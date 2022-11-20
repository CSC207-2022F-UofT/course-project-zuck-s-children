package chat.control;

import AccountCreation.Account;

public class AccountInModel {
    private Account acc;

    public AccountInModel(Account acc){
        this.acc = acc;
    }

    public Account getAccount(){
        return this.acc;
    }
}
