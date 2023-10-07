package com.flypro.core.mission.survey.grid;

import ef.a;
import eg.b;
import java.util.ArrayList;
import java.util.List;

public class d {

    /* renamed from: a  reason: collision with root package name */
    List<b> f14453a = new ArrayList();

    public d(List<b> list, List<b> list2) {
        for (b next : list) {
            a(a(list2, next), next);
        }
    }

    private ArrayList<a> a(List<b> list, b bVar) {
        ArrayList<a> arrayList = new ArrayList<>();
        for (b a2 : list) {
            try {
                arrayList.add(eg.d.a(a2, bVar));
            } catch (Exception unused) {
            }
        }
        return arrayList;
    }

    private void a(ArrayList<a> arrayList, b bVar) {
        int size = arrayList.size();
        if (size != 0 && size != 1) {
            if (size != 2) {
                this.f14453a.add(eg.d.a(arrayList));
            } else {
                this.f14453a.add(new b(arrayList.get(0), arrayList.get(1)));
            }
        }
    }

    public List<b> a() {
        return this.f14453a;
    }
}
