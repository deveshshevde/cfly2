package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import androidx.appcompat.R;
import com.blankj.utilcode.constant.MemoryConstants;
import t.ac;

public class LinearLayoutCompat extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    private boolean f1177a;

    /* renamed from: b  reason: collision with root package name */
    private int f1178b;

    /* renamed from: c  reason: collision with root package name */
    private int f1179c;

    /* renamed from: d  reason: collision with root package name */
    private int f1180d;

    /* renamed from: e  reason: collision with root package name */
    private int f1181e;

    /* renamed from: f  reason: collision with root package name */
    private int f1182f;

    /* renamed from: g  reason: collision with root package name */
    private float f1183g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f1184h;

    /* renamed from: i  reason: collision with root package name */
    private int[] f1185i;

    /* renamed from: j  reason: collision with root package name */
    private int[] f1186j;

    /* renamed from: k  reason: collision with root package name */
    private Drawable f1187k;

    /* renamed from: l  reason: collision with root package name */
    private int f1188l;

    /* renamed from: m  reason: collision with root package name */
    private int f1189m;

    /* renamed from: n  reason: collision with root package name */
    private int f1190n;

    /* renamed from: o  reason: collision with root package name */
    private int f1191o;

    public static class LayoutParams extends LinearLayout.LayoutParams {
        public LayoutParams(int i2, int i3) {
            super(i2, i3);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public LinearLayoutCompat(Context context) {
        this(context, (AttributeSet) null);
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f1177a = true;
        this.f1178b = -1;
        this.f1179c = 0;
        this.f1181e = 8388659;
        af a2 = af.a(context, attributeSet, R.styleable.LinearLayoutCompat, i2, 0);
        ac.a(this, context, R.styleable.LinearLayoutCompat, attributeSet, a2.a(), i2, 0);
        int a3 = a2.a(R.styleable.LinearLayoutCompat_android_orientation, -1);
        if (a3 >= 0) {
            setOrientation(a3);
        }
        int a4 = a2.a(R.styleable.LinearLayoutCompat_android_gravity, -1);
        if (a4 >= 0) {
            setGravity(a4);
        }
        boolean a5 = a2.a(R.styleable.LinearLayoutCompat_android_baselineAligned, true);
        if (!a5) {
            setBaselineAligned(a5);
        }
        this.f1183g = a2.a(R.styleable.LinearLayoutCompat_android_weightSum, -1.0f);
        this.f1178b = a2.a(R.styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.f1184h = a2.a(R.styleable.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(a2.a(R.styleable.LinearLayoutCompat_divider));
        this.f1190n = a2.a(R.styleable.LinearLayoutCompat_showDividers, 0);
        this.f1191o = a2.e(R.styleable.LinearLayoutCompat_dividerPadding, 0);
        a2.b();
    }

    private void a(View view, int i2, int i3, int i4, int i5) {
        view.layout(i2, i3, i4 + i2, i5 + i3);
    }

    private void c(int i2, int i3) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), MemoryConstants.GB);
        for (int i4 = 0; i4 < i2; i4++) {
            View b2 = b(i4);
            if (b2.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) b2.getLayoutParams();
                if (layoutParams.width == -1) {
                    int i5 = layoutParams.height;
                    layoutParams.height = b2.getMeasuredHeight();
                    measureChildWithMargins(b2, makeMeasureSpec, 0, i3, 0);
                    layoutParams.height = i5;
                }
            }
        }
    }

    private void d(int i2, int i3) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), MemoryConstants.GB);
        for (int i4 = 0; i4 < i2; i4++) {
            View b2 = b(i4);
            if (b2.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) b2.getLayoutParams();
                if (layoutParams.height == -1) {
                    int i5 = layoutParams.width;
                    layoutParams.width = b2.getMeasuredWidth();
                    measureChildWithMargins(b2, i3, 0, makeMeasureSpec, 0);
                    layoutParams.width = i5;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int a(View view) {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int a(View view, int i2) {
        return 0;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x02d2, code lost:
        if (r15 > 0) goto L_0x02e0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x02dd, code lost:
        if (r15 < 0) goto L_0x02df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x02df, code lost:
        r15 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x02e0, code lost:
        r13.measure(r0, android.view.View.MeasureSpec.makeMeasureSpec(r15, r10));
        r1 = android.view.View.combineMeasuredStates(r1, r13.getMeasuredState() & -256);
        r0 = r18;
     */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x031d  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x0328  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x032a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(int r34, int r35) {
        /*
            r33 = this;
            r7 = r33
            r8 = r34
            r9 = r35
            r10 = 0
            r7.f1182f = r10
            int r11 = r33.getVirtualChildCount()
            int r12 = android.view.View.MeasureSpec.getMode(r34)
            int r13 = android.view.View.MeasureSpec.getMode(r35)
            int r14 = r7.f1178b
            boolean r15 = r7.f1184h
            r16 = 0
            r17 = 1
            r0 = 0
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r18 = 0
            r19 = 1
            r20 = 0
        L_0x002a:
            r10 = 8
            r22 = r4
            if (r6 >= r11) goto L_0x019b
            android.view.View r4 = r7.b((int) r6)
            if (r4 != 0) goto L_0x0047
            int r4 = r7.f1182f
            int r10 = r7.d(r6)
            int r4 = r4 + r10
            r7.f1182f = r4
            r23 = r11
            r24 = r13
            r4 = r22
            goto L_0x018f
        L_0x0047:
            r24 = r1
            int r1 = r4.getVisibility()
            if (r1 != r10) goto L_0x005e
            int r1 = r7.a((android.view.View) r4, (int) r6)
            int r6 = r6 + r1
            r23 = r11
            r4 = r22
            r1 = r24
            r24 = r13
            goto L_0x018f
        L_0x005e:
            boolean r1 = r7.c(r6)
            if (r1 == 0) goto L_0x006b
            int r1 = r7.f1182f
            int r10 = r7.f1189m
            int r1 = r1 + r10
            r7.f1182f = r1
        L_0x006b:
            android.view.ViewGroup$LayoutParams r1 = r4.getLayoutParams()
            r10 = r1
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r10 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r10
            float r1 = r10.weight
            float r25 = r0 + r1
            r1 = 1073741824(0x40000000, float:2.0)
            if (r13 != r1) goto L_0x00a7
            int r0 = r10.height
            if (r0 != 0) goto L_0x00a7
            float r0 = r10.weight
            int r0 = (r0 > r16 ? 1 : (r0 == r16 ? 0 : -1))
            if (r0 <= 0) goto L_0x00a7
            int r0 = r7.f1182f
            int r1 = r10.topMargin
            int r1 = r1 + r0
            r26 = r2
            int r2 = r10.bottomMargin
            int r1 = r1 + r2
            int r0 = java.lang.Math.max(r0, r1)
            r7.f1182f = r0
            r0 = r3
            r3 = r4
            r31 = r5
            r23 = r11
            r8 = r24
            r29 = r26
            r18 = 1
            r11 = r6
            r24 = r13
            r13 = r22
            goto L_0x0117
        L_0x00a7:
            r26 = r2
            int r0 = r10.height
            if (r0 != 0) goto L_0x00b8
            float r0 = r10.weight
            int r0 = (r0 > r16 ? 1 : (r0 == r16 ? 0 : -1))
            if (r0 <= 0) goto L_0x00b8
            r0 = -2
            r10.height = r0
            r2 = 0
            goto L_0x00ba
        L_0x00b8:
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
        L_0x00ba:
            r27 = 0
            int r0 = (r25 > r16 ? 1 : (r25 == r16 ? 0 : -1))
            if (r0 != 0) goto L_0x00c5
            int r0 = r7.f1182f
            r28 = r0
            goto L_0x00c7
        L_0x00c5:
            r28 = 0
        L_0x00c7:
            r0 = r33
            r8 = r24
            r23 = 1073741824(0x40000000, float:2.0)
            r1 = r4
            r30 = r2
            r29 = r26
            r2 = r6
            r9 = r3
            r3 = r34
            r23 = r11
            r24 = r13
            r13 = r22
            r11 = 1073741824(0x40000000, float:2.0)
            r22 = r4
            r4 = r27
            r31 = r5
            r5 = r35
            r11 = r6
            r6 = r28
            r0.a(r1, r2, r3, r4, r5, r6)
            r0 = r30
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 == r1) goto L_0x00f4
            r10.height = r0
        L_0x00f4:
            int r0 = r22.getMeasuredHeight()
            int r1 = r7.f1182f
            int r2 = r1 + r0
            int r3 = r10.topMargin
            int r2 = r2 + r3
            int r3 = r10.bottomMargin
            int r2 = r2 + r3
            r3 = r22
            int r4 = r7.b((android.view.View) r3)
            int r2 = r2 + r4
            int r1 = java.lang.Math.max(r1, r2)
            r7.f1182f = r1
            if (r15 == 0) goto L_0x0116
            int r0 = java.lang.Math.max(r0, r9)
            goto L_0x0117
        L_0x0116:
            r0 = r9
        L_0x0117:
            if (r14 < 0) goto L_0x0121
            int r6 = r11 + 1
            if (r14 != r6) goto L_0x0121
            int r1 = r7.f1182f
            r7.f1179c = r1
        L_0x0121:
            if (r11 >= r14) goto L_0x0132
            float r1 = r10.weight
            int r1 = (r1 > r16 ? 1 : (r1 == r16 ? 0 : -1))
            if (r1 > 0) goto L_0x012a
            goto L_0x0132
        L_0x012a:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r1 = "A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex."
            r0.<init>(r1)
            throw r0
        L_0x0132:
            r1 = 1073741824(0x40000000, float:2.0)
            if (r12 == r1) goto L_0x013f
            int r1 = r10.width
            r2 = -1
            if (r1 != r2) goto L_0x013f
            r1 = 1
            r20 = 1
            goto L_0x0140
        L_0x013f:
            r1 = 0
        L_0x0140:
            int r2 = r10.leftMargin
            int r4 = r10.rightMargin
            int r2 = r2 + r4
            int r4 = r3.getMeasuredWidth()
            int r4 = r4 + r2
            r5 = r29
            int r5 = java.lang.Math.max(r5, r4)
            int r6 = r3.getMeasuredState()
            int r6 = android.view.View.combineMeasuredStates(r8, r6)
            if (r19 == 0) goto L_0x0162
            int r8 = r10.width
            r9 = -1
            if (r8 != r9) goto L_0x0162
            r19 = 1
            goto L_0x0164
        L_0x0162:
            r19 = 0
        L_0x0164:
            float r8 = r10.weight
            int r8 = (r8 > r16 ? 1 : (r8 == r16 ? 0 : -1))
            if (r8 <= 0) goto L_0x0175
            if (r1 == 0) goto L_0x016d
            goto L_0x016e
        L_0x016d:
            r2 = r4
        L_0x016e:
            int r4 = java.lang.Math.max(r13, r2)
            r1 = r31
            goto L_0x0180
        L_0x0175:
            if (r1 == 0) goto L_0x0178
            goto L_0x0179
        L_0x0178:
            r2 = r4
        L_0x0179:
            r1 = r31
            int r1 = java.lang.Math.max(r1, r2)
            r4 = r13
        L_0x0180:
            int r2 = r7.a((android.view.View) r3, (int) r11)
            int r2 = r2 + r11
            r3 = r0
            r0 = r25
            r32 = r5
            r5 = r1
            r1 = r6
            r6 = r2
            r2 = r32
        L_0x018f:
            int r6 = r6 + 1
            r8 = r34
            r9 = r35
            r11 = r23
            r13 = r24
            goto L_0x002a
        L_0x019b:
            r8 = r1
            r9 = r3
            r1 = r5
            r23 = r11
            r24 = r13
            r13 = r22
            r5 = r2
            int r2 = r7.f1182f
            if (r2 <= 0) goto L_0x01b9
            r2 = r23
            boolean r3 = r7.c(r2)
            if (r3 == 0) goto L_0x01bb
            int r3 = r7.f1182f
            int r4 = r7.f1189m
            int r3 = r3 + r4
            r7.f1182f = r3
            goto L_0x01bb
        L_0x01b9:
            r2 = r23
        L_0x01bb:
            r3 = r24
            if (r15 == 0) goto L_0x0209
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r3 == r4) goto L_0x01c5
            if (r3 != 0) goto L_0x0209
        L_0x01c5:
            r4 = 0
            r7.f1182f = r4
            r4 = 0
        L_0x01c9:
            if (r4 >= r2) goto L_0x0209
            android.view.View r6 = r7.b((int) r4)
            if (r6 != 0) goto L_0x01db
            int r6 = r7.f1182f
            int r11 = r7.d(r4)
            int r6 = r6 + r11
        L_0x01d8:
            r7.f1182f = r6
            goto L_0x0204
        L_0x01db:
            int r11 = r6.getVisibility()
            if (r11 != r10) goto L_0x01e7
            int r6 = r7.a((android.view.View) r6, (int) r4)
            int r4 = r4 + r6
            goto L_0x0204
        L_0x01e7:
            android.view.ViewGroup$LayoutParams r11 = r6.getLayoutParams()
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r11 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r11
            int r14 = r7.f1182f
            int r21 = r14 + r9
            int r10 = r11.topMargin
            int r21 = r21 + r10
            int r10 = r11.bottomMargin
            int r21 = r21 + r10
            int r6 = r7.b((android.view.View) r6)
            int r6 = r21 + r6
            int r6 = java.lang.Math.max(r14, r6)
            goto L_0x01d8
        L_0x0204:
            int r4 = r4 + 1
            r10 = 8
            goto L_0x01c9
        L_0x0209:
            int r4 = r7.f1182f
            int r6 = r33.getPaddingTop()
            int r10 = r33.getPaddingBottom()
            int r6 = r6 + r10
            int r4 = r4 + r6
            r7.f1182f = r4
            int r6 = r33.getSuggestedMinimumHeight()
            int r4 = java.lang.Math.max(r4, r6)
            r6 = r35
            r10 = r9
            r9 = 0
            int r4 = android.view.View.resolveSizeAndState(r4, r6, r9)
            r9 = 16777215(0xffffff, float:2.3509886E-38)
            r9 = r9 & r4
            int r11 = r7.f1182f
            int r9 = r9 - r11
            if (r18 != 0) goto L_0x0278
            if (r9 == 0) goto L_0x0237
            int r11 = (r0 > r16 ? 1 : (r0 == r16 ? 0 : -1))
            if (r11 <= 0) goto L_0x0237
            goto L_0x0278
        L_0x0237:
            int r0 = java.lang.Math.max(r1, r13)
            if (r15 == 0) goto L_0x0273
            r1 = 1073741824(0x40000000, float:2.0)
            if (r3 == r1) goto L_0x0273
            r1 = 0
        L_0x0242:
            if (r1 >= r2) goto L_0x0273
            android.view.View r3 = r7.b((int) r1)
            if (r3 == 0) goto L_0x0270
            int r9 = r3.getVisibility()
            r11 = 8
            if (r9 != r11) goto L_0x0253
            goto L_0x0270
        L_0x0253:
            android.view.ViewGroup$LayoutParams r9 = r3.getLayoutParams()
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r9 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r9
            float r9 = r9.weight
            int r9 = (r9 > r16 ? 1 : (r9 == r16 ? 0 : -1))
            if (r9 <= 0) goto L_0x0270
            int r9 = r3.getMeasuredWidth()
            r11 = 1073741824(0x40000000, float:2.0)
            int r9 = android.view.View.MeasureSpec.makeMeasureSpec(r9, r11)
            int r13 = android.view.View.MeasureSpec.makeMeasureSpec(r10, r11)
            r3.measure(r9, r13)
        L_0x0270:
            int r1 = r1 + 1
            goto L_0x0242
        L_0x0273:
            r11 = r34
            r1 = r8
            goto L_0x0362
        L_0x0278:
            float r10 = r7.f1183g
            int r11 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1))
            if (r11 <= 0) goto L_0x027f
            r0 = r10
        L_0x027f:
            r10 = 0
            r7.f1182f = r10
            r11 = r9
            r9 = r1
            r1 = r8
            r8 = 0
        L_0x0286:
            if (r8 >= r2) goto L_0x0351
            android.view.View r13 = r7.b((int) r8)
            int r14 = r13.getVisibility()
            r15 = 8
            if (r14 != r15) goto L_0x029a
            r21 = r11
            r11 = r34
            goto L_0x034a
        L_0x029a:
            android.view.ViewGroup$LayoutParams r14 = r13.getLayoutParams()
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r14 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r14
            float r10 = r14.weight
            int r18 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1))
            if (r18 <= 0) goto L_0x02f4
            float r15 = (float) r11
            float r15 = r15 * r10
            float r15 = r15 / r0
            int r15 = (int) r15
            float r0 = r0 - r10
            int r11 = r11 - r15
            int r10 = r33.getPaddingLeft()
            int r18 = r33.getPaddingRight()
            int r10 = r10 + r18
            r18 = r0
            int r0 = r14.leftMargin
            int r10 = r10 + r0
            int r0 = r14.rightMargin
            int r10 = r10 + r0
            int r0 = r14.width
            r21 = r11
            r11 = r34
            int r0 = getChildMeasureSpec(r11, r10, r0)
            int r10 = r14.height
            if (r10 != 0) goto L_0x02d5
            r10 = 1073741824(0x40000000, float:2.0)
            if (r3 == r10) goto L_0x02d2
            goto L_0x02d7
        L_0x02d2:
            if (r15 <= 0) goto L_0x02df
            goto L_0x02e0
        L_0x02d5:
            r10 = 1073741824(0x40000000, float:2.0)
        L_0x02d7:
            int r23 = r13.getMeasuredHeight()
            int r15 = r23 + r15
            if (r15 >= 0) goto L_0x02e0
        L_0x02df:
            r15 = 0
        L_0x02e0:
            int r15 = android.view.View.MeasureSpec.makeMeasureSpec(r15, r10)
            r13.measure(r0, r15)
            int r0 = r13.getMeasuredState()
            r0 = r0 & -256(0xffffffffffffff00, float:NaN)
            int r1 = android.view.View.combineMeasuredStates(r1, r0)
            r0 = r18
            goto L_0x02f9
        L_0x02f4:
            r10 = r11
            r11 = r34
            r21 = r10
        L_0x02f9:
            int r10 = r14.leftMargin
            int r15 = r14.rightMargin
            int r10 = r10 + r15
            int r15 = r13.getMeasuredWidth()
            int r15 = r15 + r10
            int r5 = java.lang.Math.max(r5, r15)
            r18 = r0
            r0 = 1073741824(0x40000000, float:2.0)
            if (r12 == r0) goto L_0x0316
            int r0 = r14.width
            r23 = r1
            r1 = -1
            if (r0 != r1) goto L_0x0319
            r0 = 1
            goto L_0x031a
        L_0x0316:
            r23 = r1
            r1 = -1
        L_0x0319:
            r0 = 0
        L_0x031a:
            if (r0 == 0) goto L_0x031d
            goto L_0x031e
        L_0x031d:
            r10 = r15
        L_0x031e:
            int r0 = java.lang.Math.max(r9, r10)
            if (r19 == 0) goto L_0x032a
            int r9 = r14.width
            if (r9 != r1) goto L_0x032a
            r9 = 1
            goto L_0x032b
        L_0x032a:
            r9 = 0
        L_0x032b:
            int r10 = r7.f1182f
            int r15 = r13.getMeasuredHeight()
            int r15 = r15 + r10
            int r1 = r14.topMargin
            int r15 = r15 + r1
            int r1 = r14.bottomMargin
            int r15 = r15 + r1
            int r1 = r7.b((android.view.View) r13)
            int r15 = r15 + r1
            int r1 = java.lang.Math.max(r10, r15)
            r7.f1182f = r1
            r19 = r9
            r1 = r23
            r9 = r0
            r0 = r18
        L_0x034a:
            int r8 = r8 + 1
            r11 = r21
            r10 = 0
            goto L_0x0286
        L_0x0351:
            r11 = r34
            int r0 = r7.f1182f
            int r3 = r33.getPaddingTop()
            int r8 = r33.getPaddingBottom()
            int r3 = r3 + r8
            int r0 = r0 + r3
            r7.f1182f = r0
            r0 = r9
        L_0x0362:
            if (r19 != 0) goto L_0x0369
            r3 = 1073741824(0x40000000, float:2.0)
            if (r12 == r3) goto L_0x0369
            goto L_0x036a
        L_0x0369:
            r0 = r5
        L_0x036a:
            int r3 = r33.getPaddingLeft()
            int r5 = r33.getPaddingRight()
            int r3 = r3 + r5
            int r0 = r0 + r3
            int r3 = r33.getSuggestedMinimumWidth()
            int r0 = java.lang.Math.max(r0, r3)
            int r0 = android.view.View.resolveSizeAndState(r0, r11, r1)
            r7.setMeasuredDimension(r0, r4)
            if (r20 == 0) goto L_0x0388
            r7.c(r2, r6)
        L_0x0388:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.a(int, int):void");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x009d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(int r18, int r19, int r20, int r21) {
        /*
            r17 = this;
            r6 = r17
            int r7 = r17.getPaddingLeft()
            int r0 = r20 - r18
            int r1 = r17.getPaddingRight()
            int r8 = r0 - r1
            int r0 = r0 - r7
            int r1 = r17.getPaddingRight()
            int r9 = r0 - r1
            int r10 = r17.getVirtualChildCount()
            int r0 = r6.f1181e
            r1 = r0 & 112(0x70, float:1.57E-43)
            r2 = 8388615(0x800007, float:1.1754953E-38)
            r11 = r0 & r2
            r0 = 16
            if (r1 == r0) goto L_0x003b
            r0 = 80
            if (r1 == r0) goto L_0x002f
            int r0 = r17.getPaddingTop()
            goto L_0x0047
        L_0x002f:
            int r0 = r17.getPaddingTop()
            int r0 = r0 + r21
            int r0 = r0 - r19
            int r1 = r6.f1182f
            int r0 = r0 - r1
            goto L_0x0047
        L_0x003b:
            int r0 = r17.getPaddingTop()
            int r1 = r21 - r19
            int r2 = r6.f1182f
            int r1 = r1 - r2
            int r1 = r1 / 2
            int r0 = r0 + r1
        L_0x0047:
            r1 = 0
            r12 = 0
        L_0x0049:
            if (r12 >= r10) goto L_0x00c6
            android.view.View r13 = r6.b((int) r12)
            r14 = 1
            if (r13 != 0) goto L_0x0059
            int r1 = r6.d(r12)
            int r0 = r0 + r1
            goto L_0x00c3
        L_0x0059:
            int r1 = r13.getVisibility()
            r2 = 8
            if (r1 == r2) goto L_0x00c3
            int r4 = r13.getMeasuredWidth()
            int r15 = r13.getMeasuredHeight()
            android.view.ViewGroup$LayoutParams r1 = r13.getLayoutParams()
            r5 = r1
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r5 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r5
            int r1 = r5.gravity
            if (r1 >= 0) goto L_0x0075
            r1 = r11
        L_0x0075:
            int r2 = t.ac.i(r17)
            int r1 = t.f.a(r1, r2)
            r1 = r1 & 7
            if (r1 == r14) goto L_0x008b
            r2 = 5
            if (r1 == r2) goto L_0x0088
            int r1 = r5.leftMargin
            int r1 = r1 + r7
            goto L_0x0096
        L_0x0088:
            int r1 = r8 - r4
            goto L_0x0093
        L_0x008b:
            int r1 = r9 - r4
            int r1 = r1 / 2
            int r1 = r1 + r7
            int r2 = r5.leftMargin
            int r1 = r1 + r2
        L_0x0093:
            int r2 = r5.rightMargin
            int r1 = r1 - r2
        L_0x0096:
            r2 = r1
            boolean r1 = r6.c(r12)
            if (r1 == 0) goto L_0x00a0
            int r1 = r6.f1189m
            int r0 = r0 + r1
        L_0x00a0:
            int r1 = r5.topMargin
            int r16 = r0 + r1
            int r0 = r6.a((android.view.View) r13)
            int r3 = r16 + r0
            r0 = r17
            r1 = r13
            r14 = r5
            r5 = r15
            r0.a(r1, r2, r3, r4, r5)
            int r0 = r14.bottomMargin
            int r15 = r15 + r0
            int r0 = r6.b((android.view.View) r13)
            int r15 = r15 + r0
            int r16 = r16 + r15
            int r0 = r6.a((android.view.View) r13, (int) r12)
            int r12 = r12 + r0
            r0 = r16
        L_0x00c3:
            r1 = 1
            int r12 = r12 + r1
            goto L_0x0049
        L_0x00c6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.a(int, int, int, int):void");
    }

    /* access modifiers changed from: package-private */
    public void a(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        for (int i2 = 0; i2 < virtualChildCount; i2++) {
            View b2 = b(i2);
            if (!(b2 == null || b2.getVisibility() == 8 || !c(i2))) {
                a(canvas, (b2.getTop() - ((LayoutParams) b2.getLayoutParams()).topMargin) - this.f1189m);
            }
        }
        if (c(virtualChildCount)) {
            View b3 = b(virtualChildCount - 1);
            a(canvas, b3 == null ? (getHeight() - getPaddingBottom()) - this.f1189m : b3.getBottom() + ((LayoutParams) b3.getLayoutParams()).bottomMargin);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(Canvas canvas, int i2) {
        this.f1187k.setBounds(getPaddingLeft() + this.f1191o, i2, (getWidth() - getPaddingRight()) - this.f1191o, this.f1189m + i2);
        this.f1187k.draw(canvas);
    }

    /* access modifiers changed from: package-private */
    public void a(View view, int i2, int i3, int i4, int i5, int i6) {
        measureChildWithMargins(view, i3, i4, i5, i6);
    }

    /* access modifiers changed from: package-private */
    public int b(View view) {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public View b(int i2) {
        return getChildAt(i2);
    }

    /* renamed from: b */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x03a8, code lost:
        if (r8 > 0) goto L_0x03b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x03b3, code lost:
        if (r8 < 0) goto L_0x03b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x03b5, code lost:
        r8 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x03b6, code lost:
        r14.measure(android.view.View.MeasureSpec.makeMeasureSpec(r8, r3), r0);
        r9 = android.view.View.combineMeasuredStates(r9, r14.getMeasuredState() & -16777216);
        r0 = r23;
        r3 = r24;
     */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x0441  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x0444  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x016d  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0171  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0193  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0196  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01bf  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01c2  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01ca  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x01d5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(int r38, int r39) {
        /*
            r37 = this;
            r7 = r37
            r8 = r38
            r9 = r39
            r10 = 0
            r7.f1182f = r10
            int r11 = r37.getVirtualChildCount()
            int r12 = android.view.View.MeasureSpec.getMode(r38)
            int r13 = android.view.View.MeasureSpec.getMode(r39)
            int[] r0 = r7.f1185i
            r14 = 4
            if (r0 == 0) goto L_0x001e
            int[] r0 = r7.f1186j
            if (r0 != 0) goto L_0x0026
        L_0x001e:
            int[] r0 = new int[r14]
            r7.f1185i = r0
            int[] r0 = new int[r14]
            r7.f1186j = r0
        L_0x0026:
            int[] r15 = r7.f1185i
            int[] r6 = r7.f1186j
            r16 = 3
            r5 = -1
            r15[r16] = r5
            r17 = 2
            r15[r17] = r5
            r18 = 1
            r15[r18] = r5
            r15[r10] = r5
            r6[r16] = r5
            r6[r17] = r5
            r6[r18] = r5
            r6[r10] = r5
            boolean r4 = r7.f1177a
            boolean r3 = r7.f1184h
            r2 = 1073741824(0x40000000, float:2.0)
            if (r12 != r2) goto L_0x004c
            r19 = 1
            goto L_0x004e
        L_0x004c:
            r19 = 0
        L_0x004e:
            r20 = 0
            r0 = 0
            r1 = 0
            r14 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 1
            r27 = 0
        L_0x0061:
            r28 = r6
            r5 = 8
            if (r1 >= r11) goto L_0x01fe
            android.view.View r6 = r7.b((int) r1)
            if (r6 != 0) goto L_0x007f
            int r5 = r7.f1182f
            int r6 = r7.d(r1)
            int r5 = r5 + r6
            r7.f1182f = r5
        L_0x0076:
            r2 = r1
            r32 = r3
            r36 = r4
            r1 = 1073741824(0x40000000, float:2.0)
            goto L_0x01ed
        L_0x007f:
            int r10 = r6.getVisibility()
            if (r10 != r5) goto L_0x008b
            int r5 = r7.a((android.view.View) r6, (int) r1)
            int r1 = r1 + r5
            goto L_0x0076
        L_0x008b:
            boolean r5 = r7.c(r1)
            if (r5 == 0) goto L_0x0098
            int r5 = r7.f1182f
            int r10 = r7.f1188l
            int r5 = r5 + r10
            r7.f1182f = r5
        L_0x0098:
            android.view.ViewGroup$LayoutParams r5 = r6.getLayoutParams()
            r10 = r5
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r10 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r10
            float r5 = r10.weight
            float r31 = r0 + r5
            if (r12 != r2) goto L_0x00ea
            int r0 = r10.width
            if (r0 != 0) goto L_0x00ea
            float r0 = r10.weight
            int r0 = (r0 > r20 ? 1 : (r0 == r20 ? 0 : -1))
            if (r0 <= 0) goto L_0x00ea
            int r0 = r7.f1182f
            if (r19 == 0) goto L_0x00ba
            int r5 = r10.leftMargin
            int r2 = r10.rightMargin
            int r5 = r5 + r2
            int r0 = r0 + r5
            goto L_0x00c4
        L_0x00ba:
            int r2 = r10.leftMargin
            int r2 = r2 + r0
            int r5 = r10.rightMargin
            int r2 = r2 + r5
            int r0 = java.lang.Math.max(r0, r2)
        L_0x00c4:
            r7.f1182f = r0
            if (r4 == 0) goto L_0x00db
            r0 = 0
            int r2 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r0)
            r6.measure(r2, r2)
            r34 = r1
            r32 = r3
            r36 = r4
            r3 = r6
            r30 = -2
            goto L_0x0164
        L_0x00db:
            r34 = r1
            r32 = r3
            r36 = r4
            r3 = r6
            r1 = 1073741824(0x40000000, float:2.0)
            r24 = 1
            r30 = -2
            goto L_0x0166
        L_0x00ea:
            int r0 = r10.width
            if (r0 != 0) goto L_0x00f9
            float r0 = r10.weight
            int r0 = (r0 > r20 ? 1 : (r0 == r20 ? 0 : -1))
            if (r0 <= 0) goto L_0x00f9
            r5 = -2
            r10.width = r5
            r2 = 0
            goto L_0x00fc
        L_0x00f9:
            r5 = -2
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
        L_0x00fc:
            int r0 = (r31 > r20 ? 1 : (r31 == r20 ? 0 : -1))
            if (r0 != 0) goto L_0x0105
            int r0 = r7.f1182f
            r29 = r0
            goto L_0x0107
        L_0x0105:
            r29 = 0
        L_0x0107:
            r33 = 0
            r0 = r37
            r34 = r1
            r1 = r6
            r35 = r2
            r2 = r34
            r32 = r3
            r3 = r38
            r36 = r4
            r4 = r29
            r9 = -1
            r29 = -2
            r5 = r39
            r29 = r6
            r9 = -2147483648(0xffffffff80000000, float:-0.0)
            r30 = -2
            r6 = r33
            r0.a(r1, r2, r3, r4, r5, r6)
            r0 = r35
            if (r0 == r9) goto L_0x0130
            r10.width = r0
        L_0x0130:
            int r0 = r29.getMeasuredWidth()
            if (r19 == 0) goto L_0x0147
            int r1 = r7.f1182f
            int r2 = r10.leftMargin
            int r2 = r2 + r0
            int r3 = r10.rightMargin
            int r2 = r2 + r3
            r3 = r29
            int r4 = r7.b((android.view.View) r3)
            int r2 = r2 + r4
            int r1 = r1 + r2
            goto L_0x015c
        L_0x0147:
            r3 = r29
            int r1 = r7.f1182f
            int r2 = r1 + r0
            int r4 = r10.leftMargin
            int r2 = r2 + r4
            int r4 = r10.rightMargin
            int r2 = r2 + r4
            int r4 = r7.b((android.view.View) r3)
            int r2 = r2 + r4
            int r1 = java.lang.Math.max(r1, r2)
        L_0x015c:
            r7.f1182f = r1
            if (r32 == 0) goto L_0x0164
            int r14 = java.lang.Math.max(r0, r14)
        L_0x0164:
            r1 = 1073741824(0x40000000, float:2.0)
        L_0x0166:
            if (r13 == r1) goto L_0x0171
            int r0 = r10.height
            r2 = -1
            if (r0 != r2) goto L_0x0171
            r0 = 1
            r27 = 1
            goto L_0x0172
        L_0x0171:
            r0 = 0
        L_0x0172:
            int r2 = r10.topMargin
            int r4 = r10.bottomMargin
            int r2 = r2 + r4
            int r4 = r3.getMeasuredHeight()
            int r4 = r4 + r2
            int r5 = r3.getMeasuredState()
            r6 = r25
            int r25 = android.view.View.combineMeasuredStates(r6, r5)
            if (r36 == 0) goto L_0x01b2
            int r5 = r3.getBaseline()
            r6 = -1
            if (r5 == r6) goto L_0x01b2
            int r6 = r10.gravity
            if (r6 >= 0) goto L_0x0196
            int r6 = r7.f1181e
            goto L_0x0198
        L_0x0196:
            int r6 = r10.gravity
        L_0x0198:
            r6 = r6 & 112(0x70, float:1.57E-43)
            r9 = 4
            int r6 = r6 >> r9
            r6 = r6 & -2
            int r6 = r6 >> 1
            r9 = r15[r6]
            int r9 = java.lang.Math.max(r9, r5)
            r15[r6] = r9
            r9 = r28[r6]
            int r5 = r4 - r5
            int r5 = java.lang.Math.max(r9, r5)
            r28[r6] = r5
        L_0x01b2:
            r5 = r21
            int r21 = java.lang.Math.max(r5, r4)
            if (r26 == 0) goto L_0x01c2
            int r5 = r10.height
            r6 = -1
            if (r5 != r6) goto L_0x01c2
            r26 = 1
            goto L_0x01c4
        L_0x01c2:
            r26 = 0
        L_0x01c4:
            float r5 = r10.weight
            int r5 = (r5 > r20 ? 1 : (r5 == r20 ? 0 : -1))
            if (r5 <= 0) goto L_0x01d5
            if (r0 == 0) goto L_0x01cd
            goto L_0x01ce
        L_0x01cd:
            r2 = r4
        L_0x01ce:
            r10 = r23
            int r23 = java.lang.Math.max(r10, r2)
            goto L_0x01e3
        L_0x01d5:
            r10 = r23
            if (r0 == 0) goto L_0x01da
            goto L_0x01db
        L_0x01da:
            r2 = r4
        L_0x01db:
            r4 = r22
            int r22 = java.lang.Math.max(r4, r2)
            r23 = r10
        L_0x01e3:
            r10 = r34
            int r0 = r7.a((android.view.View) r3, (int) r10)
            int r0 = r0 + r10
            r2 = r0
            r0 = r31
        L_0x01ed:
            int r2 = r2 + 1
            r9 = r39
            r1 = r2
            r6 = r28
            r3 = r32
            r4 = r36
            r2 = 1073741824(0x40000000, float:2.0)
            r5 = -1
            r10 = 0
            goto L_0x0061
        L_0x01fe:
            r32 = r3
            r36 = r4
            r2 = r21
            r4 = r22
            r10 = r23
            r6 = r25
            r1 = 1073741824(0x40000000, float:2.0)
            r9 = -2147483648(0xffffffff80000000, float:-0.0)
            r30 = -2
            int r3 = r7.f1182f
            if (r3 <= 0) goto L_0x0221
            boolean r3 = r7.c(r11)
            if (r3 == 0) goto L_0x0221
            int r3 = r7.f1182f
            int r1 = r7.f1188l
            int r3 = r3 + r1
            r7.f1182f = r3
        L_0x0221:
            r1 = r15[r18]
            r3 = -1
            if (r1 != r3) goto L_0x0238
            r1 = 0
            r5 = r15[r1]
            if (r5 != r3) goto L_0x0238
            r1 = r15[r17]
            if (r1 != r3) goto L_0x0238
            r1 = r15[r16]
            if (r1 == r3) goto L_0x0234
            goto L_0x0238
        L_0x0234:
            r1 = r2
            r23 = r6
            goto L_0x0269
        L_0x0238:
            r1 = r15[r16]
            r3 = 0
            r5 = r15[r3]
            r9 = r15[r18]
            r3 = r15[r17]
            int r3 = java.lang.Math.max(r9, r3)
            int r3 = java.lang.Math.max(r5, r3)
            int r1 = java.lang.Math.max(r1, r3)
            r3 = r28[r16]
            r5 = 0
            r9 = r28[r5]
            r5 = r28[r18]
            r23 = r6
            r6 = r28[r17]
            int r5 = java.lang.Math.max(r5, r6)
            int r5 = java.lang.Math.max(r9, r5)
            int r3 = java.lang.Math.max(r3, r5)
            int r1 = r1 + r3
            int r1 = java.lang.Math.max(r2, r1)
        L_0x0269:
            if (r32 == 0) goto L_0x02ca
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r12 == r2) goto L_0x0271
            if (r12 != 0) goto L_0x02ca
        L_0x0271:
            r2 = 0
            r7.f1182f = r2
            r2 = 0
        L_0x0275:
            if (r2 >= r11) goto L_0x02ca
            android.view.View r3 = r7.b((int) r2)
            if (r3 != 0) goto L_0x0287
            int r3 = r7.f1182f
            int r5 = r7.d(r2)
            int r3 = r3 + r5
            r7.f1182f = r3
            goto L_0x0294
        L_0x0287:
            int r5 = r3.getVisibility()
            r6 = 8
            if (r5 != r6) goto L_0x0297
            int r3 = r7.a((android.view.View) r3, (int) r2)
            int r2 = r2 + r3
        L_0x0294:
            r22 = r1
            goto L_0x02c5
        L_0x0297:
            android.view.ViewGroup$LayoutParams r5 = r3.getLayoutParams()
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r5 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r5
            int r6 = r7.f1182f
            if (r19 == 0) goto L_0x02b0
            int r9 = r5.leftMargin
            int r9 = r9 + r14
            int r5 = r5.rightMargin
            int r9 = r9 + r5
            int r3 = r7.b((android.view.View) r3)
            int r9 = r9 + r3
            int r6 = r6 + r9
            r7.f1182f = r6
            goto L_0x0294
        L_0x02b0:
            int r9 = r6 + r14
            r22 = r1
            int r1 = r5.leftMargin
            int r9 = r9 + r1
            int r1 = r5.rightMargin
            int r9 = r9 + r1
            int r1 = r7.b((android.view.View) r3)
            int r9 = r9 + r1
            int r1 = java.lang.Math.max(r6, r9)
            r7.f1182f = r1
        L_0x02c5:
            int r2 = r2 + 1
            r1 = r22
            goto L_0x0275
        L_0x02ca:
            r22 = r1
            int r1 = r7.f1182f
            int r2 = r37.getPaddingLeft()
            int r3 = r37.getPaddingRight()
            int r2 = r2 + r3
            int r1 = r1 + r2
            r7.f1182f = r1
            int r2 = r37.getSuggestedMinimumWidth()
            int r1 = java.lang.Math.max(r1, r2)
            r2 = 0
            int r1 = android.view.View.resolveSizeAndState(r1, r8, r2)
            r2 = 16777215(0xffffff, float:2.3509886E-38)
            r2 = r2 & r1
            int r3 = r7.f1182f
            int r2 = r2 - r3
            if (r24 != 0) goto L_0x033b
            if (r2 == 0) goto L_0x02f7
            int r5 = (r0 > r20 ? 1 : (r0 == r20 ? 0 : -1))
            if (r5 <= 0) goto L_0x02f7
            goto L_0x033b
        L_0x02f7:
            int r0 = java.lang.Math.max(r4, r10)
            if (r32 == 0) goto L_0x0333
            r2 = 1073741824(0x40000000, float:2.0)
            if (r12 == r2) goto L_0x0333
            r10 = 0
        L_0x0302:
            if (r10 >= r11) goto L_0x0333
            android.view.View r2 = r7.b((int) r10)
            if (r2 == 0) goto L_0x0330
            int r4 = r2.getVisibility()
            r5 = 8
            if (r4 != r5) goto L_0x0313
            goto L_0x0330
        L_0x0313:
            android.view.ViewGroup$LayoutParams r4 = r2.getLayoutParams()
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r4 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r4
            float r4 = r4.weight
            int r4 = (r4 > r20 ? 1 : (r4 == r20 ? 0 : -1))
            if (r4 <= 0) goto L_0x0330
            r4 = 1073741824(0x40000000, float:2.0)
            int r5 = android.view.View.MeasureSpec.makeMeasureSpec(r14, r4)
            int r6 = r2.getMeasuredHeight()
            int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r6, r4)
            r2.measure(r5, r6)
        L_0x0330:
            int r10 = r10 + 1
            goto L_0x0302
        L_0x0333:
            r2 = r39
            r25 = r11
            r3 = r22
            goto L_0x04cd
        L_0x033b:
            float r5 = r7.f1183g
            int r6 = (r5 > r20 ? 1 : (r5 == r20 ? 0 : -1))
            if (r6 <= 0) goto L_0x0342
            r0 = r5
        L_0x0342:
            r5 = -1
            r15[r16] = r5
            r15[r17] = r5
            r15[r18] = r5
            r6 = 0
            r15[r6] = r5
            r28[r16] = r5
            r28[r17] = r5
            r28[r18] = r5
            r28[r6] = r5
            r7.f1182f = r6
            r6 = r4
            r9 = r23
            r4 = -1
            r10 = 0
        L_0x035b:
            if (r10 >= r11) goto L_0x0474
            android.view.View r14 = r7.b((int) r10)
            if (r14 == 0) goto L_0x0465
            int r5 = r14.getVisibility()
            r3 = 8
            if (r5 != r3) goto L_0x036d
            goto L_0x0465
        L_0x036d:
            android.view.ViewGroup$LayoutParams r5 = r14.getLayoutParams()
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r5 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r5
            float r3 = r5.weight
            int r23 = (r3 > r20 ? 1 : (r3 == r20 ? 0 : -1))
            if (r23 <= 0) goto L_0x03cd
            float r8 = (float) r2
            float r8 = r8 * r3
            float r8 = r8 / r0
            int r8 = (int) r8
            float r0 = r0 - r3
            int r2 = r2 - r8
            int r3 = r37.getPaddingTop()
            int r23 = r37.getPaddingBottom()
            int r3 = r3 + r23
            r23 = r0
            int r0 = r5.topMargin
            int r3 = r3 + r0
            int r0 = r5.bottomMargin
            int r3 = r3 + r0
            int r0 = r5.height
            r24 = r2
            r25 = r11
            r11 = -1
            r2 = r39
            int r0 = getChildMeasureSpec(r2, r3, r0)
            int r3 = r5.width
            if (r3 != 0) goto L_0x03ab
            r3 = 1073741824(0x40000000, float:2.0)
            if (r12 == r3) goto L_0x03a8
            goto L_0x03ad
        L_0x03a8:
            if (r8 <= 0) goto L_0x03b5
            goto L_0x03b6
        L_0x03ab:
            r3 = 1073741824(0x40000000, float:2.0)
        L_0x03ad:
            int r29 = r14.getMeasuredWidth()
            int r8 = r29 + r8
            if (r8 >= 0) goto L_0x03b6
        L_0x03b5:
            r8 = 0
        L_0x03b6:
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r8, r3)
            r14.measure(r8, r0)
            int r0 = r14.getMeasuredState()
            r3 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r0 = r0 & r3
            int r9 = android.view.View.combineMeasuredStates(r9, r0)
            r0 = r23
            r3 = r24
            goto L_0x03d3
        L_0x03cd:
            r3 = r2
            r25 = r11
            r11 = -1
            r2 = r39
        L_0x03d3:
            int r8 = r7.f1182f
            if (r19 == 0) goto L_0x03f0
            int r23 = r14.getMeasuredWidth()
            int r11 = r5.leftMargin
            int r23 = r23 + r11
            int r11 = r5.rightMargin
            int r23 = r23 + r11
            int r11 = r7.b((android.view.View) r14)
            int r23 = r23 + r11
            int r8 = r8 + r23
            r7.f1182f = r8
            r23 = r0
            goto L_0x0408
        L_0x03f0:
            int r11 = r14.getMeasuredWidth()
            int r11 = r11 + r8
            r23 = r0
            int r0 = r5.leftMargin
            int r11 = r11 + r0
            int r0 = r5.rightMargin
            int r11 = r11 + r0
            int r0 = r7.b((android.view.View) r14)
            int r11 = r11 + r0
            int r0 = java.lang.Math.max(r8, r11)
            r7.f1182f = r0
        L_0x0408:
            r0 = 1073741824(0x40000000, float:2.0)
            if (r13 == r0) goto L_0x0413
            int r0 = r5.height
            r8 = -1
            if (r0 != r8) goto L_0x0413
            r0 = 1
            goto L_0x0414
        L_0x0413:
            r0 = 0
        L_0x0414:
            int r8 = r5.topMargin
            int r11 = r5.bottomMargin
            int r8 = r8 + r11
            int r11 = r14.getMeasuredHeight()
            int r11 = r11 + r8
            int r4 = java.lang.Math.max(r4, r11)
            if (r0 == 0) goto L_0x0425
            goto L_0x0426
        L_0x0425:
            r8 = r11
        L_0x0426:
            int r0 = java.lang.Math.max(r6, r8)
            if (r26 == 0) goto L_0x0433
            int r6 = r5.height
            r8 = -1
            if (r6 != r8) goto L_0x0434
            r6 = 1
            goto L_0x0435
        L_0x0433:
            r8 = -1
        L_0x0434:
            r6 = 0
        L_0x0435:
            if (r36 == 0) goto L_0x045f
            int r14 = r14.getBaseline()
            if (r14 == r8) goto L_0x045f
            int r8 = r5.gravity
            if (r8 >= 0) goto L_0x0444
            int r5 = r7.f1181e
            goto L_0x0446
        L_0x0444:
            int r5 = r5.gravity
        L_0x0446:
            r5 = r5 & 112(0x70, float:1.57E-43)
            r8 = 4
            int r5 = r5 >> r8
            r5 = r5 & -2
            int r5 = r5 >> 1
            r8 = r15[r5]
            int r8 = java.lang.Math.max(r8, r14)
            r15[r5] = r8
            r8 = r28[r5]
            int r11 = r11 - r14
            int r8 = java.lang.Math.max(r8, r11)
            r28[r5] = r8
        L_0x045f:
            r26 = r6
            r6 = r0
            r0 = r23
            goto L_0x046a
        L_0x0465:
            r3 = r2
            r25 = r11
            r2 = r39
        L_0x046a:
            int r10 = r10 + 1
            r8 = r38
            r2 = r3
            r11 = r25
            r5 = -1
            goto L_0x035b
        L_0x0474:
            r2 = r39
            r25 = r11
            int r0 = r7.f1182f
            int r3 = r37.getPaddingLeft()
            int r5 = r37.getPaddingRight()
            int r3 = r3 + r5
            int r0 = r0 + r3
            r7.f1182f = r0
            r0 = r15[r18]
            r3 = -1
            if (r0 != r3) goto L_0x049b
            r0 = 0
            r5 = r15[r0]
            if (r5 != r3) goto L_0x049b
            r0 = r15[r17]
            if (r0 != r3) goto L_0x049b
            r0 = r15[r16]
            if (r0 == r3) goto L_0x0499
            goto L_0x049b
        L_0x0499:
            r0 = r4
            goto L_0x04c9
        L_0x049b:
            r0 = r15[r16]
            r3 = 0
            r5 = r15[r3]
            r8 = r15[r18]
            r10 = r15[r17]
            int r8 = java.lang.Math.max(r8, r10)
            int r5 = java.lang.Math.max(r5, r8)
            int r0 = java.lang.Math.max(r0, r5)
            r5 = r28[r16]
            r3 = r28[r3]
            r8 = r28[r18]
            r10 = r28[r17]
            int r8 = java.lang.Math.max(r8, r10)
            int r3 = java.lang.Math.max(r3, r8)
            int r3 = java.lang.Math.max(r5, r3)
            int r0 = r0 + r3
            int r0 = java.lang.Math.max(r4, r0)
        L_0x04c9:
            r3 = r0
            r0 = r6
            r23 = r9
        L_0x04cd:
            if (r26 != 0) goto L_0x04d4
            r4 = 1073741824(0x40000000, float:2.0)
            if (r13 == r4) goto L_0x04d4
            goto L_0x04d5
        L_0x04d4:
            r0 = r3
        L_0x04d5:
            int r3 = r37.getPaddingTop()
            int r4 = r37.getPaddingBottom()
            int r3 = r3 + r4
            int r0 = r0 + r3
            int r3 = r37.getSuggestedMinimumHeight()
            int r0 = java.lang.Math.max(r0, r3)
            r3 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r3 = r23 & r3
            r1 = r1 | r3
            int r3 = r23 << 16
            int r0 = android.view.View.resolveSizeAndState(r0, r2, r3)
            r7.setMeasuredDimension(r1, r0)
            if (r27 == 0) goto L_0x04fe
            r0 = r38
            r1 = r25
            r7.d(r1, r0)
        L_0x04fe:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.b(int, int):void");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00f7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(int r25, int r26, int r27, int r28) {
        /*
            r24 = this;
            r6 = r24
            boolean r0 = androidx.appcompat.widget.al.a(r24)
            int r7 = r24.getPaddingTop()
            int r1 = r28 - r26
            int r2 = r24.getPaddingBottom()
            int r8 = r1 - r2
            int r1 = r1 - r7
            int r2 = r24.getPaddingBottom()
            int r9 = r1 - r2
            int r10 = r24.getVirtualChildCount()
            int r1 = r6.f1181e
            r2 = 8388615(0x800007, float:1.1754953E-38)
            r2 = r2 & r1
            r11 = r1 & 112(0x70, float:1.57E-43)
            boolean r12 = r6.f1177a
            int[] r13 = r6.f1185i
            int[] r14 = r6.f1186j
            int r1 = t.ac.i(r24)
            int r1 = t.f.a(r2, r1)
            r15 = 2
            r5 = 1
            if (r1 == r5) goto L_0x004b
            r2 = 5
            if (r1 == r2) goto L_0x003f
            int r1 = r24.getPaddingLeft()
            goto L_0x0056
        L_0x003f:
            int r1 = r24.getPaddingLeft()
            int r1 = r1 + r27
            int r1 = r1 - r25
            int r2 = r6.f1182f
            int r1 = r1 - r2
            goto L_0x0056
        L_0x004b:
            int r1 = r24.getPaddingLeft()
            int r2 = r27 - r25
            int r3 = r6.f1182f
            int r2 = r2 - r3
            int r2 = r2 / r15
            int r1 = r1 + r2
        L_0x0056:
            r2 = 0
            if (r0 == 0) goto L_0x0060
            int r0 = r10 + -1
            r16 = r0
            r17 = -1
            goto L_0x0064
        L_0x0060:
            r16 = 0
            r17 = 1
        L_0x0064:
            r3 = 0
        L_0x0065:
            if (r3 >= r10) goto L_0x013f
            int r0 = r17 * r3
            int r2 = r16 + r0
            android.view.View r0 = r6.b((int) r2)
            if (r0 != 0) goto L_0x0078
            int r0 = r6.d(r2)
            int r1 = r1 + r0
            goto L_0x0129
        L_0x0078:
            int r5 = r0.getVisibility()
            r15 = 8
            if (r5 == r15) goto L_0x0127
            int r15 = r0.getMeasuredWidth()
            int r5 = r0.getMeasuredHeight()
            android.view.ViewGroup$LayoutParams r18 = r0.getLayoutParams()
            r4 = r18
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r4 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r4
            r18 = r3
            if (r12 == 0) goto L_0x00a0
            int r3 = r4.height
            r19 = r10
            r10 = -1
            if (r3 == r10) goto L_0x00a2
            int r10 = r0.getBaseline()
            goto L_0x00a3
        L_0x00a0:
            r19 = r10
        L_0x00a2:
            r10 = -1
        L_0x00a3:
            int r3 = r4.gravity
            if (r3 >= 0) goto L_0x00a8
            r3 = r11
        L_0x00a8:
            r3 = r3 & 112(0x70, float:1.57E-43)
            r20 = r11
            r11 = 16
            if (r3 == r11) goto L_0x00e3
            r11 = 48
            if (r3 == r11) goto L_0x00d1
            r11 = 80
            if (r3 == r11) goto L_0x00bb
            r3 = r7
            r11 = -1
            goto L_0x00e0
        L_0x00bb:
            int r3 = r8 - r5
            int r11 = r4.bottomMargin
            int r3 = r3 - r11
            r11 = -1
            if (r10 == r11) goto L_0x00e0
            int r21 = r0.getMeasuredHeight()
            int r21 = r21 - r10
            r10 = 2
            r22 = r14[r10]
            int r22 = r22 - r21
            int r3 = r3 - r22
            goto L_0x00e0
        L_0x00d1:
            r11 = -1
            int r3 = r4.topMargin
            int r3 = r3 + r7
            if (r10 == r11) goto L_0x00e0
            r21 = 1
            r22 = r13[r21]
            int r22 = r22 - r10
            int r3 = r3 + r22
            goto L_0x00f1
        L_0x00e0:
            r21 = 1
            goto L_0x00f1
        L_0x00e3:
            r11 = -1
            r21 = 1
            int r3 = r9 - r5
            r10 = 2
            int r3 = r3 / r10
            int r3 = r3 + r7
            int r10 = r4.topMargin
            int r3 = r3 + r10
            int r10 = r4.bottomMargin
            int r3 = r3 - r10
        L_0x00f1:
            boolean r10 = r6.c(r2)
            if (r10 == 0) goto L_0x00fa
            int r10 = r6.f1188l
            int r1 = r1 + r10
        L_0x00fa:
            int r10 = r4.leftMargin
            int r10 = r10 + r1
            int r1 = r6.a((android.view.View) r0)
            int r22 = r10 + r1
            r1 = r0
            r0 = r24
            r25 = r1
            r11 = r2
            r2 = r22
            r22 = r7
            r23 = -1
            r7 = r4
            r4 = r15
            r0.a(r1, r2, r3, r4, r5)
            int r0 = r7.rightMargin
            int r15 = r15 + r0
            r0 = r25
            int r1 = r6.b((android.view.View) r0)
            int r15 = r15 + r1
            int r10 = r10 + r15
            int r0 = r6.a((android.view.View) r0, (int) r11)
            int r3 = r18 + r0
            r1 = r10
            goto L_0x0133
        L_0x0127:
            r18 = r3
        L_0x0129:
            r22 = r7
            r19 = r10
            r20 = r11
            r21 = 1
            r23 = -1
        L_0x0133:
            int r3 = r3 + 1
            r10 = r19
            r11 = r20
            r7 = r22
            r5 = 1
            r15 = 2
            goto L_0x0065
        L_0x013f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.b(int, int, int, int):void");
    }

    /* access modifiers changed from: package-private */
    public void b(Canvas canvas) {
        int i2;
        int i3;
        int i4;
        int virtualChildCount = getVirtualChildCount();
        boolean a2 = al.a(this);
        for (int i5 = 0; i5 < virtualChildCount; i5++) {
            View b2 = b(i5);
            if (!(b2 == null || b2.getVisibility() == 8 || !c(i5))) {
                LayoutParams layoutParams = (LayoutParams) b2.getLayoutParams();
                b(canvas, a2 ? b2.getRight() + layoutParams.rightMargin : (b2.getLeft() - layoutParams.leftMargin) - this.f1188l);
            }
        }
        if (c(virtualChildCount)) {
            View b3 = b(virtualChildCount - 1);
            if (b3 != null) {
                LayoutParams layoutParams2 = (LayoutParams) b3.getLayoutParams();
                if (a2) {
                    i4 = b3.getLeft();
                    i3 = layoutParams2.leftMargin;
                } else {
                    i2 = b3.getRight() + layoutParams2.rightMargin;
                    b(canvas, i2);
                }
            } else if (a2) {
                i2 = getPaddingLeft();
                b(canvas, i2);
            } else {
                i4 = getWidth();
                i3 = getPaddingRight();
            }
            i2 = (i4 - i3) - this.f1188l;
            b(canvas, i2);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(Canvas canvas, int i2) {
        this.f1187k.setBounds(i2, getPaddingTop() + this.f1191o, this.f1188l + i2, (getHeight() - getPaddingBottom()) - this.f1191o);
        this.f1187k.draw(canvas);
    }

    /* access modifiers changed from: protected */
    public boolean c(int i2) {
        if (i2 == 0) {
            return (this.f1190n & 1) != 0;
        }
        if (i2 == getChildCount()) {
            return (this.f1190n & 4) != 0;
        }
        if ((this.f1190n & 2) == 0) {
            return false;
        }
        for (int i3 = i2 - 1; i3 >= 0; i3--) {
            if (getChildAt(i3).getVisibility() != 8) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* access modifiers changed from: package-private */
    public int d(int i2) {
        return 0;
    }

    public int getBaseline() {
        int i2;
        if (this.f1178b < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i3 = this.f1178b;
        if (childCount > i3) {
            View childAt = getChildAt(i3);
            int baseline = childAt.getBaseline();
            if (baseline != -1) {
                int i4 = this.f1179c;
                if (this.f1180d == 1 && (i2 = this.f1181e & 112) != 48) {
                    if (i2 == 16) {
                        i4 += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f1182f) / 2;
                    } else if (i2 == 80) {
                        i4 = ((getBottom() - getTop()) - getPaddingBottom()) - this.f1182f;
                    }
                }
                return i4 + ((LayoutParams) childAt.getLayoutParams()).topMargin + baseline;
            } else if (this.f1178b == 0) {
                return -1;
            } else {
                throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
            }
        } else {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
    }

    public int getBaselineAlignedChildIndex() {
        return this.f1178b;
    }

    public Drawable getDividerDrawable() {
        return this.f1187k;
    }

    public int getDividerPadding() {
        return this.f1191o;
    }

    public int getDividerWidth() {
        return this.f1188l;
    }

    public int getGravity() {
        return this.f1181e;
    }

    public int getOrientation() {
        return this.f1180d;
    }

    public int getShowDividers() {
        return this.f1190n;
    }

    /* access modifiers changed from: package-private */
    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.f1183g;
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public LayoutParams generateDefaultLayoutParams() {
        int i2 = this.f1180d;
        if (i2 == 0) {
            return new LayoutParams(-2, -2);
        }
        if (i2 == 1) {
            return new LayoutParams(-1, -2);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.f1187k != null) {
            if (this.f1180d == 1) {
                a(canvas);
            } else {
                b(canvas);
            }
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        if (this.f1180d == 1) {
            a(i2, i3, i4, i5);
        } else {
            b(i2, i3, i4, i5);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        if (this.f1180d == 1) {
            a(i2, i3);
        } else {
            b(i2, i3);
        }
    }

    public void setBaselineAligned(boolean z2) {
        this.f1177a = z2;
    }

    public void setBaselineAlignedChildIndex(int i2) {
        if (i2 < 0 || i2 >= getChildCount()) {
            throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
        }
        this.f1178b = i2;
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable != this.f1187k) {
            this.f1187k = drawable;
            boolean z2 = false;
            if (drawable != null) {
                this.f1188l = drawable.getIntrinsicWidth();
                this.f1189m = drawable.getIntrinsicHeight();
            } else {
                this.f1188l = 0;
                this.f1189m = 0;
            }
            if (drawable == null) {
                z2 = true;
            }
            setWillNotDraw(z2);
            requestLayout();
        }
    }

    public void setDividerPadding(int i2) {
        this.f1191o = i2;
    }

    public void setGravity(int i2) {
        if (this.f1181e != i2) {
            if ((8388615 & i2) == 0) {
                i2 |= 8388611;
            }
            if ((i2 & 112) == 0) {
                i2 |= 48;
            }
            this.f1181e = i2;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i2) {
        int i3 = i2 & 8388615;
        int i4 = this.f1181e;
        if ((8388615 & i4) != i3) {
            this.f1181e = i3 | (-8388616 & i4);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z2) {
        this.f1184h = z2;
    }

    public void setOrientation(int i2) {
        if (this.f1180d != i2) {
            this.f1180d = i2;
            requestLayout();
        }
    }

    public void setShowDividers(int i2) {
        if (i2 != this.f1190n) {
            requestLayout();
        }
        this.f1190n = i2;
    }

    public void setVerticalGravity(int i2) {
        int i3 = i2 & 112;
        int i4 = this.f1181e;
        if ((i4 & 112) != i3) {
            this.f1181e = i3 | (i4 & -113);
            requestLayout();
        }
    }

    public void setWeightSum(float f2) {
        this.f1183g = Math.max(0.0f, f2);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
