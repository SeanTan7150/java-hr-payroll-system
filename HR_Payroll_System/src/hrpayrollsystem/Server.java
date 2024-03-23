package hrpayrollsystem;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Server extends UnicastRemoteObject implements Interface {
    public Server() throws RemoteException {
        super();
    }
    
    // Insert new employee (default role = employee)
    @Override
    public void insertEmployee(Employee newEmployee) throws RemoteException {
        try {
            DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
            try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/PRS", "root", "root")) {
                String sql = "INSERT INTO employee (USERNAME, "
                        + "FIRST_NAME, "
                        + "LAST_NAME, "
                        + "IC_PASSPORT_NO, "
                        + "EMAIL, "
                        + "AGE, "
                        + "PASSWORD, "
                        + "ALLOWANCE, "
                        + "BASIC_SALARY, "
                        + "POSITION, "
                        + "EMPLOYEE_ID,"
                        + "ROLE)"
                        + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                
                try (PreparedStatement pstm = conn.prepareStatement(sql)) {
                    pstm.setString(1, newEmployee.getUsername());
                    pstm.setString(2, newEmployee.getFirstName());
                    pstm.setString(3, newEmployee.getLastName());
                    pstm.setString(4, newEmployee.getIcNumber());
                    pstm.setString(5, newEmployee.getEmail());
                    pstm.setInt(6, 28);
                    pstm.setString(7, newEmployee.getPassword());
                    pstm.setDouble(8, 50.00);
                    pstm.setDouble(9, 3000.00);
                    pstm.setString(10, "developer");
                    pstm.setString(11, newEmployee.getEmployeeId());
                    pstm.setString(12, "employee");
                    pstm.execute();
                    
                    conn.commit();
                    conn.close();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void updateEmployee(String username, String firstName, String lastName, String email, int age) throws RemoteException {
        try {
            DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
            try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/PRS", "root", "root")) {
                String sql = "UPDATE employee SET "
                        + "FIRST_NAME = ?, "
                        + "LAST_NAME = ?, "
                        + "EMAIL = ?, "
                        + "AGE = ? "
                        + "WHERE USERNAME = ?";
                
                try (PreparedStatement pstm = conn.prepareStatement(sql)) {
                    pstm.setString(1, firstName);
                    pstm.setString(2, lastName);
                    pstm.setString(3, email);
                    pstm.setInt(4, age);
                    pstm.setString(5, username);
                    pstm.execute();
                    
                    conn.commit();
                    conn.close();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public int getChangePasswordOTP() throws RemoteException {
        int otp = 0;
        Random random = new Random();
        otp = 100000 + random.nextInt(900000);
        return otp;
    }
    
    @Override
    public long getTimestamp() throws RemoteException {
        return System.currentTimeMillis();
    }
    
    @Override
    public void sendMailOTP(String username, int otp) throws RemoteException {
        try {
            DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
            try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/PRS;create=true", "root", "root")) {
                String sql = "SELECT EMAIL FROM employee WHERE USERNAME = ?";
                
                try (PreparedStatement pstm = conn.prepareStatement(sql)) {
                    pstm.setString(1, username);
                    
                    ResultSet rs = pstm.executeQuery();
                    String email = null;
                    if (rs.next()) {
                        email = rs.getString(1);
                    }
                    
                    // Setup SMTP server properties
                    Properties props = System.getProperties();
                    props.put("mail.smtp.starttls.enable", "true");
                    props.put("mail.smtp.host", "smtp.gmail.com");
                    props.put("mail.smtp.port", "587");
                    props.put("mail.smtp.auth", "true");
                    
                    Session newSession = Session.getDefaultInstance(props, null);
                    
                    String from = "dcomsnoreply@gmail.com"; //dcoms123
                    String password = "zfod kmoz ztcz iuwc";
                    String host = "smtp.gmail.com";
                    String subject = "Password Reset for the Payroll System";
                    String body = "Hi, " + username + ". \nYour OTP for password reset is " + otp 
                            + ". Please enter the received OTP when resetting your password within 30 minutes. "
                            + "If you didn't request a password reset, please ignore this email. \n\n\nSincerely, \nAdmin";
                    
                    Message msg = new MimeMessage(newSession);
                    msg.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
                    msg.setSubject(subject);
                    msg.setText(body);
                    
                    try (Transport transport = newSession.getTransport("smtp")) {
                        transport.connect(host, from, password);
                        transport.sendMessage(msg, msg.getAllRecipients());
                    }
                    conn.commit();
                    conn.close();
                } catch (AddressException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                } catch (MessagingException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public ValidationResult changePassword(String username, String newPassword) throws RemoteException {
        try {
            DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
            try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/PRS;create=true", "root", "root")) {
                String sql = "UPDATE employee SET PASSWORD = ? WHERE USERNAME = ?";
                
                try (PreparedStatement pstm = conn.prepareStatement(sql)) {
                    pstm.setString(1, newPassword);
                    pstm.setString(2, username);
                    conn.commit();
                    conn.close();
                    
                    if (pstm.executeUpdate() <= 0) {
                        return new ValidationResult(false, "Failed to update", "Failed");
                    }
                }
                conn.commit();
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ValidationResult(true, "Your new password successfully updated", "Success");
    }
    
    @Override
    public Employee getEmployeeBasicDetails(String username) throws RemoteException {
        Employee loggedInUser = null;
        try {
            DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
            try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/PRS;create=true", "root", "root")) {
                String sql = "SELECT * FROM employee WHERE USERNAME = ?";
                
                try (PreparedStatement pstm = conn.prepareStatement(sql)) {
                    pstm.setString(1, username);
                    
                    ResultSet rs = pstm.executeQuery();
                    if (rs.next()) {
                        loggedInUser = new Employee(
                                rs.getString("USERNAME"),
                                rs.getString("PASSWORD"), 
                                rs.getString("FIRST_NAME"), 
                                rs.getString("LAST_NAME"), 
                                rs.getString("IC_PASSPORT_NO"), 
                                rs.getString("EMPLOYEE_ID"), 
                                rs.getString("EMAIL"), 
                                rs.getInt("AGE")
                        );
                    }
                    conn.commit();
                    conn.close();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        return loggedInUser;
    }
    
    @Override
    public ArrayList<Employee> getAllEmployeeBasicDetails() throws RemoteException {
        ArrayList<Employee> employees = new ArrayList<>();
        try {
            DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
            try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/PRS;create=true", "root", "root")) {
                String sql = "SELECT * FROM employee WHERE ROLE = ?";
                
                try (PreparedStatement pstm = conn.prepareStatement(sql)) {
                    pstm.setString(1, "employee");
                    
                    ResultSet rs = pstm.executeQuery();
                    while (rs.next()) {
                        Employee employee = new Employee(
                                rs.getString("USERNAME"),
                                rs.getString("PASSWORD"), 
                                rs.getString("FIRST_NAME"), 
                                rs.getString("LAST_NAME"), 
                                rs.getString("IC_PASSPORT_NO"), 
                                rs.getString("EMPLOYEE_ID"), 
                                rs.getString("EMAIL"), 
                                rs.getInt("AGE")
                        );
                        employees.add(employee);
                    }
                    conn.commit();
                    conn.close();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        return employees;
    }
    
    @Override
    public Employee getEmployeeFullDetails(String username, int month) throws RemoteException {
        Employee loggedInUser = null;
        ArrayList<Deduction> deductionList = new ArrayList<>();
        double allowance = 0;
        double basicSalary = 0;
        double grossSalary = 0;
        double incomeTax = 0;
        double netSalary = 0;

        try {
            DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
            try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/PRS;create=true", "root", "root")) {
                String sql = "SELECT * FROM employee WHERE USERNAME = ?";
                
                try (PreparedStatement pstm = conn.prepareStatement(sql)) {
                    pstm.setString(1, username);
                    
                    ResultSet rs = pstm.executeQuery();
                    if (rs.next()) {
                        allowance = rs.getDouble("ALLOWANCE");
                        basicSalary = rs.getDouble("BASIC_SALARY");
                        grossSalary = basicSalary + allowance;
                        incomeTax = getIncomeTax(basicSalary);
                        loggedInUser = new Employee(
                                rs.getString("USERNAME"),
                                rs.getString("PASSWORD"), 
                                rs.getString("FIRST_NAME"), 
                                rs.getString("LAST_NAME"), 
                                rs.getString("IC_PASSPORT_NO"), 
                                rs.getString("EMPLOYEE_ID"), 
                                rs.getString("POSITION"),
                                rs.getString("EMAIL"), 
                                rs.getInt("AGE"),
                                allowance,
                                0,
                                grossSalary,
                                basicSalary,
                                incomeTax,
                                deductionList
                        );
                    }
                    
                    if (loggedInUser != null) {
                        loggedInUser.setDeductionList(getDeductionList(username));
                        netSalary = grossSalary - loggedInUser.getDeduction(month) - incomeTax;
                        loggedInUser.setNetSalary(netSalary);
                    }
                    
                    conn.commit();
                    conn.close();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        return loggedInUser;
    }

    @Override
    public ArrayList<Employee> getAllEmployeeFullDetails(int month) throws RemoteException {
        ArrayList<Employee> employees = new ArrayList<>();
        ArrayList<Deduction> deductionList = new ArrayList<>();
        String username = null;
        double allowance = 0;
        double basicSalary = 0;
        double grossSalary = 0;
        double incomeTax = 0;
        double netSalary = 0;

        try {
            DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
            try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/PRS;create=true", "root", "root")) {
                String sql = "SELECT * FROM employee WHERE ROLE = ?";
                
                try (PreparedStatement pstm = conn.prepareStatement(sql)) {
                    pstm.setString(1, "employee");
                    
                    ResultSet rs = pstm.executeQuery();
                    while (rs.next()) {
                        username = rs.getString("USERNAME");
                        allowance = rs.getDouble("ALLOWANCE");
                        basicSalary = rs.getDouble("BASIC_SALARY");
                        grossSalary = basicSalary + allowance;
                        incomeTax = getIncomeTax(basicSalary);
                        Employee employee = new Employee(
                                username,
                                rs.getString("PASSWORD"), 
                                rs.getString("FIRST_NAME"), 
                                rs.getString("LAST_NAME"), 
                                rs.getString("IC_PASSPORT_NO"), 
                                rs.getString("EMPLOYEE_ID"), 
                                rs.getString("POSITION"),
                                rs.getString("EMAIL"), 
                                rs.getInt("AGE"),
                                allowance,
                                0,
                                grossSalary,
                                basicSalary,
                                incomeTax,
                                deductionList
                        );
                        employees.add(employee);
                    }
                    
                    for (Employee employee : employees) {
                        employee.setDeductionList(getDeductionList(employee.getUsername()));
                        netSalary = employee.getGrossSalary() - employee.getDeduction(month) - employee.getIncomeTax();
                        employee.setNetSalary(netSalary);
                    }
                    conn.commit();
                    conn.close();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        return employees;
    }
    
    @Override
    public String getPayrollDocument(String username, int month, String filePath) throws RemoteException, FileNotFoundException, DocumentException {
        try {
            Employee employee = getEmployeeFullDetails(username, month);
            if (employee == null) {
                return "Employee does not exist";
            }
            else {
                Document doc = new Document();
                PdfWriter.getInstance(doc, new FileOutputStream(filePath + username + ".pdf"));
                doc.open();

                Paragraph companyName = new Paragraph("BHEL Company", FontFactory.getFont(FontFactory.TIMES_BOLD, 15));
                doc.add(companyName);
                doc.add(new Chunk(new LineSeparator()));

                Paragraph title = new Paragraph("Employee Payroll Statement", FontFactory.getFont(FontFactory.TIMES_BOLD, 18));
                title.setAlignment(Element.ALIGN_CENTER);
                doc.add(title);

                Paragraph date = (new Paragraph("Generated on " + new Date(new java.util.Date().getTime()).toString(), FontFactory.getFont(FontFactory.TIMES_ITALIC, 10)));
                date.setAlignment(Element.ALIGN_RIGHT);
                doc.add(date);

                double basicSalary = employee.getBasicSalary();
                double epf = basicSalary * 0.09;
                double socso = basicSalary * 0.005;
                double eis = basicSalary * 0.002;

                Paragraph personalDetails = new Paragraph(
                        "Personal Details:\n" 
                        + "username: " + employee.getUsername() + "\n"
                        + "IC/Passport No: " + employee.getIcNumber() + "\n"
                        + "Employee ID: " + employee.getEmployeeId() + "\n"
                        + "Position: " + employee.getJobPosition() + "\n"

                        + "\nPayment:\n"
                        + "Month: " + month + "\n"
                        + "Basic Salary: RM " + basicSalary + "\n"
                        + "Allowance: RM " + employee.getAllowance() + "\n"
                        + "Gross Pay: RM " + employee.getGrossSalary()+ "\n"
                        + "Deductions: RM " + employee.getDeduction(month)+ "\n"
                        + "Income Tax: RM " + employee.getIncomeTax()+ "\n"
                        + "EPF: RM " + epf + "\n"
                        + "SOCSO: RM " + socso + "\n"
                        + "EIS: RM " + eis + "\n"
                );
                Chunk netSalaryChunk = new Chunk("Net Salary: RM " + employee.getNetSalary());
                netSalaryChunk.setUnderline(1, -2);
                personalDetails.add(netSalaryChunk);
                personalDetails.setAlignment(Element.ALIGN_CENTER);
                doc.add(personalDetails);
                doc.close();
            }
        } catch (DocumentException | FileNotFoundException ex) {
            return "Error generating PDF: " + ex.getMessage();
        }
        return "Payroll generated successfully!";
    }
    
    @Override
    public HashMap<String, Double> getEmployeeTotals(int month) throws RemoteException {
        double totalBasicSalary = 0;
        double totalAllowance = 0;
        double totalEPF = 0;
        double totalSOCSO = 0;
        double totalDeduction = 0;
        double totalNetSalary = 0;
        
        double basicSalary = 0;
        double epf = 0;
        double socso = 0;
        
        ArrayList<Employee> employees = getAllEmployeeFullDetails(month);
        for (Employee employee : employees) {
            basicSalary = employee.getBasicSalary();
            epf = basicSalary * 0.09;
            socso = basicSalary * 0.005;
            
            totalBasicSalary += basicSalary;
            totalAllowance += employee.getAllowance();
            totalEPF += epf;
            totalSOCSO += socso;
            totalDeduction += employee.getDeduction(month);
            totalNetSalary += employee.getNetSalary();
        }
        
        HashMap<String, Double> totals = new HashMap<>();
        totals.put("BasicSalary", totalBasicSalary);
        totals.put("Allowance", totalAllowance);
        totals.put("EPF", totalEPF);
        totals.put("SOCSO", totalSOCSO);
        totals.put("Deduction", totalDeduction);
        totals.put("NetSalary", totalNetSalary);
        return totals;
    }
    
    private ArrayList<Deduction> getDeductionList(String username) throws RemoteException {
        ArrayList<Deduction> deductionList = new ArrayList<>();
        try {
            DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
            try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/PRS;create=true", "root", "root")) {
                String sql = "SELECT * FROM deduction WHERE USERNAME = ?";
                
                try (PreparedStatement pstm = conn.prepareStatement(sql)) {
                    pstm.setString(1, username);
                    
                    ResultSet rs = pstm.executeQuery();
                    while (rs.next()) {
                        deductionList.add(new Deduction(rs.getInt("MONTH"), rs.getDouble("AMOUNT")));
                    }
                    conn.commit();
                    conn.close();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        return deductionList;
    }
    
    private double getIncomeTax(double basicSalary) throws RemoteException {
        if (basicSalary < 5000) {
            return 0;
        }
        else if (basicSalary <= 20000) {
            return basicSalary * 0.01;
        }
        else if (basicSalary <= 35000) {
            return basicSalary * 0.03;
        }
        return basicSalary * 0.08;
    }
    
    // VALIDATION
    private ValidationResult validateUsername(String username) throws RemoteException {
        if (username.isEmpty()) {
            return new ValidationResult(false, "Add your username", "Missing Value");
        }
        else if (!username.matches("^[a-zA-Z]+$")) {
            return new ValidationResult(false, "Enter your username using letters only", "Invalid Input");
        }
        return new ValidationResult(true, "", "");
    }
    
    private ValidationResult checkUsernameExist(String username) throws RemoteException {
        boolean checkUser = false;
        try {
            DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
            try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/PRS", "root", "root")) {
                String sql = "SELECT COUNT(*) FROM employee WHERE USERNAME = ?";
                try (PreparedStatement pstm = conn.prepareStatement(sql)) {
                    pstm.setString(1, username);
                    try (ResultSet rs = pstm.executeQuery()) {
                        if (rs.next()) {
                            checkUser = rs.getInt(1) > 0;
                        }
                    }
                    conn.commit();
                    conn.close();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (checkUser) {
            return new ValidationResult(false, "This username already exists", "Invalid Input");
        }
        return new ValidationResult(true, "", "");
    }
    
    private ValidationResult validateFirstName(String firstName) throws RemoteException {
        if (firstName.isEmpty()) {
            return new ValidationResult(false, "Add your first name", "Missing Value");
        }
        else if (!firstName.matches("^[a-zA-Z]+$")) {
            return new ValidationResult(false, "Enter your first name using letters only", "Invalid Input");
        }
        return new ValidationResult(true, "", "");
    }
    
    private ValidationResult validateLastName(String lastName) throws RemoteException {
        if (lastName.isEmpty()) {
            return new ValidationResult(false, "Add your last name", "Missing Value");
        }
        else if (!lastName.matches("^[a-zA-Z]+$")) {
            return new ValidationResult(false, "Enter your last name using letters only", "Invalid Input");
        }
        return new ValidationResult(true, "", "");
    }
    
    private ValidationResult validateICNumber(String icNumber) throws RemoteException {
        if (icNumber.isEmpty()) {
            return new ValidationResult(false, "Add your ic / passport number", "Missing Value");
        }
        else if (icNumber.matches("^[a-zA-Z]*$")) {
            return new ValidationResult(false, "IC should be number only, Passport number should be letters and number", "Invalid Input");
        }
        return new ValidationResult(true, "", "");
    }
    
    private ValidationResult validateEmail(String email) throws RemoteException {
        if (email.isEmpty()) {
            return new ValidationResult(false, "Add your email", "Missing Value");
        }
        if (!email.matches("^(.+)@(.+)$")) {
            return new ValidationResult(false, "Your email address is invalid", "Invalid Input");
        }
        return new ValidationResult(true, "", "");
    }
    
    private ValidationResult validateAge(String age) throws RemoteException {
        if (age.isEmpty()) {
            return new ValidationResult(false, "Add your age", "Missing Value");
        }
        else if (!age.matches("\\d+")) {
            return new ValidationResult(false, "Age must be an integer", "Invalid Input");
        }
        else if (age.length() > 2) {
            return new ValidationResult(false, "Enter a valid age (up to 2 digits)", "Invalid Input");
        }
        return new ValidationResult(true, "", "");
    }
    
    private ValidationResult validatePassword(String password, String confirmPassword) throws RemoteException {
        if (password.isEmpty()) {
            return new ValidationResult(false, "Add your password", "Missing Value");
        }
        else if (confirmPassword.isEmpty()) {
            return new ValidationResult(false, "Add your confirmed password", "Missing Value");
        }
        else if (!password.equals(confirmPassword)) {
            return new ValidationResult(false, "Retype your password again", "Invalid Input");
        }
        return new ValidationResult(true, "", "");
    }

    private ValidationResult validateChangePasswordOTP(String enteredOTP, int storedOTP, long storedTimestamp) throws RemoteException {
        long current_time = System.currentTimeMillis();
        long time_diff = current_time - storedTimestamp;
        long expirationTime = 30 * 60 * 1000;
        
        if (enteredOTP.isEmpty()) {
            return new ValidationResult(false, "Add your OTP", "Missing Value");
        }
        else if (!enteredOTP.matches("\\d+")) {
            return new ValidationResult(false, "OTP must be an integer", "Invalid Input");
        }
        else if (Integer.parseInt(enteredOTP) != storedOTP) {
            return new ValidationResult(false, "Invalid OTP. Password update failed.", "");
        }
        else if (time_diff > expirationTime) {
            return new ValidationResult(false, "OTP has expired. Please request a new OTP.", "");
        }
        return new ValidationResult(true, "", "");
    }
    
    private ValidationResult checkLogin(String username, String password) throws RemoteException {
        boolean login = false;
        String role = null;
        try {
            DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
            try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/PRS;create=true", "root", "root")) {
                String sql = "SELECT * FROM employee WHERE USERNAME = ? and PASSWORD = ?";
                
                try (PreparedStatement pstm = conn.prepareStatement(sql)) {
                    pstm.setString(1, username);
                    pstm.setString(2, password);
                    
                    try (ResultSet rs = pstm.executeQuery()) {
                        login = rs.next();
                        
                        if (login) {
                            role = rs.getString("ROLE");
                        }
                    }
                    conn.commit();
                    conn.close();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (!login) {
            return new ValidationResult(false, "login failed", "Error");
        }
        else if (!"employee".equals(role) && !"admin".equals(role)) {
            return new ValidationResult(false, "login failed due to the unknown user role", "Error");
        }
        return new ValidationResult(true, "", "");
    }
    
    // Return true if input fields are valid
    // Else, return false, error message, and error type
    @Override
    public ValidationResult validateRegistration(
            String username, 
            String firstName, 
            String lastName, 
            String icNumber, 
            String email, 
            String age, 
            String password, 
            String confirmPassword
    ) throws RemoteException {
        ValidationResult isRegistrationValid = new ValidationResult(true, "", "");
        ExecutorService exe = Executors.newFixedThreadPool(8);
        try {
            List<Callable<ValidationResult>> validators = Arrays.asList(
                    () -> validateUsername(username), 
                    () -> validateFirstName(firstName),
                    () -> validateLastName(lastName),
                    () -> validateICNumber(icNumber),
                    () -> validateEmail(email),
                    () -> validateAge(age),
                    () -> validatePassword(password, confirmPassword),
                    () -> checkUsernameExist(username)
            );
            
            for (Callable<ValidationResult> validator : validators) {
                ValidationResult result = exe.submit(validator).get();
                if (!result.isValid()) {
                    isRegistrationValid.setValid(false);
                    isRegistrationValid.setMessage(result.getMessage());
                    isRegistrationValid.setMessageType(result.getMessageType());
                    break;
                }
            }
        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        exe.shutdown();
        return isRegistrationValid;
    }
    
    // Return true if input fields are valid and login success
    // Else, return false, error message, and error type
    @Override
    public ValidationResult validateLogin(String username, String password) throws RemoteException {
        ValidationResult isLoginValid = new ValidationResult(true, "", "");
        ExecutorService exe = Executors.newFixedThreadPool(3);
        try {
            List<Callable<ValidationResult>> validators = Arrays.asList(
                    () -> validateUsername(username),
                    () -> validatePassword(password, password),
                    () -> checkLogin(username, password)
            );
            
            for (Callable<ValidationResult> validator : validators) {
                ValidationResult result = exe.submit(validator).get();
                if (!result.isValid()) {
                    isLoginValid.setValid(false);
                    isLoginValid.setMessage(result.getMessage());
                    isLoginValid.setMessageType(result.getMessageType());
                    break;
                }
            }
        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        exe.shutdown();
        return isLoginValid;
    }

    @Override
    public ValidationResult validateForgottenPassword(String username) throws RemoteException {
        ValidationResult isForgottenPasswordValid = new ValidationResult(true, "", "");
        ExecutorService exe = Executors.newFixedThreadPool(2);
        try {
            List<Callable<ValidationResult>> validators = Arrays.asList(
                    () -> validateUsername(username),
                    () -> checkUsernameExist(username)
            );
            
            for (Callable<ValidationResult> validator : validators) {
                ValidationResult result = exe.submit(validator).get();
                if (!result.isValid()) {
                    isForgottenPasswordValid.setValid(false);
                    isForgottenPasswordValid.setMessage(result.getMessage());
                    isForgottenPasswordValid.setMessageType(result.getMessageType());
                    break;
                }
            }
        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        exe.shutdown();
        return isForgottenPasswordValid;
    }

    public ValidationResult validateChangePassword(String enteredOTP, int storedOTP, long storedTimestamp, String newPassword, String confirmPassword) {
        ValidationResult isChangePasswordValid = new ValidationResult(true, "", "");
        ExecutorService exe = Executors.newFixedThreadPool(2);
        try {
            List<Callable<ValidationResult>> validators = Arrays.asList(
                    () -> validateChangePasswordOTP(enteredOTP, storedOTP, storedTimestamp),
                    () -> validatePassword(newPassword, confirmPassword)
            );
            
            for (Callable<ValidationResult> validator : validators) {
                ValidationResult result = exe.submit(validator).get();
                if (!result.isValid()) {
                    isChangePasswordValid.setValid(false);
                    isChangePasswordValid.setMessage(result.getMessage());
                    isChangePasswordValid.setMessageType(result.getMessageType());
                    break;
                }
            }
        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        exe.shutdown();
        return isChangePasswordValid;
    }
}
