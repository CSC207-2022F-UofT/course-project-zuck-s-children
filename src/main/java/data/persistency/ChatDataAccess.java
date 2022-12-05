package data.persistency;


import chat.entities.ChatRoomEnt;

import java.io.*;
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
        public Object loadRoomById(String rid) throws Throwable {
                return chatdata.findById(rid);
        }

        @Override
        public List<Object> loadRoomByAccount() {
                return chatdata.findByAccount(UserDatabase.getUserDatabase().getCurrentUser());
        }

        @Override
        public List<Object> loadAll() {
                return chatdata.getChatList();
        }

        public void addChatRoom(ChatRoomEnt room){
                chatdata.addChatRoom(room);
        }

}