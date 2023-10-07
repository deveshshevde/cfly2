package bz;

import android.graphics.drawable.Drawable;
import cc.l;
import com.bumptech.glide.request.e;

public abstract class c<T> implements j<T> {

    /* renamed from: a  reason: collision with root package name */
    private final int f6127a;

    /* renamed from: b  reason: collision with root package name */
    private final int f6128b;

    /* renamed from: c  reason: collision with root package name */
    private e f6129c;

    public c() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public c(int i2, int i3) {
        if (l.a(i2, i3)) {
            this.f6127a = i2;
            this.f6128b = i3;
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + i2 + " and height: " + i3);
    }

    public final e a() {
        return this.f6129c;
    }

    public final void a(i iVar) {
        iVar.a(this.f6127a, this.f6128b);
    }

    public final void a(e eVar) {
        this.f6129c = eVar;
    }

    public void b(Drawable drawable) {
    }

    public final void b(i iVar) {
    }

    public void c(Drawable drawable) {
    }

    public void e() {
    }

    public void f() {
    }

    public void g() {
    }
}
