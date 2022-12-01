package UI;

import Notification.ShowNotif.NotifResponseModel;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;


public class NotificationUI extends JFrame implements ActionListener{
    ArrayList<List> notifications;
    JTable notifTable;
    JLabel notifLabel = new JLabel("All notifications");
    JLabel clearLabel = new JLabel("No new notifications");
    JButton chatButton = new JButton("Go to chatroom");
    Container container = getContentPane();

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

    private void addComponentsToContainer(String response) {
        container.add(chatButton);
        if (Objects.equals(response, "show")){
            container.add(notifTable);
            container.add(notifLabel);
            container.remove(clearLabel);
        }
        else{
            container.add(clearLabel);
            container.remove(notifTable);
            container.remove(notifLabel);
        }

    }

    private void setLocationAndSize(String response) {
        chatButton.setBounds(50, 50, 300, 200);
        if (Objects.equals(response, "show")){
            notifTable.setBounds(30, 30, 1000, 700);
            //notifLabel.setBounds();
        } else{
            //clearLabel.setBounds();
        }
    }

    private void setLayoutManager() {
        container.setLayout(null);
    }

    public void prepareView(ArrayList<List> response) {
        this.notifications = response;
        notifTable = makeTable(this.notifications);
        setLayoutManager();
        setLocationAndSize("show");
        addComponentsToContainer("show");
        addActionEvent();
    }

    public void showMessage(){
        setLayoutManager();
        setLocationAndSize("clear");
        addComponentsToContainer("clear");
        addActionEvent();
    }

    public void addActionEvent() {
        chatButton.addActionListener(this);
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

    }
}
