package com.amap.api.mapcore.util;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

public abstract class ji {

    /* renamed from: a  reason: collision with root package name */
    public String f9452a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f9453b = "";

    /* renamed from: c  reason: collision with root package name */
    public int f9454c = 99;

    /* renamed from: d  reason: collision with root package name */
    public int f9455d = SubsamplingScaleImageView.TILE_SIZE_AUTO;

    /* renamed from: e  reason: collision with root package name */
    public long f9456e = 0;

    /* renamed from: f  reason: collision with root package name */
    public long f9457f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f9458g = 0;

    /* renamed from: h  reason: collision with root package name */
    public boolean f9459h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f9460i = true;

    public ji(boolean z2, boolean z3) {
        this.f9459h = z2;
        this.f9460i = z3;
    }

    /* renamed from: a */
    public abstract ji clone();

    public final void a(ji jiVar) {
        this.f9452a = jiVar.f9452a;
        this.f9453b = jiVar.f9453b;
        this.f9454c = jiVar.f9454c;
        this.f9455d = jiVar.f9455d;
        this.f9456e = jiVar.f9456e;
        this.f9457f = jiVar.f9457f;
        this.f9458g = jiVar.f9458g;
        this.f9459h = jiVar.f9459h;
        this.f9460i = jiVar.f9460i;
    }

    public String toString() {
        return "AmapCell{mcc=" + this.f9452a + ", mnc=" + this.f9453b + ", signalStrength=" + this.f9454c + ", asulevel=" + this.f9455d + ", lastUpdateSystemMills=" + this.f9456e + ", lastUpdateUtcMills=" + this.f9457f + ", age=" + this.f9458g + ", main=" + this.f9459h + ", newapi=" + this.f9460i + '}';
    }
}
