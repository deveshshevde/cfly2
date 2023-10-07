package jv;

import android.os.SystemClock;
import com.xeagle.android.login.pickImage.data.GLImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import kotlin.jvm.internal.h;

public class a extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private final String f29779a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f29780b = true;

    /* renamed from: c  reason: collision with root package name */
    private final long f29781c = 10;

    /* renamed from: d  reason: collision with root package name */
    private boolean f29782d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f29783e = true;

    /* renamed from: f  reason: collision with root package name */
    private boolean f29784f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f29785g = true;

    /* renamed from: h  reason: collision with root package name */
    private boolean f29786h;

    /* renamed from: i  reason: collision with root package name */
    private BufferedOutputStream f29787i;

    /* renamed from: j  reason: collision with root package name */
    private c f29788j;

    /* renamed from: k  reason: collision with root package name */
    private long f29789k = -1;

    /* renamed from: l  reason: collision with root package name */
    private long f29790l = -1;

    /* renamed from: m  reason: collision with root package name */
    private long f29791m;

    /* renamed from: n  reason: collision with root package name */
    private byte[] f29792n;

    /* renamed from: o  reason: collision with root package name */
    private byte[] f29793o;

    /* renamed from: p  reason: collision with root package name */
    private final int f29794p;

    /* renamed from: q  reason: collision with root package name */
    private final int f29795q;

    /* renamed from: r  reason: collision with root package name */
    private final int f29796r;

    /* renamed from: jv.a$a  reason: collision with other inner class name */
    static final class C0200a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f29797a;

        C0200a(a aVar) {
            this.f29797a = aVar;
        }

        public final void run() {
            if (this.f29797a.f()) {
                this.f29797a.a(false);
                SystemClock.sleep(50);
                c j2 = this.f29797a.j();
                if (j2 != null) {
                    j2.a();
                }
            }
        }
    }

    public a(int i2, int i3, int i4) {
        this.f29794p = i2;
        this.f29795q = i3;
        this.f29796r = i4;
        String simpleName = a.class.getSimpleName();
        h.b(simpleName, "DecodeThread::class.java.simpleName");
        this.f29779a = simpleName;
    }

    /* access modifiers changed from: protected */
    public final String a() {
        return this.f29779a;
    }

    /* access modifiers changed from: protected */
    public final void a(long j2) {
        this.f29789k = j2;
    }

    public final void a(String str) {
        h.d(str, GLImage.KEY_PATH);
        if (!this.f29784f) {
            c cVar = new c(str, this.f29794p, this.f29795q, this.f29796r, this.f29792n, this.f29793o);
            this.f29788j = cVar;
            if (cVar != null) {
                cVar.start();
            }
            this.f29784f = true;
        }
    }

    /* access modifiers changed from: protected */
    public final void a(boolean z2) {
        this.f29784f = z2;
    }

    /* access modifiers changed from: protected */
    public final void a(byte[] bArr) {
        this.f29792n = bArr;
    }

    public final void a(byte[] bArr, byte[] bArr2) {
        h.d(bArr, "sps");
        h.d(bArr2, "pps");
        this.f29792n = bArr;
        this.f29793o = bArr2;
    }

    /* access modifiers changed from: protected */
    public final void b(long j2) {
        this.f29790l = j2;
    }

    public final void b(String str) {
        h.d(str, GLImage.KEY_PATH);
        this.f29782d = true;
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        this.f29787i = new BufferedOutputStream(new FileOutputStream(file));
    }

    /* access modifiers changed from: protected */
    public final void b(boolean z2) {
        this.f29785g = z2;
    }

    /* access modifiers changed from: protected */
    public final void b(byte[] bArr) {
        this.f29793o = bArr;
    }

    /* access modifiers changed from: protected */
    public final boolean b() {
        return this.f29780b;
    }

    /* access modifiers changed from: protected */
    public final long c() {
        return this.f29781c;
    }

    /* access modifiers changed from: protected */
    public final void c(long j2) {
        this.f29791m = j2;
    }

    /* access modifiers changed from: protected */
    public final void c(boolean z2) {
        this.f29786h = z2;
    }

    public final void d(boolean z2) {
        this.f29783e = z2;
    }

    /* access modifiers changed from: protected */
    public final boolean d() {
        return this.f29782d;
    }

    /* access modifiers changed from: protected */
    public final boolean e() {
        return this.f29783e;
    }

    /* access modifiers changed from: protected */
    public final boolean f() {
        return this.f29784f;
    }

    /* access modifiers changed from: protected */
    public final boolean g() {
        return this.f29785g;
    }

    /* access modifiers changed from: protected */
    public final boolean h() {
        return this.f29786h;
    }

    /* access modifiers changed from: protected */
    public final BufferedOutputStream i() {
        return this.f29787i;
    }

    /* access modifiers changed from: protected */
    public final c j() {
        return this.f29788j;
    }

    /* access modifiers changed from: protected */
    public final long k() {
        return this.f29789k;
    }

    /* access modifiers changed from: protected */
    public final long l() {
        return this.f29790l;
    }

    /* access modifiers changed from: protected */
    public final long m() {
        return this.f29791m;
    }

    /* access modifiers changed from: protected */
    public final byte[] n() {
        return this.f29792n;
    }

    /* access modifiers changed from: protected */
    public final byte[] o() {
        return this.f29793o;
    }

    public final void p() {
        ka.a.a().b().execute(new C0200a(this));
    }

    public final void q() {
        this.f29782d = false;
        BufferedOutputStream bufferedOutputStream = this.f29787i;
        if (bufferedOutputStream != null) {
            bufferedOutputStream.flush();
        }
        BufferedOutputStream bufferedOutputStream2 = this.f29787i;
        if (bufferedOutputStream2 != null) {
            bufferedOutputStream2.close();
        }
        this.f29787i = null;
    }
}
