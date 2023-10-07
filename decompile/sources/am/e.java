package am;

import al.b;
import an.g;
import android.content.Context;
import android.os.Build;
import androidx.work.NetworkType;
import androidx.work.j;
import ao.p;
import ap.a;

public class e extends c<b> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f250a = j.a("NetworkMeteredCtrlr");

    public e(Context context, a aVar) {
        super(g.a(context, aVar).c());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean b(b bVar) {
        if (Build.VERSION.SDK_INT >= 26) {
            return !bVar.a() || !bVar.c();
        }
        j.a().b(f250a, "Metered network constraint is not supported before API 26, only checking for connected state.", new Throwable[0]);
        return !bVar.a();
    }

    /* access modifiers changed from: package-private */
    public boolean a(p pVar) {
        return pVar.f5504j.a() == NetworkType.f5065e;
    }
}
