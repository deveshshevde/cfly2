package com.amap.api.mapcore.util;

import android.content.Context;
import java.util.Map;

public final class il extends gx {

    /* renamed from: g  reason: collision with root package name */
    Map<String, String> f9265g = null;

    /* renamed from: h  reason: collision with root package name */
    String f9266h = "";

    /* renamed from: i  reason: collision with root package name */
    String f9267i = "";

    /* renamed from: j  reason: collision with root package name */
    byte[] f9268j = null;

    /* renamed from: k  reason: collision with root package name */
    byte[] f9269k = null;

    /* renamed from: l  reason: collision with root package name */
    boolean f9270l = false;

    /* renamed from: m  reason: collision with root package name */
    String f9271m = null;

    /* renamed from: n  reason: collision with root package name */
    Map<String, String> f9272n = null;

    /* renamed from: o  reason: collision with root package name */
    boolean f9273o = false;

    /* renamed from: p  reason: collision with root package name */
    private String f9274p = "";

    public il(Context context, ff ffVar) {
        super(context, ffVar);
    }

    public final void a(String str) {
        this.f9271m = str;
    }

    public final void a(Map<String, String> map) {
        this.f9272n = map;
    }

    public final void a(byte[] bArr) {
        this.f9268j = bArr;
    }

    public final void b(String str) {
        this.f9266h = str;
    }

    public final void b(Map<String, String> map) {
        this.f9265g = map;
    }

    public final void c(String str) {
        this.f9267i = str;
    }

    public final byte[] c() {
        return this.f9268j;
    }

    public final byte[] d() {
        return this.f9269k;
    }

    public final boolean f() {
        return this.f9270l;
    }

    public final String g() {
        return this.f9271m;
    }

    public final String getIPDNSName() {
        return this.f9274p;
    }

    public final String getIPV6URL() {
        return this.f9267i;
    }

    public final Map<String, String> getParams() {
        return this.f9272n;
    }

    public final Map<String, String> getRequestHead() {
        return this.f9265g;
    }

    public final String getSDKName() {
        return "loc";
    }

    public final String getURL() {
        return this.f9266h;
    }

    /* access modifiers changed from: protected */
    public final boolean h() {
        return this.f9273o;
    }

    public final void i() {
        this.f9270l = true;
    }

    public final void j() {
        this.f9273o = true;
    }
}
