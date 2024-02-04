package hrpayrollsystem;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Interface extends Remote {
    public int addDbg(int x, int y) throws RemoteException;
}
