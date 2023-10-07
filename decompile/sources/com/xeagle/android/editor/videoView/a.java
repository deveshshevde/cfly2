package com.xeagle.android.editor.videoView;

import android.opengl.GLES20;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.HashMap;
import java.util.LinkedList;

public class a {

    /* renamed from: b  reason: collision with root package name */
    private static final String f22851b = "a";

    /* renamed from: a  reason: collision with root package name */
    protected float[] f22852a;

    /* renamed from: c  reason: collision with root package name */
    private final float[] f22853c;

    /* renamed from: d  reason: collision with root package name */
    private FloatBuffer f22854d;

    /* renamed from: e  reason: collision with root package name */
    private String f22855e;

    /* renamed from: f  reason: collision with root package name */
    private String f22856f;

    /* renamed from: g  reason: collision with root package name */
    private int f22857g;

    /* renamed from: h  reason: collision with root package name */
    private int f22858h;

    /* renamed from: i  reason: collision with root package name */
    private final HashMap<String, Integer> f22859i;

    /* renamed from: j  reason: collision with root package name */
    private final LinkedList<Runnable> f22860j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f22861k;

    public a() {
        this("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n");
    }

    public a(String str, String str2) {
        float[] fArr = {-1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
        this.f22853c = fArr;
        this.f22858h = -12345;
        this.f22852a = new float[]{0.0f, 0.0f, 0.0f, 1.0f};
        this.f22859i = new HashMap<>();
        this.f22861k = false;
        this.f22855e = str;
        this.f22856f = str2;
        this.f22860j = new LinkedList<>();
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f22854d = asFloatBuffer;
        asFloatBuffer.put(fArr).position(0);
    }

    public void a() {
    }

    public String b() {
        return this.f22855e;
    }

    public String c() {
        return this.f22856f;
    }

    public final void d() {
        GLES20.glDeleteProgram(this.f22857g);
        e();
    }

    public void e() {
    }
}
