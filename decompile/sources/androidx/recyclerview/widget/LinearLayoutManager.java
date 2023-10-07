package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.k;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.List;

public class LinearLayoutManager extends RecyclerView.h implements RecyclerView.r.b, k.d {

    /* renamed from: a  reason: collision with root package name */
    private c f3842a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f3843b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f3844c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f3845d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f3846e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f3847f;

    /* renamed from: g  reason: collision with root package name */
    private final b f3848g;

    /* renamed from: h  reason: collision with root package name */
    private int f3849h;

    /* renamed from: i  reason: collision with root package name */
    int f3850i;

    /* renamed from: j  reason: collision with root package name */
    s f3851j;

    /* renamed from: k  reason: collision with root package name */
    boolean f3852k;

    /* renamed from: l  reason: collision with root package name */
    int f3853l;

    /* renamed from: m  reason: collision with root package name */
    int f3854m;

    /* renamed from: n  reason: collision with root package name */
    SavedState f3855n;

    /* renamed from: o  reason: collision with root package name */
    final a f3856o;

    /* renamed from: z  reason: collision with root package name */
    private int[] f3857z;

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: a */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        int f3858a;

        /* renamed from: b  reason: collision with root package name */
        int f3859b;

        /* renamed from: c  reason: collision with root package name */
        boolean f3860c;

        public SavedState() {
        }

        SavedState(Parcel parcel) {
            this.f3858a = parcel.readInt();
            this.f3859b = parcel.readInt();
            this.f3860c = parcel.readInt() != 1 ? false : true;
        }

        public SavedState(SavedState savedState) {
            this.f3858a = savedState.f3858a;
            this.f3859b = savedState.f3859b;
            this.f3860c = savedState.f3860c;
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            return this.f3858a >= 0;
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.f3858a = -1;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f3858a);
            parcel.writeInt(this.f3859b);
            parcel.writeInt(this.f3860c ? 1 : 0);
        }
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        s f3861a;

        /* renamed from: b  reason: collision with root package name */
        int f3862b;

        /* renamed from: c  reason: collision with root package name */
        int f3863c;

        /* renamed from: d  reason: collision with root package name */
        boolean f3864d;

        /* renamed from: e  reason: collision with root package name */
        boolean f3865e;

        a() {
            a();
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f3862b = -1;
            this.f3863c = Integer.MIN_VALUE;
            this.f3864d = false;
            this.f3865e = false;
        }

        public void a(View view, int i2) {
            int b2 = this.f3861a.b();
            if (b2 >= 0) {
                b(view, i2);
                return;
            }
            this.f3862b = i2;
            if (this.f3864d) {
                int d2 = (this.f3861a.d() - b2) - this.f3861a.b(view);
                this.f3863c = this.f3861a.d() - d2;
                if (d2 > 0) {
                    int e2 = this.f3863c - this.f3861a.e(view);
                    int c2 = this.f3861a.c();
                    int min = e2 - (c2 + Math.min(this.f3861a.a(view) - c2, 0));
                    if (min < 0) {
                        this.f3863c += Math.min(d2, -min);
                        return;
                    }
                    return;
                }
                return;
            }
            int a2 = this.f3861a.a(view);
            int c3 = a2 - this.f3861a.c();
            this.f3863c = a2;
            if (c3 > 0) {
                int d3 = (this.f3861a.d() - Math.min(0, (this.f3861a.d() - b2) - this.f3861a.b(view))) - (a2 + this.f3861a.e(view));
                if (d3 < 0) {
                    this.f3863c -= Math.min(c3, -d3);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public boolean a(View view, RecyclerView.s sVar) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return !layoutParams.d() && layoutParams.f() >= 0 && layoutParams.f() < sVar.e();
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.f3863c = this.f3864d ? this.f3861a.d() : this.f3861a.c();
        }

        public void b(View view, int i2) {
            this.f3863c = this.f3864d ? this.f3861a.b(view) + this.f3861a.b() : this.f3861a.a(view);
            this.f3862b = i2;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f3862b + ", mCoordinate=" + this.f3863c + ", mLayoutFromEnd=" + this.f3864d + ", mValid=" + this.f3865e + '}';
        }
    }

    protected static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f3866a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f3867b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f3868c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f3869d;

        protected b() {
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f3866a = 0;
            this.f3867b = false;
            this.f3868c = false;
            this.f3869d = false;
        }
    }

    static class c {

        /* renamed from: a  reason: collision with root package name */
        boolean f3870a = true;

        /* renamed from: b  reason: collision with root package name */
        int f3871b;

        /* renamed from: c  reason: collision with root package name */
        int f3872c;

        /* renamed from: d  reason: collision with root package name */
        int f3873d;

        /* renamed from: e  reason: collision with root package name */
        int f3874e;

        /* renamed from: f  reason: collision with root package name */
        int f3875f;

        /* renamed from: g  reason: collision with root package name */
        int f3876g;

        /* renamed from: h  reason: collision with root package name */
        int f3877h = 0;

        /* renamed from: i  reason: collision with root package name */
        int f3878i = 0;

        /* renamed from: j  reason: collision with root package name */
        boolean f3879j = false;

        /* renamed from: k  reason: collision with root package name */
        int f3880k;

        /* renamed from: l  reason: collision with root package name */
        List<RecyclerView.v> f3881l = null;

        /* renamed from: m  reason: collision with root package name */
        boolean f3882m;

        c() {
        }

        private View b() {
            int size = this.f3881l.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = this.f3881l.get(i2).itemView;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                if (!layoutParams.d() && this.f3873d == layoutParams.f()) {
                    a(view);
                    return view;
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public View a(RecyclerView.n nVar) {
            if (this.f3881l != null) {
                return b();
            }
            View c2 = nVar.c(this.f3873d);
            this.f3873d += this.f3874e;
            return c2;
        }

        public void a() {
            a((View) null);
        }

        public void a(View view) {
            View b2 = b(view);
            this.f3873d = b2 == null ? -1 : ((RecyclerView.LayoutParams) b2.getLayoutParams()).f();
        }

        /* access modifiers changed from: package-private */
        public boolean a(RecyclerView.s sVar) {
            int i2 = this.f3873d;
            return i2 >= 0 && i2 < sVar.e();
        }

        public View b(View view) {
            int f2;
            int size = this.f3881l.size();
            View view2 = null;
            int i2 = SubsamplingScaleImageView.TILE_SIZE_AUTO;
            for (int i3 = 0; i3 < size; i3++) {
                View view3 = this.f3881l.get(i3).itemView;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view3.getLayoutParams();
                if (view3 != view && !layoutParams.d() && (f2 = (layoutParams.f() - this.f3873d) * this.f3874e) >= 0 && f2 < i2) {
                    view2 = view3;
                    if (f2 == 0) {
                        break;
                    }
                    i2 = f2;
                }
            }
            return view2;
        }
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    public LinearLayoutManager(Context context, int i2, boolean z2) {
        this.f3850i = 1;
        this.f3844c = false;
        this.f3852k = false;
        this.f3845d = false;
        this.f3846e = true;
        this.f3853l = -1;
        this.f3854m = Integer.MIN_VALUE;
        this.f3855n = null;
        this.f3856o = new a();
        this.f3848g = new b();
        this.f3849h = 2;
        this.f3857z = new int[2];
        b(i2);
        b(z2);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        this.f3850i = 1;
        this.f3844c = false;
        this.f3852k = false;
        this.f3845d = false;
        this.f3846e = true;
        this.f3853l = -1;
        this.f3854m = Integer.MIN_VALUE;
        this.f3855n = null;
        this.f3856o = new a();
        this.f3848g = new b();
        this.f3849h = 2;
        this.f3857z = new int[2];
        RecyclerView.h.b a2 = a(context, attributeSet, i2, i3);
        b(a2.f3981a);
        b(a2.f3983c);
        a(a2.f3984d);
    }

    private View P() {
        return i(this.f3852k ? z() - 1 : 0);
    }

    private View Q() {
        return i(this.f3852k ? 0 : z() - 1);
    }

    private View R() {
        return this.f3852k ? T() : U();
    }

    private View S() {
        return this.f3852k ? U() : T();
    }

    private View T() {
        return c(0, z());
    }

    private View U() {
        return c(z() - 1, -1);
    }

    private int a(int i2, RecyclerView.n nVar, RecyclerView.s sVar, boolean z2) {
        int d2;
        int d3 = this.f3851j.d() - i2;
        if (d3 <= 0) {
            return 0;
        }
        int i3 = -c(-d3, nVar, sVar);
        int i4 = i2 + i3;
        if (!z2 || (d2 = this.f3851j.d() - i4) <= 0) {
            return i3;
        }
        this.f3851j.a(d2);
        return d2 + i3;
    }

    private void a(int i2, int i3) {
        this.f3842a.f3872c = this.f3851j.d() - i3;
        this.f3842a.f3874e = this.f3852k ? -1 : 1;
        this.f3842a.f3873d = i2;
        this.f3842a.f3875f = 1;
        this.f3842a.f3871b = i3;
        this.f3842a.f3876g = Integer.MIN_VALUE;
    }

    private void a(int i2, int i3, boolean z2, RecyclerView.s sVar) {
        int i4;
        this.f3842a.f3882m = m();
        this.f3842a.f3875f = i2;
        int[] iArr = this.f3857z;
        boolean z3 = false;
        iArr[0] = 0;
        int i5 = 1;
        iArr[1] = 0;
        a(sVar, iArr);
        int max = Math.max(0, this.f3857z[0]);
        int max2 = Math.max(0, this.f3857z[1]);
        if (i2 == 1) {
            z3 = true;
        }
        this.f3842a.f3877h = z3 ? max2 : max;
        c cVar = this.f3842a;
        if (!z3) {
            max = max2;
        }
        cVar.f3878i = max;
        if (z3) {
            this.f3842a.f3877h += this.f3851j.g();
            View Q = Q();
            c cVar2 = this.f3842a;
            if (this.f3852k) {
                i5 = -1;
            }
            cVar2.f3874e = i5;
            this.f3842a.f3873d = d(Q) + this.f3842a.f3874e;
            this.f3842a.f3871b = this.f3851j.b(Q);
            i4 = this.f3851j.b(Q) - this.f3851j.d();
        } else {
            View P = P();
            this.f3842a.f3877h += this.f3851j.c();
            c cVar3 = this.f3842a;
            if (!this.f3852k) {
                i5 = -1;
            }
            cVar3.f3874e = i5;
            this.f3842a.f3873d = d(P) + this.f3842a.f3874e;
            this.f3842a.f3871b = this.f3851j.a(P);
            i4 = (-this.f3851j.a(P)) + this.f3851j.c();
        }
        this.f3842a.f3872c = i3;
        if (z2) {
            this.f3842a.f3872c -= i4;
        }
        this.f3842a.f3876g = i4;
    }

    private void a(a aVar) {
        a(aVar.f3862b, aVar.f3863c);
    }

    private void a(RecyclerView.n nVar, int i2, int i3) {
        if (i2 != i3) {
            if (i3 > i2) {
                for (int i4 = i3 - 1; i4 >= i2; i4--) {
                    a(i4, nVar);
                }
                return;
            }
            while (i2 > i3) {
                a(i2, nVar);
                i2--;
            }
        }
    }

    private void a(RecyclerView.n nVar, c cVar) {
        if (cVar.f3870a && !cVar.f3882m) {
            int i2 = cVar.f3876g;
            int i3 = cVar.f3878i;
            if (cVar.f3875f == -1) {
                c(nVar, i2, i3);
            } else {
                b(nVar, i2, i3);
            }
        }
    }

    private void a(RecyclerView.n nVar, RecyclerView.s sVar, a aVar) {
        if (!a(sVar, aVar) && !b(nVar, sVar, aVar)) {
            aVar.b();
            aVar.f3862b = this.f3845d ? sVar.e() - 1 : 0;
        }
    }

    private boolean a(RecyclerView.s sVar, a aVar) {
        int i2;
        boolean z2 = false;
        if (!sVar.a() && (i2 = this.f3853l) != -1) {
            if (i2 < 0 || i2 >= sVar.e()) {
                this.f3853l = -1;
                this.f3854m = Integer.MIN_VALUE;
            } else {
                aVar.f3862b = this.f3853l;
                SavedState savedState = this.f3855n;
                if (savedState != null && savedState.a()) {
                    aVar.f3864d = this.f3855n.f3860c;
                    aVar.f3863c = aVar.f3864d ? this.f3851j.d() - this.f3855n.f3859b : this.f3851j.c() + this.f3855n.f3859b;
                    return true;
                } else if (this.f3854m == Integer.MIN_VALUE) {
                    View c2 = c(this.f3853l);
                    if (c2 == null) {
                        if (z() > 0) {
                            if ((this.f3853l < d(i(0))) == this.f3852k) {
                                z2 = true;
                            }
                            aVar.f3864d = z2;
                        }
                        aVar.b();
                    } else if (this.f3851j.e(c2) > this.f3851j.f()) {
                        aVar.b();
                        return true;
                    } else if (this.f3851j.a(c2) - this.f3851j.c() < 0) {
                        aVar.f3863c = this.f3851j.c();
                        aVar.f3864d = false;
                        return true;
                    } else if (this.f3851j.d() - this.f3851j.b(c2) < 0) {
                        aVar.f3863c = this.f3851j.d();
                        aVar.f3864d = true;
                        return true;
                    } else {
                        aVar.f3863c = aVar.f3864d ? this.f3851j.b(c2) + this.f3851j.b() : this.f3851j.a(c2);
                    }
                    return true;
                } else {
                    aVar.f3864d = this.f3852k;
                    aVar.f3863c = this.f3852k ? this.f3851j.d() - this.f3854m : this.f3851j.c() + this.f3854m;
                    return true;
                }
            }
        }
        return false;
    }

    private int b(int i2, RecyclerView.n nVar, RecyclerView.s sVar, boolean z2) {
        int c2;
        int c3 = i2 - this.f3851j.c();
        if (c3 <= 0) {
            return 0;
        }
        int i3 = -c(c3, nVar, sVar);
        int i4 = i2 + i3;
        if (!z2 || (c2 = i4 - this.f3851j.c()) <= 0) {
            return i3;
        }
        this.f3851j.a(-c2);
        return i3 - c2;
    }

    private void b() {
        this.f3852k = (this.f3850i == 1 || !i()) ? this.f3844c : !this.f3844c;
    }

    private void b(a aVar) {
        h(aVar.f3862b, aVar.f3863c);
    }

    private void b(RecyclerView.n nVar, int i2, int i3) {
        if (i2 >= 0) {
            int i4 = i2 - i3;
            int z2 = z();
            if (this.f3852k) {
                int i5 = z2 - 1;
                for (int i6 = i5; i6 >= 0; i6--) {
                    View i7 = i(i6);
                    if (this.f3851j.b(i7) > i4 || this.f3851j.c(i7) > i4) {
                        a(nVar, i5, i6);
                        return;
                    }
                }
                return;
            }
            for (int i8 = 0; i8 < z2; i8++) {
                View i9 = i(i8);
                if (this.f3851j.b(i9) > i4 || this.f3851j.c(i9) > i4) {
                    a(nVar, 0, i8);
                    return;
                }
            }
        }
    }

    private void b(RecyclerView.n nVar, RecyclerView.s sVar, int i2, int i3) {
        RecyclerView.n nVar2 = nVar;
        RecyclerView.s sVar2 = sVar;
        if (sVar.b() && z() != 0 && !sVar.a() && c()) {
            List<RecyclerView.v> c2 = nVar.c();
            int size = c2.size();
            int d2 = d(i(0));
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < size; i6++) {
                RecyclerView.v vVar = c2.get(i6);
                if (!vVar.isRemoved()) {
                    char c3 = 1;
                    if ((vVar.getLayoutPosition() < d2) != this.f3852k) {
                        c3 = 65535;
                    }
                    int e2 = this.f3851j.e(vVar.itemView);
                    if (c3 == 65535) {
                        i4 += e2;
                    } else {
                        i5 += e2;
                    }
                }
            }
            this.f3842a.f3881l = c2;
            if (i4 > 0) {
                h(d(P()), i2);
                this.f3842a.f3877h = i4;
                this.f3842a.f3872c = 0;
                this.f3842a.a();
                a(nVar2, this.f3842a, sVar2, false);
            }
            if (i5 > 0) {
                a(d(Q()), i3);
                this.f3842a.f3877h = i5;
                this.f3842a.f3872c = 0;
                this.f3842a.a();
                a(nVar2, this.f3842a, sVar2, false);
            }
            this.f3842a.f3881l = null;
        }
    }

    private boolean b(RecyclerView.n nVar, RecyclerView.s sVar, a aVar) {
        View a2;
        boolean z2 = false;
        if (z() == 0) {
            return false;
        }
        View I = I();
        if (I != null && aVar.a(I, sVar)) {
            aVar.a(I, d(I));
            return true;
        } else if (this.f3843b != this.f3845d || (a2 = a(nVar, sVar, aVar.f3864d, this.f3845d)) == null) {
            return false;
        } else {
            aVar.b(a2, d(a2));
            if (!sVar.a() && c()) {
                int a3 = this.f3851j.a(a2);
                int b2 = this.f3851j.b(a2);
                int c2 = this.f3851j.c();
                int d2 = this.f3851j.d();
                boolean z3 = b2 <= c2 && a3 < c2;
                if (a3 >= d2 && b2 > d2) {
                    z2 = true;
                }
                if (z3 || z2) {
                    if (aVar.f3864d) {
                        c2 = d2;
                    }
                    aVar.f3863c = c2;
                }
            }
            return true;
        }
    }

    private void c(RecyclerView.n nVar, int i2, int i3) {
        int z2 = z();
        if (i2 >= 0) {
            int e2 = (this.f3851j.e() - i2) + i3;
            if (this.f3852k) {
                for (int i4 = 0; i4 < z2; i4++) {
                    View i5 = i(i4);
                    if (this.f3851j.a(i5) < e2 || this.f3851j.d(i5) < e2) {
                        a(nVar, 0, i4);
                        return;
                    }
                }
                return;
            }
            int i6 = z2 - 1;
            for (int i7 = i6; i7 >= 0; i7--) {
                View i8 = i(i7);
                if (this.f3851j.a(i8) < e2 || this.f3851j.d(i8) < e2) {
                    a(nVar, i6, i7);
                    return;
                }
            }
        }
    }

    private void h(int i2, int i3) {
        this.f3842a.f3872c = i3 - this.f3851j.c();
        this.f3842a.f3873d = i2;
        this.f3842a.f3874e = this.f3852k ? 1 : -1;
        this.f3842a.f3875f = -1;
        this.f3842a.f3871b = i3;
        this.f3842a.f3876g = Integer.MIN_VALUE;
    }

    private int i(RecyclerView.s sVar) {
        if (z() == 0) {
            return 0;
        }
        j();
        s sVar2 = this.f3851j;
        View a2 = a(!this.f3846e, true);
        return v.a(sVar, sVar2, a2, b(!this.f3846e, true), this, this.f3846e, this.f3852k);
    }

    private int j(RecyclerView.s sVar) {
        if (z() == 0) {
            return 0;
        }
        j();
        s sVar2 = this.f3851j;
        View a2 = a(!this.f3846e, true);
        return v.a(sVar, sVar2, a2, b(!this.f3846e, true), this, this.f3846e);
    }

    private int k(RecyclerView.s sVar) {
        if (z() == 0) {
            return 0;
        }
        j();
        s sVar2 = this.f3851j;
        View a2 = a(!this.f3846e, true);
        return v.b(sVar, sVar2, a2, b(!this.f3846e, true), this, this.f3846e);
    }

    public int a(int i2, RecyclerView.n nVar, RecyclerView.s sVar) {
        if (this.f3850i == 1) {
            return 0;
        }
        return c(i2, nVar, sVar);
    }

    /* access modifiers changed from: package-private */
    public int a(RecyclerView.n nVar, c cVar, RecyclerView.s sVar, boolean z2) {
        int i2 = cVar.f3872c;
        if (cVar.f3876g != Integer.MIN_VALUE) {
            if (cVar.f3872c < 0) {
                cVar.f3876g += cVar.f3872c;
            }
            a(nVar, cVar);
        }
        int i3 = cVar.f3872c + cVar.f3877h;
        b bVar = this.f3848g;
        while (true) {
            if ((!cVar.f3882m && i3 <= 0) || !cVar.a(sVar)) {
                break;
            }
            bVar.a();
            a(nVar, sVar, cVar, bVar);
            if (!bVar.f3867b) {
                cVar.f3871b += bVar.f3866a * cVar.f3875f;
                if (!bVar.f3868c || cVar.f3881l != null || !sVar.a()) {
                    cVar.f3872c -= bVar.f3866a;
                    i3 -= bVar.f3866a;
                }
                if (cVar.f3876g != Integer.MIN_VALUE) {
                    cVar.f3876g += bVar.f3866a;
                    if (cVar.f3872c < 0) {
                        cVar.f3876g += cVar.f3872c;
                    }
                    a(nVar, cVar);
                }
                if (z2 && bVar.f3869d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i2 - cVar.f3872c;
    }

    /* access modifiers changed from: package-private */
    public View a(int i2, int i3, boolean z2, boolean z3) {
        j();
        int i4 = GlMapUtil.DEVICE_DISPLAY_DPI_HIGH;
        int i5 = z2 ? 24579 : GlMapUtil.DEVICE_DISPLAY_DPI_HIGH;
        if (!z3) {
            i4 = 0;
        }
        return (this.f3850i == 0 ? this.f3971r : this.f3972s).a(i2, i3, i5, i4);
    }

    public View a(View view, int i2, RecyclerView.n nVar, RecyclerView.s sVar) {
        int f2;
        b();
        if (z() == 0 || (f2 = f(i2)) == Integer.MIN_VALUE) {
            return null;
        }
        j();
        a(f2, (int) (((float) this.f3851j.f()) * 0.33333334f), false, sVar);
        this.f3842a.f3876g = Integer.MIN_VALUE;
        this.f3842a.f3870a = false;
        a(nVar, this.f3842a, sVar, true);
        View S = f2 == -1 ? S() : R();
        View P = f2 == -1 ? P() : Q();
        if (!P.hasFocusable()) {
            return S;
        }
        if (S == null) {
            return null;
        }
        return P;
    }

    /* access modifiers changed from: package-private */
    public View a(RecyclerView.n nVar, RecyclerView.s sVar, boolean z2, boolean z3) {
        int i2;
        int i3;
        j();
        int z4 = z();
        int i4 = -1;
        if (z3) {
            i3 = z() - 1;
            i2 = -1;
        } else {
            i4 = z4;
            i3 = 0;
            i2 = 1;
        }
        int e2 = sVar.e();
        int c2 = this.f3851j.c();
        int d2 = this.f3851j.d();
        View view = null;
        View view2 = null;
        View view3 = null;
        while (i3 != i4) {
            View i5 = i(i3);
            int d3 = d(i5);
            int a2 = this.f3851j.a(i5);
            int b2 = this.f3851j.b(i5);
            if (d3 >= 0 && d3 < e2) {
                if (!((RecyclerView.LayoutParams) i5.getLayoutParams()).d()) {
                    boolean z5 = b2 <= c2 && a2 < c2;
                    boolean z6 = a2 >= d2 && b2 > d2;
                    if (!z5 && !z6) {
                        return i5;
                    }
                    if (z2) {
                        if (!z6) {
                            if (view != null) {
                            }
                            view = i5;
                        }
                    } else if (!z5) {
                        if (view != null) {
                        }
                        view = i5;
                    }
                    view2 = i5;
                } else if (view3 == null) {
                    view3 = i5;
                }
            }
            i3 += i2;
        }
        return view != null ? view : view2 != null ? view2 : view3;
    }

    /* access modifiers changed from: package-private */
    public View a(boolean z2, boolean z3) {
        int i2;
        int z4;
        if (this.f3852k) {
            i2 = z() - 1;
            z4 = -1;
        } else {
            i2 = 0;
            z4 = z();
        }
        return a(i2, z4, z2, z3);
    }

    public RecyclerView.LayoutParams a() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    public void a(int i2, int i3, RecyclerView.s sVar, RecyclerView.h.a aVar) {
        if (this.f3850i != 0) {
            i2 = i3;
        }
        if (z() != 0 && i2 != 0) {
            j();
            a(i2 > 0 ? 1 : -1, Math.abs(i2), true, sVar);
            a(sVar, this.f3842a, aVar);
        }
    }

    public void a(int i2, RecyclerView.h.a aVar) {
        int i3;
        boolean z2;
        SavedState savedState = this.f3855n;
        int i4 = -1;
        if (savedState == null || !savedState.a()) {
            b();
            z2 = this.f3852k;
            i3 = this.f3853l;
            if (i3 == -1) {
                i3 = z2 ? i2 - 1 : 0;
            }
        } else {
            z2 = this.f3855n.f3860c;
            i3 = this.f3855n.f3858a;
        }
        if (!z2) {
            i4 = 1;
        }
        for (int i5 = 0; i5 < this.f3849h && i3 >= 0 && i3 < i2; i5++) {
            aVar.b(i3, 0);
            i3 += i4;
        }
    }

    public void a(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.f3855n = savedState;
            if (this.f3853l != -1) {
                savedState.b();
            }
            s();
        }
    }

    public void a(View view, View view2, int i2, int i3) {
        int i4;
        a("Cannot drop a view during a scroll or layout calculation");
        j();
        b();
        int d2 = d(view);
        int d3 = d(view2);
        char c2 = d2 < d3 ? (char) 1 : 65535;
        if (this.f3852k) {
            if (c2 == 1) {
                b(d3, this.f3851j.d() - (this.f3851j.a(view2) + this.f3851j.e(view)));
                return;
            }
            i4 = this.f3851j.d() - this.f3851j.b(view2);
        } else if (c2 == 65535) {
            i4 = this.f3851j.a(view2);
        } else {
            b(d3, this.f3851j.b(view2) - this.f3851j.e(view));
            return;
        }
        b(d3, i4);
    }

    public void a(AccessibilityEvent accessibilityEvent) {
        super.a(accessibilityEvent);
        if (z() > 0) {
            accessibilityEvent.setFromIndex(o());
            accessibilityEvent.setToIndex(q());
        }
    }

    /* access modifiers changed from: package-private */
    public void a(RecyclerView.n nVar, RecyclerView.s sVar, a aVar, int i2) {
    }

    /* access modifiers changed from: package-private */
    public void a(RecyclerView.n nVar, RecyclerView.s sVar, c cVar, b bVar) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        View a2 = cVar.a(nVar);
        if (a2 == null) {
            bVar.f3867b = true;
            return;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) a2.getLayoutParams();
        if (cVar.f3881l == null) {
            if (this.f3852k == (cVar.f3875f == -1)) {
                b(a2);
            } else {
                b(a2, 0);
            }
        } else {
            if (this.f3852k == (cVar.f3875f == -1)) {
                a(a2);
            } else {
                a(a2, 0);
            }
        }
        a(a2, 0, 0);
        bVar.f3866a = this.f3851j.e(a2);
        if (this.f3850i == 1) {
            if (i()) {
                i6 = C() - G();
                i5 = i6 - this.f3851j.f(a2);
            } else {
                i5 = E();
                i6 = this.f3851j.f(a2) + i5;
            }
            if (cVar.f3875f == -1) {
                int i7 = cVar.f3871b;
                i4 = cVar.f3871b - bVar.f3866a;
                i3 = i6;
                i2 = i7;
            } else {
                int i8 = cVar.f3871b;
                i2 = cVar.f3871b + bVar.f3866a;
                i3 = i6;
                i4 = i8;
            }
        } else {
            int F = F();
            int f2 = this.f3851j.f(a2) + F;
            if (cVar.f3875f == -1) {
                i4 = F;
                i3 = cVar.f3871b;
                i2 = f2;
                i5 = cVar.f3871b - bVar.f3866a;
            } else {
                int i9 = cVar.f3871b;
                i3 = cVar.f3871b + bVar.f3866a;
                i4 = F;
                i2 = f2;
                i5 = i9;
            }
        }
        a(a2, i5, i4, i3, i2);
        if (layoutParams.d() || layoutParams.e()) {
            bVar.f3868c = true;
        }
        bVar.f3869d = a2.hasFocusable();
    }

    public void a(RecyclerView.s sVar) {
        super.a(sVar);
        this.f3855n = null;
        this.f3853l = -1;
        this.f3854m = Integer.MIN_VALUE;
        this.f3856o.a();
    }

    /* access modifiers changed from: package-private */
    public void a(RecyclerView.s sVar, c cVar, RecyclerView.h.a aVar) {
        int i2 = cVar.f3873d;
        if (i2 >= 0 && i2 < sVar.e()) {
            aVar.b(i2, Math.max(0, cVar.f3876g));
        }
    }

    /* access modifiers changed from: protected */
    public void a(RecyclerView.s sVar, int[] iArr) {
        int i2;
        int f2 = f(sVar);
        if (this.f3842a.f3875f == -1) {
            i2 = 0;
        } else {
            i2 = f2;
            f2 = 0;
        }
        iArr[0] = f2;
        iArr[1] = i2;
    }

    public void a(RecyclerView recyclerView, RecyclerView.n nVar) {
        super.a(recyclerView, nVar);
        if (this.f3847f) {
            c(nVar);
            nVar.a();
        }
    }

    public void a(RecyclerView recyclerView, RecyclerView.s sVar, int i2) {
        o oVar = new o(recyclerView.getContext());
        oVar.c(i2);
        a((RecyclerView.r) oVar);
    }

    public void a(String str) {
        if (this.f3855n == null) {
            super.a(str);
        }
    }

    public void a(boolean z2) {
        a((String) null);
        if (this.f3845d != z2) {
            this.f3845d = z2;
            s();
        }
    }

    public int b(int i2, RecyclerView.n nVar, RecyclerView.s sVar) {
        if (this.f3850i == 0) {
            return 0;
        }
        return c(i2, nVar, sVar);
    }

    public int b(RecyclerView.s sVar) {
        return k(sVar);
    }

    /* access modifiers changed from: package-private */
    public View b(boolean z2, boolean z3) {
        int z4;
        int i2;
        if (this.f3852k) {
            z4 = 0;
            i2 = z();
        } else {
            z4 = z() - 1;
            i2 = -1;
        }
        return a(z4, i2, z2, z3);
    }

    public void b(int i2) {
        if (i2 == 0 || i2 == 1) {
            a((String) null);
            if (i2 != this.f3850i || this.f3851j == null) {
                s a2 = s.a(this, i2);
                this.f3851j = a2;
                this.f3856o.f3861a = a2;
                this.f3850i = i2;
                s();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation:" + i2);
    }

    public void b(int i2, int i3) {
        this.f3853l = i2;
        this.f3854m = i3;
        SavedState savedState = this.f3855n;
        if (savedState != null) {
            savedState.b();
        }
        s();
    }

    public void b(boolean z2) {
        a((String) null);
        if (z2 != this.f3844c) {
            this.f3844c = z2;
            s();
        }
    }

    /* access modifiers changed from: package-private */
    public int c(int i2, RecyclerView.n nVar, RecyclerView.s sVar) {
        if (z() == 0 || i2 == 0) {
            return 0;
        }
        j();
        this.f3842a.f3870a = true;
        int i3 = i2 > 0 ? 1 : -1;
        int abs = Math.abs(i2);
        a(i3, abs, true, sVar);
        int a2 = this.f3842a.f3876g + a(nVar, this.f3842a, sVar, false);
        if (a2 < 0) {
            return 0;
        }
        if (abs > a2) {
            i2 = i3 * a2;
        }
        this.f3851j.a(-i2);
        this.f3842a.f3880k = i2;
        return i2;
    }

    public int c(RecyclerView.s sVar) {
        return k(sVar);
    }

    public View c(int i2) {
        int z2 = z();
        if (z2 == 0) {
            return null;
        }
        int d2 = i2 - d(i(0));
        if (d2 >= 0 && d2 < z2) {
            View i3 = i(d2);
            if (d(i3) == i2) {
                return i3;
            }
        }
        return super.c(i2);
    }

    /* access modifiers changed from: package-private */
    public View c(int i2, int i3) {
        int i4;
        int i5;
        j();
        if ((i3 > i2 ? 1 : i3 < i2 ? (char) 65535 : 0) == 0) {
            return i(i2);
        }
        if (this.f3851j.a(i(i2)) < this.f3851j.c()) {
            i5 = 16644;
            i4 = 16388;
        } else {
            i5 = 4161;
            i4 = 4097;
        }
        return (this.f3850i == 0 ? this.f3971r : this.f3972s).a(i2, i3, i5, i4);
    }

    public void c(RecyclerView.n nVar, RecyclerView.s sVar) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        View c2;
        int i8;
        int i9;
        int i10 = -1;
        if (!(this.f3855n == null && this.f3853l == -1) && sVar.e() == 0) {
            c(nVar);
            return;
        }
        SavedState savedState = this.f3855n;
        if (savedState != null && savedState.a()) {
            this.f3853l = this.f3855n.f3858a;
        }
        j();
        this.f3842a.f3870a = false;
        b();
        View I = I();
        if (!this.f3856o.f3865e || this.f3853l != -1 || this.f3855n != null) {
            this.f3856o.a();
            this.f3856o.f3864d = this.f3852k ^ this.f3845d;
            a(nVar, sVar, this.f3856o);
            this.f3856o.f3865e = true;
        } else if (I != null && (this.f3851j.a(I) >= this.f3851j.d() || this.f3851j.b(I) <= this.f3851j.c())) {
            this.f3856o.a(I, d(I));
        }
        c cVar = this.f3842a;
        cVar.f3875f = cVar.f3880k >= 0 ? 1 : -1;
        int[] iArr = this.f3857z;
        iArr[0] = 0;
        iArr[1] = 0;
        a(sVar, iArr);
        int max = Math.max(0, this.f3857z[0]) + this.f3851j.c();
        int max2 = Math.max(0, this.f3857z[1]) + this.f3851j.g();
        if (!(!sVar.a() || (i7 = this.f3853l) == -1 || this.f3854m == Integer.MIN_VALUE || (c2 = c(i7)) == null)) {
            if (this.f3852k) {
                i8 = this.f3851j.d() - this.f3851j.b(c2);
                i9 = this.f3854m;
            } else {
                i9 = this.f3851j.a(c2) - this.f3851j.c();
                i8 = this.f3854m;
            }
            int i11 = i8 - i9;
            if (i11 > 0) {
                max += i11;
            } else {
                max2 -= i11;
            }
        }
        if (!this.f3856o.f3864d ? !this.f3852k : this.f3852k) {
            i10 = 1;
        }
        a(nVar, sVar, this.f3856o, i10);
        a(nVar);
        this.f3842a.f3882m = m();
        this.f3842a.f3879j = sVar.a();
        this.f3842a.f3878i = 0;
        if (this.f3856o.f3864d) {
            b(this.f3856o);
            this.f3842a.f3877h = max;
            a(nVar, this.f3842a, sVar, false);
            i3 = this.f3842a.f3871b;
            int i12 = this.f3842a.f3873d;
            if (this.f3842a.f3872c > 0) {
                max2 += this.f3842a.f3872c;
            }
            a(this.f3856o);
            this.f3842a.f3877h = max2;
            this.f3842a.f3873d += this.f3842a.f3874e;
            a(nVar, this.f3842a, sVar, false);
            i2 = this.f3842a.f3871b;
            if (this.f3842a.f3872c > 0) {
                int i13 = this.f3842a.f3872c;
                h(i12, i3);
                this.f3842a.f3877h = i13;
                a(nVar, this.f3842a, sVar, false);
                i3 = this.f3842a.f3871b;
            }
        } else {
            a(this.f3856o);
            this.f3842a.f3877h = max2;
            a(nVar, this.f3842a, sVar, false);
            i2 = this.f3842a.f3871b;
            int i14 = this.f3842a.f3873d;
            if (this.f3842a.f3872c > 0) {
                max += this.f3842a.f3872c;
            }
            b(this.f3856o);
            this.f3842a.f3877h = max;
            this.f3842a.f3873d += this.f3842a.f3874e;
            a(nVar, this.f3842a, sVar, false);
            i3 = this.f3842a.f3871b;
            if (this.f3842a.f3872c > 0) {
                int i15 = this.f3842a.f3872c;
                a(i14, i2);
                this.f3842a.f3877h = i15;
                a(nVar, this.f3842a, sVar, false);
                i2 = this.f3842a.f3871b;
            }
        }
        if (z() > 0) {
            if (this.f3852k ^ this.f3845d) {
                int a2 = a(i2, nVar, sVar, true);
                i6 = i3 + a2;
                i4 = i2 + a2;
                i5 = b(i6, nVar, sVar, false);
            } else {
                int b2 = b(i3, nVar, sVar, true);
                i6 = i3 + b2;
                i4 = i2 + b2;
                i5 = a(i4, nVar, sVar, false);
            }
            i3 = i6 + i5;
            i2 = i4 + i5;
        }
        b(nVar, sVar, i3, i2);
        if (!sVar.a()) {
            this.f3851j.a();
        } else {
            this.f3856o.a();
        }
        this.f3843b = this.f3845d;
    }

    public void c(boolean z2) {
        this.f3846e = z2;
    }

    public boolean c() {
        return this.f3855n == null && this.f3843b == this.f3845d;
    }

    public int d(RecyclerView.s sVar) {
        return i(sVar);
    }

    public PointF d(int i2) {
        if (z() == 0) {
            return null;
        }
        boolean z2 = false;
        int i3 = 1;
        if (i2 < d(i(0))) {
            z2 = true;
        }
        if (z2 != this.f3852k) {
            i3 = -1;
        }
        return this.f3850i == 0 ? new PointF((float) i3, 0.0f) : new PointF(0.0f, (float) i3);
    }

    public boolean d() {
        return true;
    }

    public int e(RecyclerView.s sVar) {
        return i(sVar);
    }

    public Parcelable e() {
        if (this.f3855n != null) {
            return new SavedState(this.f3855n);
        }
        SavedState savedState = new SavedState();
        if (z() > 0) {
            j();
            boolean z2 = this.f3843b ^ this.f3852k;
            savedState.f3860c = z2;
            if (z2) {
                View Q = Q();
                savedState.f3859b = this.f3851j.d() - this.f3851j.b(Q);
                savedState.f3858a = d(Q);
            } else {
                View P = P();
                savedState.f3858a = d(P);
                savedState.f3859b = this.f3851j.a(P) - this.f3851j.c();
            }
        } else {
            savedState.b();
        }
        return savedState;
    }

    public void e(int i2) {
        this.f3853l = i2;
        this.f3854m = Integer.MIN_VALUE;
        SavedState savedState = this.f3855n;
        if (savedState != null) {
            savedState.b();
        }
        s();
    }

    /* access modifiers changed from: package-private */
    public int f(int i2) {
        return i2 != 1 ? i2 != 2 ? i2 != 17 ? i2 != 33 ? i2 != 66 ? (i2 == 130 && this.f3850i == 1) ? 1 : Integer.MIN_VALUE : this.f3850i == 0 ? 1 : Integer.MIN_VALUE : this.f3850i == 1 ? -1 : Integer.MIN_VALUE : this.f3850i == 0 ? -1 : Integer.MIN_VALUE : (this.f3850i != 1 && i()) ? -1 : 1 : (this.f3850i != 1 && i()) ? 1 : -1;
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public int f(RecyclerView.s sVar) {
        if (sVar.d()) {
            return this.f3851j.f();
        }
        return 0;
    }

    public boolean f() {
        return this.f3850i == 0;
    }

    public int g(RecyclerView.s sVar) {
        return j(sVar);
    }

    public boolean g() {
        return this.f3850i == 1;
    }

    public int h() {
        return this.f3850i;
    }

    public int h(RecyclerView.s sVar) {
        return j(sVar);
    }

    /* access modifiers changed from: protected */
    public boolean i() {
        return x() == 1;
    }

    /* access modifiers changed from: package-private */
    public void j() {
        if (this.f3842a == null) {
            this.f3842a = k();
        }
    }

    /* access modifiers changed from: package-private */
    public c k() {
        return new c();
    }

    public boolean l() {
        return this.f3846e;
    }

    /* access modifiers changed from: package-private */
    public boolean m() {
        return this.f3851j.h() == 0 && this.f3851j.e() == 0;
    }

    /* access modifiers changed from: package-private */
    public boolean n() {
        return (B() == 1073741824 || A() == 1073741824 || !O()) ? false : true;
    }

    public int o() {
        View a2 = a(0, z(), false, true);
        if (a2 == null) {
            return -1;
        }
        return d(a2);
    }

    public int p() {
        View a2 = a(0, z(), true, false);
        if (a2 == null) {
            return -1;
        }
        return d(a2);
    }

    public int q() {
        View a2 = a(z() - 1, -1, false, true);
        if (a2 == null) {
            return -1;
        }
        return d(a2);
    }

    public int r() {
        View a2 = a(z() - 1, -1, true, false);
        if (a2 == null) {
            return -1;
        }
        return d(a2);
    }
}
