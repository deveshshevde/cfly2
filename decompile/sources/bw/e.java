package bw;

import android.content.Context;
import bw.c;

final class e implements c {

    /* renamed from: a  reason: collision with root package name */
    final c.a f6058a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f6059b;

    e(Context context, c.a aVar) {
        this.f6059b = context.getApplicationContext();
        this.f6058a = aVar;
    }

    private void a() {
        s.a(this.f6059b).a(this.f6058a);
    }

    private void b() {
        s.a(this.f6059b).b(this.f6058a);
    }

    public void e() {
        a();
    }

    public void f() {
        b();
    }

    public void g() {
    }
}
