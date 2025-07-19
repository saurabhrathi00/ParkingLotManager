package strategy;

import models.Ticket;

public interface FeeCalculationStrategy {
    /**
     * Calculates the parking fee for a given ticket.
     *
     * @param ticket the ticket for which to calculate the fee
     * @return the calculated fee
     */
    double calculateFee(Ticket ticket);
}
