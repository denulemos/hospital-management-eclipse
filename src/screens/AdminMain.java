
package screens;

import javax.swing.*;


public class AdminMain extends javax.swing.JFrame {
	
	
	 private JMenu jMenu1= new JMenu();
	 private JMenu jMenu2= new JMenu();
	 private JMenu jMenu3= new JMenu();
	 private JMenu jMenu4= new JMenu();
	 private JMenuBar jMenuBar1 = new JMenuBar();
	 private JMenuItem jMenuItem1= new JMenuItem();
	 private JMenuItem jMenuItem2= new JMenuItem();
	 private JMenuItem jMenuItem4 = new JMenuItem();
	 private JMenuItem jMenuItem7= new JMenuItem();
	 private JMenu logoutMenu= new JMenu();

    AddPatient addPatient;
    RegisterDoctorScreen registerDoctorScreen;
    RegisterConsultantScreen registerAdmin;
    AttendPatient editPatient;

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
        add(addPatient);
        add(registerDoctorScreen);
        add(registerAdmin);
        add(editPatient);
    }

   
    private void initComponents() {

        jMenuItem4.setText("jMenuItem4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 102, 102));

        jMenu1.setText("Users");

        jMenuItem1.setText("Add new Doctor");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem7.setText("Add new Admin");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Patients");

        jMenuItem2.setText("Add new Patient");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Schedule");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        jMenu4.setText("Generate Report");
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu4MouseClicked(evt);
            }
        });
        jMenu4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu4);

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
    }

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {
        addPatient.setVisible(true);
        registerDoctorScreen.setVisible(false);
        registerAdmin.setVisible(false);
         editPatient.setVisible(false);
    }

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {
        addPatient.setVisible(false);
        registerDoctorScreen.setVisible(false);
        registerAdmin.setVisible(true);
         editPatient.setVisible(false);
    }

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {
        addPatient.setVisible(false);
        registerDoctorScreen.setVisible(false);
        registerAdmin.setVisible(false);
         editPatient.setVisible(false);
    }

    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {
        addPatient.setVisible(false);
        registerDoctorScreen.setVisible(false);
        registerAdmin.setVisible(false);
         editPatient.setVisible(false);
    }
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminMain().setVisible(true);
            }
        });
    }

    
 
  
}
