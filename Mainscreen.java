import java.util.ArrayList;
import java.util.Scanner;
public class Mainscreen{
    public void run(ArrayList<User> userDatabase,ArrayList<City> cities){
        User u1 = new User();
        System.out.println("---------------------Welcome to Car Rental System---------------------");
        System.out.println("Type the operation number you want to do");
        System.out.println("1.Register\n2.Login");
        Scanner scanner = new Scanner(System.in);
        int ans = scanner.nextInt();
        if(ans==1)
        {
            u1.getDetails();
            u1.register(u1, userDatabase);
            System.out.println("Redirecting you to Login Screen");
            u1.loginDetails(userDatabase,cities);
        }
        else if(ans==2)
        {
            u1.loginDetails(userDatabase,cities);
        }
        else{
            System.out.println("!!Please enter valid option!!");
            run(userDatabase,cities);
        }
        
    }


}