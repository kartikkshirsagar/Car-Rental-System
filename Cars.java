public class Cars{
    String name;
    int category;
    String numberPlate;
    boolean availability;
     void getCostMultiplier(Ride r){
       
     };
     void displayCarInfo()
     {
         System.out.println("-------------------------------------------");
         System.out.println("Car Name: "+ name+"\n");
         System.out.println("Car License Plate: "+ numberPlate + "\n");
         System.out.println("-------------------------------------------");

     }
     Cars(String name,String numberPlate,int category){
         this.category = category;
         this.name = name;
         this.numberPlate=numberPlate; 
         this.availability=true;
     }
}
