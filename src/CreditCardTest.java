import static org.junit.Assert.*;

import org.junit.Test;

public class CreditCardTest {

    @Test
    public void testGetCardNumber() {
        // Arrange
        CreditCard card = new VisaCC("4123456789123");
        CreditCard card2 = new MasterCard("5123456789123456");
        CreditCard card3 = new AmericanExpress("341234567891234");
        CreditCard card4 = new Discover("6011123456789123");
        CreditCard card5 = new inValidCard("3601112345678789");

        assertEquals("4123456789123", card.getCardNumber());
        assertEquals("5123456789123456", card2.getCardNumber());
        assertEquals("341234567891234", card3.getCardNumber());
        assertEquals("6011123456789123", card4.getCardNumber());
        assertEquals("3601112345678789", card5.getCardNumber());  
    }
    
    @Test
    public void testNextHandler(){
        CreditCard card = new VisaCC(null);
        CreditCard card2 = new MasterCard(null);
        CreditCard card3 = new AmericanExpress(null);
        CreditCard card4 = new Discover(null);
        CreditCard card5 = new inValidCard(null);

        card.setNextHandler(card2);
        card2.setNextHandler(card3);
        card3.setNextHandler(card4);
        card4.setNextHandler(card5);

        assertEquals(card2, card.getNextHandler());
        assertEquals(card3, card2.getNextHandler());
        assertEquals(card4, card3.getNextHandler());
        assertEquals(card5, card4.getNextHandler());
        assertEquals(null, card5.getNextHandler());
    }

    @Test
    public void testValidate(){
        CreditCard card = new VisaCC("4123456789123");
        CreditCard card2 = new MasterCard("5123456789123456");
        CreditCard card3 = new AmericanExpress("341234567891234");
        CreditCard card4 = new Discover("6011123456789123");
        CreditCard card5 = new inValidCard("3601112345678789");

        assertEquals(null, card.getCardType());
        assertEquals(null, card2.getCardType());
        assertEquals(null, card3.getCardType());
        assertEquals(null, card4.getCardType());
        assertEquals(null, card5.getCardType());

        card.handleValidate();
        card2.handleValidate();
        card3.handleValidate();
        card4.handleValidate();
        card5.handleValidate();

        assertEquals("Visa", card.getCardType());
        assertEquals("MasterCard", card2.getCardType());
        assertEquals("AmericanExpress", card3.getCardType());
        assertEquals("Discover", card4.getCardType());
        assertEquals("Invalid: not a possible card number", card5.getCardType());
    }
}