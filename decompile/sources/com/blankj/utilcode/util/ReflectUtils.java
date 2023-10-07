package com.blankj.utilcode.util;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public final class ReflectUtils {
    /* access modifiers changed from: private */
    public final Object object;
    private final Class<?> type;

    private static class NULL {
        private NULL() {
        }
    }

    public static class ReflectException extends RuntimeException {
        private static final long serialVersionUID = 858774075258496016L;

        public ReflectException(String str) {
            super(str);
        }

        public ReflectException(String str, Throwable th) {
            super(str, th);
        }

        public ReflectException(Throwable th) {
            super(th);
        }
    }

    private ReflectUtils(Class<?> cls) {
        this(cls, cls);
    }

    private ReflectUtils(Class<?> cls, Object obj) {
        this.type = cls;
        this.object = obj;
    }

    private <T extends AccessibleObject> T accessible(T t2) {
        if (t2 == null) {
            return null;
        }
        if (t2 instanceof Member) {
            Member member = (Member) t2;
            if (Modifier.isPublic(member.getModifiers()) && Modifier.isPublic(member.getDeclaringClass().getModifiers())) {
                return t2;
            }
        }
        if (!t2.isAccessible()) {
            t2.setAccessible(true);
        }
        return t2;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:4|5|6) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001b, code lost:
        throw new java.lang.NoSuchMethodException();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000d, code lost:
        return r0.getDeclaredMethod(r2, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000e, code lost:
        r0 = r0.getSuperclass();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
        if (r0 != null) goto L_0x0009;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0009 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.reflect.Method exactMethod(java.lang.String r2, java.lang.Class<?>[] r3) throws java.lang.NoSuchMethodException {
        /*
            r1 = this;
            java.lang.Class r0 = r1.type()
            java.lang.reflect.Method r2 = r0.getMethod(r2, r3)     // Catch:{ NoSuchMethodException -> 0x0009 }
            return r2
        L_0x0009:
            java.lang.reflect.Method r2 = r0.getDeclaredMethod(r2, r3)     // Catch:{ NoSuchMethodException -> 0x000e }
            return r2
        L_0x000e:
            java.lang.Class r0 = r0.getSuperclass()
            if (r0 == 0) goto L_0x0015
            goto L_0x0009
        L_0x0015:
            java.lang.NoSuchMethodException r2 = new java.lang.NoSuchMethodException
            r2.<init>()
            goto L_0x001c
        L_0x001b:
            throw r2
        L_0x001c:
            goto L_0x001b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blankj.utilcode.util.ReflectUtils.exactMethod(java.lang.String, java.lang.Class[]):java.lang.reflect.Method");
    }

    private static Class<?> forName(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new ReflectException((Throwable) e2);
        }
    }

    private static Class<?> forName(String str, ClassLoader classLoader) {
        try {
            return Class.forName(str, true, classLoader);
        } catch (ClassNotFoundException e2) {
            throw new ReflectException((Throwable) e2);
        }
    }

    private Field getAccessibleField(String str) {
        Class type2 = type();
        try {
            return (Field) accessible(type2.getField(str));
        } catch (NoSuchFieldException e2) {
            do {
                try {
                    return (Field) accessible(type2.getDeclaredField(str));
                } catch (NoSuchFieldException unused) {
                    type2 = type2.getSuperclass();
                    if (type2 != null) {
                        throw new ReflectException((Throwable) e2);
                    }
                }
            } while (type2 != null);
            throw new ReflectException((Throwable) e2);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.Class<?>[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.Class<?>[] getArgsType(java.lang.Object... r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 != 0) goto L_0x0006
            java.lang.Class[] r4 = new java.lang.Class[r0]
            return r4
        L_0x0006:
            int r1 = r4.length
            java.lang.Class[] r1 = new java.lang.Class[r1]
        L_0x0009:
            int r2 = r4.length
            if (r0 >= r2) goto L_0x001c
            r2 = r4[r0]
            if (r2 != 0) goto L_0x0013
            java.lang.Class<com.blankj.utilcode.util.ReflectUtils$NULL> r2 = com.blankj.utilcode.util.ReflectUtils.NULL.class
            goto L_0x0017
        L_0x0013:
            java.lang.Class r2 = r2.getClass()
        L_0x0017:
            r1[r0] = r2
            int r0 = r0 + 1
            goto L_0x0009
        L_0x001c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blankj.utilcode.util.ReflectUtils.getArgsType(java.lang.Object[]):java.lang.Class[]");
    }

    private Field getField(String str) throws IllegalAccessException {
        Field accessibleField = getAccessibleField(str);
        if ((accessibleField.getModifiers() & 16) == 16) {
            try {
                Field declaredField = Field.class.getDeclaredField("modifiers");
                declaredField.setAccessible(true);
                declaredField.setInt(accessibleField, accessibleField.getModifiers() & -17);
            } catch (NoSuchFieldException unused) {
                accessibleField.setAccessible(true);
            }
        }
        return accessibleField;
    }

    private boolean isSimilarSignature(Method method, String str, Class<?>[] clsArr) {
        return method.getName().equals(str) && match(method.getParameterTypes(), clsArr);
    }

    private boolean match(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr.length != clsArr2.length) {
            return false;
        }
        for (int i2 = 0; i2 < clsArr2.length; i2++) {
            if (clsArr2[i2] != NULL.class && !wrapper(clsArr[i2]).isAssignableFrom(wrapper(clsArr2[i2]))) {
                return false;
            }
        }
        return true;
    }

    private ReflectUtils method(Method method, Object obj, Object... objArr) {
        try {
            accessible(method);
            if (method.getReturnType() != Void.TYPE) {
                return reflect(method.invoke(obj, objArr));
            }
            method.invoke(obj, objArr);
            return reflect(obj);
        } catch (Exception e2) {
            throw new ReflectException((Throwable) e2);
        }
    }

    private ReflectUtils newInstance(Constructor<?> constructor, Object... objArr) {
        try {
            return new ReflectUtils(constructor.getDeclaringClass(), ((Constructor) accessible(constructor)).newInstance(objArr));
        } catch (Exception e2) {
            throw new ReflectException((Throwable) e2);
        }
    }

    /* access modifiers changed from: private */
    public static String property(String str) {
        int length = str.length();
        if (length == 0) {
            return "";
        }
        if (length == 1) {
            return str.toLowerCase();
        }
        return str.substring(0, 1).toLowerCase() + str.substring(1);
    }

    public static ReflectUtils reflect(Class<?> cls) throws ReflectException {
        return new ReflectUtils(cls);
    }

    public static ReflectUtils reflect(Object obj) throws ReflectException {
        return new ReflectUtils(obj == null ? Object.class : obj.getClass(), obj);
    }

    public static ReflectUtils reflect(String str) throws ReflectException {
        return reflect(forName(str));
    }

    public static ReflectUtils reflect(String str, ClassLoader classLoader) throws ReflectException {
        return reflect(forName(str, classLoader));
    }

    private Method similarMethod(String str, Class<?>[] clsArr) throws NoSuchMethodException {
        Class type2 = type();
        ArrayList arrayList = new ArrayList();
        for (Method method : type2.getMethods()) {
            if (isSimilarSignature(method, str, clsArr)) {
                arrayList.add(method);
            }
        }
        if (arrayList.isEmpty()) {
            do {
                for (Method method2 : type2.getDeclaredMethods()) {
                    if (isSimilarSignature(method2, str, clsArr)) {
                        arrayList.add(method2);
                    }
                }
                if (arrayList.isEmpty()) {
                    type2 = type2.getSuperclass();
                }
            } while (type2 != null);
            throw new NoSuchMethodException("No similar method " + str + " with params " + Arrays.toString(clsArr) + " could be found on type " + type() + ".");
        }
        sortMethods(arrayList);
        return (Method) arrayList.get(0);
    }

    private void sortConstructors(List<Constructor<?>> list) {
        Collections.sort(list, new Comparator<Constructor<?>>() {
            public int compare(Constructor<?> constructor, Constructor<?> constructor2) {
                Class[] parameterTypes = constructor.getParameterTypes();
                Class[] parameterTypes2 = constructor2.getParameterTypes();
                int length = parameterTypes.length;
                for (int i2 = 0; i2 < length; i2++) {
                    if (!parameterTypes[i2].equals(parameterTypes2[i2])) {
                        return ReflectUtils.this.wrapper(parameterTypes[i2]).isAssignableFrom(ReflectUtils.this.wrapper(parameterTypes2[i2])) ? 1 : -1;
                    }
                }
                return 0;
            }
        });
    }

    private void sortMethods(List<Method> list) {
        Collections.sort(list, new Comparator<Method>() {
            public int compare(Method method, Method method2) {
                Class[] parameterTypes = method.getParameterTypes();
                Class[] parameterTypes2 = method2.getParameterTypes();
                int length = parameterTypes.length;
                for (int i2 = 0; i2 < length; i2++) {
                    if (!parameterTypes[i2].equals(parameterTypes2[i2])) {
                        return ReflectUtils.this.wrapper(parameterTypes[i2]).isAssignableFrom(ReflectUtils.this.wrapper(parameterTypes2[i2])) ? 1 : -1;
                    }
                }
                return 0;
            }
        });
    }

    private Class<?> type() {
        return this.type;
    }

    private Object unwrap(Object obj) {
        return obj instanceof ReflectUtils ? ((ReflectUtils) obj).get() : obj;
    }

    /* access modifiers changed from: private */
    public Class<?> wrapper(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        return cls.isPrimitive() ? Boolean.TYPE == cls ? Boolean.class : Integer.TYPE == cls ? Integer.class : Long.TYPE == cls ? Long.class : Short.TYPE == cls ? Short.class : Byte.TYPE == cls ? Byte.class : Double.TYPE == cls ? Double.class : Float.TYPE == cls ? Float.class : Character.TYPE == cls ? Character.class : Void.TYPE == cls ? Void.class : cls : cls;
    }

    public boolean equals(Object obj) {
        return (obj instanceof ReflectUtils) && this.object.equals(((ReflectUtils) obj).get());
    }

    public ReflectUtils field(String str) {
        try {
            Field field = getField(str);
            return new ReflectUtils(field.getType(), field.get(this.object));
        } catch (IllegalAccessException e2) {
            throw new ReflectException((Throwable) e2);
        }
    }

    public ReflectUtils field(String str, Object obj) {
        try {
            getField(str).set(this.object, unwrap(obj));
            return this;
        } catch (Exception e2) {
            throw new ReflectException((Throwable) e2);
        }
    }

    public <T> T get() {
        return this.object;
    }

    public int hashCode() {
        return this.object.hashCode();
    }

    public ReflectUtils method(String str) throws ReflectException {
        return method(str, new Object[0]);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:4|5|6) */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0019, code lost:
        return method(similarMethod(r4, r0), r3.object, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001a, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0020, code lost:
        throw new com.blankj.utilcode.util.ReflectUtils.ReflectException((java.lang.Throwable) r4);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x000f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.blankj.utilcode.util.ReflectUtils method(java.lang.String r4, java.lang.Object... r5) throws com.blankj.utilcode.util.ReflectUtils.ReflectException {
        /*
            r3 = this;
            java.lang.Class[] r0 = r3.getArgsType(r5)
            java.lang.reflect.Method r1 = r3.exactMethod(r4, r0)     // Catch:{ NoSuchMethodException -> 0x000f }
            java.lang.Object r2 = r3.object     // Catch:{ NoSuchMethodException -> 0x000f }
            com.blankj.utilcode.util.ReflectUtils r4 = r3.method(r1, r2, r5)     // Catch:{ NoSuchMethodException -> 0x000f }
            return r4
        L_0x000f:
            java.lang.reflect.Method r4 = r3.similarMethod(r4, r0)     // Catch:{ NoSuchMethodException -> 0x001a }
            java.lang.Object r0 = r3.object     // Catch:{ NoSuchMethodException -> 0x001a }
            com.blankj.utilcode.util.ReflectUtils r4 = r3.method(r4, r0, r5)     // Catch:{ NoSuchMethodException -> 0x001a }
            return r4
        L_0x001a:
            r4 = move-exception
            com.blankj.utilcode.util.ReflectUtils$ReflectException r5 = new com.blankj.utilcode.util.ReflectUtils$ReflectException
            r5.<init>((java.lang.Throwable) r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blankj.utilcode.util.ReflectUtils.method(java.lang.String, java.lang.Object[]):com.blankj.utilcode.util.ReflectUtils");
    }

    public ReflectUtils newInstance() {
        return newInstance(new Object[0]);
    }

    public ReflectUtils newInstance(Object... objArr) {
        Class[] argsType = getArgsType(objArr);
        try {
            return newInstance(type().getDeclaredConstructor(argsType), objArr);
        } catch (NoSuchMethodException e2) {
            ArrayList arrayList = new ArrayList();
            for (Constructor constructor : type().getDeclaredConstructors()) {
                if (match(constructor.getParameterTypes(), argsType)) {
                    arrayList.add(constructor);
                }
            }
            if (!arrayList.isEmpty()) {
                sortConstructors(arrayList);
                return newInstance((Constructor) arrayList.get(0), objArr);
            }
            throw new ReflectException((Throwable) e2);
        }
    }

    public <P> P proxy(Class<P> cls) {
        final boolean z2 = this.object instanceof Map;
        AnonymousClass3 r1 = new InvocationHandler() {
            public Object invoke(Object obj, Method method, Object[] objArr) {
                String name = method.getName();
                try {
                    return ReflectUtils.reflect(ReflectUtils.this.object).method(name, objArr).get();
                } catch (ReflectException e2) {
                    if (z2) {
                        Map map = (Map) ReflectUtils.this.object;
                        int length = objArr == null ? 0 : objArr.length;
                        if (length == 0 && name.startsWith("get")) {
                            return map.get(ReflectUtils.property(name.substring(3)));
                        }
                        if (length == 0 && name.startsWith("is")) {
                            return map.get(ReflectUtils.property(name.substring(2)));
                        }
                        if (length == 1 && name.startsWith("set")) {
                            map.put(ReflectUtils.property(name.substring(3)), objArr[0]);
                            return null;
                        }
                    }
                    throw e2;
                }
            }
        };
        return Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, r1);
    }

    public String toString() {
        return this.object.toString();
    }
}
