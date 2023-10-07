package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public final class hq extends hu {

    /* renamed from: a  reason: collision with root package name */
    private Context f9166a;

    /* renamed from: b  reason: collision with root package name */
    private String f9167b;

    /* renamed from: e  reason: collision with root package name */
    private gq f9168e;

    /* renamed from: f  reason: collision with root package name */
    private Object[] f9169f;

    public hq(Context context, hu huVar, gq gqVar, String str, Object... objArr) {
        super(huVar);
        this.f9166a = context;
        this.f9167b = str;
        this.f9168e = gqVar;
        this.f9169f = objArr;
    }

    private String b() {
        try {
            return String.format(fg.c(this.f9167b), this.f9169f);
        } catch (Throwable th) {
            th.printStackTrace();
            fz.c(th, "ofm", "gpj");
            return "";
        }
    }

    /* access modifiers changed from: protected */
    public final byte[] a(byte[] bArr) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        String a2 = fg.a(bArr);
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        String a3 = fg.a(this.f9168e.b(fg.a(b())));
        return fg.a("{\"pinfo\":\"" + a3 + "\",\"els\":[" + a2 + "]}");
    }
}
