/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package institucion.Views.Teacher;


import institucion.Controllers.CtrlTeacher;
import java.awt.event.ItemEvent;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author master
 */
public class Attendance extends javax.swing.JFrame {

    /**
     * Creates new form attendance_control
     */
    private CtrlTeacher ctrl;
    public int teacher_id;
    public Attendance() {
        ctrl = new CtrlTeacher();
        this.setUndecorated(true);
        initComponents();
        this.setSize(820,495);
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblIcon = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabAttendance = new javax.swing.JTable();
        btnPrint = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        lblMonth = new javax.swing.JLabel();
        cmbMonth = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));

        lblIcon.setBackground(new java.awt.Color(153, 153, 255));
        lblIcon.setFont(new java.awt.Font("Loma", 1, 48)); // NOI18N
        lblIcon.setForeground(new java.awt.Color(153, 153, 255));
        lblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/clock.png"))); // NOI18N
        lblIcon.setText("Asistencias");
        lblIcon.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblIcon.setVerifyInputWhenFocusTarget(false);
        lblIcon.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addComponent(lblIcon)
                .addGap(55, 55, 55))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(lblIcon)
                .addContainerGap(164, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 370, 494);

        jPanel2.setBackground(new java.awt.Color(102, 102, 255));

        tabAttendance.setBackground(new java.awt.Color(102, 102, 255));
        tabAttendance.setFont(new java.awt.Font("Lao UI", 1, 14)); // NOI18N
        tabAttendance.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Asistencia"
            }
        ));
        tabAttendance.setSelectionBackground(new java.awt.Color(0, 0, 102));
        tabAttendance.getTableHeader().setResizingAllowed(false);
        tabAttendance.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabAttendance);

        btnPrint.setBackground(new java.awt.Color(0, 51, 204));
        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/printer.png"))); // NOI18N
        btnPrint.setBorder(null);
        btnPrint.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(0, 51, 204));
        btnCancel.setFont(new java.awt.Font("Loma", 1, 18)); // NOI18N
        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/close.png"))); // NOI18N
        btnCancel.setBorder(null);
        btnCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        lblMonth.setFont(new java.awt.Font("Lao UI", 1, 14)); // NOI18N
        lblMonth.setForeground(new java.awt.Color(255, 255, 255));
        lblMonth.setText("Mes:");

        cmbMonth.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--", "Enero", "Febrero", "Marzo", "Abril", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        cmbMonth.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbMonthItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(76, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblMonth)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMonth)
                    .addComponent(cmbMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnPrint, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(369, 0, 460, 509);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        int teacher_id = this.teacher_id;
        this.setTable(teacher_id, 0);
    }//GEN-LAST:event_formWindowOpened

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPrintActionPerformed

    private void cmbMonthItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbMonthItemStateChanged
        String month    =   "";
        int teacher_id  =   0;
        HashMap<String,Integer> collMonths=new HashMap<String, Integer>();
        collMonths.put("Enero", 1);
        collMonths.put("Febrero", 2);
        collMonths.put("Marzo", 3);
        collMonths.put("Abril", 4);
        collMonths.put("Mayo", 5);
        collMonths.put("Junio", 6);
        collMonths.put("Julio", 7);
        collMonths.put("Agosto", 8);
        collMonths.put("Septiembre", 9);
        collMonths.put("Octubre", 10);
        collMonths.put("Noviembre", 11);
        collMonths.put("Diciembre", 12);
        DefaultTableModel tabEmpty = new DefaultTableModel();
        tabAttendance.setModel(tabEmpty);
        if(evt.getStateChange() == ItemEvent.SELECTED){
            teacher_id  =   this.teacher_id;
            month       =   cmbMonth.getSelectedItem().toString();
            if(!month.equals("--")){
                int m = collMonths.get(month);
                this.setTable(this.teacher_id, m);
            }else{
                JOptionPane.showMessageDialog(null, 
                                              "Favor de seleccionar un mes Válido", 
                                              "Error", 
                                              JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_cmbMonthItemStateChanged
    private void setTable(int id, int month){
        Object[][] attendances = ctrl.getTeacherAttendances(id, month);
        String[] columns = {"Estado Asistencia", "Fecha  Hora"};
        DefaultTableModel dtm = new DefaultTableModel(attendances,columns){
            @Override
            public boolean isCellEditable(int row, int column) {
                    return false;
            }
        };
        tabAttendance.setModel(dtm);
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        tabAttendance.getColumnModel().getColumn(0).setCellRenderer(tcr);
        tabAttendance.getColumnModel().getColumn(1).setCellRenderer(tcr);
        tabAttendance.getColumnModel().getColumn(0).setPreferredWidth(5);
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
            java.util.logging.Logger.getLogger(Attendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Attendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Attendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Attendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Attendance().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnPrint;
    private javax.swing.JComboBox cmbMonth;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblIcon;
    private javax.swing.JLabel lblMonth;
    private javax.swing.JTable tabAttendance;
    // End of variables declaration//GEN-END:variables
}
