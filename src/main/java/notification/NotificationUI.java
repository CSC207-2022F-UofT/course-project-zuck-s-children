package notification;

import notification.Control.ShowNotifController;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static main_app.StudyBuddyApp.*;

public class NotificationUI extends JInternalFrame implements ActionListener{
    /**
     * A Notification UI as a tabbed pane in Navigation UI
     */
    ArrayList<List> notifications;
    public JPanel notifPanel;
    JTable notifTable;
    JTable clearTable;
    JButton chatButton = new JButton("Go to chatroom");
    JButton clearButton = new JButton("Clear Notifications");
    JScrollPane scrollNotifTable;
    JMenuBar mb;

    /**
     * Construct a Notification UI Object with a menu bar.
     * Add action events to buttons.
     */
    public NotificationUI(){
        super("Notifications");
        setMinimumSize(new Dimension(400, 800));
        mb = new JMenuBar();
        mb.add(clearButton);
        mb.add(chatButton);
        this.setLayout(new BorderLayout());
        this.add(mb, BorderLayout.SOUTH);
        this.addActionEvent();
    }

    /**
     * Call on showNotif use case to generate table of all notifications
     * @param controller Controller for showNotif use case
     */
    public void create(ShowNotifController controller) {
        controller.showNotif();
    }

    /**
     * Create JTable based on list of notifications.
     *
     * @param notifications Nested List of strings of notifications
     */
    public JTable makeTable(ArrayList<List> notifications) {
        String[] columnNames = {"Sender", "Content", "Date"};
        String[][] data = getNotif(this.notifications);

        return new JTable(data, columnNames);
    }

    /**
     * Convert list of Notification objects into nested list of strings
     * helper method for makeTable().
     *
     * @param notifications  Nested List of strings of notifications
     */
    private String[][] getNotif(ArrayList<List> notifications) {
        int length = notifications.size();
        String[][] data = new String[length][3];

        for (int i = 0; i<length; i++){
            data[i][0] = (String) notifications.get(i).get(0);
            data[i][1] = (String) notifications.get(i).get(1);
            data[i][2] = (String) notifications.get(i).get(2);
        }
        return data;
    }

    /**
     * Add table of notifications to the interface
     *
     * @param response Nested List of strings of notifications
     */
    public void prepareView(ArrayList<List> response) {
        this.notifications = response;
        notifTable = makeTable(this.notifications);
        scrollNotifTable = new JScrollPane(notifTable);
        this.add(scrollNotifTable, BorderLayout.CENTER);
    }

    /**
     * Update interface in responds to clearNotif use case.
     */
    public void update(){
        JOptionPane.showMessageDialog(this, "No new notifications!");
        this.remove(scrollNotifTable);
        this.repaint();
    }

    /**
     * Add action events to buttons.
     */
    public void addActionEvent() {
        chatButton.addActionListener(this);
        clearButton.addActionListener(this);
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == chatButton){


        }
        if (e.getSource() == clearButton){
            if (JOptionPane.showConfirmDialog(this.notifPanel,
                    "Are you sure you want to clear all notifications?", "Clear?",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){

                clearNotifController.clearNotif();
            }

        }

    }

}
