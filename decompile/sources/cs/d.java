package cs;

import android.content.res.Resources;
import android.opengl.GLES20;

public class d extends a {

    /* renamed from: l  reason: collision with root package name */
    public String f26276l = "attribute vec4 vPosition;\nattribute vec2 vCoord;\nuniform mat4 vMatrix;\nvarying vec2 textureCoordinate;\n\nvoid main(){\n    gl_Position = vMatrix*vPosition;\n    textureCoordinate = vCoord;\n}";

    /* renamed from: m  reason: collision with root package name */
    public String f26277m = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 textureCoordinate;\nuniform samplerExternalOES vTexture;\nvoid main() {\n    gl_FragColor = texture2D( vTexture, textureCoordinate );\n}";

    public d(Resources resources) {
        super(resources);
    }

    /* access modifiers changed from: protected */
    public void b(int i2, int i3) {
    }

    /* access modifiers changed from: protected */
    public void g() {
        a(this.f26276l, this.f26277m);
    }

    /* access modifiers changed from: protected */
    public void m() {
        GLES20.glActiveTexture(d() + 33984);
        GLES20.glBindTexture(36197, e());
        GLES20.glUniform1i(this.f26254g, d());
    }
}
