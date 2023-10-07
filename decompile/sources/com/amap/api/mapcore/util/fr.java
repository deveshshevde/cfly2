package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.amap.api.mapcore.util.ga;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

public final class fr {

    /* renamed from: a  reason: collision with root package name */
    private Context f8809a;

    /* renamed from: b  reason: collision with root package name */
    private ff f8810b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f8811c = true;

    /* renamed from: d  reason: collision with root package name */
    private boolean f8812d = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f8813e = true;

    /* renamed from: f  reason: collision with root package name */
    private boolean f8814f = false;

    /* renamed from: g  reason: collision with root package name */
    private List<String> f8815g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    private ft f8816h = new ft((byte) 0);

    /* renamed from: i  reason: collision with root package name */
    private ft f8817i = new ft();

    /* renamed from: j  reason: collision with root package name */
    private ga.a f8818j = new ga.a() {
        public final void a(int i2) {
            if (i2 > 0 && fr.a(fr.this) != null) {
                ((fs) fr.this.c().f9128f).a(i2);
                fr.a(fr.this, IjkMediaPlayer.OnNativeInvokeListener.ARG_ERROR, String.valueOf(((fs) fr.this.c().f9128f).b()));
                fr.a(fr.this).postDelayed(new Runnable() {
                    public final void run() {
                        fr.this.c(false);
                    }
                }, 660000);
            }
        }
    };

    /* renamed from: k  reason: collision with root package name */
    private ga.a f8819k = new ga.a() {
        public final void a(int i2) {
            if (i2 > 0) {
                ((fs) fr.this.e().f9128f).a(i2);
                fr.a(fr.this, "info", String.valueOf(((fs) fr.this.e().f9128f).b()));
                if (fr.a(fr.this) != null) {
                    fr.a(fr.this).postDelayed(new Runnable() {
                        public final void run() {
                            fr.this.d(false);
                        }
                    }, 660000);
                }
            }
        }
    };

    /* renamed from: l  reason: collision with root package name */
    private Handler f8820l = null;

    /* renamed from: m  reason: collision with root package name */
    private hg f8821m = null;

    /* renamed from: n  reason: collision with root package name */
    private hg f8822n = null;

    static class a {

        /* renamed from: a  reason: collision with root package name */
        public static Map<String, fr> f8827a = new HashMap();
    }

    private fr(ff ffVar) {
        this.f8810b = ffVar;
    }

    private long a(String str) {
        try {
            String format = new SimpleDateFormat("yyyyMMdd").format(new Date());
            fu a2 = fu.a(this.f8810b);
            Context context = this.f8809a;
            return Long.parseLong(a2.a(context, "", "", format + str));
        } catch (Throwable unused) {
            return 0;
        }
    }

    static /* synthetic */ Handler a(fr frVar) {
        Context context = frVar.f8809a;
        if (context == null || context == null) {
            return null;
        }
        if (frVar.f8820l == null) {
            frVar.f8820l = new Handler(frVar.f8809a.getMainLooper());
        }
        return frVar.f8820l;
    }

    public static fr a(ff ffVar) {
        if (ffVar == null || TextUtils.isEmpty(ffVar.a())) {
            return null;
        }
        if (a.f8827a.get(ffVar.a()) == null) {
            a.f8827a.put(ffVar.a(), new fr(ffVar));
        }
        return a.f8827a.get(ffVar.a());
    }

    private static String a(Context context, String str, ff ffVar) {
        String str2;
        if (context == null) {
            return null;
        }
        if (ffVar != null) {
            try {
                if (!TextUtils.isEmpty(ffVar.a())) {
                    str2 = fd.b(ffVar.a());
                    return context.getFilesDir().getAbsolutePath() + File.separator + "EBDEC84EF205FEA2DF0719DEB822869E" + File.separator + str + File.separator + str2;
                }
            } catch (Throwable unused) {
                return null;
            }
        }
        str2 = "a";
        return context.getFilesDir().getAbsolutePath() + File.separator + "EBDEC84EF205FEA2DF0719DEB822869E" + File.separator + str + File.separator + str2;
    }

    private void a(int i2) {
        Context context;
        ft b2 = b(i2);
        String a2 = fq.a((List<fq>) b2.a());
        if (!TextUtils.isEmpty(a2) && !"[]".equals(a2) && (context = this.f8809a) != null) {
            ga.a(context, this.f8810b, fq.a(i2), c(i2), a2);
            b2.b();
        }
    }

    static /* synthetic */ void a(fr frVar, String str, String str2) {
        try {
            String format = new SimpleDateFormat("yyyyMMdd").format(new Date());
            fu a2 = fu.a(frVar.f8810b);
            Context context = frVar.f8809a;
            a2.a(context, "", "", format + str, str2);
        } catch (Throwable unused) {
        }
    }

    private ft b(int i2) {
        return i2 == fq.f8804b ? this.f8817i : this.f8816h;
    }

    private void b(boolean z2) {
        c(z2);
        d(z2);
    }

    private boolean b() {
        return this.f8809a != null;
    }

    /* access modifiers changed from: private */
    public hg c() {
        hg hgVar = this.f8822n;
        if (hgVar != null) {
            return hgVar;
        }
        d();
        return this.f8822n;
    }

    private hg c(int i2) {
        if (i2 == fq.f8804b) {
            if (this.f8822n == null) {
                this.f8822n = c();
            }
            return this.f8822n;
        }
        if (this.f8821m == null) {
            this.f8821m = e();
        }
        return this.f8821m;
    }

    /* access modifiers changed from: private */
    public void c(boolean z2) {
        hg c2 = c(fq.f8804b);
        if (z2) {
            ((fs) c2.f9128f).a(z2);
        }
        Context context = this.f8809a;
        if (context != null) {
            ga.a(context, c2, this.f8818j);
        }
    }

    private hg d() {
        if (this.f8809a == null) {
            return null;
        }
        hg hgVar = new hg();
        this.f8822n = hgVar;
        hgVar.f9123a = h();
        this.f8822n.f9124b = 512000000;
        this.f8822n.f9126d = 12500;
        this.f8822n.f9125c = "1";
        this.f8822n.f9130h = -1;
        this.f8822n.f9131i = "elkey";
        long a2 = a(IjkMediaPlayer.OnNativeInvokeListener.ARG_ERROR);
        this.f8822n.f9128f = new fs(true, new ib(this.f8809a, this.f8812d), a2, 10000000);
        this.f8822n.f9129g = null;
        return this.f8822n;
    }

    /* access modifiers changed from: private */
    public void d(boolean z2) {
        hg c2 = c(fq.f8803a);
        if (z2) {
            ((fs) c2.f9128f).a(z2);
        }
        Context context = this.f8809a;
        if (context != null) {
            ga.a(context, c2, this.f8819k);
        }
    }

    /* access modifiers changed from: private */
    public hg e() {
        hg hgVar = this.f8821m;
        if (hgVar != null) {
            return hgVar;
        }
        f();
        return this.f8821m;
    }

    private hg f() {
        if (this.f8809a == null) {
            return null;
        }
        hg hgVar = new hg();
        this.f8821m = hgVar;
        hgVar.f9123a = g();
        this.f8821m.f9124b = 512000000;
        this.f8821m.f9126d = 12500;
        this.f8821m.f9125c = "1";
        this.f8821m.f9130h = -1;
        this.f8821m.f9131i = "inlkey";
        long a2 = a("info");
        this.f8821m.f9128f = new fs(this.f8814f, new ib(this.f8809a, this.f8812d), a2, 30000000);
        this.f8821m.f9129g = null;
        return this.f8821m;
    }

    private String g() {
        Context context = this.f8809a;
        if (context == null) {
            return null;
        }
        return a(context, "CAF9B6B99962BF5C2264824231D7A40C", this.f8810b);
    }

    private String h() {
        Context context = this.f8809a;
        if (context == null) {
            return null;
        }
        return a(context, "CB5E100E5A9A3E7F6D1FD97512215282", this.f8810b);
    }

    public final void a() {
        if (b()) {
            a(fq.f8804b);
            a(fq.f8803a);
        }
    }

    public final void a(Context context) {
        this.f8809a = context.getApplicationContext();
    }

    public final void a(fq fqVar) {
        if (b() && this.f8811c && fq.a(fqVar)) {
            boolean z2 = true;
            if (fqVar != null) {
                List<String> list = this.f8815g;
                if (list != null && list.size() != 0) {
                    int i2 = 0;
                    while (true) {
                        if (i2 < this.f8815g.size()) {
                            if (!TextUtils.isEmpty(this.f8815g.get(i2)) && fqVar.b().contains(this.f8815g.get(i2))) {
                                break;
                            }
                            i2++;
                        } else {
                            break;
                        }
                    }
                }
                z2 = false;
            }
            if (!z2) {
                if (this.f8813e || fqVar.a() != fq.f8803a) {
                    ft b2 = b(fqVar.a());
                    if (b2.a(fqVar.b())) {
                        String a2 = fq.a((List<fq>) b2.a());
                        if (this.f8809a != null && !TextUtils.isEmpty(a2) && !"[]".equals(a2)) {
                            ga.a(this.f8809a, this.f8810b, fqVar.c(), c(fqVar.a()), a2);
                            b(false);
                            b2.b();
                        } else {
                            return;
                        }
                    }
                    b2.a(fqVar);
                }
            }
        }
    }

    public final void a(boolean z2) {
        if (b()) {
            b(z2);
        }
    }

    public final void a(boolean z2, boolean z3, boolean z4, boolean z5, List<String> list) {
        this.f8811c = z2;
        this.f8812d = z3;
        this.f8813e = z4;
        this.f8814f = z5;
        this.f8815g = list;
        d();
        f();
    }
}
