package enums;

import java.util.EnumSet;
import java.util.Set;

public enum VehicleType {
    CAR("Car", EnumSet.of(SpotType.STANDARD, SpotType.LARGE)),
    MOTORCYCLE("Motorcycle", EnumSet.of(SpotType.COMPACT)),
    TRUCK("Truck", EnumSet.of(SpotType.LARGE)),
    BUS("Bus", EnumSet.of(SpotType.LARGE));

    private final String typeName;
    private final Set<SpotType> allowedSpotTypes;

    VehicleType(String typeName, Set<SpotType> allowedSpotTypes) {
        this.typeName = typeName;
        this.allowedSpotTypes = allowedSpotTypes;
    }
    public String getTypeName() {
        return typeName;
    }
    public Set<SpotType> getAllowedSpotTypes() {
        return allowedSpotTypes;
    }
    public static VehicleType fromString(String typeName) {
        for (VehicleType type : VehicleType.values()) {
            if (type.typeName.equalsIgnoreCase(typeName)) {
                return type;
            }
        }
        throw new IllegalArgumentException("No enum constant " + VehicleType.class.getCanonicalName() + "." + typeName);
    }

    public boolean canParkIn(SpotType spotType) {
        return allowedSpotTypes.contains(spotType);
    }
}
