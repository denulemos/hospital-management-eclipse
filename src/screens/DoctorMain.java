
package screens;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.*;

public class DoctorMain extends javax.swing.JFrame {
    
    AttendPatient attendPatient;
    ScheduleDoctor schedule;
    GenerateReportDoctor report;
    
    // components
    private JMenu LogOutMenu;
    private JMenu ScheduleMenu;
    private JMenu reportMenu;
    private JMenu patientMenu;
    private JMenuBar menuDoctor;

    public DoctorMain() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        attendPatient = new AttendPatient();
        schedule = new ScheduleDoctor();
        report = new GenerateReportDoctor();
        getContentPane().add(attendPatient);
        getContentPane().add(schedule);
        getContentPane().add(report);
    }


    private void initComponents() {

        menuDoctor = new JMenuBar();
        ScheduleMenu = new JMenu();
        reportMenu = new JMenu();
        patientMenu = new JMenu();
        LogOutMenu = new JMenu();


        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(UIManager.getDefaults().getColor("Button.default.hoverBorderColor"));

        ScheduleMenu.setText("Schedule");

        ScheduleMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ScheduleMenuMouseClicked();
            }
        });
       
        menuDoctor.add(ScheduleMenu);

        reportMenu.setText("Generate Report");
        reportMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	reportMenuMouseClicked();
            }
        });
        
        menuDoctor.add(reportMenu);

        patientMenu.setText("Attend Patient");
        patientMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	patientMenuMouseClicked();
            }
        });
       
        menuDoctor.add(patientMenu);

        LogOutMenu.setBackground(UIManager.getDefaults().getColor("Actions.Red"));
        LogOutMenu.setText("Log Out");
        LogOutMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogOutMenuMouseClicked(evt);
            }
        });
       
        menuDoctor.add(LogOutMenu);

        setJMenuBar(menuDoctor);

        javax.swing.GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1002, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 729, Short.MAX_VALUE)
        );

        pack();
    }



    private void LogOutMenuMouseClicked(java.awt.event.MouseEvent evt) {
        int option = JOptionPane.showConfirmDialog(null, "Do you really want to Log Out?", "Select", JOptionPane.YES_NO_OPTION);
            if (option == 0) {
                System.exit(0);
            }
    }



    private void ScheduleMenuMouseClicked() {
    	 attendPatient.setVisible(false);
         schedule.setVisible(true);
         report.setVisible(false);
    }


    private void reportMenuMouseClicked() {
        attendPatient.setVisible(false);
        schedule.setVisible(false);
        report.setVisible(true);
    }

    private void patientMenuMouseClicked() {
        attendPatient.setVisible(true);
        schedule.setVisible(false);
        report.setVisible(false);
    }


    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DoctorMain().setVisible(true);
            }
        });
    }

  
   

}
