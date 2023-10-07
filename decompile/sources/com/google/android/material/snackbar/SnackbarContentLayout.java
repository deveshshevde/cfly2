package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.R;
import gn.a;
import t.ac;

public class SnackbarContentLayout extends LinearLayout implements a {

    /* renamed from: a  reason: collision with root package name */
    private TextView f19637a;

    /* renamed from: b  reason: collision with root package name */
    private Button f19638b;

    /* renamed from: c  reason: collision with root package name */
    private int f19639c;

    /* renamed from: d  reason: collision with root package name */
    private int f19640d;

    public SnackbarContentLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public SnackbarContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SnackbarLayout);
        this.f19639c = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SnackbarLayout_android_maxWidth, -1);
        this.f19640d = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SnackbarLayout_maxActionInlineWidth, -1);
        obtainStyledAttributes.recycle();
    }

    private static void a(View view, int i2, int i3) {
        if (ac.B(view)) {
            ac.b(view, ac.l(view), i2, ac.m(view), i3);
        } else {
            view.setPadding(view.getPaddingLeft(), i2, view.getPaddingRight(), i3);
        }
    }

    private boolean a(int i2, int i3, int i4) {
        boolean z2;
        if (i2 != getOrientation()) {
            setOrientation(i2);
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.f19637a.getPaddingTop() == i3 && this.f19637a.getPaddingBottom() == i4) {
            return z2;
        }
        a((View) this.f19637a, i3, i4);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void a(float f2) {
        if (f2 != 1.0f) {
            this.f19638b.setTextColor(a.a(a.a((View) this, R.attr.colorSurface), this.f19638b.getCurrentTextColor(), f2));
        }
    }

    public void a(int i2, int i3) {
        this.f19637a.setAlpha(0.0f);
        long j2 = (long) i3;
        long j3 = (long) i2;
        this.f19637a.animate().alpha(1.0f).setDuration(j2).setStartDelay(j3).start();
        if (this.f19638b.getVisibility() == 0) {
            this.f19638b.setAlpha(0.0f);
            this.f19638b.animate().alpha(1.0f).setDuration(j2).setStartDelay(j3).start();
        }
    }

    public void b(int i2, int i3) {
        this.f19637a.setAlpha(1.0f);
        long j2 = (long) i3;
        long j3 = (long) i2;
        this.f19637a.animate().alpha(0.0f).setDuration(j2).setStartDelay(j3).start();
        if (this.f19638b.getVisibility() == 0) {
            this.f19638b.setAlpha(1.0f);
            this.f19638b.animate().alpha(0.0f).setDuration(j2).setStartDelay(j3).start();
        }
    }

    public Button getActionView() {
        return this.f19638b;
    }

    public TextView getMessageView() {
        return this.f19637a;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f19637a = (TextView) findViewById(R.id.snackbar_text);
        this.f19638b = (Button) findViewById(R.id.snackbar_action);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0053, code lost:
        if (a(1, r0, r0 - r1) != false) goto L_0x0060;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005e, code lost:
        if (a(0, r0, r0) != false) goto L_0x0060;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r8, int r9) {
        /*
            r7 = this;
            super.onMeasure(r8, r9)
            int r0 = r7.f19639c
            if (r0 <= 0) goto L_0x0018
            int r0 = r7.getMeasuredWidth()
            int r1 = r7.f19639c
            if (r0 <= r1) goto L_0x0018
            r8 = 1073741824(0x40000000, float:2.0)
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r8)
            super.onMeasure(r8, r9)
        L_0x0018:
            android.content.res.Resources r0 = r7.getResources()
            int r1 = com.google.android.material.R.dimen.design_snackbar_padding_vertical_2lines
            int r0 = r0.getDimensionPixelSize(r1)
            android.content.res.Resources r1 = r7.getResources()
            int r2 = com.google.android.material.R.dimen.design_snackbar_padding_vertical
            int r1 = r1.getDimensionPixelSize(r2)
            android.widget.TextView r2 = r7.f19637a
            android.text.Layout r2 = r2.getLayout()
            int r2 = r2.getLineCount()
            r3 = 0
            r4 = 1
            if (r2 <= r4) goto L_0x003c
            r2 = 1
            goto L_0x003d
        L_0x003c:
            r2 = 0
        L_0x003d:
            if (r2 == 0) goto L_0x0056
            int r5 = r7.f19640d
            if (r5 <= 0) goto L_0x0056
            android.widget.Button r5 = r7.f19638b
            int r5 = r5.getMeasuredWidth()
            int r6 = r7.f19640d
            if (r5 <= r6) goto L_0x0056
            int r1 = r0 - r1
            boolean r0 = r7.a((int) r4, (int) r0, (int) r1)
            if (r0 == 0) goto L_0x0061
            goto L_0x0060
        L_0x0056:
            if (r2 == 0) goto L_0x0059
            goto L_0x005a
        L_0x0059:
            r0 = r1
        L_0x005a:
            boolean r0 = r7.a((int) r3, (int) r0, (int) r0)
            if (r0 == 0) goto L_0x0061
        L_0x0060:
            r3 = 1
        L_0x0061:
            if (r3 == 0) goto L_0x0066
            super.onMeasure(r8, r9)
        L_0x0066:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.snackbar.SnackbarContentLayout.onMeasure(int, int):void");
    }

    public void setMaxInlineActionWidth(int i2) {
        this.f19640d = i2;
    }
}
