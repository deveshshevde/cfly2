package bv;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import cc.k;
import com.bumptech.glide.load.engine.s;
import com.bumptech.glide.load.f;

public class b implements e<Bitmap, BitmapDrawable> {

    /* renamed from: a  reason: collision with root package name */
    private final Resources f6046a;

    public b(Resources resources) {
        this.f6046a = (Resources) k.a(resources);
    }

    public s<BitmapDrawable> a(s<Bitmap> sVar, f fVar) {
        return com.bumptech.glide.load.resource.bitmap.s.a(this.f6046a, sVar);
    }
}
