package com.google.android.material.chip;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import com.amap.api.mapcore.util.fx;
import com.google.android.material.R;
import com.google.android.material.chip.a;
import com.google.android.material.internal.l;
import com.google.android.material.internal.s;
import gl.h;
import gt.d;
import gt.f;
import gu.b;
import gw.i;
import gw.m;
import gw.p;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import t.ac;
import u.c;

public class Chip extends AppCompatCheckBox implements a.C0127a, p {

    /* renamed from: a  reason: collision with root package name */
    private static final int f18768a = R.style.Widget_MaterialComponents_Chip_Action;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final Rect f18769b = new Rect();

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f18770c = {16842913};

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f18771d = {16842911};
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public a f18772e;

    /* renamed from: f  reason: collision with root package name */
    private InsetDrawable f18773f;

    /* renamed from: g  reason: collision with root package name */
    private RippleDrawable f18774g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f18775h;

    /* renamed from: i  reason: collision with root package name */
    private CompoundButton.OnCheckedChangeListener f18776i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f18777j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f18778k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f18779l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public boolean f18780m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f18781n;

    /* renamed from: o  reason: collision with root package name */
    private int f18782o;

    /* renamed from: p  reason: collision with root package name */
    private int f18783p;

    /* renamed from: q  reason: collision with root package name */
    private final a f18784q;

    /* renamed from: r  reason: collision with root package name */
    private final Rect f18785r;

    /* renamed from: s  reason: collision with root package name */
    private final RectF f18786s;

    /* renamed from: t  reason: collision with root package name */
    private final f f18787t;

    private class a extends x.a {
        a(Chip chip) {
            super(chip);
        }

        /* access modifiers changed from: protected */
        public int a(float f2, float f3) {
            return (!Chip.this.n() || !Chip.this.getCloseIconTouchBounds().contains(f2, f3)) ? 0 : 1;
        }

        /* access modifiers changed from: protected */
        public void a(int i2, c cVar) {
            CharSequence charSequence = "";
            if (i2 == 1) {
                CharSequence closeIconContentDescription = Chip.this.getCloseIconContentDescription();
                if (closeIconContentDescription == null) {
                    CharSequence text = Chip.this.getText();
                    Context context = Chip.this.getContext();
                    int i3 = R.string.mtrl_chip_close_icon_content_description;
                    Object[] objArr = new Object[1];
                    if (!TextUtils.isEmpty(text)) {
                        charSequence = text;
                    }
                    objArr[0] = charSequence;
                    closeIconContentDescription = context.getString(i3, objArr).trim();
                }
                cVar.e(closeIconContentDescription);
                cVar.b(Chip.this.getCloseIconTouchBoundsInt());
                cVar.a(c.a.f34535e);
                cVar.j(Chip.this.isEnabled());
                return;
            }
            cVar.e(charSequence);
            cVar.b(Chip.f18769b);
        }

        /* access modifiers changed from: protected */
        public void a(int i2, boolean z2) {
            if (i2 == 1) {
                boolean unused = Chip.this.f18780m = z2;
                Chip.this.refreshDrawableState();
            }
        }

        /* access modifiers changed from: protected */
        public void a(List<Integer> list) {
            list.add(0);
            if (Chip.this.n() && Chip.this.c() && Chip.this.f18775h != null) {
                list.add(1);
            }
        }

        /* access modifiers changed from: protected */
        public void a(c cVar) {
            cVar.a(Chip.this.d());
            cVar.h(Chip.this.isClickable());
            cVar.b((CharSequence) (Chip.this.d() || Chip.this.isClickable()) ? Chip.this.d() ? "android.widget.CompoundButton" : "android.widget.Button" : "android.view.View");
            CharSequence text = Chip.this.getText();
            if (Build.VERSION.SDK_INT >= 23) {
                cVar.c(text);
            } else {
                cVar.e(text);
            }
        }

        /* access modifiers changed from: protected */
        public boolean b(int i2, int i3, Bundle bundle) {
            if (i3 != 16) {
                return false;
            }
            if (i2 == 0) {
                return Chip.this.performClick();
            }
            if (i2 == 1) {
                return Chip.this.b();
            }
            return false;
        }
    }

    public Chip(Context context) {
        this(context, (AttributeSet) null);
    }

    public Chip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.chipStyle);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Chip(android.content.Context r8, android.util.AttributeSet r9, int r10) {
        /*
            r7 = this;
            int r4 = f18768a
            android.content.Context r8 = gx.a.a(r8, r9, r10, r4)
            r7.<init>(r8, r9, r10)
            android.graphics.Rect r8 = new android.graphics.Rect
            r8.<init>()
            r7.f18785r = r8
            android.graphics.RectF r8 = new android.graphics.RectF
            r8.<init>()
            r7.f18786s = r8
            com.google.android.material.chip.Chip$1 r8 = new com.google.android.material.chip.Chip$1
            r8.<init>()
            r7.f18787t = r8
            android.content.Context r8 = r7.getContext()
            r7.a((android.util.AttributeSet) r9)
            com.google.android.material.chip.a r6 = com.google.android.material.chip.a.a(r8, r9, r10, r4)
            r7.a(r8, r9, r10)
            r7.setChipDrawable(r6)
            float r0 = t.ac.s(r7)
            r6.r(r0)
            int[] r2 = com.google.android.material.R.styleable.Chip
            r0 = 0
            int[] r5 = new int[r0]
            r0 = r8
            r1 = r9
            r3 = r10
            android.content.res.TypedArray r9 = com.google.android.material.internal.l.a(r0, r1, r2, r3, r4, r5)
            int r10 = android.os.Build.VERSION.SDK_INT
            r0 = 23
            if (r10 >= r0) goto L_0x0051
            int r10 = com.google.android.material.R.styleable.Chip_android_textColor
            android.content.res.ColorStateList r8 = gt.c.a((android.content.Context) r8, (android.content.res.TypedArray) r9, (int) r10)
            r7.setTextColor(r8)
        L_0x0051:
            int r8 = com.google.android.material.R.styleable.Chip_shapeAppearance
            boolean r8 = r9.hasValue(r8)
            r9.recycle()
            com.google.android.material.chip.Chip$a r9 = new com.google.android.material.chip.Chip$a
            r9.<init>(r7)
            r7.f18784q = r9
            r7.g()
            if (r8 != 0) goto L_0x0069
            r7.i()
        L_0x0069:
            boolean r8 = r7.f18777j
            r7.setChecked(r8)
            java.lang.CharSequence r8 = r6.n()
            r7.setText(r8)
            android.text.TextUtils$TruncateAt r8 = r6.p()
            r7.setEllipsize(r8)
            r7.o()
            com.google.android.material.chip.a r8 = r7.f18772e
            boolean r8 = r8.L()
            if (r8 != 0) goto L_0x008e
            r8 = 1
            r7.setLines(r8)
            r7.setHorizontallyScrolling(r8)
        L_0x008e:
            r8 = 8388627(0x800013, float:1.175497E-38)
            r7.setGravity(r8)
            r7.h()
            boolean r8 = r7.e()
            if (r8 == 0) goto L_0x00a2
            int r8 = r7.f18783p
            r7.setMinHeight(r8)
        L_0x00a2:
            int r8 = t.ac.i(r7)
            r7.f18782o = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    private void a(int i2, int i3, int i4, int i5) {
        this.f18773f = new InsetDrawable(this.f18772e, i2, i3, i4, i5);
    }

    private void a(Context context, AttributeSet attributeSet, int i2) {
        TypedArray a2 = l.a(context, attributeSet, R.styleable.Chip, i2, f18768a, new int[0]);
        this.f18781n = a2.getBoolean(R.styleable.Chip_ensureMinTouchTargetSize, false);
        this.f18783p = (int) Math.ceil((double) a2.getDimension(R.styleable.Chip_chipMinTouchTargetSize, (float) Math.ceil((double) s.a(getContext(), 48))));
        a2.recycle();
    }

    private void a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "background") != null) {
                Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableLeft") != null) {
                throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
            } else if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableStart") != null) {
                throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
            } else if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableEnd") != null) {
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            } else if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableRight") != null) {
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            } else if (!attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "singleLine", true) || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "lines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minLines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLines", 1) != 1) {
                throw new UnsupportedOperationException("Chip does not support multi-line text");
            } else if (attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 8388627) != 8388627) {
                Log.w("Chip", "Chip text must be vertically center and start aligned");
            }
        }
    }

    private void a(a aVar) {
        if (aVar != null) {
            aVar.a((a.C0127a) null);
        }
    }

    private boolean a(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 10) {
            try {
                Field declaredField = x.a.class.getDeclaredField(fx.f8870k);
                declaredField.setAccessible(true);
                if (((Integer) declaredField.get(this.f18784q)).intValue() != Integer.MIN_VALUE) {
                    Method declaredMethod = x.a.class.getDeclaredMethod(fx.f8868i, new Class[]{Integer.TYPE});
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(this.f18784q, new Object[]{Integer.MIN_VALUE});
                    return true;
                }
            } catch (IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException e2) {
                Log.e("Chip", "Unable to send Accessibility Exit event", e2);
            }
        }
        return false;
    }

    private void b(a aVar) {
        aVar.a((a.C0127a) this);
    }

    private void g() {
        ac.a((View) this, (t.a) (!n() || !c() || this.f18775h == null) ? null : this.f18784q);
    }

    /* access modifiers changed from: private */
    public RectF getCloseIconTouchBounds() {
        this.f18786s.setEmpty();
        if (n() && this.f18775h != null) {
            this.f18772e.a(this.f18786s);
        }
        return this.f18786s;
    }

    /* access modifiers changed from: private */
    public Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        this.f18785r.set((int) closeIconTouchBounds.left, (int) closeIconTouchBounds.top, (int) closeIconTouchBounds.right, (int) closeIconTouchBounds.bottom);
        return this.f18785r;
    }

    private d getTextAppearance() {
        a aVar = this.f18772e;
        if (aVar != null) {
            return aVar.o();
        }
        return null;
    }

    private void h() {
        a aVar;
        if (!TextUtils.isEmpty(getText()) && (aVar = this.f18772e) != null) {
            int K = (int) (aVar.K() + this.f18772e.H() + this.f18772e.d());
            int D = (int) (this.f18772e.D() + this.f18772e.G() + this.f18772e.c());
            if (this.f18773f != null) {
                Rect rect = new Rect();
                this.f18773f.getPadding(rect);
                D += rect.left;
                K += rect.right;
            }
            ac.b(this, D, getPaddingTop(), K, getPaddingBottom());
        }
    }

    private void i() {
        if (Build.VERSION.SDK_INT >= 21) {
            setOutlineProvider(new ViewOutlineProvider() {
                public void getOutline(View view, Outline outline) {
                    if (Chip.this.f18772e != null) {
                        Chip.this.f18772e.getOutline(outline);
                    } else {
                        outline.setAlpha(0.0f);
                    }
                }
            });
        }
    }

    private void j() {
        if (b.f28598a) {
            l();
            return;
        }
        this.f18772e.a(true);
        ac.a((View) this, getBackgroundDrawable());
        h();
        k();
    }

    private void k() {
        if (getBackgroundDrawable() == this.f18773f && this.f18772e.getCallback() == null) {
            this.f18772e.setCallback(this.f18773f);
        }
    }

    private void l() {
        this.f18774g = new RippleDrawable(b.b(this.f18772e.m()), getBackgroundDrawable(), (Drawable) null);
        this.f18772e.a(false);
        ac.a((View) this, (Drawable) this.f18774g);
        h();
    }

    private int[] m() {
        int i2 = 0;
        int i3 = isEnabled() ? 1 : 0;
        if (this.f18780m) {
            i3++;
        }
        if (this.f18779l) {
            i3++;
        }
        if (this.f18778k) {
            i3++;
        }
        if (isChecked()) {
            i3++;
        }
        int[] iArr = new int[i3];
        if (isEnabled()) {
            iArr[0] = 16842910;
            i2 = 1;
        }
        if (this.f18780m) {
            iArr[i2] = 16842908;
            i2++;
        }
        if (this.f18779l) {
            iArr[i2] = 16843623;
            i2++;
        }
        if (this.f18778k) {
            iArr[i2] = 16842919;
            i2++;
        }
        if (isChecked()) {
            iArr[i2] = 16842913;
        }
        return iArr;
    }

    /* access modifiers changed from: private */
    public boolean n() {
        a aVar = this.f18772e;
        return (aVar == null || aVar.u() == null) ? false : true;
    }

    private void o() {
        TextPaint paint = getPaint();
        a aVar = this.f18772e;
        if (aVar != null) {
            paint.drawableState = aVar.getState();
        }
        d textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.b(getContext(), paint, this.f18787t);
        }
    }

    private void p() {
        if (this.f18773f != null) {
            this.f18773f = null;
            setMinWidth(0);
            setMinHeight((int) getChipMinHeight());
            j();
        }
    }

    private void setCloseIconHovered(boolean z2) {
        if (this.f18779l != z2) {
            this.f18779l = z2;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z2) {
        if (this.f18778k != z2) {
            this.f18778k = z2;
            refreshDrawableState();
        }
    }

    public void a() {
        a(this.f18783p);
        requestLayout();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x007d, code lost:
        if (getMinWidth() != r6) goto L_0x0083;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(int r6) {
        /*
            r5 = this;
            r5.f18783p = r6
            boolean r0 = r5.e()
            r1 = 0
            if (r0 != 0) goto L_0x0015
            android.graphics.drawable.InsetDrawable r6 = r5.f18773f
            if (r6 == 0) goto L_0x0011
            r5.p()
            goto L_0x0014
        L_0x0011:
            r5.j()
        L_0x0014:
            return r1
        L_0x0015:
            com.google.android.material.chip.a r0 = r5.f18772e
            int r0 = r0.getIntrinsicHeight()
            int r0 = r6 - r0
            int r0 = java.lang.Math.max(r1, r0)
            com.google.android.material.chip.a r2 = r5.f18772e
            int r2 = r2.getIntrinsicWidth()
            int r2 = r6 - r2
            int r2 = java.lang.Math.max(r1, r2)
            if (r2 > 0) goto L_0x003d
            if (r0 > 0) goto L_0x003d
            android.graphics.drawable.InsetDrawable r6 = r5.f18773f
            if (r6 == 0) goto L_0x0039
            r5.p()
            goto L_0x003c
        L_0x0039:
            r5.j()
        L_0x003c:
            return r1
        L_0x003d:
            if (r2 <= 0) goto L_0x0042
            int r2 = r2 / 2
            goto L_0x0043
        L_0x0042:
            r2 = 0
        L_0x0043:
            if (r0 <= 0) goto L_0x0047
            int r1 = r0 / 2
        L_0x0047:
            android.graphics.drawable.InsetDrawable r0 = r5.f18773f
            r3 = 1
            if (r0 == 0) goto L_0x006a
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            android.graphics.drawable.InsetDrawable r4 = r5.f18773f
            r4.getPadding(r0)
            int r4 = r0.top
            if (r4 != r1) goto L_0x006a
            int r4 = r0.bottom
            if (r4 != r1) goto L_0x006a
            int r4 = r0.left
            if (r4 != r2) goto L_0x006a
            int r0 = r0.right
            if (r0 != r2) goto L_0x006a
            r5.j()
            return r3
        L_0x006a:
            int r0 = android.os.Build.VERSION.SDK_INT
            r4 = 16
            if (r0 < r4) goto L_0x0080
            int r0 = r5.getMinHeight()
            if (r0 == r6) goto L_0x0079
            r5.setMinHeight(r6)
        L_0x0079:
            int r0 = r5.getMinWidth()
            if (r0 == r6) goto L_0x0086
            goto L_0x0083
        L_0x0080:
            r5.setMinHeight(r6)
        L_0x0083:
            r5.setMinWidth(r6)
        L_0x0086:
            r5.a(r2, r1, r2, r1)
            r5.j()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.a(int):boolean");
    }

    public boolean b() {
        boolean z2 = false;
        playSoundEffect(0);
        View.OnClickListener onClickListener = this.f18775h;
        if (onClickListener != null) {
            onClickListener.onClick(this);
            z2 = true;
        }
        this.f18784q.a(1, 1);
        return z2;
    }

    public boolean c() {
        a aVar = this.f18772e;
        return aVar != null && aVar.t();
    }

    public boolean d() {
        a aVar = this.f18772e;
        return aVar != null && aVar.y();
    }

    /* access modifiers changed from: protected */
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return a(motionEvent) || this.f18784q.a(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!this.f18784q.a(keyEvent) || this.f18784q.c() == Integer.MIN_VALUE) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        a aVar = this.f18772e;
        if ((aVar == null || !aVar.e()) ? false : this.f18772e.a(m())) {
            invalidate();
        }
    }

    public boolean e() {
        return this.f18781n;
    }

    public Drawable getBackgroundDrawable() {
        InsetDrawable insetDrawable = this.f18773f;
        return insetDrawable == null ? this.f18772e : insetDrawable;
    }

    public Drawable getCheckedIcon() {
        a aVar = this.f18772e;
        if (aVar != null) {
            return aVar.z();
        }
        return null;
    }

    public ColorStateList getCheckedIconTint() {
        a aVar = this.f18772e;
        if (aVar != null) {
            return aVar.A();
        }
        return null;
    }

    public ColorStateList getChipBackgroundColor() {
        a aVar = this.f18772e;
        if (aVar != null) {
            return aVar.h();
        }
        return null;
    }

    public float getChipCornerRadius() {
        a aVar = this.f18772e;
        if (aVar != null) {
            return Math.max(0.0f, aVar.j());
        }
        return 0.0f;
    }

    public Drawable getChipDrawable() {
        return this.f18772e;
    }

    public float getChipEndPadding() {
        a aVar = this.f18772e;
        if (aVar != null) {
            return aVar.K();
        }
        return 0.0f;
    }

    public Drawable getChipIcon() {
        a aVar = this.f18772e;
        if (aVar != null) {
            return aVar.q();
        }
        return null;
    }

    public float getChipIconSize() {
        a aVar = this.f18772e;
        if (aVar != null) {
            return aVar.s();
        }
        return 0.0f;
    }

    public ColorStateList getChipIconTint() {
        a aVar = this.f18772e;
        if (aVar != null) {
            return aVar.r();
        }
        return null;
    }

    public float getChipMinHeight() {
        a aVar = this.f18772e;
        if (aVar != null) {
            return aVar.i();
        }
        return 0.0f;
    }

    public float getChipStartPadding() {
        a aVar = this.f18772e;
        if (aVar != null) {
            return aVar.D();
        }
        return 0.0f;
    }

    public ColorStateList getChipStrokeColor() {
        a aVar = this.f18772e;
        if (aVar != null) {
            return aVar.k();
        }
        return null;
    }

    public float getChipStrokeWidth() {
        a aVar = this.f18772e;
        if (aVar != null) {
            return aVar.l();
        }
        return 0.0f;
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    public Drawable getCloseIcon() {
        a aVar = this.f18772e;
        if (aVar != null) {
            return aVar.u();
        }
        return null;
    }

    public CharSequence getCloseIconContentDescription() {
        a aVar = this.f18772e;
        if (aVar != null) {
            return aVar.x();
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        a aVar = this.f18772e;
        if (aVar != null) {
            return aVar.J();
        }
        return 0.0f;
    }

    public float getCloseIconSize() {
        a aVar = this.f18772e;
        if (aVar != null) {
            return aVar.w();
        }
        return 0.0f;
    }

    public float getCloseIconStartPadding() {
        a aVar = this.f18772e;
        if (aVar != null) {
            return aVar.I();
        }
        return 0.0f;
    }

    public ColorStateList getCloseIconTint() {
        a aVar = this.f18772e;
        if (aVar != null) {
            return aVar.v();
        }
        return null;
    }

    public TextUtils.TruncateAt getEllipsize() {
        a aVar = this.f18772e;
        if (aVar != null) {
            return aVar.p();
        }
        return null;
    }

    public void getFocusedRect(Rect rect) {
        if (this.f18784q.c() == 1 || this.f18784q.b() == 1) {
            rect.set(getCloseIconTouchBoundsInt());
        } else {
            super.getFocusedRect(rect);
        }
    }

    public h getHideMotionSpec() {
        a aVar = this.f18772e;
        if (aVar != null) {
            return aVar.C();
        }
        return null;
    }

    public float getIconEndPadding() {
        a aVar = this.f18772e;
        if (aVar != null) {
            return aVar.F();
        }
        return 0.0f;
    }

    public float getIconStartPadding() {
        a aVar = this.f18772e;
        if (aVar != null) {
            return aVar.E();
        }
        return 0.0f;
    }

    public ColorStateList getRippleColor() {
        a aVar = this.f18772e;
        if (aVar != null) {
            return aVar.m();
        }
        return null;
    }

    public m getShapeAppearanceModel() {
        return this.f18772e.M();
    }

    public h getShowMotionSpec() {
        a aVar = this.f18772e;
        if (aVar != null) {
            return aVar.B();
        }
        return null;
    }

    public float getTextEndPadding() {
        a aVar = this.f18772e;
        if (aVar != null) {
            return aVar.H();
        }
        return 0.0f;
    }

    public float getTextStartPadding() {
        a aVar = this.f18772e;
        if (aVar != null) {
            return aVar.G();
        }
        return 0.0f;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        i.a((View) this, (gw.h) this.f18772e);
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 2);
        if (isChecked()) {
            mergeDrawableStates(onCreateDrawableState, f18770c);
        }
        if (d()) {
            mergeDrawableStates(onCreateDrawableState, f18771d);
        }
        return onCreateDrawableState;
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z2, int i2, Rect rect) {
        super.onFocusChanged(z2, i2, rect);
        this.f18784q.a(z2, i2, rect);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        boolean z2;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 7) {
            if (actionMasked == 10) {
                z2 = false;
            }
            return super.onHoverEvent(motionEvent);
        }
        z2 = getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY());
        setCloseIconHovered(z2);
        return super.onHoverEvent(motionEvent);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName((d() || isClickable()) ? d() ? "android.widget.CompoundButton" : "android.widget.Button" : "android.view.View");
        accessibilityNodeInfo.setCheckable(d());
        accessibilityNodeInfo.setClickable(isClickable());
        if (getParent() instanceof ChipGroup) {
            ChipGroup chipGroup = (ChipGroup) getParent();
            c.a(accessibilityNodeInfo).b((Object) c.C0258c.a(chipGroup.b(this), 1, chipGroup.b() ? chipGroup.a((View) this) : -1, 1, false, isChecked()));
        }
    }

    public PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i2) {
        if (!getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) || !isEnabled()) {
            return null;
        }
        return PointerIcon.getSystemIcon(getContext(), 1002);
    }

    public void onRtlPropertiesChanged(int i2) {
        super.onRtlPropertiesChanged(i2);
        if (this.f18782o != i2) {
            this.f18782o = i2;
            h();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001e, code lost:
        if (r0 != 3) goto L_0x0040;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0049 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getActionMasked()
            android.graphics.RectF r1 = r5.getCloseIconTouchBounds()
            float r2 = r6.getX()
            float r3 = r6.getY()
            boolean r1 = r1.contains(r2, r3)
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L_0x0039
            if (r0 == r3) goto L_0x002b
            r4 = 2
            if (r0 == r4) goto L_0x0021
            r1 = 3
            if (r0 == r1) goto L_0x0034
            goto L_0x0040
        L_0x0021:
            boolean r0 = r5.f18778k
            if (r0 == 0) goto L_0x0040
            if (r1 != 0) goto L_0x003e
            r5.setCloseIconPressed(r2)
            goto L_0x003e
        L_0x002b:
            boolean r0 = r5.f18778k
            if (r0 == 0) goto L_0x0034
            r5.b()
            r0 = 1
            goto L_0x0035
        L_0x0034:
            r0 = 0
        L_0x0035:
            r5.setCloseIconPressed(r2)
            goto L_0x0041
        L_0x0039:
            if (r1 == 0) goto L_0x0040
            r5.setCloseIconPressed(r3)
        L_0x003e:
            r0 = 1
            goto L_0x0041
        L_0x0040:
            r0 = 0
        L_0x0041:
            if (r0 != 0) goto L_0x0049
            boolean r6 = super.onTouchEvent(r6)
            if (r6 == 0) goto L_0x004a
        L_0x0049:
            r2 = 1
        L_0x004a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setBackground(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f18774g) {
            super.setBackground(drawable);
        } else {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        }
    }

    public void setBackgroundColor(int i2) {
        Log.w("Chip", "Do not set the background color; Chip manages its own background drawable.");
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f18774g) {
            super.setBackgroundDrawable(drawable);
        } else {
            Log.w("Chip", "Do not set the background drawable; Chip manages its own background drawable.");
        }
    }

    public void setBackgroundResource(int i2) {
        Log.w("Chip", "Do not set the background resource; Chip manages its own background drawable.");
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        Log.w("Chip", "Do not set the background tint list; Chip manages its own background drawable.");
    }

    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        Log.w("Chip", "Do not set the background tint mode; Chip manages its own background drawable.");
    }

    public void setCheckable(boolean z2) {
        a aVar = this.f18772e;
        if (aVar != null) {
            aVar.d(z2);
        }
    }

    public void setCheckableResource(int i2) {
        a aVar = this.f18772e;
        if (aVar != null) {
            aVar.o(i2);
        }
    }

    public void setChecked(boolean z2) {
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        a aVar = this.f18772e;
        if (aVar == null) {
            this.f18777j = z2;
        } else if (aVar.y()) {
            boolean isChecked = isChecked();
            super.setChecked(z2);
            if (isChecked != z2 && (onCheckedChangeListener = this.f18776i) != null) {
                onCheckedChangeListener.onCheckedChanged(this, z2);
            }
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        a aVar = this.f18772e;
        if (aVar != null) {
            aVar.c(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z2) {
        setCheckedIconVisible(z2);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(int i2) {
        setCheckedIconVisible(i2);
    }

    public void setCheckedIconResource(int i2) {
        a aVar = this.f18772e;
        if (aVar != null) {
            aVar.q(i2);
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        a aVar = this.f18772e;
        if (aVar != null) {
            aVar.f(colorStateList);
        }
    }

    public void setCheckedIconTintResource(int i2) {
        a aVar = this.f18772e;
        if (aVar != null) {
            aVar.r(i2);
        }
    }

    public void setCheckedIconVisible(int i2) {
        a aVar = this.f18772e;
        if (aVar != null) {
            aVar.p(i2);
        }
    }

    public void setCheckedIconVisible(boolean z2) {
        a aVar = this.f18772e;
        if (aVar != null) {
            aVar.e(z2);
        }
    }

    public void setChipBackgroundColor(ColorStateList colorStateList) {
        a aVar = this.f18772e;
        if (aVar != null) {
            aVar.a(colorStateList);
        }
    }

    public void setChipBackgroundColorResource(int i2) {
        a aVar = this.f18772e;
        if (aVar != null) {
            aVar.a(i2);
        }
    }

    @Deprecated
    public void setChipCornerRadius(float f2) {
        a aVar = this.f18772e;
        if (aVar != null) {
            aVar.b(f2);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(int i2) {
        a aVar = this.f18772e;
        if (aVar != null) {
            aVar.c(i2);
        }
    }

    public void setChipDrawable(a aVar) {
        a aVar2 = this.f18772e;
        if (aVar2 != aVar) {
            a(aVar2);
            this.f18772e = aVar;
            aVar.f(false);
            b(this.f18772e);
            a(this.f18783p);
        }
    }

    public void setChipEndPadding(float f2) {
        a aVar = this.f18772e;
        if (aVar != null) {
            aVar.m(f2);
        }
    }

    public void setChipEndPaddingResource(int i2) {
        a aVar = this.f18772e;
        if (aVar != null) {
            aVar.B(i2);
        }
    }

    public void setChipIcon(Drawable drawable) {
        a aVar = this.f18772e;
        if (aVar != null) {
            aVar.a(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z2) {
        setChipIconVisible(z2);
    }

    @Deprecated
    public void setChipIconEnabledResource(int i2) {
        setChipIconVisible(i2);
    }

    public void setChipIconResource(int i2) {
        a aVar = this.f18772e;
        if (aVar != null) {
            aVar.i(i2);
        }
    }

    public void setChipIconSize(float f2) {
        a aVar = this.f18772e;
        if (aVar != null) {
            aVar.d(f2);
        }
    }

    public void setChipIconSizeResource(int i2) {
        a aVar = this.f18772e;
        if (aVar != null) {
            aVar.k(i2);
        }
    }

    public void setChipIconTint(ColorStateList colorStateList) {
        a aVar = this.f18772e;
        if (aVar != null) {
            aVar.d(colorStateList);
        }
    }

    public void setChipIconTintResource(int i2) {
        a aVar = this.f18772e;
        if (aVar != null) {
            aVar.j(i2);
        }
    }

    public void setChipIconVisible(int i2) {
        a aVar = this.f18772e;
        if (aVar != null) {
            aVar.h(i2);
        }
    }

    public void setChipIconVisible(boolean z2) {
        a aVar = this.f18772e;
        if (aVar != null) {
            aVar.b(z2);
        }
    }

    public void setChipMinHeight(float f2) {
        a aVar = this.f18772e;
        if (aVar != null) {
            aVar.a(f2);
        }
    }

    public void setChipMinHeightResource(int i2) {
        a aVar = this.f18772e;
        if (aVar != null) {
            aVar.b(i2);
        }
    }

    public void setChipStartPadding(float f2) {
        a aVar = this.f18772e;
        if (aVar != null) {
            aVar.f(f2);
        }
    }

    public void setChipStartPaddingResource(int i2) {
        a aVar = this.f18772e;
        if (aVar != null) {
            aVar.u(i2);
        }
    }

    public void setChipStrokeColor(ColorStateList colorStateList) {
        a aVar = this.f18772e;
        if (aVar != null) {
            aVar.b(colorStateList);
        }
    }

    public void setChipStrokeColorResource(int i2) {
        a aVar = this.f18772e;
        if (aVar != null) {
            aVar.d(i2);
        }
    }

    public void setChipStrokeWidth(float f2) {
        a aVar = this.f18772e;
        if (aVar != null) {
            aVar.c(f2);
        }
    }

    public void setChipStrokeWidthResource(int i2) {
        a aVar = this.f18772e;
        if (aVar != null) {
            aVar.e(i2);
        }
    }

    @Deprecated
    public void setChipText(CharSequence charSequence) {
        setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(int i2) {
        setText(getResources().getString(i2));
    }

    public void setCloseIcon(Drawable drawable) {
        a aVar = this.f18772e;
        if (aVar != null) {
            aVar.b(drawable);
        }
        g();
    }

    public void setCloseIconContentDescription(CharSequence charSequence) {
        a aVar = this.f18772e;
        if (aVar != null) {
            aVar.b(charSequence);
        }
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z2) {
        setCloseIconVisible(z2);
    }

    @Deprecated
    public void setCloseIconEnabledResource(int i2) {
        setCloseIconVisible(i2);
    }

    public void setCloseIconEndPadding(float f2) {
        a aVar = this.f18772e;
        if (aVar != null) {
            aVar.l(f2);
        }
    }

    public void setCloseIconEndPaddingResource(int i2) {
        a aVar = this.f18772e;
        if (aVar != null) {
            aVar.A(i2);
        }
    }

    public void setCloseIconResource(int i2) {
        a aVar = this.f18772e;
        if (aVar != null) {
            aVar.l(i2);
        }
        g();
    }

    public void setCloseIconSize(float f2) {
        a aVar = this.f18772e;
        if (aVar != null) {
            aVar.e(f2);
        }
    }

    public void setCloseIconSizeResource(int i2) {
        a aVar = this.f18772e;
        if (aVar != null) {
            aVar.n(i2);
        }
    }

    public void setCloseIconStartPadding(float f2) {
        a aVar = this.f18772e;
        if (aVar != null) {
            aVar.k(f2);
        }
    }

    public void setCloseIconStartPaddingResource(int i2) {
        a aVar = this.f18772e;
        if (aVar != null) {
            aVar.z(i2);
        }
    }

    public void setCloseIconTint(ColorStateList colorStateList) {
        a aVar = this.f18772e;
        if (aVar != null) {
            aVar.e(colorStateList);
        }
    }

    public void setCloseIconTintResource(int i2) {
        a aVar = this.f18772e;
        if (aVar != null) {
            aVar.m(i2);
        }
    }

    public void setCloseIconVisible(int i2) {
        setCloseIconVisible(getResources().getBoolean(i2));
    }

    public void setCloseIconVisible(boolean z2) {
        a aVar = this.f18772e;
        if (aVar != null) {
            aVar.c(z2);
        }
        g();
    }

    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i2, int i3, int i4, int i5) {
        if (i2 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (i4 == 0) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(i2, i3, i4, i5);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    public void setCompoundDrawablesWithIntrinsicBounds(int i2, int i3, int i4, int i5) {
        if (i2 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (i4 == 0) {
            super.setCompoundDrawablesWithIntrinsicBounds(i2, i3, i4, i5);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        } else {
            throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
        }
    }

    public void setElevation(float f2) {
        super.setElevation(f2);
        a aVar = this.f18772e;
        if (aVar != null) {
            aVar.r(f2);
        }
    }

    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.f18772e != null) {
            if (truncateAt != TextUtils.TruncateAt.MARQUEE) {
                super.setEllipsize(truncateAt);
                a aVar = this.f18772e;
                if (aVar != null) {
                    aVar.a(truncateAt);
                    return;
                }
                return;
            }
            throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z2) {
        this.f18781n = z2;
        a(this.f18783p);
    }

    public void setGravity(int i2) {
        if (i2 != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        } else {
            super.setGravity(i2);
        }
    }

    public void setHideMotionSpec(h hVar) {
        a aVar = this.f18772e;
        if (aVar != null) {
            aVar.b(hVar);
        }
    }

    public void setHideMotionSpecResource(int i2) {
        a aVar = this.f18772e;
        if (aVar != null) {
            aVar.t(i2);
        }
    }

    public void setIconEndPadding(float f2) {
        a aVar = this.f18772e;
        if (aVar != null) {
            aVar.h(f2);
        }
    }

    public void setIconEndPaddingResource(int i2) {
        a aVar = this.f18772e;
        if (aVar != null) {
            aVar.w(i2);
        }
    }

    public void setIconStartPadding(float f2) {
        a aVar = this.f18772e;
        if (aVar != null) {
            aVar.g(f2);
        }
    }

    public void setIconStartPaddingResource(int i2) {
        a aVar = this.f18772e;
        if (aVar != null) {
            aVar.v(i2);
        }
    }

    public void setLayoutDirection(int i2) {
        if (this.f18772e != null && Build.VERSION.SDK_INT >= 17) {
            super.setLayoutDirection(i2);
        }
    }

    public void setLines(int i2) {
        if (i2 <= 1) {
            super.setLines(i2);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    public void setMaxLines(int i2) {
        if (i2 <= 1) {
            super.setMaxLines(i2);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    public void setMaxWidth(int i2) {
        super.setMaxWidth(i2);
        a aVar = this.f18772e;
        if (aVar != null) {
            aVar.C(i2);
        }
    }

    public void setMinLines(int i2) {
        if (i2 <= 1) {
            super.setMinLines(i2);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    /* access modifiers changed from: package-private */
    public void setOnCheckedChangeListenerInternal(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f18776i = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.f18775h = onClickListener;
        g();
    }

    public void setRippleColor(ColorStateList colorStateList) {
        a aVar = this.f18772e;
        if (aVar != null) {
            aVar.c(colorStateList);
        }
        if (!this.f18772e.a()) {
            l();
        }
    }

    public void setRippleColorResource(int i2) {
        a aVar = this.f18772e;
        if (aVar != null) {
            aVar.f(i2);
            if (!this.f18772e.a()) {
                l();
            }
        }
    }

    public void setShapeAppearanceModel(m mVar) {
        this.f18772e.setShapeAppearanceModel(mVar);
    }

    public void setShowMotionSpec(h hVar) {
        a aVar = this.f18772e;
        if (aVar != null) {
            aVar.a(hVar);
        }
    }

    public void setShowMotionSpecResource(int i2) {
        a aVar = this.f18772e;
        if (aVar != null) {
            aVar.s(i2);
        }
    }

    public void setSingleLine(boolean z2) {
        if (z2) {
            super.setSingleLine(z2);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        a aVar = this.f18772e;
        if (aVar != null) {
            if (charSequence == null) {
                charSequence = "";
            }
            super.setText(aVar.L() ? null : charSequence, bufferType);
            a aVar2 = this.f18772e;
            if (aVar2 != null) {
                aVar2.a(charSequence);
            }
        }
    }

    public void setTextAppearance(int i2) {
        super.setTextAppearance(i2);
        a aVar = this.f18772e;
        if (aVar != null) {
            aVar.g(i2);
        }
        o();
    }

    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        a aVar = this.f18772e;
        if (aVar != null) {
            aVar.g(i2);
        }
        o();
    }

    public void setTextAppearance(d dVar) {
        a aVar = this.f18772e;
        if (aVar != null) {
            aVar.a(dVar);
        }
        o();
    }

    public void setTextAppearanceResource(int i2) {
        setTextAppearance(getContext(), i2);
    }

    public void setTextEndPadding(float f2) {
        a aVar = this.f18772e;
        if (aVar != null) {
            aVar.j(f2);
        }
    }

    public void setTextEndPaddingResource(int i2) {
        a aVar = this.f18772e;
        if (aVar != null) {
            aVar.y(i2);
        }
    }

    public void setTextStartPadding(float f2) {
        a aVar = this.f18772e;
        if (aVar != null) {
            aVar.i(f2);
        }
    }

    public void setTextStartPaddingResource(int i2) {
        a aVar = this.f18772e;
        if (aVar != null) {
            aVar.x(i2);
        }
    }
}
