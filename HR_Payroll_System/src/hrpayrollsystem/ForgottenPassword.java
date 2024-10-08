package hrpayrollsystem;

import java.io.UnsupportedEncodingException;
import java.rmi.RemoteException;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class ForgottenPassword extends javax.swing.JFrame {
    private Interface hrInterface;
    int storedOTP;
    long storedTimestamp;
    /**
     * Creates new form forgotten_password
     */
    public ForgottenPassword(Interface hrInterface) {
        initComponents();
        this.hrInterface = hrInterface;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        send_button = new javax.swing.JButton();
        username_field = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        update_button = new javax.swing.JButton();
        otp_field = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        new_pw_field = new javax.swing.JPasswordField();
        confirm_new_pw_field = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel1.setText("Reset Password");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Please provide your username. You will receive an email with ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("follow-up instructions on how to reset your password.");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel4.setText("Username");

        send_button.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        send_button.setText("Send");
        send_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                send_buttonActionPerformed(evt);
            }
        });

        username_field.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        username_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                username_fieldActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel5.setText("OTP");

        update_button.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        update_button.setText("Update");
        update_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_buttonActionPerformed(evt);
            }
        });

        otp_field.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        otp_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                otp_fieldActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel6.setText("New password");

        new_pw_field.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        confirm_new_pw_field.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel7.setText("Confirm new password");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jButton1.setForeground(new java.awt.Color(102, 102, 255));
        jButton1.setText("Go to Login Page");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(157, 157, 157)
                                .addComponent(update_button))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(confirm_new_pw_field, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                                    .addComponent(new_pw_field)
                                    .addComponent(send_button, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(username_field)
                                    .addComponent(otp_field))))
                        .addGap(63, 63, 63))))
            .addGroup(layout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(70, 70, 70)
                        .addComponent(jLabel5)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel6)
                        .addGap(19, 19, 19)
                        .addComponent(jLabel7))
                    .addComponent(username_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(send_button)
                        .addGap(24, 24, 24)
                        .addComponent(otp_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(new_pw_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(confirm_new_pw_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(update_button)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void send_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_send_buttonActionPerformed
        try {
            // get username from the input field
            String username = username_field.getText();
            
            // check if the username field empty
            if (username.isEmpty()) {
                JOptionPane.showMessageDialog(null,"Please enter your username", "Missing username",
                        JOptionPane.ERROR_MESSAGE);
                return; //if the username field empty, after showing "Missing username", not to proceed to next func
            }
            
            ValidationResult result = hrInterface.validateForgottenPassword(username);
            
            if (result.isValid()) {
                // Generate a random 6-digit OTP
                Random random = new Random();
                int otp = 100000 + random.nextInt(900000); //store the int between 100000 and 999999
                
                // Record the timestamp which generate the otp
                long timestamp = System.currentTimeMillis();
                hrInterface.sendMailOTP(username, otp);;
                
                // Store the generated OTP and the user's email for verification later
                storedOTP = otp;
                storedTimestamp = timestamp;
                JOptionPane.showMessageDialog(this, "OTP sent to your email address. Check your inbox.");
            }
            else {
                JOptionPane.showMessageDialog(null, "User not found", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (RemoteException ex) {
            Logger.getLogger(ForgottenPassword.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_send_buttonActionPerformed
    
    private void username_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_username_fieldActionPerformed
    }//GEN-LAST:event_username_fieldActionPerformed

    private void update_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_buttonActionPerformed
        String enteredOTPText = otp_field.getText();
        String new_pw = String.valueOf(new_pw_field.getPassword()); 
        String re_pass = String.valueOf(confirm_new_pw_field.getPassword());
        
        // Check if the OTP field is empty
        if (enteredOTPText.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Add your OTP", "Missing Value",
                    JOptionPane.WARNING_MESSAGE);
            return;  // If the OTP field is empty, do not proceed to the next function
        }
        else if (!enteredOTPText.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "OTP must be an integer", "Invalid input",
                    JOptionPane.WARNING_MESSAGE);
            return;  
        }
        
    
        int enteredOTP = Integer.parseInt(enteredOTPText);
        
        // set expiration of OTP
        long current_time = System.currentTimeMillis();
        long time_diff = current_time - storedTimestamp;
        long expirationTime = 30 * 60 * 1000; // 30 min in milliseconds 
        
        // Verify OTP
        if (enteredOTP == storedOTP  && time_diff <= expirationTime) {
            if (new_pw.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Add your new password", "Missing Value",
                    JOptionPane.WARNING_MESSAGE);
            }
            else if (re_pass.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Add your confirmed new password", "Missing Value",
                        JOptionPane.WARNING_MESSAGE);
            }
            else if(!new_pw.equals(re_pass))
            {
                JOptionPane.showMessageDialog(null, "Retype your confirmed new password again", "Invalid Input",
                        JOptionPane.ERROR_MESSAGE);
            }
            else {
                try {
                    String username = username_field.getText();
                    hrInterface.changePassword(username, new_pw);
                } catch (RemoteException ex) {
                    Logger.getLogger(ForgottenPassword.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } 
        else if (time_diff > expirationTime) {
            JOptionPane.showMessageDialog(this, "OTP has expired. Please request a new OTP.");
        } 
        else {
            JOptionPane.showMessageDialog(this, "Invalid OTP. Password update failed.");
        }
        
        Login login = new Login(hrInterface, new LoginModel());
        login.setVisible(true);
        dispose();

    }//GEN-LAST:event_update_buttonActionPerformed

    private void otp_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_otp_fieldActionPerformed

    }//GEN-LAST:event_otp_fieldActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        LoginModel login_model = new LoginModel();
        new Login(hrInterface, login_model).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField confirm_new_pw_field;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPasswordField new_pw_field;
    private javax.swing.JTextField otp_field;
    private javax.swing.JButton send_button;
    private javax.swing.JButton update_button;
    private javax.swing.JTextField username_field;
    // End of variables declaration//GEN-END:variables
}
