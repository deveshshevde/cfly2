package kb;

import java.util.ArrayList;

public class h<T> implements f<T> {

    /* renamed from: a  reason: collision with root package name */
    private final a<T> f29966a;

    /* renamed from: b  reason: collision with root package name */
    private final a f29967b;

    /* renamed from: c  reason: collision with root package name */
    private int f29968c;

    /* renamed from: d  reason: collision with root package name */
    private final ArrayList<T> f29969d;

    public interface a {
        void a(h<?> hVar);
    }

    public h(a<T> aVar) {
        this(aVar, (a) null, -1);
    }

    public h(a<T> aVar, a aVar2, int i2) {
        this.f29969d = new ArrayList<>();
        this.f29966a = aVar;
        this.f29967b = aVar2;
        this.f29968c = i2;
    }

    public synchronized T a() {
        if (!this.f29969d.isEmpty()) {
            ArrayList<T> arrayList = this.f29969d;
            return this.f29966a.a(this, arrayList.remove(arrayList.size() - 1));
        }
        int i2 = this.f29968c;
        if (i2 == 0) {
            return null;
        }
        if (i2 > 0) {
            this.f29968c = i2 - 1;
        }
        return this.f29966a.a(this, null);
    }

    public void a(T t2) {
        boolean z2;
        a aVar;
        synchronized (this) {
            z2 = this.f29968c == 0 && this.f29969d.isEmpty();
            this.f29969d.add(t2);
        }
        if (z2 && (aVar = this.f29967b) != null) {
            aVar.a(this);
        }
    }
}
