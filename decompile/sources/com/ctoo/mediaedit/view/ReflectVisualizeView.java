package com.ctoo.mediaedit.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;

public class ReflectVisualizeView extends AudioVisualizeView {
    public ReflectVisualizeView(Context context) {
        super(context);
    }

    public ReflectVisualizeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ReflectVisualizeView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    /* access modifiers changed from: protected */
    public void a(TypedArray typedArray) {
    }

    /* access modifiers changed from: protected */
    public void a(Canvas canvas) {
        this.f10967d = ((this.f10971h.width() - (((float) (this.f10964a - 1)) * this.f10965b)) / ((float) this.f10964a)) * 1.0f;
        this.f10972i.setStrokeWidth(this.f10967d);
        this.f10972i.setStyle(Paint.Style.FILL);
        for (int i2 = 0; i2 < this.f10964a; i2++) {
            if (this.f10970g[i2] < 0) {
                this.f10970g[i2] = Byte.MAX_VALUE;
            }
            float f2 = (float) i2;
            canvas.drawLine((this.f10971h.width() * f2) / ((float) this.f10964a), this.f10971h.height() / 2.0f, (this.f10971h.width() * f2) / ((float) this.f10964a), ((this.f10971h.height() / 2.0f) + 2.0f) - (this.f10966c * ((float) this.f10970g[i2])), this.f10972i);
            canvas.drawLine((this.f10971h.width() * f2) / ((float) this.f10964a), this.f10971h.height() / 2.0f, (this.f10971h.width() * f2) / ((float) this.f10964a), (this.f10971h.height() / 2.0f) + 2.0f + (this.f10966c * ((float) this.f10970g[i2])), this.f10972i);
        }
    }
}
