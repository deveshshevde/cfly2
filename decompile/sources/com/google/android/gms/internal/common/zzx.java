package com.google.android.gms.internal.common;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public final class zzx {
    /* access modifiers changed from: private */
    public final zzo zza;
    /* access modifiers changed from: private */
    public final boolean zzb;
    private final zzu zzc;

    private zzx(zzu zzu, boolean z2, zzo zzo, int i2, byte[] bArr) {
        this.zzc = zzu;
        this.zzb = z2;
        this.zza = zzo;
    }

    public static zzx zzc(zzo zzo) {
        return new zzx(new zzu(zzo), false, zzn.zza, SubsamplingScaleImageView.TILE_SIZE_AUTO, (byte[]) null);
    }

    /* access modifiers changed from: private */
    public final Iterator<String> zzh(CharSequence charSequence) {
        return new zzt(this.zzc, this, charSequence);
    }

    public final zzx zzb() {
        return new zzx(this.zzc, true, this.zza, SubsamplingScaleImageView.TILE_SIZE_AUTO, (byte[]) null);
    }

    public final Iterable<String> zzd(CharSequence charSequence) {
        return new zzv(this, charSequence);
    }

    public final List<String> zzf(CharSequence charSequence) {
        Objects.requireNonNull(charSequence);
        Iterator<String> zzh = zzh(charSequence);
        ArrayList arrayList = new ArrayList();
        while (zzh.hasNext()) {
            arrayList.add(zzh.next());
        }
        return Collections.unmodifiableList(arrayList);
    }
}
