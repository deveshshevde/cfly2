package org.greenrobot.eventbus;

import java.util.ArrayList;
import java.util.List;

final class i {

    /* renamed from: d  reason: collision with root package name */
    private static final List<i> f14048d = new ArrayList();

    /* renamed from: a  reason: collision with root package name */
    Object f14049a;

    /* renamed from: b  reason: collision with root package name */
    p f14050b;

    /* renamed from: c  reason: collision with root package name */
    i f14051c;

    private i(Object obj, p pVar) {
        this.f14049a = obj;
        this.f14050b = pVar;
    }

    static i a(p pVar, Object obj) {
        List<i> list = f14048d;
        synchronized (list) {
            int size = list.size();
            if (size <= 0) {
                return new i(obj, pVar);
            }
            i remove = list.remove(size - 1);
            remove.f14049a = obj;
            remove.f14050b = pVar;
            remove.f14051c = null;
            return remove;
        }
    }

    static void a(i iVar) {
        iVar.f14049a = null;
        iVar.f14050b = null;
        iVar.f14051c = null;
        List<i> list = f14048d;
        synchronized (list) {
            if (list.size() < 10000) {
                list.add(iVar);
            }
        }
    }
}
