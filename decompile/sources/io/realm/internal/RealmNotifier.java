package io.realm.internal;

import io.realm.internal.g;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;

public abstract class RealmNotifier implements Closeable {
    private final g.a<a> onChangeCallBack = new g.a<a>() {
        public void a(a aVar, Object obj) {
            if (RealmNotifier.this.sharedRealm != null && !RealmNotifier.this.sharedRealm.isClosed()) {
                aVar.a(obj);
            }
        }
    };
    private g<a> realmObserverPairs = new g<>();
    /* access modifiers changed from: private */
    public OsSharedRealm sharedRealm;
    private List<Runnable> transactionCallbacks = new ArrayList();

    private static class a<T> extends g.b<T, io.realm.g<T>> {
        public a(T t2, io.realm.g<T> gVar) {
            super(t2, gVar);
        }

        /* access modifiers changed from: private */
        public void a(T t2) {
            if (t2 != null) {
                ((io.realm.g) this.f29041b).a(t2);
            }
        }
    }

    protected RealmNotifier(OsSharedRealm osSharedRealm) {
        this.sharedRealm = osSharedRealm;
    }

    private void removeAllChangeListeners() {
        this.realmObserverPairs.b();
    }

    public <T> void addChangeListener(T t2, io.realm.g<T> gVar) {
        this.realmObserverPairs.a(new a(t2, gVar));
    }

    public void addTransactionCallback(Runnable runnable) {
        this.transactionCallbacks.add(runnable);
    }

    /* access modifiers changed from: package-private */
    public void beforeNotify() {
        this.sharedRealm.invalidateIterators();
    }

    public void close() {
        removeAllChangeListeners();
    }

    /* access modifiers changed from: package-private */
    public void didChange() {
        this.realmObserverPairs.a(this.onChangeCallBack);
        if (!this.transactionCallbacks.isEmpty()) {
            List<Runnable> list = this.transactionCallbacks;
            this.transactionCallbacks = new ArrayList();
            for (Runnable run : list) {
                run.run();
            }
        }
    }

    public int getListenersListSize() {
        return this.realmObserverPairs.c();
    }

    public abstract boolean post(Runnable runnable);

    public <E> void removeChangeListener(E e2, io.realm.g<E> gVar) {
        this.realmObserverPairs.a(e2, gVar);
    }

    public <E> void removeChangeListeners(E e2) {
        this.realmObserverPairs.a((Object) e2);
    }
}
