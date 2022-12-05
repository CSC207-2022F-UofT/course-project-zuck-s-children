package ui;

import java.awt.*;
import javax.swing.*;

import static main_app.StudyBuddyApp.*;

public class Navigation {
    // titles of tabs
    final static String PROFILE = "Profile";
    final static String NOTIFICATIONS = "Notifications";
    final static String SWIPER = "Swiper";

    final static int extraWindowWidth = 100;

    public void addComponentToPane(Container pane) {
        JTabbedPane tabbedPane = new JTabbedPane();

        tabbedPane.addTab(PROFILE, profileUI);

        Account curr = new Account("Sanzhar", "password");
        Account acc1 = new Account("huan22", "password");
        MatchNotification match1 = new MatchNotification("hello", acc1, LocalDateTime.now());
        ChatNotification chat1 = new ChatNotification("nihao", acc1, LocalDateTime.now(), "3");
        curr.addNotification(match1);
        curr.addNotification(chat1);

        UserDatabase.setCurrentUser(curr);

        notificationUI = new NotificationUI();
        showNotifPresenter = new ShowNotifPresenter(notificationUI);
        showNotifInteractor = new ShowNotifInteractor(showNotifPresenter);
        showNotifController =new ShowNotifController(showNotifInteractor);
        notificationUI.create(showNotifController);
        tabbedPane.addTab(NOTIFICATIONS, notificationUI);
        clearNotifPresenter = new ClearNotifPresenter(notificationUI);
        clearNotifInteractor = new ClearNotifInteractor(clearNotifPresenter);
        clearNotifController = new ClearNotifController(clearNotifInteractor);

//        tabbedPane.addTab(SWIPER, swiperUI);

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
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        Navigation demo = new Navigation();
        demo.addComponentToPane(frame.getContentPane());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
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