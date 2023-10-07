package com.google.android.gms.analytics;

import android.net.Uri;
import android.text.TextUtils;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.internal.gtm.zzbs;
import com.google.android.gms.internal.gtm.zzbv;
import com.google.android.gms.internal.gtm.zzez;
import com.google.android.gms.internal.gtm.zzfr;
import com.google.android.gms.internal.gtm.zzfs;
import fg.i;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

public class Tracker extends zzbs {
    private boolean zza;
    private final Map<String, String> zzb;
    private final Map<String, String> zzc = new HashMap();
    /* access modifiers changed from: private */
    public final zzez zzd;
    /* access modifiers changed from: private */
    public final zzv zze;
    private ExceptionReporter zzf;
    /* access modifiers changed from: private */
    public zzfr zzg;

    Tracker(zzbv zzbv, String str, zzez zzez) {
        super(zzbv);
        HashMap hashMap = new HashMap();
        this.zzb = hashMap;
        if (str != null) {
            hashMap.put("&tid", str);
        }
        hashMap.put("useSecure", "1");
        hashMap.put("&a", Integer.toString(new Random().nextInt(SubsamplingScaleImageView.TILE_SIZE_AUTO) + 1));
        this.zzd = new zzez(60, 2000, "tracking", zzC());
        this.zze = new zzv(this, zzbv);
    }

    private static void zzZ(Map<String, String> map, Map<String, String> map2) {
        m.a(map2);
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                String zzn = zzn(next);
                if (zzn != null) {
                    map2.put(zzn, (String) next.getValue());
                }
            }
        }
    }

    private static String zzn(Map.Entry<String, String> entry) {
        String key = entry.getKey();
        if (!key.startsWith("&") || key.length() < 2) {
            return null;
        }
        return entry.getKey().substring(1);
    }

    public void enableAdvertisingIdCollection(boolean z2) {
        this.zza = z2;
    }

    public void enableAutoActivityTracking(boolean z2) {
        this.zze.zzc(z2);
    }

    public void enableExceptionReporting(boolean z2) {
        String str;
        synchronized (this) {
            ExceptionReporter exceptionReporter = this.zzf;
            if ((exceptionReporter != null) != z2) {
                if (z2) {
                    ExceptionReporter exceptionReporter2 = new ExceptionReporter(this, Thread.getDefaultUncaughtExceptionHandler(), zzo());
                    this.zzf = exceptionReporter2;
                    Thread.setDefaultUncaughtExceptionHandler(exceptionReporter2);
                    str = "Uncaught exceptions will be reported to Google Analytics";
                } else {
                    Thread.setDefaultUncaughtExceptionHandler(exceptionReporter.zza());
                    str = "Uncaught exceptions will not be reported to Google Analytics";
                }
                zzO(str);
            }
        }
    }

    public String get(String str) {
        zzW();
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.zzb.containsKey(str)) {
            return this.zzb.get(str);
        }
        if (str.equals("&ul")) {
            return zzfs.zzd(Locale.getDefault());
        }
        if (str.equals("&cid")) {
            return zzv().zzb();
        }
        if (str.equals("&sr")) {
            return zzx().zzb();
        }
        if (str.equals("&aid")) {
            return zzu().zza().zzd();
        }
        if (str.equals("&an")) {
            return zzu().zza().zzf();
        }
        if (str.equals("&av")) {
            return zzu().zza().zzg();
        }
        if (str.equals("&aiid")) {
            return zzu().zza().zze();
        }
        return null;
    }

    public void send(Map<String, String> map) {
        long a2 = zzC().a();
        if (zzp().getAppOptOut()) {
            zzF("AppOptOut is set to true. Not sending Google Analytics hit");
            return;
        }
        boolean isDryRunEnabled = zzp().isDryRunEnabled();
        HashMap hashMap = new HashMap();
        zzZ(this.zzb, hashMap);
        zzZ(map, hashMap);
        String str = this.zzb.get("useSecure");
        int i2 = 1;
        boolean z2 = str == null || str.equalsIgnoreCase("true") || str.equalsIgnoreCase("yes") || str.equalsIgnoreCase("1") || (!str.equalsIgnoreCase("false") && !str.equalsIgnoreCase("no") && !str.equalsIgnoreCase("0"));
        Map<String, String> map2 = this.zzc;
        m.a(hashMap);
        for (Map.Entry next : map2.entrySet()) {
            String zzn = zzn(next);
            if (zzn != null && !hashMap.containsKey(zzn)) {
                hashMap.put(zzn, (String) next.getValue());
            }
        }
        this.zzc.clear();
        String str2 = (String) hashMap.get("t");
        if (TextUtils.isEmpty(str2)) {
            zzz().zzc(hashMap, "Missing hit type parameter");
            return;
        }
        String str3 = (String) hashMap.get("tid");
        if (!TextUtils.isEmpty(str3)) {
            boolean z3 = this.zza;
            synchronized (this) {
                if ("screenview".equalsIgnoreCase(str2) || "pageview".equalsIgnoreCase(str2) || "appview".equalsIgnoreCase(str2) || TextUtils.isEmpty(str2)) {
                    String str4 = this.zzb.get("&a");
                    m.a(str4);
                    int parseInt = Integer.parseInt(str4) + 1;
                    if (parseInt < Integer.MAX_VALUE) {
                        i2 = parseInt;
                    }
                    this.zzb.put("&a", Integer.toString(i2));
                }
            }
            zzq().zzi(new zzu(this, hashMap, z3, str2, a2, isDryRunEnabled, z2, str3));
            return;
        }
        zzz().zzc(hashMap, "Missing tracking id parameter");
    }

    public void set(String str, String str2) {
        m.a(str, (Object) "Key should be non-null");
        if (!TextUtils.isEmpty(str)) {
            this.zzb.put(str, str2);
        }
    }

    public void setAnonymizeIp(boolean z2) {
        set("&aip", zzfs.zzc(z2));
    }

    public void setAppId(String str) {
        set("&aid", str);
    }

    public void setAppInstallerId(String str) {
        set("&aiid", str);
    }

    public void setAppName(String str) {
        set("&an", str);
    }

    public void setAppVersion(String str) {
        set("&av", str);
    }

    public void setCampaignParamsOnNextHit(Uri uri) {
        if (uri != null && !uri.isOpaque()) {
            String queryParameter = uri.getQueryParameter("referrer");
            if (!TextUtils.isEmpty(queryParameter)) {
                String valueOf = String.valueOf(queryParameter);
                Uri parse = Uri.parse(valueOf.length() != 0 ? "http://hostname/?".concat(valueOf) : new String("http://hostname/?"));
                String queryParameter2 = parse.getQueryParameter("utm_id");
                if (queryParameter2 != null) {
                    this.zzc.put("&ci", queryParameter2);
                }
                String queryParameter3 = parse.getQueryParameter("anid");
                if (queryParameter3 != null) {
                    this.zzc.put("&anid", queryParameter3);
                }
                String queryParameter4 = parse.getQueryParameter("utm_campaign");
                if (queryParameter4 != null) {
                    this.zzc.put("&cn", queryParameter4);
                }
                String queryParameter5 = parse.getQueryParameter("utm_content");
                if (queryParameter5 != null) {
                    this.zzc.put("&cc", queryParameter5);
                }
                String queryParameter6 = parse.getQueryParameter("utm_medium");
                if (queryParameter6 != null) {
                    this.zzc.put("&cm", queryParameter6);
                }
                String queryParameter7 = parse.getQueryParameter("utm_source");
                if (queryParameter7 != null) {
                    this.zzc.put("&cs", queryParameter7);
                }
                String queryParameter8 = parse.getQueryParameter("utm_term");
                if (queryParameter8 != null) {
                    this.zzc.put("&ck", queryParameter8);
                }
                String queryParameter9 = parse.getQueryParameter("dclid");
                if (queryParameter9 != null) {
                    this.zzc.put("&dclid", queryParameter9);
                }
                String queryParameter10 = parse.getQueryParameter("gclid");
                if (queryParameter10 != null) {
                    this.zzc.put("&gclid", queryParameter10);
                }
                String queryParameter11 = parse.getQueryParameter("aclid");
                if (queryParameter11 != null) {
                    this.zzc.put("&aclid", queryParameter11);
                }
            }
        }
    }

    public void setClientId(String str) {
        set("&cid", str);
    }

    public void setEncoding(String str) {
        set("&de", str);
    }

    public void setHostname(String str) {
        set("&dh", str);
    }

    public void setLanguage(String str) {
        set("&ul", str);
    }

    public void setLocation(String str) {
        set("&dl", str);
    }

    public void setPage(String str) {
        set("&dp", str);
    }

    public void setReferrer(String str) {
        set("&dr", str);
    }

    public void setSampleRate(double d2) {
        set("&sf", Double.toString(d2));
    }

    public void setScreenColors(String str) {
        set("&sd", str);
    }

    public void setScreenName(String str) {
        set("&cd", str);
    }

    public void setScreenResolution(int i2, int i3) {
        if (i2 >= 0 || i3 >= 0) {
            StringBuilder sb = new StringBuilder(23);
            sb.append(i2);
            sb.append("x");
            sb.append(i3);
            set("&sr", sb.toString());
            return;
        }
        zzR("Invalid width or height. The values should be non-negative.");
    }

    public void setSessionTimeout(long j2) {
        this.zze.zze(j2 * 1000);
    }

    public void setTitle(String str) {
        set("&dt", str);
    }

    public void setUseSecure(boolean z2) {
        set("useSecure", zzfs.zzc(z2));
    }

    public void setViewportSize(String str) {
        set("&vp", str);
    }

    /* access modifiers changed from: protected */
    public final void zzd() {
        this.zze.zzX();
        String zza2 = zzB().zza();
        if (zza2 != null) {
            set("&an", zza2);
        }
        String zzb2 = zzB().zzb();
        if (zzb2 != null) {
            set("&av", zzb2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzm(zzfr zzfr) {
        zzO("Loading Tracker config values");
        this.zzg = zzfr;
        String str = zzfr.zza;
        if (str != null) {
            set("&tid", str);
            zzP("trackingId loaded", str);
        }
        double d2 = zzfr.zzb;
        if (d2 >= i.f27244a) {
            String d3 = Double.toString(d2);
            set("&sf", d3);
            zzP("Sample frequency loaded", d3);
        }
        int i2 = zzfr.zzc;
        if (i2 >= 0) {
            setSessionTimeout((long) i2);
            zzP("Session timeout loaded", Integer.valueOf(i2));
        }
        int i3 = zzfr.zzd;
        boolean z2 = false;
        if (i3 != -1) {
            boolean z3 = 1 == i3;
            enableAutoActivityTracking(z3);
            zzP("Auto activity tracking loaded", Boolean.valueOf(z3));
        }
        int i4 = zzfr.zze;
        if (i4 != -1) {
            if (i4 != 0) {
                set("&aip", "1");
            }
            zzP("Anonymize ip loaded", Boolean.valueOf(1 == i4));
        }
        if (zzfr.zzf == 1) {
            z2 = true;
        }
        enableExceptionReporting(z2);
    }
}
