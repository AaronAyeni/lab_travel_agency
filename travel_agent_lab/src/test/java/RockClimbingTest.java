import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RockClimbingTest {

    RockClimbing rockClimbing;
    Customer customer;
    TravelAgent travelAgent;

    @BeforeEach

    public void setUp(){
        rockClimbing = new RockClimbing(10,5,"Paul");
        customer = new Customer("Mark",100);
        travelAgent = new TravelAgent();

    }

    @Test

    public void canRockClimb(){
        travelAgent.makeBooking(rockClimbing,customer);
        assertThat(rockClimbing.climb(10,1)).isEqualTo("Mark climbed 10 feet");
    }
















}
