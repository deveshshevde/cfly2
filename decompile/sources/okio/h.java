package okio;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class h extends s {

    /* renamed from: a  reason: collision with root package name */
    private s f32439a;

    public h(s sVar) {
        if (sVar != null) {
            this.f32439a = sVar;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    public boolean B_() {
        return this.f32439a.B_();
    }

    public s C_() {
        return this.f32439a.C_();
    }

    public long D_() {
        return this.f32439a.D_();
    }

    public final h a(s sVar) {
        if (sVar != null) {
            this.f32439a = sVar;
            return this;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    public final s a() {
        return this.f32439a;
    }

    public s a(long j2) {
        return this.f32439a.a(j2);
    }

    public s a(long j2, TimeUnit timeUnit) {
        return this.f32439a.a(j2, timeUnit);
    }

    public long d() {
        return this.f32439a.d();
    }

    public s f() {
        return this.f32439a.f();
    }

    public void g() throws IOException {
        this.f32439a.g();
    }
}
