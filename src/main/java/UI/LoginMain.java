package UI;

import javax.swing.*;

public class LoginMain {
    //Running the loginUI page. Note: This will go into the StudyBuddyApp as the opening page.
    public static void main(String[] a) {
        LoginUI frame = new LoginUI();
        frame.setTitle("Login Page");
        frame.setVisible(true);
        frame.setBounds(0, 0, 1440, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

    }

}
