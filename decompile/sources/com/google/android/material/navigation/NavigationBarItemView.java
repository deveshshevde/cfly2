package com.google.android.material.navigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.widget.ah;
import androidx.core.content.b;
import androidx.core.widget.j;
import com.google.android.material.R;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.a;
import t.ac;
import t.y;
import u.c;

public abstract class NavigationBarItemView extends FrameLayout implements n.a {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f19342a = {16842912};

    /* renamed from: b  reason: collision with root package name */
    private final int f19343b;

    /* renamed from: c  reason: collision with root package name */
    private float f19344c;

    /* renamed from: d  reason: collision with root package name */
    private float f19345d;

    /* renamed from: e  reason: collision with root package name */
    private float f19346e;

    /* renamed from: f  reason: collision with root package name */
    private int f19347f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f19348g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public ImageView f19349h;

    /* renamed from: i  reason: collision with root package name */
    private final ViewGroup f19350i;

    /* renamed from: j  reason: collision with root package name */
    private final TextView f19351j;

    /* renamed from: k  reason: collision with root package name */
    private final TextView f19352k;

    /* renamed from: l  reason: collision with root package name */
    private int f19353l = -1;

    /* renamed from: m  reason: collision with root package name */
    private i f19354m;

    /* renamed from: n  reason: collision with root package name */
    private ColorStateList f19355n;

    /* renamed from: o  reason: collision with root package name */
    private Drawable f19356o;

    /* renamed from: p  reason: collision with root package name */
    private Drawable f19357p;

    /* renamed from: q  reason: collision with root package name */
    private BadgeDrawable f19358q;

    public NavigationBarItemView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(getItemLayoutResId(), this, true);
        this.f19349h = (ImageView) findViewById(R.id.navigation_bar_item_icon_view);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.navigation_bar_item_labels_group);
        this.f19350i = viewGroup;
        TextView textView = (TextView) findViewById(R.id.navigation_bar_item_small_label_view);
        this.f19351j = textView;
        TextView textView2 = (TextView) findViewById(R.id.navigation_bar_item_large_label_view);
        this.f19352k = textView2;
        setBackgroundResource(getItemBackgroundResId());
        this.f19343b = getResources().getDimensionPixelSize(getItemDefaultMarginResId());
        viewGroup.setTag(R.id.mtrl_view_tag_bottom_padding, Integer.valueOf(viewGroup.getPaddingBottom()));
        ac.b((View) textView, 2);
        ac.b((View) textView2, 2);
        setFocusable(true);
        a(textView.getTextSize(), textView2.getTextSize());
        ImageView imageView = this.f19349h;
        if (imageView != null) {
            imageView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                    if (NavigationBarItemView.this.f19349h.getVisibility() == 0) {
                        NavigationBarItemView navigationBarItemView = NavigationBarItemView.this;
                        navigationBarItemView.a((View) navigationBarItemView.f19349h);
                    }
                }
            });
        }
    }

    private void a(float f2, float f3) {
        this.f19344c = f2 - f3;
        this.f19345d = (f3 * 1.0f) / f2;
        this.f19346e = (f2 * 1.0f) / f3;
    }

    /* access modifiers changed from: private */
    public void a(View view) {
        if (c()) {
            a.b(this.f19358q, view, d(view));
        }
    }

    private static void a(View view, float f2, float f3, int i2) {
        view.setScaleX(f2);
        view.setScaleY(f3);
        view.setVisibility(i2);
    }

    private static void a(View view, int i2) {
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), i2);
    }

    private static void a(View view, int i2, int i3) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = i2;
        layoutParams.gravity = i3;
        view.setLayoutParams(layoutParams);
    }

    private void b(View view) {
        if (c() && view != null) {
            setClipChildren(false);
            setClipToPadding(false);
            a.a(this.f19358q, view, d(view));
        }
    }

    private void c(View view) {
        if (c()) {
            if (view != null) {
                setClipChildren(true);
                setClipToPadding(true);
                a.a(this.f19358q, view);
            }
            this.f19358q = null;
        }
    }

    private boolean c() {
        return this.f19358q != null;
    }

    private FrameLayout d(View view) {
        if (view != this.f19349h || !a.f18524a) {
            return null;
        }
        return (FrameLayout) this.f19349h.getParent();
    }

    private int getItemVisiblePosition() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        int indexOfChild = viewGroup.indexOfChild(this);
        int i2 = 0;
        for (int i3 = 0; i3 < indexOfChild; i3++) {
            View childAt = viewGroup.getChildAt(i3);
            if ((childAt instanceof NavigationBarItemView) && childAt.getVisibility() == 0) {
                i2++;
            }
        }
        return i2;
    }

    private int getSuggestedIconHeight() {
        BadgeDrawable badgeDrawable = this.f19358q;
        int minimumHeight = badgeDrawable != null ? badgeDrawable.getMinimumHeight() / 2 : 0;
        return Math.max(minimumHeight, ((FrameLayout.LayoutParams) this.f19349h.getLayoutParams()).topMargin) + this.f19349h.getMeasuredWidth() + minimumHeight;
    }

    private int getSuggestedIconWidth() {
        BadgeDrawable badgeDrawable = this.f19358q;
        int minimumWidth = badgeDrawable == null ? 0 : badgeDrawable.getMinimumWidth() - this.f19358q.h();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f19349h.getLayoutParams();
        return Math.max(minimumWidth, layoutParams.leftMargin) + this.f19349h.getMeasuredWidth() + Math.max(minimumWidth, layoutParams.rightMargin);
    }

    public void a(i iVar, int i2) {
        this.f19354m = iVar;
        setCheckable(iVar.isCheckable());
        setChecked(iVar.isChecked());
        setEnabled(iVar.isEnabled());
        setIcon(iVar.getIcon());
        setTitle(iVar.getTitle());
        setId(iVar.getItemId());
        if (!TextUtils.isEmpty(iVar.getContentDescription())) {
            setContentDescription(iVar.getContentDescription());
        }
        CharSequence tooltipText = !TextUtils.isEmpty(iVar.getTooltipText()) ? iVar.getTooltipText() : iVar.getTitle();
        if (Build.VERSION.SDK_INT < 21 || Build.VERSION.SDK_INT > 23) {
            ah.a(this, tooltipText);
        }
        setVisibility(iVar.isVisible() ? 0 : 8);
    }

    public boolean a() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        c(this.f19349h);
    }

    public BadgeDrawable getBadge() {
        return this.f19358q;
    }

    /* access modifiers changed from: protected */
    public int getItemBackgroundResId() {
        return R.drawable.mtrl_navigation_bar_item_background;
    }

    public i getItemData() {
        return this.f19354m;
    }

    /* access modifiers changed from: protected */
    public int getItemDefaultMarginResId() {
        return R.dimen.mtrl_navigation_bar_item_default_margin;
    }

    /* access modifiers changed from: protected */
    public abstract int getItemLayoutResId();

    public int getItemPosition() {
        return this.f19353l;
    }

    /* access modifiers changed from: protected */
    public int getSuggestedMinimumHeight() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f19350i.getLayoutParams();
        return getSuggestedIconHeight() + layoutParams.topMargin + this.f19350i.getMeasuredHeight() + layoutParams.bottomMargin;
    }

    /* access modifiers changed from: protected */
    public int getSuggestedMinimumWidth() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f19350i.getLayoutParams();
        return Math.max(getSuggestedIconWidth(), layoutParams.leftMargin + this.f19350i.getMeasuredWidth() + layoutParams.rightMargin);
    }

    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        i iVar = this.f19354m;
        if (iVar != null && iVar.isCheckable() && this.f19354m.isChecked()) {
            mergeDrawableStates(onCreateDrawableState, f19342a);
        }
        return onCreateDrawableState;
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        BadgeDrawable badgeDrawable = this.f19358q;
        if (badgeDrawable != null && badgeDrawable.isVisible()) {
            CharSequence title = this.f19354m.getTitle();
            if (!TextUtils.isEmpty(this.f19354m.getContentDescription())) {
                title = this.f19354m.getContentDescription();
            }
            accessibilityNodeInfo.setContentDescription(title + ", " + this.f19358q.g());
        }
        c a2 = c.a(accessibilityNodeInfo);
        a2.b((Object) c.C0258c.a(0, 1, getItemVisiblePosition(), 1, false, isSelected()));
        if (isSelected()) {
            a2.h(false);
            a2.b(c.a.f34535e);
        }
        a2.j((CharSequence) getResources().getString(R.string.item_view_role_description));
    }

    /* access modifiers changed from: package-private */
    public void setBadge(BadgeDrawable badgeDrawable) {
        this.f19358q = badgeDrawable;
        ImageView imageView = this.f19349h;
        if (imageView != null) {
            b(imageView);
        }
    }

    public void setCheckable(boolean z2) {
        refreshDrawableState();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0082, code lost:
        a(r8.f19349h, r8.f19343b, 49);
        r0 = r8.f19352k;
        r1 = r8.f19346e;
        a(r0, r1, r1, 4);
        a(r8.f19351j, 1.0f, 1.0f, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x009a, code lost:
        if (r9 != false) goto L_0x009c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x009c, code lost:
        a(r0, r1, 49);
        r0 = r8.f19350i;
        a((android.view.View) r0, ((java.lang.Integer) r0.getTag(com.google.android.material.R.id.mtrl_view_tag_bottom_padding)).intValue());
        r8.f19352k.setVisibility(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x00b6, code lost:
        a(r0, r1, 17);
        a((android.view.View) r8.f19350i, 0);
        r8.f19352k.setVisibility(4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x00c3, code lost:
        r8.f19351j.setVisibility(4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00d1, code lost:
        if (r9 != false) goto L_0x009c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00e5, code lost:
        if (r9 != false) goto L_0x0069;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0067, code lost:
        if (r9 != false) goto L_0x0069;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setChecked(boolean r9) {
        /*
            r8 = this;
            android.widget.TextView r0 = r8.f19352k
            int r1 = r0.getWidth()
            r2 = 2
            int r1 = r1 / r2
            float r1 = (float) r1
            r0.setPivotX(r1)
            android.widget.TextView r0 = r8.f19352k
            int r1 = r0.getBaseline()
            float r1 = (float) r1
            r0.setPivotY(r1)
            android.widget.TextView r0 = r8.f19351j
            int r1 = r0.getWidth()
            int r1 = r1 / r2
            float r1 = (float) r1
            r0.setPivotX(r1)
            android.widget.TextView r0 = r8.f19351j
            int r1 = r0.getBaseline()
            float r1 = (float) r1
            r0.setPivotY(r1)
            int r0 = r8.f19347f
            r1 = -1
            r3 = 17
            r4 = 49
            r5 = 1065353216(0x3f800000, float:1.0)
            r6 = 4
            r7 = 0
            if (r0 == r1) goto L_0x00c9
            if (r0 == 0) goto L_0x0096
            r1 = 1
            if (r0 == r1) goto L_0x0056
            if (r0 == r2) goto L_0x0041
            goto L_0x00e8
        L_0x0041:
            android.widget.ImageView r0 = r8.f19349h
            int r1 = r8.f19343b
            a(r0, r1, r3)
            android.widget.TextView r0 = r8.f19352k
            r1 = 8
            r0.setVisibility(r1)
            android.widget.TextView r0 = r8.f19351j
            r0.setVisibility(r1)
            goto L_0x00e8
        L_0x0056:
            android.view.ViewGroup r0 = r8.f19350i
            int r1 = com.google.android.material.R.id.mtrl_view_tag_bottom_padding
            java.lang.Object r1 = r0.getTag(r1)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            a((android.view.View) r0, (int) r1)
            if (r9 == 0) goto L_0x0082
        L_0x0069:
            android.widget.ImageView r0 = r8.f19349h
            int r1 = r8.f19343b
            float r1 = (float) r1
            float r2 = r8.f19344c
            float r1 = r1 + r2
            int r1 = (int) r1
            a(r0, r1, r4)
            android.widget.TextView r0 = r8.f19352k
            a(r0, r5, r5, r7)
            android.widget.TextView r0 = r8.f19351j
            float r1 = r8.f19345d
            a(r0, r1, r1, r6)
            goto L_0x00e8
        L_0x0082:
            android.widget.ImageView r0 = r8.f19349h
            int r1 = r8.f19343b
            a(r0, r1, r4)
            android.widget.TextView r0 = r8.f19352k
            float r1 = r8.f19346e
            a(r0, r1, r1, r6)
            android.widget.TextView r0 = r8.f19351j
            a(r0, r5, r5, r7)
            goto L_0x00e8
        L_0x0096:
            android.widget.ImageView r0 = r8.f19349h
            int r1 = r8.f19343b
            if (r9 == 0) goto L_0x00b6
        L_0x009c:
            a(r0, r1, r4)
            android.view.ViewGroup r0 = r8.f19350i
            int r1 = com.google.android.material.R.id.mtrl_view_tag_bottom_padding
            java.lang.Object r1 = r0.getTag(r1)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            a((android.view.View) r0, (int) r1)
            android.widget.TextView r0 = r8.f19352k
            r0.setVisibility(r7)
            goto L_0x00c3
        L_0x00b6:
            a(r0, r1, r3)
            android.view.ViewGroup r0 = r8.f19350i
            a((android.view.View) r0, (int) r7)
            android.widget.TextView r0 = r8.f19352k
            r0.setVisibility(r6)
        L_0x00c3:
            android.widget.TextView r0 = r8.f19351j
            r0.setVisibility(r6)
            goto L_0x00e8
        L_0x00c9:
            boolean r0 = r8.f19348g
            if (r0 == 0) goto L_0x00d4
            android.widget.ImageView r0 = r8.f19349h
            int r1 = r8.f19343b
            if (r9 == 0) goto L_0x00b6
            goto L_0x009c
        L_0x00d4:
            android.view.ViewGroup r0 = r8.f19350i
            int r1 = com.google.android.material.R.id.mtrl_view_tag_bottom_padding
            java.lang.Object r1 = r0.getTag(r1)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            a((android.view.View) r0, (int) r1)
            if (r9 == 0) goto L_0x0082
            goto L_0x0069
        L_0x00e8:
            r8.refreshDrawableState()
            r8.setSelected(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.navigation.NavigationBarItemView.setChecked(boolean):void");
    }

    public void setEnabled(boolean z2) {
        super.setEnabled(z2);
        this.f19351j.setEnabled(z2);
        this.f19352k.setEnabled(z2);
        this.f19349h.setEnabled(z2);
        ac.a((View) this, z2 ? y.a(getContext(), 1002) : null);
    }

    public void setIcon(Drawable drawable) {
        if (drawable != this.f19356o) {
            this.f19356o = drawable;
            if (drawable != null) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = androidx.core.graphics.drawable.a.g(drawable).mutate();
                this.f19357p = drawable;
                ColorStateList colorStateList = this.f19355n;
                if (colorStateList != null) {
                    androidx.core.graphics.drawable.a.a(drawable, colorStateList);
                }
            }
            this.f19349h.setImageDrawable(drawable);
        }
    }

    public void setIconSize(int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f19349h.getLayoutParams();
        layoutParams.width = i2;
        layoutParams.height = i2;
        this.f19349h.setLayoutParams(layoutParams);
    }

    public void setIconTintList(ColorStateList colorStateList) {
        Drawable drawable;
        this.f19355n = colorStateList;
        if (this.f19354m != null && (drawable = this.f19357p) != null) {
            androidx.core.graphics.drawable.a.a(drawable, colorStateList);
            this.f19357p.invalidateSelf();
        }
    }

    public void setItemBackground(int i2) {
        setItemBackground(i2 == 0 ? null : b.a(getContext(), i2));
    }

    public void setItemBackground(Drawable drawable) {
        if (!(drawable == null || drawable.getConstantState() == null)) {
            drawable = drawable.getConstantState().newDrawable().mutate();
        }
        ac.a((View) this, drawable);
    }

    public void setItemPosition(int i2) {
        this.f19353l = i2;
    }

    public void setLabelVisibilityMode(int i2) {
        if (this.f19347f != i2) {
            this.f19347f = i2;
            i iVar = this.f19354m;
            if (iVar != null) {
                setChecked(iVar.isChecked());
            }
        }
    }

    public void setShifting(boolean z2) {
        if (this.f19348g != z2) {
            this.f19348g = z2;
            i iVar = this.f19354m;
            if (iVar != null) {
                setChecked(iVar.isChecked());
            }
        }
    }

    public void setTextAppearanceActive(int i2) {
        j.a(this.f19352k, i2);
        a(this.f19351j.getTextSize(), this.f19352k.getTextSize());
    }

    public void setTextAppearanceInactive(int i2) {
        j.a(this.f19351j, i2);
        a(this.f19351j.getTextSize(), this.f19352k.getTextSize());
    }

    public void setTextColor(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.f19351j.setTextColor(colorStateList);
            this.f19352k.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        this.f19351j.setText(charSequence);
        this.f19352k.setText(charSequence);
        i iVar = this.f19354m;
        if (iVar == null || TextUtils.isEmpty(iVar.getContentDescription())) {
            setContentDescription(charSequence);
        }
        i iVar2 = this.f19354m;
        if (iVar2 != null && !TextUtils.isEmpty(iVar2.getTooltipText())) {
            charSequence = this.f19354m.getTooltipText();
        }
        if (Build.VERSION.SDK_INT < 21 || Build.VERSION.SDK_INT > 23) {
            ah.a(this, charSequence);
        }
    }
}
