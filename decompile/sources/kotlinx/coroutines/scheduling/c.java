package kotlinx.coroutines.scheduling;

import java.util.concurrent.RejectedExecutionException;
import kotlin.coroutines.f;
import kotlinx.coroutines.ai;
import kotlinx.coroutines.ay;

public class c extends ay {

    /* renamed from: b  reason: collision with root package name */
    private CoroutineScheduler f30481b;

    /* renamed from: e  reason: collision with root package name */
    private final int f30482e;

    /* renamed from: f  reason: collision with root package name */
    private final int f30483f;

    /* renamed from: g  reason: collision with root package name */
    private final long f30484g;

    /* renamed from: h  reason: collision with root package name */
    private final String f30485h;

    public c(int i2, int i3, long j2, String str) {
        this.f30482e = i2;
        this.f30483f = i3;
        this.f30484g = j2;
        this.f30485h = str;
        this.f30481b = a();
    }

    public c(int i2, int i3, String str) {
        this(i2, i3, k.f30502e, str);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(int i2, int i3, String str, int i4, f fVar) {
        this((i4 & 1) != 0 ? k.f30500c : i2, (i4 & 2) != 0 ? k.f30501d : i3, (i4 & 4) != 0 ? "DefaultDispatcher" : str);
    }

    private final CoroutineScheduler a() {
        return new CoroutineScheduler(this.f30482e, this.f30483f, this.f30484g, this.f30485h);
    }

    public final void a(Runnable runnable, i iVar, boolean z2) {
        try {
            this.f30481b.a(runnable, iVar, z2);
        } catch (RejectedExecutionException unused) {
            ai.f30301b.a((Runnable) this.f30481b.a(runnable, iVar));
        }
    }

    public void a(f fVar, Runnable runnable) {
        try {
            CoroutineScheduler.a(this.f30481b, runnable, (i) null, false, 6, (Object) null);
        } catch (RejectedExecutionException unused) {
            ai.f30301b.a(fVar, runnable);
        }
    }

    public void close() {
        this.f30481b.close();
    }

    public String toString() {
        return super.toString() + "[scheduler = " + this.f30481b + ']';
    }
}
