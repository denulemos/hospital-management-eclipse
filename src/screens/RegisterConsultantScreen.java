
package screens;

import dao.AdminDAO;
import validators.FieldValidator;
import exceptions.EmptyFieldException;
import exceptions.UserAlreadyExistsException;
import implementations.AdministratorDAOImp;
import models.UserModel;
import statics.MessageStatic;
import javax.swing.*;
import java.awt.GridLayout;

public class RegisterConsultantScreen extends javax.swing.JInternalFrame {

	AdminDAO controller = new AdministratorDAOImp();

	private JLabel nameLabel;
	private JTextField adminId;
	private JTextField adminName;
	private JPasswordField adminPassword;
	private JButton submitButton;
	private JButton cancelButton;
	private JLabel idLabel;
	private JLabel passLabel;

	public RegisterConsultantScreen() {
		initComponents();
	}

	private void validateFields() throws EmptyFieldException {
		FieldValidator.validateField(adminId.getText());
		FieldValidator.validateField(adminName.getText());
		FieldValidator.validateField(String.valueOf(adminPassword.getPassword()));
	};

	private void initComponents() {
		adminId = new JTextField();
		submitButton = new JButton();
		cancelButton = new JButton();
		nameLabel = new JLabel();

		setPreferredSize(new java.awt.Dimension(846, 463));

		submitButton.setText("Submit");
		submitButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					validateFields();
					UserModel user = controller.get(adminId.getText());
					if (user != null) {
						throw new UserAlreadyExistsException(adminId.getText());
					} else {
						UserModel userToAdd = new UserModel(adminId.getText(), adminName.getText(),
								String.valueOf(adminPassword.getPassword()));
						controller.add(userToAdd);
						MessageStatic.generateMessage("The User has been registered succesfully");
					}

				} catch (Exception e) {
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

		nameLabel.setText("Fullname");
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		getContentPane().add(nameLabel);
		adminName = new JTextField();
		getContentPane().add(adminName);
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
