package org.apache.commons.net.ftp.parser;

import org.apache.commons.net.ftp.d;

public class i extends b {

    /* renamed from: b  reason: collision with root package name */
    private final e f32886b;

    public i() {
        this((d) null);
    }

    public i(d dVar) {
        super("(\\S+)\\s+(\\S+)\\s+(?:(<DIR>)|([0-9]+))\\s+(\\S.*)", 32);
        a(dVar);
        d dVar2 = new d("WINDOWS", "MM-dd-yy kk:mm", (String) null);
        dVar2.a("MM-dd-yy kk:mm");
        f fVar = new f();
        this.f32886b = fVar;
        fVar.a(dVar2);
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0044 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.apache.commons.net.ftp.FTPFile a(java.lang.String r8) {
        /*
            r7 = this;
            org.apache.commons.net.ftp.FTPFile r0 = new org.apache.commons.net.ftp.FTPFile
            r0.<init>()
            r0.d(r8)
            boolean r8 = r7.c(r8)
            r1 = 0
            if (r8 == 0) goto L_0x0082
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r2 = 1
            java.lang.String r3 = r7.b(r2)
            r8.append(r3)
            java.lang.String r3 = " "
            r8.append(r3)
            r3 = 2
            java.lang.String r3 = r7.b(r3)
            r8.append(r3)
            java.lang.String r8 = r8.toString()
            r3 = 3
            java.lang.String r3 = r7.b(r3)
            r4 = 4
            java.lang.String r4 = r7.b(r4)
            r5 = 5
            java.lang.String r5 = r7.b(r5)
            java.util.Calendar r6 = super.b(r8)     // Catch:{ ParseException -> 0x0044 }
            r0.a((java.util.Calendar) r6)     // Catch:{ ParseException -> 0x0044 }
            goto L_0x004f
        L_0x0044:
            org.apache.commons.net.ftp.parser.e r6 = r7.f32886b     // Catch:{ ParseException -> 0x004e }
            java.util.Calendar r8 = r6.a(r8)     // Catch:{ ParseException -> 0x004e }
            r0.a((java.util.Calendar) r8)     // Catch:{ ParseException -> 0x004e }
            goto L_0x004f
        L_0x004e:
        L_0x004f:
            if (r5 == 0) goto L_0x0082
            java.lang.String r8 = "."
            boolean r8 = r5.equals(r8)
            if (r8 != 0) goto L_0x0082
            java.lang.String r8 = ".."
            boolean r8 = r5.equals(r8)
            if (r8 == 0) goto L_0x0062
            goto L_0x0082
        L_0x0062:
            r0.c(r5)
            java.lang.String r8 = "<DIR>"
            boolean r8 = r8.equals(r3)
            if (r8 == 0) goto L_0x0076
            r0.b((int) r2)
            r1 = 0
        L_0x0072:
            r0.a((long) r1)
            goto L_0x0081
        L_0x0076:
            r8 = 0
            r0.b((int) r8)
            if (r4 == 0) goto L_0x0081
            long r1 = java.lang.Long.parseLong(r4)
            goto L_0x0072
        L_0x0081:
            return r0
        L_0x0082:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.net.ftp.parser.i.a(java.lang.String):org.apache.commons.net.ftp.FTPFile");
    }

    public d a() {
        return new d("WINDOWS", "MM-dd-yy hh:mma", (String) null);
    }
}
