package hk;

import android.graphics.PointF;
import android.util.Pair;
import com.huantansheng.easyphotos.models.puzzle.Line;
import java.util.ArrayList;
import java.util.List;

class d {
    static Pair<List<b>, List<a>> a(a aVar) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        float k2 = aVar.k();
        float l2 = aVar.l();
        float a2 = aVar.a();
        float b2 = aVar.b();
        float f2 = l2 / 3.0f;
        float f3 = b2 + f2;
        PointF pointF = new PointF(a2, f3);
        float f4 = k2 / 3.0f;
        float f5 = (f4 * 2.0f) + a2;
        PointF pointF2 = new PointF(f5, b2);
        float f6 = (f2 * 2.0f) + b2;
        PointF pointF3 = new PointF(k2 + a2, f6);
        float f7 = a2 + f4;
        PointF pointF4 = new PointF(f7, b2 + l2);
        PointF pointF5 = new PointF(f7, f3);
        PointF pointF6 = new PointF(f5, f3);
        PointF pointF7 = new PointF(f5, f6);
        PointF pointF8 = new PointF(f7, f6);
        b bVar = new b(pointF, pointF6);
        b bVar2 = new b(pointF2, pointF7);
        b bVar3 = new b(pointF8, pointF3);
        b bVar4 = new b(pointF5, pointF4);
        bVar.a(aVar.f13333a);
        bVar.b(bVar2);
        bVar.a((Line) aVar.f13334b);
        bVar.b((Line) bVar3);
        bVar2.a(aVar.f13334b);
        bVar2.b(bVar3);
        bVar2.a((Line) bVar4);
        bVar2.b((Line) aVar.f13335c);
        bVar3.a(bVar4);
        bVar3.b(aVar.f13335c);
        bVar3.a((Line) bVar);
        bVar3.b((Line) aVar.f13336d);
        bVar4.a(bVar);
        bVar4.b(aVar.f13336d);
        bVar4.a((Line) aVar.f13333a);
        bVar4.b((Line) bVar2);
        arrayList.add(bVar);
        arrayList.add(bVar2);
        arrayList.add(bVar3);
        arrayList.add(bVar4);
        a aVar2 = new a(aVar);
        aVar2.f13335c = bVar2;
        aVar2.f13336d = bVar;
        arrayList2.add(aVar2);
        a aVar3 = new a(aVar);
        aVar3.f13333a = bVar2;
        aVar3.f13336d = bVar3;
        arrayList2.add(aVar3);
        a aVar4 = new a(aVar);
        aVar4.f13335c = bVar4;
        aVar4.f13334b = bVar;
        arrayList2.add(aVar4);
        a aVar5 = new a(aVar);
        aVar5.f13334b = bVar;
        aVar5.f13335c = bVar2;
        aVar5.f13333a = bVar4;
        aVar5.f13336d = bVar3;
        arrayList2.add(aVar5);
        a aVar6 = new a(aVar);
        aVar6.f13333a = bVar4;
        aVar6.f13334b = bVar3;
        arrayList2.add(aVar6);
        return new Pair<>(arrayList, arrayList2);
    }

    static Pair<List<b>, List<a>> a(a aVar, int i2, int i3) {
        int i4;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList(i2);
        a aVar2 = new a(aVar);
        for (int i5 = i2 + 1; i5 > 1; i5--) {
            b a2 = a(aVar2, Line.Direction.HORIZONTAL, ((float) (i5 - 1)) / ((float) i5));
            arrayList2.add(a2);
            aVar2.f13336d = a2;
        }
        ArrayList arrayList3 = new ArrayList();
        a aVar3 = new a(aVar);
        int i6 = i3 + 1;
        while (true) {
            i4 = 0;
            if (i6 <= 1) {
                break;
            }
            b a3 = a(aVar3, Line.Direction.VERTICAL, ((float) (i6 - 1)) / ((float) i6));
            arrayList3.add(a3);
            a aVar4 = new a(aVar3);
            aVar4.f13333a = a3;
            int size = arrayList2.size();
            while (i4 <= size) {
                a aVar5 = new a(aVar4);
                if (i4 == 0) {
                    aVar5.f13334b = (b) arrayList2.get(i4);
                } else {
                    if (i4 != size) {
                        aVar5.f13334b = (b) arrayList2.get(i4);
                    }
                    aVar5.f13336d = (b) arrayList2.get(i4 - 1);
                }
                arrayList.add(aVar5);
                i4++;
            }
            aVar3.f13335c = a3;
            i6--;
        }
        int size2 = arrayList2.size();
        while (i4 <= size2) {
            a aVar6 = new a(aVar3);
            if (i4 == 0) {
                aVar6.f13334b = (b) arrayList2.get(i4);
            } else {
                if (i4 != arrayList2.size()) {
                    aVar6.f13334b = (b) arrayList2.get(i4);
                }
                aVar6.f13336d = (b) arrayList2.get(i4 - 1);
            }
            arrayList.add(aVar6);
            i4++;
        }
        ArrayList arrayList4 = new ArrayList();
        arrayList4.addAll(arrayList2);
        arrayList4.addAll(arrayList3);
        return new Pair<>(arrayList4, arrayList);
    }

    static b a(a aVar, Line.Direction direction, float f2) {
        b bVar;
        PointF pointF = new PointF();
        PointF pointF2 = new PointF();
        if (direction == Line.Direction.HORIZONTAL) {
            pointF.x = aVar.a();
            pointF.y = (aVar.l() * f2) + aVar.b();
            pointF2.x = aVar.c();
            pointF2.y = (aVar.l() * f2) + aVar.b();
        } else if (direction == Line.Direction.VERTICAL) {
            pointF.x = (aVar.k() * f2) + aVar.a();
            pointF.y = aVar.b();
            pointF2.x = (aVar.k() * f2) + aVar.a();
            pointF2.y = aVar.d();
        }
        b bVar2 = new b(pointF, pointF2);
        if (direction == Line.Direction.HORIZONTAL) {
            bVar2.f13346b = aVar.f13333a;
            bVar2.f13347c = aVar.f13335c;
            bVar2.b((Line) aVar.f13336d);
            bVar = aVar.f13334b;
        } else {
            if (direction == Line.Direction.VERTICAL) {
                bVar2.f13346b = aVar.f13334b;
                bVar2.f13347c = aVar.f13336d;
                bVar2.b((Line) aVar.f13335c);
                bVar = aVar.f13333a;
            }
            return bVar2;
        }
        bVar2.a((Line) bVar);
        return bVar2;
    }

    static List<a> a(a aVar, b bVar) {
        a aVar2;
        ArrayList arrayList = new ArrayList();
        if (bVar.g() == Line.Direction.HORIZONTAL) {
            a aVar3 = new a(aVar);
            aVar3.f13336d = bVar;
            arrayList.add(aVar3);
            aVar2 = new a(aVar);
            aVar2.f13334b = bVar;
        } else {
            if (bVar.g() == Line.Direction.VERTICAL) {
                a aVar4 = new a(aVar);
                aVar4.f13335c = bVar;
                arrayList.add(aVar4);
                aVar2 = new a(aVar);
                aVar2.f13333a = bVar;
            }
            return arrayList;
        }
        arrayList.add(aVar2);
        return arrayList;
    }

    static List<a> a(a aVar, b bVar, b bVar2) {
        ArrayList arrayList = new ArrayList();
        a aVar2 = new a(aVar);
        aVar2.f13336d = bVar;
        aVar2.f13335c = bVar2;
        arrayList.add(aVar2);
        a aVar3 = new a(aVar);
        aVar3.f13336d = bVar;
        aVar3.f13333a = bVar2;
        arrayList.add(aVar3);
        a aVar4 = new a(aVar);
        aVar4.f13334b = bVar;
        aVar4.f13335c = bVar2;
        arrayList.add(aVar4);
        a aVar5 = new a(aVar);
        aVar5.f13334b = bVar;
        aVar5.f13333a = bVar2;
        arrayList.add(aVar5);
        return arrayList;
    }
}
