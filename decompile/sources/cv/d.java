package cv;

import android.opengl.GLES20;
import cu.e;

public class d extends e {

    /* renamed from: a  reason: collision with root package name */
    private float f26486a;

    /* renamed from: b  reason: collision with root package name */
    private int f26487b;

    public d(String str, String str2) {
        super(str, str2);
    }

    public void a(float f2) {
        this.f26486a = f2;
        a(this.f26487b, f2);
    }

    public void d() {
        super.d();
        this.f26487b = GLES20.glGetUniformLocation(j(), "progress");
    }

    public void e() {
        super.e();
        a(0.0f);
    }
}
