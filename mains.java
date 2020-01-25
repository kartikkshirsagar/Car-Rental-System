import java.util.ArrayList;

public class mains{
    public static void main(String[] args){
        ArrayList<User> userdatabase= new ArrayList<User>();
        User u1=new User();
        Mainscreen m = new Mainscreen();
        m.run(userdatabase);
    }
}