import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BedAndBreakfastTest {

    Customer firstCustomer;
    BedAndBreakfast bedAndBreakfast;

    @BeforeEach
    public void setUp(){
        firstCustomer = new Customer("John",100.0);
        bedAndBreakfast = new BedAndBreakfast(50.0,firstCustomer,4);
    }

    @Test
    public void canSetPrice(){
        bedAndBreakfast.setPrice(30);
        assertThat(bedAndBreakfast.getPrice()).isEqualTo(30);
    }

    @Test
    public void canGetPrice(){
        assertThat(bedAndBreakfast.getPrice()).isEqualTo(50);
    }

    @Test
    public void canGetCapacity(){
        assertThat(bedAndBreakfast.getCapacity()).isEqualTo(4);
    }

    @Test
    public void canSetCapacity(){
        bedAndBreakfast.setCapacity(3);
        assertThat(bedAndBreakfast.getCapacity()).isEqualTo(3);
    }

    @Test
    public void canReduceCapacityByOne(){
        bedAndBreakfast.reduceCapacityByOne();
        assertThat(bedAndBreakfast.getCapacity()).isEqualTo(3);
    }

    @Test
    public void canGetCustomer(){
        assertThat(bedAndBreakfast.getCustomer()).isEqualTo(firstCustomer);
    }

    @Test
    public void canSetCustomer(){
        Customer secondCustomer = new Customer("Mark",100.0);
        bedAndBreakfast.setCustomer(secondCustomer);
        assertThat(bedAndBreakfast.getCustomer()).isEqualTo(secondCustomer);
    }
    @Test
    public void canBook(){
        bedAndBreakfast.book(firstCustomer);
        assertThat(firstCustomer.getWalletAmount()).isEqualTo(50);
        assertThat(bedAndBreakfast.getCapacity()).isEqualTo(3);
    }
    @Test
    public void canCancel(){
        bedAndBreakfast.book(firstCustomer);
        bedAndBreakfast.cancel(firstCustomer);

        assertThat(firstCustomer.getWalletAmount()).isEqualTo(100);
        assertThat(bedAndBreakfast.getCapacity()).isEqualTo(4);
    }
    @Test
    public void checkHasCapacity(){
        bedAndBreakfast = new BedAndBreakfast(50.0,firstCustomer,1);

        assertThat(bedAndBreakfast.hasCapacity()).isEqualTo(true);
        bedAndBreakfast.book(firstCustomer);
        assertThat(bedAndBreakfast.hasCapacity()).isEqualTo(false);
    }

}
