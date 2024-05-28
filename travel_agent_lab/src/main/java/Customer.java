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
        if (newName.isEmpty()){
            throw new IllegalArgumentException("Customer name cannot be empty!");
        } else {
            this.name = newName;
        }
    }

    public double getWalletAmount(){
        return this.wallet;
    }

    public void addToWallet(double amount){
        if (amount < 0){
            throw new ArithmeticException("Please provide valid amount");
        } else {
            this.wallet += amount;
        }
    }

    public void payFromWallet(double amount) {
        if (this.canAfford(amount) && amount>0) {
            this.wallet -= amount;
        } else {
            throw new ArithmeticException("Please provide valid amount!");
        }

    }

    public boolean canAfford(double price){
        if (this.wallet >= price){
            return true;
        }

        else{
            throw new ArithmeticException("The wallet does not have sufficient money!");
        }
    }














}
