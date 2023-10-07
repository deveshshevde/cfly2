package nd;

import okhttp3.ac;
import okhttp3.v;
import okio.e;

public final class h extends ac {

    /* renamed from: a  reason: collision with root package name */
    private final String f31388a;

    /* renamed from: b  reason: collision with root package name */
    private final long f31389b;

    /* renamed from: c  reason: collision with root package name */
    private final e f31390c;

    public h(String str, long j2, e eVar) {
        this.f31388a = str;
        this.f31389b = j2;
        this.f31390c = eVar;
    }

    public long contentLength() {
        return this.f31389b;
    }

    public v contentType() {
        String str = this.f31388a;
        if (str != null) {
            return v.b(str);
        }
        return null;
    }

    public e source() {
        return this.f31390c;
    }
}
