package com.huantansheng.easyphotos.models.puzzle.slant;

import android.graphics.PointF;
import android.util.Pair;
import com.huantansheng.easyphotos.models.puzzle.Line;
import java.util.ArrayList;
import java.util.List;

class d {

    /* renamed from: a  reason: collision with root package name */
    private static final PointF f20454a = new PointF();

    /* renamed from: b  reason: collision with root package name */
    private static final PointF f20455b = new PointF();

    /* renamed from: c  reason: collision with root package name */
    private static final PointF f20456c = new PointF();

    /* renamed from: d  reason: collision with root package name */
    private static final PointF f20457d = new PointF();

    /* renamed from: e  reason: collision with root package name */
    private static final PointF f20458e = new PointF();

    /* renamed from: f  reason: collision with root package name */
    private static final PointF f20459f = new PointF();

    /* renamed from: g  reason: collision with root package name */
    private static final PointF f20460g = new PointF();

    /* renamed from: h  reason: collision with root package name */
    private static final PointF f20461h = new PointF();

    /* renamed from: i  reason: collision with root package name */
    private static final PointF f20462i = new PointF();

    /* renamed from: j  reason: collision with root package name */
    private static final PointF f20463j = new PointF();

    /* renamed from: k  reason: collision with root package name */
    private static final PointF f20464k = new PointF();

    /* renamed from: l  reason: collision with root package name */
    private static final PointF f20465l = new PointF();

    static float a(PointF pointF, PointF pointF2) {
        return (float) Math.sqrt(Math.pow((double) (pointF2.x - pointF.x), 2.0d) + Math.pow((double) (pointF2.y - pointF.y), 2.0d));
    }

    static float a(b bVar) {
        if (b(bVar)) {
            return 0.0f;
        }
        if (c(bVar)) {
            return Float.POSITIVE_INFINITY;
        }
        return (bVar.f20435a.y - bVar.f20436b.y) / (bVar.f20435a.x - bVar.f20436b.x);
    }

    static Pair<List<b>, List<a>> a(a aVar, int i2, int i3) {
        int i4;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList(i2);
        a aVar2 = new a(aVar);
        for (int i5 = i2 + 1; i5 > 1; i5--) {
            float f2 = ((float) (i5 - 1)) / ((float) i5);
            b a2 = a(aVar2, Line.Direction.HORIZONTAL, f2 - 0.025f, f2 + 0.025f);
            arrayList2.add(a2);
            aVar2.f20421d = a2;
            aVar2.f20423f = a2.f20435a;
            aVar2.f20425h = a2.f20436b;
        }
        ArrayList arrayList3 = new ArrayList();
        a aVar3 = new a(aVar);
        int i6 = i3 + 1;
        while (true) {
            i4 = 0;
            if (i6 <= 1) {
                break;
            }
            float f3 = ((float) (i6 - 1)) / ((float) i6);
            b a3 = a(aVar3, Line.Direction.VERTICAL, f3 + 0.025f, f3 - 0.025f);
            arrayList3.add(a3);
            a aVar4 = new a(aVar3);
            aVar4.f20418a = a3;
            aVar4.f20422e = a3.f20435a;
            aVar4.f20423f = a3.f20436b;
            int size = arrayList2.size();
            while (i4 <= size) {
                a aVar5 = new a(aVar4);
                if (i4 == 0) {
                    aVar5.f20419b = (b) arrayList2.get(i4);
                } else if (i4 == size) {
                    aVar5.f20421d = (b) arrayList2.get(i4 - 1);
                    CrossoverPointF crossoverPointF = new CrossoverPointF(aVar5.f20421d, aVar5.f20418a);
                    a(crossoverPointF, aVar5.f20421d, aVar5.f20418a);
                    CrossoverPointF crossoverPointF2 = new CrossoverPointF(aVar5.f20421d, aVar5.f20420c);
                    a(crossoverPointF2, aVar5.f20421d, aVar5.f20420c);
                    aVar5.f20423f = crossoverPointF;
                    aVar5.f20425h = crossoverPointF2;
                } else {
                    aVar5.f20419b = (b) arrayList2.get(i4);
                    aVar5.f20421d = (b) arrayList2.get(i4 - 1);
                }
                CrossoverPointF crossoverPointF3 = new CrossoverPointF(aVar5.f20419b, aVar5.f20418a);
                a(crossoverPointF3, aVar5.f20419b, aVar5.f20418a);
                CrossoverPointF crossoverPointF4 = new CrossoverPointF(aVar5.f20419b, aVar5.f20420c);
                a(crossoverPointF4, aVar5.f20419b, aVar5.f20420c);
                aVar5.f20422e = crossoverPointF3;
                aVar5.f20424g = crossoverPointF4;
                arrayList.add(aVar5);
                i4++;
            }
            aVar3.f20420c = a3;
            aVar3.f20424g = a3.f20435a;
            aVar3.f20425h = a3.f20436b;
            i6--;
        }
        int size2 = arrayList2.size();
        while (i4 <= size2) {
            a aVar6 = new a(aVar3);
            if (i4 == 0) {
                aVar6.f20419b = (b) arrayList2.get(i4);
            } else if (i4 == size2) {
                aVar6.f20421d = (b) arrayList2.get(i4 - 1);
                CrossoverPointF crossoverPointF5 = new CrossoverPointF(aVar6.f20421d, aVar6.f20418a);
                a(crossoverPointF5, aVar6.f20421d, aVar6.f20418a);
                CrossoverPointF crossoverPointF6 = new CrossoverPointF(aVar6.f20421d, aVar6.f20420c);
                a(crossoverPointF6, aVar6.f20421d, aVar6.f20420c);
                aVar6.f20423f = crossoverPointF5;
                aVar6.f20425h = crossoverPointF6;
            } else {
                aVar6.f20419b = (b) arrayList2.get(i4);
                aVar6.f20421d = (b) arrayList2.get(i4 - 1);
            }
            CrossoverPointF crossoverPointF7 = new CrossoverPointF(aVar6.f20419b, aVar6.f20418a);
            a(crossoverPointF7, aVar6.f20419b, aVar6.f20418a);
            CrossoverPointF crossoverPointF8 = new CrossoverPointF(aVar6.f20419b, aVar6.f20420c);
            a(crossoverPointF8, aVar6.f20419b, aVar6.f20420c);
            aVar6.f20422e = crossoverPointF7;
            aVar6.f20424g = crossoverPointF8;
            arrayList.add(aVar6);
            i4++;
        }
        ArrayList arrayList4 = new ArrayList();
        arrayList4.addAll(arrayList2);
        arrayList4.addAll(arrayList3);
        return new Pair<>(arrayList4, arrayList);
    }

    private static CrossoverPointF a(PointF pointF, PointF pointF2, Line.Direction direction, float f2) {
        CrossoverPointF crossoverPointF = new CrossoverPointF();
        a(crossoverPointF, pointF, pointF2, direction, f2);
        return crossoverPointF;
    }

    static b a(a aVar, Line.Direction direction, float f2, float f3) {
        b bVar;
        b bVar2 = new b(direction);
        if (direction == Line.Direction.HORIZONTAL) {
            bVar2.f20435a = a((PointF) aVar.f20422e, (PointF) aVar.f20423f, Line.Direction.VERTICAL, f2);
            bVar2.f20436b = a((PointF) aVar.f20424g, (PointF) aVar.f20425h, Line.Direction.VERTICAL, f3);
            bVar2.f20438d = aVar.f20418a;
            bVar2.f20439e = aVar.f20420c;
            bVar2.f20440f = aVar.f20421d;
            bVar = aVar.f20419b;
        } else {
            bVar2.f20435a = a((PointF) aVar.f20422e, (PointF) aVar.f20424g, Line.Direction.HORIZONTAL, f2);
            bVar2.f20436b = a((PointF) aVar.f20423f, (PointF) aVar.f20425h, Line.Direction.HORIZONTAL, f3);
            bVar2.f20438d = aVar.f20419b;
            bVar2.f20439e = aVar.f20421d;
            bVar2.f20440f = aVar.f20420c;
            bVar = aVar.f20418a;
        }
        bVar2.f20441g = bVar;
        return bVar2;
    }

    static List<a> a(a aVar, b bVar) {
        ArrayList arrayList = new ArrayList();
        a aVar2 = new a(aVar);
        a aVar3 = new a(aVar);
        if (bVar.f20437c == Line.Direction.HORIZONTAL) {
            aVar2.f20421d = bVar;
            aVar2.f20423f = bVar.f20435a;
            aVar2.f20425h = bVar.f20436b;
            aVar3.f20419b = bVar;
            aVar3.f20422e = bVar.f20435a;
            aVar3.f20424g = bVar.f20436b;
        } else {
            aVar2.f20420c = bVar;
            aVar2.f20424g = bVar.f20435a;
            aVar2.f20425h = bVar.f20436b;
            aVar3.f20418a = bVar;
            aVar3.f20422e = bVar.f20435a;
            aVar3.f20423f = bVar.f20436b;
        }
        arrayList.add(aVar2);
        arrayList.add(aVar3);
        return arrayList;
    }

    static List<a> a(a aVar, b bVar, b bVar2) {
        ArrayList arrayList = new ArrayList();
        CrossoverPointF crossoverPointF = new CrossoverPointF(bVar, bVar2);
        a(crossoverPointF, bVar, bVar2);
        a aVar2 = new a(aVar);
        aVar2.f20421d = bVar;
        aVar2.f20420c = bVar2;
        aVar2.f20424g = bVar2.f20435a;
        aVar2.f20425h = crossoverPointF;
        aVar2.f20423f = bVar.f20435a;
        arrayList.add(aVar2);
        a aVar3 = new a(aVar);
        aVar3.f20421d = bVar;
        aVar3.f20418a = bVar2;
        aVar3.f20422e = bVar2.f20435a;
        aVar3.f20425h = bVar.f20436b;
        aVar3.f20423f = crossoverPointF;
        arrayList.add(aVar3);
        a aVar4 = new a(aVar);
        aVar4.f20419b = bVar;
        aVar4.f20420c = bVar2;
        aVar4.f20422e = bVar.f20435a;
        aVar4.f20424g = crossoverPointF;
        aVar4.f20425h = bVar2.f20436b;
        arrayList.add(aVar4);
        a aVar5 = new a(aVar);
        aVar5.f20419b = bVar;
        aVar5.f20418a = bVar2;
        aVar5.f20422e = crossoverPointF;
        aVar5.f20424g = bVar.f20436b;
        aVar5.f20423f = bVar2.f20436b;
        arrayList.add(aVar5);
        return arrayList;
    }

    static void a(PointF pointF, PointF pointF2, PointF pointF3, Line.Direction direction, float f2) {
        float abs = Math.abs(pointF2.y - pointF3.y);
        float abs2 = Math.abs(pointF2.x - pointF3.x);
        float max = Math.max(pointF2.y, pointF3.y);
        float min = Math.min(pointF2.y, pointF3.y);
        float max2 = Math.max(pointF2.x, pointF3.x);
        float min2 = Math.min(pointF2.x, pointF3.x);
        if (direction == Line.Direction.HORIZONTAL) {
            pointF.x = min2 + (abs2 * f2);
            float f3 = f2 * abs;
            if (pointF2.y < pointF3.y) {
                pointF.y = min + f3;
            } else {
                pointF.y = max - f3;
            }
        } else {
            pointF.y = min + (abs * f2);
            float f4 = f2 * abs2;
            if (pointF2.x < pointF3.x) {
                pointF.x = min2 + f4;
            } else {
                pointF.x = max2 - f4;
            }
        }
    }

    static void a(CrossoverPointF crossoverPointF, b bVar, b bVar2) {
        crossoverPointF.f20416a = bVar;
        crossoverPointF.f20417b = bVar2;
        if (a(bVar, bVar2)) {
            crossoverPointF.set(0.0f, 0.0f);
        } else if (b(bVar) && c(bVar2)) {
            crossoverPointF.set(bVar2.f20435a.x, bVar.f20435a.y);
        } else if (c(bVar) && b(bVar2)) {
            crossoverPointF.set(bVar.f20435a.x, bVar2.f20435a.y);
        } else if (b(bVar) && !c(bVar2)) {
            float a2 = a(bVar2);
            float d2 = d(bVar2);
            crossoverPointF.y = bVar.f20435a.y;
            crossoverPointF.x = (crossoverPointF.y - d2) / a2;
        } else if (c(bVar) && !b(bVar2)) {
            float a3 = a(bVar2);
            float d3 = d(bVar2);
            crossoverPointF.x = bVar.f20435a.x;
            crossoverPointF.y = (a3 * crossoverPointF.x) + d3;
        } else if (b(bVar2) && !c(bVar)) {
            float a4 = a(bVar);
            float d4 = d(bVar);
            crossoverPointF.y = bVar2.f20435a.y;
            crossoverPointF.x = (crossoverPointF.y - d4) / a4;
        } else if (!c(bVar2) || b(bVar)) {
            float a5 = a(bVar);
            float d5 = d(bVar);
            crossoverPointF.x = (d(bVar2) - d5) / (a5 - a(bVar2));
            crossoverPointF.y = (crossoverPointF.x * a5) + d5;
        } else {
            float a6 = a(bVar);
            float d6 = d(bVar);
            crossoverPointF.x = bVar2.f20435a.x;
            crossoverPointF.y = (a6 * crossoverPointF.x) + d6;
        }
    }

    static boolean a(a aVar, float f2, float f3) {
        PointF pointF = f20458e;
        pointF.x = aVar.f20424g.x - aVar.f20422e.x;
        pointF.y = aVar.f20424g.y - aVar.f20422e.y;
        PointF pointF2 = f20459f;
        pointF2.x = f2 - aVar.f20422e.x;
        pointF2.y = f3 - aVar.f20422e.y;
        PointF pointF3 = f20460g;
        pointF3.x = aVar.f20425h.x - aVar.f20424g.x;
        pointF3.y = aVar.f20425h.y - aVar.f20424g.y;
        PointF pointF4 = f20461h;
        pointF4.x = f2 - aVar.f20424g.x;
        pointF4.y = f3 - aVar.f20424g.y;
        PointF pointF5 = f20462i;
        pointF5.x = aVar.f20423f.x - aVar.f20425h.x;
        pointF5.y = aVar.f20423f.y - aVar.f20425h.y;
        PointF pointF6 = f20463j;
        pointF6.x = f2 - aVar.f20425h.x;
        pointF6.y = f3 - aVar.f20425h.y;
        PointF pointF7 = f20464k;
        pointF7.x = aVar.f20422e.x - aVar.f20423f.x;
        pointF7.y = aVar.f20422e.y - aVar.f20423f.y;
        PointF pointF8 = f20465l;
        pointF8.x = f2 - aVar.f20423f.x;
        pointF8.y = f3 - aVar.f20423f.y;
        return b(pointF, pointF2) > 0.0f && b(pointF3, pointF4) > 0.0f && b(pointF5, pointF6) > 0.0f && b(pointF7, pointF8) > 0.0f;
    }

    static boolean a(b bVar, float f2, float f3, float f4) {
        CrossoverPointF crossoverPointF = bVar.f20435a;
        CrossoverPointF crossoverPointF2 = bVar.f20436b;
        if (bVar.f20437c == Line.Direction.VERTICAL) {
            PointF pointF = f20454a;
            pointF.x = crossoverPointF.x - f4;
            pointF.y = crossoverPointF.y;
            PointF pointF2 = f20455b;
            pointF2.x = crossoverPointF.x + f4;
            pointF2.y = crossoverPointF.y;
            PointF pointF3 = f20456c;
            pointF3.x = crossoverPointF2.x + f4;
            pointF3.y = crossoverPointF2.y;
            PointF pointF4 = f20457d;
            pointF4.x = crossoverPointF2.x - f4;
            pointF4.y = crossoverPointF2.y;
        } else {
            PointF pointF5 = f20454a;
            pointF5.x = crossoverPointF.x;
            pointF5.y = crossoverPointF.y - f4;
            PointF pointF6 = f20455b;
            pointF6.x = crossoverPointF2.x;
            pointF6.y = crossoverPointF2.y - f4;
            PointF pointF7 = f20456c;
            pointF7.x = crossoverPointF2.x;
            pointF7.y = crossoverPointF2.y + f4;
            PointF pointF8 = f20457d;
            pointF8.x = crossoverPointF.x;
            pointF8.y = crossoverPointF.y + f4;
        }
        PointF pointF9 = f20458e;
        PointF pointF10 = f20455b;
        float f5 = pointF10.x;
        PointF pointF11 = f20454a;
        pointF9.x = f5 - pointF11.x;
        pointF9.y = pointF10.y - pointF11.y;
        PointF pointF12 = f20459f;
        pointF12.x = f2 - pointF11.x;
        pointF12.y = f3 - pointF11.y;
        PointF pointF13 = f20460g;
        PointF pointF14 = f20456c;
        pointF13.x = pointF14.x - pointF10.x;
        pointF13.y = pointF14.y - pointF10.y;
        PointF pointF15 = f20461h;
        pointF15.x = f2 - pointF10.x;
        pointF15.y = f3 - pointF10.y;
        PointF pointF16 = f20462i;
        PointF pointF17 = f20457d;
        pointF16.x = pointF17.x - pointF14.x;
        pointF16.y = pointF17.y - pointF14.y;
        PointF pointF18 = f20463j;
        pointF18.x = f2 - pointF14.x;
        pointF18.y = f3 - pointF14.y;
        PointF pointF19 = f20464k;
        pointF19.x = pointF11.x - pointF17.x;
        pointF19.y = pointF11.y - pointF17.y;
        PointF pointF20 = f20465l;
        pointF20.x = f2 - pointF17.x;
        pointF20.y = f3 - pointF17.y;
        return b(pointF9, pointF12) > 0.0f && b(pointF13, pointF15) > 0.0f && b(pointF16, pointF18) > 0.0f && b(pointF19, pointF20) > 0.0f;
    }

    private static boolean a(b bVar, b bVar2) {
        return a(bVar) == a(bVar2);
    }

    private static float b(PointF pointF, PointF pointF2) {
        return (pointF.x * pointF2.y) - (pointF2.x * pointF.y);
    }

    private static boolean b(b bVar) {
        return bVar.f20435a.y == bVar.f20436b.y;
    }

    private static boolean c(b bVar) {
        return bVar.f20435a.x == bVar.f20436b.x;
    }

    private static float d(b bVar) {
        if (b(bVar)) {
            return bVar.f20435a.y;
        }
        if (c(bVar)) {
            return Float.POSITIVE_INFINITY;
        }
        return bVar.f20435a.y - (a(bVar) * bVar.f20435a.x);
    }
}
