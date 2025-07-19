package enums;

public enum TicketStatus
{
    ACTIVE,
    EXPIRED,
    CANCELLED,
    PAID;

    public static TicketStatus fromString(String status) {
        for (TicketStatus ts : TicketStatus.values()) {
            if (ts.name().equalsIgnoreCase(status)) {
                return ts;
            }
        }
        throw new IllegalArgumentException("Unknown ticket status: " + status);
    }
}
