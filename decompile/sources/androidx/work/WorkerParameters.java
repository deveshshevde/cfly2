package androidx.work;

import android.net.Network;
import android.net.Uri;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;

public final class WorkerParameters {

    /* renamed from: a  reason: collision with root package name */
    private UUID f5087a;

    /* renamed from: b  reason: collision with root package name */
    private d f5088b;

    /* renamed from: c  reason: collision with root package name */
    private Set<String> f5089c;

    /* renamed from: d  reason: collision with root package name */
    private a f5090d;

    /* renamed from: e  reason: collision with root package name */
    private int f5091e;

    /* renamed from: f  reason: collision with root package name */
    private Executor f5092f;

    /* renamed from: g  reason: collision with root package name */
    private ap.a f5093g;

    /* renamed from: h  reason: collision with root package name */
    private s f5094h;

    /* renamed from: i  reason: collision with root package name */
    private m f5095i;

    /* renamed from: j  reason: collision with root package name */
    private f f5096j;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public List<String> f5097a = Collections.emptyList();

        /* renamed from: b  reason: collision with root package name */
        public List<Uri> f5098b = Collections.emptyList();

        /* renamed from: c  reason: collision with root package name */
        public Network f5099c;
    }

    public WorkerParameters(UUID uuid, d dVar, Collection<String> collection, a aVar, int i2, Executor executor, ap.a aVar2, s sVar, m mVar, f fVar) {
        this.f5087a = uuid;
        this.f5088b = dVar;
        this.f5089c = new HashSet(collection);
        this.f5090d = aVar;
        this.f5091e = i2;
        this.f5092f = executor;
        this.f5093g = aVar2;
        this.f5094h = sVar;
        this.f5095i = mVar;
        this.f5096j = fVar;
    }

    public UUID a() {
        return this.f5087a;
    }

    public d b() {
        return this.f5088b;
    }

    public Executor c() {
        return this.f5092f;
    }

    public ap.a d() {
        return this.f5093g;
    }

    public s e() {
        return this.f5094h;
    }

    public f f() {
        return this.f5096j;
    }
}
