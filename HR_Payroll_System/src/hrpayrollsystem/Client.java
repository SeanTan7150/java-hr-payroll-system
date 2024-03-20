package hrpayrollsystem;

import com.itextpdf.text.DocumentException;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        Interface hrInterface = (Interface)Naming.lookup("rmi://localhost:1040/HrServer");
        
            //        Employee newEmployee = new Employee("jojo", "jojo", "Jonathan", "Joestar", "021013141033", "EMP001", "jojo@gmail.com");
//        hrInterface.insertEmployee(newEmployee);
//        System.out.println(hrInterface.validateRegistration("jojo", "Jonathan", "Joestar", "021013141033", "jojo@gmail.com", "80", "jojo", "").isValid());
//        System.out.println(hrInterface.validateRegistration("jojo", "Jonathan", "Joestar", "021013141033", "jojo@gmail.com", "80", "jojo", "").getErrorMessage());
//        try {
//            System.out.println(hrInterface.getPayrollDocument("jojo", 1, "C:\\Users\\xiuha\\OneDrive\\Desktop\\DCOMS\\"));
//        } catch (FileNotFoundException | DocumentException ex) {
//            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        System.out.println(hrInterface.getEmployeeFullDetails("hoho"));
    }
}
