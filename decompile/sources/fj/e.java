package fj;

import com.google.android.exoplayer2.extractor.flv.b;
import com.google.android.exoplayer2.extractor.mp4.g;
import fm.d;
import fn.c;
import fq.a;
import fq.ab;
import fq.u;
import java.lang.reflect.Constructor;

public final class e implements k {

    /* renamed from: a  reason: collision with root package name */
    private static final Constructor<? extends g> f27369a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f27370b;

    /* renamed from: c  reason: collision with root package name */
    private int f27371c;

    /* renamed from: d  reason: collision with root package name */
    private int f27372d;

    /* renamed from: e  reason: collision with root package name */
    private int f27373e;

    /* renamed from: f  reason: collision with root package name */
    private int f27374f;

    /* renamed from: g  reason: collision with root package name */
    private int f27375g;

    /* renamed from: h  reason: collision with root package name */
    private int f27376h;

    /* renamed from: i  reason: collision with root package name */
    private int f27377i = 1;

    /* renamed from: j  reason: collision with root package name */
    private int f27378j;

    static {
        Constructor<? extends U> constructor = null;
        try {
            if (Boolean.TRUE.equals(Class.forName("com.google.android.exoplayer2.ext.flac.FlacLibrary").getMethod("isAvailable", new Class[0]).invoke((Object) null, new Object[0]))) {
                constructor = Class.forName("com.google.android.exoplayer2.ext.flac.FlacExtractor").asSubclass(g.class).getConstructor(new Class[0]);
            }
        } catch (ClassNotFoundException unused) {
        } catch (Exception e2) {
            throw new RuntimeException("Error instantiating FLAC extension", e2);
        }
        f27369a = constructor;
    }

    public synchronized g[] createExtractors() {
        g[] gVarArr;
        gVarArr = new g[14];
        gVarArr[0] = new d(this.f27373e);
        int i2 = 1;
        gVarArr[1] = new com.google.android.exoplayer2.extractor.mp4.e(this.f27375g);
        gVarArr[2] = new g(this.f27374f);
        gVarArr[3] = new c(this.f27376h | (this.f27370b ? 1 : 0));
        gVarArr[4] = new fq.e(this.f27371c | (this.f27370b ? 1 : 0));
        gVarArr[5] = new a();
        gVarArr[6] = new ab(this.f27377i, this.f27378j);
        gVarArr[7] = new b();
        gVarArr[8] = new fo.c();
        gVarArr[9] = new u();
        gVarArr[10] = new fr.a();
        int i3 = this.f27372d;
        if (!this.f27370b) {
            i2 = 0;
        }
        gVarArr[11] = new fk.a(i2 | i3);
        gVarArr[12] = new fq.c();
        Constructor<? extends g> constructor = f27369a;
        if (constructor != null) {
            try {
                gVarArr[13] = (g) constructor.newInstance(new Object[0]);
            } catch (Exception e2) {
                throw new IllegalStateException("Unexpected error creating FLAC extractor", e2);
            }
        } else {
            gVarArr[13] = new fl.b();
        }
        return gVarArr;
    }
}
