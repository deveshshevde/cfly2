package com.google.android.exoplayer2.ui.spherical;

import android.opengl.GLES20;
import com.google.android.exoplayer2.util.i;
import ge.d;
import java.nio.FloatBuffer;

final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f16877a = {"uniform mat4 uMvpMatrix;", "uniform mat3 uTexMatrix;", "attribute vec4 aPosition;", "attribute vec2 aTexCoords;", "varying vec2 vTexCoords;", "void main() {", "  gl_Position = uMvpMatrix * aPosition;", "  vTexCoords = (uTexMatrix * vec3(aTexCoords, 1)).xy;", "}"};

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f16878b = {"#extension GL_OES_EGL_image_external : require", "precision mediump float;", "uniform samplerExternalOES uTexture;", "varying vec2 vTexCoords;", "void main() {", "  gl_FragColor = texture2D(uTexture, vTexCoords);", "}"};

    /* renamed from: c  reason: collision with root package name */
    private static final float[] f16879c = {1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* renamed from: d  reason: collision with root package name */
    private static final float[] f16880d = {1.0f, 0.0f, 0.0f, 0.0f, -0.5f, 0.0f, 0.0f, 0.5f, 1.0f};

    /* renamed from: e  reason: collision with root package name */
    private static final float[] f16881e = {1.0f, 0.0f, 0.0f, 0.0f, -0.5f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* renamed from: f  reason: collision with root package name */
    private static final float[] f16882f = {0.5f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* renamed from: g  reason: collision with root package name */
    private static final float[] f16883g = {0.5f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.5f, 1.0f, 1.0f};

    /* renamed from: h  reason: collision with root package name */
    private int f16884h;

    /* renamed from: i  reason: collision with root package name */
    private a f16885i;

    /* renamed from: j  reason: collision with root package name */
    private a f16886j;

    /* renamed from: k  reason: collision with root package name */
    private int f16887k;

    /* renamed from: l  reason: collision with root package name */
    private int f16888l;

    /* renamed from: m  reason: collision with root package name */
    private int f16889m;

    /* renamed from: n  reason: collision with root package name */
    private int f16890n;

    /* renamed from: o  reason: collision with root package name */
    private int f16891o;

    /* renamed from: p  reason: collision with root package name */
    private int f16892p;

    private static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final int f16893a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final FloatBuffer f16894b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final FloatBuffer f16895c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public final int f16896d;

        public a(d.b bVar) {
            this.f16893a = bVar.a();
            this.f16894b = i.a(bVar.f28482c);
            this.f16895c = i.a(bVar.f28483d);
            int i2 = bVar.f28481b;
            this.f16896d = i2 != 1 ? i2 != 2 ? 4 : 6 : 5;
        }
    }

    b() {
    }

    public static boolean a(d dVar) {
        d.a aVar = dVar.f28475a;
        d.a aVar2 = dVar.f28476b;
        return aVar.a() == 1 && aVar.a(0).f28480a == 0 && aVar2.a() == 1 && aVar2.a(0).f28480a == 0;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        int a2 = i.a(f16877a, f16878b);
        this.f16887k = a2;
        this.f16888l = GLES20.glGetUniformLocation(a2, "uMvpMatrix");
        this.f16889m = GLES20.glGetUniformLocation(this.f16887k, "uTexMatrix");
        this.f16890n = GLES20.glGetAttribLocation(this.f16887k, "aPosition");
        this.f16891o = GLES20.glGetAttribLocation(this.f16887k, "aTexCoords");
        this.f16892p = GLES20.glGetUniformLocation(this.f16887k, "uTexture");
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, float[] fArr, boolean z2) {
        a aVar = z2 ? this.f16886j : this.f16885i;
        if (aVar != null) {
            GLES20.glUseProgram(this.f16887k);
            i.b();
            GLES20.glEnableVertexAttribArray(this.f16890n);
            GLES20.glEnableVertexAttribArray(this.f16891o);
            i.b();
            int i3 = this.f16884h;
            GLES20.glUniformMatrix3fv(this.f16889m, 1, false, i3 == 1 ? z2 ? f16881e : f16880d : i3 == 2 ? z2 ? f16883g : f16882f : f16879c, 0);
            GLES20.glUniformMatrix4fv(this.f16888l, 1, false, fArr, 0);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(36197, i2);
            GLES20.glUniform1i(this.f16892p, 0);
            i.b();
            GLES20.glVertexAttribPointer(this.f16890n, 3, 5126, false, 12, aVar.f16894b);
            i.b();
            GLES20.glVertexAttribPointer(this.f16891o, 2, 5126, false, 8, aVar.f16895c);
            i.b();
            GLES20.glDrawArrays(aVar.f16896d, 0, aVar.f16893a);
            i.b();
            GLES20.glDisableVertexAttribArray(this.f16890n);
            GLES20.glDisableVertexAttribArray(this.f16891o);
        }
    }

    public void b(d dVar) {
        if (a(dVar)) {
            this.f16884h = dVar.f28477c;
            this.f16885i = new a(dVar.f28475a.a(0));
            this.f16886j = dVar.f28478d ? this.f16885i : new a(dVar.f28476b.a(0));
        }
    }
}
