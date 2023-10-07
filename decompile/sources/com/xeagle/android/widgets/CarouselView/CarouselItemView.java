package com.xeagle.android.widgets.CarouselView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CarouselItemView extends LinearLayout implements Comparable<CarouselItemView> {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f25514a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f25515b;

    /* renamed from: c  reason: collision with root package name */
    private int f25516c;

    /* renamed from: d  reason: collision with root package name */
    private float f25517d;

    /* renamed from: e  reason: collision with root package name */
    private float f25518e;

    /* renamed from: f  reason: collision with root package name */
    private float f25519f;

    /* renamed from: g  reason: collision with root package name */
    private float f25520g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f25521h;

    /* renamed from: i  reason: collision with root package name */
    private Matrix f25522i;

    public CarouselItemView(Context context) {
        super(context);
    }

    /* renamed from: a */
    public int compareTo(CarouselItemView carouselItemView) {
        return (int) (carouselItemView.f25520g - this.f25520g);
    }

    /* access modifiers changed from: package-private */
    public Matrix getCIMatrix() {
        return this.f25522i;
    }

    public float getCurrentAngle() {
        return this.f25517d;
    }

    public int getIndex() {
        return this.f25516c;
    }

    public float getItemX() {
        return this.f25518e;
    }

    public float getItemY() {
        return this.f25519f;
    }

    public float getItemZ() {
        return this.f25520g;
    }

    public String getName() {
        return this.f25515b.getText().toString();
    }

    /* access modifiers changed from: package-private */
    public void setCIMatrix(Matrix matrix) {
        this.f25522i = matrix;
    }

    public void setCurrentAngle(float f2) {
        if (this.f25516c == 0 && f2 > 5.0f) {
            Log.d("", "");
        }
        this.f25517d = f2;
    }

    public void setDrawn(boolean z2) {
        this.f25521h = z2;
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.f25514a.setImageBitmap(bitmap);
    }

    public void setIndex(int i2) {
        this.f25516c = i2;
    }

    public void setItemX(float f2) {
        this.f25518e = f2;
    }

    public void setItemY(float f2) {
        this.f25519f = f2;
    }

    public void setItemZ(float f2) {
        this.f25520g = f2;
    }

    public void setText(String str) {
        this.f25515b.setText(str);
    }
}
