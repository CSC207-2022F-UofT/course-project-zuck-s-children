package chat.control;

import AccountCreation.Account;

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
