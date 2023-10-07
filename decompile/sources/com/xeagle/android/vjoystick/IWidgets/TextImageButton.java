package com.xeagle.android.vjoystick.IWidgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import com.xeagle.R;

public class TextImageButton extends IButton {

    /* renamed from: a  reason: collision with root package name */
    private Bitmap f24670a;

    /* renamed from: b  reason: collision with root package name */
    private int f24671b;

    public TextImageButton(Context context) {
        super(context);
    }

    /* JADX INFO: finally extract failed */
    public TextImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TextImageButton);
        try {
            this.f24671b = obtainStyledAttributes.getResourceId(0, com.cfly.uav_pro.R.drawable.placeholder);
            obtainStyledAttributes.recycle();
            this.f24670a = BitmapFactory.decodeResource(getResources(), this.f24671b);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public TextImageButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        canvas.drawBitmap(this.f24670a, (float) ((getMeasuredWidth() - this.f24670a.getWidth()) >> 1), (float) 0, (Paint) null);
        canvas.translate(0.0f, (float) ((getMeasuredHeight() >> 1) - ((int) getTextSize())));
        super.onDraw(canvas);
    }
}
