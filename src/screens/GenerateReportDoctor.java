package screens;

import controllers.ScheduleController;
import controllers.UserController;
import validators.DateValidator;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import javax.swing.*;


public class GenerateReportDoctor extends javax.swing.JInternalFrame {

    ScheduleController schedController = new ScheduleController();
    DateValidator dateValidator = new DateValidator();
    
    // Init components
    private JLabel TotalAmount;
    private JLabel amountGain;
    private JButton jButton1;
    private JButton jButton2;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JScrollPane jScrollPane2;
    private JTable resultTable;
   
    public GenerateReportDoctor() {
        initComponents();
    }

  
    private void initComponents() {

        jLabel6 = new JLabel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jScrollPane2 = new JScrollPane();
        resultTable = new JTable();
        jLabel3 = new JLabel();
        TotalAmount = new JLabel();
        amountGain = new JLabel();
        jLabel7 = new JLabel();

        jLabel6.setText("Register Doctor");
        jLabel1.setText("From");
        jLabel2.setText("To");
        jButton1.setText("Generate Report");
        jLabel7.setText("Generate Report");
        jButton2.setText("Cancel");
        
        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
 
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        resultTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Patient", "Date", "Taken", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(resultTable);

        
        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(191, 191, 191)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(259, 259, 259))
            .addGroup(layout.createSequentialGroup()
                .addGap(89, 89, 89)
                
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                
                .addGap(155, 155, 155))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(356, 356, 356))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(amountGain)
                    .addComponent(TotalAmount))
                .addGap(891, 891, 891))
            .addGroup(layout.createSequentialGroup()
                .addGap(342, 342, 342)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                   
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(39, 39, 39)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(amountGain)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TotalAmount)
                .addGap(28, 28, 28)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
       Boolean from = true
    		   Boolean to = true
      
       
       String doctor = UserController.currentUser.getId();
        try {
            if (DateValidator.isDateFilled(from) && DateValidator.isDateFilled(to)) {
                 int amount = 0;
                DefaultTableModel model = (DefaultTableModel)resultTable.getModel();
                model.setRowCount(0);
                ResultSet results = schedController.getScheduleByDoctorByDates(doctor, from, to);
                     if (results.next()){
            do {
                if (results.getString(5).equals("1")){
                    amount += results.getInt(6);
                }
               String [] row = {results.getString(1), results.getString(3), results.getString(4), results.getString(5), results.getString(6)};
               model.addRow(row);
            }while(results.next());
            }
         amountGain.setText("Total = " + Integer.toString(amount) + "$");
            }
           
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),
						"Error!", JOptionPane.ERROR_MESSAGE);
        }
    }




  
}