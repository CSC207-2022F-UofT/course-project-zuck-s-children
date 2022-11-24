package UI.components;

import javax.swing.*;

public class Button {
    JButton button;

    /**
     * Returns class variable button
     * @return button
     */
    public JButton getButton(){
        return button;
    }

    public void setButton(String buttonText) {
        button = new JButton(buttonText);
    }

}
