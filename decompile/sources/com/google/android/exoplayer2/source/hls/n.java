package com.google.android.exoplayer2.source.hls;

import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.util.a;
import com.google.android.exoplayer2.util.aa;
import com.google.android.exoplayer2.util.q;
import fj.g;
import fj.i;
import fj.r;
import fj.s;
import fj.u;
import gd.h;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class n implements g {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f11703a = Pattern.compile("LOCAL:([^,]+)");

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f11704b = Pattern.compile("MPEGTS:(-?\\d+)");

    /* renamed from: c  reason: collision with root package name */
    private final String f11705c;

    /* renamed from: d  reason: collision with root package name */
    private final aa f11706d;

    /* renamed from: e  reason: collision with root package name */
    private final q f11707e = new q();

    /* renamed from: f  reason: collision with root package name */
    private i f11708f;

    /* renamed from: g  reason: collision with root package name */
    private byte[] f11709g = new byte[1024];

    /* renamed from: h  reason: collision with root package name */
    private int f11710h;

    public n(String str, aa aaVar) {
        this.f11705c = str;
        this.f11706d = aaVar;
    }

    @RequiresNonNull({"output"})
    private u a(long j2) {
        u a2 = this.f11708f.a(0, 3);
        a2.a(Format.a((String) null, "text/vtt", (String) null, -1, 0, this.f11705c, (DrmInitData) null, j2));
        this.f11708f.a();
        return a2;
    }

    @RequiresNonNull({"output"})
    private void a() throws ParserException {
        q qVar = new q(this.f11709g);
        h.a(qVar);
        long j2 = 0;
        long j3 = 0;
        for (String B = qVar.B(); !TextUtils.isEmpty(B); B = qVar.B()) {
            if (B.startsWith("X-TIMESTAMP-MAP")) {
                Matcher matcher = f11703a.matcher(B);
                if (!matcher.find()) {
                    String valueOf = String.valueOf(B);
                    throw new ParserException(valueOf.length() != 0 ? "X-TIMESTAMP-MAP doesn't contain local timestamp: ".concat(valueOf) : new String("X-TIMESTAMP-MAP doesn't contain local timestamp: "));
                }
                Matcher matcher2 = f11704b.matcher(B);
                if (!matcher2.find()) {
                    String valueOf2 = String.valueOf(B);
                    throw new ParserException(valueOf2.length() != 0 ? "X-TIMESTAMP-MAP doesn't contain media timestamp: ".concat(valueOf2) : new String("X-TIMESTAMP-MAP doesn't contain media timestamp: "));
                } else {
                    j3 = h.a(matcher.group(1));
                    j2 = aa.d(Long.parseLong(matcher2.group(1)));
                }
            }
        }
        Matcher c2 = h.c(qVar);
        if (c2 == null) {
            a(0);
            return;
        }
        long a2 = h.a(c2.group(1));
        long b2 = this.f11706d.b(aa.e((j2 + a2) - j3));
        u a3 = a(b2 - a2);
        this.f11707e.a(this.f11709g, this.f11710h);
        a3.a(this.f11707e, this.f11710h);
        a3.a(b2, 1, this.f11710h, 0, (u.a) null);
    }

    public int a(fj.h hVar, r rVar) throws IOException, InterruptedException {
        a.b(this.f11708f);
        int d2 = (int) hVar.d();
        int i2 = this.f11710h;
        byte[] bArr = this.f11709g;
        if (i2 == bArr.length) {
            this.f11709g = Arrays.copyOf(bArr, ((d2 != -1 ? d2 : bArr.length) * 3) / 2);
        }
        byte[] bArr2 = this.f11709g;
        int i3 = this.f11710h;
        int a2 = hVar.a(bArr2, i3, bArr2.length - i3);
        if (a2 != -1) {
            int i4 = this.f11710h + a2;
            this.f11710h = i4;
            if (d2 == -1 || i4 != d2) {
                return 0;
            }
        }
        a();
        return -1;
    }

    public void a(long j2, long j3) {
        throw new IllegalStateException();
    }

    public void a(i iVar) {
        this.f11708f = iVar;
        iVar.a(new s.b(-9223372036854775807L));
    }

    public boolean a(fj.h hVar) throws IOException, InterruptedException {
        hVar.b(this.f11709g, 0, 6, false);
        this.f11707e.a(this.f11709g, 6);
        if (h.b(this.f11707e)) {
            return true;
        }
        hVar.b(this.f11709g, 6, 3, false);
        this.f11707e.a(this.f11709g, 9);
        return h.b(this.f11707e);
    }

    public void c() {
    }
}
