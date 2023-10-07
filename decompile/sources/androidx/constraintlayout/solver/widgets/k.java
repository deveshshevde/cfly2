package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.c;
import java.util.ArrayList;

public class k extends ConstraintWidget {
    public ArrayList<ConstraintWidget> aR = new ArrayList<>();

    public void Z() {
        ArrayList<ConstraintWidget> arrayList = this.aR;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                ConstraintWidget constraintWidget = this.aR.get(i2);
                if (constraintWidget instanceof k) {
                    ((k) constraintWidget).Z();
                }
            }
        }
    }

    public void a(c cVar) {
        super.a(cVar);
        int size = this.aR.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.aR.get(i2).a(cVar);
        }
    }

    public ArrayList<ConstraintWidget> ac() {
        return this.aR;
    }

    public void ad() {
        this.aR.clear();
    }

    public void b(ConstraintWidget constraintWidget) {
        this.aR.add(constraintWidget);
        if (constraintWidget.v() != null) {
            ((k) constraintWidget.v()).c(constraintWidget);
        }
        constraintWidget.a_(this);
    }

    public void c(ConstraintWidget constraintWidget) {
        this.aR.remove(constraintWidget);
        constraintWidget.s();
    }

    public void s() {
        this.aR.clear();
        super.s();
    }
}
