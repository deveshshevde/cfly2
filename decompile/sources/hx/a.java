package hx;

import android.app.Activity;
import androidx.core.content.d;
import java.util.ArrayList;
import java.util.List;

public class a {

    /* renamed from: hx.a$a  reason: collision with other inner class name */
    public interface C0099a {
        void a();

        void b();

        void c();
    }

    private static void a(Activity activity, int i2, String... strArr) {
        androidx.core.app.a.a(activity, strArr, i2);
    }

    private static void a(Activity activity, C0099a aVar, String[] strArr, List<Integer> list, int i2) {
        if (androidx.core.app.a.a(activity, strArr[list.get(i2).intValue()])) {
            aVar.b();
        } else if (i2 < list.size() - 1) {
            a(activity, aVar, strArr, list, i2 + 1);
        } else {
            aVar.c();
        }
    }

    public static void a(Activity activity, String[] strArr, int[] iArr, C0099a aVar) {
        int length = iArr.length;
        ArrayList arrayList = new ArrayList();
        if (length > 0) {
            for (int i2 = 0; i2 < length; i2++) {
                if (iArr[i2] != 0) {
                    arrayList.add(Integer.valueOf(i2));
                }
            }
        }
        if (arrayList.size() == 0) {
            aVar.a();
        } else {
            a(activity, aVar, strArr, arrayList, 0);
        }
    }

    public static boolean a(Activity activity, String... strArr) {
        ArrayList arrayList = new ArrayList();
        boolean z2 = true;
        for (String str : strArr) {
            if (d.a(activity, str) != 0) {
                arrayList.add(str);
                z2 = false;
            }
        }
        if (!z2) {
            a(activity, 12, (String[]) arrayList.toArray(new String[arrayList.size()]));
        }
        return z2;
    }
}
