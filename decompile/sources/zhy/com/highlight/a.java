package zhy.com.highlight;

import android.graphics.Bitmap;
import android.graphics.RectF;
import android.os.Build;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.util.List;

public class a implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a  reason: collision with root package name */
    private View f34757a;

    /* renamed from: b  reason: collision with root package name */
    private List<d> f34758b;

    /* renamed from: c  reason: collision with root package name */
    private Message f34759c;

    /* renamed from: zhy.com.highlight.a$a  reason: collision with other inner class name */
    public interface C0268a {
        void a(Bitmap bitmap, d dVar);
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public float f34760a;

        /* renamed from: b  reason: collision with root package name */
        public float f34761b;

        /* renamed from: c  reason: collision with root package name */
        public float f34762c;

        /* renamed from: d  reason: collision with root package name */
        public float f34763d;
    }

    public interface c {
        void a(float f2, float f3, RectF rectF, b bVar);
    }

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public int f34764a = -1;

        /* renamed from: b  reason: collision with root package name */
        public RectF f34765b;

        /* renamed from: c  reason: collision with root package name */
        public b f34766c;

        /* renamed from: d  reason: collision with root package name */
        public View f34767d;

        /* renamed from: e  reason: collision with root package name */
        public c f34768e;

        /* renamed from: f  reason: collision with root package name */
        public C0268a f34769f;
    }

    private void b() {
        Message message = this.f34759c;
        if (message != null) {
            Message.obtain(message).sendToTarget();
        }
    }

    private void c() {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f34757a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    public void a() {
        ViewGroup viewGroup = (ViewGroup) this.f34757a;
        for (d next : this.f34758b) {
            RectF rectF = new RectF(ov.a.a(viewGroup, next.f34767d));
            next.f34765b = rectF;
            next.f34768e.a(((float) viewGroup.getWidth()) - rectF.right, ((float) viewGroup.getHeight()) - rectF.bottom, rectF, next.f34766c);
        }
    }

    public void onGlobalLayout() {
        c();
        b();
    }
}
