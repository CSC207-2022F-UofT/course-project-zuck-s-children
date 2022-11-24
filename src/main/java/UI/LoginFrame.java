package UI;

import AccountCreation.RegisterController;
import AccountCreation.RegisterInBoundary;
import AccountCreation.RegisterPresenter;
import AccountLogin.LoginController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame implements ActionListener {
    //Each UI component:
    Container container = getContentPane();
    //login stuff
    JLabel loginLabel = new JLabel("LOGIN");
    JLabel userLabel = new JLabel("Username");
    JLabel passwordLabel = new JLabel("Password");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JCheckBox showPassword = new JCheckBox("Show Password");
    //register account stuff
    JLabel registerLabel = new JLabel("CREATE NEW ACCOUNT");
    JLabel userLabel2 = new JLabel("Username");
    JLabel passwordLabel2 = new JLabel("Password");
    JTextField registerUsername = new JTextField();
    JPasswordField registerPassword = new JPasswordField();
    JButton registerButton = new JButton("Sign Up");

    LoginFrame() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();

    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        loginLabel.setBounds(700, 170, 70, 20);
        userLabel.setBounds(690, 200, 70, 20);
        passwordLabel.setBounds(690, 250, 70, 20);
        userTextField.setBounds(630, 220, 193, 28);
        passwordField.setBounds(630, 270, 193, 28);
        showPassword.setBounds(630, 300, 150, 30);
        loginButton.setBounds(628, 330, 100, 30);
        resetButton.setBounds(728, 330, 100, 30);

        registerLabel.setBounds(650, 400, 200, 20);
        userLabel2.setBounds(690, 430, 70, 20);
        registerUsername.setBounds(630, 450, 193, 28);
        passwordLabel2.setBounds(690, 480, 70, 20);
        registerPassword.setBounds(630, 500, 193, 28);
        registerButton.setBounds(627, 530, 200, 25);
    }

    public void addComponentsToContainer() {
        container.add(loginLabel);
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);

        container.add(registerLabel);
        container.add(userLabel2);
        container.add(passwordLabel2);
        container.add(registerUsername);
        container.add(registerPassword);
        container.add(registerButton);
    }

    public void addActionEvent() {
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
        registerButton.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //Coding Part of loginButton
        if (e.getSource() == loginButton) {
            String userText;
            String pwdText;
            userText = userTextField.getText();
            pwdText = passwordField.getText();
            if (userText.equalsIgnoreCase("mehtab") && pwdText.equalsIgnoreCase("12345")) {
                JOptionPane.showMessageDialog(this, "Login Successful");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            }

        }
        //Coding Part of resetButton
        if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("");
        }
        //Coding Part of showPassword JCheckBox
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }
        //Coding Part of registerButton
        if (e.getSource() == registerButton) {
            RegisterInBoundary registerBoundary = null;
            RegisterController registerController = new RegisterController(RegisterInBoundary registerBoundary);
            registerController.createNewAccount(registerUsername.getText(), registerPassword.getText());
            RegisterPresenter.alertUser
        }
        }
    }

}

