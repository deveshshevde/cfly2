package ol;

import java.util.concurrent.atomic.AtomicReference;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final a f32479a = new a();

    /* renamed from: b  reason: collision with root package name */
    private final AtomicReference<b> f32480b = new AtomicReference<>();

    a() {
    }

    public static a a() {
        return f32479a;
    }

    public b b() {
        if (this.f32480b.get() == null) {
            this.f32480b.compareAndSet((Object) null, b.a());
        }
        return this.f32480b.get();
    }
}
