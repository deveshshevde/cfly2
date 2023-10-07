package com.flypro.core.firmware;

public enum FirmwareType {
    ARDU_PLANE("ArduPlane"),
    ARDU_COPTER("ArduCopter"),
    ARDU_ROVER("ArduRover");
    

    /* renamed from: d  reason: collision with root package name */
    private final String f14409d;

    private FirmwareType(String str) {
        this.f14409d = str;
    }

    public static FirmwareType a(String str) {
        FirmwareType firmwareType = ARDU_PLANE;
        if (str.equalsIgnoreCase(firmwareType.f14409d)) {
            return firmwareType;
        }
        FirmwareType firmwareType2 = ARDU_ROVER;
        return str.equalsIgnoreCase(firmwareType2.f14409d) ? firmwareType2 : ARDU_COPTER;
    }

    public String toString() {
        return this.f14409d;
    }
}
