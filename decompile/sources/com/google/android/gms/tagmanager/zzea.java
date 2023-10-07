package com.google.android.gms.tagmanager;

import android.net.Uri;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

final class zzea {
    private static zzea zza;
    private volatile String zzb = null;
    private volatile String zzc = null;
    private volatile String zzd = null;
    private volatile int zze = 1;

    zzea() {
    }

    static zzea zza() {
        zzea zzea;
        synchronized (zzea.class) {
            if (zza == null) {
                zza = new zzea();
            }
            zzea = zza;
        }
        return zzea;
    }

    private static final String zzf(String str) {
        return str.split("&")[0].split("=")[1];
    }

    /* access modifiers changed from: package-private */
    public final String zzb() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final String zzc() {
        return this.zzb;
    }

    /* access modifiers changed from: package-private */
    public final synchronized boolean zzd(Uri uri) {
        try {
            String decode = URLDecoder.decode(uri.toString(), "UTF-8");
            if (decode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_auth=\\S+&gtm_preview=\\d+(&gtm_debug=x)?$")) {
                String valueOf = String.valueOf(decode);
                zzdh.zzb.zzd(valueOf.length() != 0 ? "Container preview url: ".concat(valueOf) : new String("Container preview url: "));
                if (decode.matches(".*?&gtm_debug=x$")) {
                    this.zze = 3;
                } else {
                    this.zze = 2;
                }
                this.zzd = uri.getQuery().replace("&gtm_debug=x", "");
                if (this.zze == 2 || this.zze == 3) {
                    String valueOf2 = String.valueOf(this.zzd);
                    this.zzc = valueOf2.length() != 0 ? "/r?".concat(valueOf2) : new String("/r?");
                }
                this.zzb = zzf(this.zzd);
                return true;
            } else if (!decode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_preview=$")) {
                String valueOf3 = String.valueOf(decode);
                zzdh.zzc(valueOf3.length() != 0 ? "Invalid preview uri: ".concat(valueOf3) : new String("Invalid preview uri: "));
                return false;
            } else if (!zzf(uri.getQuery()).equals(this.zzb)) {
                return false;
            } else {
                String valueOf4 = String.valueOf(this.zzb);
                zzdh.zzb.zzd(valueOf4.length() != 0 ? "Exit preview mode for container: ".concat(valueOf4) : new String("Exit preview mode for container: "));
                this.zze = 1;
                this.zzc = null;
                return true;
            }
        } catch (UnsupportedEncodingException unused) {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final int zze() {
        return this.zze;
    }
}
