package hrpayrollsystem;

import java.io.IOException;
//import java.io.FileInputStream; 
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream; 
import java.io.ObjectInputStream; 
import java.io.ObjectOutputStream; 
//import java.sql.SQLException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.swing.JOptionPane;

public class loginModel implements java.io.Serializable{
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    
    public loginModel(String username, String password) {
        this.username = username;
        this.password = password;
        System.out.println("start serialize");
        
        
//        try {  
//            // Create an instance of the login page object
//            loginModel loginModel = new loginModel(username, password);
//
//            // Use the ObjectOutputStream class to serialize the login page object and write it to a file
//            FileOutputStream fileOut = new FileOutputStream("loginModel.ser");
//            ObjectOutputStream out = new ObjectOutputStream(fileOut);
//            out.writeObject(loginModel);
//            out.close();
//            fileOut.close();
//            System.out.println("successfully serialized");
//    
//        } 
//        catch (FileNotFoundException ex) {
//            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeObject(username);
        out.writeObject(password);
//        System.out.println("successfully serialized");
        out.close();
        
    }
    
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        username = (String) in.readObject();
        password = (String) in.readObject();
//        System.out.println("successfully deserialized");
        in.close();
        
    }
}
