package ct;

import android.opengl.GLES20;
import com.ctoo.mediaedit.R;
import com.ctoo.mediaedit.filter.a;
import com.ctoo.mediaedit.filter.gpu.b;

public class n extends d {

    /* renamed from: b  reason: collision with root package name */
    private int f26397b;

    /* renamed from: c  reason: collision with root package name */
    private int f26398c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public int[] f26399d = {-1};

    /* renamed from: q  reason: collision with root package name */
    private int[] f26400q = {-1};

    public n() {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", a.a(R.raw.freud));
    }

    public void a() {
        super.a();
        int i2 = 0;
        GLES20.glDeleteTextures(1, this.f26399d, 0);
        while (true) {
            int[] iArr = this.f26399d;
            if (i2 < iArr.length) {
                iArr[i2] = -1;
                i2++;
            } else {
                return;
            }
        }
    }

    public void a(int i2, int i3) {
        super.a(i2, i3);
        GLES20.glUniform1f(this.f26398c, (float) i2);
        GLES20.glUniform1f(this.f26397b, (float) i3);
    }

    public void b() {
        int i2 = 0;
        while (true) {
            int[] iArr = this.f26399d;
            if (i2 < iArr.length && iArr[i2] != -1) {
                GLES20.glActiveTexture(i2 + 3 + 33984);
                GLES20.glBindTexture(3553, 0);
                GLES20.glActiveTexture(33984);
                i2++;
            } else {
                return;
            }
        }
    }

    public void c() {
        int i2 = 0;
        while (true) {
            int[] iArr = this.f26399d;
            if (i2 < iArr.length && iArr[i2] != -1) {
                int i3 = i2 + 3;
                GLES20.glActiveTexture(33984 + i3);
                GLES20.glBindTexture(3553, this.f26399d[i2]);
                GLES20.glUniform1i(this.f26400q[i2], i3);
                i2++;
            } else {
                return;
            }
        }
    }

    public void d() {
        super.d();
        this.f26400q[0] = GLES20.glGetUniformLocation(j(), "inputImageTexture2");
        this.f26398c = GLES20.glGetUniformLocation(j(), "inputImageTextureWidth");
        this.f26397b = GLES20.glGetUniformLocation(j(), "inputImageTextureHeight");
    }

    public void e() {
        super.e();
        a(this.f26370a, 1.0f);
        a((Runnable) new Runnable() {
            public void run() {
                n.this.f26399d[0] = a.a(b.f10869a, "filter/freud_rand.png");
            }
        });
    }
}
