package com.xeagle.android.widgets.CarouselView;

import android.content.Context;
import android.graphics.Matrix;
import android.util.Log;
import android.widget.ImageView;

public class CarouselItemImage extends ImageView implements Comparable<CarouselItemImage> {

    /* renamed from: a  reason: collision with root package name */
    private int f25507a;

    /* renamed from: b  reason: collision with root package name */
    private float f25508b;

    /* renamed from: c  reason: collision with root package name */
    private float f25509c;

    /* renamed from: d  reason: collision with root package name */
    private float f25510d;

    /* renamed from: e  reason: collision with root package name */
    private float f25511e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f25512f;

    /* renamed from: g  reason: collision with root package name */
    private Matrix f25513g;

    public CarouselItemImage(Context context) {
        super(context);
    }

    /* renamed from: a */
    public int compareTo(CarouselItemImage carouselItemImage) {
        return (int) (carouselItemImage.f25511e - this.f25511e);
    }

    public boolean a() {
        return this.f25512f;
    }

    /* access modifiers changed from: package-private */
    public Matrix getCIMatrix() {
        return this.f25513g;
    }

    public float getCurrentAngle() {
        return this.f25508b;
    }

    public int getIndex() {
        return this.f25507a;
    }

    public float getItemX() {
        return this.f25509c;
    }

    public float getItemY() {
        return this.f25510d;
    }

    public float getItemZ() {
        return this.f25511e;
    }

    /* access modifiers changed from: package-private */
    public void setCIMatrix(Matrix matrix) {
        this.f25513g = matrix;
    }

    public void setCurrentAngle(float f2) {
        if (this.f25507a == 0 && f2 > 5.0f) {
            Log.d("", "");
        }
        this.f25508b = f2;
    }

    public void setDrawn(boolean z2) {
        this.f25512f = z2;
    }

    public void setIndex(int i2) {
        this.f25507a = i2;
    }

    public void setItemX(float f2) {
        this.f25509c = f2;
    }

    public void setItemY(float f2) {
        this.f25510d = f2;
    }

    public void setItemZ(float f2) {
        this.f25511e = f2;
    }
}
