package data.persistency;

import chat.entities.ChatRoomEnt;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ChatDataAccess implements ChatDataAccessInterface{
        private static ChatData chatdata;
        @Override
        public void save(String filePath, ChatData chatList) throws IOException{
                OutputStream file = new FileOutputStream(filePath);
                OutputStream buffer = new BufferedOutputStream(file);
                ObjectOutput output = new ObjectOutputStream(buffer);

                // serialize the Map
                output.writeObject(chatList);
                output.close();
        }
        public static void loadAllRooms(String filePath) throws Throwable{
                InputStream file = new FileInputStream(filePath);
                InputStream buffer = new BufferedInputStream(file);
                ObjectInput input = new ObjectInputStream(buffer);
                chatdata = (ChatData) input.readObject();
                input.close();

        };

        @Override
        public ChatData getChatData(){
                return this.chatdata;
        }
        @Override
        public Object loadRoomById(String rid) throws Throwable {
                return chatdata.find(rid);
        }

        @Override
        public List<Object> loadRoomByAccount(Object acc) {
                ArrayList<Object> roomList = new ArrayList<Object>();
                for(Object room : chatdata.getAllRooms()){
                        if(((ChatRoomEnt)room).getParticipants().checkParticipant(acc)){
                                roomList.add(room);
                        };
                }
                return roomList;
        }


}
