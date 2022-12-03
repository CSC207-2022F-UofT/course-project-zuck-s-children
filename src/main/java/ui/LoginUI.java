package ui;

import account_creation.*;
import account_login.LoginController;
import account_login.LoginInModel;
import account_login.LoginUseCase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginUI extends JFrame implements ActionListener, ViewModel {

    //Each UI component:
    Container container = getContentPane();
    //login stuff
    JLabel loginLabel = new JLabel("LOGIN");
    JLabel userLabel = new JLabel("Username");
    JLabel passwordLabel = new JLabel("Password");
    JTextField loginUsername = new JTextField();
    JPasswordField loginPassword = new JPasswordField();
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

    public LoginUI() {
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
        loginUsername.setBounds(630, 220, 193, 28);
        loginPassword.setBounds(630, 270, 193, 28);
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
        container.add(loginUsername);
        container.add(loginPassword);
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

    //Frame from the main method and the closing mechanism for successful login case.
    public static LoginUI frame = null;

    public static void setFrame(LoginUI mainFrame) {
        frame = mainFrame;
    }
    public void closeLoginUI() {
        frame.dispose();
    }

    public void loginFailMechanism() {
        JOptionPane.showMessageDialog(this, "Invalid Username or Password.");
    }

    public void loginSuccessMechanism() {
        JOptionPane.showMessageDialog(this, "Login was successful!");
    }

    public void registerSuccessMechanism() {
        JOptionPane.showMessageDialog(this, "Account creation was successful.");
    }

    public void registerFailMechanism() {
        JOptionPane.showMessageDialog(this, "Account creation was unsuccessful. Please try again.");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Coding Part of loginButton
        if (e.getSource() == loginButton) {
            String loginUser;
            String loginPwd;
            loginUser = loginUsername.getText();
            loginPwd = String.valueOf(loginPassword.getPassword());

            LoginInModel loginInModel = new LoginInModel(loginUser, loginPwd);
            LoginUseCase loginUseCase = new LoginUseCase(loginInModel);
            LoginController loginController = new LoginController(loginUseCase);
            loginController.loginToAccount(loginUser, loginPwd);
        }
        //Coding Part of registerButton
        if (e.getSource() == registerButton) {
            String registerUser;
            String registerPwd;
            registerUser = registerUsername.getText();
            registerPwd = String.valueOf(registerPassword.getPassword());

            RegisterInModel registerInModel = new RegisterInModel(registerUser, registerPwd);
            RegisterUseCase registerUseCase = new RegisterUseCase(registerInModel);
            RegisterController registerController = new RegisterController(registerUseCase);
            registerController.createNewAccount(registerUser, registerPwd);
        }
            //Coding Part of resetButton
        if (e.getSource() == resetButton) {
            loginUsername.setText("");
            loginPassword.setText("");
        }
        //Coding Part of showPassword JCheckBox
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                loginPassword.setEchoChar((char) 0);
            } else {
                loginPassword.setEchoChar('*');
            }
        }
        }
    @Override
    public void build() {
        LoginUI frame = new LoginUI();
        frame.setTitle("Login Page");
        frame.setVisible(true);
        frame.setBounds(0, 0, 1440, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        LoginUI.setFrame(frame);
    }
}

