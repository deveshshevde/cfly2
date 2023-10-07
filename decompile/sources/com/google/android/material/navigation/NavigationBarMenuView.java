package com.google.android.material.navigation;

import aa.b;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.n;
import androidx.transition.AutoTransition;
import androidx.transition.Transition;
import androidx.transition.TransitionSet;
import androidx.transition.v;
import c.a;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.internal.j;
import java.util.HashSet;
import s.e;
import t.ac;
import u.c;

public abstract class NavigationBarMenuView extends ViewGroup implements n {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f19360a = {16842912};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f19361b = {-16842910};

    /* renamed from: c  reason: collision with root package name */
    private final TransitionSet f19362c;

    /* renamed from: d  reason: collision with root package name */
    private final View.OnClickListener f19363d;

    /* renamed from: e  reason: collision with root package name */
    private final e.a<NavigationBarItemView> f19364e = new e.c(5);

    /* renamed from: f  reason: collision with root package name */
    private final SparseArray<View.OnTouchListener> f19365f = new SparseArray<>(5);

    /* renamed from: g  reason: collision with root package name */
    private int f19366g;

    /* renamed from: h  reason: collision with root package name */
    private NavigationBarItemView[] f19367h;

    /* renamed from: i  reason: collision with root package name */
    private int f19368i = 0;

    /* renamed from: j  reason: collision with root package name */
    private int f19369j = 0;

    /* renamed from: k  reason: collision with root package name */
    private ColorStateList f19370k;

    /* renamed from: l  reason: collision with root package name */
    private int f19371l;

    /* renamed from: m  reason: collision with root package name */
    private ColorStateList f19372m;

    /* renamed from: n  reason: collision with root package name */
    private final ColorStateList f19373n = a(16842808);

    /* renamed from: o  reason: collision with root package name */
    private int f19374o;

    /* renamed from: p  reason: collision with root package name */
    private int f19375p;

    /* renamed from: q  reason: collision with root package name */
    private Drawable f19376q;

    /* renamed from: r  reason: collision with root package name */
    private int f19377r;

    /* renamed from: s  reason: collision with root package name */
    private SparseArray<BadgeDrawable> f19378s = new SparseArray<>(5);
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public NavigationBarPresenter f19379t;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public g f19380u;

    public NavigationBarMenuView(Context context) {
        super(context);
        AutoTransition autoTransition = new AutoTransition();
        this.f19362c = autoTransition;
        autoTransition.a(0);
        autoTransition.a(115);
        autoTransition.a((TimeInterpolator) new b());
        autoTransition.a((Transition) new j());
        this.f19363d = new View.OnClickListener() {
            public void onClick(View view) {
                i itemData = ((NavigationBarItemView) view).getItemData();
                if (!NavigationBarMenuView.this.f19380u.a((MenuItem) itemData, (m) NavigationBarMenuView.this.f19379t, 0)) {
                    itemData.setChecked(true);
                }
            }
        };
        ac.b((View) this, 1);
    }

    private void a() {
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < this.f19380u.size(); i2++) {
            hashSet.add(Integer.valueOf(this.f19380u.getItem(i2).getItemId()));
        }
        for (int i3 = 0; i3 < this.f19378s.size(); i3++) {
            int keyAt = this.f19378s.keyAt(i3);
            if (!hashSet.contains(Integer.valueOf(keyAt))) {
                this.f19378s.delete(keyAt);
            }
        }
    }

    private boolean c(int i2) {
        return i2 != -1;
    }

    private NavigationBarItemView getNewItem() {
        NavigationBarItemView a2 = this.f19364e.a();
        return a2 == null ? a(getContext()) : a2;
    }

    private void setBadgeIfNeeded(NavigationBarItemView navigationBarItemView) {
        BadgeDrawable badgeDrawable;
        int id2 = navigationBarItemView.getId();
        if (c(id2) && (badgeDrawable = this.f19378s.get(id2)) != null) {
            navigationBarItemView.setBadge(badgeDrawable);
        }
    }

    public ColorStateList a(int i2) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i2, typedValue, true)) {
            return null;
        }
        ColorStateList a2 = a.a(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(R.attr.colorPrimary, typedValue, true)) {
            return null;
        }
        int i3 = typedValue.data;
        int defaultColor = a2.getDefaultColor();
        int[] iArr = f19361b;
        return new ColorStateList(new int[][]{iArr, f19360a, EMPTY_STATE_SET}, new int[]{a2.getColorForState(iArr, defaultColor), i3, defaultColor});
    }

    /* access modifiers changed from: protected */
    public abstract NavigationBarItemView a(Context context);

    public void a(g gVar) {
        this.f19380u = gVar;
    }

    /* access modifiers changed from: protected */
    public boolean a(int i2, int i3) {
        if (i2 == -1) {
            if (i3 > 3) {
                return true;
            }
        } else if (i2 == 0) {
            return true;
        }
        return false;
    }

    public void b() {
        removeAllViews();
        NavigationBarItemView[] navigationBarItemViewArr = this.f19367h;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                if (navigationBarItemView != null) {
                    this.f19364e.a(navigationBarItemView);
                    navigationBarItemView.b();
                }
            }
        }
        if (this.f19380u.size() == 0) {
            this.f19368i = 0;
            this.f19369j = 0;
            this.f19367h = null;
            return;
        }
        a();
        this.f19367h = new NavigationBarItemView[this.f19380u.size()];
        boolean a2 = a(this.f19366g, this.f19380u.j().size());
        for (int i2 = 0; i2 < this.f19380u.size(); i2++) {
            this.f19379t.b(true);
            this.f19380u.getItem(i2).setCheckable(true);
            this.f19379t.b(false);
            NavigationBarItemView newItem = getNewItem();
            this.f19367h[i2] = newItem;
            newItem.setIconTintList(this.f19370k);
            newItem.setIconSize(this.f19371l);
            newItem.setTextColor(this.f19373n);
            newItem.setTextAppearanceInactive(this.f19374o);
            newItem.setTextAppearanceActive(this.f19375p);
            newItem.setTextColor(this.f19372m);
            Drawable drawable = this.f19376q;
            if (drawable != null) {
                newItem.setItemBackground(drawable);
            } else {
                newItem.setItemBackground(this.f19377r);
            }
            newItem.setShifting(a2);
            newItem.setLabelVisibilityMode(this.f19366g);
            i iVar = (i) this.f19380u.getItem(i2);
            newItem.a(iVar, 0);
            newItem.setItemPosition(i2);
            int itemId = iVar.getItemId();
            newItem.setOnTouchListener(this.f19365f.get(itemId));
            newItem.setOnClickListener(this.f19363d);
            int i3 = this.f19368i;
            if (i3 != 0 && itemId == i3) {
                this.f19369j = i2;
            }
            setBadgeIfNeeded(newItem);
            addView(newItem);
        }
        int min = Math.min(this.f19380u.size() - 1, this.f19369j);
        this.f19369j = min;
        this.f19380u.getItem(min).setChecked(true);
    }

    /* access modifiers changed from: package-private */
    public void b(int i2) {
        int size = this.f19380u.size();
        for (int i3 = 0; i3 < size; i3++) {
            MenuItem item = this.f19380u.getItem(i3);
            if (i2 == item.getItemId()) {
                this.f19368i = i2;
                this.f19369j = i3;
                item.setChecked(true);
                return;
            }
        }
    }

    public void c() {
        g gVar = this.f19380u;
        if (gVar != null && this.f19367h != null) {
            int size = gVar.size();
            if (size != this.f19367h.length) {
                b();
                return;
            }
            int i2 = this.f19368i;
            for (int i3 = 0; i3 < size; i3++) {
                MenuItem item = this.f19380u.getItem(i3);
                if (item.isChecked()) {
                    this.f19368i = item.getItemId();
                    this.f19369j = i3;
                }
            }
            if (i2 != this.f19368i) {
                v.a(this, this.f19362c);
            }
            boolean a2 = a(this.f19366g, this.f19380u.j().size());
            for (int i4 = 0; i4 < size; i4++) {
                this.f19379t.b(true);
                this.f19367h[i4].setLabelVisibilityMode(this.f19366g);
                this.f19367h[i4].setShifting(a2);
                this.f19367h[i4].a((i) this.f19380u.getItem(i4), 0);
                this.f19379t.b(false);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public SparseArray<BadgeDrawable> getBadgeDrawables() {
        return this.f19378s;
    }

    public ColorStateList getIconTintList() {
        return this.f19370k;
    }

    public Drawable getItemBackground() {
        NavigationBarItemView[] navigationBarItemViewArr = this.f19367h;
        return (navigationBarItemViewArr == null || navigationBarItemViewArr.length <= 0) ? this.f19376q : navigationBarItemViewArr[0].getBackground();
    }

    @Deprecated
    public int getItemBackgroundRes() {
        return this.f19377r;
    }

    public int getItemIconSize() {
        return this.f19371l;
    }

    public int getItemTextAppearanceActive() {
        return this.f19375p;
    }

    public int getItemTextAppearanceInactive() {
        return this.f19374o;
    }

    public ColorStateList getItemTextColor() {
        return this.f19372m;
    }

    public int getLabelVisibilityMode() {
        return this.f19366g;
    }

    /* access modifiers changed from: protected */
    public g getMenu() {
        return this.f19380u;
    }

    public int getSelectedItemId() {
        return this.f19368i;
    }

    /* access modifiers changed from: protected */
    public int getSelectedItemPosition() {
        return this.f19369j;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        c.a(accessibilityNodeInfo).a((Object) c.b.a(1, this.f19380u.j().size(), false, 1));
    }

    /* access modifiers changed from: package-private */
    public void setBadgeDrawables(SparseArray<BadgeDrawable> sparseArray) {
        this.f19378s = sparseArray;
        NavigationBarItemView[] navigationBarItemViewArr = this.f19367h;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setBadge(sparseArray.get(navigationBarItemView.getId()));
            }
        }
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.f19370k = colorStateList;
        NavigationBarItemView[] navigationBarItemViewArr = this.f19367h;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView iconTintList : navigationBarItemViewArr) {
                iconTintList.setIconTintList(colorStateList);
            }
        }
    }

    public void setItemBackground(Drawable drawable) {
        this.f19376q = drawable;
        NavigationBarItemView[] navigationBarItemViewArr = this.f19367h;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView itemBackground : navigationBarItemViewArr) {
                itemBackground.setItemBackground(drawable);
            }
        }
    }

    public void setItemBackgroundRes(int i2) {
        this.f19377r = i2;
        NavigationBarItemView[] navigationBarItemViewArr = this.f19367h;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView itemBackground : navigationBarItemViewArr) {
                itemBackground.setItemBackground(i2);
            }
        }
    }

    public void setItemIconSize(int i2) {
        this.f19371l = i2;
        NavigationBarItemView[] navigationBarItemViewArr = this.f19367h;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView iconSize : navigationBarItemViewArr) {
                iconSize.setIconSize(i2);
            }
        }
    }

    public void setItemTextAppearanceActive(int i2) {
        this.f19375p = i2;
        NavigationBarItemView[] navigationBarItemViewArr = this.f19367h;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setTextAppearanceActive(i2);
                ColorStateList colorStateList = this.f19372m;
                if (colorStateList != null) {
                    navigationBarItemView.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextAppearanceInactive(int i2) {
        this.f19374o = i2;
        NavigationBarItemView[] navigationBarItemViewArr = this.f19367h;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setTextAppearanceInactive(i2);
                ColorStateList colorStateList = this.f19372m;
                if (colorStateList != null) {
                    navigationBarItemView.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.f19372m = colorStateList;
        NavigationBarItemView[] navigationBarItemViewArr = this.f19367h;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView textColor : navigationBarItemViewArr) {
                textColor.setTextColor(colorStateList);
            }
        }
    }

    public void setLabelVisibilityMode(int i2) {
        this.f19366g = i2;
    }

    public void setPresenter(NavigationBarPresenter navigationBarPresenter) {
        this.f19379t = navigationBarPresenter;
    }
}
