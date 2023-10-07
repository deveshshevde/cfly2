package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.d;
import androidx.constraintlayout.solver.widgets.g;
import androidx.constraintlayout.solver.widgets.h;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.b;
import java.util.Arrays;
import java.util.HashMap;

public abstract class ConstraintHelper extends View {

    /* renamed from: a  reason: collision with root package name */
    private View[] f2521a = null;

    /* renamed from: b  reason: collision with root package name */
    private HashMap<Integer, String> f2522b = new HashMap<>();

    /* renamed from: j  reason: collision with root package name */
    protected int[] f2523j = new int[32];

    /* renamed from: k  reason: collision with root package name */
    protected int f2524k;

    /* renamed from: l  reason: collision with root package name */
    protected Context f2525l;

    /* renamed from: m  reason: collision with root package name */
    protected g f2526m;

    /* renamed from: n  reason: collision with root package name */
    protected boolean f2527n = false;

    /* renamed from: o  reason: collision with root package name */
    protected String f2528o;

    /* renamed from: p  reason: collision with root package name */
    protected String f2529p;

    public ConstraintHelper(Context context) {
        super(context);
        this.f2525l = context;
        a((AttributeSet) null);
    }

    public ConstraintHelper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2525l = context;
        a(attributeSet);
    }

    public ConstraintHelper(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f2525l = context;
        a(attributeSet);
    }

    private int a(ConstraintLayout constraintLayout, String str) {
        Resources resources;
        if (str == null || constraintLayout == null || (resources = this.f2525l.getResources()) == null) {
            return 0;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = constraintLayout.getChildAt(i2);
            if (childAt.getId() != -1) {
                String str2 = null;
                try {
                    str2 = resources.getResourceEntryName(childAt.getId());
                } catch (Resources.NotFoundException unused) {
                }
                if (str.equals(str2)) {
                    return childAt.getId();
                }
            }
        }
        return 0;
    }

    private void a(int i2) {
        if (i2 != getId()) {
            int i3 = this.f2524k + 1;
            int[] iArr = this.f2523j;
            if (i3 > iArr.length) {
                this.f2523j = Arrays.copyOf(iArr, iArr.length * 2);
            }
            int[] iArr2 = this.f2523j;
            int i4 = this.f2524k;
            iArr2[i4] = i2;
            this.f2524k = i4 + 1;
        }
    }

    private void a(String str) {
        if (str != null && str.length() != 0 && this.f2525l != null) {
            String trim = str.trim();
            if (getParent() instanceof ConstraintLayout) {
                ConstraintLayout constraintLayout = (ConstraintLayout) getParent();
            }
            int c2 = c(trim);
            if (c2 != 0) {
                this.f2522b.put(Integer.valueOf(c2), trim);
                a(c2);
                return;
            }
            Log.w("ConstraintHelper", "Could not find id of \"" + trim + "\"");
        }
    }

    private int[] a(View view, String str) {
        String[] split = str.split(",");
        view.getContext();
        int[] iArr = new int[split.length];
        int i2 = 0;
        for (String trim : split) {
            int c2 = c(trim.trim());
            if (c2 != 0) {
                iArr[i2] = c2;
                i2++;
            }
        }
        return i2 != split.length ? Arrays.copyOf(iArr, i2) : iArr;
    }

    private void b(String str) {
        if (str != null && str.length() != 0 && this.f2525l != null) {
            String trim = str.trim();
            ConstraintLayout constraintLayout = null;
            if (getParent() instanceof ConstraintLayout) {
                constraintLayout = (ConstraintLayout) getParent();
            }
            if (constraintLayout == null) {
                Log.w("ConstraintHelper", "Parent not a ConstraintLayout");
                return;
            }
            int childCount = constraintLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = constraintLayout.getChildAt(i2);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if ((layoutParams instanceof ConstraintLayout.LayoutParams) && trim.equals(((ConstraintLayout.LayoutParams) layoutParams).V)) {
                    if (childAt.getId() == -1) {
                        Log.w("ConstraintHelper", "to use ConstraintTag view " + childAt.getClass().getSimpleName() + " must have an ID");
                    } else {
                        a(childAt.getId());
                    }
                }
            }
        }
    }

    private int c(String str) {
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        int i2 = 0;
        if (isInEditMode() && constraintLayout != null) {
            Object a2 = constraintLayout.a(0, str);
            if (a2 instanceof Integer) {
                i2 = ((Integer) a2).intValue();
            }
        }
        if (i2 == 0 && constraintLayout != null) {
            i2 = a(constraintLayout, str);
        }
        if (i2 == 0) {
            try {
                i2 = R.id.class.getField(str).getInt((Object) null);
            } catch (Exception unused) {
            }
        }
        return i2 == 0 ? this.f2525l.getResources().getIdentifier(str, "id", this.f2525l.getPackageName()) : i2;
    }

    /* access modifiers changed from: protected */
    public void a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.ConstraintLayout_Layout_constraint_referenced_ids) {
                    String string = obtainStyledAttributes.getString(index);
                    this.f2528o = string;
                    setIds(string);
                } else if (index == R.styleable.ConstraintLayout_Layout_constraint_referenced_tags) {
                    String string2 = obtainStyledAttributes.getString(index);
                    this.f2529p = string2;
                    setReferenceTags(string2);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void a(ConstraintWidget constraintWidget, boolean z2) {
    }

    public void a(d dVar, g gVar, SparseArray<ConstraintWidget> sparseArray) {
        gVar.j();
        for (int i2 = 0; i2 < this.f2524k; i2++) {
            gVar.a(sparseArray.get(this.f2523j[i2]));
        }
    }

    public void a(ConstraintLayout constraintLayout) {
    }

    public void a(b.a aVar, h hVar, ConstraintLayout.LayoutParams layoutParams, SparseArray<ConstraintWidget> sparseArray) {
        if (aVar.f2641d.f2650ae != null) {
            setReferencedIds(aVar.f2641d.f2650ae);
        } else if (aVar.f2641d.f2651af != null && aVar.f2641d.f2651af.length() > 0) {
            aVar.f2641d.f2650ae = a((View) this, aVar.f2641d.f2651af);
        }
        hVar.j();
        if (aVar.f2641d.f2650ae != null) {
            for (int i2 : aVar.f2641d.f2650ae) {
                ConstraintWidget constraintWidget = sparseArray.get(i2);
                if (constraintWidget != null) {
                    hVar.a(constraintWidget);
                }
            }
        }
    }

    public void b(ConstraintLayout constraintLayout) {
    }

    public void c() {
        if (this.f2526m != null) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams instanceof ConstraintLayout.LayoutParams) {
                ((ConstraintLayout.LayoutParams) layoutParams).f2560an = (ConstraintWidget) this.f2526m;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void c(ConstraintLayout constraintLayout) {
        int visibility = getVisibility();
        float elevation = Build.VERSION.SDK_INT >= 21 ? getElevation() : 0.0f;
        for (int i2 = 0; i2 < this.f2524k; i2++) {
            View d2 = constraintLayout.d(this.f2523j[i2]);
            if (d2 != null) {
                d2.setVisibility(visibility);
                if (elevation > 0.0f && Build.VERSION.SDK_INT >= 21) {
                    d2.setTranslationZ(d2.getTranslationZ() + elevation);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void d() {
        ViewParent parent = getParent();
        if (parent != null && (parent instanceof ConstraintLayout)) {
            c((ConstraintLayout) parent);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0022, code lost:
        r1 = r5.f2522b.get(java.lang.Integer.valueOf(r1));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d(androidx.constraintlayout.widget.ConstraintLayout r6) {
        /*
            r5 = this;
            boolean r0 = r5.isInEditMode()
            if (r0 == 0) goto L_0x000b
            java.lang.String r0 = r5.f2528o
            r5.setIds(r0)
        L_0x000b:
            androidx.constraintlayout.solver.widgets.g r0 = r5.f2526m
            if (r0 != 0) goto L_0x0010
            return
        L_0x0010:
            r0.j()
            r0 = 0
        L_0x0014:
            int r1 = r5.f2524k
            if (r0 >= r1) goto L_0x0053
            int[] r1 = r5.f2523j
            r1 = r1[r0]
            android.view.View r2 = r6.d(r1)
            if (r2 != 0) goto L_0x0045
            java.util.HashMap<java.lang.Integer, java.lang.String> r3 = r5.f2522b
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.Object r1 = r3.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            int r3 = r5.a((androidx.constraintlayout.widget.ConstraintLayout) r6, (java.lang.String) r1)
            if (r3 == 0) goto L_0x0045
            int[] r2 = r5.f2523j
            r2[r0] = r3
            java.util.HashMap<java.lang.Integer, java.lang.String> r2 = r5.f2522b
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)
            r2.put(r4, r1)
            android.view.View r2 = r6.d(r3)
        L_0x0045:
            if (r2 == 0) goto L_0x0050
            androidx.constraintlayout.solver.widgets.g r1 = r5.f2526m
            androidx.constraintlayout.solver.widgets.ConstraintWidget r2 = r6.a((android.view.View) r2)
            r1.a((androidx.constraintlayout.solver.widgets.ConstraintWidget) r2)
        L_0x0050:
            int r0 = r0 + 1
            goto L_0x0014
        L_0x0053:
            androidx.constraintlayout.solver.widgets.g r0 = r5.f2526m
            androidx.constraintlayout.solver.widgets.d r6 = r6.K
            r0.a((androidx.constraintlayout.solver.widgets.d) r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintHelper.d(androidx.constraintlayout.widget.ConstraintLayout):void");
    }

    /* access modifiers changed from: protected */
    public View[] e(ConstraintLayout constraintLayout) {
        View[] viewArr = this.f2521a;
        if (viewArr == null || viewArr.length != this.f2524k) {
            this.f2521a = new View[this.f2524k];
        }
        for (int i2 = 0; i2 < this.f2524k; i2++) {
            this.f2521a[i2] = constraintLayout.d(this.f2523j[i2]);
        }
        return this.f2521a;
    }

    public void f(ConstraintLayout constraintLayout) {
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f2523j, this.f2524k);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.f2528o;
        if (str != null) {
            setIds(str);
        }
        String str2 = this.f2529p;
        if (str2 != null) {
            setReferenceTags(str2);
        }
    }

    public void onDraw(Canvas canvas) {
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        if (this.f2527n) {
            super.onMeasure(i2, i3);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    /* access modifiers changed from: protected */
    public void setIds(String str) {
        this.f2528o = str;
        if (str != null) {
            int i2 = 0;
            this.f2524k = 0;
            while (true) {
                int indexOf = str.indexOf(44, i2);
                if (indexOf == -1) {
                    a(str.substring(i2));
                    return;
                } else {
                    a(str.substring(i2, indexOf));
                    i2 = indexOf + 1;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void setReferenceTags(String str) {
        this.f2529p = str;
        if (str != null) {
            int i2 = 0;
            this.f2524k = 0;
            while (true) {
                int indexOf = str.indexOf(44, i2);
                if (indexOf == -1) {
                    b(str.substring(i2));
                    return;
                } else {
                    b(str.substring(i2, indexOf));
                    i2 = indexOf + 1;
                }
            }
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.f2528o = null;
        this.f2524k = 0;
        for (int a2 : iArr) {
            a(a2);
        }
    }

    public void setTag(int i2, Object obj) {
        super.setTag(i2, obj);
        if (obj == null && this.f2528o == null) {
            a(i2);
        }
    }
}
