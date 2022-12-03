package ui;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.ArrayList;
import java.util.List;

public class ChatListUI extends javax.swing.JFrame implements ListSelectionListener {
    JList roomList;


    public void build(JPanel panel, List<Object> listOfRooms) {
        panel.removeAll();
        List<String> names = new ArrayList<String>();
        for(Object s : listOfRooms){
            names.add((String)((List<String>)s).get(0));
        }
        roomList = new JList((ListModel) names);
        panel.add(roomList);
        pack();
    }

    /**
     * Called whenever the value of the selection changes.
     *
     * @param e the event that characterizes the change.
     */
    @Override
    public void valueChanged(ListSelectionEvent e) {

    }
}
