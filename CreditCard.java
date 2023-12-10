public interface CreditCard {
    int getCardNumber();
    CreditCard handleValidate();
    void setNextHandler(CreditCard next);
}

class VisaCC implements CreditCard {
    int cardNumber;
    private CreditCard nextHandler;

    public VisaCC(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public CreditCard handleValidate() {
        if (cardNumber == 1234) {
            System.out.println("Validated by Visa");
            return this;
        } else if (nextHandler != null) {
            System.out.println("Not validated by Visa");
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
    public int getCardNumber() {
        return cardNumber;
    }
}

class MasterCard implements CreditCard {
    int cardNumber;
    private CreditCard nextHandler;

    public MasterCard(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public CreditCard handleValidate() {
        if (cardNumber == 5678) {
            System.out.println("Validated by Master");
            return this;
        } else if (nextHandler != null) {
            System.out.println("Not validated by Master");
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
    public int getCardNumber() {
        return cardNumber;
    }
}