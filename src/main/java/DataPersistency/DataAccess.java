package DataPersistency;

public class DataAccess{

        public static boolean duplicateUsername(String inputUsername) {
                return UserDatabase.containsKey(inputUsername);
        }
}
