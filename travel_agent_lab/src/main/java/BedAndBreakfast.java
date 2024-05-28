public class BedAndBreakfast implements Bookable {
    private double price;
    private Customer customer;
    private int capacity;

    public BedAndBreakfast(double price, Customer customer, int capacity){
       this.price = price;
       this.customer = customer;
       this.capacity = capacity;

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

    public void reduceCapacity(int noOfCustomers){
        this.capacity -= noOfCustomers;
    }
    public void setCapacity(int noOfRooms){
        this.capacity = noOfRooms;
    }

    public Customer getCustomer(){
        return this.customer;
    }
    public void setCustomer(Customer customer){
        this.customer = customer;
    }

    public void book(Customer customer){
        customer.payFromWallet(this.price);
        this.reduceCapacity(1);
    }

    public void cancel(Customer customer){
        customer.addToWallet(this.price);
        this.reduceCapacity(-1);
    }

    public boolean hasCapacity(){
        if(this.capacity > 0){
            return true;
        }
       return false;
    }
}
