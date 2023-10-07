package com.google.android.gms.internal.gtm;

import android.content.Context;
import com.google.android.gms.common.internal.m;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.Future;

public final class zzcn extends zzbs {
    private volatile String zza;
    private Future<String> zzb;

    protected zzcn(zzbv zzbv) {
        super(zzbv);
    }

    /* access modifiers changed from: private */
    public final String zzf() {
        FileOutputStream fileOutputStream;
        String lowerCase = UUID.randomUUID().toString().toLowerCase(Locale.US);
        try {
            Context zza2 = zzq().zza();
            m.a(lowerCase);
            m.c("ClientId should be saved from worker thread");
            fileOutputStream = null;
            try {
                zzP("Storing clientId", lowerCase);
                fileOutputStream = zza2.openFileOutput("gaClientId", 0);
                fileOutputStream.write(lowerCase.getBytes());
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e2) {
                        zzK("Failed to close clientId writing stream", e2);
                    }
                }
                return lowerCase;
                zzK("Failed to close clientId writing stream", e);
                return "0";
            } catch (FileNotFoundException e3) {
                zzK("Error creating clientId file", e3);
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e4) {
                        e = e4;
                    }
                }
                return "0";
            } catch (IOException e5) {
                zzK("Error writing to clientId file", e5);
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e6) {
                        e = e6;
                    }
                }
                return "0";
            }
        } catch (Exception e7) {
            zzK("Error saving clientId file", e7);
            return "0";
        } catch (Throwable th) {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e8) {
                    zzK("Failed to close clientId writing stream", e8);
                }
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x003c A[Catch:{ InterruptedException -> 0x002f, ExecutionException -> 0x0024 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String zzb() {
        /*
            r2 = this;
            r2.zzW()
            monitor-enter(r2)
            java.lang.String r0 = r2.zza     // Catch:{ all -> 0x004e }
            if (r0 != 0) goto L_0x0017
            com.google.android.gms.analytics.zzr r0 = r2.zzq()     // Catch:{ all -> 0x004e }
            com.google.android.gms.internal.gtm.zzcl r1 = new com.google.android.gms.internal.gtm.zzcl     // Catch:{ all -> 0x004e }
            r1.<init>(r2)     // Catch:{ all -> 0x004e }
            java.util.concurrent.Future r0 = r0.zzg(r1)     // Catch:{ all -> 0x004e }
            r2.zzb = r0     // Catch:{ all -> 0x004e }
        L_0x0017:
            java.util.concurrent.Future<java.lang.String> r0 = r2.zzb     // Catch:{ all -> 0x004e }
            if (r0 == 0) goto L_0x004a
            java.lang.Object r0 = r0.get()     // Catch:{ InterruptedException -> 0x002f, ExecutionException -> 0x0024 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ InterruptedException -> 0x002f, ExecutionException -> 0x0024 }
            r2.zza = r0     // Catch:{ InterruptedException -> 0x002f, ExecutionException -> 0x0024 }
            goto L_0x0038
        L_0x0024:
            r0 = move-exception
            java.lang.String r1 = "Failed to load or generate client id"
            r2.zzK(r1, r0)     // Catch:{ all -> 0x004e }
            java.lang.String r0 = "0"
        L_0x002c:
            r2.zza = r0     // Catch:{ all -> 0x004e }
            goto L_0x0038
        L_0x002f:
            r0 = move-exception
            java.lang.String r1 = "ClientId loading or generation was interrupted"
            r2.zzS(r1, r0)     // Catch:{ all -> 0x004e }
            java.lang.String r0 = "0"
            goto L_0x002c
        L_0x0038:
            java.lang.String r0 = r2.zza     // Catch:{ all -> 0x004e }
            if (r0 != 0) goto L_0x0040
            java.lang.String r0 = "0"
            r2.zza = r0     // Catch:{ all -> 0x004e }
        L_0x0040:
            java.lang.String r0 = "Loaded clientId"
            java.lang.String r1 = r2.zza     // Catch:{ all -> 0x004e }
            r2.zzP(r0, r1)     // Catch:{ all -> 0x004e }
            r0 = 0
            r2.zzb = r0     // Catch:{ all -> 0x004e }
        L_0x004a:
            java.lang.String r0 = r2.zza     // Catch:{ all -> 0x004e }
            monitor-exit(r2)     // Catch:{ all -> 0x004e }
            return r0
        L_0x004e:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x004e }
            goto L_0x0052
        L_0x0051:
            throw r0
        L_0x0052:
            goto L_0x0051
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzcn.zzb():java.lang.String");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r3v1 */
    /* JADX WARNING: type inference failed for: r3v3, types: [java.io.FileInputStream] */
    /* JADX WARNING: type inference failed for: r3v4 */
    /* JADX WARNING: type inference failed for: r3v5 */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0076 A[SYNTHETIC, Splitter:B:36:0x0076] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x007e A[SYNTHETIC, Splitter:B:41:0x007e] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x008a A[SYNTHETIC, Splitter:B:49:0x008a] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0099 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String zzc() {
        /*
            r9 = this;
            java.lang.String r0 = "gaClientId"
            java.lang.String r1 = "Failed to close client id reading stream"
            com.google.android.gms.analytics.zzr r2 = r9.zzq()
            android.content.Context r2 = r2.zza()
            java.lang.String r3 = "ClientId should be loaded from worker thread"
            com.google.android.gms.common.internal.m.c(r3)
            r3 = 0
            java.io.FileInputStream r4 = r2.openFileInput(r0)     // Catch:{ FileNotFoundException -> 0x0087, IOException -> 0x006a, all -> 0x0068 }
            r5 = 36
            byte[] r6 = new byte[r5]     // Catch:{ FileNotFoundException -> 0x0066, IOException -> 0x0064 }
            r7 = 0
            int r5 = r4.read(r6, r7, r5)     // Catch:{ FileNotFoundException -> 0x0066, IOException -> 0x0064 }
            int r8 = r4.available()     // Catch:{ FileNotFoundException -> 0x0066, IOException -> 0x0064 }
            if (r8 <= 0) goto L_0x0036
            java.lang.String r5 = "clientId file seems corrupted, deleting it."
            r9.zzR(r5)     // Catch:{ FileNotFoundException -> 0x0066, IOException -> 0x0064 }
            r4.close()     // Catch:{ FileNotFoundException -> 0x0066, IOException -> 0x0064 }
            r2.deleteFile(r0)     // Catch:{ FileNotFoundException -> 0x0066, IOException -> 0x0064 }
            if (r4 == 0) goto L_0x0092
            r4.close()     // Catch:{ IOException -> 0x008e }
            goto L_0x0092
        L_0x0036:
            r8 = 14
            if (r5 >= r8) goto L_0x004b
            java.lang.String r5 = "clientId file is empty, deleting it."
            r9.zzR(r5)     // Catch:{ FileNotFoundException -> 0x0066, IOException -> 0x0064 }
            r4.close()     // Catch:{ FileNotFoundException -> 0x0066, IOException -> 0x0064 }
            r2.deleteFile(r0)     // Catch:{ FileNotFoundException -> 0x0066, IOException -> 0x0064 }
            if (r4 == 0) goto L_0x0092
            r4.close()     // Catch:{ IOException -> 0x008e }
            goto L_0x0092
        L_0x004b:
            r4.close()     // Catch:{ FileNotFoundException -> 0x0066, IOException -> 0x0064 }
            java.lang.String r8 = new java.lang.String     // Catch:{ FileNotFoundException -> 0x0066, IOException -> 0x0064 }
            r8.<init>(r6, r7, r5)     // Catch:{ FileNotFoundException -> 0x0066, IOException -> 0x0064 }
            java.lang.String r5 = "Read client id from disk"
            r9.zzP(r5, r8)     // Catch:{ FileNotFoundException -> 0x0066, IOException -> 0x0064 }
            if (r4 == 0) goto L_0x0062
            r4.close()     // Catch:{ IOException -> 0x005e }
            goto L_0x0062
        L_0x005e:
            r0 = move-exception
            r9.zzK(r1, r0)
        L_0x0062:
            r3 = r8
            goto L_0x0092
        L_0x0064:
            r5 = move-exception
            goto L_0x006c
        L_0x0066:
            goto L_0x0088
        L_0x0068:
            r0 = move-exception
            goto L_0x007c
        L_0x006a:
            r5 = move-exception
            r4 = r3
        L_0x006c:
            java.lang.String r6 = "Error reading client id file, deleting it"
            r9.zzK(r6, r5)     // Catch:{ all -> 0x007a }
            r2.deleteFile(r0)     // Catch:{ all -> 0x007a }
            if (r4 == 0) goto L_0x0092
            r4.close()     // Catch:{ IOException -> 0x008e }
            goto L_0x0092
        L_0x007a:
            r0 = move-exception
            r3 = r4
        L_0x007c:
            if (r3 == 0) goto L_0x0086
            r3.close()     // Catch:{ IOException -> 0x0082 }
            goto L_0x0086
        L_0x0082:
            r2 = move-exception
            r9.zzK(r1, r2)
        L_0x0086:
            throw r0
        L_0x0087:
            r4 = r3
        L_0x0088:
            if (r4 == 0) goto L_0x0092
            r4.close()     // Catch:{ IOException -> 0x008e }
            goto L_0x0092
        L_0x008e:
            r0 = move-exception
            r9.zzK(r1, r0)
        L_0x0092:
            if (r3 != 0) goto L_0x0099
            java.lang.String r0 = r9.zzf()
            return r0
        L_0x0099:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzcn.zzc():java.lang.String");
    }

    /* access modifiers changed from: protected */
    public final void zzd() {
    }

    /* access modifiers changed from: package-private */
    public final String zze() {
        synchronized (this) {
            this.zza = null;
            this.zzb = zzq().zzg(new zzcm(this));
        }
        return zzb();
    }
}
