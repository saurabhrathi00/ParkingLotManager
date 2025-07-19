package managers;

import models.Ticket;
import strategy.FeeCalculationStrategy;
import strategy.PaymentStrategy;

public class PaymentProcessor {
    private PaymentStrategy paymentStrategy;
    private FeeCalculationStrategy feeCalculationStrategy;


    public PaymentProcessor(PaymentStrategy paymentStrategy, FeeCalculationStrategy feeCalculationStrategy) {
        this.paymentStrategy = paymentStrategy;
        this.feeCalculationStrategy = feeCalculationStrategy;
    }

    public FeeCalculationStrategy getFeeCalculationStrategy() {
        return feeCalculationStrategy;
    }

    public PaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }
    public void setFeeCalculationStrategy(FeeCalculationStrategy feeCalculationStrategy) {
        this.feeCalculationStrategy = feeCalculationStrategy;
    }
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }


    public void processPayment(double amount) {
        this.paymentStrategy.processPayment(amount);
    }

    public double calculateFee(Ticket ticket) {
        return feeCalculationStrategy.calculateFee(ticket);
    }


}
