package org.apache.commons.net.ftp.parser;

import java.text.ParseException;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.d;

public class g extends b {

    /* renamed from: b  reason: collision with root package name */
    private int f32884b = -1;

    /* renamed from: c  reason: collision with root package name */
    private n f32885c;

    public g() {
        super("");
        super.a((d) null);
    }

    private FTPFile e(String str) {
        if (!c(str)) {
            return null;
        }
        FTPFile fTPFile = new FTPFile();
        fTPFile.d(str);
        String b2 = b(2);
        String b3 = b(1);
        fTPFile.c(b2);
        if ("PS".equals(b3)) {
            fTPFile.b(0);
        } else if (!"PO".equals(b3) && !"PO-E".equals(b3)) {
            return null;
        } else {
            fTPFile.b(1);
        }
        return fTPFile;
    }

    private FTPFile f(String str) {
        FTPFile fTPFile = new FTPFile();
        if (c(str)) {
            fTPFile.d(str);
            String str2 = b(2) + " " + b(3);
            fTPFile.c(b(1));
            fTPFile.b(0);
            try {
                fTPFile.a(super.b(str2));
            } catch (ParseException unused) {
            }
            return fTPFile;
        } else if (str == null || str.trim().isEmpty()) {
            return null;
        } else {
            fTPFile.d(str);
            fTPFile.c(str.split(" ")[0]);
            fTPFile.b(0);
            return fTPFile;
        }
    }

    private FTPFile g(String str) {
        if (!c(str)) {
            return null;
        }
        FTPFile fTPFile = new FTPFile();
        if (!b(3).equalsIgnoreCase("OUTPUT")) {
            return null;
        }
        fTPFile.d(str);
        fTPFile.c(b(2));
        fTPFile.b(0);
        return fTPFile;
    }

    private FTPFile h(String str) {
        if (!c(str)) {
            return null;
        }
        FTPFile fTPFile = new FTPFile();
        if (!b(4).equalsIgnoreCase("OUTPUT")) {
            return null;
        }
        fTPFile.d(str);
        fTPFile.c(b(2));
        fTPFile.b(0);
        return fTPFile;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0085  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<java.lang.String> a(java.util.List<java.lang.String> r6) {
        /*
            r5 = this;
            if (r6 == 0) goto L_0x0088
            boolean r0 = r6.isEmpty()
            if (r0 != 0) goto L_0x0088
            r0 = 0
            java.lang.Object r1 = r6.get(r0)
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r2 = "Volume"
            int r2 = r1.indexOf(r2)
            r3 = 3
            if (r2 < 0) goto L_0x0029
            java.lang.String r2 = "Dsname"
            int r2 = r1.indexOf(r2)
            if (r2 < 0) goto L_0x0029
            r5.a((int) r0)
            java.lang.String r1 = "\\S+\\s+\\S+\\s+\\S+\\s+\\S+\\s+(?:\\S+\\s+)?(?:F|FB|V|VB|U)\\s+\\S+\\s+\\S+\\s+(PS|PO|PO-E)\\s+(\\S+)\\s*"
        L_0x0025:
            super.d(r1)
            goto L_0x0081
        L_0x0029:
            java.lang.String r2 = "Name"
            int r2 = r1.indexOf(r2)
            if (r2 < 0) goto L_0x0040
            java.lang.String r2 = "Id"
            int r2 = r1.indexOf(r2)
            if (r2 < 0) goto L_0x0040
            r1 = 1
            r5.a((int) r1)
            java.lang.String r1 = "(\\S+)\\s+\\S+\\s+\\S+\\s+(\\S+)\\s+(\\S+)\\s+\\S+\\s+\\S+\\s+\\S+\\s+\\S+\\s*"
            goto L_0x0025
        L_0x0040:
            java.lang.String r2 = "total"
            int r2 = r1.indexOf(r2)
            if (r2 != 0) goto L_0x0054
            r1 = 2
            r5.a((int) r1)
            org.apache.commons.net.ftp.parser.n r1 = new org.apache.commons.net.ftp.parser.n
            r1.<init>()
            r5.f32885c = r1
            goto L_0x0081
        L_0x0054:
            java.lang.String r2 = "Spool Files"
            int r2 = r1.indexOf(r2)
            r4 = 30
            if (r2 < r4) goto L_0x0064
            r5.a((int) r3)
            java.lang.String r1 = "(\\S+)\\s+(\\S+)\\s+(\\S+)\\s+(\\S+)\\s+(\\S+)\\s+(\\S+)\\s*"
            goto L_0x0025
        L_0x0064:
            java.lang.String r2 = "JOBNAME"
            int r2 = r1.indexOf(r2)
            if (r2 != 0) goto L_0x007d
            java.lang.String r2 = "JOBID"
            int r1 = r1.indexOf(r2)
            r2 = 8
            if (r1 <= r2) goto L_0x007d
            r1 = 4
            r5.a((int) r1)
            java.lang.String r1 = "(\\S+)\\s+(\\S+)\\s+(\\S+)\\s+(\\S+)\\s+(\\S+)\\s+(\\S+).*"
            goto L_0x0025
        L_0x007d:
            r1 = -1
            r5.a((int) r1)
        L_0x0081:
            int r1 = r5.f32884b
            if (r1 == r3) goto L_0x0088
            r6.remove(r0)
        L_0x0088:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.net.ftp.parser.g.a(java.util.List):java.util.List");
    }

    public FTPFile a(String str) {
        int i2 = this.f32884b;
        if (i2 == 0) {
            return e(str);
        }
        if (i2 == 1) {
            return f(str);
        }
        if (i2 == 2) {
            return this.f32885c.a(str);
        }
        if (i2 == 3) {
            return g(str);
        }
        if (i2 == 4) {
            return h(str);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public d a() {
        return new d("MVS", "yyyy/MM/dd HH:mm", (String) null);
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        this.f32884b = i2;
    }
}
