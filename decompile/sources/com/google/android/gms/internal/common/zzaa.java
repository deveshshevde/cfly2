package com.google.android.gms.internal.common;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.Arrays;
import java.util.Objects;

class zzaa<E> extends zzab<E> {
    Object[] zza = new Object[4];
    int zzb = 0;
    boolean zzc;

    zzaa(int i2) {
    }

    private final void zzb(int i2) {
        Object[] objArr = this.zza;
        int length = objArr.length;
        if (length < i2) {
            int i3 = length + (length >> 1) + 1;
            if (i3 < i2) {
                int highestOneBit = Integer.highestOneBit(i2 - 1);
                i3 = highestOneBit + highestOneBit;
            }
            if (i3 < 0) {
                i3 = SubsamplingScaleImageView.TILE_SIZE_AUTO;
            }
            this.zza = Arrays.copyOf(objArr, i3);
        } else if (this.zzc) {
            this.zza = (Object[]) objArr.clone();
        } else {
            return;
        }
        this.zzc = false;
    }

    public final zzaa<E> zza(E e2) {
        Objects.requireNonNull(e2);
        zzb(this.zzb + 1);
        Object[] objArr = this.zza;
        int i2 = this.zzb;
        this.zzb = i2 + 1;
        objArr[i2] = e2;
        return this;
    }
}
