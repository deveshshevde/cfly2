package com.amap.api.mapcore.util;

import java.util.ArrayList;
import java.util.HashMap;

public final class jp {

    /* renamed from: a  reason: collision with root package name */
    private HashMap<String, jq> f9492a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private long f9493b = 0;

    public final long a(jq jqVar) {
        if (jqVar == null) {
            return 0;
        }
        HashMap<String, jq> hashMap = this.f9492a;
        String b2 = jqVar.b();
        jq jqVar2 = hashMap.get(b2);
        if (jqVar2 == null) {
            jqVar.f9507n = is.b();
            hashMap.put(b2, jqVar);
            return 0;
        } else if (jqVar2.a() != jqVar.a()) {
            jqVar.f9507n = is.b();
            hashMap.put(b2, jqVar);
            return 0;
        } else {
            jqVar.f9507n = jqVar2.f9507n;
            hashMap.put(b2, jqVar);
            return (is.b() - jqVar2.f9507n) / 1000;
        }
    }

    public final void a() {
        this.f9492a.clear();
        this.f9493b = 0;
    }

    public final void a(ArrayList<? extends jq> arrayList) {
        if (arrayList != null) {
            long b2 = is.b();
            long j2 = this.f9493b;
            if (j2 <= 0 || b2 - j2 >= 60000) {
                HashMap<String, jq> hashMap = this.f9492a;
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    jq jqVar = (jq) arrayList.get(i2);
                    jq jqVar2 = hashMap.get(jqVar.b());
                    if (jqVar2 != null) {
                        if (jqVar2.a() == jqVar.a()) {
                            jqVar.f9507n = jqVar2.f9507n;
                        } else {
                            jqVar.f9507n = b2;
                        }
                    }
                }
                hashMap.clear();
                int size2 = arrayList.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    jq jqVar3 = (jq) arrayList.get(i3);
                    hashMap.put(jqVar3.b(), jqVar3);
                }
                this.f9493b = b2;
            }
        }
    }
}
