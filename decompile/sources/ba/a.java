package ba;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import be.b;

public final class a extends bc.a {

    /* renamed from: a  reason: collision with root package name */
    private Uri f5586a;

    /* renamed from: b  reason: collision with root package name */
    private Object f5587b;

    /* renamed from: c  reason: collision with root package name */
    private Bundle f5588c;

    /* renamed from: d  reason: collision with root package name */
    private int f5589d;

    /* renamed from: e  reason: collision with root package name */
    private int f5590e;

    /* renamed from: f  reason: collision with root package name */
    private b f5591f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f5592g;

    /* renamed from: h  reason: collision with root package name */
    private Bundle f5593h;

    /* renamed from: i  reason: collision with root package name */
    private int f5594i;

    /* renamed from: j  reason: collision with root package name */
    private int f5595j;

    /* renamed from: k  reason: collision with root package name */
    private String f5596k;

    public a() {
        this((String) null, (String) null);
    }

    public a(String str, String str2) {
        this(str, str2, (Uri) null, (Bundle) null);
    }

    public a(String str, String str2, Uri uri, Bundle bundle) {
        this.f5589d = -1;
        this.f5590e = 300;
        this.f5594i = -1;
        this.f5595j = -1;
        a(str);
        b(str2);
        a(uri);
        this.f5588c = bundle == null ? new Bundle() : bundle;
    }

    public Bundle a() {
        return this.f5593h;
    }

    public a a(Uri uri) {
        this.f5586a = uri;
        return this;
    }

    public a a(b bVar) {
        this.f5591f = bVar;
        return this;
    }

    public a a(String str, byte b2) {
        this.f5588c.putByte(str, b2);
        return this;
    }

    public a a(String str, double d2) {
        this.f5588c.putDouble(str, d2);
        return this;
    }

    public a a(String str, float f2) {
        this.f5588c.putFloat(str, f2);
        return this;
    }

    public a a(String str, int i2) {
        this.f5588c.putInt(str, i2);
        return this;
    }

    public a a(String str, long j2) {
        this.f5588c.putLong(str, j2);
        return this;
    }

    public a a(String str, String str2) {
        this.f5588c.putString(str, str2);
        return this;
    }

    public a a(String str, short s2) {
        this.f5588c.putShort(str, s2);
        return this;
    }

    public a a(String str, boolean z2) {
        this.f5588c.putBoolean(str, z2);
        return this;
    }

    public Object a(Context context) {
        return a(context, (bb.b) null);
    }

    public Object a(Context context, bb.b bVar) {
        return bf.a.a().a(context, this, -1, bVar);
    }

    public int b() {
        return this.f5594i;
    }

    public int c() {
        return this.f5595j;
    }

    public b d() {
        return this.f5591f;
    }

    public boolean e() {
        return this.f5592g;
    }

    public Bundle f() {
        return this.f5588c;
    }

    public Uri g() {
        return this.f5586a;
    }

    public Object h() {
        return a((Context) null);
    }

    public a i() {
        this.f5592g = true;
        return this;
    }

    public int j() {
        return this.f5589d;
    }

    public String k() {
        return this.f5596k;
    }

    public String toString() {
        return "Postcard{uri=" + this.f5586a + ", tag=" + this.f5587b + ", mBundle=" + this.f5588c + ", flags=" + this.f5589d + ", timeout=" + this.f5590e + ", provider=" + this.f5591f + ", greenChannel=" + this.f5592g + ", optionsCompat=" + this.f5593h + ", enterAnim=" + this.f5594i + ", exitAnim=" + this.f5595j + "}\n" + super.toString();
    }
}
