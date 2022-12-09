package account_creation;

import ui.LoginUI;
import data.persistency.UserDatabase;

import java.util.HashMap;
import java.util.Objects;

public class RegisterUseCase implements RegisterInBoundary {
    private RegisterInModel registerInModel;
    private RegisterOutBoundary registerPresenter;
    private static HashMap<String, Account> userDatabaseAccounts;

    /**
     * Construct a register use case interactor to undergo the process of registration.
     *
     * @param registerInModel with the information on registration details.
     */
    public RegisterUseCase (RegisterInModel registerInModel) {
        this.registerInModel = registerInModel;
        LoginUI loginUI = new LoginUI();
        this.registerPresenter = new RegisterPresenter(loginUI);
        userDatabaseAccounts = UserDatabase.getUserDatabase().getAccounts();
    }

    /**
     * Create a new account given the details in the registerInModel. Ensuring it is valid by checking for duplicate
     * usernames or empty parameters.
     *
     * @param registerInModel with the information on registration details.
     */
    @Override
    public void createNewAccount(RegisterInModel registerInModel) {
        String registerUser = registerInModel.getInputUsername();
        String registerPwd = registerInModel.getInputPassword();

        if (checkDuplicateUsername(registerUser) || checkEmptyParameter(registerUser, registerPwd)) {
            // must raise exception or error and send message up to view
            int numberOfAccounts = userDatabaseAccounts.size();
            System.out.println(numberOfAccounts);
            RegisterOutModel responseModel = new RegisterOutModel(false);
            registerPresenter.alertUser(responseModel);
        } else {
            // add NewAccount entity into UserDatabase
            Account newAccount = new Account(registerUser,
                    registerPwd);

            userDatabaseAccounts.put(registerUser, newAccount);

            int numberOfAccounts = userDatabaseAccounts.size();
            System.out.println(numberOfAccounts);

            RegisterOutModel responseModel = new RegisterOutModel(true);
            registerPresenter.alertUser(responseModel);
        }
    }

    private static boolean checkDuplicateUsername(String inputUsername) {
        return userDatabaseAccounts.containsKey(inputUsername);
    }

    private static boolean checkEmptyParameter(String inputUsername, String inputPassword) {
        return Objects.equals(inputUsername, "") || Objects.equals(inputPassword, "");
    }
}
