package bu;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.c;
import com.bumptech.glide.load.engine.s;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.resource.bitmap.e;
import java.security.MessageDigest;

public class f implements i<c> {

    /* renamed from: b  reason: collision with root package name */
    private final i<Bitmap> f6011b;

    /* JADX WARNING: type inference failed for: r1v0, types: [java.lang.Object, com.bumptech.glide.load.i<android.graphics.Bitmap>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public f(com.bumptech.glide.load.i<android.graphics.Bitmap> r1) {
        /*
            r0 = this;
            r0.<init>()
            java.lang.Object r1 = cc.k.a(r1)
            com.bumptech.glide.load.i r1 = (com.bumptech.glide.load.i) r1
            r0.f6011b = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bu.f.<init>(com.bumptech.glide.load.i):void");
    }

    public s<c> a(Context context, s<c> sVar, int i2, int i3) {
        c d2 = sVar.d();
        e eVar = new e(d2.b(), c.a(context).a());
        s<Bitmap> a2 = this.f6011b.a(context, eVar, i2, i3);
        if (!eVar.equals(a2)) {
            eVar.f();
        }
        d2.a(this.f6011b, a2.d());
        return sVar;
    }

    public void a(MessageDigest messageDigest) {
        this.f6011b.a(messageDigest);
    }

    public boolean equals(Object obj) {
        if (obj instanceof f) {
            return this.f6011b.equals(((f) obj).f6011b);
        }
        return false;
    }

    public int hashCode() {
        return this.f6011b.hashCode();
    }
}
