package ge;

import android.opengl.Matrix;
import com.google.android.exoplayer2.util.z;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final float[] f28471a = new float[16];

    /* renamed from: b  reason: collision with root package name */
    private final float[] f28472b = new float[16];

    /* renamed from: c  reason: collision with root package name */
    private final z<float[]> f28473c = new z<>();

    /* renamed from: d  reason: collision with root package name */
    private boolean f28474d;

    public static void a(float[] fArr, float[] fArr2) {
        Matrix.setIdentityM(fArr, 0);
        float sqrt = (float) Math.sqrt((double) ((fArr2[10] * fArr2[10]) + (fArr2[8] * fArr2[8])));
        fArr[0] = fArr2[10] / sqrt;
        fArr[2] = fArr2[8] / sqrt;
        fArr[8] = (-fArr2[8]) / sqrt;
        fArr[10] = fArr2[10] / sqrt;
    }

    private static void b(float[] fArr, float[] fArr2) {
        float f2 = fArr2[0];
        float f3 = -fArr2[1];
        float f4 = -fArr2[2];
        float length = Matrix.length(f2, f3, f4);
        if (length != 0.0f) {
            Matrix.setRotateM(fArr, 0, (float) Math.toDegrees((double) length), f2 / length, f3 / length, f4 / length);
            return;
        }
        Matrix.setIdentityM(fArr, 0);
    }

    public void a() {
        this.f28473c.a();
        this.f28474d = false;
    }

    public void a(long j2, float[] fArr) {
        this.f28473c.a(j2, fArr);
    }

    public boolean a(float[] fArr, long j2) {
        float[] a2 = this.f28473c.a(j2);
        if (a2 == null) {
            return false;
        }
        b(this.f28472b, a2);
        if (!this.f28474d) {
            a(this.f28471a, this.f28472b);
            this.f28474d = true;
        }
        Matrix.multiplyMM(fArr, 0, this.f28471a, 0, this.f28472b, 0);
        return true;
    }
}
