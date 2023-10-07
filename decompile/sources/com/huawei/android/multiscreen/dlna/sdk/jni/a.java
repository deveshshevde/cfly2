package com.huawei.android.multiscreen.dlna.sdk.jni;

import java.io.File;

public class a implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private String f20879a;

    /* renamed from: b  reason: collision with root package name */
    private int f20880b;

    /* renamed from: c  reason: collision with root package name */
    private String f20881c;

    /* renamed from: d  reason: collision with root package name */
    private int f20882d;

    /* renamed from: e  reason: collision with root package name */
    private DlnaDmsShareDir f20883e;

    public a(String str) {
        b(str);
        String str2 = this.f20881c;
        int i2 = 0;
        d(str2 == null ? 0 : str2.length());
        a(c(this.f20881c));
        String str3 = this.f20879a;
        i2 = str3 != null ? str3.length() : i2;
        this.f20880b = i2;
        c(i2);
    }

    private String c(String str) {
        return str == null ? str : str.substring(str.lastIndexOf(47) + 1);
    }

    public void a(DlnaDmsShareDir dlnaDmsShareDir) {
        this.f20883e = dlnaDmsShareDir;
    }

    public void a(String str) {
        this.f20879a = str;
    }

    public int b() {
        return 1;
    }

    public void b(String str) {
        if (!str.equals("/") && str.endsWith("/")) {
            str = str.substring(0, str.length() - 1);
        }
        this.f20881c = str;
    }

    public void c(int i2) {
        this.f20880b = i2;
    }

    public void d(int i2) {
        this.f20882d = i2;
    }

    public boolean d() {
        return false;
    }

    public void f() {
        this.f20879a = null;
        this.f20880b = 0;
        this.f20881c = null;
        this.f20882d = 0;
    }

    /* renamed from: h */
    public a clone() {
        try {
            return (a) super.clone();
        } catch (CloneNotSupportedException unused) {
            ie.a.d("DlnaDmsShareFile", "DlnaDmsShareFile happened CloneNotSupportedException");
            return null;
        }
    }

    public String i() {
        return this.f20879a;
    }

    public String j() {
        return this.f20881c;
    }

    public String k() {
        ie.a.a("DlnaDmsShareFile", this.f20881c);
        String str = this.f20881c;
        return (str == null || str.equals("/")) ? this.f20881c : new File(this.f20881c).getParentFile().getAbsolutePath();
    }
}
