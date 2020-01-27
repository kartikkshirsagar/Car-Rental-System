
public class Ride{
    int rideCost;
    Ride(City source,City destination)
    {
        this.rideCost=((source.x_coordinate - destination.x_coordinate) +(source.y_coordinate - destination.y_coordinate))^2 ;
    }

    Ride(City source,City destination,City via){
        this.rideCost = ((source.x_coordinate - via.x_coordinate) +(source.y_coordinate - via.y_coordinate))^2 +((via.x_coordinate - destination.x_coordinate) +(via.y_coordinate - destination.y_coordinate))^2;
    }

}