package com.lidroid.xutils.http.client.multipart;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

class e implements Iterable<d> {

    /* renamed from: a  reason: collision with root package name */
    private final List<d> f21103a = new LinkedList();

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, List<d>> f21104b = new HashMap();

    public d a(String str) {
        List list;
        if (str == null || (list = this.f21104b.get(str.toLowerCase(Locale.US))) == null || list.isEmpty()) {
            return null;
        }
        return (d) list.get(0);
    }

    public void a(d dVar) {
        if (dVar != null) {
            String lowerCase = dVar.a().toLowerCase(Locale.US);
            List list = this.f21104b.get(lowerCase);
            if (list == null) {
                list = new LinkedList();
                this.f21104b.put(lowerCase, list);
            }
            list.add(dVar);
            this.f21103a.add(dVar);
        }
    }

    public Iterator<d> iterator() {
        return Collections.unmodifiableList(this.f21103a).iterator();
    }

    public String toString() {
        return this.f21103a.toString();
    }
}
