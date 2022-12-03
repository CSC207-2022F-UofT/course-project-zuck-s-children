//import UI
import AccountCreation.Account;
import UI.LoginUI;
import chat.entities.ChatRoomEnt;
import data.persistency.ChatDataAccess;
import data.persistency.ChatDatabase;
import data.persistency.UserDatabase;

//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StudyBuddyApp {
    static UserDatabase userDatabase;
    static ChatDatabase chatDatabase;
    public static void main(String[] args){

        HashMap<String, Account> userDatabase = null;
        List<Object> chatData = null;

        // deserializing the userDatabase.txt file and the chatDatabase.txt file
        try {
            FileInputStream finUser = new FileInputStream("userDatabase.txt");
            FileInputStream finChat = new FileInputStream("chatDatabase.txt");
            //Creating stream to read the object
            ObjectInputStream inUser = new ObjectInputStream(finUser);
            ObjectInputStream inChat = new ObjectInputStream(finChat);
            userDatabase = (HashMap<String, Account>)inUser.readObject();
            chatData = (List<Object>)inChat.readObject();
            //closing the stream
            inUser.close();
            inChat.close();
            finUser.close();
            finChat.close();
            System.out.println("successful deserialization");

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("unsuccessful deserialization");

        }
        if (userDatabase == null) {
            userDatabase = new HashMap<String, Account>();
        }
        if(chatData == null){
            chatDatabase = new ChatDatabase(new ArrayList<>());
        }
        else{
            chatDatabase = new ChatDatabase(chatData);
        }
        UserDatabase.setAccounts(userDatabase);
        ChatDataAccess chatDataAccess = new ChatDataAccess();
        ChatDataAccess.setChatdata(chatDatabase);

        //initial page: user authorization
        LoginUI frame = new LoginUI();
        frame.setTitle("Login Page");
        frame.setVisible(true);
        frame.setBounds(0, 0, 1440, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        LoginUI.setFrame(frame);


        HashMap<String, Account> finalUserDatabase = userDatabase;
        ChatDatabase finalChatDatabase = chatDataAccess.getChatData();
        LoginUI.getFrames()[0].addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(frame,
                        "Are you sure you want to close this window?", "Close Window?",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                    try {
                        FileOutputStream foutUser = new FileOutputStream("userDatabase.txt");
                        FileOutputStream foutChat = new FileOutputStream("chatDatabase.txt");
                        ObjectOutputStream outUser = new ObjectOutputStream(foutUser);
                        ObjectOutputStream outChat = new ObjectOutputStream(foutChat);
                        System.out.println("Serialized UserDatabase size: " + UserDatabase.getAccounts().size());
                        outUser.writeObject(finalUserDatabase);
                        outChat.writeObject(finalChatDatabase);
                        outChat.flush();
                        outUser.flush();
                        outChat.close();
                        outUser.close();
                        foutChat.close();
                        foutUser.close();
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
