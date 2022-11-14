package screen;

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
    public SwipeScreen(SwiperController controller) {

        this.swiperController = controller;

        JLabel title = new JLabel("Potential Match?");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton accept = new JButton("Accept");
        JButton reject = new JButton("Reject");

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

        try {
            userRegisterController.create(username.getText(),
                    String.valueOf(password.getPassword()),
                    String.valueOf(repeatPassword.getPassword()));
            JOptionPane.showMessageDialog(this, "%s created.".formatted(username.getText()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
}
