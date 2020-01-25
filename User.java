import java.util.*;
public class User extends Person{

    public void loginDetails(ArrayList<User> userDatabase){
        boolean b;
        Mainscreen m = new Mainscreen();
        System.out.println("Please enter your Id...");
        Scanner scanner = new Scanner(System.in);
        this.userId = scanner.nextLine();
        System.out.println("Please enter your Password...");
        this.password = scanner.nextLine();
        b=loginValidation(this.userId, this.password, userDatabase);
        if(b==true)
        {
            //go ahead with cab booking
        }
        else{
            System.out.println("If you want to go to register and login screen please type 9, if you want to login again press any other key");
            if(scanner.nextInt()==9)
            {
                m.run(userDatabase);
            }
            else{
                loginDetails(userDatabase);
            }
            
            
        }

    }

    public boolean loginValidation(String id,String password,ArrayList<User> database){
        int i,flag=0;
        boolean retval=false;
        for(i=0;i<database.size() && flag==0;i++)
        {
            User u=database.get(i);
            if(u.userId==id)
            {   
                if(u.password==password)
                {
                    flag=1;
                    System.out.println("Login Successful\nWelcome "+ u.name);
                    retval=true;
                }
                
            }

        }
        if(flag==0)
        {
            retval=false;
            System.out.println("Authentication Failure...\nIncorrect Credentials");
        }
        return retval;

    }
}