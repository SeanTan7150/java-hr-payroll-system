package hrpayrollsystem;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements Interface{
    public Server() throws RemoteException {
        super();
    }
    
    @Override
    public int addDbg(int x, int y) throws RemoteException {
        return x + y;
    }
}
