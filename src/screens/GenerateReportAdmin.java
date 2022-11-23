package screens;

import controllers.ScheduleController;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class GenerateReportAdmin extends javax.swing.JInternalFrame {

	ScheduleController schedController = new ScheduleController();
	private JLabel amountGain;
	private JTextField doctorField;
	private JButton jButton1;
	private JButton jButton2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel7;
	private JScrollPane jScrollPane2;
	private JTable resultTable;

	public GenerateReportAdmin() {
		initComponents();
	}

	private void initComponents() {

		jButton1 = new JButton();
		doctorField = new JTextField();
		jLabel3 = new JLabel();
		jButton2 = new JButton();
		jScrollPane2 = new JScrollPane();
		resultTable = new JTable();

		jLabel4 = new JLabel();
		jLabel5 = new JLabel();
		amountGain = new JLabel();
		jLabel7 = new JLabel();

		jButton1.setText("Generate Report");

		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jLabel3.setText("Doctor ID");

		jButton2.setText("Cancel");

		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		resultTable.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "ID", "Doctor", "Patient", "Date", "Taken", "Price" }) {
			boolean[] canEdit = new boolean[] { false, false, false, false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		resultTable.setRowSelectionAllowed(false);
		jScrollPane2.setViewportView(resultTable);

		jLabel4.setText("From");

		jLabel5.setText("To");

		jLabel7.setText("Generate Report");
		jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup().addGap(20, 20, 20).addComponent(amountGain)
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup().addContainerGap()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup().addGap(122, 122, 122)
												.addComponent(jLabel4).addGap(270, 270, 270).addComponent(jLabel3)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(jLabel5).addGap(102, 102, 102))
										.addComponent(jScrollPane2)

										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
												layout.createSequentialGroup().addGap(376, 376, 376).addGroup(layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
																layout.createSequentialGroup().addComponent(jButton2,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 136,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(355, 355, 355))
														.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
																layout.createSequentialGroup().addComponent(jButton1,
																		javax.swing.GroupLayout.PREFERRED_SIZE, 136,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(364, 364, 364)))))
								.addContainerGap())
				.addGroup(GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jLabel7).addGap(349, 349, 349)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addGap(17, 17, 17).addComponent(jLabel7).addGap(29, 29, 29)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(jLabel3)
						.addComponent(jLabel4).addComponent(jLabel5))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(doctorField,
						GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.PREFERRED_SIZE))

				.addGap(42, 42, 42).addComponent(jButton1).addGap(40, 40, 40)
				.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addGap(18, 18, 18).addComponent(jButton2)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(amountGain)
				.addContainerGap(53, Short.MAX_VALUE)));

		pack();
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
		this.setVisible(false);
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
		LocalDateTime from = fromDate.getDateTimePermissive();
		LocalDateTime to = toDate.getDateTimePermissive();

		if (from == null || to == null) {
			JOptionPane.showMessageDialog(null, "All fields must be filled");
			return;
		}

		String doctor = doctorField.getText();
		try {
			int amount = 0;
			DefaultTableModel model = (DefaultTableModel) resultTable.getModel();
			model.setRowCount(0);
			ResultSet results = schedController.getScheduleByDoctorByDates(doctor, from, to);
			if (results.next()) {
				do {
					if (results.getString(5).equals("1")) {
						amount += results.getInt(6);
					}

					String[] row = { results.getString(1), results.getString(2), results.getString(3),
							results.getString(4), results.getString(5), Integer.toString(results.getInt(6)) };
					model.addRow(row);
				} while (results.next());
			}
			amountGain.setText("Total = " + Integer.toString(amount) + "$");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "There was an error trying to get the appointments");
			System.out.println(e);
		}
	}

}