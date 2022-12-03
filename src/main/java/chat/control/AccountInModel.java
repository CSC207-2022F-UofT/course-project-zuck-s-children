package chat.control;

import account_creation.Account;

public class AccountInModel {
    private Account acc;

    /**
     * Construct an account model
     * @param acc
     */
    public AccountInModel(Account acc){
        this.acc = acc;
    }

    /**
     * Return the Account that this model represents
     * @return
     */
    public Account getAccount(){
        return this.acc;
    }
}
