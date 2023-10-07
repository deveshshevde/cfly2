package com.huawei.android.multiscreen.dlna.sdk.networkmanager;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private String f20892a;

    /* renamed from: b  reason: collision with root package name */
    private ENetworkType f20893b;

    /* renamed from: c  reason: collision with root package name */
    private String f20894c;

    /* renamed from: d  reason: collision with root package name */
    private String f20895d;

    public a() {
    }

    public a(String str, ENetworkType eNetworkType, String str2, String str3) {
        this.f20892a = str;
        this.f20893b = eNetworkType;
        this.f20894c = str2;
        this.f20895d = str3;
    }

    public String a() {
        return this.f20892a;
    }

    public void a(ENetworkType eNetworkType) {
        this.f20893b = eNetworkType;
    }

    public void a(String str) {
        this.f20892a = str;
    }

    public ENetworkType b() {
        return this.f20893b;
    }

    public void b(String str) {
        this.f20894c = str;
    }

    public String c() {
        return this.f20894c;
    }

    public void c(String str) {
        if (str != null) {
            str = str.replace(":", "");
        }
        this.f20895d = str;
    }

    public String d() {
        return this.f20895d;
    }
}
