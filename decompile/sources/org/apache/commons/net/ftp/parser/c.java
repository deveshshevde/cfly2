package org.apache.commons.net.ftp.parser;

import java.util.regex.Pattern;
import org.apache.commons.net.ftp.d;
import org.apache.commons.net.ftp.e;

public class c implements d {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f32877a = Pattern.compile("(\\p{javaJavaIdentifierStart}(\\p{javaJavaIdentifierPart})*\\.)+\\p{javaJavaIdentifierStart}(\\p{javaJavaIdentifierPart})*");

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00fa  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.apache.commons.net.ftp.e a(java.lang.String r5, org.apache.commons.net.ftp.d r6) {
        /*
            r4 = this;
            java.util.regex.Pattern r0 = f32877a
            java.util.regex.Matcher r0 = r0.matcher(r5)
            boolean r0 = r0.matches()
            if (r0 == 0) goto L_0x003e
            java.lang.Class r0 = java.lang.Class.forName(r5)     // Catch:{ ClassNotFoundException -> 0x003e }
            java.lang.Object r1 = r0.newInstance()     // Catch:{ ClassCastException -> 0x0022, Exception -> 0x0019, ExceptionInInitializerError -> 0x0017 }
            org.apache.commons.net.ftp.e r1 = (org.apache.commons.net.ftp.e) r1     // Catch:{ ClassCastException -> 0x0022, Exception -> 0x0019, ExceptionInInitializerError -> 0x0017 }
            goto L_0x003f
        L_0x0017:
            r0 = move-exception
            goto L_0x001a
        L_0x0019:
            r0 = move-exception
        L_0x001a:
            org.apache.commons.net.ftp.parser.ParserInitializationException r1 = new org.apache.commons.net.ftp.parser.ParserInitializationException     // Catch:{ ClassNotFoundException -> 0x003e }
            java.lang.String r2 = "Error initializing parser"
            r1.<init>(r2, r0)     // Catch:{ ClassNotFoundException -> 0x003e }
            throw r1     // Catch:{ ClassNotFoundException -> 0x003e }
        L_0x0022:
            r1 = move-exception
            org.apache.commons.net.ftp.parser.ParserInitializationException r2 = new org.apache.commons.net.ftp.parser.ParserInitializationException     // Catch:{ ClassNotFoundException -> 0x003e }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException -> 0x003e }
            r3.<init>()     // Catch:{ ClassNotFoundException -> 0x003e }
            java.lang.String r0 = r0.getName()     // Catch:{ ClassNotFoundException -> 0x003e }
            r3.append(r0)     // Catch:{ ClassNotFoundException -> 0x003e }
            java.lang.String r0 = " does not implement the interface org.apache.commons.net.ftp.FTPFileEntryParser."
            r3.append(r0)     // Catch:{ ClassNotFoundException -> 0x003e }
            java.lang.String r0 = r3.toString()     // Catch:{ ClassNotFoundException -> 0x003e }
            r2.<init>(r0, r1)     // Catch:{ ClassNotFoundException -> 0x003e }
            throw r2     // Catch:{ ClassNotFoundException -> 0x003e }
        L_0x003e:
            r1 = 0
        L_0x003f:
            if (r1 != 0) goto L_0x00f6
            java.util.Locale r0 = java.util.Locale.ENGLISH
            java.lang.String r0 = r5.toUpperCase(r0)
            java.lang.String r1 = "UNIX_LTRIM"
            int r1 = r0.indexOf(r1)
            if (r1 < 0) goto L_0x0057
            org.apache.commons.net.ftp.parser.n r1 = new org.apache.commons.net.ftp.parser.n
            r5 = 1
            r1.<init>(r6, r5)
            goto L_0x00f6
        L_0x0057:
            java.lang.String r1 = "UNIX"
            int r1 = r0.indexOf(r1)
            if (r1 < 0) goto L_0x0067
            org.apache.commons.net.ftp.parser.n r1 = new org.apache.commons.net.ftp.parser.n
            r5 = 0
            r1.<init>(r6, r5)
            goto L_0x00f6
        L_0x0067:
            java.lang.String r1 = "VMS"
            int r1 = r0.indexOf(r1)
            if (r1 < 0) goto L_0x0076
            org.apache.commons.net.ftp.parser.p r1 = new org.apache.commons.net.ftp.parser.p
            r1.<init>(r6)
            goto L_0x00f6
        L_0x0076:
            java.lang.String r1 = "WINDOWS"
            int r1 = r0.indexOf(r1)
            if (r1 < 0) goto L_0x0084
            org.apache.commons.net.ftp.e r1 = r4.b(r6)
            goto L_0x00f6
        L_0x0084:
            java.lang.String r1 = "OS/2"
            int r1 = r0.indexOf(r1)
            if (r1 < 0) goto L_0x0092
            org.apache.commons.net.ftp.parser.k r1 = new org.apache.commons.net.ftp.parser.k
            r1.<init>(r6)
            goto L_0x00f6
        L_0x0092:
            java.lang.String r1 = "OS/400"
            int r1 = r0.indexOf(r1)
            if (r1 >= 0) goto L_0x00f2
            java.lang.String r1 = "AS/400"
            int r1 = r0.indexOf(r1)
            if (r1 < 0) goto L_0x00a3
            goto L_0x00f2
        L_0x00a3:
            java.lang.String r1 = "MVS"
            int r1 = r0.indexOf(r1)
            if (r1 < 0) goto L_0x00b1
            org.apache.commons.net.ftp.parser.g r1 = new org.apache.commons.net.ftp.parser.g
            r1.<init>()
            goto L_0x00f6
        L_0x00b1:
            java.lang.String r1 = "NETWARE"
            int r1 = r0.indexOf(r1)
            if (r1 < 0) goto L_0x00bf
            org.apache.commons.net.ftp.parser.j r1 = new org.apache.commons.net.ftp.parser.j
            r1.<init>(r6)
            goto L_0x00f6
        L_0x00bf:
            java.lang.String r1 = "MACOS PETER"
            int r1 = r0.indexOf(r1)
            if (r1 < 0) goto L_0x00cd
            org.apache.commons.net.ftp.parser.h r1 = new org.apache.commons.net.ftp.parser.h
            r1.<init>(r6)
            goto L_0x00f6
        L_0x00cd:
            java.lang.String r1 = "TYPE: L8"
            int r0 = r0.indexOf(r1)
            if (r0 < 0) goto L_0x00db
            org.apache.commons.net.ftp.parser.n r1 = new org.apache.commons.net.ftp.parser.n
            r1.<init>(r6)
            goto L_0x00f6
        L_0x00db:
            org.apache.commons.net.ftp.parser.ParserInitializationException r6 = new org.apache.commons.net.ftp.parser.ParserInitializationException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unknown parser type: "
            r0.append(r1)
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            r6.<init>(r5)
            throw r6
        L_0x00f2:
            org.apache.commons.net.ftp.e r1 = r4.c(r6)
        L_0x00f6:
            boolean r5 = r1 instanceof org.apache.commons.net.ftp.a
            if (r5 == 0) goto L_0x0100
            r5 = r1
            org.apache.commons.net.ftp.a r5 = (org.apache.commons.net.ftp.a) r5
            r5.a(r6)
        L_0x0100:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.net.ftp.parser.c.a(java.lang.String, org.apache.commons.net.ftp.d):org.apache.commons.net.ftp.e");
    }

    private e b(d dVar) {
        if (dVar != null && "WINDOWS".equals(dVar.a())) {
            return new i(dVar);
        }
        d dVar2 = dVar != null ? new d(dVar) : null;
        e[] eVarArr = new e[2];
        i iVar = new i(dVar);
        boolean z2 = false;
        eVarArr[0] = iVar;
        if (dVar2 != null && "UNIX_LTRIM".equals(dVar2.a())) {
            z2 = true;
        }
        eVarArr[1] = new n(dVar2, z2);
        return new a(eVarArr);
    }

    private e c(d dVar) {
        if (dVar != null && "OS/400".equals(dVar.a())) {
            return new l(dVar);
        }
        d dVar2 = dVar != null ? new d(dVar) : null;
        e[] eVarArr = new e[2];
        l lVar = new l(dVar);
        boolean z2 = false;
        eVarArr[0] = lVar;
        if (dVar2 != null && "UNIX_LTRIM".equals(dVar2.a())) {
            z2 = true;
        }
        eVarArr[1] = new n(dVar2, z2);
        return new a(eVarArr);
    }

    public e a(String str) {
        if (str != null) {
            return a(str, (d) null);
        }
        throw new ParserInitializationException("Parser key cannot be null");
    }

    public e a(d dVar) throws ParserInitializationException {
        return a(dVar.a(), dVar);
    }
}
