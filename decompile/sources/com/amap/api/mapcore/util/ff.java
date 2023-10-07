package com.amap.api.mapcore.util;

import android.text.TextUtils;

@ge(a = "a")
public final class ff {
    @gf(a = "a1", b = 6)

    /* renamed from: a  reason: collision with root package name */
    private String f8742a;
    @gf(a = "a2", b = 6)

    /* renamed from: b  reason: collision with root package name */
    private String f8743b;
    @gf(a = "a6", b = 2)

    /* renamed from: c  reason: collision with root package name */
    private int f8744c;
    @gf(a = "a3", b = 6)

    /* renamed from: d  reason: collision with root package name */
    private String f8745d;
    @gf(a = "a4", b = 6)

    /* renamed from: e  reason: collision with root package name */
    private String f8746e;
    @gf(a = "a5", b = 6)

    /* renamed from: f  reason: collision with root package name */
    private String f8747f;

    /* renamed from: g  reason: collision with root package name */
    private String f8748g;

    /* renamed from: h  reason: collision with root package name */
    private String f8749h;

    /* renamed from: i  reason: collision with root package name */
    private String f8750i;

    /* renamed from: j  reason: collision with root package name */
    private String f8751j;

    /* renamed from: k  reason: collision with root package name */
    private String f8752k;

    /* renamed from: l  reason: collision with root package name */
    private String[] f8753l;

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public String f8754a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public String f8755b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public String f8756c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public String f8757d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public boolean f8758e = true;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public String f8759f = "standard";
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public String[] f8760g = null;

        public a(String str, String str2, String str3) {
            this.f8754a = str2;
            this.f8755b = str2;
            this.f8757d = str3;
            this.f8756c = str;
        }

        public final a a(String str) {
            this.f8755b = str;
            return this;
        }

        public final a a(String[] strArr) {
            if (strArr != null) {
                this.f8760g = (String[]) strArr.clone();
            }
            return this;
        }

        public final ff a() throws eu {
            if (this.f8760g != null) {
                return new ff(this, (byte) 0);
            }
            throw new eu("sdk packages is null");
        }
    }

    private ff() {
        this.f8744c = 1;
        this.f8753l = null;
    }

    private ff(a aVar) {
        this.f8744c = 1;
        this.f8753l = null;
        this.f8748g = aVar.f8754a;
        this.f8749h = aVar.f8755b;
        this.f8751j = aVar.f8756c;
        this.f8750i = aVar.f8757d;
        this.f8744c = aVar.f8758e ? 1 : 0;
        this.f8752k = aVar.f8759f;
        this.f8753l = aVar.f8760g;
        this.f8743b = fg.b(this.f8749h);
        this.f8742a = fg.b(this.f8751j);
        this.f8745d = fg.b(this.f8750i);
        this.f8746e = fg.b(a(this.f8753l));
        this.f8747f = fg.b(this.f8752k);
    }

    /* synthetic */ ff(a aVar, byte b2) {
        this(aVar);
    }

    private static String a(String[] strArr) {
        if (strArr == null) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            for (String append : strArr) {
                sb.append(append);
                sb.append(";");
            }
            return sb.toString();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static String[] a(String str) {
        try {
            return str.split(";");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final String a() {
        if (TextUtils.isEmpty(this.f8751j) && !TextUtils.isEmpty(this.f8742a)) {
            this.f8751j = fg.c(this.f8742a);
        }
        return this.f8751j;
    }

    public final void a(boolean z2) {
        this.f8744c = z2 ? 1 : 0;
    }

    public final String b() {
        return this.f8748g;
    }

    public final String c() {
        if (TextUtils.isEmpty(this.f8749h) && !TextUtils.isEmpty(this.f8743b)) {
            this.f8749h = fg.c(this.f8743b);
        }
        return this.f8749h;
    }

    public final String d() {
        if (TextUtils.isEmpty(this.f8750i) && !TextUtils.isEmpty(this.f8745d)) {
            this.f8750i = fg.c(this.f8745d);
        }
        return this.f8750i;
    }

    public final String e() {
        if (TextUtils.isEmpty(this.f8752k) && !TextUtils.isEmpty(this.f8747f)) {
            this.f8752k = fg.c(this.f8747f);
        }
        if (TextUtils.isEmpty(this.f8752k)) {
            this.f8752k = "standard";
        }
        return this.f8752k;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        try {
            return this.f8751j.equals(((ff) obj).f8751j) && this.f8748g.equals(((ff) obj).f8748g) && this.f8749h.equals(((ff) obj).f8749h);
        } catch (Throwable unused) {
        }
    }

    public final boolean f() {
        return this.f8744c == 1;
    }

    public final String[] g() {
        String[] strArr = this.f8753l;
        if ((strArr == null || strArr.length == 0) && !TextUtils.isEmpty(this.f8746e)) {
            this.f8753l = a(fg.c(this.f8746e));
        }
        return (String[]) this.f8753l.clone();
    }
}
