package jw;

import android.content.Context;
import com.xeagle.android.utils.file.IO.d;
import en.a;
import jw.a;

public abstract class c extends a {

    /* renamed from: b  reason: collision with root package name */
    a f29834b;

    /* renamed from: c  reason: collision with root package name */
    Context f29835c;

    public c(a aVar, Context context) {
        this.f29834b = aVar;
        this.f29835c = context;
    }

    /* access modifiers changed from: protected */
    public a.C0202a a() {
        return new d(this.f29835c);
    }

    public abstract void a(d dVar);

    /* access modifiers changed from: protected */
    public void a(a.C0202a aVar) {
        a((d) aVar);
    }
}
