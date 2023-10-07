package ct;

import android.opengl.GLES20;
import com.ctoo.mediaedit.filter.a;
import com.ctoo.mediaedit.filter.gpu.b;

public class v extends d {

    /* renamed from: b  reason: collision with root package name */
    protected String f26427b;

    /* renamed from: c  reason: collision with root package name */
    public int f26428c;

    /* renamed from: d  reason: collision with root package name */
    public int f26429d = -1;

    public v(String str) {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2; // lookup texture\n \n void main()\n {\n     lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     \n     mediump float blueColor = textureColor.b * 63.0;\n     \n     mediump vec2 quad1;\n     quad1.y = floor(floor(blueColor) / 8.0);\n     quad1.x = floor(blueColor) - (quad1.y * 8.0);\n     \n     mediump vec2 quad2;\n     quad2.y = floor(ceil(blueColor) / 8.0);\n     quad2.x = ceil(blueColor) - (quad2.y * 8.0);\n     \n     highp vec2 texPos1;\n     texPos1.x = (quad1.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.r);\n     texPos1.y = (quad1.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.g);\n     \n     highp vec2 texPos2;\n     texPos2.x = (quad2.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.r);\n     texPos2.y = (quad2.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.g);\n     \n     lowp vec4 newColor1 = texture2D(inputImageTexture2, texPos1);\n     lowp vec4 newColor2 = texture2D(inputImageTexture2, texPos2);\n     \n     lowp vec4 newColor = mix(newColor1, newColor2, fract(blueColor));\n     gl_FragColor = vec4(newColor.rgb, textureColor.w);\n }");
        this.f26427b = str;
    }

    public void a() {
        super.a();
        GLES20.glDeleteTextures(1, new int[]{this.f26429d}, 0);
        this.f26429d = -1;
    }

    /* access modifiers changed from: protected */
    public void b() {
        if (this.f26429d != -1) {
            GLES20.glActiveTexture(33987);
            GLES20.glBindTexture(3553, 0);
            GLES20.glActiveTexture(33984);
        }
    }

    /* access modifiers changed from: protected */
    public void c() {
        if (this.f26429d != -1) {
            GLES20.glActiveTexture(33987);
            GLES20.glBindTexture(3553, this.f26429d);
            GLES20.glUniform1i(this.f26428c, 3);
        }
    }

    public void d() {
        super.d();
        this.f26428c = GLES20.glGetUniformLocation(j(), "inputImageTexture2");
    }

    public void e() {
        super.e();
        a((Runnable) new Runnable() {
            public void run() {
                v.this.f26429d = a.a(b.f10869a, v.this.f26427b, -1);
            }
        });
    }
}
