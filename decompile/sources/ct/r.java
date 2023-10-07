package ct;

import android.opengl.GLES20;
import com.ctoo.mediaedit.R;
import com.ctoo.mediaedit.filter.a;
import com.ctoo.mediaedit.filter.gpu.b;

public class r extends d {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public int[] f26415b = {-1};

    /* renamed from: c  reason: collision with root package name */
    private int[] f26416c = {-1};

    public r() {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", a.a(R.raw.inkwell));
    }

    public void a() {
        super.a();
        int i2 = 0;
        GLES20.glDeleteTextures(1, this.f26415b, 0);
        while (true) {
            int[] iArr = this.f26415b;
            if (i2 < iArr.length) {
                iArr[i2] = -1;
                i2++;
            } else {
                return;
            }
        }
    }

    public void b() {
        int i2 = 0;
        while (true) {
            int[] iArr = this.f26415b;
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
            int[] iArr = this.f26415b;
            if (i2 < iArr.length && iArr[i2] != -1) {
                int i3 = i2 + 3;
                GLES20.glActiveTexture(33984 + i3);
                GLES20.glBindTexture(3553, this.f26415b[i2]);
                GLES20.glUniform1i(this.f26416c[i2], i3);
                i2++;
            } else {
                return;
            }
        }
    }

    public void d() {
        super.d();
        int i2 = 0;
        while (true) {
            int[] iArr = this.f26416c;
            if (i2 < iArr.length) {
                int j2 = j();
                iArr[i2] = GLES20.glGetUniformLocation(j2, "inputImageTexture" + (i2 + 2));
                i2++;
            } else {
                return;
            }
        }
    }

    public void e() {
        super.e();
        a(this.f26370a, 1.0f);
        a((Runnable) new Runnable() {
            public void run() {
                r.this.f26415b[0] = a.a(b.f10869a, "filter/inkwellmap.png");
            }
        });
    }
}
