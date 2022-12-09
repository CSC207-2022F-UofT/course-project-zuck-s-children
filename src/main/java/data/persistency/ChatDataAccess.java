package data.persistency;


import account_creation.Account;
import chat.entities.ChatRoomEnt;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ChatDataAccess implements ChatDataAccessInterface{
        private static ChatDatabase chatdata;

        public static void setChatdata(ChatDatabase chatdata) {
                ChatDataAccess.chatdata = chatdata;
        }


        @Override
        public ChatDatabase getChatData(){
                return this.chatdata;
        }
        @Override
        public Object loadRoomById(String rid) {
                return chatdata.findById(rid);
        }

        @Override
        public List<Object> loadRoomByAccount() {
                if (chatdata == null) {
                        return new ArrayList<>();
                } else {
                        return chatdata.findByAccount(UserDatabase.getUserDatabase().getCurrentUser());
                }
        }

        @Override
        public void addChatRoom(ChatRoomEnt room){
                chatdata.addChatRoom(room);
        }

}