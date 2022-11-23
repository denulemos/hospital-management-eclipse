package screens;

import controllers.ScheduleController;
import statics.UserStatic;
import validators.DateValidator;
import validators.PatientValidator;
import validators.ScheduleValidator;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.Month;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

public class ScheduleDoctor extends javax.swing.JInternalFrame {

	ScheduleController schedController = new ScheduleController();
	private JButton jButton1;
	private JButton jButton3;
	private JButton jButton4;
	private JButton jButton5;
	private JList<String> jList2;
	private JScrollPane jScrollPane2;
	private JScrollPane jScrollPane3;
	private JTable resultTable;
	private JTextField dayField;
	private JTextField monthField;
	private JTextField yearField;
	private JTextField hourField;
	private JTextField minuteField;

	public ScheduleDoctor() {
		initComponents();
	}

	private void refreshData() {
		try {
			DefaultTableModel model = (DefaultTableModel) resultTable.getModel();
			model.setRowCount(0);
			ResultSet results = schedController.getScheduleByDoctor(UserStatic.currentUser.getId());
			if (results.next()) {
				do {
					String[] row = { results.getString(1), results.getString(4), results.getString(3),
							results.getString(6), results.getString(5) };
					model.addRow(row);
				} while (results.next());
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "There was an error trying to get the appointments");
			System.out.println(e);
		}
	}

	private void initComponents() {

		jScrollPane3 = new JScrollPane();
		jList2 = new JList<>();
		jScrollPane2 = new JScrollPane();
		resultTable = new JTable();
		jButton1 = new JButton();
		jButton3 = new JButton();
		jButton4 = new JButton();
		jButton5 = new JButton();

		jList2.setModel(new AbstractListModel<String>() {
			String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };

			public int getSize() {
				return strings.length;
			}

			public String getElementAt(int i) {
				return strings[i];
			}
		});
		jScrollPane3.setViewportView(jList2);

		resultTable.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "ID", "Date", "Patient", "Price", "Taken?" }) {
			boolean[] canEdit = new boolean[] { false, false, true, true, true };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		resultTable.setColumnSelectionAllowed(true);
		resultTable.addContainerListener(new java.awt.event.ContainerAdapter() {
			public void componentAdded(java.awt.event.ContainerEvent evt) {
				componentAdded(evt);
			}
		});
		resultTable.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				focusGained(evt);
			}
		});
		resultTable.addComponentListener(new java.awt.event.ComponentAdapter() {
			public void componentShown(java.awt.event.ComponentEvent evt) {
				componentShown(evt);
			}
		});
		jScrollPane2.setViewportView(resultTable);

		jButton1.setText("Add Appointment");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton3.setText("Save Changes");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

		jButton4.setText("Cancel");
		jButton4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton4ActionPerformed(evt);
			}
		});

		jButton5.setText("Refresh");
		jButton5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton5ActionPerformed(evt);
			}
		});

		JLabel dayLabel = new JLabel("Day");

		JLabel monthLabel = new JLabel("Month");

		JLabel yearLabel = new JLabel("Year");

		JLabel hourLabel = new JLabel("Hour (24 Hs)");

		dayField = new JTextField();
		dayField.setToolTipText("Example: 12");
		dayField.setColumns(10);

		monthField = new JTextField();
		monthField.setToolTipText("Example: May");
		monthField.setColumns(10);

		yearField = new JTextField();
		yearField.setToolTipText("Example: 2020");
		yearField.setColumns(10);

		hourField = new JTextField();
		hourField.setToolTipText("Example: 21");
		hourField.setColumns(10);

		JLabel minuteLabel = new JLabel("Minute");

		minuteField = new JTextField();
		minuteField.setToolTipText("Example: 02");
		minuteField.setColumns(10);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
						.addGap(22)
						.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
								.addGroup(layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(dayField, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
												.addComponent(dayLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 49,
														Short.MAX_VALUE))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(layout.createParallelGroup(Alignment.LEADING)
												.addComponent(monthField, GroupLayout.PREFERRED_SIZE, 66,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(monthLabel, GroupLayout.PREFERRED_SIZE, 49,
														GroupLayout.PREFERRED_SIZE))))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
								.addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(jButton5, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(jButton4, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
								.addGroup(layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(yearField, 0, 0, Short.MAX_VALUE)
												.addComponent(yearLabel, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
										.addGap(18)
										.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
												.addGroup(layout.createSequentialGroup()
														.addComponent(hourField, GroupLayout.PREFERRED_SIZE, 49,
																GroupLayout.PREFERRED_SIZE)
														.addGap(43).addComponent(minuteField,
																GroupLayout.PREFERRED_SIZE, 49,
																GroupLayout.PREFERRED_SIZE))
												.addGroup(Alignment.TRAILING,
														layout.createSequentialGroup().addComponent(hourLabel)
																.addPreferredGap(ComponentPlacement.RELATED,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(minuteLabel, GroupLayout.PREFERRED_SIZE,
																		49, GroupLayout.PREFERRED_SIZE))))))
						.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jScrollPane2,
								GroupLayout.PREFERRED_SIZE, 652, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(46, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.TRAILING).addGroup(layout.createSequentialGroup()
				.addGap(24)
				.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(dayLabel).addComponent(monthLabel)
						.addComponent(yearLabel).addComponent(hourLabel).addComponent(minuteLabel))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(dayField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(monthField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(yearField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(hourField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(minuteField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(37)
				.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(jButton1).addComponent(jButton3)
						.addComponent(jButton5).addComponent(jButton4))
				.addGap(18).addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 283, GroupLayout.PREFERRED_SIZE)
				.addContainerGap()));
		getContentPane().setLayout(layout);

		pack();
	}

	private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
		this.setVisible(false);
	}
	

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		DateValidator validator = new DateValidator();
		String doctor = UserStatic.currentUser.getId();
		String specialty = UserStatic.currentUser.getSpecialty();
		int price = UserStatic.currentUser.getPrice();
		try {
			int day = validator.dayValidator(dayField.getText());
			int hour = validator.hourValidator(hourField.getText());
			int minute = validator.minuteValidator(minuteField.getText());
			Month month = validator.monthValidator(monthField.getText());
			int year = validator.yearValidator(yearField.getText());
			LocalDateTime time = validator.dateTimeConverter(month, day, year, hour, minute);
			ScheduleValidator.isScheduleOccuped(time, doctor);
			schedController.createSchedule(doctor, time, price, specialty);
			JOptionPane.showMessageDialog(null, "Appointment created");
			refreshData();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "There was an error:" + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
		refreshData();
	}

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		for (int i = 0; i < resultTable.getRowCount(); i++) {
			String id = (String) resultTable.getValueAt(i, 0);
			String patient = (String) resultTable.getValueAt(i, 2);
			int price = Integer.valueOf((String) resultTable.getValueAt(i, 3));
			String taken = (String) resultTable.getValueAt(i, 4);

			try {
				ScheduleValidator.validateTake(patient, taken);
				PatientValidator.checkIfUserExists(patient);
				schedController.updateSchedule(id, patient, price, taken);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}

		}

		JOptionPane.showMessageDialog(null, "Appointments Updated");
		refreshData();
	}

}