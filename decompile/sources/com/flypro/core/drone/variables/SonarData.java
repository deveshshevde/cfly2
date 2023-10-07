package com.flypro.core.drone.variables;

import java.io.Serializable;

public class SonarData implements Serializable {
    private static final long serialVersionUID = -6528574664112064945L;

    /* renamed from: a  reason: collision with root package name */
    private float f14262a;

    /* renamed from: b  reason: collision with root package name */
    private float f14263b;

    /* renamed from: c  reason: collision with root package name */
    private float f14264c;

    /* renamed from: d  reason: collision with root package name */
    private float f14265d;

    /* renamed from: e  reason: collision with root package name */
    private float f14266e;

    /* renamed from: f  reason: collision with root package name */
    private float f14267f;

    public SonarData(float f2, float f3, float f4, float f5, float f6, float f7) {
        this.f14262a = f2;
        this.f14263b = f3;
        this.f14264c = f4;
        this.f14265d = f5;
        this.f14266e = f6;
        this.f14267f = f7;
    }

    public float a() {
        return this.f14262a;
    }

    public float b() {
        return this.f14263b;
    }

    public float c() {
        return this.f14264c;
    }

    public float d() {
        return this.f14265d;
    }

    public float e() {
        return this.f14266e;
    }

    public float f() {
        return this.f14267f;
    }
}
