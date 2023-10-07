package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.os.Parcelable;
import androidx.versionedparcelable.a;

public class IconCompatParcelizer {
    public static IconCompat read(a aVar) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f2959a = aVar.b(iconCompat.f2959a, 1);
        iconCompat.f2961c = aVar.b(iconCompat.f2961c, 2);
        iconCompat.f2962d = aVar.b(iconCompat.f2962d, 3);
        iconCompat.f2963e = aVar.b(iconCompat.f2963e, 4);
        iconCompat.f2964f = aVar.b(iconCompat.f2964f, 5);
        iconCompat.f2965g = (ColorStateList) aVar.b(iconCompat.f2965g, 6);
        iconCompat.f2967j = aVar.b(iconCompat.f2967j, 7);
        iconCompat.f2968k = aVar.b(iconCompat.f2968k, 8);
        iconCompat.f();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, a aVar) {
        aVar.a(true, true);
        iconCompat.a(aVar.a());
        if (-1 != iconCompat.f2959a) {
            aVar.a(iconCompat.f2959a, 1);
        }
        if (iconCompat.f2961c != null) {
            aVar.a(iconCompat.f2961c, 2);
        }
        if (iconCompat.f2962d != null) {
            aVar.a(iconCompat.f2962d, 3);
        }
        if (iconCompat.f2963e != 0) {
            aVar.a(iconCompat.f2963e, 4);
        }
        if (iconCompat.f2964f != 0) {
            aVar.a(iconCompat.f2964f, 5);
        }
        if (iconCompat.f2965g != null) {
            aVar.a((Parcelable) iconCompat.f2965g, 6);
        }
        if (iconCompat.f2967j != null) {
            aVar.a(iconCompat.f2967j, 7);
        }
        if (iconCompat.f2968k != null) {
            aVar.a(iconCompat.f2968k, 8);
        }
    }
}
