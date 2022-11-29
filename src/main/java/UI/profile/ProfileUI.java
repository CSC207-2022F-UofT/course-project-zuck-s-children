package UI.profile;


import UI.ViewModel;
import UI.components.Button;
import profile.Profile;
import profile.ProfileInModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProfileUI extends JFrame implements ActionListener, ViewModel {
    JButton editBtn = new JButton("Edit"); // the edit/save button
    JPanel personalInfoSection = new JPanel(); // figure out layout later
    JLabel nameLbl = new JLabel("Name"); // the name label
    JTextField nameTF = new JTextField("N/A"); // the textfield where the user type their name; default value is "N/A"
    JLabel pronounLbl = new JLabel("Preferred pronouns"); // the preferred pronouns label
    JTextField pronounTF = new JTextField("N/A"); // the textfield where the user type their preferred pronouns; default value is "N/A"
    JLabel yearLbl = new JLabel("Year"); // the year label
    JComboBox<String> yearCB = new JComboBox<String>(Profile.YEARS); // the dropdown where the user choose their year in university; NEED TO FIGURE OUT DEFAULT SELECTION
    JLabel fieldLbl = new JLabel("Field of study"); // the field of study label
    JComboBox<String> fieldCB = new JComboBox<String>(Profile.FIELDS); // the dropdown where the user choose their field of study; NEED TO FIGURE OUT DEFAULT SELECTION

    // the dropdowns where user pick up to three study styles for themselves
    JComboBox<String > style1 = new JComboBox<String>(Profile.STYLES);
    JComboBox<String > style2 = new JComboBox<String>(Profile.STYLES);
    JComboBox<String > style3 = new JComboBox<String>(Profile.STYLES);
    JList<String > yearPref = new JList<String>(Profile.YEARS); // the multiple selection list where user pick preferred year for their ideal study buddy

    // the dropdowns where the user pick up to three field of study for their ideal study buddy
    JComboBox<String > fieldPref1 = new JComboBox<String>(Profile.FIELDS);
    JComboBox<String > fieldPref2 = new JComboBox<String>(Profile.FIELDS);
    JComboBox<String > fieldPref3 = new JComboBox<String>(Profile.FIELDS);

    // the dropdowns where the user pick up to three study styles for their ideal study buddy
    JComboBox<String > stylePref1 = new JComboBox<String>(Profile.STYLES);
    JComboBox<String > stylePref2 = new JComboBox<String>(Profile.STYLES);
    JComboBox<String > stylePref3 = new JComboBox<String>(Profile.STYLES);

    // the dropdowns where the user pick up to three study spots they prefer
    JComboBox<String > spotPref1 = new JComboBox<String>(Profile.studySpots);
    JComboBox<String > spotPref2 = new JComboBox<String>(Profile.studySpots);
    JComboBox<String > spotPref3 = new JComboBox<String>(Profile.studySpots);
    JPanel SBSection = new JPanel(); // figure out layout later

    JPanel SSSection = new JPanel(new FlowLayout()); // the study spot preferences section

    public ProfileUI() {
        // first set up personal info section of the profile page
        // name
        nameTF.setEditable(false);
        personalInfoSection.add(nameLbl);
        personalInfoSection.add(nameTF);

        // pronouns
        pronounTF.setEditable(false);
        personalInfoSection.add(pronounLbl);
        personalInfoSection.add(pronounTF);

        // year in uni
        personalInfoSection.add(yearLbl);
        personalInfoSection.add(yearCB);

        // field of study (single selection)
        personalInfoSection.add(fieldLbl);
        personalInfoSection.add(fieldCB);

        // study styles (up to 3 selections)
        JLabel styleLbl = new JLabel("Study styles");
        personalInfoSection.add(styleLbl);
        personalInfoSection.add(style1);
        personalInfoSection.add(style2);
        personalInfoSection.add(style3);


        // set up the Study Buddy Preferences section
        // title
        JLabel studyBuddyLbl = new JLabel("-- Study Buddy Preferences --");
        SBSection.add(studyBuddyLbl);
        studyBuddyLbl.setHorizontalAlignment(JLabel.CENTER);

        // year pref (multiple selection, can select all)
        JLabel yearPrefLbl = new JLabel("Preferred study buddy year");
        SBSection.add(yearPrefLbl);
        SBSection.add(yearPref);

        // field of study pref (up to 3 selections)
        JLabel fieldPrefLbl = new JLabel("Preferred study buddy field of study");
        SBSection.add(fieldPrefLbl);
        SBSection.add(fieldPref1);
        SBSection.add(fieldPref2);
        SBSection.add(fieldPref3);

        // field of study pref (up to 3 selections)
        JLabel stylesLbl = new JLabel("Preferred study buddy study styles");
        SBSection.add(stylesLbl);
        SBSection.add(stylePref1);
        SBSection.add(stylePref2);
        SBSection.add(stylePref3);

        // set up the Study Spots Preferences section
        // title
        JLabel studySpotsLbl = new JLabel("-- Preferred Study Spots --");
        SSSection.add(studySpotsLbl);
        studySpotsLbl.setHorizontalAlignment(JLabel.CENTER);

        // adding the three dropdowns of all study spots
        SSSection.add(spotPref1);
        SSSection.add(spotPref2);
        SSSection.add(spotPref3);

        editBtn.addActionListener(this);

        setVisible(true); // so the frame will show
    }

    @Override
    public void build() {

    }

    public static void main(String[] args) {
        ProfileUI profileUI = new ProfileUI();
        profileUI.build();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // if user wants to start editing
        if (editBtn.getText().equals("Edit")) {
            // turns page into edit mode
            editBtn.setText("Save");
            nameTF.setEditable(true);
            pronounTF.setEditable(true);
        }
        // if user finishes editing
        else {
            // turns page into view mode
            editBtn.setText("Edit");
            nameTF.setEditable(false);
            pronounTF.setEditable(false);

            // the list of the user's study styles
            ArrayList<String> personalStudyStyles = new ArrayList<String>();
            personalStudyStyles.add((String) style1.getSelectedItem());
            personalStudyStyles.add((String) style2.getSelectedItem());
            personalStudyStyles.add((String) style3.getSelectedItem());

            // the list of user's field of study preferences for their SB
            ArrayList<String> fieldPref = new ArrayList<>();
            fieldPref.add((String) fieldPref1.getSelectedItem());
            fieldPref.add((String) fieldPref2.getSelectedItem());
            fieldPref.add((String) fieldPref3.getSelectedItem());

            // the list of user's study style preferences for their SB
            ArrayList<String> stylePref = new ArrayList<String>();
            stylePref.add((String) stylePref1.getSelectedItem());
            stylePref.add((String) stylePref2.getSelectedItem());
            stylePref.add((String) stylePref3.getSelectedItem());

            // the hashmap of user's SB preferences, including the preferred year, field of study, and study styles
            HashMap<String, List<String>> studyBuddyPref = new HashMap<>();studyBuddyPref.put("year", yearPref.getSelectedValuesList());
            studyBuddyPref.put("field of study", fieldPref);
            studyBuddyPref.put("descriptions", stylePref);

            // the list of the user's preferred study spots
            ArrayList<String> spotPref = new ArrayList<>();
            spotPref.add((String) spotPref1.getSelectedItem());
            spotPref.add((String) spotPref2.getSelectedItem());
            spotPref.add((String) spotPref3.getSelectedItem());

            // creating an InModel using the input info
            ProfileInModel profileModifications = new ProfileInModel(nameTF.getText(), pronounTF.getText(), (String) yearCB.getSelectedItem(), (String) fieldCB.getSelectedItem(), personalStudyStyles, studyBuddyPref, spotPref);
        }
    }


}