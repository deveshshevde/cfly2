package jl;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.view.Surface;
import com.shuyu.gsyvideoplayer.render.view.GSYVideoGLView;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import jg.f;
import jk.a;

public class b extends a {
    private GSYVideoGLView.a A = new a();

    /* renamed from: n  reason: collision with root package name */
    private final float[] f29526n;

    /* renamed from: o  reason: collision with root package name */
    private final String f29527o = "uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n";

    /* renamed from: p  reason: collision with root package name */
    private int f29528p;

    /* renamed from: q  reason: collision with root package name */
    private int[] f29529q = new int[2];

    /* renamed from: r  reason: collision with root package name */
    private int f29530r;

    /* renamed from: s  reason: collision with root package name */
    private int f29531s;

    /* renamed from: t  reason: collision with root package name */
    private int f29532t;

    /* renamed from: u  reason: collision with root package name */
    private int f29533u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f29534v = false;

    /* renamed from: w  reason: collision with root package name */
    private boolean f29535w = false;

    /* renamed from: x  reason: collision with root package name */
    private FloatBuffer f29536x;

    /* renamed from: y  reason: collision with root package name */
    private SurfaceTexture f29537y;

    /* renamed from: z  reason: collision with root package name */
    private f f29538z;

    public b() {
        float[] fArr = {-1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
        this.f29526n = fArr;
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f29536x = asFloatBuffer;
        asFloatBuffer.put(fArr).position(0);
        Matrix.setIdentityM(this.f29512e, 0);
        Matrix.setIdentityM(this.f29511d, 0);
    }

    public void a() {
    }

    public void a(GSYVideoGLView.a aVar) {
        if (aVar != null) {
            this.A = aVar;
        }
        this.f29517j = true;
        this.f29518k = true;
    }

    /* access modifiers changed from: protected */
    public void a(GL10 gl10) {
        if (this.f29535w) {
            this.f29535w = false;
            if (this.f29538z != null) {
                this.f29538z.getBitmap(a(0, 0, this.f29510c.getWidth(), this.f29510c.getHeight(), gl10));
            }
        }
    }

    public void a(f fVar, boolean z2) {
        this.f29538z = fVar;
        this.f29508a = z2;
    }

    public void c() {
        this.f29535w = true;
    }

    public GSYVideoGLView.a d() {
        return this.A;
    }

    /* access modifiers changed from: protected */
    public void f() {
        if (this.f29517j) {
            this.f29528p = a(i(), j());
            this.f29517j = false;
        }
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glClear(16640);
        GLES20.glUseProgram(this.f29528p);
        a("glUseProgram");
    }

    /* access modifiers changed from: protected */
    public void g() {
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, this.f29529q[0]);
    }

    /* access modifiers changed from: protected */
    public void h() {
        this.f29536x.position(0);
        GLES20.glVertexAttribPointer(this.f29532t, 3, 5126, false, 20, this.f29536x);
        a("glVertexAttribPointer maPosition");
        GLES20.glEnableVertexAttribArray(this.f29532t);
        a("glEnableVertexAttribArray maPositionHandle");
        this.f29536x.position(3);
        GLES20.glVertexAttribPointer(this.f29533u, 3, 5126, false, 20, this.f29536x);
        a("glVertexAttribPointer maTextureHandle");
        GLES20.glEnableVertexAttribArray(this.f29533u);
        a("glEnableVertexAttribArray maTextureHandle");
        GLES20.glUniformMatrix4fv(this.f29530r, 1, false, this.f29511d, 0);
        GLES20.glUniformMatrix4fv(this.f29531s, 1, false, this.f29512e, 0);
        GLES20.glDrawArrays(5, 0, 4);
        a("glDrawArrays");
    }

    /* access modifiers changed from: protected */
    public String i() {
        return "uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n";
    }

    /* access modifiers changed from: protected */
    public String j() {
        return this.A.a(this.f29510c);
    }

    public void onDrawFrame(GL10 gl10) {
        synchronized (this) {
            if (this.f29534v) {
                this.f29537y.updateTexImage();
                this.f29537y.getTransformMatrix(this.f29512e);
                this.f29534v = false;
            }
        }
        f();
        g();
        h();
        a(gl10);
        GLES20.glFinish();
    }

    public synchronized void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.f29534v = true;
    }

    public void onSurfaceChanged(GL10 gl10, int i2, int i3) {
        GLES20.glViewport(0, 0, i2, i3);
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        int a2 = a(i(), j());
        this.f29528p = a2;
        if (a2 != 0) {
            this.f29532t = GLES20.glGetAttribLocation(a2, "aPosition");
            a("glGetAttribLocation aPosition");
            if (this.f29532t != -1) {
                this.f29533u = GLES20.glGetAttribLocation(this.f29528p, "aTextureCoord");
                a("glGetAttribLocation aTextureCoord");
                if (this.f29533u != -1) {
                    this.f29530r = GLES20.glGetUniformLocation(this.f29528p, "uMVPMatrix");
                    a("glGetUniformLocation uMVPMatrix");
                    if (this.f29530r != -1) {
                        this.f29531s = GLES20.glGetUniformLocation(this.f29528p, "uSTMatrix");
                        a("glGetUniformLocation uSTMatrix");
                        if (this.f29531s != -1) {
                            GLES20.glGenTextures(2, this.f29529q, 0);
                            GLES20.glBindTexture(36197, this.f29529q[0]);
                            a("glBindTexture mTextureID");
                            GLES20.glTexParameteri(3553, 10241, 9729);
                            GLES20.glTexParameteri(3553, 10240, 9729);
                            GLES20.glTexParameteri(3553, 10242, 33071);
                            GLES20.glTexParameteri(3553, 10243, 33071);
                            SurfaceTexture surfaceTexture = new SurfaceTexture(this.f29529q[0]);
                            this.f29537y = surfaceTexture;
                            surfaceTexture.setOnFrameAvailableListener(this);
                            a(new Surface(this.f29537y));
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
}
