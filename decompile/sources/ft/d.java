package ft;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.f;
import com.google.android.exoplayer2.upstream.h;
import com.google.android.exoplayer2.upstream.s;
import com.google.android.exoplayer2.util.a;
import java.util.List;
import java.util.Map;

public abstract class d implements Loader.d {

    /* renamed from: c  reason: collision with root package name */
    public final h f13110c;

    /* renamed from: d  reason: collision with root package name */
    public final int f13111d;

    /* renamed from: e  reason: collision with root package name */
    public final Format f13112e;

    /* renamed from: f  reason: collision with root package name */
    public final int f13113f;

    /* renamed from: g  reason: collision with root package name */
    public final Object f13114g;

    /* renamed from: h  reason: collision with root package name */
    public final long f13115h;

    /* renamed from: i  reason: collision with root package name */
    public final long f13116i;

    /* renamed from: j  reason: collision with root package name */
    protected final s f13117j;

    public d(f fVar, h hVar, int i2, Format format, int i3, Object obj, long j2, long j3) {
        this.f13117j = new s(fVar);
        this.f13110c = (h) a.b(hVar);
        this.f13111d = i2;
        this.f13112e = format;
        this.f13113f = i3;
        this.f13114g = obj;
        this.f13115h = j2;
        this.f13116i = j3;
    }

    public final long d() {
        return this.f13116i - this.f13115h;
    }

    public final long e() {
        return this.f13117j.e();
    }

    public final Uri f() {
        return this.f13117j.f();
    }

    public final Map<String, List<String>> g() {
        return this.f13117j.g();
    }
}
