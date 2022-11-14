package AccountCreationLogin;

import DataPersistency.DataAccess;

import java.util.ArrayList;
import java.util.List;

public class RegisterUseCase {

    private static final String inputUsername = RegisterInBoundary.getInputUsernameBoundary();
    private static final String inputPassword = RegisterInBoundary.getInputPasswordBoundary();

    public static boolean createNewAccount() {
        if (checkDuplicateUsername(inputUsername)) {
            // must raise exception or error and send message up to view
            return false;
        } else {
            // add NewAccount entity into UserDatabase
            NewAccount newAccount = new NewAccount(inputUsername, inputPassword);

            List<Object> databaseValue = new ArrayList<>();
            databaseValue.add(inputPassword);
            databaseValue.add(newAccount.getProfile());
            databaseValue.add(newAccount.getMatches());
            UserDatabase.put(newAccount.getUsername(), databaseValue);

            return true;
        }
    }

    public static boolean checkDuplicateUsername(String inputUsername) {
        return DataAccess.duplicateUsername(inputUsername);
    }


}
