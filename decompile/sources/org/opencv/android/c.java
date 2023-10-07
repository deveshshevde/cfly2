package org.opencv.android;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.Log;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import org.opencv.android.CameraGLSurfaceView;

public abstract class c implements SurfaceTexture.OnFrameAvailableListener, GLSurfaceView.Renderer {
    private int A;
    private int B;
    private int C;
    private int D;
    private int E;
    private FloatBuffer F;
    private FloatBuffer G;
    private FloatBuffer H;

    /* renamed from: a  reason: collision with root package name */
    private final String f34016a = "attribute vec2 vPosition;\nattribute vec2 vTexCoord;\nvarying vec2 texCoord;\nvoid main() {\n  texCoord = vTexCoord;\n  gl_Position = vec4 ( vPosition.x, vPosition.y, 0.0, 1.0 );\n}";

    /* renamed from: b  reason: collision with root package name */
    protected final String f34017b = "CameraGLRendererBase";

    /* renamed from: c  reason: collision with root package name */
    protected int f34018c;

    /* renamed from: d  reason: collision with root package name */
    protected int f34019d;

    /* renamed from: e  reason: collision with root package name */
    protected int f34020e;

    /* renamed from: f  reason: collision with root package name */
    protected int f34021f;

    /* renamed from: g  reason: collision with root package name */
    protected int f34022g;

    /* renamed from: h  reason: collision with root package name */
    protected int f34023h;

    /* renamed from: i  reason: collision with root package name */
    protected int f34024i;

    /* renamed from: j  reason: collision with root package name */
    protected SurfaceTexture f34025j;

    /* renamed from: k  reason: collision with root package name */
    protected boolean f34026k;

    /* renamed from: l  reason: collision with root package name */
    protected boolean f34027l;

    /* renamed from: m  reason: collision with root package name */
    protected boolean f34028m;

    /* renamed from: n  reason: collision with root package name */
    protected boolean f34029n;

    /* renamed from: o  reason: collision with root package name */
    protected boolean f34030o;

    /* renamed from: p  reason: collision with root package name */
    protected CameraGLSurfaceView f34031p;

    /* renamed from: q  reason: collision with root package name */
    private final String f34032q = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES sTexture;\nvarying vec2 texCoord;\nvoid main() {\n  gl_FragColor = texture2D(sTexture,texCoord);\n}";

    /* renamed from: r  reason: collision with root package name */
    private final String f34033r = "precision mediump float;\nuniform sampler2D sTexture;\nvarying vec2 texCoord;\nvoid main() {\n  gl_FragColor = texture2D(sTexture,texCoord);\n}";

    /* renamed from: s  reason: collision with root package name */
    private final float[] f34034s;

    /* renamed from: t  reason: collision with root package name */
    private final float[] f34035t;

    /* renamed from: u  reason: collision with root package name */
    private final float[] f34036u;

    /* renamed from: v  reason: collision with root package name */
    private int[] f34037v;

    /* renamed from: w  reason: collision with root package name */
    private int[] f34038w;

    /* renamed from: x  reason: collision with root package name */
    private int[] f34039x;

    /* renamed from: y  reason: collision with root package name */
    private int[] f34040y;

    /* renamed from: z  reason: collision with root package name */
    private int f34041z;

    public c(CameraGLSurfaceView cameraGLSurfaceView) {
        float[] fArr = {-1.0f, -1.0f, -1.0f, 1.0f, 1.0f, -1.0f, 1.0f, 1.0f};
        this.f34034s = fArr;
        float[] fArr2 = {0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f};
        this.f34035t = fArr2;
        float[] fArr3 = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
        this.f34036u = fArr3;
        this.f34037v = new int[]{0};
        this.f34038w = new int[]{0};
        this.f34039x = new int[]{0};
        this.f34040y = new int[]{0};
        this.f34041z = -1;
        this.A = -1;
        this.f34018c = -1;
        this.f34019d = -1;
        this.f34020e = -1;
        this.f34021f = -1;
        this.f34022g = -1;
        this.f34023h = -1;
        this.f34024i = -1;
        this.f34026k = false;
        this.f34027l = false;
        this.f34028m = false;
        this.f34029n = true;
        this.f34030o = false;
        this.f34031p = cameraGLSurfaceView;
        int length = (fArr.length * 32) / 8;
        this.F = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.G = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.H = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.F.put(fArr).position(0);
        this.G.put(fArr2).position(0);
        this.H.put(fArr3).position(0);
    }

    private static int a(String str, String str2) {
        Log.d("CameraGLRendererBase", "loadShader");
        int glCreateShader = GLES20.glCreateShader(35633);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] == 0) {
            Log.e("CameraGLRendererBase", "Could not compile vertex shader: " + GLES20.glGetShaderInfoLog(glCreateShader));
            GLES20.glDeleteShader(glCreateShader);
            return 0;
        }
        int glCreateShader2 = GLES20.glCreateShader(35632);
        GLES20.glShaderSource(glCreateShader2, str2);
        GLES20.glCompileShader(glCreateShader2);
        GLES20.glGetShaderiv(glCreateShader2, 35713, iArr, 0);
        if (iArr[0] == 0) {
            Log.e("CameraGLRendererBase", "Could not compile fragment shader:" + GLES20.glGetShaderInfoLog(glCreateShader2));
            GLES20.glDeleteShader(glCreateShader);
            GLES20.glDeleteShader(glCreateShader2);
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        GLES20.glAttachShader(glCreateProgram, glCreateShader);
        GLES20.glAttachShader(glCreateProgram, glCreateShader2);
        GLES20.glLinkProgram(glCreateProgram);
        GLES20.glDeleteShader(glCreateShader);
        GLES20.glDeleteShader(glCreateShader2);
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] == 0) {
            Log.e("CameraGLRendererBase", "Could not link shader program: " + GLES20.glGetProgramInfoLog(glCreateProgram));
            return 0;
        }
        GLES20.glValidateProgram(glCreateProgram);
        GLES20.glGetProgramiv(glCreateProgram, 35715, iArr, 0);
        if (iArr[0] == 0) {
            Log.e("CameraGLRendererBase", "Shader program validation error: " + GLES20.glGetProgramInfoLog(glCreateProgram));
            GLES20.glDeleteProgram(glCreateProgram);
            return 0;
        }
        Log.d("CameraGLRendererBase", "Shader program is built OK");
        return glCreateProgram;
    }

    private void a(int i2, int i3) {
        int i4 = i2;
        int i5 = i3;
        Log.d("CameraGLRendererBase", "initFBO(" + i4 + "x" + i5 + ")");
        l();
        GLES20.glGenTextures(1, this.f34039x, 0);
        GLES20.glBindTexture(3553, this.f34039x[0]);
        GLES20.glTexImage2D(3553, 0, 6408, i2, i3, 0, 6408, 5121, (Buffer) null);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glTexParameteri(3553, 10241, 9728);
        GLES20.glTexParameteri(3553, 10240, 9728);
        GLES20.glGenTextures(1, this.f34038w, 0);
        GLES20.glBindTexture(3553, this.f34038w[0]);
        GLES20.glTexImage2D(3553, 0, 6408, i2, i3, 0, 6408, 5121, (Buffer) null);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glTexParameteri(3553, 10241, 9728);
        GLES20.glTexParameteri(3553, 10240, 9728);
        GLES20.glGenFramebuffers(1, this.f34040y, 0);
        GLES20.glBindFramebuffer(36160, this.f34040y[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.f34038w[0], 0);
        Log.d("CameraGLRendererBase", "initFBO error status: " + GLES20.glGetError());
        int glCheckFramebufferStatus = GLES20.glCheckFramebufferStatus(36160);
        if (glCheckFramebufferStatus != 36053) {
            Log.e("CameraGLRendererBase", "initFBO failed, status: " + glCheckFramebufferStatus);
        }
        this.f34020e = i4;
        this.f34021f = i5;
    }

    private void a(int i2, boolean z2, int i3) {
        int i4;
        int i5;
        FloatBuffer floatBuffer;
        int i6;
        boolean z3;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11 = i2;
        int i12 = i3;
        GLES20.glBindFramebuffer(36160, i12);
        if (i12 == 0) {
            i5 = this.f34031p.getWidth();
            i4 = this.f34031p.getHeight();
        } else {
            i5 = this.f34020e;
            i4 = this.f34021f;
        }
        GLES20.glViewport(0, 0, i5, i4);
        GLES20.glClear(16384);
        if (z2) {
            GLES20.glUseProgram(this.f34041z);
            GLES20.glVertexAttribPointer(this.B, 2, 5126, false, 8, this.F);
            i9 = this.C;
            i8 = 2;
            i7 = 5126;
            z3 = false;
            i6 = 8;
            floatBuffer = this.G;
        } else {
            GLES20.glUseProgram(this.A);
            GLES20.glVertexAttribPointer(this.D, 2, 5126, false, 8, this.F);
            i9 = this.E;
            i8 = 2;
            i7 = 5126;
            z3 = false;
            i6 = 8;
            floatBuffer = this.H;
        }
        GLES20.glVertexAttribPointer(i9, i8, i7, z3, i6, floatBuffer);
        GLES20.glActiveTexture(33984);
        if (z2) {
            GLES20.glBindTexture(36197, i11);
            i10 = this.f34041z;
        } else {
            GLES20.glBindTexture(3553, i11);
            i10 = this.A;
        }
        GLES20.glUniform1i(GLES20.glGetUniformLocation(i10, "sTexture"), 0);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glFlush();
    }

    private void a(int[] iArr) {
        if (iArr.length == 1) {
            GLES20.glGenTextures(1, iArr, 0);
            GLES20.glBindTexture(36197, iArr[0]);
            GLES20.glTexParameteri(36197, 10242, 33071);
            GLES20.glTexParameteri(36197, 10243, 33071);
            GLES20.glTexParameteri(36197, 10241, 9728);
            GLES20.glTexParameteri(36197, 10240, 9728);
        }
    }

    private static void b(int[] iArr) {
        if (iArr.length == 1) {
            GLES20.glDeleteTextures(1, iArr, 0);
        }
    }

    private void i() {
        String glGetString = GLES20.glGetString(7938);
        if (glGetString != null) {
            Log.i("CameraGLRendererBase", "OpenGL ES version: " + glGetString);
        }
        GLES20.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        int a2 = a("attribute vec2 vPosition;\nattribute vec2 vTexCoord;\nvarying vec2 texCoord;\nvoid main() {\n  texCoord = vTexCoord;\n  gl_Position = vec4 ( vPosition.x, vPosition.y, 0.0, 1.0 );\n}", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nuniform samplerExternalOES sTexture;\nvarying vec2 texCoord;\nvoid main() {\n  gl_FragColor = texture2D(sTexture,texCoord);\n}");
        this.f34041z = a2;
        this.B = GLES20.glGetAttribLocation(a2, "vPosition");
        this.C = GLES20.glGetAttribLocation(this.f34041z, "vTexCoord");
        GLES20.glEnableVertexAttribArray(this.B);
        GLES20.glEnableVertexAttribArray(this.C);
        int a3 = a("attribute vec2 vPosition;\nattribute vec2 vTexCoord;\nvarying vec2 texCoord;\nvoid main() {\n  texCoord = vTexCoord;\n  gl_Position = vec4 ( vPosition.x, vPosition.y, 0.0, 1.0 );\n}", "precision mediump float;\nuniform sampler2D sTexture;\nvarying vec2 texCoord;\nvoid main() {\n  gl_FragColor = texture2D(sTexture,texCoord);\n}");
        this.A = a3;
        this.D = GLES20.glGetAttribLocation(a3, "vPosition");
        this.E = GLES20.glGetAttribLocation(this.A, "vTexCoord");
        GLES20.glEnableVertexAttribArray(this.D);
        GLES20.glEnableVertexAttribArray(this.E);
    }

    private void j() {
        Log.d("CameraGLRendererBase", "initSurfaceTexture");
        k();
        a(this.f34037v);
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.f34037v[0]);
        this.f34025j = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this);
    }

    private void k() {
        Log.d("CameraGLRendererBase", "deleteSurfaceTexture");
        SurfaceTexture surfaceTexture = this.f34025j;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.f34025j = null;
            b(this.f34037v);
        }
    }

    private void l() {
        Log.d("CameraGLRendererBase", "deleteFBO(" + this.f34020e + "x" + this.f34021f + ")");
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glDeleteFramebuffers(1, this.f34040y, 0);
        b(this.f34038w);
        b(this.f34039x);
        this.f34021f = 0;
        this.f34020e = 0;
    }

    /* access modifiers changed from: protected */
    public synchronized void a() {
        int i2;
        Log.d("CameraGLRendererBase", "doStart");
        j();
        a(this.f34024i);
        this.f34030o = true;
        int i3 = this.f34018c;
        if (i3 > 0 && (i2 = this.f34019d) > 0) {
            c(i3, i2);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void a(int i2);

    /* access modifiers changed from: protected */
    public void b() {
        Log.d("CameraGLRendererBase", "doStop");
        synchronized (this) {
            this.f34028m = false;
            this.f34030o = false;
            this.f34027l = false;
            c();
            k();
        }
        CameraGLSurfaceView.a cameraTextureListener = this.f34031p.getCameraTextureListener();
        if (cameraTextureListener != null) {
            cameraTextureListener.a();
        }
    }

    public void b(int i2) {
        e();
        this.f34024i = i2;
        d();
    }

    /* access modifiers changed from: protected */
    public abstract void b(int i2, int i3);

    /* access modifiers changed from: protected */
    public abstract void c();

    /* access modifiers changed from: protected */
    public void c(int i2, int i3) {
        synchronized (this) {
            this.f34027l = false;
            this.f34018c = i2;
            this.f34019d = i3;
            b(i2, i3);
            a(this.f34018c, this.f34019d);
            this.f34027l = true;
        }
        CameraGLSurfaceView.a cameraTextureListener = this.f34031p.getCameraTextureListener();
        if (cameraTextureListener != null) {
            cameraTextureListener.a(this.f34018c, this.f34019d);
        }
    }

    public synchronized void d() {
        Log.d("CameraGLRendererBase", "enableView");
        this.f34029n = true;
        f();
    }

    public synchronized void e() {
        Log.d("CameraGLRendererBase", "disableView");
        this.f34029n = false;
        f();
    }

    /* access modifiers changed from: protected */
    public void f() {
        Log.d("CameraGLRendererBase", "updateState");
        Log.d("CameraGLRendererBase", "mEnabled=" + this.f34029n + ", mHaveSurface=" + this.f34026k);
        boolean z2 = this.f34029n && this.f34026k && this.f34031p.getVisibility() == 0;
        if (z2 == this.f34030o) {
            Log.d("CameraGLRendererBase", "keeping State unchanged");
        } else if (z2) {
            a();
        } else {
            b();
        }
        Log.d("CameraGLRendererBase", "updateState end");
    }

    public void g() {
        Log.i("CameraGLRendererBase", "onResume");
    }

    public void h() {
        Log.i("CameraGLRendererBase", "onPause");
        this.f34026k = false;
        f();
        this.f34019d = -1;
        this.f34018c = -1;
    }

    public void onDrawFrame(GL10 gl10) {
        if (this.f34027l) {
            synchronized (this) {
                if (this.f34028m) {
                    this.f34025j.updateTexImage();
                    this.f34028m = false;
                }
                GLES20.glClear(16384);
                CameraGLSurfaceView.a cameraTextureListener = this.f34031p.getCameraTextureListener();
                if (cameraTextureListener != null) {
                    a(this.f34037v[0], true, this.f34040y[0]);
                    a(cameraTextureListener.a(this.f34038w[0], this.f34039x[0], this.f34018c, this.f34019d) ? this.f34039x[0] : this.f34038w[0], false, 0);
                } else {
                    Log.d("CameraGLRendererBase", "texCamera(OES) -> screen");
                    a(this.f34037v[0], true, 0);
                }
            }
        }
    }

    public synchronized void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.f34028m = true;
        this.f34031p.requestRender();
    }

    public void onSurfaceChanged(GL10 gl10, int i2, int i3) {
        Log.i("CameraGLRendererBase", "onSurfaceChanged(" + i2 + "x" + i3 + ")");
        this.f34026k = true;
        f();
        c(i2, i3);
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        Log.i("CameraGLRendererBase", "onSurfaceCreated");
        i();
    }
}
