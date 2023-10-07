package com.google.android.material.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.appcompat.widget.af;
import androidx.customview.view.AbsSavedState;
import com.blankj.utilcode.constant.MemoryConstants;
import com.google.android.material.R;
import com.google.android.material.internal.ScrimInsetsFrameLayout;
import com.google.android.material.internal.b;
import com.google.android.material.internal.e;
import com.google.android.material.internal.f;
import f.g;
import gt.c;
import gw.h;
import gw.i;
import gw.m;
import t.ak;

public class NavigationView extends ScrimInsetsFrameLayout {

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f19398d = {16842912};

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f19399e = {-16842910};

    /* renamed from: f  reason: collision with root package name */
    private static final int f19400f = R.style.Widget_Design_NavigationView;

    /* renamed from: c  reason: collision with root package name */
    a f19401c;

    /* renamed from: g  reason: collision with root package name */
    private final e f19402g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final f f19403h;

    /* renamed from: i  reason: collision with root package name */
    private final int f19404i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final int[] f19405j;

    /* renamed from: k  reason: collision with root package name */
    private MenuInflater f19406k;

    /* renamed from: l  reason: collision with root package name */
    private ViewTreeObserver.OnGlobalLayoutListener f19407l;

    public static class SavedState extends AbsSavedState {
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
        public Bundle f19410a;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f19410a = parcel.readBundle(classLoader);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeBundle(this.f19410a);
        }
    }

    public interface a {
        boolean a(MenuItem menuItem);
    }

    public NavigationView(Context context) {
        this(context, (AttributeSet) null);
    }

    public NavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.navigationViewStyle);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public NavigationView(android.content.Context r11, android.util.AttributeSet r12, int r13) {
        /*
            r10 = this;
            int r6 = f19400f
            android.content.Context r11 = gx.a.a(r11, r12, r13, r6)
            r10.<init>(r11, r12, r13)
            com.google.android.material.internal.f r11 = new com.google.android.material.internal.f
            r11.<init>()
            r10.f19403h = r11
            r0 = 2
            int[] r0 = new int[r0]
            r10.f19405j = r0
            android.content.Context r7 = r10.getContext()
            com.google.android.material.internal.e r8 = new com.google.android.material.internal.e
            r8.<init>(r7)
            r10.f19402g = r8
            int[] r2 = com.google.android.material.R.styleable.NavigationView
            r9 = 0
            int[] r5 = new int[r9]
            r0 = r7
            r1 = r12
            r3 = r13
            r4 = r6
            androidx.appcompat.widget.af r0 = com.google.android.material.internal.l.b(r0, r1, r2, r3, r4, r5)
            int r1 = com.google.android.material.R.styleable.NavigationView_android_background
            boolean r1 = r0.g(r1)
            if (r1 == 0) goto L_0x003e
            int r1 = com.google.android.material.R.styleable.NavigationView_android_background
            android.graphics.drawable.Drawable r1 = r0.a(r1)
            t.ac.a((android.view.View) r10, (android.graphics.drawable.Drawable) r1)
        L_0x003e:
            android.graphics.drawable.Drawable r1 = r10.getBackground()
            if (r1 == 0) goto L_0x004c
            android.graphics.drawable.Drawable r1 = r10.getBackground()
            boolean r1 = r1 instanceof android.graphics.drawable.ColorDrawable
            if (r1 == 0) goto L_0x0074
        L_0x004c:
            gw.m$a r12 = gw.m.a((android.content.Context) r7, (android.util.AttributeSet) r12, (int) r13, (int) r6)
            gw.m r12 = r12.a()
            android.graphics.drawable.Drawable r13 = r10.getBackground()
            gw.h r1 = new gw.h
            r1.<init>((gw.m) r12)
            boolean r12 = r13 instanceof android.graphics.drawable.ColorDrawable
            if (r12 == 0) goto L_0x006e
            android.graphics.drawable.ColorDrawable r13 = (android.graphics.drawable.ColorDrawable) r13
            int r12 = r13.getColor()
            android.content.res.ColorStateList r12 = android.content.res.ColorStateList.valueOf(r12)
            r1.g((android.content.res.ColorStateList) r12)
        L_0x006e:
            r1.a((android.content.Context) r7)
            t.ac.a((android.view.View) r10, (android.graphics.drawable.Drawable) r1)
        L_0x0074:
            int r12 = com.google.android.material.R.styleable.NavigationView_elevation
            boolean r12 = r0.g(r12)
            if (r12 == 0) goto L_0x0086
            int r12 = com.google.android.material.R.styleable.NavigationView_elevation
            int r12 = r0.e(r12, r9)
            float r12 = (float) r12
            r10.setElevation(r12)
        L_0x0086:
            int r12 = com.google.android.material.R.styleable.NavigationView_android_fitsSystemWindows
            boolean r12 = r0.a((int) r12, (boolean) r9)
            r10.setFitsSystemWindows(r12)
            int r12 = com.google.android.material.R.styleable.NavigationView_android_maxWidth
            int r12 = r0.e(r12, r9)
            r10.f19404i = r12
            int r12 = com.google.android.material.R.styleable.NavigationView_itemIconTint
            boolean r12 = r0.g(r12)
            if (r12 == 0) goto L_0x00a6
            int r12 = com.google.android.material.R.styleable.NavigationView_itemIconTint
            android.content.res.ColorStateList r12 = r0.e(r12)
            goto L_0x00ad
        L_0x00a6:
            r12 = 16842808(0x1010038, float:2.3693715E-38)
            android.content.res.ColorStateList r12 = r10.c(r12)
        L_0x00ad:
            int r13 = com.google.android.material.R.styleable.NavigationView_itemTextAppearance
            boolean r13 = r0.g(r13)
            r1 = 1
            if (r13 == 0) goto L_0x00be
            int r13 = com.google.android.material.R.styleable.NavigationView_itemTextAppearance
            int r13 = r0.g(r13, r9)
            r2 = 1
            goto L_0x00c0
        L_0x00be:
            r13 = 0
            r2 = 0
        L_0x00c0:
            int r3 = com.google.android.material.R.styleable.NavigationView_itemIconSize
            boolean r3 = r0.g(r3)
            if (r3 == 0) goto L_0x00d1
            int r3 = com.google.android.material.R.styleable.NavigationView_itemIconSize
            int r3 = r0.e(r3, r9)
            r10.setItemIconSize(r3)
        L_0x00d1:
            r3 = 0
            int r4 = com.google.android.material.R.styleable.NavigationView_itemTextColor
            boolean r4 = r0.g(r4)
            if (r4 == 0) goto L_0x00e0
            int r3 = com.google.android.material.R.styleable.NavigationView_itemTextColor
            android.content.res.ColorStateList r3 = r0.e(r3)
        L_0x00e0:
            if (r2 != 0) goto L_0x00eb
            if (r3 != 0) goto L_0x00eb
            r3 = 16842806(0x1010036, float:2.369371E-38)
            android.content.res.ColorStateList r3 = r10.c(r3)
        L_0x00eb:
            int r4 = com.google.android.material.R.styleable.NavigationView_itemBackground
            android.graphics.drawable.Drawable r4 = r0.a(r4)
            if (r4 != 0) goto L_0x00fd
            boolean r5 = r10.a((androidx.appcompat.widget.af) r0)
            if (r5 == 0) goto L_0x00fd
            android.graphics.drawable.Drawable r4 = r10.b((androidx.appcompat.widget.af) r0)
        L_0x00fd:
            int r5 = com.google.android.material.R.styleable.NavigationView_itemHorizontalPadding
            boolean r5 = r0.g(r5)
            if (r5 == 0) goto L_0x010e
            int r5 = com.google.android.material.R.styleable.NavigationView_itemHorizontalPadding
            int r5 = r0.e(r5, r9)
            r11.d(r5)
        L_0x010e:
            int r5 = com.google.android.material.R.styleable.NavigationView_itemIconPadding
            int r5 = r0.e(r5, r9)
            int r6 = com.google.android.material.R.styleable.NavigationView_itemMaxLines
            int r6 = r0.a((int) r6, (int) r1)
            r10.setItemMaxLines(r6)
            com.google.android.material.navigation.NavigationView$1 r6 = new com.google.android.material.navigation.NavigationView$1
            r6.<init>()
            r8.a((androidx.appcompat.view.menu.g.a) r6)
            r11.a((int) r1)
            r11.a((android.content.Context) r7, (androidx.appcompat.view.menu.g) r8)
            r11.a((android.content.res.ColorStateList) r12)
            int r12 = r10.getOverScrollMode()
            r11.h(r12)
            if (r2 == 0) goto L_0x013a
            r11.c((int) r13)
        L_0x013a:
            r11.b((android.content.res.ColorStateList) r3)
            r11.a((android.graphics.drawable.Drawable) r4)
            r11.e(r5)
            r8.a((androidx.appcompat.view.menu.m) r11)
            androidx.appcompat.view.menu.n r11 = r11.a((android.view.ViewGroup) r10)
            android.view.View r11 = (android.view.View) r11
            r10.addView(r11)
            int r11 = com.google.android.material.R.styleable.NavigationView_menu
            boolean r11 = r0.g(r11)
            if (r11 == 0) goto L_0x0160
            int r11 = com.google.android.material.R.styleable.NavigationView_menu
            int r11 = r0.g(r11, r9)
            r10.a((int) r11)
        L_0x0160:
            int r11 = com.google.android.material.R.styleable.NavigationView_headerLayout
            boolean r11 = r0.g(r11)
            if (r11 == 0) goto L_0x0171
            int r11 = com.google.android.material.R.styleable.NavigationView_headerLayout
            int r11 = r0.g(r11, r9)
            r10.b((int) r11)
        L_0x0171:
            r0.b()
            r10.a()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.navigation.NavigationView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    private void a() {
        this.f19407l = new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                NavigationView navigationView = NavigationView.this;
                navigationView.getLocationOnScreen(navigationView.f19405j);
                boolean z2 = true;
                boolean z3 = NavigationView.this.f19405j[1] == 0;
                NavigationView.this.f19403h.c(z3);
                NavigationView.this.setDrawTopInsetForeground(z3);
                Activity a2 = b.a(NavigationView.this.getContext());
                if (a2 != null && Build.VERSION.SDK_INT >= 21) {
                    boolean z4 = a2.findViewById(16908290).getHeight() == NavigationView.this.getHeight();
                    boolean z5 = Color.alpha(a2.getWindow().getNavigationBarColor()) != 0;
                    NavigationView navigationView2 = NavigationView.this;
                    if (!z4 || !z5) {
                        z2 = false;
                    }
                    navigationView2.setDrawBottomInsetForeground(z2);
                }
            }
        };
        getViewTreeObserver().addOnGlobalLayoutListener(this.f19407l);
    }

    private boolean a(af afVar) {
        return afVar.g(R.styleable.NavigationView_itemShapeAppearance) || afVar.g(R.styleable.NavigationView_itemShapeAppearanceOverlay);
    }

    private final Drawable b(af afVar) {
        h hVar = new h(m.a(getContext(), afVar.g(R.styleable.NavigationView_itemShapeAppearance, 0), afVar.g(R.styleable.NavigationView_itemShapeAppearanceOverlay, 0)).a());
        hVar.g(c.a(getContext(), afVar, R.styleable.NavigationView_itemShapeFillColor));
        return new InsetDrawable(hVar, afVar.e(R.styleable.NavigationView_itemShapeInsetStart, 0), afVar.e(R.styleable.NavigationView_itemShapeInsetTop, 0), afVar.e(R.styleable.NavigationView_itemShapeInsetEnd, 0), afVar.e(R.styleable.NavigationView_itemShapeInsetBottom, 0));
    }

    private ColorStateList c(int i2) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i2, typedValue, true)) {
            return null;
        }
        ColorStateList a2 = c.a.a(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(androidx.appcompat.R.attr.colorPrimary, typedValue, true)) {
            return null;
        }
        int i3 = typedValue.data;
        int defaultColor = a2.getDefaultColor();
        int[] iArr = f19399e;
        return new ColorStateList(new int[][]{iArr, f19398d, EMPTY_STATE_SET}, new int[]{a2.getColorForState(iArr, defaultColor), i3, defaultColor});
    }

    private MenuInflater getMenuInflater() {
        if (this.f19406k == null) {
            this.f19406k = new g(getContext());
        }
        return this.f19406k;
    }

    public void a(int i2) {
        this.f19403h.b(true);
        getMenuInflater().inflate(i2, this.f19402g);
        this.f19403h.b(false);
        this.f19403h.a(false);
    }

    /* access modifiers changed from: protected */
    public void a(ak akVar) {
        this.f19403h.a(akVar);
    }

    public View b(int i2) {
        return this.f19403h.b(i2);
    }

    public MenuItem getCheckedItem() {
        return this.f19403h.a();
    }

    public int getHeaderCount() {
        return this.f19403h.d();
    }

    public Drawable getItemBackground() {
        return this.f19403h.h();
    }

    public int getItemHorizontalPadding() {
        return this.f19403h.i();
    }

    public int getItemIconPadding() {
        return this.f19403h.j();
    }

    public ColorStateList getItemIconTintList() {
        return this.f19403h.e();
    }

    public int getItemMaxLines() {
        return this.f19403h.k();
    }

    public ColorStateList getItemTextColor() {
        return this.f19403h.g();
    }

    public Menu getMenu() {
        return this.f19402g;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        i.a((View) this);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (Build.VERSION.SDK_INT < 16) {
            getViewTreeObserver().removeGlobalOnLayoutListener(this.f19407l);
        } else {
            getViewTreeObserver().removeOnGlobalLayoutListener(this.f19407l);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int i4;
        int mode = View.MeasureSpec.getMode(i2);
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                i4 = this.f19404i;
            }
            super.onMeasure(i2, i3);
        }
        i4 = Math.min(View.MeasureSpec.getSize(i2), this.f19404i);
        i2 = View.MeasureSpec.makeMeasureSpec(i4, MemoryConstants.GB);
        super.onMeasure(i2, i3);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        this.f19402g.b(savedState.f19410a);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f19410a = new Bundle();
        this.f19402g.a(savedState.f19410a);
        return savedState;
    }

    public void setCheckedItem(int i2) {
        MenuItem findItem = this.f19402g.findItem(i2);
        if (findItem != null) {
            this.f19403h.a((androidx.appcompat.view.menu.i) findItem);
        }
    }

    public void setCheckedItem(MenuItem menuItem) {
        MenuItem findItem = this.f19402g.findItem(menuItem.getItemId());
        if (findItem != null) {
            this.f19403h.a((androidx.appcompat.view.menu.i) findItem);
            return;
        }
        throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
    }

    public void setElevation(float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            super.setElevation(f2);
        }
        i.a((View) this, f2);
    }

    public void setItemBackground(Drawable drawable) {
        this.f19403h.a(drawable);
    }

    public void setItemBackgroundResource(int i2) {
        setItemBackground(androidx.core.content.b.a(getContext(), i2));
    }

    public void setItemHorizontalPadding(int i2) {
        this.f19403h.d(i2);
    }

    public void setItemHorizontalPaddingResource(int i2) {
        this.f19403h.d(getResources().getDimensionPixelSize(i2));
    }

    public void setItemIconPadding(int i2) {
        this.f19403h.e(i2);
    }

    public void setItemIconPaddingResource(int i2) {
        this.f19403h.e(getResources().getDimensionPixelSize(i2));
    }

    public void setItemIconSize(int i2) {
        this.f19403h.g(i2);
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.f19403h.a(colorStateList);
    }

    public void setItemMaxLines(int i2) {
        this.f19403h.f(i2);
    }

    public void setItemTextAppearance(int i2) {
        this.f19403h.c(i2);
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.f19403h.b(colorStateList);
    }

    public void setNavigationItemSelectedListener(a aVar) {
        this.f19401c = aVar;
    }

    public void setOverScrollMode(int i2) {
        super.setOverScrollMode(i2);
        f fVar = this.f19403h;
        if (fVar != null) {
            fVar.h(i2);
        }
    }
}
