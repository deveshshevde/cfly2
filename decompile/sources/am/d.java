package am;

import al.b;
import an.g;
import android.content.Context;
import android.os.Build;
import androidx.work.NetworkType;
import ao.p;
import ap.a;

public class d extends c<b> {
    public d(Context context, a aVar) {
        super(g.a(context, aVar).c());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean b(b bVar) {
        return Build.VERSION.SDK_INT >= 26 ? !bVar.a() || !bVar.b() : !bVar.a();
    }

    /* access modifiers changed from: package-private */
    public boolean a(p pVar) {
        return pVar.f5504j.a() == NetworkType.f5062b;
    }
}
