package LoginUI;

//import AccountCreation.RegisterController;
//import AccountLogin.LoginController;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.Objects;
//
//public class LoginPage implements ActionListener{
//
//
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//
//    }
//}

import javax.swing.*;
class gui{
    public static void main(String args[]){
        JFrame frame = new JFrame("My First GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        JButton button = new JButton("Press");
        frame.getContentPane().add(button); // Adds Button to content pane of frame
        frame.setVisible(true);
    }
}
