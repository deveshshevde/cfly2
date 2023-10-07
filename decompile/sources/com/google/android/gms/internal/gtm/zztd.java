package com.google.android.gms.internal.gtm;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;

public abstract class zztd implements Serializable, Iterable<Byte> {
    private static final Comparator<zztd> zza = new zzsv();
    public static final zztd zzb = new zzta(zzvi.zzc);
    private static final zztc zzd = new zztc((zztb) null);
    private int zzc = 0;

    static {
        int i2 = zzsk.zza;
    }

    zztd() {
    }

    static int zzk(int i2, int i3, int i4) {
        int i5 = i3 - i2;
        if ((i2 | i3 | i5 | (i4 - i3)) >= 0) {
            return i5;
        }
        if (i2 < 0) {
            StringBuilder sb = new StringBuilder(32);
            sb.append("Beginning index: ");
            sb.append(i2);
            sb.append(" < 0");
            throw new IndexOutOfBoundsException(sb.toString());
        } else if (i3 < i2) {
            StringBuilder sb2 = new StringBuilder(66);
            sb2.append("Beginning index larger than ending index: ");
            sb2.append(i2);
            sb2.append(", ");
            sb2.append(i3);
            throw new IndexOutOfBoundsException(sb2.toString());
        } else {
            StringBuilder sb3 = new StringBuilder(37);
            sb3.append("End index: ");
            sb3.append(i3);
            sb3.append(" >= ");
            sb3.append(i4);
            throw new IndexOutOfBoundsException(sb3.toString());
        }
    }

    public static zztd zzm(byte[] bArr) {
        return zzn(bArr, 0, bArr.length);
    }

    public static zztd zzn(byte[] bArr, int i2, int i3) {
        zzk(i2, i2 + i3, bArr.length);
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i2, bArr2, 0, i3);
        return new zzta(bArr2);
    }

    public static zztd zzo(String str) {
        return new zzta(str.getBytes(zzvi.zza));
    }

    static zztd zzp(byte[] bArr) {
        return new zzta(bArr);
    }

    static zztd zzq(byte[] bArr, int i2, int i3) {
        return new zzsx(bArr, i2, i3);
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i2 = this.zzc;
        if (i2 == 0) {
            int zzd2 = zzd();
            i2 = zzf(zzd2, 0, zzd2);
            if (i2 == 0) {
                i2 = 1;
            }
            this.zzc = i2;
        }
        return i2;
    }

    public final /* synthetic */ Iterator iterator() {
        return new zzst(this);
    }

    public final String toString() {
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(zzd());
        objArr[2] = zzd() <= 50 ? zzxm.zza(this) : String.valueOf(zzxm.zza(zzg(0, 47))).concat("...");
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }

    public abstract byte zza(int i2);

    /* access modifiers changed from: package-private */
    public abstract byte zzb(int i2);

    public abstract int zzd();

    /* access modifiers changed from: protected */
    public abstract void zze(byte[] bArr, int i2, int i3, int i4);

    /* access modifiers changed from: protected */
    public abstract int zzf(int i2, int i3, int i4);

    public abstract zztd zzg(int i2, int i3);

    /* access modifiers changed from: protected */
    public abstract String zzh(Charset charset);

    /* access modifiers changed from: package-private */
    public abstract void zzi(zzss zzss) throws IOException;

    public abstract boolean zzj();

    /* access modifiers changed from: protected */
    public final int zzl() {
        return this.zzc;
    }

    public final String zzr(Charset charset) {
        return zzd() == 0 ? "" : zzh(charset);
    }
}
