package Swipe.Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;

public class EmptyScreen extends JPanel implements ActionListener {
    public EmptyScreen() {


        JLabel title = new JLabel("Check back later!");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
