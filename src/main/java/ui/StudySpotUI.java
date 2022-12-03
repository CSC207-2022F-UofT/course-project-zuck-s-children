package ui;

import javax.swing.*;

public class StudySpotUI { //doc, cahnged ca violation design /person

    JLabel label;
    /**
     * Create a study spot UI
     * @param panel contains recommendations to be presented in a chatroom
     */
    public void createRecommendationBox(JPanel panel){ //button in chat

    }
    /**
     * Build a box with recommended study spots
     * @param recs recommended study spots
     */
    public void build(JPanel recPanel, String recs) {
        label = new JLabel("Study Spot Recommendations: " + recs);
        recPanel.add(label);
        createRecommendationBox(recPanel);
    }
}
