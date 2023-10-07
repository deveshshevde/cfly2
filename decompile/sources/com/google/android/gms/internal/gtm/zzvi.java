package com.google.android.gms.internal.gtm;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Objects;

public final class zzvi {
    static final Charset zza = Charset.forName("UTF-8");
    static final Charset zzb = Charset.forName("ISO-8859-1");
    public static final byte[] zzc;
    public static final ByteBuffer zzd;
    public static final zztj zze;

    static {
        byte[] bArr = new byte[0];
        zzc = bArr;
        zzd = ByteBuffer.wrap(bArr);
        int i2 = zztj.zzd;
        zztf zztf = new zztf(bArr, 0, 0, false, (zzte) null);
        try {
            zztf.zzb(0);
            zze = zztf;
        } catch (zzvk e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static int zza(boolean z2) {
        return z2 ? 1231 : 1237;
    }

    public static int zzb(byte[] bArr) {
        int length = bArr.length;
        int zzd2 = zzd(length, bArr, 0, length);
        if (zzd2 == 0) {
            return 1;
        }
        return zzd2;
    }

    public static int zzc(long j2) {
        return (int) (j2 ^ (j2 >>> 32));
    }

    static int zzd(int i2, byte[] bArr, int i3, int i4) {
        for (int i5 = i3; i5 < i3 + i4; i5++) {
            i2 = (i2 * 31) + bArr[i5];
        }
        return i2;
    }

    static <T> T zze(T t2) {
        Objects.requireNonNull(t2);
        return t2;
    }

    static <T> T zzf(T t2, String str) {
        Objects.requireNonNull(t2, str);
        return t2;
    }

    static Object zzg(Object obj, Object obj2) {
        return ((zzwk) obj).zzap().zzx((zzwk) obj2).zzD();
    }

    public static String zzh(byte[] bArr) {
        return new String(bArr, zza);
    }

    static boolean zzi(zzwk zzwk) {
        if (!(zzwk instanceof zzsi)) {
            return false;
        }
        zzsi zzsi = (zzsi) zzwk;
        throw null;
    }

    public static boolean zzj(byte[] bArr) {
        return zzyd.zze(bArr);
    }
}
