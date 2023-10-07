package cu;

import android.opengl.GLES20;

public class d extends a {

    /* renamed from: a  reason: collision with root package name */
    private int f26452a;

    /* renamed from: b  reason: collision with root package name */
    private float f26453b;

    public d() {
        this(0.0f);
    }

    public d(float f2) {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", " varying highp vec2 textureCoordinate;\n \n uniform sampler2D inputImageTexture;\n uniform highp float exposure;\n \n void main()\n {\n     highp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     \n     gl_FragColor = vec4(textureColor.rgb * pow(2.0, exposure), textureColor.w);\n } ");
        this.f26453b = f2;
    }

    public void a(float f2) {
        this.f26453b = f2;
        a(this.f26452a, f2);
    }

    public void d() {
        super.d();
        this.f26452a = GLES20.glGetUniformLocation(j(), "exposure");
    }

    public void e() {
        super.e();
        a(this.f26453b);
    }
}
