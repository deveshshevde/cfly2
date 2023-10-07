package com.google.android.material.card;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import androidx.cardview.widget.CardView;
import com.google.android.material.R;
import gw.i;
import gw.m;
import gw.p;

public class MaterialCardView extends CardView implements Checkable, p {

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f18733e = {16842911};

    /* renamed from: f  reason: collision with root package name */
    private static final int[] f18734f = {16842912};

    /* renamed from: g  reason: collision with root package name */
    private static final int[] f18735g = {R.attr.state_dragged};

    /* renamed from: h  reason: collision with root package name */
    private static final int f18736h = R.style.Widget_MaterialComponents_CardView;

    /* renamed from: i  reason: collision with root package name */
    private final a f18737i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f18738j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f18739k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f18740l;

    /* renamed from: m  reason: collision with root package name */
    private a f18741m;

    public interface a {
        void a(MaterialCardView materialCardView, boolean z2);
    }

    public MaterialCardView(Context context) {
        this(context, (AttributeSet) null);
    }

    public MaterialCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialCardViewStyle);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MaterialCardView(android.content.Context r8, android.util.AttributeSet r9, int r10) {
        /*
            r7 = this;
            int r6 = f18736h
            android.content.Context r8 = gx.a.a(r8, r9, r10, r6)
            r7.<init>(r8, r9, r10)
            r8 = 0
            r7.f18739k = r8
            r7.f18740l = r8
            r0 = 1
            r7.f18738j = r0
            android.content.Context r0 = r7.getContext()
            int[] r2 = com.google.android.material.R.styleable.MaterialCardView
            int[] r5 = new int[r8]
            r1 = r9
            r3 = r10
            r4 = r6
            android.content.res.TypedArray r8 = com.google.android.material.internal.l.a(r0, r1, r2, r3, r4, r5)
            com.google.android.material.card.a r0 = new com.google.android.material.card.a
            r0.<init>(r7, r9, r10, r6)
            r7.f18737i = r0
            android.content.res.ColorStateList r9 = super.getCardBackgroundColor()
            r0.b((android.content.res.ColorStateList) r9)
            int r9 = super.getContentPaddingLeft()
            int r10 = super.getContentPaddingTop()
            int r1 = super.getContentPaddingRight()
            int r2 = super.getContentPaddingBottom()
            r0.a(r9, r10, r1, r2)
            r0.a((android.content.res.TypedArray) r8)
            r8.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.card.MaterialCardView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    private void c() {
        if (Build.VERSION.SDK_INT > 26) {
            this.f18737i.v();
        }
    }

    private RectF getBoundsAsRectF() {
        RectF rectF = new RectF();
        rectF.set(this.f18737i.e().getBounds());
        return rectF;
    }

    public void a(int i2, int i3, int i4, int i5) {
        this.f18737i.a(i2, i3, i4, i5);
    }

    /* access modifiers changed from: package-private */
    public void b(int i2, int i3, int i4, int i5) {
        super.a(i2, i3, i4, i5);
    }

    public ColorStateList getCardBackgroundColor() {
        return this.f18737i.f();
    }

    public ColorStateList getCardForegroundColor() {
        return this.f18737i.g();
    }

    /* access modifiers changed from: package-private */
    public float getCardViewRadius() {
        return super.getRadius();
    }

    public Drawable getCheckedIcon() {
        return this.f18737i.s();
    }

    public int getCheckedIconMargin() {
        return this.f18737i.u();
    }

    public int getCheckedIconSize() {
        return this.f18737i.t();
    }

    public ColorStateList getCheckedIconTint() {
        return this.f18737i.q();
    }

    public int getContentPaddingBottom() {
        return this.f18737i.h().bottom;
    }

    public int getContentPaddingLeft() {
        return this.f18737i.h().left;
    }

    public int getContentPaddingRight() {
        return this.f18737i.h().right;
    }

    public int getContentPaddingTop() {
        return this.f18737i.h().top;
    }

    public float getProgress() {
        return this.f18737i.k();
    }

    public float getRadius() {
        return this.f18737i.j();
    }

    public ColorStateList getRippleColor() {
        return this.f18737i.r();
    }

    public m getShapeAppearanceModel() {
        return this.f18737i.w();
    }

    @Deprecated
    public int getStrokeColor() {
        return this.f18737i.b();
    }

    public ColorStateList getStrokeColorStateList() {
        return this.f18737i.c();
    }

    public int getStrokeWidth() {
        return this.f18737i.d();
    }

    public boolean isChecked() {
        return this.f18739k;
    }

    public boolean o_() {
        return this.f18740l;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        i.a((View) this, this.f18737i.e());
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 3);
        if (p_()) {
            mergeDrawableStates(onCreateDrawableState, f18733e);
        }
        if (isChecked()) {
            mergeDrawableStates(onCreateDrawableState, f18734f);
        }
        if (o_()) {
            mergeDrawableStates(onCreateDrawableState, f18735g);
        }
        return onCreateDrawableState;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.cardview.widget.CardView");
        accessibilityEvent.setChecked(isChecked());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.cardview.widget.CardView");
        accessibilityNodeInfo.setCheckable(p_());
        accessibilityNodeInfo.setClickable(isClickable());
        accessibilityNodeInfo.setChecked(isChecked());
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.f18737i.a(getMeasuredWidth(), getMeasuredHeight());
    }

    public boolean p_() {
        a aVar = this.f18737i;
        return aVar != null && aVar.p();
    }

    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (this.f18738j) {
            if (!this.f18737i.a()) {
                Log.i("MaterialCardView", "Setting a custom background is not supported.");
                this.f18737i.a(true);
            }
            super.setBackgroundDrawable(drawable);
        }
    }

    /* access modifiers changed from: package-private */
    public void setBackgroundInternal(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setCardBackgroundColor(int i2) {
        this.f18737i.b(ColorStateList.valueOf(i2));
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        this.f18737i.b(colorStateList);
    }

    public void setCardElevation(float f2) {
        super.setCardElevation(f2);
        this.f18737i.l();
    }

    public void setCardForegroundColor(ColorStateList colorStateList) {
        this.f18737i.c(colorStateList);
    }

    public void setCheckable(boolean z2) {
        this.f18737i.b(z2);
    }

    public void setChecked(boolean z2) {
        if (this.f18739k != z2) {
            toggle();
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        this.f18737i.a(drawable);
    }

    public void setCheckedIconMargin(int i2) {
        this.f18737i.c(i2);
    }

    public void setCheckedIconMarginResource(int i2) {
        if (i2 != -1) {
            this.f18737i.c(getResources().getDimensionPixelSize(i2));
        }
    }

    public void setCheckedIconResource(int i2) {
        this.f18737i.a(c.a.b(getContext(), i2));
    }

    public void setCheckedIconSize(int i2) {
        this.f18737i.b(i2);
    }

    public void setCheckedIconSizeResource(int i2) {
        if (i2 != 0) {
            this.f18737i.b(getResources().getDimensionPixelSize(i2));
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        this.f18737i.e(colorStateList);
    }

    public void setClickable(boolean z2) {
        super.setClickable(z2);
        a aVar = this.f18737i;
        if (aVar != null) {
            aVar.i();
        }
    }

    public void setDragged(boolean z2) {
        if (this.f18740l != z2) {
            this.f18740l = z2;
            refreshDrawableState();
            c();
            invalidate();
        }
    }

    public void setMaxCardElevation(float f2) {
        super.setMaxCardElevation(f2);
        this.f18737i.m();
    }

    public void setOnCheckedChangeListener(a aVar) {
        this.f18741m = aVar;
    }

    public void setPreventCornerOverlap(boolean z2) {
        super.setPreventCornerOverlap(z2);
        this.f18737i.m();
        this.f18737i.o();
    }

    public void setProgress(float f2) {
        this.f18737i.b(f2);
    }

    public void setRadius(float f2) {
        super.setRadius(f2);
        this.f18737i.a(f2);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        this.f18737i.d(colorStateList);
    }

    public void setRippleColorResource(int i2) {
        this.f18737i.d(c.a.a(getContext(), i2));
    }

    public void setShapeAppearanceModel(m mVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            setClipToOutline(mVar.a(getBoundsAsRectF()));
        }
        this.f18737i.a(mVar);
    }

    public void setStrokeColor(int i2) {
        this.f18737i.a(ColorStateList.valueOf(i2));
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        this.f18737i.a(colorStateList);
    }

    public void setStrokeWidth(int i2) {
        this.f18737i.a(i2);
    }

    public void setUseCompatPadding(boolean z2) {
        super.setUseCompatPadding(z2);
        this.f18737i.m();
        this.f18737i.o();
    }

    public void toggle() {
        if (p_() && isEnabled()) {
            this.f18739k = !this.f18739k;
            refreshDrawableState();
            c();
            a aVar = this.f18741m;
            if (aVar != null) {
                aVar.a(this, this.f18739k);
            }
        }
    }
}
