import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GymGUI extends JFrame {
    // Main components
    private JTabbedPane tabbedPane;
    private JPanel regularPanel, premiumPanel;
    
    // Common text fields
    private JTextField idField, nameField, locationField, phoneField, emailField;
    private JRadioButton maleRadio, femaleRadio;
    
    // Date components
    private JComboBox<String> dobDayCombo, dobMonthCombo, dobYearCombo;
    private JComboBox<String> startDayCombo, startMonthCombo, startYearCombo;
    
    // Regular member components
    private JTextField referralField;
    private JTextField activateRegIdField, deactivateRegIdField, attendRegIdField, displayRegIdField;
    private JTextField upgradeRegIdField;
    private JComboBox<String> planCombo;
    
    // Premium member components
    private JTextField trainerField;
    private JTextField activatePremIdField, deactivatePremIdField, attendPremIdField, displayPremIdField;
    private JTextField discountPremIdField, paymentPremIdField, paymentAmountField;
    
    // Data storage
    private List<GymMember> members = new ArrayList<>();
    
    public GymGUI() {
        setTitle("GymGUI");
        setSize(700, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        tabbedPane = new JTabbedPane();
        
        createRegularPanel();
        createPremiumPanel();
        
        tabbedPane.addTab("Regular Member", regularPanel);
        tabbedPane.addTab("Premium Member", premiumPanel);
        
        add(tabbedPane, BorderLayout.CENTER);
    }
    public static void main(String[] args) {
    // Use SwingUtilities.invokeLater to ensure GUI creation happens on the Event Dispatch Thread
    SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            GymGUI gui = new GymGUI();
            gui.setLocationRelativeTo(null);  // Center the window on the screen
            gui.setVisible(true);  // Make the GUI visible
        }
    });
    
}
    private void revertFields() {
    // Clear all input fields 
    idField.setText("");
    nameField.setText("");
    locationField.setText("");
    phoneField.setText("");
    emailField.setText("");
    maleRadio.setSelected(true);
    dobDayCombo.setSelectedIndex(0);
    dobMonthCombo.setSelectedIndex(0);
    dobYearCombo.setSelectedIndex(0);
    startDayCombo.setSelectedIndex(0);
    startMonthCombo.setSelectedIndex(0);
    startYearCombo.setSelectedIndex(0);
    referralField.setText("");
    trainerField.setText("");
    
    // You might want to add a confirmation message
    JOptionPane.showMessageDialog(this, "Form reverted to default state");
}
    private void createRegularPanel() {
        
        regularPanel = new JPanel();
        regularPanel.setLayout(null); // Using null layout for absolute positioning
        // Common fields
        addCommonFields(regularPanel);
        
        // Regular-specific fields
        JLabel referralLabel = new JLabel("Referral Source");
        referralLabel.setBounds(430, 210, 100, 25);
        regularPanel.add(referralLabel);
        
        referralField = new JTextField();
        referralField.setBounds(540, 210, 120, 25);
        regularPanel.add(referralField);
        
        // Add Regular Member button
        JButton addRegularButton = new JButton("Add Regular Member");
        addRegularButton.setBounds(160, 320, 180, 40);
        addRegularButton.addActionListener(e -> addRegularMember());
        regularPanel.add(addRegularButton);
        
        // Revert Regular Member button
        JButton revertRegularButton = new JButton("Revert Regular Member");
        revertRegularButton.setBounds(570, 320, 180, 40);
        revertRegularButton.addActionListener(e -> revertFields());
        regularPanel.add(revertRegularButton);
        
        // Activate section
        activateRegIdField = new JTextField();
        activateRegIdField.setBounds(200, 380, 80, 25);
        regularPanel.add(activateRegIdField);
        
        JLabel activateIdLabel = new JLabel("ID");
        activateIdLabel.setBounds(160, 380, 30, 25);
        regularPanel.add(activateIdLabel);
        
        JButton activateButton = new JButton("Activate");
        activateButton.setBounds(350, 380, 100, 40);
        activateButton.addActionListener(e -> activateMembership(activateRegIdField.getText()));
        regularPanel.add(activateButton);
        
        // Deactivate section
        deactivateRegIdField = new JTextField();
        deactivateRegIdField.setBounds(200, 440, 80, 25);
        regularPanel.add(deactivateRegIdField);
        
        JLabel deactivateIdLabel = new JLabel("ID");
        deactivateIdLabel.setBounds(160, 440, 30, 25);
        regularPanel.add(deactivateIdLabel);
        
        JButton deactivateButton = new JButton("De Activate");
        deactivateButton.setBounds(350, 440, 100, 40);
        deactivateButton.addActionListener(e -> deactivateMembership(deactivateRegIdField.getText()));
        regularPanel.add(deactivateButton);
        
        // Mark Attendance section
        attendRegIdField = new JTextField();
        attendRegIdField.setBounds(200, 500, 80, 25);
        regularPanel.add(attendRegIdField);
        
        JLabel attendIdLabel = new JLabel("ID");
        attendIdLabel.setBounds(160, 500, 30, 25);
        regularPanel.add(attendIdLabel);
        
        JButton attendButton = new JButton("Mark Attendance");
        attendButton.setBounds(350, 500, 150, 40);
        attendButton.addActionListener(e -> markAttendance(attendRegIdField.getText()));
        regularPanel.add(attendButton);
        
        // Display button
        displayRegIdField = new JTextField();
        displayRegIdField.setBounds(200, 560, 80, 25);
        regularPanel.add(displayRegIdField);
        
        JLabel displayIdLabel = new JLabel("ID");
        displayIdLabel.setBounds(160, 560, 30, 25);
        regularPanel.add(displayIdLabel);
        
        JButton displayButton = new JButton("Display");
        displayButton.setBounds(570, 500, 100, 40);
        displayButton.addActionListener(e -> displayMember(displayRegIdField.getText()));
        regularPanel.add(displayButton);
        
        // Clear button
        JButton clearButton = new JButton("Clear");
        clearButton.setBounds(570, 560, 100, 40);
        clearButton.addActionListener(e -> revertFields());
        regularPanel.add(clearButton);
        
        // Upgrade Plan section
        upgradeRegIdField = new JTextField();
        upgradeRegIdField.setBounds(200, 620, 80, 25);
        regularPanel.add(upgradeRegIdField);
        
        JLabel upgradeIdLabel = new JLabel("ID");
        upgradeIdLabel.setBounds(160, 620, 30, 25);
        regularPanel.add(upgradeIdLabel);
        
        JLabel planLabel = new JLabel("Plan");
        planLabel.setBounds(300, 620, 40, 25);
        regularPanel.add(planLabel);
        
        planCombo = new JComboBox<>(new String[]{"Basic", "Standard", "Deluxe"});
        planCombo.setBounds(350, 620, 100, 25);
        regularPanel.add(planCombo);
        
        JButton upgradeButton = new JButton("Upgrade Plan");
        upgradeButton.setBounds(570, 620, 120, 40);
        upgradeButton.addActionListener(e -> upgradePlan(upgradeRegIdField.getText()));
        regularPanel.add(upgradeButton);
        
        // File operations
        JButton saveButton = new JButton("Save to File");
        saveButton.setBounds(160, 680, 120, 40);
        saveButton.addActionListener(e -> saveToFile());
        regularPanel.add(saveButton);
        
        JButton readButton = new JButton("Read from File");
        readButton.setBounds(350, 680, 120, 40);
        readButton.addActionListener(e -> readFromFile());
        regularPanel.add(readButton);
        
        JButton changeToPremiumButton = new JButton("Change to Premium Member");
        changeToPremiumButton.setBounds(480, 680, 200, 40);
        changeToPremiumButton.addActionListener(e -> tabbedPane.setSelectedIndex(1));
        regularPanel.add(changeToPremiumButton);
    }
    
    private void createPremiumPanel() {
        premiumPanel = new JPanel();
        premiumPanel.setLayout(null); // Using null layout for absolute positioning
        
        // Common fields
        addCommonFields(premiumPanel);
        
        // Premium-specific fields
        JLabel trainerLabel = new JLabel("Personal Trainer");
        trainerLabel.setBounds(430, 210, 100, 25);
        premiumPanel.add(trainerLabel);
        
        trainerField = new JTextField();
        trainerField.setBounds(540, 210, 120, 25);
        premiumPanel.add(trainerField);
        
        // Add Premium Member button
        JButton addPremiumButton = new JButton("Add Premium Member");
        addPremiumButton.setBounds(160, 320, 180, 40);
        addPremiumButton.addActionListener(e -> addPremiumMember());
        premiumPanel.add(addPremiumButton);
        
        // Revert Premium Member button
        JButton revertPremiumButton = new JButton("Revert Premium Member");
        revertPremiumButton.setBounds(570, 320, 180, 40);
        revertPremiumButton.addActionListener(e -> revertFields());
        premiumPanel.add(revertPremiumButton);
        
        // Activate/Deactivate row
        activatePremIdField = new JTextField();
        activatePremIdField.setBounds(200, 380, 80, 25);
        premiumPanel.add(activatePremIdField);
        
        JLabel activateIdLabel = new JLabel("ID");
        activateIdLabel.setBounds(160, 380, 30, 25);
        premiumPanel.add(activateIdLabel);
        
        JButton activateButton = new JButton("Activate");
        activateButton.setBounds(300, 380, 100, 40);
        activateButton.addActionListener(e -> activateMembership(activatePremIdField.getText()));
        premiumPanel.add(activateButton);
        
        JButton deactivateButton = new JButton("De Activate");
        deactivateButton.setBounds(430, 380, 100, 40);
        deactivateButton.addActionListener(e -> deactivateMembership(activatePremIdField.getText()));
        premiumPanel.add(deactivateButton);
        
        // Mark Attendance row
        attendPremIdField = new JTextField();
        attendPremIdField.setBounds(200, 440, 80, 25);
        premiumPanel.add(attendPremIdField);
        
        JLabel attendIdLabel = new JLabel("ID");
        attendIdLabel.setBounds(160, 440, 30, 25);
        premiumPanel.add(attendIdLabel);
        
        JButton attendButton = new JButton("Mark Attendance");
        attendButton.setBounds(300, 440, 150, 40);
        attendButton.addActionListener(e -> markAttendance(attendPremIdField.getText()));
        premiumPanel.add(attendButton);
        
        JButton displayButton = new JButton("Display");
        displayButton.setBounds(570, 440, 100, 40);
        displayButton.addActionListener(e -> displayMember(activatePremIdField.getText()));
        premiumPanel.add(displayButton);
        
        // Calculate Discount row
        discountPremIdField = new JTextField();
        discountPremIdField.setBounds(200, 500, 80, 25);
        premiumPanel.add(discountPremIdField);
        
        JLabel discountIdLabel = new JLabel("ID");
        discountIdLabel.setBounds(160, 500, 30, 25);
        premiumPanel.add(discountIdLabel);
        
        JButton discountButton = new JButton("Calculate Discount");
        discountButton.setBounds(300, 500, 150, 40);
        discountButton.addActionListener(e -> calculateDiscount(discountPremIdField.getText()));
        premiumPanel.add(discountButton);
        
        JButton clearButton = new JButton("Clear");
        clearButton.setBounds(570, 500, 100, 40);
        clearButton.addActionListener(e -> revertFields());
        premiumPanel.add(clearButton);
        
        // Pay Due Amount row
        paymentPremIdField = new JTextField();
        paymentPremIdField.setBounds(200, 560, 80, 25);
        premiumPanel.add(paymentPremIdField);
        
        JLabel paymentIdLabel = new JLabel("ID");
        paymentIdLabel.setBounds(160, 560, 30, 25);
        premiumPanel.add(paymentIdLabel);
        
        JLabel amountLabel = new JLabel("Amount");
        amountLabel.setBounds(300, 560, 50, 25);
        premiumPanel.add(amountLabel);
        
        paymentAmountField = new JTextField();
        paymentAmountField.setBounds(360, 560, 80, 25);
        premiumPanel.add(paymentAmountField);
        
        JButton payButton = new JButton("Pay Due Amount");
        payButton.setBounds(570, 560, 150, 40);
        payButton.addActionListener(e -> payDueAmount(paymentPremIdField.getText()));
        premiumPanel.add(payButton);
        
        // File operations
        JButton saveButton = new JButton("Save to File");
        saveButton.setBounds(160, 620, 120, 40);
        saveButton.addActionListener(e -> saveToFile());
        premiumPanel.add(saveButton);
        
        JButton readButton = new JButton("Read from File");
        readButton.setBounds(350, 620, 120, 40);
        readButton.addActionListener(e -> readFromFile());
        premiumPanel.add(readButton);
        
        JButton changeToRegularButton = new JButton("Change to Regular Member");
        changeToRegularButton.setBounds(480, 620, 200, 40);
        changeToRegularButton.addActionListener(e -> tabbedPane.setSelectedIndex(0));
        premiumPanel.add(changeToRegularButton);
    }
    
    private void addCommonFields(JPanel panel) {
        // ID field
        JLabel idLabel = new JLabel("ID");
        idLabel.setBounds(50, 50, 100, 25);
        panel.add(idLabel);
        
        idField = new JTextField();
        idField.setBounds(150, 50, 120, 25);
        panel.add(idField);
        
        // Name field
        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(430, 50, 100, 25);
        panel.add(nameLabel);
        
        nameField = new JTextField();
        nameField.setBounds(540, 50, 120, 25);
        panel.add(nameField);
        
        // Location field
        JLabel locationLabel = new JLabel("Location");
        locationLabel.setBounds(50, 90, 100, 25);
        panel.add(locationLabel);
        
        locationField = new JTextField();
        locationField.setBounds(150, 90, 120, 25);
        panel.add(locationField);
        
        // Phone field
        JLabel phoneLabel = new JLabel("Phone");
        phoneLabel.setBounds(430, 90, 100, 25);
        panel.add(phoneLabel);
        
        phoneField = new JTextField();
        phoneField.setBounds(540, 90, 120, 25);
        panel.add(phoneField);
        
        // Email field
        JLabel emailLabel = new JLabel("Email");
        emailLabel.setBounds(50, 130, 100, 25);
        panel.add(emailLabel);
        
        emailField = new JTextField();
        emailField.setBounds(150, 130, 220, 25);
        panel.add(emailField);
        
        // Gender field
        JLabel genderLabel = new JLabel("Gender");
        genderLabel.setBounds(430, 130, 100, 25);
        panel.add(genderLabel);
        
        maleRadio = new JRadioButton("Male");
        maleRadio.setBounds(540, 130, 60, 25);
        maleRadio.setSelected(true);
        panel.add(maleRadio);
        
        femaleRadio = new JRadioButton("Female");
        femaleRadio.setBounds(610, 130, 80, 25);
        panel.add(femaleRadio);
        
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);
        
        // DOB field
        JLabel dobLabel = new JLabel("DOB");
        dobLabel.setBounds(50, 170, 100, 25);
        panel.add(dobLabel);
        
        // Day, Month, Year dropdowns for DOB
        String[] days = new String[31];
        for (int i = 0; i < 31; i++) {
            days[i] = String.valueOf(i + 1);
        }
        dobDayCombo = new JComboBox<>(days);
        dobDayCombo.setBounds(150, 170, 60, 25);
        panel.add(dobDayCombo);
        
        String[] months = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        dobMonthCombo = new JComboBox<>(months);
        dobMonthCombo.setBounds(220, 170, 70, 25);
        panel.add(dobMonthCombo);
        
        String[] years = new String[50];
        for (int i = 0; i < 50; i++) {
            years[i] = String.valueOf(1970 + i);
        }
        dobYearCombo = new JComboBox<>(years);
        dobYearCombo.setBounds(300, 170, 70, 25);
        panel.add(dobYearCombo);
        
        // Membership Start Date
        JLabel startDateLabel = new JLabel("Membership Start Date");
        startDateLabel.setBounds(50, 210, 150, 25);
        panel.add(startDateLabel);
        
        // Day, Month, Year dropdowns for Start Date
        startDayCombo = new JComboBox<>(days);
        startDayCombo.setBounds(200, 210, 60, 25);
        panel.add(startDayCombo);
        
        startMonthCombo = new JComboBox<>(months);
        startMonthCombo.setBounds(270, 210, 70, 25);
        panel.add(startMonthCombo);
        
        startYearCombo = new JComboBox<>(years);
        startYearCombo.setBounds(350, 210, 70, 25);
        panel.add(startYearCombo);
    }
    
    private void addRegularMember() {
        try {
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            String location = locationField.getText();
            String phone = phoneField.getText();
            String email = emailField.getText();
            String gender = maleRadio.isSelected() ? "Male" : "Female";
            
            String dob = dobDayCombo.getSelectedItem() + "/" + 
                         dobMonthCombo.getSelectedItem() + "/" + 
                         dobYearCombo.getSelectedItem();
            
            String startDate = startDayCombo.getSelectedItem() + "/" + 
                              startMonthCombo.getSelectedItem() + "/" + 
                              startYearCombo.getSelectedItem();
            
            String referralSource = referralField.getText();
            
            if (name.isEmpty() || location.isEmpty() || phone.isEmpty() || email.isEmpty() || referralSource.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields");
                return;
            }
            
            RegularMember member = new RegularMember(id, name, location, phone, email, gender, dob, startDate, referralSource);
            members.add(member);
            
            JOptionPane.showMessageDialog(this, "Regular Member added successfully");
            revertFields();
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid ID number");
        }
    }
    
    private void addPremiumMember() {
        try {
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            String location = locationField.getText();
            String phone = phoneField.getText();
            String email = emailField.getText();
            String gender = maleRadio.isSelected() ? "Male" : "Female";
            
            String dob = dobDayCombo.getSelectedItem() + "/" + 
                         dobMonthCombo.getSelectedItem() + "/" + 
                         dobYearCombo.getSelectedItem();
            
            String startDate = startDayCombo.getSelectedItem() + "/" + 
                              startMonthCombo.getSelectedItem() + "/" + 
                              startYearCombo.getSelectedItem();
            
            String trainer = trainerField.getText();
            
            if (name.isEmpty() || location.isEmpty() || phone.isEmpty() || email.isEmpty() || trainer.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields");
                return;
            }
            
            PremiumMember member = new PremiumMember(id, name, location, phone, email, gender, dob, startDate, trainer);
            members.add(member);
            
            JOptionPane.showMessageDialog(this, "Premium Member added successfully");
            revertFields();
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid ID number");
        }
    }
    
    private void activateMembership(String idStr) {
        try {
            int id = Integer.parseInt(idStr);
            GymMember member = findMemberById(id);
            
            if (member != null) {
                member.activateMembership();
                JOptionPane.showMessageDialog(this, "Membership activated successfully");
            } else {
                JOptionPane.showMessageDialog(this, "Member with ID " + id + " not found");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid ID number");
        }
    }
    
    private void deactivateMembership(String idStr) {
        try {
            int id = Integer.parseInt(idStr);
            GymMember member = findMemberById(id);
            
            if (member != null) {
                member.deactivateMembership();
                JOptionPane.showMessageDialog(this, "Membership deactivated successfully");
            } else {
                JOptionPane.showMessageDialog(this, "Member with ID " + id + " not found");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid ID number");
        }
    }
    
    private void markAttendance(String idStr) {
        try {
            int id = Integer.parseInt(idStr);
            GymMember member = findMemberById(id);
            
            if (member != null) {
                if (member.isActiveStatus()) {
                    member.markAttendance();
                    JOptionPane.showMessageDialog(this, "Attendance marked successfully");
                } else {
                    JOptionPane.showMessageDialog(this, "Cannot mark attendance. Membership is not active.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Member with ID " + id + " not found");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid ID number");
        }
    }
    
    private void displayMember(String idStr) {
        try {
            int id = Integer.parseInt(idStr);
            GymMember member = findMemberById(id);
            
            if (member != null) {
                StringBuilder details = new StringBuilder();
                details.append("ID: ").append(member.getId()).append("\n");
                details.append("Name: ").append(member.getName()).append("\n");
                details.append("Location: ").append(member.getLocation()).append("\n");
                details.append("Phone: ").append(member.getPhone()).append("\n");
                details.append("Email: ").append(member.getEmail()).append("\n");
                details.append("Gender: ").append(member.getGender()).append("\n");
                details.append("DOB: ").append(member.getDOB()).append("\n");
                details.append("Membership Start Date: ").append(member.getMembershipStartDate()).append("\n");
                details.append("Active Status: ").append(member.isActiveStatus() ? "Yes" : "No").append("\n");
                details.append("Attendance: ").append(member.getAttendance()).append("\n");
                details.append("Loyalty Points: ").append(member.getLoyaltyPoints()).append("\n\n");
                
                if (member instanceof RegularMember) {
                    RegularMember regMember = (RegularMember) member;
                    details.append("Member Type: Regular\n");
                    details.append("Referral Source: ").append(regMember.getReferralSource()).append("\n");
                    details.append("Plan: ").append(regMember.getPlan()).append("\n");
                    details.append("Price: ").append(regMember.getPrice()).append("\n");
                    details.append("Attendance Limit: ").append(regMember.getAttendanceLimit()).append("\n");
                    details.append("Eligible for Upgrade: ").append(regMember.isEligibleForUpgrade() ? "Yes" : "No");
                } else if (member instanceof PremiumMember) {
                    PremiumMember premMember = (PremiumMember) member;
                    details.append("Member Type: Premium\n");
                    details.append("Personal Trainer: ").append(premMember.getPersonalTrainer()).append("\n");
                    details.append("Premium Charge: ").append(premMember.getPremiumCharge()).append("\n");
                    details.append("Paid Amount: ").append(premMember.getPaidAmount()).append("\n");
                    details.append("Is Full Payment: ").append(premMember.isFullPayment() ? "Yes" : "No").append("\n");
                    details.append("Discount Amount: ").append(premMember.getDiscountAmount());
                }
                
                JOptionPane.showMessageDialog(this, details.toString(), "Member Details", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Member with ID " + id + " not found");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid ID number");
        }
    }
    
    private void upgradePlan(String idStr) {
        try {
            int id = Integer.parseInt(idStr);
            GymMember member = findMemberById(id);
            
            if (member != null) {
                if (member instanceof RegularMember) {
                    RegularMember regMember = (RegularMember) member;
                    String newPlan = planCombo.getSelectedItem().toString().toLowerCase();
                    String result = regMember.upgradePlan(newPlan);
                    JOptionPane.showMessageDialog(this, result);
                } else {
                    JOptionPane.showMessageDialog(this, "Only Regular Members can upgrade plans");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Member with ID " + id + " not found");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid ID number");
        }
    }
    
    private void calculateDiscount(String idStr) {
        try {
            int id = Integer.parseInt(idStr);
            GymMember member = findMemberById(id);
            
            if (member != null) {
                if (member instanceof PremiumMember) {
                    PremiumMember premMember = (PremiumMember) member;
                    premMember.calculateDiscount();
                    JOptionPane.showMessageDialog(this, "Discount calculated: " + premMember.getDiscountAmount());
                } else {
                    JOptionPane.showMessageDialog(this, "Only Premium Members can have discounts");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Member with ID " + id + " not found");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid ID number");
        }
    }
    
    private void payDueAmount(String idStr) {
        try {
            int id = Integer.parseInt(idStr);
            double amount = Double.parseDouble(paymentAmountField.getText());
            
            GymMember member = findMemberById(id);
            
            if (member != null) {
                if (member instanceof PremiumMember) {
                    PremiumMember premMember = (PremiumMember) member;
                    String result = premMember.payDueAmount(amount);
                    JOptionPane.showMessageDialog(this, result);
                } else {
                    JOptionPane.showMessageDialog(this, "Only Premium Members can make payments");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Member with ID " + id + " not found");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid ID and amount numbers");
        }
    }
    
    private void saveToFile() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("gym_members.dat"))) {
            out.writeObject(members);
            JOptionPane.showMessageDialog(this, "Members saved to file successfully");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving to file: " + e.getMessage());
        }
    }
    
    private void readFromFile() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("gym_members.dat"))) {
            members = (List<GymMember>) in.readObject();
            JOptionPane.showMessageDialog(this, "Members loaded from file successfully");
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Error reading from file: " + e.getMessage());
        }
    }
    
  private GymMember findMemberById(int id) {
    for (GymMember member : members) {
        if (member.getId() == id) {
            return member;
        }
    }
    return null;  // Return null if no member with the given ID is found
}
}