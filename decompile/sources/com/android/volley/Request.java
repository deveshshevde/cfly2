package com.android.volley;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.android.volley.a;
import com.android.volley.i;
import com.android.volley.l;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Map;

public abstract class Request<T> implements Comparable<Request<T>> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final l.a f9865a;

    /* renamed from: b  reason: collision with root package name */
    private final int f9866b;

    /* renamed from: c  reason: collision with root package name */
    private final String f9867c;

    /* renamed from: d  reason: collision with root package name */
    private final int f9868d;

    /* renamed from: e  reason: collision with root package name */
    private final i.a f9869e;

    /* renamed from: f  reason: collision with root package name */
    private Integer f9870f;

    /* renamed from: g  reason: collision with root package name */
    private h f9871g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f9872h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f9873i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f9874j;

    /* renamed from: k  reason: collision with root package name */
    private long f9875k;

    /* renamed from: l  reason: collision with root package name */
    private k f9876l;

    /* renamed from: m  reason: collision with root package name */
    private a.C0077a f9877m;

    public enum Priority {
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE
    }

    public Request(int i2, String str, i.a aVar) {
        this.f9865a = l.a.f9937a ? new l.a() : null;
        this.f9872h = true;
        int i3 = 0;
        this.f9873i = false;
        this.f9874j = false;
        this.f9875k = 0;
        this.f9877m = null;
        this.f9866b = i2;
        this.f9867c = str;
        this.f9869e = aVar;
        a((k) new c());
        this.f9868d = !TextUtils.isEmpty(str) ? Uri.parse(str).getHost().hashCode() : i3;
    }

    private byte[] a(Map<String, String> map, String str) {
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry next : map.entrySet()) {
                sb.append(URLEncoder.encode((String) next.getKey(), str));
                sb.append('=');
                sb.append(URLEncoder.encode((String) next.getValue(), str));
                sb.append('&');
            }
            return sb.toString().getBytes(str);
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("Encoding not supported: " + str, e2);
        }
    }

    public int a() {
        return this.f9866b;
    }

    /* renamed from: a */
    public int compareTo(Request<T> request) {
        Priority r2 = r();
        Priority r3 = request.r();
        return r2 == r3 ? this.f9870f.intValue() - request.f9870f.intValue() : r3.ordinal() - r2.ordinal();
    }

    /* access modifiers changed from: protected */
    public VolleyError a(VolleyError volleyError) {
        return volleyError;
    }

    /* access modifiers changed from: protected */
    public abstract i<T> a(g gVar);

    public final void a(int i2) {
        this.f9870f = Integer.valueOf(i2);
    }

    public void a(a.C0077a aVar) {
        this.f9877m = aVar;
    }

    public void a(h hVar) {
        this.f9871g = hVar;
    }

    public void a(k kVar) {
        this.f9876l = kVar;
    }

    /* access modifiers changed from: protected */
    public abstract void a(T t2);

    public void a(String str) {
        if (l.a.f9937a) {
            this.f9865a.a(str, Thread.currentThread().getId());
        } else if (this.f9875k == 0) {
            this.f9875k = SystemClock.elapsedRealtime();
        }
    }

    public int b() {
        return this.f9868d;
    }

    public void b(VolleyError volleyError) {
        i.a aVar = this.f9869e;
        if (aVar != null) {
            aVar.a(volleyError);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(final String str) {
        h hVar = this.f9871g;
        if (hVar != null) {
            hVar.b(this);
        }
        if (l.a.f9937a) {
            final long id2 = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public void run() {
                        Request.this.f9865a.a(str, id2);
                        Request.this.f9865a.a(toString());
                    }
                });
                return;
            }
            this.f9865a.a(str, id2);
            this.f9865a.a(toString());
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.f9875k;
        if (elapsedRealtime >= 3000) {
            l.b("%d ms: %s", Long.valueOf(elapsedRealtime), toString());
        }
    }

    public String c() {
        return this.f9867c;
    }

    public String d() {
        return c();
    }

    public a.C0077a e() {
        return this.f9877m;
    }

    public void f() {
        this.f9873i = true;
    }

    public boolean g() {
        return this.f9873i;
    }

    public Map<String, String> h() throws AuthFailureError {
        return Collections.emptyMap();
    }

    /* access modifiers changed from: protected */
    public Map<String, String> i() throws AuthFailureError {
        return m();
    }

    /* access modifiers changed from: protected */
    public String j() {
        return n();
    }

    public String k() {
        return o();
    }

    public byte[] l() throws AuthFailureError {
        Map<String, String> i2 = i();
        if (i2 == null || i2.size() <= 0) {
            return null;
        }
        return a(i2, j());
    }

    /* access modifiers changed from: protected */
    public Map<String, String> m() throws AuthFailureError {
        return null;
    }

    /* access modifiers changed from: protected */
    public String n() {
        return "UTF-8";
    }

    public String o() {
        return "application/x-www-form-urlencoded; charset=" + n();
    }

    public byte[] p() throws AuthFailureError {
        Map<String, String> m2 = m();
        if (m2 == null || m2.size() <= 0) {
            return null;
        }
        return a(m2, n());
    }

    public final boolean q() {
        return this.f9872h;
    }

    public Priority r() {
        return Priority.NORMAL;
    }

    public final int s() {
        return this.f9876l.a();
    }

    public k t() {
        return this.f9876l;
    }

    public String toString() {
        return (this.f9873i ? "[X] " : "[ ] ") + c() + " " + ("0x" + Integer.toHexString(b())) + " " + r() + " " + this.f9870f;
    }

    public void u() {
        this.f9874j = true;
    }

    public boolean v() {
        return this.f9874j;
    }
}
