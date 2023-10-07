package gy;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.google.android.material.R;
import com.google.android.material.internal.i;
import com.google.android.material.internal.l;
import gt.c;
import gt.d;
import gw.f;
import gw.g;
import gw.h;
import gw.j;

public class a extends h implements i.a {

    /* renamed from: a  reason: collision with root package name */
    private static final int f13265a = R.style.Widget_MaterialComponents_Tooltip;

    /* renamed from: b  reason: collision with root package name */
    private static final int f13266b = R.attr.tooltipStyle;

    /* renamed from: c  reason: collision with root package name */
    private CharSequence f13267c;

    /* renamed from: d  reason: collision with root package name */
    private final Context f13268d;

    /* renamed from: e  reason: collision with root package name */
    private final Paint.FontMetrics f13269e = new Paint.FontMetrics();

    /* renamed from: f  reason: collision with root package name */
    private final i f13270f;

    /* renamed from: g  reason: collision with root package name */
    private final View.OnLayoutChangeListener f13271g;

    /* renamed from: h  reason: collision with root package name */
    private final Rect f13272h;

    /* renamed from: i  reason: collision with root package name */
    private int f13273i;

    /* renamed from: j  reason: collision with root package name */
    private int f13274j;

    /* renamed from: k  reason: collision with root package name */
    private int f13275k;

    /* renamed from: l  reason: collision with root package name */
    private int f13276l;

    /* renamed from: m  reason: collision with root package name */
    private int f13277m;

    /* renamed from: n  reason: collision with root package name */
    private int f13278n;

    /* renamed from: o  reason: collision with root package name */
    private float f13279o;

    /* renamed from: p  reason: collision with root package name */
    private float f13280p;

    /* renamed from: q  reason: collision with root package name */
    private final float f13281q;

    /* renamed from: r  reason: collision with root package name */
    private float f13282r;

    /* renamed from: s  reason: collision with root package name */
    private float f13283s;

    private a(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        i iVar = new i(this);
        this.f13270f = iVar;
        this.f13271g = new View.OnLayoutChangeListener() {
            public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                a.this.c(view);
            }
        };
        this.f13272h = new Rect();
        this.f13279o = 1.0f;
        this.f13280p = 1.0f;
        this.f13281q = 0.5f;
        this.f13282r = 0.5f;
        this.f13283s = 1.0f;
        this.f13268d = context;
        iVar.a().density = context.getResources().getDisplayMetrics().density;
        iVar.a().setTextAlign(Paint.Align.CENTER);
    }

    private float a() {
        int i2;
        if (((this.f13272h.right - getBounds().right) - this.f13278n) - this.f13276l < 0) {
            i2 = ((this.f13272h.right - getBounds().right) - this.f13278n) - this.f13276l;
        } else if (((this.f13272h.left - getBounds().left) - this.f13278n) + this.f13276l <= 0) {
            return 0.0f;
        } else {
            i2 = ((this.f13272h.left - getBounds().left) - this.f13278n) + this.f13276l;
        }
        return (float) i2;
    }

    private float a(Rect rect) {
        return ((float) rect.centerY()) - d();
    }

    public static a a(Context context, AttributeSet attributeSet, int i2, int i3) {
        a aVar = new a(context, attributeSet, i2, i3);
        aVar.a(attributeSet, i2, i3);
        return aVar;
    }

    private void a(Canvas canvas) {
        if (this.f13267c != null) {
            Rect bounds = getBounds();
            int a2 = (int) a(bounds);
            if (this.f13270f.b() != null) {
                this.f13270f.a().drawableState = getState();
                this.f13270f.a(this.f13268d);
                this.f13270f.a().setAlpha((int) (this.f13283s * 255.0f));
            }
            CharSequence charSequence = this.f13267c;
            canvas.drawText(charSequence, 0, charSequence.length(), (float) bounds.centerX(), (float) a2, this.f13270f.a());
        }
    }

    private void a(AttributeSet attributeSet, int i2, int i3) {
        Class<a> cls = a.class;
        TypedArray a2 = l.a(this.f13268d, attributeSet, R.styleable.Tooltip, i2, i3, new int[0]);
        this.f13277m = this.f13268d.getResources().getDimensionPixelSize(R.dimen.mtrl_tooltip_arrowSize);
        setShapeAppearanceModel(M().n().b(b()).a());
        a(a2.getText(R.styleable.Tooltip_android_text));
        a(c.c(this.f13268d, a2, R.styleable.Tooltip_android_textAppearance));
        g(ColorStateList.valueOf(a2.getColor(R.styleable.Tooltip_backgroundTint, gn.a.a(m.a.b(gn.a.a(this.f13268d, 16842801, cls.getCanonicalName()), 229), m.a.b(gn.a.a(this.f13268d, R.attr.colorOnBackground, cls.getCanonicalName()), 153)))));
        h(ColorStateList.valueOf(gn.a.a(this.f13268d, R.attr.colorSurface, cls.getCanonicalName())));
        this.f13273i = a2.getDimensionPixelSize(R.styleable.Tooltip_android_padding, 0);
        this.f13274j = a2.getDimensionPixelSize(R.styleable.Tooltip_android_minWidth, 0);
        this.f13275k = a2.getDimensionPixelSize(R.styleable.Tooltip_android_minHeight, 0);
        this.f13276l = a2.getDimensionPixelSize(R.styleable.Tooltip_android_layout_margin, 0);
        a2.recycle();
    }

    private f b() {
        double width = (double) getBounds().width();
        double d2 = (double) this.f13277m;
        double sqrt = Math.sqrt(2.0d);
        Double.isNaN(d2);
        Double.isNaN(width);
        float f2 = ((float) (width - (d2 * sqrt))) / 2.0f;
        return new j(new g((float) this.f13277m), Math.min(Math.max(-a(), -f2), f2));
    }

    private float c() {
        CharSequence charSequence = this.f13267c;
        if (charSequence == null) {
            return 0.0f;
        }
        return this.f13270f.a(charSequence.toString());
    }

    /* access modifiers changed from: private */
    public void c(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        this.f13278n = iArr[0];
        view.getWindowVisibleDisplayFrame(this.f13272h);
    }

    private float d() {
        this.f13270f.a().getFontMetrics(this.f13269e);
        return (this.f13269e.descent + this.f13269e.ascent) / 2.0f;
    }

    public void a(float f2) {
        this.f13282r = 1.2f;
        this.f13279o = f2;
        this.f13280p = f2;
        this.f13283s = gl.a.a(0.0f, 1.0f, 0.19f, 1.0f, f2);
        invalidateSelf();
    }

    public void a(View view) {
        if (view != null) {
            c(view);
            view.addOnLayoutChangeListener(this.f13271g);
        }
    }

    public void a(d dVar) {
        this.f13270f.a(dVar, this.f13268d);
    }

    public void a(CharSequence charSequence) {
        if (!TextUtils.equals(this.f13267c, charSequence)) {
            this.f13267c = charSequence;
            this.f13270f.a(true);
            invalidateSelf();
        }
    }

    public void b(View view) {
        if (view != null) {
            view.removeOnLayoutChangeListener(this.f13271g);
        }
    }

    public void draw(Canvas canvas) {
        canvas.save();
        float a2 = a();
        double d2 = (double) this.f13277m;
        double sqrt = Math.sqrt(2.0d);
        Double.isNaN(d2);
        double d3 = d2 * sqrt;
        double d4 = (double) this.f13277m;
        Double.isNaN(d4);
        canvas.scale(this.f13279o, this.f13280p, ((float) getBounds().left) + (((float) getBounds().width()) * 0.5f), ((float) getBounds().top) + (((float) getBounds().height()) * this.f13282r));
        canvas.translate(a2, (float) (-(d3 - d4)));
        super.draw(canvas);
        a(canvas);
        canvas.restore();
    }

    public void f() {
        invalidateSelf();
    }

    public int getIntrinsicHeight() {
        return (int) Math.max(this.f13270f.a().getTextSize(), (float) this.f13275k);
    }

    public int getIntrinsicWidth() {
        return (int) Math.max(((float) (this.f13273i * 2)) + c(), (float) this.f13274j);
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        setShapeAppearanceModel(M().n().b(b()).a());
    }

    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }
}
