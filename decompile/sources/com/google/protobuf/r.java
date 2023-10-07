package com.google.protobuf;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import sun.misc.Unsafe;

final class r {

    /* renamed from: a  reason: collision with root package name */
    private static final Unsafe f20172a = d();

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f20173b = f();

    /* renamed from: c  reason: collision with root package name */
    private static final boolean f20174c = e();

    /* renamed from: d  reason: collision with root package name */
    private static final long f20175d = ((long) g());

    /* renamed from: e  reason: collision with root package name */
    private static final long f20176e = a(a((Class<?>) Buffer.class, "address"));

    static byte a(byte[] bArr, long j2) {
        return f20172a.getByte(bArr, j2);
    }

    private static long a(Field field) {
        Unsafe unsafe;
        if (field == null || (unsafe = f20172a) == null) {
            return -1;
        }
        return unsafe.objectFieldOffset(field);
    }

    private static Field a(Class<?> cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    static void a(byte[] bArr, long j2, byte b2) {
        f20172a.putByte(bArr, j2, b2);
    }

    static boolean a() {
        return f20174c;
    }

    static long b(byte[] bArr, long j2) {
        return f20172a.getLong(bArr, j2);
    }

    static boolean b() {
        return f20173b;
    }

    static long c() {
        return f20175d;
    }

    private static Unsafe d() {
        try {
            return (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() {
                /* renamed from: a */
                public Unsafe run() throws Exception {
                    Class<Unsafe> cls = Unsafe.class;
                    for (Field field : cls.getDeclaredFields()) {
                        field.setAccessible(true);
                        Object obj = field.get((Object) null);
                        if (cls.isInstance(obj)) {
                            return cls.cast(obj);
                        }
                    }
                    return null;
                }
            });
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean e() {
        Unsafe unsafe = f20172a;
        if (unsafe != null) {
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("arrayBaseOffset", new Class[]{Class.class});
                cls.getMethod("getByte", new Class[]{Object.class, Long.TYPE});
                cls.getMethod("putByte", new Class[]{Object.class, Long.TYPE, Byte.TYPE});
                cls.getMethod("getLong", new Class[]{Object.class, Long.TYPE});
                cls.getMethod("copyMemory", new Class[]{Object.class, Long.TYPE, Object.class, Long.TYPE, Long.TYPE});
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    private static boolean f() {
        Unsafe unsafe = f20172a;
        if (unsafe != null) {
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", new Class[]{Field.class});
                cls.getMethod("getByte", new Class[]{Long.TYPE});
                cls.getMethod("getLong", new Class[]{Object.class, Long.TYPE});
                cls.getMethod("putByte", new Class[]{Long.TYPE, Byte.TYPE});
                cls.getMethod("getLong", new Class[]{Long.TYPE});
                cls.getMethod("copyMemory", new Class[]{Long.TYPE, Long.TYPE, Long.TYPE});
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    private static int g() {
        if (f20174c) {
            return f20172a.arrayBaseOffset(byte[].class);
        }
        return -1;
    }
}
