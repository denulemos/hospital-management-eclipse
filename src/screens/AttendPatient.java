
package screens;

import controllers.PatientController;
import dao.PatientDAO;
import models.PatientModel;
import statics.MessageStatic;
import validators.FieldValidator;
import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AttendPatient extends javax.swing.JInternalFrame {

	PatientDAO patientController = new PatientController();

	private JTextArea historyPatient;
	private JButton searchButton, saveButton, cancelButton;
	private JLabel idLabel, historyLabel, jLabel3, nameLabel, jLabel5, lastnameLabel, patientLabel;
	private JScrollPane jScrollPane1, jScrollPane2;
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
		searchButton = new JButton();
		jScrollPane2 = new JScrollPane();
		resultTable = new JTable();
		jScrollPane1 = new JScrollPane();
		historyPatient = new JTextArea();
		historyLabel = new JLabel();
		saveButton = new JButton();
		cancelButton = new JButton();
		patientName = new JTextField();
		nameLabel = new JLabel();
		patientLastname = new JTextField();
		lastnameLabel = new JLabel();
		patientLabel = new JLabel();

		jLabel3.setText("jLabel3");

		jLabel5.setText("Patient Name");

		idLabel.setText("Patient ID");

		searchButton.setText("Search");
		searchButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				searchButtonActionPerformed();
			}
		});

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

		historyPatient.setColumns(20);
		historyPatient.setRows(5);
		jScrollPane1.setViewportView(historyPatient);

		historyLabel.setText("History");

		saveButton.setText("Save Changes");
		saveButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				saveButtonActionPerformed();
			}
		});

		cancelButton.setText("Cancel");
		cancelButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cancelButtonActionPerformed();
			}
		});

		nameLabel.setText("Patient Name");

		lastnameLabel.setText("Patient Lastname");

		patientLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
		patientLabel.setText("Patient");

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(106, 106, 106)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(searchButton).addComponent(idLabel)
												.addComponent(patientId, javax.swing.GroupLayout.PREFERRED_SIZE, 166,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGroup(layout.createSequentialGroup().addComponent(saveButton)
														.addGap(18, 18, 18).addComponent(cancelButton,
																javax.swing.GroupLayout.PREFERRED_SIZE, 113,
																javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40,
												Short.MAX_VALUE)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(historyLabel).addComponent(jScrollPane1,
														javax.swing.GroupLayout.PREFERRED_SIZE, 326,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addContainerGap(27, Short.MAX_VALUE))
								.addGroup(layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(patientLabel)
												.addGroup(layout.createSequentialGroup().addGroup(layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(nameLabel).addComponent(patientName,
																javax.swing.GroupLayout.PREFERRED_SIZE, 166,
																javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGap(40, 40, 40)
														.addGroup(layout
																.createParallelGroup(
																		javax.swing.GroupLayout.Alignment.LEADING)
																.addComponent(lastnameLabel)
																.addComponent(patientLastname,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 166,
																		javax.swing.GroupLayout.PREFERRED_SIZE))))
										.addGap(0, 0, Short.MAX_VALUE)))));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addGap(18, 18, 18).addComponent(patientLabel).addGap(34, 34, 34)
				.addComponent(idLabel).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(patientId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
						.addGroup(layout.createSequentialGroup().addComponent(nameLabel)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(
										patientName, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup().addComponent(lastnameLabel)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(patientLastname, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
				.addGap(29, 29, 29).addComponent(searchButton)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
				.addComponent(historyLabel).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 141,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(saveButton).addComponent(cancelButton)))
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204,
								javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGap(17, 17, 17)));

		pack();
	}

	private void searchButtonActionPerformed() {

		try {
			FieldValidator.validateField(patientId.getText());
			FieldValidator.validateField(patientName.getText());
			FieldValidator.validateField(patientLastname.getText());
			PatientModel user = new PatientModel(patientId.getText(), patientLastname.getText(), patientName.getText(),
					null, null);

			ResultSet result = patientController.searchPatient(user);

			if (result.next()) {
				DefaultTableModel model = (DefaultTableModel) resultTable.getModel();
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
