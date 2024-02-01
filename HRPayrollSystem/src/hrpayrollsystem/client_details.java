package hrpayrollsystem;

//import hrpayrollsystem.client_homepage;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class client_details extends javax.swing.JFrame {

    private final String loggedInUsername;

    /**
     * Creates new form client_details
     */
    public client_details(String loggedInUsername) {
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
        String query = "SELECT employee_id, username, first_name, last_name, ic_passport_no, email, age FROM employee WHERE username = ?";
        PreparedStatement stm = conn.prepareStatement(query);
        stm.setString(1, loggedInUsername);
        
        ResultSet resultSet = stm.executeQuery();

        if (resultSet.next()) {
            // Display user data in the corresponding labels
            String employeeID = resultSet.getString("employee_id");
            String userName = resultSet.getString("username");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            int ic_passport_no = resultSet.getInt("ic_passport_no");
            String email = resultSet.getString("email");
            int age = resultSet.getInt("age");

            jLabel1.setText("Personal Details - " + userName);
            
            employee_id_field.setText(employeeID);
            first_name_field.setText(firstName);
            last_name_field.setText(lastName);
            ic_passport_no_field.setText(String.valueOf(ic_passport_no)); //int must be converted into string before set in the field
            email_field.setText(email);
            age_field.setText(String.valueOf(age));
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
        ic_passport_no_field = new javax.swing.JTextField();
        age_field = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        update_button = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        email_field = new javax.swing.JTextField();
        first_name_field = new javax.swing.JTextField();
        last_name_field = new javax.swing.JTextField();
        back_button = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        employee_id_field = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setText("Personal Details");

        ic_passport_no_field.setEditable(false);

        age_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                age_fieldActionPerformed(evt);
            }
        });

        jLabel3.setText("First Name  ");
        jLabel3.setAlignmentX(0.5F);

        jLabel4.setText("Last Name  ");

        jLabel9.setForeground(new java.awt.Color(204, 51, 0));
        jLabel9.setText("*** the employee ID and IC / Passport Number cannot update. ");

        jLabel5.setText("IC/ Passport number ");

        update_button.setText("Update");
        update_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_buttonActionPerformed(evt);
            }
        });

        jLabel6.setText("Email");

        jLabel7.setText("Age");

        email_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                email_fieldActionPerformed(evt);
            }
        });

        first_name_field.setAlignmentY(1.0F);
        first_name_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                first_name_fieldActionPerformed(evt);
            }
        });

        back_button.setForeground(new java.awt.Color(51, 102, 255));
        back_button.setText("Back");
        back_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_buttonActionPerformed(evt);
            }
        });

        jLabel8.setText("Employee ID");

        employee_id_field.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(97, 97, 97)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(back_button)
                                .addGap(40, 40, 40)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(57, 57, 57)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(last_name_field, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(first_name_field, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(46, 46, 46)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(email_field, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ic_passport_no_field, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(46, 46, 46)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(employee_id_field)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(update_button)
                                    .addComponent(age_field, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(149, 149, 149))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(employee_id_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(first_name_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(last_name_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ic_passport_no_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(email_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(age_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(update_button)
                    .addComponent(back_button))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void email_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_email_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_email_fieldActionPerformed

    private void first_name_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_first_name_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_first_name_fieldActionPerformed

    private void update_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_buttonActionPerformed
        try {
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/prsDB", "prs", "prs");

            // Query to retrieve existing user data
            String selectQuery = "SELECT employee_id, first_name, last_name, email, age FROM employee WHERE username=?";
            PreparedStatement selectStm = conn.prepareStatement(selectQuery);
            selectStm.setString(1, loggedInUsername);

            ResultSet existing_emp_data = selectStm.executeQuery();

            if (existing_emp_data.next()) {
                // Retrieve existing user data from the db
                String db_firstName = existing_emp_data.getString("first_name");
                String db_lastName = existing_emp_data.getString("last_name");
                String db_email = existing_emp_data.getString("email");
                String dbAge = existing_emp_data.getString("age");

                // Get user data from the form
                String formFirstName = first_name_field.getText();
                String formLastName = last_name_field.getText();
                String formEmail = email_field.getText();
                String formAge = age_field.getText();

                // Compare the existing data with the form data
                if (db_firstName.equals(formFirstName) && db_lastName.equals(formLastName)
                    && db_email.equals(formEmail) && dbAge.equals(formAge)) {
                    JOptionPane.showMessageDialog(null, "No changes are made", "No Changes", JOptionPane.INFORMATION_MESSAGE);
                } 
                else if(formFirstName.isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Add your first name", "Missing Value",
                            JOptionPane.WARNING_MESSAGE);
                }
                else if (!formFirstName.matches("^[a-zA-Z]+$")) 
                {
                    JOptionPane.showMessageDialog(null, "Enter your first name using letters only", "Invalid Input",
                            JOptionPane.WARNING_MESSAGE);
                }
                else if(formLastName.isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Add your last name", "Missing Value",
                            JOptionPane.WARNING_MESSAGE);
                }
                else if (!formLastName.matches("^[a-zA-Z]+$")) 
                {
                    JOptionPane.showMessageDialog(null, "Enter your last name using letters only", "Invalid Input",
                            JOptionPane.WARNING_MESSAGE);
                }
                else if(formEmail.isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Add your email", "Missing Value",
                            JOptionPane.WARNING_MESSAGE);
                }
                else if (!formEmail.matches("^(.+)@(.+)$")) {
                    JOptionPane.showMessageDialog(null, "Your email address is invalid", "Invalid Input", 
                            JOptionPane.ERROR_MESSAGE);
                }
                else if(formAge.isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Add your age", "Missing Value",
                            JOptionPane.WARNING_MESSAGE);
                }
                else if (!formAge.matches("\\d+")) {
                    JOptionPane.showMessageDialog(null, "Age must be an integer", "Invalid Input", 
                            JOptionPane.ERROR_MESSAGE);
                } 
                else if (formAge.length() > 2) {
                    JOptionPane.showMessageDialog(null, "Enter a valid age (up to 2 digits)", "Invalid Input",
                            JOptionPane.WARNING_MESSAGE);
                } 
                else {
                    // Update the user data in the database
                    String updateQuery = "UPDATE employee SET first_name=?, last_name=?, email=?, age=? WHERE username=?";
                    PreparedStatement updateStm = conn.prepareStatement(updateQuery);
                    updateStm.setString(1, formFirstName);
                    updateStm.setString(2, formLastName);
                    updateStm.setString(3, formEmail);
                    updateStm.setString(4, formAge);
                    updateStm.setString(5, loggedInUsername);

                    int rowsAffected = updateStm.executeUpdate();

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "Data successfully updated", "Success", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to update", "Failed", JOptionPane.ERROR_MESSAGE);
                    }

                }
            }

            conn.close();
        } catch (SQLException | NumberFormatException ex) {
            Logger.getLogger(client_details.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error updating data", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_update_buttonActionPerformed

    private void age_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_age_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_age_fieldActionPerformed

    private void back_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_buttonActionPerformed
        client_homepage c_homepage = new client_homepage(loggedInUsername);
        c_homepage.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_back_buttonActionPerformed

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
            java.util.logging.Logger.getLogger(client_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(client_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(client_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(client_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new client_details("loggedInUsername").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField age_field;
    private javax.swing.JButton back_button;
    private javax.swing.JTextField email_field;
    private javax.swing.JTextField employee_id_field;
    private javax.swing.JTextField first_name_field;
    private javax.swing.JTextField ic_passport_no_field;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField last_name_field;
    private javax.swing.JButton update_button;
    // End of variables declaration//GEN-END:variables
}
