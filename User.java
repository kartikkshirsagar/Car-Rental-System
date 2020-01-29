import java.util.*;

public class User extends Person implements Respondent{

    User(String name , String mobno,String email,String ID ,String pass){
        this.name = name;
        this.mobnumber = mobno;
        this.email = email;
        this.userId = ID;
        this.password = pass;
    }
    User(){}
    

    public void rate(User u){
        System.out.println("How many stars would you like to give to our service(out of 5)?");
        int star;
        Scanner scanner1 = new Scanner(System.in);
        star = scanner1.nextInt();
        System.out.println("Thank you for your feedback!! "+ u.name + " You gave us "+ star+ "stars.");
        

    }


    
    public void bookCab(User user,ArrayList<City> cities,ArrayList<Cars>car_data){
        
        System.out.println("Please enter pick up location\n1 for City 1\n2 for City 2\n3 for City 3\n4 for City 4\n5 for City 5\n");
        Scanner scanner = new Scanner(System.in);
        int ans,ans2,ans3,flag=0,cost;
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
            cost = r1.getCost(r1);
            cost=Math.abs(cost);

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
            cost=r2.getCost(r2);
            cost=Math.abs(cost);
            flag=2;   
        }
        //System.out.println(cost);

        System.out.println("Select a Car Category\n1 for Mini\n2 for Micro\n3 for Luxury\n");
        Scanner myObj = new Scanner(System.in);
        //Random rnd = new Random();
       // int index = rnd.nextInt(5);
        ans=myObj.nextInt();
        int flag1=0;
        if(ans==1)
        {
            if(car_data.get(0).availability)
            {
                car_data.get(0).displayInfo();
                car_data.get(0).availability=false;
                flag1=0;

            }
            else{
                System.out.println("Sorry Car not available!!");
                flag1=1;
            }
            
        }
        else if(ans==2)
        {
            if(car_data.get(1).availability)
            {
                car_data.get(1).displayInfo();
                car_data.get(1).availability=false;
                flag1=0;
            }
            else{
                System.out.println("Sorry Car not available!!");
                flag1=1;
            }
            
        }
        else if(ans==3)
        {
            if(car_data.get(2).availability)
            {
                car_data.get(2).displayInfo();
                car_data.get(2).availability=false;
                flag1=0;
            }
            else{
                System.out.println("Sorry Car not available!!");
                flag1=1;
            }
            
        }
        flag=0;
        mains obj = new mains();
        ArrayList<Driver> drivers = new ArrayList<Driver>();
        drivers=obj.getList(); 
        for (Driver driver : drivers) {
            if(driver.availabilty==true  && flag==0 && flag1==0 ){
                driver.displayDriver(driver);
                driver.availabilty=false;
                flag=1;
            }
        }
        if(flag1==0){
            System.out.println("Your Trip Cost would be " + cost);
        }
        
        System.out.println("Want to book one more cab??(1 for yes 0 for no)");
        Scanner ans4=new Scanner(System.in);
        if(ans4.nextInt()==1)
        {
            System.out.println("Okay then enter!!");
            bookCab(user, cities, car_data);
        }
        else {
            System.out.println("Thanks for your booking, details have been sent to " + user.email);
        }
        user.rate(user);
    
    }




    public void loginDetails(ArrayList<User> userDatabase,ArrayList<City> cities,ArrayList<Cars>car_data){
        boolean b;
        Mainscreen m = new Mainscreen();
        System.out.println("Please enter your Id...");
        Scanner scanner = new Scanner(System.in);
        this.userId = scanner.nextLine();
        System.out.println("Please enter your Password...");
        this.password = scanner.nextLine();
        b=loginValidation(this.userId, this.password, userDatabase);
        System.out.println(b);
        if(b==true)
        {
            //go ahead with cab booking
            for (User user : userDatabase) {
                if(user.userId.equals(this.userId))
                {
                    bookCab(user,cities,car_data);
                }
            }

        }
        else{
            System.out.println("If you want to go to register and login screen please type 9, if you want to login again press any other integer");
            int ans=scanner.nextInt();
            if(ans==9)
            {
                m.run(userDatabase,cities,car_data);
            }
            else{
                loginDetails(userDatabase,cities,car_data);
            }
            
            
        }


    }

    public void register(User u1,ArrayList<User> database){
        database.add(u1);
    }

    public boolean loginValidation(String id,String password,ArrayList<User> database){
        int i,flag=0;
        boolean retval=false;
        for(i=0;i<database.size() && flag==0;i++)
        {
            User u=database.get(i);
            if(u.userId.equals(id))
            {   
                if(u.password.equals(password))
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

interface Respondent{
    public void rate(User user);
    //public void issues();
}
