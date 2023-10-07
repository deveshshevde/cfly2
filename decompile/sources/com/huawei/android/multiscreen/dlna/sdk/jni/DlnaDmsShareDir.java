package com.huawei.android.multiscreen.dlna.sdk.jni;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DlnaDmsShareDir extends a {

    /* renamed from: a  reason: collision with root package name */
    private int f20863a;

    /* renamed from: b  reason: collision with root package name */
    private int f20864b = 0;

    /* renamed from: c  reason: collision with root package name */
    private a[] f20865c;

    /* renamed from: d  reason: collision with root package name */
    private int f20866d;

    /* renamed from: e  reason: collision with root package name */
    private ConcurrentHashMap<String, a> f20867e = new ConcurrentHashMap<>();

    public DlnaDmsShareDir(String str) {
        super(str);
    }

    public int a() {
        return this.f20863a;
    }

    public void a(int i2) {
        this.f20863a = i2;
    }

    public void a(String str, a aVar) {
        if (!TextUtils.isEmpty(str) && aVar != null) {
            aVar.a(this);
            c().put(str, aVar);
        }
    }

    public void a(a[] aVarArr) {
        this.f20865c = aVarArr;
        this.f20866d = aVarArr == null ? 0 : aVarArr.length;
    }

    public int b() {
        return this.f20864b;
    }

    public void b(int i2) {
        this.f20864b = i2;
    }

    public ConcurrentHashMap<String, a> c() {
        return this.f20867e;
    }

    public boolean d() {
        return true;
    }

    /* renamed from: e */
    public DlnaDmsShareDir h() {
        DlnaDmsShareDir dlnaDmsShareDir = (DlnaDmsShareDir) super.clone();
        dlnaDmsShareDir.f20863a = this.f20863a;
        dlnaDmsShareDir.f20864b = this.f20864b;
        for (Map.Entry next : c().entrySet()) {
            dlnaDmsShareDir.a((String) next.getKey(), ((a) next.getValue()).clone());
        }
        return dlnaDmsShareDir;
    }

    public void f() {
        super.f();
        for (Map.Entry<String, a> value : c().entrySet()) {
            ((a) value.getValue()).f();
        }
        c().clear();
    }

    public void g() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, a> value : this.f20867e.entrySet()) {
            a aVar = (a) value.getValue();
            if (!aVar.d()) {
                arrayList.add(aVar);
            }
        }
        a((a[]) arrayList.toArray(new a[arrayList.size()]));
    }
}
