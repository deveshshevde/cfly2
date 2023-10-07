package com.google.android.material.navigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.widget.af;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.internal.l;
import com.google.android.material.internal.s;
import gt.c;
import gw.h;
import gw.i;
import t.ac;
import t.ak;

public abstract class NavigationBarView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private final a f19388a;

    /* renamed from: b  reason: collision with root package name */
    private final NavigationBarMenuView f19389b;

    /* renamed from: c  reason: collision with root package name */
    private final NavigationBarPresenter f19390c;

    /* renamed from: d  reason: collision with root package name */
    private ColorStateList f19391d;

    /* renamed from: e  reason: collision with root package name */
    private MenuInflater f19392e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public b f19393f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public a f19394g;

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
        Bundle f19397a;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            a(parcel, classLoader == null ? getClass().getClassLoader() : classLoader);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private void a(Parcel parcel, ClassLoader classLoader) {
            this.f19397a = parcel.readBundle(classLoader);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeBundle(this.f19397a);
        }
    }

    public interface a {
        void a(MenuItem menuItem);
    }

    public interface b {
        boolean a(MenuItem menuItem);
    }

    public NavigationBarView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(gx.a.a(context, attributeSet, i2, i3), attributeSet, i2);
        NavigationBarPresenter navigationBarPresenter = new NavigationBarPresenter();
        this.f19390c = navigationBarPresenter;
        Context context2 = getContext();
        af b2 = l.b(context2, attributeSet, R.styleable.NavigationBarView, i2, i3, R.styleable.NavigationBarView_itemTextAppearanceInactive, R.styleable.NavigationBarView_itemTextAppearanceActive);
        a aVar = new a(context2, getClass(), getMaxItemCount());
        this.f19388a = aVar;
        NavigationBarMenuView a2 = a(context2);
        this.f19389b = a2;
        navigationBarPresenter.a(a2);
        navigationBarPresenter.a(1);
        a2.setPresenter(navigationBarPresenter);
        aVar.a((m) navigationBarPresenter);
        navigationBarPresenter.a(getContext(), (g) aVar);
        a2.setIconTintList(b2.g(R.styleable.NavigationBarView_itemIconTint) ? b2.e(R.styleable.NavigationBarView_itemIconTint) : a2.a(16842808));
        setItemIconSize(b2.e(R.styleable.NavigationBarView_itemIconSize, getResources().getDimensionPixelSize(R.dimen.mtrl_navigation_bar_item_default_icon_size)));
        if (b2.g(R.styleable.NavigationBarView_itemTextAppearanceInactive)) {
            setItemTextAppearanceInactive(b2.g(R.styleable.NavigationBarView_itemTextAppearanceInactive, 0));
        }
        if (b2.g(R.styleable.NavigationBarView_itemTextAppearanceActive)) {
            setItemTextAppearanceActive(b2.g(R.styleable.NavigationBarView_itemTextAppearanceActive, 0));
        }
        if (b2.g(R.styleable.NavigationBarView_itemTextColor)) {
            setItemTextColor(b2.e(R.styleable.NavigationBarView_itemTextColor));
        }
        if (getBackground() == null || (getBackground() instanceof ColorDrawable)) {
            ac.a((View) this, (Drawable) b(context2));
        }
        if (b2.g(R.styleable.NavigationBarView_elevation)) {
            setElevation((float) b2.e(R.styleable.NavigationBarView_elevation, 0));
        }
        androidx.core.graphics.drawable.a.a(getBackground().mutate(), c.a(context2, b2, R.styleable.NavigationBarView_backgroundTint));
        setLabelVisibilityMode(b2.c(R.styleable.NavigationBarView_labelVisibilityMode, -1));
        int g2 = b2.g(R.styleable.NavigationBarView_itemBackground, 0);
        if (g2 != 0) {
            a2.setItemBackgroundRes(g2);
        } else {
            setItemRippleColor(c.a(context2, b2, R.styleable.NavigationBarView_itemRippleColor));
        }
        if (b2.g(R.styleable.NavigationBarView_menu)) {
            a(b2.g(R.styleable.NavigationBarView_menu, 0));
        }
        b2.b();
        addView(a2);
        aVar.a((g.a) new g.a() {
            public void a(g gVar) {
            }

            public boolean a(g gVar, MenuItem menuItem) {
                if (NavigationBarView.this.f19394g == null || menuItem.getItemId() != NavigationBarView.this.getSelectedItemId()) {
                    return NavigationBarView.this.f19393f != null && !NavigationBarView.this.f19393f.a(menuItem);
                }
                NavigationBarView.this.f19394g.a(menuItem);
                return true;
            }
        });
        a();
    }

    private void a() {
        s.a((View) this, (s.a) new s.a() {
            public ak a(View view, ak akVar, s.b bVar) {
                bVar.f19341d += akVar.d();
                boolean z2 = true;
                if (ac.i(view) != 1) {
                    z2 = false;
                }
                int a2 = akVar.a();
                int c2 = akVar.c();
                bVar.f19338a += z2 ? c2 : a2;
                int i2 = bVar.f19340c;
                if (!z2) {
                    a2 = c2;
                }
                bVar.f19340c = i2 + a2;
                bVar.a(view);
                return akVar;
            }
        });
    }

    private h b(Context context) {
        h hVar = new h();
        Drawable background = getBackground();
        if (background instanceof ColorDrawable) {
            hVar.g(ColorStateList.valueOf(((ColorDrawable) background).getColor()));
        }
        hVar.a(context);
        return hVar;
    }

    private MenuInflater getMenuInflater() {
        if (this.f19392e == null) {
            this.f19392e = new f.g(getContext());
        }
        return this.f19392e;
    }

    /* access modifiers changed from: protected */
    public abstract NavigationBarMenuView a(Context context);

    public void a(int i2) {
        this.f19390c.b(true);
        getMenuInflater().inflate(i2, this.f19388a);
        this.f19390c.b(false);
        this.f19390c.a(true);
    }

    public Drawable getItemBackground() {
        return this.f19389b.getItemBackground();
    }

    @Deprecated
    public int getItemBackgroundResource() {
        return this.f19389b.getItemBackgroundRes();
    }

    public int getItemIconSize() {
        return this.f19389b.getItemIconSize();
    }

    public ColorStateList getItemIconTintList() {
        return this.f19389b.getIconTintList();
    }

    public ColorStateList getItemRippleColor() {
        return this.f19391d;
    }

    public int getItemTextAppearanceActive() {
        return this.f19389b.getItemTextAppearanceActive();
    }

    public int getItemTextAppearanceInactive() {
        return this.f19389b.getItemTextAppearanceInactive();
    }

    public ColorStateList getItemTextColor() {
        return this.f19389b.getItemTextColor();
    }

    public int getLabelVisibilityMode() {
        return this.f19389b.getLabelVisibilityMode();
    }

    public abstract int getMaxItemCount();

    public Menu getMenu() {
        return this.f19388a;
    }

    public n getMenuView() {
        return this.f19389b;
    }

    /* access modifiers changed from: protected */
    public NavigationBarPresenter getPresenter() {
        return this.f19390c;
    }

    public int getSelectedItemId() {
        return this.f19389b.getSelectedItemId();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        i.a((View) this);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        this.f19388a.b(savedState.f19397a);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f19397a = new Bundle();
        this.f19388a.a(savedState.f19397a);
        return savedState;
    }

    public void setElevation(float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            super.setElevation(f2);
        }
        i.a((View) this, f2);
    }

    public void setItemBackground(Drawable drawable) {
        this.f19389b.setItemBackground(drawable);
        this.f19391d = null;
    }

    public void setItemBackgroundResource(int i2) {
        this.f19389b.setItemBackgroundRes(i2);
        this.f19391d = null;
    }

    public void setItemIconSize(int i2) {
        this.f19389b.setItemIconSize(i2);
    }

    public void setItemIconSizeRes(int i2) {
        setItemIconSize(getResources().getDimensionPixelSize(i2));
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.f19389b.setIconTintList(colorStateList);
    }

    public void setItemRippleColor(ColorStateList colorStateList) {
        if (this.f19391d != colorStateList) {
            this.f19391d = colorStateList;
            if (colorStateList == null) {
                this.f19389b.setItemBackground((Drawable) null);
                return;
            }
            ColorStateList a2 = gu.b.a(colorStateList);
            if (Build.VERSION.SDK_INT >= 21) {
                this.f19389b.setItemBackground(new RippleDrawable(a2, (Drawable) null, (Drawable) null));
                return;
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(1.0E-5f);
            Drawable g2 = androidx.core.graphics.drawable.a.g(gradientDrawable);
            androidx.core.graphics.drawable.a.a(g2, a2);
            this.f19389b.setItemBackground(g2);
        } else if (colorStateList == null && this.f19389b.getItemBackground() != null) {
            this.f19389b.setItemBackground((Drawable) null);
        }
    }

    public void setItemTextAppearanceActive(int i2) {
        this.f19389b.setItemTextAppearanceActive(i2);
    }

    public void setItemTextAppearanceInactive(int i2) {
        this.f19389b.setItemTextAppearanceInactive(i2);
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.f19389b.setItemTextColor(colorStateList);
    }

    public void setLabelVisibilityMode(int i2) {
        if (this.f19389b.getLabelVisibilityMode() != i2) {
            this.f19389b.setLabelVisibilityMode(i2);
            this.f19390c.a(false);
        }
    }

    public void setOnItemReselectedListener(a aVar) {
        this.f19394g = aVar;
    }

    public void setOnItemSelectedListener(b bVar) {
        this.f19393f = bVar;
    }

    public void setSelectedItemId(int i2) {
        MenuItem findItem = this.f19388a.findItem(i2);
        if (findItem != null && !this.f19388a.a(findItem, (m) this.f19390c, 0)) {
            findItem.setChecked(true);
        }
    }
}
