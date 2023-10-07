package kotlinx.coroutines.internal;

import java.util.ArrayDeque;
import java.util.Objects;
import kotlin.Pair;
import kotlin.coroutines.jvm.internal.c;
import kotlin.j;
import kotlin.jvm.internal.h;
import kotlin.text.f;

public final class v {

    /* renamed from: a  reason: collision with root package name */
    private static final String f30436a;

    /* renamed from: b  reason: collision with root package name */
    private static final String f30437b;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            java.lang.String r0 = "kotlinx.coroutines.internal.v"
            java.lang.String r1 = "kotlin.coroutines.jvm.internal.BaseContinuationImpl"
            kotlin.Result$a r2 = kotlin.Result.f30171a     // Catch:{ all -> 0x0013 }
            java.lang.Class r2 = java.lang.Class.forName(r1)     // Catch:{ all -> 0x0013 }
            java.lang.String r2 = r2.getCanonicalName()     // Catch:{ all -> 0x0013 }
            java.lang.Object r2 = kotlin.Result.e(r2)     // Catch:{ all -> 0x0013 }
            goto L_0x001e
        L_0x0013:
            r2 = move-exception
            kotlin.Result$a r3 = kotlin.Result.f30171a
            java.lang.Object r2 = kotlin.i.a((java.lang.Throwable) r2)
            java.lang.Object r2 = kotlin.Result.e(r2)
        L_0x001e:
            java.lang.Throwable r3 = kotlin.Result.c(r2)
            if (r3 != 0) goto L_0x0025
            r1 = r2
        L_0x0025:
            java.lang.String r1 = (java.lang.String) r1
            f30436a = r1
            kotlin.Result$a r1 = kotlin.Result.f30171a     // Catch:{ all -> 0x0038 }
            java.lang.Class r1 = java.lang.Class.forName(r0)     // Catch:{ all -> 0x0038 }
            java.lang.String r1 = r1.getCanonicalName()     // Catch:{ all -> 0x0038 }
            java.lang.Object r1 = kotlin.Result.e(r1)     // Catch:{ all -> 0x0038 }
            goto L_0x0043
        L_0x0038:
            r1 = move-exception
            kotlin.Result$a r2 = kotlin.Result.f30171a
            java.lang.Object r1 = kotlin.i.a((java.lang.Throwable) r1)
            java.lang.Object r1 = kotlin.Result.e(r1)
        L_0x0043:
            java.lang.Throwable r2 = kotlin.Result.c(r1)
            if (r2 != 0) goto L_0x004a
            r0 = r1
        L_0x004a:
            java.lang.String r0 = (java.lang.String) r0
            f30437b = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.v.<clinit>():void");
    }

    private static final int a(StackTraceElement[] stackTraceElementArr, String str) {
        int length = stackTraceElementArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (h.a((Object) str, (Object) stackTraceElementArr[i2].getClassName())) {
                return i2;
            }
        }
        return -1;
    }

    public static final StackTraceElement a(String str) {
        return new StackTraceElement("\b\b\b(" + str, "\b", "\b", -1);
    }

    public static final <E extends Throwable> E a(E e2) {
        E cause = e2.getCause();
        if (cause != null) {
            boolean z2 = true;
            if (!(!h.a((Object) cause.getClass(), (Object) e2.getClass()))) {
                StackTraceElement[] stackTrace = e2.getStackTrace();
                int length = stackTrace.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        z2 = false;
                        break;
                    } else if (a(stackTrace[i2])) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (z2) {
                    return cause;
                }
            }
        }
        return e2;
    }

    private static final <E extends Throwable> E a(E e2, E e3, ArrayDeque<StackTraceElement> arrayDeque) {
        arrayDeque.addFirst(a("Coroutine boundary"));
        StackTraceElement[] stackTrace = e2.getStackTrace();
        int a2 = a(stackTrace, f30436a);
        int i2 = 0;
        if (a2 == -1) {
            Object[] array = arrayDeque.toArray(new StackTraceElement[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            e3.setStackTrace((StackTraceElement[]) array);
            return e3;
        }
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[(arrayDeque.size() + a2)];
        for (int i3 = 0; i3 < a2; i3++) {
            stackTraceElementArr[i3] = stackTrace[i3];
        }
        for (StackTraceElement stackTraceElement : arrayDeque) {
            stackTraceElementArr[a2 + i2] = stackTraceElement;
            i2++;
        }
        e3.setStackTrace(stackTraceElementArr);
        return e3;
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0022 A[EDGE_INSN: B:12:0x0022->B:11:0x0022 ?: BREAK  
    EDGE_INSN: B:13:0x0022->B:11:0x0022 ?: BREAK  , RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x0012  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001b  */
    private static final java.util.ArrayDeque<java.lang.StackTraceElement> a(kotlin.coroutines.jvm.internal.c r2) {
        /*
            java.util.ArrayDeque r0 = new java.util.ArrayDeque
            r0.<init>()
            java.lang.StackTraceElement r1 = r2.getStackTraceElement()
            if (r1 == 0) goto L_0x000e
        L_0x000b:
            r0.add(r1)
        L_0x000e:
            boolean r1 = r2 instanceof kotlin.coroutines.jvm.internal.c
            if (r1 != 0) goto L_0x0013
            r2 = 0
        L_0x0013:
            if (r2 == 0) goto L_0x0022
            kotlin.coroutines.jvm.internal.c r2 = r2.getCallerFrame()
            if (r2 == 0) goto L_0x0022
            java.lang.StackTraceElement r1 = r2.getStackTraceElement()
            if (r1 == 0) goto L_0x000e
            goto L_0x000b
        L_0x0022:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.v.a(kotlin.coroutines.jvm.internal.c):java.util.ArrayDeque");
    }

    private static final void a(StackTraceElement[] stackTraceElementArr, ArrayDeque<StackTraceElement> arrayDeque) {
        int length = stackTraceElementArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                i2 = -1;
                break;
            } else if (a(stackTraceElementArr[i2])) {
                break;
            } else {
                i2++;
            }
        }
        int i3 = i2 + 1;
        int length2 = stackTraceElementArr.length - 1;
        if (length2 >= i3) {
            while (true) {
                if (a(stackTraceElementArr[length2], arrayDeque.getLast())) {
                    arrayDeque.removeLast();
                }
                arrayDeque.addFirst(stackTraceElementArr[length2]);
                if (length2 != i3) {
                    length2--;
                } else {
                    return;
                }
            }
        }
    }

    public static final boolean a(StackTraceElement stackTraceElement) {
        return f.b(stackTraceElement.getClassName(), "\b\b\b", false, 2, (Object) null);
    }

    private static final boolean a(StackTraceElement stackTraceElement, StackTraceElement stackTraceElement2) {
        return stackTraceElement.getLineNumber() == stackTraceElement2.getLineNumber() && h.a((Object) stackTraceElement.getMethodName(), (Object) stackTraceElement2.getMethodName()) && h.a((Object) stackTraceElement.getFileName(), (Object) stackTraceElement2.getFileName()) && h.a((Object) stackTraceElement.getClassName(), (Object) stackTraceElement2.getClassName());
    }

    /* access modifiers changed from: private */
    public static final <E extends Throwable> E b(E e2, c cVar) {
        Pair b2 = b(e2);
        E e3 = (Throwable) b2.c();
        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) b2.d();
        Throwable a2 = g.a(e3);
        if (a2 == null || (!h.a((Object) a2.getMessage(), (Object) e3.getMessage()))) {
            return e2;
        }
        ArrayDeque a3 = a(cVar);
        if (a3.isEmpty()) {
            return e2;
        }
        if (e3 != e2) {
            a(stackTraceElementArr, (ArrayDeque<StackTraceElement>) a3);
        }
        return a(e3, a2, a3);
    }

    private static final <E extends Throwable> Pair<E, StackTraceElement[]> b(E e2) {
        boolean z2;
        Throwable cause = e2.getCause();
        if (cause == null || !h.a((Object) cause.getClass(), (Object) e2.getClass())) {
            return j.a(e2, new StackTraceElement[0]);
        }
        StackTraceElement[] stackTrace = e2.getStackTrace();
        int length = stackTrace.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                z2 = false;
                break;
            } else if (a(stackTrace[i2])) {
                z2 = true;
                break;
            } else {
                i2++;
            }
        }
        return z2 ? j.a(cause, stackTrace) : j.a(e2, new StackTraceElement[0]);
    }
}
