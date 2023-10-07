package androidx.recyclerview.widget;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.recyclerview.widget.RecyclerView;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

public abstract class x extends RecyclerView.j {

    /* renamed from: a  reason: collision with root package name */
    RecyclerView f4324a;

    /* renamed from: b  reason: collision with root package name */
    private Scroller f4325b;

    /* renamed from: c  reason: collision with root package name */
    private final RecyclerView.l f4326c = new RecyclerView.l() {

        /* renamed from: a  reason: collision with root package name */
        boolean f4327a = false;

        public void a(RecyclerView recyclerView, int i2) {
            super.a(recyclerView, i2);
            if (i2 == 0 && this.f4327a) {
                this.f4327a = false;
                x.this.a();
            }
        }

        public void a(RecyclerView recyclerView, int i2, int i3) {
            if (i2 != 0 || i3 != 0) {
                this.f4327a = true;
            }
        }
    };

    private void b() throws IllegalStateException {
        if (this.f4324a.getOnFlingListener() == null) {
            this.f4324a.a(this.f4326c);
            this.f4324a.setOnFlingListener(this);
            return;
        }
        throw new IllegalStateException("An instance of OnFlingListener already set.");
    }

    private boolean b(RecyclerView.h hVar, int i2, int i3) {
        RecyclerView.r b2;
        int a2;
        if (!(hVar instanceof RecyclerView.r.b) || (b2 = b(hVar)) == null || (a2 = a(hVar, i2, i3)) == -1) {
            return false;
        }
        b2.c(a2);
        hVar.a(b2);
        return true;
    }

    private void c() {
        this.f4324a.b(this.f4326c);
        this.f4324a.setOnFlingListener((RecyclerView.j) null);
    }

    public abstract int a(RecyclerView.h hVar, int i2, int i3);

    public abstract View a(RecyclerView.h hVar);

    /* access modifiers changed from: package-private */
    public void a() {
        RecyclerView.h layoutManager;
        View a2;
        RecyclerView recyclerView = this.f4324a;
        if (recyclerView != null && (layoutManager = recyclerView.getLayoutManager()) != null && (a2 = a(layoutManager)) != null) {
            int[] a3 = a(layoutManager, a2);
            if (a3[0] != 0 || a3[1] != 0) {
                this.f4324a.a(a3[0], a3[1]);
            }
        }
    }

    public void a(RecyclerView recyclerView) throws IllegalStateException {
        RecyclerView recyclerView2 = this.f4324a;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                c();
            }
            this.f4324a = recyclerView;
            if (recyclerView != null) {
                b();
                this.f4325b = new Scroller(this.f4324a.getContext(), new DecelerateInterpolator());
                a();
            }
        }
    }

    public boolean a(int i2, int i3) {
        RecyclerView.h layoutManager = this.f4324a.getLayoutManager();
        if (layoutManager == null || this.f4324a.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.f4324a.getMinFlingVelocity();
        return (Math.abs(i3) > minFlingVelocity || Math.abs(i2) > minFlingVelocity) && b(layoutManager, i2, i3);
    }

    public abstract int[] a(RecyclerView.h hVar, View view);

    /* access modifiers changed from: protected */
    public RecyclerView.r b(RecyclerView.h hVar) {
        return c(hVar);
    }

    public int[] b(int i2, int i3) {
        this.f4325b.fling(0, 0, i2, i3, Integer.MIN_VALUE, SubsamplingScaleImageView.TILE_SIZE_AUTO, Integer.MIN_VALUE, SubsamplingScaleImageView.TILE_SIZE_AUTO);
        return new int[]{this.f4325b.getFinalX(), this.f4325b.getFinalY()};
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public o c(RecyclerView.h hVar) {
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
                if (x.this.f4324a != null) {
                    x xVar = x.this;
                    int[] a2 = xVar.a(xVar.f4324a.getLayoutManager(), view);
                    int i2 = a2[0];
                    int i3 = a2[1];
                    int a3 = a(Math.max(Math.abs(i2), Math.abs(i3)));
                    if (a3 > 0) {
                        aVar.a(i2, i3, a3, this.f4303b);
                    }
                }
            }
        };
    }
}
