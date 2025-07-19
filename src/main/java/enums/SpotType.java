package enums;

public enum SpotType {
    COMPACT("Compact"),
    STANDARD("Standard"),
    LARGE("Large"),
    HANDICAPPED("Handicapped");

    private final String typeName;

    SpotType(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }

    public static SpotType fromString(String typeName) {
        for (SpotType type : SpotType.values()) {
            if (type.typeName.equalsIgnoreCase(typeName)) {
                return type;
            }
        }
        throw new IllegalArgumentException("No enum constant " + SpotType.class.getCanonicalName() + "." + typeName);
    }
}
