package org.apache.commons.math3.linear;

import java.io.Serializable;
import nj.c;
import org.apache.commons.math3.exception.NullArgumentException;

public class ArrayRealVector extends j implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private static final k f32698a = k.a();
    private static final long serialVersionUID = -1097961340710804027L;

    /* renamed from: b  reason: collision with root package name */
    private double[] f32699b;

    public ArrayRealVector() {
        this.f32699b = new double[0];
    }

    public ArrayRealVector(int i2) {
        this.f32699b = new double[i2];
    }

    public ArrayRealVector(ArrayRealVector arrayRealVector, boolean z2) {
        double[] dArr = arrayRealVector.f32699b;
        this.f32699b = z2 ? (double[]) dArr.clone() : dArr;
    }

    public ArrayRealVector(double[] dArr) {
        this.f32699b = (double[]) dArr.clone();
    }

    public ArrayRealVector(double[] dArr, boolean z2) {
        if (dArr != null) {
            this.f32699b = z2 ? (double[]) dArr.clone() : dArr;
            return;
        }
        throw new NullArgumentException();
    }

    public double a(int i2) {
        return this.f32699b[i2];
    }

    public ArrayRealVector a() {
        return new ArrayRealVector(this, true);
    }

    /* renamed from: a */
    public ArrayRealVector b(c cVar) {
        int i2 = 0;
        while (true) {
            double[] dArr = this.f32699b;
            if (i2 >= dArr.length) {
                return this;
            }
            dArr[i2] = cVar.a(dArr[i2]);
            i2++;
        }
    }

    public j a(double d2) {
        int i2 = 0;
        while (true) {
            double[] dArr = this.f32699b;
            if (i2 >= dArr.length) {
                return this;
            }
            dArr[i2] = dArr[i2] + d2;
            i2++;
        }
    }

    public j a(int i2, int i3) {
        ArrayRealVector arrayRealVector = new ArrayRealVector(i3);
        try {
            System.arraycopy(this.f32699b, i2, arrayRealVector.f32699b, 0, i3);
        } catch (IndexOutOfBoundsException unused) {
            b(i2);
            b((i2 + i3) - 1);
        }
        return arrayRealVector;
    }

    public void a(int i2, double d2) {
        try {
            this.f32699b[i2] = d2;
        } catch (IndexOutOfBoundsException unused) {
            b(i2);
        }
    }

    public double[] b() {
        return this.f32699b;
    }

    public int c() {
        return this.f32699b.length;
    }

    public boolean d() {
        for (double isNaN : this.f32699b) {
            if (Double.isNaN(isNaN)) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        if (this.f32699b.length != jVar.c()) {
            return false;
        }
        if (jVar.d()) {
            return d();
        }
        int i2 = 0;
        while (true) {
            double[] dArr = this.f32699b;
            if (i2 >= dArr.length) {
                return true;
            }
            if (dArr[i2] != jVar.a(i2)) {
                return false;
            }
            i2++;
        }
    }

    public int hashCode() {
        if (d()) {
            return 9;
        }
        return nl.c.a(this.f32699b);
    }

    public String toString() {
        return f32698a.a((j) this);
    }
}
