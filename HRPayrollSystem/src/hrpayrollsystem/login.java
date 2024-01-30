package hrpayrollsystem;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
        
public class login extends javax.swing.JFrame { 
    private loginModel login_model;
    
    /**
     * Creates new form login
     */
    public login(loginModel login_model) {
        initComponents();
        this.login_model = login_model;
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
        username_field = new javax.swing.JTextField();
        login_button = new javax.swing.JButton();
        password_field = new javax.swing.JPasswordField();
        signup_button = new javax.swing.JButton();
        forgot_pw_button = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setText("LOGIN");

        jLabel2.setText("Username");

        jLabel3.setText("Password");

        username_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                username_fieldActionPerformed(evt);
            }
        });

        login_button.setText("login");
        login_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_buttonActionPerformed(evt);
            }
        });

        password_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                password_fieldActionPerformed(evt);
            }
        });

        signup_button.setForeground(new java.awt.Color(102, 102, 255));
        signup_button.setText("Don't have an account?");
        signup_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signup_buttonActionPerformed(evt);
            }
        });

        forgot_pw_button.setForeground(new java.awt.Color(102, 102, 255));
        forgot_pw_button.setText("Forgot password?");
        forgot_pw_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forgot_pw_buttonActionPerformed(evt);
            }
        });

        jCheckBox1.setText("Show / Hide password");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(114, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(189, 189, 189)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(username_field)
                                .addComponent(password_field, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(121, 121, 121)
                            .addComponent(jLabel1)
                            .addGap(131, 131, 131)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(247, 247, 247)
                        .addComponent(jCheckBox1)))
                .addGap(82, 82, 82))
            .addGroup(layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(signup_button)
                        .addGap(18, 18, 18)
                        .addComponent(forgot_pw_button))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(login_button, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(username_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(password_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(login_button, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(signup_button)
                    .addComponent(forgot_pw_button))
                .addGap(57, 57, 57))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void username_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_username_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_username_fieldActionPerformed

    private void password_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_password_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_password_fieldActionPerformed

    private void login_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_buttonActionPerformed
        String uname = username_field.getText();
        String password = new String(password_field.getPassword());
        
        try {
            if (login_validation(uname, password)) {
                JOptionPane.showMessageDialog(null,"login successfully", "Success",
                        JOptionPane.INFORMATION_MESSAGE);

                client_homepage c_home = new client_homepage(uname);
                c_home.setVisible(true);
                this.dispose();
                
//                // Create an instance of the login page object
//                login loginPage = new login(uname, password);
//
//                // Use the ObjectOutputStream class to serialize the login page object and write it to a file
//                FileOutputStream fileOut = new FileOutputStream("loginPage.ser");
//                ObjectOutputStream out = new ObjectOutputStream(fileOut);
//                out.writeObject(loginPage);
//                out.close();
//                fileOut.close();
//                System.out.println("successfully serialized");
                
            }
            else {
                JOptionPane.showMessageDialog(null,"login failed", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        } 
//        catch (FileNotFoundException ex) {
//            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        username_field.setText("");
        password_field.setText("");
    }//GEN-LAST:event_login_buttonActionPerformed

    private void signup_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signup_buttonActionPerformed
        registration reg = new registration();
        reg.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_signup_buttonActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if (jCheckBox1.isSelected()) {
            // show the pw
            password_field.setEchoChar((char) 0);
        } else {
            // hide the pw 
            password_field.setEchoChar('*');
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void forgot_pw_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forgot_pw_buttonActionPerformed
        forgotten_password forgotten_pw = new forgotten_password();
        forgotten_pw.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_forgot_pw_buttonActionPerformed

    private boolean login_validation(String uname, String password) throws SQLException 
    {
        Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/prsDB", "prs", "prs"); //db connection link, db username, db pw
        PreparedStatement stm = conn.prepareStatement("SELECT * FROM employee WHERE username = ? AND password = ?");  
        stm.setString(1, uname);
        stm.setString(2, password); 
        
        ResultSet resultSet = stm.executeQuery();
        boolean isValid = resultSet.next();
        resultSet.close(); 
        stm.close();
        conn.close(); 
        return isValid;
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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
//        try (FileInputStream fileIn = new FileInputStream("login_data.ser");
//            ObjectInputStream input = new ObjectInputStream(fileIn)) {
//           login previousLogin = (login) input.readObject();
//           // Use the deserialized login object's data if needed
//           input.close();
//        } catch (IOException | ClassNotFoundException e) {
//            // Handle if no saved data or errors
//            e.printStackTrace();
//        }
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                loginModel login_model = new loginModel("username", "password");
                new login(login_model).setVisible(true);
            }
        });
        
//        try (FileInputStream fileIn = new FileInputStream("login_data.ser");
//             ObjectInputStream input = new ObjectInputStream(fileIn)) {
//            login previousLogin = (login) input.readObject();
//            previousLogin.initializeLayout(); // Recreate the layout
//            previousLogin.setVisible(true);
//        } catch (IOException | ClassNotFoundException e) {
//            // Handle if no saved data or errors
//            e.printStackTrace();
//        }
    }
    
//    private void initializeLayout() {
//        // Recreate the layout here, similar to initComponents()
//        layout = new javax.swing.GroupLayout(getContentPane());
//        getContentPane().setLayout(layout);
//        // ... rest of layout setup
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton forgot_pw_button;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton login_button;
    private javax.swing.JPasswordField password_field;
    private javax.swing.JButton signup_button;
    private javax.swing.JTextField username_field;
    // End of variables declaration//GEN-END:variables
}
