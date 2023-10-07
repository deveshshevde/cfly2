package com.amap.api.mapcore.util;

@ge(a = "update_item")
public class az {
    @gf(a = "title", b = 6)

    /* renamed from: a  reason: collision with root package name */
    protected String f7884a = null;
    @gf(a = "url", b = 6)

    /* renamed from: b  reason: collision with root package name */
    protected String f7885b = null;
    @gf(a = "mAdcode", b = 6)

    /* renamed from: c  reason: collision with root package name */
    protected String f7886c = null;
    @gf(a = "fileName", b = 6)

    /* renamed from: d  reason: collision with root package name */
    protected String f7887d = null;
    @gf(a = "version", b = 6)

    /* renamed from: e  reason: collision with root package name */
    protected String f7888e = "";
    @gf(a = "lLocalLength", b = 5)

    /* renamed from: f  reason: collision with root package name */
    protected long f7889f = 0;
    @gf(a = "lRemoteLength", b = 5)

    /* renamed from: g  reason: collision with root package name */
    protected long f7890g = 0;
    @gf(a = "localPath", b = 6)

    /* renamed from: h  reason: collision with root package name */
    protected String f7891h;
    @gf(a = "isProvince", b = 2)

    /* renamed from: i  reason: collision with root package name */
    protected int f7892i = 0;
    @gf(a = "mCompleteCode", b = 2)

    /* renamed from: j  reason: collision with root package name */
    protected int f7893j;
    @gf(a = "mCityCode", b = 6)

    /* renamed from: k  reason: collision with root package name */
    protected String f7894k = "";
    @gf(a = "mState", b = 2)

    /* renamed from: l  reason: collision with root package name */
    public int f7895l;
    @gf(a = "mPinyin", b = 6)

    /* renamed from: m  reason: collision with root package name */
    public String f7896m = "";

    public static String e(String str) {
        return "mAdcode" + "='" + str + "'";
    }

    public static String f(String str) {
        return "mPinyin" + "='" + str + "'";
    }

    public final String c() {
        return this.f7884a;
    }

    public final void c(String str) {
        this.f7886c = str;
    }

    public final String d() {
        return this.f7888e;
    }

    public final void d(String str) {
        this.f7894k = str;
    }

    public final String e() {
        return this.f7886c;
    }

    public final String f() {
        return this.f7885b;
    }

    public final int g() {
        return this.f7893j;
    }

    public final String h() {
        return this.f7896m;
    }
}
