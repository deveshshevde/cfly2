package me.yokeyword.fragmentation;

import android.app.Activity;
import android.os.Bundle;
import android.view.animation.Animation;
import androidx.fragment.app.Fragment;
import me.yokeyword.fragmentation.anim.FragmentAnimator;

public class e extends Fragment implements c {

    /* renamed from: a  reason: collision with root package name */
    final f f31138a = new f(this);

    /* renamed from: b  reason: collision with root package name */
    protected SupportActivity f31139b;

    public void a(int i2, int i3, Bundle bundle) {
        this.f31138a.a(i2, i3, bundle);
    }

    public void a(Bundle bundle) {
        this.f31138a.d(bundle);
    }

    public void b(Bundle bundle) {
        this.f31138a.e(bundle);
    }

    public void h_() {
        this.f31138a.e();
    }

    public f i() {
        return this.f31138a;
    }

    public void i_() {
        this.f31138a.f();
    }

    public final boolean j() {
        return this.f31138a.g();
    }

    public FragmentAnimator k() {
        return this.f31138a.h();
    }

    public boolean l() {
        return this.f31138a.j();
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f31138a.c(bundle);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f31138a.a(activity);
        this.f31139b = (SupportActivity) this.f31138a.l();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f31138a.a(bundle);
    }

    public Animation onCreateAnimation(int i2, boolean z2, int i3) {
        return this.f31138a.a(i2, z2, i3);
    }

    public void onDestroy() {
        this.f31138a.d();
        super.onDestroy();
    }

    public void onDestroyView() {
        this.f31138a.c();
        super.onDestroyView();
    }

    public void onHiddenChanged(boolean z2) {
        super.onHiddenChanged(z2);
        this.f31138a.a(z2);
    }

    public void onPause() {
        super.onPause();
        this.f31138a.b();
    }

    public void onResume() {
        super.onResume();
        this.f31138a.a();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f31138a.b(bundle);
    }

    public void setUserVisibleHint(boolean z2) {
        super.setUserVisibleHint(z2);
        this.f31138a.b(z2);
    }
}
