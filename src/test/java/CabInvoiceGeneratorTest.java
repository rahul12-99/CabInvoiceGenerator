import com.cabinvoice.CabInvoiceGenerator;
import com.cabinvoice.Ride;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CabInvoiceGeneratorTest {
    CabInvoiceGenerator invoiceGenerator = new CabInvoiceGenerator();

    /**
     * This method is for calculated fare test
     */
    @Test
    public void givenDistance_shouldReturnFare(){
        double distance = 2.0;
        int time = 5;
        double result = invoiceGenerator.calculateFare(distance,time);
        Assertions.assertEquals(25,result);
    }

    /**
     * This method is for test the multiple rides
     */
    @Test
    public void givenDistanceAndTime_ForMultipleRide_ShouldReturnTotalFare() {
        Ride[] rides = {new Ride(2,2),new Ride(5,1)};
        double invoice = invoiceGenerator.invoiceGenerators(rides);
        Assertions.assertEquals(73, invoice, 0.0);
    }
}
