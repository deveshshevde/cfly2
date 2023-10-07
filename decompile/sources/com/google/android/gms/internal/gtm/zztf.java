package com.google.android.gms.internal.gtm;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.IOException;

final class zztf extends zztj {
    private final byte[] zze;
    private int zzf;
    private int zzg;
    private int zzh = SubsamplingScaleImageView.TILE_SIZE_AUTO;

    /* synthetic */ zztf(byte[] bArr, int i2, int i3, boolean z2, zzte zzte) {
        super((zzti) null);
        this.zze = bArr;
        this.zzf = 0;
    }

    public final int zza() {
        throw null;
    }

    public final int zzb(int i2) throws zzvk {
        int i3 = this.zzh;
        this.zzh = 0;
        int i4 = this.zzf + this.zzg;
        this.zzf = i4;
        if (i4 > 0) {
            this.zzg = i4;
            this.zzf = 0;
        } else {
            this.zzg = 0;
        }
        return i3;
    }

    public final int zzc() throws IOException {
        throw null;
    }

    public final zztd zzd() throws IOException {
        throw null;
    }

    public final String zze() throws IOException {
        throw null;
    }

    public final String zzf() throws IOException {
        throw null;
    }

    public final void zzg(int i2) throws zzvk {
        throw null;
    }

    public final void zzh(int i2) {
        throw null;
    }

    public final boolean zzi() throws IOException {
        throw null;
    }

    public final boolean zzj() throws IOException {
        throw null;
    }

    public final boolean zzk(int i2) throws IOException {
        throw null;
    }
}
