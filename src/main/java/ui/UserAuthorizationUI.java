package ui;

import javax.swing.*;
import java.awt.*;

public class UserAuthorizationUI { // Implements ActionListener
    JFrame jframe;

    public JFrame getJframe(){
        return jframe;
    }

    public void createDialogBox(String boxTitle, int width, int height) {
        jframe = new JFrame("Nimbus Look and Feel");
        Color c = new Color(240, 240, 240);
        // Setting background color for JFrame
        jframe.getContentPane().setBackground(c);
        jframe.setLayout(null);
        jframe.setTitle(boxTitle);
        jframe.setSize(width, height);
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
