package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.internal.common.zzi;
import j.a;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

public final class dj extends Fragment implements i {

    /* renamed from: a  reason: collision with root package name */
    private static final WeakHashMap<FragmentActivity, WeakReference<dj>> f17605a = new WeakHashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, LifecycleCallback> f17606b = Collections.synchronizedMap(new a());
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public int f17607c = 0;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Bundle f17608d;

    public static dj a(FragmentActivity fragmentActivity) {
        dj djVar;
        WeakHashMap<FragmentActivity, WeakReference<dj>> weakHashMap = f17605a;
        WeakReference weakReference = weakHashMap.get(fragmentActivity);
        if (weakReference != null && (djVar = (dj) weakReference.get()) != null) {
            return djVar;
        }
        try {
            dj djVar2 = (dj) fragmentActivity.getSupportFragmentManager().b("SupportLifecycleFragmentImpl");
            if (djVar2 == null || djVar2.isRemoving()) {
                djVar2 = new dj();
                fragmentActivity.getSupportFragmentManager().a().a((Fragment) djVar2, "SupportLifecycleFragmentImpl").d();
            }
            weakHashMap.put(fragmentActivity, new WeakReference(djVar2));
            return djVar2;
        } catch (ClassCastException e2) {
            throw new IllegalStateException("Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", e2);
        }
    }

    public final /* synthetic */ Activity a() {
        return getActivity();
    }

    public final <T extends LifecycleCallback> T a(String str, Class<T> cls) {
        return (LifecycleCallback) cls.cast(this.f17606b.get(str));
    }

    public final void a(String str, LifecycleCallback lifecycleCallback) {
        if (!this.f17606b.containsKey(str)) {
            this.f17606b.put(str, lifecycleCallback);
            if (this.f17607c > 0) {
                new zzi(Looper.getMainLooper()).post(new di(this, lifecycleCallback, str));
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
        for (LifecycleCallback a2 : this.f17606b.values()) {
            a2.a(str, fileDescriptor, printWriter, strArr);
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        for (LifecycleCallback a2 : this.f17606b.values()) {
            a2.a(i2, i3, intent);
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f17607c = 1;
        this.f17608d = bundle;
        for (Map.Entry next : this.f17606b.entrySet()) {
            ((LifecycleCallback) next.getValue()).a(bundle != null ? bundle.getBundle((String) next.getKey()) : null);
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        this.f17607c = 5;
        for (LifecycleCallback b2 : this.f17606b.values()) {
            b2.b();
        }
    }

    public final void onResume() {
        super.onResume();
        this.f17607c = 3;
        for (LifecycleCallback c2 : this.f17606b.values()) {
            c2.c();
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            for (Map.Entry next : this.f17606b.entrySet()) {
                Bundle bundle2 = new Bundle();
                ((LifecycleCallback) next.getValue()).b(bundle2);
                bundle.putBundle((String) next.getKey(), bundle2);
            }
        }
    }

    public final void onStart() {
        super.onStart();
        this.f17607c = 2;
        for (LifecycleCallback d2 : this.f17606b.values()) {
            d2.d();
        }
    }

    public final void onStop() {
        super.onStop();
        this.f17607c = 4;
        for (LifecycleCallback e2 : this.f17606b.values()) {
            e2.e();
        }
    }
}
