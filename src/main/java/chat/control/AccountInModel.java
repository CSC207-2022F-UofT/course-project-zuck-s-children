package chat.control;

import account_and_login.account_creation.Account;

public class AccountInModel {
    private final Account acc;

    /**
     * Construct an account model
     * @param acc account model
     */
    public AccountInModel(Account acc){
        this.acc = acc;
    }

    /**
     * Return the Account that this model represents
     * @return the account
     */
    public Account getAccount(){
        return this.acc;
    }
}