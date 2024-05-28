import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TravelAgentTest {


    Train train;
    Customer customer;
    BedAndBreakfast hotel;
    TravelAgent travelAgent;
    Customer customerTwo;

    @BeforeEach

    public void setUp(){
        customer = new Customer("Rabin",1000);
        customerTwo = new Customer("Dan",1500);
        train = new Train(50,100);
        hotel = new BedAndBreakfast(100,customer,3);
        travelAgent = new TravelAgent();

    }

    @Test

    public void canMakeBooking(){
        travelAgent.makeBooking(train,customer);
        assertThat(customer.getWalletAmount()).isEqualTo(950.00);
        assertThat(train.getCustomerFromList(1)).isEqualTo(customer);
        assertThat(train.getCapacity()).isEqualTo(99);



    }
    @Test

    public void canCancelBooking(){
        travelAgent.makeBooking(train,customer);
        travelAgent.makeBooking(train,customerTwo);


        travelAgent.cancelBooking(train,customer);
        assertThat(customer.getWalletAmount()).isEqualTo(1000.00);
        assertThat(train.getCustomerFromList(1)).isEqualTo(customerTwo);
        assertThat(train.getCapacity()).isEqualTo(99);








    }



}
