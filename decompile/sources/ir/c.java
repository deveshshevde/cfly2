package ir;

import android.view.animation.Interpolator;
import ir.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class c extends a {

    /* renamed from: b  reason: collision with root package name */
    boolean f29075b = false;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<a> f29076c = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public HashMap<a, e> f29077d = new HashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<e> f29078e = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<e> f29079f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    private boolean f29080g = true;

    /* renamed from: h  reason: collision with root package name */
    private a f29081h = null;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public boolean f29082i = false;

    /* renamed from: j  reason: collision with root package name */
    private long f29083j = 0;

    /* renamed from: k  reason: collision with root package name */
    private m f29084k = null;

    /* renamed from: l  reason: collision with root package name */
    private long f29085l = -1;

    private class a implements a.C0197a {

        /* renamed from: b  reason: collision with root package name */
        private c f29090b;

        a(c cVar) {
            this.f29090b = cVar;
        }

        public void a(a aVar) {
        }

        public void b(a aVar) {
            aVar.b(this);
            c.this.f29076c.remove(aVar);
            boolean z2 = true;
            ((e) this.f29090b.f29077d.get(aVar)).f29103f = true;
            if (!c.this.f29075b) {
                ArrayList c2 = this.f29090b.f29079f;
                int size = c2.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        break;
                    } else if (!((e) c2.get(i2)).f29103f) {
                        z2 = false;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (z2) {
                    if (c.this.f29074a != null) {
                        ArrayList arrayList = (ArrayList) c.this.f29074a.clone();
                        int size2 = arrayList.size();
                        for (int i3 = 0; i3 < size2; i3++) {
                            ((a.C0197a) arrayList.get(i3)).b(this.f29090b);
                        }
                    }
                    boolean unused = this.f29090b.f29082i = false;
                }
            }
        }

        public void c(a aVar) {
        }
    }

    public class b {

        /* renamed from: b  reason: collision with root package name */
        private e f29092b;

        b(a aVar) {
            e eVar = (e) c.this.f29077d.get(aVar);
            this.f29092b = eVar;
            if (eVar == null) {
                this.f29092b = new e(aVar);
                c.this.f29077d.put(aVar, this.f29092b);
                c.this.f29078e.add(this.f29092b);
            }
        }

        public b a(a aVar) {
            e eVar = (e) c.this.f29077d.get(aVar);
            if (eVar == null) {
                eVar = new e(aVar);
                c.this.f29077d.put(aVar, eVar);
                c.this.f29078e.add(eVar);
            }
            eVar.a(new C0198c(this.f29092b, 0));
            return this;
        }

        public b b(a aVar) {
            e eVar = (e) c.this.f29077d.get(aVar);
            if (eVar == null) {
                eVar = new e(aVar);
                c.this.f29077d.put(aVar, eVar);
                c.this.f29078e.add(eVar);
            }
            eVar.a(new C0198c(this.f29092b, 1));
            return this;
        }
    }

    /* renamed from: ir.c$c  reason: collision with other inner class name */
    private static class C0198c {

        /* renamed from: a  reason: collision with root package name */
        public e f29093a;

        /* renamed from: b  reason: collision with root package name */
        public int f29094b;

        public C0198c(e eVar, int i2) {
            this.f29093a = eVar;
            this.f29094b = i2;
        }
    }

    private static class d implements a.C0197a {

        /* renamed from: a  reason: collision with root package name */
        private c f29095a;

        /* renamed from: b  reason: collision with root package name */
        private e f29096b;

        /* renamed from: c  reason: collision with root package name */
        private int f29097c;

        public d(c cVar, e eVar, int i2) {
            this.f29095a = cVar;
            this.f29096b = eVar;
            this.f29097c = i2;
        }

        private void d(a aVar) {
            if (!this.f29095a.f29075b) {
                C0198c cVar = null;
                int size = this.f29096b.f29100c.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        break;
                    }
                    C0198c cVar2 = this.f29096b.f29100c.get(i2);
                    if (cVar2.f29094b == this.f29097c && cVar2.f29093a.f29098a == aVar) {
                        aVar.b(this);
                        cVar = cVar2;
                        break;
                    }
                    i2++;
                }
                this.f29096b.f29100c.remove(cVar);
                if (this.f29096b.f29100c.size() == 0) {
                    this.f29096b.f29098a.a();
                    this.f29095a.f29076c.add(this.f29096b.f29098a);
                }
            }
        }

        public void a(a aVar) {
            if (this.f29097c == 0) {
                d(aVar);
            }
        }

        public void b(a aVar) {
            if (this.f29097c == 1) {
                d(aVar);
            }
        }

        public void c(a aVar) {
        }
    }

    private static class e implements Cloneable {

        /* renamed from: a  reason: collision with root package name */
        public a f29098a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<C0198c> f29099b = null;

        /* renamed from: c  reason: collision with root package name */
        public ArrayList<C0198c> f29100c = null;

        /* renamed from: d  reason: collision with root package name */
        public ArrayList<e> f29101d = null;

        /* renamed from: e  reason: collision with root package name */
        public ArrayList<e> f29102e = null;

        /* renamed from: f  reason: collision with root package name */
        public boolean f29103f = false;

        public e(a aVar) {
            this.f29098a = aVar;
        }

        /* renamed from: a */
        public e clone() {
            try {
                e eVar = (e) super.clone();
                eVar.f29098a = this.f29098a.clone();
                return eVar;
            } catch (CloneNotSupportedException unused) {
                throw new AssertionError();
            }
        }

        public void a(C0198c cVar) {
            if (this.f29099b == null) {
                this.f29099b = new ArrayList<>();
                this.f29101d = new ArrayList<>();
            }
            this.f29099b.add(cVar);
            if (!this.f29101d.contains(cVar.f29093a)) {
                this.f29101d.add(cVar.f29093a);
            }
            e eVar = cVar.f29093a;
            if (eVar.f29102e == null) {
                eVar.f29102e = new ArrayList<>();
            }
            eVar.f29102e.add(this);
        }
    }

    private void e() {
        if (this.f29080g) {
            this.f29079f.clear();
            ArrayList arrayList = new ArrayList();
            int size = this.f29078e.size();
            for (int i2 = 0; i2 < size; i2++) {
                e eVar = this.f29078e.get(i2);
                if (eVar.f29099b == null || eVar.f29099b.size() == 0) {
                    arrayList.add(eVar);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            while (arrayList.size() > 0) {
                int size2 = arrayList.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    e eVar2 = (e) arrayList.get(i3);
                    this.f29079f.add(eVar2);
                    if (eVar2.f29102e != null) {
                        int size3 = eVar2.f29102e.size();
                        for (int i4 = 0; i4 < size3; i4++) {
                            e eVar3 = eVar2.f29102e.get(i4);
                            eVar3.f29101d.remove(eVar2);
                            if (eVar3.f29101d.size() == 0) {
                                arrayList2.add(eVar3);
                            }
                        }
                    }
                }
                arrayList.clear();
                arrayList.addAll(arrayList2);
                arrayList2.clear();
            }
            this.f29080g = false;
            if (this.f29079f.size() != this.f29078e.size()) {
                throw new IllegalStateException("Circular dependencies cannot exist in AnimatorSet");
            }
            return;
        }
        int size4 = this.f29078e.size();
        for (int i5 = 0; i5 < size4; i5++) {
            e eVar4 = this.f29078e.get(i5);
            if (eVar4.f29099b != null && eVar4.f29099b.size() > 0) {
                int size5 = eVar4.f29099b.size();
                for (int i6 = 0; i6 < size5; i6++) {
                    C0198c cVar = eVar4.f29099b.get(i6);
                    if (eVar4.f29101d == null) {
                        eVar4.f29101d = new ArrayList<>();
                    }
                    if (!eVar4.f29101d.contains(cVar.f29093a)) {
                        eVar4.f29101d.add(cVar.f29093a);
                    }
                }
            }
            eVar4.f29103f = false;
        }
    }

    public b a(a aVar) {
        if (aVar == null) {
            return null;
        }
        this.f29080g = true;
        return new b(aVar);
    }

    public void a() {
        this.f29075b = false;
        this.f29082i = true;
        e();
        int size = this.f29079f.size();
        for (int i2 = 0; i2 < size; i2++) {
            e eVar = this.f29079f.get(i2);
            ArrayList<a.C0197a> b2 = eVar.f29098a.b();
            if (b2 != null && b2.size() > 0) {
                Iterator it2 = new ArrayList(b2).iterator();
                while (it2.hasNext()) {
                    a.C0197a aVar = (a.C0197a) it2.next();
                    if ((aVar instanceof d) || (aVar instanceof a)) {
                        eVar.f29098a.b(aVar);
                    }
                }
            }
        }
        final ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < size; i3++) {
            e eVar2 = this.f29079f.get(i3);
            if (this.f29081h == null) {
                this.f29081h = new a(this);
            }
            if (eVar2.f29099b == null || eVar2.f29099b.size() == 0) {
                arrayList.add(eVar2);
            } else {
                int size2 = eVar2.f29099b.size();
                for (int i4 = 0; i4 < size2; i4++) {
                    C0198c cVar = eVar2.f29099b.get(i4);
                    cVar.f29093a.f29098a.a((a.C0197a) new d(this, eVar2, cVar.f29094b));
                }
                eVar2.f29100c = (ArrayList) eVar2.f29099b.clone();
            }
            eVar2.f29098a.a((a.C0197a) this.f29081h);
        }
        if (this.f29083j <= 0) {
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                e eVar3 = (e) it3.next();
                eVar3.f29098a.a();
                this.f29076c.add(eVar3.f29098a);
            }
        } else {
            m b3 = m.b(0.0f, 1.0f);
            this.f29084k = b3;
            b3.a(this.f29083j);
            this.f29084k.a((a.C0197a) new b() {

                /* renamed from: a  reason: collision with root package name */
                boolean f29086a = false;

                public void b(a aVar) {
                    if (!this.f29086a) {
                        int size = arrayList.size();
                        for (int i2 = 0; i2 < size; i2++) {
                            e eVar = (e) arrayList.get(i2);
                            eVar.f29098a.a();
                            c.this.f29076c.add(eVar.f29098a);
                        }
                    }
                }
            });
            this.f29084k.a();
        }
        if (this.f29074a != null) {
            ArrayList arrayList2 = (ArrayList) this.f29074a.clone();
            int size3 = arrayList2.size();
            for (int i5 = 0; i5 < size3; i5++) {
                ((a.C0197a) arrayList2.get(i5)).a(this);
            }
        }
        if (this.f29078e.size() == 0 && this.f29083j == 0) {
            this.f29082i = false;
            if (this.f29074a != null) {
                ArrayList arrayList3 = (ArrayList) this.f29074a.clone();
                int size4 = arrayList3.size();
                for (int i6 = 0; i6 < size4; i6++) {
                    ((a.C0197a) arrayList3.get(i6)).b(this);
                }
            }
        }
    }

    public void a(Interpolator interpolator) {
        Iterator<e> it2 = this.f29078e.iterator();
        while (it2.hasNext()) {
            it2.next().f29098a.a(interpolator);
        }
    }

    public void a(List<a> list) {
        if (list != null && list.size() > 0) {
            this.f29080g = true;
            int i2 = 0;
            if (list.size() == 1) {
                a(list.get(0));
                return;
            }
            while (i2 < list.size() - 1) {
                i2++;
                a(list.get(i2)).b(list.get(i2));
            }
        }
    }

    public void a(a... aVarArr) {
        if (aVarArr != null) {
            this.f29080g = true;
            b a2 = a(aVarArr[0]);
            for (int i2 = 1; i2 < aVarArr.length; i2++) {
                a2.a(aVarArr[i2]);
            }
        }
    }

    public void b(long j2) {
        this.f29083j = j2;
    }

    /* renamed from: c */
    public c a(long j2) {
        if (j2 >= 0) {
            Iterator<e> it2 = this.f29078e.iterator();
            while (it2.hasNext()) {
                it2.next().f29098a.a(j2);
            }
            this.f29085l = j2;
            return this;
        }
        throw new IllegalArgumentException("duration must be a value of zero or greater");
    }

    /* renamed from: d */
    public c clone() {
        c cVar = (c) super.clone();
        cVar.f29080g = true;
        cVar.f29075b = false;
        cVar.f29082i = false;
        cVar.f29076c = new ArrayList<>();
        cVar.f29077d = new HashMap<>();
        cVar.f29078e = new ArrayList<>();
        cVar.f29079f = new ArrayList<>();
        HashMap hashMap = new HashMap();
        Iterator<e> it2 = this.f29078e.iterator();
        while (it2.hasNext()) {
            e next = it2.next();
            e a2 = next.clone();
            hashMap.put(next, a2);
            cVar.f29078e.add(a2);
            cVar.f29077d.put(a2.f29098a, a2);
            ArrayList arrayList = null;
            a2.f29099b = null;
            a2.f29100c = null;
            a2.f29102e = null;
            a2.f29101d = null;
            ArrayList<a.C0197a> b2 = a2.f29098a.b();
            if (b2 != null) {
                Iterator<a.C0197a> it3 = b2.iterator();
                while (it3.hasNext()) {
                    a.C0197a next2 = it3.next();
                    if (next2 instanceof a) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(next2);
                    }
                }
                if (arrayList != null) {
                    Iterator it4 = arrayList.iterator();
                    while (it4.hasNext()) {
                        b2.remove((a.C0197a) it4.next());
                    }
                }
            }
        }
        Iterator<e> it5 = this.f29078e.iterator();
        while (it5.hasNext()) {
            e next3 = it5.next();
            e eVar = (e) hashMap.get(next3);
            if (next3.f29099b != null) {
                Iterator<C0198c> it6 = next3.f29099b.iterator();
                while (it6.hasNext()) {
                    C0198c next4 = it6.next();
                    eVar.a(new C0198c((e) hashMap.get(next4.f29093a), next4.f29094b));
                }
            }
        }
        return cVar;
    }
}
