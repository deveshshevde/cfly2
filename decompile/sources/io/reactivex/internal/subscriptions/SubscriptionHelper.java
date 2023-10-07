package io.reactivex.internal.subscriptions;

import io.reactivex.exceptions.ProtocolViolationException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import lw.b;
import ly.a;
import oj.c;

public enum SubscriptionHelper implements c {
    CANCELLED;

    public static void a() {
        a.a((Throwable) new ProtocolViolationException("Subscription already set!"));
    }

    public static void a(AtomicReference<c> atomicReference, AtomicLong atomicLong, long j2) {
        c cVar = atomicReference.get();
        if (cVar != null) {
            cVar.a(j2);
        } else if (b(j2)) {
            io.reactivex.internal.util.a.a(atomicLong, j2);
            c cVar2 = atomicReference.get();
            if (cVar2 != null) {
                long andSet = atomicLong.getAndSet(0);
                if (andSet != 0) {
                    cVar2.a(andSet);
                }
            }
        }
    }

    public static boolean a(AtomicReference<c> atomicReference) {
        c andSet;
        c cVar = atomicReference.get();
        SubscriptionHelper subscriptionHelper = CANCELLED;
        if (cVar == subscriptionHelper || (andSet = atomicReference.getAndSet(subscriptionHelper)) == subscriptionHelper) {
            return false;
        }
        if (andSet == null) {
            return true;
        }
        andSet.c();
        return true;
    }

    public static boolean a(AtomicReference<c> atomicReference, AtomicLong atomicLong, c cVar) {
        if (!a(atomicReference, cVar)) {
            return false;
        }
        long andSet = atomicLong.getAndSet(0);
        if (andSet == 0) {
            return true;
        }
        cVar.a(andSet);
        return true;
    }

    public static boolean a(AtomicReference<c> atomicReference, c cVar) {
        b.a(cVar, "s is null");
        if (atomicReference.compareAndSet((Object) null, cVar)) {
            return true;
        }
        cVar.c();
        if (atomicReference.get() == CANCELLED) {
            return false;
        }
        a();
        return false;
    }

    public static boolean a(c cVar, c cVar2) {
        if (cVar2 == null) {
            a.a((Throwable) new NullPointerException("next is null"));
            return false;
        } else if (cVar == null) {
            return true;
        } else {
            cVar2.c();
            a();
            return false;
        }
    }

    public static boolean b(long j2) {
        if (j2 > 0) {
            return true;
        }
        a.a((Throwable) new IllegalArgumentException("n > 0 required but it was " + j2));
        return false;
    }

    public void a(long j2) {
    }

    public void c() {
    }
}
