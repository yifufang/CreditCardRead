public class Chain {
    public void chainOfResonsibility() {
        int cardNumber = 1234;
        CreditCard visa = new VisaCC(cardNumber);
        CreditCard master = new MasterCard(cardNumber);

        visa.setNextHandler(master);
        CreditCard result = visa.handleValidate();

        if (result != null) {
            System.out.println("Validated by " + result.getCardNumber());
        } else {
            System.out.println("Not validated");
        }
    }
}
