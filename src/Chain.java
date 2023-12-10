public class Chain {
    public CreditCard chainOfResonsibility(String cardNumber) {
        CreditCard invalid = new inValidCard(cardNumber);
        CreditCard visa = new VisaCC(cardNumber);
        CreditCard master = new MasterCard(cardNumber);
        CreditCard amex = new AmericanExpress(cardNumber);
        CreditCard discover = new Discover(cardNumber);
        CreditCard inValidEndChain = new inValidCard(cardNumber);

        invalid.setNextHandler(visa);
        visa.setNextHandler(master);
        master.setNextHandler(amex);
        amex.setNextHandler(discover);
        discover.setNextHandler(inValidEndChain);

        return invalid.handleValidate();
    }
}
