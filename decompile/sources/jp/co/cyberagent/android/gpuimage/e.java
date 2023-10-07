package jp.co.cyberagent.android.gpuimage;

import android.opengl.GLES20;
import android.opengl.Matrix;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class e extends a {

    /* renamed from: g  reason: collision with root package name */
    private int f29715g;

    /* renamed from: h  reason: collision with root package name */
    private int f29716h;

    /* renamed from: i  reason: collision with root package name */
    private float[] f29717i;

    /* renamed from: j  reason: collision with root package name */
    private float[] f29718j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f29719k;

    public e() {
        super("attribute vec4 position;\n attribute vec4 inputTextureCoordinate;\n \n uniform mat4 transformMatrix;\n uniform mat4 orthographicMatrix;\n \n varying vec2 textureCoordinate;\n \n void main()\n {\n     gl_Position = transformMatrix * vec4(position.xyz, 1.0) * orthographicMatrix;\n     textureCoordinate = inputTextureCoordinate.xy;\n }", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        float[] fArr = new float[16];
        this.f29717i = fArr;
        Matrix.orthoM(fArr, 0, -1.0f, 1.0f, -1.0f, 1.0f, -1.0f, 1.0f);
        float[] fArr2 = new float[16];
        this.f29718j = fArr2;
        Matrix.setIdentityM(fArr2, 0);
    }

    public void a(int i2, int i3) {
        super.a(i2, i3);
        if (!this.f29719k) {
            float f2 = (float) i3;
            float f3 = (float) i2;
            Matrix.orthoM(this.f29717i, 0, -1.0f, 1.0f, (-1.0f * f2) / f3, (f2 * 1.0f) / f3, -1.0f, 1.0f);
            a(this.f29716h, this.f29717i);
        }
    }

    public void a(int i2, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (!this.f29719k) {
            float[] fArr = new float[8];
            floatBuffer.position(0);
            floatBuffer.get(fArr);
            float j2 = ((float) j()) / ((float) i());
            fArr[1] = fArr[1] * j2;
            fArr[3] = fArr[3] * j2;
            fArr[5] = fArr[5] * j2;
            fArr[7] = fArr[7] * j2;
            floatBuffer = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
            floatBuffer.put(fArr).position(0);
        }
        super.a(i2, floatBuffer, floatBuffer2);
    }

    public void a(float[] fArr) {
        this.f29718j = fArr;
        a(this.f29715g, fArr);
    }

    public void b() {
        super.b();
        this.f29715g = GLES20.glGetUniformLocation(k(), "transformMatrix");
        this.f29716h = GLES20.glGetUniformLocation(k(), "orthographicMatrix");
        a(this.f29715g, this.f29718j);
        a(this.f29716h, this.f29717i);
    }

    public void c() {
        super.c();
    }
}
