package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.amap.api.mapcore.util.bd;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import java.io.File;

public final class al extends OfflineMapCity implements au, bl {
    public static final Parcelable.Creator<al> CREATOR = new Parcelable.Creator<al>() {
        private static al a(Parcel parcel) {
            return new al(parcel);
        }

        private static al[] a(int i2) {
            return new al[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        public final /* synthetic */ Object[] newArray(int i2) {
            return a(i2);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public final bp f7809a;

    /* renamed from: b  reason: collision with root package name */
    public final bp f7810b;

    /* renamed from: c  reason: collision with root package name */
    public final bp f7811c;

    /* renamed from: d  reason: collision with root package name */
    public final bp f7812d;

    /* renamed from: e  reason: collision with root package name */
    public final bp f7813e;

    /* renamed from: f  reason: collision with root package name */
    public final bp f7814f;

    /* renamed from: g  reason: collision with root package name */
    public final bp f7815g;

    /* renamed from: h  reason: collision with root package name */
    public final bp f7816h;

    /* renamed from: i  reason: collision with root package name */
    public final bp f7817i;

    /* renamed from: j  reason: collision with root package name */
    public final bp f7818j;

    /* renamed from: k  reason: collision with root package name */
    public final bp f7819k;

    /* renamed from: l  reason: collision with root package name */
    bp f7820l;

    /* renamed from: m  reason: collision with root package name */
    Context f7821m;

    /* renamed from: n  reason: collision with root package name */
    boolean f7822n;

    /* renamed from: o  reason: collision with root package name */
    private String f7823o;

    /* renamed from: p  reason: collision with root package name */
    private String f7824p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public long f7825q;

    /* renamed from: com.amap.api.mapcore.util.al$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f7829a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.amap.api.mapcore.util.bm$a[] r0 = com.amap.api.mapcore.util.bm.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f7829a = r0
                com.amap.api.mapcore.util.bm$a r1 = com.amap.api.mapcore.util.bm.a.amap_exception     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f7829a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.amap.api.mapcore.util.bm$a r1 = com.amap.api.mapcore.util.bm.a.file_io_exception     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f7829a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.amap.api.mapcore.util.bm$a r1 = com.amap.api.mapcore.util.bm.a.network_exception     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.al.AnonymousClass3.<clinit>():void");
        }
    }

    private al(Context context, int i2) {
        this.f7809a = new br(this);
        this.f7810b = new by(this);
        this.f7811c = new bu(this);
        this.f7812d = new bw(this);
        this.f7813e = new bx(this);
        this.f7814f = new bq(this);
        this.f7815g = new bv(this);
        this.f7816h = new bs(-1, this);
        this.f7817i = new bs(101, this);
        this.f7818j = new bs(102, this);
        this.f7819k = new bs(103, this);
        this.f7823o = null;
        this.f7824p = "";
        this.f7822n = false;
        this.f7825q = 0;
        this.f7821m = context;
        a(i2);
    }

    public al(Context context, OfflineMapCity offlineMapCity) {
        this(context, offlineMapCity.getState());
        setCity(offlineMapCity.getCity());
        setUrl(offlineMapCity.getUrl());
        setState(offlineMapCity.getState());
        setCompleteCode(offlineMapCity.getcompleteCode());
        setAdcode(offlineMapCity.getAdcode());
        setVersion(offlineMapCity.getVersion());
        setSize(offlineMapCity.getSize());
        setCode(offlineMapCity.getCode());
        setJianpin(offlineMapCity.getJianpin());
        setPinyin(offlineMapCity.getPinyin());
        s();
    }

    public al(Parcel parcel) {
        super(parcel);
        this.f7809a = new br(this);
        this.f7810b = new by(this);
        this.f7811c = new bu(this);
        this.f7812d = new bw(this);
        this.f7813e = new bx(this);
        this.f7814f = new bq(this);
        this.f7815g = new bv(this);
        this.f7816h = new bs(-1, this);
        this.f7817i = new bs(101, this);
        this.f7818j = new bs(102, this);
        this.f7819k = new bs(103, this);
        this.f7823o = null;
        this.f7824p = "";
        this.f7822n = false;
        this.f7825q = 0;
        this.f7824p = parcel.readString();
    }

    private String A() {
        if (TextUtils.isEmpty(this.f7823o)) {
            return null;
        }
        String str = this.f7823o;
        return str.substring(0, str.lastIndexOf("."));
    }

    private String B() {
        if (TextUtils.isEmpty(this.f7823o)) {
            return null;
        }
        String A = A();
        return A.substring(0, A.lastIndexOf(46));
    }

    private boolean C() {
        double size = (double) getSize();
        Double.isNaN(size);
        double size2 = (double) (((long) getcompleteCode()) * getSize());
        Double.isNaN(size2);
        int i2 = (((double) bj.a()) > ((size * 2.5d) - size2) ? 1 : (((double) bj.a()) == ((size * 2.5d) - size2) ? 0 : -1));
        return false;
    }

    private void a(final File file, File file2, final String str) {
        new bd().a(file, file2, -1, bj.a(file), new bd.a() {
            public final void a() {
                try {
                    if (new File(str).delete()) {
                        bj.b(file);
                        al.this.setCompleteCode(100);
                        al.this.f7820l.g();
                    }
                } catch (Exception unused) {
                    al.this.f7820l.a(al.this.f7819k.b());
                }
            }

            public final void a(float f2) {
                int i2 = al.this.getcompleteCode();
                double d2 = (double) f2;
                Double.isNaN(d2);
                int i3 = (int) ((d2 * 0.39d) + 60.0d);
                if (i3 - i2 > 0 && System.currentTimeMillis() - al.this.f7825q > 1000) {
                    al.this.setCompleteCode(i3);
                    long unused = al.this.f7825q = System.currentTimeMillis();
                }
            }

            public final void b() {
                al.this.f7820l.a(al.this.f7819k.b());
            }
        });
    }

    private void z() {
        am a2 = am.a(this.f7821m);
        if (a2 != null) {
            a2.a(this);
        }
    }

    public final String a() {
        return this.f7824p;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x001a, code lost:
        if (r2 < 0) goto L_0x003b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r2) {
        /*
            r1 = this;
            r0 = -1
            if (r2 == r0) goto L_0x003b
            if (r2 == 0) goto L_0x0038
            r0 = 1
            if (r2 == r0) goto L_0x0035
            r0 = 2
            if (r2 == r0) goto L_0x0032
            r0 = 3
            if (r2 == r0) goto L_0x002f
            r0 = 4
            if (r2 == r0) goto L_0x002c
            r0 = 6
            if (r2 == r0) goto L_0x0029
            r0 = 7
            if (r2 == r0) goto L_0x0026
            switch(r2) {
                case 101: goto L_0x0023;
                case 102: goto L_0x0020;
                case 103: goto L_0x001d;
                default: goto L_0x001a;
            }
        L_0x001a:
            if (r2 >= 0) goto L_0x003f
            goto L_0x003b
        L_0x001d:
            com.amap.api.mapcore.util.bp r0 = r1.f7819k
            goto L_0x003d
        L_0x0020:
            com.amap.api.mapcore.util.bp r0 = r1.f7818j
            goto L_0x003d
        L_0x0023:
            com.amap.api.mapcore.util.bp r0 = r1.f7817i
            goto L_0x003d
        L_0x0026:
            com.amap.api.mapcore.util.bp r0 = r1.f7815g
            goto L_0x003d
        L_0x0029:
            com.amap.api.mapcore.util.bp r0 = r1.f7809a
            goto L_0x003d
        L_0x002c:
            com.amap.api.mapcore.util.bp r0 = r1.f7814f
            goto L_0x003d
        L_0x002f:
            com.amap.api.mapcore.util.bp r0 = r1.f7812d
            goto L_0x003d
        L_0x0032:
            com.amap.api.mapcore.util.bp r0 = r1.f7810b
            goto L_0x003d
        L_0x0035:
            com.amap.api.mapcore.util.bp r0 = r1.f7813e
            goto L_0x003d
        L_0x0038:
            com.amap.api.mapcore.util.bp r0 = r1.f7811c
            goto L_0x003d
        L_0x003b:
            com.amap.api.mapcore.util.bp r0 = r1.f7816h
        L_0x003d:
            r1.f7820l = r0
        L_0x003f:
            r1.setState(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.al.a(int):void");
    }

    public final void a(long j2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f7825q > 500) {
            int i2 = (int) j2;
            if (i2 > getcompleteCode()) {
                setCompleteCode(i2);
                d();
            }
            this.f7825q = currentTimeMillis;
        }
    }

    public final void a(long j2, long j3) {
        int i2 = (int) ((j3 * 100) / j2);
        if (i2 != getcompleteCode()) {
            setCompleteCode(i2);
            d();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0033 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0034  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.amap.api.mapcore.util.bm.a r3) {
        /*
            r2 = this;
            int[] r0 = com.amap.api.mapcore.util.al.AnonymousClass3.f7829a
            int r3 = r3.ordinal()
            r3 = r0[r3]
            r0 = 1
            if (r3 == r0) goto L_0x0019
            r0 = 2
            if (r3 == r0) goto L_0x0016
            r0 = 3
            if (r3 == r0) goto L_0x0013
            r3 = 6
            goto L_0x001f
        L_0x0013:
            com.amap.api.mapcore.util.bp r3 = r2.f7817i
            goto L_0x001b
        L_0x0016:
            com.amap.api.mapcore.util.bp r3 = r2.f7819k
            goto L_0x001b
        L_0x0019:
            com.amap.api.mapcore.util.bp r3 = r2.f7818j
        L_0x001b:
            int r3 = r3.b()
        L_0x001f:
            com.amap.api.mapcore.util.bp r0 = r2.f7820l
            com.amap.api.mapcore.util.bp r1 = r2.f7811c
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0034
            com.amap.api.mapcore.util.bp r0 = r2.f7820l
            com.amap.api.mapcore.util.bp r1 = r2.f7810b
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0034
            return
        L_0x0034:
            com.amap.api.mapcore.util.bp r0 = r2.f7820l
            r0.a((int) r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.al.a(com.amap.api.mapcore.util.bm$a):void");
    }

    public final void a(bp bpVar) {
        this.f7820l = bpVar;
        setState(bpVar.b());
    }

    public final void a(String str) {
        this.f7824p = str;
    }

    public final bp b(int i2) {
        switch (i2) {
            case 101:
                return this.f7817i;
            case 102:
                return this.f7818j;
            case 103:
                return this.f7819k;
            default:
                return this.f7816h;
        }
    }

    public final String b() {
        return getUrl();
    }

    public final void b(String str) {
        this.f7820l.equals(this.f7813e);
        this.f7824p = str;
        String A = A();
        String B = B();
        if (TextUtils.isEmpty(A) || TextUtils.isEmpty(B)) {
            q();
            return;
        }
        File file = new File(B + "/");
        File file2 = new File(dl.a(this.f7821m) + File.separator + "map/");
        File file3 = new File(dl.a(this.f7821m));
        if (!file3.exists() && !file3.mkdir()) {
            return;
        }
        if (file2.exists() || file2.mkdir()) {
            a(file, file2, A);
        }
    }

    public final bp c() {
        return this.f7820l;
    }

    public final void d() {
        am a2 = am.a(this.f7821m);
        if (a2 != null) {
            a2.c(this);
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final void e() {
        am a2 = am.a(this.f7821m);
        if (a2 != null) {
            a2.e(this);
            d();
        }
    }

    public final void f() {
        new StringBuilder("CityOperation current State==>").append(c().b());
        if (this.f7820l.equals(this.f7812d)) {
            this.f7820l.d();
        } else if (this.f7820l.equals(this.f7811c)) {
            this.f7820l.e();
        } else if (this.f7820l.equals(this.f7815g) || this.f7820l.equals(this.f7816h)) {
            z();
            this.f7822n = true;
        } else if (this.f7820l.equals(this.f7818j) || this.f7820l.equals(this.f7817i) || this.f7820l.a(this.f7819k)) {
            this.f7820l.c();
        } else {
            c().h();
        }
    }

    public final void g() {
        this.f7820l.e();
    }

    public final void h() {
        this.f7820l.a(this.f7819k.b());
    }

    public final void i() {
        this.f7820l.a();
        if (this.f7822n) {
            this.f7820l.h();
        }
        this.f7822n = false;
    }

    public final void j() {
        this.f7820l.equals(this.f7814f);
        this.f7820l.f();
    }

    public final void k() {
        am a2 = am.a(this.f7821m);
        if (a2 != null) {
            a2.b(this);
        }
    }

    public final void l() {
        am a2 = am.a(this.f7821m);
        if (a2 != null) {
            a2.d(this);
        }
    }

    public final void m() {
        this.f7825q = 0;
        this.f7820l.equals(this.f7810b);
        this.f7820l.c();
    }

    public final void n() {
        this.f7820l.equals(this.f7811c);
        this.f7820l.g();
    }

    public final void o() {
        e();
    }

    public final void p() {
        this.f7825q = 0;
        setCompleteCode(0);
        this.f7820l.equals(this.f7813e);
        this.f7820l.c();
    }

    public final void q() {
        this.f7820l.equals(this.f7813e);
        this.f7820l.a(this.f7816h.b());
    }

    public final void r() {
        e();
    }

    /* access modifiers changed from: protected */
    public final void s() {
        String str;
        String str2 = am.f7830a;
        String b2 = bj.b(getUrl());
        if (b2 != null) {
            str = str2 + b2 + ".zip.tmp";
        } else {
            str = str2 + getPinyin() + ".zip.tmp";
        }
        this.f7823o = str;
    }

    public final aw t() {
        setState(this.f7820l.b());
        aw awVar = new aw((OfflineMapCity) this, this.f7821m);
        awVar.a(a());
        new StringBuilder("vMapFileNames: ").append(a());
        return awVar;
    }

    public final boolean u() {
        return C();
    }

    public final String v() {
        StringBuffer stringBuffer = new StringBuffer();
        String b2 = bj.b(getUrl());
        if (b2 == null) {
            b2 = getPinyin();
        }
        stringBuffer.append(b2);
        stringBuffer.append(".zip");
        return stringBuffer.toString();
    }

    public final String w() {
        return getAdcode();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.f7824p);
    }

    public final String x() {
        return A();
    }

    public final String y() {
        return B();
    }
}
