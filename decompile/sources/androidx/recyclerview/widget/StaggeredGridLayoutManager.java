package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class StaggeredGridLayoutManager extends RecyclerView.h implements RecyclerView.r.b {
    private SavedState A;
    private int B;
    private final Rect C = new Rect();
    private final a D = new a();
    private boolean E = false;
    private boolean F = true;
    private int[] G;
    private final Runnable H = new Runnable() {
        public void run() {
            StaggeredGridLayoutManager.this.b();
        }
    };

    /* renamed from: a  reason: collision with root package name */
    b[] f4040a;

    /* renamed from: b  reason: collision with root package name */
    s f4041b;

    /* renamed from: c  reason: collision with root package name */
    s f4042c;

    /* renamed from: d  reason: collision with root package name */
    boolean f4043d = false;

    /* renamed from: e  reason: collision with root package name */
    boolean f4044e = false;

    /* renamed from: f  reason: collision with root package name */
    int f4045f = -1;

    /* renamed from: g  reason: collision with root package name */
    int f4046g = Integer.MIN_VALUE;

    /* renamed from: h  reason: collision with root package name */
    LazySpanLookup f4047h = new LazySpanLookup();

    /* renamed from: i  reason: collision with root package name */
    private int f4048i = -1;

    /* renamed from: j  reason: collision with root package name */
    private int f4049j;

    /* renamed from: k  reason: collision with root package name */
    private int f4050k;

    /* renamed from: l  reason: collision with root package name */
    private final n f4051l;

    /* renamed from: m  reason: collision with root package name */
    private BitSet f4052m;

    /* renamed from: n  reason: collision with root package name */
    private int f4053n = 2;

    /* renamed from: o  reason: collision with root package name */
    private boolean f4054o;

    /* renamed from: z  reason: collision with root package name */
    private boolean f4055z;

    public static class LayoutParams extends RecyclerView.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        b f4057a;

        /* renamed from: b  reason: collision with root package name */
        boolean f4058b;

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public void a(boolean z2) {
            this.f4058b = z2;
        }

        public boolean a() {
            return this.f4058b;
        }
    }

    static class LazySpanLookup {

        /* renamed from: a  reason: collision with root package name */
        int[] f4059a;

        /* renamed from: b  reason: collision with root package name */
        List<FullSpanItem> f4060b;

        static class FullSpanItem implements Parcelable {
            public static final Parcelable.Creator<FullSpanItem> CREATOR = new Parcelable.Creator<FullSpanItem>() {
                /* renamed from: a */
                public FullSpanItem createFromParcel(Parcel parcel) {
                    return new FullSpanItem(parcel);
                }

                /* renamed from: a */
                public FullSpanItem[] newArray(int i2) {
                    return new FullSpanItem[i2];
                }
            };

            /* renamed from: a  reason: collision with root package name */
            int f4061a;

            /* renamed from: b  reason: collision with root package name */
            int f4062b;

            /* renamed from: c  reason: collision with root package name */
            int[] f4063c;

            /* renamed from: d  reason: collision with root package name */
            boolean f4064d;

            FullSpanItem() {
            }

            FullSpanItem(Parcel parcel) {
                this.f4061a = parcel.readInt();
                this.f4062b = parcel.readInt();
                this.f4064d = parcel.readInt() != 1 ? false : true;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    int[] iArr = new int[readInt];
                    this.f4063c = iArr;
                    parcel.readIntArray(iArr);
                }
            }

            /* access modifiers changed from: package-private */
            public int a(int i2) {
                int[] iArr = this.f4063c;
                if (iArr == null) {
                    return 0;
                }
                return iArr[i2];
            }

            public int describeContents() {
                return 0;
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.f4061a + ", mGapDir=" + this.f4062b + ", mHasUnwantedGapAfter=" + this.f4064d + ", mGapPerSpan=" + Arrays.toString(this.f4063c) + '}';
            }

            public void writeToParcel(Parcel parcel, int i2) {
                parcel.writeInt(this.f4061a);
                parcel.writeInt(this.f4062b);
                parcel.writeInt(this.f4064d ? 1 : 0);
                int[] iArr = this.f4063c;
                if (iArr == null || iArr.length <= 0) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(iArr.length);
                parcel.writeIntArray(this.f4063c);
            }
        }

        LazySpanLookup() {
        }

        private void c(int i2, int i3) {
            List<FullSpanItem> list = this.f4060b;
            if (list != null) {
                int i4 = i2 + i3;
                for (int size = list.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = this.f4060b.get(size);
                    if (fullSpanItem.f4061a >= i2) {
                        if (fullSpanItem.f4061a < i4) {
                            this.f4060b.remove(size);
                        } else {
                            fullSpanItem.f4061a -= i3;
                        }
                    }
                }
            }
        }

        private void d(int i2, int i3) {
            List<FullSpanItem> list = this.f4060b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = this.f4060b.get(size);
                    if (fullSpanItem.f4061a >= i2) {
                        fullSpanItem.f4061a += i3;
                    }
                }
            }
        }

        private int g(int i2) {
            if (this.f4060b == null) {
                return -1;
            }
            FullSpanItem f2 = f(i2);
            if (f2 != null) {
                this.f4060b.remove(f2);
            }
            int size = this.f4060b.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    i3 = -1;
                    break;
                } else if (this.f4060b.get(i3).f4061a >= i2) {
                    break;
                } else {
                    i3++;
                }
            }
            if (i3 == -1) {
                return -1;
            }
            this.f4060b.remove(i3);
            return this.f4060b.get(i3).f4061a;
        }

        /* access modifiers changed from: package-private */
        public int a(int i2) {
            List<FullSpanItem> list = this.f4060b;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (this.f4060b.get(size).f4061a >= i2) {
                        this.f4060b.remove(size);
                    }
                }
            }
            return b(i2);
        }

        public FullSpanItem a(int i2, int i3, int i4, boolean z2) {
            List<FullSpanItem> list = this.f4060b;
            if (list == null) {
                return null;
            }
            int size = list.size();
            for (int i5 = 0; i5 < size; i5++) {
                FullSpanItem fullSpanItem = this.f4060b.get(i5);
                if (fullSpanItem.f4061a >= i3) {
                    return null;
                }
                if (fullSpanItem.f4061a >= i2 && (i4 == 0 || fullSpanItem.f4062b == i4 || (z2 && fullSpanItem.f4064d))) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            int[] iArr = this.f4059a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f4060b = null;
        }

        /* access modifiers changed from: package-private */
        public void a(int i2, int i3) {
            int[] iArr = this.f4059a;
            if (iArr != null && i2 < iArr.length) {
                int i4 = i2 + i3;
                e(i4);
                int[] iArr2 = this.f4059a;
                System.arraycopy(iArr2, i4, iArr2, i2, (iArr2.length - i2) - i3);
                int[] iArr3 = this.f4059a;
                Arrays.fill(iArr3, iArr3.length - i3, iArr3.length, -1);
                c(i2, i3);
            }
        }

        /* access modifiers changed from: package-private */
        public void a(int i2, b bVar) {
            e(i2);
            this.f4059a[i2] = bVar.f4086e;
        }

        public void a(FullSpanItem fullSpanItem) {
            if (this.f4060b == null) {
                this.f4060b = new ArrayList();
            }
            int size = this.f4060b.size();
            for (int i2 = 0; i2 < size; i2++) {
                FullSpanItem fullSpanItem2 = this.f4060b.get(i2);
                if (fullSpanItem2.f4061a == fullSpanItem.f4061a) {
                    this.f4060b.remove(i2);
                }
                if (fullSpanItem2.f4061a >= fullSpanItem.f4061a) {
                    this.f4060b.add(i2, fullSpanItem);
                    return;
                }
            }
            this.f4060b.add(fullSpanItem);
        }

        /* access modifiers changed from: package-private */
        public int b(int i2) {
            int[] iArr = this.f4059a;
            if (iArr == null || i2 >= iArr.length) {
                return -1;
            }
            int g2 = g(i2);
            if (g2 == -1) {
                int[] iArr2 = this.f4059a;
                Arrays.fill(iArr2, i2, iArr2.length, -1);
                return this.f4059a.length;
            }
            int min = Math.min(g2 + 1, this.f4059a.length);
            Arrays.fill(this.f4059a, i2, min, -1);
            return min;
        }

        /* access modifiers changed from: package-private */
        public void b(int i2, int i3) {
            int[] iArr = this.f4059a;
            if (iArr != null && i2 < iArr.length) {
                int i4 = i2 + i3;
                e(i4);
                int[] iArr2 = this.f4059a;
                System.arraycopy(iArr2, i2, iArr2, i4, (iArr2.length - i2) - i3);
                Arrays.fill(this.f4059a, i2, i4, -1);
                d(i2, i3);
            }
        }

        /* access modifiers changed from: package-private */
        public int c(int i2) {
            int[] iArr = this.f4059a;
            if (iArr == null || i2 >= iArr.length) {
                return -1;
            }
            return iArr[i2];
        }

        /* access modifiers changed from: package-private */
        public int d(int i2) {
            int length = this.f4059a.length;
            while (length <= i2) {
                length *= 2;
            }
            return length;
        }

        /* access modifiers changed from: package-private */
        public void e(int i2) {
            int[] iArr = this.f4059a;
            if (iArr == null) {
                int[] iArr2 = new int[(Math.max(i2, 10) + 1)];
                this.f4059a = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i2 >= iArr.length) {
                int[] iArr3 = new int[d(i2)];
                this.f4059a = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                int[] iArr4 = this.f4059a;
                Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
            }
        }

        public FullSpanItem f(int i2) {
            List<FullSpanItem> list = this.f4060b;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.f4060b.get(size);
                if (fullSpanItem.f4061a == i2) {
                    return fullSpanItem;
                }
            }
            return null;
        }
    }

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
        int f4065a;

        /* renamed from: b  reason: collision with root package name */
        int f4066b;

        /* renamed from: c  reason: collision with root package name */
        int f4067c;

        /* renamed from: d  reason: collision with root package name */
        int[] f4068d;

        /* renamed from: e  reason: collision with root package name */
        int f4069e;

        /* renamed from: f  reason: collision with root package name */
        int[] f4070f;

        /* renamed from: g  reason: collision with root package name */
        List<LazySpanLookup.FullSpanItem> f4071g;

        /* renamed from: h  reason: collision with root package name */
        boolean f4072h;

        /* renamed from: i  reason: collision with root package name */
        boolean f4073i;

        /* renamed from: j  reason: collision with root package name */
        boolean f4074j;

        public SavedState() {
        }

        SavedState(Parcel parcel) {
            this.f4065a = parcel.readInt();
            this.f4066b = parcel.readInt();
            int readInt = parcel.readInt();
            this.f4067c = readInt;
            if (readInt > 0) {
                int[] iArr = new int[readInt];
                this.f4068d = iArr;
                parcel.readIntArray(iArr);
            }
            int readInt2 = parcel.readInt();
            this.f4069e = readInt2;
            if (readInt2 > 0) {
                int[] iArr2 = new int[readInt2];
                this.f4070f = iArr2;
                parcel.readIntArray(iArr2);
            }
            boolean z2 = false;
            this.f4072h = parcel.readInt() == 1;
            this.f4073i = parcel.readInt() == 1;
            this.f4074j = parcel.readInt() == 1 ? true : z2;
            this.f4071g = parcel.readArrayList(LazySpanLookup.FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.f4067c = savedState.f4067c;
            this.f4065a = savedState.f4065a;
            this.f4066b = savedState.f4066b;
            this.f4068d = savedState.f4068d;
            this.f4069e = savedState.f4069e;
            this.f4070f = savedState.f4070f;
            this.f4072h = savedState.f4072h;
            this.f4073i = savedState.f4073i;
            this.f4074j = savedState.f4074j;
            this.f4071g = savedState.f4071g;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f4068d = null;
            this.f4067c = 0;
            this.f4069e = 0;
            this.f4070f = null;
            this.f4071g = null;
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.f4068d = null;
            this.f4067c = 0;
            this.f4065a = -1;
            this.f4066b = -1;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f4065a);
            parcel.writeInt(this.f4066b);
            parcel.writeInt(this.f4067c);
            if (this.f4067c > 0) {
                parcel.writeIntArray(this.f4068d);
            }
            parcel.writeInt(this.f4069e);
            if (this.f4069e > 0) {
                parcel.writeIntArray(this.f4070f);
            }
            parcel.writeInt(this.f4072h ? 1 : 0);
            parcel.writeInt(this.f4073i ? 1 : 0);
            parcel.writeInt(this.f4074j ? 1 : 0);
            parcel.writeList(this.f4071g);
        }
    }

    class a {

        /* renamed from: a  reason: collision with root package name */
        int f4075a;

        /* renamed from: b  reason: collision with root package name */
        int f4076b;

        /* renamed from: c  reason: collision with root package name */
        boolean f4077c;

        /* renamed from: d  reason: collision with root package name */
        boolean f4078d;

        /* renamed from: e  reason: collision with root package name */
        boolean f4079e;

        /* renamed from: f  reason: collision with root package name */
        int[] f4080f;

        a() {
            a();
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f4075a = -1;
            this.f4076b = Integer.MIN_VALUE;
            this.f4077c = false;
            this.f4078d = false;
            this.f4079e = false;
            int[] iArr = this.f4080f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }

        /* access modifiers changed from: package-private */
        public void a(int i2) {
            this.f4076b = this.f4077c ? StaggeredGridLayoutManager.this.f4041b.d() - i2 : StaggeredGridLayoutManager.this.f4041b.c() + i2;
        }

        /* access modifiers changed from: package-private */
        public void a(b[] bVarArr) {
            int length = bVarArr.length;
            int[] iArr = this.f4080f;
            if (iArr == null || iArr.length < length) {
                this.f4080f = new int[StaggeredGridLayoutManager.this.f4040a.length];
            }
            for (int i2 = 0; i2 < length; i2++) {
                this.f4080f[i2] = bVarArr[i2].a(Integer.MIN_VALUE);
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.f4076b = this.f4077c ? StaggeredGridLayoutManager.this.f4041b.d() : StaggeredGridLayoutManager.this.f4041b.c();
        }
    }

    class b {

        /* renamed from: a  reason: collision with root package name */
        ArrayList<View> f4082a = new ArrayList<>();

        /* renamed from: b  reason: collision with root package name */
        int f4083b = Integer.MIN_VALUE;

        /* renamed from: c  reason: collision with root package name */
        int f4084c = Integer.MIN_VALUE;

        /* renamed from: d  reason: collision with root package name */
        int f4085d = 0;

        /* renamed from: e  reason: collision with root package name */
        final int f4086e;

        b(int i2) {
            this.f4086e = i2;
        }

        /* access modifiers changed from: package-private */
        public int a(int i2) {
            int i3 = this.f4083b;
            if (i3 != Integer.MIN_VALUE) {
                return i3;
            }
            if (this.f4082a.size() == 0) {
                return i2;
            }
            a();
            return this.f4083b;
        }

        /* access modifiers changed from: package-private */
        public int a(int i2, int i3, boolean z2) {
            return a(i2, i3, z2, true, false);
        }

        /* access modifiers changed from: package-private */
        public int a(int i2, int i3, boolean z2, boolean z3, boolean z4) {
            int c2 = StaggeredGridLayoutManager.this.f4041b.c();
            int d2 = StaggeredGridLayoutManager.this.f4041b.d();
            int i4 = i3 > i2 ? 1 : -1;
            while (i2 != i3) {
                View view = this.f4082a.get(i2);
                int a2 = StaggeredGridLayoutManager.this.f4041b.a(view);
                int b2 = StaggeredGridLayoutManager.this.f4041b.b(view);
                boolean z5 = false;
                boolean z6 = !z4 ? a2 < d2 : a2 <= d2;
                if (!z4 ? b2 > c2 : b2 >= c2) {
                    z5 = true;
                }
                if (z6 && z5) {
                    if (!z2 || !z3) {
                        if (!z3 && a2 >= c2 && b2 <= d2) {
                        }
                    } else if (a2 >= c2 && b2 <= d2) {
                    }
                    return StaggeredGridLayoutManager.this.d(view);
                }
                i2 += i4;
            }
            return -1;
        }

        public View a(int i2, int i3) {
            View view = null;
            if (i3 != -1) {
                int size = this.f4082a.size() - 1;
                while (size >= 0) {
                    View view2 = this.f4082a.get(size);
                    if ((StaggeredGridLayoutManager.this.f4043d && StaggeredGridLayoutManager.this.d(view2) >= i2) || ((!StaggeredGridLayoutManager.this.f4043d && StaggeredGridLayoutManager.this.d(view2) <= i2) || !view2.hasFocusable())) {
                        break;
                    }
                    size--;
                    view = view2;
                }
            } else {
                int size2 = this.f4082a.size();
                int i4 = 0;
                while (i4 < size2) {
                    View view3 = this.f4082a.get(i4);
                    if ((StaggeredGridLayoutManager.this.f4043d && StaggeredGridLayoutManager.this.d(view3) <= i2) || ((!StaggeredGridLayoutManager.this.f4043d && StaggeredGridLayoutManager.this.d(view3) >= i2) || !view3.hasFocusable())) {
                        break;
                    }
                    i4++;
                    view = view3;
                }
            }
            return view;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            LazySpanLookup.FullSpanItem f2;
            View view = this.f4082a.get(0);
            LayoutParams c2 = c(view);
            this.f4083b = StaggeredGridLayoutManager.this.f4041b.a(view);
            if (c2.f4058b && (f2 = StaggeredGridLayoutManager.this.f4047h.f(c2.f())) != null && f2.f4062b == -1) {
                this.f4083b -= f2.a(this.f4086e);
            }
        }

        /* access modifiers changed from: package-private */
        public void a(View view) {
            LayoutParams c2 = c(view);
            c2.f4057a = this;
            this.f4082a.add(0, view);
            this.f4083b = Integer.MIN_VALUE;
            if (this.f4082a.size() == 1) {
                this.f4084c = Integer.MIN_VALUE;
            }
            if (c2.d() || c2.e()) {
                this.f4085d += StaggeredGridLayoutManager.this.f4041b.e(view);
            }
        }

        /* access modifiers changed from: package-private */
        public void a(boolean z2, int i2) {
            int b2 = z2 ? b(Integer.MIN_VALUE) : a(Integer.MIN_VALUE);
            e();
            if (b2 != Integer.MIN_VALUE) {
                if (z2 && b2 < StaggeredGridLayoutManager.this.f4041b.d()) {
                    return;
                }
                if (z2 || b2 <= StaggeredGridLayoutManager.this.f4041b.c()) {
                    if (i2 != Integer.MIN_VALUE) {
                        b2 += i2;
                    }
                    this.f4084c = b2;
                    this.f4083b = b2;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public int b() {
            int i2 = this.f4083b;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            a();
            return this.f4083b;
        }

        /* access modifiers changed from: package-private */
        public int b(int i2) {
            int i3 = this.f4084c;
            if (i3 != Integer.MIN_VALUE) {
                return i3;
            }
            if (this.f4082a.size() == 0) {
                return i2;
            }
            c();
            return this.f4084c;
        }

        /* access modifiers changed from: package-private */
        public int b(int i2, int i3, boolean z2) {
            return a(i2, i3, false, false, z2);
        }

        /* access modifiers changed from: package-private */
        public void b(View view) {
            LayoutParams c2 = c(view);
            c2.f4057a = this;
            this.f4082a.add(view);
            this.f4084c = Integer.MIN_VALUE;
            if (this.f4082a.size() == 1) {
                this.f4083b = Integer.MIN_VALUE;
            }
            if (c2.d() || c2.e()) {
                this.f4085d += StaggeredGridLayoutManager.this.f4041b.e(view);
            }
        }

        /* access modifiers changed from: package-private */
        public LayoutParams c(View view) {
            return (LayoutParams) view.getLayoutParams();
        }

        /* access modifiers changed from: package-private */
        public void c() {
            LazySpanLookup.FullSpanItem f2;
            ArrayList<View> arrayList = this.f4082a;
            View view = arrayList.get(arrayList.size() - 1);
            LayoutParams c2 = c(view);
            this.f4084c = StaggeredGridLayoutManager.this.f4041b.b(view);
            if (c2.f4058b && (f2 = StaggeredGridLayoutManager.this.f4047h.f(c2.f())) != null && f2.f4062b == 1) {
                this.f4084c += f2.a(this.f4086e);
            }
        }

        /* access modifiers changed from: package-private */
        public void c(int i2) {
            this.f4083b = i2;
            this.f4084c = i2;
        }

        /* access modifiers changed from: package-private */
        public int d() {
            int i2 = this.f4084c;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            c();
            return this.f4084c;
        }

        /* access modifiers changed from: package-private */
        public void d(int i2) {
            int i3 = this.f4083b;
            if (i3 != Integer.MIN_VALUE) {
                this.f4083b = i3 + i2;
            }
            int i4 = this.f4084c;
            if (i4 != Integer.MIN_VALUE) {
                this.f4084c = i4 + i2;
            }
        }

        /* access modifiers changed from: package-private */
        public void e() {
            this.f4082a.clear();
            f();
            this.f4085d = 0;
        }

        /* access modifiers changed from: package-private */
        public void f() {
            this.f4083b = Integer.MIN_VALUE;
            this.f4084c = Integer.MIN_VALUE;
        }

        /* access modifiers changed from: package-private */
        public void g() {
            int size = this.f4082a.size();
            View remove = this.f4082a.remove(size - 1);
            LayoutParams c2 = c(remove);
            c2.f4057a = null;
            if (c2.d() || c2.e()) {
                this.f4085d -= StaggeredGridLayoutManager.this.f4041b.e(remove);
            }
            if (size == 1) {
                this.f4083b = Integer.MIN_VALUE;
            }
            this.f4084c = Integer.MIN_VALUE;
        }

        /* access modifiers changed from: package-private */
        public void h() {
            View remove = this.f4082a.remove(0);
            LayoutParams c2 = c(remove);
            c2.f4057a = null;
            if (this.f4082a.size() == 0) {
                this.f4084c = Integer.MIN_VALUE;
            }
            if (c2.d() || c2.e()) {
                this.f4085d -= StaggeredGridLayoutManager.this.f4041b.e(remove);
            }
            this.f4083b = Integer.MIN_VALUE;
        }

        public int i() {
            return this.f4085d;
        }

        public int j() {
            int i2;
            int i3;
            if (StaggeredGridLayoutManager.this.f4043d) {
                i3 = this.f4082a.size() - 1;
                i2 = -1;
            } else {
                i3 = 0;
                i2 = this.f4082a.size();
            }
            return b(i3, i2, true);
        }

        public int k() {
            int i2;
            int i3;
            if (StaggeredGridLayoutManager.this.f4043d) {
                i3 = 0;
                i2 = this.f4082a.size();
            } else {
                i3 = this.f4082a.size() - 1;
                i2 = -1;
            }
            return b(i3, i2, true);
        }

        public int l() {
            int i2;
            int i3;
            if (StaggeredGridLayoutManager.this.f4043d) {
                i3 = 0;
                i2 = this.f4082a.size();
            } else {
                i3 = this.f4082a.size() - 1;
                i2 = -1;
            }
            return a(i3, i2, true);
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        RecyclerView.h.b a2 = a(context, attributeSet, i2, i3);
        b(a2.f3981a);
        a(a2.f3982b);
        a(a2.f3983c);
        this.f4051l = new n();
        r();
    }

    private void P() {
        this.f4044e = (this.f4049j == 1 || !k()) ? this.f4043d : !this.f4043d;
    }

    private void Q() {
        int i2;
        if (this.f4042c.h() != 1073741824) {
            float f2 = 0.0f;
            int z2 = z();
            for (int i3 = 0; i3 < z2; i3++) {
                View i4 = i(i3);
                float e2 = (float) this.f4042c.e(i4);
                if (e2 >= f2) {
                    if (((LayoutParams) i4.getLayoutParams()).a()) {
                        e2 = (e2 * 1.0f) / ((float) this.f4048i);
                    }
                    f2 = Math.max(f2, e2);
                }
            }
            int i5 = this.f4050k;
            int round = Math.round(f2 * ((float) this.f4048i));
            if (this.f4042c.h() == Integer.MIN_VALUE) {
                round = Math.min(round, this.f4042c.f());
            }
            f(round);
            if (this.f4050k != i5) {
                for (int i6 = 0; i6 < z2; i6++) {
                    View i7 = i(i6);
                    LayoutParams layoutParams = (LayoutParams) i7.getLayoutParams();
                    if (!layoutParams.f4058b) {
                        if (!k() || this.f4049j != 1) {
                            int i8 = this.f4049j;
                            i2 = (layoutParams.f4057a.f4086e * this.f4050k) - (layoutParams.f4057a.f4086e * i5);
                            if (i8 != 1) {
                                i7.offsetTopAndBottom(i2);
                            }
                        } else {
                            i2 = ((-((this.f4048i - 1) - layoutParams.f4057a.f4086e)) * this.f4050k) - ((-((this.f4048i - 1) - layoutParams.f4057a.f4086e)) * i5);
                        }
                        i7.offsetLeftAndRight(i2);
                    }
                }
            }
        }
    }

    /* JADX WARNING: type inference failed for: r9v0 */
    /* JADX WARNING: type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARNING: type inference failed for: r9v5 */
    private int a(RecyclerView.n nVar, n nVar2, RecyclerView.s sVar) {
        int i2;
        b bVar;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        View view;
        StaggeredGridLayoutManager staggeredGridLayoutManager;
        RecyclerView.n nVar3 = nVar;
        n nVar4 = nVar2;
        ? r9 = 0;
        this.f4052m.set(0, this.f4048i, true);
        if (this.f4051l.f4301i) {
            i2 = nVar4.f4297e == 1 ? SubsamplingScaleImageView.TILE_SIZE_AUTO : Integer.MIN_VALUE;
        } else {
            i2 = nVar4.f4297e == 1 ? nVar4.f4299g + nVar4.f4294b : nVar4.f4298f - nVar4.f4294b;
        }
        a(nVar4.f4297e, i2);
        int d2 = this.f4044e ? this.f4041b.d() : this.f4041b.c();
        boolean z2 = false;
        while (nVar2.a(sVar) && (this.f4051l.f4301i || !this.f4052m.isEmpty())) {
            View a2 = nVar4.a(nVar3);
            LayoutParams layoutParams = (LayoutParams) a2.getLayoutParams();
            int f2 = layoutParams.f();
            int c2 = this.f4047h.c(f2);
            boolean z3 = c2 == -1;
            if (z3) {
                bVar = layoutParams.f4058b ? this.f4040a[r9] : a(nVar4);
                this.f4047h.a(f2, bVar);
            } else {
                bVar = this.f4040a[c2];
            }
            b bVar2 = bVar;
            layoutParams.f4057a = bVar2;
            if (nVar4.f4297e == 1) {
                b(a2);
            } else {
                b(a2, (int) r9);
            }
            a(a2, layoutParams, (boolean) r9);
            if (nVar4.f4297e == 1) {
                int r2 = layoutParams.f4058b ? r(d2) : bVar2.b(d2);
                int e2 = this.f4041b.e(a2) + r2;
                if (z3 && layoutParams.f4058b) {
                    LazySpanLookup.FullSpanItem n2 = n(r2);
                    n2.f4062b = -1;
                    n2.f4061a = f2;
                    this.f4047h.a(n2);
                }
                i3 = e2;
                i4 = r2;
            } else {
                int q2 = layoutParams.f4058b ? q(d2) : bVar2.a(d2);
                i4 = q2 - this.f4041b.e(a2);
                if (z3 && layoutParams.f4058b) {
                    LazySpanLookup.FullSpanItem o2 = o(q2);
                    o2.f4062b = 1;
                    o2.f4061a = f2;
                    this.f4047h.a(o2);
                }
                i3 = q2;
            }
            if (layoutParams.f4058b && nVar4.f4296d == -1) {
                if (!z3) {
                    if (!(nVar4.f4297e == 1 ? m() : o())) {
                        LazySpanLookup.FullSpanItem f3 = this.f4047h.f(f2);
                        if (f3 != null) {
                            f3.f4064d = true;
                        }
                    }
                }
                this.E = true;
            }
            a(a2, layoutParams, nVar4);
            if (!k() || this.f4049j != 1) {
                int c3 = layoutParams.f4058b ? this.f4042c.c() : (bVar2.f4086e * this.f4050k) + this.f4042c.c();
                i6 = c3;
                i5 = this.f4042c.e(a2) + c3;
            } else {
                int d3 = layoutParams.f4058b ? this.f4042c.d() : this.f4042c.d() - (((this.f4048i - 1) - bVar2.f4086e) * this.f4050k);
                i5 = d3;
                i6 = d3 - this.f4042c.e(a2);
            }
            if (this.f4049j == 1) {
                staggeredGridLayoutManager = this;
                view = a2;
                i8 = i6;
                i6 = i4;
                i7 = i5;
            } else {
                staggeredGridLayoutManager = this;
                view = a2;
                i8 = i4;
                i7 = i3;
                i3 = i5;
            }
            staggeredGridLayoutManager.a(view, i8, i6, i7, i3);
            if (layoutParams.f4058b) {
                a(this.f4051l.f4297e, i2);
            } else {
                a(bVar2, this.f4051l.f4297e, i2);
            }
            a(nVar3, this.f4051l);
            if (this.f4051l.f4300h && a2.hasFocusable()) {
                if (layoutParams.f4058b) {
                    this.f4052m.clear();
                } else {
                    this.f4052m.set(bVar2.f4086e, false);
                    z2 = true;
                    r9 = 0;
                }
            }
            z2 = true;
            r9 = 0;
        }
        if (!z2) {
            a(nVar3, this.f4051l);
        }
        int c4 = this.f4051l.f4297e == -1 ? this.f4041b.c() - q(this.f4041b.c()) : r(this.f4041b.d()) - this.f4041b.d();
        if (c4 > 0) {
            return Math.min(nVar4.f4294b, c4);
        }
        return 0;
    }

    private b a(n nVar) {
        int i2;
        int i3;
        int i4 = -1;
        if (t(nVar.f4297e)) {
            i3 = this.f4048i - 1;
            i2 = -1;
        } else {
            i3 = 0;
            i4 = this.f4048i;
            i2 = 1;
        }
        b bVar = null;
        if (nVar.f4297e == 1) {
            int i5 = SubsamplingScaleImageView.TILE_SIZE_AUTO;
            int c2 = this.f4041b.c();
            while (i3 != i4) {
                b bVar2 = this.f4040a[i3];
                int b2 = bVar2.b(c2);
                if (b2 < i5) {
                    bVar = bVar2;
                    i5 = b2;
                }
                i3 += i2;
            }
            return bVar;
        }
        int i6 = Integer.MIN_VALUE;
        int d2 = this.f4041b.d();
        while (i3 != i4) {
            b bVar3 = this.f4040a[i3];
            int a2 = bVar3.a(d2);
            if (a2 > i6) {
                bVar = bVar3;
                i6 = a2;
            }
            i3 += i2;
        }
        return bVar;
    }

    private void a(int i2, int i3) {
        for (int i4 = 0; i4 < this.f4048i; i4++) {
            if (!this.f4040a[i4].f4082a.isEmpty()) {
                a(this.f4040a[i4], i2, i3);
            }
        }
    }

    private void a(View view, int i2, int i3, boolean z2) {
        b(view, this.C);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int b2 = b(i2, layoutParams.leftMargin + this.C.left, layoutParams.rightMargin + this.C.right);
        int b3 = b(i3, layoutParams.topMargin + this.C.top, layoutParams.bottomMargin + this.C.bottom);
        if (z2 ? a(view, b2, b3, (RecyclerView.LayoutParams) layoutParams) : b(view, b2, b3, layoutParams)) {
            view.measure(b2, b3);
        }
    }

    private void a(View view, LayoutParams layoutParams, n nVar) {
        if (nVar.f4297e == 1) {
            if (layoutParams.f4058b) {
                p(view);
            } else {
                layoutParams.f4057a.b(view);
            }
        } else if (layoutParams.f4058b) {
            q(view);
        } else {
            layoutParams.f4057a.a(view);
        }
    }

    private void a(View view, LayoutParams layoutParams, boolean z2) {
        int i2;
        int i3;
        if (layoutParams.f4058b) {
            if (this.f4049j == 1) {
                i3 = this.B;
            } else {
                a(view, a(C(), A(), E() + G(), layoutParams.width, true), this.B, z2);
                return;
            }
        } else if (this.f4049j == 1) {
            i3 = a(this.f4050k, A(), 0, layoutParams.width, false);
        } else {
            i3 = a(C(), A(), E() + G(), layoutParams.width, true);
            i2 = a(this.f4050k, B(), 0, layoutParams.height, false);
            a(view, i3, i2, z2);
        }
        i2 = a(D(), B(), F() + H(), layoutParams.height, true);
        a(view, i3, i2, z2);
    }

    private void a(RecyclerView.n nVar, int i2) {
        while (z() > 0) {
            View i3 = i(0);
            if (this.f4041b.b(i3) <= i2 && this.f4041b.c(i3) <= i2) {
                LayoutParams layoutParams = (LayoutParams) i3.getLayoutParams();
                if (layoutParams.f4058b) {
                    int i4 = 0;
                    while (i4 < this.f4048i) {
                        if (this.f4040a[i4].f4082a.size() != 1) {
                            i4++;
                        } else {
                            return;
                        }
                    }
                    for (int i5 = 0; i5 < this.f4048i; i5++) {
                        this.f4040a[i5].h();
                    }
                } else if (layoutParams.f4057a.f4082a.size() != 1) {
                    layoutParams.f4057a.h();
                } else {
                    return;
                }
                a(i3, nVar);
            } else {
                return;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0151, code lost:
        if (b() != false) goto L_0x0155;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(androidx.recyclerview.widget.RecyclerView.n r9, androidx.recyclerview.widget.RecyclerView.s r10, boolean r11) {
        /*
            r8 = this;
            androidx.recyclerview.widget.StaggeredGridLayoutManager$a r0 = r8.D
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r1 = r8.A
            r2 = -1
            if (r1 != 0) goto L_0x000b
            int r1 = r8.f4045f
            if (r1 == r2) goto L_0x0018
        L_0x000b:
            int r1 = r10.e()
            if (r1 != 0) goto L_0x0018
            r8.c((androidx.recyclerview.widget.RecyclerView.n) r9)
            r0.a()
            return
        L_0x0018:
            boolean r1 = r0.f4079e
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x0029
            int r1 = r8.f4045f
            if (r1 != r2) goto L_0x0029
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r1 = r8.A
            if (r1 == 0) goto L_0x0027
            goto L_0x0029
        L_0x0027:
            r1 = 0
            goto L_0x002a
        L_0x0029:
            r1 = 1
        L_0x002a:
            if (r1 == 0) goto L_0x0043
            r0.a()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r5 = r8.A
            if (r5 == 0) goto L_0x0037
            r8.a((androidx.recyclerview.widget.StaggeredGridLayoutManager.a) r0)
            goto L_0x003e
        L_0x0037:
            r8.P()
            boolean r5 = r8.f4044e
            r0.f4077c = r5
        L_0x003e:
            r8.a((androidx.recyclerview.widget.RecyclerView.s) r10, (androidx.recyclerview.widget.StaggeredGridLayoutManager.a) r0)
            r0.f4079e = r4
        L_0x0043:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r5 = r8.A
            if (r5 != 0) goto L_0x0060
            int r5 = r8.f4045f
            if (r5 != r2) goto L_0x0060
            boolean r5 = r0.f4077c
            boolean r6 = r8.f4054o
            if (r5 != r6) goto L_0x0059
            boolean r5 = r8.k()
            boolean r6 = r8.f4055z
            if (r5 == r6) goto L_0x0060
        L_0x0059:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r5 = r8.f4047h
            r5.a()
            r0.f4078d = r4
        L_0x0060:
            int r5 = r8.z()
            if (r5 <= 0) goto L_0x00cb
            androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState r5 = r8.A
            if (r5 == 0) goto L_0x006e
            int r5 = r5.f4067c
            if (r5 >= r4) goto L_0x00cb
        L_0x006e:
            boolean r5 = r0.f4078d
            if (r5 == 0) goto L_0x0090
            r1 = 0
        L_0x0073:
            int r5 = r8.f4048i
            if (r1 >= r5) goto L_0x00cb
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b[] r5 = r8.f4040a
            r5 = r5[r1]
            r5.e()
            int r5 = r0.f4076b
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r5 == r6) goto L_0x008d
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b[] r5 = r8.f4040a
            r5 = r5[r1]
            int r6 = r0.f4076b
            r5.c((int) r6)
        L_0x008d:
            int r1 = r1 + 1
            goto L_0x0073
        L_0x0090:
            if (r1 != 0) goto L_0x00b1
            androidx.recyclerview.widget.StaggeredGridLayoutManager$a r1 = r8.D
            int[] r1 = r1.f4080f
            if (r1 != 0) goto L_0x0099
            goto L_0x00b1
        L_0x0099:
            r1 = 0
        L_0x009a:
            int r5 = r8.f4048i
            if (r1 >= r5) goto L_0x00cb
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b[] r5 = r8.f4040a
            r5 = r5[r1]
            r5.e()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$a r6 = r8.D
            int[] r6 = r6.f4080f
            r6 = r6[r1]
            r5.c((int) r6)
            int r1 = r1 + 1
            goto L_0x009a
        L_0x00b1:
            r1 = 0
        L_0x00b2:
            int r5 = r8.f4048i
            if (r1 >= r5) goto L_0x00c4
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b[] r5 = r8.f4040a
            r5 = r5[r1]
            boolean r6 = r8.f4044e
            int r7 = r0.f4076b
            r5.a((boolean) r6, (int) r7)
            int r1 = r1 + 1
            goto L_0x00b2
        L_0x00c4:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$a r1 = r8.D
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b[] r5 = r8.f4040a
            r1.a((androidx.recyclerview.widget.StaggeredGridLayoutManager.b[]) r5)
        L_0x00cb:
            r8.a((androidx.recyclerview.widget.RecyclerView.n) r9)
            androidx.recyclerview.widget.n r1 = r8.f4051l
            r1.f4293a = r3
            r8.E = r3
            androidx.recyclerview.widget.s r1 = r8.f4042c
            int r1 = r1.f()
            r8.f((int) r1)
            int r1 = r0.f4075a
            r8.b((int) r1, (androidx.recyclerview.widget.RecyclerView.s) r10)
            boolean r1 = r0.f4077c
            if (r1 == 0) goto L_0x00f2
            r8.m(r2)
            androidx.recyclerview.widget.n r1 = r8.f4051l
            r8.a((androidx.recyclerview.widget.RecyclerView.n) r9, (androidx.recyclerview.widget.n) r1, (androidx.recyclerview.widget.RecyclerView.s) r10)
            r8.m(r4)
            goto L_0x00fd
        L_0x00f2:
            r8.m(r4)
            androidx.recyclerview.widget.n r1 = r8.f4051l
            r8.a((androidx.recyclerview.widget.RecyclerView.n) r9, (androidx.recyclerview.widget.n) r1, (androidx.recyclerview.widget.RecyclerView.s) r10)
            r8.m(r2)
        L_0x00fd:
            androidx.recyclerview.widget.n r1 = r8.f4051l
            int r2 = r0.f4075a
            androidx.recyclerview.widget.n r5 = r8.f4051l
            int r5 = r5.f4296d
            int r2 = r2 + r5
            r1.f4295c = r2
            androidx.recyclerview.widget.n r1 = r8.f4051l
            r8.a((androidx.recyclerview.widget.RecyclerView.n) r9, (androidx.recyclerview.widget.n) r1, (androidx.recyclerview.widget.RecyclerView.s) r10)
            r8.Q()
            int r1 = r8.z()
            if (r1 <= 0) goto L_0x0127
            boolean r1 = r8.f4044e
            if (r1 == 0) goto L_0x0121
            r8.b((androidx.recyclerview.widget.RecyclerView.n) r9, (androidx.recyclerview.widget.RecyclerView.s) r10, (boolean) r4)
            r8.c((androidx.recyclerview.widget.RecyclerView.n) r9, (androidx.recyclerview.widget.RecyclerView.s) r10, (boolean) r3)
            goto L_0x0127
        L_0x0121:
            r8.c((androidx.recyclerview.widget.RecyclerView.n) r9, (androidx.recyclerview.widget.RecyclerView.s) r10, (boolean) r4)
            r8.b((androidx.recyclerview.widget.RecyclerView.n) r9, (androidx.recyclerview.widget.RecyclerView.s) r10, (boolean) r3)
        L_0x0127:
            if (r11 == 0) goto L_0x0154
            boolean r11 = r10.a()
            if (r11 != 0) goto L_0x0154
            int r11 = r8.f4053n
            if (r11 == 0) goto L_0x0145
            int r11 = r8.z()
            if (r11 <= 0) goto L_0x0145
            boolean r11 = r8.E
            if (r11 != 0) goto L_0x0143
            android.view.View r11 = r8.h()
            if (r11 == 0) goto L_0x0145
        L_0x0143:
            r11 = 1
            goto L_0x0146
        L_0x0145:
            r11 = 0
        L_0x0146:
            if (r11 == 0) goto L_0x0154
            java.lang.Runnable r11 = r8.H
            r8.a((java.lang.Runnable) r11)
            boolean r11 = r8.b()
            if (r11 == 0) goto L_0x0154
            goto L_0x0155
        L_0x0154:
            r4 = 0
        L_0x0155:
            boolean r11 = r10.a()
            if (r11 == 0) goto L_0x0160
            androidx.recyclerview.widget.StaggeredGridLayoutManager$a r11 = r8.D
            r11.a()
        L_0x0160:
            boolean r11 = r0.f4077c
            r8.f4054o = r11
            boolean r11 = r8.k()
            r8.f4055z = r11
            if (r4 == 0) goto L_0x0174
            androidx.recyclerview.widget.StaggeredGridLayoutManager$a r11 = r8.D
            r11.a()
            r8.a((androidx.recyclerview.widget.RecyclerView.n) r9, (androidx.recyclerview.widget.RecyclerView.s) r10, (boolean) r3)
        L_0x0174:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.a(androidx.recyclerview.widget.RecyclerView$n, androidx.recyclerview.widget.RecyclerView$s, boolean):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0010, code lost:
        if (r4.f4297e == -1) goto L_0x0012;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(androidx.recyclerview.widget.RecyclerView.n r3, androidx.recyclerview.widget.n r4) {
        /*
            r2 = this;
            boolean r0 = r4.f4293a
            if (r0 == 0) goto L_0x004f
            boolean r0 = r4.f4301i
            if (r0 == 0) goto L_0x0009
            goto L_0x004f
        L_0x0009:
            int r0 = r4.f4294b
            r1 = -1
            if (r0 != 0) goto L_0x001e
            int r0 = r4.f4297e
            if (r0 != r1) goto L_0x0018
        L_0x0012:
            int r4 = r4.f4299g
        L_0x0014:
            r2.b((androidx.recyclerview.widget.RecyclerView.n) r3, (int) r4)
            goto L_0x004f
        L_0x0018:
            int r4 = r4.f4298f
        L_0x001a:
            r2.a((androidx.recyclerview.widget.RecyclerView.n) r3, (int) r4)
            goto L_0x004f
        L_0x001e:
            int r0 = r4.f4297e
            if (r0 != r1) goto L_0x0039
            int r0 = r4.f4298f
            int r1 = r4.f4298f
            int r1 = r2.p((int) r1)
            int r0 = r0 - r1
            if (r0 >= 0) goto L_0x002e
            goto L_0x0012
        L_0x002e:
            int r1 = r4.f4299g
            int r4 = r4.f4294b
            int r4 = java.lang.Math.min(r0, r4)
            int r4 = r1 - r4
            goto L_0x0014
        L_0x0039:
            int r0 = r4.f4299g
            int r0 = r2.s(r0)
            int r1 = r4.f4299g
            int r0 = r0 - r1
            if (r0 >= 0) goto L_0x0045
            goto L_0x0018
        L_0x0045:
            int r1 = r4.f4298f
            int r4 = r4.f4294b
            int r4 = java.lang.Math.min(r0, r4)
            int r4 = r4 + r1
            goto L_0x001a
        L_0x004f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.a(androidx.recyclerview.widget.RecyclerView$n, androidx.recyclerview.widget.n):void");
    }

    private void a(a aVar) {
        boolean z2;
        if (this.A.f4067c > 0) {
            if (this.A.f4067c == this.f4048i) {
                for (int i2 = 0; i2 < this.f4048i; i2++) {
                    this.f4040a[i2].e();
                    int i3 = this.A.f4068d[i2];
                    if (i3 != Integer.MIN_VALUE) {
                        i3 += this.A.f4073i ? this.f4041b.d() : this.f4041b.c();
                    }
                    this.f4040a[i2].c(i3);
                }
            } else {
                this.A.a();
                SavedState savedState = this.A;
                savedState.f4065a = savedState.f4066b;
            }
        }
        this.f4055z = this.A.f4074j;
        a(this.A.f4072h);
        P();
        if (this.A.f4065a != -1) {
            this.f4045f = this.A.f4065a;
            z2 = this.A.f4073i;
        } else {
            z2 = this.f4044e;
        }
        aVar.f4077c = z2;
        if (this.A.f4069e > 1) {
            this.f4047h.f4059a = this.A.f4070f;
            this.f4047h.f4060b = this.A.f4071g;
        }
    }

    private void a(b bVar, int i2, int i3) {
        int i4 = bVar.i();
        if (i2 == -1) {
            if (bVar.b() + i4 > i3) {
                return;
            }
        } else if (bVar.d() - i4 < i3) {
            return;
        }
        this.f4052m.set(bVar.f4086e, false);
    }

    private boolean a(b bVar) {
        if (this.f4044e) {
            if (bVar.d() < this.f4041b.d()) {
                return !bVar.c(bVar.f4082a.get(bVar.f4082a.size() - 1)).f4058b;
            }
        } else if (bVar.b() > this.f4041b.c()) {
            return !bVar.c(bVar.f4082a.get(0)).f4058b;
        }
        return false;
    }

    private int b(int i2, int i3, int i4) {
        if (i3 == 0 && i4 == 0) {
            return i2;
        }
        int mode = View.MeasureSpec.getMode(i2);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i2) - i3) - i4), mode) : i2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(int r5, androidx.recyclerview.widget.RecyclerView.s r6) {
        /*
            r4 = this;
            androidx.recyclerview.widget.n r0 = r4.f4051l
            r1 = 0
            r0.f4294b = r1
            androidx.recyclerview.widget.n r0 = r4.f4051l
            r0.f4295c = r5
            boolean r0 = r4.w()
            r2 = 1
            if (r0 == 0) goto L_0x0030
            int r6 = r6.c()
            r0 = -1
            if (r6 == r0) goto L_0x0030
            boolean r0 = r4.f4044e
            if (r6 >= r5) goto L_0x001d
            r5 = 1
            goto L_0x001e
        L_0x001d:
            r5 = 0
        L_0x001e:
            if (r0 != r5) goto L_0x0027
            androidx.recyclerview.widget.s r5 = r4.f4041b
            int r5 = r5.f()
            goto L_0x0031
        L_0x0027:
            androidx.recyclerview.widget.s r5 = r4.f4041b
            int r5 = r5.f()
            r6 = r5
            r5 = 0
            goto L_0x0032
        L_0x0030:
            r5 = 0
        L_0x0031:
            r6 = 0
        L_0x0032:
            boolean r0 = r4.v()
            if (r0 == 0) goto L_0x004f
            androidx.recyclerview.widget.n r0 = r4.f4051l
            androidx.recyclerview.widget.s r3 = r4.f4041b
            int r3 = r3.c()
            int r3 = r3 - r6
            r0.f4298f = r3
            androidx.recyclerview.widget.n r6 = r4.f4051l
            androidx.recyclerview.widget.s r0 = r4.f4041b
            int r0 = r0.d()
            int r0 = r0 + r5
            r6.f4299g = r0
            goto L_0x005f
        L_0x004f:
            androidx.recyclerview.widget.n r0 = r4.f4051l
            androidx.recyclerview.widget.s r3 = r4.f4041b
            int r3 = r3.e()
            int r3 = r3 + r5
            r0.f4299g = r3
            androidx.recyclerview.widget.n r5 = r4.f4051l
            int r6 = -r6
            r5.f4298f = r6
        L_0x005f:
            androidx.recyclerview.widget.n r5 = r4.f4051l
            r5.f4300h = r1
            androidx.recyclerview.widget.n r5 = r4.f4051l
            r5.f4293a = r2
            androidx.recyclerview.widget.n r5 = r4.f4051l
            androidx.recyclerview.widget.s r6 = r4.f4041b
            int r6 = r6.h()
            if (r6 != 0) goto L_0x007a
            androidx.recyclerview.widget.s r6 = r4.f4041b
            int r6 = r6.e()
            if (r6 != 0) goto L_0x007a
            r1 = 1
        L_0x007a:
            r5.f4301i = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.b(int, androidx.recyclerview.widget.RecyclerView$s):void");
    }

    private void b(RecyclerView.n nVar, int i2) {
        int z2 = z() - 1;
        while (z2 >= 0) {
            View i3 = i(z2);
            if (this.f4041b.a(i3) >= i2 && this.f4041b.d(i3) >= i2) {
                LayoutParams layoutParams = (LayoutParams) i3.getLayoutParams();
                if (layoutParams.f4058b) {
                    int i4 = 0;
                    while (i4 < this.f4048i) {
                        if (this.f4040a[i4].f4082a.size() != 1) {
                            i4++;
                        } else {
                            return;
                        }
                    }
                    for (int i5 = 0; i5 < this.f4048i; i5++) {
                        this.f4040a[i5].g();
                    }
                } else if (layoutParams.f4057a.f4082a.size() != 1) {
                    layoutParams.f4057a.g();
                } else {
                    return;
                }
                a(i3, nVar);
                z2--;
            } else {
                return;
            }
        }
    }

    private void b(RecyclerView.n nVar, RecyclerView.s sVar, boolean z2) {
        int d2;
        int r2 = r(Integer.MIN_VALUE);
        if (r2 != Integer.MIN_VALUE && (d2 = this.f4041b.d() - r2) > 0) {
            int i2 = d2 - (-c(-d2, nVar, sVar));
            if (z2 && i2 > 0) {
                this.f4041b.a(i2);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0043 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0044  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void c(int r7, int r8, int r9) {
        /*
            r6 = this;
            boolean r0 = r6.f4044e
            if (r0 == 0) goto L_0x0009
            int r0 = r6.p()
            goto L_0x000d
        L_0x0009:
            int r0 = r6.q()
        L_0x000d:
            r1 = 8
            if (r9 != r1) goto L_0x001a
            if (r7 >= r8) goto L_0x0016
            int r2 = r8 + 1
            goto L_0x001c
        L_0x0016:
            int r2 = r7 + 1
            r3 = r8
            goto L_0x001d
        L_0x001a:
            int r2 = r7 + r8
        L_0x001c:
            r3 = r7
        L_0x001d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r4 = r6.f4047h
            r4.b(r3)
            r4 = 1
            if (r9 == r4) goto L_0x003c
            r5 = 2
            if (r9 == r5) goto L_0x0036
            if (r9 == r1) goto L_0x002b
            goto L_0x0041
        L_0x002b:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.f4047h
            r9.a((int) r7, (int) r4)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r7 = r6.f4047h
            r7.b(r8, r4)
            goto L_0x0041
        L_0x0036:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.f4047h
            r9.a((int) r7, (int) r8)
            goto L_0x0041
        L_0x003c:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.f4047h
            r9.b(r7, r8)
        L_0x0041:
            if (r2 > r0) goto L_0x0044
            return
        L_0x0044:
            boolean r7 = r6.f4044e
            if (r7 == 0) goto L_0x004d
            int r7 = r6.q()
            goto L_0x0051
        L_0x004d:
            int r7 = r6.p()
        L_0x0051:
            if (r3 > r7) goto L_0x0056
            r6.s()
        L_0x0056:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.c(int, int, int):void");
    }

    private void c(RecyclerView.n nVar, RecyclerView.s sVar, boolean z2) {
        int c2;
        int q2 = q((int) SubsamplingScaleImageView.TILE_SIZE_AUTO);
        if (q2 != Integer.MAX_VALUE && (c2 = q2 - this.f4041b.c()) > 0) {
            int c3 = c2 - c(c2, nVar, sVar);
            if (z2 && c3 > 0) {
                this.f4041b.a(-c3);
            }
        }
    }

    private boolean c(RecyclerView.s sVar, a aVar) {
        boolean z2 = this.f4054o;
        int e2 = sVar.e();
        aVar.f4075a = z2 ? w(e2) : v(e2);
        aVar.f4076b = Integer.MIN_VALUE;
        return true;
    }

    private int f(RecyclerView.s sVar) {
        if (z() == 0) {
            return 0;
        }
        return v.a(sVar, this.f4041b, b(!this.F), c(!this.F), this, this.F, this.f4044e);
    }

    private int i(RecyclerView.s sVar) {
        if (z() == 0) {
            return 0;
        }
        return v.a(sVar, this.f4041b, b(!this.F), c(!this.F), this, this.F);
    }

    private int j(RecyclerView.s sVar) {
        if (z() == 0) {
            return 0;
        }
        return v.b(sVar, this.f4041b, b(!this.F), c(!this.F), this, this.F);
    }

    private void m(int i2) {
        this.f4051l.f4297e = i2;
        n nVar = this.f4051l;
        int i3 = 1;
        if (this.f4044e != (i2 == -1)) {
            i3 = -1;
        }
        nVar.f4296d = i3;
    }

    private LazySpanLookup.FullSpanItem n(int i2) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.f4063c = new int[this.f4048i];
        for (int i3 = 0; i3 < this.f4048i; i3++) {
            fullSpanItem.f4063c[i3] = i2 - this.f4040a[i3].b(i2);
        }
        return fullSpanItem;
    }

    private LazySpanLookup.FullSpanItem o(int i2) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.f4063c = new int[this.f4048i];
        for (int i3 = 0; i3 < this.f4048i; i3++) {
            fullSpanItem.f4063c[i3] = this.f4040a[i3].a(i2) - i2;
        }
        return fullSpanItem;
    }

    private int p(int i2) {
        int a2 = this.f4040a[0].a(i2);
        for (int i3 = 1; i3 < this.f4048i; i3++) {
            int a3 = this.f4040a[i3].a(i2);
            if (a3 > a2) {
                a2 = a3;
            }
        }
        return a2;
    }

    private void p(View view) {
        for (int i2 = this.f4048i - 1; i2 >= 0; i2--) {
            this.f4040a[i2].b(view);
        }
    }

    private int q(int i2) {
        int a2 = this.f4040a[0].a(i2);
        for (int i3 = 1; i3 < this.f4048i; i3++) {
            int a3 = this.f4040a[i3].a(i2);
            if (a3 < a2) {
                a2 = a3;
            }
        }
        return a2;
    }

    private void q(View view) {
        for (int i2 = this.f4048i - 1; i2 >= 0; i2--) {
            this.f4040a[i2].a(view);
        }
    }

    private int r(int i2) {
        int b2 = this.f4040a[0].b(i2);
        for (int i3 = 1; i3 < this.f4048i; i3++) {
            int b3 = this.f4040a[i3].b(i2);
            if (b3 > b2) {
                b2 = b3;
            }
        }
        return b2;
    }

    private void r() {
        this.f4041b = s.a(this, this.f4049j);
        this.f4042c = s.a(this, 1 - this.f4049j);
    }

    private int s(int i2) {
        int b2 = this.f4040a[0].b(i2);
        for (int i3 = 1; i3 < this.f4048i; i3++) {
            int b3 = this.f4040a[i3].b(i2);
            if (b3 < b2) {
                b2 = b3;
            }
        }
        return b2;
    }

    private boolean t(int i2) {
        if (this.f4049j == 0) {
            return (i2 == -1) != this.f4044e;
        }
        return ((i2 == -1) == this.f4044e) == k();
    }

    private int u(int i2) {
        if (z() == 0) {
            return this.f4044e ? 1 : -1;
        }
        return (i2 < q()) != this.f4044e ? -1 : 1;
    }

    private int v(int i2) {
        int z2 = z();
        for (int i3 = 0; i3 < z2; i3++) {
            int d2 = d(i(i3));
            if (d2 >= 0 && d2 < i2) {
                return d2;
            }
        }
        return 0;
    }

    private int w(int i2) {
        for (int z2 = z() - 1; z2 >= 0; z2--) {
            int d2 = d(i(z2));
            if (d2 >= 0 && d2 < i2) {
                return d2;
            }
        }
        return 0;
    }

    private int x(int i2) {
        return i2 != 1 ? i2 != 2 ? i2 != 17 ? i2 != 33 ? i2 != 66 ? (i2 == 130 && this.f4049j == 1) ? 1 : Integer.MIN_VALUE : this.f4049j == 0 ? 1 : Integer.MIN_VALUE : this.f4049j == 1 ? -1 : Integer.MIN_VALUE : this.f4049j == 0 ? -1 : Integer.MIN_VALUE : (this.f4049j != 1 && k()) ? -1 : 1 : (this.f4049j != 1 && k()) ? 1 : -1;
    }

    public int a(int i2, RecyclerView.n nVar, RecyclerView.s sVar) {
        return c(i2, nVar, sVar);
    }

    public View a(View view, int i2, RecyclerView.n nVar, RecyclerView.s sVar) {
        View e2;
        View a2;
        if (z() == 0 || (e2 = e(view)) == null) {
            return null;
        }
        P();
        int x2 = x(i2);
        if (x2 == Integer.MIN_VALUE) {
            return null;
        }
        LayoutParams layoutParams = (LayoutParams) e2.getLayoutParams();
        boolean z2 = layoutParams.f4058b;
        b bVar = layoutParams.f4057a;
        int p2 = x2 == 1 ? p() : q();
        b(p2, sVar);
        m(x2);
        n nVar2 = this.f4051l;
        nVar2.f4295c = nVar2.f4296d + p2;
        this.f4051l.f4294b = (int) (((float) this.f4041b.f()) * 0.33333334f);
        this.f4051l.f4300h = true;
        this.f4051l.f4293a = false;
        a(nVar, this.f4051l, sVar);
        this.f4054o = this.f4044e;
        if (!z2 && (a2 = bVar.a(p2, x2)) != null && a2 != e2) {
            return a2;
        }
        if (t(x2)) {
            for (int i3 = this.f4048i - 1; i3 >= 0; i3--) {
                View a3 = this.f4040a[i3].a(p2, x2);
                if (a3 != null && a3 != e2) {
                    return a3;
                }
            }
        } else {
            for (int i4 = 0; i4 < this.f4048i; i4++) {
                View a4 = this.f4040a[i4].a(p2, x2);
                if (a4 != null && a4 != e2) {
                    return a4;
                }
            }
        }
        boolean z3 = (this.f4043d ^ true) == (x2 == -1);
        if (!z2) {
            View c2 = c(z3 ? bVar.j() : bVar.k());
            if (!(c2 == null || c2 == e2)) {
                return c2;
            }
        }
        if (t(x2)) {
            for (int i5 = this.f4048i - 1; i5 >= 0; i5--) {
                if (i5 != bVar.f4086e) {
                    b[] bVarArr = this.f4040a;
                    View c3 = c(z3 ? bVarArr[i5].j() : bVarArr[i5].k());
                    if (!(c3 == null || c3 == e2)) {
                        return c3;
                    }
                }
            }
        } else {
            for (int i6 = 0; i6 < this.f4048i; i6++) {
                b[] bVarArr2 = this.f4040a;
                View c4 = c(z3 ? bVarArr2[i6].j() : bVarArr2[i6].k());
                if (c4 != null && c4 != e2) {
                    return c4;
                }
            }
        }
        return null;
    }

    public RecyclerView.LayoutParams a() {
        return this.f4049j == 0 ? new LayoutParams(-2, -1) : new LayoutParams(-1, -2);
    }

    public RecyclerView.LayoutParams a(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    public RecyclerView.LayoutParams a(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public void a(int i2) {
        a((String) null);
        if (i2 != this.f4048i) {
            j();
            this.f4048i = i2;
            this.f4052m = new BitSet(this.f4048i);
            this.f4040a = new b[this.f4048i];
            for (int i3 = 0; i3 < this.f4048i; i3++) {
                this.f4040a[i3] = new b(i3);
            }
            s();
        }
    }

    public void a(int i2, int i3, RecyclerView.s sVar, RecyclerView.h.a aVar) {
        int i4;
        int i5;
        if (this.f4049j != 0) {
            i2 = i3;
        }
        if (z() != 0 && i2 != 0) {
            a(i2, sVar);
            int[] iArr = this.G;
            if (iArr == null || iArr.length < this.f4048i) {
                this.G = new int[this.f4048i];
            }
            int i6 = 0;
            for (int i7 = 0; i7 < this.f4048i; i7++) {
                if (this.f4051l.f4296d == -1) {
                    i5 = this.f4051l.f4298f;
                    i4 = this.f4040a[i7].a(this.f4051l.f4298f);
                } else {
                    i5 = this.f4040a[i7].b(this.f4051l.f4299g);
                    i4 = this.f4051l.f4299g;
                }
                int i8 = i5 - i4;
                if (i8 >= 0) {
                    this.G[i6] = i8;
                    i6++;
                }
            }
            Arrays.sort(this.G, 0, i6);
            for (int i9 = 0; i9 < i6 && this.f4051l.a(sVar); i9++) {
                aVar.b(this.f4051l.f4295c, this.G[i9]);
                this.f4051l.f4295c += this.f4051l.f4296d;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, RecyclerView.s sVar) {
        int i3;
        int i4;
        if (i2 > 0) {
            i4 = p();
            i3 = 1;
        } else {
            i4 = q();
            i3 = -1;
        }
        this.f4051l.f4293a = true;
        b(i4, sVar);
        m(i3);
        n nVar = this.f4051l;
        nVar.f4295c = i4 + nVar.f4296d;
        this.f4051l.f4294b = Math.abs(i2);
    }

    public void a(Rect rect, int i2, int i3) {
        int i4;
        int i5;
        int E2 = E() + G();
        int F2 = F() + H();
        if (this.f4049j == 1) {
            i5 = a(i3, rect.height() + F2, L());
            i4 = a(i2, (this.f4050k * this.f4048i) + E2, K());
        } else {
            i4 = a(i2, rect.width() + E2, K());
            i5 = a(i3, (this.f4050k * this.f4048i) + F2, L());
        }
        g(i4, i5);
    }

    public void a(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.A = savedState;
            if (this.f4045f != -1) {
                savedState.b();
                this.A.a();
            }
            s();
        }
    }

    public void a(AccessibilityEvent accessibilityEvent) {
        super.a(accessibilityEvent);
        if (z() > 0) {
            View b2 = b(false);
            View c2 = c(false);
            if (b2 != null && c2 != null) {
                int d2 = d(b2);
                int d3 = d(c2);
                if (d2 < d3) {
                    accessibilityEvent.setFromIndex(d2);
                    accessibilityEvent.setToIndex(d3);
                    return;
                }
                accessibilityEvent.setFromIndex(d3);
                accessibilityEvent.setToIndex(d2);
            }
        }
    }

    public void a(RecyclerView.Adapter adapter, RecyclerView.Adapter adapter2) {
        this.f4047h.a();
        for (int i2 = 0; i2 < this.f4048i; i2++) {
            this.f4040a[i2].e();
        }
    }

    public void a(RecyclerView.s sVar) {
        super.a(sVar);
        this.f4045f = -1;
        this.f4046g = Integer.MIN_VALUE;
        this.A = null;
        this.D.a();
    }

    /* access modifiers changed from: package-private */
    public void a(RecyclerView.s sVar, a aVar) {
        if (!b(sVar, aVar) && !c(sVar, aVar)) {
            aVar.b();
            aVar.f4075a = 0;
        }
    }

    public void a(RecyclerView recyclerView) {
        this.f4047h.a();
        s();
    }

    public void a(RecyclerView recyclerView, int i2, int i3) {
        c(i2, i3, 1);
    }

    public void a(RecyclerView recyclerView, int i2, int i3, int i4) {
        c(i2, i3, 8);
    }

    public void a(RecyclerView recyclerView, int i2, int i3, Object obj) {
        c(i2, i3, 4);
    }

    public void a(RecyclerView recyclerView, RecyclerView.n nVar) {
        super.a(recyclerView, nVar);
        a(this.H);
        for (int i2 = 0; i2 < this.f4048i; i2++) {
            this.f4040a[i2].e();
        }
        recyclerView.requestLayout();
    }

    public void a(RecyclerView recyclerView, RecyclerView.s sVar, int i2) {
        o oVar = new o(recyclerView.getContext());
        oVar.c(i2);
        a((RecyclerView.r) oVar);
    }

    public void a(String str) {
        if (this.A == null) {
            super.a(str);
        }
    }

    public void a(boolean z2) {
        a((String) null);
        SavedState savedState = this.A;
        if (!(savedState == null || savedState.f4072h == z2)) {
            this.A.f4072h = z2;
        }
        this.f4043d = z2;
        s();
    }

    public boolean a(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public int[] a(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.f4048i];
        } else if (iArr.length < this.f4048i) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.f4048i + ", array size:" + iArr.length);
        }
        for (int i2 = 0; i2 < this.f4048i; i2++) {
            iArr[i2] = this.f4040a[i2].l();
        }
        return iArr;
    }

    public int b(int i2, RecyclerView.n nVar, RecyclerView.s sVar) {
        return c(i2, nVar, sVar);
    }

    public int b(RecyclerView.s sVar) {
        return j(sVar);
    }

    /* access modifiers changed from: package-private */
    public View b(boolean z2) {
        int c2 = this.f4041b.c();
        int d2 = this.f4041b.d();
        int z3 = z();
        View view = null;
        for (int i2 = 0; i2 < z3; i2++) {
            View i3 = i(i2);
            int a2 = this.f4041b.a(i3);
            if (this.f4041b.b(i3) > c2 && a2 < d2) {
                if (a2 >= c2 || !z2) {
                    return i3;
                }
                if (view == null) {
                    view = i3;
                }
            }
        }
        return view;
    }

    public void b(int i2) {
        if (i2 == 0 || i2 == 1) {
            a((String) null);
            if (i2 != this.f4049j) {
                this.f4049j = i2;
                s sVar = this.f4041b;
                this.f4041b = this.f4042c;
                this.f4042c = sVar;
                s();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation.");
    }

    public void b(RecyclerView recyclerView, int i2, int i3) {
        c(i2, i3, 2);
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        int i2;
        int i3;
        if (z() == 0 || this.f4053n == 0 || !u()) {
            return false;
        }
        if (this.f4044e) {
            i3 = p();
            i2 = q();
        } else {
            i3 = q();
            i2 = p();
        }
        if (i3 == 0 && h() != null) {
            this.f4047h.a();
        } else if (!this.E) {
            return false;
        } else {
            int i4 = this.f4044e ? -1 : 1;
            int i5 = i2 + 1;
            LazySpanLookup.FullSpanItem a2 = this.f4047h.a(i3, i5, i4, true);
            if (a2 == null) {
                this.E = false;
                this.f4047h.a(i5);
                return false;
            }
            LazySpanLookup.FullSpanItem a3 = this.f4047h.a(i3, a2.f4061a, i4 * -1, true);
            if (a3 == null) {
                this.f4047h.a(a2.f4061a);
            } else {
                this.f4047h.a(a3.f4061a + 1);
            }
        }
        N();
        s();
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean b(RecyclerView.s sVar, a aVar) {
        int i2;
        int i3;
        int i4;
        boolean z2 = false;
        if (!sVar.a() && (i2 = this.f4045f) != -1) {
            if (i2 < 0 || i2 >= sVar.e()) {
                this.f4045f = -1;
                this.f4046g = Integer.MIN_VALUE;
            } else {
                SavedState savedState = this.A;
                if (savedState == null || savedState.f4065a == -1 || this.A.f4067c < 1) {
                    View c2 = c(this.f4045f);
                    if (c2 != null) {
                        aVar.f4075a = this.f4044e ? p() : q();
                        if (this.f4046g != Integer.MIN_VALUE) {
                            if (aVar.f4077c) {
                                i4 = this.f4041b.d() - this.f4046g;
                                i3 = this.f4041b.b(c2);
                            } else {
                                i4 = this.f4041b.c() + this.f4046g;
                                i3 = this.f4041b.a(c2);
                            }
                            aVar.f4076b = i4 - i3;
                            return true;
                        } else if (this.f4041b.e(c2) > this.f4041b.f()) {
                            aVar.f4076b = aVar.f4077c ? this.f4041b.d() : this.f4041b.c();
                            return true;
                        } else {
                            int a2 = this.f4041b.a(c2) - this.f4041b.c();
                            if (a2 < 0) {
                                aVar.f4076b = -a2;
                                return true;
                            }
                            int d2 = this.f4041b.d() - this.f4041b.b(c2);
                            if (d2 < 0) {
                                aVar.f4076b = d2;
                                return true;
                            }
                            aVar.f4076b = Integer.MIN_VALUE;
                        }
                    } else {
                        aVar.f4075a = this.f4045f;
                        int i5 = this.f4046g;
                        if (i5 == Integer.MIN_VALUE) {
                            if (u(aVar.f4075a) == 1) {
                                z2 = true;
                            }
                            aVar.f4077c = z2;
                            aVar.b();
                        } else {
                            aVar.a(i5);
                        }
                        aVar.f4078d = true;
                    }
                } else {
                    aVar.f4076b = Integer.MIN_VALUE;
                    aVar.f4075a = this.f4045f;
                }
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public int c(int i2, RecyclerView.n nVar, RecyclerView.s sVar) {
        if (z() == 0 || i2 == 0) {
            return 0;
        }
        a(i2, sVar);
        int a2 = a(nVar, this.f4051l, sVar);
        if (this.f4051l.f4294b >= a2) {
            i2 = i2 < 0 ? -a2 : a2;
        }
        this.f4041b.a(-i2);
        this.f4054o = this.f4044e;
        this.f4051l.f4294b = 0;
        a(nVar, this.f4051l);
        return i2;
    }

    public int c(RecyclerView.s sVar) {
        return j(sVar);
    }

    /* access modifiers changed from: package-private */
    public View c(boolean z2) {
        int c2 = this.f4041b.c();
        int d2 = this.f4041b.d();
        View view = null;
        for (int z3 = z() - 1; z3 >= 0; z3--) {
            View i2 = i(z3);
            int a2 = this.f4041b.a(i2);
            int b2 = this.f4041b.b(i2);
            if (b2 > c2 && a2 < d2) {
                if (b2 <= d2 || !z2) {
                    return i2;
                }
                if (view == null) {
                    view = i2;
                }
            }
        }
        return view;
    }

    public void c(RecyclerView.n nVar, RecyclerView.s sVar) {
        a(nVar, sVar, true);
    }

    public boolean c() {
        return this.A == null;
    }

    public int d(RecyclerView.s sVar) {
        return f(sVar);
    }

    public PointF d(int i2) {
        int u2 = u(i2);
        PointF pointF = new PointF();
        if (u2 == 0) {
            return null;
        }
        if (this.f4049j == 0) {
            pointF.x = (float) u2;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = (float) u2;
        }
        return pointF;
    }

    public boolean d() {
        return this.f4053n != 0;
    }

    public int e(RecyclerView.s sVar) {
        return f(sVar);
    }

    public Parcelable e() {
        int i2;
        int i3;
        if (this.A != null) {
            return new SavedState(this.A);
        }
        SavedState savedState = new SavedState();
        savedState.f4072h = this.f4043d;
        savedState.f4073i = this.f4054o;
        savedState.f4074j = this.f4055z;
        LazySpanLookup lazySpanLookup = this.f4047h;
        if (lazySpanLookup == null || lazySpanLookup.f4059a == null) {
            savedState.f4069e = 0;
        } else {
            savedState.f4070f = this.f4047h.f4059a;
            savedState.f4069e = savedState.f4070f.length;
            savedState.f4071g = this.f4047h.f4060b;
        }
        if (z() > 0) {
            savedState.f4065a = this.f4054o ? p() : q();
            savedState.f4066b = l();
            savedState.f4067c = this.f4048i;
            savedState.f4068d = new int[this.f4048i];
            for (int i4 = 0; i4 < this.f4048i; i4++) {
                if (this.f4054o) {
                    i2 = this.f4040a[i4].b(Integer.MIN_VALUE);
                    if (i2 != Integer.MIN_VALUE) {
                        i3 = this.f4041b.d();
                    } else {
                        savedState.f4068d[i4] = i2;
                    }
                } else {
                    i2 = this.f4040a[i4].a(Integer.MIN_VALUE);
                    if (i2 != Integer.MIN_VALUE) {
                        i3 = this.f4041b.c();
                    } else {
                        savedState.f4068d[i4] = i2;
                    }
                }
                i2 -= i3;
                savedState.f4068d[i4] = i2;
            }
        } else {
            savedState.f4065a = -1;
            savedState.f4066b = -1;
            savedState.f4067c = 0;
        }
        return savedState;
    }

    public void e(int i2) {
        SavedState savedState = this.A;
        if (!(savedState == null || savedState.f4065a == i2)) {
            this.A.b();
        }
        this.f4045f = i2;
        this.f4046g = Integer.MIN_VALUE;
        s();
    }

    /* access modifiers changed from: package-private */
    public void f(int i2) {
        this.f4050k = i2 / this.f4048i;
        this.B = View.MeasureSpec.makeMeasureSpec(i2, this.f4042c.h());
    }

    public boolean f() {
        return this.f4049j == 0;
    }

    public int g(RecyclerView.s sVar) {
        return i(sVar);
    }

    public boolean g() {
        return this.f4049j == 1;
    }

    public int h(RecyclerView.s sVar) {
        return i(sVar);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0074, code lost:
        if (r10 == r11) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0086, code lost:
        if (r10 == r11) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x008a, code lost:
        r10 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View h() {
        /*
            r12 = this;
            int r0 = r12.z()
            r1 = 1
            int r0 = r0 - r1
            java.util.BitSet r2 = new java.util.BitSet
            int r3 = r12.f4048i
            r2.<init>(r3)
            int r3 = r12.f4048i
            r4 = 0
            r2.set(r4, r3, r1)
            int r3 = r12.f4049j
            r5 = -1
            if (r3 != r1) goto L_0x0020
            boolean r3 = r12.k()
            if (r3 == 0) goto L_0x0020
            r3 = 1
            goto L_0x0021
        L_0x0020:
            r3 = -1
        L_0x0021:
            boolean r6 = r12.f4044e
            if (r6 == 0) goto L_0x0027
            r6 = -1
            goto L_0x002b
        L_0x0027:
            int r0 = r0 + 1
            r6 = r0
            r0 = 0
        L_0x002b:
            if (r0 >= r6) goto L_0x002e
            r5 = 1
        L_0x002e:
            if (r0 == r6) goto L_0x00ab
            android.view.View r7 = r12.i((int) r0)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LayoutParams r8 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams) r8
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r9 = r8.f4057a
            int r9 = r9.f4086e
            boolean r9 = r2.get(r9)
            if (r9 == 0) goto L_0x0054
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r9 = r8.f4057a
            boolean r9 = r12.a((androidx.recyclerview.widget.StaggeredGridLayoutManager.b) r9)
            if (r9 == 0) goto L_0x004d
            return r7
        L_0x004d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r9 = r8.f4057a
            int r9 = r9.f4086e
            r2.clear(r9)
        L_0x0054:
            boolean r9 = r8.f4058b
            if (r9 == 0) goto L_0x0059
            goto L_0x00a9
        L_0x0059:
            int r9 = r0 + r5
            if (r9 == r6) goto L_0x00a9
            android.view.View r9 = r12.i((int) r9)
            boolean r10 = r12.f4044e
            if (r10 == 0) goto L_0x0077
            androidx.recyclerview.widget.s r10 = r12.f4041b
            int r10 = r10.b((android.view.View) r7)
            androidx.recyclerview.widget.s r11 = r12.f4041b
            int r11 = r11.b((android.view.View) r9)
            if (r10 >= r11) goto L_0x0074
            return r7
        L_0x0074:
            if (r10 != r11) goto L_0x008a
            goto L_0x0088
        L_0x0077:
            androidx.recyclerview.widget.s r10 = r12.f4041b
            int r10 = r10.a((android.view.View) r7)
            androidx.recyclerview.widget.s r11 = r12.f4041b
            int r11 = r11.a((android.view.View) r9)
            if (r10 <= r11) goto L_0x0086
            return r7
        L_0x0086:
            if (r10 != r11) goto L_0x008a
        L_0x0088:
            r10 = 1
            goto L_0x008b
        L_0x008a:
            r10 = 0
        L_0x008b:
            if (r10 == 0) goto L_0x00a9
            android.view.ViewGroup$LayoutParams r9 = r9.getLayoutParams()
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LayoutParams r9 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams) r9
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r8 = r8.f4057a
            int r8 = r8.f4086e
            androidx.recyclerview.widget.StaggeredGridLayoutManager$b r9 = r9.f4057a
            int r9 = r9.f4086e
            int r8 = r8 - r9
            if (r8 >= 0) goto L_0x00a0
            r8 = 1
            goto L_0x00a1
        L_0x00a0:
            r8 = 0
        L_0x00a1:
            if (r3 >= 0) goto L_0x00a5
            r9 = 1
            goto L_0x00a6
        L_0x00a5:
            r9 = 0
        L_0x00a6:
            if (r8 == r9) goto L_0x00a9
            return r7
        L_0x00a9:
            int r0 = r0 + r5
            goto L_0x002e
        L_0x00ab:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.h():android.view.View");
    }

    public int i() {
        return this.f4048i;
    }

    public void j() {
        this.f4047h.a();
        s();
    }

    public void j(int i2) {
        super.j(i2);
        for (int i3 = 0; i3 < this.f4048i; i3++) {
            this.f4040a[i3].d(i2);
        }
    }

    public void k(int i2) {
        super.k(i2);
        for (int i3 = 0; i3 < this.f4048i; i3++) {
            this.f4040a[i3].d(i2);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean k() {
        return x() == 1;
    }

    /* access modifiers changed from: package-private */
    public int l() {
        View c2 = this.f4044e ? c(true) : b(true);
        if (c2 == null) {
            return -1;
        }
        return d(c2);
    }

    public void l(int i2) {
        if (i2 == 0) {
            b();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean m() {
        int b2 = this.f4040a[0].b(Integer.MIN_VALUE);
        for (int i2 = 1; i2 < this.f4048i; i2++) {
            if (this.f4040a[i2].b(Integer.MIN_VALUE) != b2) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean o() {
        int a2 = this.f4040a[0].a(Integer.MIN_VALUE);
        for (int i2 = 1; i2 < this.f4048i; i2++) {
            if (this.f4040a[i2].a(Integer.MIN_VALUE) != a2) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public int p() {
        int z2 = z();
        if (z2 == 0) {
            return 0;
        }
        return d(i(z2 - 1));
    }

    /* access modifiers changed from: package-private */
    public int q() {
        if (z() == 0) {
            return 0;
        }
        return d(i(0));
    }
}
