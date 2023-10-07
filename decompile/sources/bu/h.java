package bu;

import android.graphics.Bitmap;
import bj.a;
import bl.e;
import com.bumptech.glide.load.engine.s;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.g;

public final class h implements g<a, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final e f6036a;

    public h(e eVar) {
        this.f6036a = eVar;
    }

    public s<Bitmap> a(a aVar, int i2, int i3, f fVar) {
        return com.bumptech.glide.load.resource.bitmap.e.a(aVar.h(), this.f6036a);
    }

    public boolean a(a aVar, f fVar) {
        return true;
    }
}
