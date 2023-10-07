package com.google.android.gms.tagmanager;

final class zzfu extends Number implements Comparable<zzfu> {
    private double zza;
    private long zzb;
    private final boolean zzc = true;

    private zzfu(long j2) {
        this.zzb = j2;
    }

    public static zzfu zzd(long j2) {
        return new zzfu(j2);
    }

    public final byte byteValue() {
        return (byte) ((int) zzb());
    }

    public final double doubleValue() {
        return this.zzc ? (double) this.zzb : this.zza;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzfu) && compareTo((zzfu) obj) == 0;
    }

    public final float floatValue() {
        return (float) doubleValue();
    }

    public final int hashCode() {
        return new Long(zzb()).hashCode();
    }

    public final int intValue() {
        return (int) zzb();
    }

    public final long longValue() {
        return zzb();
    }

    public final short shortValue() {
        return (short) ((int) zzb());
    }

    public final String toString() {
        return this.zzc ? Long.toString(this.zzb) : Double.toString(this.zza);
    }

    /* renamed from: zza */
    public final int compareTo(zzfu zzfu) {
        return (!this.zzc || !zzfu.zzc) ? Double.compare(doubleValue(), zzfu.doubleValue()) : new Long(this.zzb).compareTo(Long.valueOf(zzfu.zzb));
    }

    public final long zzb() {
        return this.zzc ? this.zzb : (long) this.zza;
    }

    public final boolean zzf() {
        return !this.zzc;
    }

    public final boolean zzg() {
        return this.zzc;
    }
}
