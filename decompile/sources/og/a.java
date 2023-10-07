package og;

import android.graphics.Bitmap;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.b;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static ThreadLocal<int[]> f31728a = new ThreadLocal<>();

    public static b a(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        b a2 = b.a(bitmap.getWidth(), bitmap.getHeight(), ColorSpace.RGB);
        a(bitmap, a2);
        return a2;
    }

    public static void a(Bitmap bitmap, b bVar) {
        int[] a2 = bVar.a(0);
        int[] iArr = new int[(bitmap.getWidth() * bitmap.getHeight())];
        bitmap.getPixels(iArr, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < bitmap.getHeight(); i4++) {
            int i5 = 0;
            while (i5 < bitmap.getWidth()) {
                int i6 = iArr[i2];
                a2[i3] = (i6 >> 16) & 255;
                a2[i3 + 1] = (i6 >> 8) & 255;
                a2[i3 + 2] = i6 & 255;
                i5++;
                i2++;
                i3 += 3;
            }
        }
    }
}
