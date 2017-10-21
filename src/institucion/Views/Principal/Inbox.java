/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package institucion.Views.Principal;

import institucion.Controllers.CtrlClassroom;
import institucion.Controllers.CtrlPrincipal;
import institucion.Controllers.CtrlTeacher;
import institucion.Models.Users.Message;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author o5k4r1n
 */
public class Inbox extends javax.swing.JFrame {

	/**
	 * Creates new form Inbox
	 */
	private CtrlPrincipal ctrlP;
	private CtrlTeacher ctrlT;
	private CtrlClassroom ctrlC;
	private String estado;
	public Inbox() {
		this.setUndecorated(true);
		initComponents();
		this.setLocationRelativeTo(null);
		ctrlP = new CtrlPrincipal();
		ctrlT = new CtrlTeacher();
		ctrlC = new CtrlClassroom();
		estado = "enviar";
	}

	/**
	 * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabMessages = new javax.swing.JTable();
        lblMainTitle1 = new javax.swing.JLabel();
        lblMainTItle2 = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        txtTitle = new javax.swing.JTextField();
        lblMessage = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtMessage = new javax.swing.JTextArea();
        btnSend = new javax.swing.JButton();
        btnClean = new javax.swing.JButton();
        lblTeacher = new javax.swing.JLabel();
        txtTeacher = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        list_teachers = new javax.swing.JList<>();
        txtIDTeacher = new javax.swing.JTextField();
        lblClassroom = new javax.swing.JLabel();
        cmbClassroom = new javax.swing.JComboBox<>();
        txtClassroomID = new javax.swing.JTextField();
        btnClose = new javax.swing.JButton();
        txtResend = new javax.swing.JTextField();
        lblSelectTeacher = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 51, 0));

        tabMessages.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabMessages.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabMessagesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabMessages);

        lblMainTitle1.setFont(new java.awt.Font("Loma", 1, 18)); // NOI18N
        lblMainTitle1.setForeground(new java.awt.Color(255, 255, 255));
        lblMainTitle1.setText("MENSAJES ENVIADOS");

        lblMainTItle2.setFont(new java.awt.Font("Loma", 1, 18)); // NOI18N
        lblMainTItle2.setForeground(new java.awt.Color(255, 255, 255));
        lblMainTItle2.setText("ENVIAR MENSAJE");

        lblTitle.setFont(new java.awt.Font("Loma", 1, 14)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("Titulo:");

        lblMessage.setFont(new java.awt.Font("Loma", 1, 14)); // NOI18N
        lblMessage.setForeground(new java.awt.Color(255, 255, 255));
        lblMessage.setText("Mensaje:");

        txtMessage.setColumns(20);
        txtMessage.setRows(5);
        jScrollPane2.setViewportView(txtMessage);

        btnSend.setFont(new java.awt.Font("Loma", 1, 14)); // NOI18N
        btnSend.setForeground(new java.awt.Color(255, 255, 255));
        btnSend.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/sent.png"))); // NOI18N
        btnSend.setText("Enviar");
        btnSend.setBorderPainted(false);
        btnSend.setContentAreaFilled(false);
        btnSend.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSend.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSend.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        btnClean.setFont(new java.awt.Font("Loma", 1, 14)); // NOI18N
        btnClean.setForeground(new java.awt.Color(255, 255, 255));
        btnClean.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/clean.png"))); // NOI18N
        btnClean.setText("Reiniciar");
        btnClean.setBorderPainted(false);
        btnClean.setContentAreaFilled(false);
        btnClean.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClean.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnClean.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCleanActionPerformed(evt);
            }
        });

        lblTeacher.setFont(new java.awt.Font("Loma", 1, 14)); // NOI18N
        lblTeacher.setForeground(new java.awt.Color(255, 255, 255));
        lblTeacher.setText("Profesor:");

        list_teachers.setFont(new java.awt.Font("Loma", 0, 11)); // NOI18N
        list_teachers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                list_teachersMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(list_teachers);

        lblClassroom.setFont(new java.awt.Font("Loma", 1, 14)); // NOI18N
        lblClassroom.setForeground(new java.awt.Color(255, 255, 255));
        lblClassroom.setText("Aula:");

        cmbClassroom.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbClassroomItemStateChanged(evt);
            }
        });

        btnClose.setFont(new java.awt.Font("Loma", 1, 14)); // NOI18N
        btnClose.setForeground(new java.awt.Color(255, 255, 255));
        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/close.png"))); // NOI18N
        btnClose.setText("Cerrar");
        btnClose.setBorderPainted(false);
        btnClose.setContentAreaFilled(false);
        btnClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClose.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnClose.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        lblSelectTeacher.setFont(new java.awt.Font("Loma", 1, 14)); // NOI18N
        lblSelectTeacher.setForeground(new java.awt.Color(255, 255, 255));
        lblSelectTeacher.setText("Seleccione Profesor:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnSend)
                                .addGap(54, 54, 54)
                                .addComponent(btnClean)
                                .addGap(15, 15, 15))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblMessage)
                                    .addComponent(lblTitle))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(80, 80, 80)
                                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtResend, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtClassroomID, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtIDTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(25, 25, 25)
                                                .addComponent(lblTeacher))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGap(2, 2, 2)
                                                .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(0, 32, Short.MAX_VALUE)
                                                .addComponent(lblClassroom)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cmbClassroom, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txtTeacher))))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(btnClose)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblSelectTeacher)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))))
                    .addComponent(lblMainTItle2)
                    .addComponent(lblMainTitle1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 756, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblMainTitle1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMainTItle2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblTitle)
                                .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cmbClassroom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblClassroom)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtIDTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblTeacher)
                                .addComponent(txtClassroomID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtResend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMessage)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSelectTeacher)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSend)
                    .addComponent(btnClean)
                    .addComponent(btnClose))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
		txtIDTeacher.setVisible(false);
		txtClassroomID.setVisible(false);
		txtResend.setVisible(false);
		txtTeacher.setEnabled(false);
		txtID.setVisible(false);
		clean();
		
		updateTableMessages();
		ArrayList<String> classrooms = ctrlC.obtainClassrooms();
		for(String i: classrooms){
			cmbClassroom.addItem(i);
		}
    }//GEN-LAST:event_formWindowOpened
	public void hideColumns(){
		tabMessages.getColumnModel().getColumn(0).setWidth(0);
		tabMessages.getColumnModel().getColumn(0).setMinWidth(0);
		tabMessages.getColumnModel().getColumn(0).setMaxWidth(0);
		tabMessages.getColumnModel().getColumn(4).setWidth(0);
		tabMessages.getColumnModel().getColumn(4).setMinWidth(0);
		tabMessages.getColumnModel().getColumn(4).setMaxWidth(0);
		tabMessages.getColumnModel().getColumn(5).setWidth(0);
		tabMessages.getColumnModel().getColumn(5).setMinWidth(0);
		tabMessages.getColumnModel().getColumn(5).setMaxWidth(0);

	}
    private void list_teachersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_list_teachersMouseClicked
       String name = list_teachers.getSelectedValue();
	   txtTeacher.setText(name);
	   String[] aux_name = name.split(", ");
	   
	   String ln = aux_name[0];
	   String fn = aux_name[1];
	   
	   int id = ctrlT.getTeacherID(fn, ln);
	   txtIDTeacher.setText(String.valueOf(id));
    }//GEN-LAST:event_list_teachersMouseClicked

    private void cmbClassroomItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbClassroomItemStateChanged
        String classroom = "";
		int classroom_id = 0;
		ArrayList<String> teachers = new ArrayList<String>();
		if(evt.getStateChange() == 1){
			classroom = evt.getItem().toString();
			classroom_id = ctrlC.getClassroomID(classroom);
			txtClassroomID.setText(String.valueOf(classroom_id));
			teachers = ctrlT.getTeacherByClassroom(classroom_id);
			DefaultListModel<String> list_T = new DefaultListModel<String>();
			for(String t: teachers){
				list_T.addElement(t);
			}
			list_teachers.setModel(list_T);
		}
    }//GEN-LAST:event_cmbClassroomItemStateChanged

    private void btnCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCleanActionPerformed
		clean();
    }//GEN-LAST:event_btnCleanActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
		int id = Integer.parseInt(txtID.getText());
		int counter_resend = Integer.parseInt(txtResend.getText());
		String title	= txtTitle.getText();
		String message	= txtMessage.getText();
		int teacher_id	= Integer.parseInt(txtIDTeacher.getText());
		int classroom_id= Integer.parseInt(txtClassroomID.getText());
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		String moment = dateFormat.format(cal.getTime());
		Message m;
		if(estado.equals("enviar")){
			m = new Message(teacher_id, classroom_id, title, message, moment, counter_resend);
		}else{
			m = new Message(id, teacher_id, classroom_id, title, message, counter_resend);
		}
		//Message m = new Message(teacher_id, classroom_id, title, message, moment, counter_resend);
		if(ctrlP.checkMessage(m, estado)){
			JOptionPane.showMessageDialog(this, "Mensaje enviado con éxito","Mensaje",JOptionPane.INFORMATION_MESSAGE);
			clean();
			updateTableMessages();
			return;
		}
		JOptionPane.showMessageDialog(this, "Error al enviar mensaje, favor de revisar los datos","ERROR",JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_btnSendActionPerformed
	public void updateTableMessages(){
		tabMessages.setModel(new DefaultTableModel());
		String[] cols = {"id","Titulo", "Mensaje", "# Envios","teacher_id","classroom_id"};
		Object[][] data= ctrlP.getMessages();
		DefaultTableModel tab = new DefaultTableModel(data, cols);
		tabMessages.setModel(tab);
		hideColumns();
		
	}
    private void tabMessagesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabMessagesMouseClicked
        estado = "reenviar";
		btnSend.setText("Reenviar");
		int fila = tabMessages.rowAtPoint(evt.getPoint());
		String id = tabMessages.getValueAt(fila, 0).toString();
		String title = tabMessages.getValueAt(fila, 1).toString();
		String message = tabMessages.getValueAt(fila, 2).toString();
		int resend = Integer.parseInt(tabMessages.getValueAt(fila, 3).toString());
		int teacher_id = Integer.parseInt(tabMessages.getValueAt(fila, 4).toString());
		int classroom_id = Integer.parseInt(tabMessages.getValueAt(fila, 5).toString());
		String teacher_name = ctrlT.getTeacherNameByID(teacher_id);
		txtTeacher.setText(teacher_name);
		txtTitle.setText(title);
		txtMessage.setText(message);
		txtResend.setText(String.valueOf(resend+1));
		txtIDTeacher.setText(String.valueOf(teacher_id));
		txtClassroomID.setText(String.valueOf(classroom_id));
		txtID.setText(id);
		
		cmbClassroom.setEnabled(false);
		list_teachers.setEnabled(false);
    }//GEN-LAST:event_tabMessagesMouseClicked
    public void clean(){
		estado = "enviar";
		txtTitle.setText("");
		txtTeacher.setText("");
		txtMessage.setText("");
		txtID.setText("0");
		txtClassroomID.setText("0");
		txtIDTeacher.setText("0");
		txtResend.setText("0");
		btnSend.setText("Enviar");
		DefaultListModel empty_list = new DefaultListModel();
		list_teachers.setModel(empty_list);
		
		cmbClassroom.setEnabled(true);
		list_teachers.setEnabled(true);
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
			java.util.logging.Logger.getLogger(Inbox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Inbox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Inbox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Inbox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Inbox().setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClean;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnSend;
    private javax.swing.JComboBox<String> cmbClassroom;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblClassroom;
    private javax.swing.JLabel lblMainTItle2;
    private javax.swing.JLabel lblMainTitle1;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JLabel lblSelectTeacher;
    private javax.swing.JLabel lblTeacher;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JList<String> list_teachers;
    private javax.swing.JTable tabMessages;
    private javax.swing.JTextField txtClassroomID;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtIDTeacher;
    private javax.swing.JTextArea txtMessage;
    private javax.swing.JTextField txtResend;
    private javax.swing.JTextField txtTeacher;
    private javax.swing.JTextField txtTitle;
    // End of variables declaration//GEN-END:variables
}