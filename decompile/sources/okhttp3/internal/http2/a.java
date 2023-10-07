package okhttp3.internal.http2;

import nb.c;
import okio.ByteString;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final ByteString f32075a = ByteString.a(":");

    /* renamed from: b  reason: collision with root package name */
    public static final ByteString f32076b = ByteString.a(":status");

    /* renamed from: c  reason: collision with root package name */
    public static final ByteString f32077c = ByteString.a(":method");

    /* renamed from: d  reason: collision with root package name */
    public static final ByteString f32078d = ByteString.a(":path");

    /* renamed from: e  reason: collision with root package name */
    public static final ByteString f32079e = ByteString.a(":scheme");

    /* renamed from: f  reason: collision with root package name */
    public static final ByteString f32080f = ByteString.a(":authority");

    /* renamed from: g  reason: collision with root package name */
    public final ByteString f32081g;

    /* renamed from: h  reason: collision with root package name */
    public final ByteString f32082h;

    /* renamed from: i  reason: collision with root package name */
    final int f32083i;

    public a(String str, String str2) {
        this(ByteString.a(str), ByteString.a(str2));
    }

    public a(ByteString byteString, String str) {
        this(byteString, ByteString.a(str));
    }

    public a(ByteString byteString, ByteString byteString2) {
        this.f32081g = byteString;
        this.f32082h = byteString2;
        this.f32083i = byteString.g() + 32 + byteString2.g();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f32081g.equals(aVar.f32081g) && this.f32082h.equals(aVar.f32082h);
    }

    public int hashCode() {
        return ((527 + this.f32081g.hashCode()) * 31) + this.f32082h.hashCode();
    }

    public String toString() {
        return c.a("%s: %s", this.f32081g.a(), this.f32082h.a());
    }
}
