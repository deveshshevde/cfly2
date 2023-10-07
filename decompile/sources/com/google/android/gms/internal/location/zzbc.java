package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.l;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;

public final class zzbc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbc> CREATOR = new zzbb();
    static final List<ClientIdentity> zza = Collections.emptyList();
    private LocationRequest zzb;
    private List<ClientIdentity> zzc;
    private String zzd;
    private boolean zze;
    private boolean zzf;
    private boolean zzg;
    private String zzh;
    private boolean zzi;
    private boolean zzj;
    private String zzk;
    private long zzl;
    private boolean zzm = true;

    zzbc(LocationRequest locationRequest, List<ClientIdentity> list, String str, boolean z2, boolean z3, boolean z4, String str2, boolean z5, boolean z6, String str3, long j2) {
        this.zzb = locationRequest;
        this.zzc = list;
        this.zzd = str;
        this.zze = z2;
        this.zzf = z3;
        this.zzg = z4;
        this.zzh = str2;
        this.zzi = z5;
        this.zzj = z6;
        this.zzk = str3;
        this.zzl = j2;
    }

    @Deprecated
    public static zzbc zza(LocationRequest locationRequest) {
        return zza((String) null, locationRequest);
    }

    public static zzbc zza(String str, LocationRequest locationRequest) {
        return new zzbc(locationRequest, zza, (String) null, false, false, false, (String) null, false, false, (String) null, Long.MAX_VALUE);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzbc)) {
            return false;
        }
        zzbc zzbc = (zzbc) obj;
        return l.a(this.zzb, zzbc.zzb) && l.a(this.zzc, zzbc.zzc) && l.a(this.zzd, zzbc.zzd) && this.zze == zzbc.zze && this.zzf == zzbc.zzf && this.zzg == zzbc.zzg && l.a(this.zzh, zzbc.zzh) && this.zzi == zzbc.zzi && this.zzj == zzbc.zzj && l.a(this.zzk, zzbc.zzk);
    }

    public final int hashCode() {
        return this.zzb.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.zzb);
        if (this.zzd != null) {
            sb.append(" tag=");
            sb.append(this.zzd);
        }
        if (this.zzh != null) {
            sb.append(" moduleId=");
            sb.append(this.zzh);
        }
        if (this.zzk != null) {
            sb.append(" contextAttributionTag=");
            sb.append(this.zzk);
        }
        sb.append(" hideAppOps=");
        sb.append(this.zze);
        sb.append(" clients=");
        sb.append(this.zzc);
        sb.append(" forceCoarseLocation=");
        sb.append(this.zzf);
        if (this.zzg) {
            sb.append(" exemptFromBackgroundThrottle");
        }
        if (this.zzi) {
            sb.append(" locationSettingsIgnored");
        }
        if (this.zzj) {
            sb.append(" inaccurateLocationsDelayed");
        }
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = a.a(parcel);
        a.a(parcel, 1, (Parcelable) this.zzb, i2, false);
        a.c(parcel, 5, this.zzc, false);
        a.a(parcel, 6, this.zzd, false);
        a.a(parcel, 7, this.zze);
        a.a(parcel, 8, this.zzf);
        a.a(parcel, 9, this.zzg);
        a.a(parcel, 10, this.zzh, false);
        a.a(parcel, 11, this.zzi);
        a.a(parcel, 12, this.zzj);
        a.a(parcel, 13, this.zzk, false);
        a.a(parcel, 14, this.zzl);
        a.a(parcel, a2);
    }

    public final zzbc zza(long j2) {
        if (this.zzb.c() <= this.zzb.b()) {
            this.zzl = 10000;
            return this;
        }
        long b2 = this.zzb.b();
        long c2 = this.zzb.c();
        StringBuilder sb = new StringBuilder(120);
        sb.append("could not set max age when location batching is requested, interval=");
        sb.append(b2);
        sb.append("maxWaitTime=");
        sb.append(c2);
        throw new IllegalArgumentException(sb.toString());
    }

    public final zzbc zza(String str) {
        this.zzk = str;
        return this;
    }

    public final zzbc zza(boolean z2) {
        this.zzj = true;
        return this;
    }
}
