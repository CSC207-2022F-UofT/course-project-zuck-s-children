package UI;

import UI.components.Button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class NavigationUI extends JFrame implements ActionListener {
    Button swiperBtn, chatBtn, settingBtn;
    JPanel navPanel;

    public NavigationUI() {
        this.navPanel = new JPanel();
        FlowLayout navLayout = new FlowLayout();
        navPanel.setLayout(navLayout);

        swiperBtn = new Button();
        chatBtn = new Button();
        settingBtn = new Button();

        swiperBtn.setButton("Swiper");
        chatBtn.setButton("Chat");
        settingBtn.setButton("Setting");

        navPanel.add(swiperBtn.getButton());
        navPanel.add(chatBtn.getButton());
        navPanel.add(settingBtn.getButton());
    }


    private void addActionEvent() {
        swiperBtn.getButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
