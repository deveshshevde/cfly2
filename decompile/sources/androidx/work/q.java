package androidx.work;

import android.os.Build;
import ao.p;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public abstract class q {

    /* renamed from: a  reason: collision with root package name */
    private UUID f5453a;

    /* renamed from: b  reason: collision with root package name */
    private p f5454b;

    /* renamed from: c  reason: collision with root package name */
    private Set<String> f5455c;

    public static abstract class a<B extends a<?, ?>, W extends q> {

        /* renamed from: a  reason: collision with root package name */
        boolean f5456a = false;

        /* renamed from: b  reason: collision with root package name */
        UUID f5457b;

        /* renamed from: c  reason: collision with root package name */
        p f5458c;

        /* renamed from: d  reason: collision with root package name */
        Set<String> f5459d = new HashSet();

        /* renamed from: e  reason: collision with root package name */
        Class<? extends ListenableWorker> f5460e;

        a(Class<? extends ListenableWorker> cls) {
            UUID randomUUID = UUID.randomUUID();
            this.f5457b = randomUUID;
            this.f5460e = cls;
            this.f5458c = new p(randomUUID.toString(), cls.getName());
            a(cls.getName());
        }

        public final B a(String str) {
            this.f5459d.add(str);
            return c();
        }

        /* access modifiers changed from: package-private */
        public abstract B c();

        /* access modifiers changed from: package-private */
        public abstract W d();

        public final W e() {
            W d2 = d();
            b bVar = this.f5458c.f5504j;
            boolean z2 = (Build.VERSION.SDK_INT >= 24 && bVar.i()) || bVar.d() || bVar.b() || (Build.VERSION.SDK_INT >= 23 && bVar.c());
            if (this.f5458c.f5511q) {
                if (z2) {
                    throw new IllegalArgumentException("Expedited jobs only support network and storage constraints");
                } else if (this.f5458c.f5501g > 0) {
                    throw new IllegalArgumentException("Expedited jobs cannot be delayed");
                }
            }
            this.f5457b = UUID.randomUUID();
            p pVar = new p(this.f5458c);
            this.f5458c = pVar;
            pVar.f5495a = this.f5457b.toString();
            return d2;
        }
    }

    protected q(UUID uuid, p pVar, Set<String> set) {
        this.f5453a = uuid;
        this.f5454b = pVar;
        this.f5455c = set;
    }

    public String a() {
        return this.f5453a.toString();
    }

    public p b() {
        return this.f5454b;
    }

    public Set<String> c() {
        return this.f5455c;
    }
}
