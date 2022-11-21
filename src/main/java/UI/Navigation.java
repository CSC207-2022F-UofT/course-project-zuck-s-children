package UI;

import UI.components.Button;

import javax.swing.*;
import java.awt.*;

public class Navigation implements ViewModel{
    Button swiperBtn, chatBtn, settingBtn;
    JPanel navPanel;
    @Override
    public void build() {
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

    public static void main(String[] args) {
        Navigation nav = new Navigation();
        nav.build();
    }
}
