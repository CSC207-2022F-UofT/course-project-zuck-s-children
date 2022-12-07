package swipe.screen;

import account_creation.Account;
import data.persistency.UserDatabase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import profile.Profile;
import swipe.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

class SwipeScreenTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void actionPerformed() {
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

        UserDatabase.getUserDatabase().setCurrentUser(curr);
        SwiperController testController = new SwiperController(testInteractor);
        SwipeScreen swipeScreen = new SwipeScreen(testController, potential);
        JFrame swiper = new JFrame("Time to swipe");
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        swiper.add(screens);
        screens.add(swipeScreen, "welcome");
        cardLayout.show(screens, "swipe");
        swiper.pack();

        swiper.setBounds(0, 0, 1440, 1000);
        swiper.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        swiper.setResizable(false);
        swiper.setVisible(true);
    }
}