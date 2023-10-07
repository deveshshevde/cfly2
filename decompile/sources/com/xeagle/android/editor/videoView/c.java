package com.xeagle.android.editor.videoView;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.os.Handler;
import android.util.Log;
import android.view.Surface;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class c implements SurfaceTexture.OnFrameAvailableListener, GLSurfaceView.Renderer {

    /* renamed from: j  reason: collision with root package name */
    private static final String f22862j = "c";

    /* renamed from: a  reason: collision with root package name */
    protected boolean f22863a;

    /* renamed from: b  reason: collision with root package name */
    protected boolean f22864b;

    /* renamed from: c  reason: collision with root package name */
    protected float[] f22865c;

    /* renamed from: d  reason: collision with root package name */
    protected float[] f22866d;

    /* renamed from: e  reason: collision with root package name */
    protected int f22867e;

    /* renamed from: f  reason: collision with root package name */
    protected int f22868f;

    /* renamed from: g  reason: collision with root package name */
    protected int f22869g;

    /* renamed from: h  reason: collision with root package name */
    protected int f22870h;

    /* renamed from: i  reason: collision with root package name */
    protected Handler f22871i;

    /* renamed from: k  reason: collision with root package name */
    private final String f22872k = "uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n";

    /* renamed from: l  reason: collision with root package name */
    private final float[] f22873l;

    /* renamed from: m  reason: collision with root package name */
    private a f22874m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public b f22875n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public SurfaceTexture f22876o;

    /* renamed from: p  reason: collision with root package name */
    private FloatBuffer f22877p;

    /* renamed from: q  reason: collision with root package name */
    private int f22878q;

    /* renamed from: r  reason: collision with root package name */
    private int[] f22879r;

    /* renamed from: s  reason: collision with root package name */
    private int f22880s;

    /* renamed from: t  reason: collision with root package name */
    private int f22881t;

    /* renamed from: u  reason: collision with root package name */
    private int f22882u;

    /* renamed from: v  reason: collision with root package name */
    private int f22883v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f22884w;

    public c(a aVar, b bVar) {
        float[] fArr = {-1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
        this.f22873l = fArr;
        this.f22876o = null;
        this.f22863a = false;
        this.f22864b = false;
        this.f22865c = new float[16];
        this.f22866d = new float[16];
        this.f22879r = new int[2];
        this.f22884w = false;
        this.f22867e = 0;
        this.f22868f = 0;
        this.f22869g = 0;
        this.f22870h = 0;
        this.f22871i = new Handler();
        this.f22874m = aVar;
        this.f22875n = bVar;
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f22877p = asFloatBuffer;
        asFloatBuffer.put(fArr).position(0);
        Matrix.setIdentityM(this.f22866d, 0);
        Matrix.setIdentityM(this.f22865c, 0);
    }

    /* access modifiers changed from: protected */
    public int a(int i2, String str) {
        int glCreateShader = GLES20.glCreateShader(i2);
        if (glCreateShader == 0) {
            return glCreateShader;
        }
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return glCreateShader;
        }
        String str2 = f22862j;
        Log.e(str2, "Could not compile shader " + i2 + ":");
        Log.e(str2, GLES20.glGetShaderInfoLog(glCreateShader));
        GLES20.glDeleteShader(glCreateShader);
        return 0;
    }

    /* access modifiers changed from: protected */
    public int a(String str, String str2) {
        int a2;
        int a3 = a(35633, str);
        if (a3 == 0 || (a2 = a(35632, str2)) == 0) {
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        if (glCreateProgram != 0) {
            GLES20.glAttachShader(glCreateProgram, a3);
            a("glAttachShader");
            GLES20.glAttachShader(glCreateProgram, a2);
            a("glAttachShader");
            GLES20.glLinkProgram(glCreateProgram);
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
            if (iArr[0] != 1) {
                String str3 = f22862j;
                Log.e(str3, "Could not link program: ");
                Log.e(str3, GLES20.glGetProgramInfoLog(glCreateProgram));
                GLES20.glDeleteProgram(glCreateProgram);
                return 0;
            }
        }
        return glCreateProgram;
    }

    /* access modifiers changed from: protected */
    public void a() {
        int a2 = a(this.f22874m.b(), this.f22874m.c());
        this.f22878q = a2;
        if (a2 != 0) {
            this.f22882u = GLES20.glGetAttribLocation(a2, "aPosition");
            a("glGetAttribLocation aPosition");
            if (this.f22882u != -1) {
                this.f22883v = GLES20.glGetAttribLocation(this.f22878q, "aTextureCoord");
                a("glGetAttribLocation aTextureCoord");
                if (this.f22883v != -1) {
                    this.f22880s = GLES20.glGetUniformLocation(this.f22878q, "uMVPMatrix");
                    a("glGetUniformLocation uMVPMatrix");
                    if (this.f22880s != -1) {
                        this.f22881t = GLES20.glGetUniformLocation(this.f22878q, "uSTMatrix");
                        a("glGetUniformLocation uSTMatrix");
                        if (this.f22881t != -1) {
                            GLES20.glGenTextures(2, this.f22879r, 0);
                            GLES20.glBindTexture(36197, this.f22879r[0]);
                            a("glBindTexture mTextureID");
                            GLES20.glTexParameteri(3553, 10241, 9729);
                            GLES20.glTexParameteri(3553, 10240, 9729);
                            GLES20.glTexParameteri(3553, 10242, 33071);
                            GLES20.glTexParameteri(3553, 10243, 33071);
                            SurfaceTexture surfaceTexture = new SurfaceTexture(this.f22879r[0]);
                            this.f22876o = surfaceTexture;
                            surfaceTexture.setOnFrameAvailableListener(this);
                            a(new Surface(this.f22876o));
                            return;
                        }
                        throw new RuntimeException("Could not get attrib location for uSTMatrix");
                    }
                    throw new RuntimeException("Could not get attrib location for uMVPMatrix");
                }
                throw new RuntimeException("Could not get attrib location for aTextureCoord");
            }
            throw new RuntimeException("Could not get attrib location for aPosition");
        }
    }

    public void a(Surface surface) {
        this.f22871i.post(new Runnable() {
            public void run() {
                if (c.this.f22875n != null) {
                    c.this.f22875n.onCreated(c.this.f22876o);
                }
            }
        });
    }

    public void a(a aVar) {
        a aVar2 = this.f22874m;
        this.f22874m = aVar;
        if (aVar2 != null) {
            aVar2.d();
        }
        this.f22863a = true;
        this.f22864b = true;
    }

    /* access modifiers changed from: protected */
    public void a(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            String str2 = f22862j;
            Log.e(str2, str + ": glError " + glGetError);
            this.f22871i.post(new Runnable() {
                public void run() {
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void b() {
        if (this.f22863a) {
            this.f22878q = a(this.f22874m.b(), this.f22874m.c());
            this.f22863a = false;
        }
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glClear(16640);
        GLES20.glUseProgram(this.f22878q);
        a("glUseProgram");
    }

    /* access modifiers changed from: protected */
    public void c() {
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, this.f22879r[0]);
    }

    /* access modifiers changed from: protected */
    public void d() {
        this.f22877p.position(0);
        GLES20.glVertexAttribPointer(this.f22882u, 3, 5126, false, 20, this.f22877p);
        a("glVertexAttribPointer maPosition");
        GLES20.glEnableVertexAttribArray(this.f22882u);
        a("glEnableVertexAttribArray maPositionHandle");
        this.f22877p.position(3);
        GLES20.glVertexAttribPointer(this.f22883v, 3, 5126, false, 20, this.f22877p);
        a("glVertexAttribPointer maTextureHandle");
        GLES20.glEnableVertexAttribArray(this.f22883v);
        a("glEnableVertexAttribArray maTextureHandle");
        GLES20.glUniformMatrix4fv(this.f22880s, 1, false, this.f22865c, 0);
        GLES20.glUniformMatrix4fv(this.f22881t, 1, false, this.f22866d, 0);
        a aVar = this.f22874m;
        if (aVar != null) {
            aVar.a();
        }
        GLES20.glDrawArrays(5, 0, 4);
        a("glDrawArrays");
    }

    public a e() {
        return this.f22874m;
    }

    public void onDrawFrame(GL10 gl10) {
        synchronized (this) {
            if (this.f22884w) {
                this.f22876o.updateTexImage();
                this.f22876o.getTransformMatrix(this.f22866d);
                this.f22884w = false;
            }
        }
        b();
        c();
        d();
        GLES20.glFinish();
    }

    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.f22884w = true;
    }

    public void onSurfaceChanged(GL10 gl10, int i2, int i3) {
        GLES20.glViewport(0, 0, i2, i3);
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        a();
    }
}
