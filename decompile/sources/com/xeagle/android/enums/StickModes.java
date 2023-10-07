package com.xeagle.android.enums;

import java.util.ArrayList;
import java.util.List;

public enum StickModes {
    JAPAN_HANDLE_MODE(1, "Japan", 2),
    USA_HANDLE_MODE(2, "USA", 2),
    CHINA_HANDLE_MODE(3, "China", 2),
    EUROPE_HANDLE_MODE(4, "Europe", 2),
    UNKNOWN(-1, "Unknown", 0);
    

    /* renamed from: f  reason: collision with root package name */
    private final int f23168f;

    /* renamed from: g  reason: collision with root package name */
    private final String f23169g;

    /* renamed from: h  reason: collision with root package name */
    private final int f23170h;

    private StickModes(int i2, String str, int i3) {
        this.f23168f = i2;
        this.f23169g = str;
        this.f23170h = i3;
    }

    public static StickModes a(int i2) {
        for (StickModes stickModes : values()) {
            if (i2 == stickModes.a()) {
                return stickModes;
            }
        }
        return UNKNOWN;
    }

    public static List<StickModes> b(int i2) {
        if (c(i2)) {
            i2 = 2;
        }
        ArrayList arrayList = new ArrayList();
        for (StickModes stickModes : values()) {
            if (stickModes.c() == i2) {
                arrayList.add(stickModes);
            }
        }
        return arrayList;
    }

    public static boolean c(int i2) {
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

    public int a() {
        return this.f23168f;
    }

    public String b() {
        return this.f23169g;
    }

    public int c() {
        return this.f23170h;
    }
}
