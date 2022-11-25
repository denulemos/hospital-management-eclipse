
package screens;

import dao.AdminDAO;
import dao.UserDAO;
import validators.FieldValidator;
import validators.UserValidator;
import exceptions.EmptyFieldException;
import implementations.AdministratorDAOImp;
import implementations.UserDAOImp;
import statics.MessageStatic;
import javax.swing.*;
import java.awt.GridLayout;


public class RegisterConsultantScreen extends javax.swing.JInternalFrame {

   
    AdminDAO controller = new AdministratorDAOImp();
    UserDAO userController = new UserDAOImp();
    
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
        nameLabel = new JLabel();
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

        nameLabel.setText("Name");
        getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
        getContentPane().add(nameLabel);
        adminName = new JTextField();
        getContentPane().add(adminName);
        getContentPane().add(lastLabel);
        getContentPane().add(adminLastname);
        idLabel = new JLabel();
        
                idLabel.setText("ID");
                getContentPane().add(idLabel);
        getContentPane().add(adminId);
        passLabel = new JLabel();
        
                passLabel.setText("Password");
                getContentPane().add(passLabel);
        adminPassword = new JPasswordField();
        getContentPane().add(adminPassword);
        getContentPane().add(submitButton);
        getContentPane().add(cancelButton);

        pack();
    }

    private void cancelButtonActionPerformed() {
        this.setVisible(false);   
    }


}
