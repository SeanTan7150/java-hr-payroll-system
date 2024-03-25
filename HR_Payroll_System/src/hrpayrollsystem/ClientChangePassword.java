package hrpayrollsystem;

import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ClientChangePassword extends javax.swing.JFrame {
    private Interface hrInterface;
    private String loggedInUsername;

    /**
     * Creates new form client_change_password
     */
    public ClientChangePassword(Interface hrInterface, String loggedInUsername) {
        initComponents();
        this.hrInterface = hrInterface;
        this.loggedInUsername = loggedInUsername;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        back_button = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        update_button = new javax.swing.JButton();
        old_pw_field = new javax.swing.JPasswordField();
        new_pw_field = new javax.swing.JPasswordField();
        confirm_new_pw_field = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel5.setText("Confirm new password");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel1.setText("Change Password");

        back_button.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        back_button.setForeground(new java.awt.Color(0, 102, 255));
        back_button.setText("Back");
        back_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_buttonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel3.setText("Old password");
        jLabel3.setAlignmentX(0.5F);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel4.setText("New password");

        update_button.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        update_button.setText("Update");
        update_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_buttonActionPerformed(evt);
            }
        });

        old_pw_field.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        new_pw_field.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        confirm_new_pw_field.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(jLabel1)
                .addContainerGap(187, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(update_button))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(back_button)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(63, 63, 63)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(new_pw_field, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                                    .addComponent(confirm_new_pw_field, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(old_pw_field))))))
                .addGap(84, 84, 84))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel1)
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(old_pw_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(new_pw_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(confirm_new_pw_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(26, 26, 26)
                .addComponent(update_button)
                .addGap(26, 26, 26)
                .addComponent(back_button)
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void back_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_buttonActionPerformed
        ClientHomepage c_homepage = new ClientHomepage(hrInterface, loggedInUsername);
        c_homepage.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_back_buttonActionPerformed

    private void update_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_buttonActionPerformed
        
        try {
            //Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/prsDB", "prs", "prs");

            String old_pw = String.valueOf(old_pw_field.getPassword());
            String new_pw = String.valueOf(new_pw_field.getPassword());
            String re_pass = String.valueOf(confirm_new_pw_field.getPassword());
            
            if(old_pw.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Add your old password", "Missing Value",
                JOptionPane.WARNING_MESSAGE);
            }
            else if(new_pw.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Add your new password", "Missing Value",
                JOptionPane.WARNING_MESSAGE);
            }
            else if(re_pass.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Add your confirmed new password", "Missing Value",
                JOptionPane.WARNING_MESSAGE);
            }
            else if(!new_pw.equals(re_pass))
            {
                JOptionPane.showMessageDialog(null, "Retype your confirmed new password again", "Invalid Input",
                JOptionPane.ERROR_MESSAGE);
            }
                
            // Query to retrieve existing user data
//            String selectQuery = "SELECT password FROM employee WHERE username=?";
//            PreparedStatement selectStm = conn.prepareStatement(selectQuery);
//            selectStm.setString(1, loggedInUsername);
            
            ValidationResult userValidation = hrInterface.validateLogin(loggedInUsername, old_pw);
            
            if (userValidation.isValid()) {
                ValidationResult changePasswordValidation = hrInterface.changePassword(loggedInUsername, new_pw);
                JOptionPane.showMessageDialog(null, changePasswordValidation.getMessage());
                ClientHomepage clientHomepage = new ClientHomepage(hrInterface, loggedInUsername);
                clientHomepage.setVisible(true);
                dispose();
            }
            else {
                JOptionPane.showMessageDialog(null, userValidation.getMessage());
            }
            
//            ResultSet existing_emp_data = selectStm.executeQuery();
//
//            if (existing_emp_data.next()) {
//                // Retrieve existing user data from the db
//                String db_password = existing_emp_data.getString("password");
                

                // Get user data from the form
//                String old_pw = String.valueOf(old_pw_field.getPassword());
//                String new_pw = String.valueOf(new_pw_field.getPassword());
//                String re_pass = String.valueOf(confirm_new_pw_field.getPassword());

                // Compare the existing data with the form data
//                if(old_pw.isEmpty())
//                {
//                    JOptionPane.showMessageDialog(null, "Add your old password", "Missing Value",
//                            JOptionPane.WARNING_MESSAGE);
//                }
//                else if(new_pw.isEmpty())
//                {
//                    JOptionPane.showMessageDialog(null, "Add your new password", "Missing Value",
//                            JOptionPane.WARNING_MESSAGE);
//                }
//                else if(re_pass.isEmpty())
//                {
//                    JOptionPane.showMessageDialog(null, "Add your confirmed new password", "Missing Value",
//                            JOptionPane.WARNING_MESSAGE);
//                }
//                else if (!db_password.equals(old_pw) ) {
//                    JOptionPane.showMessageDialog(null, "Your old password is incorrect", "Incorrect", 
//                            JOptionPane.INFORMATION_MESSAGE);
//                } 
//                else if(!new_pw.equals(re_pass))
//                {
//                    JOptionPane.showMessageDialog(null, "Retype your confirmed new password again", "Invalid Input",
//                            JOptionPane.ERROR_MESSAGE);
//                }
//                else {
                    // Update the user data in the database
//                    String updateQuery = "UPDATE employee SET password=? WHERE username=?";
//                    PreparedStatement updateStm = conn.prepareStatement(updateQuery);
//                    updateStm.setString(1, new_pw);
//                    updateStm.setString(2, loggedInUsername);
//
//                    int rowsAffected = updateStm.executeUpdate();
//
//                    if (rowsAffected > 0) {
//                        JOptionPane.showMessageDialog(null, "Your new password successfully updated", "Success", JOptionPane.INFORMATION_MESSAGE);
//                    } else {
//                        JOptionPane.showMessageDialog(null, "Failed to update", "Failed", JOptionPane.ERROR_MESSAGE);
//                    }
//
//                    updateStm.close();

                    
//                } catch (RemoteException ex) {
//            Logger.getLogger(ClientChangePassword.class.getName()).log(Level.SEVERE, null, ex);
//        }
//            }

//            conn.close();
            
        } catch (NumberFormatException ex) {
            Logger.getLogger(ClientChangePassword.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error updating data", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (RemoteException ex) {
            Logger.getLogger(ClientChangePassword.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_update_buttonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back_button;
    private javax.swing.JPasswordField confirm_new_pw_field;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField new_pw_field;
    private javax.swing.JPasswordField old_pw_field;
    private javax.swing.JButton update_button;
    // End of variables declaration//GEN-END:variables
}
