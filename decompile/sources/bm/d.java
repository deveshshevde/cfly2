package bm;

import bm.a;
import java.io.File;

public class d implements a.C0051a {

    /* renamed from: a  reason: collision with root package name */
    private final long f5798a;

    /* renamed from: b  reason: collision with root package name */
    private final a f5799b;

    public interface a {
        File a();
    }

    public d(a aVar, long j2) {
        this.f5798a = j2;
        this.f5799b = aVar;
    }

    public d(final String str, long j2) {
        this((a) new a() {
            public File a() {
                return new File(str);
            }
        }, j2);
    }

    public a a() {
        File a2 = this.f5799b.a();
        if (a2 == null) {
            return null;
        }
        if (a2.isDirectory() || a2.mkdirs()) {
            return e.a(a2, this.f5798a);
        }
        return null;
    }
}
