package org.apache.commons.net.ftp;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class i {

    /* renamed from: e  reason: collision with root package name */
    private static final FTPFile[] f32869e = new FTPFile[0];

    /* renamed from: a  reason: collision with root package name */
    private List<String> f32870a;

    /* renamed from: b  reason: collision with root package name */
    private ListIterator<String> f32871b;

    /* renamed from: c  reason: collision with root package name */
    private final e f32872c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f32873d;

    i(e eVar, d dVar) {
        LinkedList linkedList = new LinkedList();
        this.f32870a = linkedList;
        this.f32871b = linkedList.listIterator();
        this.f32872c = eVar;
        this.f32873d = dVar != null ? dVar.h() : false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0024, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0029, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002a, code lost:
        r3.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002e, code lost:
        throw r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(java.io.InputStream r3, java.lang.String r4) throws java.io.IOException {
        /*
            r2 = this;
            java.io.BufferedReader r0 = new java.io.BufferedReader
            java.io.InputStreamReader r1 = new java.io.InputStreamReader
            java.nio.charset.Charset r4 = org.apache.commons.net.util.a.a(r4)
            r1.<init>(r3, r4)
            r0.<init>(r1)
            org.apache.commons.net.ftp.e r3 = r2.f32872c     // Catch:{ all -> 0x0022 }
        L_0x0010:
            java.lang.String r3 = r3.a((java.io.BufferedReader) r0)     // Catch:{ all -> 0x0022 }
            if (r3 == 0) goto L_0x001e
            java.util.List<java.lang.String> r4 = r2.f32870a     // Catch:{ all -> 0x0022 }
            r4.add(r3)     // Catch:{ all -> 0x0022 }
            org.apache.commons.net.ftp.e r3 = r2.f32872c     // Catch:{ all -> 0x0022 }
            goto L_0x0010
        L_0x001e:
            r0.close()
            return
        L_0x0022:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0024 }
        L_0x0024:
            r4 = move-exception
            r0.close()     // Catch:{ all -> 0x0029 }
            goto L_0x002d
        L_0x0029:
            r0 = move-exception
            r3.addSuppressed(r0)
        L_0x002d:
            goto L_0x002f
        L_0x002e:
            throw r4
        L_0x002f:
            goto L_0x002e
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.net.ftp.i.b(java.io.InputStream, java.lang.String):void");
    }

    public void a(InputStream inputStream, String str) throws IOException {
        this.f32870a = new LinkedList();
        b(inputStream, str);
        this.f32872c.a(this.f32870a);
        b();
    }

    public FTPFile[] a() throws IOException {
        return a(h.f32867b);
    }

    public FTPFile[] a(g gVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        for (String next : this.f32870a) {
            FTPFile a2 = this.f32872c.a(next);
            if (a2 == null && this.f32873d) {
                a2 = new FTPFile(next);
            }
            if (gVar.a(a2)) {
                arrayList.add(a2);
            }
        }
        return (FTPFile[]) arrayList.toArray(f32869e);
    }

    public void b() {
        this.f32871b = this.f32870a.listIterator();
    }
}
