package androidx.core.app;

import android.app.Notification;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import androidx.core.app.h;
import androidx.core.graphics.drawable.IconCompat;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

class j {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f2903a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static Field f2904b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f2905c;

    /* renamed from: d  reason: collision with root package name */
    private static final Object f2906d = new Object();

    public static Bundle a(Notification.Builder builder, h.a aVar) {
        IconCompat a2 = aVar.a();
        builder.addAction(a2 != null ? a2.c() : 0, aVar.b(), aVar.c());
        Bundle bundle = new Bundle(aVar.d());
        if (aVar.f() != null) {
            bundle.putParcelableArray("android.support.remoteInputs", a(aVar.f()));
        }
        if (aVar.i() != null) {
            bundle.putParcelableArray("android.support.dataRemoteInputs", a(aVar.i()));
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.e());
        return bundle;
    }

    public static Bundle a(Notification notification) {
        String str;
        String str2;
        synchronized (f2903a) {
            if (f2905c) {
                return null;
            }
            try {
                if (f2904b == null) {
                    Field declaredField = Notification.class.getDeclaredField("extras");
                    if (!Bundle.class.isAssignableFrom(declaredField.getType())) {
                        Log.e("NotificationCompat", "Notification.extras field is not of type Bundle");
                        f2905c = true;
                        return null;
                    }
                    declaredField.setAccessible(true);
                    f2904b = declaredField;
                }
                Bundle bundle = (Bundle) f2904b.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    f2904b.set(notification, bundle);
                }
                return bundle;
            } catch (IllegalAccessException e2) {
                e = e2;
                str = "NotificationCompat";
                str2 = "Unable to access notification extras";
                Log.e(str, str2, e);
                f2905c = true;
                return null;
            } catch (NoSuchFieldException e3) {
                e = e3;
                str = "NotificationCompat";
                str2 = "Unable to access notification extras";
                Log.e(str, str2, e);
                f2905c = true;
                return null;
            }
        }
    }

    static Bundle a(h.a aVar) {
        Bundle bundle = new Bundle();
        IconCompat a2 = aVar.a();
        bundle.putInt("icon", a2 != null ? a2.c() : 0);
        bundle.putCharSequence("title", aVar.b());
        bundle.putParcelable("actionIntent", aVar.c());
        Bundle bundle2 = aVar.d() != null ? new Bundle(aVar.d()) : new Bundle();
        bundle2.putBoolean("android.support.allowGeneratedReplies", aVar.e());
        bundle.putBundle("extras", bundle2);
        bundle.putParcelableArray("remoteInputs", a(aVar.f()));
        bundle.putBoolean("showsUserInterface", aVar.j());
        bundle.putInt("semanticAction", aVar.g());
        return bundle;
    }

    private static Bundle a(m mVar) {
        Bundle bundle = new Bundle();
        bundle.putString("resultKey", mVar.a());
        bundle.putCharSequence("label", mVar.b());
        bundle.putCharSequenceArray("choices", mVar.c());
        bundle.putBoolean("allowFreeFormInput", mVar.e());
        bundle.putBundle("extras", mVar.g());
        Set<String> d2 = mVar.d();
        if (d2 != null && !d2.isEmpty()) {
            ArrayList arrayList = new ArrayList(d2.size());
            for (String add : d2) {
                arrayList.add(add);
            }
            bundle.putStringArrayList("allowedDataTypes", arrayList);
        }
        return bundle;
    }

    public static SparseArray<Bundle> a(List<Bundle> list) {
        int size = list.size();
        SparseArray<Bundle> sparseArray = null;
        for (int i2 = 0; i2 < size; i2++) {
            Bundle bundle = list.get(i2);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                sparseArray.put(i2, bundle);
            }
        }
        return sparseArray;
    }

    private static Bundle[] a(m[] mVarArr) {
        if (mVarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[mVarArr.length];
        for (int i2 = 0; i2 < mVarArr.length; i2++) {
            bundleArr[i2] = a(mVarArr[i2]);
        }
        return bundleArr;
    }
}
