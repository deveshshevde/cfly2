package org.apache.commons.net.ftp.parser;

import java.io.BufferedReader;
import java.io.IOException;
import org.apache.commons.net.ftp.d;

public class o extends b {
    public o() {
        this((d) null);
    }

    public o(d dVar) {
        super("(.*?;[0-9]+)\\s*(\\d+)(?:/\\d+)?\\s*(\\S+)\\s+(\\S+)\\s+\\[(([0-9$A-Za-z_]+)|([0-9$A-Za-z_]+),([0-9$a-zA-Z_]+))\\]?\\s*\\([a-zA-Z]*,([a-zA-Z]*),([a-zA-Z]*),([a-zA-Z]*)\\)");
        a(dVar);
    }

    public String a(BufferedReader bufferedReader) throws IOException {
        String readLine = bufferedReader.readLine();
        StringBuilder sb = new StringBuilder();
        while (readLine != null) {
            if (!readLine.startsWith("Directory") && !readLine.startsWith("Total")) {
                sb.append(readLine);
                if (readLine.trim().endsWith(")")) {
                    break;
                }
            }
            readLine = bufferedReader.readLine();
        }
        if (sb.length() == 0) {
            return null;
        }
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00b3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.apache.commons.net.ftp.FTPFile a(java.lang.String r18) {
        /*
            r17 = this;
            r0 = r17
            boolean r1 = r17.c(r18)
            r2 = 0
            if (r1 == 0) goto L_0x00e3
            org.apache.commons.net.ftp.FTPFile r1 = new org.apache.commons.net.ftp.FTPFile
            r1.<init>()
            r3 = r18
            r1.d(r3)
            r3 = 1
            java.lang.String r4 = r0.b(r3)
            r5 = 2
            java.lang.String r6 = r0.b(r5)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r8 = 3
            java.lang.String r9 = r0.b(r8)
            r7.append(r9)
            java.lang.String r9 = " "
            r7.append(r9)
            r9 = 4
            java.lang.String r9 = r0.b(r9)
            r7.append(r9)
            java.lang.String r7 = r7.toString()
            r9 = 5
            java.lang.String r9 = r0.b(r9)
            java.lang.String[] r10 = new java.lang.String[r8]
            r11 = 9
            java.lang.String r11 = r0.b(r11)
            r12 = 0
            r10[r12] = r11
            r11 = 10
            java.lang.String r11 = r0.b(r11)
            r10[r3] = r11
            r11 = 11
            java.lang.String r11 = r0.b(r11)
            r10[r5] = r11
            java.util.Calendar r7 = super.b(r7)     // Catch:{ ParseException -> 0x0062 }
            r1.a((java.util.Calendar) r7)     // Catch:{ ParseException -> 0x0062 }
        L_0x0062:
            java.util.StringTokenizer r7 = new java.util.StringTokenizer
            java.lang.String r11 = ","
            r7.<init>(r9, r11)
            int r9 = r7.countTokens()
            if (r9 == r3) goto L_0x0077
            if (r9 == r5) goto L_0x0073
            r7 = r2
            goto L_0x007b
        L_0x0073:
            java.lang.String r2 = r7.nextToken()
        L_0x0077:
            java.lang.String r7 = r7.nextToken()
        L_0x007b:
            java.lang.String r9 = ".DIR"
            int r9 = r4.lastIndexOf(r9)
            r11 = -1
            if (r9 == r11) goto L_0x0088
            r1.b((int) r3)
            goto L_0x008b
        L_0x0088:
            r1.b((int) r12)
        L_0x008b:
            boolean r9 = r17.b()
            if (r9 == 0) goto L_0x0092
            goto L_0x009c
        L_0x0092:
            r9 = 59
            int r9 = r4.lastIndexOf(r9)
            java.lang.String r4 = r4.substring(r12, r9)
        L_0x009c:
            r1.c(r4)
            long r13 = java.lang.Long.parseLong(r6)
            r15 = 512(0x200, double:2.53E-321)
            long r13 = r13 * r15
            r1.a((long) r13)
            r1.a((java.lang.String) r2)
            r1.e(r7)
            r2 = 0
        L_0x00b1:
            if (r2 >= r8) goto L_0x00e2
            r4 = r10[r2]
            r6 = 82
            int r6 = r4.indexOf(r6)
            if (r6 < 0) goto L_0x00bf
            r6 = 1
            goto L_0x00c0
        L_0x00bf:
            r6 = 0
        L_0x00c0:
            r1.a(r2, r12, r6)
            r6 = 87
            int r6 = r4.indexOf(r6)
            if (r6 < 0) goto L_0x00cd
            r6 = 1
            goto L_0x00ce
        L_0x00cd:
            r6 = 0
        L_0x00ce:
            r1.a(r2, r3, r6)
            r6 = 69
            int r4 = r4.indexOf(r6)
            if (r4 < 0) goto L_0x00db
            r4 = 1
            goto L_0x00dc
        L_0x00db:
            r4 = 0
        L_0x00dc:
            r1.a(r2, r5, r4)
            int r2 = r2 + 1
            goto L_0x00b1
        L_0x00e2:
            return r1
        L_0x00e3:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.net.ftp.parser.o.a(java.lang.String):org.apache.commons.net.ftp.FTPFile");
    }

    /* access modifiers changed from: protected */
    public d a() {
        return new d("VMS", "d-MMM-yyyy HH:mm:ss", (String) null);
    }

    /* access modifiers changed from: protected */
    public boolean b() {
        return false;
    }
}
