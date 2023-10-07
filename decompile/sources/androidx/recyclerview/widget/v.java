package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

class v {
    static int a(RecyclerView.s sVar, s sVar2, View view, View view2, RecyclerView.h hVar, boolean z2) {
        if (hVar.z() == 0 || sVar.e() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z2) {
            return Math.abs(hVar.d(view) - hVar.d(view2)) + 1;
        }
        return Math.min(sVar2.f(), sVar2.b(view2) - sVar2.a(view));
    }

    static int a(RecyclerView.s sVar, s sVar2, View view, View view2, RecyclerView.h hVar, boolean z2, boolean z3) {
        if (hVar.z() == 0 || sVar.e() == 0 || view == null || view2 == null) {
            return 0;
        }
        int max = z3 ? Math.max(0, (sVar.e() - Math.max(hVar.d(view), hVar.d(view2))) - 1) : Math.max(0, Math.min(hVar.d(view), hVar.d(view2)));
        if (!z2) {
            return max;
        }
        return Math.round((((float) max) * (((float) Math.abs(sVar2.b(view2) - sVar2.a(view))) / ((float) (Math.abs(hVar.d(view) - hVar.d(view2)) + 1)))) + ((float) (sVar2.c() - sVar2.a(view))));
    }

    static int b(RecyclerView.s sVar, s sVar2, View view, View view2, RecyclerView.h hVar, boolean z2) {
        if (hVar.z() == 0 || sVar.e() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z2) {
            return sVar.e();
        }
        return (int) ((((float) (sVar2.b(view2) - sVar2.a(view))) / ((float) (Math.abs(hVar.d(view) - hVar.d(view2)) + 1))) * ((float) sVar.e()));
    }
}
