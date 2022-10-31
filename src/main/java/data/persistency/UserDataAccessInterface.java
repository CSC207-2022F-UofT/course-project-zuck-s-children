package data.persistency;

public interface UserDataAccessInterface {
    void save();
    ArrayList<Account> load();
}
