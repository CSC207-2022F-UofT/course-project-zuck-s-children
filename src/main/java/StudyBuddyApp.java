import account_creation.Account;
import ui.LoginUI;
import data.persistency.UserDatabase;

import javax.swing.*;
import java.io.*;
import java.util.HashMap;

public class StudyBuddyApp {

    public static void main(String[] args){
        UserDatabase USERDATABASE = UserDatabase.getUserDatabase();
        // deserializing the userDatabase.txt file
        try {
            FileInputStream fin = new FileInputStream("/Users/tankenji/IdeaProjects/course-project-zuck-s-children/userDatabase.txt");
            //Creating stream to read the object
            ObjectInputStream in = new ObjectInputStream(fin);
            HashMap<String, Account> userDatabaseAccounts = (HashMap<String, Account>) in.readObject();

            USERDATABASE.setAccounts(userDatabaseAccounts);


            //closing the stream
            in.close();
            fin.close();

            System.out.println("successful deserialization");
            System.out.println("Deserialized UserDatabase size: " + USERDATABASE.getAccounts().size());
            System.out.println(USERDATABASE.getAccounts().get("1"));

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("unsuccessful deserialization");
            USERDATABASE = UserDatabase.getUserDatabase();
            USERDATABASE.setAccounts(new HashMap<String, Account>());
        }

        //initial page: user authorization
        LoginUI frame = new LoginUI();
        frame.setTitle("Login Page");
        frame.setVisible(true);
        frame.setBounds(0, 0, 1440, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        LoginUI.setFrame(frame);


        HashMap<String, Account> finalUserDatabaseAccounts = USERDATABASE.getAccounts();
        LoginUI.getFrames()[0].addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(frame,
                        "Are you sure you want to close this window?", "Close Window?",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                    try {
                        FileOutputStream fout = new FileOutputStream("/Users/tankenji/IdeaProjects/course-project-zuck-s-children/userDatabase.txt");
                        ObjectOutputStream out = new ObjectOutputStream(fout);
                        System.out.println("Serialized UserDatabase size: " + finalUserDatabaseAccounts.size());
                        out.writeObject(finalUserDatabaseAccounts);
                        out.flush();
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
