package com.google.android.gms.tagmanager;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import gf.a;
import java.io.IOException;

final class zza implements zzc {
    final /* synthetic */ zzd zza;

    zza(zzd zzd) {
        this.zza = zzd;
    }

    public final a.C0184a zza() {
        String str;
        try {
            return a.a(this.zza.zzi);
        } catch (IllegalStateException e2) {
            e = e2;
            str = "IllegalStateException getting Advertising Id Info";
            zzdh.zzd(str, e);
            return null;
        } catch (GooglePlayServicesRepairableException e3) {
            e = e3;
            str = "GooglePlayServicesRepairableException getting Advertising Id Info";
            zzdh.zzd(str, e);
            return null;
        } catch (IOException e4) {
            e = e4;
            str = "IOException getting Ad Id Info";
            zzdh.zzd(str, e);
            return null;
        } catch (GooglePlayServicesNotAvailableException e5) {
            e = e5;
            this.zza.zze();
            str = "GooglePlayServicesNotAvailableException getting Advertising Id Info";
            zzdh.zzd(str, e);
            return null;
        } catch (Exception e6) {
            e = e6;
            str = "Unknown exception. Could not get the Advertising Id Info.";
            zzdh.zzd(str, e);
            return null;
        }
    }
}
