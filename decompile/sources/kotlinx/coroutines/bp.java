package kotlinx.coroutines;

public abstract class bp extends aa {
    public abstract bp a();

    /* access modifiers changed from: protected */
    public final String b() {
        bp bpVar;
        bp b2 = ap.b();
        bp bpVar2 = this;
        if (bpVar2 == b2) {
            return "Dispatchers.Main";
        }
        try {
            bpVar = b2.a();
        } catch (UnsupportedOperationException unused) {
            bpVar = null;
        }
        if (bpVar2 == bpVar) {
            return "Dispatchers.Main.immediate";
        }
        return null;
    }

    public String toString() {
        String b2 = b();
        if (b2 != null) {
            return b2;
        }
        return ah.b(this) + '@' + ah.a((Object) this);
    }
}
