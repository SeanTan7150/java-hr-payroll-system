package hrpayrollsystem;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        Interface hrInterface = (Interface)Naming.lookup("rmi://localhost:1040/HrServer");
    }
}