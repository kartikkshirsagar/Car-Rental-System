import java.util.*;
public class User extends Person{

    User(String name , String mobno,String email,String ID ,String pass){
        this.name = name;
        this.mobnumber = mobno;
        this.email = email;
        this.userId = ID;
        this.password = pass;
    }
    User(){}
    

    public void bookCab(User user,ArrayList<City> cities){
        System.out.println("Please enter pick up location\n1 for City A\n2 for City B\n3 for City C\n4 for City 4\n5 for City 5\n");
        Scanner scanner = new Scanner(System.in);
        int ans,ans2,ans3,flag=0;
        City pick=cities.get(0),via=cities.get(0),drop=cities.get(0);
        ans=scanner.nextInt();
        System.out.println("VIA?(Press 9 for direct route)");
        ans2=scanner.nextInt();
        System.out.println("Drop Off location?");
        ans3 = scanner.nextInt();
        
        if(ans2!=9)
        {   
            for (City city : cities) {
                if(ans==city.Id)
                {
                    pick=city;
                }
                if(ans2==city.Id)
                {
                    via=city;
                }
                if(ans3==city.Id)
                {
                    drop=city;
                }
            }
            Ride r1 = new Ride(pick,via,drop);
            flag=1;
            System.out.println("So your path is City "+ans+ "---> City " + ans2+ "--->City "+ ans3);
        }
        else{

            System.out.println("So your path is City "+ans+ "---> City " + ans3);
            for (City city : cities)
            {
                if(ans==city.Id)
                    {
                        pick=city;
                    }
                if(ans3==city.Id)
                    {
                        drop=city;
                    }
            }
            Ride r2 = new Ride(pick,drop); 
            flag=2;   
        }
        
        System.out.println("Select a Car Category\n1 for Mini\n2 for Micro\n 3 for Luxury\n");


        
    }

    public void loginDetails(ArrayList<User> userDatabase,ArrayList<City> cities){
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
            for (User user : userDatabase) {
                if(user.userId == this.userId)
                {
                    bookCab(user,cities);
                }
            }

        }
        else{
            System.out.println("If you want to go to register and login screen please type 9, if you want to login again press any other integer");
            int ans=scanner.nextInt();
            if(ans==9)
            {
                m.run(userDatabase,cities);
            }
            else{
                loginDetails(userDatabase,cities);
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