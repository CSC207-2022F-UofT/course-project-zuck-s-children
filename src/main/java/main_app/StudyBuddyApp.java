package main_app;
import account_creation.Account;
import data.persistency.ChatDataAccess;
import data.persistency.ChatDatabase;
import notification.Control.ClearNotifController;
import notification.Control.ClearNotifInputBoundary;
import notification.Control.ShowNotifController;
import notification.Control.ShowNotifInputBoundary;
import notification.Present.ClearNotifOutputBoundary;
import notification.Present.ShowNotifOutputBoundary;
import profile.*;

import ui.LoginUI;
import data.persistency.UserDatabase;
import notification.NotificationUI;

import swipe.SwiperInputBoundary;
import swipe.SwiperInteractor;
import swipe.SwiperPresenter;
import swipe.screen.SwipeScreen;
import swipe.screen.SwiperController;
import swipe.screen.SwiperPresenterFormatter;
import ui.*;
import data.persistency.UserDatabase;


import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class StudyBuddyApp {
    public static ChatDatabase chatDatabase;
    public static Profile currUserProfile = new Profile();
    public static ProfileUI profileUI;
    public static ProfilePresenter profilePresenter = new ProfilePresenter(profileUI);
    public static ProfileEditUseCase profileEditUseCase = new ProfileEditUseCase(profilePresenter);
    public static ProfileController profileController = new ProfileController(profileEditUseCase);
    public static NotificationUI notificationUI;
    public static ShowNotifOutputBoundary showNotifPresenter;
    public static ShowNotifInputBoundary showNotifInteractor;
    public static ShowNotifController showNotifController;
    public static ClearNotifOutputBoundary clearNotifPresenter;
    public static ClearNotifInputBoundary clearNotifInteractor;
    public static ClearNotifController clearNotifController;


    // Swiper Stuff
    // TODO: maybe Sanzhar to make all constructors compatible with the main program
    public static LinkedList<Account> potentialMatches;
    public static SwiperPresenter swiperPresenter = new SwiperPresenterFormatter();
    public static SwiperInputBoundary swiperInputBoundary = new SwiperInteractor(swiperPresenter);
    public static SwiperController swiperController= new SwiperController(swiperInputBoundary);
    public static SwiperUI swiperUI = new SwiperUI();

    public static ChatListUI chatListUI;

    public static void main(String[] args){
        UserDatabase USERDATABASE = UserDatabase.getUserDatabase();
        List<Object> chatData = null;

        // deserializing the userDatabase.txt file and the chatDatabase.txt file
        try {
            FileInputStream finUser = new FileInputStream("userDatabase.txt");
            FileInputStream finChat = new FileInputStream("chatDatabase.txt");
            //Creating stream to read the object

            ObjectInputStream inUser = new ObjectInputStream(finUser);
            ObjectInputStream inChat = new ObjectInputStream(finChat);
            HashMap<String, Account> userDatabaseAccounts = (HashMap<String, Account>) inUser.readObject();
            USERDATABASE.setAccounts(userDatabaseAccounts);
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

            USERDATABASE = UserDatabase.getUserDatabase();
            USERDATABASE.setAccounts(new HashMap<String, Account>());

            chatData = new ArrayList<>();
        }
        ChatDataAccess chatDataAccess = new ChatDataAccess();
        chatDatabase = new ChatDatabase(chatData);
        ChatDataAccess.setChatdata(chatDatabase);
        chatListUI = new ChatListUI();
        chatListUI.build();

        //initial page: user authorization
        LoginUI frame = new LoginUI();
        frame.setTitle("Login Page");
        frame.setVisible(true);
        frame.setBounds(0, 0, 1440, 1000);
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frame.setResizable(false);
        LoginUI.setFrame(frame);

        HashMap<String, Account> finalUserDatabaseAccounts = USERDATABASE.getAccounts();
        List<Object> finalChatDatabase = chatDataAccess.getChatData().getChatList();

        frame.addWindowListener(new java.awt.event.WindowAdapter() {
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
                        outUser.writeObject(finalUserDatabaseAccounts);
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
                        System.out.println("Unsuccessful serialization");

                    }
                    System.exit(0);
                }
            }
        });

    }
}
