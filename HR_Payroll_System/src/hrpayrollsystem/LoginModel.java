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
}
