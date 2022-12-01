package com.mycompany.hospitaladministrationsystem;

import screens.DoctorMain;
import services.DoctorService;
import statics.MessageStatic;
import statics.UserStatic;
import screens.AdminMain;
import exceptions.DBException;
import implementations.DoctorDAOImp;
import implementations.UserDAOImp;
import models.DoctorModel;
import models.UserModel;
import provider.ConnectionProvider;
import validators.FieldValidator;
import validators.UserValidator;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import dao.DoctorDAO;

import java.awt.GridLayout;

public class main extends javax.swing.JFrame {
	Connection connection;

	private JTextField idField;
	private JLabel idLabel;
	private JLabel passLabel;
	private JButton loginButton;
	private JPasswordField passwordField;
	JRadioButton doctorButton, userButton;

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

		doctorButton = new JRadioButton("Doctor");
		userButton = new JRadioButton("User");
		ButtonGroup bg = new ButtonGroup();
		bg.add(doctorButton);
		bg.add(userButton);
		getContentPane().add(doctorButton);
		getContentPane().add(userButton);

		pack();
	}
	
	private void loginDoctor (String id, String password) {
try {
			
			DoctorService doctorService = DoctorService.getInstance();
			DoctorModel result = doctorService.login(id, password);
			DoctorMain doctorMain = new DoctorMain();
			doctorMain.setVisible(true);
			
				//UserModel user = new UserModel(result.getString(2), result.getString(3), result.getString(1),
						//result.getString(5), Integer.parseInt(result.getString(6)), null);
				//UserStatic.setGlobalUser(user);
					
					// MessageStatic.generateMessage("Welcome " + user.getName() + " " + user.getLastname() + "!");
		

		} catch (Exception e) {
			MessageStatic.generateErrorMessage(e.getMessage());
		}
	}
	
	private void loginUser (String id, String password) {
try {
			DoctorModel result = userController.login(id, password);
			
				//UserModel user = new UserModel(result.getString(2), result.getString(3), result.getString(1),
						//result.getString(5), Integer.parseInt(result.getString(6)), null);
				//UserStatic.setGlobalUser(user);
					DoctorMain doctorMain = new DoctorMain();
					doctorMain.setVisible(true);
					// MessageStatic.generateMessage("Welcome " + user.getName() + " " + user.getLastname() + "!");
		

		} catch (Exception e) {
			MessageStatic.generateErrorMessage(e.getMessage());
		}
	}

	private void loginButtonActionPerformed() {
		String id = idField.getText();
		String password = String.valueOf(passwordField.getPassword());
		try {
			FieldValidator.validateField(id);
			FieldValidator.validateField(password);
			if (doctorButton.isSelected()) {
				loginDoctor(id, password);
			}
			else {
				loginUser(id, password);
			}
		} catch (Exception e) {
			MessageStatic.generateErrorMessage(e.getMessage());
		}
	

		
		/*
		try {
			
			UserDAOImp userController = new UserDAOImp();
			ResultSet result = userController.getUser(id, password);
			if (result.next()) {
				UserModel user = new UserModel(result.getString(2), result.getString(3), result.getString(1),
						result.getString(5), Integer.parseInt(result.getString(6)), null);
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
*/
	}

	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new main().setVisible(true);
			}
		});
	}

}
