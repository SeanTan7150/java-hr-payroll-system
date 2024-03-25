package hrpayrollsystem;

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
import java.io.File;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ClientPayroll extends javax.swing.JFrame {

    private Interface hrInterface;
    private final String loggedInUsername;

    /**
     * Creates new form client_payroll
     */
    public ClientPayroll(Interface hrInterface, String loggedInUsername) throws RemoteException {
        initComponents();
        this.hrInterface = hrInterface;
        this.loggedInUsername = loggedInUsername;
        try {
            displayUserData();
        } catch (SQLException ex) {
            // Handle SQLException
            ex.printStackTrace();
        }
    }

    private void displayUserData() throws SQLException, RemoteException {
        Calendar calendar = Calendar.getInstance();
        int currentMonth = calendar.get(Calendar.MONTH) + 1;
        month_combobox.setSelectedIndex(currentMonth - 1);
        Employee employee = hrInterface.getEmployeeFullDetails(loggedInUsername, currentMonth);
        DecimalFormat df = new DecimalFormat("#.00");
        username_field.setText(employee.getUsername());
        ic_passport_no_field.setText(employee.getIcNumber()); //int must be converted into string before set in the field
        employee_id_field.setText(employee.getEmployeeId());
        position_field.setText(employee.getJobPosition());
        month_combobox.setSelectedItem(currentMonth);
        basic_salary_field.setText(String.valueOf(df.format(employee.getBasicSalary()))); //double must be converted into string before set in the field
        allowance_field.setText(String.valueOf(df.format(employee.getAllowance())));
        gross_pay_field.setText(String.valueOf(df.format(employee.getGrossSalary())));
        deduction_field.setText(String.valueOf(df.format(employee.getDeduction(currentMonth))));
        income_tax_field.setText(String.valueOf(df.format(employee.getIncomeTax())));
        epf_field.setText(String.valueOf(df.format(employee.getBasicSalary() * hrInterface.getEPF())));
        socso_field.setText(String.valueOf(df.format(employee.getBasicSalary() * hrInterface.getSOCSO())));
        eis_field.setText(String.valueOf(df.format(employee.getBasicSalary() * hrInterface.getEIS())));
        net_salary_field.setText(String.valueOf(df.format(employee.getNetSalary())));

//        Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/prsDB", "prs", "prs");
//
//        // Query to retrieve additional data for the logged-in user 
//        // left join: show all rows from employee table & the matched rows from deduction table
//        String query = "SELECT e.username, e.first_name, e.last_name, e.ic_passport_no, e.email, e.age, "
//            + "e.allowance, e.basic_salary, e.position, e.employee_id, "
//            + "d.month, d.amount "
//            + "FROM employee e "
//            + "LEFT JOIN deduction d ON e.username = d.username " //should use employee_id but it has problem
//            + "WHERE e.username = ?";
//        PreparedStatement stm = conn.prepareStatement(query);
//        stm.setString(1, loggedInUsername);
//        
//        ResultSet resultSet = stm.executeQuery();
//
//        if (resultSet.next()) {
//            // Display user data from db
//            String userName = resultSet.getString("username");
//            String ic_passport_no = resultSet.getString("ic_passport_no");
//            String employeeID = resultSet.getString("employee_id");
//            String position = resultSet.getString("position");
//            double basicSalary = resultSet.getDouble("basic_salary");
//            double allowance = resultSet.getDouble("allowance");
//            double income_tax;
//            if (basicSalary < 5000) {
//                income_tax = 0;
//            } else if (basicSalary <= 20000) {
//                income_tax = basicSalary * 0.01;
//            } else if (basicSalary <= 35000) {
//                income_tax = basicSalary * 0.03;
//            } else {
//                income_tax = basicSalary * 0.08; 
//            }
//            
//            String month = resultSet.getString("month");
//            double amount = resultSet.getDouble("amount");
//                   
        // format numbers to 2 decimal places
//            DecimalFormat df = new DecimalFormat("#.00");
//            username_field.setText(userName);
//            ic_passport_no_field.setText(ic_passport_no); //int must be converted into string before set in the field
//            employee_id_field.setText(employeeID);
//            position_field.setText(position);
//            month_combobox.setSelectedItem(month);
//            basic_salary_field.setText(String.valueOf(df.format(basicSalary))); //double must be converted into string before set in the field
//            allowance_field.setText(String.valueOf(df.format(allowance)));
//            gross_pay_field.setText(String.valueOf(df.format(basicSalary + allowance)));
//            deduction_field.setText(String.valueOf(df.format(amount)));
//            income_tax_field.setText(String.valueOf(df.format(income_tax))); 
//            epf_field.setText(String.valueOf(df.format(basicSalary * 0.09)));
//            socso_field.setText(String.valueOf(df.format(basicSalary * 0.005)));
//            eis_field.setText(String.valueOf(df.format(basicSalary * 0.002)));
//            net_salary_field.setText(String.valueOf(df.format(basicSalary + allowance - amount - basicSalary * 0.097 - income_tax)));
//        }
//
//        conn.close();
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
        month_combobox = new javax.swing.JComboBox<>();
        search_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel1.setText("Employee Payroll");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel2.setText("Allowance ");

        allowance_field.setEditable(false);
        allowance_field.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        back_button.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        back_button.setForeground(new java.awt.Color(51, 102, 255));
        back_button.setText("Back");
        back_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_buttonActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel5.setText("IC/ Passport number ");

        ic_passport_no_field.setEditable(false);
        ic_passport_no_field.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        ic_passport_no_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ic_passport_no_fieldActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel3.setText("Net Salary (RM) ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 20)); // NOI18N
        jLabel4.setText("BHEL Company");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel6.setText("Position");

        username_field.setEditable(false);
        username_field.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        username_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                username_fieldActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel7.setText("Username");

        position_field.setEditable(false);
        position_field.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        net_salary_field.setEditable(false);
        net_salary_field.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel8.setText("Basic Salary ");

        basic_salary_field.setEditable(false);
        basic_salary_field.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel9.setText("EPF");

        epf_field.setEditable(false);
        epf_field.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel10.setText("SOCSO");

        socso_field.setEditable(false);
        socso_field.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel11.setText("EIS");

        eis_field.setEditable(false);
        eis_field.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel12.setText("Deduction");

        deduction_field.setEditable(false);
        deduction_field.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        deduction_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deduction_fieldActionPerformed(evt);
            }
        });

        generate_payroll_button.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        generate_payroll_button.setText("Generate");
        generate_payroll_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generate_payroll_buttonActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel13.setText("Gross Pay ");

        gross_pay_field.setEditable(false);
        gross_pay_field.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel14.setText("Income Tax");

        income_tax_field.setEditable(false);
        income_tax_field.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel15.setText("Employee ID");

        employee_id_field.setEditable(false);
        employee_id_field.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        month_combobox.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        month_combobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April", "May", "June", "July ", "August", "September", "October", "November", "December", " " }));

        search_button.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        search_button.setText("Search");
        search_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator3)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(back_button)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(generate_payroll_button))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(eis_field, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(socso_field, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(income_tax_field, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(deduction_field, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(gross_pay_field, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(allowance_field, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(epf_field, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(net_salary_field, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(month_combobox, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(search_button, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator1)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(username_field, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(ic_passport_no_field)
                                    .addComponent(employee_id_field, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(position_field, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGap(85, 85, 85)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                                .addComponent(basic_salary_field, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(50, 50, 50))
            .addGroup(layout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(username_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(ic_passport_no_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                    .addComponent(month_combobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search_button))
                .addGap(18, 18, 18)
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
        ClientHomepage c_homepage = new ClientHomepage(hrInterface, loggedInUsername);
        c_homepage.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_back_buttonActionPerformed

    private void ic_passport_no_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ic_passport_no_fieldActionPerformed
    }//GEN-LAST:event_ic_passport_no_fieldActionPerformed

    private void generate_payroll_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generate_payroll_buttonActionPerformed
        try {                                                        
            Calendar calendar = Calendar.getInstance();
            int currentMonth = calendar.get(Calendar.MONTH) + 1;
            String message = hrInterface.getPayrollDocument(loggedInUsername, currentMonth);
            JOptionPane.showMessageDialog(null, message);
//            try {
//                // Retrieve payroll data from the fields
//                String username = username_field.getText();
//                String ic_passport_no = ic_passport_no_field.getText();
//                String employeeID = employee_id_field.getText();
//                String position = position_field.getText();
//                String month = (String) month_combobox.getSelectedItem();
//                
//                DecimalFormat df = new DecimalFormat("#0.00");
//                String basicSalary = df.format(Double.parseDouble(basic_salary_field.getText()));
//                String allowance = df.format(Double.parseDouble(allowance_field.getText()));
//                String grossPay = df.format(Double.parseDouble(gross_pay_field.getText()));
//                String deduction = df.format(Double.parseDouble(deduction_field.getText()));
//                String incomeTax = df.format(Double.parseDouble(income_tax_field.getText()));
//                String epf = df.format(Double.parseDouble(epf_field.getText()));
//                String socso = df.format(Double.parseDouble(socso_field.getText()));
//                String eis = df.format(Double.parseDouble(eis_field.getText()));
//                String netSalary = df.format(Double.parseDouble(net_salary_field.getText()));
//                
//                // Create a PDF document
//                Document document = new Document();
//                PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\Acer\\OneDrive - Asia Pacific University\\Desktop\\payroll_" + username + ".pdf"));
//                
//                document.open();
//                
//                Paragraph company_name = new Paragraph("BHEL Company", FontFactory.getFont(FontFactory.TIMES_BOLD, 15));
//                document.add(company_name);
//                
//                document.add(new Chunk(new LineSeparator()));
//                
//                Paragraph title = new Paragraph("Employee Payroll Statement", FontFactory.getFont(FontFactory.TIMES_BOLD, 18));
//                title.setAlignment(Element.ALIGN_CENTER);
//                document.add(title);
//                
//                Paragraph date = (new Paragraph("Generated on " + new Date(new java.util.Date().getTime()).toString(), FontFactory.getFont(FontFactory.TIMES_ITALIC, 10)));
//                date.setAlignment(Element.ALIGN_RIGHT);
//                document.add(date);
//                
//                Paragraph personalDetails = new Paragraph(
//                        "Personal Details:\n"
//                                + "username: " + username + "\n"
//                                        + "IC/Passport No: " + ic_passport_no + "\n"
//                                                + "Employee ID: " + employeeID + "\n"
//                                                        + "Position: " + position + "\n"
//                                                                + "\nPayment:\n"
//                                                                + "Month: " + month + "\n"
//                                                                        + "Basic Salary: RM " + basicSalary + "\n"
//                                                                                + "Allowance: RM " + allowance + "\n"
//                                                                                        + "Gross Pay: RM " + grossPay + "\n"
//                                                                                                + "Deductions: RM " + deduction + "\n"
//                                                                                                        + "Income Tax: RM " + incomeTax + "\n"
//                                                                                                                + "EPF: RM " + epf + "\n"
//                                                                                                                        + "SOCSO: RM " + socso + "\n"
//                                                                                                                                + "EIS: RM " + eis + "\n");
//                
//                Chunk netSalaryChunk = new Chunk("Net Salary: RM " + netSalary);
//                netSalaryChunk.setUnderline(1, -2); // single underline with thickness
//                personalDetails.add(netSalaryChunk);
//                
//                personalDetails.setAlignment(Element.ALIGN_CENTER);
//                document.add(personalDetails);
//                
//                // Close the PDF document
//                document.close();
//                
//                JOptionPane.showMessageDialog(null, "Payroll generated successfully!");
//            } catch (DocumentException | FileNotFoundException ex) {
//                JOptionPane.showMessageDialog(null, "Error generating PDF: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//                ex.printStackTrace(); // Log the exception for debugging
//            }
        } catch (RemoteException ex) {
            Logger.getLogger(ClientPayroll.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ClientPayroll.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(ClientPayroll.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_generate_payroll_buttonActionPerformed

    private void deduction_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deduction_fieldActionPerformed

    }//GEN-LAST:event_deduction_fieldActionPerformed

    private void username_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_username_fieldActionPerformed

    }//GEN-LAST:event_username_fieldActionPerformed

    private void search_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_buttonActionPerformed
        try {
            int selectedMonth = month_combobox.getSelectedIndex();
            
            Employee employee = hrInterface.getEmployeeFullDetails(loggedInUsername, selectedMonth + 1);
            DecimalFormat df = new DecimalFormat("#.00");
            username_field.setText(employee.getUsername());
            ic_passport_no_field.setText(employee.getIcNumber()); //int must be converted into string before set in the field
            employee_id_field.setText(employee.getEmployeeId());
            position_field.setText(employee.getJobPosition());
            basic_salary_field.setText(String.valueOf(df.format(employee.getBasicSalary()))); //double must be converted into string before set in the field
            allowance_field.setText(String.valueOf(df.format(employee.getAllowance())));
            gross_pay_field.setText(String.valueOf(df.format(employee.getGrossSalary())));
            deduction_field.setText(String.valueOf(df.format(employee.getDeduction(selectedMonth + 1))));
            income_tax_field.setText(String.valueOf(df.format(employee.getIncomeTax())));
            epf_field.setText(String.valueOf(df.format(employee.getBasicSalary() * hrInterface.getEPF())));
            socso_field.setText(String.valueOf(df.format(employee.getBasicSalary() * hrInterface.getSOCSO())));
            eis_field.setText(String.valueOf(df.format(employee.getBasicSalary() * hrInterface.getEIS())));
            net_salary_field.setText(String.valueOf(df.format(employee.getNetSalary())));
            
            JOptionPane.showMessageDialog(null, "The payroll is shown based on your search");
            
//        try {
//            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/prsDB", "prs", "prs");
//
//            String selected_month = (String) month_combobox.getSelectedItem();
//            String query = "SELECT e.username, e.first_name, e.last_name, e.ic_passport_no, e.email, e.age, "
//                    + "e.allowance, e.basic_salary, e.position, e.employee_id, "
//                    + "d.month, d.amount "
//                    + "FROM employee e "
//                    + "LEFT JOIN deduction d ON e.username = d.username " //should use employee_id but it has problem
//                    + "WHERE e.username = ? AND d.month = ?";
//            PreparedStatement stm = conn.prepareStatement(query);
//            stm.setString(1, loggedInUsername);
//            stm.setString(2, selected_month);
//
//            ResultSet resultSet = stm.executeQuery();
//            DecimalFormat df = new DecimalFormat("#.00");
//
//            if (resultSet.next()) {
//                // has matching rows found at deduction table, get the data from deduction and employee table, then calculate the net salary
//                String userName = resultSet.getString("username");
//                String ic_passport_no = resultSet.getString("ic_passport_no");
//                String employeeID = resultSet.getString("employee_id");
//                String position = resultSet.getString("position");
//                double basicSalary = resultSet.getDouble("basic_salary");
//                double allowance = resultSet.getDouble("allowance");
//                double income_tax;
//                if (basicSalary < 5000) {
//                    income_tax = 0;
//                } else if (basicSalary <= 20000) {
//                    income_tax = basicSalary * 0.01;
//                } else if (basicSalary <= 35000) {
//                    income_tax = basicSalary * 0.03;
//                } else {
//                    income_tax = basicSalary * 0.08;
//                }
//                double amount = resultSet.getDouble("amount");
//
//                username_field.setText(userName);
//                ic_passport_no_field.setText(ic_passport_no); //int must be converted into string before set in the field
//                employee_id_field.setText(employeeID);
//                position_field.setText(position);
//                month_combobox.setSelectedItem(selected_month);
//                basic_salary_field.setText(String.valueOf(df.format(basicSalary))); //double must be converted into string before set in the field
//                allowance_field.setText(String.valueOf(df.format(allowance)));
//                gross_pay_field.setText(String.valueOf(df.format(basicSalary + allowance)));
//                deduction_field.setText(String.valueOf(df.format(amount)));
//                income_tax_field.setText(String.valueOf(df.format(income_tax)));
//                epf_field.setText(String.valueOf(df.format(basicSalary * 0.09)));
//                socso_field.setText(String.valueOf(df.format(basicSalary * 0.005)));
//                eis_field.setText(String.valueOf(df.format(basicSalary * 0.002)));
//                net_salary_field.setText(String.valueOf(df.format(basicSalary + allowance - amount - basicSalary * 0.097 - income_tax)));
//                JOptionPane.showMessageDialog(null, "The payroll is shown based on your search");
//            } else {
//                // No matching rows found at deduction table, set deduction_field to "0.00", then calculate the net salary
//                deduction_field.setText(".00");
//                double basicSalary = Double.parseDouble(basic_salary_field.getText());
//                double allowance = Double.parseDouble(allowance_field.getText());
//                double income_tax = Double.parseDouble(income_tax_field.getText());
//                double netSalary = basicSalary + allowance - basicSalary * 0.097 - income_tax;
//                net_salary_field.setText(String.valueOf(df.format(netSalary)));
//                JOptionPane.showMessageDialog(null, "The payroll is shown based on your search");
//            }
//
//            conn.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(ClientPayroll.class.getName()).log(Level.SEVERE, null, ex);
//            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//        }
        } catch (RemoteException ex) {
            Logger.getLogger(ClientPayroll.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_search_buttonActionPerformed

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
    private javax.swing.JComboBox<String> month_combobox;
    private javax.swing.JTextField net_salary_field;
    private javax.swing.JTextField position_field;
    private javax.swing.JButton search_button;
    private javax.swing.JTextField socso_field;
    private javax.swing.JTextField username_field;
    // End of variables declaration//GEN-END:variables
}
