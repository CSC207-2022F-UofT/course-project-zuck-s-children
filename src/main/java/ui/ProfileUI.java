package ui;


import ui.components.Button;

import javax.swing.*;
import java.awt.*;

public class ProfileUI {
    Button editBtn;
    JPanel profilePanel;

    public void build() {
        this.profilePanel = new JPanel();
        FlowLayout profileLayout = new FlowLayout();
        profilePanel.setLayout(profileLayout);

        editBtn = new Button();
        editBtn.setButton("Edit");

        profilePanel.add(editBtn.getButton());
    }

    public static void main(String[] args) {
        ProfileUI profileUI = new ProfileUI();
        profileUI.build();
    }
}