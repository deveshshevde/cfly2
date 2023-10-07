package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.widgets.analyzer.n;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class h extends ConstraintWidget implements g {

    /* renamed from: aw  reason: collision with root package name */
    public ConstraintWidget[] f2447aw = new ConstraintWidget[4];

    /* renamed from: ax  reason: collision with root package name */
    public int f2448ax = 0;

    public int J(int i2) {
        for (int i3 = 0; i3 < this.f2448ax; i3++) {
            ConstraintWidget constraintWidget = this.f2447aw[i3];
            if (i2 == 0 && constraintWidget.f2260au != -1) {
                return constraintWidget.f2260au;
            }
            if (i2 == 1 && constraintWidget.f2261av != -1) {
                return constraintWidget.f2261av;
            }
        }
        return -1;
    }

    public void a(ConstraintWidget constraintWidget) {
        if (constraintWidget != this && constraintWidget != null) {
            int i2 = this.f2448ax + 1;
            ConstraintWidget[] constraintWidgetArr = this.f2447aw;
            if (i2 > constraintWidgetArr.length) {
                this.f2447aw = (ConstraintWidget[]) Arrays.copyOf(constraintWidgetArr, constraintWidgetArr.length * 2);
            }
            ConstraintWidget[] constraintWidgetArr2 = this.f2447aw;
            int i3 = this.f2448ax;
            constraintWidgetArr2[i3] = constraintWidget;
            this.f2448ax = i3 + 1;
        }
    }

    public void a(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        super.a(constraintWidget, hashMap);
        h hVar = (h) constraintWidget;
        this.f2448ax = 0;
        int i2 = hVar.f2448ax;
        for (int i3 = 0; i3 < i2; i3++) {
            a(hashMap.get(hVar.f2447aw[i3]));
        }
    }

    public void a(d dVar) {
    }

    public void a(ArrayList<n> arrayList, int i2, n nVar) {
        for (int i3 = 0; i3 < this.f2448ax; i3++) {
            nVar.a(this.f2447aw[i3]);
        }
        for (int i4 = 0; i4 < this.f2448ax; i4++) {
            androidx.constraintlayout.solver.widgets.analyzer.h.a(this.f2447aw[i4], i2, arrayList, nVar);
        }
    }

    public void j() {
        this.f2448ax = 0;
        Arrays.fill(this.f2447aw, (Object) null);
    }
}
