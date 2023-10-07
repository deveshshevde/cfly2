package com.google.android.material.button;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.s;
import gw.m;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeMap;
import t.ac;
import t.j;
import u.c;

public class MaterialButtonToggleGroup extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private static final String f18692a = "MaterialButtonToggleGroup";

    /* renamed from: b  reason: collision with root package name */
    private static final int f18693b = R.style.Widget_MaterialComponents_MaterialButtonToggleGroup;

    /* renamed from: c  reason: collision with root package name */
    private final List<b> f18694c;

    /* renamed from: d  reason: collision with root package name */
    private final a f18695d;

    /* renamed from: e  reason: collision with root package name */
    private final d f18696e;

    /* renamed from: f  reason: collision with root package name */
    private final LinkedHashSet<c> f18697f;

    /* renamed from: g  reason: collision with root package name */
    private final Comparator<MaterialButton> f18698g;

    /* renamed from: h  reason: collision with root package name */
    private Integer[] f18699h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public boolean f18700i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public boolean f18701j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f18702k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public int f18703l;

    private class a implements MaterialButton.a {
        private a() {
        }

        public void a(MaterialButton materialButton, boolean z2) {
            if (!MaterialButtonToggleGroup.this.f18700i) {
                if (MaterialButtonToggleGroup.this.f18701j) {
                    int unused = MaterialButtonToggleGroup.this.f18703l = z2 ? materialButton.getId() : -1;
                }
                if (MaterialButtonToggleGroup.this.b(materialButton.getId(), z2)) {
                    MaterialButtonToggleGroup.this.c(materialButton.getId(), materialButton.isChecked());
                }
                MaterialButtonToggleGroup.this.invalidate();
            }
        }
    }

    private static class b {

        /* renamed from: e  reason: collision with root package name */
        private static final gw.c f18707e = new gw.a(0.0f);

        /* renamed from: a  reason: collision with root package name */
        gw.c f18708a;

        /* renamed from: b  reason: collision with root package name */
        gw.c f18709b;

        /* renamed from: c  reason: collision with root package name */
        gw.c f18710c;

        /* renamed from: d  reason: collision with root package name */
        gw.c f18711d;

        b(gw.c cVar, gw.c cVar2, gw.c cVar3, gw.c cVar4) {
            this.f18708a = cVar;
            this.f18709b = cVar3;
            this.f18710c = cVar4;
            this.f18711d = cVar2;
        }

        public static b a(b bVar) {
            gw.c cVar = bVar.f18708a;
            gw.c cVar2 = bVar.f18711d;
            gw.c cVar3 = f18707e;
            return new b(cVar, cVar2, cVar3, cVar3);
        }

        public static b a(b bVar, View view) {
            return s.a(view) ? b(bVar) : a(bVar);
        }

        public static b b(b bVar) {
            gw.c cVar = f18707e;
            return new b(cVar, cVar, bVar.f18709b, bVar.f18710c);
        }

        public static b b(b bVar, View view) {
            return s.a(view) ? a(bVar) : b(bVar);
        }

        public static b c(b bVar) {
            gw.c cVar = bVar.f18708a;
            gw.c cVar2 = f18707e;
            return new b(cVar, cVar2, bVar.f18709b, cVar2);
        }

        public static b d(b bVar) {
            gw.c cVar = f18707e;
            return new b(cVar, bVar.f18711d, cVar, bVar.f18710c);
        }
    }

    public interface c {
        void a(MaterialButtonToggleGroup materialButtonToggleGroup, int i2, boolean z2);
    }

    private class d implements MaterialButton.b {
        private d() {
        }

        public void a(MaterialButton materialButton, boolean z2) {
            MaterialButtonToggleGroup.this.invalidate();
        }
    }

    public MaterialButtonToggleGroup(Context context) {
        this(context, (AttributeSet) null);
    }

    public MaterialButtonToggleGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialButtonToggleGroupStyle);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MaterialButtonToggleGroup(android.content.Context r7, android.util.AttributeSet r8, int r9) {
        /*
            r6 = this;
            int r4 = f18693b
            android.content.Context r7 = gx.a.a(r7, r8, r9, r4)
            r6.<init>(r7, r8, r9)
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r6.f18694c = r7
            com.google.android.material.button.MaterialButtonToggleGroup$a r7 = new com.google.android.material.button.MaterialButtonToggleGroup$a
            r0 = 0
            r7.<init>()
            r6.f18695d = r7
            com.google.android.material.button.MaterialButtonToggleGroup$d r7 = new com.google.android.material.button.MaterialButtonToggleGroup$d
            r7.<init>()
            r6.f18696e = r7
            java.util.LinkedHashSet r7 = new java.util.LinkedHashSet
            r7.<init>()
            r6.f18697f = r7
            com.google.android.material.button.MaterialButtonToggleGroup$1 r7 = new com.google.android.material.button.MaterialButtonToggleGroup$1
            r7.<init>()
            r6.f18698g = r7
            r7 = 0
            r6.f18700i = r7
            android.content.Context r0 = r6.getContext()
            int[] r2 = com.google.android.material.R.styleable.MaterialButtonToggleGroup
            int[] r5 = new int[r7]
            r1 = r8
            r3 = r9
            android.content.res.TypedArray r8 = com.google.android.material.internal.l.a(r0, r1, r2, r3, r4, r5)
            int r9 = com.google.android.material.R.styleable.MaterialButtonToggleGroup_singleSelection
            boolean r9 = r8.getBoolean(r9, r7)
            r6.setSingleSelection((boolean) r9)
            int r9 = com.google.android.material.R.styleable.MaterialButtonToggleGroup_checkedButton
            r0 = -1
            int r9 = r8.getResourceId(r9, r0)
            r6.f18703l = r9
            int r9 = com.google.android.material.R.styleable.MaterialButtonToggleGroup_selectionRequired
            boolean r7 = r8.getBoolean(r9, r7)
            r6.f18702k = r7
            r7 = 1
            r6.setChildrenDrawingOrderEnabled(r7)
            r8.recycle()
            t.ac.b((android.view.View) r6, (int) r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.button.MaterialButtonToggleGroup.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    /* access modifiers changed from: private */
    public int a(View view) {
        if (!(view instanceof MaterialButton)) {
            return -1;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            if (getChildAt(i3) == view) {
                return i2;
            }
            if ((getChildAt(i3) instanceof MaterialButton) && d(i3)) {
                i2++;
            }
        }
        return -1;
    }

    private b a(int i2, int i3, int i4) {
        b bVar = this.f18694c.get(i2);
        if (i3 == i4) {
            return bVar;
        }
        boolean z2 = getOrientation() == 0;
        if (i2 == i3) {
            return z2 ? b.a(bVar, this) : b.c(bVar);
        }
        if (i2 == i4) {
            return z2 ? b.b(bVar, this) : b.d(bVar);
        }
        return null;
    }

    private void a(int i2, boolean z2) {
        View findViewById = findViewById(i2);
        if (findViewById instanceof MaterialButton) {
            this.f18700i = true;
            ((MaterialButton) findViewById).setChecked(z2);
            this.f18700i = false;
        }
    }

    private static void a(m.a aVar, b bVar) {
        if (bVar == null) {
            aVar.a(0.0f);
        } else {
            aVar.b(bVar.f18708a).e(bVar.f18711d).c(bVar.f18709b).d(bVar.f18710c);
        }
    }

    private LinearLayout.LayoutParams b(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        return layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : new LinearLayout.LayoutParams(layoutParams.width, layoutParams.height);
    }

    private MaterialButton b(int i2) {
        return (MaterialButton) getChildAt(i2);
    }

    /* access modifiers changed from: private */
    public boolean b(int i2, boolean z2) {
        List<Integer> checkedButtonIds = getCheckedButtonIds();
        if (!this.f18702k || !checkedButtonIds.isEmpty()) {
            if (z2 && this.f18701j) {
                checkedButtonIds.remove(Integer.valueOf(i2));
                for (Integer intValue : checkedButtonIds) {
                    int intValue2 = intValue.intValue();
                    a(intValue2, false);
                    c(intValue2, false);
                }
            }
            return true;
        }
        a(i2, true);
        this.f18703l = i2;
        return false;
    }

    private void c(int i2) {
        if (getChildCount() != 0 && i2 != -1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) b(i2).getLayoutParams();
            if (getOrientation() == 1) {
                layoutParams.topMargin = 0;
                layoutParams.bottomMargin = 0;
                return;
            }
            j.b(layoutParams, 0);
            j.a(layoutParams, 0);
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
        }
    }

    /* access modifiers changed from: private */
    public void c(int i2, boolean z2) {
        Iterator it2 = this.f18697f.iterator();
        while (it2.hasNext()) {
            ((c) it2.next()).a(this, i2, z2);
        }
    }

    private void d() {
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        if (firstVisibleChildIndex != -1) {
            for (int i2 = firstVisibleChildIndex + 1; i2 < getChildCount(); i2++) {
                MaterialButton b2 = b(i2);
                int min = Math.min(b2.getStrokeWidth(), b(i2 - 1).getStrokeWidth());
                LinearLayout.LayoutParams b3 = b((View) b2);
                if (getOrientation() == 0) {
                    j.b(b3, 0);
                    j.a(b3, -min);
                    b3.topMargin = 0;
                } else {
                    b3.bottomMargin = 0;
                    b3.topMargin = -min;
                    j.a(b3, 0);
                }
                b2.setLayoutParams(b3);
            }
            c(firstVisibleChildIndex);
        }
    }

    private void d(int i2, boolean z2) {
        MaterialButton materialButton = (MaterialButton) findViewById(i2);
        if (materialButton != null) {
            materialButton.setChecked(z2);
        }
    }

    private boolean d(int i2) {
        return getChildAt(i2).getVisibility() != 8;
    }

    private void e() {
        TreeMap treeMap = new TreeMap(this.f18698g);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            treeMap.put(b(i2), Integer.valueOf(i2));
        }
        this.f18699h = (Integer[]) treeMap.values().toArray(new Integer[0]);
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (d(i2)) {
                return i2;
            }
        }
        return -1;
    }

    private int getLastVisibleChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (d(childCount)) {
                return childCount;
            }
        }
        return -1;
    }

    private int getVisibleButtonCount() {
        int i2 = 0;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            if ((getChildAt(i3) instanceof MaterialButton) && d(i3)) {
                i2++;
            }
        }
        return i2;
    }

    private void setCheckedId(int i2) {
        this.f18703l = i2;
        c(i2, true);
    }

    private void setGeneratedIdIfNeeded(MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            materialButton.setId(ac.a());
        }
    }

    private void setupButtonChild(MaterialButton materialButton) {
        materialButton.setMaxLines(1);
        materialButton.setEllipsize(TextUtils.TruncateAt.END);
        materialButton.setCheckable(true);
        materialButton.a((MaterialButton.a) this.f18695d);
        materialButton.setOnPressedChangeListenerInternal(this.f18696e);
        materialButton.setShouldDrawSurfaceColorStroke(true);
    }

    public void a() {
        this.f18700i = true;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            MaterialButton b2 = b(i2);
            b2.setChecked(false);
            c(b2.getId(), false);
        }
        this.f18700i = false;
        setCheckedId(-1);
    }

    public void a(int i2) {
        if (i2 != this.f18703l) {
            d(i2, true);
        }
    }

    public void a(c cVar) {
        this.f18697f.add(cVar);
    }

    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof MaterialButton)) {
            Log.e(f18692a, "Child views must be of type MaterialButton.");
            return;
        }
        super.addView(view, i2, layoutParams);
        MaterialButton materialButton = (MaterialButton) view;
        setGeneratedIdIfNeeded(materialButton);
        setupButtonChild(materialButton);
        if (materialButton.isChecked()) {
            b(materialButton.getId(), true);
            setCheckedId(materialButton.getId());
        }
        m shapeAppearanceModel = materialButton.getShapeAppearanceModel();
        this.f18694c.add(new b(shapeAppearanceModel.f(), shapeAppearanceModel.i(), shapeAppearanceModel.g(), shapeAppearanceModel.h()));
        ac.a((View) materialButton, (t.a) new t.a() {
            public void a(View view, u.c cVar) {
                super.a(view, cVar);
                cVar.b((Object) c.C0258c.a(0, 1, MaterialButtonToggleGroup.this.a(view), 1, false, ((MaterialButton) view).isChecked()));
            }
        });
    }

    public boolean b() {
        return this.f18701j;
    }

    /* access modifiers changed from: package-private */
    public void c() {
        int childCount = getChildCount();
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        int lastVisibleChildIndex = getLastVisibleChildIndex();
        for (int i2 = 0; i2 < childCount; i2++) {
            MaterialButton b2 = b(i2);
            if (b2.getVisibility() != 8) {
                m.a n2 = b2.getShapeAppearanceModel().n();
                a(n2, a(i2, firstVisibleChildIndex, lastVisibleChildIndex));
                b2.setShapeAppearanceModel(n2.a());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        e();
        super.dispatchDraw(canvas);
    }

    public CharSequence getAccessibilityClassName() {
        return MaterialButtonToggleGroup.class.getName();
    }

    public int getCheckedButtonId() {
        if (this.f18701j) {
            return this.f18703l;
        }
        return -1;
    }

    public List<Integer> getCheckedButtonIds() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            MaterialButton b2 = b(i2);
            if (b2.isChecked()) {
                arrayList.add(Integer.valueOf(b2.getId()));
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i2, int i3) {
        Integer[] numArr = this.f18699h;
        if (numArr != null && i3 < numArr.length) {
            return numArr[i3].intValue();
        }
        Log.w(f18692a, "Child order wasn't updated");
        return i3;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        int i2 = this.f18703l;
        if (i2 != -1) {
            d(i2, true);
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        u.c.a(accessibilityNodeInfo).a((Object) c.b.a(1, getVisibleButtonCount(), false, b() ? 1 : 2));
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        c();
        d();
        super.onMeasure(i2, i3);
    }

    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            MaterialButton materialButton = (MaterialButton) view;
            materialButton.b(this.f18695d);
            materialButton.setOnPressedChangeListenerInternal((MaterialButton.b) null);
        }
        int indexOfChild = indexOfChild(view);
        if (indexOfChild >= 0) {
            this.f18694c.remove(indexOfChild);
        }
        c();
        d();
    }

    public void setSelectionRequired(boolean z2) {
        this.f18702k = z2;
    }

    public void setSingleSelection(int i2) {
        setSingleSelection(getResources().getBoolean(i2));
    }

    public void setSingleSelection(boolean z2) {
        if (this.f18701j != z2) {
            this.f18701j = z2;
            a();
        }
    }
}
