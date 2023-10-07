package com.google.android.gms.internal.gtm;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzuq extends zzsj<Float> implements zzvh, zzws, RandomAccess {
    private static final zzuq zza;
    private float[] zzb;
    private int zzc;

    static {
        zzuq zzuq = new zzuq(new float[0], 0);
        zza = zzuq;
        zzuq.zzb();
    }

    zzuq() {
        this(new float[10], 0);
    }

    private zzuq(float[] fArr, int i2) {
        this.zzb = fArr;
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
        float floatValue = ((Float) obj).floatValue();
        zza();
        if (i2 < 0 || i2 > (i3 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzf(i2));
        }
        float[] fArr = this.zzb;
        if (i3 < fArr.length) {
            System.arraycopy(fArr, i2, fArr, i2 + 1, i3 - i2);
        } else {
            float[] fArr2 = new float[(((i3 * 3) / 2) + 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i2);
            System.arraycopy(this.zzb, i2, fArr2, i2 + 1, this.zzc - i2);
            this.zzb = fArr2;
        }
        this.zzb[i2] = floatValue;
        this.zzc++;
        this.modCount++;
    }

    public final /* synthetic */ boolean add(Object obj) {
        zze(((Float) obj).floatValue());
        return true;
    }

    public final boolean addAll(Collection<? extends Float> collection) {
        zza();
        zzvi.zze(collection);
        if (!(collection instanceof zzuq)) {
            return super.addAll(collection);
        }
        zzuq zzuq = (zzuq) collection;
        int i2 = zzuq.zzc;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.zzc;
        if (SubsamplingScaleImageView.TILE_SIZE_AUTO - i3 >= i2) {
            int i4 = i3 + i2;
            float[] fArr = this.zzb;
            if (i4 > fArr.length) {
                this.zzb = Arrays.copyOf(fArr, i4);
            }
            System.arraycopy(zzuq.zzb, 0, this.zzb, this.zzc, zzuq.zzc);
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
        if (!(obj instanceof zzuq)) {
            return super.equals(obj);
        }
        zzuq zzuq = (zzuq) obj;
        if (this.zzc != zzuq.zzc) {
            return false;
        }
        float[] fArr = zzuq.zzb;
        for (int i2 = 0; i2 < this.zzc; i2++) {
            if (Float.floatToIntBits(this.zzb[i2]) != Float.floatToIntBits(fArr[i2])) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i2) {
        zzg(i2);
        return Float.valueOf(this.zzb[i2]);
    }

    public final int hashCode() {
        int i2 = 1;
        for (int i3 = 0; i3 < this.zzc; i3++) {
            i2 = (i2 * 31) + Float.floatToIntBits(this.zzb[i3]);
        }
        return i2;
    }

    public final int indexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        float floatValue = ((Float) obj).floatValue();
        int i2 = this.zzc;
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.zzb[i3] == floatValue) {
                return i3;
            }
        }
        return -1;
    }

    public final /* synthetic */ Object remove(int i2) {
        zza();
        zzg(i2);
        float[] fArr = this.zzb;
        float f2 = fArr[i2];
        int i3 = this.zzc;
        if (i2 < i3 - 1) {
            System.arraycopy(fArr, i2 + 1, fArr, i2, (i3 - i2) - 1);
        }
        this.zzc--;
        this.modCount++;
        return Float.valueOf(f2);
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i2, int i3) {
        zza();
        if (i3 >= i2) {
            float[] fArr = this.zzb;
            System.arraycopy(fArr, i3, fArr, i2, this.zzc - i3);
            this.zzc -= i3 - i2;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final /* synthetic */ Object set(int i2, Object obj) {
        float floatValue = ((Float) obj).floatValue();
        zza();
        zzg(i2);
        float[] fArr = this.zzb;
        float f2 = fArr[i2];
        fArr[i2] = floatValue;
        return Float.valueOf(f2);
    }

    public final int size() {
        return this.zzc;
    }

    public final /* synthetic */ zzvh zzd(int i2) {
        if (i2 >= this.zzc) {
            return new zzuq(Arrays.copyOf(this.zzb, i2), this.zzc);
        }
        throw new IllegalArgumentException();
    }

    public final void zze(float f2) {
        zza();
        int i2 = this.zzc;
        float[] fArr = this.zzb;
        if (i2 == fArr.length) {
            float[] fArr2 = new float[(((i2 * 3) / 2) + 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i2);
            this.zzb = fArr2;
        }
        float[] fArr3 = this.zzb;
        int i3 = this.zzc;
        this.zzc = i3 + 1;
        fArr3[i3] = f2;
    }
}
