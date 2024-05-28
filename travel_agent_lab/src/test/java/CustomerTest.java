import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CustomerTest {


    Customer customer;

    @BeforeEach

    public void setUp(){

        customer = new Customer("John");


    }


    @Test

    public void canGetName(){
        assertThat(customer.getName()).isEqualTo("John");
    }


    @Test

    public void canSetName(){
        customer.setName("Bob");
        assertThat(customer.getName()).isEqualTo("Bob");
    }

    @Test

    public void canGetWalletAmount(){
        assertThat(customer.getWalletAmount()).isEqualTo(0.0);
    }


    @Test

    public void canSetWalletAmount(){
        customer.addToWallet(5.0);
        assertThat(customer.getWalletAmount()).isEqualTo(5.0);
    }

    @Test

    public void canPayFromWalletAmount(){
        customer.addToWallet(10);
        customer.payFromWallet(5);
        assertThat(customer.getWalletAmount()).isEqualTo(5);
    }

    @Test

    public void checkCanAfford(){
        customer.addToWallet(10);
        assertThat(customer.canAfford(5)).isEqualTo(true);
        assertThat(customer.canAfford(20)).isEqualTo(false);
    }




















}
