import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TrainTest {


    Train train;
    Customer fisrtCustomer;
    Customer secondCustomer;

    @BeforeEach
    public void setUp(){
        train = new Train(100.00, 200);
        fisrtCustomer = new Customer("Dan", 1000.00);
        secondCustomer = new Customer("Aaron", 2000.00);
    }

    @Test
    public void canGetPrice(){
        assertThat(train.getPrice()).isEqualTo(100.00);
    }

    @Test
    public void canSetPrice(){
        train.setPrice("FIRSTCLASS");
        assertThat(train.getPrice()).isEqualTo(200.00);
        train.setPrice("ECONOMYCLASS");
        assertThat(train.getPrice()).isEqualTo(50.00);
    }

    @Test
    public void canGetCapacity(){
        assertThat(train.getCapacity()).isEqualTo(200);
    }

    @Test
    public void canSetCapacity(){
        train.setCapacity(300);
        assertThat(train.getCapacity()).isEqualTo(300);
    }

    @Test
    public void checkHasCapacity(){
        assertThat(train.hasCapacity()).isEqualTo(true);
    }

    @Test
    public void canReduceCapacityByOne(){
        train.reduceCapacityByOne();
        assertThat(train.getCapacity()).isEqualTo(199);
    }

    @Test
    public void canIncreaseCapacityByOne(){
        train.increaseCapacityByOne();
        assertThat(train.getCapacity()).isEqualTo(201);
    }

    @Test
    public void cangetCustomList(){
        ArrayList<Customer> result= train.getCustomerList();
        assertThat(result.size()).isEqualTo(0);
    }

    @Test
    public void canGetCustomerFromList(){
        train.addToCustomerList(fisrtCustomer);
        train.addToCustomerList(secondCustomer);
        Customer result = train.getCustomerFromList(2);
        assertThat(result).isEqualTo(secondCustomer);
    }

    @Test
    public void canAddToCustomerList(){
        train.addToCustomerList(fisrtCustomer);
        Customer result = train.getCustomerFromList(1);
        assertThat(result).isEqualTo(fisrtCustomer);
    }

    @Test
    public void canRemoveFromCustomerList(){
        train.addToCustomerList(fisrtCustomer);
        train.addToCustomerList(secondCustomer);
        train.removeFromCustomerList(fisrtCustomer);
        assertThat(train.countCustomers()).isEqualTo(1);
    }

    @Test
    public void canCountCustomers(){
        assertThat(train.countCustomers()).isEqualTo(0);
    }

    @Test
    public void canBook(){
        train.book(fisrtCustomer);
        assertThat(fisrtCustomer.getWalletAmount()).isEqualTo(900.00);
        assertThat(train.getCustomerFromList(1)).isEqualTo(fisrtCustomer);
        assertThat(train.getCapacity()).isEqualTo(199);
    }

    public void canBook_withTicketType(){
        train.book(fisrtCustomer, "FIRSTCLASS");
        assertThat(fisrtCustomer.getWalletAmount()).isEqualTo(800.00);
        assertThat(train.getCustomerFromList(1)).isEqualTo(fisrtCustomer);
        assertThat(train.getCapacity()).isEqualTo(199);
    }

    @Test
    public void canCancel(){
        train.book(fisrtCustomer);
        train.book(secondCustomer);
        train.cancel(fisrtCustomer);
        assertThat(fisrtCustomer.getWalletAmount()).isEqualTo(1000.00);
        assertThat(train.countCustomers()).isEqualTo(1);
        assertThat(train.getCapacity()).isEqualTo(199);
    }


}
