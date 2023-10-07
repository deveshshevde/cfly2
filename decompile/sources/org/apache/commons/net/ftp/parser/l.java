package org.apache.commons.net.ftp.parser;

import org.apache.commons.net.ftp.d;

public class l extends b {
    public l() {
        this((d) null);
    }

    public l(d dVar) {
        super("(\\S+)\\s+(?:(\\d+)\\s+)?(?:(\\S+)\\s+(\\S+)\\s+)?(\\*STMF|\\*DIR|\\*FILE|\\*MEM)\\s+(?:(\\S+)\\s*)?");
        a(dVar);
    }

    private boolean e(String str) {
        return str == null || str.isEmpty();
    }

    /* JADX WARNING: Removed duplicated region for block: B:54:0x00ee  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.apache.commons.net.ftp.FTPFile a(java.lang.String r12) {
        /*
            r11 = this;
            org.apache.commons.net.ftp.FTPFile r0 = new org.apache.commons.net.ftp.FTPFile
            r0.<init>()
            r0.d(r12)
            boolean r12 = r11.c(r12)
            r1 = 0
            if (r12 == 0) goto L_0x0109
            r12 = 1
            java.lang.String r2 = r11.b(r12)
            r3 = 2
            java.lang.String r3 = r11.b(r3)
            r4 = 3
            java.lang.String r5 = r11.b(r4)
            boolean r5 = r11.e(r5)
            r6 = 4
            if (r5 == 0) goto L_0x0033
            java.lang.String r5 = r11.b(r6)
            boolean r5 = r11.e(r5)
            if (r5 != 0) goto L_0x0030
            goto L_0x0033
        L_0x0030:
            java.lang.String r5 = ""
            goto L_0x004f
        L_0x0033:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r7 = r11.b(r4)
            r5.append(r7)
            java.lang.String r7 = " "
            r5.append(r7)
            java.lang.String r6 = r11.b(r6)
            r5.append(r6)
            java.lang.String r5 = r5.toString()
        L_0x004f:
            r6 = 5
            java.lang.String r6 = r11.b(r6)
            r7 = 6
            java.lang.String r7 = r11.b(r7)
            java.util.Calendar r8 = super.b(r5)     // Catch:{ ParseException -> 0x0061 }
            r0.a((java.util.Calendar) r8)     // Catch:{ ParseException -> 0x0061 }
            goto L_0x0062
        L_0x0061:
        L_0x0062:
            java.lang.String r8 = "*STMF"
            boolean r8 = r6.equalsIgnoreCase(r8)
            r9 = 47
            r10 = 0
            if (r8 == 0) goto L_0x007e
            boolean r4 = r11.e(r3)
            if (r4 != 0) goto L_0x007d
            boolean r4 = r11.e(r7)
            if (r4 == 0) goto L_0x007a
            goto L_0x007d
        L_0x007a:
            r1 = 1
        L_0x007b:
            r4 = 0
            goto L_0x00d7
        L_0x007d:
            return r1
        L_0x007e:
            java.lang.String r8 = "*DIR"
            boolean r8 = r6.equalsIgnoreCase(r8)
            if (r8 == 0) goto L_0x0097
            boolean r4 = r11.e(r3)
            if (r4 != 0) goto L_0x0096
            boolean r4 = r11.e(r7)
            if (r4 == 0) goto L_0x0093
            goto L_0x0096
        L_0x0093:
            r1 = 1
            r4 = 1
            goto L_0x00d7
        L_0x0096:
            return r1
        L_0x0097:
            java.lang.String r8 = "*FILE"
            boolean r8 = r6.equalsIgnoreCase(r8)
            if (r8 == 0) goto L_0x00b2
            if (r7 == 0) goto L_0x00b1
            java.util.Locale r4 = java.util.Locale.ROOT
            java.lang.String r4 = r7.toUpperCase(r4)
            java.lang.String r5 = ".SAVF"
            boolean r4 = r4.endsWith(r5)
            if (r4 == 0) goto L_0x00b1
        L_0x00af:
            r1 = 0
            goto L_0x007b
        L_0x00b1:
            return r1
        L_0x00b2:
            java.lang.String r8 = "*MEM"
            boolean r6 = r6.equalsIgnoreCase(r8)
            if (r6 == 0) goto L_0x00d6
            boolean r4 = r11.e(r7)
            if (r4 == 0) goto L_0x00c1
            return r1
        L_0x00c1:
            boolean r4 = r11.e(r3)
            if (r4 == 0) goto L_0x00d5
            boolean r4 = r11.e(r5)
            if (r4 != 0) goto L_0x00ce
            goto L_0x00d5
        L_0x00ce:
            char r1 = java.io.File.separatorChar
            java.lang.String r7 = r7.replace(r9, r1)
            goto L_0x00af
        L_0x00d5:
            return r1
        L_0x00d6:
            r1 = 1
        L_0x00d7:
            r0.b((int) r4)
            r0.e(r2)
            long r2 = java.lang.Long.parseLong(r3)     // Catch:{ NumberFormatException -> 0x00e5 }
            r0.a((long) r2)     // Catch:{ NumberFormatException -> 0x00e5 }
            goto L_0x00e6
        L_0x00e5:
        L_0x00e6:
            java.lang.String r2 = "/"
            boolean r2 = r7.endsWith(r2)
            if (r2 == 0) goto L_0x00f7
            int r2 = r7.length()
            int r2 = r2 - r12
            java.lang.String r7 = r7.substring(r10, r2)
        L_0x00f7:
            if (r1 == 0) goto L_0x0105
            int r1 = r7.lastIndexOf(r9)
            r2 = -1
            if (r1 <= r2) goto L_0x0105
            int r1 = r1 + r12
            java.lang.String r7 = r7.substring(r1)
        L_0x0105:
            r0.c(r7)
            return r0
        L_0x0109:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.net.ftp.parser.l.a(java.lang.String):org.apache.commons.net.ftp.FTPFile");
    }

    /* access modifiers changed from: protected */
    public d a() {
        return new d("OS/400", "yy/MM/dd HH:mm:ss", (String) null);
    }
}
