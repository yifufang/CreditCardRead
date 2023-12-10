import org.junit.Test;
import static org.junit.Assert.*;

public class ChainTest {

    @Test
    public void chainTest() {
        Chain chain = new Chain();
        CreditCard card = chain.chainOfResonsibility("4123456789123");
        
        assertEquals("Visa", card.getCardType());
        assertEquals("4123456789123", card.getCardNumber());
        assertEquals(null, card.getNextHandler().getCardType());
    }
}
