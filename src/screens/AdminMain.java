
package screens;

import javax.swing.*;


public class AdminMain extends javax.swing.JFrame {
	
	
	 private JMenu usersMenu= new JMenu();
	 private JMenu patientsMenu= new JMenu();
	 private JMenu scheduleMenu= new JMenu();
	 private JMenu reportMenu= new JMenu();
	 private JMenuBar jMenuBar1 = new JMenuBar();
	 private JMenuItem addDoctorMenu= new JMenuItem();
	 private JMenuItem addPatientMenu= new JMenuItem();
	 private JMenuItem jMenuItem4 = new JMenuItem();
	 private JMenuItem addAdminMenu= new JMenuItem();
	 private JMenu logoutMenu= new JMenu();

    AddPatient addPatient;
    RegisterDoctorScreen registerDoctorScreen;
    RegisterConsultantScreen registerAdmin;
    AttendPatient editPatient;
    ScheduleAdmin schedule;
    GenerateReportAdmin report;

    public AdminMain() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        addScreens();
    }
    
    private void addScreens () {
    	addPatient = new AddPatient();
        registerDoctorScreen = new RegisterDoctorScreen();
        registerAdmin = new RegisterConsultantScreen();
        editPatient = new AttendPatient();
        schedule = new ScheduleAdmin();
        report = new GenerateReportAdmin();
        getContentPane().add(addPatient);
        getContentPane().add(registerDoctorScreen);
        getContentPane().add(registerAdmin);
        getContentPane().add(editPatient);
        getContentPane().add(schedule);
        getContentPane().add(report);
    }

   
    private void initComponents() {

        jMenuItem4.setText("jMenuItem4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 102, 102));

        usersMenu.setText("Users");

        addDoctorMenu.setText("Add new Doctor");
        addDoctorMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        usersMenu.add(addDoctorMenu);

        addAdminMenu.setText("Add new Admin");
        addAdminMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        usersMenu.add(addAdminMenu);

        jMenuBar1.add(usersMenu);

        patientsMenu.setText("Patients");

        addPatientMenu.setText("Add new Patient");
        addPatientMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        patientsMenu.add(addPatientMenu);

        jMenuBar1.add(patientsMenu);

        scheduleMenu.setText("Schedule");
        scheduleMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
       
        jMenuBar1.add(scheduleMenu);

        reportMenu.setText("Generate Report");
        reportMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu4MouseClicked(evt);
            }
        });
       
        jMenuBar1.add(reportMenu);

        logoutMenu.setText("Logout");
        logoutMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutMenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(logoutMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1235, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 738, Short.MAX_VALUE)
        );

        pack();
    }

    private void logoutMenuMouseClicked(java.awt.event.MouseEvent evt) {
         int option = JOptionPane.showConfirmDialog(null, "Do you really want to Log Out?", "Select", JOptionPane.YES_NO_OPTION);
            if (option == 0) {
                System.exit(0);
            }
    }

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {
        addPatient.setVisible(false);
        registerDoctorScreen.setVisible(true);
        registerAdmin.setVisible(false);
        editPatient.setVisible(false);
        report.setVisible(false);
    }

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {
        addPatient.setVisible(true);
        registerDoctorScreen.setVisible(false);
        registerAdmin.setVisible(false);
         editPatient.setVisible(false);
         report.setVisible(false);
    }

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {
        addPatient.setVisible(false);
        registerDoctorScreen.setVisible(false);
        registerAdmin.setVisible(true);
         editPatient.setVisible(false);
         report.setVisible(false);
    }

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {
        addPatient.setVisible(false);
        registerDoctorScreen.setVisible(false);
        registerAdmin.setVisible(false);
         editPatient.setVisible(false);
         schedule.setVisible(true);
         report.setVisible(false);
    }

    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {
        addPatient.setVisible(false);
        registerDoctorScreen.setVisible(false);
        registerAdmin.setVisible(false);
         editPatient.setVisible(false);
         schedule.setVisible(false);
         report.setVisible(true);
    }
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminMain().setVisible(true);
            }
        });
    }

    
 
  
}
