package com.xeagle.android.widgets.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RadioButton;
import com.xeagle.R;

public class RadioButtonCenter extends RadioButton {

    /* renamed from: a  reason: collision with root package name */
    private Drawable f25798a;

    public RadioButtonCenter(Context context) {
        super(context);
    }

    public RadioButtonCenter(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: finally extract failed */
    public RadioButtonCenter(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RadioButtonCenter, i2, 0);
        try {
            this.f25798a = obtainStyledAttributes.getDrawable(0);
            obtainStyledAttributes.recycle();
            setButtonDrawable(17170445);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Drawable drawable = this.f25798a;
        if (drawable != null) {
            drawable.setState(getDrawableState());
            int gravity = getGravity() & 112;
            int intrinsicHeight = this.f25798a.getIntrinsicHeight();
            int i2 = 0;
            if (gravity == 16) {
                i2 = (getHeight() - intrinsicHeight) / 2;
            } else if (gravity == 80) {
                i2 = getHeight() - intrinsicHeight;
            }
            int intrinsicWidth = this.f25798a.getIntrinsicWidth();
            int width = (getWidth() - intrinsicWidth) / 2;
            this.f25798a.setBounds(width, i2, intrinsicWidth + width, intrinsicHeight + i2);
            this.f25798a.draw(canvas);
        }
    }
}
