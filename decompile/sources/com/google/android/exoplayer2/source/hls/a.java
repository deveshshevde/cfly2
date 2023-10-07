package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.f;
import com.google.android.exoplayer2.upstream.g;
import com.google.android.exoplayer2.upstream.h;
import com.google.android.exoplayer2.upstream.t;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

class a implements f {

    /* renamed from: a  reason: collision with root package name */
    private final f f16187a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f16188b;

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f16189c;

    /* renamed from: d  reason: collision with root package name */
    private CipherInputStream f16190d;

    public a(f fVar, byte[] bArr, byte[] bArr2) {
        this.f16187a = fVar;
        this.f16188b = bArr;
        this.f16189c = bArr2;
    }

    public final int a(byte[] bArr, int i2, int i3) throws IOException {
        com.google.android.exoplayer2.util.a.b(this.f16190d);
        int read = this.f16190d.read(bArr, i2, i3);
        if (read < 0) {
            return -1;
        }
        return read;
    }

    public final long a(h hVar) throws IOException {
        try {
            Cipher d2 = d();
            try {
                d2.init(2, new SecretKeySpec(this.f16188b, "AES"), new IvParameterSpec(this.f16189c));
                g gVar = new g(this.f16187a, hVar);
                this.f16190d = new CipherInputStream(gVar, d2);
                gVar.a();
                return -1;
            } catch (InvalidAlgorithmParameterException | InvalidKeyException e2) {
                throw new RuntimeException(e2);
            }
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e3) {
            throw new RuntimeException(e3);
        }
    }

    public final Uri a() {
        return this.f16187a.a();
    }

    public final void a(t tVar) {
        this.f16187a.a(tVar);
    }

    public final Map<String, List<String>> b() {
        return this.f16187a.b();
    }

    public void c() throws IOException {
        if (this.f16190d != null) {
            this.f16190d = null;
            this.f16187a.c();
        }
    }

    /* access modifiers changed from: protected */
    public Cipher d() throws NoSuchPaddingException, NoSuchAlgorithmException {
        return Cipher.getInstance("AES/CBC/PKCS7Padding");
    }
}
