
package screens;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.*;

public class DoctorMain extends javax.swing.JFrame {
    
    AttendPatient attendPatient;
    
    // components
    private JMenu LogOutMenu;
    private JMenu ScheduleMenu;
    private JMenu jMenu2;
    private JMenu jMenu3;
    private JMenuBar jMenuBar1;
    private JMenuItem jMenuItem1;
    private JMenuItem jMenuItem2;

    public DoctorMain() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        attendPatient = new AttendPatient();
        add(attendPatient);
    }


    private void initComponents() {

        jMenuItem1 = new JMenuItem();
        jMenuItem2 = new JMenuItem();
        jMenuBar1 = new JMenuBar();
        ScheduleMenu = new JMenu();
        jMenu2 = new JMenu();
        jMenu3 = new JMenu();
        LogOutMenu = new JMenu();



        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(UIManager.getDefaults().getColor("Button.default.hoverBorderColor"));

        ScheduleMenu.setText("Schedule");

        ScheduleMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ScheduleMenuMouseClicked(evt);
            }
        });
        ScheduleMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionPerformed(evt);
            }
        });
        jMenuBar1.add(ScheduleMenu);

        jMenu2.setText("Generate Report");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Attend Patient");
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

        LogOutMenu.setBackground(UIManager.getDefaults().getColor("Actions.Red"));
        LogOutMenu.setText("Log Out");
        LogOutMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogOutMenuMouseClicked(evt);
            }
        });
        LogOutMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionPerformed(evt);
            }
        });
        jMenuBar1.add(LogOutMenu);

        setJMenuBar(jMenuBar1);

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



    private void LogOutMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogOutMenuMouseClicked
        int option = JOptionPane.showConfirmDialog(null, "Do you really want to Log Out?", "Select", JOptionPane.YES_NO_OPTION);
            if (option == 0) {
                System.exit(0);
            }
    }



    private void ScheduleMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ScheduleMenuMouseClicked
        attendPatient.setVisible(false);      
    }


    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        attendPatient.setVisible(false);
    }

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        attendPatient.setVisible(true);
    }


    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DoctorMain().setVisible(true);
            }
        });
    }

  
   

}
