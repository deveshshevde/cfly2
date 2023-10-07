package com.xeagle.android.widgets.CarouselView;

import android.content.Context;
import android.view.animation.AnimationUtils;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private int f25559a;

    /* renamed from: b  reason: collision with root package name */
    private float f25560b;

    /* renamed from: c  reason: collision with root package name */
    private float f25561c;

    /* renamed from: d  reason: collision with root package name */
    private long f25562d;

    /* renamed from: e  reason: collision with root package name */
    private long f25563e;

    /* renamed from: f  reason: collision with root package name */
    private float f25564f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f25565g = true;

    /* renamed from: h  reason: collision with root package name */
    private float f25566h = 0.05f;

    /* renamed from: i  reason: collision with root package name */
    private float f25567i;

    /* renamed from: j  reason: collision with root package name */
    private final float f25568j = 240.0f;

    public e(Context context) {
    }

    public void a(float f2) {
        this.f25559a = 1;
        this.f25565g = false;
        this.f25567i = f2;
        this.f25563e = (long) ((int) (Math.sqrt((double) (((this.f25566h * 2.0f) * Math.abs(f2)) / 240.0f)) * 1000.0d));
        this.f25562d = AnimationUtils.currentAnimationTimeMillis();
    }

    public void a(float f2, float f3, int i2) {
        this.f25559a = 0;
        this.f25565g = false;
        this.f25563e = (long) i2;
        this.f25562d = AnimationUtils.currentAnimationTimeMillis();
        this.f25560b = f2;
        this.f25564f = f3;
    }

    public final void a(boolean z2) {
        this.f25565g = z2;
    }

    public final boolean a() {
        return this.f25565g;
    }

    public final float b() {
        return this.f25561c;
    }

    public boolean c() {
        if (this.f25565g) {
            return false;
        }
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.f25562d;
        long j2 = this.f25563e;
        if (currentAnimationTimeMillis < j2) {
            int i2 = this.f25559a;
            if (i2 == 0) {
                this.f25561c = this.f25560b + ((float) Math.round(this.f25564f * (((float) currentAnimationTimeMillis) / ((float) j2))));
            } else if (i2 == 1) {
                float f2 = ((float) currentAnimationTimeMillis) / 1000.0f;
                float f3 = this.f25567i;
                this.f25561c = this.f25560b - (Math.signum(f3) * ((float) Math.round((((f3 < 0.0f ? this.f25566h : -this.f25566h) * f3) * f2) - (((240.0f * f2) * f2) / 2.0f))));
            }
            return true;
        }
        this.f25565g = true;
        return false;
    }
}
