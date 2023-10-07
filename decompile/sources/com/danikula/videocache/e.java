package com.danikula.videocache;

import android.text.TextUtils;
import da.b;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Locale;

class e extends m {

    /* renamed from: a  reason: collision with root package name */
    private final i f11037a;

    /* renamed from: b  reason: collision with root package name */
    private final b f11038b;

    /* renamed from: c  reason: collision with root package name */
    private b f11039c;

    public e(i iVar, b bVar) {
        super(iVar, bVar);
        this.f11038b = bVar;
        this.f11037a = iVar;
    }

    private String a(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    private void a(OutputStream outputStream, long j2) throws ProxyCacheException, IOException {
        byte[] bArr = new byte[8192];
        while (true) {
            int a2 = a(bArr, j2, 8192);
            if (a2 != -1) {
                outputStream.write(bArr, 0, a2);
                j2 += (long) a2;
            } else {
                outputStream.flush();
                return;
            }
        }
    }

    private boolean a(d dVar) throws ProxyCacheException {
        long a2 = this.f11037a.a();
        return !((a2 > 0 ? 1 : (a2 == 0 ? 0 : -1)) > 0) || !dVar.f11036c || ((float) dVar.f11035b) <= ((float) this.f11038b.a()) + (((float) a2) * 0.2f);
    }

    private String b(d dVar) throws IOException, ProxyCacheException {
        String c2 = this.f11037a.c();
        boolean z2 = !TextUtils.isEmpty(c2);
        long a2 = this.f11038b.d() ? this.f11038b.a() : this.f11037a.a();
        boolean z3 = a2 >= 0;
        long j2 = dVar.f11036c ? a2 - dVar.f11035b : a2;
        boolean z4 = z3 && dVar.f11036c;
        StringBuilder sb = new StringBuilder();
        sb.append(dVar.f11036c ? "HTTP/1.1 206 PARTIAL CONTENT\n" : "HTTP/1.1 200 OK\n");
        sb.append("Accept-Ranges: bytes\n");
        String str = "";
        sb.append(z3 ? a("Content-Length: %d\n", Long.valueOf(j2)) : str);
        sb.append(z4 ? a("Content-Range: bytes %d-%d/%d\n", Long.valueOf(dVar.f11035b), Long.valueOf(a2 - 1), Long.valueOf(a2)) : str);
        if (z2) {
            str = a("Content-Type: %s\n", c2);
        }
        sb.append(str);
        sb.append("\n");
        return sb.toString();
    }

    private void b(OutputStream outputStream, long j2) throws ProxyCacheException, IOException {
        i iVar = new i(this.f11037a);
        try {
            iVar.a((long) ((int) j2));
            byte[] bArr = new byte[8192];
            while (true) {
                int a2 = iVar.a(bArr);
                if (a2 != -1) {
                    outputStream.write(bArr, 0, a2);
                } else {
                    outputStream.flush();
                    return;
                }
            }
        } finally {
            iVar.b();
        }
    }

    /* access modifiers changed from: protected */
    public void a(int i2) {
        b bVar = this.f11039c;
        if (bVar != null) {
            bVar.a(this.f11038b.f26685a, this.f11037a.d(), i2);
        }
    }

    public void a(b bVar) {
        this.f11039c = bVar;
    }

    public void a(d dVar, Socket socket) throws IOException, ProxyCacheException {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
        bufferedOutputStream.write(b(dVar).getBytes("UTF-8"));
        long j2 = dVar.f11035b;
        if (a(dVar)) {
            a((OutputStream) bufferedOutputStream, j2);
        } else {
            b(bufferedOutputStream, j2);
        }
    }
}
