package kotlinx.coroutines.android;

import android.os.Handler;
import android.os.Looper;
import kotlin.coroutines.f;
import kotlin.jvm.internal.h;
import kotlin.l;
import kotlinx.coroutines.ak;
import kotlinx.coroutines.j;
import mr.d;

public final class a extends b implements ak {
    private volatile a _immediate;

    /* renamed from: b  reason: collision with root package name */
    private final a f30308b;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final Handler f30309d;

    /* renamed from: e  reason: collision with root package name */
    private final String f30310e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f30311f;

    /* renamed from: kotlinx.coroutines.android.a$a  reason: collision with other inner class name */
    public static final class C0212a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f30312a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ j f30313b;

        public C0212a(a aVar, j jVar) {
            this.f30312a = aVar;
            this.f30313b = jVar;
        }

        public final void run() {
            this.f30313b.a(this.f30312a, l.f30254a);
        }
    }

    public a(Handler handler, String str) {
        this(handler, str, false);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(Handler handler, String str, int i2, f fVar) {
        this(handler, (i2 & 2) != 0 ? null : str);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private a(Handler handler, String str, boolean z2) {
        super((f) null);
        a aVar = null;
        this.f30309d = handler;
        this.f30310e = str;
        this.f30311f = z2;
        this._immediate = z2 ? this : aVar;
        a aVar2 = this._immediate;
        if (aVar2 == null) {
            aVar2 = new a(handler, str, true);
            this._immediate = aVar2;
            l lVar = l.f30254a;
        }
        this.f30308b = aVar2;
    }

    public void a(long j2, j<? super l> jVar) {
        Runnable aVar = new C0212a(this, jVar);
        this.f30309d.postDelayed(aVar, d.b(j2, 4611686018427387903L));
        jVar.a(new HandlerContext$scheduleResumeAfterDelay$1(this, aVar));
    }

    public void a(f fVar, Runnable runnable) {
        this.f30309d.post(runnable);
    }

    public boolean a(f fVar) {
        return !this.f30311f || (h.a((Object) Looper.myLooper(), (Object) this.f30309d.getLooper()) ^ true);
    }

    /* renamed from: c */
    public a a() {
        return this.f30308b;
    }

    public boolean equals(Object obj) {
        return (obj instanceof a) && ((a) obj).f30309d == this.f30309d;
    }

    public int hashCode() {
        return System.identityHashCode(this.f30309d);
    }

    public String toString() {
        String b2 = b();
        if (b2 != null) {
            return b2;
        }
        a aVar = this;
        String str = aVar.f30310e;
        if (str == null) {
            str = aVar.f30309d.toString();
        }
        if (!aVar.f30311f) {
            return str;
        }
        return str + ".immediate";
    }
}
