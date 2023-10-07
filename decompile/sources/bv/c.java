package bv;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import bl.e;
import com.bumptech.glide.load.engine.s;
import com.bumptech.glide.load.f;

public final class c implements e<Drawable, byte[]> {

    /* renamed from: a  reason: collision with root package name */
    private final e f6047a;

    /* renamed from: b  reason: collision with root package name */
    private final e<Bitmap, byte[]> f6048b;

    /* renamed from: c  reason: collision with root package name */
    private final e<bu.c, byte[]> f6049c;

    public c(e eVar, e<Bitmap, byte[]> eVar2, e<bu.c, byte[]> eVar3) {
        this.f6047a = eVar;
        this.f6048b = eVar2;
        this.f6049c = eVar3;
    }

    private static s<bu.c> a(s<Drawable> sVar) {
        return sVar;
    }

    public s<byte[]> a(s<Drawable> sVar, f fVar) {
        Drawable d2 = sVar.d();
        if (d2 instanceof BitmapDrawable) {
            return this.f6048b.a(com.bumptech.glide.load.resource.bitmap.e.a(((BitmapDrawable) d2).getBitmap(), this.f6047a), fVar);
        }
        if (d2 instanceof bu.c) {
            return this.f6049c.a(a(sVar), fVar);
        }
        return null;
    }
}
