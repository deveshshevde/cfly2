package kotlinx.coroutines;

public class bi extends bm implements s {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f30345a;

    public bi(bg bgVar) {
        super(true);
        this.f30345a = b(bgVar);
        a(bgVar);
    }

    private final boolean b(bg bgVar) {
        while (true) {
            bm bmVar = null;
            if (!(bgVar instanceof bm)) {
                bgVar = null;
            }
            bm bmVar2 = (bm) bgVar;
            if (bmVar2 == null) {
                return false;
            }
            if (bmVar2.b()) {
                return true;
            }
            o k2 = bmVar2.k();
            if (!(k2 instanceof p)) {
                k2 = null;
            }
            p pVar = (p) k2;
            if (pVar != null) {
                bmVar = (bm) pVar.f30346b;
            }
            bgVar = bmVar;
        }
    }

    public boolean b() {
        return this.f30345a;
    }

    public boolean y_() {
        return true;
    }
}
