package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class g {

    /* renamed from: a  reason: collision with root package name */
    private static final Comparator<c> f4162a = new Comparator<c>() {
        /* renamed from: a */
        public int compare(c cVar, c cVar2) {
            return cVar.f4165a - cVar2.f4165a;
        }
    };

    public static abstract class a {
        public abstract int a();

        public abstract boolean a(int i2, int i3);

        public abstract int b();

        public abstract boolean b(int i2, int i3);

        public Object c(int i2, int i3) {
            return null;
        }
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        private final int[] f4163a;

        /* renamed from: b  reason: collision with root package name */
        private final int f4164b;

        b(int i2) {
            int[] iArr = new int[i2];
            this.f4163a = iArr;
            this.f4164b = iArr.length / 2;
        }

        /* access modifiers changed from: package-private */
        public int a(int i2) {
            return this.f4163a[i2 + this.f4164b];
        }

        /* access modifiers changed from: package-private */
        public void a(int i2, int i3) {
            this.f4163a[i2 + this.f4164b] = i3;
        }

        /* access modifiers changed from: package-private */
        public int[] a() {
            return this.f4163a;
        }
    }

    static class c {

        /* renamed from: a  reason: collision with root package name */
        public final int f4165a;

        /* renamed from: b  reason: collision with root package name */
        public final int f4166b;

        /* renamed from: c  reason: collision with root package name */
        public final int f4167c;

        c(int i2, int i3, int i4) {
            this.f4165a = i2;
            this.f4166b = i3;
            this.f4167c = i4;
        }

        /* access modifiers changed from: package-private */
        public int a() {
            return this.f4165a + this.f4167c;
        }

        /* access modifiers changed from: package-private */
        public int b() {
            return this.f4166b + this.f4167c;
        }
    }

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        private final List<c> f4168a;

        /* renamed from: b  reason: collision with root package name */
        private final int[] f4169b;

        /* renamed from: c  reason: collision with root package name */
        private final int[] f4170c;

        /* renamed from: d  reason: collision with root package name */
        private final a f4171d;

        /* renamed from: e  reason: collision with root package name */
        private final int f4172e;

        /* renamed from: f  reason: collision with root package name */
        private final int f4173f;

        /* renamed from: g  reason: collision with root package name */
        private final boolean f4174g;

        d(a aVar, List<c> list, int[] iArr, int[] iArr2, boolean z2) {
            this.f4168a = list;
            this.f4169b = iArr;
            this.f4170c = iArr2;
            Arrays.fill(iArr, 0);
            Arrays.fill(iArr2, 0);
            this.f4171d = aVar;
            this.f4172e = aVar.a();
            this.f4173f = aVar.b();
            this.f4174g = z2;
            a();
            b();
        }

        private static e a(Collection<e> collection, int i2, boolean z2) {
            e eVar;
            Iterator<e> it2 = collection.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    eVar = null;
                    break;
                }
                eVar = it2.next();
                if (eVar.f4175a == i2 && eVar.f4177c == z2) {
                    it2.remove();
                    break;
                }
            }
            while (it2.hasNext()) {
                e next = it2.next();
                int i3 = next.f4176b;
                next.f4176b = z2 ? i3 - 1 : i3 + 1;
            }
            return eVar;
        }

        private void a() {
            c cVar = this.f4168a.isEmpty() ? null : this.f4168a.get(0);
            if (!(cVar != null && cVar.f4165a == 0 && cVar.f4166b == 0)) {
                this.f4168a.add(0, new c(0, 0, 0));
            }
            this.f4168a.add(new c(this.f4172e, this.f4173f, 0));
        }

        private void a(int i2) {
            int size = this.f4168a.size();
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                c cVar = this.f4168a.get(i4);
                while (i3 < cVar.f4166b) {
                    if (this.f4170c[i3] != 0 || !this.f4171d.a(i2, i3)) {
                        i3++;
                    } else {
                        int i5 = this.f4171d.b(i2, i3) ? 8 : 4;
                        this.f4169b[i2] = (i3 << 4) | i5;
                        this.f4170c[i3] = (i2 << 4) | i5;
                        return;
                    }
                }
                i3 = cVar.b();
            }
        }

        private void b() {
            for (c next : this.f4168a) {
                for (int i2 = 0; i2 < next.f4167c; i2++) {
                    int i3 = next.f4165a + i2;
                    int i4 = next.f4166b + i2;
                    int i5 = this.f4171d.b(i3, i4) ? 1 : 2;
                    this.f4169b[i3] = (i4 << 4) | i5;
                    this.f4170c[i4] = (i3 << 4) | i5;
                }
            }
            if (this.f4174g) {
                c();
            }
        }

        private void c() {
            int i2 = 0;
            for (c next : this.f4168a) {
                while (i2 < next.f4165a) {
                    if (this.f4169b[i2] == 0) {
                        a(i2);
                    }
                    i2++;
                }
                i2 = next.a();
            }
        }

        public void a(RecyclerView.Adapter adapter) {
            a((q) new b(adapter));
        }

        public void a(q qVar) {
            int i2;
            c cVar = qVar instanceof c ? (c) qVar : new c(qVar);
            int i3 = this.f4172e;
            ArrayDeque arrayDeque = new ArrayDeque();
            int i4 = this.f4172e;
            int i5 = this.f4173f;
            for (int size = this.f4168a.size() - 1; size >= 0; size--) {
                c cVar2 = this.f4168a.get(size);
                int a2 = cVar2.a();
                int b2 = cVar2.b();
                while (true) {
                    if (i4 <= a2) {
                        break;
                    }
                    i4--;
                    int i6 = this.f4169b[i4];
                    if ((i6 & 12) != 0) {
                        int i7 = i6 >> 4;
                        e a3 = a(arrayDeque, i7, false);
                        if (a3 != null) {
                            int i8 = (i3 - a3.f4176b) - 1;
                            cVar.c(i4, i8);
                            if ((i6 & 4) != 0) {
                                cVar.a(i8, 1, this.f4171d.c(i4, i7));
                            }
                        } else {
                            arrayDeque.add(new e(i4, (i3 - i4) - 1, true));
                        }
                    } else {
                        cVar.b(i4, 1);
                        i3--;
                    }
                }
                while (i5 > b2) {
                    i5--;
                    int i9 = this.f4170c[i5];
                    if ((i9 & 12) != 0) {
                        int i10 = i9 >> 4;
                        e a4 = a(arrayDeque, i10, true);
                        if (a4 == null) {
                            arrayDeque.add(new e(i5, i3 - i4, false));
                        } else {
                            cVar.c((i3 - a4.f4176b) - 1, i4);
                            if ((i9 & 4) != 0) {
                                cVar.a(i4, 1, this.f4171d.c(i10, i5));
                            }
                        }
                    } else {
                        cVar.a(i4, 1);
                        i3++;
                    }
                }
                int i11 = cVar2.f4165a;
                int i12 = cVar2.f4166b;
                for (i2 = 0; i2 < cVar2.f4167c; i2++) {
                    if ((this.f4169b[i11] & 15) == 2) {
                        cVar.a(i11, 1, this.f4171d.c(i11, i12));
                    }
                    i11++;
                    i12++;
                }
                i4 = cVar2.f4165a;
                i5 = cVar2.f4166b;
            }
            cVar.a();
        }
    }

    private static class e {

        /* renamed from: a  reason: collision with root package name */
        int f4175a;

        /* renamed from: b  reason: collision with root package name */
        int f4176b;

        /* renamed from: c  reason: collision with root package name */
        boolean f4177c;

        e(int i2, int i3, boolean z2) {
            this.f4175a = i2;
            this.f4176b = i3;
            this.f4177c = z2;
        }
    }

    static class f {

        /* renamed from: a  reason: collision with root package name */
        int f4178a;

        /* renamed from: b  reason: collision with root package name */
        int f4179b;

        /* renamed from: c  reason: collision with root package name */
        int f4180c;

        /* renamed from: d  reason: collision with root package name */
        int f4181d;

        public f() {
        }

        public f(int i2, int i3, int i4, int i5) {
            this.f4178a = i2;
            this.f4179b = i3;
            this.f4180c = i4;
            this.f4181d = i5;
        }

        /* access modifiers changed from: package-private */
        public int a() {
            return this.f4179b - this.f4178a;
        }

        /* access modifiers changed from: package-private */
        public int b() {
            return this.f4181d - this.f4180c;
        }
    }

    /* renamed from: androidx.recyclerview.widget.g$g  reason: collision with other inner class name */
    static class C0036g {

        /* renamed from: a  reason: collision with root package name */
        public int f4182a;

        /* renamed from: b  reason: collision with root package name */
        public int f4183b;

        /* renamed from: c  reason: collision with root package name */
        public int f4184c;

        /* renamed from: d  reason: collision with root package name */
        public int f4185d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f4186e;

        C0036g() {
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            return this.f4185d - this.f4183b != this.f4184c - this.f4182a;
        }

        /* access modifiers changed from: package-private */
        public boolean b() {
            return this.f4185d - this.f4183b > this.f4184c - this.f4182a;
        }

        /* access modifiers changed from: package-private */
        public int c() {
            return Math.min(this.f4184c - this.f4182a, this.f4185d - this.f4183b);
        }

        /* access modifiers changed from: package-private */
        public c d() {
            if (a()) {
                return this.f4186e ? new c(this.f4182a, this.f4183b, c()) : b() ? new c(this.f4182a, this.f4183b + 1, c()) : new c(this.f4182a + 1, this.f4183b, c());
            }
            int i2 = this.f4182a;
            return new c(i2, this.f4183b, this.f4184c - i2);
        }
    }

    public static d a(a aVar) {
        return a(aVar, true);
    }

    public static d a(a aVar, boolean z2) {
        int a2 = aVar.a();
        int b2 = aVar.b();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new f(0, a2, 0, b2));
        int i2 = ((((a2 + b2) + 1) / 2) * 2) + 1;
        b bVar = new b(i2);
        b bVar2 = new b(i2);
        ArrayList arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            f fVar = (f) arrayList2.remove(arrayList2.size() - 1);
            C0036g a3 = a(fVar, aVar, bVar, bVar2);
            if (a3 != null) {
                if (a3.c() > 0) {
                    arrayList.add(a3.d());
                }
                f fVar2 = arrayList3.isEmpty() ? new f() : (f) arrayList3.remove(arrayList3.size() - 1);
                fVar2.f4178a = fVar.f4178a;
                fVar2.f4180c = fVar.f4180c;
                fVar2.f4179b = a3.f4182a;
                fVar2.f4181d = a3.f4183b;
                arrayList2.add(fVar2);
                fVar.f4179b = fVar.f4179b;
                fVar.f4181d = fVar.f4181d;
                fVar.f4178a = a3.f4184c;
                fVar.f4180c = a3.f4185d;
                arrayList2.add(fVar);
            } else {
                arrayList3.add(fVar);
            }
        }
        Collections.sort(arrayList, f4162a);
        return new d(aVar, arrayList, bVar.a(), bVar2.a(), z2);
    }

    private static C0036g a(f fVar, a aVar, b bVar, b bVar2) {
        if (fVar.a() >= 1 && fVar.b() >= 1) {
            int a2 = ((fVar.a() + fVar.b()) + 1) / 2;
            bVar.a(1, fVar.f4178a);
            bVar2.a(1, fVar.f4179b);
            for (int i2 = 0; i2 < a2; i2++) {
                C0036g a3 = a(fVar, aVar, bVar, bVar2, i2);
                if (a3 != null) {
                    return a3;
                }
                C0036g b2 = b(fVar, aVar, bVar, bVar2, i2);
                if (b2 != null) {
                    return b2;
                }
            }
        }
        return null;
    }

    private static C0036g a(f fVar, a aVar, b bVar, b bVar2, int i2) {
        int i3;
        int i4;
        int i5;
        boolean z2 = true;
        if (Math.abs(fVar.a() - fVar.b()) % 2 != 1) {
            z2 = false;
        }
        int a2 = fVar.a() - fVar.b();
        int i6 = -i2;
        int i7 = i6;
        while (i7 <= i2) {
            if (i7 == i6 || (i7 != i2 && bVar.a(i7 + 1) > bVar.a(i7 - 1))) {
                i4 = bVar.a(i7 + 1);
                i3 = i4;
            } else {
                i4 = bVar.a(i7 - 1);
                i3 = i4 + 1;
            }
            int i8 = (fVar.f4180c + (i3 - fVar.f4178a)) - i7;
            int i9 = (i2 == 0 || i3 != i4) ? i8 : i8 - 1;
            while (i3 < fVar.f4179b && i8 < fVar.f4181d && aVar.a(i3, i8)) {
                i3++;
                i8++;
            }
            bVar.a(i7, i3);
            if (!z2 || (i5 = a2 - i7) < i6 + 1 || i5 > i2 - 1 || bVar2.a(i5) > i3) {
                i7 += 2;
            } else {
                C0036g gVar = new C0036g();
                gVar.f4182a = i4;
                gVar.f4183b = i9;
                gVar.f4184c = i3;
                gVar.f4185d = i8;
                gVar.f4186e = false;
                return gVar;
            }
        }
        return null;
    }

    private static C0036g b(f fVar, a aVar, b bVar, b bVar2, int i2) {
        int i3;
        int i4;
        int i5;
        boolean z2 = (fVar.a() - fVar.b()) % 2 == 0;
        int a2 = fVar.a() - fVar.b();
        int i6 = -i2;
        int i7 = i6;
        while (i7 <= i2) {
            if (i7 == i6 || (i7 != i2 && bVar2.a(i7 + 1) < bVar2.a(i7 - 1))) {
                i4 = bVar2.a(i7 + 1);
                i3 = i4;
            } else {
                i4 = bVar2.a(i7 - 1);
                i3 = i4 - 1;
            }
            int i8 = fVar.f4181d - ((fVar.f4179b - i3) - i7);
            int i9 = (i2 == 0 || i3 != i4) ? i8 : i8 + 1;
            while (i3 > fVar.f4178a && i8 > fVar.f4180c && aVar.a(i3 - 1, i8 - 1)) {
                i3--;
                i8--;
            }
            bVar2.a(i7, i3);
            if (!z2 || (i5 = a2 - i7) < i6 || i5 > i2 || bVar.a(i5) < i3) {
                i7 += 2;
            } else {
                C0036g gVar = new C0036g();
                gVar.f4182a = i3;
                gVar.f4183b = i8;
                gVar.f4184c = i4;
                gVar.f4185d = i9;
                gVar.f4186e = true;
                return gVar;
            }
        }
        return null;
    }
}
