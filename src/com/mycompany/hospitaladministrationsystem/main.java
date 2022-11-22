package com.mycompany.hospitaladministrationsystem;

import screens.DoctorMain;
import statics.UserStatic;
import screens.AdminMain;
import controllers.UserController;
import exceptions.DBException;
import exceptions.EmptyFieldException;
import models.UserModel;
import provider.ConnectionProvider;
import validators.FieldValidator;
import validators.UserValidator;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.*;
import java.awt.event.*;

public class main extends javax.swing.JFrame {
	DoctorMain doctorMain;
	AdminMain adminMain;
	Connection connection;

	private JTextField idField;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel7;
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
			doctorMain = new DoctorMain();
			adminMain = new AdminMain();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	private void initComponents() {

		passwordField = new JPasswordField();
		idField = new JTextField();
		loginButton = new JButton();
		jLabel1 = new JLabel();
		jLabel2 = new JLabel();
		jLabel7 = new JLabel();

		loginButton.setText("Login");
		jLabel1.setText("ID");
		jLabel2.setText("Password");
		jLabel7.setText("Medical Administration System");

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		passwordField.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				actionPerformed(evt);
			}
		});

		loginButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				loginButtonActionPerformed(evt);
			}
		});

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(124, 124, 124).addComponent(jLabel7))
						.addGroup(layout.createSequentialGroup().addGap(169, 169, 169)
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
										.addComponent(jLabel2).addComponent(jLabel1)
										.addComponent(loginButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(idField).addComponent(passwordField, GroupLayout.PREFERRED_SIZE,
												206, GroupLayout.PREFERRED_SIZE))))
				.addContainerGap(123, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addGap(52, 52, 52).addComponent(jLabel7).addGap(68, 68, 68)
				.addComponent(jLabel1).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(idField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addGap(13, 13, 13).addComponent(jLabel2)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
				.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE)
				.addGap(35, 35, 35).addComponent(loginButton).addContainerGap(146, Short.MAX_VALUE)));

		pack();
	}

	private void loginButtonActionPerformed(ActionEvent evt) {
		String id = idField.getText();
		String password = String.valueOf(passwordField.getPassword());

		try {
			FieldValidator.validateField(id);
			FieldValidator.validateField(password);
			UserController userController = new UserController();
			ResultSet result = userController.getUser(id, password);
			if (result.next()) {
				UserModel user;
				user = UserStatic.setGlobalUser(result.getString(2), result.getString(3), result.getString(1),
						result.getString(5), Integer.parseInt(result.getString(6)));

				if (UserValidator.isDoctor(user)) {
					doctorMain.setVisible(true);
					new main().setVisible(false);
				} else {
					adminMain.setVisible(true);
					new main().setVisible(false);
				}
				JOptionPane.showMessageDialog(null, "Welcome " + user.getName() + " " + user.getLastname() + "!");
			} else {
				JOptionPane.showMessageDialog(null, "User not found");
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
