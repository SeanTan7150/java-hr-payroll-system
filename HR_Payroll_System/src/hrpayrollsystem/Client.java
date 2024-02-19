package hrpayrollsystem;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        Interface hrInterface = (Interface)Naming.lookup("rmi://localhost:1040/HrServer");
//        Employee newEmployee = new Employee("jojo", "jojo", "Jonathan", "Joestar", "021013141033", "EMP001", "jojo@gmail.com");
//        hrInterface.insertEmployee(newEmployee);
        hrInterface.sendMailOTP("jojo", hrInterface.getChangePasswordOTP());
    }
}
