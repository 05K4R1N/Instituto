/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package institucion.Views.Teacher;

import institucion.Controllers.CtrlTeacher;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JOptionPane;
/**
 *
 * @author master
 */
public class Messages extends javax.swing.JFrame {

    /**
     * Creates new form Messages
     */
	private CtrlTeacher ctrl;
	private int classroom_id;
	private int teacher_id;
    public Messages(int classroom_id, int teacher_id) {
		this.setUndecorated(true);
        initComponents();
		ctrl = new CtrlTeacher();
		this.classroom_id = classroom_id;
		this.teacher_id   = teacher_id;
        this.setSize(583, 481);
        this.setLocationRelativeTo(null);
		message_content.setLineWrap(true);
    }

    private Messages() {
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
        panelMessages = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        message_content = new javax.swing.JTextArea();
        btndelete = new javax.swing.JButton();
        txtMessageId = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setBackground(new java.awt.Color(51, 102, 0));

        panelMessages.setBackground(new java.awt.Color(51, 102, 0));

        javax.swing.GroupLayout panelMessagesLayout = new javax.swing.GroupLayout(panelMessages);
        panelMessages.setLayout(panelMessagesLayout);
        panelMessagesLayout.setHorizontalGroup(
            panelMessagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
        );
        panelMessagesLayout.setVerticalGroup(
            panelMessagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(panelMessages, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(panelMessages, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);

        jPanel2.setBackground(new java.awt.Color(0, 102, 0));

        btnSalir.setBackground(new java.awt.Color(0, 102, 0));
        btnSalir.setFont(new java.awt.Font("Loma", 1, 18)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/close.png"))); // NOI18N
        btnSalir.setText("SALIR");
        btnSalir.setBorder(null);
        btnSalir.setBorderPainted(false);
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalirMouseClicked(evt);
            }
        });

        message_content.setBackground(new java.awt.Color(0, 101, 0));
        message_content.setColumns(20);
        message_content.setFont(new java.awt.Font("Loma", 1, 14)); // NOI18N
        message_content.setForeground(new java.awt.Color(255, 255, 255));
        message_content.setRows(5);
        jScrollPane3.setViewportView(message_content);

        btndelete.setBackground(new java.awt.Color(255, 0, 0));
        btndelete.setFont(new java.awt.Font("Loma", 1, 14)); // NOI18N
        btndelete.setForeground(new java.awt.Color(255, 255, 255));
        btndelete.setText("ELIMINAR");
        btndelete.setBorderPainted(false);
        btndelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btndelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btndeleteMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(btnSalir))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btndelete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtMessageId, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btndelete)
                    .addComponent(txtMessageId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btnSalir)
                .addGap(20, 20, 20))
        );

        getContentPane().add(jPanel2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnSalirMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        btndelete.setEnabled(false);
        txtMessageId.setVisible(false);
        if(listMessages() == 0){
                JOptionPane.showMessageDialog(null, "No existe ningun mensaje en Notificacion", "SIN NOTIFICACION", JOptionPane.ERROR_MESSAGE);
                this.setVisible(false);
        }
    }//GEN-LAST:event_formWindowOpened

    private void btndeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndeleteMouseClicked
        if(btndelete.isEnabled()){
            int message_id = Integer.parseInt(txtMessageId.getText());
            int resp = JOptionPane.showConfirmDialog(null, "Eliminacion de Mensaje en vista","Eliminar",JOptionPane.YES_NO_OPTION);
            if(resp == 0){
                    ctrl.deleteMessageByMessageID(message_id, teacher_id);
                    message_content.setText("");
                    txtMessageId.setText("");
                    btndelete.setEnabled(false);
                    panelMessages.removeAll();
                    int num_messages = listMessages();
                    if(num_messages == 0 ){
                            JOptionPane.showMessageDialog(null, "No existe ningun mensaje en Notificacion", "SIN NOTIFICACION", JOptionPane.ERROR_MESSAGE);
                            this.setVisible(false);
                    }
            }
        }
    }//GEN-LAST:event_btndeleteMouseClicked
    public int  listMessages(){
        Map<Integer,String> messages = ctrl.viewMessages(classroom_id, teacher_id);
        int y = 0;
        if(messages.size() > 0){
                for(Map.Entry<Integer, String> message: messages.entrySet()){
                        JButton btn_message = new JButton();
                        btn_message.setText(message.getValue());
                        btn_message.setFont(new Font("Loma", Font.PLAIN, 11));
                        btn_message.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        btn_message.setBounds(0, y,panelMessages.getWidth(), 20);
                        btn_message.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                    int id = message.getKey();
                                    txtMessageId.setText(String.valueOf(id));
                                    String message = ctrl.getMessageByID(id);
                                    message_content.setText(message);
                                    txtMessageId.setText(String.valueOf(id));
                                    btndelete.setEnabled(true);
                            }
                        });
                        panelMessages.add(btn_message);
                        panelMessages.revalidate();
                        panelMessages.repaint();
                        y = y + 20;

                }
        }
        int num_messages = messages.size();
        return num_messages;
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
            java.util.logging.Logger.getLogger(Messages.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Messages.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Messages.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Messages.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Messages().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btndelete;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea message_content;
    private javax.swing.JPanel panelMessages;
    private javax.swing.JTextField txtMessageId;
    // End of variables declaration//GEN-END:variables
}
