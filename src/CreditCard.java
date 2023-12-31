public interface CreditCard {
    String getCardNumber();
    String getCardType();
    CreditCard getNextHandler();
    CreditCard handleValidate();
    void setNextHandler(CreditCard next);
}

class inValidCard implements CreditCard{
    String cardNumber;
    String cardType;
    CreditCard nextHandler;

    public inValidCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public CreditCard handleValidate() {
        if (cardNumber == null || cardNumber.length() == 0) {
            cardType = "Invalid: empty/null card number";
            return this;
        }
        if (cardNumber.length() > 19) {
            cardType = "Invalid: more than 19 digits";
            return this;    
        }
        if (!cardNumber.matches("[0-9]+")) {
            cardType = "Invalid: contains non-numeric characters";
            return this;
        }
    
        if (nextHandler != null) {
            return nextHandler.handleValidate();
        } else {
            cardType = "Invalid: not a possible card number";
            return this;
        }
        
    }

    @Override
    public void setNextHandler(CreditCard next) {
        this.nextHandler = next;
    }

    @Override
    public String getCardNumber() {
        return cardNumber;
    }
    @Override
    public String getCardType() {
        return cardType;
    }

    @Override
    public CreditCard getNextHandler() {
        return nextHandler;
    }

}

class VisaCC implements CreditCard {
    private String cardNumber;
    private String cardType;
    private CreditCard nextHandler;

    public VisaCC(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public CreditCard handleValidate() {
        if (cardNumber.charAt(0) == '4' && (cardNumber.length() == 13 || cardNumber.length() == 16) ) {
            this.cardType = "Visa";
            System.out.println(cardNumber + " Validated by Visa");
            return this;
        } else if (nextHandler != null) {
            return nextHandler.handleValidate();
        } else{
            return null;
        }
        
    }

    @Override
    public void setNextHandler(CreditCard next) {
        this.nextHandler = next;
    }

    @Override
    public String getCardNumber() {
        return cardNumber;
    }
    @Override 
    public String getCardType() {
        return cardType;
    }
    @Override
    public CreditCard getNextHandler() {
        return nextHandler;
    }
}

class MasterCard implements CreditCard {
    private String cardNumber;
    private String cardType;
    private CreditCard nextHandler;

    public MasterCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public CreditCard handleValidate() {
        if (cardNumber.charAt(0) == '5' && cardNumber.length() == 16 && (cardNumber.charAt(1) >= '1' && cardNumber.charAt(1) <= '5')) {
            this.cardType = "MasterCard";
            System.out.println(cardNumber + " Validated by MasterCard");
            return this;
        } else if (nextHandler != null) {
            return nextHandler.handleValidate();
        } else{
            return null;
        }
    }

    @Override
    public void setNextHandler(CreditCard next) {
        this.nextHandler = next;
    }

    @Override
    public String getCardNumber() {
        return cardNumber;
    }
    @Override
    public String getCardType() {
        return cardType;
    }
    @Override
    public CreditCard getNextHandler() {
        return nextHandler;
    }
}

class AmericanExpress implements CreditCard {
    private String cardNumber;
    private String cardType;
    private CreditCard nextHandler;

    public AmericanExpress(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public CreditCard handleValidate() {
        if (cardNumber.charAt(0) == '3' && cardNumber.length() == 15 && (cardNumber.charAt(1) == '4' || cardNumber.charAt(1) == '7')) {
            this.cardType = "AmericanExpress";
            System.out.println(cardNumber + " Validated by American Express");
            return this;
        } else if (nextHandler != null) {
            return nextHandler.handleValidate();
        } else{
            return null;
        }
    }

    @Override
    public void setNextHandler(CreditCard next) {
        this.nextHandler = next;
    }

    @Override
    public String getCardNumber() {
        return cardNumber;
    }
    @Override
    public String getCardType() {
        return cardType;
    }
    @Override
    public CreditCard getNextHandler() {
        return nextHandler;
    }
}

class Discover implements CreditCard {
    private String cardNumber;
    private String cardType;
    private CreditCard nextHandler;

    public Discover(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public CreditCard handleValidate() {
        if (cardNumber.substring(0,4).equals("6011") && cardNumber.length() == 16) {
            this.cardType = "Discover";
            System.out.println(cardNumber + " Validated by Discover");
            return this;
        } else if (nextHandler != null) {
            return nextHandler.handleValidate();
        } else{
            return null;
        }
    }

    @Override
    public void setNextHandler(CreditCard next) {
        this.nextHandler = next;
    }

    @Override
    public String getCardNumber() {
        return cardNumber;
    }
    @Override
    public String getCardType() {
        return cardType;
    }
    @Override
    public CreditCard getNextHandler() {
        return nextHandler;
    }
}