package androidx.activity.result;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.k;
import androidx.lifecycle.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    private Random f468a = new Random();

    /* renamed from: b  reason: collision with root package name */
    ArrayList<String> f469b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    final transient Map<String, a<?>> f470c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    final Map<String, Object> f471d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    final Bundle f472e = new Bundle();

    /* renamed from: f  reason: collision with root package name */
    private final Map<Integer, String> f473f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    private final Map<String, Integer> f474g = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    private final Map<String, b> f475h = new HashMap();

    private static class a<O> {

        /* renamed from: a  reason: collision with root package name */
        final a<O> f484a;

        /* renamed from: b  reason: collision with root package name */
        final b.a<?, O> f485b;

        a(a<O> aVar, b.a<?, O> aVar2) {
            this.f484a = aVar;
            this.f485b = aVar2;
        }
    }

    private static class b {

        /* renamed from: a  reason: collision with root package name */
        final Lifecycle f486a;

        /* renamed from: b  reason: collision with root package name */
        private final ArrayList<k> f487b = new ArrayList<>();

        b(Lifecycle lifecycle) {
            this.f486a = lifecycle;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            Iterator<k> it2 = this.f487b.iterator();
            while (it2.hasNext()) {
                this.f486a.b(it2.next());
            }
            this.f487b.clear();
        }

        /* access modifiers changed from: package-private */
        public void a(k kVar) {
            this.f486a.a(kVar);
            this.f487b.add(kVar);
        }
    }

    private int a() {
        int nextInt = this.f468a.nextInt(2147418112);
        while (true) {
            int i2 = nextInt + 65536;
            if (!this.f473f.containsKey(Integer.valueOf(i2))) {
                return i2;
            }
            nextInt = this.f468a.nextInt(2147418112);
        }
    }

    private void a(int i2, String str) {
        this.f473f.put(Integer.valueOf(i2), str);
        this.f474g.put(str, Integer.valueOf(i2));
    }

    private <O> void a(String str, int i2, Intent intent, a<O> aVar) {
        if (aVar == null || aVar.f484a == null) {
            this.f471d.remove(str);
            this.f472e.putParcelable(str, new ActivityResult(i2, intent));
            return;
        }
        aVar.f484a.a(aVar.f485b.a(i2, intent));
    }

    private int b(String str) {
        Integer num = this.f474g.get(str);
        if (num != null) {
            return num.intValue();
        }
        int a2 = a();
        a(a2, str);
        return a2;
    }

    public final <I, O> b<I> a(final String str, n nVar, final b.a<I, O> aVar, a<O> aVar2) {
        Lifecycle lifecycle = nVar.getLifecycle();
        if (!lifecycle.a().a(Lifecycle.State.STARTED)) {
            final int b2 = b(str);
            b bVar = this.f475h.get(str);
            if (bVar == null) {
                bVar = new b(lifecycle);
            }
            bVar.a(new ActivityResultRegistry$1(this, str, aVar2, aVar));
            this.f475h.put(str, bVar);
            return new b<I>() {
                public void a() {
                    c.this.a(str);
                }

                public void a(I i2, androidx.core.app.b bVar) {
                    c.this.f469b.add(str);
                    c.this.a(b2, aVar, i2, bVar);
                }
            };
        }
        throw new IllegalStateException("LifecycleOwner " + nVar + " is attempting to register while current state is " + lifecycle.a() + ". LifecycleOwners must call register before they are STARTED.");
    }

    public final <I, O> b<I> a(final String str, final b.a<I, O> aVar, a<O> aVar2) {
        final int b2 = b(str);
        this.f470c.put(str, new a(aVar2, aVar));
        if (this.f471d.containsKey(str)) {
            Object obj = this.f471d.get(str);
            this.f471d.remove(str);
            aVar2.a(obj);
        }
        ActivityResult activityResult = (ActivityResult) this.f472e.getParcelable(str);
        if (activityResult != null) {
            this.f472e.remove(str);
            aVar2.a(aVar.a(activityResult.a(), activityResult.b()));
        }
        return new b<I>() {
            public void a() {
                c.this.a(str);
            }

            public void a(I i2, androidx.core.app.b bVar) {
                c.this.f469b.add(str);
                c.this.a(b2, aVar, i2, bVar);
            }
        };
    }

    public abstract <I, O> void a(int i2, b.a<I, O> aVar, I i3, androidx.core.app.b bVar);

    public final void a(Bundle bundle) {
        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList(this.f473f.keySet()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList(this.f473f.values()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList(this.f469b));
        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle) this.f472e.clone());
        bundle.putSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT", this.f468a);
    }

    /* access modifiers changed from: package-private */
    public final void a(String str) {
        Integer remove;
        if (!this.f469b.contains(str) && (remove = this.f474g.remove(str)) != null) {
            this.f473f.remove(remove);
        }
        this.f470c.remove(str);
        if (this.f471d.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.f471d.get(str));
            this.f471d.remove(str);
        }
        if (this.f472e.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.f472e.getParcelable(str));
            this.f472e.remove(str);
        }
        b bVar = this.f475h.get(str);
        if (bVar != null) {
            bVar.a();
            this.f475h.remove(str);
        }
    }

    public final boolean a(int i2, int i3, Intent intent) {
        String str = this.f473f.get(Integer.valueOf(i2));
        if (str == null) {
            return false;
        }
        this.f469b.remove(str);
        a(str, i3, intent, this.f470c.get(str));
        return true;
    }

    public final <O> boolean a(int i2, O o2) {
        String str = this.f473f.get(Integer.valueOf(i2));
        if (str == null) {
            return false;
        }
        this.f469b.remove(str);
        a aVar = this.f470c.get(str);
        if (aVar == null || aVar.f484a == null) {
            this.f472e.remove(str);
            this.f471d.put(str, o2);
            return true;
        }
        aVar.f484a.a(o2);
        return true;
    }

    public final void b(Bundle bundle) {
        if (bundle != null) {
            ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
            ArrayList<String> stringArrayList = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
            if (stringArrayList != null && integerArrayList != null) {
                int size = stringArrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    a(integerArrayList.get(i2).intValue(), stringArrayList.get(i2));
                }
                this.f469b = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
                this.f468a = (Random) bundle.getSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT");
                this.f472e.putAll(bundle.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT"));
            }
        }
    }
}
