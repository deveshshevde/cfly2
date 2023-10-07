package gt;

import android.graphics.Typeface;

public final class a extends f {

    /* renamed from: a  reason: collision with root package name */
    private final Typeface f28569a;

    /* renamed from: b  reason: collision with root package name */
    private final C0185a f28570b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f28571c;

    /* renamed from: gt.a$a  reason: collision with other inner class name */
    public interface C0185a {
        void a(Typeface typeface);
    }

    public a(C0185a aVar, Typeface typeface) {
        this.f28569a = typeface;
        this.f28570b = aVar;
    }

    private void a(Typeface typeface) {
        if (!this.f28571c) {
            this.f28570b.a(typeface);
        }
    }

    public void a() {
        this.f28571c = true;
    }

    public void a(int i2) {
        a(this.f28569a);
    }

    public void a(Typeface typeface, boolean z2) {
        a(typeface);
    }
}
