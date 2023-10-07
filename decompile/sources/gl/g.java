package gl;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;

public class g implements TypeEvaluator<Matrix> {

    /* renamed from: a  reason: collision with root package name */
    private final float[] f28545a = new float[9];

    /* renamed from: b  reason: collision with root package name */
    private final float[] f28546b = new float[9];

    /* renamed from: c  reason: collision with root package name */
    private final Matrix f28547c = new Matrix();

    /* renamed from: a */
    public Matrix evaluate(float f2, Matrix matrix, Matrix matrix2) {
        matrix.getValues(this.f28545a);
        matrix2.getValues(this.f28546b);
        for (int i2 = 0; i2 < 9; i2++) {
            float[] fArr = this.f28546b;
            float f3 = fArr[i2];
            float[] fArr2 = this.f28545a;
            fArr[i2] = fArr2[i2] + ((f3 - fArr2[i2]) * f2);
        }
        this.f28547c.setValues(this.f28546b);
        return this.f28547c;
    }
}
