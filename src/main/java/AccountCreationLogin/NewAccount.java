package AccountCreationLogin;

import java.awt.*;
import java.sql.Array;
import java.util.ArrayList;

public class NewAccount {
    private String username;
    private String password;
    private Profile profile;
    private List<Profile> matches;

    public NewAccount(String username, String password) {
        this.username = username;
        this.password = password;
        this.profile = new Profile;
        this.matches = new ArrayList<Profile>();
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public Profile getProfile() {
        return this.profile;
    }

    public List<Profile> getMatches() {
        return this.matches;
    }

    public void addMatch() {
        this.matches.add(Profile);
    }
}
