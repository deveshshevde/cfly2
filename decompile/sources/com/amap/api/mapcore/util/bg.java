package com.amap.api.mapcore.util;

import android.content.Context;
import com.amap.api.mapcore.util.bm;
import com.amap.api.mapcore.util.gy;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.MapsInitializer;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public final class bg implements gy.a {

    /* renamed from: a  reason: collision with root package name */
    bh f8051a = null;

    /* renamed from: b  reason: collision with root package name */
    long f8052b = 0;

    /* renamed from: c  reason: collision with root package name */
    long f8053c = 0;

    /* renamed from: d  reason: collision with root package name */
    long f8054d;

    /* renamed from: e  reason: collision with root package name */
    boolean f8055e = true;

    /* renamed from: f  reason: collision with root package name */
    bb f8056f;

    /* renamed from: g  reason: collision with root package name */
    long f8057g = 0;

    /* renamed from: h  reason: collision with root package name */
    a f8058h;

    /* renamed from: i  reason: collision with root package name */
    private Context f8059i;

    /* renamed from: j  reason: collision with root package name */
    private bm f8060j;

    /* renamed from: k  reason: collision with root package name */
    private String f8061k;

    /* renamed from: l  reason: collision with root package name */
    private hf f8062l;

    /* renamed from: m  reason: collision with root package name */
    private bc f8063m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f8064n = false;

    public interface a {
        void c();
    }

    private static class b extends cp {

        /* renamed from: e  reason: collision with root package name */
        private final String f8065e;

        public b(String str) {
            this.f8065e = str;
        }

        public final String getIPV6URL() {
            return getURL();
        }

        public final Map<String, String> getRequestHead() {
            return null;
        }

        public final String getURL() {
            return this.f8065e;
        }

        public final boolean isSupportIPV6() {
            return false;
        }
    }

    public bg(bh bhVar, String str, Context context, bm bmVar) throws IOException {
        this.f8056f = bb.a(context.getApplicationContext());
        this.f8051a = bhVar;
        this.f8059i = context;
        this.f8061k = str;
        this.f8060j = bmVar;
        d();
    }

    private void a(long j2) {
        bm bmVar;
        long j3 = this.f8054d;
        if (j3 > 0 && (bmVar = this.f8060j) != null) {
            bmVar.a(j3, j2);
            this.f8057g = System.currentTimeMillis();
        }
    }

    private void c() throws IOException {
        bn bnVar = new bn(this.f8061k);
        bnVar.setConnectionTimeout(30000);
        bnVar.setSoTimeout(30000);
        this.f8062l = new hf(bnVar, this.f8052b, this.f8053c, MapsInitializer.getProtocol() == 2);
        this.f8063m = new bc(this.f8051a.b() + File.separator + this.f8051a.c(), this.f8052b);
    }

    private void d() {
        File file = new File(this.f8051a.b() + this.f8051a.c());
        if (file.exists()) {
            this.f8055e = false;
            this.f8052b = file.length();
            try {
                long g2 = g();
                this.f8054d = g2;
                this.f8053c = g2;
            } catch (IOException unused) {
                bm bmVar = this.f8060j;
                if (bmVar != null) {
                    bmVar.a(bm.a.file_io_exception);
                }
            }
        } else {
            this.f8052b = 0;
            this.f8053c = 0;
        }
    }

    private boolean e() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f8051a.b());
        sb.append(File.separator);
        sb.append(this.f8051a.c());
        return new File(sb.toString()).length() >= 10;
    }

    private void f() throws AMapException {
        if (ex.f8670a != 1) {
            int i2 = 0;
            while (i2 < 3) {
                try {
                    if (!ex.a(this.f8059i, dl.a())) {
                        i2++;
                    } else {
                        return;
                    }
                } catch (Throwable th) {
                    fz.c(th, "SiteFileFetch", "authOffLineDownLoad");
                    th.printStackTrace();
                }
            }
        }
    }

    private long g() throws IOException {
        Map<String, String> map;
        String a2 = this.f8051a.a();
        try {
            hc.b();
            map = hc.e(new b(a2), MapsInitializer.getProtocol() == 2);
        } catch (eu e2) {
            e2.printStackTrace();
            map = null;
        }
        int i2 = -1;
        if (map != null) {
            for (String next : map.keySet()) {
                if ("Content-Length".equalsIgnoreCase(next)) {
                    i2 = Integer.parseInt(map.get(next));
                }
            }
        }
        return (long) i2;
    }

    private void h() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f8051a != null && currentTimeMillis - this.f8057g > 500) {
            i();
            this.f8057g = currentTimeMillis;
            a(this.f8052b);
        }
    }

    private void i() {
        this.f8056f.a(this.f8051a.e(), this.f8051a.d(), this.f8054d, this.f8052b, this.f8053c);
    }

    public final void a() {
        try {
            if (dl.d(this.f8059i)) {
                f();
                if (ex.f8670a != 1) {
                    bm bmVar = this.f8060j;
                    if (bmVar != null) {
                        bmVar.a(bm.a.amap_exception);
                        return;
                    }
                    return;
                }
                if (!e()) {
                    this.f8055e = true;
                }
                if (this.f8055e) {
                    long g2 = g();
                    this.f8054d = g2;
                    if (!(g2 == -1 || g2 == -2)) {
                        this.f8053c = g2;
                    }
                    this.f8052b = 0;
                }
                bm bmVar2 = this.f8060j;
                if (bmVar2 != null) {
                    bmVar2.m();
                }
                if (this.f8052b >= this.f8053c) {
                    onFinish();
                    return;
                }
                c();
                this.f8062l.a(this);
                return;
            }
            bm bmVar3 = this.f8060j;
            if (bmVar3 != null) {
                bmVar3.a(bm.a.network_exception);
            }
        } catch (AMapException e2) {
            fz.c(e2, "SiteFileFetch", "download");
            bm bmVar4 = this.f8060j;
            if (bmVar4 != null) {
                bmVar4.a(bm.a.amap_exception);
            }
        } catch (IOException unused) {
            bm bmVar5 = this.f8060j;
            if (bmVar5 != null) {
                bmVar5.a(bm.a.file_io_exception);
            }
        }
    }

    public final void a(a aVar) {
        this.f8058h = aVar;
    }

    public final void b() {
        hf hfVar = this.f8062l;
        if (hfVar != null) {
            hfVar.a();
        }
    }

    public final void onDownload(byte[] bArr, long j2) {
        try {
            this.f8063m.a(bArr);
            this.f8052b = j2;
            h();
        } catch (IOException e2) {
            e2.printStackTrace();
            fz.c(e2, "fileAccessI", "fileAccessI.write(byte[] data)");
            bm bmVar = this.f8060j;
            if (bmVar != null) {
                bmVar.a(bm.a.file_io_exception);
            }
            hf hfVar = this.f8062l;
            if (hfVar != null) {
                hfVar.a();
            }
        }
    }

    public final void onException(Throwable th) {
        bc bcVar;
        this.f8064n = true;
        b();
        bm bmVar = this.f8060j;
        if (bmVar != null) {
            bmVar.a(bm.a.network_exception);
        }
        if (!(th instanceof IOException) && (bcVar = this.f8063m) != null) {
            bcVar.a();
        }
    }

    public final void onFinish() {
        h();
        bm bmVar = this.f8060j;
        if (bmVar != null) {
            bmVar.n();
        }
        bc bcVar = this.f8063m;
        if (bcVar != null) {
            bcVar.a();
        }
        a aVar = this.f8058h;
        if (aVar != null) {
            aVar.c();
        }
    }

    public final void onStop() {
        if (!this.f8064n) {
            bm bmVar = this.f8060j;
            if (bmVar != null) {
                bmVar.o();
            }
            i();
        }
    }
}
