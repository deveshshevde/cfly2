package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.a;
import androidx.constraintlayout.solver.widgets.d;
import androidx.constraintlayout.solver.widgets.h;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.b;

public class Barrier extends ConstraintHelper {

    /* renamed from: a  reason: collision with root package name */
    private int f2502a;

    /* renamed from: b  reason: collision with root package name */
    private int f2503b;

    /* renamed from: c  reason: collision with root package name */
    private a f2504c;

    public Barrier(Context context) {
        super(context);
        super.setVisibility(8);
    }

    public Barrier(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }

    public Barrier(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        super.setVisibility(8);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001f, code lost:
        if (r7 == 6) goto L_0x0010;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0025, code lost:
        if (r7 == 6) goto L_0x001c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0013, code lost:
        if (r7 == 6) goto L_0x001c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(androidx.constraintlayout.solver.widgets.ConstraintWidget r6, int r7, boolean r8) {
        /*
            r5 = this;
            r5.f2503b = r7
            int r7 = android.os.Build.VERSION.SDK_INT
            r0 = 1
            r1 = 0
            r2 = 6
            r3 = 5
            r4 = 17
            if (r7 >= r4) goto L_0x0016
            int r7 = r5.f2502a
            if (r7 != r3) goto L_0x0013
        L_0x0010:
            r5.f2503b = r1
            goto L_0x0028
        L_0x0013:
            if (r7 != r2) goto L_0x0028
        L_0x0015:
            goto L_0x001c
        L_0x0016:
            int r7 = r5.f2502a
            if (r8 == 0) goto L_0x0022
            if (r7 != r3) goto L_0x001f
        L_0x001c:
            r5.f2503b = r0
            goto L_0x0028
        L_0x001f:
            if (r7 != r2) goto L_0x0028
            goto L_0x0010
        L_0x0022:
            if (r7 != r3) goto L_0x0025
            goto L_0x0010
        L_0x0025:
            if (r7 != r2) goto L_0x0028
            goto L_0x0015
        L_0x0028:
            boolean r7 = r6 instanceof androidx.constraintlayout.solver.widgets.a
            if (r7 == 0) goto L_0x0033
            androidx.constraintlayout.solver.widgets.a r6 = (androidx.constraintlayout.solver.widgets.a) r6
            int r7 = r5.f2503b
            r6.a((int) r7)
        L_0x0033:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.Barrier.a(androidx.constraintlayout.solver.widgets.ConstraintWidget, int, boolean):void");
    }

    /* access modifiers changed from: protected */
    public void a(AttributeSet attributeSet) {
        super.a(attributeSet);
        this.f2504c = new a();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.ConstraintLayout_Layout_barrierDirection) {
                    setType(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_barrierAllowsGoneWidgets) {
                    this.f2504c.a(obtainStyledAttributes.getBoolean(index, true));
                } else if (index == R.styleable.ConstraintLayout_Layout_barrierMargin) {
                    this.f2504c.b(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.f2526m = this.f2504c;
        c();
    }

    public void a(ConstraintWidget constraintWidget, boolean z2) {
        a(constraintWidget, this.f2502a, z2);
    }

    public void a(b.a aVar, h hVar, ConstraintLayout.LayoutParams layoutParams, SparseArray<ConstraintWidget> sparseArray) {
        super.a(aVar, hVar, layoutParams, sparseArray);
        if (hVar instanceof a) {
            a aVar2 = (a) hVar;
            a(aVar2, aVar.f2641d.f2647ab, ((d) hVar.v()).Y());
            aVar2.a(aVar.f2641d.f2655aj);
            aVar2.b(aVar.f2641d.f2648ac);
        }
    }

    public boolean a() {
        return this.f2504c.c();
    }

    public int getMargin() {
        return this.f2504c.g();
    }

    public int getType() {
        return this.f2502a;
    }

    public void setAllowsGoneWidget(boolean z2) {
        this.f2504c.a(z2);
    }

    public void setDpMargin(int i2) {
        a aVar = this.f2504c;
        aVar.b((int) ((((float) i2) * getResources().getDisplayMetrics().density) + 0.5f));
    }

    public void setMargin(int i2) {
        this.f2504c.b(i2);
    }

    public void setType(int i2) {
        this.f2502a = i2;
    }
}
