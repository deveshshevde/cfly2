package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.constant.MemoryConstants;
import java.util.Arrays;
import u.c;

public class GridLayoutManager extends LinearLayoutManager {

    /* renamed from: a  reason: collision with root package name */
    boolean f3831a = false;

    /* renamed from: b  reason: collision with root package name */
    int f3832b = -1;

    /* renamed from: c  reason: collision with root package name */
    int[] f3833c;

    /* renamed from: d  reason: collision with root package name */
    View[] f3834d;

    /* renamed from: e  reason: collision with root package name */
    final SparseIntArray f3835e = new SparseIntArray();

    /* renamed from: f  reason: collision with root package name */
    final SparseIntArray f3836f = new SparseIntArray();

    /* renamed from: g  reason: collision with root package name */
    b f3837g = new a();

    /* renamed from: h  reason: collision with root package name */
    final Rect f3838h = new Rect();

    /* renamed from: z  reason: collision with root package name */
    private boolean f3839z;

    public static class LayoutParams extends RecyclerView.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        int f3840a = -1;

        /* renamed from: b  reason: collision with root package name */
        int f3841b = 0;

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

        public int a() {
            return this.f3840a;
        }

        public int b() {
            return this.f3841b;
        }
    }

    public static final class a extends b {
        public int getSpanIndex(int i2, int i3) {
            return i2 % i3;
        }

        public int getSpanSize(int i2) {
            return 1;
        }
    }

    public static abstract class b {
        private boolean mCacheSpanGroupIndices = false;
        private boolean mCacheSpanIndices = false;
        final SparseIntArray mSpanGroupIndexCache = new SparseIntArray();
        final SparseIntArray mSpanIndexCache = new SparseIntArray();

        static int findFirstKeyLessThan(SparseIntArray sparseIntArray, int i2) {
            int size = sparseIntArray.size() - 1;
            int i3 = 0;
            while (i3 <= size) {
                int i4 = (i3 + size) >>> 1;
                if (sparseIntArray.keyAt(i4) < i2) {
                    i3 = i4 + 1;
                } else {
                    size = i4 - 1;
                }
            }
            int i5 = i3 - 1;
            if (i5 < 0 || i5 >= sparseIntArray.size()) {
                return -1;
            }
            return sparseIntArray.keyAt(i5);
        }

        /* access modifiers changed from: package-private */
        public int getCachedSpanGroupIndex(int i2, int i3) {
            if (!this.mCacheSpanGroupIndices) {
                return getSpanGroupIndex(i2, i3);
            }
            int i4 = this.mSpanGroupIndexCache.get(i2, -1);
            if (i4 != -1) {
                return i4;
            }
            int spanGroupIndex = getSpanGroupIndex(i2, i3);
            this.mSpanGroupIndexCache.put(i2, spanGroupIndex);
            return spanGroupIndex;
        }

        /* access modifiers changed from: package-private */
        public int getCachedSpanIndex(int i2, int i3) {
            if (!this.mCacheSpanIndices) {
                return getSpanIndex(i2, i3);
            }
            int i4 = this.mSpanIndexCache.get(i2, -1);
            if (i4 != -1) {
                return i4;
            }
            int spanIndex = getSpanIndex(i2, i3);
            this.mSpanIndexCache.put(i2, spanIndex);
            return spanIndex;
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x002d  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0043  */
        /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int getSpanGroupIndex(int r7, int r8) {
            /*
                r6 = this;
                boolean r0 = r6.mCacheSpanGroupIndices
                r1 = 0
                if (r0 == 0) goto L_0x0024
                android.util.SparseIntArray r0 = r6.mSpanGroupIndexCache
                int r0 = findFirstKeyLessThan(r0, r7)
                r2 = -1
                if (r0 == r2) goto L_0x0024
                android.util.SparseIntArray r2 = r6.mSpanGroupIndexCache
                int r2 = r2.get(r0)
                int r3 = r0 + 1
                int r4 = r6.getCachedSpanIndex(r0, r8)
                int r0 = r6.getSpanSize(r0)
                int r4 = r4 + r0
                if (r4 != r8) goto L_0x0027
                int r2 = r2 + 1
                goto L_0x0026
            L_0x0024:
                r2 = 0
                r3 = 0
            L_0x0026:
                r4 = 0
            L_0x0027:
                int r0 = r6.getSpanSize(r7)
            L_0x002b:
                if (r3 >= r7) goto L_0x0040
                int r5 = r6.getSpanSize(r3)
                int r4 = r4 + r5
                if (r4 != r8) goto L_0x0038
                int r2 = r2 + 1
                r4 = 0
                goto L_0x003d
            L_0x0038:
                if (r4 <= r8) goto L_0x003d
                int r2 = r2 + 1
                r4 = r5
            L_0x003d:
                int r3 = r3 + 1
                goto L_0x002b
            L_0x0040:
                int r4 = r4 + r0
                if (r4 <= r8) goto L_0x0045
                int r2 = r2 + 1
            L_0x0045:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.b.getSpanGroupIndex(int, int):int");
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x0024  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int getSpanIndex(int r6, int r7) {
            /*
                r5 = this;
                int r0 = r5.getSpanSize(r6)
                r1 = 0
                if (r0 != r7) goto L_0x0008
                return r1
            L_0x0008:
                boolean r2 = r5.mCacheSpanIndices
                if (r2 == 0) goto L_0x0020
                android.util.SparseIntArray r2 = r5.mSpanIndexCache
                int r2 = findFirstKeyLessThan(r2, r6)
                if (r2 < 0) goto L_0x0020
                android.util.SparseIntArray r3 = r5.mSpanIndexCache
                int r3 = r3.get(r2)
                int r4 = r5.getSpanSize(r2)
                int r3 = r3 + r4
                goto L_0x0030
            L_0x0020:
                r2 = 0
                r3 = 0
            L_0x0022:
                if (r2 >= r6) goto L_0x0033
                int r4 = r5.getSpanSize(r2)
                int r3 = r3 + r4
                if (r3 != r7) goto L_0x002d
                r3 = 0
                goto L_0x0030
            L_0x002d:
                if (r3 <= r7) goto L_0x0030
                r3 = r4
            L_0x0030:
                int r2 = r2 + 1
                goto L_0x0022
            L_0x0033:
                int r0 = r0 + r3
                if (r0 > r7) goto L_0x0037
                return r3
            L_0x0037:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.b.getSpanIndex(int, int):int");
        }

        public abstract int getSpanSize(int i2);

        public void invalidateSpanGroupIndexCache() {
            this.mSpanGroupIndexCache.clear();
        }

        public void invalidateSpanIndexCache() {
            this.mSpanIndexCache.clear();
        }

        public boolean isSpanGroupIndexCacheEnabled() {
            return this.mCacheSpanGroupIndices;
        }

        public boolean isSpanIndexCacheEnabled() {
            return this.mCacheSpanIndices;
        }

        public void setSpanGroupIndexCacheEnabled(boolean z2) {
            if (!z2) {
                this.mSpanGroupIndexCache.clear();
            }
            this.mCacheSpanGroupIndices = z2;
        }

        public void setSpanIndexCacheEnabled(boolean z2) {
            if (!z2) {
                this.mSpanGroupIndexCache.clear();
            }
            this.mCacheSpanIndices = z2;
        }
    }

    public GridLayoutManager(Context context, int i2) {
        super(context);
        a(i2);
    }

    public GridLayoutManager(Context context, int i2, int i3, boolean z2) {
        super(context, i3, z2);
        a(i2);
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        a(a(context, attributeSet, i2, i3).f3982b);
    }

    private void P() {
        this.f3835e.clear();
        this.f3836f.clear();
    }

    private void Q() {
        int z2 = z();
        for (int i2 = 0; i2 < z2; i2++) {
            LayoutParams layoutParams = (LayoutParams) i(i2).getLayoutParams();
            int f2 = layoutParams.f();
            this.f3835e.put(f2, layoutParams.b());
            this.f3836f.put(f2, layoutParams.a());
        }
    }

    private void R() {
        int i2;
        int i3;
        if (h() == 1) {
            i3 = C() - G();
            i2 = E();
        } else {
            i3 = D() - H();
            i2 = F();
        }
        m(i3 - i2);
    }

    private void S() {
        View[] viewArr = this.f3834d;
        if (viewArr == null || viewArr.length != this.f3832b) {
            this.f3834d = new View[this.f3832b];
        }
    }

    private int a(RecyclerView.n nVar, RecyclerView.s sVar, int i2) {
        if (!sVar.a()) {
            return this.f3837g.getCachedSpanGroupIndex(i2, this.f3832b);
        }
        int b2 = nVar.b(i2);
        if (b2 != -1) {
            return this.f3837g.getCachedSpanGroupIndex(b2, this.f3832b);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i2);
        return 0;
    }

    private void a(float f2, int i2) {
        m(Math.max(Math.round(f2 * ((float) this.f3832b)), i2));
    }

    private void a(View view, int i2, int i3, boolean z2) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (z2 ? a(view, i2, i3, layoutParams) : b(view, i2, i3, layoutParams)) {
            view.measure(i2, i3);
        }
    }

    private void a(View view, int i2, boolean z2) {
        int i3;
        int i4;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect = layoutParams.f3946d;
        int i5 = rect.top + rect.bottom + layoutParams.topMargin + layoutParams.bottomMargin;
        int i6 = rect.left + rect.right + layoutParams.leftMargin + layoutParams.rightMargin;
        int a2 = a(layoutParams.f3840a, layoutParams.f3841b);
        if (this.f3850i == 1) {
            i3 = a(a2, i2, i6, layoutParams.width, false);
            i4 = a(this.f3851j.f(), B(), i5, layoutParams.height, true);
        } else {
            int a3 = a(a2, i2, i5, layoutParams.height, false);
            int a4 = a(this.f3851j.f(), A(), i6, layoutParams.width, true);
            i4 = a3;
            i3 = a4;
        }
        a(view, i3, i4, z2);
    }

    private void a(RecyclerView.n nVar, RecyclerView.s sVar, int i2, boolean z2) {
        int i3;
        int i4;
        int i5 = 0;
        int i6 = -1;
        if (z2) {
            i6 = i2;
            i4 = 0;
            i3 = 1;
        } else {
            i4 = i2 - 1;
            i3 = -1;
        }
        while (i4 != i6) {
            View view = this.f3834d[i4];
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.f3841b = c(nVar, sVar, d(view));
            layoutParams.f3840a = i5;
            i5 += layoutParams.f3841b;
            i4 += i3;
        }
    }

    static int[] a(int[] iArr, int i2, int i3) {
        int i4;
        if (!(iArr != null && iArr.length == i2 + 1 && iArr[iArr.length - 1] == i3)) {
            iArr = new int[(i2 + 1)];
        }
        int i5 = 0;
        iArr[0] = 0;
        int i6 = i3 / i2;
        int i7 = i3 % i2;
        int i8 = 0;
        for (int i9 = 1; i9 <= i2; i9++) {
            i5 += i7;
            if (i5 <= 0 || i2 - i5 >= i7) {
                i4 = i6;
            } else {
                i4 = i6 + 1;
                i5 -= i2;
            }
            i8 += i4;
            iArr[i9] = i8;
        }
        return iArr;
    }

    private int b(RecyclerView.n nVar, RecyclerView.s sVar, int i2) {
        if (!sVar.a()) {
            return this.f3837g.getCachedSpanIndex(i2, this.f3832b);
        }
        int i3 = this.f3836f.get(i2, -1);
        if (i3 != -1) {
            return i3;
        }
        int b2 = nVar.b(i2);
        if (b2 != -1) {
            return this.f3837g.getCachedSpanIndex(b2, this.f3832b);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i2);
        return 0;
    }

    private void b(RecyclerView.n nVar, RecyclerView.s sVar, LinearLayoutManager.a aVar, int i2) {
        boolean z2 = i2 == 1;
        int b2 = b(nVar, sVar, aVar.f3862b);
        if (z2) {
            while (b2 > 0 && aVar.f3862b > 0) {
                aVar.f3862b--;
                b2 = b(nVar, sVar, aVar.f3862b);
            }
            return;
        }
        int e2 = sVar.e() - 1;
        int i3 = aVar.f3862b;
        while (i3 < e2) {
            int i4 = i3 + 1;
            int b3 = b(nVar, sVar, i4);
            if (b3 <= b2) {
                break;
            }
            i3 = i4;
            b2 = b3;
        }
        aVar.f3862b = i3;
    }

    private int c(RecyclerView.n nVar, RecyclerView.s sVar, int i2) {
        if (!sVar.a()) {
            return this.f3837g.getSpanSize(i2);
        }
        int i3 = this.f3835e.get(i2, -1);
        if (i3 != -1) {
            return i3;
        }
        int b2 = nVar.b(i2);
        if (b2 != -1) {
            return this.f3837g.getSpanSize(b2);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i2);
        return 1;
    }

    private int i(RecyclerView.s sVar) {
        if (!(z() == 0 || sVar.e() == 0)) {
            j();
            View a2 = a(!l(), true);
            View b2 = b(!l(), true);
            if (!(a2 == null || b2 == null)) {
                if (!l()) {
                    return this.f3837g.getCachedSpanGroupIndex(sVar.e() - 1, this.f3832b) + 1;
                }
                int b3 = this.f3851j.b(b2) - this.f3851j.a(a2);
                int cachedSpanGroupIndex = this.f3837g.getCachedSpanGroupIndex(d(a2), this.f3832b);
                return (int) ((((float) b3) / ((float) ((this.f3837g.getCachedSpanGroupIndex(d(b2), this.f3832b) - cachedSpanGroupIndex) + 1))) * ((float) (this.f3837g.getCachedSpanGroupIndex(sVar.e() - 1, this.f3832b) + 1)));
            }
        }
        return 0;
    }

    private int j(RecyclerView.s sVar) {
        if (!(z() == 0 || sVar.e() == 0)) {
            j();
            boolean l2 = l();
            View a2 = a(!l2, true);
            View b2 = b(!l2, true);
            if (!(a2 == null || b2 == null)) {
                int cachedSpanGroupIndex = this.f3837g.getCachedSpanGroupIndex(d(a2), this.f3832b);
                int cachedSpanGroupIndex2 = this.f3837g.getCachedSpanGroupIndex(d(b2), this.f3832b);
                int min = Math.min(cachedSpanGroupIndex, cachedSpanGroupIndex2);
                int max = this.f3852k ? Math.max(0, ((this.f3837g.getCachedSpanGroupIndex(sVar.e() - 1, this.f3832b) + 1) - Math.max(cachedSpanGroupIndex, cachedSpanGroupIndex2)) - 1) : Math.max(0, min);
                if (!l2) {
                    return max;
                }
                return Math.round((((float) max) * (((float) Math.abs(this.f3851j.b(b2) - this.f3851j.a(a2))) / ((float) ((this.f3837g.getCachedSpanGroupIndex(d(b2), this.f3832b) - this.f3837g.getCachedSpanGroupIndex(d(a2), this.f3832b)) + 1)))) + ((float) (this.f3851j.c() - this.f3851j.a(a2))));
            }
        }
        return 0;
    }

    private void m(int i2) {
        this.f3833c = a(this.f3833c, this.f3832b, i2);
    }

    /* access modifiers changed from: package-private */
    public int a(int i2, int i3) {
        if (this.f3850i != 1 || !i()) {
            int[] iArr = this.f3833c;
            return iArr[i3 + i2] - iArr[i2];
        }
        int[] iArr2 = this.f3833c;
        int i4 = this.f3832b;
        return iArr2[i4 - i2] - iArr2[(i4 - i2) - i3];
    }

    public int a(int i2, RecyclerView.n nVar, RecyclerView.s sVar) {
        R();
        S();
        return super.a(i2, nVar, sVar);
    }

    public int a(RecyclerView.n nVar, RecyclerView.s sVar) {
        if (this.f3850i == 0) {
            return this.f3832b;
        }
        if (sVar.e() < 1) {
            return 0;
        }
        return a(nVar, sVar, sVar.e() - 1) + 1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00d8, code lost:
        if (r13 == (r2 > r15)) goto L_0x00b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00f8, code lost:
        if (r13 == r8) goto L_0x00bc;
     */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0109  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View a(android.view.View r23, int r24, androidx.recyclerview.widget.RecyclerView.n r25, androidx.recyclerview.widget.RecyclerView.s r26) {
        /*
            r22 = this;
            r0 = r22
            r1 = r25
            r2 = r26
            android.view.View r3 = r22.e((android.view.View) r23)
            r4 = 0
            if (r3 != 0) goto L_0x000e
            return r4
        L_0x000e:
            android.view.ViewGroup$LayoutParams r5 = r3.getLayoutParams()
            androidx.recyclerview.widget.GridLayoutManager$LayoutParams r5 = (androidx.recyclerview.widget.GridLayoutManager.LayoutParams) r5
            int r6 = r5.f3840a
            int r7 = r5.f3840a
            int r5 = r5.f3841b
            int r7 = r7 + r5
            android.view.View r5 = super.a((android.view.View) r23, (int) r24, (androidx.recyclerview.widget.RecyclerView.n) r25, (androidx.recyclerview.widget.RecyclerView.s) r26)
            if (r5 != 0) goto L_0x0022
            return r4
        L_0x0022:
            r5 = r24
            int r5 = r0.f((int) r5)
            r9 = 1
            if (r5 != r9) goto L_0x002d
            r5 = 1
            goto L_0x002e
        L_0x002d:
            r5 = 0
        L_0x002e:
            boolean r10 = r0.f3852k
            if (r5 == r10) goto L_0x0034
            r5 = 1
            goto L_0x0035
        L_0x0034:
            r5 = 0
        L_0x0035:
            r10 = -1
            if (r5 == 0) goto L_0x0040
            int r5 = r22.z()
            int r5 = r5 - r9
            r11 = -1
            r12 = -1
            goto L_0x0047
        L_0x0040:
            int r5 = r22.z()
            r11 = r5
            r5 = 0
            r12 = 1
        L_0x0047:
            int r13 = r0.f3850i
            if (r13 != r9) goto L_0x0053
            boolean r13 = r22.i()
            if (r13 == 0) goto L_0x0053
            r13 = 1
            goto L_0x0054
        L_0x0053:
            r13 = 0
        L_0x0054:
            int r14 = r0.a((androidx.recyclerview.widget.RecyclerView.n) r1, (androidx.recyclerview.widget.RecyclerView.s) r2, (int) r5)
            r10 = r5
            r8 = 0
            r15 = -1
            r16 = -1
            r17 = 0
            r5 = r4
        L_0x0060:
            if (r10 == r11) goto L_0x014a
            int r9 = r0.a((androidx.recyclerview.widget.RecyclerView.n) r1, (androidx.recyclerview.widget.RecyclerView.s) r2, (int) r10)
            android.view.View r1 = r0.i((int) r10)
            if (r1 != r3) goto L_0x006e
            goto L_0x014a
        L_0x006e:
            boolean r18 = r1.hasFocusable()
            if (r18 == 0) goto L_0x0088
            if (r9 == r14) goto L_0x0088
            if (r4 == 0) goto L_0x007a
            goto L_0x014a
        L_0x007a:
            r18 = r3
            r20 = r5
            r23 = r8
            r19 = r11
            r11 = r16
            r5 = r17
            goto L_0x0136
        L_0x0088:
            android.view.ViewGroup$LayoutParams r9 = r1.getLayoutParams()
            androidx.recyclerview.widget.GridLayoutManager$LayoutParams r9 = (androidx.recyclerview.widget.GridLayoutManager.LayoutParams) r9
            int r2 = r9.f3840a
            r18 = r3
            int r3 = r9.f3840a
            r19 = r11
            int r11 = r9.f3841b
            int r3 = r3 + r11
            boolean r11 = r1.hasFocusable()
            if (r11 == 0) goto L_0x00a4
            if (r2 != r6) goto L_0x00a4
            if (r3 != r7) goto L_0x00a4
            return r1
        L_0x00a4:
            boolean r11 = r1.hasFocusable()
            if (r11 == 0) goto L_0x00ac
            if (r4 == 0) goto L_0x00b4
        L_0x00ac:
            boolean r11 = r1.hasFocusable()
            if (r11 != 0) goto L_0x00be
            if (r5 != 0) goto L_0x00be
        L_0x00b4:
            r20 = r5
            r23 = r8
            r11 = r16
            r5 = r17
        L_0x00bc:
            r8 = 1
            goto L_0x0107
        L_0x00be:
            int r11 = java.lang.Math.max(r2, r6)
            int r20 = java.lang.Math.min(r3, r7)
            int r11 = r20 - r11
            boolean r20 = r1.hasFocusable()
            if (r20 == 0) goto L_0x00db
            if (r11 <= r8) goto L_0x00d1
            goto L_0x00b4
        L_0x00d1:
            if (r11 != r8) goto L_0x00fe
            if (r2 <= r15) goto L_0x00d7
            r11 = 1
            goto L_0x00d8
        L_0x00d7:
            r11 = 0
        L_0x00d8:
            if (r13 != r11) goto L_0x00fe
            goto L_0x00b4
        L_0x00db:
            if (r4 != 0) goto L_0x00fe
            r20 = r5
            r23 = r8
            r5 = 0
            r8 = 1
            boolean r21 = r0.a((android.view.View) r1, (boolean) r5, (boolean) r8)
            if (r21 == 0) goto L_0x0102
            r5 = r17
            if (r11 <= r5) goto L_0x00f0
            r11 = r16
            goto L_0x0107
        L_0x00f0:
            if (r11 != r5) goto L_0x00fb
            r11 = r16
            if (r2 <= r11) goto L_0x00f7
            goto L_0x00f8
        L_0x00f7:
            r8 = 0
        L_0x00f8:
            if (r13 != r8) goto L_0x0106
            goto L_0x00bc
        L_0x00fb:
            r11 = r16
            goto L_0x0106
        L_0x00fe:
            r20 = r5
            r23 = r8
        L_0x0102:
            r11 = r16
            r5 = r17
        L_0x0106:
            r8 = 0
        L_0x0107:
            if (r8 == 0) goto L_0x0136
            boolean r8 = r1.hasFocusable()
            if (r8 == 0) goto L_0x0124
            int r4 = r9.f3840a
            int r3 = java.lang.Math.min(r3, r7)
            int r2 = java.lang.Math.max(r2, r6)
            int r8 = r3 - r2
            r15 = r4
            r17 = r5
            r16 = r11
            r5 = r20
            r4 = r1
            goto L_0x013e
        L_0x0124:
            int r5 = r9.f3840a
            int r3 = java.lang.Math.min(r3, r7)
            int r2 = java.lang.Math.max(r2, r6)
            int r17 = r3 - r2
            r8 = r23
            r16 = r5
            r5 = r1
            goto L_0x013e
        L_0x0136:
            r8 = r23
            r17 = r5
            r16 = r11
            r5 = r20
        L_0x013e:
            int r10 = r10 + r12
            r1 = r25
            r2 = r26
            r3 = r18
            r11 = r19
            r9 = 1
            goto L_0x0060
        L_0x014a:
            r20 = r5
            if (r4 == 0) goto L_0x014f
            goto L_0x0151
        L_0x014f:
            r4 = r20
        L_0x0151:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.a(android.view.View, int, androidx.recyclerview.widget.RecyclerView$n, androidx.recyclerview.widget.RecyclerView$s):android.view.View");
    }

    /* access modifiers changed from: package-private */
    public View a(RecyclerView.n nVar, RecyclerView.s sVar, boolean z2, boolean z3) {
        int i2;
        int z4 = z();
        int i3 = -1;
        int i4 = 1;
        if (z3) {
            i2 = z() - 1;
            i4 = -1;
        } else {
            i3 = z4;
            i2 = 0;
        }
        int e2 = sVar.e();
        j();
        int c2 = this.f3851j.c();
        int d2 = this.f3851j.d();
        View view = null;
        View view2 = null;
        while (i2 != i3) {
            View i5 = i(i2);
            int d3 = d(i5);
            if (d3 >= 0 && d3 < e2 && b(nVar, sVar, d3) == 0) {
                if (((RecyclerView.LayoutParams) i5.getLayoutParams()).d()) {
                    if (view2 == null) {
                        view2 = i5;
                    }
                } else if (this.f3851j.a(i5) < d2 && this.f3851j.b(i5) >= c2) {
                    return i5;
                } else {
                    if (view == null) {
                        view = i5;
                    }
                }
            }
            i2 += i4;
        }
        return view != null ? view : view2;
    }

    public RecyclerView.LayoutParams a() {
        return this.f3850i == 0 ? new LayoutParams(-2, -1) : new LayoutParams(-1, -2);
    }

    public RecyclerView.LayoutParams a(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    public RecyclerView.LayoutParams a(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public void a(int i2) {
        if (i2 != this.f3832b) {
            this.f3831a = true;
            if (i2 >= 1) {
                this.f3832b = i2;
                this.f3837g.invalidateSpanIndexCache();
                s();
                return;
            }
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + i2);
        }
    }

    public void a(Rect rect, int i2, int i3) {
        int i4;
        int i5;
        if (this.f3833c == null) {
            super.a(rect, i2, i3);
        }
        int E = E() + G();
        int F = F() + H();
        if (this.f3850i == 1) {
            i5 = a(i3, rect.height() + F, L());
            int[] iArr = this.f3833c;
            i4 = a(i2, iArr[iArr.length - 1] + E, K());
        } else {
            i4 = a(i2, rect.width() + E, K());
            int[] iArr2 = this.f3833c;
            i5 = a(i3, iArr2[iArr2.length - 1] + F, L());
        }
        g(i4, i5);
    }

    public void a(b bVar) {
        this.f3837g = bVar;
    }

    public void a(RecyclerView.n nVar, RecyclerView.s sVar, View view, c cVar) {
        boolean z2;
        boolean z3;
        int i2;
        int i3;
        int i4;
        int i5;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            super.a(view, cVar);
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        int a2 = a(nVar, sVar, layoutParams2.f());
        if (this.f3850i == 0) {
            i5 = layoutParams2.a();
            i4 = layoutParams2.b();
            i2 = 1;
            z3 = false;
            z2 = false;
            i3 = a2;
        } else {
            i4 = 1;
            i3 = layoutParams2.a();
            i2 = layoutParams2.b();
            z3 = false;
            z2 = false;
            i5 = a2;
        }
        cVar.b((Object) c.C0258c.a(i5, i4, i3, i2, z3, z2));
    }

    /* access modifiers changed from: package-private */
    public void a(RecyclerView.n nVar, RecyclerView.s sVar, LinearLayoutManager.a aVar, int i2) {
        super.a(nVar, sVar, aVar, i2);
        R();
        if (sVar.e() > 0 && !sVar.a()) {
            b(nVar, sVar, aVar, i2);
        }
        S();
    }

    /* access modifiers changed from: package-private */
    public void a(RecyclerView.n nVar, RecyclerView.s sVar, LinearLayoutManager.c cVar, LinearLayoutManager.b bVar) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        View a2;
        RecyclerView.n nVar2 = nVar;
        RecyclerView.s sVar2 = sVar;
        LinearLayoutManager.c cVar2 = cVar;
        LinearLayoutManager.b bVar2 = bVar;
        int i12 = this.f3851j.i();
        boolean z2 = false;
        boolean z3 = i12 != 1073741824;
        int i13 = z() > 0 ? this.f3833c[this.f3832b] : 0;
        if (z3) {
            R();
        }
        boolean z4 = cVar2.f3874e == 1;
        int i14 = this.f3832b;
        if (!z4) {
            i14 = b(nVar2, sVar2, cVar2.f3873d) + c(nVar2, sVar2, cVar2.f3873d);
        }
        int i15 = 0;
        while (i15 < this.f3832b && cVar2.a(sVar2) && i14 > 0) {
            int i16 = cVar2.f3873d;
            int c2 = c(nVar2, sVar2, i16);
            if (c2 <= this.f3832b) {
                i14 -= c2;
                if (i14 < 0 || (a2 = cVar2.a(nVar2)) == null) {
                    break;
                }
                this.f3834d[i15] = a2;
                i15++;
            } else {
                throw new IllegalArgumentException("Item at position " + i16 + " requires " + c2 + " spans but GridLayoutManager has only " + this.f3832b + " spans.");
            }
        }
        if (i15 == 0) {
            bVar2.f3867b = true;
            return;
        }
        float f2 = 0.0f;
        a(nVar2, sVar2, i15, z4);
        int i17 = 0;
        int i18 = 0;
        while (i17 < i15) {
            View view = this.f3834d[i17];
            if (cVar2.f3881l == null) {
                if (z4) {
                    b(view);
                } else {
                    b(view, (int) z2);
                }
            } else if (z4) {
                a(view);
            } else {
                a(view, z2 ? 1 : 0);
            }
            b(view, this.f3838h);
            a(view, i12, z2);
            int e2 = this.f3851j.e(view);
            if (e2 > i18) {
                i18 = e2;
            }
            float f3 = (((float) this.f3851j.f(view)) * 1.0f) / ((float) ((LayoutParams) view.getLayoutParams()).f3841b);
            if (f3 > f2) {
                f2 = f3;
            }
            i17++;
            z2 = false;
        }
        if (z3) {
            a(f2, i13);
            i18 = 0;
            for (int i19 = 0; i19 < i15; i19++) {
                View view2 = this.f3834d[i19];
                a(view2, (int) MemoryConstants.GB, true);
                int e3 = this.f3851j.e(view2);
                if (e3 > i18) {
                    i18 = e3;
                }
            }
        }
        for (int i20 = 0; i20 < i15; i20++) {
            View view3 = this.f3834d[i20];
            if (this.f3851j.e(view3) != i18) {
                LayoutParams layoutParams = (LayoutParams) view3.getLayoutParams();
                Rect rect = layoutParams.f3946d;
                int i21 = rect.top + rect.bottom + layoutParams.topMargin + layoutParams.bottomMargin;
                int i22 = rect.left + rect.right + layoutParams.leftMargin + layoutParams.rightMargin;
                int a3 = a(layoutParams.f3840a, layoutParams.f3841b);
                if (this.f3850i == 1) {
                    i11 = a(a3, (int) MemoryConstants.GB, i22, layoutParams.width, false);
                    i10 = View.MeasureSpec.makeMeasureSpec(i18 - i21, MemoryConstants.GB);
                } else {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i18 - i22, MemoryConstants.GB);
                    i10 = a(a3, (int) MemoryConstants.GB, i21, layoutParams.height, false);
                    i11 = makeMeasureSpec;
                }
                a(view3, i11, i10, true);
            }
        }
        int i23 = 0;
        bVar2.f3866a = i18;
        if (this.f3850i == 1) {
            if (cVar2.f3875f == -1) {
                i5 = cVar2.f3871b;
                i2 = i5 - i18;
            } else {
                int i24 = cVar2.f3871b;
                i2 = i24;
                i5 = i18 + i24;
            }
            i4 = 0;
            i3 = 0;
        } else if (cVar2.f3875f == -1) {
            int i25 = cVar2.f3871b;
            i3 = i25 - i18;
            i2 = 0;
            i4 = i25;
            i5 = 0;
        } else {
            int i26 = cVar2.f3871b;
            i4 = i18 + i26;
            i3 = i26;
            i5 = 0;
            i2 = 0;
        }
        while (i23 < i15) {
            View view4 = this.f3834d[i23];
            LayoutParams layoutParams2 = (LayoutParams) view4.getLayoutParams();
            if (this.f3850i == 1) {
                if (i()) {
                    int E = E() + this.f3833c[this.f3832b - layoutParams2.f3840a];
                    i9 = i5;
                    i8 = E;
                    i7 = E - this.f3851j.f(view4);
                } else {
                    int E2 = E() + this.f3833c[layoutParams2.f3840a];
                    i9 = i5;
                    i7 = E2;
                    i8 = this.f3851j.f(view4) + E2;
                }
                i6 = i2;
            } else {
                int F = F() + this.f3833c[layoutParams2.f3840a];
                i6 = F;
                i8 = i4;
                i7 = i3;
                i9 = this.f3851j.f(view4) + F;
            }
            a(view4, i7, i6, i8, i9);
            if (layoutParams2.d() || layoutParams2.e()) {
                bVar2.f3868c = true;
            }
            bVar2.f3869d |= view4.hasFocusable();
            i23++;
            i5 = i9;
            i4 = i8;
            i3 = i7;
            i2 = i6;
        }
        Arrays.fill(this.f3834d, (Object) null);
    }

    public void a(RecyclerView.s sVar) {
        super.a(sVar);
        this.f3831a = false;
    }

    /* access modifiers changed from: package-private */
    public void a(RecyclerView.s sVar, LinearLayoutManager.c cVar, RecyclerView.h.a aVar) {
        int i2 = this.f3832b;
        for (int i3 = 0; i3 < this.f3832b && cVar.a(sVar) && i2 > 0; i3++) {
            int i4 = cVar.f3873d;
            aVar.b(i4, Math.max(0, cVar.f3876g));
            i2 -= this.f3837g.getSpanSize(i4);
            cVar.f3873d += cVar.f3874e;
        }
    }

    public void a(RecyclerView recyclerView) {
        this.f3837g.invalidateSpanIndexCache();
        this.f3837g.invalidateSpanGroupIndexCache();
    }

    public void a(RecyclerView recyclerView, int i2, int i3) {
        this.f3837g.invalidateSpanIndexCache();
        this.f3837g.invalidateSpanGroupIndexCache();
    }

    public void a(RecyclerView recyclerView, int i2, int i3, int i4) {
        this.f3837g.invalidateSpanIndexCache();
        this.f3837g.invalidateSpanGroupIndexCache();
    }

    public void a(RecyclerView recyclerView, int i2, int i3, Object obj) {
        this.f3837g.invalidateSpanIndexCache();
        this.f3837g.invalidateSpanGroupIndexCache();
    }

    public void a(boolean z2) {
        if (!z2) {
            super.a(false);
            return;
        }
        throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
    }

    public boolean a(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public int b() {
        return this.f3832b;
    }

    public int b(int i2, RecyclerView.n nVar, RecyclerView.s sVar) {
        R();
        S();
        return super.b(i2, nVar, sVar);
    }

    public int b(RecyclerView.n nVar, RecyclerView.s sVar) {
        if (this.f3850i == 1) {
            return this.f3832b;
        }
        if (sVar.e() < 1) {
            return 0;
        }
        return a(nVar, sVar, sVar.e() - 1) + 1;
    }

    public int b(RecyclerView.s sVar) {
        return this.f3839z ? i(sVar) : super.b(sVar);
    }

    public void b(RecyclerView recyclerView, int i2, int i3) {
        this.f3837g.invalidateSpanIndexCache();
        this.f3837g.invalidateSpanGroupIndexCache();
    }

    public int c(RecyclerView.s sVar) {
        return this.f3839z ? i(sVar) : super.c(sVar);
    }

    public void c(RecyclerView.n nVar, RecyclerView.s sVar) {
        if (sVar.a()) {
            Q();
        }
        super.c(nVar, sVar);
        P();
    }

    public boolean c() {
        return this.f3855n == null && !this.f3831a;
    }

    public int d(RecyclerView.s sVar) {
        return this.f3839z ? j(sVar) : super.d(sVar);
    }

    public int e(RecyclerView.s sVar) {
        return this.f3839z ? j(sVar) : super.e(sVar);
    }
}
