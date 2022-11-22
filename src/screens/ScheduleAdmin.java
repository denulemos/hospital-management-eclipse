
package screens;

import controllers.PatientController;
import models.PatientModel;
import utils.Colors;
import validators.FieldValidator;
import java.sql.ResultSet;
import javax.swing.*;


public class ScheduleAdmin extends javax.swing.JInternalFrame {

    PatientController controller = new PatientController();
    
    // Components
    private JTextArea historyPatient;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JTextField patientId;
    private JTextField patientId2;
    private JTextField patientLastname;
    private JTextField patientName;
    private JTable resultTable;
    
   
    public ScheduleAdmin() {
        initComponents();
    }

  
    private void initComponents() {

        jLabel3 = new JLabel();
        patientId2 = new JTextField();
        jLabel5 = new JLabel();
        patientId = new JTextField();
        jLabel1 = new JLabel();
        jButton1 = new JButton();
        jScrollPane2 = new JScrollPane();
        resultTable = new JTable();
        jScrollPane1 = new JScrollPane();
        historyPatient = new JTextArea();
        jLabel2 = new JLabel();
        jButton2 = new JButton();
        jButton3 = new JButton();
        patientName = new JTextField();
        jLabel4 = new JLabel();
        patientLastname = new JTextField();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();

        jLabel3.setText("jLabel3");
        jLabel5.setText("Patient Name");
        jLabel1.setText("Patient ID");
        jButton1.setText("Search");
        
        patientId2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	 PatientModel user = new PatientModel((String)resultTable.getModel().getValueAt(0,2), (String)resultTable.getModel().getValueAt(0,1), (String)resultTable.getModel().getValueAt(0,0), historyPatient.getText(), null);
                 
                 try {
                     controller.editPatient(user.getId(), user.getName(), user.getLastname(), user.getHistory());
                     JOptionPane.showMessageDialog(null, "Patient updated");
                 }
                 
                 catch (Exception e) {
                     JOptionPane.showMessageDialog(null, "There was an error updating the patient: " + e);
                 }
            }
        });

        

        patientId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionPerformed(evt);
            }
        });

        
        
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	try {
                    FieldValidator.validateField(patientId.getText());
                    FieldValidator.validateField(patientName.getText());
                    FieldValidator.validateField(patientLastname.getText());
                    PatientModel user = new PatientModel(patientId.getText(), patientLastname.getText(), patientName.getText(), null, null);
                    ResultSet result =controller.searchPatient(user.getId(), user.getName(), user.getLastname());
                    
                    if (result.next()) {
                        DefaultTableModel model = (DefaultTableModel)resultTable.getModel();
                            String [] row = {result.getString(3), result.getString(2), result.getString(1)};
                            model.addRow(row);
                            historyPatient.setText(result.getString(4));
                    }
                    
                    else {
                        JOptionPane.showMessageDialog(null, "User not found");
                        return;
                    }
                    
                }
                
                catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(),
        						"Error", JOptionPane.ERROR_MESSAGE);
                }
                
            }
        });

        resultTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Lastname", "ID "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        resultTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(resultTable);

        historyPatient.setColumns(20);
        historyPatient.setRows(5);
        jScrollPane1.setViewportView(historyPatient);

        jLabel2.setText("History");


        jButton2.setText("Save Changes");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	 PatientModel user = new PatientModel((String)resultTable.getModel().getValueAt(0,2), (String)resultTable.getModel().getValueAt(0,1), (String)resultTable.getModel().getValueAt(0,0), historyPatient.getText(), null);
                 
                 try {
                     controller.editPatient(user.getId(), user.getName(), user.getLastname(), user.getHistory());
                     JOptionPane.showMessageDialog(null, "Patient updated");
                 }
                 
                 catch (Exception e) {
                     JOptionPane.showMessageDialog(null, "There was an error updating the patient: " + e);
                 }
            }
        });


        jButton3.setText("Cancel");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        patientName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionPerformed(evt);
            }
        });

        jLabel4.setText("Patient Name");

        patientLastname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionPerformed(evt);
            }
        });

        jLabel6.setText("Patient Lastname");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel7.setText("Patient");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(jLabel1)
                            .addComponent(patientId, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(27, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(patientName, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(patientLastname, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(patientId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(patientName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(patientLastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton3)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        pack();
    }





   

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
    }

   


}
