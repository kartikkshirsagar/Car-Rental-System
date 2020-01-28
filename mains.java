import java.util.ArrayList;

public class mains{
    public static void main(String[] args){
        ArrayList<User> userdatabase= new ArrayList<User>();
        ArrayList<City> cities=new ArrayList<City>();
        
        ArrayList<Cars> car_data=new ArrayList<Cars>();
        User u1=new User("kartik","1234567890","kartik.kshirsagar@outlook.com","kshirsagar","kartik");
        User u2 = new User("suruchi","0987654321","suruchishrey@gmail.com","shrey","suruchi");
        Driver d1 = new Driver("Doe","8765432109","MH098183");
        Driver d2 = new Driver("John","0987654321","PJ908765");
        Driver d3 = new Driver("Stonks","9999999999","XL09876");
        Driver d4 = new Driver("Salman K","6969696969","BBH420");
        cities.add(new City(120,75,1));
        cities.add(new City(21,77,2));
        cities.add(new City(84,9,3));
        cities.add(new City(21,100,4));
        
        car_data.add(new Cars("i20","MH-04-610",1));
        car_data.add(new Cars("i10","MH-04-710",2));
        car_data.add(new Cars("Tesla","MH-31-999",3));
        
        Mainscreen m = new Mainscreen();
        m.run(userdatabase,cities,car_data);
    }
}
