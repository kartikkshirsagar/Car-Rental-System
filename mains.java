import java.util.ArrayList;

public class mains{
    public static void main(String[] args){
        ArrayList<User> userdatabase= new ArrayList<User>();
        User u1=new User("kartik","1234567890","kartik.kshirsagar@outlook.com","kshirsagar","kartik");
        User u2 = new User("suruchi","0987654321","suruchishrey@gmail.com","shrey","suruchi");
        Driver d1 = new Driver("Doe","8765432109","MH098183");
        Driver d2 = new Driver("John","0987654321","PJ908765");
        Driver d3 = new Driver("Stonks","9999999999","XL09876");
        Driver d4 = new Driver("Salman K","6969696969","BBH420");
        Mainscreen m = new Mainscreen();
        m.run(userdatabase);
    }
}