package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import androidx.core.app.a;
import androidx.core.content.b;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import s.f;

public abstract class h<E> extends e {

    /* renamed from: a  reason: collision with root package name */
    private final Activity f3387a;

    /* renamed from: b  reason: collision with root package name */
    final FragmentManager f3388b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f3389c;

    /* renamed from: d  reason: collision with root package name */
    private final Handler f3390d;

    /* renamed from: e  reason: collision with root package name */
    private final int f3391e;

    h(Activity activity, Context context, Handler handler, int i2) {
        this.f3388b = new k();
        this.f3387a = activity;
        this.f3389c = (Context) f.a(context, (Object) "context == null");
        this.f3390d = (Handler) f.a(handler, (Object) "handler == null");
        this.f3391e = i2;
    }

    h(FragmentActivity fragmentActivity) {
        this(fragmentActivity, fragmentActivity, new Handler(), 0);
    }

    public View a(int i2) {
        return null;
    }

    public void a(Fragment fragment, Intent intent, int i2, Bundle bundle) {
        if (i2 == -1) {
            b.a(this.f3389c, intent, bundle);
            return;
        }
        throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
    }

    @Deprecated
    public void a(Fragment fragment, IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) throws IntentSender.SendIntentException {
        if (i2 == -1) {
            a.a(this.f3387a, intentSender, i2, intent, i3, i4, i5, bundle);
        } else {
            throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
        }
    }

    @Deprecated
    public void a(Fragment fragment, String[] strArr, int i2) {
    }

    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public boolean a() {
        return true;
    }

    public boolean a(Fragment fragment) {
        return true;
    }

    public boolean a(String str) {
        return false;
    }

    public LayoutInflater b() {
        return LayoutInflater.from(this.f3389c);
    }

    public void d() {
    }

    public abstract E e();

    /* access modifiers changed from: package-private */
    public Activity f() {
        return this.f3387a;
    }

    /* access modifiers changed from: package-private */
    public Context g() {
        return this.f3389c;
    }

    /* access modifiers changed from: package-private */
    public Handler h() {
        return this.f3390d;
    }
}
