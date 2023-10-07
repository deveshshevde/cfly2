package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.ah;
import androidx.core.widget.j;
import com.google.android.material.R;
import l.f;
import t.a;
import t.ac;
import u.c;

public class NavigationMenuItemView extends ForegroundLinearLayout implements n.a {

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f19196d = {16842912};

    /* renamed from: c  reason: collision with root package name */
    boolean f19197c;

    /* renamed from: e  reason: collision with root package name */
    private int f19198e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f19199f;

    /* renamed from: g  reason: collision with root package name */
    private final CheckedTextView f19200g;

    /* renamed from: h  reason: collision with root package name */
    private FrameLayout f19201h;

    /* renamed from: i  reason: collision with root package name */
    private i f19202i;

    /* renamed from: j  reason: collision with root package name */
    private ColorStateList f19203j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f19204k;

    /* renamed from: l  reason: collision with root package name */
    private Drawable f19205l;

    /* renamed from: m  reason: collision with root package name */
    private final a f19206m;

    public NavigationMenuItemView(Context context) {
        this(context, (AttributeSet) null);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AnonymousClass1 r4 = new a() {
            public void a(View view, c cVar) {
                super.a(view, cVar);
                cVar.a(NavigationMenuItemView.this.f19197c);
            }
        };
        this.f19206m = r4;
        setOrientation(0);
        LayoutInflater.from(context).inflate(R.layout.design_navigation_menu_item, this, true);
        setIconSize(context.getResources().getDimensionPixelSize(R.dimen.design_navigation_icon_size));
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(R.id.design_menu_item_text);
        this.f19200g = checkedTextView;
        checkedTextView.setDuplicateParentStateEnabled(true);
        ac.a((View) checkedTextView, (a) r4);
    }

    private boolean c() {
        return this.f19202i.getTitle() == null && this.f19202i.getIcon() == null && this.f19202i.getActionView() != null;
    }

    private void d() {
        int i2;
        LinearLayoutCompat.LayoutParams layoutParams;
        if (c()) {
            this.f19200g.setVisibility(8);
            FrameLayout frameLayout = this.f19201h;
            if (frameLayout != null) {
                layoutParams = (LinearLayoutCompat.LayoutParams) frameLayout.getLayoutParams();
                i2 = -1;
            } else {
                return;
            }
        } else {
            this.f19200g.setVisibility(0);
            FrameLayout frameLayout2 = this.f19201h;
            if (frameLayout2 != null) {
                layoutParams = (LinearLayoutCompat.LayoutParams) frameLayout2.getLayoutParams();
                i2 = -2;
            } else {
                return;
            }
        }
        layoutParams.width = i2;
        this.f19201h.setLayoutParams(layoutParams);
    }

    private StateListDrawable e() {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(androidx.appcompat.R.attr.colorControlHighlight, typedValue, true)) {
            return null;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(f19196d, new ColorDrawable(typedValue.data));
        stateListDrawable.addState(EMPTY_STATE_SET, new ColorDrawable(0));
        return stateListDrawable;
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.f19201h == null) {
                this.f19201h = (FrameLayout) ((ViewStub) findViewById(R.id.design_menu_item_action_area_stub)).inflate();
            }
            this.f19201h.removeAllViews();
            this.f19201h.addView(view);
        }
    }

    public void a(i iVar, int i2) {
        this.f19202i = iVar;
        if (iVar.getItemId() > 0) {
            setId(iVar.getItemId());
        }
        setVisibility(iVar.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            ac.a((View) this, (Drawable) e());
        }
        setCheckable(iVar.isCheckable());
        setChecked(iVar.isChecked());
        setEnabled(iVar.isEnabled());
        setTitle(iVar.getTitle());
        setIcon(iVar.getIcon());
        setActionView(iVar.getActionView());
        setContentDescription(iVar.getContentDescription());
        ah.a(this, iVar.getTooltipText());
        d();
    }

    public boolean a() {
        return false;
    }

    public void b() {
        FrameLayout frameLayout = this.f19201h;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        this.f19200g.setCompoundDrawables((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    public i getItemData() {
        return this.f19202i;
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        i iVar = this.f19202i;
        if (iVar != null && iVar.isCheckable() && this.f19202i.isChecked()) {
            mergeDrawableStates(onCreateDrawableState, f19196d);
        }
        return onCreateDrawableState;
    }

    public void setCheckable(boolean z2) {
        refreshDrawableState();
        if (this.f19197c != z2) {
            this.f19197c = z2;
            this.f19206m.a((View) this.f19200g, 2048);
        }
    }

    public void setChecked(boolean z2) {
        refreshDrawableState();
        this.f19200g.setChecked(z2);
    }

    public void setHorizontalPadding(int i2) {
        setPadding(i2, 0, i2, 0);
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            if (this.f19204k) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = androidx.core.graphics.drawable.a.g(drawable).mutate();
                androidx.core.graphics.drawable.a.a(drawable, this.f19203j);
            }
            int i2 = this.f19198e;
            drawable.setBounds(0, 0, i2, i2);
        } else if (this.f19199f) {
            if (this.f19205l == null) {
                Drawable a2 = f.a(getResources(), R.drawable.navigation_empty_icon, getContext().getTheme());
                this.f19205l = a2;
                if (a2 != null) {
                    int i3 = this.f19198e;
                    a2.setBounds(0, 0, i3, i3);
                }
            }
            drawable = this.f19205l;
        }
        j.a(this.f19200g, drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    public void setIconPadding(int i2) {
        this.f19200g.setCompoundDrawablePadding(i2);
    }

    public void setIconSize(int i2) {
        this.f19198e = i2;
    }

    /* access modifiers changed from: package-private */
    public void setIconTintList(ColorStateList colorStateList) {
        this.f19203j = colorStateList;
        this.f19204k = colorStateList != null;
        i iVar = this.f19202i;
        if (iVar != null) {
            setIcon(iVar.getIcon());
        }
    }

    public void setMaxLines(int i2) {
        this.f19200g.setMaxLines(i2);
    }

    public void setNeedsEmptyIcon(boolean z2) {
        this.f19199f = z2;
    }

    public void setTextAppearance(int i2) {
        j.a((TextView) this.f19200g, i2);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.f19200g.setTextColor(colorStateList);
    }

    public void setTitle(CharSequence charSequence) {
        this.f19200g.setText(charSequence);
    }
}
