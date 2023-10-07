package com.MAVLink.Messages;

public enum ApmModes {
    FIXED_WING_MANUAL(0, "Manual", 1),
    FIXED_WING_CIRCLE(1, "Circle", 1),
    FIXED_WING_STABILIZE(2, "Stabilize", 1),
    FIXED_WING_TRAINING(3, "Training", 1),
    FIXED_WING_FLY_BY_WIRE_A(5, "FBW A", 1),
    FIXED_WING_FLY_BY_WIRE_B(6, "FBW B", 1),
    FIXED_WING_AUTO(10, "Auto", 1),
    FIXED_WING_RTL(11, "RTL", 1),
    FIXED_WING_LOITER(12, "Loiter", 1),
    FIXED_WING_GUIDED(15, "Guided", 1),
    ROTOR_STABILIZE(0, "Stabilize", 2),
    ROTOR_ALT_HOLD(2, "Alt Hold", 2),
    ROTOR_AUTO(3, "Auto", 2),
    ROTOR_GUIDED(4, "Guided", 2),
    ROTOR_LOITER(5, "Loiter", 2),
    ROTOR_RTL(6, "RTL", 2),
    ROTOR_CIRCLE(7, "Circle", 2),
    ROTOR_LAND(9, "Land", 2),
    ROTOR_TRACKER(11, "Tracker", 2),
    ROTOR_POSHOLD(16, "Shot", 2),
    ROVER_MANUAL(0, "MANUAL", 10),
    ROVER_LEARNING(2, "LEARNING", 10),
    ROVER_STEERING(3, "STEERING", 10),
    ROVER_HOLD(4, "HOLD", 10),
    ROVER_AUTO(10, "AUTO", 10),
    ROVER_RTL(11, "RTL", 10),
    ROVER_GUIDED(15, "GUIDED", 10),
    ROVER_INITIALIZING(16, "INITIALIZING", 10),
    UNKNOWN(-1, "Unknown", 0);
    
    private final int D;
    private final String E;
    private final int F;

    private ApmModes(int i2, String str, int i3) {
        this.D = i2;
        this.E = str;
        this.F = i3;
    }

    public static ApmModes a(int i2, int i3) {
        if (a(i3)) {
            i3 = 2;
        }
        for (ApmModes apmModes : values()) {
            if (i2 == apmModes.a() && i3 == apmModes.c()) {
                return apmModes;
            }
        }
        return UNKNOWN;
    }

    public static boolean a(int i2) {
        if (i2 == 2 || i2 == 4) {
            return true;
        }
        switch (i2) {
            case 13:
            case 14:
            case 15:
                return true;
            default:
                return false;
        }
    }

    public static boolean a(ApmModes apmModes) {
        return apmModes != UNKNOWN;
    }

    public int a() {
        return this.D;
    }

    public String b() {
        return this.E;
    }

    public int c() {
        return this.F;
    }
}
