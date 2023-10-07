package jp.co.cyberagent.android.gpuimage;

import android.graphics.PointF;
import android.opengl.GLES20;
import java.nio.FloatBuffer;
import java.util.LinkedList;

public class a {

    /* renamed from: a  reason: collision with root package name */
    protected int f29649a;

    /* renamed from: b  reason: collision with root package name */
    protected int f29650b;

    /* renamed from: c  reason: collision with root package name */
    protected int f29651c;

    /* renamed from: d  reason: collision with root package name */
    protected int f29652d;

    /* renamed from: e  reason: collision with root package name */
    protected int f29653e;

    /* renamed from: f  reason: collision with root package name */
    protected int f29654f;

    /* renamed from: g  reason: collision with root package name */
    private final LinkedList<Runnable> f29655g;

    /* renamed from: h  reason: collision with root package name */
    private final String f29656h;

    /* renamed from: i  reason: collision with root package name */
    private final String f29657i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f29658j;

    public a() {
        this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
    }

    public a(String str, String str2) {
        this.f29655g = new LinkedList<>();
        this.f29656h = str;
        this.f29657i = str2;
    }

    public final void a() {
        b();
        this.f29658j = true;
        c();
    }

    /* access modifiers changed from: protected */
    public void a(final int i2, final float f2) {
        a(new Runnable() {
            public void run() {
                GLES20.glUniform1f(i2, f2);
            }
        });
    }

    public void a(int i2, int i3) {
        this.f29653e = i2;
        this.f29654f = i3;
    }

    /* access modifiers changed from: protected */
    public void a(final int i2, final PointF pointF) {
        a(new Runnable() {
            public void run() {
                GLES20.glUniform2fv(i2, 1, new float[]{pointF.x, pointF.y}, 0);
            }
        });
    }

    public void a(int i2, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        GLES20.glUseProgram(this.f29649a);
        g();
        if (this.f29658j) {
            floatBuffer.position(0);
            GLES20.glVertexAttribPointer(this.f29650b, 2, 5126, false, 0, floatBuffer);
            GLES20.glEnableVertexAttribArray(this.f29650b);
            floatBuffer2.position(0);
            GLES20.glVertexAttribPointer(this.f29652d, 2, 5126, false, 0, floatBuffer2);
            GLES20.glEnableVertexAttribArray(this.f29652d);
            if (i2 != -1) {
                GLES20.glActiveTexture(33984);
                GLES20.glBindTexture(3553, i2);
                GLES20.glUniform1i(this.f29651c, 0);
            }
            f();
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glDisableVertexAttribArray(this.f29650b);
            GLES20.glDisableVertexAttribArray(this.f29652d);
            GLES20.glBindTexture(3553, 0);
        }
    }

    /* access modifiers changed from: protected */
    public void a(final int i2, final float[] fArr) {
        a(new Runnable() {
            public void run() {
                GLES20.glUniformMatrix4fv(i2, 1, false, fArr, 0);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void a(Runnable runnable) {
        synchronized (this.f29655g) {
            this.f29655g.addLast(runnable);
        }
    }

    public void b() {
        int a2 = f.a(this.f29656h, this.f29657i);
        this.f29649a = a2;
        this.f29650b = GLES20.glGetAttribLocation(a2, "position");
        this.f29651c = GLES20.glGetUniformLocation(this.f29649a, "inputImageTexture");
        this.f29652d = GLES20.glGetAttribLocation(this.f29649a, "inputTextureCoordinate");
        this.f29658j = true;
    }

    public void c() {
    }

    public final void d() {
        this.f29658j = false;
        GLES20.glDeleteProgram(this.f29649a);
        e();
    }

    public void e() {
    }

    /* access modifiers changed from: protected */
    public void f() {
    }

    /* access modifiers changed from: protected */
    public void g() {
        while (!this.f29655g.isEmpty()) {
            this.f29655g.removeFirst().run();
        }
    }

    public boolean h() {
        return this.f29658j;
    }

    public int i() {
        return this.f29653e;
    }

    public int j() {
        return this.f29654f;
    }

    public int k() {
        return this.f29649a;
    }
}
