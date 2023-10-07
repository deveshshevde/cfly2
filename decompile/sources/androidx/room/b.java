package androidx.room;

import ag.f;

public abstract class b<T> extends n {
    public b(RoomDatabase roomDatabase) {
        super(roomDatabase);
    }

    /* access modifiers changed from: protected */
    public abstract void a(f fVar, T t2);

    public final void a(T t2) {
        f c2 = c();
        try {
            a(c2, t2);
            c2.b();
        } finally {
            a(c2);
        }
    }
}
