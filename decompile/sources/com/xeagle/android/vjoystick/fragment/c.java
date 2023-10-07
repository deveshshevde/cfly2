package com.xeagle.android.vjoystick.fragment;

import com.hoho.android.usb.usb.data_proxy.d;
import com.hoho.android.usb.usb.data_proxy.f;
import com.myusb.proxy.proto.Proxy;
import com.xeagle.android.login.retrofitLogin.CameraGlobal;
import com.xeagle.android.login.retrofitLogin.sochip.SochipPresenter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f25058a = "com.xeagle.android.vjoystick.fragment.c";

    /* renamed from: b  reason: collision with root package name */
    private lc.a f25059b;

    /* renamed from: c  reason: collision with root package name */
    private final List<lc.a> f25060c;

    /* renamed from: d  reason: collision with root package name */
    private final List<lc.a> f25061d;

    /* renamed from: e  reason: collision with root package name */
    private final List<lc.a> f25062e;

    /* renamed from: f  reason: collision with root package name */
    private final List<lc.a> f25063f;

    /* renamed from: g  reason: collision with root package name */
    private final List<lc.a> f25064g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final StringBuilder f25065h;

    /* renamed from: i  reason: collision with root package name */
    private final List<b> f25066i;

    /* renamed from: j  reason: collision with root package name */
    private AtomicBoolean f25067j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public d f25068k;

    /* renamed from: l  reason: collision with root package name */
    private final f f25069l;

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final c f25074a = new c();
    }

    public interface b {
        boolean a();
    }

    private c() {
        this.f25067j = new AtomicBoolean(false);
        this.f25069l = new f() {
            public void a(int i2, int i3, int i4, String str, byte[] bArr) {
                c.this.f25065h.append(new String(bArr));
            }

            public void a(int i2, int i3, String str, Proxy.ConnType connType) {
                c.this.f25068k.b("list_dir");
            }

            public void a(int i2, String str, int i3, Proxy.ConnType connType) {
                c.this.g();
            }

            public void a(int i2, String str, Proxy.ConnType connType) {
            }
        };
        this.f25060c = Collections.synchronizedList(new ArrayList());
        this.f25061d = Collections.synchronizedList(new ArrayList());
        this.f25062e = Collections.synchronizedList(new ArrayList());
        this.f25063f = Collections.synchronizedList(new ArrayList());
        this.f25064g = Collections.synchronizedList(new ArrayList());
        this.f25065h = new StringBuilder();
        this.f25066i = new ArrayList();
    }

    public static c a() {
        return a.f25074a;
    }

    private void a(int i2, String str) {
        d dVar = this.f25068k;
        if (dVar != null) {
            dVar.a(i2, Proxy.ConnType.HTTP, Proxy.MsgType.SEND, "172.50.10.1", 80, 0, 0, str, str.getBytes());
        }
    }

    private void a(final String str) {
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            public void run() {
                try {
                    c.this.a(org.jsoup.a.b(str).a(5000).a());
                    c.this.a(false);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void a(Document document) {
        List<lc.a> list;
        Iterator it2 = document.e("a[class=link]").iterator();
        while (it2.hasNext()) {
            String a2 = ((Element) it2.next()).e("a").a("href");
            String upperCase = a2.toUpperCase();
            if (!upperCase.startsWith(".")) {
                if (upperCase.endsWith(".MP4")) {
                    if (!this.f25062e.contains(this.f25059b)) {
                        list = this.f25062e;
                    }
                } else if (upperCase.endsWith(".JPG")) {
                    if (!this.f25061d.contains(this.f25059b)) {
                        list = this.f25061d;
                    }
                } else if (upperCase.startsWith("PAN")) {
                    if (!this.f25064g.contains(this.f25059b)) {
                        list = this.f25064g;
                    }
                } else if (upperCase.startsWith("TIME")) {
                    if (!this.f25063f.contains(this.f25059b)) {
                        list = this.f25063f;
                    }
                } else if (upperCase.endsWith("/")) {
                    lc.a aVar = new lc.a(true, "0M", a2, "-", (String) null, 1, 0);
                    if (!this.f25060c.contains(aVar)) {
                        this.f25060c.add(aVar);
                    }
                }
                list.add(this.f25059b);
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(boolean z2) {
        if (this.f25060c.isEmpty()) {
            f();
            return;
        }
        lc.a e2 = e();
        this.f25059b = e2;
        if (e2 == null) {
            f();
        } else if (z2) {
            a(14, "http://172.50.10.1/SD/AMBA/" + this.f25059b.c());
        } else {
            a("http://172.50.10.1/SD/AMBA/");
        }
    }

    private void d() {
        StringBuilder sb = this.f25065h;
        sb.delete(0, sb.length());
        this.f25060c.clear();
        this.f25061d.clear();
        this.f25062e.clear();
        this.f25063f.clear();
        this.f25064g.clear();
    }

    private lc.a e() {
        while (!this.f25060c.isEmpty()) {
            lc.a remove = this.f25060c.remove(0);
            if (remove != null && remove.a()) {
                return remove;
            }
        }
        return null;
    }

    private void f() {
        synchronized (this.f25066i) {
            this.f25067j.set(true);
            ArrayList arrayList = new ArrayList();
            for (b next : this.f25066i) {
                if (next.a()) {
                    arrayList.add(next);
                }
            }
            this.f25066i.removeAll(arrayList);
            this.f25068k.b("list_dir");
        }
    }

    /* access modifiers changed from: private */
    public void g() {
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            public void run() {
                String sb = c.this.f25065h.toString();
                c.this.f25065h.delete(0, c.this.f25065h.length());
                c.this.a(org.jsoup.a.a(sb));
                c.this.a(true);
            }
        });
    }

    public void a(int i2, boolean z2, SochipPresenter sochipPresenter) {
        synchronized (this.f25065h) {
            this.f25067j.set(false);
            d dVar = this.f25068k;
            if (dVar != null) {
                dVar.a("list_dir", this.f25069l);
            }
            d();
            if (i2 == 1) {
                if (z2) {
                    a(14, "http://172.50.10.1/SD/AMBA/");
                } else {
                    a("http://172.50.10.1/SD/AMBA/");
                }
            } else if (i2 == 2 && sochipPresenter != null) {
                sochipPresenter.getSdcardStatus(CameraGlobal.BASE_URL, 1, CameraGlobal.GET_SDCARD_STATUS);
            }
        }
    }

    public void a(d dVar) {
        synchronized (this.f25065h) {
            this.f25068k = dVar;
        }
    }

    public void a(b bVar) {
        synchronized (this.f25066i) {
            this.f25066i.add(bVar);
        }
    }

    public void a(List<lc.a> list) {
        if (list != null && !this.f25062e.isEmpty()) {
            list.addAll(this.f25062e);
        }
    }

    public void b(List<lc.a> list) {
        if (list != null && !this.f25061d.isEmpty()) {
            list.addAll(this.f25061d);
        }
    }

    public boolean b() {
        return this.f25067j.get();
    }

    public void c() {
        synchronized (this.f25065h) {
            d dVar = this.f25068k;
            if (dVar != null) {
                dVar.b("list_dir");
            }
            d();
        }
    }

    public void c(List<lc.a> list) {
        if (list != null && !this.f25064g.isEmpty()) {
            list.addAll(this.f25064g);
        }
    }

    public void d(List<lc.a> list) {
        if (list != null && !this.f25063f.isEmpty()) {
            list.addAll(this.f25063f);
        }
    }
}
