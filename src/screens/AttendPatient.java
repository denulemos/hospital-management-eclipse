
package screens;

import dao.PatientDAO;
import implementations.PatientDAOImp;
import models.PatientModel;
import statics.MessageStatic;
import validators.FieldValidator;
import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.GridLayout;

public class AttendPatient extends javax.swing.JInternalFrame {

	PatientDAO patientController = new PatientDAOImp();

	private JTextArea historyPatient;
	private JButton searchButton, saveButton, cancelButton;
	private JLabel idLabel, historyLabel, jLabel3, nameLabel, jLabel5, lastnameLabel;
	private JScrollPane jScrollPane2;
	private JTextField patientId, patientLastname, patientName;
	private JTable resultTable;

	public AttendPatient() {
		initComponents();
	}

	private void initComponents() {

		jLabel3 = new JLabel();
		jLabel5 = new JLabel();
		patientId = new JTextField();
		idLabel = new JLabel();

		jLabel3.setText("jLabel3");

		jLabel5.setText("Patient Name");

		idLabel.setText("Patient ID");
		getContentPane().setLayout(new GridLayout(7, 2, 0, 0));
		getContentPane().add(idLabel);
		getContentPane().add(patientId);
				nameLabel = new JLabel();
				
						nameLabel.setText("Patient Name");
						getContentPane().add(nameLabel);
				patientName = new JTextField();
				getContentPane().add(patientName);
				lastnameLabel = new JLabel();
				
						lastnameLabel.setText("Patient Lastname");
						getContentPane().add(lastnameLabel);
				patientLastname = new JTextField();
				getContentPane().add(patientLastname);
				historyLabel = new JLabel();
				
						historyLabel.setText("History");
						getContentPane().add(historyLabel);
				historyPatient = new JTextArea();
				getContentPane().add(historyPatient);
				
						historyPatient.setColumns(20);
						historyPatient.setRows(5);
				jScrollPane2 = new JScrollPane();
				resultTable = new JTable();
				
						resultTable.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {
				
						}, new String[] { "Name", "Lastname", "ID " }) {
							private static final long serialVersionUID = 1L;
							boolean[] canEdit = new boolean[] { false, false, false };
				
							public boolean isCellEditable(int rowIndex, int columnIndex) {
								return canEdit[columnIndex];
							}
						});
						resultTable.addMouseListener(new java.awt.event.MouseAdapter() {
							public void mouseClicked(java.awt.event.MouseEvent evt) {
								mouseClicked(evt);
							}
						});
						jScrollPane2.setViewportView(resultTable);
						getContentPane().add(jScrollPane2);
				cancelButton = new JButton();
				
						cancelButton.setText("Cancel");
						cancelButton.addActionListener(new java.awt.event.ActionListener() {
							public void actionPerformed(java.awt.event.ActionEvent evt) {
								cancelButtonActionPerformed();
							}
						});
						saveButton = new JButton();
						
								saveButton.setText("Save Changes");
								saveButton.addActionListener(new java.awt.event.ActionListener() {
									public void actionPerformed(java.awt.event.ActionEvent evt) {
										saveButtonActionPerformed();
									}
								});
								getContentPane().add(saveButton);
						getContentPane().add(cancelButton);
				searchButton = new JButton();
				
						searchButton.setText("Search");
						searchButton.addActionListener(new java.awt.event.ActionListener() {
							public void actionPerformed(java.awt.event.ActionEvent evt) {
								searchButtonActionPerformed();
							}
						});
						getContentPane().add(searchButton);

		pack();
	}

	private void searchButtonActionPerformed() {

		try {
			DefaultTableModel model = (DefaultTableModel) resultTable.getModel();
			model.setRowCount(0);
			PatientModel user = new PatientModel(patientId.getText(), patientLastname.getText(), patientName.getText(),
					null, null);

			ResultSet result = patientController.searchPatient(user);

			if (result.next()) {
				String[] row = { result.getString(3), result.getString(2), result.getString(1) };
				model.addRow(row);
				historyPatient.setText(result.getString(4));
			}

			else {
				MessageStatic.generateErrorMessage("User not found");
				return;
			}

		}

		catch (Exception e) {
			MessageStatic.generateErrorMessage(e.getMessage());
		}

	}

	private void saveButtonActionPerformed() {
		PatientModel user = new PatientModel((String) resultTable.getModel().getValueAt(0, 2),
				(String) resultTable.getModel().getValueAt(0, 1), (String) resultTable.getModel().getValueAt(0, 0),
				historyPatient.getText(), null);

		try {
			patientController.editPatient(user.getId(), user.getName(), user.getLastname(), user.getHistory());
			MessageStatic.generateMessage("Patient updated");
		}

		catch (Exception e) {
			MessageStatic.generateErrorMessage("There was an error updating the patient: " + e.getMessage());
		}

	}

	private void cancelButtonActionPerformed() {
		this.setVisible(false);
	}

}
