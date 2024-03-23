package hrpayrollsystem;

//import java.io.IOException;
import java.io.FileInputStream; 
//import java.io.FileNotFoundException;
import java.io.FileOutputStream; 
import java.io.ObjectInputStream; 
import java.io.ObjectOutputStream; 
//import javax.swing.text.GapContent;
//import java.sql.SQLException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.swing.JOptionPane;

public class LoginModel implements java.io.Serializable{
    private String username;
    private String password;
    
    
    public LoginModel(String username, String password) {
//        this.username = username;
//        this.password = password;
        this.username = "employee_username";
        this.password = "employee_password";

        try{
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("loginModelFile.ser"));
            username = (String) is.readObject();
            password = (String) is.readObject();
            is.close();
        } catch(Exception ex){
        ex.printStackTrace();
        }
        try{
            FileOutputStream fs = new FileOutputStream("loginModelFile.ser");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(username);
            os.writeObject(password);
            os.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }

    
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
    
//    private void writeObject(ObjectOutputStream out) throws IOException {
//        out.writeObject(username);
//        out.writeObject(password);
//        out.close();
//    }
    
//    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
//        username = (String) in.readObject();
//        password = (String) in.readObject();
//        in.close();
//    }
}
