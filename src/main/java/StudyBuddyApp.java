//import UI
import UI.UserAuthorizationUI;

public class StudyBuddyApp {
    public static void main(String[] args){
        //initial page: user authorization
        UserAuthorizationUI userAuthorizationPage = new UserAuthorizationUI();

        userAuthorizationPage.createDialogBox("Example", 540, 300);
    }
}
