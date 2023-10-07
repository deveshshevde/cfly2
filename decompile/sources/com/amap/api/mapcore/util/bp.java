package com.amap.api.mapcore.util;

public abstract class bp implements bt {

    /* renamed from: a  reason: collision with root package name */
    protected int f8090a;

    /* renamed from: b  reason: collision with root package name */
    protected al f8091b;

    public bp(int i2, al alVar) {
        this.f8090a = i2;
        this.f8091b = alVar;
    }

    public void a() {
        StringBuilder sb = new StringBuilder("Wrong call delete()  State: ");
        sb.append(b());
        sb.append("  ");
        sb.append(getClass());
    }

    public void a(int i2) {
        StringBuilder sb = new StringBuilder("Wrong call fail()  State: ");
        sb.append(b());
        sb.append("  ");
        sb.append(getClass());
    }

    public final boolean a(bp bpVar) {
        return bpVar.b() == b();
    }

    public final int b() {
        return this.f8090a;
    }

    public final void b(bp bpVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(b());
        sb.append(" ==> ");
        sb.append(bpVar.b());
        sb.append("   ");
        sb.append(getClass());
        sb.append("==>");
        sb.append(bpVar.getClass());
    }

    public void c() {
        StringBuilder sb = new StringBuilder("Wrong call start()  State: ");
        sb.append(b());
        sb.append("  ");
        sb.append(getClass());
    }

    public void d() {
        StringBuilder sb = new StringBuilder("Wrong call continueDownload()  State: ");
        sb.append(b());
        sb.append("  ");
        sb.append(getClass());
    }

    public void e() {
        StringBuilder sb = new StringBuilder("Wrong call pause()  State: ");
        sb.append(b());
        sb.append("  ");
        sb.append(getClass());
    }

    public void f() {
        StringBuilder sb = new StringBuilder("Wrong call hasNew()  State: ");
        sb.append(b());
        sb.append("  ");
        sb.append(getClass());
    }

    public void g() {
        StringBuilder sb = new StringBuilder("Wrong call complete()  State: ");
        sb.append(b());
        sb.append("  ");
        sb.append(getClass());
    }
}
