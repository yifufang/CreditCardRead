import org.junit.Test;
import static org.junit.Assert.*;

public class CardFactoryTest {
    @Test
    public void factoryTest() {
        CardFactory cardFactory = new ConcreateCardFactory();
        CreditCard card = cardFactory.createCard("4123456789123");
        CreditCard card2 = cardFactory.createCard("");

        assertEquals("Visa", card.getCardType());
        assertEquals("4123456789123", card.getCardNumber());
        assertEquals("Invalid: empty/null card number", card2.getCardType());
        assertEquals("", card2.getCardNumber());
    }
}
