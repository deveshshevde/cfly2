package com.google.android.exoplayer2.upstream;

import android.content.Context;
import com.google.android.exoplayer2.upstream.f;

public final class l implements f.a {

    /* renamed from: a  reason: collision with root package name */
    private final Context f17052a;

    /* renamed from: b  reason: collision with root package name */
    private final t f17053b;

    /* renamed from: c  reason: collision with root package name */
    private final f.a f17054c;

    public l(Context context, t tVar, f.a aVar) {
        this.f17052a = context.getApplicationContext();
        this.f17053b = tVar;
        this.f17054c = aVar;
    }

    public l(Context context, String str) {
        this(context, str, (t) null);
    }

    public l(Context context, String str, t tVar) {
        this(context, tVar, (f.a) new n(str, tVar));
    }

    /* renamed from: b */
    public k a() {
        k kVar = new k(this.f17052a, this.f17054c.a());
        t tVar = this.f17053b;
        if (tVar != null) {
            kVar.a(tVar);
        }
        return kVar;
    }
}
