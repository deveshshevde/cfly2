package nl;

import java.util.Arrays;
import org.apache.commons.math3.exception.NullArgumentException;

public final class c {
    public static int a(double d2) {
        return new Double(d2).hashCode();
    }

    public static int a(double[] dArr) {
        return Arrays.hashCode(dArr);
    }

    public static void a(Object obj) throws NullArgumentException {
        if (obj == null) {
            throw new NullArgumentException();
        }
    }
}
