package com.github.barteksc.pdfviewer.scroll;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.b;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.R;
import com.github.barteksc.pdfviewer.util.d;

public class DefaultScrollHandle extends RelativeLayout implements a {

    /* renamed from: a  reason: collision with root package name */
    protected TextView f14666a;

    /* renamed from: b  reason: collision with root package name */
    protected Context f14667b;

    /* renamed from: c  reason: collision with root package name */
    private float f14668c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f14669d;

    /* renamed from: e  reason: collision with root package name */
    private PDFView f14670e;

    /* renamed from: f  reason: collision with root package name */
    private float f14671f;

    /* renamed from: g  reason: collision with root package name */
    private Handler f14672g;

    /* renamed from: h  reason: collision with root package name */
    private Runnable f14673h;

    public DefaultScrollHandle(Context context) {
        this(context, false);
    }

    public DefaultScrollHandle(Context context, boolean z2) {
        super(context);
        this.f14668c = 0.0f;
        this.f14672g = new Handler();
        this.f14673h = new Runnable() {
            public void run() {
                DefaultScrollHandle.this.e();
            }
        };
        this.f14667b = context;
        this.f14669d = z2;
        this.f14666a = new TextView(context);
        setVisibility(4);
        setTextColor(-16777216);
        setTextSize(16);
    }

    private void f() {
        int i2;
        float f2;
        float f3;
        if (this.f14670e.m()) {
            f3 = getY();
            f2 = (float) getHeight();
            i2 = this.f14670e.getHeight();
        } else {
            f3 = getX();
            f2 = (float) getWidth();
            i2 = this.f14670e.getWidth();
        }
        this.f14668c = ((f3 + this.f14668c) / ((float) i2)) * f2;
    }

    private boolean g() {
        PDFView pDFView = this.f14670e;
        return pDFView != null && pDFView.getPageCount() > 0 && !this.f14670e.i();
    }

    private void setPosition(float f2) {
        if (!Float.isInfinite(f2) && !Float.isNaN(f2)) {
            float height = (float) (this.f14670e.m() ? this.f14670e.getHeight() : this.f14670e.getWidth());
            float f3 = f2 - this.f14668c;
            if (f3 < 0.0f) {
                f3 = 0.0f;
            } else if (f3 > height - ((float) d.a(this.f14667b, 40))) {
                f3 = height - ((float) d.a(this.f14667b, 40));
            }
            if (this.f14670e.m()) {
                setY(f3);
            } else {
                setX(f3);
            }
            f();
            invalidate();
        }
    }

    public void a() {
        this.f14670e.removeView(this);
    }

    public void b() {
        this.f14672g.postDelayed(this.f14673h, 1000);
    }

    public boolean c() {
        return getVisibility() == 0;
    }

    public void d() {
        setVisibility(0);
    }

    public void e() {
        setVisibility(4);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0075  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            boolean r0 = r4.g()
            if (r0 != 0) goto L_0x000b
            boolean r5 = super.onTouchEvent(r5)
            return r5
        L_0x000b:
            int r0 = r5.getAction()
            r1 = 1
            if (r0 == 0) goto L_0x002e
            if (r0 == r1) goto L_0x0025
            r2 = 2
            if (r0 == r2) goto L_0x0056
            r2 = 3
            if (r0 == r2) goto L_0x0025
            r2 = 5
            if (r0 == r2) goto L_0x002e
            r2 = 6
            if (r0 == r2) goto L_0x0025
            boolean r5 = super.onTouchEvent(r5)
            return r5
        L_0x0025:
            r4.b()
            com.github.barteksc.pdfviewer.PDFView r5 = r4.f14670e
            r5.g()
            return r1
        L_0x002e:
            com.github.barteksc.pdfviewer.PDFView r0 = r4.f14670e
            r0.a()
            android.os.Handler r0 = r4.f14672g
            java.lang.Runnable r2 = r4.f14673h
            r0.removeCallbacks(r2)
            com.github.barteksc.pdfviewer.PDFView r0 = r4.f14670e
            boolean r0 = r0.m()
            if (r0 == 0) goto L_0x004b
            float r0 = r5.getRawY()
            float r2 = r4.getY()
            goto L_0x0053
        L_0x004b:
            float r0 = r5.getRawX()
            float r2 = r4.getX()
        L_0x0053:
            float r0 = r0 - r2
            r4.f14671f = r0
        L_0x0056:
            com.github.barteksc.pdfviewer.PDFView r0 = r4.f14670e
            boolean r0 = r0.m()
            r2 = 0
            if (r0 == 0) goto L_0x0075
            float r5 = r5.getRawY()
            float r0 = r4.f14671f
            float r5 = r5 - r0
            float r0 = r4.f14668c
            float r5 = r5 + r0
            r4.setPosition(r5)
            com.github.barteksc.pdfviewer.PDFView r5 = r4.f14670e
            float r0 = r4.f14668c
            int r3 = r4.getHeight()
            goto L_0x008a
        L_0x0075:
            float r5 = r5.getRawX()
            float r0 = r4.f14671f
            float r5 = r5 - r0
            float r0 = r4.f14668c
            float r5 = r5 + r0
            r4.setPosition(r5)
            com.github.barteksc.pdfviewer.PDFView r5 = r4.f14670e
            float r0 = r4.f14668c
            int r3 = r4.getWidth()
        L_0x008a:
            float r3 = (float) r3
            float r0 = r0 / r3
            r5.a((float) r0, (boolean) r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setPageNum(int i2) {
        String valueOf = String.valueOf(i2);
        if (!this.f14666a.getText().equals(valueOf)) {
            this.f14666a.setText(valueOf);
        }
    }

    public void setScroll(float f2) {
        if (!c()) {
            d();
        } else {
            this.f14672g.removeCallbacks(this.f14673h);
        }
        setPosition(((float) (this.f14670e.m() ? this.f14670e.getHeight() : this.f14670e.getWidth())) * f2);
    }

    public void setTextColor(int i2) {
        this.f14666a.setTextColor(i2);
    }

    public void setTextSize(int i2) {
        this.f14666a.setTextSize(1, (float) i2);
    }

    public void setupLayout(PDFView pDFView) {
        Drawable drawable;
        int i2;
        int i3;
        Context context;
        int i4;
        int i5;
        Context context2;
        int i6 = 65;
        int i7 = 40;
        if (pDFView.m()) {
            if (this.f14669d) {
                i2 = 9;
                context2 = this.f14667b;
                i5 = R.drawable.default_scroll_handle_left;
            } else {
                i2 = 11;
                context2 = this.f14667b;
                i5 = R.drawable.default_scroll_handle_right;
            }
            drawable = b.a(context2, i5);
        } else {
            if (this.f14669d) {
                i4 = 10;
                context = this.f14667b;
                i3 = R.drawable.default_scroll_handle_top;
            } else {
                i4 = 12;
                context = this.f14667b;
                i3 = R.drawable.default_scroll_handle_bottom;
            }
            drawable = b.a(context, i3);
            i6 = 40;
            i7 = 65;
        }
        if (Build.VERSION.SDK_INT < 16) {
            setBackgroundDrawable(drawable);
        } else {
            setBackground(drawable);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(d.a(this.f14667b, i6), d.a(this.f14667b, i7));
        layoutParams.setMargins(0, 0, 0, 0);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13, -1);
        addView(this.f14666a, layoutParams2);
        layoutParams.addRule(i2);
        pDFView.addView(this, layoutParams);
        this.f14670e = pDFView;
    }
}
