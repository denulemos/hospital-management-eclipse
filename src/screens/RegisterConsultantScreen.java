
package screens;

import controllers.AdministratorController;
import controllers.UserController;
import validators.FieldValidator;
import validators.UserValidator;
import exceptions.EmptyFieldException;
import java.sql.SQLException;
import javax.swing.*;


public class RegisterConsultantScreen extends javax.swing.JInternalFrame {

   
    AdministratorController controller = new AdministratorController();
    UserController userController = new UserController();
    
    private JLabel Name;
    private JTextField adminId;
    private JTextField adminLastname;
    private JTextField adminName;
    private JPasswordField adminPassword;
    private JButton jButton1;
    private JButton jButton2;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    
    public RegisterConsultantScreen() {
        initComponents();
    }
    
    private void validateFields () throws EmptyFieldException {
        FieldValidator.validateField(adminId.getText());
        FieldValidator.validateField(adminName.getText());
        FieldValidator.validateField(adminLastname.getText());
        FieldValidator.validateField(String.valueOf(adminPassword.getPassword()));
    };

   
    private void initComponents() {

        adminLastname = new JTextField();
        adminId = new JTextField();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        adminPassword = new JPasswordField();
        Name = new JLabel();
        adminName = new JTextField();
        jLabel4 = new JLabel();

        setPreferredSize(new java.awt.Dimension(846, 463));


        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	 try {
                     validateFields();
                     UserValidator.userExists(adminId.getText());
                     controller.addAdmin(adminId.getText(), adminName.getText(), adminLastname.getText(), String.valueOf(adminPassword.getPassword()));
                     JOptionPane.showMessageDialog(null, "The User has been registered succesfully");
                 } catch (SQLException ex) {
                     JOptionPane.showMessageDialog(null, "Couldn't add new User: " + ex);
                 }
                 catch (Exception e) {
                     JOptionPane.showMessageDialog(null, e.getMessage(),
         						"Error", JOptionPane.ERROR_MESSAGE);
                 }
            }
        });


        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Lastname");

        jLabel2.setText("ID");

        jLabel3.setText("Password");

        Name.setText("Name");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setText("Register new Administrator");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(adminName)
                            .addComponent(Name)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(adminPassword)
                            .addComponent(adminLastname)
                            .addComponent(adminId)
                            .addComponent(jButton1, GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(29, 29, 29)
                .addComponent(Name)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(adminName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(adminLastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(adminId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(adminPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        pack();
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
        
    }


}
