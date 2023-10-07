package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.af;
import com.google.android.gms.common.internal.d;
import java.util.ArrayList;
import java.util.Map;

final class ai extends ap {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ aq f17426a;

    /* renamed from: c  reason: collision with root package name */
    private final Map<a.f, af> f17427c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ai(aq aqVar, Map<a.f, af> map) {
        super(aqVar, (ao) null);
        this.f17426a = aqVar;
        this.f17427c = map;
    }

    public final void a() {
        af afVar = new af(this.f17426a.f17438d);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (a.f next : this.f17427c.keySet()) {
            if (!next.requiresGooglePlayServices() || this.f17427c.get(next).f17422c) {
                arrayList2.add(next);
            } else {
                arrayList.add(next);
            }
        }
        int i2 = -1;
        int i3 = 0;
        if (!arrayList.isEmpty()) {
            int size = arrayList.size();
            while (i3 < size) {
                i2 = afVar.a(this.f17426a.f17437c, (a.f) arrayList.get(i3));
                i3++;
                if (i2 != 0) {
                    break;
                }
            }
        } else {
            int size2 = arrayList2.size();
            while (i3 < size2) {
                i2 = afVar.a(this.f17426a.f17437c, (a.f) arrayList2.get(i3));
                i3++;
                if (i2 == 0) {
                    break;
                }
            }
        }
        if (i2 != 0) {
            ConnectionResult connectionResult = new ConnectionResult(i2, (PendingIntent) null);
            aq aqVar = this.f17426a;
            aqVar.f17435a.a((ax) new ag(this, aqVar, connectionResult));
            return;
        }
        aq aqVar2 = this.f17426a;
        if (aqVar2.f17447m && aqVar2.f17445k != null) {
            aqVar2.f17445k.b();
        }
        for (a.f next2 : this.f17427c.keySet()) {
            d.c cVar = this.f17427c.get(next2);
            if (!next2.requiresGooglePlayServices() || afVar.a(this.f17426a.f17437c, next2) == 0) {
                next2.connect(cVar);
            } else {
                aq aqVar3 = this.f17426a;
                aqVar3.f17435a.a((ax) new ah(this, aqVar3, cVar));
            }
        }
    }
}
