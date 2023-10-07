package cu;

import android.opengl.GLES20;

public class c extends a {

    /* renamed from: a  reason: collision with root package name */
    private int f26450a;

    /* renamed from: b  reason: collision with root package name */
    private float f26451b;

    public c() {
        this(1.0f);
    }

    public c(float f2) {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \n uniform sampler2D inputImageTexture;\n uniform lowp float contrast;\n \n void main()\n {\n     lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     \n     gl_FragColor = vec4(((textureColor.rgb - vec3(0.5)) * contrast + vec3(0.5)), textureColor.w);\n }");
        this.f26451b = f2;
    }

    public void a(float f2) {
        this.f26451b = f2;
        a(this.f26450a, f2);
    }

    public void d() {
        super.d();
        this.f26450a = GLES20.glGetUniformLocation(j(), "contrast");
    }

    public void e() {
        super.e();
        a(this.f26451b);
    }
}
