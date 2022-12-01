//import UI
import AccountCreation.Account;
import UI.LoginUI;
import data.persistency.UserDatabase;

import javax.swing.*;
import java.io.*;
import java.util.HashMap;

public class StudyBuddyApp {
    public static void main(String[] args){

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
        LoginUI loginUI = new LoginUI();
        loginUI.build();


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
