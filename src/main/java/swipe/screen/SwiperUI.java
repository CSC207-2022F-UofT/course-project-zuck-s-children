package swipe.screen;

import account_and_login.account_creation.Account;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

/**
 * a UI that is a JInternalFrame to be added into the main navigation frame, it contains a SwipeScreen.
 */
public class SwiperUI extends JInternalFrame{

    /**
     * a JPanel which will contain the swipe panel
     */
    JPanel initial;
    /**
     * a SwipeScreen JPanel that contains the information from a potential user with the necessary buttons.
     */
    SwipeScreen swipePanel;

    /**
     * A Cardlayout as part of the overall frame
     */
    CardLayout cl;

    /**
     * A constructor that initializes cl and intitial as an empty cardlayout and JPanel, and sets the frames bounds
     * and title.
     */
    public SwiperUI(){
        super("Swiper");
        this.setBounds(0, 0, 1440, 1000);
        this.setResizable(false);
        cl = new CardLayout();
        initial = new JPanel(cl);
        this.add(initial);
        this.pack();
        this.setVisible(true);
    }

    /**
     * One version of build that initializes swipePanel with the parameters and adds it to initial, then showcases the
     * final result.
     * @param potential; a LinkedList of potential accounts to be matched with
     * @param swiperController
     */
    public void build(LinkedList<Account> potential, SwiperController swiperController){

        swipePanel = new SwipeScreen(swiperController, potential, 0);
        initial.add(swipePanel, "Swipe");
        cl.show(initial, "Swipe");
        this.pack();

    }

    /**
     * a second version of build that does the same thing as the first build but now takes in an actual SwipeScreen
     * instead of making one, this is for all the accounts in the potential list that are not at index 0.
     * @param swipePanel2
     */
    public void build(SwipeScreen swipePanel2){
        if (swipePanel != null){
            initial.remove(swipePanel);
        }
        initial.add(swipePanel2, "1");
        cl.show(initial, "1");
        this.pack();

    }

    /**
     * a final version of build that adds an EmptyScreen to initial for when the list of potential matches ends, then
     * showcases the empty screen.
     */
    public void build(){
        if (swipePanel != null){
            initial.remove(swipePanel);
        }
        initial.add(new EmptyScreen(), "2");
        cl.show(initial, "2");
        this.pack();
    }
}
