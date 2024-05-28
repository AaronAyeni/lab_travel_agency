import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SwimmingTest {

    Swimming swimming;
    Customer customer;
    TravelAgent travelAgent;

    @BeforeEach

    public void setUp(){
        swimming = new Swimming(50,10,"John");
        customer = new Customer("Mark",100);
        travelAgent = new TravelAgent();

    }


    @Test

    public void canSwim(){
        travelAgent.makeBooking(swimming,customer);

        assertThat(swimming.swim(100,1)).isEqualTo("Mark swam 100 meters");

    }











}
