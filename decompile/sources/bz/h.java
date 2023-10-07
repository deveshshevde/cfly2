package bz;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import ca.b;
import com.bumptech.glide.request.e;

public final class h<Z> extends c<Z> {

    /* renamed from: a  reason: collision with root package name */
    private static final Handler f6143a = new Handler(Looper.getMainLooper(), new Handler.Callback() {
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((h) message.obj).b();
            return true;
        }
    });

    /* renamed from: b  reason: collision with root package name */
    private final com.bumptech.glide.h f6144b;

    private h(com.bumptech.glide.h hVar, int i2, int i3) {
        super(i2, i3);
        this.f6144b = hVar;
    }

    public static <Z> h<Z> a(com.bumptech.glide.h hVar, int i2, int i3) {
        return new h<>(hVar, i2, i3);
    }

    public void a(Drawable drawable) {
    }

    public void a(Z z2, b<? super Z> bVar) {
        e a2 = a();
        if (a2 != null && a2.e()) {
            f6143a.obtainMessage(1, this).sendToTarget();
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.f6144b.a((j<?>) this);
    }
}
