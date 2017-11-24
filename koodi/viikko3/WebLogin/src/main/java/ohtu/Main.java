
package ohtu;

import java.util.HashMap;
import ohtu.authentication.AuthenticationService;
import ohtu.data_access.FileUserDao;
import ohtu.data_access.UserDao;
import ohtu.util.CreationStatus;
import spark.ModelAndView;
import static spark.Spark.*;
import spark.template.velocity.VelocityTemplateEngine;

public class Main {
    
    static String LAYOUT = "templates/layout.html";
  
    static UserDao dao;
    static AuthenticationService authService;
    
    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));
    }

    public static void setDao(UserDao dao) {
        Main.dao = dao;
    }
    
    public static AuthenticationService authenticationService(){
        if ( dao==null ) {
          dao = new FileUserDao("salasanat.txt");  
        } if (authService==null) {
           authService = new AuthenticationService(dao); 
        }

        return authService;
    }    
      
    static int findOutPort() {
        if ( portFromEnv!=null ) {
            return Integer.parseInt(portFromEnv);
        }
        
        return 4567;
    }
    
    static String portFromEnv = new ProcessBuilder().environment().get("PORT");
    
    static void setEnvPort(String port){
        portFromEnv = port;
    }
}
