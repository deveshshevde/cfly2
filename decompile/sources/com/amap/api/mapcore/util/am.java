package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import org.json.JSONException;

public class am {

    /* renamed from: a  reason: collision with root package name */
    public static String f7830a = "";

    /* renamed from: b  reason: collision with root package name */
    public static boolean f7831b = false;

    /* renamed from: d  reason: collision with root package name */
    public static String f7832d = "";

    /* renamed from: k  reason: collision with root package name */
    private static volatile am f7833k;

    /* renamed from: c  reason: collision with root package name */
    List<al> f7834c = new Vector();

    /* renamed from: e  reason: collision with root package name */
    b f7835e = null;

    /* renamed from: f  reason: collision with root package name */
    public aq f7836f;

    /* renamed from: g  reason: collision with root package name */
    as f7837g;

    /* renamed from: h  reason: collision with root package name */
    ap f7838h = null;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public Context f7839i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public boolean f7840j = true;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public a f7841l;

    /* renamed from: m  reason: collision with root package name */
    private av f7842m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public bb f7843n;

    /* renamed from: o  reason: collision with root package name */
    private id f7844o = null;

    /* renamed from: p  reason: collision with root package name */
    private id f7845p = null;

    /* renamed from: q  reason: collision with root package name */
    private id f7846q = null;

    /* renamed from: r  reason: collision with root package name */
    private boolean f7847r = true;

    public interface a {
        void a();

        void a(al alVar);

        void b(al alVar);

        void c(al alVar);
    }

    class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            try {
                message.getData();
                Object obj = message.obj;
                if (obj instanceof al) {
                    al alVar = (al) obj;
                    StringBuilder sb = new StringBuilder("OfflineMapHandler handleMessage CitObj  name: ");
                    sb.append(alVar.getCity());
                    sb.append(" complete: ");
                    sb.append(alVar.getcompleteCode());
                    sb.append(" status: ");
                    sb.append(alVar.getState());
                    if (am.this.f7841l != null) {
                        am.this.f7841l.a(alVar);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private am(Context context) {
        this.f7839i = context;
    }

    public static am a(Context context) {
        if (f7833k == null) {
            synchronized (am.class) {
                if (f7833k == null && !f7831b) {
                    f7833k = new am(context.getApplicationContext());
                }
            }
        }
        return f7833k;
    }

    private void a(final al alVar, final boolean z2) {
        if (this.f7837g == null) {
            this.f7837g = new as(this.f7839i);
        }
        if (this.f7845p == null) {
            this.f7845p = dk.a("AMapOfflineRemove");
        }
        try {
            this.f7845p.a(new ie() {
                public final void runTask() {
                    try {
                        if (!alVar.c().equals(alVar.f7809a)) {
                            if (alVar.getState() != 7) {
                                if (alVar.getState() != -1) {
                                    am.this.f7837g.a(alVar);
                                    if (am.this.f7841l != null) {
                                        am.this.f7841l.c(alVar);
                                        return;
                                    }
                                    return;
                                }
                            }
                            am.this.f7837g.a(alVar);
                            if (z2 && am.this.f7841l != null) {
                                am.this.f7841l.c(alVar);
                            }
                        } else if (am.this.f7841l != null) {
                            am.this.f7841l.c(alVar);
                        }
                    } catch (Throwable th) {
                        fz.c(th, "requestDelete", "removeExcecRunnable");
                    }
                }
            });
        } catch (Throwable th) {
            fz.c(th, "requestDelete", "removeExcecRunnable");
        }
    }

    /* access modifiers changed from: private */
    public static boolean b(String str, String str2) {
        int i2 = 0;
        while (i2 < str2.length()) {
            try {
                if (str.charAt(i2) > str2.charAt(i2)) {
                    return true;
                }
                if (str.charAt(i2) < str2.charAt(i2)) {
                    return false;
                }
                i2++;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    private void f(final al alVar) throws AMapException {
        j();
        if (alVar != null) {
            if (this.f7846q == null) {
                this.f7846q = dk.a("AMapOfflineDownload");
            }
            try {
                this.f7846q.a(new ie() {
                    public final void runTask() {
                        try {
                            if (am.this.f7840j) {
                                am.this.j();
                                an anVar = (an) new ao(am.this.f7839i, am.f7832d).c();
                                if (anVar != null) {
                                    boolean unused = am.this.f7840j = false;
                                    if (anVar.a()) {
                                        am.this.c();
                                    }
                                }
                            }
                            alVar.setVersion(am.f7832d);
                            alVar.f();
                        } catch (AMapException e2) {
                            e2.printStackTrace();
                        } catch (Throwable th) {
                            fz.c(th, "OfflineDownloadManager", "startDownloadRunnable");
                        }
                    }
                });
            } catch (Throwable th) {
                fz.c(th, "startDownload", "downloadExcecRunnable");
            }
        } else {
            throw new AMapException(AMapException.ERROR_INVALID_PARAMETER);
        }
    }

    private void g() {
        try {
            aw a2 = this.f7843n.a("000001");
            if (a2 != null) {
                this.f7843n.c("000001");
                a2.c("100000");
                this.f7843n.a(a2);
            }
        } catch (Throwable th) {
            fz.c(th, "OfflineDownloadManager", "changeBadCase");
        }
    }

    private void g(String str) throws JSONException {
        aq aqVar;
        List<OfflineMapProvince> a2 = bj.a(str, this.f7839i.getApplicationContext());
        if (a2 != null && a2.size() != 0 && (aqVar = this.f7836f) != null) {
            aqVar.a(a2);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0034, code lost:
        return r3;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0019  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amap.api.mapcore.util.al h(java.lang.String r6) {
        /*
            r5 = this;
            r0 = 0
            if (r6 == 0) goto L_0x003a
            int r1 = r6.length()
            if (r1 > 0) goto L_0x000a
            goto L_0x003a
        L_0x000a:
            java.util.List<com.amap.api.mapcore.util.al> r1 = r5.f7834c
            monitor-enter(r1)
            java.util.List<com.amap.api.mapcore.util.al> r2 = r5.f7834c     // Catch:{ all -> 0x0037 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0037 }
        L_0x0013:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0037 }
            if (r3 == 0) goto L_0x0035
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0037 }
            com.amap.api.mapcore.util.al r3 = (com.amap.api.mapcore.util.al) r3     // Catch:{ all -> 0x0037 }
            java.lang.String r4 = r3.getCity()     // Catch:{ all -> 0x0037 }
            boolean r4 = r6.equals(r4)     // Catch:{ all -> 0x0037 }
            if (r4 != 0) goto L_0x0033
            java.lang.String r4 = r3.getPinyin()     // Catch:{ all -> 0x0037 }
            boolean r4 = r6.equals(r4)     // Catch:{ all -> 0x0037 }
            if (r4 == 0) goto L_0x0013
        L_0x0033:
            monitor-exit(r1)     // Catch:{ all -> 0x0037 }
            return r3
        L_0x0035:
            monitor-exit(r1)     // Catch:{ all -> 0x0037 }
            return r0
        L_0x0037:
            r6 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0037 }
            throw r6
        L_0x003a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.am.h(java.lang.String):com.amap.api.mapcore.util.al");
    }

    private void h() {
        if (!"".equals(dl.c(this.f7839i))) {
            File file = new File(dl.c(this.f7839i) + "offlinemapv4.png");
            String a2 = !file.exists() ? bj.a(this.f7839i, "offlinemapv4.png") : bj.c(file);
            if (a2 != null) {
                try {
                    g(a2);
                } catch (JSONException e2) {
                    if (file.exists()) {
                        file.delete();
                    }
                    fz.c(e2, "MapDownloadManager", "paseJson io");
                    e2.printStackTrace();
                }
            }
        }
    }

    private al i(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        synchronized (this.f7834c) {
            for (al next : this.f7834c) {
                if (str.equals(next.getCode())) {
                    return next;
                }
            }
            return null;
        }
    }

    private void i() {
        Iterator<aw> it2 = this.f7843n.a().iterator();
        while (it2.hasNext()) {
            aw next = it2.next();
            if (!(next == null || next.c() == null || next.e().length() <= 0)) {
                if (!(next.f7895l == 4 || next.f7895l == 7 || next.f7895l < 0)) {
                    next.f7895l = 3;
                }
                al h2 = h(next.c());
                if (h2 != null) {
                    String d2 = next.d();
                    if (d2 == null || !b(f7832d, d2)) {
                        h2.a(next.f7895l);
                        h2.setCompleteCode(next.g());
                    } else {
                        h2.a(7);
                    }
                    if (next.d().length() > 0) {
                        h2.setVersion(next.d());
                    }
                    List<String> b2 = this.f7843n.b(next.e());
                    StringBuffer stringBuffer = new StringBuffer();
                    for (String append : b2) {
                        stringBuffer.append(append);
                        stringBuffer.append(";");
                    }
                    h2.a(stringBuffer.toString());
                    aq aqVar = this.f7836f;
                    if (aqVar != null) {
                        aqVar.a(h2);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void j() throws AMapException {
        if (!dl.d(this.f7839i)) {
            throw new AMapException(AMapException.ERROR_CONNECTION);
        }
    }

    private static void j(String str) {
        f7830a = str;
    }

    private static void k() {
        f7833k = null;
        f7831b = true;
    }

    private void l() {
        synchronized (this) {
            this.f7841l = null;
        }
    }

    public final void a() {
        this.f7843n = bb.a(this.f7839i.getApplicationContext());
        g();
        this.f7835e = new b(this.f7839i.getMainLooper());
        this.f7836f = new aq(this.f7839i);
        this.f7842m = av.a();
        j(dl.c(this.f7839i));
        try {
            h();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        synchronized (this.f7834c) {
            Iterator<OfflineMapProvince> it2 = this.f7836f.a().iterator();
            while (it2.hasNext()) {
                Iterator<OfflineMapCity> it3 = it2.next().getCityList().iterator();
                while (it3.hasNext()) {
                    OfflineMapCity next = it3.next();
                    if (next != null) {
                        this.f7834c.add(new al(this.f7839i, next));
                    }
                }
            }
        }
        ap apVar = new ap(this.f7839i);
        this.f7838h = apVar;
        apVar.start();
    }

    public final void a(al alVar) {
        a(alVar, false);
    }

    public final void a(a aVar) {
        this.f7841l = aVar;
    }

    public final void a(final String str) {
        if (str == null) {
            try {
                a aVar = this.f7841l;
                if (aVar != null) {
                    aVar.b((al) null);
                }
            } catch (Throwable th) {
                fz.c(th, "OfflineDownloadManager", "checkUpdate");
            }
        } else {
            if (this.f7844o == null) {
                this.f7844o = dk.a("AMapOfflineCheckUpdate");
            }
            this.f7844o.a(new ie() {
                public final void runTask() {
                    al a2 = am.this.h(str);
                    if (a2 != null) {
                        try {
                            if (!a2.c().equals(a2.f7811c)) {
                                if (!a2.c().equals(a2.f7813e)) {
                                    String pinyin = a2.getPinyin();
                                    if (pinyin.length() > 0) {
                                        String d2 = am.this.f7843n.d(pinyin);
                                        if (d2 == null) {
                                            d2 = a2.getVersion();
                                        }
                                        if (am.f7832d.length() > 0 && d2 != null && am.b(am.f7832d, d2)) {
                                            a2.j();
                                        }
                                    }
                                }
                            }
                            if (am.this.f7841l != null) {
                                synchronized (am.this) {
                                    try {
                                        am.this.f7841l.b(a2);
                                    } catch (Throwable th) {
                                        fz.c(th, "OfflineDownloadManager", "checkUpdatefinally");
                                    }
                                }
                                return;
                            }
                            return;
                        } catch (Exception unused) {
                            if (am.this.f7841l != null) {
                                synchronized (am.this) {
                                    am.this.f7841l.b(a2);
                                }
                            } else {
                                return;
                            }
                        } catch (Throwable th2) {
                            fz.c(th2, "OfflineDownloadManager", "checkUpdatefinally");
                        }
                    }
                    am.this.j();
                    an anVar = (an) new ao(am.this.f7839i, am.f7832d).c();
                    if (am.this.f7841l != null) {
                        if (anVar == null) {
                            if (am.this.f7841l != null) {
                                synchronized (am.this) {
                                    try {
                                        am.this.f7841l.b(a2);
                                    } catch (Throwable th3) {
                                        fz.c(th3, "OfflineDownloadManager", "checkUpdatefinally");
                                    }
                                }
                                return;
                            }
                            return;
                        } else if (anVar.a()) {
                            am.this.c();
                        }
                    }
                    if (am.this.f7841l != null) {
                        synchronized (am.this) {
                            try {
                                am.this.f7841l.b(a2);
                            } catch (Throwable th4) {
                                fz.c(th4, "OfflineDownloadManager", "checkUpdatefinally");
                            }
                        }
                        return;
                    }
                    return;
                    throw th;
                }
            });
        }
    }

    public final void b() {
        i();
        a aVar = this.f7841l;
        if (aVar != null) {
            try {
                aVar.a();
            } catch (Throwable th) {
                fz.c(th, "OfflineDownloadManager", "verifyCallBack");
            }
        }
    }

    public final void b(al alVar) {
        try {
            av avVar = this.f7842m;
            if (avVar != null) {
                avVar.a(alVar, this.f7839i);
            }
        } catch (eu e2) {
            e2.printStackTrace();
        }
    }

    public final boolean b(String str) {
        return h(str) != null;
    }

    /* access modifiers changed from: protected */
    public final void c() throws AMapException {
        if (this.f7836f != null) {
            at atVar = new at(this.f7839i, "");
            atVar.a(this.f7839i);
            List list = (List) atVar.c();
            if (this.f7834c != null) {
                this.f7836f.a((List<OfflineMapProvince>) list);
            }
            List<al> list2 = this.f7834c;
            if (list2 != null) {
                synchronized (list2) {
                    Iterator<OfflineMapProvince> it2 = this.f7836f.a().iterator();
                    while (it2.hasNext()) {
                        Iterator<OfflineMapCity> it3 = it2.next().getCityList().iterator();
                        while (it3.hasNext()) {
                            OfflineMapCity next = it3.next();
                            for (al next2 : this.f7834c) {
                                if (next.getPinyin().equals(next2.getPinyin())) {
                                    String version = next2.getVersion();
                                    if (next2.getState() != 4 || f7832d.length() <= 0 || !b(f7832d, version)) {
                                        next2.setCity(next.getCity());
                                        next2.setUrl(next.getUrl());
                                        next2.s();
                                        next2.setAdcode(next.getAdcode());
                                        next2.setVersion(next.getVersion());
                                        next2.setSize(next.getSize());
                                        next2.setCode(next.getCode());
                                        next2.setJianpin(next.getJianpin());
                                        next2.setPinyin(next.getPinyin());
                                    } else {
                                        next2.j();
                                        next2.setUrl(next.getUrl());
                                        next2.s();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public final void c(al alVar) {
        aq aqVar = this.f7836f;
        if (aqVar != null) {
            aqVar.a(alVar);
        }
        b bVar = this.f7835e;
        if (bVar != null) {
            Message obtainMessage = bVar.obtainMessage();
            obtainMessage.obj = alVar;
            this.f7835e.sendMessage(obtainMessage);
        }
    }

    public final void c(String str) {
        al h2 = h(str);
        if (h2 == null) {
            a aVar = this.f7841l;
            if (aVar != null) {
                try {
                    aVar.c(h2);
                } catch (Throwable th) {
                    fz.c(th, "OfflineDownloadManager", ProductAction.ACTION_REMOVE);
                }
            }
        } else {
            d(h2);
            a(h2, true);
        }
    }

    public final void d() {
        synchronized (this.f7834c) {
            for (al next : this.f7834c) {
                if (next.c().equals(next.f7811c) || next.c().equals(next.f7810b)) {
                    d(next);
                    next.g();
                }
            }
        }
    }

    public final void d(al alVar) {
        av avVar = this.f7842m;
        if (avVar != null) {
            avVar.a(alVar);
        }
    }

    public final void d(String str) throws AMapException {
        al h2 = h(str);
        if (str == null || str.length() <= 0 || h2 == null) {
            throw new AMapException(AMapException.ERROR_INVALID_PARAMETER);
        }
        f(h2);
    }

    public final void e() {
        synchronized (this.f7834c) {
            Iterator<al> it2 = this.f7834c.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                al next = it2.next();
                if (next.c().equals(next.f7811c)) {
                    next.g();
                    break;
                }
            }
        }
    }

    public final void e(al alVar) {
        av avVar = this.f7842m;
        if (avVar != null) {
            avVar.b(alVar);
        }
    }

    public final void e(String str) throws AMapException {
        al i2 = i(str);
        if (i2 != null) {
            f(i2);
            return;
        }
        throw new AMapException(AMapException.ERROR_INVALID_PARAMETER);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0005, code lost:
        r2 = h(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String f(java.lang.String r2) {
        /*
            r1 = this;
            java.lang.String r0 = ""
            if (r2 != 0) goto L_0x0005
            return r0
        L_0x0005:
            com.amap.api.mapcore.util.al r2 = r1.h(r2)
            if (r2 != 0) goto L_0x000c
            return r0
        L_0x000c:
            java.lang.String r2 = r2.getAdcode()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.am.f(java.lang.String):java.lang.String");
    }

    public final void f() {
        id idVar = this.f7844o;
        if (idVar != null) {
            idVar.c();
        }
        id idVar2 = this.f7846q;
        if (idVar2 != null) {
            idVar2.c();
        }
        ap apVar = this.f7838h;
        if (apVar != null) {
            if (apVar.isAlive()) {
                this.f7838h.interrupt();
            }
            this.f7838h = null;
        }
        b bVar = this.f7835e;
        if (bVar != null) {
            bVar.removeCallbacksAndMessages((Object) null);
            this.f7835e = null;
        }
        av avVar = this.f7842m;
        if (avVar != null) {
            avVar.b();
        }
        aq aqVar = this.f7836f;
        if (aqVar != null) {
            aqVar.g();
        }
        k();
        this.f7840j = true;
        l();
    }
}
