import java.util.ArrayList;

public class Train implements Bookable{

    private double price;
    private int capacity;
    private ArrayList<Customer> customers;
    private TravelClass travelClass;

    public Train(double price, int capacity){
        this.price = price;
        this.capacity = capacity;
        this.customers = new ArrayList<>();
        this.travelClass = null;
    }

    public void book(Customer customer){
        if(this.hasCapacity()){
            customer.payFromWallet(this.price);
            this.addToCustomerList(customer);
            this.reduceCapacityByOne();
        }
    }

    public void book(Customer customer, String ticketType){
        if(this.hasCapacity()){
            this.setPrice(ticketType);
            customer.payFromWallet(this.price);
            this.addToCustomerList(customer);
            this.reduceCapacityByOne();
        }
    }

    public void setTravelClass(String tickeType){
        this.travelClass = TravelClass.valueOf(tickeType);
    }

    public void cancel(Customer customer){
        customer.addToWallet(this.price);
        this.removeFromCustomerList(customer);
        this.increaseCapacityByOne();
    }

    public double getPrice(){
        return this.price;
    }

    public void setPrice(String travelType){
        this.setTravelClass(travelType);
        switch (this.travelClass.name()) {
            case "FIRSTCLASS":
                this.price = 200.00;
                break;
            case "ECONOMYCLASS":
                this.price = 50.00;
        }

    }

    public int getCapacity(){
        return this.capacity;
    }

    public void setCapacity(int numberOfSeats){
        this.capacity = numberOfSeats;
    }

    public boolean hasCapacity(){
        return this.capacity > 0;
    }

    public void reduceCapacityByOne(){
        this.capacity -= 1;
    }

    public void increaseCapacityByOne(){
        this.capacity += 1;
    }

    public ArrayList<Customer> getCustomerList(){
        return this.customers;
    }

    public Customer getCustomerFromList(int customerNumber){
        return this.customers.get(customerNumber-1);
    }

    public void addToCustomerList(Customer customer){
        this.customers.add(customer);
    }

    public void removeFromCustomerList(Customer customer){
        this.customers.remove(customer);
    }

    public int countCustomers(){
        return this.customers.size();
    }


}
