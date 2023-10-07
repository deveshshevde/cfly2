package as;

import android.view.View;
import com.google.android.gms.analytics.ecommerce.Promotion;
import kotlin.jvm.internal.h;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final d f5563a = new d();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f5564b = true;

    /* renamed from: c  reason: collision with root package name */
    private static final Runnable f5565c = a.f5566a;

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public static final a f5566a = new a();

        a() {
        }

        public final void run() {
            d.f5564b = true;
        }
    }

    private d() {
    }

    public final boolean a(View view) {
        h.c(view, Promotion.ACTION_VIEW);
        if (!f5564b) {
            return false;
        }
        f5564b = false;
        view.post(f5565c);
        return true;
    }
}
