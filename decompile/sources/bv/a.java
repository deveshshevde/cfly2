package bv;

import android.graphics.Bitmap;
import br.b;
import com.bumptech.glide.load.engine.s;
import com.bumptech.glide.load.f;
import java.io.ByteArrayOutputStream;

public class a implements e<Bitmap, byte[]> {

    /* renamed from: a  reason: collision with root package name */
    private final Bitmap.CompressFormat f6044a;

    /* renamed from: b  reason: collision with root package name */
    private final int f6045b;

    public a() {
        this(Bitmap.CompressFormat.JPEG, 100);
    }

    public a(Bitmap.CompressFormat compressFormat, int i2) {
        this.f6044a = compressFormat;
        this.f6045b = i2;
    }

    public s<byte[]> a(s<Bitmap> sVar, f fVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        sVar.d().compress(this.f6044a, this.f6045b, byteArrayOutputStream);
        sVar.f();
        return new b(byteArrayOutputStream.toByteArray());
    }
}
