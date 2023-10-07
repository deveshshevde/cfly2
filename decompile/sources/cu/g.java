package cu;

import android.opengl.GLES20;

public class g extends a {

    /* renamed from: a  reason: collision with root package name */
    private int f26480a;

    /* renamed from: b  reason: collision with root package name */
    private float f26481b;

    public g() {
        this(1.0f);
    }

    public g(float f2) {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \n uniform sampler2D inputImageTexture;\n uniform lowp float saturation;\nconst mediump vec3 luminanceWeighting = vec3(0.2125, 0.7154, 0.0721);\n \n void main()\n {\n     lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     lowp float luminance = dot(textureColor.rgb, luminanceWeighting);\n     lowp vec3 greyScaleColor = vec3(luminance);\n     \n     gl_FragColor = vec4(mix(greyScaleColor,textureColor.rgb,saturation), textureColor.w);\n }");
        this.f26481b = f2;
    }

    public void a(float f2) {
        this.f26481b = f2;
        a(this.f26480a, f2);
    }

    public void d() {
        super.d();
        this.f26480a = GLES20.glGetUniformLocation(j(), "saturation");
    }

    public void e() {
        super.e();
        a(this.f26481b);
    }
}
