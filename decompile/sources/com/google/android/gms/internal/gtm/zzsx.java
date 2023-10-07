package com.google.android.gms.internal.gtm;

final class zzsx extends zzta {
    private final int zzc;
    private final int zzd;

    zzsx(byte[] bArr, int i2, int i3) {
        super(bArr);
        zzk(i2, i2 + i3, bArr.length);
        this.zzc = i2;
        this.zzd = i3;
    }

    public final byte zza(int i2) {
        int i3 = this.zzd;
        if (((i3 - (i2 + 1)) | i2) >= 0) {
            return this.zza[this.zzc + i2];
        }
        if (i2 < 0) {
            StringBuilder sb = new StringBuilder(22);
            sb.append("Index < 0: ");
            sb.append(i2);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("Index > length: ");
        sb2.append(i2);
        sb2.append(", ");
        sb2.append(i3);
        throw new ArrayIndexOutOfBoundsException(sb2.toString());
    }

    /* access modifiers changed from: package-private */
    public final byte zzb(int i2) {
        return this.zza[this.zzc + i2];
    }

    /* access modifiers changed from: protected */
    public final int zzc() {
        return this.zzc;
    }

    public final int zzd() {
        return this.zzd;
    }

    /* access modifiers changed from: protected */
    public final void zze(byte[] bArr, int i2, int i3, int i4) {
        System.arraycopy(this.zza, this.zzc, bArr, 0, i4);
    }
}
