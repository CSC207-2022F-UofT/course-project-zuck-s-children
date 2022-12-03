package profile;

import UI.ProfileUI;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProfileEditUseCaseTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void modifyProfile() {
        ProfileUI profileUI = new ProfileUI();
        ProfilePresenter profilePresenter = new ProfilePresenter(profileUI);
//        ProfileEditUseCase profileEditUseCase = new ProfileEditUseCase(profilePresenter);

    }
}