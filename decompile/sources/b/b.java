package b;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResult;
import b.a;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class b {

    public static final class a extends a<String[], Map<String, Boolean>> {
        static Intent a(String[] strArr) {
            return new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr);
        }

        public Intent a(Context context, String[] strArr) {
            return a(strArr);
        }

        public a.C0047a<Map<String, Boolean>> b(Context context, String[] strArr) {
            if (strArr == null || strArr.length == 0) {
                return new a.C0047a<>(Collections.emptyMap());
            }
            j.a aVar = new j.a();
            boolean z2 = true;
            for (String str : strArr) {
                boolean z3 = androidx.core.content.b.b(context, str) == 0;
                aVar.put(str, Boolean.valueOf(z3));
                if (!z3) {
                    z2 = false;
                }
            }
            if (z2) {
                return new a.C0047a<>(aVar);
            }
            return null;
        }

        /* renamed from: b */
        public Map<String, Boolean> a(int i2, Intent intent) {
            if (i2 != -1) {
                return Collections.emptyMap();
            }
            if (intent == null) {
                return Collections.emptyMap();
            }
            String[] stringArrayExtra = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
            int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
            if (intArrayExtra == null || stringArrayExtra == null) {
                return Collections.emptyMap();
            }
            HashMap hashMap = new HashMap();
            int length = stringArrayExtra.length;
            for (int i3 = 0; i3 < length; i3++) {
                hashMap.put(stringArrayExtra[i3], Boolean.valueOf(intArrayExtra[i3] == 0));
            }
            return hashMap;
        }
    }

    /* renamed from: b.b$b  reason: collision with other inner class name */
    public static final class C0048b extends a<Intent, ActivityResult> {
        public Intent a(Context context, Intent intent) {
            return intent;
        }

        /* renamed from: b */
        public ActivityResult a(int i2, Intent intent) {
            return new ActivityResult(i2, intent);
        }
    }
}
