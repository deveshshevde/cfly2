package androidx.lifecycle;

import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import androidx.savedstate.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class x {

    /* renamed from: e  reason: collision with root package name */
    private static final Class[] f3647e;

    /* renamed from: a  reason: collision with root package name */
    final Map<String, Object> f3648a;

    /* renamed from: b  reason: collision with root package name */
    final Map<String, a.b> f3649b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, Object<?>> f3650c;

    /* renamed from: d  reason: collision with root package name */
    private final a.b f3651d;

    static {
        Class[] clsArr = new Class[29];
        clsArr[0] = Boolean.TYPE;
        clsArr[1] = boolean[].class;
        clsArr[2] = Double.TYPE;
        clsArr[3] = double[].class;
        clsArr[4] = Integer.TYPE;
        clsArr[5] = int[].class;
        clsArr[6] = Long.TYPE;
        clsArr[7] = long[].class;
        clsArr[8] = String.class;
        clsArr[9] = String[].class;
        clsArr[10] = Binder.class;
        clsArr[11] = Bundle.class;
        clsArr[12] = Byte.TYPE;
        clsArr[13] = byte[].class;
        clsArr[14] = Character.TYPE;
        clsArr[15] = char[].class;
        clsArr[16] = CharSequence.class;
        clsArr[17] = CharSequence[].class;
        clsArr[18] = ArrayList.class;
        clsArr[19] = Float.TYPE;
        clsArr[20] = float[].class;
        clsArr[21] = Parcelable.class;
        clsArr[22] = Parcelable[].class;
        clsArr[23] = Serializable.class;
        clsArr[24] = Short.TYPE;
        clsArr[25] = short[].class;
        clsArr[26] = SparseArray.class;
        clsArr[27] = Build.VERSION.SDK_INT >= 21 ? Size.class : Integer.TYPE;
        clsArr[28] = Build.VERSION.SDK_INT >= 21 ? SizeF.class : Integer.TYPE;
        f3647e = clsArr;
    }

    public x() {
        this.f3649b = new HashMap();
        this.f3650c = new HashMap();
        this.f3651d = new a.b() {
            public Bundle a() {
                for (Map.Entry entry : new HashMap(x.this.f3649b).entrySet()) {
                    x.this.a((String) entry.getKey(), ((a.b) entry.getValue()).a());
                }
                Set<String> keySet = x.this.f3648a.keySet();
                ArrayList arrayList = new ArrayList(keySet.size());
                ArrayList arrayList2 = new ArrayList(arrayList.size());
                for (String next : keySet) {
                    arrayList.add(next);
                    arrayList2.add(x.this.f3648a.get(next));
                }
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("keys", arrayList);
                bundle.putParcelableArrayList("values", arrayList2);
                return bundle;
            }
        };
        this.f3648a = new HashMap();
    }

    public x(Map<String, Object> map) {
        this.f3649b = new HashMap();
        this.f3650c = new HashMap();
        this.f3651d = new a.b() {
            public Bundle a() {
                for (Map.Entry entry : new HashMap(x.this.f3649b).entrySet()) {
                    x.this.a((String) entry.getKey(), ((a.b) entry.getValue()).a());
                }
                Set<String> keySet = x.this.f3648a.keySet();
                ArrayList arrayList = new ArrayList(keySet.size());
                ArrayList arrayList2 = new ArrayList(arrayList.size());
                for (String next : keySet) {
                    arrayList.add(next);
                    arrayList2.add(x.this.f3648a.get(next));
                }
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("keys", arrayList);
                bundle.putParcelableArrayList("values", arrayList2);
                return bundle;
            }
        };
        this.f3648a = new HashMap(map);
    }

    static x a(Bundle bundle, Bundle bundle2) {
        if (bundle == null && bundle2 == null) {
            return new x();
        }
        HashMap hashMap = new HashMap();
        if (bundle2 != null) {
            for (String str : bundle2.keySet()) {
                hashMap.put(str, bundle2.get(str));
            }
        }
        if (bundle == null) {
            return new x(hashMap);
        }
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("keys");
        ArrayList parcelableArrayList2 = bundle.getParcelableArrayList("values");
        if (parcelableArrayList == null || parcelableArrayList2 == null || parcelableArrayList.size() != parcelableArrayList2.size()) {
            throw new IllegalStateException("Invalid bundle passed as restored state");
        }
        for (int i2 = 0; i2 < parcelableArrayList.size(); i2++) {
            hashMap.put((String) parcelableArrayList.get(i2), parcelableArrayList2.get(i2));
        }
        return new x(hashMap);
    }

    private static void a(Object obj) {
        if (obj != null) {
            Class[] clsArr = f3647e;
            int length = clsArr.length;
            int i2 = 0;
            while (i2 < length) {
                if (!clsArr[i2].isInstance(obj)) {
                    i2++;
                } else {
                    return;
                }
            }
            throw new IllegalArgumentException("Can't put value with type " + obj.getClass() + " into saved state");
        }
    }

    /* access modifiers changed from: package-private */
    public a.b a() {
        return this.f3651d;
    }

    public <T> void a(String str, T t2) {
        a(t2);
        s sVar = (s) this.f3650c.get(str);
        if (sVar != null) {
            sVar.b(t2);
        } else {
            this.f3648a.put(str, t2);
        }
    }
}
