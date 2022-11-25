
package screens;

import controllers.AdministratorController;
import controllers.UserController;
import dao.AdminDAO;
import dao.UserDAO;
import validators.FieldValidator;
import validators.UserValidator;
import exceptions.EmptyFieldException;
import statics.MessageStatic;
import javax.swing.*;


public class RegisterConsultantScreen extends javax.swing.JInternalFrame {

   
    AdminDAO controller = new AdministratorController();
    UserDAO userController = new UserController();
    
    private JLabel nameLabel;
    private JTextField adminId;
    private JTextField adminLastname;
    private JTextField adminName;
    private JPasswordField adminPassword;
    private JButton submitButton;
    private JButton cancelButton;
    private JLabel lastLabel;
    private JLabel idLabel;
    private JLabel passLabel;
    private JLabel titleLabel;
    
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
        submitButton = new JButton();
        cancelButton = new JButton();
        lastLabel = new JLabel();
        idLabel = new JLabel();
        passLabel = new JLabel();
        adminPassword = new JPasswordField();
        nameLabel = new JLabel();
        adminName = new JTextField();
        titleLabel = new JLabel();

        setPreferredSize(new java.awt.Dimension(846, 463));


        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	 try {
                     validateFields();
                     UserValidator.userExists(adminId.getText());
                     controller.addAdmin(adminId.getText(), adminName.getText(), adminLastname.getText(), String.valueOf(adminPassword.getPassword()));
                     MessageStatic.generateMessage("The User has been registered succesfully");
                 } 
                 catch (Exception e) {
                	 MessageStatic.generateErrorMessage("Couldn't add new User: " + e.getMessage());
                 }
            }
        });


        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	cancelButtonActionPerformed();
            }
        });

        lastLabel.setText("Lastname");

        idLabel.setText("ID");

        passLabel.setText("Password");

        nameLabel.setText("Name");


        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(titleLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(adminName)
                            .addComponent(nameLabel)
                            .addComponent(passLabel)
                            .addComponent(lastLabel)
                            .addComponent(idLabel)
                            .addComponent(adminPassword)
                            .addComponent(adminLastname)
                            .addComponent(adminId)
                            .addComponent(submitButton, GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGap(29, 29, 29)
                .addComponent(nameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(adminName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lastLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(adminLastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(idLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(adminId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(passLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(adminPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(submitButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelButton)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        pack();
    }

    private void cancelButtonActionPerformed() {
        this.setVisible(false);   
    }


}
