package ui;

import account_creation.Account;
import swipe.screen.EmptyScreen;
import swipe.screen.SwipeScreen;
import swipe.screen.SwiperController;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class SwiperUI extends JInternalFrame{

    JPanel initial;
    SwipeScreen swipePanel;
    CardLayout cl;

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
    public void build(LinkedList<Account> potential, SwiperController swiperController){
//        if (swipePanel != null){
//            this.remove(swipePanel);
//            this.remove(initial);
//        }
        swipePanel = new SwipeScreen(swiperController, potential, 0);
        initial.add(swipePanel, "Swipe");
        cl.show(initial, "Swipe");
        this.pack();
//        while (!swipePanel.getPressed()){
//
//        }
//        initial.remove(swipePanel);


    }
    public void build(SwipeScreen swipePanel2){
        if (swipePanel != null){
            initial.remove(swipePanel);
        }
        initial.add(swipePanel2, "1");
        cl.show(initial, "1");
        this.pack();

    }
    public void build(){
        initial.remove(swipePanel);
        initial.add(new EmptyScreen(), "2");
        cl.show(initial, "2");
        this.pack();
    }
}
