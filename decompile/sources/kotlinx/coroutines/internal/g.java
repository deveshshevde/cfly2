package kotlinx.coroutines.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Comparator;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Result;
import kotlin.i;
import kotlin.jvm.internal.h;
import mm.b;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    private static final int f30407a = a(Throwable.class, -1);

    /* renamed from: b  reason: collision with root package name */
    private static final ReentrantReadWriteLock f30408b = new ReentrantReadWriteLock();

    /* renamed from: c  reason: collision with root package name */
    private static final WeakHashMap<Class<? extends Throwable>, b<Throwable, Throwable>> f30409c = new WeakHashMap<>();

    public static final class a<T> implements Comparator<T> {
        public final int compare(T t2, T t3) {
            return mi.a.a(Integer.valueOf(((Constructor) t3).getParameterTypes().length), Integer.valueOf(((Constructor) t2).getParameterTypes().length));
        }
    }

    private static final int a(Class<?> cls, int i2) {
        Integer num;
        kotlin.jvm.a.a(cls);
        try {
            Result.a aVar = Result.f30171a;
            num = Result.e(Integer.valueOf(a(cls, 0, 1, (Object) null)));
        } catch (Throwable th) {
            Result.a aVar2 = Result.f30171a;
            num = Result.e(i.a(th));
        }
        Integer valueOf = Integer.valueOf(i2);
        if (Result.b(num)) {
            num = valueOf;
        }
        return ((Number) num).intValue();
    }

    static /* synthetic */ int a(Class cls, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 0;
        }
        return b(cls, i2);
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public static final <E extends java.lang.Throwable> E a(E r9) {
        /*
            boolean r0 = r9 instanceof kotlinx.coroutines.y
            r1 = 0
            if (r0 == 0) goto L_0x0028
            kotlin.Result$a r0 = kotlin.Result.f30171a     // Catch:{ all -> 0x0012 }
            kotlinx.coroutines.y r9 = (kotlinx.coroutines.y) r9     // Catch:{ all -> 0x0012 }
            java.lang.Throwable r9 = r9.a()     // Catch:{ all -> 0x0012 }
            java.lang.Object r9 = kotlin.Result.e(r9)     // Catch:{ all -> 0x0012 }
            goto L_0x001d
        L_0x0012:
            r9 = move-exception
            kotlin.Result$a r0 = kotlin.Result.f30171a
            java.lang.Object r9 = kotlin.i.a((java.lang.Throwable) r9)
            java.lang.Object r9 = kotlin.Result.e(r9)
        L_0x001d:
            boolean r0 = kotlin.Result.b(r9)
            if (r0 == 0) goto L_0x0024
            goto L_0x0025
        L_0x0024:
            r1 = r9
        L_0x0025:
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            return r1
        L_0x0028:
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = f30408b
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r2 = r0.readLock()
            r2.lock()
            java.util.WeakHashMap<java.lang.Class<? extends java.lang.Throwable>, mm.b<java.lang.Throwable, java.lang.Throwable>> r3 = f30409c     // Catch:{ all -> 0x0123 }
            java.lang.Class r4 = r9.getClass()     // Catch:{ all -> 0x0123 }
            java.lang.Object r3 = r3.get(r4)     // Catch:{ all -> 0x0123 }
            mm.b r3 = (mm.b) r3     // Catch:{ all -> 0x0123 }
            r2.unlock()
            if (r3 == 0) goto L_0x0049
            java.lang.Object r9 = r3.invoke(r9)
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            return r9
        L_0x0049:
            int r2 = f30407a
            java.lang.Class r3 = r9.getClass()
            r4 = 0
            int r3 = a(r3, r4)
            if (r2 == r3) goto L_0x009e
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r2 = r0.readLock()
            int r3 = r0.getWriteHoldCount()
            if (r3 != 0) goto L_0x0065
            int r3 = r0.getReadHoldCount()
            goto L_0x0066
        L_0x0065:
            r3 = 0
        L_0x0066:
            r5 = 0
        L_0x0067:
            if (r5 >= r3) goto L_0x006f
            r2.unlock()
            int r5 = r5 + 1
            goto L_0x0067
        L_0x006f:
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r0.lock()
            java.util.WeakHashMap<java.lang.Class<? extends java.lang.Throwable>, mm.b<java.lang.Throwable, java.lang.Throwable>> r5 = f30409c     // Catch:{ all -> 0x0091 }
            java.util.Map r5 = (java.util.Map) r5     // Catch:{ all -> 0x0091 }
            java.lang.Class r9 = r9.getClass()     // Catch:{ all -> 0x0091 }
            kotlinx.coroutines.internal.ExceptionsConstuctorKt$tryCopyException$4$1 r6 = kotlinx.coroutines.internal.ExceptionsConstuctorKt$tryCopyException$4$1.f30377a     // Catch:{ all -> 0x0091 }
            r5.put(r9, r6)     // Catch:{ all -> 0x0091 }
            kotlin.l r9 = kotlin.l.f30254a     // Catch:{ all -> 0x0091 }
        L_0x0085:
            if (r4 >= r3) goto L_0x008d
            r2.lock()
            int r4 = r4 + 1
            goto L_0x0085
        L_0x008d:
            r0.unlock()
            return r1
        L_0x0091:
            r9 = move-exception
        L_0x0092:
            if (r4 >= r3) goto L_0x009a
            r2.lock()
            int r4 = r4 + 1
            goto L_0x0092
        L_0x009a:
            r0.unlock()
            throw r9
        L_0x009e:
            r0 = r1
            mm.b r0 = (mm.b) r0
            java.lang.Class r2 = r9.getClass()
            java.lang.reflect.Constructor[] r2 = r2.getConstructors()
            kotlinx.coroutines.internal.g$a r3 = new kotlinx.coroutines.internal.g$a
            r3.<init>()
            java.util.Comparator r3 = (java.util.Comparator) r3
            java.util.List r2 = kotlin.collections.b.c(r2, r3)
            java.util.Iterator r2 = r2.iterator()
        L_0x00b8:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x00ca
            java.lang.Object r0 = r2.next()
            java.lang.reflect.Constructor r0 = (java.lang.reflect.Constructor) r0
            mm.b r0 = a((java.lang.reflect.Constructor<?>) r0)
            if (r0 == 0) goto L_0x00b8
        L_0x00ca:
            java.util.concurrent.locks.ReentrantReadWriteLock r2 = f30408b
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r3 = r2.readLock()
            int r5 = r2.getWriteHoldCount()
            if (r5 != 0) goto L_0x00db
            int r5 = r2.getReadHoldCount()
            goto L_0x00dc
        L_0x00db:
            r5 = 0
        L_0x00dc:
            r6 = 0
        L_0x00dd:
            if (r6 >= r5) goto L_0x00e5
            r3.unlock()
            int r6 = r6 + 1
            goto L_0x00dd
        L_0x00e5:
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r2 = r2.writeLock()
            r2.lock()
            java.util.WeakHashMap<java.lang.Class<? extends java.lang.Throwable>, mm.b<java.lang.Throwable, java.lang.Throwable>> r6 = f30409c     // Catch:{ all -> 0x0116 }
            java.util.Map r6 = (java.util.Map) r6     // Catch:{ all -> 0x0116 }
            java.lang.Class r7 = r9.getClass()     // Catch:{ all -> 0x0116 }
            if (r0 == 0) goto L_0x00f8
            r8 = r0
            goto L_0x00fc
        L_0x00f8:
            kotlinx.coroutines.internal.ExceptionsConstuctorKt$tryCopyException$5$1 r8 = kotlinx.coroutines.internal.ExceptionsConstuctorKt$tryCopyException$5$1.f30378a     // Catch:{ all -> 0x0116 }
            mm.b r8 = (mm.b) r8     // Catch:{ all -> 0x0116 }
        L_0x00fc:
            r6.put(r7, r8)     // Catch:{ all -> 0x0116 }
            kotlin.l r6 = kotlin.l.f30254a     // Catch:{ all -> 0x0116 }
        L_0x0101:
            if (r4 >= r5) goto L_0x0109
            r3.lock()
            int r4 = r4 + 1
            goto L_0x0101
        L_0x0109:
            r2.unlock()
            if (r0 == 0) goto L_0x0115
            java.lang.Object r9 = r0.invoke(r9)
            r1 = r9
            java.lang.Throwable r1 = (java.lang.Throwable) r1
        L_0x0115:
            return r1
        L_0x0116:
            r9 = move-exception
        L_0x0117:
            if (r4 >= r5) goto L_0x011f
            r3.lock()
            int r4 = r4 + 1
            goto L_0x0117
        L_0x011f:
            r2.unlock()
            throw r9
        L_0x0123:
            r9 = move-exception
            r2.unlock()
            goto L_0x0129
        L_0x0128:
            throw r9
        L_0x0129:
            goto L_0x0128
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.g.a(java.lang.Throwable):java.lang.Throwable");
    }

    private static final b<Throwable, Throwable> a(Constructor<?> constructor) {
        b<Throwable, Throwable> bVar;
        Class[] parameterTypes = constructor.getParameterTypes();
        int length = parameterTypes.length;
        if (length == 0) {
            bVar = new ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$4(constructor);
        } else if (length == 1) {
            Class cls = parameterTypes[0];
            if (h.a((Object) cls, (Object) Throwable.class)) {
                bVar = new ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$2(constructor);
            } else if (!h.a((Object) cls, (Object) String.class)) {
                return null;
            } else {
                bVar = new ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$3(constructor);
            }
        } else if (length != 2 || !h.a((Object) parameterTypes[0], (Object) String.class) || !h.a((Object) parameterTypes[1], (Object) Throwable.class)) {
            return null;
        } else {
            bVar = new ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$1(constructor);
        }
        return bVar;
    }

    private static final int b(Class<?> cls, int i2) {
        Class<? super Object> superclass;
        do {
            Field[] declaredFields = r5.getDeclaredFields();
            int length = declaredFields.length;
            int i3 = 0;
            Class<? super Object> cls2 = cls;
            for (int i4 = 0; i4 < length; i4++) {
                if (!Modifier.isStatic(declaredFields[i4].getModifiers())) {
                    i3++;
                }
            }
            i2 += i3;
            superclass = cls2.getSuperclass();
            cls2 = superclass;
        } while (superclass != null);
        return i2;
    }
}
