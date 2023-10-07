package iy;

import com.permissionx.guolindev.b;
import java.util.ArrayList;
import java.util.List;

public class g extends a {
    g(f fVar) {
        super(fVar);
    }

    public /* bridge */ /* synthetic */ c a() {
        return super.a();
    }

    public void a(List<String> list) {
        this.f29395b.a((b) this);
    }

    public /* bridge */ /* synthetic */ d b() {
        return super.b();
    }

    public /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    public void d() {
        if (this.f29395b.f29409f) {
            boolean a2 = b.a(this.f29395b.f29404a, "android.permission.ACCESS_FINE_LOCATION");
            boolean a3 = b.a(this.f29395b.f29404a, "android.permission.ACCESS_COARSE_LOCATION");
            if (a2 || a3) {
                if (this.f29395b.f29420q == null && this.f29395b.f29421r == null) {
                    a((List<String>) null);
                    return;
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add("android.permission.ACCESS_BACKGROUND_LOCATION");
                if (this.f29395b.f29421r != null) {
                    this.f29395b.f29421r.onExplainReason(this.f29396c, arrayList, true);
                    return;
                } else {
                    this.f29395b.f29420q.a(this.f29396c, arrayList);
                    return;
                }
            }
        }
        c();
    }
}
