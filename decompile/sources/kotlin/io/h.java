package kotlin.io;

import java.io.BufferedReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import mt.b;
import mt.c;

public final class h {
    public static final List<String> a(Reader reader) {
        kotlin.jvm.internal.h.d(reader, "$this$readLines");
        ArrayList arrayList = new ArrayList();
        a(reader, new TextStreamsKt$readLines$1(arrayList));
        return arrayList;
    }

    public static final b<String> a(BufferedReader bufferedReader) {
        kotlin.jvm.internal.h.d(bufferedReader, "$this$lineSequence");
        return c.a(new g(bufferedReader));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0040, code lost:
        kotlin.io.a.a(r3, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0044, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void a(java.io.Reader r3, mm.b<? super java.lang.String, kotlin.l> r4) {
        /*
            java.lang.String r0 = "$this$forEachLine"
            kotlin.jvm.internal.h.d(r3, r0)
            java.lang.String r0 = "action"
            kotlin.jvm.internal.h.d(r4, r0)
            boolean r0 = r3 instanceof java.io.BufferedReader
            if (r0 == 0) goto L_0x0011
            java.io.BufferedReader r3 = (java.io.BufferedReader) r3
            goto L_0x0019
        L_0x0011:
            java.io.BufferedReader r0 = new java.io.BufferedReader
            r1 = 8192(0x2000, float:1.14794E-41)
            r0.<init>(r3, r1)
            r3 = r0
        L_0x0019:
            java.io.Closeable r3 = (java.io.Closeable) r3
            r0 = 0
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            r1 = r3
            java.io.BufferedReader r1 = (java.io.BufferedReader) r1     // Catch:{ all -> 0x003d }
            mt.b r1 = a((java.io.BufferedReader) r1)     // Catch:{ all -> 0x003d }
            java.util.Iterator r1 = r1.a()     // Catch:{ all -> 0x003d }
        L_0x0029:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x003d }
            if (r2 == 0) goto L_0x0037
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x003d }
            r4.invoke(r2)     // Catch:{ all -> 0x003d }
            goto L_0x0029
        L_0x0037:
            kotlin.l r4 = kotlin.l.f30254a     // Catch:{ all -> 0x003d }
            kotlin.io.a.a(r3, r0)
            return
        L_0x003d:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x003f }
        L_0x003f:
            r0 = move-exception
            kotlin.io.a.a(r3, r4)
            goto L_0x0045
        L_0x0044:
            throw r0
        L_0x0045:
            goto L_0x0044
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.h.a(java.io.Reader, mm.b):void");
    }
}
