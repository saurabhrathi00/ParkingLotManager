package models;

import enums.TicketStatus;
import managers.PaymentProcessor;
import strategy.FeeCalculationStrategy;
import strategy.PaymentStrategy;
import strategy.SimpleFeeCalculationStrategy;

public class Exit {
    private String id;
    private PaymentProcessor paymentProcessor;

    public Exit(String id, PaymentProcessor paymentProcessor) {
        this.id = id;
        this.paymentProcessor = paymentProcessor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PaymentProcessor getPaymentProcessor() {
        return paymentProcessor;
    }

    public void setPaymentProcessor(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public double calculateFee(Ticket ticket) {
        return paymentProcessor.calculateFee(ticket);
    }

    public void processPayment(Ticket ticket, double amount) {
        paymentProcessor.processPayment(amount);
        ticket.setTicketStatus(TicketStatus.PAID); // Update ticket status to PAID after payment
        ParkingSpot parkingSpot = ticket.getParkingSpot();
        parkingSpot.setOccupied(false);
        parkingSpot.setParkedVehicle(null);
    }
}
