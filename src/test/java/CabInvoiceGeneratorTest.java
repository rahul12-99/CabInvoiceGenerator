import com.cabinvoice.CabInvoiceGenerator;
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
}
