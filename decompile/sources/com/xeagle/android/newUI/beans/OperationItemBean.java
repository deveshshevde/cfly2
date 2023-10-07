package com.xeagle.android.newUI.beans;

import java.io.Serializable;

public class OperationItemBean implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private int f23931a;

    /* renamed from: b  reason: collision with root package name */
    private String f23932b = "";

    /* renamed from: c  reason: collision with root package name */
    private int f23933c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f23934d;

    /* renamed from: e  reason: collision with root package name */
    private String f23935e;

    public OperationItemBean(int i2) {
        this.f23931a = i2;
    }

    public OperationItemBean(int i2, String str, int i3, boolean z2, String str2) {
        this.f23931a = i2;
        this.f23932b = str;
        this.f23933c = i3;
        this.f23934d = z2;
        this.f23935e = str2;
    }

    public int a() {
        return this.f23931a;
    }

    public void a(boolean z2) {
        this.f23934d = z2;
    }

    public String b() {
        return this.f23932b;
    }

    public int c() {
        return this.f23933c;
    }

    public boolean d() {
        return this.f23934d;
    }

    public String e() {
        return this.f23935e;
    }
}
