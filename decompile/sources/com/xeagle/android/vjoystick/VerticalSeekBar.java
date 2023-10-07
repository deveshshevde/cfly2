package com.xeagle.android.vjoystick;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.SeekBar;

public class VerticalSeekBar extends SeekBar {

    /* renamed from: a  reason: collision with root package name */
    float f24939a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f24940b;

    /* renamed from: c  reason: collision with root package name */
    private float f24941c;

    /* renamed from: d  reason: collision with root package name */
    private int f24942d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f24943e = false;

    public VerticalSeekBar(Context context) {
        super(context);
    }

    public VerticalSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VerticalSeekBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f24942d = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    private void a(MotionEvent motionEvent) {
        float f2;
        int height = getHeight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i2 = (height - paddingTop) - paddingBottom;
        int y2 = (int) motionEvent.getY();
        int i3 = height - paddingBottom;
        float f3 = 0.0f;
        if (y2 > i3) {
            f2 = 0.0f;
        } else if (y2 < paddingTop) {
            f2 = 1.0f;
        } else {
            float f4 = ((float) ((i2 - y2) + paddingTop)) / ((float) i2);
            f3 = this.f24939a;
            f2 = f4;
        }
        setProgress((int) (f3 + (f2 * ((float) getMax()))));
    }

    private void d() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    public boolean a() {
        return this.f24943e;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.f24940b = true;
    }

    /* access modifiers changed from: package-private */
    public void c() {
        this.f24940b = false;
    }

    /* access modifiers changed from: protected */
    public synchronized void onDraw(Canvas canvas) {
        canvas.rotate(-90.0f);
        canvas.translate((float) (-getHeight()), 0.0f);
        super.onDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public synchronized void onMeasure(int i2, int i3) {
        super.onMeasure(i3, i2);
        setMeasuredDimension(getMeasuredHeight(), getMeasuredWidth());
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i3, i2, i5, i4);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002d, code lost:
        if (java.lang.Math.abs(r5.getY() - r4.f24941c) > ((float) r4.f24942d)) goto L_0x0063;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            boolean r0 = r4.isEnabled()
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            int r0 = r5.getAction()
            r2 = 1
            if (r0 == 0) goto L_0x0056
            if (r0 == r2) goto L_0x0030
            r3 = 2
            if (r0 == r3) goto L_0x0015
            goto L_0x007d
        L_0x0015:
            boolean r0 = r4.f24940b
            if (r0 == 0) goto L_0x001d
            r4.a(r5)
            goto L_0x0072
        L_0x001d:
            float r0 = r5.getY()
            float r3 = r4.f24941c
            float r0 = r0 - r3
            float r0 = java.lang.Math.abs(r0)
            int r3 = r4.f24942d
            float r3 = (float) r3
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 <= 0) goto L_0x0072
            goto L_0x0063
        L_0x0030:
            boolean r0 = r4.f24940b
            if (r0 == 0) goto L_0x003e
            r4.a(r5)
            r4.c()
            r4.setPressed(r1)
            goto L_0x0047
        L_0x003e:
            r4.b()
            r4.a(r5)
            r4.c()
        L_0x0047:
            int r5 = r4.getWidth()
            int r0 = r4.getHeight()
            r4.onSizeChanged(r5, r0, r1, r1)
            r4.invalidate()
            goto L_0x007d
        L_0x0056:
            boolean r0 = r4.a()
            if (r0 == 0) goto L_0x0063
            float r5 = r5.getY()
            r4.f24941c = r5
            goto L_0x007d
        L_0x0063:
            r4.setPressed(r2)
            r4.invalidate()
            r4.b()
            r4.a(r5)
            r4.d()
        L_0x0072:
            int r5 = r4.getWidth()
            int r0 = r4.getHeight()
            r4.onSizeChanged(r5, r0, r1, r1)
        L_0x007d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.vjoystick.VerticalSeekBar.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setInScrollingContainer(boolean z2) {
        this.f24943e = z2;
    }

    public synchronized void setProgress(int i2) {
        super.setProgress(i2);
        onSizeChanged(getWidth(), getHeight(), 0, 0);
    }
}
