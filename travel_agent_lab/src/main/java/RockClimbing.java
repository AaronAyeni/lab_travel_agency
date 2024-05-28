public class RockClimbing extends Activity{


    String instructorName;

    public RockClimbing(double price,int capacity,String instructorName){
        super(price, capacity);
        this.instructorName = instructorName;


    }

    public String getInstructorName(){
        return this.instructorName;
    }

    public void setInstructorName(String newInstructor){
        this.instructorName =  newInstructor;
    }

    public String climb(int distance,int customerNumber){

        return  super.getFromCustomerList(customerNumber).getName() + " climbed " + distance+ " feet";
    }


}
