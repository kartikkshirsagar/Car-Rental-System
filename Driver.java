public class Driver extends Person{
    String licenseno;
    boolean availabilty=true;
    Driver(String name , String mobno,String licenseno){
        this.name= name;
        this.mobnumber = mobno;
        this.licenseno = licenseno;

    }
    public void displayDriver(Driver driver)
    {
        System.out.println("---------------------------------------------\n");
        System.out.println("Your Driver is : "+ driver.name);
        System.out.println("Mobile Number: " + driver.mobnumber);
        System.out.println("License Number: " + driver.licenseno);
        System.out.println("---------------------------------------------\n");
    }
}