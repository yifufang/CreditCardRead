public interface CardFactory {
    CreditCard createCard(String cardNumber);
}

class ConcreateCardFactory implements CardFactory {
    @Override
    public CreditCard createCard(String cardNumber) {
        Chain chain = new Chain();
        CreditCard card = chain.chainOfResonsibility(cardNumber);
        return card;
    }
}
