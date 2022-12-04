package ui;

import ui.components.Button;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ChatRoomUI extends JFrame implements ActionListener {
    String roomId;
    JPanel inputPanel;
    JScrollPane msgPane;
    Button sendBtn;
    JTextField textfield;

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    /**
     * Create a chat room UI
     *
     * @param panel a JPanel for a chat room
     */
    private void createChatRoomUI(JPanel panel) {
        inputPanel = new JPanel();
        textfield = new JTextField();
        sendBtn = new Button();
        sendBtn.setButton("Send");
        sendBtn.getButton().addActionListener(this);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(msgPane);

    }

    public void build(JPanel panel) {
        createChatRoomUI(panel);
        pack();
    }
    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed (ActionEvent e){

    }
}