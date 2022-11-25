
package screens;

import controllers.DoctorController;
import controllers.UserController;
import dao.DoctorDAO;
import dao.UserDAO;
import models.UserModel;
import validators.FieldValidator;
import validators.UserValidator;
import exceptions.EmptyFieldException;
import java.sql.SQLException;
import javax.swing.*;

public class RegisterDoctorScreen extends javax.swing.JInternalFrame {

	
	private JLabel $ = new JLabel();
	private JTextField doctorId = new JTextField();
	private JTextField doctorLastname = new JTextField();
	private JTextField doctorName2 = new JTextField();
	private JPasswordField doctorPassword = new JPasswordField();
	private JLabel doctorPrice = new JLabel();
	private JTextField doctorSpecialty = new JTextField();
	private JButton submitButton = new JButton();
	private JButton cancelButton = new JButton();
	private JLabel nameLabel = new JLabel();
	private JLabel idLabel = new JLabel();
	private JLabel passwordLabel = new JLabel();
	private JLabel specialtyLabel = new JLabel();
	private JLabel lastnameLabel = new JLabel();
	private JLabel registerLabel = new JLabel();
	private JTextField price = new JTextField();

	DoctorDAO doctorController = new DoctorController();
	UserDAO userController = new UserController();

	public RegisterDoctorScreen() {
		initComponents();
	}

	private void setTexts() {
		nameLabel.setText("Name");
		idLabel.setText("ID");
		passwordLabel.setText("Password");
		specialtyLabel.setText("Specialty");
		cancelButton.setText("Cancel");
		submitButton.setText("Submit");
		lastnameLabel.setText("Lastname");
		doctorPrice.setText("Price per Session");
		$.setText("$");
		registerLabel.setText("Register Doctor");
	}

	private void initComponents() {

		setTexts();

		submitButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					validateFields();
					UserValidator.userExists(doctorId.getText());
					int priceDoctor = FieldValidator.validateAndConvertToNumber(price.getText());
					UserModel doctor = new UserModel(doctorName2.getText(), doctorLastname.getText(),
							doctorId.getText(), doctorSpecialty.getText(), priceDoctor,
							String.valueOf(doctorPassword.getPassword()));
					doctorController.addDoctor(doctor.getId(), doctor.getName(), doctor.getLastname(),
							doctor.getPassword(), doctor.getSpecialty(), doctor.getPrice());
					JOptionPane.showMessageDialog(null, "The Doctor has been registered succesfully");
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(null, "Couldn't add new Doctor: " + ex, "Error",
							JOptionPane.ERROR_MESSAGE);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		cancelButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cancelAction();
			}
		});


		GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addGap(135, 135, 135)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addComponent(nameLabel)
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(layout.createSequentialGroup().addGroup(layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(doctorPrice).addComponent(idLabel).addComponent(lastnameLabel)
								.addComponent(specialtyLabel)
								.addComponent(doctorName2, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
								.addComponent(doctorPassword)
								.addComponent(doctorSpecialty, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
								.addComponent(passwordLabel).addComponent(doctorId)
								.addComponent(doctorLastname, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
								.addGroup(layout.createSequentialGroup()
										.addComponent(price, GroupLayout.PREFERRED_SIZE, 110,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent($))
								.addComponent(submitButton, GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(cancelButton, GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE))
								.addGap(0, 115, Short.MAX_VALUE))))
				.addGroup(GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(registerLabel).addGap(166, 166, 166)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(12, 12, 12).addComponent(registerLabel)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(nameLabel)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(doctorName2, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(lastnameLabel)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(doctorLastname, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(7, 7, 7).addComponent(idLabel)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(doctorId, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(passwordLabel)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(doctorPassword, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(specialtyLabel)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(doctorSpecialty, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(doctorPrice)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent($))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
						.addComponent(submitButton).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(cancelButton).addGap(27, 27, 27)));

		pack();
	}

	private void validateFields() throws EmptyFieldException {
		FieldValidator.validateField(doctorName2.getText());
		FieldValidator.validateField(doctorLastname.getText());
		FieldValidator.validateField(doctorId.getText());
		FieldValidator.validateField(doctorSpecialty.getText());
		FieldValidator.validateField(String.valueOf(doctorPassword.getPassword()));
	};

	private void cancelAction() {
		this.setVisible(false);
	}

}
