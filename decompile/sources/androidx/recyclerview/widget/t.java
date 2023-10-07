package androidx.recyclerview.widget;

import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

public class t extends x {

    /* renamed from: b  reason: collision with root package name */
    private s f4316b;

    /* renamed from: c  reason: collision with root package name */
    private s f4317c;

    private int a(View view, s sVar) {
        return (sVar.a(view) + (sVar.e(view) / 2)) - (sVar.c() + (sVar.f() / 2));
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

    private boolean b(RecyclerView.h hVar, int i2, int i3) {
        return hVar.f() ? i2 > 0 : i3 > 0;
    }

    private boolean d(RecyclerView.h hVar) {
        PointF d2;
        int J = hVar.J();
        if (!(hVar instanceof RecyclerView.r.b) || (d2 = ((RecyclerView.r.b) hVar).d(J - 1)) == null) {
            return false;
        }
        return d2.x < 0.0f || d2.y < 0.0f;
    }

    private s e(RecyclerView.h hVar) {
        if (hVar.g()) {
            return f(hVar);
        }
        if (hVar.f()) {
            return g(hVar);
        }
        return null;
    }

    private s f(RecyclerView.h hVar) {
        s sVar = this.f4316b;
        if (sVar == null || sVar.f4313a != hVar) {
            this.f4316b = s.b(hVar);
        }
        return this.f4316b;
    }

    private s g(RecyclerView.h hVar) {
        s sVar = this.f4317c;
        if (sVar == null || sVar.f4313a != hVar) {
            this.f4317c = s.a(hVar);
        }
        return this.f4317c;
    }

    public int a(RecyclerView.h hVar, int i2, int i3) {
        s e2;
        int J = hVar.J();
        if (J == 0 || (e2 = e(hVar)) == null) {
            return -1;
        }
        int i4 = Integer.MIN_VALUE;
        int i5 = SubsamplingScaleImageView.TILE_SIZE_AUTO;
        int z2 = hVar.z();
        View view = null;
        View view2 = null;
        for (int i6 = 0; i6 < z2; i6++) {
            View i7 = hVar.i(i6);
            if (i7 != null) {
                int a2 = a(i7, e2);
                if (a2 <= 0 && a2 > i4) {
                    view2 = i7;
                    i4 = a2;
                }
                if (a2 >= 0 && a2 < i5) {
                    view = i7;
                    i5 = a2;
                }
            }
        }
        boolean b2 = b(hVar, i2, i3);
        if (b2 && view != null) {
            return hVar.d(view);
        }
        if (!b2 && view2 != null) {
            return hVar.d(view2);
        }
        if (b2) {
            view = view2;
        }
        if (view == null) {
            return -1;
        }
        int d2 = hVar.d(view) + (d(hVar) == b2 ? -1 : 1);
        if (d2 < 0 || d2 >= J) {
            return -1;
        }
        return d2;
    }

    public View a(RecyclerView.h hVar) {
        s g2;
        if (hVar.g()) {
            g2 = f(hVar);
        } else if (!hVar.f()) {
            return null;
        } else {
            g2 = g(hVar);
        }
        return a(hVar, g2);
    }

    public int[] a(RecyclerView.h hVar, View view) {
        int[] iArr = new int[2];
        if (hVar.f()) {
            iArr[0] = a(view, g(hVar));
        } else {
            iArr[0] = 0;
        }
        if (hVar.g()) {
            iArr[1] = a(view, f(hVar));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    /* access modifiers changed from: protected */
    public RecyclerView.r b(RecyclerView.h hVar) {
        if (!(hVar instanceof RecyclerView.r.b)) {
            return null;
        }
        return new o(this.f4324a.getContext()) {
            /* access modifiers changed from: protected */
            public float a(DisplayMetrics displayMetrics) {
                return 100.0f / ((float) displayMetrics.densityDpi);
            }

            /* access modifiers changed from: protected */
            public void a(View view, RecyclerView.s sVar, RecyclerView.r.a aVar) {
                t tVar = t.this;
                int[] a2 = tVar.a(tVar.f4324a.getLayoutManager(), view);
                int i2 = a2[0];
                int i3 = a2[1];
                int a3 = a(Math.max(Math.abs(i2), Math.abs(i3)));
                if (a3 > 0) {
                    aVar.a(i2, i3, a3, this.f4303b);
                }
            }

            /* access modifiers changed from: protected */
            public int b(int i2) {
                return Math.min(100, super.b(i2));
            }
        };
    }
}
