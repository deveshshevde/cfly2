package am;

import al.b;
import an.g;
import android.content.Context;
import android.os.Build;
import androidx.work.NetworkType;
import androidx.work.j;
import ao.p;
import ap.a;

public class f extends c<b> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f251a = j.a("NetworkNotRoamingCtrlr");

    public f(Context context, a aVar) {
        super(g.a(context, aVar).c());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean b(b bVar) {
        if (Build.VERSION.SDK_INT >= 24) {
            return !bVar.a() || !bVar.d();
        }
        j.a().b(f251a, "Not-roaming network constraint is not supported before API 24, only checking for connected state.", new Throwable[0]);
        return !bVar.a();
    }

    /* access modifiers changed from: package-private */
    public boolean a(p pVar) {
        return pVar.f5504j.a() == NetworkType.f5064d;
    }
}
