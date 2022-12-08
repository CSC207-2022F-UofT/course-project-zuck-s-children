package ui.components;

import javax.swing.*;
import java.util.ArrayList;

public class NotifTable {
    JFrame frame;
    JTable table;

    public NotifTable(ArrayList notifications){
        frame = new JFrame();
        frame.setTitle("Notifications");

        String[] columnNames = { "Sender", "Content", "Date" };
        String[][] data = new String[notifications.size()][];
        int i = 0;
        for (Object l : notifications){
            data[i] = (String [])l;
            i += 1;
        }

        table = new JTable(data, columnNames);
        table.setBounds(30, 40, 200, 300);

        JScrollPane sp = new JScrollPane(table);
        frame.add(sp);
        frame.setSize(500, 200);
        frame.setVisible(true);
    }
}
