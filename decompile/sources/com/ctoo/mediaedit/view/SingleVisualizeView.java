package com.ctoo.mediaedit.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import com.ctoo.mediaedit.R;

public class SingleVisualizeView extends AudioVisualizeView {

    /* renamed from: n  reason: collision with root package name */
    private int f11023n;

    public SingleVisualizeView(Context context) {
        super(context);
    }

    public SingleVisualizeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SingleVisualizeView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    /* access modifiers changed from: protected */
    public void a(TypedArray typedArray) {
        this.f11023n = typedArray.getInteger(R.styleable.AudioVisualizeView_visualize_orientation, 1);
    }

    /* access modifiers changed from: protected */
    public void a(Canvas canvas) {
        float f2;
        float f3;
        float f4;
        float f5;
        this.f10967d = ((this.f10971h.width() - (((float) (this.f10964a - 1)) * this.f10965b)) / ((float) this.f10964a)) * 1.0f;
        this.f10972i.setStrokeWidth(this.f10967d);
        this.f10972i.setStyle(Paint.Style.FILL);
        for (int i2 = 0; i2 < this.f10964a; i2++) {
            if (this.f10970g[i2] < 0) {
                this.f10970g[i2] = Byte.MAX_VALUE;
            }
            int i3 = this.f11023n;
            if (i3 == 1) {
                float f6 = (float) i2;
                f5 = (this.f10971h.width() * f6) / ((float) this.f10964a);
                f4 = this.f10971h.height() / 2.0f;
                f3 = (this.f10971h.width() * f6) / ((float) this.f10964a);
                f2 = ((this.f10971h.height() / 2.0f) + 2.0f) - ((float) this.f10970g[i2]);
            } else if (i3 != 2) {
            } else {
                float f7 = (float) i2;
                f5 = (this.f10971h.width() * f7) / ((float) this.f10964a);
                f4 = this.f10971h.height() / 2.0f;
                f3 = (this.f10971h.width() * f7) / ((float) this.f10964a);
                f2 = (this.f10971h.height() / 2.0f) + 2.0f + ((float) this.f10970g[i2]);
            }
            canvas.drawLine(f5, f4, f3, f2, this.f10972i);
        }
    }
}
