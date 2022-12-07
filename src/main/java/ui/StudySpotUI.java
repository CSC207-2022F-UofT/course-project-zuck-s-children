package ui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class StudySpotUI {

    JFrame recPopUp;
    JPanel p;
    JPanel spot1;
    JPanel spot2;
    JPanel spot3;

    /**
     * Create a study spot UI
     *
     * @param p contains recommendations to be presented in a chatroom
     */
    public void createRecommendationBox(JPanel p) { //button in chat
        recPopUp = new JFrame("Study Spot Recommendations");
        recPopUp.setVisible(true);
        recPopUp.add(p);
        recPopUp.pack();
    }

    /**
     * Build boxes around each study spot
     *
     * @param recs recommended study spots
     */
    public void build(ArrayList<String> recs) {
        p = new JPanel();

        spot1 = new JPanel();
        spot1.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        spot2 = new JPanel();
        spot2.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        spot3 = new JPanel();
        spot3.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel ex1 = new JLabel(recs.get(0));
        JLabel ex2 = new JLabel(recs.get(1));
        JLabel ex3 = new JLabel(recs.get(2));

        spot1.add(ex1);
        spot2.add(ex2);
        spot3.add(ex3);

        p.add(spot1);
        p.add(spot2);
        p.add(spot3);

        createRecommendationBox(p);
    }
}
