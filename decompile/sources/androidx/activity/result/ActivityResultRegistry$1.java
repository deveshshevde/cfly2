package androidx.activity.result;

import androidx.activity.result.c;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.k;
import androidx.lifecycle.n;
import b.a;

class ActivityResultRegistry$1 implements k {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f456a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ a f457b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ a f458c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ c f459d;

    ActivityResultRegistry$1(c cVar, String str, a aVar, a aVar2) {
        this.f459d = cVar;
        this.f456a = str;
        this.f457b = aVar;
        this.f458c = aVar2;
    }

    public void a(n nVar, Lifecycle.Event event) {
        if (Lifecycle.Event.ON_START.equals(event)) {
            this.f459d.f470c.put(this.f456a, new c.a(this.f457b, this.f458c));
            if (this.f459d.f471d.containsKey(this.f456a)) {
                Object obj = this.f459d.f471d.get(this.f456a);
                this.f459d.f471d.remove(this.f456a);
                this.f457b.a(obj);
            }
            ActivityResult activityResult = (ActivityResult) this.f459d.f472e.getParcelable(this.f456a);
            if (activityResult != null) {
                this.f459d.f472e.remove(this.f456a);
                this.f457b.a(this.f458c.a(activityResult.a(), activityResult.b()));
            }
        } else if (Lifecycle.Event.ON_STOP.equals(event)) {
            this.f459d.f470c.remove(this.f456a);
        } else if (Lifecycle.Event.ON_DESTROY.equals(event)) {
            this.f459d.a(this.f456a);
        }
    }
}
