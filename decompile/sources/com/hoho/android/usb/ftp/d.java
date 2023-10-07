package com.hoho.android.usb.ftp;

import android.util.Log;
import ha.f;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.regex.Pattern;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.l;

public class d extends c {

    /* renamed from: u  reason: collision with root package name */
    private static final Pattern f11853u = Pattern.compile("(\\d{1,3},\\d{1,3},\\d{1,3},\\d{1,3}),(\\d{1,3}),(\\d{1,3})");
    private LinkedBlockingQueue<byte[]> A = new LinkedBlockingQueue<>();

    /* renamed from: g  reason: collision with root package name */
    private int f11854g;

    /* renamed from: h  reason: collision with root package name */
    private int f11855h;

    /* renamed from: i  reason: collision with root package name */
    private int f11856i;

    /* renamed from: j  reason: collision with root package name */
    private String f11857j;

    /* renamed from: k  reason: collision with root package name */
    private int f11858k;

    /* renamed from: l  reason: collision with root package name */
    private int f11859l;

    /* renamed from: m  reason: collision with root package name */
    private int f11860m;

    /* renamed from: n  reason: collision with root package name */
    private int f11861n;

    /* renamed from: o  reason: collision with root package name */
    private b f11862o;

    /* renamed from: p  reason: collision with root package name */
    private hc.a f11863p;

    /* renamed from: q  reason: collision with root package name */
    private String f11864q;

    /* renamed from: r  reason: collision with root package name */
    private hc.b f11865r;

    /* renamed from: s  reason: collision with root package name */
    private int f11866s = 1000;

    /* renamed from: t  reason: collision with root package name */
    private a f11867t = new b(this);

    /* renamed from: v  reason: collision with root package name */
    private boolean f11868v = false;

    /* renamed from: w  reason: collision with root package name */
    private String f11869w = "root";

    /* renamed from: x  reason: collision with root package name */
    private String f11870x = "cfly";

    /* renamed from: y  reason: collision with root package name */
    private com.hoho.android.usb.rtsp.a f11871y;

    /* renamed from: z  reason: collision with root package name */
    private LinkedBlockingQueue<byte[]> f11872z = new LinkedBlockingQueue<>();

    public interface a {
    }

    public static class b implements a {

        /* renamed from: a  reason: collision with root package name */
        private d f20230a;

        public b(d dVar) {
            this.f20230a = dVar;
        }
    }

    public d() {
        g();
        this.f11855h = -1;
        this.f11865r = new a();
        this.f11862o = null;
    }

    private void g() {
        this.f11854g = 0;
        this.f11857j = null;
        this.f11856i = -1;
        this.f11858k = 0;
        this.f11860m = 7;
        this.f11859l = 4;
        this.f11861n = 10;
        this.f11863p = null;
        this.f11864q = "";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002c, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002e, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean k(java.lang.String r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            com.hoho.android.usb.rtsp.a r0 = r3.f11871y     // Catch:{ all -> 0x002f }
            r1 = 0
            if (r0 == 0) goto L_0x002d
            boolean r0 = r0.a()     // Catch:{ all -> 0x002f }
            if (r0 != 0) goto L_0x000d
            goto L_0x002d
        L_0x000d:
            com.hoho.android.usb.rtsp.a r0 = r3.f11871y     // Catch:{ all -> 0x002f }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x002f }
            r2.<init>()     // Catch:{ all -> 0x002f }
            r2.append(r4)     // Catch:{ all -> 0x002f }
            java.lang.String r4 = "\r\n"
            r2.append(r4)     // Catch:{ all -> 0x002f }
            java.lang.String r4 = r2.toString()     // Catch:{ all -> 0x002f }
            byte[] r4 = r4.getBytes()     // Catch:{ all -> 0x002f }
            int r4 = r0.a((byte[]) r4)     // Catch:{ all -> 0x002f }
            if (r4 != 0) goto L_0x002b
            r1 = 1
        L_0x002b:
            monitor-exit(r3)
            return r1
        L_0x002d:
            monitor-exit(r3)
            return r1
        L_0x002f:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hoho.android.usb.ftp.d.k(java.lang.String):boolean");
    }

    public String a() {
        try {
            return new String(this.f11872z.take());
        } catch (InterruptedException e2) {
            e2.printStackTrace();
            Log.i("FTP", "readLine: ======response====" + e2.getMessage());
            return null;
        }
    }

    public boolean a(String str) {
        return k(str);
    }

    public boolean b(int i2) throws Exception {
        if (!e.a(a(i2))) {
            return false;
        }
        this.f11858k = i2;
        this.f11859l = 4;
        return true;
    }

    public void f() {
        this.f11854g = 2;
        this.f11857j = null;
        this.f11856i = -1;
    }

    public boolean g(String str) throws Exception {
        return e.a(c(str));
    }

    public boolean h(String str) throws Exception {
        return e.a(d(str));
    }

    public boolean i(String str) throws Exception {
        return e.a(e(str));
    }

    public String j(String str) throws Exception {
        e.a(f(str));
        return c();
    }

    @l(a = ThreadMode.BACKGROUND)
    public void usbTcpRecDataEvent(f fVar) {
        String str;
        if (fVar.b() == 7) {
            if (!this.f11872z.offer(fVar.a())) {
                str = "usbTcpRecDataEvent:===receive failed ";
            } else {
                return;
            }
        } else if (fVar.b() == 8 && !this.A.offer(fVar.a())) {
            str = "usbTcpRecDataEvent: ===receive serve data fail";
        } else {
            return;
        }
        Log.e("FTP", str);
    }
}
