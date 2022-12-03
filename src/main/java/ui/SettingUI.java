package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingUI extends JFrame implements ActionListener {

    Container container = getContentPane();
    JButton notificationButton = new JButton("Notifications");
    JButton profileButton = new JButton("profile");
    JButton accountButton = new JButton("Account Settings");


    public SettingUI() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }

    private void addComponentsToContainer() {
        container.add(notificationButton);
        container.add(profileButton);
        container.add(accountButton);
    }

    private void setLocationAndSize() {
    }

    private void setLayoutManager() {
        container.setLayout(null);
    }

    public void addActionEvent(){
        notificationButton.addActionListener(this);
    }
    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == accountButton){

        }
        if (e.getSource() == profileButton){

        }
        if (e.getSource() == notificationButton){

        }

    }
}
