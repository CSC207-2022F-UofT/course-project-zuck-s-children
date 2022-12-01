import AccountCreation.Account;
import data.persistency.UserDatabase;
import profile.Profile;
import swipe.SwiperInputBoundary;
import swipe.SwiperInteractor;
import swipe.SwiperPresenter;
import swipe.screen.EmptyScreen;
import swipe.screen.SwipeScreen;
import swipe.screen.SwiperController;
import swipe.screen.SwiperPresenterFormatter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class swiperMain {
    static UserDatabase userDatabase = new UserDatabase();

    public static void main(String[] args){
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
        SwiperPresenter testPresenter = new SwiperPresenterFormatter();
        SwiperInputBoundary testInteractor = new SwiperInteractor(testPresenter);
        Account curr = new Account("Sanzhar", "password");
        curr.setProfile(prof1);

        Account potential = new Account("Potential", "pass");
        potential.setProfile(prof2);
        Account second = new Account("Potential2", "pass3232");
        second.setProfile(prof1);

        UserDatabase.setCurrentUser(curr);
        SwiperController testController = new SwiperController(testInteractor);
        LinkedList<Account> stuff = new LinkedList<>();
        if (stuff.isEmpty()){
            EmptyScreen em = new EmptyScreen();
            JFrame swiper = new JFrame("Nobody Likes u lmao");
            CardLayout cardLayout = new CardLayout();
            JPanel screens = new JPanel(cardLayout);
            swiper.add(screens);
            screens.add(em, "welcome");
            cardLayout.show(screens, "swipe");
            swiper.pack();

            swiper.setBounds(0, 0, 1440, 1000);
            swiper.setResizable(false);
            swiper.setVisible(true);


        }
        stuff.add(potential);
        stuff.add(second);
        UserDatabase.getAccounts().put(potential.getUsername(), potential);
        UserDatabase.getAccounts().put(second.getUsername(), second);
        for (Account a: stuff){
            SwipeScreen swipeScreen = new SwipeScreen(testController, a);
            JFrame swiper = new JFrame("Time to swipe");
            CardLayout cardLayout = new CardLayout();
            JPanel screens = new JPanel(cardLayout);
            swiper.add(screens);
            screens.add(swipeScreen, "welcome");
            cardLayout.show(screens, "swipe");
            swiper.pack();

            swiper.setBounds(0, 0, 1440, 1000);
            swiper.setResizable(false);
            swiper.setVisible(true);
            while (!swipeScreen.getPressed()){
                int i = 1;
                i ++;
            }
            swiper.setVisible(false);
        }

    }}
