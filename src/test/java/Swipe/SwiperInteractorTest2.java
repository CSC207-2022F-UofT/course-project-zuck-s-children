package Swipe;

import AccountCreation.Account;
import Swipe.Screen.SwiperPresenterFormatter;
import data.persistency.UserDatabase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SwiperInteractorTest2 {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void create() {
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
}