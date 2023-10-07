package t;

import android.view.View;
import android.view.ViewTreeObserver;
import java.util.Objects;

public final class x implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a  reason: collision with root package name */
    private final View f34520a;

    /* renamed from: b  reason: collision with root package name */
    private ViewTreeObserver f34521b;

    /* renamed from: c  reason: collision with root package name */
    private final Runnable f34522c;

    private x(View view, Runnable runnable) {
        this.f34520a = view;
        this.f34521b = view.getViewTreeObserver();
        this.f34522c = runnable;
    }

    public static x a(View view, Runnable runnable) {
        Objects.requireNonNull(view, "view == null");
        Objects.requireNonNull(runnable, "runnable == null");
        x xVar = new x(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(xVar);
        view.addOnAttachStateChangeListener(xVar);
        return xVar;
    }

    public void a() {
        (this.f34521b.isAlive() ? this.f34521b : this.f34520a.getViewTreeObserver()).removeOnPreDrawListener(this);
        this.f34520a.removeOnAttachStateChangeListener(this);
    }

    public boolean onPreDraw() {
        a();
        this.f34522c.run();
        return true;
    }

    public void onViewAttachedToWindow(View view) {
        this.f34521b = view.getViewTreeObserver();
    }

    public void onViewDetachedFromWindow(View view) {
        a();
    }
}
