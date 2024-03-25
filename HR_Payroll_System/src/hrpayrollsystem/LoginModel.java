package hrpayrollsystem;

import java.io.FileInputStream; 
import java.io.FileOutputStream; 
import java.io.ObjectInputStream; 
import java.io.ObjectOutputStream; 

public class LoginModel implements java.io.Serializable{
    private String username;
    private String password;
    
    public LoginModel() {
        try{
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("loginModelFile.ser"));
            this.username = (String) is.readObject();
            this.password = (String) is.readObject();
            is.close();
        } catch(Exception ex){
            this.username = "";
            this.password = "";
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
    
    public void serializeLogin(String username, String password) {
        try {
            FileOutputStream fs = new FileOutputStream("loginModelFile.ser");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(username);
            os.writeObject(password);
            os.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
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
