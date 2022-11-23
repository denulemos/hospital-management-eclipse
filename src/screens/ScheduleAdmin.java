package screens;

import controllers.DoctorController;
import controllers.ScheduleController;
import validators.DateValidator;
import validators.FieldValidator;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.Month;

import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.*;

public class ScheduleAdmin extends javax.swing.JInternalFrame {

	DoctorController doctorController = new DoctorController();
	ScheduleController scheduleController = new ScheduleController();

	private JButton getFreeAppointments;
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

		getFreeAppointments = new JButton();
		jScrollPane2 = new JScrollPane();
		resultTable = new JTable();
		specialtyLabel = new JLabel();
		patientId = new JTextField();
		patientLabel = new JLabel();
		cancelButton = new JButton();
		searchPatientButton = new JButton();
		specialtyField = new JTextField();
		specialtyField.setToolTipText("Example: General");

		getFreeAppointments.setText("Search  Appointments");

		getFreeAppointments.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				getFreeAppointmentsActionPerformed(evt);
			}
		});

		resultTable.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "ID", "Doctor", "Patient", "Date", "Taken", "Price", "Specialty" }) {
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
				jButton3ActionPerformed(evt);
			}
		});

		searchPatientButton.setText("Search Patient Appointments");
		searchPatientButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton5ActionPerformed(evt);
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
		
		JButton freeForSpecialtyButton = new JButton("Search Free Appointments for Specialty");
		
		JButton freeForDateButton = new JButton("Search Free Appointments for Date");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 986, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(layout.createSequentialGroup()
					.addGap(39)
					.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(cancelButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(getFreeAppointments, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(patientLabel)
						.addComponent(patientId, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchPatientButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
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
				.addGroup(Alignment.LEADING, layout.createSequentialGroup()
					.addGap(29)
					.addComponent(btnSaveChanges, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(802, Short.MAX_VALUE))
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
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
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
								.addComponent(minuteField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(layout.createSequentialGroup()
							.addComponent(getFreeAppointments)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(cancelButton)))
					.addPreferredGap(ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
					.addComponent(btnSaveChanges)
					.addGap(18)
					.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
					.addGap(16))
		);
		getContentPane().setLayout(layout);

		pack();
	}

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		this.setVisible(false);
	}

	private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
		DefaultTableModel model = (DefaultTableModel) resultTable.getModel();
		try {
			FieldValidator.validateField(patientId.getText());
			model.setRowCount(0);
			ResultSet results = scheduleController.getScheduleByPatient(patientId.getText());
			if (results.next()) {
				do {

					String[] row = { results.getString(1), results.getString(2), results.getString(3),
							results.getString(4), results.getString(5), results.getString(6), results.getString(7) };
					model.addRow(row);

				} while (results.next());
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	private void getFreeAppointmentsActionPerformed(java.awt.event.ActionEvent evt) {
		DefaultTableModel model = (DefaultTableModel) resultTable.getModel();
		DateValidator validator = new DateValidator();
		ScheduleController schedule = new ScheduleController();
		String id;
		model.setRowCount(0);
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
			if (!(dayField.getText().isEmpty())) {
				int hour, minute;
				int day = validator.dayValidator(dayField.getText());
				Month month = validator.monthValidator(monthField.getText());
				int year = validator.yearValidator(yearField.getText());
				if (!(hourField.getText().isEmpty())) {
					 hour = 00;
					 minute = 00;
				}
				else {
					 hour = validator.hourValidator(hourField.getText());
					 minute = validator.minuteValidator(minuteField.getText());
				}
				
				LocalDateTime time = validator.dateTimeConverter(month, day, year, hour, minute);
				ResultSet results = scheduleController.getScheduleByDoctorSingleDate(time);
				if (results.next()) {
					do {
						if (results.getString(5).equals('0')) {
							if (specialty.isEmpty()) {
								String[] row = { results.getString(1), results.getString(2), results.getString(3),
										results.getString(4), results.getString(5), results.getString(6),
										results.getString(7) };
								model.addRow(row);
							} else {
								if (results.getString(7).equals(specialty)) {
									String[] row = { results.getString(1), results.getString(2), results.getString(3),
											results.getString(4), results.getString(5), results.getString(6),
											results.getString(7) };
									model.addRow(row);
								}
							}

						}
					} while (results.next());
				}

			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}

	}
}