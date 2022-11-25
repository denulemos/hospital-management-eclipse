package com.mycompany.hospitaladministrationsystem;

import screens.DoctorMain;
import statics.MessageStatic;
import statics.UserStatic;
import screens.AdminMain;
import controllers.UserController;
import exceptions.DBException;
import models.UserModel;
import provider.ConnectionProvider;
import validators.FieldValidator;
import validators.UserValidator;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class main extends javax.swing.JFrame {
	Connection connection;

	private JTextField idField;
	private JLabel idLabel;
	private JLabel passLabel;
	private JButton loginButton;
	private JPasswordField passwordField;

	public void stablishConnection() throws DBException {

		ConnectionProvider.setConnection();
		connection = ConnectionProvider.connection;

	}

	public main() {
		try {
			stablishConnection();
			initComponents();
		} catch (Exception e) {
			MessageStatic.generateErrorMessage(e.getMessage());
		}

	}

	private void initComponents() {

		passwordField = new JPasswordField();
		idField = new JTextField();
		loginButton = new JButton();
		idLabel = new JLabel();
		passLabel = new JLabel();

		loginButton.setText("Login");
		idLabel.setText("ID");
		passLabel.setText("Password");

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


		loginButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				loginButtonActionPerformed();
			}
		});

		GroupLayout layout = new GroupLayout(getContentPane());
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGap(169)
					.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(passLabel)
						.addComponent(idLabel)
						.addComponent(loginButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(idField)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(123, Short.MAX_VALUE))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGap(134)
					.addComponent(idLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(idField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(13)
					.addComponent(passLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(35)
					.addComponent(loginButton)
					.addContainerGap(146, Short.MAX_VALUE))
		);
		getContentPane().setLayout(layout);

		pack();
	}

	private void loginButtonActionPerformed() {
		String id = idField.getText();
		String password = String.valueOf(passwordField.getPassword());

		try {
			FieldValidator.validateField(id);
			FieldValidator.validateField(password);
			UserController userController = new UserController();
			ResultSet result = userController.getUser(id, password);
			if (result.next()) {
				UserModel user = new UserModel(result.getString(2), result.getString(3), result.getString(1), result.getString(5), Integer.parseInt(result.getString(6)), null);
				UserStatic.setGlobalUser(user);
				
				if (UserValidator.isDoctor(user)) {
					DoctorMain doctorMain = new DoctorMain();
					doctorMain.setVisible(true);
				} else {
					AdminMain adminMain = new AdminMain();
					adminMain.setVisible(true);
				}
				MessageStatic.generateMessage("Welcome " + user.getName() + " " + user.getLastname() + "!");
			} else {
				MessageStatic.generateErrorMessage("User not found");
			}

		} catch (Exception e) {
			MessageStatic.generateErrorMessage(e.getMessage());
		}

	}

	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new main().setVisible(true);
			}
		});
	}

}
