package Swipe;

import AccountCreation.Account;
import Swipe.Screen.SwiperPresenterFormatter;
import Swipe.SwiperInteractor;
import Swipe.SwiperPresenter;
import data.persistency.UserDatabase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class SwiperInteractorTest {

    @BeforeEach
    void setUp() {

    }


    @Test
    void create() {
        SwiperPresenter testPresenter = new SwiperPresenterFormatter();
        SwiperInteractor testInteractor = new SwiperInteractor(testPresenter);
        Account curr = new Account("Sanzhar", "password");
        Account potential = new Account("Potential", "pass");
        UserDatabase.setCurrentUser(curr);
        SwiperRequestModel testRequest = new SwiperRequestModel(true, potential);
        testInteractor.create(testRequest);
        assertFalse(curr.getMatches().contains(potential));
        assertFalse(potential.getMatches().contains(curr));
        UserDatabase.setCurrentUser(potential);
        SwiperRequestModel testRequest2 = new SwiperRequestModel(true, curr);
        testInteractor.create(testRequest2);
        assertTrue(curr.getMatches().contains(potential));
        assertTrue(potential.getMatches().contains(curr));

    }
    @AfterEach
    void tearDown() {
    }
}