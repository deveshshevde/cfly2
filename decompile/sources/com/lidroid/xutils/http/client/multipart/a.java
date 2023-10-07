package com.lidroid.xutils.http.client.multipart;

import ij.b;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final String f21088a;

    /* renamed from: b  reason: collision with root package name */
    private final e f21089b;

    /* renamed from: c  reason: collision with root package name */
    private final b f21090c;

    public a(String str, b bVar) {
        if (str == null) {
            throw new IllegalArgumentException("Name may not be null");
        } else if (bVar != null) {
            this.f21088a = str;
            this.f21090c = bVar;
            this.f21089b = new e();
            a(bVar);
            b(bVar);
            c(bVar);
        } else {
            throw new IllegalArgumentException("Body may not be null");
        }
    }

    public String a() {
        return this.f21088a;
    }

    /* access modifiers changed from: protected */
    public void a(b bVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("form-data; name=\"");
        sb.append(a());
        sb.append("\"");
        if (bVar.b() != null) {
            sb.append("; filename=\"");
            sb.append(bVar.b());
            sb.append("\"");
        }
        a("Content-Disposition", sb.toString());
    }

    public void a(String str, String str2) {
        if (str != null) {
            this.f21089b.a(new d(str, str2));
            return;
        }
        throw new IllegalArgumentException("Field name may not be null");
    }

    public b b() {
        return this.f21090c;
    }

    /* access modifiers changed from: protected */
    public void b(b bVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(bVar.a());
        if (bVar.c() != null) {
            sb.append("; charset=");
            sb.append(bVar.c());
        }
        a("Content-Type", sb.toString());
    }

    public e c() {
        return this.f21089b;
    }

    /* access modifiers changed from: protected */
    public void c(b bVar) {
        a("Content-Transfer-Encoding", bVar.d());
    }
}
