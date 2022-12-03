package ui.profile;

import javax.swing.*;

public class ProfileMain {
    public static void main(String[] a) {
        ProfileUI frame = new ProfileUI();
        frame.setTitle("Login Page");
        frame.setVisible(true);
        frame.setBounds(0, 0, 1440, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
}}
