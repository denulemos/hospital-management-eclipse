package screens;

import controllers.ScheduleController;
import controllers.UserController;
import validators.DateValidator;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class GenerateReportDoctor extends javax.swing.JInternalFrame {

	ScheduleController schedController = new ScheduleController();
	DateValidator dateValidator = new DateValidator();

	private JLabel TotalAmount;
	private JLabel amountGain;

	private JButton jButton1;
	private JButton jButton2;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel6;
	private JScrollPane jScrollPane2;
	private JTable resultTable;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;

	public GenerateReportDoctor() {
		initComponents();
	}

	private void initComponents() {

		jLabel6 = new JLabel();
		jLabel1 = new JLabel();
		jLabel2 = new JLabel();
		jButton1 = new JButton();
		jButton2 = new JButton();
		jScrollPane2 = new JScrollPane();
		resultTable = new JTable();
		jLabel3 = new JLabel();
		TotalAmount = new JLabel();
		amountGain = new JLabel();

		jLabel6.setText("Register Doctor");
		jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

		jLabel1.setText("From");

		jLabel2.setText("To");

		jButton1.setText("Generate Report");

		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton2.setText("Cancel");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
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
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		lblNewLabel = new JLabel("Day");
		
		lblNewLabel_1 = new JLabel("Month");
		
		lblNewLabel_2 = new JLabel("Year");
		
		lblNewLabel_3 = new JLabel("Hour");
		
		lblNewLabel_4 = new JLabel("Minute");
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		
		lblNewLabel_5 = new JLabel("New label");
		
		lblNewLabel_6 = new JLabel("New label");
		
		lblNewLabel_7 = new JLabel("New label");
		
		lblNewLabel_8 = new JLabel("New label");
		
		lblNewLabel_9 = new JLabel("New label");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jLabel3)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addComponent(amountGain)
						.addComponent(TotalAmount))
					.addGap(195)
					.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(244))
				.addGroup(layout.createSequentialGroup()
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
							.addGap(83)
							.addComponent(jLabel1))
						.addGroup(layout.createSequentialGroup()
							.addContainerGap(73, Short.MAX_VALUE)
							.addGroup(layout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
									.addGroup(Alignment.LEADING, layout.createSequentialGroup()
										.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
									.addGroup(Alignment.LEADING, layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(Alignment.LEADING)
											.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGap(532)
										.addGroup(layout.createParallelGroup(Alignment.TRAILING)
											.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))))
								.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
									.addGroup(layout.createParallelGroup(Alignment.TRAILING)
										.addGroup(Alignment.LEADING, layout.createSequentialGroup()
											.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addGap(100)
											.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, 150, Short.MAX_VALUE)
											.addComponent(lblNewLabel_9, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
										.addGroup(layout.createSequentialGroup()
											.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, 530, Short.MAX_VALUE)
											.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)))
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGap(4)))
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel2)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
					.addGap(24))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGap(14)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLabel2)
						.addComponent(jLabel1))
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
							.addGap(18)
							.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel)
								.addGroup(layout.createSequentialGroup()
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(layout.createParallelGroup(Alignment.BASELINE)
										.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_1))))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_3))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_4)
								.addComponent(jButton1)
								.addComponent(jButton2))
							.addGap(35)
							.addGroup(layout.createParallelGroup(Alignment.TRAILING)
								.addGroup(layout.createSequentialGroup()
									.addComponent(amountGain)
									.addComponent(TotalAmount)
									.addGap(28)
									.addComponent(jLabel3))
								.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)))
						.addGroup(layout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_5))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_6))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_7))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_8))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_9))))
					.addContainerGap(23, Short.MAX_VALUE))
		);
		getContentPane().setLayout(layout);

		pack();
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		this.setVisible(false);
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		LocalDateTime from = fromDate.getDateTimePermissive();
		LocalDateTime to = toDate.getDateTimePermissive();

		String doctor = UserController.currentUser.getId();
		try {
			if (DateValidator.isDateFilled(from) && DateValidator.isDateFilled(to)) {
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
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
		}
	}

}