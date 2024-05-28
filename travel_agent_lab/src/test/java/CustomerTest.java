import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CustomerTest {


    Customer customer;

    @BeforeEach
    public void setUp(){
        customer = new Customer("John",100.0);
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
    public void canSetName_withException(){
        Exception exception  = assertThrows(IllegalArgumentException.class, () ->
                customer.setName(""));
        String expected = "Customer name cannot be empty!";
        String actual = exception.getMessage();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void canGetWalletAmount(){
        assertThat(customer.getWalletAmount()).isEqualTo(100.00);
    }


    @Test
    public void canAddToWalletAmount(){
        customer.addToWallet(5.0);
        assertThat(customer.getWalletAmount()).isEqualTo(105.00);
    }

    @Test
    public void canAddToWallet_withException(){
        Exception exception = assertThrows(ArithmeticException.class, ()->
                customer.addToWallet(-5));
        String expected = "Please provide valid amount";
        String actual = exception.getMessage();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void canPayFromWalletAmount(){
        customer.addToWallet(10);
        customer.payFromWallet(5);
        assertThat(customer.getWalletAmount()).isEqualTo(105.00);
    }

    @Test
    public void canPaycanPayFromWallet_withException(){
        Exception exception = assertThrows(ArithmeticException.class, ()->
                customer.payFromWallet(-50));
        String expected = "Please provide valid amount!";
        String actual = exception.getMessage();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void checkCanAfford(){
        customer.addToWallet(10);
        assertThat(customer.canAfford(5)).isEqualTo(true);
    }

    @Test
    public void checkCanAfford_withException(){
        Exception exception = assertThrows(ArithmeticException.class, ()->
                customer.canAfford(110));
        String expected = "The wallet does not have sufficient money!";
        String actual = exception.getMessage();
        assertThat(actual).isEqualTo(expected);
    }


}
