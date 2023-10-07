package u;

import android.os.Build;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.ArrayList;
import java.util.List;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private final Object f34560a;

    static class a extends AccessibilityNodeProvider {

        /* renamed from: a  reason: collision with root package name */
        final d f34561a;

        a(d dVar) {
            this.f34561a = dVar;
        }

        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i2) {
            c a2 = this.f34561a.a(i2);
            if (a2 == null) {
                return null;
            }
            return a2.a();
        }

        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i2) {
            List<c> a2 = this.f34561a.a(str, i2);
            if (a2 == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int size = a2.size();
            for (int i3 = 0; i3 < size; i3++) {
                arrayList.add(a2.get(i3).a());
            }
            return arrayList;
        }

        public boolean performAction(int i2, int i3, Bundle bundle) {
            return this.f34561a.a(i2, i3, bundle);
        }
    }

    static class b extends a {
        b(d dVar) {
            super(dVar);
        }

        public AccessibilityNodeInfo findFocus(int i2) {
            c b2 = this.f34561a.b(i2);
            if (b2 == null) {
                return null;
            }
            return b2.a();
        }
    }

    static class c extends b {
        c(d dVar) {
            super(dVar);
        }

        public void addExtraDataToAccessibilityNodeInfo(int i2, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
            this.f34561a.a(i2, c.a(accessibilityNodeInfo), str, bundle);
        }
    }

    public d() {
        this.f34560a = Build.VERSION.SDK_INT >= 26 ? new c(this) : Build.VERSION.SDK_INT >= 19 ? new b(this) : Build.VERSION.SDK_INT >= 16 ? new a(this) : null;
    }

    public d(Object obj) {
        this.f34560a = obj;
    }

    public Object a() {
        return this.f34560a;
    }

    public List<c> a(String str, int i2) {
        return null;
    }

    public c a(int i2) {
        return null;
    }

    public void a(int i2, c cVar, String str, Bundle bundle) {
    }

    public boolean a(int i2, int i3, Bundle bundle) {
        return false;
    }

    public c b(int i2) {
        return null;
    }
}
