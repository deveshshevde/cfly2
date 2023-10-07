package com.danikula.videocache;

import da.a;
import db.b;
import java.io.File;

class c {

    /* renamed from: a  reason: collision with root package name */
    public final File f11027a;

    /* renamed from: b  reason: collision with root package name */
    public final da.c f11028b;

    /* renamed from: c  reason: collision with root package name */
    public final a f11029c;

    /* renamed from: d  reason: collision with root package name */
    public final dc.c f11030d;

    /* renamed from: e  reason: collision with root package name */
    public final b f11031e;

    c(File file, da.c cVar, a aVar, dc.c cVar2, b bVar) {
        this.f11027a = file;
        this.f11028b = cVar;
        this.f11029c = aVar;
        this.f11030d = cVar2;
        this.f11031e = bVar;
    }

    /* access modifiers changed from: package-private */
    public File a(String str) {
        return new File(this.f11027a, this.f11028b.a(str));
    }
}
