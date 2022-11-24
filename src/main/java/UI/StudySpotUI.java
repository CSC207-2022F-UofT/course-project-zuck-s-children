package UI;

import javax.swing.*;

public class StudySpotUI implements ViewModel{

    JTextArea textArea;

    public void createRecommendationBox(JPanel panel){ //button in chat

    }
    /**
     */
    //@Override i will fix this too
    public void build(JPanel recPanel,String recs) {
        textArea = new JTextArea();
        textArea.append("Study Spot Recommendations: " + recs);
        recPanel.add(textArea);
        createRecommendationBox(recPanel);
    }

    @Override
    public void build() {

    }
}
