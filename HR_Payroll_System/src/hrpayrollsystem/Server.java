package hrpayrollsystem;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Server extends UnicastRemoteObject implements Interface{
    public Server() throws RemoteException {
        super();
    }
    
    @Override
    public void insertEmployee(Employee newEmployee) throws RemoteException {
        try {
            DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
            try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/PRS;create=true", "root", "root")) {
                String sql = "insert into employee (USERNAME, "
                        + "FIRST_NAME, "
                        + "LAST_NAME, "
                        + "IC_PASSPORT_NO, "
                        + "EMAIL, "
                        + "AGE, "
                        + "PASSWORD, "
                        + "ALLOWANCE, "
                        + "BASIC_SALARY, "
                        + "POSITION, "
                        + "DEDUCTION, "
                        + "EMPLOYEE_ID)"
                        + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                
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
                    pstm.setString(10, "Developer");
                    pstm.setDouble(11, 0.00);
                    pstm.setString(12, newEmployee.getEmployeeId());
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
    public boolean login(String username, String password) throws RemoteException {
        boolean login = false;
        try {
            DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
            try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/PRS;create=true", "root", "root")) {
                String sql = "select * from employee where USERNAME = ? and PASSWORD = ?";
                
                try (PreparedStatement pstm = conn.prepareStatement(sql)) {
                    pstm.setString(1, username);
                    pstm.setString(2, password);
                    
                    ResultSet rs = pstm.executeQuery();
                    conn.commit();
                    conn.close();
                    login = rs.next();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        return login;
    }
    
    @Override
    public int getChangePasswordOTP() throws RemoteException {
        int otp = 0;
        Random random = new Random();
        otp = 100000 + random.nextInt(900000);
        return otp;
    }
    
    @Override
    public void sendMailOTP(String username, int otp) throws RemoteException {
        try {
            DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
            try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/PRS;create=true", "root", "root")) {
                String sql = "select EMAIL from employee where USERNAME = ?";
                
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
}
