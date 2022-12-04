package ui;

import notification.clear_notif.ClearNotifController;
import notification.show_notif.ShowNotifController;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;


public class NotificationUI extends JFrame implements ActionListener{
    ArrayList<List> notifications;
    public JPanel notifPanel;
    JTable notifTable;
    JLabel notifLabel = new JLabel("All notifications");
    JLabel clearLabel = new JLabel("No new notifications");
    JButton chatButton = new JButton("Go to chatroom");
    JButton clearButton = new JButton("Clear Notifications");
    JButton showButton = new JButton("Show Notifications");

    ClearNotifController clearNotifController;

    public NotificationUI(JPanel notifPanel) {
        this.notifPanel = notifPanel;

    }
    public void build(ClearNotifController clearController) {
        this.clearNotifController = clearController;
        this.notifPanel.add(showButton);

        JMenuBar mb = new JMenuBar();
        mb.add(clearButton);
        mb.add(chatButton);
        this.notifPanel.setLayout(new BorderLayout());
        this.notifPanel.add(mb, BorderLayout.SOUTH);
        this.addActionEvent();

}

    public JTable makeTable(ArrayList<List> notifications) {
        String[] columnNames = {"Sender", "Content", "Date"};
        String[][] data = getNotif(this.notifications);

        return new JTable(data, columnNames);
    }

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
    
    public void prepareView(ArrayList<List> response) {
        this.notifications = response;
        notifTable = makeTable(this.notifications);
        JLabel practice = new JLabel("prac");

        this.notifPanel.setLayout(new BorderLayout());
        this.notifPanel.add(notifTable, BorderLayout.CENTER);
    }

    public void showMessage(){
        JOptionPane.showMessageDialog(this, "No new notifications!");
    }

    public void addActionEvent() {
        chatButton.addActionListener(this);
        showButton.addActionListener(this);
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
        //chat stuff

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
