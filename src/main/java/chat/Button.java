package chat;

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
