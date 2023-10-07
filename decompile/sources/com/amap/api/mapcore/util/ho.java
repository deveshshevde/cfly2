package com.amap.api.mapcore.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class ho extends hu {

    /* renamed from: a  reason: collision with root package name */
    ByteArrayOutputStream f9164a = new ByteArrayOutputStream();

    public ho() {
    }

    public ho(hu huVar) {
        super(huVar);
    }

    /* access modifiers changed from: protected */
    public final byte[] a(byte[] bArr) {
        byte[] byteArray = this.f9164a.toByteArray();
        try {
            this.f9164a.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        this.f9164a = new ByteArrayOutputStream();
        return byteArray;
    }

    public final void b(byte[] bArr) {
        try {
            this.f9164a.write(bArr);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
