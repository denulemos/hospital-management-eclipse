
package screens;

import dao.DoctorDAO;
import models.DoctorModel;
import statics.MessageStatic;
import validators.FieldValidator;
import exceptions.EmptyFieldException;
import exceptions.UserAlreadyExistsException;
import implementations.DoctorDAOImp;

import javax.swing.*;
import java.awt.GridLayout;

@SuppressWarnings("serial")
public class RegisterDoctorScreen extends javax.swing.JInternalFrame {
	private JTextField doctorId = new JTextField();
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
	private JTextField price = new JTextField();

	DoctorDAO doctorController = new DoctorDAOImp();
	private final JLabel label_28 = new JLabel("");

	public RegisterDoctorScreen() {
		initComponents();
	}

	private void setTexts() {
		nameLabel.setText("Fullname");
		idLabel.setText("ID");
		passwordLabel.setText("Password");
		specialtyLabel.setText("Specialty");
		cancelButton.setText("Cancel");
		submitButton.setText("Submit");
		doctorPrice.setText("Price per Session");
	}

	private void initComponents() {

		setTexts();

		submitButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					validateFields();
					DoctorModel doctor = doctorController.getById(doctorId.getText());
					if (doctor != null) {
						throw new UserAlreadyExistsException(doctorId.getText());
					} else {
						String name = doctorName2.getText();
						String id = doctorId.getText();
						String specialty = doctorSpecialty.getText();
						String password = String.valueOf(doctorPassword.getPassword());

						int priceDoctor = FieldValidator.validateAndConvertToNumber(price.getText());
						doctor = new DoctorModel(name, id,password, specialty, priceDoctor);
						doctorController.add(doctor);
						MessageStatic.generateMessage("The Doctor has been added");
					}

				} catch (Exception e) {
					MessageStatic.generateErrorMessage(e.getMessage());
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
		FieldValidator.validateField(doctorId.getText());
		FieldValidator.validateField(doctorSpecialty.getText());
		FieldValidator.validateField(String.valueOf(doctorPassword.getPassword()));
	};

	private void cancelAction() {
		this.setVisible(false);
	}

}
