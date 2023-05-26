import com.cabinvoice.CabInvoiceGenerator;
import com.cabinvoice.InvoiceSummary;
import com.cabinvoice.Ride;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CabInvoiceGeneratorTest {
    CabInvoiceGenerator invoiceGenerator = new CabInvoiceGenerator();

    /**
     * This method is for calculated fare test
     */
    @Test
    public void givenDistance_shouldReturnFare() {
        double distance = 2.0;
        int time = 5;
        double result = invoiceGenerator.calculateFare(distance, time);
        Assertions.assertEquals(25, result);
    }

    /**
     * This method is for test the multiple rides
     */
    @Test
    public void givenDistanceAndTime_ForMultipleRide_ShouldReturnTotalFare() {
        Ride[] rides = {new Ride(2, 2), new Ride(5, 1)};
        double invoice = invoiceGenerator.invoiceGenerators(rides);
        Assertions.assertEquals(73, invoice, 0.0);
    }

    /**
     * This method is for test the total no of ride , total fare and average fare per ride
     */
    @Test
    public void givenDistanceAndTime_ForMultipleRide_ShouldReturnSummary() {
        Ride[] rides = {new Ride(2, 2),
                new Ride(5, 1)};
        InvoiceSummary summary = invoiceGenerator.invoiceGeneratorNew(rides);
        InvoiceSummary expectedSummary = new InvoiceSummary(2, 73);
        Assertions.assertEquals(expectedSummary, summary);
    }

    /**
     * this method is tested for the invoice service gets from list of rides and return invoice
     */
    @Test
    public void givenDistanceAndTime_ShouldReturnInvoiceService() {
        Ride[] rides = {new Ride(2,2),
                new Ride(5,1)};

        Ride[] userTwo = {new Ride(3,1),
                new Ride(1,5)};
        InvoiceSummary summary = invoiceGenerator.invoiceGeneratorList(rides,userTwo);
        InvoiceSummary expectedSummary = new InvoiceSummary(2, 119);
        Assertions.assertEquals(expectedSummary, summary);
    }
}
