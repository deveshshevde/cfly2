package com.amap.api.mapcore.util;

public final class hr extends hu {

    /* renamed from: a  reason: collision with root package name */
    private StringBuilder f9170a = new StringBuilder();

    /* renamed from: b  reason: collision with root package name */
    private boolean f9171b = true;

    public hr() {
    }

    public hr(hu huVar) {
        super(huVar);
    }

    /* access modifiers changed from: protected */
    public final byte[] a(byte[] bArr) {
        byte[] a2 = fg.a(this.f9170a.toString());
        this.f9176d = a2;
        this.f9171b = true;
        StringBuilder sb = this.f9170a;
        sb.delete(0, sb.length());
        return a2;
    }

    public final void b(byte[] bArr) {
        String a2 = fg.a(bArr);
        if (this.f9171b) {
            this.f9171b = false;
        } else {
            this.f9170a.append(",");
        }
        StringBuilder sb = this.f9170a;
        sb.append("{\"log\":\"");
        sb.append(a2);
        sb.append("\"}");
    }
}
