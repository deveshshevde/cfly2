package com.google.android.material.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.widget.j;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import gw.i;
import gw.m;
import gw.p;
import java.util.Iterator;
import java.util.LinkedHashSet;
import t.ac;

public class MaterialButton extends AppCompatButton implements Checkable, p {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f18675a = {16842911};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f18676b = {16842912};

    /* renamed from: c  reason: collision with root package name */
    private static final int f18677c = R.style.Widget_MaterialComponents_Button;

    /* renamed from: e  reason: collision with root package name */
    private final a f18678e;

    /* renamed from: f  reason: collision with root package name */
    private final LinkedHashSet<a> f18679f;

    /* renamed from: g  reason: collision with root package name */
    private b f18680g;

    /* renamed from: h  reason: collision with root package name */
    private PorterDuff.Mode f18681h;

    /* renamed from: i  reason: collision with root package name */
    private ColorStateList f18682i;

    /* renamed from: j  reason: collision with root package name */
    private Drawable f18683j;

    /* renamed from: k  reason: collision with root package name */
    private int f18684k;

    /* renamed from: l  reason: collision with root package name */
    private int f18685l;

    /* renamed from: m  reason: collision with root package name */
    private int f18686m;

    /* renamed from: n  reason: collision with root package name */
    private int f18687n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f18688o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f18689p;

    /* renamed from: q  reason: collision with root package name */
    private int f18690q;

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* renamed from: a */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        boolean f18691a;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                getClass().getClassLoader();
            }
            a(parcel);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private void a(Parcel parcel) {
            boolean z2 = true;
            if (parcel.readInt() != 1) {
                z2 = false;
            }
            this.f18691a = z2;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f18691a ? 1 : 0);
        }
    }

    public interface a {
        void a(MaterialButton materialButton, boolean z2);
    }

    interface b {
        void a(MaterialButton materialButton, boolean z2);
    }

    public MaterialButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public MaterialButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialButtonStyle);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MaterialButton(android.content.Context r9, android.util.AttributeSet r10, int r11) {
        /*
            r8 = this;
            int r6 = f18677c
            android.content.Context r9 = gx.a.a(r9, r10, r11, r6)
            r8.<init>(r9, r10, r11)
            java.util.LinkedHashSet r9 = new java.util.LinkedHashSet
            r9.<init>()
            r8.f18679f = r9
            r9 = 0
            r8.f18688o = r9
            r8.f18689p = r9
            android.content.Context r7 = r8.getContext()
            int[] r2 = com.google.android.material.R.styleable.MaterialButton
            int[] r5 = new int[r9]
            r0 = r7
            r1 = r10
            r3 = r11
            r4 = r6
            android.content.res.TypedArray r0 = com.google.android.material.internal.l.a(r0, r1, r2, r3, r4, r5)
            int r1 = com.google.android.material.R.styleable.MaterialButton_iconPadding
            int r1 = r0.getDimensionPixelSize(r1, r9)
            r8.f18687n = r1
            int r1 = com.google.android.material.R.styleable.MaterialButton_iconTintMode
            r2 = -1
            int r1 = r0.getInt(r1, r2)
            android.graphics.PorterDuff$Mode r2 = android.graphics.PorterDuff.Mode.SRC_IN
            android.graphics.PorterDuff$Mode r1 = com.google.android.material.internal.s.a((int) r1, (android.graphics.PorterDuff.Mode) r2)
            r8.f18681h = r1
            android.content.Context r1 = r8.getContext()
            int r2 = com.google.android.material.R.styleable.MaterialButton_iconTint
            android.content.res.ColorStateList r1 = gt.c.a((android.content.Context) r1, (android.content.res.TypedArray) r0, (int) r2)
            r8.f18682i = r1
            android.content.Context r1 = r8.getContext()
            int r2 = com.google.android.material.R.styleable.MaterialButton_icon
            android.graphics.drawable.Drawable r1 = gt.c.b(r1, r0, r2)
            r8.f18683j = r1
            int r1 = com.google.android.material.R.styleable.MaterialButton_iconGravity
            r2 = 1
            int r1 = r0.getInteger(r1, r2)
            r8.f18690q = r1
            int r1 = com.google.android.material.R.styleable.MaterialButton_iconSize
            int r1 = r0.getDimensionPixelSize(r1, r9)
            r8.f18684k = r1
            gw.m$a r10 = gw.m.a((android.content.Context) r7, (android.util.AttributeSet) r10, (int) r11, (int) r6)
            gw.m r10 = r10.a()
            com.google.android.material.button.a r11 = new com.google.android.material.button.a
            r11.<init>(r8, r10)
            r8.f18678e = r11
            r11.a((android.content.res.TypedArray) r0)
            r0.recycle()
            int r10 = r8.f18687n
            r8.setCompoundDrawablePadding(r10)
            android.graphics.drawable.Drawable r10 = r8.f18683j
            if (r10 == 0) goto L_0x0084
            r9 = 1
        L_0x0084:
            r8.a((boolean) r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.button.MaterialButton.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    private void a(int i2, int i3) {
        if (this.f18683j != null && getLayout() != null) {
            if (d() || e()) {
                this.f18686m = 0;
                int i4 = this.f18690q;
                boolean z2 = true;
                if (i4 == 1 || i4 == 3) {
                    this.f18685l = 0;
                } else {
                    int i5 = this.f18684k;
                    if (i5 == 0) {
                        i5 = this.f18683j.getIntrinsicWidth();
                    }
                    int textWidth = (((((i2 - getTextWidth()) - ac.m(this)) - i5) - this.f18687n) - ac.l(this)) / 2;
                    boolean b2 = b();
                    if (this.f18690q != 4) {
                        z2 = false;
                    }
                    if (b2 != z2) {
                        textWidth = -textWidth;
                    }
                    if (this.f18685l != textWidth) {
                        this.f18685l = textWidth;
                        a(false);
                        return;
                    }
                    return;
                }
            } else if (f()) {
                this.f18685l = 0;
                if (this.f18690q == 16) {
                    this.f18686m = 0;
                } else {
                    int i6 = this.f18684k;
                    if (i6 == 0) {
                        i6 = this.f18683j.getIntrinsicHeight();
                    }
                    int textHeight = (((((i3 - getTextHeight()) - getPaddingTop()) - i6) - this.f18687n) - getPaddingBottom()) / 2;
                    if (this.f18686m != textHeight) {
                        this.f18686m = textHeight;
                        a(false);
                        return;
                    }
                    return;
                }
            } else {
                return;
            }
            a(false);
        }
    }

    private void a(boolean z2) {
        Drawable drawable = this.f18683j;
        if (drawable != null) {
            Drawable mutate = androidx.core.graphics.drawable.a.g(drawable).mutate();
            this.f18683j = mutate;
            androidx.core.graphics.drawable.a.a(mutate, this.f18682i);
            PorterDuff.Mode mode = this.f18681h;
            if (mode != null) {
                androidx.core.graphics.drawable.a.a(this.f18683j, mode);
            }
            int i2 = this.f18684k;
            if (i2 == 0) {
                i2 = this.f18683j.getIntrinsicWidth();
            }
            int i3 = this.f18684k;
            if (i3 == 0) {
                i3 = this.f18683j.getIntrinsicHeight();
            }
            Drawable drawable2 = this.f18683j;
            int i4 = this.f18685l;
            int i5 = this.f18686m;
            drawable2.setBounds(i4, i5, i2 + i4, i3 + i5);
        }
        if (z2) {
            c();
            return;
        }
        Drawable[] b2 = j.b(this);
        boolean z3 = false;
        Drawable drawable3 = b2[0];
        Drawable drawable4 = b2[1];
        Drawable drawable5 = b2[2];
        if ((d() && drawable3 != this.f18683j) || ((e() && drawable5 != this.f18683j) || (f() && drawable4 != this.f18683j))) {
            z3 = true;
        }
        if (z3) {
            c();
        }
    }

    private boolean b() {
        return ac.i(this) == 1;
    }

    private void c() {
        if (d()) {
            j.a(this, this.f18683j, (Drawable) null, (Drawable) null, (Drawable) null);
        } else if (e()) {
            j.a(this, (Drawable) null, (Drawable) null, this.f18683j, (Drawable) null);
        } else if (f()) {
            j.a(this, (Drawable) null, this.f18683j, (Drawable) null, (Drawable) null);
        }
    }

    private boolean d() {
        int i2 = this.f18690q;
        return i2 == 1 || i2 == 2;
    }

    private boolean e() {
        int i2 = this.f18690q;
        return i2 == 3 || i2 == 4;
    }

    private boolean f() {
        int i2 = this.f18690q;
        return i2 == 16 || i2 == 32;
    }

    private boolean g() {
        a aVar = this.f18678e;
        return aVar != null && !aVar.b();
    }

    private String getA11yClassName() {
        return (a() ? CompoundButton.class : Button.class).getName();
    }

    private int getTextHeight() {
        TextPaint paint = getPaint();
        String charSequence = getText().toString();
        if (getTransformationMethod() != null) {
            charSequence = getTransformationMethod().getTransformation(charSequence, this).toString();
        }
        Rect rect = new Rect();
        paint.getTextBounds(charSequence, 0, charSequence.length(), rect);
        return Math.min(rect.height(), getLayout().getHeight());
    }

    private int getTextWidth() {
        TextPaint paint = getPaint();
        String charSequence = getText().toString();
        if (getTransformationMethod() != null) {
            charSequence = getTransformationMethod().getTransformation(charSequence, this).toString();
        }
        return Math.min((int) paint.measureText(charSequence), getLayout().getEllipsizedWidth());
    }

    public void a(a aVar) {
        this.f18679f.add(aVar);
    }

    public boolean a() {
        a aVar = this.f18678e;
        return aVar != null && aVar.j();
    }

    public void b(a aVar) {
        this.f18679f.remove(aVar);
    }

    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    public int getCornerRadius() {
        if (g()) {
            return this.f18678e.h();
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.f18683j;
    }

    public int getIconGravity() {
        return this.f18690q;
    }

    public int getIconPadding() {
        return this.f18687n;
    }

    public int getIconSize() {
        return this.f18684k;
    }

    public ColorStateList getIconTint() {
        return this.f18682i;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f18681h;
    }

    public int getInsetBottom() {
        return this.f18678e.m();
    }

    public int getInsetTop() {
        return this.f18678e.n();
    }

    public ColorStateList getRippleColor() {
        if (g()) {
            return this.f18678e.e();
        }
        return null;
    }

    public m getShapeAppearanceModel() {
        if (g()) {
            return this.f18678e.l();
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (g()) {
            return this.f18678e.f();
        }
        return null;
    }

    public int getStrokeWidth() {
        if (g()) {
            return this.f18678e.g();
        }
        return 0;
    }

    public ColorStateList getSupportBackgroundTintList() {
        return g() ? this.f18678e.c() : super.getSupportBackgroundTintList();
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return g() ? this.f18678e.d() : super.getSupportBackgroundTintMode();
    }

    public boolean isChecked() {
        return this.f18688o;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (g()) {
            i.a((View) this, this.f18678e.i());
        }
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 2);
        if (a()) {
            mergeDrawableStates(onCreateDrawableState, f18675a);
        }
        if (isChecked()) {
            mergeDrawableStates(onCreateDrawableState, f18676b);
        }
        return onCreateDrawableState;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(isChecked());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        accessibilityNodeInfo.setCheckable(a());
        accessibilityNodeInfo.setChecked(isChecked());
        accessibilityNodeInfo.setClickable(isClickable());
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        a aVar;
        super.onLayout(z2, i2, i3, i4, i5);
        if (Build.VERSION.SDK_INT == 21 && (aVar = this.f18678e) != null) {
            aVar.a(i5 - i3, i4 - i2);
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        setChecked(savedState.f18691a);
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f18691a = this.f18688o;
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        a(i2, i3);
    }

    /* access modifiers changed from: protected */
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        super.onTextChanged(charSequence, i2, i3, i4);
        a(getMeasuredWidth(), getMeasuredHeight());
    }

    public boolean performClick() {
        toggle();
        return super.performClick();
    }

    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    public void setBackgroundColor(int i2) {
        if (g()) {
            this.f18678e.a(i2);
        } else {
            super.setBackgroundColor(i2);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (g()) {
            if (drawable != getBackground()) {
                Log.w("MaterialButton", "MaterialButton manages its own background to control elevation, shape, color and states. Consider using backgroundTint, shapeAppearance and other attributes where available. A custom background will ignore these attributes and you should consider handling interaction states such as pressed, focused and disabled");
                this.f18678e.a();
            } else {
                getBackground().setState(drawable.getState());
                return;
            }
        }
        super.setBackgroundDrawable(drawable);
    }

    public void setBackgroundResource(int i2) {
        setBackgroundDrawable(i2 != 0 ? c.a.b(getContext(), i2) : null);
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z2) {
        if (g()) {
            this.f18678e.b(z2);
        }
    }

    public void setChecked(boolean z2) {
        if (a() && isEnabled() && this.f18688o != z2) {
            this.f18688o = z2;
            refreshDrawableState();
            if (!this.f18689p) {
                this.f18689p = true;
                Iterator it2 = this.f18679f.iterator();
                while (it2.hasNext()) {
                    ((a) it2.next()).a(this, this.f18688o);
                }
                this.f18689p = false;
            }
        }
    }

    public void setCornerRadius(int i2) {
        if (g()) {
            this.f18678e.c(i2);
        }
    }

    public void setCornerRadiusResource(int i2) {
        if (g()) {
            setCornerRadius(getResources().getDimensionPixelSize(i2));
        }
    }

    public void setElevation(float f2) {
        super.setElevation(f2);
        if (g()) {
            this.f18678e.i().r(f2);
        }
    }

    public void setIcon(Drawable drawable) {
        if (this.f18683j != drawable) {
            this.f18683j = drawable;
            a(true);
            a(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconGravity(int i2) {
        if (this.f18690q != i2) {
            this.f18690q = i2;
            a(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconPadding(int i2) {
        if (this.f18687n != i2) {
            this.f18687n = i2;
            setCompoundDrawablePadding(i2);
        }
    }

    public void setIconResource(int i2) {
        setIcon(i2 != 0 ? c.a.b(getContext(), i2) : null);
    }

    public void setIconSize(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        } else if (this.f18684k != i2) {
            this.f18684k = i2;
            a(true);
        }
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.f18682i != colorStateList) {
            this.f18682i = colorStateList;
            a(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.f18681h != mode) {
            this.f18681h = mode;
            a(false);
        }
    }

    public void setIconTintResource(int i2) {
        setIconTint(c.a.a(getContext(), i2));
    }

    public void setInsetBottom(int i2) {
        this.f18678e.d(i2);
    }

    public void setInsetTop(int i2) {
        this.f18678e.e(i2);
    }

    /* access modifiers changed from: package-private */
    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    /* access modifiers changed from: package-private */
    public void setOnPressedChangeListenerInternal(b bVar) {
        this.f18680g = bVar;
    }

    public void setPressed(boolean z2) {
        b bVar = this.f18680g;
        if (bVar != null) {
            bVar.a(this, z2);
        }
        super.setPressed(z2);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (g()) {
            this.f18678e.b(colorStateList);
        }
    }

    public void setRippleColorResource(int i2) {
        if (g()) {
            setRippleColor(c.a.a(getContext(), i2));
        }
    }

    public void setShapeAppearanceModel(m mVar) {
        if (g()) {
            this.f18678e.a(mVar);
            return;
        }
        throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
    }

    /* access modifiers changed from: package-private */
    public void setShouldDrawSurfaceColorStroke(boolean z2) {
        if (g()) {
            this.f18678e.a(z2);
        }
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (g()) {
            this.f18678e.c(colorStateList);
        }
    }

    public void setStrokeColorResource(int i2) {
        if (g()) {
            setStrokeColor(c.a.a(getContext(), i2));
        }
    }

    public void setStrokeWidth(int i2) {
        if (g()) {
            this.f18678e.b(i2);
        }
    }

    public void setStrokeWidthResource(int i2) {
        if (g()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i2));
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (g()) {
            this.f18678e.a(colorStateList);
        } else {
            super.setSupportBackgroundTintList(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (g()) {
            this.f18678e.a(mode);
        } else {
            super.setSupportBackgroundTintMode(mode);
        }
    }

    public void toggle() {
        setChecked(!this.f18688o);
    }
}
