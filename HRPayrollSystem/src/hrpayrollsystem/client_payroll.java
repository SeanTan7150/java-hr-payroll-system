package hrpayrollsystem;

import hrpayrollsystem.client_homepage;
import com.itextpdf.text.Chunk;
import java.io.FileNotFoundException;  
import java.io.FileOutputStream;  
import com.itextpdf.text.Document;  
import com.itextpdf.text.DocumentException;  
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;  
import com.itextpdf.text.pdf.PdfWriter;  
import com.itextpdf.text.pdf.draw.LineSeparator;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class client_payroll extends javax.swing.JFrame {

    private final String loggedInUsername;
    
    /**
     * Creates new form client_payroll
     */
    public client_payroll(String loggedInUsername) {
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
        String query = "SELECT username, first_name, last_name, ic_passport_no, email, age, "
                + "allowance, basic_salary, position, deduction, employee_id FROM employee WHERE username = ?";
        PreparedStatement stm = conn.prepareStatement(query);
        stm.setString(1, loggedInUsername);
        
        ResultSet resultSet = stm.executeQuery();

        if (resultSet.next()) {
            // Display user data from db
            String userName = resultSet.getString("username");
            int ic_passport_no = resultSet.getInt("ic_passport_no");
            String employeeID = resultSet.getString("employee_id");
            String position = resultSet.getString("position");
            double basicSalary = resultSet.getDouble("basic_salary");
            double allowance = resultSet.getDouble("allowance");
            double deduction = resultSet.getDouble("deduction");
            double income_tax;
            
            if (basicSalary < 5000) {
                income_tax = 0;
            } else if (basicSalary <= 20000) {
                income_tax = basicSalary * 0.01;
            } else if (basicSalary <= 35000) {
                income_tax = basicSalary * 0.03;
            } else {
                income_tax = basicSalary * 0.08; 
            }
                   
            // format numbers to 2 decimal places
            DecimalFormat df = new DecimalFormat("#.00");
            username_field.setText(userName);
            ic_passport_no_field.setText(String.valueOf(ic_passport_no)); //int must be converted into string before set in the field
            employee_id_field.setText(employeeID);
            position_field.setText(position);
            basic_salary_field.setText(String.valueOf(df.format(basicSalary))); //double must be converted into string before set in the field
            allowance_field.setText(String.valueOf(df.format(allowance)));
            gross_pay_field.setText(String.valueOf(df.format(basicSalary + allowance)));
            deduction_field.setText(String.valueOf(df.format(deduction)));
            income_tax_field.setText(String.valueOf(df.format(income_tax))); 
            epf_field.setText(String.valueOf(df.format(basicSalary * 0.09)));
            socso_field.setText(String.valueOf(df.format(basicSalary * 0.005)));
            eis_field.setText(String.valueOf(df.format(basicSalary * 0.002)));
            net_salary_field.setText(String.valueOf(df.format(basicSalary + allowance - deduction - basicSalary * 0.097 - income_tax)));
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
        allowance_field = new javax.swing.JTextField();
        back_button = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        ic_passport_no_field = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        username_field = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        position_field = new javax.swing.JTextField();
        net_salary_field = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        basic_salary_field = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        epf_field = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        socso_field = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        eis_field = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        deduction_field = new javax.swing.JTextField();
        generate_payroll_button = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        gross_pay_field = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        income_tax_field = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        employee_id_field = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setText("Employee Payroll");

        jLabel2.setText("Allowance ");

        allowance_field.setEditable(false);

        back_button.setForeground(new java.awt.Color(51, 102, 255));
        back_button.setText("Back");
        back_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_buttonActionPerformed(evt);
            }
        });

        jLabel5.setText("IC/ Passport number ");

        ic_passport_no_field.setEditable(false);
        ic_passport_no_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ic_passport_no_fieldActionPerformed(evt);
            }
        });

        jLabel3.setText("Net Salary (RM) ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel4.setText("BHEL Company");

        jLabel6.setText("Position");

        username_field.setEditable(false);

        jLabel7.setText("Username");

        position_field.setEditable(false);

        net_salary_field.setEditable(false);

        jLabel8.setText("Basic Salary ");

        basic_salary_field.setEditable(false);

        jLabel9.setText("EPF");

        epf_field.setEditable(false);

        jLabel10.setText("SOCSO");

        socso_field.setEditable(false);

        jLabel11.setText("EIS");

        eis_field.setEditable(false);

        jLabel12.setText("Deduction");

        deduction_field.setEditable(false);
        deduction_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deduction_fieldActionPerformed(evt);
            }
        });

        generate_payroll_button.setText("generate");
        generate_payroll_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generate_payroll_buttonActionPerformed(evt);
            }
        });

        jLabel13.setText("Gross Pay ");

        gross_pay_field.setEditable(false);

        jLabel14.setText("Income Tax");

        jLabel15.setText("Employee ID");

        employee_id_field.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(53, 53, 53)
                            .addComponent(net_salary_field, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(position_field, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(53, 53, 53)
                                            .addComponent(basic_salary_field, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(socso_field, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(eis_field, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGap(53, 53, 53)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(allowance_field, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(gross_pay_field, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(epf_field, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                                                .addComponent(deduction_field, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                                                .addComponent(income_tax_field)))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(53, 53, 53)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(employee_id_field, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(ic_passport_no_field)
                                                    .addComponent(username_field, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(112, 112, 112)
                                .addComponent(jLabel1))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(back_button)
                                .addGap(80, 80, 80)
                                .addComponent(generate_payroll_button)))))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel4)
                .addGap(2, 2, 2)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(username_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(ic_passport_no_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(employee_id_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(position_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(basic_salary_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(allowance_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(gross_pay_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(deduction_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(income_tax_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(epf_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(socso_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(eis_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(net_salary_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(generate_payroll_button)
                    .addComponent(back_button))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void back_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_buttonActionPerformed
        client_homepage c_homepage = new client_homepage(loggedInUsername);
        c_homepage.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_back_buttonActionPerformed

    private void ic_passport_no_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ic_passport_no_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ic_passport_no_fieldActionPerformed

    private void generate_payroll_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generate_payroll_buttonActionPerformed
        try {
            // Retrieve payroll data from the fields
            String username = username_field.getText();
            String ic_passport_no = ic_passport_no_field.getText();
            String employeeID = employee_id_field.getText();
            String position = position_field.getText();
            double basicSalary = Double.parseDouble(basic_salary_field.getText());
            double allowance = Double.parseDouble(allowance_field.getText());
            double grossPay = Double.parseDouble(gross_pay_field.getText());
            double deduction = Double.parseDouble(deduction_field.getText());
            double incomeTax = Double.parseDouble(income_tax_field.getText());
            double epf = Double.parseDouble(epf_field.getText());
            double socso = Double.parseDouble(socso_field.getText());
            double eis = Double.parseDouble(eis_field.getText());
            double netSalary = Double.parseDouble(net_salary_field.getText());
            
            // Create a PDF document
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\Acer\\OneDrive - Asia Pacific University\\Desktop\\payroll_" + username + ".pdf"));

            document.open();

            Paragraph company_name = new Paragraph("BHEL Company", FontFactory.getFont(FontFactory.TIMES_BOLD, 15));
            document.add(company_name);
            
            document.add(new Chunk(new LineSeparator()));
        
            Paragraph title = new Paragraph("Employee Payroll Statement", FontFactory.getFont(FontFactory.TIMES_BOLD, 18));
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            
            Paragraph date = (new Paragraph("Generated on " + new Date(new java.util.Date().getTime()).toString(), FontFactory.getFont(FontFactory.TIMES_ITALIC, 10)));
            date.setAlignment(Element.ALIGN_RIGHT);
            document.add(date);
            
            Paragraph personalDetails = new Paragraph(
                    "Personal Details:\n" +
                    "username: " + username + "\n" +
                    "IC/Passport No: " + ic_passport_no + "\n" +
                    "Employee ID: " + employeeID + "\n" +
                    "Position: " + position + "\n" +
                            
                    "\nPayment:\n" +
                    "Basic Salary: RM " + basicSalary + "\n" +
                    "Allowance: RM " + allowance + "\n" +
                    "Gross Pay: RM " + grossPay + "\n" +        
                    "Deductions: RM " + deduction + "\n" +
                    "Income Tax: RM " + incomeTax + "\n" +
                    "EPF: RM " + epf + "\n" +
                    "SOCSO: RM " + socso + "\n" +
                    "EIS: RM " + eis + "\n");
            
            Chunk netSalaryChunk = new Chunk("Net Salary: RM " + netSalary);
            netSalaryChunk.setUnderline(1, -2); // single underline with thickness
            personalDetails.add(netSalaryChunk);
            
            personalDetails.setAlignment(Element.ALIGN_CENTER);
            document.add(personalDetails);

            // Close the PDF document
            document.close();

            JOptionPane.showMessageDialog(null, "Payroll generated successfully!");
        } catch (DocumentException | FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error generating PDF: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace(); // Log the exception for debugging
        }
    }//GEN-LAST:event_generate_payroll_buttonActionPerformed

    private void deduction_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deduction_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deduction_fieldActionPerformed

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
            java.util.logging.Logger.getLogger(client_payroll.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(client_payroll.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(client_payroll.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(client_payroll.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new client_payroll("loggedInUsername").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField allowance_field;
    private javax.swing.JButton back_button;
    private javax.swing.JTextField basic_salary_field;
    private javax.swing.JTextField deduction_field;
    private javax.swing.JTextField eis_field;
    private javax.swing.JTextField employee_id_field;
    private javax.swing.JTextField epf_field;
    private javax.swing.JButton generate_payroll_button;
    private javax.swing.JTextField gross_pay_field;
    private javax.swing.JTextField ic_passport_no_field;
    private javax.swing.JTextField income_tax_field;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField net_salary_field;
    private javax.swing.JTextField position_field;
    private javax.swing.JTextField socso_field;
    private javax.swing.JTextField username_field;
    // End of variables declaration//GEN-END:variables
}
