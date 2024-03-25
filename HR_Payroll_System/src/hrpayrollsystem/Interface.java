package hrpayrollsystem;

import com.itextpdf.text.DocumentException;
import java.io.FileNotFoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public interface Interface extends Remote {
    public double getEPF() throws RemoteException;
    
    public double getSOCSO() throws RemoteException;
    
    public double getEIS() throws RemoteException;
    
    public String generateEmployeeId() throws RemoteException, SQLException;
    
    public void insertEmployee(Employee newEmployee) throws RemoteException;
    
    public void updateEmployee(String username, String firstName, String lastName, String email, int age) throws RemoteException;
    
    public void updateEmployeeJobInformation(String username, String icNumber, String employeeId, String jobPosition) throws RemoteException;
    
    public void updateEmployeeSalary(String username, double allowance, double basicSalary) throws RemoteException;
    
    public void updateEmployeeDeduction(String username, String employeeId, int month, double deductionAmount) throws RemoteException;
    
    public int getChangePasswordOTP() throws RemoteException;
    
    public long getTimestamp() throws RemoteException;
    
    public void sendMailOTP(String username, int otp) throws RemoteException;
    
    public ValidationResult changePassword(String username, String newPassword) throws RemoteException;
    
    public Employee getEmployeeBasicDetails(String username) throws RemoteException;
    
    public ArrayList<Employee> getAllEmployeeBasicDetails() throws RemoteException;
    
    public Employee getEmployeeFullDetails(String username, int month) throws RemoteException;
    
    public ArrayList<Employee> getAllEmployeeFullDetails(int month) throws RemoteException;
    
    public String getUserRole(String username) throws RemoteException;
    
    public String getPayrollDocument(String username, int month) throws RemoteException, FileNotFoundException, DocumentException;
    
    public HashMap<String, Double> getEmployeeTotals(int month) throws RemoteException;
    
    public double getIncomeTaxPercentage(double basicsalary) throws RemoteException;
    
    public double getIncomeTax(double basicSalary) throws RemoteException;
    
    public double calculateNetSalary(double basicSalary, double allowance, double deduction) throws RemoteException;
    
    // VALIDATION
//    public ValidationResult validateUsername(String username) throws RemoteException;
//    
    public ValidationResult checkUsernameExist(String username) throws RemoteException;
//    
//    public ValidationResult validateFirstName(String firstName) throws RemoteException;
//    
//    public ValidationResult validateLastName(String lastName) throws RemoteException;
//    
//    public ValidationResult validateICNumber(String icNumber) throws RemoteException;
//    
//    public ValidationResult validateEmail(String email) throws RemoteException;
//    
//    public ValidationResult validateAge(String age) throws RemoteException;
//    
//    public ValidationResult validatePassword(String password, String confirmPassword) throws RemoteException;
    
    public ValidationResult validateRegistration(String username, String firstName, String lastName, String icNumber, String email, String age, String password, String confirmPassword) throws RemoteException;

//    public ValidationResult checkLogin(String username, String password) throws RemoteException;
    
    public ValidationResult validateLogin(String username, String password) throws RemoteException;
    
    public ValidationResult validateForgottenPassword(String username) throws RemoteException;
}