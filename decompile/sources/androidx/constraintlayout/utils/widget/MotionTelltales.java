package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.R;

public class MotionTelltales extends MockView {

    /* renamed from: b  reason: collision with root package name */
    MotionLayout f2495b;

    /* renamed from: c  reason: collision with root package name */
    float[] f2496c = new float[2];

    /* renamed from: d  reason: collision with root package name */
    Matrix f2497d = new Matrix();

    /* renamed from: e  reason: collision with root package name */
    int f2498e = 0;

    /* renamed from: f  reason: collision with root package name */
    int f2499f = -65281;

    /* renamed from: g  reason: collision with root package name */
    float f2500g = 0.25f;

    /* renamed from: h  reason: collision with root package name */
    private Paint f2501h = new Paint();

    public MotionTelltales(Context context) {
        super(context);
        a(context, (AttributeSet) null);
    }

    public MotionTelltales(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public MotionTelltales(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MotionTelltales);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.MotionTelltales_telltales_tailColor) {
                    this.f2499f = obtainStyledAttributes.getColor(index, this.f2499f);
                } else if (index == R.styleable.MotionTelltales_telltales_velocityMode) {
                    this.f2498e = obtainStyledAttributes.getInt(index, this.f2498e);
                } else if (index == R.styleable.MotionTelltales_telltales_tailScale) {
                    this.f2500g = obtainStyledAttributes.getFloat(index, this.f2500g);
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.f2501h.setColor(this.f2499f);
        this.f2501h.setStrokeWidth(5.0f);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        getMatrix().invert(this.f2497d);
        if (this.f2495b == null) {
            ViewParent parent = getParent();
            if (parent instanceof MotionLayout) {
                this.f2495b = (MotionLayout) parent;
                return;
            }
            return;
        }
        int width = getWidth();
        int height = getHeight();
        float[] fArr = {0.1f, 0.25f, 0.5f, 0.75f, 0.9f};
        for (int i2 = 0; i2 < 5; i2++) {
            float f2 = fArr[i2];
            for (int i3 = 0; i3 < 5; i3++) {
                float f3 = fArr[i3];
                this.f2495b.a((View) this, f3, f2, this.f2496c, this.f2498e);
                this.f2497d.mapVectors(this.f2496c);
                float f4 = ((float) width) * f3;
                float f5 = ((float) height) * f2;
                float[] fArr2 = this.f2496c;
                float f6 = fArr2[0];
                float f7 = this.f2500g;
                float f8 = f5 - (fArr2[1] * f7);
                this.f2497d.mapVectors(fArr2);
                canvas.drawLine(f4, f5, f4 - (f6 * f7), f8, this.f2501h);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        postInvalidate();
    }

    public void setText(CharSequence charSequence) {
        this.f2484a = charSequence.toString();
        requestLayout();
    }
}
