
package ohtu.io;

import java.util.Scanner;
<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsoleIO implements IO {

    
=======

public class ConsoleIO implements IO {
>>>>>>> 47567022126cd47d95da67fe0990f21063754a4f
    private Scanner scanner = new Scanner(System.in);
    
    public void print(String toPrint) {
        System.out.println(toPrint);
    }

    public int readInt(String prompt) {
        System.out.println(prompt);
        return Integer.parseInt(scanner.nextLine());
    }

    public String readLine(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }
    
}
