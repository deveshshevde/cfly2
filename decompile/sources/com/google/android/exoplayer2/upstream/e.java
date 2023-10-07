package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import android.util.Base64;
import com.autonavi.base.amap.mapcore.AeUtil;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.ad;
import java.io.IOException;
import java.net.URLDecoder;

public final class e extends d {

    /* renamed from: a  reason: collision with root package name */
    private h f16985a;

    /* renamed from: b  reason: collision with root package name */
    private byte[] f16986b;

    /* renamed from: c  reason: collision with root package name */
    private int f16987c;

    /* renamed from: d  reason: collision with root package name */
    private int f16988d;

    public e() {
        super(false);
    }

    public int a(byte[] bArr, int i2, int i3) {
        if (i3 == 0) {
            return 0;
        }
        int i4 = this.f16987c - this.f16988d;
        if (i4 == 0) {
            return -1;
        }
        int min = Math.min(i3, i4);
        System.arraycopy(ad.a(this.f16986b), this.f16988d, bArr, i2, min);
        this.f16988d += min;
        a(min);
        return min;
    }

    public long a(h hVar) throws IOException {
        b(hVar);
        this.f16985a = hVar;
        this.f16988d = (int) hVar.f17000f;
        Uri uri = hVar.f16995a;
        String scheme = uri.getScheme();
        if (!AeUtil.ROOT_DATA_PATH_OLD_NAME.equals(scheme)) {
            String valueOf = String.valueOf(scheme);
            throw new ParserException(valueOf.length() != 0 ? "Unsupported scheme: ".concat(valueOf) : new String("Unsupported scheme: "));
        }
        String[] a2 = ad.a(uri.getSchemeSpecificPart(), ",");
        if (a2.length == 2) {
            String str = a2[1];
            if (a2[0].contains(";base64")) {
                try {
                    this.f16986b = Base64.decode(str, 0);
                } catch (IllegalArgumentException e2) {
                    String valueOf2 = String.valueOf(str);
                    throw new ParserException(valueOf2.length() != 0 ? "Error while parsing Base64 encoded string: ".concat(valueOf2) : new String("Error while parsing Base64 encoded string: "), e2);
                }
            } else {
                this.f16986b = ad.c(URLDecoder.decode(str, "US-ASCII"));
            }
            int length = hVar.f17001g != -1 ? ((int) hVar.f17001g) + this.f16988d : this.f16986b.length;
            this.f16987c = length;
            if (length > this.f16986b.length || this.f16988d > length) {
                this.f16986b = null;
                throw new DataSourceException(0);
            }
            c(hVar);
            return ((long) this.f16987c) - ((long) this.f16988d);
        }
        String valueOf3 = String.valueOf(uri);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf3).length() + 23);
        sb.append("Unexpected URI format: ");
        sb.append(valueOf3);
        throw new ParserException(sb.toString());
    }

    public Uri a() {
        h hVar = this.f16985a;
        if (hVar != null) {
            return hVar.f16995a;
        }
        return null;
    }

    public void c() {
        if (this.f16986b != null) {
            this.f16986b = null;
            d();
        }
        this.f16985a = null;
    }
}
