package account_creation;

import account_and_login.LoginUI;
import account_and_login.account_creation.Account;
import account_and_login.account_creation.RegisterController;
import account_and_login.account_creation.RegisterInModel;
import account_and_login.account_creation.RegisterUseCase;
import data.persistency.UserDatabase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

class RegisterInteractorTest {

    @BeforeEach
    void setUp() {
        UserDatabase USERDATABASE = UserDatabase.getUserDatabase();
        // deserializing the userDatabase.txt file and the chatDatabase.txt file
        try {
            FileInputStream finUser = new FileInputStream("userDatabase.txt");
            //Creating stream to read the object
            ObjectInputStream inUser = new ObjectInputStream(finUser);
            HashMap<String, Account> userDatabaseAccounts = (HashMap<String, Account>) inUser.readObject();
            USERDATABASE.setAccounts(userDatabaseAccounts);
            //closing the stream
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
     * Test that a new account can be created through the RegisterController.
     */
    @Test
    void createNewAccount() {
        String registerUser = "Kenji";
        String registerPwd = "123";

        RegisterInModel registerInModel = new RegisterInModel(registerUser, registerPwd);
        RegisterUseCase registerUseCase = new RegisterUseCase(registerInModel);
        RegisterController registerController = new RegisterController(registerUseCase);
        registerController.createNewAccount(registerUser, registerPwd);

        Assertions.assertNotNull(UserDatabase.getUserDatabase().getAccounts().get("Kenji").getPassword());
        Assertions.assertEquals(UserDatabase.getUserDatabase().getAccounts().get("Kenji").getPassword(), "123");
    }

    /**
     * Test that one cannot create a new account with a username which is already registered.
     */
    @Test
    void creationParameters() {
        String registerUser1;
        String registerPwd1;
        registerUser1 = "Zuck";
        registerPwd1 = "123";

        RegisterInModel registerInModel1 = new RegisterInModel(registerUser1, registerPwd1);
        RegisterUseCase registerUseCase1 = new RegisterUseCase(registerInModel1);
        RegisterController registerController1 = new RegisterController(registerUseCase1);
        registerController1.createNewAccount(registerUser1, registerPwd1);

        String registerUser;
        String registerPwd;
        registerUser = "Zuck";
        registerPwd = "321";

        RegisterInModel registerInModel = new RegisterInModel(registerUser, registerPwd);
        RegisterUseCase registerUseCase = new RegisterUseCase(registerInModel);
        RegisterController registerController = new RegisterController(registerUseCase);
        registerController.createNewAccount(registerUser, registerPwd);

        Assertions.assertEquals(UserDatabase.getUserDatabase().getAccounts().get("Zuck").getPassword(), "123");
    }

    /**
     * Test that one cannot create an account with an empty parameter.
     */
    @Test
    void emptyParameter() {
        String registerUser2;
        String registerPwd2;
        registerUser2 = "";
        registerPwd2 = "321";

        RegisterInModel registerInModel2 = new RegisterInModel(registerUser2, registerPwd2);
        RegisterUseCase registerUseCase2 = new RegisterUseCase(registerInModel2);
        RegisterController registerController2 = new RegisterController(registerUseCase2);
        registerController2.createNewAccount(registerUser2, registerPwd2);

        String registerUser1;
        String registerPwd1;
        registerUser1 = "hi";
        registerPwd1 = "";

        RegisterInModel registerInModel1 = new RegisterInModel(registerUser1, registerPwd1);
        RegisterUseCase registerUseCase1 = new RegisterUseCase(registerInModel1);
        RegisterController registerController1 = new RegisterController(registerUseCase1);
        registerController1.createNewAccount(registerUser1, registerPwd1);

        Assertions.assertNull(UserDatabase.getUserDatabase().getAccounts().get(""));
        Assertions.assertNull(UserDatabase.getUserDatabase().getAccounts().get("hi"));
    }

    @AfterEach
    void tearDown() {
        UserDatabase.getUserDatabase().getAccounts().remove("Kenji");
        UserDatabase.getUserDatabase().getAccounts().remove("Zuck");

        try {
            FileOutputStream foutUser = new FileOutputStream("userDatabase.txt");
            ObjectOutputStream outUser = new ObjectOutputStream(foutUser);
            outUser.writeObject(UserDatabase.getUserDatabase().getAccounts());
            outUser.flush();
            outUser.close();
            foutUser.close();
            System.out.println("Successful serialization");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Unsuccessful serialization");

        }
    }
}