package com.android.volley.toolbox;

import com.android.volley.Request;
import com.android.volley.g;
import com.android.volley.i;
import java.io.UnsupportedEncodingException;

public class k extends Request<String> {

    /* renamed from: a  reason: collision with root package name */
    private final i.b<String> f10008a;

    public k(int i2, String str, i.b<String> bVar, i.a aVar) {
        super(i2, str, aVar);
        this.f10008a = bVar;
    }

    /* access modifiers changed from: protected */
    public i<String> a(g gVar) {
        String str;
        try {
            str = new String(gVar.f9918b, e.a(gVar.f9919c));
        } catch (UnsupportedEncodingException unused) {
            str = new String(gVar.f9918b);
        }
        return i.a(str, e.a(gVar));
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void a(String str) {
        this.f10008a.a(str);
    }
}
