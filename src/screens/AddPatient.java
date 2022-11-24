package screens;

import controllers.PatientController;
import models.PatientModel;

import javax.swing.*;
import java.awt.*;

public class AddPatient extends javax.swing.JInternalFrame {

    PatientController controller = new PatientController();
    
    // Components
    private JButton addPatientCancel;
    private JButton addPatientSubmit;
    private JLabel nameLabel;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel7;
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
        nameLabel = new JLabel();
        addPatientSubmit = new JButton();
        addPatientCancel = new JButton();
        jScrollPane1 = new JScrollPane();
        patientHistory = new JTextArea();
        jLabel2 = new JLabel();
        patientId = new JTextField();
        jLabel4 = new JLabel();
        radioMan = new JRadioButton();
        radioFemale = new JRadioButton();
        patientLastname = new JTextField();
        jLabel3 = new JLabel();
        jLabel7 = new JLabel();

        nameLabel.setText("Name");
        addPatientSubmit.setText("Add");
        jLabel2.setText("Medic History");
        jLabel4.setText("ID");
        radioMan.setText("Man");
        radioFemale.setText("Female");
        jLabel3.setText("Lastname");
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

        patientHistory.setColumns(20);
        patientHistory.setRows(5);
        jScrollPane1.setViewportView(patientHistory);

        

        jLabel7.setFont(new Font("Segoe UI", 0, 24)); // NOI18N
        jLabel7.setText("Add Patient");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(patientId)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameLabel)
                            .addComponent(patientName)
                            .addComponent(addPatientSubmit, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                            .addComponent(addPatientCancel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(radioMan)
                                .addGap(32, 32, 32)
                                .addComponent(radioFemale))
                            .addComponent(patientLastname)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addComponent(jLabel7)))
                .addContainerGap(123, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel7)
                .addGap(34, 34, 34)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(patientId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(nameLabel)
                .addGap(4, 4, 4)
                .addComponent(patientName,GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(4, 4, 4)
                .addComponent(patientLastname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(radioMan)
                    .addComponent(radioFemale))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(addPatientSubmit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addPatientCancel)
                .addGap(39, 39, 39))
        );

        pack();
    }

    private void addPatientSubmitActionPerformed() {
        String gender = setGender();
        
        try {
        	PatientModel patient = new PatientModel(patientId.getText(), patientLastname.getText(), patientName.getText(), patientHistory.getText(), gender);
            controller.addPatient(patient);
            JOptionPane.showMessageDialog(null, "The patient has been registered succesfully");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Couldn't add new Patient: " + ex);
        }
        
        
    }

    private void addPatientCancelActionPerformed() {
        this.setVisible(false);
    }




   
}
