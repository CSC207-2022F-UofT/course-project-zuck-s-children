package ui;

import chat.control.ChatRoomOpenController;
import chat.control.MsgSendController;
import chat.presenter.MsgOutBoundary;
import chat.control.RoomInModel;
import chat.entities.ChatRoomEnt;
import chat.presenter.ChatRoomPresenter;
import chat.use_cases.ChatRoomOpenInteractor;
import chat.use_cases.MsgInBoundary;
import chat.use_cases.MsgSendInteractor;
import chat.use_cases.OpenRoomBoundary;
import data_persistency.ChatDataAccess;
import data_persistency.ChatDataAccessInterface;
import spots.presenter.RecsPresenter;
import spots.use_cases.RecsOutBoundary;

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
    ChatDataAccessInterface chatDataAccess = new ChatDataAccess();

    /**
     * Construct a chat list UI
     */
    public ChatListUI(){
        super("Chat List");
        this.setBounds(0, 0, 1440, 1000);
        this.setResizable(false);
        this.build();
    }

    /**
     * Update the view
     */
    public void update(){
        this.remove(chatList);
        this.build();
    }

    /**
     * Build the content of a chat list
     */
    public void build() {
        this.chatList = new JPanel();
        roomIds = new ArrayList<>();
        DefaultListModel<String> listModel = new DefaultListModel<>();
        List<Object> listOfRooms = chatDataAccess.loadRoomByAccount();
        for(Object room : listOfRooms){
            roomIds.add(((ChatRoomEnt)room).getId());
            listModel.addElement(room.toString());
        }
        roomList = new JList<>(listModel);
        roomList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        roomList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        roomList.addListSelectionListener(this);
        listScroller = new JScrollPane(roomList);
        listScroller.setPreferredSize(new Dimension(1080, 600));
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
            ChatRoomUI chatRoomUI = new ChatRoomUI();
            chatRoomUI.setTitle((String)roomList.getSelectedValue());
            MsgOutBoundary chatRoomPresenter = new ChatRoomPresenter(chatRoomUI);
            MsgInBoundary msgInteractor = new MsgSendInteractor(chatRoomPresenter, chatDataAccess);
            MsgSendController msgController = new MsgSendController(msgInteractor);

            chatRoomUI.setCA(msgController);

            OpenRoomBoundary chatRoomInteractor = new ChatRoomOpenInteractor(chatRoomPresenter, chatDataAccess);
            ChatRoomOpenController chatRoomOpenController = new ChatRoomOpenController(chatRoomInteractor);
            chatRoomOpenController.navigate(model);
        }
    }
}