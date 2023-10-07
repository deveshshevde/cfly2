package in.srain.cube.views.ptr;

public abstract class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private Runnable f13679a;

    /* renamed from: b  reason: collision with root package name */
    private byte f13680b = 0;

    public void a() {
        a((Runnable) null);
    }

    public void a(Runnable runnable) {
        if (runnable != null) {
            this.f13679a = runnable;
        }
        byte b2 = this.f13680b;
        if (b2 == 0) {
            this.f13680b = 1;
            run();
        } else if (b2 == 2) {
            b();
        }
    }

    public void b() {
        Runnable runnable = this.f13679a;
        if (runnable != null) {
            runnable.run();
        }
        this.f13680b = 2;
    }

    public void b(Runnable runnable) {
        this.f13679a = runnable;
    }
}
