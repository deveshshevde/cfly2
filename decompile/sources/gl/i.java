package gl;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

public class i {

    /* renamed from: a  reason: collision with root package name */
    private long f28550a = 0;

    /* renamed from: b  reason: collision with root package name */
    private long f28551b = 300;

    /* renamed from: c  reason: collision with root package name */
    private TimeInterpolator f28552c = null;

    /* renamed from: d  reason: collision with root package name */
    private int f28553d = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f28554e = 1;

    public i(long j2, long j3) {
        this.f28550a = j2;
        this.f28551b = j3;
    }

    public i(long j2, long j3, TimeInterpolator timeInterpolator) {
        this.f28550a = j2;
        this.f28551b = j3;
        this.f28552c = timeInterpolator;
    }

    static i a(ValueAnimator valueAnimator) {
        i iVar = new i(valueAnimator.getStartDelay(), valueAnimator.getDuration(), b(valueAnimator));
        iVar.f28553d = valueAnimator.getRepeatCount();
        iVar.f28554e = valueAnimator.getRepeatMode();
        return iVar;
    }

    private static TimeInterpolator b(ValueAnimator valueAnimator) {
        TimeInterpolator interpolator = valueAnimator.getInterpolator();
        return ((interpolator instanceof AccelerateDecelerateInterpolator) || interpolator == null) ? a.f28536b : interpolator instanceof AccelerateInterpolator ? a.f28537c : interpolator instanceof DecelerateInterpolator ? a.f28538d : interpolator;
    }

    public long a() {
        return this.f28550a;
    }

    public void a(Animator animator) {
        animator.setStartDelay(a());
        animator.setDuration(b());
        animator.setInterpolator(c());
        if (animator instanceof ValueAnimator) {
            ValueAnimator valueAnimator = (ValueAnimator) animator;
            valueAnimator.setRepeatCount(d());
            valueAnimator.setRepeatMode(e());
        }
    }

    public long b() {
        return this.f28551b;
    }

    public TimeInterpolator c() {
        TimeInterpolator timeInterpolator = this.f28552c;
        return timeInterpolator != null ? timeInterpolator : a.f28536b;
    }

    public int d() {
        return this.f28553d;
    }

    public int e() {
        return this.f28554e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        if (a() == iVar.a() && b() == iVar.b() && d() == iVar.d() && e() == iVar.e()) {
            return c().getClass().equals(iVar.c().getClass());
        }
        return false;
    }

    public int hashCode() {
        return (((((((((int) (a() ^ (a() >>> 32))) * 31) + ((int) (b() ^ (b() >>> 32)))) * 31) + c().getClass().hashCode()) * 31) + d()) * 31) + e();
    }

    public String toString() {
        return 10 + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " delay: " + a() + " duration: " + b() + " interpolator: " + c().getClass() + " repeatCount: " + d() + " repeatMode: " + e() + "}\n";
    }
}
