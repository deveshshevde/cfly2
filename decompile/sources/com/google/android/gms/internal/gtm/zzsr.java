package com.google.android.gms.internal.gtm;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzsr extends zzsj<Boolean> implements zzvh, zzws, RandomAccess {
    private static final zzsr zza;
    private boolean[] zzb;
    private int zzc;

    static {
        zzsr zzsr = new zzsr(new boolean[0], 0);
        zza = zzsr;
        zzsr.zzb();
    }

    zzsr() {
        this(new boolean[10], 0);
    }

    private zzsr(boolean[] zArr, int i2) {
        this.zzb = zArr;
        this.zzc = i2;
    }

    private final String zzf(int i2) {
        int i3 = this.zzc;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i2);
        sb.append(", Size:");
        sb.append(i3);
        return sb.toString();
    }

    private final void zzg(int i2) {
        if (i2 < 0 || i2 >= this.zzc) {
            throw new IndexOutOfBoundsException(zzf(i2));
        }
    }

    public final /* synthetic */ void add(int i2, Object obj) {
        int i3;
        boolean booleanValue = ((Boolean) obj).booleanValue();
        zza();
        if (i2 < 0 || i2 > (i3 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzf(i2));
        }
        boolean[] zArr = this.zzb;
        if (i3 < zArr.length) {
            System.arraycopy(zArr, i2, zArr, i2 + 1, i3 - i2);
        } else {
            boolean[] zArr2 = new boolean[(((i3 * 3) / 2) + 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i2);
            System.arraycopy(this.zzb, i2, zArr2, i2 + 1, this.zzc - i2);
            this.zzb = zArr2;
        }
        this.zzb[i2] = booleanValue;
        this.zzc++;
        this.modCount++;
    }

    public final /* synthetic */ boolean add(Object obj) {
        zze(((Boolean) obj).booleanValue());
        return true;
    }

    public final boolean addAll(Collection<? extends Boolean> collection) {
        zza();
        zzvi.zze(collection);
        if (!(collection instanceof zzsr)) {
            return super.addAll(collection);
        }
        zzsr zzsr = (zzsr) collection;
        int i2 = zzsr.zzc;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.zzc;
        if (SubsamplingScaleImageView.TILE_SIZE_AUTO - i3 >= i2) {
            int i4 = i3 + i2;
            boolean[] zArr = this.zzb;
            if (i4 > zArr.length) {
                this.zzb = Arrays.copyOf(zArr, i4);
            }
            System.arraycopy(zzsr.zzb, 0, this.zzb, this.zzc, zzsr.zzc);
            this.zzc = i4;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzsr)) {
            return super.equals(obj);
        }
        zzsr zzsr = (zzsr) obj;
        if (this.zzc != zzsr.zzc) {
            return false;
        }
        boolean[] zArr = zzsr.zzb;
        for (int i2 = 0; i2 < this.zzc; i2++) {
            if (this.zzb[i2] != zArr[i2]) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i2) {
        zzg(i2);
        return Boolean.valueOf(this.zzb[i2]);
    }

    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.zzc; i3++) {
            i2 = (i2 * 31) + zzvi.zza(this.zzb[i3]);
        }
        return i2;
    }

    public final int indexOf(Object obj) {
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        int i2 = this.zzc;
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.zzb[i3] == booleanValue) {
                return i3;
            }
        }
        return -1;
    }

    public final /* synthetic */ Object remove(int i2) {
        zza();
        zzg(i2);
        boolean[] zArr = this.zzb;
        boolean z2 = zArr[i2];
        int i3 = this.zzc;
        if (i2 < i3 - 1) {
            System.arraycopy(zArr, i2 + 1, zArr, i2, (i3 - i2) - 1);
        }
        this.zzc--;
        this.modCount++;
        return Boolean.valueOf(z2);
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i2, int i3) {
        zza();
        if (i3 >= i2) {
            boolean[] zArr = this.zzb;
            System.arraycopy(zArr, i3, zArr, i2, this.zzc - i3);
            this.zzc -= i3 - i2;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* synthetic */ Object set(int i2, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        zza();
        zzg(i2);
        boolean[] zArr = this.zzb;
        boolean z2 = zArr[i2];
        zArr[i2] = booleanValue;
        return Boolean.valueOf(z2);
    }

    public final int size() {
        return this.zzc;
    }

    public final /* synthetic */ zzvh zzd(int i2) {
        if (i2 >= this.zzc) {
            return new zzsr(Arrays.copyOf(this.zzb, i2), this.zzc);
        }
        throw new IllegalArgumentException();
    }

    public final void zze(boolean z2) {
        zza();
        int i2 = this.zzc;
        boolean[] zArr = this.zzb;
        if (i2 == zArr.length) {
            boolean[] zArr2 = new boolean[(((i2 * 3) / 2) + 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i2);
            this.zzb = zArr2;
        }
        boolean[] zArr3 = this.zzb;
        int i3 = this.zzc;
        this.zzc = i3 + 1;
        zArr3[i3] = z2;
    }
}
