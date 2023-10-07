package ct;

import android.opengl.GLES20;
import cu.e;

public class d extends e {

    /* renamed from: a  reason: collision with root package name */
    public int f26370a;

    public d(String str, String str2) {
        super(str, str2);
    }

    public void d() {
        super.d();
        this.f26370a = GLES20.glGetUniformLocation(j(), "strength");
    }
}
