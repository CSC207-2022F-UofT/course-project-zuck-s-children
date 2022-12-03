package data.persistency;

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
        public void save(String filePath, ChatDatabase chatList) throws IOException{
                OutputStream file = new FileOutputStream(filePath);
                OutputStream buffer = new BufferedOutputStream(file);
                ObjectOutput output = new ObjectOutputStream(buffer);

                // serialize the Map
                output.writeObject(chatList);
                output.close();
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
                return chatdata.findByAccount(UserDatabase.getCurrentUser());
        }


}
