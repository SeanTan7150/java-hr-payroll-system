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
        //Interface hrInterface = (Interface)Naming.lookup("rmi://localhost:1040/HrServer");
        Interface hrInterface = null;
        Login login = new Login(hrInterface, new LoginModel("username", "password"));
        login.setVisible(true);
    }
}