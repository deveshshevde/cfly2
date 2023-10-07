package com.huawei.android.multiscreen.mirror.sdk.structs;

import android.view.Surface;

public class SSinkProperty {

    /* renamed from: a  reason: collision with root package name */
    private boolean f20964a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f20965b;

    /* renamed from: c  reason: collision with root package name */
    private int f20966c;

    /* renamed from: d  reason: collision with root package name */
    private int f20967d;

    /* renamed from: e  reason: collision with root package name */
    private String f20968e;

    /* renamed from: f  reason: collision with root package name */
    private String f20969f;

    /* renamed from: g  reason: collision with root package name */
    private String f20970g;

    /* renamed from: h  reason: collision with root package name */
    private Surface f20971h;

    public SSinkProperty(boolean z2, boolean z3, int i2, int i3, String str, String str2, String str3) {
        this(z2, z3, i2, i3, str, str2, str3, (Surface) null);
    }

    public SSinkProperty(boolean z2, boolean z3, int i2, int i3, String str, String str2, String str3, Surface surface) {
        this.f20964a = z2;
        this.f20965b = z3;
        this.f20966c = i2;
        this.f20967d = i3;
        this.f20968e = str;
        this.f20969f = str2;
        this.f20970g = str3;
        this.f20971h = surface;
    }

    public void a(Surface surface) {
        this.f20971h = surface;
    }
}
