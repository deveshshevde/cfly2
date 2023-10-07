package io.realm.internal;

import io.realm.e;
import io.realm.g;
import io.realm.internal.ObservableCollection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class OsResults implements ObservableCollection, e {

    /* renamed from: b  reason: collision with root package name */
    private static final long f28993b = nativeGetFinalizerPtr();

    /* renamed from: a  reason: collision with root package name */
    private final long f28994a;

    /* renamed from: c  reason: collision with root package name */
    private final OsSharedRealm f28995c;

    /* renamed from: d  reason: collision with root package name */
    private final d f28996d;

    /* renamed from: e  reason: collision with root package name */
    private final Table f28997e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f28998f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f28999g;

    /* renamed from: h  reason: collision with root package name */
    private final g<ObservableCollection.b> f29000h;

    public static abstract class a<T> implements Iterator<T> {

        /* renamed from: a  reason: collision with root package name */
        OsResults f29001a;

        /* renamed from: b  reason: collision with root package name */
        protected int f29002b;

        /* access modifiers changed from: package-private */
        public T a(int i2) {
            return a(this.f29001a.a(i2));
        }

        /* access modifiers changed from: protected */
        public abstract T a(UncheckedRow uncheckedRow);

        /* access modifiers changed from: package-private */
        public void a() {
            this.f29001a = this.f29001a.a();
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.f29001a = null;
        }

        /* access modifiers changed from: package-private */
        public void c() {
            if (this.f29001a == null) {
                throw new ConcurrentModificationException("No outside changes to a Realm is allowed while iterating a living Realm collection.");
            }
        }

        public boolean hasNext() {
            c();
            return ((long) (this.f29002b + 1)) < this.f29001a.c();
        }

        public T next() {
            c();
            int i2 = this.f29002b + 1;
            this.f29002b = i2;
            if (((long) i2) < this.f29001a.c()) {
                return a(this.f29002b);
            }
            throw new NoSuchElementException("Cannot access index " + this.f29002b + " when size is " + this.f29001a.c() + ". Remember to check hasNext() before using next().");
        }

        @Deprecated
        public void remove() {
            throw new UnsupportedOperationException("remove() is not supported by RealmResults iterators.");
        }
    }

    private OsResults(OsSharedRealm osSharedRealm, Table table, long j2) {
        this(osSharedRealm, table, j2, false);
    }

    OsResults(OsSharedRealm osSharedRealm, Table table, long j2, boolean z2) {
        this.f28999g = false;
        this.f29000h = new g<>();
        this.f28995c = osSharedRealm;
        d dVar = osSharedRealm.context;
        this.f28996d = dVar;
        this.f28997e = table;
        this.f28994a = j2;
        dVar.a(this);
        this.f28998f = z2;
    }

    private static native Object nativeAggregate(long j2, long j3, byte b2);

    private static native void nativeClear(long j2);

    private static native boolean nativeContains(long j2, long j3);

    private static native long nativeCreateResults(long j2, long j3, SortDescriptor sortDescriptor, SortDescriptor sortDescriptor2);

    private static native long nativeCreateResultsFromBacklinks(long j2, long j3, long j4, long j5);

    private static native long nativeCreateResultsFromList(long j2, long j3, SortDescriptor sortDescriptor);

    private static native long nativeCreateSnapshot(long j2);

    private static native void nativeDelete(long j2, long j3);

    private static native boolean nativeDeleteFirst(long j2);

    private static native boolean nativeDeleteLast(long j2);

    private static native long nativeDistinct(long j2, SortDescriptor sortDescriptor);

    private static native long nativeFirstRow(long j2);

    private static native long nativeGetFinalizerPtr();

    private static native byte nativeGetMode(long j2);

    private static native long nativeGetRow(long j2, int i2);

    private static native long nativeIndexOf(long j2, long j3);

    private static native boolean nativeIsValid(long j2);

    private static native long nativeLastRow(long j2);

    private static native long nativeSize(long j2);

    private static native long nativeSort(long j2, SortDescriptor sortDescriptor);

    private native void nativeStartListening(long j2);

    private native void nativeStopListening(long j2);

    private static native long nativeWhere(long j2);

    public OsResults a() {
        if (this.f28999g) {
            return this;
        }
        OsResults osResults = new OsResults(this.f28995c, this.f28997e, nativeCreateSnapshot(this.f28994a));
        osResults.f28999g = true;
        return osResults;
    }

    public UncheckedRow a(int i2) {
        return this.f28997e.d(nativeGetRow(this.f28994a, i2));
    }

    public <T> void a(T t2, e<T> eVar) {
        this.f29000h.a(t2, eVar);
        if (this.f29000h.a()) {
            nativeStopListening(this.f28994a);
        }
    }

    public <T> void a(T t2, g<T> gVar) {
        a(t2, new ObservableCollection.c(gVar));
    }

    public UncheckedRow b() {
        long nativeFirstRow = nativeFirstRow(this.f28994a);
        if (nativeFirstRow != 0) {
            return this.f28997e.d(nativeFirstRow);
        }
        return null;
    }

    public long c() {
        return nativeSize(this.f28994a);
    }

    public boolean d() {
        return nativeIsValid(this.f28994a);
    }

    public boolean e() {
        return this.f28998f;
    }

    public long getNativeFinalizerPtr() {
        return f28993b;
    }

    public long getNativePtr() {
        return this.f28994a;
    }

    public void notifyChangeListeners(long j2) {
        if (j2 != 0 || !e()) {
            boolean z2 = this.f28998f;
            this.f28998f = true;
            this.f29000h.a(new ObservableCollection.a((j2 == 0 || !z2) ? null : new OsCollectionChangeSet(j2)));
        }
    }
}
