package la;

import ci.a;
import ci.b;
import com.cfly.uav_pro.R;
import kotlin.jvm.internal.h;

public final class c extends a<lc.a, b> {
    public c() {
        super((int) R.layout.item_sd_file);
    }

    public final void a() {
        getData().clear();
        notifyDataSetChanged();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void convert(b bVar, lc.a aVar) {
        h.d(bVar, "helper");
        h.d(aVar, "item");
        bVar.a((int) R.id.tvFileName, (CharSequence) aVar.c());
    }
}
