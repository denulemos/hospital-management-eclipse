package com.mycompany.hospitaladministrationsystem;

import screens.DoctorMain;
import statics.MessageStatic;
import statics.UserStatic;
import screens.AdminMain;
import exceptions.DBException;
import implementations.UserDAOImp;
import models.UserModel;
import provider.ConnectionProvider;
import validators.FieldValidator;
import validators.UserValidator;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.GridLayout;

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
		loginButton = new JButton();
		idLabel = new JLabel();

		loginButton.setText("Login");
		idLabel.setText("ID");

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


		loginButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				loginButtonActionPerformed();
			}
		});
		getContentPane().setLayout(new GridLayout(0, 4, 4, 4));
		getContentPane().add(idLabel);
				idField = new JTextField();
				getContentPane().add(idField);
				passLabel = new JLabel();
				passLabel.setText("Password");
				getContentPane().add(passLabel);
		
				passwordField = new JPasswordField();
				getContentPane().add(passwordField);
		getContentPane().add(loginButton);

		pack();
	}

	private void loginButtonActionPerformed() {
		String id = idField.getText();
		String password = String.valueOf(passwordField.getPassword());

		try {
			FieldValidator.validateField(id);
			FieldValidator.validateField(password);
			UserDAOImp userController = new UserDAOImp();
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
