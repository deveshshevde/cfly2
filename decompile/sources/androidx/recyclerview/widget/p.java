package androidx.recyclerview.widget;

import android.graphics.PointF;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

public class p extends x {

    /* renamed from: b  reason: collision with root package name */
    private s f4310b;

    /* renamed from: c  reason: collision with root package name */
    private s f4311c;

    private int a(View view, s sVar) {
        return (sVar.a(view) + (sVar.e(view) / 2)) - (sVar.c() + (sVar.f() / 2));
    }

    private int a(RecyclerView.h hVar, s sVar, int i2, int i3) {
        int[] b2 = b(i2, i3);
        float b3 = b(hVar, sVar);
        if (b3 <= 0.0f) {
            return 0;
        }
        return Math.round(((float) (Math.abs(b2[0]) > Math.abs(b2[1]) ? b2[0] : b2[1])) / b3);
    }

    private View a(RecyclerView.h hVar, s sVar) {
        int z2 = hVar.z();
        View view = null;
        if (z2 == 0) {
            return null;
        }
        int c2 = sVar.c() + (sVar.f() / 2);
        int i2 = SubsamplingScaleImageView.TILE_SIZE_AUTO;
        for (int i3 = 0; i3 < z2; i3++) {
            View i4 = hVar.i(i3);
            int abs = Math.abs((sVar.a(i4) + (sVar.e(i4) / 2)) - c2);
            if (abs < i2) {
                view = i4;
                i2 = abs;
            }
        }
        return view;
    }

    private float b(RecyclerView.h hVar, s sVar) {
        int max;
        int z2 = hVar.z();
        if (z2 == 0) {
            return 1.0f;
        }
        View view = null;
        View view2 = null;
        int i2 = SubsamplingScaleImageView.TILE_SIZE_AUTO;
        int i3 = Integer.MIN_VALUE;
        for (int i4 = 0; i4 < z2; i4++) {
            View i5 = hVar.i(i4);
            int d2 = hVar.d(i5);
            if (d2 != -1) {
                if (d2 < i2) {
                    view = i5;
                    i2 = d2;
                }
                if (d2 > i3) {
                    view2 = i5;
                    i3 = d2;
                }
            }
        }
        if (view == null || view2 == null || (max = Math.max(sVar.b(view), sVar.b(view2)) - Math.min(sVar.a(view), sVar.a(view2))) == 0) {
            return 1.0f;
        }
        return (((float) max) * 1.0f) / ((float) ((i3 - i2) + 1));
    }

    private s d(RecyclerView.h hVar) {
        s sVar = this.f4310b;
        if (sVar == null || sVar.f4313a != hVar) {
            this.f4310b = s.b(hVar);
        }
        return this.f4310b;
    }

    private s e(RecyclerView.h hVar) {
        s sVar = this.f4311c;
        if (sVar == null || sVar.f4313a != hVar) {
            this.f4311c = s.a(hVar);
        }
        return this.f4311c;
    }

    public int a(RecyclerView.h hVar, int i2, int i3) {
        int J;
        View a2;
        int d2;
        int i4;
        PointF d3;
        int i5;
        int i6;
        if (!(hVar instanceof RecyclerView.r.b) || (J = hVar.J()) == 0 || (a2 = a(hVar)) == null || (d2 = hVar.d(a2)) == -1 || (d3 = ((RecyclerView.r.b) hVar).d(i4)) == null) {
            return -1;
        }
        int i7 = 0;
        if (hVar.f()) {
            i5 = a(hVar, e(hVar), i2, 0);
            if (d3.x < 0.0f) {
                i5 = -i5;
            }
        } else {
            i5 = 0;
        }
        if (hVar.g()) {
            i6 = a(hVar, d(hVar), 0, i3);
            if (d3.y < 0.0f) {
                i6 = -i6;
            }
        } else {
            i6 = 0;
        }
        if (hVar.g()) {
            i5 = i6;
        }
        if (i5 == 0) {
            return -1;
        }
        int i8 = d2 + i5;
        if (i8 >= 0) {
            i7 = i8;
        }
        return i7 >= J ? J - 1 : i7;
    }

    public View a(RecyclerView.h hVar) {
        s e2;
        if (hVar.g()) {
            e2 = d(hVar);
        } else if (!hVar.f()) {
            return null;
        } else {
            e2 = e(hVar);
        }
        return a(hVar, e2);
    }

    public int[] a(RecyclerView.h hVar, View view) {
        int[] iArr = new int[2];
        if (hVar.f()) {
            iArr[0] = a(view, e(hVar));
        } else {
            iArr[0] = 0;
        }
        if (hVar.g()) {
            iArr[1] = a(view, d(hVar));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }
}
