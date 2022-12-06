package ui;

import account_creation.Account;
import chat.entities.ChatRoomEnt;
import data.persistency.ChatDataAccess;
import data.persistency.ChatDataAccessInterface;
import data.persistency.ChatDatabase;
import data.persistency.UserDatabase;
import notification.Control.ClearNotifController;
import notification.Control.ShowNotifController;
import notification.Entities.ChatNotification;
import notification.Entities.MatchNotification;
import notification.NotificationUI;
import notification.Present.ClearNotifPresenter;
import notification.Present.ShowNotifPresenter;
import notification.UseCases.ClearNotifInteractor;
import notification.UseCases.ShowNotifInteractor;
import profile.Profile;
import matching.MatchingAlgorithm;
import profile.ProfileUI;


import java.awt.*;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import javax.swing.*;

import static main_app.StudyBuddyApp.*;

public class Navigation {
    // titles of tabs
    final static ChatDataAccessInterface chatDataAccess = new ChatDataAccess();
    final static String PROFILE = "Profile";
    final static String NOTIFICATIONS = "Notifications";
    final static String CHAT = "Chat List";
    final static String SWIPER = "Swiper";

    final static int extraWindowWidth = 100;

    public void addComponentToPane(Container pane) {
        JTabbedPane tabbedPane = new JTabbedPane();
        Account acc1 = new Account("huan22", "password");
        MatchNotification match1 = new MatchNotification("hello", acc1, LocalDateTime.now());
        ChatNotification chat1 = new ChatNotification("nihao", acc1, LocalDateTime.now(), "3");

        tabbedPane.addTab(SWIPER, swiperUI);
        Profile prof2 = new Profile();
        prof2.setName("lol");
        prof2.setYear("jjj");
        prof2.setFieldOfStudy("ddd");
        ArrayList<String> styles1 = new ArrayList<>(Arrays.asList("hoho", "haha"));
        prof2.setStudyStyles(styles1);
        ArrayList<String> studySpotPref2 = new ArrayList<>(Arrays.asList("sdfa", "f"));
        prof2.setStudySpotPreferences(studySpotPref2);
        Profile prof1 = new Profile();
        prof1.setName("aaa");
        prof1.setPronouns("bbb");
        prof1.setYear("");
        prof1.setFieldOfStudy("ddd");
        prof1.setStudyStyles(styles1);
        ArrayList<String> studySpotPref1 = new ArrayList<>(Arrays.asList("www", "f"));
        prof1.setStudySpotPreferences(studySpotPref1);
        Account sanzhar = new Account("Sanzhar", "password");
        sanzhar.setProfile(prof2);
        Account potential = new Account("Potential", "pass");
        potential.setProfile(prof2);
        Account second = new Account("Potential2", "pass3232");
        second.setProfile(prof1);


        LinkedList<Account> stuff = new LinkedList<>();
        stuff.add(potential);
        stuff.add(second);
        stuff.add(sanzhar);
        sanzhar.addNotification(match1);
        sanzhar.addNotification(chat1);
        UserDatabase.getAccounts().put(potential.getUsername(), potential);
        UserDatabase.getAccounts().put(second.getUsername(), second);
        UserDatabase.getAccounts().put(sanzhar.getUsername(), sanzhar);

        profileUI = new ProfileUI();
        tabbedPane.addTab(PROFILE, profileUI);

        notificationUI = new NotificationUI();
        showNotifPresenter = new ShowNotifPresenter(notificationUI);
        showNotifInteractor = new ShowNotifInteractor(showNotifPresenter);
        showNotifController =new ShowNotifController(showNotifInteractor);
        notificationUI.create(showNotifController);
        tabbedPane.addTab(NOTIFICATIONS, notificationUI);
        clearNotifPresenter = new ClearNotifPresenter(notificationUI);
        clearNotifInteractor = new ClearNotifInteractor(clearNotifPresenter);
        clearNotifController = new ClearNotifController(clearNotifInteractor);

        chatListUI.build();
        tabbedPane.addTab(CHAT, chatListUI);

        swiperUI.setBounds(0, 0, 1440, 1000);
        swiperUI.build(stuff, swiperController);


        pane.add(tabbedPane, BorderLayout.CENTER);

    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    public static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Study Buddy Finder");
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        //Create and set up the content pane.
        Navigation demo = new Navigation();
        demo.addComponentToPane(frame.getContentPane());
        serializeOnWindowClose(frame);
        //Display the window.
        frame.pack();
        frame.setVisible(true);

    }
    public static void serializeOnWindowClose(JFrame frame){
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                try {
                    FileOutputStream foutUser = new FileOutputStream("userDatabase.txt");
                    FileOutputStream foutChat = new FileOutputStream("chatDatabase.txt");
                    ObjectOutputStream outUser = new ObjectOutputStream(foutUser);
                    ObjectOutputStream outChat = new ObjectOutputStream(foutChat);
                    outUser.writeObject(UserDatabase.getAccounts());
                    outChat.writeObject(chatDataAccess.getChatData().getChatList());
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
        });
    }

    public static void main(String[] args) {
        /* Use an appropriate Look and Feel */
        try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);

        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
