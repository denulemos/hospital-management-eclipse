package screens;

import controllers.DoctorController;
import controllers.ScheduleController;
import validators.DateValidator;
import validators.FieldValidator;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.*;

public class ScheduleAdmin extends javax.swing.JInternalFrame {

	DoctorController doctorController = new DoctorController();
	ScheduleController scheduleController = new ScheduleController();

	private JButton getFreeAppointments;
	private JButton jButton3;
	private JButton jButton4;
	private JButton jButton5;
	private JLabel jLabel3;
	private JLabel jLabel4;
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
	private JTextField textField;
	private JLabel minuteLabel;
	private JTextField minuteField;

	public ScheduleAdmin() {
		initComponents();
	}

	private void initComponents() {

		jButton4 = new javax.swing.JButton();
		getFreeAppointments = new javax.swing.JButton();
		jScrollPane2 = new javax.swing.JScrollPane();
		resultTable = new javax.swing.JTable();
		jLabel4 = new javax.swing.JLabel();
		patientId = new javax.swing.JTextField();
		jLabel3 = new javax.swing.JLabel();
		jButton3 = new javax.swing.JButton();
		jButton5 = new javax.swing.JButton();
		specialtyField = new javax.swing.JTextField();
		specialtyField.setToolTipText("Example: General");

		jButton4.setText("Search Appointment");

		getFreeAppointments.setText("Search Free Appointments");

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

		jLabel4.setText("Specialty");

		jLabel3.setText("Patient ID");

		jButton3.setText("Cancel");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

		jButton5.setText("Search Patient Appointments");
		jButton5.addActionListener(new java.awt.event.ActionListener() {
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

		textField = new JTextField();
		textField.setToolTipText("Example: 21");
		textField.setColumns(10);

		minuteLabel = new JLabel("Minute");

		minuteField = new JTextField();
		minuteField.setToolTipText("Example: 20");
		minuteField.setColumns(10);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 986, Short.MAX_VALUE).addContainerGap())
				.addGroup(layout.createSequentialGroup().addGap(39).addGroup(layout
						.createParallelGroup(Alignment.LEADING, false)
						.addComponent(jButton3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(getFreeAppointments, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addComponent(jLabel3)
						.addComponent(patientId, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
						.addComponent(jButton5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addPreferredGap(ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
								.addComponent(minuteLabel, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
								.addGap(18).addComponent(minuteField, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(layout.createSequentialGroup()
										.addComponent(yearLabel, GroupLayout.PREFERRED_SIZE, 49,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(yearField,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addComponent(jLabel4)
								.addComponent(specialtyField, GroupLayout.PREFERRED_SIZE, 183,
										GroupLayout.PREFERRED_SIZE)
								.addGroup(layout.createSequentialGroup()
										.addComponent(dayLabel, GroupLayout.PREFERRED_SIZE, 49,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(dayField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(layout.createSequentialGroup()
										.addComponent(monthLabel, GroupLayout.PREFERRED_SIZE, 49,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(monthField,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(layout.createSequentialGroup().addComponent(hourLabel)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(textField,
												GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)))
						.addGap(494)));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
				.addGap(43)
				.addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
						.addComponent(jLabel4).addPreferredGap(ComponentPlacement.RELATED).addComponent(specialtyField,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup().addComponent(jLabel3).addGap(6)
								.addComponent(patientId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(jButton5)
										.addComponent(dayLabel).addComponent(dayField, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(monthLabel).addComponent(
								monthField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(yearLabel).addComponent(
								yearField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
						.addGap(24)
						.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(hourLabel).addComponent(
								textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(minuteLabel).addComponent(
								minuteField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)))
						.addGroup(layout.createSequentialGroup().addComponent(getFreeAppointments)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(jButton3)))
				.addPreferredGap(ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
				.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE).addGap(16)));
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
		model.setRowCount(0);
		String specialty = specialtyField.getText();

		LocalDateTime time = scheduleAdminPicker.getDateTimePermissive();
		if (!specialty.isEmpty()) {
			try {
				ResultSet results = doctorController.getDoctorBySpecialty(specialty);
				if (results.next()) {
					do {
						if (results.getString(5).equals('0')) {
							String[] row = { results.getString(1), results.getString(2), results.getString(3),
									results.getString(4), results.getString(5), results.getString(6),
									results.getString(7) };
							model.addRow(row);
						}
					} while (results.next());
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (!(time == null)) {
			try {
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
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}