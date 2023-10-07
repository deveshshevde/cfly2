package com.google.android.gms.analytics;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.internal.gtm.zzav;
import com.google.android.gms.internal.gtm.zzba;
import com.google.android.gms.internal.gtm.zzfs;
import java.lang.Thread;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public final class zzr {
    private static volatile zzr zza;
    private final Context zzb;
    /* access modifiers changed from: private */
    public final List<zzs> zzc = new CopyOnWriteArrayList();
    private final zzg zzd = new zzg();
    private final zzn zze = new zzn(this);
    private volatile zzav zzf;
    /* access modifiers changed from: private */
    public Thread.UncaughtExceptionHandler zzg;

    zzr(Context context) {
        Context applicationContext = context.getApplicationContext();
        m.a(applicationContext);
        this.zzb = applicationContext;
    }

    public static zzr zzb(Context context) {
        m.a(context);
        if (zza == null) {
            synchronized (zzr.class) {
                if (zza == null) {
                    zza = new zzr(context);
                }
            }
        }
        return zza;
    }

    public static void zzh() {
        if (!(Thread.currentThread() instanceof zzq)) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    public final Context zza() {
        return this.zzb;
    }

    public final zzav zzc() {
        if (this.zzf == null) {
            synchronized (this) {
                if (this.zzf == null) {
                    zzav zzav = new zzav();
                    PackageManager packageManager = this.zzb.getPackageManager();
                    String packageName = this.zzb.getPackageName();
                    zzav.zzi(packageName);
                    zzav.zzj(packageManager.getInstallerPackageName(packageName));
                    String str = null;
                    try {
                        PackageInfo packageInfo = packageManager.getPackageInfo(this.zzb.getPackageName(), 0);
                        if (packageInfo != null) {
                            CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                            if (!TextUtils.isEmpty(applicationLabel)) {
                                packageName = applicationLabel.toString();
                            }
                            str = packageInfo.versionName;
                        }
                    } catch (PackageManager.NameNotFoundException unused) {
                        String valueOf = String.valueOf(packageName);
                        Log.e("GAv4", valueOf.length() != 0 ? "Error retrieving package info: appName set to ".concat(valueOf) : new String("Error retrieving package info: appName set to "));
                    }
                    zzav.zzk(packageName);
                    zzav.zzl(str);
                    this.zzf = zzav;
                }
            }
        }
        return this.zzf;
    }

    public final zzba zzd() {
        DisplayMetrics displayMetrics = this.zzb.getResources().getDisplayMetrics();
        zzba zzba = new zzba();
        zzba.zze(zzfs.zzd(Locale.getDefault()));
        zzba.zza = displayMetrics.widthPixels;
        zzba.zzb = displayMetrics.heightPixels;
        return zzba;
    }

    public final <V> Future<V> zzg(Callable<V> callable) {
        m.a(callable);
        if (!(Thread.currentThread() instanceof zzq)) {
            return this.zze.submit(callable);
        }
        FutureTask futureTask = new FutureTask(callable);
        futureTask.run();
        return futureTask;
    }

    public final void zzi(Runnable runnable) {
        m.a(runnable);
        this.zze.submit(runnable);
    }

    public final void zzj(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.zzg = uncaughtExceptionHandler;
    }

    /* access modifiers changed from: package-private */
    public final void zzk(zzh zzh) {
        if (zzh.zzl()) {
            throw new IllegalStateException("Measurement prototype can't be submitted");
        } else if (!zzh.zzm()) {
            zzh zzh2 = new zzh(zzh);
            zzh2.zzi();
            this.zze.execute(new zzl(this, zzh2));
        } else {
            throw new IllegalStateException("Measurement can only be submitted once");
        }
    }
}
