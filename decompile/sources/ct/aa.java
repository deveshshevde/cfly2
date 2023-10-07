package ct;

import android.opengl.GLES20;
import com.ctoo.mediaedit.R;
import com.ctoo.mediaedit.filter.a;
import com.ctoo.mediaedit.filter.gpu.b;

public class aa extends d {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public int[] f26291b = {-1, -1, -1};

    /* renamed from: c  reason: collision with root package name */
    private int[] f26292c = {-1, -1, -1};

    public aa() {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", a.a(R.raw.rise));
    }

    public void a() {
        super.a();
        int[] iArr = this.f26291b;
        int i2 = 0;
        GLES20.glDeleteTextures(iArr.length, iArr, 0);
        while (true) {
            int[] iArr2 = this.f26291b;
            if (i2 < iArr2.length) {
                iArr2[i2] = -1;
                i2++;
            } else {
                return;
            }
        }
    }

    public void b() {
        int i2 = 0;
        while (true) {
            int[] iArr = this.f26291b;
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
            int[] iArr = this.f26291b;
            if (i2 < iArr.length && iArr[i2] != -1) {
                int i3 = i2 + 3;
                GLES20.glActiveTexture(33984 + i3);
                GLES20.glBindTexture(3553, this.f26291b[i2]);
                GLES20.glUniform1i(this.f26292c[i2], i3);
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
            int[] iArr = this.f26292c;
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
        a((Runnable) new Runnable() {
            public void run() {
                aa.this.f26291b[0] = a.a(b.f10869a, "filter/blackboard1024.png");
                aa.this.f26291b[1] = a.a(b.f10869a, "filter/overlaymap.png");
                aa.this.f26291b[2] = a.a(b.f10869a, "filter/risemap.png");
            }
        });
    }
}
