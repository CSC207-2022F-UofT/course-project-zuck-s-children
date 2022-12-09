package spots.use_cases;

import account_and_login.account_creation.Account;

public interface RecsInBoundary {

    /**
     * Method can be over-ridden
     *
     * @param user1 user in a chat room
     * @param user2 user in a chat room
     */
    void createRecs(Account user1, Account user2);
}
