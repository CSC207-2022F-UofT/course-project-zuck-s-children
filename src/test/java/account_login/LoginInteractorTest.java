package account_login;

import account_and_login.account_creation.Account;
import account_and_login.account_login.LoginController;
import account_and_login.account_login.LoginInModel;
import account_and_login.account_login.LoginUseCase;
import data.persistency.UserDatabase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.HashMap;

class LoginInteractorTest {

    @BeforeEach
    void setUp() {
        UserDatabase USERDATABASE = UserDatabase.getUserDatabase();
        try {
            FileInputStream finUser = new FileInputStream("userDatabase.txt");
            ObjectInputStream inUser = new ObjectInputStream(finUser);
            HashMap<String, Account> userDatabaseAccounts = (HashMap<String, Account>) inUser.readObject();
            USERDATABASE.setAccounts(userDatabaseAccounts);
            inUser.close();
            finUser.close();
            System.out.println("Successful deserialization");

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Unsuccessful deserialization");
            USERDATABASE = UserDatabase.getUserDatabase();
            USERDATABASE.setAccounts(new HashMap<String, Account>());
        }
    }

    /**
     * Test that correct username and password inputs result in successful login, setting the current user.
     */
    @Test
    void correctInputs() {
        Account newAccount = new Account("User1", "Pass1");
        UserDatabase.getUserDatabase().getAccounts().put("User1", newAccount);

        String loginUser = "User1";
        String loginPwd = "Pass1";

        LoginInModel loginInModel = new LoginInModel(loginUser, loginPwd);
        LoginUseCase loginUseCase = new LoginUseCase(loginInModel);
        LoginController loginController = new LoginController(loginUseCase);
        loginController.loginToAccount(loginUser, loginPwd);

        Assertions.assertEquals(UserDatabase.getUserDatabase().getCurrentUser(), newAccount);
    }

    /**
     * Test that an incorrect password but correct username results in unsuccessful login, i.e. current account is not
     * the account attempted to logging into.
     */
    @Test
    void incorrectPassword() {
        Account newAccount = new Account("User1", "Pass1");
        UserDatabase.getUserDatabase().getAccounts().put("User1", newAccount);

        String loginUser = "User1";
        String loginPwd = "Pass2";

        LoginInModel loginInModel = new LoginInModel(loginUser, loginPwd);
        LoginUseCase loginUseCase = new LoginUseCase(loginInModel);
        LoginController loginController = new LoginController(loginUseCase);
        loginController.loginToAccount(loginUser, loginPwd);

        Assertions.assertNotEquals(UserDatabase.getUserDatabase().getCurrentUser(), newAccount);
    }

    /**
     * Test that an unregistered username results in unsuccessful login, i.e. current account is not the account
     * attempted to logging into.
     */
    @Test
    void unregisteredUsername() {
        Account newAccount = new Account("User1", "Pass1");
        UserDatabase.getUserDatabase().getAccounts().put("User1", newAccount);

        String loginUser = "User2";
        String loginPwd = "Pass1";

        LoginInModel loginInModel = new LoginInModel(loginUser, loginPwd);
        LoginUseCase loginUseCase = new LoginUseCase(loginInModel);
        LoginController loginController = new LoginController(loginUseCase);
        loginController.loginToAccount(loginUser, loginPwd);

        Assertions.assertNotEquals(UserDatabase.getUserDatabase().getCurrentUser(), newAccount);
    }

    @AfterEach
    void tearDown() {
    }
}
