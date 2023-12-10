import static org.junit.Assert.*;

import org.junit.Test;

public class CreditCardTest {

    @Test
    public void testGetCardNumber() {
        // Arrange
        try{
            CardFactory factory = new ConcreateCardFactory();
            CreditCard card = factory.createCard("");
            CreditCard card2 = factory.createCard("12345678901234567890123");
            CreditCard card3 = factory.createCard("123456789012345678U");
            CreditCard card4 = factory.createCard("52345678901234*6");
            CreditCard card5 = factory.createCard("3601112345678789");
            // Assert
            assertEquals("Invalid: empty/null card number", card.getCardType());
            assertEquals("Invalid: more than 19 digits", card2.getCardType());
            assertEquals("Invalid: contains non-numeric characters", card3.getCardType());
            assertEquals("Invalid: contains non-numeric characters", card4.getCardType());
            assertEquals("Invalid: not a possible card number", card5.getCardType());

            System.out.println("All tests succeeded!");
        }
        catch(AssertionError e){
            throw e;
        }
        
    }
    // Add more test methods here
}