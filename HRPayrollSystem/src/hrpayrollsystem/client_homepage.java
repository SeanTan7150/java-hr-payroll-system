package hrpayrollsystem;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class client_homepage extends javax.swing.JFrame {

    private String loggedInUsername;

    /**
     * Creates new form client_homepage
     */
    public client_homepage(String loggedInUsername) {
        initComponents();
        this.loggedInUsername = loggedInUsername;
        
        try {
            displayUserData(loggedInUsername);
        } catch (SQLException ex) {
            // Handle SQLException
            ex.printStackTrace();
        }
    }

    private void displayUserData(String loggedInUsername) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/prsDB", "prs", "prs");

        // Query to retrieve additional data for the logged-in user
        String query = "SELECT username, first_name, last_name, ic_passport_no, email, age, allowance FROM employee WHERE username = ?";
        PreparedStatement stm = conn.prepareStatement(query);
        stm.setString(1, loggedInUsername);
        
        ResultSet resultSet = stm.executeQuery();

        if (resultSet.next()) {
            String userName = resultSet.getString("username");
            jLabel2.setText("Hi, " + userName);
        }

        conn.close();
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
        update_personal_details_button = new javax.swing.JButton();
        check_payroll_button = new javax.swing.JButton();
        logout_button = new javax.swing.JButton();
        change_password_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 35)); // NOI18N
        jLabel1.setText("Client Homepage");

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 25)); // NOI18N
        jLabel2.setText("Username");

        update_personal_details_button.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        update_personal_details_button.setText("Update personal details");
        update_personal_details_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_personal_details_buttonActionPerformed(evt);
            }
        });

        check_payroll_button.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        check_payroll_button.setText("Check payroll");
        check_payroll_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_payroll_buttonActionPerformed(evt);
            }
        });

        logout_button.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        logout_button.setForeground(new java.awt.Color(255, 51, 0));
        logout_button.setText("Logout");
        logout_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout_buttonActionPerformed(evt);
            }
        });

        change_password_button.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        change_password_button.setText("Change password");
        change_password_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                change_password_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(logout_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel1))
                    .addComponent(update_personal_details_button, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                    .addComponent(check_payroll_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(change_password_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(150, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(206, 206, 206))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(47, 47, 47)
                .addComponent(update_personal_details_button)
                .addGap(18, 18, 18)
                .addComponent(check_payroll_button)
                .addGap(18, 18, 18)
                .addComponent(change_password_button)
                .addGap(12, 12, 12)
                .addComponent(logout_button)
                .addContainerGap(78, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void update_personal_details_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_personal_details_buttonActionPerformed
        client_details c_details = new client_details(loggedInUsername);
        c_details.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_update_personal_details_buttonActionPerformed

    private void check_payroll_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_payroll_buttonActionPerformed
        client_payroll c_payroll = new client_payroll(loggedInUsername);
        c_payroll.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_check_payroll_buttonActionPerformed

    private void logout_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout_buttonActionPerformed
        int dialog = JOptionPane.showConfirmDialog(logout_button, "Are you sure to logout?");
        if (dialog == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null,"Logout successfully", "Success",
                JOptionPane.INFORMATION_MESSAGE);
            loginModel login_model = new loginModel("username", "password");
            new login(login_model).setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_logout_buttonActionPerformed

    private void change_password_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_change_password_buttonActionPerformed
        client_change_password change_pw = new client_change_password(loggedInUsername);
        change_pw.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_change_password_buttonActionPerformed

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
            java.util.logging.Logger.getLogger(client_homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(client_homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(client_homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(client_homepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new client_homepage("loggedInUsername").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton change_password_button;
    private javax.swing.JButton check_payroll_button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton logout_button;
    private javax.swing.JButton update_personal_details_button;
    // End of variables declaration//GEN-END:variables

}
