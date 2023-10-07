package cu;

import android.opengl.GLES20;

public class h extends a {

    /* renamed from: a  reason: collision with root package name */
    private int f26482a;

    /* renamed from: b  reason: collision with root package name */
    private float f26483b;

    /* renamed from: c  reason: collision with root package name */
    private int f26484c;

    /* renamed from: d  reason: collision with root package name */
    private int f26485d;

    public h() {
        this(0.0f);
    }

    public h(float f2) {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nuniform float imageWidthFactor;\nuniform float imageHeightFactor;\nuniform float sharpness;\n \nvarying vec2 textureCoordinate;\nvarying vec2 leftTextureCoordinate;\nvarying vec2 rightTextureCoordinate;\nvarying vec2 topTextureCoordinate;\nvarying vec2 bottomTextureCoordinate;\n \nvarying float centerMultiplier;\nvarying float edgeMultiplier;\n \nvoid main()\n{\n    gl_Position = position;\n    \n    mediump vec2 widthStep = vec2(imageWidthFactor, 0.0);\n    mediump vec2 heightStep = vec2(0.0, imageHeightFactor);\n    \n    textureCoordinate = inputTextureCoordinate.xy;\n    leftTextureCoordinate = inputTextureCoordinate.xy - widthStep;\n    rightTextureCoordinate = inputTextureCoordinate.xy + widthStep;\n    topTextureCoordinate = inputTextureCoordinate.xy - heightStep;\n    bottomTextureCoordinate = inputTextureCoordinate.xy + heightStep;\n    \n    centerMultiplier = 1.0 + 4.0 * sharpness;\n    edgeMultiplier = sharpness;\n}", "precision highp float;\nvarying highp vec2 textureCoordinate;\nvarying vec2 leftTextureCoordinate;\nvarying vec2 rightTextureCoordinate;\nvarying vec2 topTextureCoordinate;\nvarying vec2 bottomTextureCoordinate;\n \nvarying float centerMultiplier;\nvarying float edgeMultiplier;\n \n uniform sampler2D inputImageTexture;\n \n void main()\n {\n    mediump vec3 textureColor = texture2D(inputImageTexture, textureCoordinate).rgb;\n    mediump vec3 leftTextureColor = texture2D(inputImageTexture, leftTextureCoordinate).rgb;\n    mediump vec3 rightTextureColor = texture2D(inputImageTexture, rightTextureCoordinate).rgb;\n    mediump vec3 topTextureColor = texture2D(inputImageTexture, topTextureCoordinate).rgb;\n    mediump vec3 bottomTextureColor = texture2D(inputImageTexture, bottomTextureCoordinate).rgb;\n     \n    gl_FragColor = vec4((textureColor * centerMultiplier - (leftTextureColor * edgeMultiplier + rightTextureColor * edgeMultiplier + topTextureColor * edgeMultiplier + bottomTextureColor * edgeMultiplier)), texture2D(inputImageTexture, bottomTextureCoordinate).w);\n }");
        this.f26483b = f2;
    }

    public void a(float f2) {
        this.f26483b = f2;
        a(this.f26482a, f2);
    }

    public void a(int i2, int i3) {
        super.a(i2, i3);
        a(this.f26484c, 1.0f / ((float) i2));
        a(this.f26485d, 1.0f / ((float) i3));
    }

    public void d() {
        super.d();
        this.f26482a = GLES20.glGetUniformLocation(j(), "sharpness");
        this.f26484c = GLES20.glGetUniformLocation(j(), "imageWidthFactor");
        this.f26485d = GLES20.glGetUniformLocation(j(), "imageHeightFactor");
    }

    public void e() {
        super.e();
        a(this.f26483b);
    }
}
