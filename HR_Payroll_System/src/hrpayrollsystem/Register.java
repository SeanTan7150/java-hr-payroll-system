package hrpayrollsystem;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Register {
    public static void main(String[] args) throws RemoteException {
        Registry registry = LocateRegistry.createRegistry(1040);
        registry.rebind("HrServer", new Server());
    }
}