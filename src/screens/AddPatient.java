package screens;

import dao.PatientDAO;
import implementations.PatientDAOImp;
import models.PatientModel;
import statics.MessageStatic;

import javax.swing.*;
import java.awt.*;

public class AddPatient extends javax.swing.JInternalFrame {

    PatientDAO patientController = new PatientDAOImp();
    
    // Components
    private JButton addPatientCancel, addPatientSubmit;
    private JLabel nameLabel, historyLabel, lastnameLabel, idLabel;
    private JScrollPane jScrollPane1;
    private JTextArea patientHistory;
    private JTextField patientId;
    private JTextField patientLastname;
    private JTextField patientName;
    private JRadioButton radioFemale;
    private JRadioButton radioMan;

    public AddPatient() {
        initComponents();
    }


    private String setGender () {
        if (radioMan.isSelected()){
            return "M";
        }
        
        return "F";
        
    };
    
    
    private void initComponents() {

        patientName = new JTextField();
        patientName.setToolTipText("Example: Juan");
        nameLabel = new JLabel();
        addPatientSubmit = new JButton();
        addPatientCancel = new JButton();
        patientId = new JTextField();
        patientId.setToolTipText("Example: DNI ");
        idLabel = new JLabel();

        nameLabel.setText("Name");
        addPatientSubmit.setText("Add");
        idLabel.setText("ID");
        addPatientCancel.setText("Cancel");
        
        addPatientSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPatientSubmitActionPerformed();
            }
        });


        
        addPatientCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPatientCancelActionPerformed();
            }
        });
        getContentPane().setLayout(new GridLayout(0, 2, 4, 0));
        getContentPane().add(idLabel);
        getContentPane().add(patientId);
        getContentPane().add(nameLabel);
        getContentPane().add(patientName);
        lastnameLabel = new JLabel();
        lastnameLabel.setText("Lastname");
        getContentPane().add(lastnameLabel);
        patientLastname = new JTextField();
        patientLastname.setToolTipText("Example: Perez");
        getContentPane().add(patientLastname);
        radioMan = new JRadioButton();
        radioMan.setText("Man");
        getContentPane().add(radioMan);
        radioFemale = new JRadioButton();
        radioFemale.setText("Female");
        getContentPane().add(radioFemale);
        historyLabel = new JLabel();
        historyLabel.setText("Medic History");
        getContentPane().add(historyLabel);
        jScrollPane1 = new JScrollPane();
        jScrollPane1.setToolTipText("Example: This patient has..");
        patientHistory = new JTextArea();
        
                patientHistory.setColumns(20);
                patientHistory.setRows(5);
                jScrollPane1.setViewportView(patientHistory);
                getContentPane().add(jScrollPane1);
        getContentPane().add(addPatientSubmit);
        getContentPane().add(addPatientCancel);

        pack();
    }

    private void addPatientSubmitActionPerformed() {
        String gender = setGender();
        
        try {
        	PatientModel patient = new PatientModel(patientId.getText(), patientLastname.getText(), patientName.getText(), patientHistory.getText(), gender);
        	patientController.addPatient(patient);
            MessageStatic.generateMessage("The patient has been registered succesfully");
        } catch (Exception ex) {
        	MessageStatic.generateErrorMessage("Couldn't add new Patient: " + ex);
        }
        
        
    }

    private void addPatientCancelActionPerformed() {
        this.setVisible(false);
    }




   
}
