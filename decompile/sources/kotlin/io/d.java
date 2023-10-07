package kotlin.io;

import java.io.File;
import java.nio.charset.Charset;
import kotlin.jvm.internal.h;

class d extends c {
    public static final void a(File file, String str, Charset charset) {
        h.d(file, "$this$writeText");
        h.d(str, "text");
        h.d(charset, "charset");
        byte[] bytes = str.getBytes(charset);
        h.b(bytes, "(this as java.lang.String).getBytes(charset)");
        b.a(file, bytes);
    }

    public static /* synthetic */ void a(File file, String str, Charset charset, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            charset = kotlin.text.d.f30261a;
        }
        b.a(file, str, charset);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0022, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0023, code lost:
        kotlin.io.a.a(r0, r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void a(java.io.File r2, byte[] r3) {
        /*
            java.lang.String r0 = "$this$writeBytes"
            kotlin.jvm.internal.h.d(r2, r0)
            java.lang.String r0 = "array"
            kotlin.jvm.internal.h.d(r3, r0)
            java.io.FileOutputStream r0 = new java.io.FileOutputStream
            r0.<init>(r2)
            java.io.Closeable r0 = (java.io.Closeable) r0
            r2 = 0
            java.lang.Throwable r2 = (java.lang.Throwable) r2
            r1 = r0
            java.io.FileOutputStream r1 = (java.io.FileOutputStream) r1     // Catch:{ all -> 0x0020 }
            r1.write(r3)     // Catch:{ all -> 0x0020 }
            kotlin.l r3 = kotlin.l.f30254a     // Catch:{ all -> 0x0020 }
            kotlin.io.a.a(r0, r2)
            return
        L_0x0020:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0022 }
        L_0x0022:
            r3 = move-exception
            kotlin.io.a.a(r0, r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.d.a(java.io.File, byte[]):void");
    }
}
