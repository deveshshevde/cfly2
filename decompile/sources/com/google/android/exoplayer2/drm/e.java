package com.google.android.exoplayer2.drm;

import android.media.DeniedByServerException;
import android.media.MediaCryptoException;
import android.media.MediaDrmException;
import android.media.NotProvisionedException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.d;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface e<T extends d> {

    public static final class a {
    }

    public interface b<T extends d> {
    }

    public interface c<T extends d> {
        e<T> a(UUID uuid);
    }

    public static final class d {
    }

    a a(byte[] bArr, List<DrmInitData.SchemeData> list, int i2, HashMap<String, String> hashMap) throws NotProvisionedException;

    void a(b<? super T> bVar);

    void a(byte[] bArr);

    byte[] a() throws MediaDrmException;

    byte[] a(byte[] bArr, byte[] bArr2) throws NotProvisionedException, DeniedByServerException;

    d b();

    void b(byte[] bArr) throws DeniedByServerException;

    void b(byte[] bArr, byte[] bArr2);

    Map<String, String> c(byte[] bArr);

    void c();

    T d(byte[] bArr) throws MediaCryptoException;

    Class<T> d();
}
