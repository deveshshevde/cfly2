package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

public final class be {

    /* renamed from: a  reason: collision with root package name */
    private static final Uri f17799a = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").build();

    /* renamed from: b  reason: collision with root package name */
    private final String f17800b;

    /* renamed from: c  reason: collision with root package name */
    private final String f17801c;

    /* renamed from: d  reason: collision with root package name */
    private final ComponentName f17802d = null;

    /* renamed from: e  reason: collision with root package name */
    private final int f17803e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f17804f;

    public be(String str, String str2, int i2, boolean z2) {
        m.a(str);
        this.f17800b = str;
        m.a(str2);
        this.f17801c = str2;
        this.f17803e = i2;
        this.f17804f = z2;
    }

    public final int a() {
        return this.f17803e;
    }

    public final Intent a(Context context) {
        Bundle bundle;
        if (this.f17800b == null) {
            return new Intent().setComponent(this.f17802d);
        }
        Intent intent = null;
        if (this.f17804f) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("serviceActionBundleKey", this.f17800b);
            try {
                bundle = context.getContentResolver().call(f17799a, "serviceIntentCall", (String) null, bundle2);
            } catch (IllegalArgumentException e2) {
                Log.w("ConnectionStatusConfig", "Dynamic intent resolution failed: ".concat(e2.toString()));
                bundle = null;
            }
            if (bundle != null) {
                intent = (Intent) bundle.getParcelable("serviceResponseIntentKey");
            }
            if (intent == null) {
                String valueOf = String.valueOf(this.f17800b);
                Log.w("ConnectionStatusConfig", valueOf.length() != 0 ? "Dynamic lookup for intent failed for action: ".concat(valueOf) : new String("Dynamic lookup for intent failed for action: "));
            }
        }
        return intent != null ? intent : new Intent(this.f17800b).setPackage(this.f17801c);
    }

    public final ComponentName b() {
        return this.f17802d;
    }

    public final String c() {
        return this.f17801c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof be)) {
            return false;
        }
        be beVar = (be) obj;
        return l.a(this.f17800b, beVar.f17800b) && l.a(this.f17801c, beVar.f17801c) && l.a(this.f17802d, beVar.f17802d) && this.f17803e == beVar.f17803e && this.f17804f == beVar.f17804f;
    }

    public final int hashCode() {
        return l.a(this.f17800b, this.f17801c, this.f17802d, Integer.valueOf(this.f17803e), Boolean.valueOf(this.f17804f));
    }

    public final String toString() {
        String str = this.f17800b;
        if (str != null) {
            return str;
        }
        m.a(this.f17802d);
        return this.f17802d.flattenToString();
    }
}
