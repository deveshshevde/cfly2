package ir;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AndroidRuntimeException;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import ir.a;
import java.util.ArrayList;
import java.util.HashMap;

public class m extends a {

    /* renamed from: h  reason: collision with root package name */
    private static ThreadLocal<a> f29157h = new ThreadLocal<>();
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public static final ThreadLocal<ArrayList<m>> f29158i = new ThreadLocal<ArrayList<m>>() {
        /* access modifiers changed from: protected */
        /* renamed from: a */
        public ArrayList<m> initialValue() {
            return new ArrayList<>();
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public static final ThreadLocal<ArrayList<m>> f29159j = new ThreadLocal<ArrayList<m>>() {
        /* access modifiers changed from: protected */
        /* renamed from: a */
        public ArrayList<m> initialValue() {
            return new ArrayList<>();
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public static final ThreadLocal<ArrayList<m>> f29160k = new ThreadLocal<ArrayList<m>>() {
        /* access modifiers changed from: protected */
        /* renamed from: a */
        public ArrayList<m> initialValue() {
            return new ArrayList<>();
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public static final ThreadLocal<ArrayList<m>> f29161l = new ThreadLocal<ArrayList<m>>() {
        /* access modifiers changed from: protected */
        /* renamed from: a */
        public ArrayList<m> initialValue() {
            return new ArrayList<>();
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public static final ThreadLocal<ArrayList<m>> f29162m = new ThreadLocal<ArrayList<m>>() {
        /* access modifiers changed from: protected */
        /* renamed from: a */
        public ArrayList<m> initialValue() {
            return new ArrayList<>();
        }
    };

    /* renamed from: n  reason: collision with root package name */
    private static final Interpolator f29163n = new AccelerateDecelerateInterpolator();

    /* renamed from: o  reason: collision with root package name */
    private static final l f29164o = new f();

    /* renamed from: p  reason: collision with root package name */
    private static final l f29165p = new d();
    /* access modifiers changed from: private */

    /* renamed from: z  reason: collision with root package name */
    public static long f29166z = 10;
    private int A = 0;
    private int B = 1;
    private Interpolator C = f29163n;
    private ArrayList<b> D = null;

    /* renamed from: b  reason: collision with root package name */
    long f29167b;

    /* renamed from: c  reason: collision with root package name */
    long f29168c = -1;

    /* renamed from: d  reason: collision with root package name */
    int f29169d = 0;

    /* renamed from: e  reason: collision with root package name */
    boolean f29170e = false;

    /* renamed from: f  reason: collision with root package name */
    k[] f29171f;

    /* renamed from: g  reason: collision with root package name */
    HashMap<String, k> f29172g;

    /* renamed from: q  reason: collision with root package name */
    private boolean f29173q = false;

    /* renamed from: r  reason: collision with root package name */
    private int f29174r = 0;

    /* renamed from: s  reason: collision with root package name */
    private float f29175s = 0.0f;

    /* renamed from: t  reason: collision with root package name */
    private boolean f29176t = false;

    /* renamed from: u  reason: collision with root package name */
    private long f29177u;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public boolean f29178v = false;

    /* renamed from: w  reason: collision with root package name */
    private boolean f29179w = false;

    /* renamed from: x  reason: collision with root package name */
    private long f29180x = 300;
    /* access modifiers changed from: private */

    /* renamed from: y  reason: collision with root package name */
    public long f29181y = 0;

    private static class a extends Handler {
        private a() {
        }

        public void handleMessage(Message message) {
            boolean z2;
            ArrayList arrayList = (ArrayList) m.f29158i.get();
            ArrayList arrayList2 = (ArrayList) m.f29160k.get();
            int i2 = message.what;
            if (i2 == 0) {
                ArrayList arrayList3 = (ArrayList) m.f29159j.get();
                z2 = arrayList.size() <= 0 && arrayList2.size() <= 0;
                while (arrayList3.size() > 0) {
                    ArrayList arrayList4 = (ArrayList) arrayList3.clone();
                    arrayList3.clear();
                    int size = arrayList4.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        m mVar = (m) arrayList4.get(i3);
                        if (mVar.f29181y == 0) {
                            mVar.n();
                        } else {
                            arrayList2.add(mVar);
                        }
                    }
                }
            } else if (i2 == 1) {
                z2 = true;
            } else {
                return;
            }
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            ArrayList arrayList5 = (ArrayList) m.f29162m.get();
            ArrayList arrayList6 = (ArrayList) m.f29161l.get();
            int size2 = arrayList2.size();
            for (int i4 = 0; i4 < size2; i4++) {
                m mVar2 = (m) arrayList2.get(i4);
                if (mVar2.b(currentAnimationTimeMillis)) {
                    arrayList5.add(mVar2);
                }
            }
            int size3 = arrayList5.size();
            if (size3 > 0) {
                for (int i5 = 0; i5 < size3; i5++) {
                    m mVar3 = (m) arrayList5.get(i5);
                    mVar3.n();
                    boolean unused = mVar3.f29178v = true;
                    arrayList2.remove(mVar3);
                }
                arrayList5.clear();
            }
            int size4 = arrayList.size();
            int i6 = 0;
            while (i6 < size4) {
                m mVar4 = (m) arrayList.get(i6);
                if (mVar4.e(currentAnimationTimeMillis)) {
                    arrayList6.add(mVar4);
                }
                if (arrayList.size() == size4) {
                    i6++;
                } else {
                    size4--;
                    arrayList6.remove(mVar4);
                }
            }
            if (arrayList6.size() > 0) {
                for (int i7 = 0; i7 < arrayList6.size(); i7++) {
                    ((m) arrayList6.get(i7)).e();
                }
                arrayList6.clear();
            }
            if (!z2) {
                return;
            }
            if (!arrayList.isEmpty() || !arrayList2.isEmpty()) {
                sendEmptyMessageDelayed(1, Math.max(0, m.f29166z - (AnimationUtils.currentAnimationTimeMillis() - currentAnimationTimeMillis)));
            }
        }
    }

    public interface b {
        void a(m mVar);
    }

    private void a(boolean z2) {
        if (Looper.myLooper() != null) {
            this.f29173q = z2;
            this.f29174r = 0;
            this.f29169d = 0;
            this.f29179w = true;
            this.f29176t = false;
            f29159j.get().add(this);
            if (this.f29181y == 0) {
                d(g());
                this.f29169d = 0;
                this.f29178v = true;
                if (this.f29074a != null) {
                    ArrayList arrayList = (ArrayList) this.f29074a.clone();
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ((a.C0197a) arrayList.get(i2)).a(this);
                    }
                }
            }
            a aVar = f29157h.get();
            if (aVar == null) {
                aVar = new a();
                f29157h.set(aVar);
            }
            aVar.sendEmptyMessage(0);
            return;
        }
        throw new AndroidRuntimeException("Animators may only be run on Looper threads");
    }

    public static m b(float... fArr) {
        m mVar = new m();
        mVar.a(fArr);
        return mVar;
    }

    /* access modifiers changed from: private */
    public boolean b(long j2) {
        if (!this.f29176t) {
            this.f29176t = true;
            this.f29177u = j2;
            return false;
        }
        long j3 = j2 - this.f29177u;
        long j4 = this.f29181y;
        if (j3 <= j4) {
            return false;
        }
        this.f29167b = j2 - (j3 - j4);
        this.f29169d = 1;
        return true;
    }

    /* access modifiers changed from: private */
    public void e() {
        f29158i.get().remove(this);
        f29159j.get().remove(this);
        f29160k.get().remove(this);
        this.f29169d = 0;
        if (this.f29178v && this.f29074a != null) {
            ArrayList arrayList = (ArrayList) this.f29074a.clone();
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((a.C0197a) arrayList.get(i2)).b(this);
            }
        }
        this.f29178v = false;
        this.f29179w = false;
    }

    /* access modifiers changed from: private */
    public void n() {
        d();
        f29158i.get().add(this);
        if (this.f29181y > 0 && this.f29074a != null) {
            ArrayList arrayList = (ArrayList) this.f29074a.clone();
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((a.C0197a) arrayList.get(i2)).a(this);
            }
        }
    }

    public void a() {
        a(false);
    }

    /* access modifiers changed from: package-private */
    public void a(float f2) {
        float interpolation = this.C.getInterpolation(f2);
        this.f29175s = interpolation;
        for (k a2 : this.f29171f) {
            a2.a(interpolation);
        }
        ArrayList<b> arrayList = this.D;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.D.get(i2).a(this);
            }
        }
    }

    public void a(Interpolator interpolator) {
        if (interpolator == null) {
            interpolator = new LinearInterpolator();
        }
        this.C = interpolator;
    }

    public void a(float... fArr) {
        if (fArr != null && fArr.length != 0) {
            k[] kVarArr = this.f29171f;
            if (kVarArr == null || kVarArr.length == 0) {
                a(k.a("", fArr));
            } else {
                kVarArr[0].a(fArr);
            }
            this.f29170e = false;
        }
    }

    public void a(k... kVarArr) {
        this.f29171f = kVarArr;
        this.f29172g = new HashMap<>(r0);
        for (k kVar : kVarArr) {
            this.f29172g.put(kVar.c(), kVar);
        }
        this.f29170e = false;
    }

    /* renamed from: c */
    public m a(long j2) {
        if (j2 >= 0) {
            this.f29180x = j2;
            return this;
        }
        throw new IllegalArgumentException("Animators cannot have negative duration: " + j2);
    }

    /* access modifiers changed from: package-private */
    public void d() {
        if (!this.f29170e) {
            for (k b2 : this.f29171f) {
                b2.b();
            }
            this.f29170e = true;
        }
    }

    public void d(long j2) {
        d();
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (this.f29169d != 1) {
            this.f29168c = j2;
            this.f29169d = 2;
        }
        this.f29167b = currentAnimationTimeMillis - j2;
        e(currentAnimationTimeMillis);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x007e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean e(long r10) {
        /*
            r9 = this;
            int r0 = r9.f29169d
            r1 = 0
            r3 = 1
            if (r0 != 0) goto L_0x001a
            r9.f29169d = r3
            long r4 = r9.f29168c
            int r0 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0012
            r9.f29167b = r10
            goto L_0x001a
        L_0x0012:
            long r4 = r10 - r4
            r9.f29167b = r4
            r4 = -1
            r9.f29168c = r4
        L_0x001a:
            int r0 = r9.f29169d
            r4 = 2
            r5 = 0
            if (r0 == r3) goto L_0x0023
            if (r0 == r4) goto L_0x0023
            goto L_0x0084
        L_0x0023:
            long r6 = r9.f29180x
            r0 = 1065353216(0x3f800000, float:1.0)
            int r8 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r8 <= 0) goto L_0x0032
            long r1 = r9.f29167b
            long r10 = r10 - r1
            float r10 = (float) r10
            float r11 = (float) r6
            float r10 = r10 / r11
            goto L_0x0034
        L_0x0032:
            r10 = 1065353216(0x3f800000, float:1.0)
        L_0x0034:
            int r11 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r11 < 0) goto L_0x0079
            int r11 = r9.f29174r
            int r1 = r9.A
            if (r11 < r1) goto L_0x0047
            r11 = -1
            if (r1 != r11) goto L_0x0042
            goto L_0x0047
        L_0x0042:
            float r10 = java.lang.Math.min(r10, r0)
            goto L_0x007a
        L_0x0047:
            java.util.ArrayList r11 = r9.f29074a
            if (r11 == 0) goto L_0x0062
            java.util.ArrayList r11 = r9.f29074a
            int r11 = r11.size()
            r1 = 0
        L_0x0052:
            if (r1 >= r11) goto L_0x0062
            java.util.ArrayList r2 = r9.f29074a
            java.lang.Object r2 = r2.get(r1)
            ir.a$a r2 = (ir.a.C0197a) r2
            r2.c(r9)
            int r1 = r1 + 1
            goto L_0x0052
        L_0x0062:
            int r11 = r9.B
            if (r11 != r4) goto L_0x006b
            boolean r11 = r9.f29173q
            r11 = r11 ^ r3
            r9.f29173q = r11
        L_0x006b:
            int r11 = r9.f29174r
            int r1 = (int) r10
            int r11 = r11 + r1
            r9.f29174r = r11
            float r10 = r10 % r0
            long r1 = r9.f29167b
            long r3 = r9.f29180x
            long r1 = r1 + r3
            r9.f29167b = r1
        L_0x0079:
            r3 = 0
        L_0x007a:
            boolean r11 = r9.f29173q
            if (r11 == 0) goto L_0x0080
            float r10 = r0 - r10
        L_0x0080:
            r9.a((float) r10)
            r5 = r3
        L_0x0084:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.m.e(long):boolean");
    }

    /* renamed from: f */
    public m clone() {
        m mVar = (m) super.clone();
        ArrayList<b> arrayList = this.D;
        if (arrayList != null) {
            mVar.D = new ArrayList<>();
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                mVar.D.add(arrayList.get(i2));
            }
        }
        mVar.f29168c = -1;
        mVar.f29173q = false;
        mVar.f29174r = 0;
        mVar.f29170e = false;
        mVar.f29169d = 0;
        mVar.f29176t = false;
        k[] kVarArr = this.f29171f;
        if (kVarArr != null) {
            int length = kVarArr.length;
            mVar.f29171f = new k[length];
            mVar.f29172g = new HashMap<>(length);
            for (int i3 = 0; i3 < length; i3++) {
                k a2 = kVarArr[i3].clone();
                mVar.f29171f[i3] = a2;
                mVar.f29172g.put(a2.c(), a2);
            }
        }
        return mVar;
    }

    public long g() {
        if (!this.f29170e || this.f29169d == 0) {
            return 0;
        }
        return AnimationUtils.currentAnimationTimeMillis() - this.f29167b;
    }

    public String toString() {
        String str = "ValueAnimator@" + Integer.toHexString(hashCode());
        if (this.f29171f != null) {
            for (int i2 = 0; i2 < this.f29171f.length; i2++) {
                str = str + "\n    " + this.f29171f[i2].toString();
            }
        }
        return str;
    }
}
