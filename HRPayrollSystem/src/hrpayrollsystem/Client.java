package hrpayrollsystem;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        //Interface hrInterface = (Interface)Naming.lookup("rmi://localhost:1040/HrServer");
        
        String[] tableHeaders = new String[] {
            "First Name", "Last Name", "Employee ID", "Job Position", " "
        };
        Object[][] data = null; // TODO Get employee data and put it in here
        AdminPage adminPage = new AdminPage(data, tableHeaders);
        adminPage.setVisible(true);
    }
}