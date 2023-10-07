package bo;

import android.net.Uri;
import android.text.TextUtils;
import cc.k;
import com.bumptech.glide.load.c;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;

public class g implements c {

    /* renamed from: b  reason: collision with root package name */
    private final h f5873b;

    /* renamed from: c  reason: collision with root package name */
    private final URL f5874c;

    /* renamed from: d  reason: collision with root package name */
    private final String f5875d;

    /* renamed from: e  reason: collision with root package name */
    private String f5876e;

    /* renamed from: f  reason: collision with root package name */
    private URL f5877f;

    /* renamed from: g  reason: collision with root package name */
    private volatile byte[] f5878g;

    /* renamed from: h  reason: collision with root package name */
    private int f5879h;

    public g(String str) {
        this(str, h.f5881b);
    }

    public g(String str, h hVar) {
        this.f5874c = null;
        this.f5875d = k.a(str);
        this.f5873b = (h) k.a(hVar);
    }

    public g(URL url) {
        this(url, h.f5881b);
    }

    public g(URL url, h hVar) {
        this.f5874c = (URL) k.a(url);
        this.f5875d = null;
        this.f5873b = (h) k.a(hVar);
    }

    private URL d() throws MalformedURLException {
        if (this.f5877f == null) {
            this.f5877f = new URL(e());
        }
        return this.f5877f;
    }

    private String e() {
        if (TextUtils.isEmpty(this.f5876e)) {
            String str = this.f5875d;
            if (TextUtils.isEmpty(str)) {
                str = ((URL) k.a(this.f5874c)).toString();
            }
            this.f5876e = Uri.encode(str, "@#&=*+-_.,:!?()/~'%;$");
        }
        return this.f5876e;
    }

    private byte[] f() {
        if (this.f5878g == null) {
            this.f5878g = c().getBytes(f10157a);
        }
        return this.f5878g;
    }

    public URL a() throws MalformedURLException {
        return d();
    }

    public void a(MessageDigest messageDigest) {
        messageDigest.update(f());
    }

    public Map<String, String> b() {
        return this.f5873b.a();
    }

    public String c() {
        String str = this.f5875d;
        return str != null ? str : ((URL) k.a(this.f5874c)).toString();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return c().equals(gVar.c()) && this.f5873b.equals(gVar.f5873b);
    }

    public int hashCode() {
        if (this.f5879h == 0) {
            int hashCode = c().hashCode();
            this.f5879h = hashCode;
            this.f5879h = (hashCode * 31) + this.f5873b.hashCode();
        }
        return this.f5879h;
    }

    public String toString() {
        return c();
    }
}
