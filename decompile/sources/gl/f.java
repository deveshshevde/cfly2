package gl;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;

public class f extends Property<ImageView, Matrix> {

    /* renamed from: a  reason: collision with root package name */
    private final Matrix f28544a = new Matrix();

    public f() {
        super(Matrix.class, "imageMatrixProperty");
    }

    /* renamed from: a */
    public Matrix get(ImageView imageView) {
        this.f28544a.set(imageView.getImageMatrix());
        return this.f28544a;
    }

    /* renamed from: a */
    public void set(ImageView imageView, Matrix matrix) {
        imageView.setImageMatrix(matrix);
    }
}
