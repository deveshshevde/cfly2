package io.reactivex.internal.util;

import io.reactivex.exceptions.ProtocolViolationException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;
import ly.a;
import oj.c;

public final class b {
    public static String a(String str) {
        return "It is not allowed to subscribe with a(n) " + str + " multiple times. Please create a fresh instance of " + str + " and subscribe that to the target source instead.";
    }

    public static void a(Class<?> cls) {
        a.a((Throwable) new ProtocolViolationException(a(cls.getName())));
    }

    public static boolean a(AtomicReference<c> atomicReference, c cVar, Class<?> cls) {
        lw.b.a(cVar, "next is null");
        if (atomicReference.compareAndSet((Object) null, cVar)) {
            return true;
        }
        cVar.c();
        if (atomicReference.get() == SubscriptionHelper.CANCELLED) {
            return false;
        }
        a(cls);
        return false;
    }
}
