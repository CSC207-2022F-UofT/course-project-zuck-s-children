//import UI
import AccountCreation.Account;
import UI.LoginUI;
import data.persistency.UserDatabase;
import matching.MatchingAlgorithm;

import javax.swing.*;
import java.io.*;
import java.util.HashMap;

public class StudyBuddyApp {
    public static void main(String[] args){
//        //Serializes an empty userDatabase.
//        try {
//            FileOutputStream myFileOutStream
//                    = new FileOutputStream(
//                    "/Users/tankenji/IdeaProjects/course-project-zuck-s-children/userDatabase.txt");
//
//            ObjectOutputStream myObjectOutStream
//                    = new ObjectOutputStream(myFileOutStream);
//
//            myObjectOutStream.writeObject(new UserDatabase());
//
//            // closing FileOutputStream and
//            // ObjectOutputStream
//            myObjectOutStream.close();
//            myFileOutStream.close();
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }

        HashMap<String, Account> userDatabase = null;
        // deserializing the userDatabase.txt file

        try {
            FileInputStream fin = new FileInputStream("/Users/tankenji/IdeaProjects/course-project-zuck-s-children/userDatabase.txt");
            //Creating stream to read the object
            ObjectInputStream in = new ObjectInputStream(fin);
            userDatabase = (HashMap<String, Account>)in.readObject();
            //closing the stream
            in.close();
            fin.close();
            System.out.println("successful deserialization");

            if (userDatabase == null) {
                userDatabase = new HashMap<String, Account>();
            }
            UserDatabase.setAccounts(userDatabase);
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("unsuccessful deserialization");
            if (userDatabase == null) {
                userDatabase = new HashMap<String, Account>();
            }
            UserDatabase.setAccounts(userDatabase);
        }

//        System.out.println("Deserialized UserDatabase size: " + UserDatabase.getAccounts().size());

        //initial page: user authorization
        LoginUI frame = new LoginUI();
        frame.setTitle("Login Page");
        frame.setVisible(true);
        frame.setBounds(0, 0, 1440, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        LoginUI.setFrame(frame);


        HashMap<String, Account> finalUserDatabase = userDatabase;
        LoginUI.getFrames()[0].addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(frame,
                        "Are you sure you want to close this window?", "Close Window?",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                    // serialization to userDatabase.txt file
                    try {
                        //Creating stream and writing the object
                        FileOutputStream fout = new FileOutputStream("/Users/tankenji/IdeaProjects/course-project-zuck-s-children/userDatabase.txt");
                        ObjectOutputStream out = new ObjectOutputStream(fout);

                        //check how many accounts are in the userDatabase
                        System.out.println("Serialized UserDatabase size: " + UserDatabase.getAccounts().size());

                        out.writeObject(finalUserDatabase);
                        out.flush();
                        //closing the stream
                        out.close();
                        fout.close();
                        System.out.println("successful serialization");
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    System.exit(0);
                }
            }
        });

        

    }
}
