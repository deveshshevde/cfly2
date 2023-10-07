package com.flypro.core.drone.variables;

import com.flypro.core.drone.DroneInterfaces;
import com.flypro.core.drone.d;
import en.a;

public class t extends d implements DroneInterfaces.c {

    /* renamed from: a  reason: collision with root package name */
    private double f14376a = 100.0d;

    /* renamed from: c  reason: collision with root package name */
    private boolean f14377c = false;

    /* renamed from: d  reason: collision with root package name */
    private int f14378d = -1;

    /* renamed from: e  reason: collision with root package name */
    private int f14379e = -1;

    /* renamed from: f  reason: collision with root package name */
    private int f14380f = -1;

    /* renamed from: g  reason: collision with root package name */
    private double f14381g = -1.0d;

    /* renamed from: h  reason: collision with root package name */
    private double f14382h = -1.0d;

    /* renamed from: i  reason: collision with root package name */
    private double f14383i = -1.0d;

    /* renamed from: j  reason: collision with root package name */
    private double f14384j = -1.0d;

    /* renamed from: com.flypro.core.drone.variables.t$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f14385a;

        static {
            int[] iArr = new int[DroneInterfaces.DroneEventsType.values().length];
            f14385a = iArr;
            try {
                iArr[DroneInterfaces.DroneEventsType.DISCONNECTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public t(a aVar) {
        super(aVar);
    }

    public double a() {
        return this.f14381g;
    }

    public double b() {
        return this.f14382h;
    }

    public double c() {
        return this.f14383i;
    }

    public double d() {
        return this.f14384j;
    }

    public double e() {
        return this.f14381g - this.f14383i;
    }

    public double f() {
        return this.f14382h - this.f14384j;
    }

    public int g() {
        return (int) (ei.a.a(Math.min(e(), f()), 3.0d, 40.0d) * 100.0d);
    }

    public boolean h() {
        return this.f14377c;
    }

    public void onDroneEvent(DroneInterfaces.DroneEventsType droneEventsType, a aVar) {
        if (AnonymousClass1.f14385a[droneEventsType.ordinal()] == 1) {
            this.f14377c = false;
        }
    }
}
