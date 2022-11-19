package Swipe.Screen;

import AccountCreation.Account;
import data.persistency.UserDatabase;
import swipe_left_use_case.src.swipe_left.SwiperRequestModel;
import swipe_left_use_case.src.swipe_left.SwiperController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;

// Frameworks/Drivers layer

public class SwipeScreen extends JPanel implements ActionListener {
    /**
     * The name of the potential match
     */
    JTextField name = new JTextField(15);
    /**
     * The match's account information
     */
    JPasswordField account = new JPasswordField(15);
    /**
     * The second password to make sure the user understands
     */
    JPasswordField repeatPassword = new JPasswordField(15);

    /**
     * The controller
     */
    SwiperController swiperController;

    /**
     * A window with a title and a JButton.
     */
    public SwipeScreen(SwiperController controller, Account potential) {

        this.swiperController = controller;

        JLabel title = new JLabel("Potential Match?");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel name = new LabelTextPanel(
                new JLabel(potential.getProfile().getName()));
        LabelTextPanel passwordInfo = new LabelTextPanel(
                new JLabel("Choose password"), password);
        LabelTextPanel repeatPasswordInfo = new LabelTextPanel(
                new JLabel("Enter password again"), repeatPassword);

        JButton accept = new JButton("Accept");
        accept.setActionCommand("T," + potential.getUsername());
        JButton reject = new JButton("Reject");
        reject.setActionCommand("F," + potential.getUsername());

        JPanel buttons = new JPanel();
        buttons.add(accept);
        buttons.add(reject);

        accept.addActionListener(this);
        reject.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(buttons);

    }

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
        String[] result = evt.getActionCommand().split(",");
        Account account = UserDatabase.getAccounts().get(result[1]);
        try {
            swiperController.create(evt.getActionCommand(), account);
            JOptionPane.showMessageDialog(this, "Request sent to %s!".formatted(result[1]));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
}
