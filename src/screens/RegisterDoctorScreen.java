
package screens;

import dao.DoctorDAO;
import dao.UserDAO;
import models.UserModel;
import validators.FieldValidator;
import validators.UserValidator;
import exceptions.EmptyFieldException;
import implementations.DoctorDAOImp;
import implementations.UserDAOImp;

import java.sql.SQLException;
import javax.swing.*;
import java.awt.GridLayout;

public class RegisterDoctorScreen extends javax.swing.JInternalFrame {
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
	private JTextField price = new JTextField();

	DoctorDAO doctorController = new DoctorDAOImp();
	UserDAO userController = new UserDAOImp();
	private final JLabel label_28 = new JLabel("");

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
		getContentPane().setLayout(new GridLayout(0, 2, 0, 0));
		getContentPane().add(nameLabel);
		getContentPane().add(doctorName2);
		getContentPane().add(lastnameLabel);
		getContentPane().add(doctorLastname);
		getContentPane().add(idLabel);
		getContentPane().add(doctorId);
		getContentPane().add(passwordLabel);
		getContentPane().add(doctorPassword);
		getContentPane().add(specialtyLabel);
		getContentPane().add(doctorSpecialty);
		getContentPane().add(doctorPrice);
		getContentPane().add(price);
		getContentPane().add(submitButton);
		getContentPane().add(cancelButton);
		
		getContentPane().add(label_28);

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
