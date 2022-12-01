
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

@SuppressWarnings("serial")
public class AttendPatient extends javax.swing.JInternalFrame {

	PatientDAO patientController = new PatientDAOImp();

	private JTextArea historyPatient;
	private JButton searchButton, saveButton, cancelButton;
	private JLabel idLabel, historyLabel, jLabel3, jLabel5;
	private JScrollPane jScrollPane2;
	private JTextField patientId;
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
		getContentPane().setLayout(new GridLayout(4, 2, 0, 0));
		getContentPane().add(idLabel);
		getContentPane().add(patientId);
		historyLabel = new JLabel();

		historyLabel.setText("History");
		getContentPane().add(historyLabel);
		historyPatient = new JTextArea();
		getContentPane().add(historyPatient);

		historyPatient.setColumns(20);
		historyPatient.setRows(5);
		jScrollPane2 = new JScrollPane();
		resultTable = new JTable();

		resultTable.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Name", "ID " }));
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

			PatientModel result = patientController.get(patientId.getText());

			String[] row = { result.getFullname(), result.getId() };
			model.addRow(row);
			historyPatient.setText(result.getHistory());

		}

		catch (Exception e) {
			MessageStatic.generateErrorMessage(e.getMessage());
		}

	}

	private void saveButtonActionPerformed() {
		try {
			String id = (String) resultTable.getModel().getValueAt(0, 2);
			String fullname = (String) resultTable.getModel().getValueAt(0, 1);
			String history = historyPatient.getText();
			PatientModel user = new PatientModel(id, fullname, history );
			patientController.edit(user);
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
