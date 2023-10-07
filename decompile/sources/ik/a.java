package ik;

import android.text.TextUtils;
import il.c;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private String f13571a;

    /* renamed from: b  reason: collision with root package name */
    private String f13572b;

    /* renamed from: c  reason: collision with root package name */
    private String f13573c;

    /* renamed from: d  reason: collision with root package name */
    private String f13574d;

    /* renamed from: e  reason: collision with root package name */
    private String f13575e;

    /* renamed from: f  reason: collision with root package name */
    private String f13576f;

    /* renamed from: g  reason: collision with root package name */
    private int f13577g;

    /* renamed from: h  reason: collision with root package name */
    private String f13578h;

    /* renamed from: i  reason: collision with root package name */
    private String f13579i;

    /* renamed from: j  reason: collision with root package name */
    private String f13580j;

    /* renamed from: k  reason: collision with root package name */
    private List<NameValuePair> f13581k;

    /* renamed from: l  reason: collision with root package name */
    private String f13582l;

    /* renamed from: m  reason: collision with root package name */
    private String f13583m;

    public a() {
        this.f13577g = -1;
    }

    public a(String str) {
        try {
            a(new URI(str));
        } catch (URISyntaxException e2) {
            c.a(e2.getMessage(), e2);
        }
    }

    public a(URI uri) {
        a(uri);
    }

    private String a(String str, Charset charset) {
        return b.a(str, charset);
    }

    private String a(List<NameValuePair> list, Charset charset) {
        return b.a((Iterable<? extends NameValuePair>) list, charset);
    }

    private List<NameValuePair> a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return b.a(str);
        }
        return null;
    }

    private void a(URI uri) {
        this.f13571a = uri.getScheme();
        this.f13572b = uri.getRawSchemeSpecificPart();
        this.f13573c = uri.getRawAuthority();
        this.f13576f = uri.getHost();
        this.f13577g = uri.getPort();
        this.f13575e = uri.getRawUserInfo();
        this.f13574d = uri.getUserInfo();
        this.f13579i = uri.getRawPath();
        this.f13578h = uri.getPath();
        this.f13580j = uri.getRawQuery();
        this.f13581k = a(uri.getRawQuery());
        this.f13583m = uri.getRawFragment();
        this.f13582l = uri.getFragment();
    }

    private static String b(String str) {
        if (str == null) {
            return null;
        }
        int i2 = 0;
        while (i2 < str.length() && str.charAt(i2) == '/') {
            i2++;
        }
        return i2 > 1 ? str.substring(i2 - 1) : str;
    }

    private String b(String str, Charset charset) {
        return b.c(str, charset).replace("+", "20%");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00b1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String b(java.nio.charset.Charset r4) {
        /*
            r3 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = r3.f13571a
            if (r1 == 0) goto L_0x0011
            r0.append(r1)
            r1 = 58
            r0.append(r1)
        L_0x0011:
            java.lang.String r1 = r3.f13572b
            if (r1 == 0) goto L_0x001a
        L_0x0015:
            r0.append(r1)
            goto L_0x00a2
        L_0x001a:
            java.lang.String r1 = r3.f13573c
            java.lang.String r2 = "//"
            if (r1 == 0) goto L_0x0029
            r0.append(r2)
            java.lang.String r1 = r3.f13573c
            r0.append(r1)
            goto L_0x006e
        L_0x0029:
            java.lang.String r1 = r3.f13576f
            if (r1 == 0) goto L_0x006e
            r0.append(r2)
            java.lang.String r1 = r3.f13575e
            java.lang.String r2 = "@"
            if (r1 == 0) goto L_0x003d
        L_0x0036:
            r0.append(r1)
            r0.append(r2)
            goto L_0x0046
        L_0x003d:
            java.lang.String r1 = r3.f13574d
            if (r1 == 0) goto L_0x0046
            java.lang.String r1 = r3.a((java.lang.String) r1, (java.nio.charset.Charset) r4)
            goto L_0x0036
        L_0x0046:
            java.lang.String r1 = r3.f13576f
            boolean r1 = org.apache.http.conn.util.InetAddressUtils.isIPv6Address(r1)
            if (r1 == 0) goto L_0x005b
            java.lang.String r1 = "["
            r0.append(r1)
            java.lang.String r1 = r3.f13576f
            r0.append(r1)
            java.lang.String r1 = "]"
            goto L_0x005d
        L_0x005b:
            java.lang.String r1 = r3.f13576f
        L_0x005d:
            r0.append(r1)
            int r1 = r3.f13577g
            if (r1 < 0) goto L_0x006e
            java.lang.String r1 = ":"
            r0.append(r1)
            int r1 = r3.f13577g
            r0.append(r1)
        L_0x006e:
            java.lang.String r1 = r3.f13579i
            if (r1 == 0) goto L_0x007a
            java.lang.String r1 = b((java.lang.String) r1)
        L_0x0076:
            r0.append(r1)
            goto L_0x0087
        L_0x007a:
            java.lang.String r1 = r3.f13578h
            if (r1 == 0) goto L_0x0087
            java.lang.String r1 = b((java.lang.String) r1)
            java.lang.String r1 = r3.b(r1, r4)
            goto L_0x0076
        L_0x0087:
            java.lang.String r1 = r3.f13580j
            java.lang.String r2 = "?"
            if (r1 == 0) goto L_0x0093
            r0.append(r2)
            java.lang.String r1 = r3.f13580j
            goto L_0x0015
        L_0x0093:
            java.util.List<org.apache.http.NameValuePair> r1 = r3.f13581k
            if (r1 == 0) goto L_0x00a2
            r0.append(r2)
            java.util.List<org.apache.http.NameValuePair> r1 = r3.f13581k
            java.lang.String r1 = r3.a((java.util.List<org.apache.http.NameValuePair>) r1, (java.nio.charset.Charset) r4)
            goto L_0x0015
        L_0x00a2:
            java.lang.String r1 = r3.f13583m
            java.lang.String r2 = "#"
            if (r1 == 0) goto L_0x00b1
            r0.append(r2)
            java.lang.String r4 = r3.f13583m
        L_0x00ad:
            r0.append(r4)
            goto L_0x00bf
        L_0x00b1:
            java.lang.String r1 = r3.f13582l
            if (r1 == 0) goto L_0x00bf
            r0.append(r2)
            java.lang.String r1 = r3.f13582l
            java.lang.String r4 = r3.c(r1, r4)
            goto L_0x00ad
        L_0x00bf:
            java.lang.String r4 = r0.toString()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: ik.a.b(java.nio.charset.Charset):java.lang.String");
    }

    private String c(String str, Charset charset) {
        return b.b(str, charset);
    }

    public a a(String str, String str2) {
        if (this.f13581k == null) {
            this.f13581k = new ArrayList();
        }
        this.f13581k.add(new BasicNameValuePair(str, str2));
        this.f13580j = null;
        this.f13572b = null;
        return this;
    }

    public URI a(Charset charset) throws URISyntaxException {
        return new URI(b(charset));
    }
}
