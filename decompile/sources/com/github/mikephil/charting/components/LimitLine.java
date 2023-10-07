package com.github.mikephil.charting.components;

import android.graphics.DashPathEffect;
import android.graphics.Paint;

public class LimitLine extends b {

    /* renamed from: a  reason: collision with root package name */
    private float f14896a;

    /* renamed from: b  reason: collision with root package name */
    private float f14897b;

    /* renamed from: c  reason: collision with root package name */
    private int f14898c;

    /* renamed from: d  reason: collision with root package name */
    private Paint.Style f14899d;

    /* renamed from: e  reason: collision with root package name */
    private String f14900e;

    /* renamed from: f  reason: collision with root package name */
    private DashPathEffect f14901f;

    /* renamed from: g  reason: collision with root package name */
    private LimitLabelPosition f14902g;

    public enum LimitLabelPosition {
        LEFT_TOP,
        LEFT_BOTTOM,
        RIGHT_TOP,
        RIGHT_BOTTOM
    }

    public float a() {
        return this.f14896a;
    }

    public float b() {
        return this.f14897b;
    }

    public int c() {
        return this.f14898c;
    }

    public DashPathEffect d() {
        return this.f14901f;
    }

    public Paint.Style e() {
        return this.f14899d;
    }

    public LimitLabelPosition f() {
        return this.f14902g;
    }

    public String g() {
        return this.f14900e;
    }
}
