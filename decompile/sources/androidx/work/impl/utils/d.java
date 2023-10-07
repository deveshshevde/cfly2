package androidx.work.impl.utils;

import android.content.ComponentName;
import android.content.Context;
import androidx.work.j;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5357a = j.a("PackageManagerHelper");

    public static void a(Context context, Class<?> cls, boolean z2) {
        String str = "enabled";
        try {
            context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, cls.getName()), z2 ? 1 : 2, 1);
            j a2 = j.a();
            String str2 = f5357a;
            Object[] objArr = new Object[2];
            objArr[0] = cls.getName();
            objArr[1] = z2 ? str : "disabled";
            a2.b(str2, String.format("%s %s", objArr), new Throwable[0]);
        } catch (Exception e2) {
            j a3 = j.a();
            String str3 = f5357a;
            Object[] objArr2 = new Object[2];
            objArr2[0] = cls.getName();
            if (!z2) {
                str = "disabled";
            }
            objArr2[1] = str;
            a3.b(str3, String.format("%s could not be %s", objArr2), e2);
        }
    }
}
