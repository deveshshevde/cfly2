package kotlinx.coroutines.internal;

import java.io.BufferedReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.ServiceLoader;
import java.util.Set;
import kotlin.text.f;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    public static final h f30410a = new h();

    private h() {
    }

    private final <S> S a(String str, ClassLoader classLoader, Class<S> cls) {
        Class<?> cls2 = Class.forName(str, false, classLoader);
        if (cls.isAssignableFrom(cls2)) {
            return cls.cast(cls2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        }
        throw new IllegalArgumentException(("Expected service of class " + cls + ", but found " + cls2).toString());
    }

    private final List<String> a(BufferedReader bufferedReader) {
        boolean z2;
        Set linkedHashSet = new LinkedHashSet();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return kotlin.collections.h.b(linkedHashSet);
            }
            String a2 = f.a(readLine, "#", (String) null, 2, (Object) null);
            Objects.requireNonNull(a2, "null cannot be cast to non-null type kotlin.CharSequence");
            String obj = f.b(a2).toString();
            CharSequence charSequence = obj;
            boolean z3 = false;
            int i2 = 0;
            while (true) {
                if (i2 >= charSequence.length()) {
                    z2 = true;
                    break;
                }
                char charAt = charSequence.charAt(i2);
                if (!(charAt == '.' || Character.isJavaIdentifierPart(charAt))) {
                    z2 = false;
                    break;
                }
                i2++;
            }
            if (z2) {
                if (charSequence.length() > 0) {
                    z3 = true;
                }
                if (z3) {
                    linkedHashSet.add(obj);
                }
            } else {
                throw new IllegalArgumentException(("Illegal service provider class name: " + obj).toString());
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0058, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        kotlin.io.a.a(r6, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005c, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0063, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0064, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0065, code lost:
        kotlin.a.a(r6, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0068, code lost:
        throw r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x008c, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x008d, code lost:
        kotlin.io.a.a(r0, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0090, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.List<java.lang.String> a(java.net.URL r6) {
        /*
            r5 = this;
            java.lang.String r0 = r6.toString()
            java.lang.String r1 = "jar"
            r2 = 0
            r3 = 2
            r4 = 0
            boolean r1 = kotlin.text.f.b(r0, r1, r2, r3, r4)
            if (r1 == 0) goto L_0x0069
            java.lang.String r6 = "jar:file:"
            java.lang.String r6 = kotlin.text.f.b((java.lang.String) r0, (java.lang.String) r6, (java.lang.String) r4, (int) r3, (java.lang.Object) r4)
            r1 = 33
            java.lang.String r6 = kotlin.text.f.a((java.lang.String) r6, (char) r1, (java.lang.String) r4, (int) r3, (java.lang.Object) r4)
            java.lang.String r1 = "!/"
            java.lang.String r0 = kotlin.text.f.b((java.lang.String) r0, (java.lang.String) r1, (java.lang.String) r4, (int) r3, (java.lang.Object) r4)
            java.util.jar.JarFile r1 = new java.util.jar.JarFile
            r1.<init>(r6, r2)
            r6 = r4
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch:{ all -> 0x005d }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ all -> 0x005d }
            java.util.zip.ZipEntry r3 = new java.util.zip.ZipEntry     // Catch:{ all -> 0x005d }
            r3.<init>(r0)     // Catch:{ all -> 0x005d }
            java.io.InputStream r0 = r1.getInputStream(r3)     // Catch:{ all -> 0x005d }
            java.lang.String r3 = "UTF-8"
            r2.<init>(r0, r3)     // Catch:{ all -> 0x005d }
            java.io.Reader r2 = (java.io.Reader) r2     // Catch:{ all -> 0x005d }
            r6.<init>(r2)     // Catch:{ all -> 0x005d }
            java.io.Closeable r6 = (java.io.Closeable) r6     // Catch:{ all -> 0x005d }
            java.lang.Throwable r4 = (java.lang.Throwable) r4     // Catch:{ all -> 0x005d }
            r0 = r6
            java.io.BufferedReader r0 = (java.io.BufferedReader) r0     // Catch:{ all -> 0x0056 }
            kotlinx.coroutines.internal.h r2 = f30410a     // Catch:{ all -> 0x0056 }
            java.util.List r0 = r2.a((java.io.BufferedReader) r0)     // Catch:{ all -> 0x0056 }
            kotlin.io.a.a(r6, r4)     // Catch:{ all -> 0x005d }
            r1.close()     // Catch:{ all -> 0x0054 }
            return r0
        L_0x0054:
            r6 = move-exception
            throw r6
        L_0x0056:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0058 }
        L_0x0058:
            r2 = move-exception
            kotlin.io.a.a(r6, r0)     // Catch:{ all -> 0x005d }
            throw r2     // Catch:{ all -> 0x005d }
        L_0x005d:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x005f }
        L_0x005f:
            r0 = move-exception
            r1.close()     // Catch:{ all -> 0x0064 }
            throw r0
        L_0x0064:
            r0 = move-exception
            kotlin.a.a(r6, r0)
            throw r6
        L_0x0069:
            java.io.BufferedReader r0 = new java.io.BufferedReader
            java.io.InputStreamReader r1 = new java.io.InputStreamReader
            java.io.InputStream r6 = r6.openStream()
            r1.<init>(r6)
            java.io.Reader r1 = (java.io.Reader) r1
            r0.<init>(r1)
            java.io.Closeable r0 = (java.io.Closeable) r0
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            r6 = r0
            java.io.BufferedReader r6 = (java.io.BufferedReader) r6     // Catch:{ all -> 0x008a }
            kotlinx.coroutines.internal.h r1 = f30410a     // Catch:{ all -> 0x008a }
            java.util.List r6 = r1.a((java.io.BufferedReader) r6)     // Catch:{ all -> 0x008a }
            kotlin.io.a.a(r0, r4)
            return r6
        L_0x008a:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x008c }
        L_0x008c:
            r1 = move-exception
            kotlin.io.a.a(r0, r6)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.h.a(java.net.URL):java.util.List");
    }

    private final <S> List<S> b(Class<S> cls, ClassLoader classLoader) {
        try {
            return a(cls, classLoader);
        } catch (Throwable unused) {
            return kotlin.collections.h.b(ServiceLoader.load(cls, classLoader));
        }
    }

    public final List<MainDispatcherFactory> a() {
        MainDispatcherFactory mainDispatcherFactory;
        Class<MainDispatcherFactory> cls = MainDispatcherFactory.class;
        if (!i.a()) {
            return b(cls, cls.getClassLoader());
        }
        try {
            ArrayList arrayList = new ArrayList(2);
            MainDispatcherFactory mainDispatcherFactory2 = null;
            try {
                mainDispatcherFactory = cls.cast(Class.forName("kotlinx.coroutines.android.AndroidDispatcherFactory", true, cls.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (ClassNotFoundException unused) {
                mainDispatcherFactory = null;
            }
            if (mainDispatcherFactory != null) {
                arrayList.add(mainDispatcherFactory);
            }
            try {
                mainDispatcherFactory2 = cls.cast(Class.forName("kotlinx.coroutines.test.internal.TestMainDispatcherFactory", true, cls.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (ClassNotFoundException unused2) {
            }
            if (mainDispatcherFactory2 != null) {
                arrayList.add(mainDispatcherFactory2);
            }
            return arrayList;
        } catch (Throwable unused3) {
            return b(cls, cls.getClassLoader());
        }
    }

    public final <S> List<S> a(Class<S> cls, ClassLoader classLoader) {
        ArrayList<T> list = Collections.list(classLoader.getResources("META-INF/services/" + cls.getName()));
        kotlin.jvm.internal.h.b(list, "java.util.Collections.list(this)");
        Collection arrayList = new ArrayList();
        for (T a2 : list) {
            kotlin.collections.h.a(arrayList, f30410a.a((URL) a2));
        }
        Set d2 = kotlin.collections.h.d((List) arrayList);
        if (!d2.isEmpty()) {
            Iterable<String> iterable = d2;
            Collection arrayList2 = new ArrayList(kotlin.collections.h.a(iterable, 10));
            for (String a3 : iterable) {
                arrayList2.add(f30410a.a(a3, classLoader, cls));
            }
            return (List) arrayList2;
        }
        throw new IllegalArgumentException("No providers were loaded with FastServiceLoader".toString());
    }
}
