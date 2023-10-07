package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import com.blankj.utilcode.constant.MemoryConstants;
import com.google.android.material.R;
import com.google.android.material.timepicker.ClockHandView;
import gt.c;
import java.util.Arrays;
import t.a;
import t.ac;
import u.c;

class ClockFaceView extends RadialViewGroup implements ClockHandView.b {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final ClockHandView f19888a;

    /* renamed from: b  reason: collision with root package name */
    private final Rect f19889b;

    /* renamed from: c  reason: collision with root package name */
    private final RectF f19890c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final SparseArray<TextView> f19891d;

    /* renamed from: e  reason: collision with root package name */
    private final a f19892e;

    /* renamed from: f  reason: collision with root package name */
    private final int[] f19893f;

    /* renamed from: g  reason: collision with root package name */
    private final float[] f19894g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final int f19895h;

    /* renamed from: i  reason: collision with root package name */
    private final int f19896i;

    /* renamed from: j  reason: collision with root package name */
    private final int f19897j;

    /* renamed from: k  reason: collision with root package name */
    private final int f19898k;

    /* renamed from: l  reason: collision with root package name */
    private String[] f19899l;

    /* renamed from: m  reason: collision with root package name */
    private float f19900m;

    /* renamed from: n  reason: collision with root package name */
    private final ColorStateList f19901n;

    public ClockFaceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialClockStyle);
    }

    public ClockFaceView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f19889b = new Rect();
        this.f19890c = new RectF();
        this.f19891d = new SparseArray<>();
        this.f19894g = new float[]{0.0f, 0.9f, 1.0f};
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ClockFaceView, i2, R.style.Widget_MaterialComponents_TimePicker_Clock);
        Resources resources = getResources();
        ColorStateList a2 = c.a(context, obtainStyledAttributes, R.styleable.ClockFaceView_clockNumberTextColor);
        this.f19901n = a2;
        LayoutInflater.from(context).inflate(R.layout.material_clockface_view, this, true);
        ClockHandView clockHandView = (ClockHandView) findViewById(R.id.material_clock_hand);
        this.f19888a = clockHandView;
        this.f19895h = resources.getDimensionPixelSize(R.dimen.material_clock_hand_padding);
        int colorForState = a2.getColorForState(new int[]{16842913}, a2.getDefaultColor());
        this.f19893f = new int[]{colorForState, colorForState, a2.getDefaultColor()};
        clockHandView.a((ClockHandView.b) this);
        int defaultColor = c.a.a(context, R.color.material_timepicker_clockface).getDefaultColor();
        ColorStateList a3 = c.a(context, obtainStyledAttributes, R.styleable.ClockFaceView_clockFaceBackgroundColor);
        setBackgroundColor(a3 != null ? a3.getDefaultColor() : defaultColor);
        getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            public boolean onPreDraw() {
                if (!ClockFaceView.this.isShown()) {
                    return true;
                }
                ClockFaceView.this.getViewTreeObserver().removeOnPreDrawListener(this);
                ClockFaceView.this.a(((ClockFaceView.this.getHeight() / 2) - ClockFaceView.this.f19888a.c()) - ClockFaceView.this.f19895h);
                return true;
            }
        });
        setFocusable(true);
        obtainStyledAttributes.recycle();
        this.f19892e = new a() {
            public void a(View view, u.c cVar) {
                super.a(view, cVar);
                int intValue = ((Integer) view.getTag(R.id.material_value_index)).intValue();
                if (intValue > 0) {
                    cVar.e((View) ClockFaceView.this.f19891d.get(intValue - 1));
                }
                cVar.b((Object) c.C0258c.a(0, 1, intValue, 1, false, view.isSelected()));
            }
        };
        String[] strArr = new String[12];
        Arrays.fill(strArr, "");
        a(strArr, 0);
        this.f19896i = resources.getDimensionPixelSize(R.dimen.material_time_picker_minimum_screen_height);
        this.f19897j = resources.getDimensionPixelSize(R.dimen.material_time_picker_minimum_screen_width);
        this.f19898k = resources.getDimensionPixelSize(R.dimen.material_clock_size);
    }

    private static float a(float f2, float f3, float f4) {
        return Math.max(Math.max(f2, f3), f4);
    }

    private RadialGradient a(RectF rectF, RectF rectF2) {
        if (!RectF.intersects(rectF, rectF2)) {
            return null;
        }
        return new RadialGradient(rectF.centerX() - this.f19890c.left, rectF.centerY() - this.f19890c.top, rectF.width() * 0.5f, this.f19893f, this.f19894g, Shader.TileMode.CLAMP);
    }

    private void c() {
        RectF b2 = this.f19888a.b();
        for (int i2 = 0; i2 < this.f19891d.size(); i2++) {
            TextView textView = this.f19891d.get(i2);
            if (textView != null) {
                textView.getDrawingRect(this.f19889b);
                this.f19889b.offset(textView.getPaddingLeft(), textView.getPaddingTop());
                offsetDescendantRectToMyCoords(textView, this.f19889b);
                this.f19890c.set(this.f19889b);
                textView.getPaint().setShader(a(b2, this.f19890c));
                textView.invalidate();
            }
        }
    }

    private void c(int i2) {
        LayoutInflater from = LayoutInflater.from(getContext());
        int size = this.f19891d.size();
        for (int i3 = 0; i3 < Math.max(this.f19899l.length, size); i3++) {
            TextView textView = this.f19891d.get(i3);
            if (i3 >= this.f19899l.length) {
                removeView(textView);
                this.f19891d.remove(i3);
            } else {
                if (textView == null) {
                    textView = (TextView) from.inflate(R.layout.material_clockface_textview, this, false);
                    this.f19891d.put(i3, textView);
                    addView(textView);
                }
                textView.setVisibility(0);
                textView.setText(this.f19899l[i3]);
                textView.setTag(R.id.material_value_index, Integer.valueOf(i3));
                ac.a((View) textView, this.f19892e);
                textView.setTextColor(this.f19901n);
                if (i2 != 0) {
                    textView.setContentDescription(getResources().getString(i2, new Object[]{this.f19899l[i3]}));
                }
            }
        }
    }

    public void a(float f2, boolean z2) {
        if (Math.abs(this.f19900m - f2) > 0.001f) {
            this.f19900m = f2;
            c();
        }
    }

    public void a(int i2) {
        if (i2 != b()) {
            super.a(i2);
            this.f19888a.a(b());
        }
    }

    public void a(String[] strArr, int i2) {
        this.f19899l = strArr;
        c(i2);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        u.c.a(accessibilityNodeInfo).a((Object) c.b.a(1, this.f19899l.length, false, 1));
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        c();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int a2 = (int) (((float) this.f19898k) / a(((float) this.f19896i) / ((float) displayMetrics.heightPixels), ((float) this.f19897j) / ((float) displayMetrics.widthPixels), 1.0f));
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(a2, MemoryConstants.GB);
        setMeasuredDimension(a2, a2);
        super.onMeasure(makeMeasureSpec, makeMeasureSpec);
    }
}
