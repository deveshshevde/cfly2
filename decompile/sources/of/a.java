package of;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import org.jcodec.common.model.c;
import org.jcodec.containers.mp4.boxes.o;

public class a {

    /* renamed from: of.a$a  reason: collision with other inner class name */
    public static class C0231a<T> {

        /* renamed from: a  reason: collision with root package name */
        private T f31726a;

        /* renamed from: b  reason: collision with root package name */
        private T f31727b;

        public C0231a(T t2, T t3) {
            this.f31726a = t2;
            this.f31727b = t3;
        }

        public T a() {
            return this.f31726a;
        }

        public T b() {
            return this.f31727b;
        }
    }

    public static List<o> a(c cVar, List<o> list, List<o> list2) {
        ArrayList arrayList = new ArrayList();
        List arrayList2 = new ArrayList(list);
        for (o next : list2) {
            long a2 = cVar.a(next.b());
            C0231a<List<o>> a3 = a(a((List<o>) arrayList2, cVar.c(), a2).b(), cVar.c(), a2 + next.a());
            arrayList.addAll(a3.a());
            arrayList2 = a3.b();
        }
        return arrayList;
    }

    public static C0231a<List<o>> a(List<o> list, c cVar, long j2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ListIterator<o> listIterator = list.listIterator();
        long j3 = 0;
        while (true) {
            if (!listIterator.hasNext()) {
                break;
            }
            o next = listIterator.next();
            if (next.a() + j3 > j2) {
                int i2 = (int) (j2 - j3);
                int a2 = cVar.a(i2);
                long j4 = (long) i2;
                o oVar = new o(j4, next.b(), 1.0f);
                o oVar2 = new o(next.a() - j4, ((long) a2) + next.b(), 1.0f);
                listIterator.remove();
                if (oVar.a() > 0) {
                    listIterator.add(oVar);
                    arrayList.add(oVar);
                }
                if (oVar2.a() > 0) {
                    listIterator.add(oVar2);
                    arrayList2.add(oVar2);
                }
            } else {
                c cVar2 = cVar;
                arrayList.add(next);
                j3 += next.a();
            }
        }
        while (listIterator.hasNext()) {
            arrayList2.add(listIterator.next());
        }
        return new C0231a<>(arrayList, arrayList2);
    }
}
