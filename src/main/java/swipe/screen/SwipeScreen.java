package swipe.screen;

import account_and_login.account_creation.Account;
import data.persistency.UserDatabase;
import profile.Profile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import static javax.swing.JOptionPane.showMessageDialog;
import static main_app.StudyBuddyApp.swiperUI;
//
// Frameworks/Drivers layer

/**
 * A window with a title, two Jbuttons for accept and reject and the relevant information from potential match
 * such as its year of study.
 */
public class SwipeScreen extends JPanel implements ActionListener {

    /**
     * The controller
     */
    private SwiperController swiperController;

    /**
     * A list of all the potential matches for the current user.
     */
    private LinkedList<Account> potential;

    /**
     * current index of potential
     */
    private int i;

    /**
     * A constructor that adds all the information to the panel based on potential at index i and buttons accept and
     * reject. Initializes controller as well.
     * @param controller
     * @param potential
     * @param i
     */
    public SwipeScreen(SwiperController controller, LinkedList<Account> potential, int i) {
        this.potential = potential;
        if (this.potential.size() > i) {
            this.i = i;
            this.swiperController = controller;
            Profile profile = potential.get(i).getProfile();
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
                    new JLabel("Study Style: " + profile.getStudyStyles().toString()));

            JButton accept = new JButton("Accept");
            accept.setActionCommand("T," + potential.get(i).getUsername());
            JButton reject = new JButton("Reject");
            reject.setActionCommand("F," + potential.get(i).getUsername());

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
    }

    /**
     * React to a button click that results in evt for accept or reject. Set off controller.
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
        String[] result = evt.getActionCommand().split(",", 2);
        Account account = UserDatabase.getUserDatabase().getAccounts().get(result[1]);
        try {
            swiperController.create(result[0], account);
            if (result[0].equals("T")){
            JOptionPane.showMessageDialog(this, "Request sent to " + result[1]);}
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Sorry, something went wrong");
        }
        next();
        }

    /**
     * a helper for actionPerformed, where it creates a new SwipeScreen to be used by the main SwiperUI
     * (in SwiperUI.build()) for the next potential match, or let SwiperUI build an empty screen if there are no more
     * matches.
     */
    private void next(){
        if (i <= potential.size() - 2){
            i += 1;
            swiperUI.build(new SwipeScreen(swiperController, potential, i));
        }
        else{
            swiperUI.build();
        }
    }


}
