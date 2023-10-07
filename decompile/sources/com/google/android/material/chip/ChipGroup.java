package com.google.android.material.chip;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import com.google.android.material.R;
import com.google.android.material.internal.FlowLayout;
import java.util.ArrayList;
import java.util.List;
import t.ac;
import u.c;

public class ChipGroup extends FlowLayout {

    /* renamed from: a  reason: collision with root package name */
    private static final int f18791a = R.style.Widget_MaterialComponents_ChipGroup;

    /* renamed from: b  reason: collision with root package name */
    private int f18792b;

    /* renamed from: c  reason: collision with root package name */
    private int f18793c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f18794d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f18795e;

    /* renamed from: f  reason: collision with root package name */
    private b f18796f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final a f18797g;

    /* renamed from: h  reason: collision with root package name */
    private c f18798h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public int f18799i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public boolean f18800j;

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(int i2, int i3) {
            super(i2, i3);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    private class a implements CompoundButton.OnCheckedChangeListener {
        private a() {
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
            if (!ChipGroup.this.f18800j) {
                if (!ChipGroup.this.getCheckedChipIds().isEmpty() || !ChipGroup.this.f18795e) {
                    int id2 = compoundButton.getId();
                    if (z2) {
                        if (!(ChipGroup.this.f18799i == -1 || ChipGroup.this.f18799i == id2 || !ChipGroup.this.f18794d)) {
                            ChipGroup chipGroup = ChipGroup.this;
                            chipGroup.b(chipGroup.f18799i, false);
                        }
                        ChipGroup.this.setCheckedId(id2);
                    } else if (ChipGroup.this.f18799i == id2) {
                        ChipGroup.this.setCheckedId(-1);
                    }
                } else {
                    ChipGroup.this.b(compoundButton.getId(), true);
                    ChipGroup.this.a(compoundButton.getId(), false);
                }
            }
        }
    }

    public interface b {
        void a(ChipGroup chipGroup, int i2);
    }

    private class c implements ViewGroup.OnHierarchyChangeListener {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public ViewGroup.OnHierarchyChangeListener f18803b;

        private c() {
        }

        public void onChildViewAdded(View view, View view2) {
            if (view == ChipGroup.this && (view2 instanceof Chip)) {
                if (view2.getId() == -1) {
                    view2.setId(ac.a());
                }
                Chip chip = (Chip) view2;
                if (chip.isChecked()) {
                    ((ChipGroup) view).a(chip.getId());
                }
                chip.setOnCheckedChangeListenerInternal(ChipGroup.this.f18797g);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f18803b;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        public void onChildViewRemoved(View view, View view2) {
            if (view == ChipGroup.this && (view2 instanceof Chip)) {
                ((Chip) view2).setOnCheckedChangeListenerInternal((CompoundButton.OnCheckedChangeListener) null);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f18803b;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    public ChipGroup(Context context) {
        this(context, (AttributeSet) null);
    }

    public ChipGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.chipGroupStyle);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ChipGroup(android.content.Context r8, android.util.AttributeSet r9, int r10) {
        /*
            r7 = this;
            int r4 = f18791a
            android.content.Context r8 = gx.a.a(r8, r9, r10, r4)
            r7.<init>(r8, r9, r10)
            com.google.android.material.chip.ChipGroup$a r8 = new com.google.android.material.chip.ChipGroup$a
            r0 = 0
            r8.<init>()
            r7.f18797g = r8
            com.google.android.material.chip.ChipGroup$c r8 = new com.google.android.material.chip.ChipGroup$c
            r8.<init>()
            r7.f18798h = r8
            r8 = -1
            r7.f18799i = r8
            r6 = 0
            r7.f18800j = r6
            android.content.Context r0 = r7.getContext()
            int[] r2 = com.google.android.material.R.styleable.ChipGroup
            int[] r5 = new int[r6]
            r1 = r9
            r3 = r10
            android.content.res.TypedArray r9 = com.google.android.material.internal.l.a(r0, r1, r2, r3, r4, r5)
            int r10 = com.google.android.material.R.styleable.ChipGroup_chipSpacing
            int r10 = r9.getDimensionPixelOffset(r10, r6)
            int r0 = com.google.android.material.R.styleable.ChipGroup_chipSpacingHorizontal
            int r0 = r9.getDimensionPixelOffset(r0, r10)
            r7.setChipSpacingHorizontal(r0)
            int r0 = com.google.android.material.R.styleable.ChipGroup_chipSpacingVertical
            int r10 = r9.getDimensionPixelOffset(r0, r10)
            r7.setChipSpacingVertical(r10)
            int r10 = com.google.android.material.R.styleable.ChipGroup_singleLine
            boolean r10 = r9.getBoolean(r10, r6)
            r7.setSingleLine((boolean) r10)
            int r10 = com.google.android.material.R.styleable.ChipGroup_singleSelection
            boolean r10 = r9.getBoolean(r10, r6)
            r7.setSingleSelection((boolean) r10)
            int r10 = com.google.android.material.R.styleable.ChipGroup_selectionRequired
            boolean r10 = r9.getBoolean(r10, r6)
            r7.setSelectionRequired(r10)
            int r10 = com.google.android.material.R.styleable.ChipGroup_checkedChip
            int r10 = r9.getResourceId(r10, r8)
            if (r10 == r8) goto L_0x0069
            r7.f18799i = r10
        L_0x0069:
            r9.recycle()
            com.google.android.material.chip.ChipGroup$c r8 = r7.f18798h
            super.setOnHierarchyChangeListener(r8)
            r8 = 1
            t.ac.b((android.view.View) r7, (int) r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.ChipGroup.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    /* access modifiers changed from: private */
    public void a(int i2, boolean z2) {
        this.f18799i = i2;
        b bVar = this.f18796f;
        if (bVar != null && this.f18794d && z2) {
            bVar.a(this, i2);
        }
    }

    /* access modifiers changed from: private */
    public void b(int i2, boolean z2) {
        View findViewById = findViewById(i2);
        if (findViewById instanceof Chip) {
            this.f18800j = true;
            ((Chip) findViewById).setChecked(z2);
            this.f18800j = false;
        }
    }

    private int getChipCount() {
        int i2 = 0;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            if (getChildAt(i3) instanceof Chip) {
                i2++;
            }
        }
        return i2;
    }

    /* access modifiers changed from: private */
    public void setCheckedId(int i2) {
        a(i2, true);
    }

    /* access modifiers changed from: package-private */
    public int a(View view) {
        if (!(view instanceof Chip)) {
            return -1;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            if (getChildAt(i3) instanceof Chip) {
                if (((Chip) getChildAt(i3)) == view) {
                    return i2;
                }
                i2++;
            }
        }
        return -1;
    }

    public void a() {
        this.f18800j = true;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof Chip) {
                ((Chip) childAt).setChecked(false);
            }
        }
        this.f18800j = false;
        setCheckedId(-1);
    }

    public void a(int i2) {
        int i3 = this.f18799i;
        if (i2 != i3) {
            if (i3 != -1 && this.f18794d) {
                b(i3, false);
            }
            if (i2 != -1) {
                b(i2, true);
            }
            setCheckedId(i2);
        }
    }

    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof Chip) {
            Chip chip = (Chip) view;
            if (chip.isChecked()) {
                int i3 = this.f18799i;
                if (i3 != -1 && this.f18794d) {
                    b(i3, false);
                }
                setCheckedId(chip.getId());
            }
        }
        super.addView(view, i2, layoutParams);
    }

    public boolean b() {
        return super.b();
    }

    public boolean c() {
        return this.f18794d;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof LayoutParams);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public int getCheckedChipId() {
        if (this.f18794d) {
            return this.f18799i;
        }
        return -1;
    }

    public List<Integer> getCheckedChipIds() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if ((childAt instanceof Chip) && ((Chip) childAt).isChecked()) {
                arrayList.add(Integer.valueOf(childAt.getId()));
                if (this.f18794d) {
                    return arrayList;
                }
            }
        }
        return arrayList;
    }

    public int getChipSpacingHorizontal() {
        return this.f18792b;
    }

    public int getChipSpacingVertical() {
        return this.f18793c;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        int i2 = this.f18799i;
        if (i2 != -1) {
            b(i2, true);
            setCheckedId(this.f18799i);
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        u.c.a(accessibilityNodeInfo).a((Object) c.b.a(getRowCount(), b() ? getChipCount() : -1, false, c() ? 1 : 2));
    }

    public void setChipSpacing(int i2) {
        setChipSpacingHorizontal(i2);
        setChipSpacingVertical(i2);
    }

    public void setChipSpacingHorizontal(int i2) {
        if (this.f18792b != i2) {
            this.f18792b = i2;
            setItemSpacing(i2);
            requestLayout();
        }
    }

    public void setChipSpacingHorizontalResource(int i2) {
        setChipSpacingHorizontal(getResources().getDimensionPixelOffset(i2));
    }

    public void setChipSpacingResource(int i2) {
        setChipSpacing(getResources().getDimensionPixelOffset(i2));
    }

    public void setChipSpacingVertical(int i2) {
        if (this.f18793c != i2) {
            this.f18793c = i2;
            setLineSpacing(i2);
            requestLayout();
        }
    }

    public void setChipSpacingVerticalResource(int i2) {
        setChipSpacingVertical(getResources().getDimensionPixelOffset(i2));
    }

    @Deprecated
    public void setDividerDrawableHorizontal(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setDividerDrawableVertical(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setFlexWrap(int i2) {
        throw new UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
    }

    public void setOnCheckedChangeListener(b bVar) {
        this.f18796f = bVar;
    }

    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        ViewGroup.OnHierarchyChangeListener unused = this.f18798h.f18803b = onHierarchyChangeListener;
    }

    public void setSelectionRequired(boolean z2) {
        this.f18795e = z2;
    }

    @Deprecated
    public void setShowDividerHorizontal(int i2) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setShowDividerVertical(int i2) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    public void setSingleLine(int i2) {
        setSingleLine(getResources().getBoolean(i2));
    }

    public void setSingleLine(boolean z2) {
        super.setSingleLine(z2);
    }

    public void setSingleSelection(int i2) {
        setSingleSelection(getResources().getBoolean(i2));
    }

    public void setSingleSelection(boolean z2) {
        if (this.f18794d != z2) {
            this.f18794d = z2;
            a();
        }
    }
}
