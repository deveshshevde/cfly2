package com.xeagle.android.login.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import com.xeagle.R;
import com.xeagle.android.login.pickImage.CaptureActivity;

public class CircleProgressView extends View {
    private Paint backgroundPaint;
    private float currentAngle;
    private float eachProgressAngle;
    private long initTime;
    private boolean isStart;
    private Context mContext;
    private WindowManager mWindowManager;
    private float maxProgressSize;
    private int millisecond;
    private float radius;
    private int ringColor;
    private Paint ringPaint;
    private float strokeWidth;

    public CircleProgressView(Context context) {
        this(context, (AttributeSet) null);
    }

    public CircleProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleProgressView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.millisecond = 1000;
        this.maxProgressSize = (float) (CaptureActivity.RECORD_MAX_TIME * this.millisecond);
        this.eachProgressAngle = 0.0f;
        this.currentAngle = 0.0f;
        this.initTime = -1;
        this.isStart = false;
        this.mContext = context;
        init(context, attributeSet);
        initVariable();
    }

    private void drawCirecle(Canvas canvas, float f2) {
        if (f2 > 0.0f && f2 <= 360.0f) {
            Canvas canvas2 = canvas;
            RectF rectF = new RectF(((float) (getWidth() / 2)) - this.radius, ((float) (getHeight() / 2)) - this.radius, ((float) (getWidth() / 2)) + this.radius, ((float) (getHeight() / 2)) + this.radius);
            canvas2.drawArc(rectF, f2 - 0.049804688f, 360.0f - f2, false, this.backgroundPaint);
            canvas2.drawArc(rectF, -90.0f, f2, false, this.ringPaint);
        }
    }

    private void init(Context context, AttributeSet attributeSet) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
        this.mWindowManager = windowManager;
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.CircleProgressbar, 0, 0);
        this.radius = obtainStyledAttributes.getDimension(0, 80.0f);
        this.strokeWidth = obtainStyledAttributes.getDimension(2, 10.0f);
        this.ringColor = obtainStyledAttributes.getColor(1, 16711680);
        this.eachProgressAngle = 360.0f / (this.maxProgressSize * 1.0f);
    }

    private void initVariable() {
        Paint paint = new Paint();
        this.ringPaint = paint;
        paint.setAntiAlias(true);
        this.ringPaint.setDither(true);
        this.ringPaint.setColor(this.ringColor);
        this.ringPaint.setStyle(Paint.Style.STROKE);
        this.ringPaint.setStrokeCap(Paint.Cap.ROUND);
        this.ringPaint.setStrokeWidth(this.strokeWidth);
        Paint paint2 = new Paint();
        this.backgroundPaint = paint2;
        paint2.setAntiAlias(true);
        this.backgroundPaint.setDither(true);
        this.backgroundPaint.setColor(getResources().getColor(com.cfly.uav_pro.R.color.whitetransparent));
        this.backgroundPaint.setStyle(Paint.Style.STROKE);
        this.backgroundPaint.setStrokeCap(Paint.Cap.ROUND);
        this.backgroundPaint.setStrokeWidth(this.strokeWidth);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.isStart) {
            drawCirecle(canvas, this.currentAngle);
            return;
        }
        int i2 = (this.initTime > -1 ? 1 : (this.initTime == -1 ? 0 : -1));
        long currentTimeMillis = System.currentTimeMillis();
        if (i2 == 0) {
            this.initTime = currentTimeMillis;
            drawCirecle(canvas, this.currentAngle);
            invalidate();
            return;
        }
        float f2 = this.currentAngle + (this.eachProgressAngle * ((float) (currentTimeMillis - this.initTime)) * 1.0f);
        this.currentAngle = f2;
        if (f2 > 360.0f) {
            this.currentAngle = 360.0f;
        }
        drawCirecle(canvas, this.currentAngle);
        if (this.currentAngle >= 360.0f || !this.isStart) {
            this.currentAngle = 0.0f;
            this.initTime = -1;
            this.isStart = false;
            return;
        }
        this.initTime = System.currentTimeMillis();
        invalidate();
    }

    public void reset() {
        this.currentAngle = 0.0f;
        this.initTime = -1;
        this.isStart = false;
        invalidate();
    }

    public void setIsStart(boolean z2) {
        if (z2 != this.isStart) {
            this.isStart = z2;
            if (z2) {
                this.initTime = -1;
                invalidate();
            }
        }
    }
}
