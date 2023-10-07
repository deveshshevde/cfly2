package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.a;
import java.util.ArrayList;

final class aj extends ap {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ aq f17428a;

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<a.f> f17429c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public aj(aq aqVar, ArrayList<a.f> arrayList) {
        super(aqVar, (ao) null);
        this.f17428a = aqVar;
        this.f17429c = arrayList;
    }

    public final void a() {
        aq aqVar = this.f17428a;
        aqVar.f17435a.f11788g.f17462d = aq.g(aqVar);
        ArrayList<a.f> arrayList = this.f17429c;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            aq aqVar2 = this.f17428a;
            arrayList.get(i2).getRemoteService(aqVar2.f17449o, aqVar2.f17435a.f11788g.f17462d);
        }
    }
}
