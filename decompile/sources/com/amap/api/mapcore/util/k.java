package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.mapcore.util.bd;
import com.amap.api.mapcore.util.gy;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.Map;

public final class k implements gy.a {

    /* renamed from: a  reason: collision with root package name */
    a f9540a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f9541b;

    /* renamed from: c  reason: collision with root package name */
    private RandomAccessFile f9542c;

    /* renamed from: d  reason: collision with root package name */
    private hf f9543d;

    /* renamed from: e  reason: collision with root package name */
    private String f9544e;

    static class a {

        /* renamed from: a  reason: collision with root package name */
        protected String f9545a;

        /* renamed from: b  reason: collision with root package name */
        protected String f9546b;

        /* renamed from: c  reason: collision with root package name */
        protected String f9547c;

        /* renamed from: d  reason: collision with root package name */
        protected String f9548d;

        /* renamed from: e  reason: collision with root package name */
        protected String f9549e;

        /* renamed from: f  reason: collision with root package name */
        protected c f9550f;

        public a(String str, String str2, String str3, String str4) {
            this.f9545a = str;
            this.f9546b = str2;
            this.f9547c = str3;
            this.f9548d = str4 + ".tmp";
            this.f9549e = str4;
        }

        public final String a() {
            return this.f9545a;
        }

        public final void a(c cVar) {
            this.f9550f = cVar;
        }

        public final String b() {
            return this.f9546b;
        }

        public final String c() {
            return this.f9548d;
        }

        public final String d() {
            return this.f9549e;
        }

        public final c e() {
            return this.f9550f;
        }
    }

    static class b extends cp {

        /* renamed from: e  reason: collision with root package name */
        private final a f9551e;

        b(a aVar) {
            this.f9551e = aVar;
        }

        public final String getIPV6URL() {
            return getURL();
        }

        public final Map<String, String> getParams() {
            return null;
        }

        public final Map<String, String> getRequestHead() {
            return null;
        }

        public final String getURL() {
            a aVar = this.f9551e;
            if (aVar != null) {
                return aVar.a();
            }
            return null;
        }

        public final boolean isSupportIPV6() {
            return false;
        }
    }

    static class c {

        /* renamed from: a  reason: collision with root package name */
        protected String f9552a;

        /* renamed from: b  reason: collision with root package name */
        protected String f9553b;

        public c(String str, String str2) {
            this.f9552a = str;
            this.f9553b = str2;
        }

        public final String a() {
            return this.f9552a;
        }

        public final String b() {
            return this.f9553b;
        }

        public final boolean c() {
            return !TextUtils.isEmpty(this.f9552a) && !TextUtils.isEmpty(this.f9553b);
        }
    }

    static class d extends a {
        public d(String str, String str2, String str3, String str4) {
            super(str, str2, str3, str4);
        }

        public final void a(String str, String str2) {
            a(new c(str, str2));
        }
    }

    public k(Context context, a aVar) {
        this.f9541b = context.getApplicationContext();
        this.f9540a = aVar;
        this.f9543d = new hf(new b(aVar));
        this.f9544e = aVar.c();
    }

    private boolean b() {
        c e2 = this.f9540a.e();
        return e2 == null || !e2.c() || !db.a(this.f9541b, e2.a(), e2.b(), "").equalsIgnoreCase(this.f9540a.b());
    }

    public final void a() {
        hf hfVar;
        try {
            if (b() && (hfVar = this.f9543d) != null) {
                hfVar.a(this);
            }
        } catch (Throwable th) {
            fz.c(th, "AuthTaskDownload", "startDownload()");
        }
    }

    public final void onDownload(byte[] bArr, long j2) {
        try {
            if (this.f9542c == null) {
                File file = new File(this.f9544e);
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                this.f9542c = new RandomAccessFile(file, "rw");
            }
            this.f9542c.seek(j2);
            this.f9542c.write(bArr);
        } catch (Throwable th) {
            fz.c(th, "AuthTaskDownload", "onDownload()");
        }
    }

    public final void onException(Throwable th) {
        try {
            RandomAccessFile randomAccessFile = this.f9542c;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
        } catch (Throwable th2) {
            fz.c(th2, "AuthTaskDownload", "onException()");
        }
    }

    public final void onFinish() {
        try {
            RandomAccessFile randomAccessFile = this.f9542c;
            if (randomAccessFile != null) {
                randomAccessFile.close();
                String b2 = this.f9540a.b();
                String a2 = fd.a(this.f9544e);
                if (a2 == null || !b2.equalsIgnoreCase(a2)) {
                    try {
                        new File(this.f9544e).delete();
                    } catch (Throwable th) {
                        fz.c(th, "AuthTaskDownload", "onFinish");
                    }
                } else {
                    String d2 = this.f9540a.d();
                    try {
                        bd bdVar = new bd();
                        File file = new File(this.f9544e);
                        bdVar.a(file, new File(d2), -1, bj.a(file), (bd.a) null);
                        c e2 = this.f9540a.e();
                        if (e2 != null && e2.c()) {
                            db.a(this.f9541b, e2.a(), e2.b(), (Object) a2);
                        }
                        new File(this.f9544e).delete();
                    } catch (Throwable th2) {
                        fz.c(th2, "AuthTaskDownload", "onFinish1");
                    }
                }
            }
        } catch (Throwable th3) {
            fz.c(th3, "AuthTaskDownload", "onFinish()");
        }
    }

    public final void onStop() {
    }
}
