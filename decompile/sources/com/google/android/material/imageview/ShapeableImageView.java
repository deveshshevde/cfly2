package com.google.android.material.imageview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.appcompat.widget.AppCompatImageView;
import com.google.android.material.R;
import gw.h;
import gw.m;
import gw.n;
import gw.p;

public class ShapeableImageView extends AppCompatImageView implements p {

    /* renamed from: a  reason: collision with root package name */
    private static final int f19158a = R.style.Widget_MaterialComponents_ShapeableImageView;

    /* renamed from: b  reason: collision with root package name */
    private final n f19159b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final RectF f19160c;

    /* renamed from: d  reason: collision with root package name */
    private final RectF f19161d;

    /* renamed from: e  reason: collision with root package name */
    private final Paint f19162e;

    /* renamed from: f  reason: collision with root package name */
    private final Paint f19163f;

    /* renamed from: g  reason: collision with root package name */
    private final Path f19164g;

    /* renamed from: h  reason: collision with root package name */
    private ColorStateList f19165h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public h f19166i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public m f19167j;

    /* renamed from: k  reason: collision with root package name */
    private float f19168k;

    /* renamed from: l  reason: collision with root package name */
    private Path f19169l;

    /* renamed from: m  reason: collision with root package name */
    private int f19170m;

    /* renamed from: n  reason: collision with root package name */
    private int f19171n;

    /* renamed from: o  reason: collision with root package name */
    private int f19172o;

    /* renamed from: p  reason: collision with root package name */
    private int f19173p;

    /* renamed from: q  reason: collision with root package name */
    private int f19174q;

    /* renamed from: r  reason: collision with root package name */
    private int f19175r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f19176s;

    class a extends ViewOutlineProvider {

        /* renamed from: b  reason: collision with root package name */
        private final Rect f19178b = new Rect();

        a() {
        }

        public void getOutline(View view, Outline outline) {
            if (ShapeableImageView.this.f19167j != null) {
                if (ShapeableImageView.this.f19166i == null) {
                    h unused = ShapeableImageView.this.f19166i = new h(ShapeableImageView.this.f19167j);
                }
                ShapeableImageView.this.f19160c.round(this.f19178b);
                ShapeableImageView.this.f19166i.setBounds(this.f19178b);
                ShapeableImageView.this.f19166i.getOutline(outline);
            }
        }
    }

    public ShapeableImageView(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    public ShapeableImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ShapeableImageView(android.content.Context r7, android.util.AttributeSet r8, int r9) {
        /*
            r6 = this;
            int r0 = f19158a
            android.content.Context r7 = gx.a.a(r7, r8, r9, r0)
            r6.<init>(r7, r8, r9)
            gw.n r7 = gw.n.a()
            r6.f19159b = r7
            android.graphics.Path r7 = new android.graphics.Path
            r7.<init>()
            r6.f19164g = r7
            r7 = 0
            r6.f19176s = r7
            android.content.Context r1 = r6.getContext()
            android.graphics.Paint r2 = new android.graphics.Paint
            r2.<init>()
            r6.f19163f = r2
            r3 = 1
            r2.setAntiAlias(r3)
            r4 = -1
            r2.setColor(r4)
            android.graphics.PorterDuffXfermode r4 = new android.graphics.PorterDuffXfermode
            android.graphics.PorterDuff$Mode r5 = android.graphics.PorterDuff.Mode.DST_OUT
            r4.<init>(r5)
            r2.setXfermode(r4)
            android.graphics.RectF r2 = new android.graphics.RectF
            r2.<init>()
            r6.f19160c = r2
            android.graphics.RectF r2 = new android.graphics.RectF
            r2.<init>()
            r6.f19161d = r2
            android.graphics.Path r2 = new android.graphics.Path
            r2.<init>()
            r6.f19169l = r2
            int[] r2 = com.google.android.material.R.styleable.ShapeableImageView
            android.content.res.TypedArray r2 = r1.obtainStyledAttributes(r8, r2, r9, r0)
            int r4 = com.google.android.material.R.styleable.ShapeableImageView_strokeColor
            android.content.res.ColorStateList r4 = gt.c.a((android.content.Context) r1, (android.content.res.TypedArray) r2, (int) r4)
            r6.f19165h = r4
            int r4 = com.google.android.material.R.styleable.ShapeableImageView_strokeWidth
            int r4 = r2.getDimensionPixelSize(r4, r7)
            float r4 = (float) r4
            r6.f19168k = r4
            int r4 = com.google.android.material.R.styleable.ShapeableImageView_contentPadding
            int r7 = r2.getDimensionPixelSize(r4, r7)
            r6.f19170m = r7
            r6.f19171n = r7
            r6.f19172o = r7
            r6.f19173p = r7
            int r4 = com.google.android.material.R.styleable.ShapeableImageView_contentPaddingLeft
            int r4 = r2.getDimensionPixelSize(r4, r7)
            r6.f19170m = r4
            int r4 = com.google.android.material.R.styleable.ShapeableImageView_contentPaddingTop
            int r4 = r2.getDimensionPixelSize(r4, r7)
            r6.f19171n = r4
            int r4 = com.google.android.material.R.styleable.ShapeableImageView_contentPaddingRight
            int r4 = r2.getDimensionPixelSize(r4, r7)
            r6.f19172o = r4
            int r4 = com.google.android.material.R.styleable.ShapeableImageView_contentPaddingBottom
            int r7 = r2.getDimensionPixelSize(r4, r7)
            r6.f19173p = r7
            int r7 = com.google.android.material.R.styleable.ShapeableImageView_contentPaddingStart
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            int r7 = r2.getDimensionPixelSize(r7, r4)
            r6.f19174q = r7
            int r7 = com.google.android.material.R.styleable.ShapeableImageView_contentPaddingEnd
            int r7 = r2.getDimensionPixelSize(r7, r4)
            r6.f19175r = r7
            r2.recycle()
            android.graphics.Paint r7 = new android.graphics.Paint
            r7.<init>()
            r6.f19162e = r7
            android.graphics.Paint$Style r2 = android.graphics.Paint.Style.STROKE
            r7.setStyle(r2)
            r7.setAntiAlias(r3)
            gw.m$a r7 = gw.m.a((android.content.Context) r1, (android.util.AttributeSet) r8, (int) r9, (int) r0)
            gw.m r7 = r7.a()
            r6.f19167j = r7
            int r7 = android.os.Build.VERSION.SDK_INT
            r8 = 21
            if (r7 < r8) goto L_0x00cc
            com.google.android.material.imageview.ShapeableImageView$a r7 = new com.google.android.material.imageview.ShapeableImageView$a
            r7.<init>()
            r6.setOutlineProvider(r7)
        L_0x00cc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.imageview.ShapeableImageView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    private void a(int i2, int i3) {
        this.f19160c.set((float) getPaddingLeft(), (float) getPaddingTop(), (float) (i2 - getPaddingRight()), (float) (i3 - getPaddingBottom()));
        this.f19159b.a(this.f19167j, 1.0f, this.f19160c, this.f19164g);
        this.f19169l.rewind();
        this.f19169l.addPath(this.f19164g);
        this.f19161d.set(0.0f, 0.0f, (float) i2, (float) i3);
        this.f19169l.addRect(this.f19161d, Path.Direction.CCW);
    }

    private void a(Canvas canvas) {
        if (this.f19165h != null) {
            this.f19162e.setStrokeWidth(this.f19168k);
            int colorForState = this.f19165h.getColorForState(getDrawableState(), this.f19165h.getDefaultColor());
            if (this.f19168k > 0.0f && colorForState != 0) {
                this.f19162e.setColor(colorForState);
                canvas.drawPath(this.f19164g, this.f19162e);
            }
        }
    }

    private boolean a() {
        return (this.f19174q == Integer.MIN_VALUE && this.f19175r == Integer.MIN_VALUE) ? false : true;
    }

    private boolean b() {
        return Build.VERSION.SDK_INT >= 17 && getLayoutDirection() == 1;
    }

    public int getContentPaddingBottom() {
        return this.f19173p;
    }

    public final int getContentPaddingEnd() {
        int i2 = this.f19175r;
        return i2 != Integer.MIN_VALUE ? i2 : b() ? this.f19170m : this.f19172o;
    }

    public int getContentPaddingLeft() {
        int i2;
        int i3;
        if (a()) {
            if (b() && (i3 = this.f19175r) != Integer.MIN_VALUE) {
                return i3;
            }
            if (!b() && (i2 = this.f19174q) != Integer.MIN_VALUE) {
                return i2;
            }
        }
        return this.f19170m;
    }

    public int getContentPaddingRight() {
        int i2;
        int i3;
        if (a()) {
            if (b() && (i3 = this.f19174q) != Integer.MIN_VALUE) {
                return i3;
            }
            if (!b() && (i2 = this.f19175r) != Integer.MIN_VALUE) {
                return i2;
            }
        }
        return this.f19172o;
    }

    public final int getContentPaddingStart() {
        int i2 = this.f19174q;
        return i2 != Integer.MIN_VALUE ? i2 : b() ? this.f19172o : this.f19170m;
    }

    public int getContentPaddingTop() {
        return this.f19171n;
    }

    public int getPaddingBottom() {
        return super.getPaddingBottom() - getContentPaddingBottom();
    }

    public int getPaddingEnd() {
        return super.getPaddingEnd() - getContentPaddingEnd();
    }

    public int getPaddingLeft() {
        return super.getPaddingLeft() - getContentPaddingLeft();
    }

    public int getPaddingRight() {
        return super.getPaddingRight() - getContentPaddingRight();
    }

    public int getPaddingStart() {
        return super.getPaddingStart() - getContentPaddingStart();
    }

    public int getPaddingTop() {
        return super.getPaddingTop() - getContentPaddingTop();
    }

    public m getShapeAppearanceModel() {
        return this.f19167j;
    }

    public ColorStateList getStrokeColor() {
        return this.f19165h;
    }

    public float getStrokeWidth() {
        return this.f19168k;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setLayerType(2, (Paint) null);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        setLayerType(0, (Paint) null);
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.f19169l, this.f19163f);
        a(canvas);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (!this.f19176s) {
            if (Build.VERSION.SDK_INT <= 19 || isLayoutDirectionResolved()) {
                this.f19176s = true;
                if (Build.VERSION.SDK_INT < 21 || (!isPaddingRelative() && !a())) {
                    setPadding(super.getPaddingLeft(), super.getPaddingTop(), super.getPaddingRight(), super.getPaddingBottom());
                } else {
                    setPaddingRelative(super.getPaddingStart(), super.getPaddingTop(), super.getPaddingEnd(), super.getPaddingBottom());
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        a(i2, i3);
    }

    public void setPadding(int i2, int i3, int i4, int i5) {
        super.setPadding(i2 + getContentPaddingLeft(), i3 + getContentPaddingTop(), i4 + getContentPaddingRight(), i5 + getContentPaddingBottom());
    }

    public void setPaddingRelative(int i2, int i3, int i4, int i5) {
        super.setPaddingRelative(i2 + getContentPaddingStart(), i3 + getContentPaddingTop(), i4 + getContentPaddingEnd(), i5 + getContentPaddingBottom());
    }

    public void setShapeAppearanceModel(m mVar) {
        this.f19167j = mVar;
        h hVar = this.f19166i;
        if (hVar != null) {
            hVar.setShapeAppearanceModel(mVar);
        }
        a(getWidth(), getHeight());
        invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        this.f19165h = colorStateList;
        invalidate();
    }

    public void setStrokeColorResource(int i2) {
        setStrokeColor(c.a.a(getContext(), i2));
    }

    public void setStrokeWidth(float f2) {
        if (this.f19168k != f2) {
            this.f19168k = f2;
            invalidate();
        }
    }

    public void setStrokeWidthResource(int i2) {
        setStrokeWidth((float) getResources().getDimensionPixelSize(i2));
    }
}
