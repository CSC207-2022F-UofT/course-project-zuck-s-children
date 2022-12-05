package ui;

import chat.control.ChatRoomOpenController;
import chat.presenter.MsgOutBoundary;
import chat.control.RoomInModel;
import chat.entities.ChatRoomEnt;
import chat.presenter.ChatRoomPresenter;
import chat.use_cases.ChatRoomOpenInteractor;
import chat.use_cases.OpenRoomBoundary;
import data.persistency.ChatDataAccess;
import data.persistency.ChatDataAccessInterface;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ChatListUI extends JInternalFrame implements ListSelectionListener {
    JList roomList;
    JScrollPane listScroller;

    JPanel chatList;

    List<String> roomIds;

    MsgOutBoundary chatRoomPresenter = new ChatRoomPresenter();
    ChatDataAccessInterface chatDataAccess = new ChatDataAccess();
    OpenRoomBoundary chatRoomInteractor = new ChatRoomOpenInteractor(chatRoomPresenter, chatDataAccess);
    ChatRoomOpenController chatRoomOpenContoller = new ChatRoomOpenController(chatRoomInteractor);


    public ChatListUI(){
        super("Chat List");
        this.setBounds(0, 0, 1440, 1000);
        this.setResizable(false);
        this.build();
    }

    public void build() {
        this.chatList = new JPanel();
        roomIds = new ArrayList<>();
        DefaultListModel<String> listModel = new DefaultListModel<>();
        List<Object> listOfRooms = chatDataAccess.loadRoomByAccount();
        for(Object room : listOfRooms){
            roomIds.add(((ChatRoomEnt)room).getId());
            listModel.addElement(((ChatRoomEnt) room).getParticipants().getOtherUser());
        }
        System.out.println("Number of Rooms: "+ roomIds.size());
        roomList = new JList<>(listModel);
        roomList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        roomList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        roomList.addListSelectionListener(this);
        listScroller = new JScrollPane(roomList);
        listScroller.setPreferredSize(new Dimension(chatList.getWidth(), chatList.getHeight()));
        chatList.add(listScroller);
        this.add(chatList);
        this.pack();
        this.setVisible(true);
    }

    /**
     * Called whenever the value of the selection changes.
     *
     * @param e the event that characterizes the change.
     */
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            RoomInModel model = new RoomInModel(this.roomIds.get(roomList.getSelectedIndex()));
            chatRoomOpenContoller.navigate(model);
        }
    }
}