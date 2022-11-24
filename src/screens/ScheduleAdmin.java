package screens;

import controllers.DoctorController;
import controllers.ScheduleController;
import exceptions.EmptyFieldException;
import statics.MessageStatic;
import validators.*;
import java.sql.ResultSet;
import java.time.*;

import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.*;

public class ScheduleAdmin extends javax.swing.JInternalFrame {

	DoctorController doctorController = new DoctorController();
	ScheduleController scheduleController = new ScheduleController();
	private JButton cancelButton;
	private JButton searchPatientButton;
	private JLabel patientLabel;
	private JLabel specialtyLabel;
	private JScrollPane jScrollPane2;
	private JTextField patientId;
	private JTable resultTable;
	private JTextField specialtyField;
	private JLabel dayLabel;
	private JLabel monthLabel;
	private JLabel yearLabel;
	private JTextField dayField;
	private JTextField yearField;
	private JTextField monthField;
	private JLabel hourLabel;
	private JTextField hourField;
	private JLabel minuteLabel;
	private JTextField minuteField;

	public ScheduleAdmin() {
		initComponents();
	}

	private void initComponents() {
		jScrollPane2 = new JScrollPane();
		resultTable = new JTable();
		specialtyLabel = new JLabel();
		patientId = new JTextField();
		patientLabel = new JLabel();
		cancelButton = new JButton();
		searchPatientButton = new JButton();
		specialtyField = new JTextField();
		specialtyField.setToolTipText("Example: General");

		resultTable.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "ID", "Doctor", "Patient", "Date", "Taken", "Price", "Specialty" }) {
			private static final long serialVersionUID = 1L;
			boolean[] canEdit = new boolean[] { false, false, true, false, true, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		jScrollPane2.setViewportView(resultTable);

		specialtyLabel.setText("Specialty");

		patientLabel.setText("Patient ID");

		cancelButton.setText("Cancel");
		cancelButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cancelButtonActionPerformed();
			}
		});

		searchPatientButton.setText("Search Patient Appointments");
		searchPatientButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				searchPatientButtonActionPerformed();
			}
		});

		dayLabel = new JLabel("Day");

		monthLabel = new JLabel("Month");

		yearLabel = new JLabel("Year");

		dayField = new JTextField();
		dayField.setToolTipText("Example: 10");
		dayField.setColumns(10);

		yearField = new JTextField();
		yearField.setToolTipText("Example: Year");
		yearField.setColumns(10);

		monthField = new JTextField();
		monthField.setToolTipText("Example: May");
		monthField.setColumns(10);

		hourLabel = new JLabel("Hour (24 hs)");

		hourField = new JTextField();
		hourField.setToolTipText("Example: 21");
		hourField.setColumns(10);

		minuteLabel = new JLabel("Minute");

		minuteField = new JTextField();
		minuteField.setToolTipText("Example: 20");
		minuteField.setColumns(10);
		
		JButton btnSaveChanges = new JButton();
		btnSaveChanges.setText("Save Changes");
		btnSaveChanges.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnSaveChangesActionPerformed();
			}
		});
		
		JButton freeForSpecialtyButton = new JButton("Search Free Appointments for Specialty");
		freeForSpecialtyButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				freeForSpecialtyButtonActionPerformed();
			}
		});
		
		JButton freeForDateButton = new JButton("Search Free Appointments for Date");
		freeForDateButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				freeForDateButtonActionPerformed();
			}
		});

		GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 1116, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(layout.createSequentialGroup()
					.addGap(39)
					.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(patientLabel, Alignment.LEADING)
						.addComponent(patientId, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchPatientButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
							.addComponent(minuteLabel, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(minuteField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup()
							.addComponent(yearLabel, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(yearField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(specialtyLabel)
						.addGroup(layout.createSequentialGroup()
							.addComponent(monthLabel, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(monthField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup()
							.addComponent(hourLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(hourField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup()
							.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addComponent(specialtyField, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
								.addGroup(layout.createSequentialGroup()
									.addComponent(dayLabel, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(dayField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(42)
							.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(freeForDateButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(freeForSpecialtyButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addGap(363))
				.addGroup(layout.createSequentialGroup()
					.addGap(29)
					.addComponent(btnSaveChanges, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(cancelButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(747))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGap(43)
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
							.addComponent(specialtyLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(specialtyField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(freeForSpecialtyButton)))
						.addGroup(layout.createSequentialGroup()
							.addComponent(patientLabel)
							.addGap(6)
							.addComponent(patientId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(searchPatientButton)
								.addComponent(dayLabel)
								.addComponent(dayField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(freeForDateButton))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(monthLabel)
						.addComponent(monthField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(yearLabel)
						.addComponent(yearField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(24)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(hourLabel)
						.addComponent(hourField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addComponent(minuteLabel)
						.addComponent(minuteField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSaveChanges)
						.addComponent(cancelButton))
					.addGap(18)
					.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
					.addGap(16))
		);
		getContentPane().setLayout(layout);

		pack();
	}

	private void cancelButtonActionPerformed() {
		this.setVisible(false);
	}

	private void searchPatientButtonActionPerformed() {
		DefaultTableModel model = (DefaultTableModel) resultTable.getModel();
		try {
			String patient = patientId.getText();
			FieldValidator.validateField(patient);
			model.setRowCount(0);
			ResultSet results = scheduleController.getScheduleByPatient(patient);
			if (results.next()) {
				do {

					String[] row = { results.getString(1), results.getString(2), results.getString(3),
							results.getString(4), results.getString(5), results.getString(6), results.getString(7) };
					model.addRow(row);

				} while (results.next());
			}
		} catch (Exception e) {
			MessageStatic.generateErrorMessage(e.getMessage());
		}

	}
	
	public void btnSaveChangesActionPerformed() {
		ScheduleController schedule = new ScheduleController();
		for (int i = 0; i < resultTable.getRowCount(); i++) {
			String id = (String) resultTable.getValueAt(i, 0);
			String patient = (String) resultTable.getValueAt(i, 2);
			int price = Integer.valueOf((String) resultTable.getValueAt(i, 5));
			String taken = (String) resultTable.getValueAt(i, 4);
			try {
				schedule.updateSchedule(id, patient, price, taken);
			} catch (Exception e) {
				MessageStatic.generateErrorMessage(e.getMessage());
			}

		}

		MessageStatic.generateMessage("Appointments Updated");
		
	}
	
	
	public void freeForSpecialtyButtonActionPerformed() {
		
		DefaultTableModel model = (DefaultTableModel) resultTable.getModel();
		model.setRowCount(0);
		ScheduleController schedule = new ScheduleController();
		String id;
		String specialty = specialtyField.getText();
		try {

			if (!specialty.isEmpty()) {
				ResultSet results = doctorController.getDoctorBySpecialty(specialty);
				ResultSet doctorResult;
				if (results.next()) {
					do {
						id = results.getString(1);
						doctorResult = schedule.getFreeScheduleByDoctor(id);
						if (doctorResult.next()) {
							do {
								if (doctorResult.getInt(5) == 0) {
									String[] row = { doctorResult.getString(1), doctorResult.getString(2), doctorResult.getString(3),
											doctorResult.getString(4), doctorResult.getString(5), doctorResult.getString(6) };
									model.addRow(row);
								}
							} while (doctorResult.next());
						}

					} while (results.next());
				}

			}
			else {
				throw new EmptyFieldException();
			}
		
		} catch (Exception e) {
			MessageStatic.generateErrorMessage(e.getMessage());
		}
		
	}
	
	public void freeForDateButtonActionPerformed() {
		DateValidator validator = new DateValidator();
		DefaultTableModel model = (DefaultTableModel) resultTable.getModel();
		model.setRowCount(0);
		ResultSet results;
		try {
		if (!(dayField.getText().isEmpty())) {
			int hour, minute;
			int day = validator.dayValidator(dayField.getText());
			Month month = validator.monthValidator(monthField.getText());
			int year = validator.yearValidator(yearField.getText());
			if (hourField.getText().isEmpty() || minuteField.getText().isEmpty()) {
				 hour = 00;
				 minute = 00;
				 LocalDate time = validator.dateConverter(month, day, year);
				 results =  scheduleController.getScheduleByDoctorSingleDate(String.valueOf(time));
			}
			else {
				 hour = validator.hourValidator(hourField.getText());
				 minute = validator.minuteValidator(minuteField.getText());
				 LocalDateTime time = validator.dateTimeConverter(month, day, year, hour, minute);
				 results =  scheduleController.getScheduleByDoctorSingleDate(String.valueOf(time));
			}
			
		
			if (results.next()) {
				do {
					if (results.getInt(5) == 0) {
						
							String[] row = { results.getString(1), results.getString(2), results.getString(3),
									results.getString(4), results.getString(5), results.getString(6),
									results.getString(7) };
							model.addRow(row);
						

					}
				} while (results.next());
			}

		}
		else {
			throw new EmptyFieldException();
		}
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	}
	}
}