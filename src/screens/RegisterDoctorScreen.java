
package screens;

import controllers.DoctorController;
import controllers.UserController;
import models.UserModel;
import validators.FieldValidator;
import validators.UserValidator;
import exceptions.EmptyFieldException;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.JOptionPane;
import utils.Colors;
import utils.Fonts;


public class RegisterDoctorScreen extends javax.swing.JInternalFrame {
	
	// Init elements
	private JLabel $ = new JLabel();
    private JTextField doctorId = new JTextField();
    private JTextField doctorLastname= new JTextField();
    private JTextField doctorName2= new JTextField();
    private JPasswordField doctorPassword= new JPasswordField();
    private JLabel doctorPrice= new JLabel();
    private JTextField doctorSpecialty= new JTextField();
    private JButton jButton1= new JButton();
    private JButton jButton2= new JButton();
    private JLabel jLabel1= new JLabel();
    private JLabel jLabel2= new JLabel();
    private JLabel jLabel3= new JLabel();
    private JLabel jLabel4= new JLabel();
    private JLabel jLabel5= new JLabel();
    private JLabel jLabel6= new JLabel();
    private JTextField price= new JTextField();

    // Init Controllers
    DoctorController doctorController = new DoctorController();
    UserController userController = new UserController();
  
    public RegisterDoctorScreen() {
        initComponents();
    }
    
    private void setTexts() {
    	 jLabel1.setText("Name");
         jLabel2.setText("ID");
         jLabel3.setText("Password");
         jLabel4.setText("Specialty");
         jButton2.setText("Cancel");
         jButton1.setText("Submit");
         jLabel5.setText("Lastname");
         doctorPrice.setText("Price per Session");
         $.setText("$");
         jLabel6.setText("Register Doctor");
    }
    
    private void setStyles() {
    	jButton1.setBackground(Colors.LIGHT_BLUE);
        jButton1.setForeground(Colors.WHITE);
        jButton2.setBackground(Colors.GRAY);
        jButton2.setForeground(Colors.GRAY);
        jLabel6.setFont(Fonts.TITLE);
    }
    
  

   
    private void initComponents() {

    	setTexts();
    	setStyles();
    	
        
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

      
      
        GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(doctorPrice)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(doctorName2, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                            .addComponent(doctorPassword)
                            .addComponent(doctorSpecialty,GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                            .addComponent(jLabel3)
                            .addComponent(doctorId)
                            .addComponent(doctorLastname, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(price, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent($))
                            .addComponent(jButton1, GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 115, Short.MAX_VALUE))))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(166, 166, 166))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(doctorName2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(doctorLastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(doctorId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(doctorPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(doctorSpecialty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(doctorPrice)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent($))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addGap(27, 27, 27))
        );

        pack();
    }

    private void validateFields () throws EmptyFieldException {
        FieldValidator.validateField(doctorName2.getText());
        FieldValidator.validateField(doctorLastname.getText());
        FieldValidator.validateField(doctorId.getText());
        FieldValidator.validateField(doctorSpecialty.getText());
        FieldValidator.validateField(String.valueOf(doctorPassword.getPassword()));
    };
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {

        try {
            validateFields();
            UserValidator.userExists(doctorId.getText());
            int priceDoctor = FieldValidator.validateAndConvertToNumber(price.getText());
            UserModel doctor = new UserModel(doctorName2.getText(), doctorLastname.getText(),doctorId.getText(), doctorSpecialty.getText(), priceDoctor, String.valueOf(doctorPassword.getPassword()) );
            doctorController.addDoctor(doctor.getId(), doctor.getName(), doctor.getLastname(),  doctor.getPassword(), doctor.getSpecialty(),  doctor.getPrice());
            JOptionPane.showMessageDialog(null, "The Doctor has been registered succesfully");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Couldn't add new Doctor: " + ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),
						"Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
    }



    
}
