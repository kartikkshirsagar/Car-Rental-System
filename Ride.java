import mypackage.Cost;
public class Ride{
    int rideCost;
    Cost obj=new Cost();
    Ride(City source,City destination)
    {
        int x=obj.calc(source.x_coordinate ,destination.x_coordinate,source.y_coordinate,destination.y_coordinate) ;

        this.rideCost= x;
    }

    Ride(City source,City destination,City via){
        int x=obj.calc(source.x_coordinate ,destination.x_coordinate,via.x_coordinate,via.y_coordinate,source.y_coordinate,destination.y_coordinate) ;
        this.rideCost =x;
    }
    public int getCost(Ride r1)
    {
        return r1.rideCost;
    }
}