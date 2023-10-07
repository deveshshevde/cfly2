package androidx.recyclerview.widget;

import androidx.core.os.i;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

final class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    static final ThreadLocal<j> f4222a = new ThreadLocal<>();

    /* renamed from: e  reason: collision with root package name */
    static Comparator<b> f4223e = new Comparator<b>() {
        /* renamed from: a */
        public int compare(b bVar, b bVar2) {
            if ((bVar.f4235d == null) != (bVar2.f4235d == null)) {
                return bVar.f4235d == null ? 1 : -1;
            }
            if (bVar.f4232a != bVar2.f4232a) {
                return bVar.f4232a ? -1 : 1;
            }
            int i2 = bVar2.f4233b - bVar.f4233b;
            if (i2 != 0) {
                return i2;
            }
            int i3 = bVar.f4234c - bVar2.f4234c;
            if (i3 != 0) {
                return i3;
            }
            return 0;
        }
    };

    /* renamed from: b  reason: collision with root package name */
    ArrayList<RecyclerView> f4224b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    long f4225c;

    /* renamed from: d  reason: collision with root package name */
    long f4226d;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<b> f4227f = new ArrayList<>();

    static class a implements RecyclerView.h.a {

        /* renamed from: a  reason: collision with root package name */
        int f4228a;

        /* renamed from: b  reason: collision with root package name */
        int f4229b;

        /* renamed from: c  reason: collision with root package name */
        int[] f4230c;

        /* renamed from: d  reason: collision with root package name */
        int f4231d;

        a() {
        }

        /* access modifiers changed from: package-private */
        public void a() {
            int[] iArr = this.f4230c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f4231d = 0;
        }

        /* access modifiers changed from: package-private */
        public void a(int i2, int i3) {
            this.f4228a = i2;
            this.f4229b = i3;
        }

        /* access modifiers changed from: package-private */
        public void a(RecyclerView recyclerView, boolean z2) {
            this.f4231d = 0;
            int[] iArr = this.f4230c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.h hVar = recyclerView.f3923o;
            if (recyclerView.f3922n != null && hVar != null && hVar.t()) {
                if (z2) {
                    if (!recyclerView.f3915g.d()) {
                        hVar.a(recyclerView.f3922n.getItemCount(), (RecyclerView.h.a) this);
                    }
                } else if (!recyclerView.v()) {
                    hVar.a(this.f4228a, this.f4229b, recyclerView.F, (RecyclerView.h.a) this);
                }
                if (this.f4231d > hVar.f3977x) {
                    hVar.f3977x = this.f4231d;
                    hVar.f3978y = z2;
                    recyclerView.f3913e.b();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public boolean a(int i2) {
            if (this.f4230c != null) {
                int i3 = this.f4231d * 2;
                for (int i4 = 0; i4 < i3; i4 += 2) {
                    if (this.f4230c[i4] == i2) {
                        return true;
                    }
                }
            }
            return false;
        }

        public void b(int i2, int i3) {
            if (i2 < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            } else if (i3 >= 0) {
                int i4 = this.f4231d * 2;
                int[] iArr = this.f4230c;
                if (iArr == null) {
                    int[] iArr2 = new int[4];
                    this.f4230c = iArr2;
                    Arrays.fill(iArr2, -1);
                } else if (i4 >= iArr.length) {
                    int[] iArr3 = new int[(i4 * 2)];
                    this.f4230c = iArr3;
                    System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                }
                int[] iArr4 = this.f4230c;
                iArr4[i4] = i2;
                iArr4[i4 + 1] = i3;
                this.f4231d++;
            } else {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
        }
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        public boolean f4232a;

        /* renamed from: b  reason: collision with root package name */
        public int f4233b;

        /* renamed from: c  reason: collision with root package name */
        public int f4234c;

        /* renamed from: d  reason: collision with root package name */
        public RecyclerView f4235d;

        /* renamed from: e  reason: collision with root package name */
        public int f4236e;

        b() {
        }

        public void a() {
            this.f4232a = false;
            this.f4233b = 0;
            this.f4234c = 0;
            this.f4235d = null;
            this.f4236e = 0;
        }
    }

    j() {
    }

    private RecyclerView.v a(RecyclerView recyclerView, int i2, long j2) {
        if (a(recyclerView, i2)) {
            return null;
        }
        RecyclerView.n nVar = recyclerView.f3913e;
        try {
            recyclerView.l();
            RecyclerView.v a2 = nVar.a(i2, false, j2);
            if (a2 != null) {
                if (!a2.isBound() || a2.isInvalid()) {
                    nVar.a(a2, false);
                } else {
                    nVar.a(a2.itemView);
                }
            }
            return a2;
        } finally {
            recyclerView.b(false);
        }
    }

    private void a() {
        b bVar;
        int size = this.f4224b.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            RecyclerView recyclerView = this.f4224b.get(i3);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.E.a(recyclerView, false);
                i2 += recyclerView.E.f4231d;
            }
        }
        this.f4227f.ensureCapacity(i2);
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            RecyclerView recyclerView2 = this.f4224b.get(i5);
            if (recyclerView2.getWindowVisibility() == 0) {
                a aVar = recyclerView2.E;
                int abs = Math.abs(aVar.f4228a) + Math.abs(aVar.f4229b);
                for (int i6 = 0; i6 < aVar.f4231d * 2; i6 += 2) {
                    if (i4 >= this.f4227f.size()) {
                        bVar = new b();
                        this.f4227f.add(bVar);
                    } else {
                        bVar = this.f4227f.get(i4);
                    }
                    int i7 = aVar.f4230c[i6 + 1];
                    bVar.f4232a = i7 <= abs;
                    bVar.f4233b = abs;
                    bVar.f4234c = i7;
                    bVar.f4235d = recyclerView2;
                    bVar.f4236e = aVar.f4230c[i6];
                    i4++;
                }
            }
        }
        Collections.sort(this.f4227f, f4223e);
    }

    private void a(RecyclerView recyclerView, long j2) {
        if (recyclerView != null) {
            if (recyclerView.f3934z && recyclerView.f3916h.c() != 0) {
                recyclerView.c();
            }
            a aVar = recyclerView.E;
            aVar.a(recyclerView, true);
            if (aVar.f4231d != 0) {
                try {
                    i.a("RV Nested Prefetch");
                    recyclerView.F.a(recyclerView.f3922n);
                    for (int i2 = 0; i2 < aVar.f4231d * 2; i2 += 2) {
                        a(recyclerView, aVar.f4230c[i2], j2);
                    }
                } finally {
                    i.a();
                }
            }
        }
    }

    private void a(b bVar, long j2) {
        RecyclerView.v a2 = a(bVar.f4235d, bVar.f4236e, bVar.f4232a ? Long.MAX_VALUE : j2);
        if (a2 != null && a2.mNestedRecyclerView != null && a2.isBound() && !a2.isInvalid()) {
            a((RecyclerView) a2.mNestedRecyclerView.get(), j2);
        }
    }

    static boolean a(RecyclerView recyclerView, int i2) {
        int c2 = recyclerView.f3916h.c();
        for (int i3 = 0; i3 < c2; i3++) {
            RecyclerView.v e2 = RecyclerView.e(recyclerView.f3916h.d(i3));
            if (e2.mPosition == i2 && !e2.isInvalid()) {
                return true;
            }
        }
        return false;
    }

    private void b(long j2) {
        int i2 = 0;
        while (i2 < this.f4227f.size()) {
            b bVar = this.f4227f.get(i2);
            if (bVar.f4235d != null) {
                a(bVar, j2);
                bVar.a();
                i2++;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(long j2) {
        a();
        b(j2);
    }

    public void a(RecyclerView recyclerView) {
        this.f4224b.add(recyclerView);
    }

    /* access modifiers changed from: package-private */
    public void a(RecyclerView recyclerView, int i2, int i3) {
        if (recyclerView.isAttachedToWindow() && this.f4225c == 0) {
            this.f4225c = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.E.a(i2, i3);
    }

    public void b(RecyclerView recyclerView) {
        this.f4224b.remove(recyclerView);
    }

    public void run() {
        try {
            i.a("RV Prefetch");
            if (!this.f4224b.isEmpty()) {
                int size = this.f4224b.size();
                long j2 = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    RecyclerView recyclerView = this.f4224b.get(i2);
                    if (recyclerView.getWindowVisibility() == 0) {
                        j2 = Math.max(recyclerView.getDrawingTime(), j2);
                    }
                }
                if (j2 != 0) {
                    a(TimeUnit.MILLISECONDS.toNanos(j2) + this.f4226d);
                    this.f4225c = 0;
                    i.a();
                }
            }
        } finally {
            this.f4225c = 0;
            i.a();
        }
    }
}
