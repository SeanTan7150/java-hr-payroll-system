package hrpayrollsystem;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Interface extends Remote {
    public void insertEmployee(Employee newEmployee) throws RemoteException;
    
    public boolean login(String username, String password) throws RemoteException;
    
    public int getChangePasswordOTP() throws RemoteException;
    
    public void sendMailOTP(String username, int otp) throws RemoteException;
}
