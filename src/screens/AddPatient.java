package screens;

import dao.PatientDAO;
import implementations.PatientDAOImp;
import models.PatientModel;
import statics.MessageStatic;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class AddPatient extends javax.swing.JInternalFrame {

    PatientDAO patientController = new PatientDAOImp();
    
    // Components
    private JButton addPatientCancel, addPatientSubmit;
    private JLabel nameLabel, historyLabel, idLabel;
    private JScrollPane jScrollPane1;
    private JTextArea patientHistory;
    private JTextField patientId;
    private JTextField patientName;

    public AddPatient() {
        initComponents();
    }

    
    private void initComponents() {

        patientName = new JTextField();
        patientName.setToolTipText("Example: Juan");
        nameLabel = new JLabel();
        addPatientSubmit = new JButton();
        addPatientCancel = new JButton();
        patientId = new JTextField();
        patientId.setToolTipText("Example: DNI ");
        idLabel = new JLabel();

        nameLabel.setText("Fullname");
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
        
        try {
        	PatientModel patient = new PatientModel(patientId.getText(), patientName.getText(), patientHistory.getText());
        	patientController.add(patient);
            MessageStatic.generateMessage("The patient has been registered succesfully");
        } catch (Exception ex) {
        	MessageStatic.generateErrorMessage("Couldn't add new Patient: " + ex);
        }
        
        
    }

    private void addPatientCancelActionPerformed() {
        this.setVisible(false);
    }




   
}
