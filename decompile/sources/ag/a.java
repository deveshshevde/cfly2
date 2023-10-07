package ag;

public final class a implements e {

    /* renamed from: a  reason: collision with root package name */
    private final String f90a;

    /* renamed from: b  reason: collision with root package name */
    private final Object[] f91b;

    public a(String str) {
        this(str, (Object[]) null);
    }

    public a(String str, Object[] objArr) {
        this.f90a = str;
        this.f91b = objArr;
    }

    private static void a(d dVar, int i2, Object obj) {
        long j2;
        int byteValue;
        double doubleValue;
        if (obj == null) {
            dVar.a(i2);
        } else if (obj instanceof byte[]) {
            dVar.a(i2, (byte[]) obj);
        } else {
            if (obj instanceof Float) {
                doubleValue = (double) ((Float) obj).floatValue();
            } else if (obj instanceof Double) {
                doubleValue = ((Double) obj).doubleValue();
            } else {
                if (obj instanceof Long) {
                    j2 = ((Long) obj).longValue();
                } else {
                    if (obj instanceof Integer) {
                        byteValue = ((Integer) obj).intValue();
                    } else if (obj instanceof Short) {
                        byteValue = ((Short) obj).shortValue();
                    } else if (obj instanceof Byte) {
                        byteValue = ((Byte) obj).byteValue();
                    } else if (obj instanceof String) {
                        dVar.a(i2, (String) obj);
                        return;
                    } else if (obj instanceof Boolean) {
                        j2 = ((Boolean) obj).booleanValue() ? 1 : 0;
                    } else {
                        throw new IllegalArgumentException("Cannot bind " + obj + " at index " + i2 + " Supported types: null, byte[], float, double, long, int, short, byte, string");
                    }
                    j2 = (long) byteValue;
                }
                dVar.a(i2, j2);
                return;
            }
            dVar.a(i2, doubleValue);
        }
    }

    public static void a(d dVar, Object[] objArr) {
        if (objArr != null) {
            int length = objArr.length;
            int i2 = 0;
            while (i2 < length) {
                Object obj = objArr[i2];
                i2++;
                a(dVar, i2, obj);
            }
        }
    }

    public void a(d dVar) {
        a(dVar, this.f91b);
    }

    public String b() {
        return this.f90a;
    }
}
