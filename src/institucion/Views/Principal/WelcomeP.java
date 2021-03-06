/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package institucion.Views.Principal;

import config.Reconocedor;
import config.Sound;
import config.Tiempo;
import institucion.Controllers.CtrlPrincipal;
import institucion.Models.Users.Principal;
import institucion.Views.Loggin.Loggin;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;



/**
 *
 * @author o5k4r1n
 */
public class WelcomeP extends javax.swing.JFrame implements Runnable {

	/**
	 * Creates new form WelcomeP
	 */
	public int director_id = 1;
        
        private CtrlPrincipal ctrlP;
	private Sound s;
	private Thread h1;
	private Tiempo t;
	
        public Reconocedor rec;
        private Thread hiloEscucha;
        private boolean estado_voz;
        
	public WelcomeP() {
            this.setUndecorated(true);
            initComponents();
            this.setSize(1400,700);
            this.setLocationRelativeTo(null);
            this.estado_voz = false;

            ctrlP = new CtrlPrincipal();
            s = new Sound();
            t = new Tiempo();

            h1 = new Thread(this);
            h1.start();
	}

	/**
	 * This method is called from within the constructor to initialize the form. 
         * WARNING: Do NOT modify this code. 
         * The content of this method is always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnProfile = new javax.swing.JButton();
        btnEditProfile = new javax.swing.JButton();
        btnMessage = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnTeacherAttendances = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btnClassrooms = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        btnActivities = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        btnStadistics = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnExit = new javax.swing.JButton();
        lblWelcome = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        btnVoice = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setName(""); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(230, 100));
        jPanel1.setRequestFocusEnabled(false);

        btnProfile.setFont(new java.awt.Font("Loma", 1, 14)); // NOI18N
        btnProfile.setForeground(new java.awt.Color(255, 255, 255));
        btnProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/principal.png"))); // NOI18N
        btnProfile.setText("Ver Perfil");
        btnProfile.setBorder(null);
        btnProfile.setBorderPainted(false);
        btnProfile.setContentAreaFilled(false);
        btnProfile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProfile.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnProfile.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfileActionPerformed(evt);
            }
        });

        btnEditProfile.setFont(new java.awt.Font("Loma", 1, 14)); // NOI18N
        btnEditProfile.setForeground(new java.awt.Color(255, 255, 255));
        btnEditProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/edit.png"))); // NOI18N
        btnEditProfile.setText("Editar Perfil");
        btnEditProfile.setBorder(null);
        btnEditProfile.setBorderPainted(false);
        btnEditProfile.setContentAreaFilled(false);
        btnEditProfile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditProfile.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditProfile.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEditProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditProfileActionPerformed(evt);
            }
        });

        btnMessage.setFont(new java.awt.Font("Loma", 1, 14)); // NOI18N
        btnMessage.setForeground(new java.awt.Color(255, 255, 255));
        btnMessage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/message.png"))); // NOI18N
        btnMessage.setText("Mensajes");
        btnMessage.setBorder(null);
        btnMessage.setBorderPainted(false);
        btnMessage.setContentAreaFilled(false);
        btnMessage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMessage.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMessage.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMessageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnProfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEditProfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(btnProfile)
                .addGap(64, 64, 64)
                .addComponent(btnEditProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(btnMessage)
                .addContainerGap(118, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 230, 710);

        jPanel2.setBackground(new java.awt.Color(0, 51, 0));

        jPanel4.setBackground(new java.awt.Color(51, 153, 0));

        btnTeacherAttendances.setFont(new java.awt.Font("Loma", 1, 14)); // NOI18N
        btnTeacherAttendances.setForeground(new java.awt.Color(255, 255, 255));
        btnTeacherAttendances.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/time.png"))); // NOI18N
        btnTeacherAttendances.setText("Asistencia de Maestros");
        btnTeacherAttendances.setBorder(null);
        btnTeacherAttendances.setBorderPainted(false);
        btnTeacherAttendances.setContentAreaFilled(false);
        btnTeacherAttendances.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTeacherAttendances.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTeacherAttendances.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnTeacherAttendances.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTeacherAttendancesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnTeacherAttendances, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnTeacherAttendances, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(51, 153, 0));

        btnClassrooms.setFont(new java.awt.Font("Loma", 1, 14)); // NOI18N
        btnClassrooms.setForeground(new java.awt.Color(255, 255, 255));
        btnClassrooms.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/classroom.png"))); // NOI18N
        btnClassrooms.setText("Disponibilidad de Salas");
        btnClassrooms.setBorder(null);
        btnClassrooms.setBorderPainted(false);
        btnClassrooms.setContentAreaFilled(false);
        btnClassrooms.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClassrooms.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnClassrooms.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnClassrooms.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClassroomsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnClassrooms, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnClassrooms, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(51, 153, 0));

        btnActivities.setFont(new java.awt.Font("Loma", 1, 14)); // NOI18N
        btnActivities.setForeground(new java.awt.Color(255, 255, 255));
        btnActivities.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/activities.png"))); // NOI18N
        btnActivities.setText("Actividades del Instituto");
        btnActivities.setBorder(null);
        btnActivities.setBorderPainted(false);
        btnActivities.setContentAreaFilled(false);
        btnActivities.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActivities.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnActivities.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnActivities.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActivitiesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnActivities, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnActivities, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel8.setBackground(new java.awt.Color(51, 153, 0));

        btnStadistics.setFont(new java.awt.Font("Loma", 1, 14)); // NOI18N
        btnStadistics.setForeground(new java.awt.Color(255, 255, 255));
        btnStadistics.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/stadistic.png"))); // NOI18N
        btnStadistics.setText("Estadisticas");
        btnStadistics.setBorder(null);
        btnStadistics.setBorderPainted(false);
        btnStadistics.setContentAreaFilled(false);
        btnStadistics.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnStadistics.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnStadistics.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnStadistics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStadisticsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnStadistics, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnStadistics, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(537, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 65, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(38, 38, 38))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(230, 430, 1580, 280);

        jPanel3.setBackground(new java.awt.Color(0, 102, 0));

        btnExit.setBackground(new java.awt.Color(0, 102, 0));
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/close.png"))); // NOI18N
        btnExit.setToolTipText("");
        btnExit.setBorder(null);
        btnExit.setBorderPainted(false);
        btnExit.setContentAreaFilled(false);
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExitMouseClicked(evt);
            }
        });

        lblWelcome.setFont(new java.awt.Font("Loma", 1, 48)); // NOI18N
        lblWelcome.setForeground(new java.awt.Color(255, 255, 255));
        lblWelcome.setText("Bienvenido");

        lblTime.setFont(new java.awt.Font("Loma", 1, 48)); // NOI18N
        lblTime.setForeground(new java.awt.Color(255, 255, 255));
        lblTime.setText("jLabel2");

        btnVoice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons/voice_off.png"))); // NOI18N
        btnVoice.setBorder(null);
        btnVoice.setBorderPainted(false);
        btnVoice.setContentAreaFilled(false);
        btnVoice.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVoice.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoiceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 958, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExit))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnVoice)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 753, Short.MAX_VALUE)
                        .addComponent(lblTime)
                        .addGap(20, 20, 20)))
                .addGap(366, 366, 366))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(btnExit))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(lblWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTime, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnVoice, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(19, 19, 19))
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(230, 0, 1500, 430);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfileActionPerformed
        s.reproduce("bep.mp3");
        Profile e = new Profile();
        e.setVisible(true);
    }//GEN-LAST:event_btnProfileActionPerformed

    private void btnEditProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditProfileActionPerformed
        s.reproduce("bep.mp3");
        Edit e = new Edit();
        e.setVisible(true);
    }//GEN-LAST:event_btnEditProfileActionPerformed

    private void btnMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMessageActionPerformed
        s.reproduce("bep.mp3");
        Inbox i = new Inbox();
        i.setVisible(true);
    }//GEN-LAST:event_btnMessageActionPerformed

    private void btnClassroomsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClassroomsActionPerformed
        s.reproduce("bep.mp3");
        Availability a = new Availability();
        a.setVisible(true);
    }//GEN-LAST:event_btnClassroomsActionPerformed

    private void btnActivitiesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActivitiesActionPerformed
        s.reproduce("bep.mp3");
        Activity act = new Activity();
        act.setVisible(true);
    }//GEN-LAST:event_btnActivitiesActionPerformed

    private void btnStadisticsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStadisticsActionPerformed
        s.reproduce("bep.mp3");
        Stadistics st = new Stadistics();
        st.setVisible(true);
    }//GEN-LAST:event_btnStadisticsActionPerformed

    private void btnTeacherAttendancesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTeacherAttendancesActionPerformed
        s.reproduce("bep.mp3");
        Attendance a = new Attendance();
        a.setVisible(true);
    }//GEN-LAST:event_btnTeacherAttendancesActionPerformed

    private void btnVoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoiceActionPerformed
        if(!this.estado_voz){
            this.iniciarVoz();
            JOptionPane.showMessageDialog(rootPane, "Reconocimiento de voz iniciado"
            + "\ncorrectamente....!!", "Comando", JOptionPane.INFORMATION_MESSAGE);
            this.estado_voz = true;
            this.changeIconBtn("/images/icons/voice_on.png");
        }else{
            JOptionPane.showMessageDialog(rootPane, "Silenciado", "Comando", 
                        JOptionPane.INFORMATION_MESSAGE);
            this.estado_voz = false;
            this.changeIconBtn("/images/icons/voice_off.png");
        }
    }//GEN-LAST:event_btnVoiceActionPerformed

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        Loggin loggin = new Loggin();
        loggin.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnExitMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        int id = this.director_id;
        Principal p = ctrlP.getPrincipalDataByID(id);
        String fullname = p.getName() + " " + p.getLastname();
        lblWelcome.setText("Bienvenido " + fullname );
    }//GEN-LAST:event_formWindowOpened
	
    private void iniciarVoz() {
        hiloEscucha = new Thread(rec = new Reconocedor(this));
        hiloEscucha.start();
    }
    public void abrirSeccion(String seccion){
        switch(seccion){
            case "Ver":
                Profile p = new Profile();
                p.setVisible(true);
                break;
            case "Editar":
                Edit e = new Edit();
                e.setVisible(true);
                break;
            case "Enviar":
                Inbox i = new Inbox();
                i.setVisible(true);
                break;
            case "Asistencia":
                Attendance a = new Attendance();
                a.setVisible(true);
                break;
            case "Salas":
                Availability av = new Availability();
                av.setVisible(true);
                break;
            case "Actividades":
                Activity act = new Activity();
                act.setVisible(true);
                break;
            case "Estadisticas":
                Stadistics s = new Stadistics();
                s.setVisible(true);
                break;
            case "Silenciar":
                this.changeIconBtn("/images/icons/voice_off.png");
                JOptionPane.showMessageDialog(rootPane, "Silenciado", "Comando", 
                        JOptionPane.INFORMATION_MESSAGE);
                break;
        }
    }
    public void changeIconBtn(String path){
        try {
            Image img = ImageIO.read(getClass().getResource(path));
            btnVoice.setIcon(new ImageIcon(img));
        } catch (IOException ex) {
            System.out.println(ex);
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
			java.util.logging.Logger.getLogger(WelcomeP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(WelcomeP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(WelcomeP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(WelcomeP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new WelcomeP().setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActivities;
    private javax.swing.JButton btnClassrooms;
    private javax.swing.JButton btnEditProfile;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnMessage;
    private javax.swing.JButton btnProfile;
    private javax.swing.JButton btnStadistics;
    private javax.swing.JButton btnTeacherAttendances;
    private javax.swing.JButton btnVoice;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblWelcome;
    // End of variables declaration//GEN-END:variables

	@Override
	public void run() {
		Thread ct = Thread.currentThread();
		while(ct == h1) {
			t.calcular();
			lblTime.setText(t.calcular());
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {}
		}
	}
}