package cy;

import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Log;
import com.ctoo.mediaedit.R;
import com.ctoo.mediaedit.utils.EasyGlUtils;
import com.ctoo.mediaedit.utils.MatrixUtils;
import cs.a;
import cs.b;
import cs.c;
import cs.e;
import cs.f;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

class g {
    private int[] A = new int[1];
    private int[] B = new int[2];
    private float[] C;

    /* renamed from: a  reason: collision with root package name */
    float[] f26555a = new float[16];

    /* renamed from: b  reason: collision with root package name */
    a f26556b;

    /* renamed from: c  reason: collision with root package name */
    e f26557c;

    /* renamed from: d  reason: collision with root package name */
    cu.e f26558d;

    /* renamed from: e  reason: collision with root package name */
    b f26559e;

    /* renamed from: f  reason: collision with root package name */
    int f26560f;

    /* renamed from: g  reason: collision with root package name */
    int f26561g;

    /* renamed from: h  reason: collision with root package name */
    int f26562h;

    /* renamed from: i  reason: collision with root package name */
    int f26563i;

    /* renamed from: j  reason: collision with root package name */
    int f26564j;

    /* renamed from: k  reason: collision with root package name */
    int f26565k;

    /* renamed from: l  reason: collision with root package name */
    int f26566l;

    /* renamed from: m  reason: collision with root package name */
    int f26567m;

    /* renamed from: n  reason: collision with root package name */
    boolean f26568n = false;

    /* renamed from: o  reason: collision with root package name */
    int f26569o;

    /* renamed from: p  reason: collision with root package name */
    int f26570p;

    /* renamed from: q  reason: collision with root package name */
    private final float[] f26571q;

    /* renamed from: r  reason: collision with root package name */
    private FloatBuffer f26572r;

    /* renamed from: s  reason: collision with root package name */
    private float[] f26573s = new float[16];

    /* renamed from: t  reason: collision with root package name */
    private float[] f26574t = new float[16];

    /* renamed from: u  reason: collision with root package name */
    private int f26575u;

    /* renamed from: v  reason: collision with root package name */
    private int f26576v = -12345;

    /* renamed from: w  reason: collision with root package name */
    private int f26577w;

    /* renamed from: x  reason: collision with root package name */
    private int f26578x;

    /* renamed from: y  reason: collision with root package name */
    private int f26579y;

    /* renamed from: z  reason: collision with root package name */
    private int f26580z;

    public g(int i2, int i3, Resources resources) {
        float[] fArr = {-1.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f, -1.0f, 0.0f, 1.0f, 1.0f, -1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 0.0f};
        this.f26571q = fArr;
        this.f26569o = i2;
        this.f26570p = i3;
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f26572r = asFloatBuffer;
        asFloatBuffer.put(fArr).position(0);
        Matrix.setIdentityM(this.f26574t, 0);
        c cVar = new c(resources);
        this.f26556b = cVar;
        cVar.a(MatrixUtils.a(MatrixUtils.a(), false, true));
        this.f26557c = new e(resources);
        this.f26559e = new b(resources);
        f fVar = new f(resources);
        fVar.a(BitmapFactory.decodeResource(resources, R.mipmap.ic_controller_easy_photos));
        fVar.a(0, 70, 0, 0);
        this.f26559e.a(fVar);
        float[] a2 = MatrixUtils.a();
        this.C = a2;
        MatrixUtils.a(a2, false, false);
        this.f26559e.a(this.C);
    }

    private int a(int i2, String str) {
        int glCreateShader = GLES20.glCreateShader(i2);
        a("glCreateShader type=" + i2);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return glCreateShader;
        }
        Log.e("TextureRender", "Could not compile shader " + i2 + ":");
        StringBuilder sb = new StringBuilder();
        sb.append(" ");
        sb.append(GLES20.glGetShaderInfoLog(glCreateShader));
        Log.e("TextureRender", sb.toString());
        GLES20.glDeleteShader(glCreateShader);
        return 0;
    }

    private int a(String str, String str2) {
        int a2;
        int a3 = a(35633, str);
        if (a3 == 0 || (a2 = a(35632, str2)) == 0) {
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        a("glCreateProgram");
        if (glCreateProgram == 0) {
            Log.e("TextureRender", "Could not create program");
        }
        GLES20.glAttachShader(glCreateProgram, a3);
        a("glAttachShader");
        GLES20.glAttachShader(glCreateProgram, a2);
        a("glAttachShader");
        GLES20.glLinkProgram(glCreateProgram);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] == 1) {
            return glCreateProgram;
        }
        Log.e("TextureRender", "Could not link program: ");
        Log.e("TextureRender", GLES20.glGetProgramInfoLog(glCreateProgram));
        GLES20.glDeleteProgram(glCreateProgram);
        return 0;
    }

    private void c() {
        int i2 = this.f26560f;
        int i3 = this.f26562h;
        float f2 = ((float) i2) / ((float) i3);
        int i4 = this.f26561g;
        int i5 = this.f26563i;
        float f3 = ((float) i4) / ((float) i5);
        if (f2 < f3) {
            this.f26564j = i2;
            this.f26565k = (int) (((float) i5) * f2);
        } else {
            this.f26564j = (int) (((float) i3) * f3);
            this.f26565k = i4;
        }
        this.f26566l = (i2 - this.f26564j) / 2;
        this.f26567m = (i4 - this.f26565k) / 2;
    }

    public int a() {
        return this.f26576v;
    }

    public void a(int i2, int i3) {
        b(i2, i3);
        c();
        this.f26568n = true;
        this.f26559e.a(this.f26560f, this.f26561g);
    }

    public void a(SurfaceTexture surfaceTexture) {
        b(surfaceTexture);
    }

    public void a(cu.e eVar) {
        cu.e eVar2 = this.f26558d;
        if (eVar2 != null) {
            eVar2.h();
        }
        this.f26558d = eVar;
        if (eVar != null) {
            eVar.f();
            this.f26558d.c(this.f26569o, this.f26570p);
            this.f26558d.a(this.f26569o, this.f26570p);
        }
    }

    public void a(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            Log.e("TextureRender", str + ": glError " + glGetError);
            throw new RuntimeException(str + ": glError " + glGetError);
        }
    }

    public void b() {
        int a2 = a("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n");
        this.f26575u = a2;
        if (a2 != 0) {
            this.f26579y = GLES20.glGetAttribLocation(a2, "aPosition");
            a("glGetAttribLocation aPosition");
            if (this.f26579y != -1) {
                this.f26580z = GLES20.glGetAttribLocation(this.f26575u, "aTextureCoord");
                a("glGetAttribLocation aTextureCoord");
                if (this.f26580z != -1) {
                    this.f26577w = GLES20.glGetUniformLocation(this.f26575u, "uMVPMatrix");
                    a("glGetUniformLocation uMVPMatrix");
                    if (this.f26577w != -1) {
                        this.f26578x = GLES20.glGetUniformLocation(this.f26575u, "uSTMatrix");
                        a("glGetUniformLocation uSTMatrix");
                        if (this.f26578x != -1) {
                            int[] iArr = new int[1];
                            GLES20.glGenTextures(1, iArr, 0);
                            int i2 = iArr[0];
                            this.f26576v = i2;
                            GLES20.glBindTexture(36197, i2);
                            a("glBindTexture mTextureID");
                            GLES20.glTexParameterf(36197, 10241, 9729.0f);
                            GLES20.glTexParameterf(36197, 10240, 9729.0f);
                            GLES20.glTexParameteri(36197, 10242, 33071);
                            GLES20.glTexParameteri(36197, 10243, 33071);
                            a("glTexParameter");
                            this.f26556b.a();
                            this.f26557c.a();
                            this.f26557c.a(this.f26576v);
                            this.f26559e.a();
                            GLES20.glGenFramebuffers(1, this.A, 0);
                            EasyGlUtils.a(2, this.B, 0, 6408, this.f26569o, this.f26570p);
                            this.f26560f = this.f26569o;
                            this.f26561g = this.f26570p;
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
        throw new RuntimeException("failed creating program");
    }

    public void b(int i2, int i3) {
        this.f26562h = i2;
        this.f26563i = i3;
    }

    public void b(SurfaceTexture surfaceTexture) {
        char c2 = 0;
        EasyGlUtils.a(this.A[0], this.B[0]);
        GLES20.glViewport(0, 0, this.f26560f, this.f26561g);
        this.f26557c.b();
        EasyGlUtils.b();
        this.f26559e.a(this.B[0]);
        this.f26559e.b();
        if (this.f26558d != null) {
            EasyGlUtils.a(this.A[0], this.B[1]);
            this.f26558d.a(this.f26559e.f());
            EasyGlUtils.b();
        }
        if (this.f26568n) {
            GLES20.glViewport(this.f26566l, this.f26567m, this.f26564j, this.f26565k);
        }
        a aVar = this.f26556b;
        int[] iArr = this.B;
        if (this.f26558d != null) {
            c2 = 1;
        }
        aVar.a(iArr[c2]);
        this.f26556b.b();
        GLES20.glFinish();
    }
}
