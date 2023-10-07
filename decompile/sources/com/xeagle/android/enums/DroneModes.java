package com.xeagle.android.enums;

import android.content.Context;
import com.cfly.uav_pro.R;
import java.util.ArrayList;
import java.util.List;

public enum DroneModes {
    ROTOR_ALT_HOLD(1, "Alt Hold", 2),
    ROTOR_LOITER(2, "Loiter", 2),
    ROTOR_GUIDED(3, "Guided", 2),
    ROTOR_CIRCLE(4, "Circle", 2),
    ROTOR_SHOT(5, "Shot", 2),
    UNKNOWN(0, "N/A", 0);
    

    /* renamed from: g  reason: collision with root package name */
    private final int f23159g;

    /* renamed from: h  reason: collision with root package name */
    private final String f23160h;

    /* renamed from: i  reason: collision with root package name */
    private final int f23161i;

    private DroneModes(int i2, String str, int i3) {
        this.f23159g = i2;
        this.f23160h = str;
        this.f23161i = i3;
    }

    public static List<String> a(Context context, int i2) {
        ArrayList arrayList = new ArrayList();
        if (a(i2)) {
            i2 = 2;
        }
        for (DroneModes droneModes : values()) {
            if (droneModes.a() == i2) {
                arrayList.add(droneModes.a(context));
            }
        }
        return arrayList;
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

    public int a() {
        return this.f23161i;
    }

    public String a(Context context) {
        int i2;
        String str = this.f23160h;
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -2013398213:
                if (str.equals("Loiter")) {
                    c2 = 0;
                    break;
                }
                break;
            case 76480:
                if (str.equals("N/A")) {
                    c2 = 1;
                    break;
                }
                break;
            case 2576154:
                if (str.equals("Shot")) {
                    c2 = 2;
                    break;
                }
                break;
            case 2018617584:
                if (str.equals("Circle")) {
                    c2 = 3;
                    break;
                }
                break;
            case 2032461078:
                if (str.equals("Alt Hold")) {
                    c2 = 4;
                    break;
                }
                break;
            case 2143949064:
                if (str.equals("Guided")) {
                    c2 = 5;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                i2 = R.string.spinner_mode_loiter;
                break;
            case 2:
                i2 = R.string.spinner_mode_shot;
                break;
            case 3:
                i2 = R.string.spinner_mode_circle;
                break;
            case 4:
                i2 = R.string.spinner_mode_althold;
                break;
            case 5:
                i2 = R.string.spinner_mode_follow;
                break;
            default:
                return "N/A";
        }
        return context.getString(i2);
    }
}
