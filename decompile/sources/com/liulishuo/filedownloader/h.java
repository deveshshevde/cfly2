package com.liulishuo.filedownloader;

import com.liulishuo.filedownloader.a;
import com.liulishuo.filedownloader.message.MessageSnapshot;
import iq.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class h {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<a.b> f21350a;

    private static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final h f21351a = new h();
    }

    private h() {
        this.f21350a = new ArrayList<>();
    }

    public static h a() {
        return a.f21351a;
    }

    /* access modifiers changed from: package-private */
    public int a(int i2) {
        int i3;
        synchronized (this.f21350a) {
            Iterator<a.b> it2 = this.f21350a.iterator();
            i3 = 0;
            while (it2.hasNext()) {
                if (it2.next().a(i2)) {
                    i3++;
                }
            }
        }
        return i3;
    }

    /* access modifiers changed from: package-private */
    public void a(List<a.b> list) {
        synchronized (this.f21350a) {
            Iterator<a.b> it2 = this.f21350a.iterator();
            while (it2.hasNext()) {
                a.b next = it2.next();
                if (!list.contains(next)) {
                    list.add(next);
                }
            }
            this.f21350a.clear();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a(a.b bVar) {
        return this.f21350a.isEmpty() || !this.f21350a.contains(bVar);
    }

    public boolean a(a.b bVar, MessageSnapshot messageSnapshot) {
        boolean remove;
        byte b2 = messageSnapshot.b();
        synchronized (this.f21350a) {
            remove = this.f21350a.remove(bVar);
            if (remove && this.f21350a.size() == 0 && m.a().f()) {
                q.a().a(true);
            }
        }
        if (d.f29057a && this.f21350a.size() == 0) {
            d.e(this, "remove %s left %d %d", bVar, Byte.valueOf(b2), Integer.valueOf(this.f21350a.size()));
        }
        if (remove) {
            t d2 = bVar.B().d();
            if (b2 == -4) {
                d2.g(messageSnapshot);
            } else if (b2 == -3) {
                d2.e(com.liulishuo.filedownloader.message.d.a(messageSnapshot));
            } else if (b2 == -2) {
                d2.i(messageSnapshot);
            } else if (b2 == -1) {
                d2.h(messageSnapshot);
            }
        } else {
            d.a(this, "remove error, not exist: %s %d", bVar, Byte.valueOf(b2));
        }
        return remove;
    }

    /* access modifiers changed from: package-private */
    public List<a.b> b(int i2) {
        byte r2;
        ArrayList arrayList = new ArrayList();
        synchronized (this.f21350a) {
            Iterator<a.b> it2 = this.f21350a.iterator();
            while (it2.hasNext()) {
                a.b next = it2.next();
                if (next.a(i2) && !next.C() && (r2 = next.A().r()) != 0 && r2 != 10) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public void b(a.b bVar) {
        if (!bVar.A().b()) {
            bVar.E();
        }
        if (bVar.B().d().a()) {
            c(bVar);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        return this.f21350a.isEmpty();
    }

    /* access modifiers changed from: package-private */
    public int c() {
        return this.f21350a.size();
    }

    /* access modifiers changed from: package-private */
    public void c(a.b bVar) {
        if (!bVar.F()) {
            synchronized (this.f21350a) {
                if (this.f21350a.contains(bVar)) {
                    d.d(this, "already has %s", bVar);
                } else {
                    bVar.G();
                    this.f21350a.add(bVar);
                    if (d.f29057a) {
                        d.e(this, "add list in all %s %d %d", bVar, Byte.valueOf(bVar.A().r()), Integer.valueOf(this.f21350a.size()));
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public a.b[] d() {
        a.b[] bVarArr;
        synchronized (this.f21350a) {
            bVarArr = (a.b[]) this.f21350a.toArray(new a.b[this.f21350a.size()]);
        }
        return bVarArr;
    }
}
