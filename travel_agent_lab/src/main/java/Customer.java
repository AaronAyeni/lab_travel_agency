public class Customer {



    private String name;
    private double wallet;



    public Customer(String name, double wallet){
        this.name = name;
        this.wallet = wallet;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String newName){
        this.name = newName;
    }

    public double getWalletAmount(){
        return this.wallet;
    }

    public void addToWallet(double amount){
        this.wallet += amount;
    }

    public void payFromWallet(double amount) {
        if (this.canAfford(amount)) {
            this.wallet -= amount;
        } else {
            System.out.println("Please add more money");


        }

    }

    public boolean canAfford(double price){
        if (this.wallet >= price){
            return true;
        }

        else{
            return false;
        }
    }














}
