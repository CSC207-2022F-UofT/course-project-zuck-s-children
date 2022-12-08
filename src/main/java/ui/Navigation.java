package ui;

import account_creation.Account;
import chat.entities.ChatRoomEnt;
import data_persistency.ChatDataAccess;
import data_persistency.ChatDataAccessInterface;
import data_persistency.UserDatabase;
import notification.Control.ClearNotifController;
import notification.Control.ShowNotifController;
import notification.Present.ClearNotifPresenter;
import notification.Present.ShowNotifPresenter;
import notification.UseCases.ClearNotifInteractor;
import notification.UseCases.ShowNotifInteractor;
import matching.MatchingAlgorithm;


import java.awt.*;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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

        notificationUI = new NotificationUI();
        showNotifPresenter = new ShowNotifPresenter(notificationUI);
        showNotifInteractor = new ShowNotifInteractor(showNotifPresenter);
        showNotifController =new ShowNotifController(showNotifInteractor);
        notificationUI.create(showNotifController);
        clearNotifPresenter = new ClearNotifPresenter(notificationUI);
        clearNotifInteractor = new ClearNotifInteractor(clearNotifPresenter);
        clearNotifController = new ClearNotifController(clearNotifInteractor);

        LinkedList<Account> potential = MatchingAlgorithm.finalMatches();
        if (potential == null || potential.size() == 0){
            swiperUI.build();
        }else{
            swiperUI.setBounds(0, 0, 1440, 1000);
            swiperUI.build(potential, swiperController);
        }
        swiperUI.setBounds(0, 0, 1440, 1000);
        chatListUI.build();
        tabbedPane.addTab(PROFILE, profileUI);
        tabbedPane.addTab(SWIPER, swiperUI);
        tabbedPane.addTab(CHAT, chatListUI);
        tabbedPane.addTab(NOTIFICATIONS, notificationUI);

        ChangeListener changeListener = new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JTabbedPane sourceTabbedPane = (JTabbedPane) e.getSource();
                int index = sourceTabbedPane.getSelectedIndex();
                if(index == 2){
                    chatListUI.update();
                } else if (index == 3) {
                    showNotifController.refresh();
                }
            }
        };
        tabbedPane.addChangeListener(changeListener);
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
                    outUser.writeObject(UserDatabase.getUserDatabase().getAccounts());
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
