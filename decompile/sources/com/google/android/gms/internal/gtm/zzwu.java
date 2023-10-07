package com.google.android.gms.internal.gtm;

import java.util.Arrays;
import java.util.RandomAccess;

final class zzwu<E> extends zzsj<E> implements RandomAccess {
    private static final zzwu<Object> zza;
    private E[] zzb;
    private int zzc;

    static {
        zzwu<Object> zzwu = new zzwu<>(new Object[0], 0);
        zza = zzwu;
        zzwu.zzb();
    }

    zzwu() {
        this(new Object[10], 0);
    }

    private zzwu(E[] eArr, int i2) {
        this.zzb = eArr;
        this.zzc = i2;
    }

    public static <E> zzwu<E> zze() {
        return zza;
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

    public final void add(int i2, E e2) {
        int i3;
        zza();
        if (i2 < 0 || i2 > (i3 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzf(i2));
        }
        E[] eArr = this.zzb;
        if (i3 < eArr.length) {
            System.arraycopy(eArr, i2, eArr, i2 + 1, i3 - i2);
        } else {
            E[] eArr2 = new Object[(((i3 * 3) / 2) + 1)];
            System.arraycopy(eArr, 0, eArr2, 0, i2);
            System.arraycopy(this.zzb, i2, eArr2, i2 + 1, this.zzc - i2);
            this.zzb = eArr2;
        }
        this.zzb[i2] = e2;
        this.zzc++;
        this.modCount++;
    }

    public final boolean add(E e2) {
        zza();
        int i2 = this.zzc;
        E[] eArr = this.zzb;
        if (i2 == eArr.length) {
            this.zzb = Arrays.copyOf(eArr, ((i2 * 3) / 2) + 1);
        }
        E[] eArr2 = this.zzb;
        int i3 = this.zzc;
        this.zzc = i3 + 1;
        eArr2[i3] = e2;
        this.modCount++;
        return true;
    }

    public final E get(int i2) {
        zzg(i2);
        return this.zzb[i2];
    }

    public final E remove(int i2) {
        zza();
        zzg(i2);
        E[] eArr = this.zzb;
        E e2 = eArr[i2];
        int i3 = this.zzc;
        if (i2 < i3 - 1) {
            System.arraycopy(eArr, i2 + 1, eArr, i2, (i3 - i2) - 1);
        }
        this.zzc--;
        this.modCount++;
        return e2;
    }

    public final E set(int i2, E e2) {
        zza();
        zzg(i2);
        E[] eArr = this.zzb;
        E e3 = eArr[i2];
        eArr[i2] = e2;
        this.modCount++;
        return e3;
    }

    public final int size() {
        return this.zzc;
    }

    public final /* synthetic */ zzvh zzd(int i2) {
        if (i2 >= this.zzc) {
            return new zzwu(Arrays.copyOf(this.zzb, i2), this.zzc);
        }
        throw new IllegalArgumentException();
    }
}
