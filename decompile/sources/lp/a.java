package lp;

import fg.i;
import java.util.ArrayList;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.e;
import org.apache.commons.math3.linear.f;
import org.apache.commons.math3.linear.h;
import org.apache.commons.math3.linear.j;
import org.apache.commons.math3.linear.l;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public j f30965a;

    /* renamed from: b  reason: collision with root package name */
    public j f30966b;

    /* renamed from: c  reason: collision with root package name */
    public j f30967c;

    /* renamed from: d  reason: collision with root package name */
    public j f30968d;

    /* renamed from: e  reason: collision with root package name */
    public j f30969e;

    /* renamed from: f  reason: collision with root package name */
    public double[] f30970f;

    private h a(j jVar) {
        Array2DRowRealMatrix array2DRowRealMatrix = new Array2DRowRealMatrix(4, 4);
        array2DRowRealMatrix.a(0, 0, jVar.a(0));
        array2DRowRealMatrix.a(0, 1, jVar.a(3));
        array2DRowRealMatrix.a(0, 2, jVar.a(4));
        array2DRowRealMatrix.a(0, 3, jVar.a(6));
        array2DRowRealMatrix.a(1, 0, jVar.a(3));
        array2DRowRealMatrix.a(1, 1, jVar.a(1));
        array2DRowRealMatrix.a(1, 2, jVar.a(5));
        array2DRowRealMatrix.a(1, 3, jVar.a(7));
        array2DRowRealMatrix.a(2, 0, jVar.a(4));
        array2DRowRealMatrix.a(2, 1, jVar.a(5));
        array2DRowRealMatrix.a(2, 2, jVar.a(2));
        array2DRowRealMatrix.a(2, 3, jVar.a(8));
        array2DRowRealMatrix.a(3, 0, jVar.a(6));
        array2DRowRealMatrix.a(3, 1, jVar.a(7));
        array2DRowRealMatrix.a(3, 2, jVar.a(8));
        array2DRowRealMatrix.a(3, 3, -1.0d);
        return array2DRowRealMatrix;
    }

    private h a(j jVar, h hVar) {
        h a2 = f.a(4);
        Array2DRowRealMatrix array2DRowRealMatrix = new Array2DRowRealMatrix(1, 3);
        array2DRowRealMatrix.a(0, jVar);
        a2.a(array2DRowRealMatrix.a(), 3, 0);
        return a2.a(hVar).a(a2.b());
    }

    private j a(h hVar) {
        h a2 = hVar.a(0, 2, 0, 2);
        for (int i2 = 0; i2 < a2.d(); i2++) {
            for (int i3 = 0; i3 < a2.e(); i3++) {
                a2.b(i2, i3, -1.0d);
            }
        }
        return new l(a2).e().a().a(hVar.a(3).a(0, 3));
    }

    private j a(double[] dArr) {
        ArrayRealVector arrayRealVector = new ArrayRealVector(dArr.length);
        for (int i2 = 0; i2 < dArr.length; i2++) {
            arrayRealVector.a(i2, Math.sqrt(1.0d / dArr[i2]));
        }
        return arrayRealVector;
    }

    private j b(ArrayList<b> arrayList) {
        ArrayList<b> arrayList2 = arrayList;
        int size = arrayList.size();
        Array2DRowRealMatrix array2DRowRealMatrix = new Array2DRowRealMatrix(size, 9);
        int i2 = 0;
        while (i2 < array2DRowRealMatrix.d()) {
            double pow = Math.pow(arrayList2.get(i2).f30971a, 2.0d);
            double pow2 = Math.pow(arrayList2.get(i2).f30972b, 2.0d);
            double pow3 = Math.pow(arrayList2.get(i2).f30973c, 2.0d);
            int i3 = i2;
            double d2 = arrayList2.get(i2).f30971a * arrayList2.get(i2).f30972b * 2.0d;
            double d3 = arrayList2.get(i3).f30971a * arrayList2.get(i3).f30973c * 2.0d;
            double d4 = arrayList2.get(i3).f30972b * arrayList2.get(i3).f30973c * 2.0d;
            double d5 = arrayList2.get(i3).f30971a * 2.0d;
            array2DRowRealMatrix.a(i3, 0, pow);
            array2DRowRealMatrix.a(i3, 1, pow2);
            array2DRowRealMatrix.a(i3, 2, pow3);
            array2DRowRealMatrix.a(i3, 3, d2);
            array2DRowRealMatrix.a(i3, 4, d3);
            array2DRowRealMatrix.a(i3, 5, d4);
            array2DRowRealMatrix.a(i3, 6, d5);
            array2DRowRealMatrix.a(i3, 7, arrayList2.get(i3).f30972b * 2.0d);
            array2DRowRealMatrix.a(i3, 8, arrayList2.get(i3).f30973c * 2.0d);
            i2 = i3 + 1;
            size = size;
            arrayList2 = arrayList;
        }
        h a2 = array2DRowRealMatrix.b().a((h) array2DRowRealMatrix);
        ArrayRealVector arrayRealVector = new ArrayRealVector(size);
        arrayRealVector.a(1.0d);
        return new l(a2).e().a().a(array2DRowRealMatrix.b().a((j) arrayRealVector));
    }

    public double a() {
        double a2 = this.f30967c.a(2);
        double a3 = this.f30968d.a(0);
        double a4 = this.f30969e.a(1);
        return Math.sqrt(((a2 * a2) + (a3 * a3)) + (a4 * a4)) / Math.sqrt(3.0d);
    }

    public void a(ArrayList<b> arrayList) {
        h a2 = a(b(arrayList));
        j a3 = a(a2);
        this.f30965a = a3;
        h a4 = a(a3, a2);
        h a5 = a4.a(0, 2, 0, 2);
        double d2 = -a4.b(3, 3);
        for (int i2 = 0; i2 < a5.d(); i2++) {
            for (int i3 = 0; i3 < a5.d(); i3++) {
                a5.a(i2, i3, a5.b(i2, i3) / d2);
            }
        }
        e eVar = new e(a5, i.f27244a);
        this.f30970f = eVar.a();
        this.f30967c = eVar.a(0);
        this.f30968d = eVar.a(1);
        this.f30969e = eVar.a(2);
        this.f30966b = a(this.f30970f);
    }
}
