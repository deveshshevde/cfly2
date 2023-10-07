package iy;

import android.content.Intent;
import android.util.Log;
import androidx.fragment.app.Fragment;
import com.permissionx.guolindev.b;
import java.util.ArrayList;
import java.util.Set;

public class e extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private f f29402a;

    /* renamed from: b  reason: collision with root package name */
    private b f29403b;

    private void a() {
        if (b()) {
            if (b.a(getContext(), "android.permission.ACCESS_BACKGROUND_LOCATION")) {
                this.f29402a.f29414k.add("android.permission.ACCESS_BACKGROUND_LOCATION");
                this.f29402a.f29415l.remove("android.permission.ACCESS_BACKGROUND_LOCATION");
                this.f29402a.f29416m.remove("android.permission.ACCESS_BACKGROUND_LOCATION");
            } else {
                boolean z2 = true;
                boolean shouldShowRequestPermissionRationale = shouldShowRequestPermissionRationale("android.permission.ACCESS_BACKGROUND_LOCATION");
                if (!(this.f29402a.f29420q == null && this.f29402a.f29421r == null) && shouldShowRequestPermissionRationale) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add("android.permission.ACCESS_BACKGROUND_LOCATION");
                    if (this.f29402a.f29421r != null) {
                        this.f29402a.f29421r.onExplainReason(this.f29403b.a(), arrayList, false);
                    } else {
                        this.f29402a.f29420q.a(this.f29403b.a(), arrayList);
                    }
                } else {
                    if (this.f29402a.f29422s != null && !shouldShowRequestPermissionRationale) {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add("android.permission.ACCESS_BACKGROUND_LOCATION");
                        this.f29402a.f29422s.onForwardToSettings(this.f29403b.b(), arrayList2);
                    }
                    if (!z2 && this.f29402a.f29411h) {
                        return;
                    }
                }
                z2 = false;
                return;
            }
            this.f29403b.c();
        }
    }

    private void a(String[] strArr, int[] iArr) {
        Set<String> set;
        if (b()) {
            this.f29402a.f29414k.clear();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i2 = 0; i2 < strArr.length; i2++) {
                String str = strArr[i2];
                if (iArr[i2] == 0) {
                    this.f29402a.f29414k.add(str);
                    this.f29402a.f29415l.remove(str);
                    set = this.f29402a.f29416m;
                } else if (shouldShowRequestPermissionRationale(str)) {
                    arrayList.add(strArr[i2]);
                    this.f29402a.f29415l.add(str);
                } else {
                    arrayList2.add(strArr[i2]);
                    this.f29402a.f29416m.add(str);
                    set = this.f29402a.f29415l;
                }
                set.remove(str);
            }
            ArrayList<String> arrayList3 = new ArrayList<>();
            arrayList3.addAll(this.f29402a.f29415l);
            arrayList3.addAll(this.f29402a.f29416m);
            for (String str2 : arrayList3) {
                if (b.a(getContext(), str2)) {
                    this.f29402a.f29415l.remove(str2);
                    this.f29402a.f29414k.add(str2);
                }
            }
            boolean z2 = true;
            if (this.f29402a.f29414k.size() == this.f29402a.f29407d.size()) {
                this.f29403b.c();
                return;
            }
            if (!(this.f29402a.f29420q == null && this.f29402a.f29421r == null) && !arrayList.isEmpty()) {
                if (this.f29402a.f29421r != null) {
                    this.f29402a.f29421r.onExplainReason(this.f29403b.a(), new ArrayList(this.f29402a.f29415l), false);
                } else {
                    this.f29402a.f29420q.a(this.f29403b.a(), new ArrayList(this.f29402a.f29415l));
                }
                this.f29402a.f29417n.addAll(arrayList2);
            } else {
                if (this.f29402a.f29422s != null && (!arrayList2.isEmpty() || !this.f29402a.f29417n.isEmpty())) {
                    this.f29402a.f29417n.clear();
                    this.f29402a.f29422s.onForwardToSettings(this.f29403b.b(), new ArrayList(this.f29402a.f29416m));
                }
                if (z2 || !this.f29402a.f29411h) {
                    this.f29403b.c();
                }
                this.f29402a.f29411h = false;
            }
            z2 = false;
            this.f29403b.c();
            this.f29402a.f29411h = false;
        }
    }

    private boolean b() {
        if (this.f29402a != null && this.f29403b != null) {
            return true;
        }
        Log.w("PermissionX", "PermissionBuilder and ChainTask should not be null at this time, so we can do nothing in this case.");
        return false;
    }

    /* access modifiers changed from: package-private */
    public void a(f fVar, b bVar) {
        this.f29402a = fVar;
        this.f29403b = bVar;
        requestPermissions(new String[]{"android.permission.ACCESS_BACKGROUND_LOCATION"}, 2);
    }

    /* access modifiers changed from: package-private */
    public void a(f fVar, Set<String> set, b bVar) {
        this.f29402a = fVar;
        this.f29403b = bVar;
        requestPermissions((String[]) set.toArray(new String[0]), 1);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 2 && b()) {
            this.f29403b.a(new ArrayList(this.f29402a.f29418o));
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (b() && this.f29402a.f29406c != null && this.f29402a.f29406c.isShowing()) {
            this.f29402a.f29406c.dismiss();
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 == 1) {
            a(strArr, iArr);
        } else if (i2 == 2) {
            a();
        }
    }
}
