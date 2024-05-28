public class Swimming extends Activity{


    String instructorName;

    public Swimming(double price,int capacity,String instructorName){
        super(price, capacity);
        this.instructorName = instructorName;


    }

    public String getInstructorName(){
        return this.instructorName;
    }

    public void setInstructorName(String newInstructor){
        this.instructorName =  newInstructor;
    }

    public String swim(int distance,int customerNumber){

        return  super.getFromCustomerList(customerNumber).getName() + " swam " + distance+ " meters";
    }







}
