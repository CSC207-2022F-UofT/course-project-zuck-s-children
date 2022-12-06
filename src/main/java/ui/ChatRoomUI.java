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
import java.util.ArrayList;
import java.util.List;

import static main_app.StudyBuddyApp.swiperUI;

public class ChatRoomUI extends JFrame implements ActionListener {
    MsgSendController msgSendController;
    String roomTitle;
    String roomId;
    JPanel inputPanel;
    JScrollPane msgPane;
    Button sendBtn;
    Button spotBtn;
    JTextField textfield;
    JTextArea textarea;
    JFrame roomFrame;

    public void setTitle(String title){
        roomTitle = title;
    }
    public void setFrame(){
        roomFrame = new JFrame(this.roomId);
    }

    public void setCA(MsgSendController msgSendController) {
        this.msgSendController = msgSendController;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }
    public void setListOfMessages(List<MessageEnt> listOfMessages){
        textarea.setText("");
        for(MessageEnt msg:listOfMessages){
            textarea.append(msg.getSender().getUsername() + ": " + msg.getContent() + "\n");
        }
    }

    /**
     * Create a chat room UI
     */
    private void createChatRoomUI() {
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

        msgPane = new JScrollPane();
        textarea = new JTextArea();
        textarea.setVisible(true);
        textarea.setEditable(false);
        msgPane.add(textarea);
        msgPane.setViewportView(textarea);
        roomFrame.add(msgPane);
        roomFrame.add(inputPanel, BorderLayout.PAGE_END);
    }

    public void build() {
        roomFrame.setPreferredSize(new Dimension(400, 700));
        roomFrame.setBounds(50,50,400,700);
        roomFrame.setTitle(roomTitle);
        createChatRoomUI();
        roomFrame.pack();
        roomFrame.setVisible(true);
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