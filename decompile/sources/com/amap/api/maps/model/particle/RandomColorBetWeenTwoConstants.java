package com.amap.api.maps.model.particle;

import java.util.Random;

public class RandomColorBetWeenTwoConstants extends ColorGenerate {

    /* renamed from: a  reason: collision with root package name */
    private float f9774a;
    private float a1;

    /* renamed from: b  reason: collision with root package name */
    private float f9775b;
    private float b1;
    private float[] color = {1.0f, 1.0f, 1.0f, 1.0f};

    /* renamed from: g  reason: collision with root package name */
    private float f9776g;
    private float g1;

    /* renamed from: r  reason: collision with root package name */
    private float f9777r;
    private float r1;
    private Random random = new Random();

    public RandomColorBetWeenTwoConstants(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        this.f9777r = f2 / 255.0f;
        this.f9776g = f3 / 255.0f;
        this.f9775b = f4 / 255.0f;
        this.f9774a = f5 / 255.0f;
        this.r1 = f6 / 255.0f;
        this.g1 = f7 / 255.0f;
        this.b1 = f8 / 255.0f;
        this.a1 = f9 / 255.0f;
        this.type = 0;
    }

    public float[] getColor() {
        float[] fArr = this.color;
        float nextFloat = this.random.nextFloat();
        float f2 = this.r1;
        float f3 = this.f9777r;
        fArr[0] = (nextFloat * (f2 - f3)) + f3;
        float[] fArr2 = this.color;
        float nextFloat2 = this.random.nextFloat();
        float f4 = this.g1;
        float f5 = this.f9776g;
        fArr2[1] = (nextFloat2 * (f4 - f5)) + f5;
        float[] fArr3 = this.color;
        float nextFloat3 = this.random.nextFloat();
        float f6 = this.b1;
        float f7 = this.f9775b;
        fArr3[2] = (nextFloat3 * (f6 - f7)) + f7;
        float[] fArr4 = this.color;
        float nextFloat4 = this.random.nextFloat();
        float f8 = this.a1;
        float f9 = this.f9774a;
        fArr4[3] = (nextFloat4 * (f8 - f9)) + f9;
        return this.color;
    }
}
