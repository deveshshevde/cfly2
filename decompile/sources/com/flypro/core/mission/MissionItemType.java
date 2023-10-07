package com.flypro.core.mission;

import ek.b;
import ek.f;
import ek.h;
import em.a;
import em.e;
import em.g;

public enum MissionItemType {
    WAYPOINT("Waypoint"),
    SPLINE_WAYPOINT("Spline Waypoint"),
    TAKEOFF("Takeoff"),
    RTL("Return to Launch"),
    LAND("Land"),
    CIRCLE("Circle"),
    CHANGE_SPEED("Change Speed");
    

    /* renamed from: h  reason: collision with root package name */
    private final String f14433h;

    /* renamed from: com.flypro.core.mission.MissionItemType$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f14434a = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.flypro.core.mission.MissionItemType[] r0 = com.flypro.core.mission.MissionItemType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f14434a = r0
                com.flypro.core.mission.MissionItemType r1 = com.flypro.core.mission.MissionItemType.WAYPOINT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f14434a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.flypro.core.mission.MissionItemType r1 = com.flypro.core.mission.MissionItemType.SPLINE_WAYPOINT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f14434a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.flypro.core.mission.MissionItemType r1 = com.flypro.core.mission.MissionItemType.TAKEOFF     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f14434a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.flypro.core.mission.MissionItemType r1 = com.flypro.core.mission.MissionItemType.CHANGE_SPEED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f14434a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.flypro.core.mission.MissionItemType r1 = com.flypro.core.mission.MissionItemType.RTL     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f14434a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.flypro.core.mission.MissionItemType r1 = com.flypro.core.mission.MissionItemType.LAND     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f14434a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.flypro.core.mission.MissionItemType r1 = com.flypro.core.mission.MissionItemType.CIRCLE     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.flypro.core.mission.MissionItemType.AnonymousClass1.<clinit>():void");
        }
    }

    private MissionItemType(String str) {
        this.f14433h = str;
    }

    public b a(b bVar) throws IllegalArgumentException {
        switch (AnonymousClass1.f14434a[ordinal()]) {
            case 1:
                return new g(bVar);
            case 2:
                return new e(bVar);
            case 3:
                return new h(bVar);
            case 4:
                return new b(bVar);
            case 5:
                return new f(bVar);
            case 6:
                return new em.b(bVar);
            case 7:
                return new a(bVar);
            default:
                throw new IllegalArgumentException("Unrecognized mission item type (" + this.f14433h + ").");
        }
    }

    public String a() {
        return this.f14433h;
    }
}
