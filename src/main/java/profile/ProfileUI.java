package profile;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static javax.swing.JOptionPane.*;
import static main_app.StudyBuddyApp.currUserProfile;
import static main_app.StudyBuddyApp.profileController;


public class ProfileUI extends JInternalFrame implements ActionListener {

    JButton editBtn = new JButton("Edit"); // the edit/save button
    JLabel nameLbl = new JLabel("Name"); // the name label
    JTextField nameTF = new JTextField(currUserProfile.getName(), 20); // the textfield where the user type their name; default value is "N/A"
    JLabel pronounLbl = new JLabel("Preferred pronouns"); // the preferred pronouns label
    JTextField pronounTF = new JTextField(currUserProfile.getPronouns(), 20); // the textfield where the user type their preferred pronouns; default value is "N/A"
    JLabel yearLbl = new JLabel("Year"); // the year label
    JComboBox<String> yearCB = new JComboBox<>(Profile.YEARS); // the dropdown where the user choose their year in university; NEED TO FIGURE OUT DEFAULT SELECTION
    JLabel fieldLbl = new JLabel("Field of study"); // the field of study label
    JComboBox<String> fieldCB = new JComboBox<>(Profile.FIELDS); // the dropdown where the user choose their field of study; NEED TO FIGURE OUT DEFAULT SELECTION

    // the dropdowns where user pick up to three study styles for themselves
    JComboBox<String> style1 = new JComboBox<>(Profile.STYLES);
    JComboBox<String> style2 = new JComboBox<>(Profile.STYLES);
    JComboBox<String> style3 = new JComboBox<>(Profile.STYLES);

    JList<String> yearPref = new JList<>(Profile.YEARS); // the multiple selection list where user pick preferred year for their ideal study buddy

    // the dropdowns where the user pick up to three field of study for their ideal study buddy
    JComboBox<String> fieldPref1 = new JComboBox<>(Profile.FIELDS);
    JComboBox<String> fieldPref2 = new JComboBox<>(Profile.FIELDS);
    JComboBox<String> fieldPref3 = new JComboBox<>(Profile.FIELDS);

    // the dropdowns where the user pick up to three study styles for their ideal study buddy
    JComboBox<String> stylePref1 = new JComboBox<>(Profile.STYLES);
    JComboBox<String> stylePref2 = new JComboBox<>(Profile.STYLES);
    JComboBox<String> stylePref3 = new JComboBox<>(Profile.STYLES);

    // the dropdowns where the user pick up to three study spots they prefer
    JComboBox<String> spotPref1 = new JComboBox<>(Profile.STUDY_SPOTS);
    JComboBox<String> spotPref2 = new JComboBox<>(Profile.STUDY_SPOTS);
    JComboBox<String> spotPref3 = new JComboBox<>(Profile.STUDY_SPOTS);

    /**
     * Construct a ProfileUI based on the user currently logged in using information from the UserDatabase.
     */
    public ProfileUI() {
        // add title to the frame
        super("Profile");
        // set minimum size of frame
        setMinimumSize(new Dimension(400, 800));
        // set up GridBagLayout
        getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints constraints0 = new GridBagConstraints();
        constraints0.anchor = GridBagConstraints.WEST;
        constraints0.insets = new Insets(10, 10, 10, 10);

        // edit/save button in the upper right corner
        constraints0.gridx = 1;
        constraints0.gridy = 0;
        add(editBtn, constraints0);
        editBtn.addActionListener(this);

        // add personal info section
        constraints0.gridx = 0;
        constraints0.gridy = 1;
        addPersonalInfoSection(constraints0);

        // add study buddy preferences section
        constraints0.gridy += 1;
        addStudyBuddyPrefSection(constraints0);

        // add study spots preferences section
        constraints0.gridy += 1;
        addStudySpotsPrefSection(constraints0);

        pack(); // make sure all layouts are applied
        setVisible(true); // so the frame will show
    }

    private void addStudySpotsPrefSection(GridBagConstraints constraints0) {
        // set up the Study Spots Preferences section with GridBagLayout manager
        JPanel studySpotSection = new JPanel(new GridBagLayout());
        GridBagConstraints constraints3 = new GridBagConstraints();
        constraints3.anchor = GridBagConstraints.WEST;
        constraints3.insets = new Insets(10, 10, 10, 10);

        // section title
        studySpotSection.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Preferred Study Spots"));

        // adding the three dropdowns of all study spots
        constraints3.gridx = 0;
        constraints3.gridy = 0;
        addSpotPrefField(studySpotSection, constraints3);

        getContentPane().add(studySpotSection, constraints0);

    }

    private void addSpotPrefField(JPanel studySpotSection, GridBagConstraints constraints3) {
        if (!currUserProfile.getStudySpotPreferences().isEmpty()) {
            if (currUserProfile.getStudySpotPreferences().size() >= 1) {
                spotPref1.setSelectedItem(currUserProfile.getStudySpotPreferences().get(0));
            }
            if (currUserProfile.getStudySpotPreferences().size() >= 2) {
                spotPref2.setSelectedItem(currUserProfile.getStudySpotPreferences().get(1));
            }
            if (currUserProfile.getStudySpotPreferences().size() >= 3) {
                spotPref3.setSelectedItem(currUserProfile.getStudySpotPreferences().get(2));
            }
        }
        spotPref1.setEnabled(false);
        spotPref2.setEnabled(false);
        spotPref3.setEnabled(false);
        studySpotSection.add(spotPref1, constraints3);
        constraints3.gridx += 1;
        studySpotSection.add(spotPref2, constraints3);
        constraints3.gridx += 1;
        studySpotSection.add(spotPref3, constraints3);
    }

    private void addStudyStylesPrefField(JPanel studyBuddySection, GridBagConstraints constraints2) {
        constraints2.gridx = 0;
        constraints2.gridy += 1;
        JLabel stylesLbl = new JLabel("Preferred study buddy study styles");
        studyBuddySection.add(stylesLbl, constraints2);
        constraints2.gridy += 1; // new row
        if (!currUserProfile.getStudyBuddyPreferences().get("descriptions").isEmpty()) {
            if (currUserProfile.getStudyBuddyPreferences().get("descriptions").size() >= 1) {
                stylePref1.setSelectedItem(currUserProfile.getStudyBuddyPreferences().get("descriptions").get(0));
            }
            if (currUserProfile.getStudyBuddyPreferences().get("descriptions").size() >= 2) {
                stylePref2.setSelectedItem(currUserProfile.getStudyBuddyPreferences().get("descriptions").get(1));
            }
            if (currUserProfile.getStudyBuddyPreferences().get("descriptions").size() >= 3) {
                stylePref3.setSelectedItem(currUserProfile.getStudyBuddyPreferences().get("descriptions").get(2));
            }
        }
        stylePref1.setEnabled(false);
        stylePref2.setEnabled(false);
        stylePref3.setEnabled(false);
        studyBuddySection.add(stylePref1, constraints2);
        constraints2.gridx += 1;
        studyBuddySection.add(stylePref2, constraints2);
        constraints2.gridx += 1;
        studyBuddySection.add(stylePref3, constraints2);
    }

    private void addFieldOfStudyPrefField(JPanel studyBuddySection, GridBagConstraints constraints2) {
        constraints2.gridx = 0;
        constraints2.gridy += 1;
        JLabel fieldPrefLbl = new JLabel("Preferred study buddy field of study");
        studyBuddySection.add(fieldPrefLbl, constraints2);
        if (!currUserProfile.getStudyBuddyPreferences().get("field of study").isEmpty()) {
            if (currUserProfile.getStudyBuddyPreferences().get("field of study").size() >= 1) {
                fieldPref1.setSelectedItem(currUserProfile.getStudyBuddyPreferences().get("field of study").get(0));
            }
            if (currUserProfile.getStudyBuddyPreferences().get("field of study").size() >= 2) {
                fieldPref2.setSelectedItem(currUserProfile.getStudyBuddyPreferences().get("field of study").get(1));
            }
            if (currUserProfile.getStudyBuddyPreferences().get("field of study").size() >= 3) {
                fieldPref3.setSelectedItem(currUserProfile.getStudyBuddyPreferences().get("field of study").get(2));
            }
        }
        fieldPref1.setEnabled(false);
        fieldPref2.setEnabled(false);
        fieldPref3.setEnabled(false);
        constraints2.gridy += 1; // new row
        studyBuddySection.add(fieldPref1, constraints2);
        constraints2.gridx += 1;
        studyBuddySection.add(fieldPref2, constraints2);
        constraints2.gridx += 1;
        studyBuddySection.add(fieldPref3, constraints2);
    }

    private void addYearPrefField(JPanel studyBuddySection, GridBagConstraints constraints2) {
        JLabel yearPrefLbl = new JLabel("Preferred study buddy year (Hold the Ctrl or Command key and click to select more than 1)");
        studyBuddySection.add(yearPrefLbl, constraints2);
        yearPref.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        if (!currUserProfile.getStudyBuddyPreferences().get("year").isEmpty()) {
            for (String year : currUserProfile.getStudyBuddyPreferences().get("year")) {
                yearPref.setSelectedValue(year, true);
            }
        }
        yearPref.setEnabled(false);
        constraints2.gridx += 1;
        studyBuddySection.add(yearPref, constraints2);
    }

    private void addStudyBuddyPrefSection(GridBagConstraints constraints0) {
        // set up with GridBagLayout manager
        JPanel studyBuddySection = new JPanel(new GridBagLayout());
        GridBagConstraints constraints2 = new GridBagConstraints();
        constraints2.anchor = GridBagConstraints.WEST;
        constraints2.insets = new Insets(10, 10, 10, 10);

        // section title
        studyBuddySection.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Study Buddy Preferences"));

        // year pref (multiple selection, can select all)
        constraints2.gridx = 0;
        constraints2.gridy = 0;
        addYearPrefField(studyBuddySection, constraints2);

        // field of study pref (up to 3 selections)
        addFieldOfStudyPrefField(studyBuddySection, constraints2);

        // study styles pref (up to 3 selections)
        addStudyStylesPrefField(studyBuddySection, constraints2);

        // add panel to the frame
        getContentPane().add(studyBuddySection, constraints0);
    }

    private void addPersonalInfoSection(GridBagConstraints constraints0) {
        // set up with GridBagLayout manager
        JPanel personalInfoSection = new JPanel(new GridBagLayout());
        GridBagConstraints constraints1 = new GridBagConstraints();
        constraints1.anchor = GridBagConstraints.WEST;
        constraints1.insets = new Insets(10, 10, 10, 10);

        // section title
        personalInfoSection.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Personal Information"));

        // name
        constraints1.gridx = 0;
        constraints1.gridy = 0;
        addNameField(personalInfoSection, constraints1);

        // pronouns
        constraints1.gridx = 0;
        constraints1.gridy = 1;
        addPronounsField(personalInfoSection, constraints1);

        // year in uni
        constraints1.gridx = 0;
        constraints1.gridy = 2;
        addYearField(personalInfoSection, constraints1);

        // field of study (single selection)
        constraints1.gridx = 0;
        constraints1.gridy = 3;
        addFieldOfStudyField(personalInfoSection, constraints1);

        // study styles (up to 3 selections)
        constraints1.gridx = 0;
        constraints1.gridy = 4;
        addStudyStylesField(personalInfoSection, constraints1);

        // add panel to the frame
        getContentPane().add(personalInfoSection, constraints0);

    }

    private void addStudyStylesField(JPanel personalInfoSection, GridBagConstraints constraints) {
        JLabel styleLbl = new JLabel("Study styles");
        personalInfoSection.add(styleLbl, constraints);
        constraints.gridy += 1;
        if (!currUserProfile.getStudyStyles().isEmpty()) {
            if (currUserProfile.getStudyStyles().size() >= 1) {
                style1.setSelectedItem(currUserProfile.getStudyStyles().get(0));
            }
            if (currUserProfile.getStudyStyles().size() >= 2) {
                style2.setSelectedItem(currUserProfile.getStudyStyles().get(1));
            }
            if (currUserProfile.getStudyStyles().size() == 3) {
                style3.setSelectedItem(currUserProfile.getStudyStyles().get(2));
            }
        }
        style1.setEnabled(false);
        style2.setEnabled(false);
        style3.setEnabled(false);
        personalInfoSection.add(style1, constraints);
        constraints.gridx += 1;
        personalInfoSection.add(style2, constraints);
        constraints.gridx += 1;
        personalInfoSection.add(style3, constraints);
    }

    private void addFieldOfStudyField(JPanel personalInfoSection, GridBagConstraints constraints) {
        personalInfoSection.add(fieldLbl, constraints);
        constraints.gridx += 1;
        if (!currUserProfile.getFieldOfStudy().equals("N/A")) {
            fieldCB.setSelectedItem(currUserProfile.getFieldOfStudy());
        }
        fieldCB.setEnabled(false);
        personalInfoSection.add(fieldCB, constraints);
    }

    private void addYearField(JPanel personalInfoSection, GridBagConstraints constraints) {
        personalInfoSection.add(yearLbl, constraints);
        constraints.gridx += 1;
        yearCB.addActionListener(this);
        if (!currUserProfile.getYear().equals("N/A")) {
            yearCB.setSelectedItem(currUserProfile.getYear());
        }
        yearCB.setEnabled(false);
        personalInfoSection.add(yearCB, constraints);
    }

    private void addPronounsField(JPanel personalInfoSection, GridBagConstraints constraints) {
        personalInfoSection.add(pronounLbl, constraints);
        pronounTF.setEditable(false);
        pronounTF.setSize(20, 2);
        constraints.gridx += 1;
        personalInfoSection.add(pronounTF, constraints);
    }

    private void addNameField(JPanel personalInfoSection, GridBagConstraints constraints) {
        personalInfoSection.add(nameLbl, constraints);
        nameTF.setEditable(false);
        nameTF.setSize(20, 2);
        constraints.gridx += 1;
        personalInfoSection.add(nameTF, constraints);
    }

    /**
     * Show a message dialogue indicating changes were successful.
     */
    public void changeSuccessDialog() {
        showMessageDialog(this, "Changes saved.");
        this.setVisible(false);
    }

    /**
     * Construct a new ProfileUI using information provided by the modifications input.
     *
     * @param modifications profile modifications
     */
    public void build(ProfileOutModel modifications) {
        nameTF.setText(modifications.getName());
        pronounTF.setText(modifications.getPronouns());
        yearCB.setSelectedItem(modifications.getYear());
        fieldCB.setSelectedItem(modifications.getFieldOfStudy());
        if (!modifications.getStudyStyles().isEmpty()) {
            if (modifications.getStudyStyles().size() >= 1) {
                style1.setSelectedItem(modifications.getStudyStyles().get(0));
            }
            if (modifications.getStudyStyles().size() >= 2) {
                style2.setSelectedItem(modifications.getStudyStyles().get(1));
            }
            if (modifications.getStudyStyles().size() >= 3) {
                style3.setSelectedItem(modifications.getStudyStyles().get(2));
            }
        }
        if (!modifications.getStudyBuddyPreferences().isEmpty()) {
            for (String year : modifications.getStudyBuddyPreferences().get("year")) {
                yearPref.setSelectedValue(year, true);
            }
            if (!modifications.getStudyBuddyPreferences().get("field of study").isEmpty()) {
                if (modifications.getStudyBuddyPreferences().get("field of study").size() >= 1) {
                    fieldPref1.setSelectedItem(modifications.getStudyBuddyPreferences().get("field of study").get(0));
                }
                if (modifications.getStudyBuddyPreferences().get("field of study").size() >= 2) {
                    fieldPref2.setSelectedItem(modifications.getStudyBuddyPreferences().get("field of study").get(1));
                }
                if (modifications.getStudyBuddyPreferences().get("field of study").size() >= 3) {
                    fieldPref3.setSelectedItem(modifications.getStudyBuddyPreferences().get("field of study").get(2));
                }
            }
            if (!modifications.getStudyBuddyPreferences().get("descriptions").isEmpty()) {
                if (modifications.getStudyBuddyPreferences().get("descriptions").size() >= 1) {
                    stylePref1.setSelectedItem(modifications.getStudyBuddyPreferences().get("descriptions").get(0));
                }
                if (modifications.getStudyBuddyPreferences().get("descriptions").size() >= 2) {
                    stylePref2.setSelectedItem(modifications.getStudyBuddyPreferences().get("descriptions").get(1));
                }
                if (modifications.getStudyBuddyPreferences().get("descriptions").size() >= 3) {
                    stylePref3.setSelectedItem(modifications.getStudyBuddyPreferences().get("descriptions").get(2));
                }
            }
        }
        if (!modifications.getStudySpotPreferences().isEmpty()) {
            if (modifications.getStudySpotPreferences().size() >= 1) {
                spotPref1.setSelectedItem(modifications.getStudySpotPreferences().get(0));
            }
            if (modifications.getStudySpotPreferences().size() >= 2) {
                spotPref2.setSelectedItem(modifications.getStudySpotPreferences().get(1));
            }
            if (modifications.getStudySpotPreferences().size() >= 3) {
                spotPref3.setSelectedItem(modifications.getStudySpotPreferences().get(2));
            }
        }
    }

    /**
     * Toggle the view/edit mode when the user clicks the Edit/Save button and send modifications to the backend when the profile is edited.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(editBtn)) {
            // if user wants to start editing
            if (editBtn.getText().equals("Edit")) {
                toggleEditMode(); // turns page into edit mode
                editBtn.setText("Save");
            }
            // if user wants to save their edits
            else {
                toggleEditMode(); // turns page into view-only mode
                editBtn.setText("Edit");

                // create the list of the user's study styles
                ArrayList<String> personalStudyStyles = new ArrayList<>();
                personalStudyStyles.add((String) style1.getSelectedItem());
                personalStudyStyles.add((String) style2.getSelectedItem());
                personalStudyStyles.add((String) style3.getSelectedItem());

                // create the list of user's field of study preferences for their SB
                ArrayList<String> fieldPref = new ArrayList<>();
                fieldPref.add((String) fieldPref1.getSelectedItem());
                fieldPref.add((String) fieldPref2.getSelectedItem());
                fieldPref.add((String) fieldPref3.getSelectedItem());

                // create the list of user's study style preferences for their SB
                ArrayList<String> stylePref = new ArrayList<>();
                stylePref.add((String) stylePref1.getSelectedItem());
                stylePref.add((String) stylePref2.getSelectedItem());
                stylePref.add((String) stylePref3.getSelectedItem());

                // create the HashMap of user's study buddy preferences, including the preferred year, field of study, and study styles
                HashMap<String, List<String>> studyBuddyPref = new HashMap<>();
                studyBuddyPref.put("year", yearPref.getSelectedValuesList());
                studyBuddyPref.put("field of study", fieldPref);
                studyBuddyPref.put("descriptions", stylePref);

                // create the list of the user's preferred study spots
                ArrayList<String> spotPref = new ArrayList<>();
                spotPref.add((String) spotPref1.getSelectedItem());
                spotPref.add((String) spotPref2.getSelectedItem());
                spotPref.add((String) spotPref3.getSelectedItem());

                // create an InModel using the input info
                ProfileInModel profileModifications = new ProfileInModel(nameTF.getText(), pronounTF.getText(), (String) yearCB.getSelectedItem(), (String) fieldCB.getSelectedItem(), personalStudyStyles, studyBuddyPref, spotPref);
                profileController.modifyProfile(profileModifications);
            }
        }
    }

    private void toggleEditMode() {
        if (editBtn.getText().equals("Save")) {
            nameTF.setEditable(false);
            pronounTF.setEditable(false);
            yearCB.setEnabled(false);
            fieldCB.setEnabled(false);
            style1.setEnabled(false);
            style2.setEnabled(false);
            style3.setEnabled(false);
            yearPref.setEnabled(false);
            fieldPref1.setEnabled(false);
            fieldPref2.setEnabled(false);
            fieldPref3.setEnabled(false);
            stylePref1.setEnabled(false);
            stylePref2.setEnabled(false);
            stylePref3.setEnabled(false);
            spotPref1.setEnabled(false);
            spotPref2.setEnabled(false);
            spotPref3.setEnabled(false);
        } else {
            nameTF.setEditable(true);
            pronounTF.setEditable(true);
            yearCB.setEnabled(true);
            fieldCB.setEnabled(true);
            style1.setEnabled(true);
            style2.setEnabled(true);
            style3.setEnabled(true);
            yearPref.setEnabled(true);
            fieldPref1.setEnabled(true);
            fieldPref2.setEnabled(true);
            fieldPref3.setEnabled(true);
            stylePref1.setEnabled(true);
            stylePref2.setEnabled(true);
            stylePref3.setEnabled(true);
            spotPref1.setEnabled(true);
            spotPref2.setEnabled(true);
            spotPref3.setEnabled(true);
        }
    }
}