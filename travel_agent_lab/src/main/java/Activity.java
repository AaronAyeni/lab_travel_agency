import java.util.ArrayList;

public abstract class Activity implements Bookable{

    double price;

    ArrayList<Customer> customerList;

    int capacity;

    public Activity(double price,int capacity){
        this.price = price;
        this.capacity = capacity;
        this.customerList = new ArrayList<Customer>();

    }

    public double getPrice(){
        return this.price;

    }

    public void setPrice(double newPrice){
        this.price = newPrice;
    }

    public int getCapacity(){
        return this.capacity;
    }

    public void setCapacity(int capacity){
        this.capacity = capacity;
    }

    public void increaseCapacityByOne(){
        this.capacity += 1;
    }

    public void reduceCapacityByOne(){
        this.capacity -= 1;
    }

    public Customer getFromCustomerList(int customerNumber){
        return this.customerList.get(customerNumber-1);
    }

    public void addToCustomerList(Customer customer){
        this.customerList.add(customer);
    }

    public void removeFromCustomerList(Customer customer){
        this.customerList.remove(customer);
    }

    public boolean hasCapacity(){
        return this.capacity>0;
    }

    public void book(Customer customer){
        customer.payFromWallet(this.price);
        this.addToCustomerList(customer);
        this.reduceCapacityByOne();

    }

    public void cancel(Customer customer){
        customer.addToWallet(this.price);
        this.removeFromCustomerList(customer);
        this.increaseCapacityByOne();
    }


















}
