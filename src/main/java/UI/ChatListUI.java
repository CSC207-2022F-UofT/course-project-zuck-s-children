package UI;

import chat.control.ChatRoomOpenContoller;
import chat.control.MsgOutBoundary;
import chat.control.RoomInModel;
import chat.control.RoomOutBoundary;
import chat.entities.ChatRoomEnt;
import chat.presenter.ChatRoomPresenter;
import chat.useCases.ChatRoomOpenInteractor;
import chat.useCases.OpenRoomBoundary;
import data.persistency.ChatDataAccess;
import data.persistency.ChatDataAccessInterface;
import data.persistency.UserDatabase;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ChatListUI extends javax.swing.JFrame implements ListSelectionListener {
    JList roomList;
    JScrollPane listScroller;

    JPanel chatList;

    List<String> roomIds;

    MsgOutBoundary chatRoomPresenter = new ChatRoomPresenter();
    ChatDataAccessInterface chatDataAccess = new ChatDataAccess();
    OpenRoomBoundary chatRoomInteractor = new ChatRoomOpenInteractor(chatRoomPresenter, chatDataAccess);
    ChatRoomOpenContoller chatRoomOpenContoller = new ChatRoomOpenContoller(chatRoomInteractor);


    public ChatListUI(JPanel panel){
        this.chatList = panel;
    }

    public void build() {
        chatList.removeAll();
        roomIds = new ArrayList<String>();
        DefaultListModel<String> listModel = new DefaultListModel<String>();
        List<Object> listOfRooms = chatDataAccess.loadRoomByAccount();
        for(Object room : listOfRooms){
            roomIds.add(((ChatRoomEnt)room).getId());
            listModel.addElement(((ChatRoomEnt) room).getParticipants().getOtherUser());
        }
        roomList = new JList<String>(listModel);
        roomList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        roomList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        roomList.addListSelectionListener(this);
        listScroller = new JScrollPane(roomList);
        listScroller.setPreferredSize(new Dimension(chatList.getWidth(), chatList.getHeight()));
        chatList.add(listScroller);
        pack();
    }

    public JPanel getPanel(){
        return this.chatList;
    }
    /**
     * Called whenever the value of the selection changes.
     *
     * @param e the event that characterizes the change.
     */
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting() == false) {
            RoomInModel model = new RoomInModel(this.roomIds.get(roomList.getSelectedIndex()));
            chatRoomOpenContoller.navigate(model);
        }
    }
}