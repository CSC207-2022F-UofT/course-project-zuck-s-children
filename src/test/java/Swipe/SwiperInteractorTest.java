package swipe;

import account_creation.Account;
import swipe.screen.SwiperPresenterFormatter;
import data_persistency.UserDatabase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SwiperInteractorTest {
    SwiperPresenter testPresenter;
    SwiperInputBoundary testInteractor;
    Account curr;
    Account potential;
    SwiperRequestModel testRequest;



    @BeforeEach
    void setUp() {
        SwiperPresenter testPresenter = new SwiperPresenterFormatter();
        SwiperInputBoundary testInteractor = new SwiperInteractor(testPresenter);
        Account curr = new Account("Sanzhar", "password");
        Account potential = new Account("Potential", "pass");
        UserDatabase.setCurrentUser(curr);
        SwiperRequestModel testRequest = new SwiperRequestModel(true, potential);




    }


    @Test
    void create() {
        SwiperPresenter testPresenter = new SwiperPresenterFormatter();
        SwiperInputBoundary testInteractor = new SwiperInteractor(testPresenter);
        Account curr = new Account("Sanzhar", "password");
        Account potential = new Account("Potential", "pass");
        UserDatabase.setCurrentUser(curr);
        SwiperRequestModel testRequest = new SwiperRequestModel(true, potential);
        SwiperResponseModel result = testInteractor.create(testRequest);
        assertTrue(curr.getMatches().contains(potential));
        assertFalse(potential.getMatches().contains(curr));
        assertEquals("N", result.getAccepted());
        UserDatabase.setCurrentUser(potential);
        SwiperRequestModel testRequest2 = new SwiperRequestModel(true, curr);
        SwiperResponseModel result2 = testInteractor.create(testRequest2);
        assertEquals("Y", result2.getAccepted());
        assertTrue(curr.getMatches().contains(potential));
        assertTrue(potential.getMatches().contains(curr));

    }
    @AfterEach
    void tearDown() {
    }
}