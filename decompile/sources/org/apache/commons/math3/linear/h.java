package org.apache.commons.math3.linear;

import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.ZeroException;

public interface h extends b {
    h a(int i2, int i3, int i4, int i5);

    h a(h hVar);

    j a(int i2);

    j a(j jVar);

    void a(int i2, int i3, double d2);

    void a(int i2, j jVar);

    void a(double[][] dArr, int i2, int i3) throws ZeroException, OutOfRangeException, DimensionMismatchException, NullArgumentException;

    double[][] a();

    double b(int i2, int i3);

    h b();

    void b(int i2, int i3, double d2);
}
