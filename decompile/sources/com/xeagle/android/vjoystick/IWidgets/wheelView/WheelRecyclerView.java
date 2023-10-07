package com.xeagle.android.vjoystick.IWidgets.wheelView;

import android.content.Context;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.cfly.uav_pro.R;

public class WheelRecyclerView extends RecyclerView {
    int N;
    int O;
    float P;
    float Q;
    Camera R;
    Matrix S;
    Rect T;

    public WheelRecyclerView(Context context) {
        super(context);
        a(context);
    }

    public WheelRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public WheelRecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    private void a(Context context) {
        this.R = new Camera();
        this.S = new Matrix();
        this.T = new Rect();
        this.N = 6;
        int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.dp_60);
        this.O = dimensionPixelOffset;
        float f2 = 180.0f / ((float) ((this.N * 2) + 1));
        this.P = f2;
        this.Q = (float) d.a(dimensionPixelOffset, f2);
        this.R.setLocation(0.0f, 0.0f, -32.0f);
    }

    public boolean drawChild(Canvas canvas, View view, long j2) {
        float exactCenterX = this.T.exactCenterX();
        float exactCenterY = this.T.exactCenterY();
        float exactCenterX2 = new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()).exactCenterX();
        float f2 = exactCenterX2 - exactCenterX;
        float f3 = (this.P * f2) / ((float) this.O);
        if (Math.abs(f3) >= 90.0f) {
            f3 = 90.0f;
        }
        double d2 = (double) f3;
        float f4 = this.Q;
        canvas.save();
        canvas.translate(-(f2 - (f4 * ((float) Math.sin(Math.toRadians(d2))))), 0.0f);
        this.R.save();
        double d3 = (double) this.Q;
        Double.isNaN(d3);
        this.R.translate(0.0f, 0.0f, (float) (d3 * (1.0d - Math.abs(Math.cos(Math.toRadians(d2))))));
        this.R.rotateY(f3);
        this.R.getMatrix(this.S);
        this.R.restore();
        this.S.preTranslate(-exactCenterX2, -exactCenterY);
        this.S.postTranslate(exactCenterX2, exactCenterY);
        canvas.concat(this.S);
        boolean drawChild = super.drawChild(canvas, view, j2);
        canvas.restore();
        return drawChild;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        this.T.set(i2, i3, i4, i5);
    }
}
