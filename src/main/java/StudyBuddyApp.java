//import UI
import UI.UserAuthorizationUI;
import data.persistency.UserDatabase;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class StudyBuddyApp {
    public static void main(String[] args){
        // deserializing the userDatabase.txt file
        UserDatabase userDatabase = null;
        try {
            //Creating stream to read the object
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("userDatabase.txt"));
            userDatabase = (UserDatabase) in.readObject();
            //closing the stream
            in.close();
            System.out.println("successful deserialization");
        } catch (Exception e) {
            System.out.println(e);
        }
        // if this is the first time program is running:
        if (userDatabase == null) {
            userDatabase = new UserDatabase();
        }
        //initial page: user authorization
        UserAuthorizationUI userAuthorizationPage = new UserAuthorizationUI();

        userAuthorizationPage.createDialogBox("Example", 540, 300);

        // serialization to userDatabase.txt file
        try {
            //Creating stream and writing the object
            FileOutputStream fout = new FileOutputStream("userDatabase.txt");
            ObjectOutputStream out = new ObjectOutputStream(fout);
            out.writeObject(userDatabase);
            out.flush();
            //closing the stream
            out.close();
            System.out.println("successful serialization");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
