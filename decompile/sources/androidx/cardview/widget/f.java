package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

class f extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    private float f1640a;

    /* renamed from: b  reason: collision with root package name */
    private final Paint f1641b;

    /* renamed from: c  reason: collision with root package name */
    private final RectF f1642c;

    /* renamed from: d  reason: collision with root package name */
    private final Rect f1643d;

    /* renamed from: e  reason: collision with root package name */
    private float f1644e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f1645f = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f1646g = true;

    /* renamed from: h  reason: collision with root package name */
    private ColorStateList f1647h;

    /* renamed from: i  reason: collision with root package name */
    private PorterDuffColorFilter f1648i;

    /* renamed from: j  reason: collision with root package name */
    private ColorStateList f1649j;

    /* renamed from: k  reason: collision with root package name */
    private PorterDuff.Mode f1650k = PorterDuff.Mode.SRC_IN;

    f(ColorStateList colorStateList, float f2) {
        this.f1640a = f2;
        this.f1641b = new Paint(5);
        b(colorStateList);
        this.f1642c = new RectF();
        this.f1643d = new Rect();
    }

    private PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    private void a(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.f1642c.set((float) rect.left, (float) rect.top, (float) rect.right, (float) rect.bottom);
        this.f1643d.set(rect);
        if (this.f1645f) {
            float a2 = g.a(this.f1644e, this.f1640a, this.f1646g);
            this.f1643d.inset((int) Math.ceil((double) g.b(this.f1644e, this.f1640a, this.f1646g)), (int) Math.ceil((double) a2));
            this.f1642c.set(this.f1643d);
        }
    }

    private void b(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f1647h = colorStateList;
        this.f1641b.setColor(colorStateList.getColorForState(getState(), this.f1647h.getDefaultColor()));
    }

    /* access modifiers changed from: package-private */
    public float a() {
        return this.f1644e;
    }

    /* access modifiers changed from: package-private */
    public void a(float f2) {
        if (f2 != this.f1640a) {
            this.f1640a = f2;
            a((Rect) null);
            invalidateSelf();
        }
    }

    /* access modifiers changed from: package-private */
    public void a(float f2, boolean z2, boolean z3) {
        if (f2 != this.f1644e || this.f1645f != z2 || this.f1646g != z3) {
            this.f1644e = f2;
            this.f1645f = z2;
            this.f1646g = z3;
            a((Rect) null);
            invalidateSelf();
        }
    }

    public void a(ColorStateList colorStateList) {
        b(colorStateList);
        invalidateSelf();
    }

    public float b() {
        return this.f1640a;
    }

    public ColorStateList c() {
        return this.f1647h;
    }

    public void draw(Canvas canvas) {
        boolean z2;
        Paint paint = this.f1641b;
        if (this.f1648i == null || paint.getColorFilter() != null) {
            z2 = false;
        } else {
            paint.setColorFilter(this.f1648i);
            z2 = true;
        }
        RectF rectF = this.f1642c;
        float f2 = this.f1640a;
        canvas.drawRoundRect(rectF, f2, f2, paint);
        if (z2) {
            paint.setColorFilter((ColorFilter) null);
        }
    }

    public int getOpacity() {
        return -3;
    }

    public void getOutline(Outline outline) {
        outline.setRoundRect(this.f1643d, this.f1640a);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = r1.f1647h;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isStateful() {
        /*
            r1 = this;
            android.content.res.ColorStateList r0 = r1.f1649j
            if (r0 == 0) goto L_0x000a
            boolean r0 = r0.isStateful()
            if (r0 != 0) goto L_0x001a
        L_0x000a:
            android.content.res.ColorStateList r0 = r1.f1647h
            if (r0 == 0) goto L_0x0014
            boolean r0 = r0.isStateful()
            if (r0 != 0) goto L_0x001a
        L_0x0014:
            boolean r0 = super.isStateful()
            if (r0 == 0) goto L_0x001c
        L_0x001a:
            r0 = 1
            goto L_0x001d
        L_0x001c:
            r0 = 0
        L_0x001d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.cardview.widget.f.isStateful():boolean");
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        a(rect);
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f1647h;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        boolean z2 = colorForState != this.f1641b.getColor();
        if (z2) {
            this.f1641b.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.f1649j;
        if (colorStateList2 == null || (mode = this.f1650k) == null) {
            return z2;
        }
        this.f1648i = a(colorStateList2, mode);
        return true;
    }

    public void setAlpha(int i2) {
        this.f1641b.setAlpha(i2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f1641b.setColorFilter(colorFilter);
    }

    public void setTintList(ColorStateList colorStateList) {
        this.f1649j = colorStateList;
        this.f1648i = a(colorStateList, this.f1650k);
        invalidateSelf();
    }

    public void setTintMode(PorterDuff.Mode mode) {
        this.f1650k = mode;
        this.f1648i = a(this.f1649j, mode);
        invalidateSelf();
    }
}
