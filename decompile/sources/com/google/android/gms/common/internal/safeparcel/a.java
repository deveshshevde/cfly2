package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public class a {
    public static int a(Parcel parcel) {
        return b(parcel, 20293);
    }

    public static void a(Parcel parcel, int i2) {
        c(parcel, i2);
    }

    public static void a(Parcel parcel, int i2, byte b2) {
        b(parcel, i2, 4);
        parcel.writeInt(b2);
    }

    public static void a(Parcel parcel, int i2, double d2) {
        b(parcel, i2, 8);
        parcel.writeDouble(d2);
    }

    public static void a(Parcel parcel, int i2, float f2) {
        b(parcel, i2, 4);
        parcel.writeFloat(f2);
    }

    public static void a(Parcel parcel, int i2, int i3) {
        b(parcel, i2, 4);
        parcel.writeInt(i3);
    }

    public static void a(Parcel parcel, int i2, long j2) {
        b(parcel, i2, 8);
        parcel.writeLong(j2);
    }

    public static void a(Parcel parcel, int i2, Bundle bundle, boolean z2) {
        if (bundle != null) {
            int b2 = b(parcel, i2);
            parcel.writeBundle(bundle);
            c(parcel, b2);
        } else if (z2) {
            b(parcel, i2, 0);
        }
    }

    public static void a(Parcel parcel, int i2, IBinder iBinder, boolean z2) {
        if (iBinder != null) {
            int b2 = b(parcel, i2);
            parcel.writeStrongBinder(iBinder);
            c(parcel, b2);
        } else if (z2) {
            b(parcel, i2, 0);
        }
    }

    public static void a(Parcel parcel, int i2, Parcel parcel2, boolean z2) {
        if (parcel2 != null) {
            int b2 = b(parcel, i2);
            parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            c(parcel, b2);
        } else if (z2) {
            b(parcel, i2, 0);
        }
    }

    public static void a(Parcel parcel, int i2, Parcelable parcelable, int i3, boolean z2) {
        if (parcelable != null) {
            int b2 = b(parcel, i2);
            parcelable.writeToParcel(parcel, i3);
            c(parcel, b2);
        } else if (z2) {
            b(parcel, i2, 0);
        }
    }

    public static void a(Parcel parcel, int i2, Float f2, boolean z2) {
        if (f2 != null) {
            b(parcel, i2, 4);
            parcel.writeFloat(f2.floatValue());
        } else if (z2) {
            b(parcel, i2, 0);
        }
    }

    public static void a(Parcel parcel, int i2, Integer num, boolean z2) {
        if (num != null) {
            b(parcel, i2, 4);
            parcel.writeInt(num.intValue());
        } else if (z2) {
            b(parcel, i2, 0);
        }
    }

    public static void a(Parcel parcel, int i2, String str, boolean z2) {
        if (str != null) {
            int b2 = b(parcel, i2);
            parcel.writeString(str);
            c(parcel, b2);
        } else if (z2) {
            b(parcel, i2, 0);
        }
    }

    public static void a(Parcel parcel, int i2, List list, boolean z2) {
        if (list != null) {
            int b2 = b(parcel, i2);
            parcel.writeList(list);
            c(parcel, b2);
        } else if (z2) {
            b(parcel, i2, 0);
        }
    }

    public static void a(Parcel parcel, int i2, short s2) {
        b(parcel, i2, 4);
        parcel.writeInt(s2);
    }

    public static void a(Parcel parcel, int i2, boolean z2) {
        b(parcel, i2, 4);
        parcel.writeInt(z2 ? 1 : 0);
    }

    public static void a(Parcel parcel, int i2, byte[] bArr, boolean z2) {
        if (bArr != null) {
            int b2 = b(parcel, i2);
            parcel.writeByteArray(bArr);
            c(parcel, b2);
        } else if (z2) {
            b(parcel, i2, 0);
        }
    }

    public static void a(Parcel parcel, int i2, int[] iArr, boolean z2) {
        if (iArr != null) {
            int b2 = b(parcel, i2);
            parcel.writeIntArray(iArr);
            c(parcel, b2);
        } else if (z2) {
            b(parcel, i2, 0);
        }
    }

    public static <T extends Parcelable> void a(Parcel parcel, int i2, T[] tArr, int i3, boolean z2) {
        if (tArr != null) {
            int b2 = b(parcel, i2);
            parcel.writeInt(r7);
            for (T t2 : tArr) {
                if (t2 == null) {
                    parcel.writeInt(0);
                } else {
                    a(parcel, t2, i3);
                }
            }
            c(parcel, b2);
        } else if (z2) {
            b(parcel, i2, 0);
        }
    }

    public static void a(Parcel parcel, int i2, String[] strArr, boolean z2) {
        if (strArr != null) {
            int b2 = b(parcel, i2);
            parcel.writeStringArray(strArr);
            c(parcel, b2);
        } else if (z2) {
            b(parcel, i2, 0);
        }
    }

    private static <T extends Parcelable> void a(Parcel parcel, T t2, int i2) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        t2.writeToParcel(parcel, i2);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }

    private static int b(Parcel parcel, int i2) {
        parcel.writeInt(i2 | -65536);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    private static void b(Parcel parcel, int i2, int i3) {
        parcel.writeInt(i2 | (i3 << 16));
    }

    public static void b(Parcel parcel, int i2, List<String> list, boolean z2) {
        if (list != null) {
            int b2 = b(parcel, i2);
            parcel.writeStringList(list);
            c(parcel, b2);
        } else if (z2) {
            b(parcel, i2, 0);
        }
    }

    private static void c(Parcel parcel, int i2) {
        int dataPosition = parcel.dataPosition();
        parcel.setDataPosition(i2 - 4);
        parcel.writeInt(dataPosition - i2);
        parcel.setDataPosition(dataPosition);
    }

    public static <T extends Parcelable> void c(Parcel parcel, int i2, List<T> list, boolean z2) {
        if (list != null) {
            int b2 = b(parcel, i2);
            int size = list.size();
            parcel.writeInt(size);
            for (int i3 = 0; i3 < size; i3++) {
                Parcelable parcelable = (Parcelable) list.get(i3);
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    a(parcel, parcelable, 0);
                }
            }
            c(parcel, b2);
        } else if (z2) {
            b(parcel, i2, 0);
        }
    }
}
