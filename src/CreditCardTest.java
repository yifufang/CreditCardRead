import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CreditCardTest {

    @Test
    public void testGetCardNumber() {
        // Arrange
        CardFactory factory = new ConcreateCardFactory();
        CreditCard card = factory.createCard("347856341908126");

        // Assert
        assertEquals("AmericanExpress", card.getCardType());
    }

    // Add more test methods here
}