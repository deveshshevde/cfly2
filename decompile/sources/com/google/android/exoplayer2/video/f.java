package com.google.android.exoplayer2.video;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import com.google.android.exoplayer2.util.a;
import com.google.android.exoplayer2.util.i;
import java.nio.FloatBuffer;
import java.util.concurrent.atomic.AtomicReference;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

class f implements GLSurfaceView.Renderer, e {

    /* renamed from: a  reason: collision with root package name */
    private static final float[] f17252a = {1.164f, 1.164f, 1.164f, 0.0f, -0.392f, 2.017f, 1.596f, -0.813f, 0.0f};

    /* renamed from: b  reason: collision with root package name */
    private static final float[] f17253b = {1.164f, 1.164f, 1.164f, 0.0f, -0.213f, 2.112f, 1.793f, -0.533f, 0.0f};

    /* renamed from: c  reason: collision with root package name */
    private static final float[] f17254c = {1.168f, 1.168f, 1.168f, 0.0f, -0.188f, 2.148f, 1.683f, -0.652f, 0.0f};

    /* renamed from: d  reason: collision with root package name */
    private static final String[] f17255d = {"y_tex", "u_tex", "v_tex"};

    /* renamed from: e  reason: collision with root package name */
    private static final FloatBuffer f17256e = i.a(new float[]{-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f});

    /* renamed from: f  reason: collision with root package name */
    private final GLSurfaceView f17257f;

    /* renamed from: g  reason: collision with root package name */
    private final int[] f17258g = new int[3];

    /* renamed from: h  reason: collision with root package name */
    private final AtomicReference<VideoDecoderOutputBuffer> f17259h;

    /* renamed from: i  reason: collision with root package name */
    private FloatBuffer[] f17260i;

    /* renamed from: j  reason: collision with root package name */
    private int f17261j;

    /* renamed from: k  reason: collision with root package name */
    private int[] f17262k;

    /* renamed from: l  reason: collision with root package name */
    private int f17263l;

    /* renamed from: m  reason: collision with root package name */
    private int[] f17264m;

    /* renamed from: n  reason: collision with root package name */
    private int[] f17265n;

    /* renamed from: o  reason: collision with root package name */
    private VideoDecoderOutputBuffer f17266o;

    public f(GLSurfaceView gLSurfaceView) {
        this.f17257f = gLSurfaceView;
        this.f17259h = new AtomicReference<>();
        this.f17260i = new FloatBuffer[3];
        this.f17262k = new int[3];
        this.f17264m = new int[3];
        this.f17265n = new int[3];
        for (int i2 = 0; i2 < 3; i2++) {
            int[] iArr = this.f17264m;
            this.f17265n[i2] = -1;
            iArr[i2] = -1;
        }
    }

    private void a() {
        GLES20.glGenTextures(3, this.f17258g, 0);
        for (int i2 = 0; i2 < 3; i2++) {
            GLES20.glUniform1i(GLES20.glGetUniformLocation(this.f17261j, f17255d[i2]), i2);
            GLES20.glActiveTexture(33984 + i2);
            GLES20.glBindTexture(3553, this.f17258g[i2]);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
        }
        i.b();
    }

    public void onDrawFrame(GL10 gl10) {
        VideoDecoderOutputBuffer andSet = this.f17259h.getAndSet((Object) null);
        if (andSet != null || this.f17266o != null) {
            if (andSet != null) {
                VideoDecoderOutputBuffer videoDecoderOutputBuffer = this.f17266o;
                if (videoDecoderOutputBuffer != null) {
                    videoDecoderOutputBuffer.release();
                }
                this.f17266o = andSet;
            }
            VideoDecoderOutputBuffer videoDecoderOutputBuffer2 = this.f17266o;
            float[] fArr = f17253b;
            int i2 = videoDecoderOutputBuffer2.colorspace;
            if (i2 == 1) {
                fArr = f17252a;
            } else if (i2 == 3) {
                fArr = f17254c;
            }
            GLES20.glUniformMatrix3fv(this.f17263l, 1, false, fArr, 0);
            int i3 = 0;
            while (i3 < 3) {
                int i4 = i3 == 0 ? videoDecoderOutputBuffer2.height : (videoDecoderOutputBuffer2.height + 1) / 2;
                GLES20.glActiveTexture(33984 + i3);
                GLES20.glBindTexture(3553, this.f17258g[i3]);
                GLES20.glPixelStorei(3317, 1);
                GLES20.glTexImage2D(3553, 0, 6409, videoDecoderOutputBuffer2.yuvStrides[i3], i4, 0, 6409, 5121, videoDecoderOutputBuffer2.yuvPlanes[i3]);
                i3++;
            }
            int[] iArr = new int[3];
            iArr[0] = videoDecoderOutputBuffer2.width;
            int i5 = (iArr[0] + 1) / 2;
            iArr[2] = i5;
            iArr[1] = i5;
            for (int i6 = 0; i6 < 3; i6++) {
                if (this.f17264m[i6] != iArr[i6] || this.f17265n[i6] != videoDecoderOutputBuffer2.yuvStrides[i6]) {
                    a.b(videoDecoderOutputBuffer2.yuvStrides[i6] != 0);
                    float f2 = ((float) iArr[i6]) / ((float) videoDecoderOutputBuffer2.yuvStrides[i6]);
                    this.f17260i[i6] = i.a(new float[]{0.0f, 0.0f, 0.0f, 1.0f, f2, 0.0f, f2, 1.0f});
                    GLES20.glVertexAttribPointer(this.f17262k[i6], 2, 5126, false, 0, this.f17260i[i6]);
                    this.f17264m[i6] = iArr[i6];
                    this.f17265n[i6] = videoDecoderOutputBuffer2.yuvStrides[i6];
                }
            }
            GLES20.glClear(16384);
            GLES20.glDrawArrays(5, 0, 4);
            i.b();
        }
    }

    public void onSurfaceChanged(GL10 gl10, int i2, int i3) {
        GLES20.glViewport(0, 0, i2, i3);
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        int a2 = i.a("varying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nattribute vec4 in_pos;\nattribute vec2 in_tc_y;\nattribute vec2 in_tc_u;\nattribute vec2 in_tc_v;\nvoid main() {\n  gl_Position = in_pos;\n  interp_tc_y = in_tc_y;\n  interp_tc_u = in_tc_u;\n  interp_tc_v = in_tc_v;\n}\n", "precision mediump float;\nvarying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nuniform sampler2D y_tex;\nuniform sampler2D u_tex;\nuniform sampler2D v_tex;\nuniform mat3 mColorConversion;\nvoid main() {\n  vec3 yuv;\n  yuv.x = texture2D(y_tex, interp_tc_y).r - 0.0625;\n  yuv.y = texture2D(u_tex, interp_tc_u).r - 0.5;\n  yuv.z = texture2D(v_tex, interp_tc_v).r - 0.5;\n  gl_FragColor = vec4(mColorConversion * yuv, 1.0);\n}\n");
        this.f17261j = a2;
        GLES20.glUseProgram(a2);
        int glGetAttribLocation = GLES20.glGetAttribLocation(this.f17261j, "in_pos");
        GLES20.glEnableVertexAttribArray(glGetAttribLocation);
        GLES20.glVertexAttribPointer(glGetAttribLocation, 2, 5126, false, 0, f17256e);
        this.f17262k[0] = GLES20.glGetAttribLocation(this.f17261j, "in_tc_y");
        GLES20.glEnableVertexAttribArray(this.f17262k[0]);
        this.f17262k[1] = GLES20.glGetAttribLocation(this.f17261j, "in_tc_u");
        GLES20.glEnableVertexAttribArray(this.f17262k[1]);
        this.f17262k[2] = GLES20.glGetAttribLocation(this.f17261j, "in_tc_v");
        GLES20.glEnableVertexAttribArray(this.f17262k[2]);
        i.b();
        this.f17263l = GLES20.glGetUniformLocation(this.f17261j, "mColorConversion");
        i.b();
        a();
        i.b();
    }
}
