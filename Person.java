import java.util.*;
import java.util.regex.Pattern;

public class Person{

    String name;
    String email;
    String userId;
    String mobnumber;
    String password;

     String generateId(){
        String set ="QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm1234567890@#";
        StringBuilder random = new StringBuilder();
        Random rnd = new Random();
        while(random.length()<7){
            int index=(int)((rnd.nextFloat()*100)%64);
            random.append(set.charAt(index));
        }
        String randomId = random.toString();
        return randomId;        
    
    }
    
    

    public void getDetails(){
        Scanner scanner=new Scanner(System.in);
        try{
            System.out.println("Enter your name");
            this.name = scanner.nextLine();
        }catch(InputMismatchException e){
            System.out.println("Error in input type "+ e);
        }
        
        while(this.name.length()<=1 || this.name.startsWith(" "))
        {
            System.out.println("Please enter valid name");
            this.name=scanner.nextLine();
        }
        System.out.println("Enter your E-Mail");
        this.email = scanner.nextLine();
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                        "[a-zA-Z0-9_+&*-]+)*@" + 
                         "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                             "A-Z]{2,7}$";
        Pattern pat = Pattern.compile(regex);

        while(!(pat.matcher(this.email).matches()))
        {
            System.out.println("Please enter valid email");
            this.email=scanner.nextLine();
        }
        System.out.println("Enter your Mobile Number");
        this.mobnumber = scanner.nextLine();
        while(this.mobnumber.length()!=10 || this.mobnumber.startsWith(" "))
        {
            System.out.println("Please enter valid mobile number");
            this.mobnumber=scanner.nextLine();
        }
        
        this.userId=generateId();
        System.out.println("Your ID is " + this.userId);
        System.out.println("Please enter a password for your account");
        this.password=scanner.nextLine();


    }

    


};