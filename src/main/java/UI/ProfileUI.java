package UI;


import profile.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProfileUI extends JFrame implements ActionListener, ViewModel {
//    Container container = getContentPane();
    JButton editBtn = new JButton("Edit Name and/or Pronouns"); // the edit/save button
    JLabel nameLbl = new JLabel("Name"); // the name label
    JTextField nameTF = new JTextField("N/A", 20); // the textfield where the user type their name; default value is "N/A"
    JLabel pronounLbl = new JLabel("Preferred pronouns"); // the preferred pronouns label
    JTextField pronounTF = new JTextField("N/A", 20); // the textfield where the user type their preferred pronouns; default value is "N/A"
    JLabel yearLbl = new JLabel("Year"); // the year label
    JComboBox<String> yearCB = new JComboBox<>(Profile.YEARS); // the dropdown where the user choose their year in university; NEED TO FIGURE OUT DEFAULT SELECTION
    JLabel fieldLbl = new JLabel("Field of study"); // the field of study label
    JComboBox<String> fieldCB = new JComboBox<>(Profile.FIELDS); // the dropdown where the user choose their field of study; NEED TO FIGURE OUT DEFAULT SELECTION

    // the dropdowns where user pick up to three study styles for themselves
    JComboBox<String > style1 = new JComboBox<>(Profile.STYLES);
    JComboBox<String > style2 = new JComboBox<>(Profile.STYLES);
    JComboBox<String > style3 = new JComboBox<>(Profile.STYLES);
    JList<String > yearPref = new JList<>(Profile.YEARS); // the multiple selection list where user pick preferred year for their ideal study buddy

    // the dropdowns where the user pick up to three field of study for their ideal study buddy
    JComboBox<String > fieldPref1 = new JComboBox<>(Profile.FIELDS);
    JComboBox<String > fieldPref2 = new JComboBox<>(Profile.FIELDS);
    JComboBox<String > fieldPref3 = new JComboBox<>(Profile.FIELDS);

    // the dropdowns where the user pick up to three study styles for their ideal study buddy
    JComboBox<String > stylePref1 = new JComboBox<>(Profile.STYLES);
    JComboBox<String > stylePref2 = new JComboBox<>(Profile.STYLES);
    JComboBox<String > stylePref3 = new JComboBox<>(Profile.STYLES);

    // the dropdowns where the user pick up to three study spots they prefer
    JComboBox<String > spotPref1 = new JComboBox<>(Profile.studySpots);
    JComboBox<String > spotPref2 = new JComboBox<>(Profile.studySpots);
    JComboBox<String > spotPref3 = new JComboBox<>(Profile.studySpots);

    JPanel SSSection = new JPanel(new FlowLayout()); // the study spot preferences section

    public ProfileUI() {
        super("Profile"); // add title to the frame
        setMinimumSize(new Dimension(400, 800));
        getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints constraints0 = new GridBagConstraints();
        constraints0.anchor = GridBagConstraints.WEST;
        constraints0.insets = new Insets(10, 10, 10, 10);

        // set up personal info section with GridBagLayout manager
        JPanel personalInfoSection = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints0.gridx = 0;
        constraints0.gridy = 0;
        getContentPane().add(personalInfoSection, constraints0); // add panel to the frame


        // adding all components
        // name
        constraints.gridx = 0;
        constraints.gridy = 0;
        personalInfoSection.add(nameLbl, constraints);
        nameTF.setEditable(false);
        nameTF.setSize(20, 2);
        constraints.gridx = 1;
        personalInfoSection.add(nameTF, constraints);

        // edit/save button in the upper right corner
        constraints.gridx = 2;
        personalInfoSection.add(editBtn, constraints);
        editBtn.addActionListener(this);

        // pronouns
        constraints.gridx = 0;
        constraints.gridy = 1;
        personalInfoSection.add(pronounLbl, constraints);
        pronounTF.setEditable(false);
        constraints.gridx = 1;
        personalInfoSection.add(pronounTF, constraints);

        // year in uni
        constraints.gridx = 0;
        constraints.gridy = 2;
        personalInfoSection.add(yearLbl, constraints);
        constraints.gridx = 1;
        yearCB.addActionListener(this);
        personalInfoSection.add(yearCB, constraints);

        // field of study (single selection)
        constraints.gridx = 0;
        constraints.gridy = 3;
        personalInfoSection.add(fieldLbl, constraints);
        constraints.gridx = 1;
        personalInfoSection.add(fieldCB, constraints);

        // study styles (up to 3 selections)
        constraints.gridx = 0;
        constraints.gridy = 4;
        JLabel styleLbl = new JLabel("Study styles");
        personalInfoSection.add(styleLbl, constraints);
        constraints.gridx = 0;
        constraints.gridy = 5;
        personalInfoSection.add(style1, constraints);
        constraints.gridx = 1;
        personalInfoSection.add(style2, constraints);
        constraints.gridx = 2;
        personalInfoSection.add(style3, constraints);

        // section title
        personalInfoSection.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Personal Information"));


        // set up the Study Buddy Preferences section with GridBagLayout manager
        JPanel SBSection = new JPanel(new GridBagLayout());
        GridBagConstraints constraints2 = new GridBagConstraints();
        constraints2.anchor = GridBagConstraints.WEST;
        constraints2.insets = new Insets(10, 10, 10, 10);
        constraints0.gridy = 1;
        constraints0.gridx = 0;
        getContentPane().add(SBSection, constraints0);

        // section title
        SBSection.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Study Buddy Preferences"));

        // year pref (multiple selection, can select all)
        constraints2.gridx = 0;
        constraints2.gridy = 0;
        JLabel yearPrefLbl = new JLabel("Preferred study buddy year");
        SBSection.add(yearPrefLbl, constraints2);
        yearPref.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        constraints2.gridx = 1;
        SBSection.add(yearPref, constraints2);

        // field of study pref (up to 3 selections)
        constraints2.gridx = 0;
        constraints2.gridy = 1;
        JLabel fieldPrefLbl = new JLabel("Preferred study buddy field of study");
        SBSection.add(fieldPrefLbl, constraints2);
        constraints2.gridy = 2; // new row
        constraints2.gridx = 0;
        SBSection.add(fieldPref1, constraints2);
        constraints2.gridx = 1;
        SBSection.add(fieldPref2, constraints2);
        constraints2.gridx = 2;
        SBSection.add(fieldPref3, constraints2);

        // study styles pref (up to 3 selections)
        constraints2.gridx = 0;
        constraints2.gridy = 3;
        JLabel stylesLbl = new JLabel("Preferred study buddy study styles");
        SBSection.add(stylesLbl, constraints2);
        constraints2.gridy = 4; // new row
        constraints2.gridx = 0;
        SBSection.add(stylePref1, constraints2);
        constraints2.gridx = 1;
        SBSection.add(stylePref2, constraints2);
        constraints2.gridx = 2;
        SBSection.add(stylePref3, constraints2);

        // set up the Study Spots Preferences section with GridBagLayout manager
        JPanel SSSection = new JPanel(new GridBagLayout());
        GridBagConstraints constraints3 = new GridBagConstraints();
        constraints3.anchor = GridBagConstraints.WEST;
        constraints3.insets = new Insets(10, 10, 10, 10);
        constraints0.gridy = 2;
        getContentPane().add(SSSection, constraints0);

        // section title
        SSSection.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Preferred Study Spots"));

        // adding the three dropdowns of all study spots
        constraints3.gridx = 0;
        constraints3.gridy = 0;
        SSSection.add(spotPref1, constraints3);
        constraints3.gridx = 1;
        SSSection.add(spotPref2, constraints3);
        constraints3.gridx = 2;
        SSSection.add(spotPref3, constraints3);

        pack();
        setVisible(true); // so the frame will show
    }

    public void changeSuccessMechanism() {
        JOptionPane.showMessageDialog(this, "Change successful.");
    }

    @Override
    public void build() {

    }

    public static void main(String[] args) {
        ProfileUI profileUI = new ProfileUI();
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
        // if user does an edit or finishes editing
        else {
            if (e.getSource().equals(editBtn)) {
                // turns name & pronoun fields into view-only mode
                editBtn.setText("Edit");
                nameTF.setEditable(false);
                pronounTF.setEditable(false);
            }

            // the list of the user's study styles
            ArrayList<String> personalStudyStyles = new ArrayList<>();
            personalStudyStyles.add((String) style1.getSelectedItem());
            personalStudyStyles.add((String) style2.getSelectedItem());
            personalStudyStyles.add((String) style3.getSelectedItem());

            // the list of user's field of study preferences for their SB
            ArrayList<String> fieldPref = new ArrayList<>();
            fieldPref.add((String) fieldPref1.getSelectedItem());
            fieldPref.add((String) fieldPref2.getSelectedItem());
            fieldPref.add((String) fieldPref3.getSelectedItem());

            // the list of user's study style preferences for their SB
            ArrayList<String> stylePref = new ArrayList<>();
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

            // creating use case object
//            ProfileEditUseCase profileUseCase = new ProfileEditUseCase(profileModifications);

//            ProfilePresenter profilePresenter = new ProfilePresenter(new ProfileOutModel(profileModifications));
            // creating controller object
//            ProfileController profileController = new ProfileController(new ProfileEditUseCase(new ProfilePresenter()));
        }
    }


}