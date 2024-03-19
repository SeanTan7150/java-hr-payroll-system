package hrpayrollsystem;

import com.itextpdf.text.DocumentException;
import java.io.FileNotFoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Interface extends Remote {
    public void insertEmployee(Employee newEmployee) throws RemoteException;
    
    public int getChangePasswordOTP() throws RemoteException;
    
    public long getTimestamp() throws RemoteException;
    
    public void sendMailOTP(String username, int otp) throws RemoteException;
    
    public ValidationResult changePassword(String username, String newPassword) throws RemoteException;
    
    public Employee getEmployeeBasicDetails(String username) throws RemoteException;
    
    public Employee getEmployeeFullDetails(String username) throws RemoteException;
    
    public String getPayrollDocument(String username, int month, String filePath) throws RemoteException, FileNotFoundException, DocumentException;
    
    // VALIDATION
//    public ValidationResult validateUsername(String username) throws RemoteException;
//    
//    public ValidationResult checkUsernameExist(String username) throws RemoteException;
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
