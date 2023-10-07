package com.amap.api.mapcore.util;

import android.content.Context;
import com.amap.api.mapcore.util.ff;
import com.amap.api.mapcore.util.gk;
import java.util.List;

public final class gi {

    /* renamed from: a  reason: collision with root package name */
    private Context f8923a;

    /* renamed from: b  reason: collision with root package name */
    private ff f8924b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f8925c = true;

    /* renamed from: d  reason: collision with root package name */
    private String f8926d = "40C27E38DCAD404B5465362914090908";

    /* renamed from: e  reason: collision with root package name */
    private ig f8927e = new ig("40C27E38DCAD404B5465362914090908");

    public final void a(Context context, boolean z2, String str, String str2, String str3, String[] strArr) {
        try {
            ff a2 = new ff.a(str, str2, str).a(strArr).a(str3).a();
            if (context != null) {
                Context applicationContext = context.getApplicationContext();
                this.f8923a = applicationContext;
                this.f8924b = a2;
                this.f8925c = z2;
                this.f8927e.a(applicationContext, a2);
            }
        } catch (eu unused) {
        }
    }

    public final void a(String str, String str2) {
        List<ff> a2 = this.f8927e.a(this.f8923a);
        gk gkVar = gk.a.f8929a;
        gk.a(this.f8923a, str, str2, a2, this.f8925c, this.f8924b);
    }
}
