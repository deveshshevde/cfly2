package jw;

import com.flypro.core.drone.variables.ListenerData;
import com.xeagle.android.utils.file.IO.c;
import en.a;
import java.util.List;
import jw.a;

public abstract class b extends a {

    /* renamed from: a  reason: collision with root package name */
    private a f29833a;

    public b(a aVar) {
        this.f29833a = aVar;
    }

    /* access modifiers changed from: protected */
    public a.C0202a a() {
        return new c(this.f29833a);
    }

    public abstract void a(List<ListenerData> list);

    /* access modifiers changed from: protected */
    public void a(a.C0202a aVar) {
        a(((c) aVar).a());
    }
}
