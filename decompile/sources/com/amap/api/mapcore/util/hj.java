package com.amap.api.mapcore.util;

import android.content.Context;

public final class hj {

    /* renamed from: a  reason: collision with root package name */
    private Context f9135a;

    /* renamed from: b  reason: collision with root package name */
    private ff f9136b;

    /* renamed from: c  reason: collision with root package name */
    private String f9137c;

    public hj(Context context, ff ffVar, String str) {
        this.f9135a = context.getApplicationContext();
        this.f9136b = ffVar;
        this.f9137c = str;
    }

    private static String a(Context context, ff ffVar, String str) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("\"sdkversion\":\"");
            sb.append(ffVar.c());
            sb.append("\",\"product\":\"");
            sb.append(ffVar.a());
            sb.append("\",\"nt\":\"");
            sb.append(ez.d(context));
            sb.append("\",\"details\":");
            sb.append(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public final byte[] a() {
        return fg.a(a(this.f9135a, this.f9136b, this.f9137c));
    }
}
