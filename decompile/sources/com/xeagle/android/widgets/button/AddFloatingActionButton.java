package com.xeagle.android.widgets.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.xeagle.R;

public class AddFloatingActionButton extends FloatingActionButton {

    /* renamed from: a  reason: collision with root package name */
    int f25727a;

    public AddFloatingActionButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public AddFloatingActionButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AddFloatingActionButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    /* access modifiers changed from: package-private */
    public void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AddFloatingActionButton, 0, 0);
        this.f25727a = obtainStyledAttributes.getColor(0, a(17170443));
        obtainStyledAttributes.recycle();
        super.a(context, attributeSet);
    }

    /* access modifiers changed from: package-private */
    public Drawable getIconDrawable() {
        return getResources().getDrawable(com.cfly.uav_pro.R.drawable.compass_pre);
    }

    public int getPlusColor() {
        return this.f25727a;
    }

    public void setIcon(int i2) {
        throw new UnsupportedOperationException("Use FloatingActionButton if you want to use custom icon");
    }

    public void setPlusColor(int i2) {
        if (this.f25727a != i2) {
            this.f25727a = i2;
            a();
        }
    }

    public void setPlusColorResId(int i2) {
        setPlusColor(a(i2));
    }
}
