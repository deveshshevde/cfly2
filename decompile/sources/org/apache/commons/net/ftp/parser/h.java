package org.apache.commons.net.ftp.parser;

import org.apache.commons.net.ftp.d;

public class h extends b {
    public h() {
        this((d) null);
    }

    public h(d dVar) {
        super("([bcdelfmpSs-])(((r|-)(w|-)([xsStTL-]))((r|-)(w|-)([xsStTL-]))((r|-)(w|-)([xsStTL-])))\\+?\\s+((folder\\s+)|((\\d+)\\s+(\\d+)\\s+))(\\d+)\\s+((?:\\d+[-/]\\d+[-/]\\d+)|(?:\\S{3}\\s+\\d{1,2})|(?:\\d{1,2}\\s+\\S{3}))\\s+(\\d+(?::\\d+)?)\\s+(\\S*)(\\s*.*)");
        a(dVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00d5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.apache.commons.net.ftp.FTPFile a(java.lang.String r17) {
        /*
            r16 = this;
            r0 = r16
            org.apache.commons.net.ftp.FTPFile r1 = new org.apache.commons.net.ftp.FTPFile
            r1.<init>()
            r2 = r17
            r1.d(r2)
            boolean r2 = r16.c(r17)
            r3 = 0
            if (r2 == 0) goto L_0x0104
            r2 = 1
            java.lang.String r4 = r0.b(r2)
            r5 = 20
            java.lang.String r5 = r0.b(r5)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r7 = 21
            java.lang.String r7 = r0.b(r7)
            r6.append(r7)
            java.lang.String r7 = " "
            r6.append(r7)
            r7 = 22
            java.lang.String r7 = r0.b(r7)
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            r7 = 23
            java.lang.String r7 = r0.b(r7)
            r8 = 24
            java.lang.String r8 = r0.b(r8)
            java.util.Calendar r6 = super.b(r6)     // Catch:{ ParseException -> 0x0051 }
            r1.a((java.util.Calendar) r6)     // Catch:{ ParseException -> 0x0051 }
        L_0x0051:
            r6 = 0
            char r4 = r4.charAt(r6)
            r9 = 45
            r10 = 3
            r11 = 2
            if (r4 == r9) goto L_0x006c
            r9 = 108(0x6c, float:1.51E-43)
            if (r4 == r9) goto L_0x0065
            switch(r4) {
                case 98: goto L_0x0069;
                case 99: goto L_0x0069;
                case 100: goto L_0x0067;
                case 101: goto L_0x0065;
                case 102: goto L_0x006c;
                default: goto L_0x0063;
            }
        L_0x0063:
            r4 = 3
            goto L_0x006d
        L_0x0065:
            r4 = 2
            goto L_0x006d
        L_0x0067:
            r4 = 1
            goto L_0x006d
        L_0x0069:
            r4 = 0
            r9 = 1
            goto L_0x006e
        L_0x006c:
            r4 = 0
        L_0x006d:
            r9 = 0
        L_0x006e:
            r1.b((int) r4)
            r12 = 4
            r13 = 0
            r14 = 4
        L_0x0074:
            if (r13 >= r10) goto L_0x00b5
            java.lang.String r15 = r0.b(r14)
            java.lang.String r10 = "-"
            boolean r15 = r15.equals(r10)
            r15 = r15 ^ r2
            r1.a(r13, r6, r15)
            int r15 = r14 + 1
            java.lang.String r15 = r0.b(r15)
            boolean r15 = r15.equals(r10)
            r15 = r15 ^ r2
            r1.a(r13, r2, r15)
            int r15 = r14 + 2
            java.lang.String r15 = r0.b(r15)
            boolean r10 = r15.equals(r10)
            if (r10 != 0) goto L_0x00ac
            char r10 = r15.charAt(r6)
            boolean r10 = java.lang.Character.isUpperCase(r10)
            if (r10 != 0) goto L_0x00ac
            r1.a(r13, r11, r2)
            goto L_0x00af
        L_0x00ac:
            r1.a(r13, r11, r6)
        L_0x00af:
            int r13 = r13 + 1
            int r14 = r14 + 4
            r10 = 3
            goto L_0x0074
        L_0x00b5:
            if (r9 != 0) goto L_0x00c0
            java.lang.String r2 = "0"
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ NumberFormatException -> 0x00c0 }
            r1.a((int) r2)     // Catch:{ NumberFormatException -> 0x00c0 }
        L_0x00c0:
            r1.e(r3)
            r1.a((java.lang.String) r3)
            long r2 = java.lang.Long.parseLong(r5)     // Catch:{ NumberFormatException -> 0x00ce }
            r1.a((long) r2)     // Catch:{ NumberFormatException -> 0x00ce }
            goto L_0x00cf
        L_0x00ce:
        L_0x00cf:
            if (r8 != 0) goto L_0x00d5
            r1.c(r7)
            goto L_0x0103
        L_0x00d5:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r7)
            r2.append(r8)
            java.lang.String r2 = r2.toString()
            if (r4 != r11) goto L_0x0100
            java.lang.String r3 = " -> "
            int r3 = r2.indexOf(r3)
            r4 = -1
            if (r3 != r4) goto L_0x00f0
            goto L_0x0100
        L_0x00f0:
            java.lang.String r4 = r2.substring(r6, r3)
            r1.c(r4)
            int r3 = r3 + r12
            java.lang.String r2 = r2.substring(r3)
            r1.b((java.lang.String) r2)
            goto L_0x0103
        L_0x0100:
            r1.c(r2)
        L_0x0103:
            return r1
        L_0x0104:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.net.ftp.parser.h.a(java.lang.String):org.apache.commons.net.ftp.FTPFile");
    }

    /* access modifiers changed from: protected */
    public d a() {
        return new d("UNIX", "MMM d yyyy", "MMM d HH:mm");
    }
}
