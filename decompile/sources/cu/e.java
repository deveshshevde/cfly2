package cu;

import android.opengl.GLES20;
import com.ctoo.mediaedit.filter.Rotation;
import com.ctoo.mediaedit.filter.a;
import com.ctoo.mediaedit.utils.c;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.LinkedList;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private final LinkedList<Runnable> f26454a;

    /* renamed from: b  reason: collision with root package name */
    private final String f26455b;

    /* renamed from: c  reason: collision with root package name */
    private final String f26456c;

    /* renamed from: e  reason: collision with root package name */
    protected int f26457e;

    /* renamed from: f  reason: collision with root package name */
    protected int f26458f;

    /* renamed from: g  reason: collision with root package name */
    protected int f26459g;

    /* renamed from: h  reason: collision with root package name */
    protected int f26460h;

    /* renamed from: i  reason: collision with root package name */
    protected int f26461i;

    /* renamed from: j  reason: collision with root package name */
    protected int f26462j;

    /* renamed from: k  reason: collision with root package name */
    protected boolean f26463k;

    /* renamed from: l  reason: collision with root package name */
    protected int f26464l;

    /* renamed from: m  reason: collision with root package name */
    protected FloatBuffer f26465m;

    /* renamed from: n  reason: collision with root package name */
    protected FloatBuffer f26466n;

    /* renamed from: o  reason: collision with root package name */
    protected int f26467o;

    /* renamed from: p  reason: collision with root package name */
    protected int f26468p;

    public e() {
        this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "#extension GL_OES_EGL_image_external : require\nvarying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
    }

    public e(String str, String str2) {
        this.f26454a = new LinkedList<>();
        this.f26455b = str;
        this.f26456c = str2;
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(c.f10961e.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f26465m = asFloatBuffer;
        asFloatBuffer.put(c.f10961e).position(0);
        FloatBuffer asFloatBuffer2 = ByteBuffer.allocateDirect(c.f10957a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f26466n = asFloatBuffer2;
        asFloatBuffer2.put(c.a(Rotation.NORMAL, false, true)).position(0);
    }

    public int a(int i2) {
        GLES20.glUseProgram(this.f26457e);
        i();
        if (!this.f26463k) {
            return -1;
        }
        this.f26464l = i2;
        this.f26465m.position(0);
        GLES20.glVertexAttribPointer(this.f26458f, 2, 5126, false, 0, this.f26465m);
        GLES20.glEnableVertexAttribArray(this.f26458f);
        this.f26466n.position(0);
        GLES20.glVertexAttribPointer(this.f26460h, 2, 5126, false, 0, this.f26466n);
        GLES20.glEnableVertexAttribArray(this.f26460h);
        if (i2 != -1) {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, i2);
            GLES20.glUniform1i(this.f26459g, 0);
        }
        c();
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(this.f26458f);
        GLES20.glDisableVertexAttribArray(this.f26460h);
        b();
        GLES20.glBindTexture(3553, 0);
        return 1;
    }

    public void a() {
    }

    /* access modifiers changed from: protected */
    public void a(final int i2, final float f2) {
        a((Runnable) new Runnable() {
            public void run() {
                GLES20.glUniform1f(i2, f2);
            }
        });
    }

    public void a(int i2, int i3) {
        this.f26461i = i2;
        this.f26462j = i3;
    }

    /* access modifiers changed from: protected */
    public void a(final int i2, final float[] fArr) {
        a((Runnable) new Runnable() {
            public void run() {
                GLES20.glUniform2fv(i2, 1, FloatBuffer.wrap(fArr));
            }
        });
    }

    /* access modifiers changed from: protected */
    public void a(Runnable runnable) {
        synchronized (this.f26454a) {
            this.f26454a.addLast(runnable);
        }
    }

    /* access modifiers changed from: protected */
    public void b() {
    }

    /* access modifiers changed from: protected */
    public void b(final int i2, final int i3) {
        a((Runnable) new Runnable() {
            public void run() {
                GLES20.glUniform1i(i2, i3);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void c() {
    }

    public void c(int i2, int i3) {
        this.f26467o = i2;
        this.f26468p = i3;
    }

    public void d() {
        int a2 = a.a(this.f26455b, this.f26456c);
        this.f26457e = a2;
        this.f26458f = GLES20.glGetAttribLocation(a2, "position");
        this.f26459g = GLES20.glGetUniformLocation(this.f26457e, "inputImageTexture");
        this.f26460h = GLES20.glGetAttribLocation(this.f26457e, "inputTextureCoordinate");
        this.f26463k = true;
    }

    public void e() {
    }

    public final void f() {
        d();
        e();
    }

    public void g() {
        if (!this.f26463k) {
            f();
        }
    }

    public final void h() {
        this.f26463k = false;
        GLES20.glDeleteProgram(this.f26457e);
        a();
    }

    /* access modifiers changed from: protected */
    public void i() {
        while (!this.f26454a.isEmpty()) {
            this.f26454a.removeFirst().run();
        }
    }

    public int j() {
        return this.f26457e;
    }
}
