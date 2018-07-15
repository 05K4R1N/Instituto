/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package institucion.Views.Principal;

import institucion.Controllers.CtrlClassroom;
import institucion.Controllers.CtrlSubject;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author o5k4r1n
 */
public class Availability extends javax.swing.JFrame {

    /**
     * Creates new form Availability
     */
    private CtrlClassroom ctrlC;
    private CtrlSubject ctrlS;
    public Availability() {
        this.setUndecorated(true);
        initComponents();
        this.setLocationRelativeTo(null);
        ctrlC = new CtrlClassroom();
        ctrlS = new CtrlSubject();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelClassVision = new javax.swing.JPanel();
        btnExit = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        cmbClassrooms = new javax.swing.JComboBox<String>();
        lblSub1 = new javax.swing.JLabel();
        lblSub2 = new javax.swing.JLabel();
        lblCapacity = new javax.swing.JLabel();
        lblOccupied = new javax.swing.JLabel();
        lblSched = new javax.swing.JLabel();
        cmbSched = new javax.swing.JComboBox();
        btnSearch = new javax.swing.JButton();
        lblSubject = new javax.swing.JLabel();
        cmbSubject = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 102, 0));

        panelClassVision.setBackground(new java.awt.Color(51, 153, 0));

        javax.swing.GroupLayout panelClassVisionLayout = new javax.swing.GroupLayout(panelClassVision);
        panelClassVision.setLayout(panelClassVisionLayout);
        panelClassVisionLayout.setHorizontalGroup(
            panelClassVisionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 770, Short.MAX_VALUE)
        );
        panelClassVisionLayout.setVerticalGroup(
            panelClassVisionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 354, Short.MAX_VALUE)
        );

        btnExit.setFont(new java.awt.Font("Loma", 1, 14)); // NOI18N
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/close.png"))); // NOI18N
        btnExit.setText("Salir");
        btnExit.setBorderPainted(false);
        btnExit.setContentAreaFilled(false);
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Lao UI", 1, 18)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("SALA:");

        cmbClassrooms.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblSub1.setFont(new java.awt.Font("Loma", 1, 18)); // NOI18N
        lblSub1.setForeground(new java.awt.Color(255, 255, 255));
        lblSub1.setText("Capacidad:");

        lblSub2.setFont(new java.awt.Font("Loma", 1, 18)); // NOI18N
        lblSub2.setForeground(new java.awt.Color(255, 255, 255));
        lblSub2.setText("Ocupados:");

        lblCapacity.setFont(new java.awt.Font("Loma", 1, 18)); // NOI18N
        lblCapacity.setForeground(new java.awt.Color(255, 255, 255));
        lblCapacity.setText("x");

        lblOccupied.setFont(new java.awt.Font("Loma", 1, 18)); // NOI18N
        lblOccupied.setForeground(new java.awt.Color(255, 255, 255));
        lblOccupied.setText("x");

        lblSched.setFont(new java.awt.Font("Lao UI", 1, 18)); // NOI18N
        lblSched.setForeground(new java.awt.Color(255, 255, 255));
        lblSched.setText("TURNO:");

        cmbSched.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnSearch.setFont(new java.awt.Font("Lao UI", 1, 14)); // NOI18N
        btnSearch.setForeground(new java.awt.Color(255, 255, 255));
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/search2.png"))); // NOI18N
        btnSearch.setText("Buscar");
        btnSearch.setBorderPainted(false);
        btnSearch.setContentAreaFilled(false);
        btnSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearch.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchMouseClicked(evt);
            }
        });

        lblSubject.setFont(new java.awt.Font("Lao UI", 1, 18)); // NOI18N
        lblSubject.setForeground(new java.awt.Color(255, 255, 255));
        lblSubject.setText("MATERIA:");

        cmbSubject.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmbSubject.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbSubjectItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblSub1)
                            .addComponent(lblSub2))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCapacity)
                            .addComponent(lblOccupied))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExit))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelClassVision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblTitle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbClassrooms, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(lblSubject)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblSched)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbSched, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSearch)))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle)
                    .addComponent(cmbClassrooms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSched)
                    .addComponent(cmbSched, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSubject)
                    .addComponent(cmbSubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelClassVision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSub1)
                            .addComponent(lblCapacity))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSub2)
                            .addComponent(lblOccupied))
                        .addContainerGap(30, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExit)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        ArrayList<String> classrooms = ctrlC.obtainClassrooms();
        cmbClassrooms.addItem("Seleccione Aula");
        for(String clasroom: classrooms){
            cmbClassrooms.addItem(clasroom);
        }
        cmbSubject.addItem("Seleccione Materia");
        ArrayList<String> subjects = ctrlS.getSubjects();
        for(String subject: subjects){
            cmbSubject.addItem(subject);
        }
        hideLabels();
    }//GEN-LAST:event_formWindowOpened
    public void hideLabels(){
        lblSub1.setVisible(false);
        lblSub2.setVisible(false);
        lblCapacity.setVisible(false);
        lblOccupied.setVisible(false);
    }
    public void showInfo(int occupied, int capacity){
        lblSub1.setVisible(true);
        lblSub2.setVisible(true);
        lblCapacity.setVisible(true);
        lblOccupied.setVisible(true);

        lblCapacity.setText(String.valueOf(capacity));
        lblOccupied.setText(String.valueOf(occupied));
    }
    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseClicked
        String selected_classroom   =   cmbClassrooms.getSelectedItem().toString();
        String selected_sched       =   cmbSched.getSelectedItem().toString();
        String selected_subject     =   cmbSubject.getSelectedItem().toString();
        if(selected_subject.equals("Seleccione Materia") ||
            selected_classroom.equals("Seleccione Aula") || 
            selected_sched.equals("Seleccione Turno")){
            JOptionPane.showMessageDialog(rootPane, 
                                        "Favor seleccionar datos correctos.",
                                        "Error",
                                        JOptionPane.WARNING_MESSAGE);
            return;
        }
        this.updateViewClassroom(selected_classroom, selected_sched, selected_subject);
        hideLabels();
    }//GEN-LAST:event_btnSearchMouseClicked

    private void cmbSubjectItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbSubjectItemStateChanged
        String subject = "";
        cmbSched.removeAllItems();
        if(evt.getStateChange() == ItemEvent.SELECTED){
            subject = evt.getItem().toString();
            ArrayList<String> shifts = ctrlS.getSubjectShifts(subject);
            cmbSched.addItem("Seleccione Turno");
            for(String shift: shifts){
                cmbSched.addItem(shift);
            }
        }
    }//GEN-LAST:event_cmbSubjectItemStateChanged
    
    private void updateViewClassroom(String classroom, String sched, String subject){
        int x = 30;
        int y = 20;
        panelClassVision.removeAll();
        panelClassVision.repaint();
        int pos = 1;
        int cont_occupied = 0;
        HashMap<String, Integer> data = ctrlC.getClassroomNumbers(classroom, sched, subject);
        if(!data.isEmpty()){
            int occupied = data.get("occupied");
            int capacity = data.get("capacity");
            showInfo(occupied, capacity);
            //770 de anchos
            for(int i = 0; i < data.get("capacity"); i++){
                JButton btn = new JButton();
                btn.setText(String.valueOf(pos));
                btn.setBounds(x, y, 60, 30);
                btn.setBackground(Color.white);
                btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Object[] options1 = { "Actualizar", "Cancelar"};

                        String[] list = {"Liberar", "Ocupar"};
                        JComboBox jcb = new JComboBox(list);
                        jcb.setEditable(false);

                        int result = JOptionPane.showOptionDialog(null, jcb, "Marcar Asistencia",
                                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
                                null, options1, null);
                        System.out.println(result);
                    }
                });
                x += 80;
                if( x == 750){
                    x = 30;
                    y += 40;
                }
                pos++;
                if(cont_occupied < occupied){
                    cont_occupied++;
                    btn.setBackground(Color.RED);
                }
                panelClassVision.add(btn);
                panelClassVision.revalidate();
                panelClassVision.repaint();
            }
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
            /* Set the Nimbus look and feel */
            //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
            /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
     * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
             */
            try {
                    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                            if ("Nimbus".equals(info.getName())) {
                                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                                    break;
                            }
                    }
            } catch (ClassNotFoundException ex) {
                    java.util.logging.Logger.getLogger(Availability.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                    java.util.logging.Logger.getLogger(Availability.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                    java.util.logging.Logger.getLogger(Availability.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                    java.util.logging.Logger.getLogger(Availability.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            //</editor-fold>

            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                            new Availability().setVisible(true);
                    }
            });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cmbClassrooms;
    private javax.swing.JComboBox cmbSched;
    private javax.swing.JComboBox cmbSubject;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCapacity;
    private javax.swing.JLabel lblOccupied;
    private javax.swing.JLabel lblSched;
    private javax.swing.JLabel lblSub1;
    private javax.swing.JLabel lblSub2;
    private javax.swing.JLabel lblSubject;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel panelClassVision;
    // End of variables declaration//GEN-END:variables
}
