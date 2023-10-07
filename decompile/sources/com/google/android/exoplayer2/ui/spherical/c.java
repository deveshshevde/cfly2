package com.google.android.exoplayer2.ui.spherical;

import android.graphics.SurfaceTexture;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.opengl.Matrix;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.i;
import com.google.android.exoplayer2.util.z;
import com.google.android.exoplayer2.video.g;
import ge.a;
import ge.d;
import ge.e;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

final class c implements g, a {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicBoolean f16897a = new AtomicBoolean();

    /* renamed from: b  reason: collision with root package name */
    private final AtomicBoolean f16898b = new AtomicBoolean(true);

    /* renamed from: c  reason: collision with root package name */
    private final b f16899c = new b();

    /* renamed from: d  reason: collision with root package name */
    private final ge.c f16900d = new ge.c();

    /* renamed from: e  reason: collision with root package name */
    private final z<Long> f16901e = new z<>();

    /* renamed from: f  reason: collision with root package name */
    private final z<d> f16902f = new z<>();

    /* renamed from: g  reason: collision with root package name */
    private final float[] f16903g = new float[16];

    /* renamed from: h  reason: collision with root package name */
    private final float[] f16904h = new float[16];

    /* renamed from: i  reason: collision with root package name */
    private int f16905i;

    /* renamed from: j  reason: collision with root package name */
    private SurfaceTexture f16906j;

    /* renamed from: k  reason: collision with root package name */
    private volatile int f16907k = 0;

    /* renamed from: l  reason: collision with root package name */
    private int f16908l = -1;

    /* renamed from: m  reason: collision with root package name */
    private byte[] f16909m;

    /* access modifiers changed from: private */
    public /* synthetic */ void a(SurfaceTexture surfaceTexture) {
        this.f16897a.set(true);
    }

    private void a(byte[] bArr, int i2, long j2) {
        byte[] bArr2 = this.f16909m;
        int i3 = this.f16908l;
        this.f16909m = bArr;
        if (i2 == -1) {
            i2 = this.f16907k;
        }
        this.f16908l = i2;
        if (i3 != i2 || !Arrays.equals(bArr2, this.f16909m)) {
            d dVar = null;
            byte[] bArr3 = this.f16909m;
            if (bArr3 != null) {
                dVar = e.a(bArr3, this.f16908l);
            }
            if (dVar == null || !b.a(dVar)) {
                dVar = d.a(this.f16908l);
            }
            this.f16902f.a(j2, dVar);
        }
    }

    public SurfaceTexture a() {
        GLES20.glClearColor(0.5f, 0.5f, 0.5f, 1.0f);
        i.b();
        this.f16899c.a();
        i.b();
        this.f16905i = i.c();
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.f16905i);
        this.f16906j = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() {
            public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
                c.this.a(surfaceTexture);
            }
        });
        return this.f16906j;
    }

    public void a(int i2) {
        this.f16907k = i2;
    }

    public void a(long j2, long j3, Format format, MediaFormat mediaFormat) {
        this.f16901e.a(j3, Long.valueOf(j2));
        a(format.f15103t, format.f15102s, j3);
    }

    public void a(long j2, float[] fArr) {
        this.f16900d.a(j2, fArr);
    }

    public void a(float[] fArr, boolean z2) {
        GLES20.glClear(16384);
        i.b();
        if (this.f16897a.compareAndSet(true, false)) {
            ((SurfaceTexture) com.google.android.exoplayer2.util.a.b(this.f16906j)).updateTexImage();
            i.b();
            if (this.f16898b.compareAndSet(true, false)) {
                Matrix.setIdentityM(this.f16903g, 0);
            }
            long timestamp = this.f16906j.getTimestamp();
            Long b2 = this.f16901e.b(timestamp);
            if (b2 != null) {
                this.f16900d.a(this.f16903g, b2.longValue());
            }
            d a2 = this.f16902f.a(timestamp);
            if (a2 != null) {
                this.f16899c.b(a2);
            }
        }
        Matrix.multiplyMM(this.f16904h, 0, fArr, 0, this.f16903g, 0);
        this.f16899c.a(this.f16905i, this.f16904h, z2);
    }

    public void b() {
        this.f16901e.a();
        this.f16900d.a();
        this.f16898b.set(true);
    }
}
