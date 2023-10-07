package jl;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLException;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.os.Handler;
import android.view.Surface;
import com.shuyu.gsyvideoplayer.render.view.GSYVideoGLView;
import com.shuyu.gsyvideoplayer.utils.Debuger;
import java.nio.IntBuffer;
import javax.microedition.khronos.opengles.GL10;
import jg.f;
import jm.b;

public abstract class a implements SurfaceTexture.OnFrameAvailableListener, GLSurfaceView.Renderer {

    /* renamed from: a  reason: collision with root package name */
    protected boolean f29508a = false;

    /* renamed from: b  reason: collision with root package name */
    protected jm.a f29509b;

    /* renamed from: c  reason: collision with root package name */
    protected GLSurfaceView f29510c;

    /* renamed from: d  reason: collision with root package name */
    protected float[] f29511d = new float[16];

    /* renamed from: e  reason: collision with root package name */
    protected float[] f29512e = new float[16];

    /* renamed from: f  reason: collision with root package name */
    protected int f29513f = 0;

    /* renamed from: g  reason: collision with root package name */
    protected int f29514g = 0;

    /* renamed from: h  reason: collision with root package name */
    protected int f29515h = 0;

    /* renamed from: i  reason: collision with root package name */
    protected int f29516i = 0;

    /* renamed from: j  reason: collision with root package name */
    protected boolean f29517j = false;

    /* renamed from: k  reason: collision with root package name */
    protected boolean f29518k = false;

    /* renamed from: l  reason: collision with root package name */
    protected b f29519l;

    /* renamed from: m  reason: collision with root package name */
    protected Handler f29520m = new Handler();

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
        Debuger.printfError("Could not compile shader " + i2 + ":");
        Debuger.printfError(GLES20.glGetShaderInfoLog(glCreateShader));
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
                Debuger.printfError("Could not link program: ");
                Debuger.printfError(GLES20.glGetProgramInfoLog(glCreateProgram));
                GLES20.glDeleteProgram(glCreateProgram);
                return 0;
            }
        }
        return glCreateProgram;
    }

    /* access modifiers changed from: protected */
    public Bitmap a(int i2, int i3, int i4, int i5, GL10 gl10) {
        int i6 = i4;
        int i7 = i5;
        int i8 = i6 * i7;
        int[] iArr = new int[i8];
        int[] iArr2 = new int[i8];
        IntBuffer wrap = IntBuffer.wrap(iArr);
        wrap.position(0);
        try {
            gl10.glReadPixels(i2, i3, i4, i5, 6408, 5121, wrap);
            for (int i9 = 0; i9 < i7; i9++) {
                int i10 = i9 * i6;
                int i11 = ((i7 - i9) - 1) * i6;
                for (int i12 = 0; i12 < i6; i12++) {
                    int i13 = iArr[i10 + i12];
                    iArr2[i11 + i12] = (i13 & -16711936) | ((i13 << 16) & 16711680) | ((i13 >> 16) & 255);
                }
            }
            return Bitmap.createBitmap(iArr2, i6, i7, this.f29508a ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        } catch (GLException unused) {
            return null;
        }
    }

    public abstract void a();

    public void a(int i2) {
        this.f29513f = i2;
    }

    public void a(GLSurfaceView gLSurfaceView) {
        this.f29510c = gLSurfaceView;
    }

    public void a(final Surface surface) {
        this.f29520m.post(new Runnable() {
            public void run() {
                if (a.this.f29509b != null) {
                    a.this.f29509b.a(surface);
                }
            }
        });
    }

    public void a(GSYVideoGLView.a aVar) {
    }

    /* access modifiers changed from: protected */
    public void a(final String str) {
        final int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            Debuger.printfError(str + ": glError " + glGetError);
            this.f29520m.post(new Runnable() {
                public void run() {
                    if (a.this.f29519l != null) {
                        b bVar = a.this.f29519l;
                        a aVar = a.this;
                        bVar.a(aVar, str + ": glError " + glGetError, glGetError, a.this.f29518k);
                    }
                    a.this.f29518k = false;
                }
            });
        }
    }

    public void a(f fVar, boolean z2) {
    }

    public void a(jm.a aVar) {
        this.f29509b = aVar;
    }

    public void a(b bVar) {
        this.f29519l = bVar;
    }

    public void a(float[] fArr) {
        this.f29511d = fArr;
    }

    public void b(int i2) {
        this.f29514g = i2;
    }

    public float[] b() {
        return this.f29511d;
    }

    public void c() {
    }

    public void c(int i2) {
        this.f29515h = i2;
    }

    public GSYVideoGLView.a d() {
        return null;
    }

    public void d(int i2) {
        this.f29516i = i2;
    }

    public void e() {
        int i2 = this.f29513f;
        if (i2 != 0 && this.f29514g != 0) {
            Matrix.scaleM(this.f29511d, 0, ((float) i2) / ((float) this.f29510c.getWidth()), ((float) this.f29514g) / ((float) this.f29510c.getHeight()), 1.0f);
        }
    }
}
