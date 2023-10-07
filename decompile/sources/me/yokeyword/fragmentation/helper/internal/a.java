package me.yokeyword.fragmentation.helper.internal;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.fragment.app.Fragment;
import me.yokeyword.fragmentation.R;
import me.yokeyword.fragmentation.anim.FragmentAnimator;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public Animation f31180a;

    /* renamed from: b  reason: collision with root package name */
    public Animation f31181b;

    /* renamed from: c  reason: collision with root package name */
    public Animation f31182c;

    /* renamed from: d  reason: collision with root package name */
    public Animation f31183d;

    /* renamed from: e  reason: collision with root package name */
    private Animation f31184e;

    /* renamed from: f  reason: collision with root package name */
    private Animation f31185f;

    /* renamed from: g  reason: collision with root package name */
    private Context f31186g;

    /* renamed from: h  reason: collision with root package name */
    private FragmentAnimator f31187h;

    public a(Context context, FragmentAnimator fragmentAnimator) {
        this.f31186g = context;
        a(fragmentAnimator);
    }

    private Animation c() {
        int i2;
        Context context;
        if (this.f31187h.b() == 0) {
            context = this.f31186g;
            i2 = R.anim.no_anim;
        } else {
            context = this.f31186g;
            i2 = this.f31187h.b();
        }
        this.f31180a = AnimationUtils.loadAnimation(context, i2);
        return this.f31180a;
    }

    private Animation d() {
        int i2;
        Context context;
        if (this.f31187h.c() == 0) {
            context = this.f31186g;
            i2 = R.anim.no_anim;
        } else {
            context = this.f31186g;
            i2 = this.f31187h.c();
        }
        this.f31181b = AnimationUtils.loadAnimation(context, i2);
        return this.f31181b;
    }

    private Animation e() {
        int i2;
        Context context;
        if (this.f31187h.d() == 0) {
            context = this.f31186g;
            i2 = R.anim.no_anim;
        } else {
            context = this.f31186g;
            i2 = this.f31187h.d();
        }
        this.f31182c = AnimationUtils.loadAnimation(context, i2);
        return this.f31182c;
    }

    private Animation f() {
        int i2;
        Context context;
        if (this.f31187h.e() == 0) {
            context = this.f31186g;
            i2 = R.anim.no_anim;
        } else {
            context = this.f31186g;
            i2 = this.f31187h.e();
        }
        this.f31183d = AnimationUtils.loadAnimation(context, i2);
        return this.f31183d;
    }

    public Animation a() {
        if (this.f31184e == null) {
            this.f31184e = AnimationUtils.loadAnimation(this.f31186g, R.anim.no_anim);
        }
        return this.f31184e;
    }

    public Animation a(Fragment fragment) {
        if ((fragment.getTag() == null || !fragment.getTag().startsWith("android:switcher:") || !fragment.getUserVisibleHint()) && (fragment.getParentFragment() == null || !fragment.getParentFragment().isRemoving() || fragment.isHidden())) {
            return null;
        }
        AnonymousClass2 r3 = new Animation() {
        };
        r3.setDuration(this.f31181b.getDuration());
        return r3;
    }

    public void a(FragmentAnimator fragmentAnimator) {
        this.f31187h = fragmentAnimator;
        c();
        d();
        e();
        f();
    }

    public Animation b() {
        if (this.f31185f == null) {
            this.f31185f = new Animation() {
            };
        }
        return this.f31185f;
    }
}
