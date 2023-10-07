package ct;

import android.opengl.GLES20;
import com.ctoo.mediaedit.R;
import com.ctoo.mediaedit.filter.a;

public class ae extends d {

    /* renamed from: b  reason: collision with root package name */
    private int f26305b;

    /* renamed from: c  reason: collision with root package name */
    private int f26306c;

    public ae() {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", a.a(R.raw.sketch));
    }

    private void a(float f2, float f3) {
        a(this.f26305b, new float[]{1.0f / f2, 1.0f / f3});
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
        this.f26305b = GLES20.glGetUniformLocation(j(), "singleStepOffset");
        this.f26306c = GLES20.glGetUniformLocation(j(), "strength");
    }

    public void e() {
        super.e();
        a(this.f26306c, 0.5f);
    }
}
