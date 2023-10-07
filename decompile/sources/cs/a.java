package cs;

import android.content.res.Resources;
import android.opengl.GLES20;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Arrays;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f26248a = true;

    /* renamed from: b  reason: collision with root package name */
    public static final float[] f26249b = n();

    /* renamed from: c  reason: collision with root package name */
    protected int f26250c;

    /* renamed from: d  reason: collision with root package name */
    protected int f26251d;

    /* renamed from: e  reason: collision with root package name */
    protected int f26252e;

    /* renamed from: f  reason: collision with root package name */
    protected int f26253f;

    /* renamed from: g  reason: collision with root package name */
    protected int f26254g;

    /* renamed from: h  reason: collision with root package name */
    protected Resources f26255h;

    /* renamed from: i  reason: collision with root package name */
    protected FloatBuffer f26256i;

    /* renamed from: j  reason: collision with root package name */
    protected FloatBuffer f26257j;

    /* renamed from: k  reason: collision with root package name */
    protected int f26258k = 0;

    /* renamed from: l  reason: collision with root package name */
    private float[] f26259l = Arrays.copyOf(f26249b, 16);

    /* renamed from: m  reason: collision with root package name */
    private int f26260m = 0;

    /* renamed from: n  reason: collision with root package name */
    private int f26261n = 0;

    /* renamed from: o  reason: collision with root package name */
    private float[] f26262o = {-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f};

    /* renamed from: p  reason: collision with root package name */
    private float[] f26263p = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};

    public a(Resources resources) {
        this.f26255h = resources;
        h();
    }

    public static int a(int i2, String str) {
        int glCreateShader = GLES20.glCreateShader(i2);
        if (glCreateShader == 0) {
            return glCreateShader;
        }
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return glCreateShader;
        }
        a(1, (Object) "Could not compile shader:" + i2);
        a(1, (Object) "GLES20 Error:" + GLES20.glGetShaderInfoLog(glCreateShader));
        GLES20.glDeleteShader(glCreateShader);
        return 0;
    }

    public static void a(int i2, Object obj) {
        if (f26248a && i2 != 0) {
            Log.e("Filter", "glError:" + i2 + "---" + obj);
        }
    }

    public static int b(String str, String str2) {
        int a2;
        int a3 = a(35633, str);
        if (a3 == 0 || (a2 = a(35632, str2)) == 0) {
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        if (glCreateProgram != 0) {
            GLES20.glAttachShader(glCreateProgram, a3);
            GLES20.glAttachShader(glCreateProgram, a2);
            GLES20.glLinkProgram(glCreateProgram);
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
            if (iArr[0] != 1) {
                a(1, (Object) "Could not link program:" + GLES20.glGetProgramInfoLog(glCreateProgram));
                GLES20.glDeleteProgram(glCreateProgram);
                return 0;
            }
        }
        return glCreateProgram;
    }

    public static float[] n() {
        return new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    }

    public final void a() {
        g();
    }

    public final void a(int i2) {
        this.f26261n = i2;
    }

    public final void a(int i2, int i3) {
        b(i2, i3);
    }

    /* access modifiers changed from: protected */
    public final void a(String str, String str2) {
        int b2 = b(str, str2);
        this.f26250c = b2;
        this.f26251d = GLES20.glGetAttribLocation(b2, "vPosition");
        this.f26252e = GLES20.glGetAttribLocation(this.f26250c, "vCoord");
        this.f26253f = GLES20.glGetUniformLocation(this.f26250c, "vMatrix");
        this.f26254g = GLES20.glGetUniformLocation(this.f26250c, "vTexture");
    }

    public final void a(float[] fArr) {
        this.f26259l = fArr;
    }

    public void b() {
        k();
        i();
        l();
        m();
        j();
    }

    /* access modifiers changed from: protected */
    public abstract void b(int i2, int i3);

    public float[] c() {
        return this.f26259l;
    }

    public final int d() {
        return this.f26260m;
    }

    public final int e() {
        return this.f26261n;
    }

    public int f() {
        return -1;
    }

    /* access modifiers changed from: protected */
    public abstract void g();

    /* access modifiers changed from: protected */
    public void h() {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(32);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        this.f26256i = asFloatBuffer;
        asFloatBuffer.put(this.f26262o);
        this.f26256i.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(32);
        allocateDirect2.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer2 = allocateDirect2.asFloatBuffer();
        this.f26257j = asFloatBuffer2;
        asFloatBuffer2.put(this.f26263p);
        this.f26257j.position(0);
    }

    /* access modifiers changed from: protected */
    public void i() {
        GLES20.glUseProgram(this.f26250c);
    }

    /* access modifiers changed from: protected */
    public void j() {
        GLES20.glEnableVertexAttribArray(this.f26251d);
        GLES20.glVertexAttribPointer(this.f26251d, 2, 5126, false, 0, this.f26256i);
        GLES20.glEnableVertexAttribArray(this.f26252e);
        GLES20.glVertexAttribPointer(this.f26252e, 2, 5126, false, 0, this.f26257j);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glDisableVertexAttribArray(this.f26251d);
        GLES20.glDisableVertexAttribArray(this.f26252e);
    }

    /* access modifiers changed from: protected */
    public void k() {
        GLES20.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        GLES20.glClear(16640);
    }

    /* access modifiers changed from: protected */
    public void l() {
        GLES20.glUniformMatrix4fv(this.f26253f, 1, false, this.f26259l, 0);
    }

    /* access modifiers changed from: protected */
    public void m() {
        GLES20.glActiveTexture(this.f26260m + 33984);
        GLES20.glBindTexture(3553, e());
        GLES20.glUniform1i(this.f26254g, this.f26260m);
    }
}
