package strategy;

public class CreditCardPaymentStrategy implements PaymentStrategy{
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of " + amount + ".");
    }
}
