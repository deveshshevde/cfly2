package androidx.transition;

import android.view.ViewGroup;

public class q {

    /* renamed from: a  reason: collision with root package name */
    private ViewGroup f4858a;

    /* renamed from: b  reason: collision with root package name */
    private Runnable f4859b;

    public static q a(ViewGroup viewGroup) {
        return (q) viewGroup.getTag(R.id.transition_current_scene);
    }

    static void a(ViewGroup viewGroup, q qVar) {
        viewGroup.setTag(R.id.transition_current_scene, qVar);
    }

    public void a() {
        Runnable runnable;
        if (a(this.f4858a) == this && (runnable = this.f4859b) != null) {
            runnable.run();
        }
    }
}
