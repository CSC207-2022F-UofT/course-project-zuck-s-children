package spots.use_cases;

import AccountCreation.Account;

public interface RecsInBoundary {

    /**
     * Method can be over-ridden
     *
     * @param user1 user in a chat room
     * @param user2 user in a chat room
     */
    void createRecs(Account user1, Account user2);
}
