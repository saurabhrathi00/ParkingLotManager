package strategy;

import models.Ticket;

public class SimpleFeeCalculationStrategy implements FeeCalculationStrategy{
    @Override
    public double calculateFee(Ticket ticket) {
        return 0;
    }
}
