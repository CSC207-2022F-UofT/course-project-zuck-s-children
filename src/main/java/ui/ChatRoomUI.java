package ui;

import ui.components.Button;

import javax.swing.*;
import java.util.List;

public class ChatRoomUI extends javax.swing.JFrame{
    JPanel msgPanel;
    JPanel inputPanel;
    JScrollPane msgPane;
    Button sendBtn;
    JTextField textfield;
    JTextArea textarea;

    /**
     * Create a chat room UI
     * @param panel
     */
    private void createChatRoomUI(JPanel panel){
        msgPanel = new JPanel();
        inputPanel = new JPanel();
        textfield = new JTextField();
        sendBtn = new Button();
        sendBtn.setButton("Send");


        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(msgPane);
        msgPane.setViewportView(textarea);
        panel.add(inputPanel);

        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.X_AXIS));
        inputPanel.add(textfield);
        inputPanel.add(sendBtn.getButton());
    }

    /**
     * Build a chatroom with a list of messages
     * @param listOfMsg
     */
    public void build(JPanel panel, List<Object> listOfMsg) {
        textarea = new JTextArea();
        for (Object chat: listOfMsg){
            String sender = ((List<String>) chat).get(0);
            String content = ((List<String>) chat).get(1);
            textarea.append("[" + sender + "]" + ": " + content + "\n");
        }
        panel.add(textarea);
        createChatRoomUI(panel);
        pack();
    }
}
