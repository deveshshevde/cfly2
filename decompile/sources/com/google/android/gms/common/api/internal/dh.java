package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.internal.common.zzi;
import j.a;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

public final class dh extends Fragment implements i {

    /* renamed from: a  reason: collision with root package name */
    private static final WeakHashMap<Activity, WeakReference<dh>> f17598a = new WeakHashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, LifecycleCallback> f17599b = Collections.synchronizedMap(new a());
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public int f17600c = 0;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Bundle f17601d;

    public static dh a(Activity activity) {
        dh dhVar;
        WeakHashMap<Activity, WeakReference<dh>> weakHashMap = f17598a;
        WeakReference weakReference = weakHashMap.get(activity);
        if (weakReference != null && (dhVar = (dh) weakReference.get()) != null) {
            return dhVar;
        }
        try {
            dh dhVar2 = (dh) activity.getFragmentManager().findFragmentByTag("LifecycleFragmentImpl");
            if (dhVar2 == null || dhVar2.isRemoving()) {
                dhVar2 = new dh();
                activity.getFragmentManager().beginTransaction().add(dhVar2, "LifecycleFragmentImpl").commitAllowingStateLoss();
            }
            weakHashMap.put(activity, new WeakReference(dhVar2));
            return dhVar2;
        } catch (ClassCastException e2) {
            throw new IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", e2);
        }
    }

    public final Activity a() {
        return getActivity();
    }

    public final <T extends LifecycleCallback> T a(String str, Class<T> cls) {
        return (LifecycleCallback) cls.cast(this.f17599b.get(str));
    }

    public final void a(String str, LifecycleCallback lifecycleCallback) {
        if (!this.f17599b.containsKey(str)) {
            this.f17599b.put(str, lifecycleCallback);
            if (this.f17600c > 0) {
                new zzi(Looper.getMainLooper()).post(new dg(this, lifecycleCallback, str));
                return;
            }
            return;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 59);
        sb.append("LifecycleCallback with tag ");
        sb.append(str);
        sb.append(" already added to this fragment.");
        throw new IllegalArgumentException(sb.toString());
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (LifecycleCallback a2 : this.f17599b.values()) {
            a2.a(str, fileDescriptor, printWriter, strArr);
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        for (LifecycleCallback a2 : this.f17599b.values()) {
            a2.a(i2, i3, intent);
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f17600c = 1;
        this.f17601d = bundle;
        for (Map.Entry next : this.f17599b.entrySet()) {
            ((LifecycleCallback) next.getValue()).a(bundle != null ? bundle.getBundle((String) next.getKey()) : null);
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        this.f17600c = 5;
        for (LifecycleCallback b2 : this.f17599b.values()) {
            b2.b();
        }
    }

    public final void onResume() {
        super.onResume();
        this.f17600c = 3;
        for (LifecycleCallback c2 : this.f17599b.values()) {
            c2.c();
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            for (Map.Entry next : this.f17599b.entrySet()) {
                Bundle bundle2 = new Bundle();
                ((LifecycleCallback) next.getValue()).b(bundle2);
                bundle.putBundle((String) next.getKey(), bundle2);
            }
        }
    }

    public final void onStart() {
        super.onStart();
        this.f17600c = 2;
        for (LifecycleCallback d2 : this.f17599b.values()) {
            d2.d();
        }
    }

    public final void onStop() {
        super.onStop();
        this.f17600c = 4;
        for (LifecycleCallback e2 : this.f17599b.values()) {
            e2.e();
        }
    }
}
