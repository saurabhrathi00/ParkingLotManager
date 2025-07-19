package enums;

public enum ParkingSpotStatus {
    AVAILABLE("Available"),
    OCCUPIED("Occupied"),
    RESERVED("Reserved"),
    OUT_OF_SERVICE("Out of Service");

    private final String statusName;

    ParkingSpotStatus(String statusName) {
        this.statusName = statusName;
    }

    public String getStatusName() {
        return statusName;
    }

    public static ParkingSpotStatus fromString(String statusName) {
        for (ParkingSpotStatus status : ParkingSpotStatus.values()) {
            if (status.statusName.equalsIgnoreCase(statusName)) {
                return status;
            }
        }
        throw new IllegalArgumentException("No enum constant " + ParkingSpotStatus.class.getCanonicalName() + "." + statusName);
    }
}
