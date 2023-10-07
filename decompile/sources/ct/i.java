package ct;

import android.opengl.GLES20;
import com.ctoo.mediaedit.R;
import com.ctoo.mediaedit.filter.a;

public class i extends d {

    /* renamed from: b  reason: collision with root package name */
    private int f26387b;

    public i() {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", a.a(R.raw.crayon));
    }

    private void a(float f2, float f3) {
        a(this.f26387b, new float[]{1.0f / f2, 1.0f / f3});
    }

    public void a() {
        super.a();
    }

    public void a(int i2, int i3) {
        super.a(i2, i3);
        a((float) i2, (float) i3);
    }

    public void d() {
        super.d();
        this.f26387b = GLES20.glGetUniformLocation(j(), "singleStepOffset");
        a(this.f26370a, 2.0f);
    }

    public void e() {
        super.e();
        a(this.f26370a, 0.5f);
    }
}
