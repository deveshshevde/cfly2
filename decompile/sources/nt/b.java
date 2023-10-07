package nt;

import android.os.Bundle;

public abstract class b<T> {

    /* renamed from: a  reason: collision with root package name */
    protected final a f31621a;

    /* access modifiers changed from: protected */
    public abstract T a(f fVar, Bundle bundle);

    /* access modifiers changed from: protected */
    public T a(f fVar, boolean z2, Bundle bundle) {
        if (fVar.a()) {
            return null;
        }
        Bundle bundle2 = bundle != null ? (Bundle) bundle.clone() : new Bundle();
        if (!bundle2.containsKey("de.greenrobot.eventbus.errordialog.title")) {
            bundle2.putString("de.greenrobot.eventbus.errordialog.title", b(fVar, bundle2));
        }
        if (!bundle2.containsKey("de.greenrobot.eventbus.errordialog.message")) {
            bundle2.putString("de.greenrobot.eventbus.errordialog.message", c(fVar, bundle2));
        }
        if (!bundle2.containsKey("de.greenrobot.eventbus.errordialog.finish_after_dialog")) {
            bundle2.putBoolean("de.greenrobot.eventbus.errordialog.finish_after_dialog", z2);
        }
        if (!bundle2.containsKey("de.greenrobot.eventbus.errordialog.event_type_on_close") && this.f31621a.f31620i != null) {
            bundle2.putSerializable("de.greenrobot.eventbus.errordialog.event_type_on_close", this.f31621a.f31620i);
        }
        if (!bundle2.containsKey("de.greenrobot.eventbus.errordialog.icon_id") && this.f31621a.f31619h != 0) {
            bundle2.putInt("de.greenrobot.eventbus.errordialog.icon_id", this.f31621a.f31619h);
        }
        return a(fVar, bundle2);
    }

    /* access modifiers changed from: protected */
    public String b(f fVar, Bundle bundle) {
        return this.f31621a.f31612a.getString(this.f31621a.f31613b);
    }

    /* access modifiers changed from: protected */
    public String c(f fVar, Bundle bundle) {
        return this.f31621a.f31612a.getString(this.f31621a.a(fVar.f31631a));
    }
}
