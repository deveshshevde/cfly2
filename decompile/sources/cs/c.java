package cs;

import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.Log;

public class c extends a {

    /* renamed from: l  reason: collision with root package name */
    public String f26274l = "attribute vec4 vPosition;\nattribute vec2 vCoord;\nuniform mat4 vMatrix;\n\nvarying vec2 textureCoordinate;\n\nvoid main(){\n    gl_Position = vMatrix*vPosition;\n    textureCoordinate = vCoord;\n}";

    /* renamed from: m  reason: collision with root package name */
    public String f26275m = "precision mediump float;\nvarying vec2 textureCoordinate;\nuniform sampler2D vTexture;\nvoid main() {\n    gl_FragColor = texture2D( vTexture, textureCoordinate );\n}";

    public c(Resources resources) {
        super(resources);
    }

    /* access modifiers changed from: protected */
    public void b(int i2, int i3) {
    }

    /* access modifiers changed from: protected */
    public void g() {
        Log.e("thread", "---初始化NoFilter " + Thread.currentThread());
        a(this.f26274l, this.f26275m);
    }

    /* access modifiers changed from: protected */
    public void k() {
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16640);
    }
}
