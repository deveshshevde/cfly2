package io.reactivex.internal.disposables;

import io.reactivex.disposables.b;
import io.reactivex.exceptions.ProtocolViolationException;
import java.util.concurrent.atomic.AtomicReference;
import ly.a;

public enum DisposableHelper implements b {
    DISPOSED;

    public static void a() {
        a.a((Throwable) new ProtocolViolationException("Disposable already set!"));
    }

    public static boolean a(b bVar) {
        return bVar == DISPOSED;
    }

    public static boolean a(b bVar, b bVar2) {
        if (bVar2 == null) {
            a.a((Throwable) new NullPointerException("next is null"));
            return false;
        } else if (bVar == null) {
            return true;
        } else {
            bVar2.dispose();
            a();
            return false;
        }
    }

    public static boolean a(AtomicReference<b> atomicReference) {
        b andSet;
        b bVar = atomicReference.get();
        DisposableHelper disposableHelper = DISPOSED;
        if (bVar == disposableHelper || (andSet = atomicReference.getAndSet(disposableHelper)) == disposableHelper) {
            return false;
        }
        if (andSet == null) {
            return true;
        }
        andSet.dispose();
        return true;
    }

    public static boolean a(AtomicReference<b> atomicReference, b bVar) {
        lw.b.a(bVar, "d is null");
        if (atomicReference.compareAndSet((Object) null, bVar)) {
            return true;
        }
        bVar.dispose();
        if (atomicReference.get() == DISPOSED) {
            return false;
        }
        a();
        return false;
    }

    public static boolean b(AtomicReference<b> atomicReference, b bVar) {
        b bVar2;
        do {
            bVar2 = atomicReference.get();
            if (bVar2 == DISPOSED) {
                if (bVar == null) {
                    return false;
                }
                bVar.dispose();
                return false;
            }
        } while (!atomicReference.compareAndSet(bVar2, bVar));
        return true;
    }

    public static boolean c(AtomicReference<b> atomicReference, b bVar) {
        if (atomicReference.compareAndSet((Object) null, bVar)) {
            return true;
        }
        if (atomicReference.get() != DISPOSED) {
            return false;
        }
        bVar.dispose();
        return false;
    }

    public void dispose() {
    }

    public boolean isDisposed() {
        return true;
    }
}
