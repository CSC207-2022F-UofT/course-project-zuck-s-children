package AccountCreation;

import AccountLogin.NewAccount;
import DataPersistency.DataAccess;

import java.util.ArrayList;
import java.util.List;

public class RegisterUseCase implements RegisterInBoundary {

    private RegisterOutBoundary registerPresenter;
    @Override
    public boolean createNewAccount(RegisterInModel registerModel) {
        if (checkDuplicateUsername(registerModel.getInputUsername())) {
            // must raise exception or error and send message up to view
            RegisterOutModel responseModel = new RegisterOutModel(false);
            registerPresenter.alertUser(responseModel);
            return false;
        } else {
            // add NewAccount entity into UserDatabase
            Account newAccount = new Account(registerModel.getInputUsername(),
                    registerModel.getInputPassword());

            List<Object> databaseValue = new ArrayList<>();
            databaseValue.add(registerModel.getInputPassword());
            databaseValue.add(newAccount.getProfile());
            databaseValue.add(newAccount.getMatches());

            UserDatabase.put(registerModel.getInputUsername(), databaseValue);

            RegisterOutModel responseModel = new RegisterOutModel(true);
            registerPresenter.alertUser(responseModel);

            return true;
        }
    }

    public static boolean checkDuplicateUsername(String inputUsername) {
        return DataAccess.duplicateUsername(inputUsername);
    }


}
