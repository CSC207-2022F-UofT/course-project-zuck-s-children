package swipe.screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;
//
/**
 * A UI class that is executed when there are no accounts to swipe on.
 */
public class EmptyScreen extends JPanel{

    /**
     * A window that simply says "Check back later! for when there are no more potential matches for the user."
     */
    public EmptyScreen() {


        JLabel title = new JLabel("Check back later!");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);

    }

}
