package am;

import al.b;
import android.content.Context;
import android.os.Build;
import androidx.work.NetworkType;
import ao.p;
import ap.a;

public class g extends c<b> {
    public g(Context context, a aVar) {
        super(an.g.a(context, aVar).c());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean b(b bVar) {
        return !bVar.a() || bVar.c();
    }

    /* access modifiers changed from: package-private */
    public boolean a(p pVar) {
        return pVar.f5504j.a() == NetworkType.f5063c || (Build.VERSION.SDK_INT >= 30 && pVar.f5504j.a() == NetworkType.f5066f);
    }
}
