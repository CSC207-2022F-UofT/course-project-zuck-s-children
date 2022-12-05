package ui;

import account_creation.Account;
import chat.control.MsgInModel;
import chat.control.MsgSendController;
import chat.entities.MessageEnt;
import chat.use_cases.MsgInBoundary;
import data.persistency.UserDatabase;
import ui.components.Button;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import static main_app.StudyBuddyApp.swiperUI;

public class ChatRoomUI extends JFrame implements ActionListener {
    MsgInBoundary msgInBoundary;
    MsgSendController msgSendController;
    String roomId;
    JPanel inputPanel;
    JScrollPane msgPane;
    Button sendBtn;
    Button spotBtn;
    JTextField textfield;
    JTextArea textarea;

    public ChatRoomUI(MsgInBoundary msgInBoundary, MsgSendController msgSendController) {
        this.msgInBoundary = msgInBoundary;
        this.msgSendController = msgSendController;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    /**
     * Create a chat room UI
     *
     * @param roomFrame a frame for a chat room
     */
    private void createChatRoomUI(JFrame roomFrame) {

        inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.LINE_AXIS));
        textfield = new JTextField();
        textfield.setColumns(50);
        sendBtn = new Button();
        sendBtn.setButton("Send");
        sendBtn.getButton().addActionListener(this);
        spotBtn = new Button();
        spotBtn.setButton("Study Spot");
        spotBtn.getButton().addActionListener(this);

        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        textfield.setBorder(border);
        inputPanel.add(textfield);
        inputPanel.add(sendBtn.getButton());
        inputPanel.add(spotBtn.getButton());

        textarea = new JTextArea();
        msgPane = new JScrollPane();
        msgPane.add(textarea);

        roomFrame.add(msgPane, BorderLayout.PAGE_START);
        roomFrame.add(inputPanel, BorderLayout.PAGE_END);
    }

    public void build(JFrame frame) {
        frame.setPreferredSize(new Dimension(400, 700));
        createChatRoomUI(frame);
        frame.pack();
        frame.setVisible(true);
    }

    private void displayMessage(JTextArea textarea){

    }
    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed (ActionEvent e){
        if(e.getSource()==sendBtn.getButton()){
            String content = textfield.getText();
            Account sender = UserDatabase.getUserDatabase().getCurrentUser();
            MsgInModel msgModel = new MsgInModel(content, sender, roomId);
            msgSendController.sendMessage(msgModel);
            textfield.setText("");
        }
        else{
            // StudySpot Recommendation
        }
    }
}