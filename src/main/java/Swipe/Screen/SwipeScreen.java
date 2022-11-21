package Swipe.Screen;

import AccountCreation.Account;
import data.persistency.UserDatabase;
import profile.Profile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;

// Frameworks/Drivers layer

public class SwipeScreen extends JPanel implements ActionListener {

    /**
     * The controller
     */
    SwiperController swiperController;

    /**
     * A window with a title and a JButton.
     */
    public SwipeScreen(SwiperController controller, Account potential) {

        this.swiperController = controller;
        Profile profile = potential.getProfile();
        JLabel title = new JLabel("Potential Match?");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel name = new LabelTextPanel(
                new JLabel("Name: " + profile.getName()));
        LabelTextPanel pronouns = new LabelTextPanel(
                new JLabel("Pronouns: " + profile.getPronouns()));
        LabelTextPanel yearOfStudy = new LabelTextPanel(
                new JLabel("Year of Study: " + profile.getYear()));
        LabelTextPanel fieldOfStudy = new LabelTextPanel(
                new JLabel("Field of Study: " + profile.getFieldOfStudy()));
        LabelTextPanel studyStyles = new LabelTextPanel(
                new JLabel("Courses: " + profile.getStudyStyles().toString()));

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
        this.add(name);
        this.add(yearOfStudy);
        this.add(pronouns);
        this.add(fieldOfStudy);
        this.add(studyStyles);

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
