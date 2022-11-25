package screens;

import controllers.ScheduleController;
import dao.ScheduleDAO;
import validators.DateValidator;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.Month;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class GenerateReportAdmin extends javax.swing.JInternalFrame {

	ScheduleDAO schedController = new ScheduleController();
	DateValidator dateValidator = new DateValidator();
	
	private JLabel amountGain;
	private JButton generateReportButton;
	private JButton cancelButton;
	private JLabel fromLabel;
	private JLabel toLabel;
	private JScrollPane jScrollPane2;
	private JTable resultTable;
	private JTextField fromDayInput;
	private JTextField fromMonthInput;
	private JTextField fromYearInput;
	private JTextField fromHourInput;
	private JTextField fromMinuteInput;
	private JLabel dayLabel;
	private JLabel monthLabel;
	private JLabel yearLabel;
	private JLabel hourLabel;
	private JLabel minuteLabel;
	private JTextField toDayInput;
	private JTextField toMonthInput;
	private JTextField toYearInput;
	private JTextField toHourInput;
	private JTextField toMinuteInput;
	private JLabel lblDay;
	private JLabel lblMonth;
	private JLabel lblYear;
	private JLabel lblHour;
	private JLabel lblMinute;
	private JTextField doctorField;

	public GenerateReportAdmin() {
		initComponents();
	}

	private void initComponents() {

		fromLabel = new JLabel();
		toLabel = new JLabel();
		generateReportButton = new JButton();
		cancelButton = new JButton();
		jScrollPane2 = new JScrollPane();
		resultTable = new JTable();
		amountGain = new JLabel();

		fromLabel.setText("From");

		toLabel.setText("To");

		generateReportButton.setText("Generate Report");

		generateReportButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		cancelButton.setText("Cancel");
		cancelButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		resultTable.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "ID", "Patient", "Date", "Taken", "Price" }) {
			boolean[] canEdit = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		jScrollPane2.setViewportView(resultTable);

		fromDayInput = new JTextField();
		fromDayInput.setColumns(10);

		fromMonthInput = new JTextField();
		fromMonthInput.setColumns(10);

		fromYearInput = new JTextField();
		fromYearInput.setColumns(10);

		fromHourInput = new JTextField();
		fromHourInput.setColumns(10);

		fromMinuteInput = new JTextField();
		fromMinuteInput.setColumns(10);

		dayLabel = new JLabel("Day");

		monthLabel = new JLabel("Month");

		yearLabel = new JLabel("Year");

		hourLabel = new JLabel("Hour");

		minuteLabel = new JLabel("Minute");

		toDayInput = new JTextField();
		toDayInput.setColumns(10);

		toMonthInput = new JTextField();
		toMonthInput.setColumns(10);

		toYearInput = new JTextField();
		toYearInput.setColumns(10);

		toHourInput = new JTextField();
		toHourInput.setColumns(10);

		toMinuteInput = new JTextField();
		toMinuteInput.setColumns(10);

		lblDay = new JLabel("Day");

		lblMonth = new JLabel("Month");

		lblYear = new JLabel("Year");

		lblHour = new JLabel("Hour");

		lblMinute = new JLabel("Minute");

		doctorField = new JTextField();
		doctorField.setColumns(10);

		JLabel doctorLabel = new JLabel("Doctor");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(layout.createSequentialGroup().addContainerGap(16, Short.MAX_VALUE).addComponent(amountGain)
						.addGap(195)
						.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(244))
				.addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(83).addComponent(fromLabel)).addGroup(layout
								.createSequentialGroup().addContainerGap(73,
										Short.MAX_VALUE)
								.addGroup(layout
										.createParallelGroup(Alignment.TRAILING)
										.addComponent(dayLabel, GroupLayout.PREFERRED_SIZE, 49,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(monthLabel, GroupLayout.PREFERRED_SIZE, 49,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(yearLabel, GroupLayout.PREFERRED_SIZE, 49,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(hourLabel, GroupLayout.PREFERRED_SIZE, 49,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(minuteLabel, GroupLayout.PREFERRED_SIZE, 49,
												GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(Alignment.TRAILING).addGroup(layout
										.createParallelGroup(Alignment.LEADING, false)
										.addGroup(layout
												.createSequentialGroup().addComponent(fromYearInput,
														GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addComponent(lblYear, GroupLayout.PREFERRED_SIZE, 49,
														GroupLayout.PREFERRED_SIZE))
										.addGroup(layout.createSequentialGroup()
												.addGroup(layout.createParallelGroup(Alignment.LEADING)
														.addComponent(fromDayInput, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(fromMonthInput, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
												.addGap(174)
												.addGroup(layout.createParallelGroup(Alignment.LEADING)
														.addComponent(doctorField, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(doctorLabel, GroupLayout.PREFERRED_SIZE, 49,
																GroupLayout.PREFERRED_SIZE))
												.addGap(262)
												.addGroup(layout.createParallelGroup(Alignment.TRAILING)
														.addComponent(lblDay, GroupLayout.PREFERRED_SIZE, 49,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblMonth, GroupLayout.PREFERRED_SIZE, 49,
																GroupLayout.PREFERRED_SIZE))))
										.addGroup(layout.createSequentialGroup().addGroup(layout
												.createParallelGroup(Alignment.LEADING)
												.addGroup(layout.createSequentialGroup()
														.addComponent(fromMinuteInput, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addGap(100)
														.addComponent(generateReportButton, GroupLayout.PREFERRED_SIZE,
																136, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 136,
																GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED, 150,
																Short.MAX_VALUE)
														.addComponent(lblMinute, GroupLayout.PREFERRED_SIZE, 49,
																GroupLayout.PREFERRED_SIZE))
												.addGroup(layout.createSequentialGroup()
														.addComponent(fromHourInput, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED, 532,
																Short.MAX_VALUE)
														.addComponent(lblHour, GroupLayout.PREFERRED_SIZE, 49,
																GroupLayout.PREFERRED_SIZE)))
												.addPreferredGap(ComponentPlacement.RELATED)))
								.addGap(4)))
						.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addComponent(toDayInput, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
								.addComponent(toLabel)
								.addComponent(toMonthInput, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
								.addComponent(toYearInput, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
								.addComponent(toHourInput, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
								.addComponent(toMinuteInput, GroupLayout.PREFERRED_SIZE, 86,
										GroupLayout.PREFERRED_SIZE))
						.addGap(24)));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
				.addGap(14)
				.addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(toLabel).addComponent(fromLabel))
				.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(18)
								.addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(dayLabel)
										.addGroup(layout.createSequentialGroup()
												.addGroup(layout.createParallelGroup(Alignment.BASELINE)
														.addComponent(fromDayInput, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(doctorLabel))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(layout.createParallelGroup(Alignment.BASELINE)
														.addComponent(fromMonthInput, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(monthLabel).addComponent(doctorField,
																GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(Alignment.BASELINE)
										.addComponent(fromYearInput, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(yearLabel))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(Alignment.BASELINE)
										.addComponent(fromHourInput, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(hourLabel))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(Alignment.BASELINE)
										.addComponent(fromMinuteInput, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(minuteLabel).addComponent(generateReportButton)
										.addComponent(cancelButton))
								.addGap(35)
								.addGroup(layout.createParallelGroup(Alignment.TRAILING)
										.addGroup(layout.createSequentialGroup().addComponent(amountGain).addGap(28))
										.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 177,
												GroupLayout.PREFERRED_SIZE)))
						.addGroup(layout.createSequentialGroup().addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(layout.createParallelGroup(Alignment.BASELINE)
										.addComponent(toDayInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblDay))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(Alignment.BASELINE)
										.addComponent(toMonthInput, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblMonth))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(Alignment.BASELINE)
										.addComponent(toYearInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblYear))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(Alignment.BASELINE)
										.addComponent(toHourInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblHour))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(Alignment.BASELINE)
										.addComponent(toMinuteInput, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblMinute))))
				.addContainerGap(31, Short.MAX_VALUE)));
		getContentPane().setLayout(layout);

		pack();
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		this.setVisible(false);
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		String doctor = doctorField.getText();
		int hour, minute, day, year;
		Month month;

		try {
			DateValidator validator = new DateValidator();
			// Set From
			day = validator.dayValidator(fromDayInput.getText());
			month = validator.monthValidator(fromMonthInput.getText());
			year = validator.yearValidator(fromYearInput.getText());

			if (fromHourInput.getText().isEmpty()) {
				hour = 00;
			} else {
				hour = validator.hourValidator(fromHourInput.getText());
			}

			if (fromMinuteInput.getText().isEmpty()) {
				minute = 00;
			} else {
				minute = validator.minuteValidator(fromMinuteInput.getText());
			}

			LocalDateTime from = validator.dateTimeConverter(month, day, year, hour, minute);

			// Set To
			day = validator.dayValidator(toDayInput.getText());
			month = validator.monthValidator(toMonthInput.getText());
			year = validator.yearValidator(toYearInput.getText());

			if (fromHourInput.getText().isEmpty()) {
				hour = 00;
			} else {
				hour = validator.hourValidator(toHourInput.getText());
			}

			if (fromMinuteInput.getText().isEmpty()) {
				minute = 00;
			} else {
				minute = validator.minuteValidator(toMinuteInput.getText());
			}
			LocalDateTime to = validator.dateTimeConverter(month, day, year, hour, minute);

			int amount = 0;
			DefaultTableModel model = (DefaultTableModel) resultTable.getModel();
			model.setRowCount(0);
			ResultSet results = schedController.getScheduleByDoctorByDates(doctor, from, to);
			if (results.next()) {
				do {
					if (results.getString(5).equals("1")) {
						amount += results.getInt(6);
					}
					String[] row = { results.getString(1), results.getString(3), results.getString(4),
							results.getString(5), results.getString(6) };
					model.addRow(row);
				} while (results.next());
			}
			amountGain.setText("Total = " + Integer.toString(amount) + "$");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
		}
	}
}