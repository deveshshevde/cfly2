package cu;

import android.opengl.GLES20;

public class f extends a {

    /* renamed from: a  reason: collision with root package name */
    private int f26478a;

    /* renamed from: b  reason: collision with root package name */
    private float f26479b;

    public f() {
        this(0.0f);
    }

    public f(float f2) {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "precision highp float;varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\nuniform mediump float hueAdjust;\nconst highp  vec4  kRGBToYPrime = vec4 (0.299, 0.587, 0.114, 0.0);\nconst highp  vec4  kRGBToI     = vec4 (0.595716, -0.274453, -0.321263, 0.0);\nconst highp  vec4  kRGBToQ     = vec4 (0.211456, -0.522591, 0.31135, 0.0);\n \nconst highp  vec4  kYIQToR   = vec4 (1.0, 0.9563, 0.6210, 0.0);\nconst highp  vec4  kYIQToG   = vec4 (1.0, -0.2721, -0.6474, 0.0);\nconst highp  vec4  kYIQToB   = vec4 (1.0, -1.1070, 1.7046, 0.0);\n \nvoid main () {\n    // Sample the input pixel\n    highp vec4 color   = texture2D(inputImageTexture, textureCoordinate);\n     \n    // Convert to YIQ\n    highp float   YPrime  = dot (color, kRGBToYPrime);\n    highp float   I      = dot (color, kRGBToI);\n    highp float   Q      = dot (color, kRGBToQ);\n     \n    // Calculate the hue and chroma\n    highp float   hue     = atan (Q, I);\n    highp float   chroma  = sqrt (I * I + Q * Q);\n     \n    // Make the user's adjustments\n    hue += (-hueAdjust); //why negative rotation?\n     \n    // Convert back to YIQ\n    Q = chroma * sin (hue);\n    I = chroma * cos (hue);\n     \n    // Convert back to RGB\n    highp vec4  yIQ = vec4 (YPrime, I, Q, 0.0);\n    color.r = dot (yIQ, kYIQToR);\n    color.g = dot (yIQ, kYIQToG);\n    color.b = dot (yIQ, kYIQToB);\n     \n    // Save the result\n    gl_FragColor = color;\n }");
        this.f26479b = f2;
    }

    public void a(float f2) {
        this.f26479b = f2;
        a(this.f26478a, f2);
    }

    public void d() {
        super.d();
        this.f26478a = GLES20.glGetUniformLocation(j(), "hueAdjust");
    }

    public void e() {
        super.e();
        a(this.f26479b);
    }
}
