package profile;

import data.persistency.UserDataAccessInterface;

import java.util.ArrayList;
import java.util.List;

public class ProfileEditUseCase implements ProfileEditInputBoundary {
    private static final ProfileFactory FACTORY = new ProfileFactory();
    private static UserDataAccessInterface userDataAccess;
    private ProfileUpdateOutputBoundary profilePresenter;
    public ProfileEditUseCase(ProfileUpdateOutputBoundary profilePresenter) {this.profilePresenter = profilePresenter;}

    @Override
    public void modifyProfile(ProfileInModel profile) {
        Profile modifiedProfile = FACTORY.create(profile);
        ArrayList<String> listOfValidInputCheckMsgs = new ArrayList<String>();

        // check if the user input no more than 3 study styles for themselves
        if (!modifiedProfile.validStudyStyleInput()) {listOfValidInputCheckMsgs.add("You can select up to 3 study styles for yourself.");}

        // check if the user input no more than 3 fields of study for their preferred study buddy
        if (!modifiedProfile.validSBStudyFieldsInput()) {listOfValidInputCheckMsgs.add("You can select up to 3 fields of study for your preferred study buddy to be in.");}

        // check if the user input no more than 3 study styles for their preferred study buddy
        if (!modifiedProfile.validSBStudyStyleInput()) {listOfValidInputCheckMsgs.add("You can select up to 3 study styles for your preferred study buddy.");}

        ProfileOutModel profileModifications = new ProfileOutModel(profile, (String[]) listOfValidInputCheckMsgs.toArray());
        ProfilePresenter.showModifiedProfile(profileModifications);
    }
}
