package hrpayrollsystem;

import hrpayrollsystem.loginModel;
import hrpayrollsystem.login;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class registration extends javax.swing.JFrame {

    /**
     * Creates new form registration
     */
    public registration() {
        initComponents();
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
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        password_field = new javax.swing.JPasswordField();
        first_name_field = new javax.swing.JTextField();
        last_name_field = new javax.swing.JTextField();
        ic_passport_no_field = new javax.swing.JTextField();
        age_field = new javax.swing.JTextField();
        register_button = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        confirm_password_field = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        email_field = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        username_field = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        reset_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setText("REGISTRATION");

        jLabel2.setText("First Name");

        jLabel3.setText("Last Name");

        jLabel4.setText("Age");

        jLabel5.setText("IC / Passport Number");

        jLabel6.setText("Password");

        password_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                password_fieldActionPerformed(evt);
            }
        });

        first_name_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                first_name_fieldActionPerformed(evt);
            }
        });

        register_button.setText("Register");
        register_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                register_buttonActionPerformed(evt);
            }
        });

        jLabel7.setText("Confirm Password");

        jLabel8.setText("Email");

        email_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                email_fieldActionPerformed(evt);
            }
        });

        jLabel9.setText("Username");

        username_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                username_fieldActionPerformed(evt);
            }
        });

        jButton1.setForeground(new java.awt.Color(102, 102, 255));
        jButton1.setText("Go to Login Page");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        reset_button.setText("Reset");
        reset_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
                            .addComponent(jButton1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(reset_button)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(age_field, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(ic_passport_no_field, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(last_name_field, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(first_name_field, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(username_field)
                                .addComponent(password_field, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(email_field, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(register_button)
                                .addComponent(confirm_password_field, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(83, 83, 83))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(username_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(first_name_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(last_name_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(ic_passport_no_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(email_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(age_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(password_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(confirm_password_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(register_button)
                    .addComponent(reset_button))
                .addGap(34, 34, 34))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void first_name_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_first_name_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_first_name_fieldActionPerformed

    private void register_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_register_buttonActionPerformed
        String uname = username_field.getText();
        String fname = first_name_field.getText();
        String lname = last_name_field.getText();
        String ic_passport_no = ic_passport_no_field.getText();
        String email = email_field.getText();
        String age = age_field.getText();
        String pass = String.valueOf(password_field.getPassword());
        String re_pass = String.valueOf(confirm_password_field.getPassword());
        String employeeID = null; 
        
        //make the employee_id auto increse by 1 when register
        try {
        Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/prsDB", "prs", "prs");
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("select max(employee_id) as max_emp_id from employee"); 
        
            if (rs.next()) { //check if there are any results available in the rs 
                int maxEmpId = rs.getInt("max_emp_id");
                employeeID = String.valueOf(maxEmpId + 1); 
            } else {
                // Handle the case where there are no employees in the table
                // Start with 1 if the table is empty
                employeeID = "1"; 
            }
        } catch (SQLException ex) {
            Logger.getLogger(registration.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            //check input validation
            if(uname.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Add your username", "Missing Value",
                        JOptionPane.WARNING_MESSAGE);
            }
            else if (!uname.matches("^[a-zA-Z]+$")) 
                JOptionPane.showMessageDialog(null, "Enter your username using letters only", "Invalid Input",
                        JOptionPane.WARNING_MESSAGE);
            else if(fname.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Add your first name", "Missing Value",
                        JOptionPane.WARNING_MESSAGE);
            }
            else if (!fname.matches("^[a-zA-Z]+$")) 
                JOptionPane.showMessageDialog(null, "Enter your first name using letters only", "Invalid Input",
                        JOptionPane.WARNING_MESSAGE);
            else if(lname.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Add your last name", "Missing Value",
                        JOptionPane.WARNING_MESSAGE);
            }
            else if (!lname.matches("^[a-zA-Z]+$")) 
                JOptionPane.showMessageDialog(null, "Enter your last name using letters only", "Invalid Input",
                        JOptionPane.WARNING_MESSAGE);
            else if(ic_passport_no.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Add your ic / passport number", "Missing Value",
                        JOptionPane.WARNING_MESSAGE);
            }
            else if (!ic_passport_no.matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "IC/Passport number must be an integer", "Invalid Input", 
                        JOptionPane.ERROR_MESSAGE);
            }
            else if(email.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Add your email", "Missing Value",
                        JOptionPane.WARNING_MESSAGE);
            }
            else if (!email.matches("^(.+)@(.+)$")) {
                JOptionPane.showMessageDialog(null, "Your email address is invalid", "Invalid Input", 
                        JOptionPane.ERROR_MESSAGE);
            }
            else if(age.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Add your age", "Missing Value",
                        JOptionPane.WARNING_MESSAGE);
            }
            else if (!age.matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "Age must be an integer", "Invalid Input", 
                        JOptionPane.ERROR_MESSAGE);
            } 
            else if (age.length() > 2) {
                JOptionPane.showMessageDialog(null, "Enter a valid age (up to 2 digits)", "Invalid Input",
                        JOptionPane.WARNING_MESSAGE);
            } 
            else if(pass.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Add your password", "Missing Value",
                        JOptionPane.WARNING_MESSAGE);
            }
            else if(re_pass.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Add your confirmed password", "Missing Value",
                        JOptionPane.WARNING_MESSAGE);
            }
            else if(!pass.equals(re_pass))
            {
                JOptionPane.showMessageDialog(null, "Retype your password again", "Invalid Input",
                        JOptionPane.ERROR_MESSAGE);
            }
            else if(check_username(uname))
            {
                JOptionPane.showMessageDialog(null, "This username already exists", "Invalid Input",
                        JOptionPane.ERROR_MESSAGE);
            }

            else{
                try 
                {
                    Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/prsDB", "prs", "prs"); 
                    PreparedStatement stm = conn.prepareStatement("INSERT INTO employee(username, first_name, last_name, ic_passport_no, email, age, password, employee_id) VALUES (?,?,?,?,?,?,?,?)");  
                    stm.setString(1, uname);
                    stm.setString(2, fname);
                    stm.setString(3, lname);
                    stm.setString(4, ic_passport_no);
                    stm.setString(5, email);
                    stm.setString(6, age);
                    stm.setString(7, pass);
                    stm.setString(8, employeeID);

                    if(stm.executeUpdate() > 0)
                    {
                        JOptionPane.showMessageDialog(null, "New user is successfully added", "Success",
                        JOptionPane.INFORMATION_MESSAGE);
                        
                        loginModel login_model = new loginModel("username", "password");
                        new login(login_model).setVisible(true);
                        this.dispose();
                    }
                    else 
                    {
                        JOptionPane.showMessageDialog(null, "Failed to added the user", "Failed",
                        JOptionPane.ERROR_MESSAGE);
                    }
                    
                } catch (SQLException ex) {
                    Logger.getLogger(registration.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(registration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_register_buttonActionPerformed

    private void email_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_email_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_email_fieldActionPerformed

    private void username_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_username_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_username_fieldActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        loginModel login_model = new loginModel("username", "password");
        new login(login_model).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void reset_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset_buttonActionPerformed
        username_field.setText("");
        first_name_field.setText("");
        last_name_field.setText("");
        ic_passport_no_field.setText("");
        email_field.setText("");
        age_field.setText("");
        password_field.setText("");
        confirm_password_field.setText("");
    }//GEN-LAST:event_reset_buttonActionPerformed

    private void password_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_password_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_password_fieldActionPerformed

    public boolean check_username(String uname)throws SQLException
    {
        ResultSet rs;
        boolean checkUser = false;
        
        try {
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/prsDB", "prs", "prs"); 
            PreparedStatement stm = conn.prepareStatement("SELECT * FROM employee WHERE username =?");  
                    
            stm.setString(1, uname);
            
            rs = stm.executeQuery();
            
            if(rs.next())
            {
                checkUser = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(registration.class.getName()).log(Level.SEVERE, null, ex);
        }
         return checkUser;
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
            java.util.logging.Logger.getLogger(registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField age_field;
    private javax.swing.JPasswordField confirm_password_field;
    private javax.swing.JTextField email_field;
    private javax.swing.JTextField first_name_field;
    private javax.swing.JTextField ic_passport_no_field;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField last_name_field;
    private javax.swing.JPasswordField password_field;
    private javax.swing.JButton register_button;
    private javax.swing.JButton reset_button;
    private javax.swing.JTextField username_field;
    // End of variables declaration//GEN-END:variables
}
