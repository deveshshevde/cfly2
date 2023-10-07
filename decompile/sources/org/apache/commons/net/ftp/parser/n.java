package org.apache.commons.net.ftp.parser;

import java.util.List;
import java.util.ListIterator;
import org.apache.commons.net.ftp.d;

public class n extends b {

    /* renamed from: b  reason: collision with root package name */
    public static final d f32890b = new d("UNIX", "yyyy-MM-dd HH:mm", (String) null);

    /* renamed from: c  reason: collision with root package name */
    final boolean f32891c;

    public n() {
        this((d) null);
    }

    public n(d dVar) {
        this(dVar, false);
    }

    public n(d dVar, boolean z2) {
        super("([bcdelfmpSs-])(((r|-)(w|-)([xsStTL-]))((r|-)(w|-)([xsStTL-]))((r|-)(w|-)([xsStTL-])))\\+?\\s*(\\d+)\\s+(?:(\\S+(?:\\s\\S+)*?)\\s+)?(?:(\\S+(?:\\s\\S+)*)\\s+)?(\\d+(?:,\\s*\\d+)?)\\s+((?:\\d+[-/]\\d+[-/]\\d+)|(?:\\S{3}\\s+\\d{1,2})|(?:\\d{1,2}\\s+\\S{3})|(?:\\d{1,2}月\\s+\\d{1,2}日))\\s+((?:\\d+(?::\\d+)?)|(?:\\d{4}年))\\s(.*)");
        a(dVar);
        this.f32891c = z2;
    }

    public List<String> a(List<String> list) {
        ListIterator<String> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (listIterator.next().matches("^total \\d+$")) {
                listIterator.remove();
            }
        }
        return list;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00f2 A[SYNTHETIC, Splitter:B:33:0x00f2] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0125  */
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
            if (r2 == 0) goto L_0x0129
            r2 = 1
            java.lang.String r3 = r0.b(r2)
            r4 = 15
            java.lang.String r4 = r0.b(r4)
            r5 = 16
            java.lang.String r5 = r0.b(r5)
            r6 = 17
            java.lang.String r6 = r0.b(r6)
            r7 = 18
            java.lang.String r7 = r0.b(r7)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r9 = 19
            java.lang.String r10 = r0.b(r9)
            r8.append(r10)
            java.lang.String r10 = " "
            r8.append(r10)
            r10 = 20
            java.lang.String r10 = r0.b(r10)
            r8.append(r10)
            java.lang.String r8 = r8.toString()
            r10 = 21
            java.lang.String r10 = r0.b(r10)
            boolean r11 = r0.f32891c
            if (r11 == 0) goto L_0x0061
            java.lang.String r11 = "^\\s+"
            java.lang.String r12 = ""
            java.lang.String r10 = r10.replaceFirst(r11, r12)
        L_0x0061:
            java.lang.String r9 = r0.b(r9)     // Catch:{ ParseException -> 0x008d }
            java.lang.String r11 = "月"
            boolean r9 = r9.contains(r11)     // Catch:{ ParseException -> 0x008d }
            if (r9 == 0) goto L_0x0088
            org.apache.commons.net.ftp.parser.f r9 = new org.apache.commons.net.ftp.parser.f     // Catch:{ ParseException -> 0x008d }
            r9.<init>()     // Catch:{ ParseException -> 0x008d }
            org.apache.commons.net.ftp.d r11 = new org.apache.commons.net.ftp.d     // Catch:{ ParseException -> 0x008d }
            java.lang.String r12 = "UNIX"
            java.lang.String r13 = "M'月' d'日' yyyy'年'"
            java.lang.String r14 = "M'月' d'日' HH:mm"
            r11.<init>(r12, r13, r14)     // Catch:{ ParseException -> 0x008d }
            r9.a((org.apache.commons.net.ftp.d) r11)     // Catch:{ ParseException -> 0x008d }
            java.util.Calendar r8 = r9.a((java.lang.String) r8)     // Catch:{ ParseException -> 0x008d }
        L_0x0084:
            r1.a((java.util.Calendar) r8)     // Catch:{ ParseException -> 0x008d }
            goto L_0x008d
        L_0x0088:
            java.util.Calendar r8 = super.b(r8)     // Catch:{ ParseException -> 0x008d }
            goto L_0x0084
        L_0x008d:
            r8 = 0
            char r3 = r3.charAt(r8)
            r9 = 45
            r11 = 3
            r12 = 2
            if (r3 == r9) goto L_0x00a8
            r9 = 108(0x6c, float:1.51E-43)
            if (r3 == r9) goto L_0x00a1
            switch(r3) {
                case 98: goto L_0x00a5;
                case 99: goto L_0x00a5;
                case 100: goto L_0x00a3;
                case 101: goto L_0x00a1;
                case 102: goto L_0x00a8;
                default: goto L_0x009f;
            }
        L_0x009f:
            r3 = 3
            goto L_0x00a9
        L_0x00a1:
            r3 = 2
            goto L_0x00a9
        L_0x00a3:
            r3 = 1
            goto L_0x00a9
        L_0x00a5:
            r3 = 0
            r9 = 1
            goto L_0x00aa
        L_0x00a8:
            r3 = 0
        L_0x00a9:
            r9 = 0
        L_0x00aa:
            r1.b((int) r3)
            r14 = 0
            r15 = 4
        L_0x00af:
            if (r14 >= r11) goto L_0x00f0
            java.lang.String r11 = r0.b(r15)
            java.lang.String r13 = "-"
            boolean r11 = r11.equals(r13)
            r11 = r11 ^ r2
            r1.a(r14, r8, r11)
            int r11 = r15 + 1
            java.lang.String r11 = r0.b(r11)
            boolean r11 = r11.equals(r13)
            r11 = r11 ^ r2
            r1.a(r14, r2, r11)
            int r11 = r15 + 2
            java.lang.String r11 = r0.b(r11)
            boolean r13 = r11.equals(r13)
            if (r13 != 0) goto L_0x00e7
            char r11 = r11.charAt(r8)
            boolean r11 = java.lang.Character.isUpperCase(r11)
            if (r11 != 0) goto L_0x00e7
            r1.a(r14, r12, r2)
            goto L_0x00ea
        L_0x00e7:
            r1.a(r14, r12, r8)
        L_0x00ea:
            int r14 = r14 + 1
            int r15 = r15 + 4
            r11 = 3
            goto L_0x00af
        L_0x00f0:
            if (r9 != 0) goto L_0x00f9
            int r2 = java.lang.Integer.parseInt(r4)     // Catch:{ NumberFormatException -> 0x00f9 }
            r1.a((int) r2)     // Catch:{ NumberFormatException -> 0x00f9 }
        L_0x00f9:
            r1.e(r5)
            r1.a((java.lang.String) r6)
            long r4 = java.lang.Long.parseLong(r7)     // Catch:{ NumberFormatException -> 0x0107 }
            r1.a((long) r4)     // Catch:{ NumberFormatException -> 0x0107 }
            goto L_0x0108
        L_0x0107:
        L_0x0108:
            if (r3 != r12) goto L_0x0125
            java.lang.String r2 = " -> "
            int r2 = r10.indexOf(r2)
            r3 = -1
            if (r2 != r3) goto L_0x0114
            goto L_0x0125
        L_0x0114:
            java.lang.String r3 = r10.substring(r8, r2)
            r1.c(r3)
            r3 = 4
            int r2 = r2 + r3
            java.lang.String r2 = r10.substring(r2)
            r1.b((java.lang.String) r2)
            goto L_0x0128
        L_0x0125:
            r1.c(r10)
        L_0x0128:
            return r1
        L_0x0129:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.net.ftp.parser.n.a(java.lang.String):org.apache.commons.net.ftp.FTPFile");
    }

    /* access modifiers changed from: protected */
    public d a() {
        return new d("UNIX", "MMM d yyyy", "MMM d HH:mm");
    }
}
