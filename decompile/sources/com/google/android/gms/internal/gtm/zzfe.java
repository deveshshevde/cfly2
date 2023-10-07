package com.google.android.gms.internal.gtm;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import com.google.android.gms.analytics.zzr;
import com.google.android.gms.common.internal.m;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Locale;
import java.util.Map;

final class zzfe extends zzbs {
    /* access modifiers changed from: private */
    public static final byte[] zza = "\n".getBytes();
    private final String zzb = String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[]{"GoogleAnalytics", zzbt.zza, Build.VERSION.RELEASE, zzfs.zzd(Locale.getDefault()), Build.MODEL, Build.ID});
    private final zzfo zzc;

    zzfe(zzbv zzbv) {
        super(zzbv);
        this.zzc = new zzfo(zzbv.zzr());
    }

    /* JADX WARNING: type inference failed for: r2v2 */
    /* JADX WARNING: type inference failed for: r2v3, types: [java.io.OutputStream] */
    /* JADX WARNING: type inference failed for: r2v4, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r2v5 */
    /* JADX WARNING: type inference failed for: r2v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0081 A[SYNTHETIC, Splitter:B:31:0x0081] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0096 A[SYNTHETIC, Splitter:B:40:0x0096] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzg(java.net.URL r6, byte[] r7) {
        /*
            r5 = this;
            java.lang.String r0 = "Error closing http post connection output stream"
            com.google.android.gms.common.internal.m.a(r6)
            com.google.android.gms.common.internal.m.a(r7)
            int r1 = r7.length
            java.lang.Integer r2 = java.lang.Integer.valueOf(r1)
            java.lang.String r3 = "POST bytes, url"
            r5.zzH(r3, r2, r6)
            boolean r2 = zzV()
            if (r2 == 0) goto L_0x0022
            java.lang.String r2 = new java.lang.String
            r2.<init>(r7)
            java.lang.String r3 = "Post payload\n"
            r5.zzP(r3, r2)
        L_0x0022:
            r2 = 0
            android.content.Context r3 = r5.zzo()     // Catch:{ IOException -> 0x0077, all -> 0x0073 }
            r3.getPackageName()     // Catch:{ IOException -> 0x0077, all -> 0x0073 }
            java.net.HttpURLConnection r6 = r5.zzb(r6)     // Catch:{ IOException -> 0x0077, all -> 0x0073 }
            r3 = 1
            r6.setDoOutput(r3)     // Catch:{ IOException -> 0x006e, all -> 0x006c }
            r6.setFixedLengthStreamingMode(r1)     // Catch:{ IOException -> 0x006e, all -> 0x006c }
            r6.connect()     // Catch:{ IOException -> 0x006e, all -> 0x006c }
            java.io.OutputStream r2 = r6.getOutputStream()     // Catch:{ IOException -> 0x006e, all -> 0x006c }
            r2.write(r7)     // Catch:{ IOException -> 0x006e, all -> 0x006c }
            r5.zzk(r6)     // Catch:{ IOException -> 0x006e, all -> 0x006c }
            int r7 = r6.getResponseCode()     // Catch:{ IOException -> 0x006e, all -> 0x006c }
            r1 = 200(0xc8, float:2.8E-43)
            if (r7 != r1) goto L_0x0053
            com.google.android.gms.internal.gtm.zzbq r7 = r5.zzs()     // Catch:{ IOException -> 0x006e, all -> 0x006c }
            r7.zzi()     // Catch:{ IOException -> 0x006e, all -> 0x006c }
            r7 = 200(0xc8, float:2.8E-43)
        L_0x0053:
            java.lang.String r1 = "POST status"
            java.lang.Integer r3 = java.lang.Integer.valueOf(r7)     // Catch:{ IOException -> 0x006e, all -> 0x006c }
            r5.zzG(r1, r3)     // Catch:{ IOException -> 0x006e, all -> 0x006c }
            if (r2 == 0) goto L_0x0066
            r2.close()     // Catch:{ IOException -> 0x0062 }
            goto L_0x0066
        L_0x0062:
            r1 = move-exception
            r5.zzK(r0, r1)
        L_0x0066:
            if (r6 == 0) goto L_0x006b
            r6.disconnect()
        L_0x006b:
            return r7
        L_0x006c:
            r7 = move-exception
            goto L_0x0094
        L_0x006e:
            r7 = move-exception
            r4 = r2
            r2 = r6
            r6 = r4
            goto L_0x007a
        L_0x0073:
            r6 = move-exception
            r7 = r6
            r6 = r2
            goto L_0x0094
        L_0x0077:
            r6 = move-exception
            r7 = r6
            r6 = r2
        L_0x007a:
            java.lang.String r1 = "Network POST connection error"
            r5.zzS(r1, r7)     // Catch:{ all -> 0x0090 }
            if (r6 == 0) goto L_0x0089
            r6.close()     // Catch:{ IOException -> 0x0085 }
            goto L_0x0089
        L_0x0085:
            r6 = move-exception
            r5.zzK(r0, r6)
        L_0x0089:
            if (r2 == 0) goto L_0x008e
            r2.disconnect()
        L_0x008e:
            r6 = 0
            return r6
        L_0x0090:
            r7 = move-exception
            r4 = r2
            r2 = r6
            r6 = r4
        L_0x0094:
            if (r2 == 0) goto L_0x009e
            r2.close()     // Catch:{ IOException -> 0x009a }
            goto L_0x009e
        L_0x009a:
            r1 = move-exception
            r5.zzK(r0, r1)
        L_0x009e:
            if (r6 == 0) goto L_0x00a3
            r6.disconnect()
        L_0x00a3:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzfe.zzg(java.net.URL, byte[]):int");
    }

    private final URL zzh() {
        zzw();
        String zzi = zzct.zzi();
        zzw();
        String zzb2 = zzeu.zzt.zzb();
        try {
            return new URL(zzb2.length() != 0 ? zzi.concat(zzb2) : new String(zzi));
        } catch (MalformedURLException e2) {
            zzK("Error trying to parse the hardcoded host url", e2);
            return null;
        }
    }

    private final URL zzi(zzex zzex) {
        String str;
        String str2;
        String str3;
        String str4;
        boolean zzh = zzex.zzh();
        zzw();
        if (zzh) {
            str3 = zzct.zzi();
            zzw();
            str4 = zzct.zzj();
            if (str4.length() == 0) {
                str2 = new String(str3);
                str = str2;
                return new URL(str);
            }
        } else {
            str3 = zzct.zzk();
            zzw();
            str4 = zzct.zzj();
            if (str4.length() == 0) {
                str2 = new String(str3);
                str = str2;
                return new URL(str);
            }
        }
        str = str3.concat(str4);
        try {
            return new URL(str);
        } catch (MalformedURLException e2) {
            zzK("Error trying to parse the hardcoded host url", e2);
            return null;
        }
    }

    private final URL zzj(zzex zzex, String str) {
        String str2;
        StringBuilder sb;
        String str3;
        boolean zzh = zzex.zzh();
        zzw();
        if (zzh) {
            str2 = zzct.zzi();
            zzw();
            str3 = zzct.zzj();
            int length = str2.length();
            sb = new StringBuilder(length + 1 + str3.length() + str.length());
        } else {
            str2 = zzct.zzk();
            zzw();
            str3 = zzct.zzj();
            int length2 = str2.length();
            sb = new StringBuilder(length2 + 1 + str3.length() + str.length());
        }
        sb.append(str2);
        sb.append(str3);
        sb.append("?");
        sb.append(str);
        try {
            return new URL(sb.toString());
        } catch (MalformedURLException e2) {
            zzK("Error trying to parse the hardcoded host url", e2);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0021 A[SYNTHETIC, Splitter:B:18:0x0021] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzk(java.net.HttpURLConnection r4) throws java.io.IOException {
        /*
            r3 = this;
            java.lang.String r0 = "Error closing http connection input stream"
            java.io.InputStream r4 = r4.getInputStream()     // Catch:{ all -> 0x001d }
            r1 = 1024(0x400, float:1.435E-42)
            byte[] r1 = new byte[r1]     // Catch:{ all -> 0x001b }
        L_0x000a:
            int r2 = r4.read(r1)     // Catch:{ all -> 0x001b }
            if (r2 > 0) goto L_0x000a
            if (r4 == 0) goto L_0x001a
            r4.close()     // Catch:{ IOException -> 0x0016 }
            return
        L_0x0016:
            r4 = move-exception
            r3.zzK(r0, r4)
        L_0x001a:
            return
        L_0x001b:
            r1 = move-exception
            goto L_0x001f
        L_0x001d:
            r1 = move-exception
            r4 = 0
        L_0x001f:
            if (r4 == 0) goto L_0x0029
            r4.close()     // Catch:{ IOException -> 0x0025 }
            goto L_0x0029
        L_0x0025:
            r4 = move-exception
            r3.zzK(r0, r4)
        L_0x0029:
            goto L_0x002b
        L_0x002a:
            throw r1
        L_0x002b:
            goto L_0x002a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzfe.zzk(java.net.HttpURLConnection):void");
    }

    private static final void zzl(StringBuilder sb, String str, String str2) throws UnsupportedEncodingException {
        if (sb.length() != 0) {
            sb.append('&');
        }
        sb.append(URLEncoder.encode(str, "UTF-8"));
        sb.append('=');
        sb.append(URLEncoder.encode(str2, "UTF-8"));
    }

    /* access modifiers changed from: package-private */
    public final String zza(zzex zzex, boolean z2) {
        m.a(zzex);
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry next : zzex.zzg().entrySet()) {
                String str = (String) next.getKey();
                if (!"ht".equals(str) && !"qt".equals(str) && !"AppUID".equals(str) && !"z".equals(str) && !"_gmsv".equals(str)) {
                    zzl(sb, str, (String) next.getValue());
                }
            }
            zzl(sb, "ht", String.valueOf(zzex.zzd()));
            zzl(sb, "qt", String.valueOf(zzC().a() - zzex.zzd()));
            zzw();
            if (z2) {
                long zzc2 = zzex.zzc();
                zzl(sb, "z", zzc2 != 0 ? String.valueOf(zzc2) : String.valueOf(zzex.zzb()));
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e2) {
            zzK("Failed to encode name or value", e2);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final HttpURLConnection zzb(URL url) throws IOException {
        URLConnection openConnection = url.openConnection();
        if (openConnection instanceof HttpURLConnection) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
            httpURLConnection.setDefaultUseCaches(false);
            zzw();
            httpURLConnection.setConnectTimeout(zzeu.zzE.zzb().intValue());
            zzw();
            httpURLConnection.setReadTimeout(zzeu.zzF.zzb().intValue());
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setRequestProperty("User-Agent", this.zzb);
            httpURLConnection.setDoInput(true);
            return httpURLConnection;
        }
        throw new IOException("Failed to obtain http connection");
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x0203  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0227  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x02c1  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x02c8  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0322 A[EDGE_INSN: B:162:0x0322->B:158:0x0322 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01c2 A[SYNTHETIC, Splitter:B:80:0x01c2] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01cd  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01dc A[SYNTHETIC, Splitter:B:90:0x01dc] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x01e7  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01f5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<java.lang.Long> zzc(java.util.List<com.google.android.gms.internal.gtm.zzex> r20) {
        /*
            r19 = this;
            r1 = r19
            java.lang.String r2 = "Error closing http compressed post connection output stream"
            com.google.android.gms.analytics.zzr.zzh()
            r19.zzW()
            com.google.android.gms.common.internal.m.a(r20)
            com.google.android.gms.internal.gtm.zzct r0 = r19.zzw()
            java.util.Set r0 = r0.zza()
            boolean r0 = r0.isEmpty()
            r4 = 1
            if (r0 != 0) goto L_0x0089
            com.google.android.gms.internal.gtm.zzfo r0 = r1.zzc
            r19.zzw()
            com.google.android.gms.internal.gtm.zzet<java.lang.Integer> r5 = com.google.android.gms.internal.gtm.zzeu.zzC
            java.lang.Object r5 = r5.zzb()
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            long r5 = (long) r5
            r7 = 1000(0x3e8, double:4.94E-321)
            long r5 = r5 * r7
            boolean r0 = r0.zzc(r5)
            if (r0 != 0) goto L_0x0039
            goto L_0x0089
        L_0x0039:
            r19.zzw()
            com.google.android.gms.internal.gtm.zzet<java.lang.String> r0 = com.google.android.gms.internal.gtm.zzeu.zzv
            java.lang.Object r0 = r0.zzb()
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r5 = "BATCH_BY_SESSION"
            boolean r5 = r5.equalsIgnoreCase(r0)
            if (r5 == 0) goto L_0x004e
        L_0x004c:
            r0 = 1
            goto L_0x0073
        L_0x004e:
            java.lang.String r5 = "BATCH_BY_TIME"
            boolean r5 = r5.equalsIgnoreCase(r0)
            if (r5 == 0) goto L_0x0057
            goto L_0x004c
        L_0x0057:
            java.lang.String r5 = "BATCH_BY_BRUTE_FORCE"
            boolean r5 = r5.equalsIgnoreCase(r0)
            if (r5 == 0) goto L_0x0060
            goto L_0x004c
        L_0x0060:
            java.lang.String r5 = "BATCH_BY_COUNT"
            boolean r5 = r5.equalsIgnoreCase(r0)
            if (r5 == 0) goto L_0x0069
            goto L_0x004c
        L_0x0069:
            java.lang.String r5 = "BATCH_BY_SIZE"
            boolean r0 = r5.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x0072
            goto L_0x004c
        L_0x0072:
            r0 = 0
        L_0x0073:
            r19.zzw()
            com.google.android.gms.internal.gtm.zzet<java.lang.String> r5 = com.google.android.gms.internal.gtm.zzeu.zzw
            java.lang.Object r5 = r5.zzb()
            java.lang.String r5 = (java.lang.String) r5
            java.lang.String r6 = "GZIP"
            boolean r5 = r6.equalsIgnoreCase(r5)
            if (r4 == r5) goto L_0x0087
            goto L_0x008a
        L_0x0087:
            r5 = 1
            goto L_0x008b
        L_0x0089:
            r0 = 0
        L_0x008a:
            r5 = 0
        L_0x008b:
            r6 = 200(0xc8, float:2.8E-43)
            if (r0 == 0) goto L_0x0227
            boolean r0 = r20.isEmpty()
            r0 = r0 ^ r4
            com.google.android.gms.common.internal.m.a((boolean) r0)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r5)
            int r8 = r20.size()
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            java.lang.String r9 = "Uploading batched hits. compression, count"
            r1.zzQ(r9, r0, r8)
            com.google.android.gms.internal.gtm.zzfd r8 = new com.google.android.gms.internal.gtm.zzfd
            r8.<init>(r1)
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.util.Iterator r0 = r20.iterator()
        L_0x00b6:
            boolean r10 = r0.hasNext()
            if (r10 == 0) goto L_0x00d5
            java.lang.Object r10 = r0.next()
            com.google.android.gms.internal.gtm.zzex r10 = (com.google.android.gms.internal.gtm.zzex) r10
            boolean r11 = r8.zzb(r10)
            if (r11 != 0) goto L_0x00c9
            goto L_0x00d5
        L_0x00c9:
            long r10 = r10.zzb()
            java.lang.Long r10 = java.lang.Long.valueOf(r10)
            r9.add(r10)
            goto L_0x00b6
        L_0x00d5:
            int r0 = r8.zza()
            if (r0 != 0) goto L_0x00dd
            goto L_0x0226
        L_0x00dd:
            java.net.URL r0 = r19.zzh()
            if (r0 != 0) goto L_0x00ee
            java.lang.String r0 = "Failed to build batching endpoint url"
            r1.zzJ(r0)
        L_0x00e8:
            java.util.List r9 = java.util.Collections.emptyList()
            goto L_0x0226
        L_0x00ee:
            if (r5 == 0) goto L_0x01eb
            byte[] r5 = r8.zzc()
            com.google.android.gms.common.internal.m.a(r0)
            com.google.android.gms.common.internal.m.a(r5)
            android.content.Context r10 = r19.zzo()     // Catch:{ IOException -> 0x01b7, all -> 0x01b1 }
            r10.getPackageName()     // Catch:{ IOException -> 0x01b7, all -> 0x01b1 }
            java.io.ByteArrayOutputStream r10 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x01b7, all -> 0x01b1 }
            r10.<init>()     // Catch:{ IOException -> 0x01b7, all -> 0x01b1 }
            java.util.zip.GZIPOutputStream r11 = new java.util.zip.GZIPOutputStream     // Catch:{ IOException -> 0x01b7, all -> 0x01b1 }
            r11.<init>(r10)     // Catch:{ IOException -> 0x01b7, all -> 0x01b1 }
            r11.write(r5)     // Catch:{ IOException -> 0x01b7, all -> 0x01b1 }
            r11.close()     // Catch:{ IOException -> 0x01b7, all -> 0x01b1 }
            r10.close()     // Catch:{ IOException -> 0x01b7, all -> 0x01b1 }
            byte[] r10 = r10.toByteArray()     // Catch:{ IOException -> 0x01b7, all -> 0x01b1 }
            java.lang.String r11 = "POST compressed size, ratio %, url"
            int r12 = r10.length     // Catch:{ IOException -> 0x01b7, all -> 0x01b1 }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r12)     // Catch:{ IOException -> 0x01b7, all -> 0x01b1 }
            long r14 = (long) r12     // Catch:{ IOException -> 0x01b7, all -> 0x01b1 }
            r16 = 100
            long r14 = r14 * r16
            int r7 = r5.length     // Catch:{ IOException -> 0x01b7, all -> 0x01b1 }
            long r3 = (long) r7     // Catch:{ IOException -> 0x01b7, all -> 0x01b1 }
            long r14 = r14 / r3
            java.lang.Long r3 = java.lang.Long.valueOf(r14)     // Catch:{ IOException -> 0x01b7, all -> 0x01b1 }
            r1.zzI(r11, r13, r3, r0)     // Catch:{ IOException -> 0x01b7, all -> 0x01b1 }
            if (r12 <= r7) goto L_0x0139
            java.lang.String r3 = "Compressed payload is larger then uncompressed. compressed, uncompressed"
            java.lang.Integer r4 = java.lang.Integer.valueOf(r7)     // Catch:{ IOException -> 0x01b7, all -> 0x01b1 }
            r1.zzT(r3, r13, r4)     // Catch:{ IOException -> 0x01b7, all -> 0x01b1 }
        L_0x0139:
            boolean r3 = zzV()     // Catch:{ IOException -> 0x01b7, all -> 0x01b1 }
            if (r3 == 0) goto L_0x015c
            java.lang.String r3 = "Post payload"
            java.lang.String r4 = "\n"
            java.lang.String r7 = new java.lang.String     // Catch:{ IOException -> 0x01b7, all -> 0x01b1 }
            r7.<init>(r5)     // Catch:{ IOException -> 0x01b7, all -> 0x01b1 }
            int r5 = r7.length()     // Catch:{ IOException -> 0x01b7, all -> 0x01b1 }
            if (r5 == 0) goto L_0x0153
            java.lang.String r4 = r4.concat(r7)     // Catch:{ IOException -> 0x01b7, all -> 0x01b1 }
            goto L_0x0159
        L_0x0153:
            java.lang.String r5 = new java.lang.String     // Catch:{ IOException -> 0x01b7, all -> 0x01b1 }
            r5.<init>(r4)     // Catch:{ IOException -> 0x01b7, all -> 0x01b1 }
            r4 = r5
        L_0x0159:
            r1.zzP(r3, r4)     // Catch:{ IOException -> 0x01b7, all -> 0x01b1 }
        L_0x015c:
            java.net.HttpURLConnection r3 = r1.zzb(r0)     // Catch:{ IOException -> 0x01b7, all -> 0x01b1 }
            r0 = 1
            r3.setDoOutput(r0)     // Catch:{ IOException -> 0x01ae, all -> 0x01a8 }
            java.lang.String r0 = "Content-Encoding"
            java.lang.String r4 = "gzip"
            r3.addRequestProperty(r0, r4)     // Catch:{ IOException -> 0x01ae, all -> 0x01a8 }
            r3.setFixedLengthStreamingMode(r12)     // Catch:{ IOException -> 0x01ae, all -> 0x01a8 }
            r3.connect()     // Catch:{ IOException -> 0x01ae, all -> 0x01a8 }
            java.io.OutputStream r4 = r3.getOutputStream()     // Catch:{ IOException -> 0x01ae, all -> 0x01a8 }
            r4.write(r10)     // Catch:{ IOException -> 0x01a3, all -> 0x019e }
            r4.close()     // Catch:{ IOException -> 0x01a3, all -> 0x019e }
            r1.zzk(r3)     // Catch:{ IOException -> 0x01ae, all -> 0x01a8 }
            int r0 = r3.getResponseCode()     // Catch:{ IOException -> 0x01ae, all -> 0x01a8 }
            if (r0 != r6) goto L_0x018d
            com.google.android.gms.internal.gtm.zzbq r0 = r19.zzs()     // Catch:{ IOException -> 0x01ae, all -> 0x01a8 }
            r0.zzi()     // Catch:{ IOException -> 0x01ae, all -> 0x01a8 }
            r0 = 200(0xc8, float:2.8E-43)
        L_0x018d:
            java.lang.String r4 = "POST status"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r0)     // Catch:{ IOException -> 0x01ae, all -> 0x01a8 }
            r1.zzG(r4, r5)     // Catch:{ IOException -> 0x01ae, all -> 0x01a8 }
            if (r3 == 0) goto L_0x019b
            r3.disconnect()
        L_0x019b:
            r3 = r0
            goto L_0x01f3
        L_0x019e:
            r0 = move-exception
            r16 = r3
            r7 = r4
            goto L_0x01ac
        L_0x01a3:
            r0 = move-exception
            r7 = r3
            r16 = r4
            goto L_0x01bb
        L_0x01a8:
            r0 = move-exception
            r16 = r3
            r7 = 0
        L_0x01ac:
            r3 = r0
            goto L_0x01da
        L_0x01ae:
            r0 = move-exception
            r7 = r3
            goto L_0x01b9
        L_0x01b1:
            r0 = move-exception
            r3 = r0
            r7 = 0
            r16 = 0
            goto L_0x01da
        L_0x01b7:
            r0 = move-exception
            r7 = 0
        L_0x01b9:
            r16 = 0
        L_0x01bb:
            java.lang.String r3 = "Network compressed POST connection error"
            r1.zzS(r3, r0)     // Catch:{ all -> 0x01d2 }
            if (r16 == 0) goto L_0x01cb
            r16.close()     // Catch:{ IOException -> 0x01c6 }
            goto L_0x01cb
        L_0x01c6:
            r0 = move-exception
            r3 = r0
            r1.zzK(r2, r3)
        L_0x01cb:
            if (r7 == 0) goto L_0x01d0
            r7.disconnect()
        L_0x01d0:
            r3 = 0
            goto L_0x01f3
        L_0x01d2:
            r0 = move-exception
            r3 = r0
            r18 = r16
            r16 = r7
            r7 = r18
        L_0x01da:
            if (r7 == 0) goto L_0x01e5
            r7.close()     // Catch:{ IOException -> 0x01e0 }
            goto L_0x01e5
        L_0x01e0:
            r0 = move-exception
            r4 = r0
            r1.zzK(r2, r4)
        L_0x01e5:
            if (r16 == 0) goto L_0x01ea
            r16.disconnect()
        L_0x01ea:
            throw r3
        L_0x01eb:
            byte[] r2 = r8.zzc()
            int r3 = r1.zzg(r0, r2)
        L_0x01f3:
            if (r3 != r6) goto L_0x0203
            int r0 = r8.zza()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r2 = "Batched upload completed. Hits batched"
            r1.zzP(r2, r0)
            goto L_0x0226
        L_0x0203:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r3)
            java.lang.String r2 = "Network error uploading hits. status code"
            r1.zzP(r2, r0)
            com.google.android.gms.internal.gtm.zzct r2 = r19.zzw()
            java.util.Set r2 = r2.zza()
            boolean r0 = r2.contains(r0)
            if (r0 == 0) goto L_0x00e8
            java.lang.String r0 = "Server instructed the client to stop batching"
            r1.zzR(r0)
            com.google.android.gms.internal.gtm.zzfo r0 = r1.zzc
            r0.zzb()
            goto L_0x00e8
        L_0x0226:
            return r9
        L_0x0227:
            java.util.ArrayList r2 = new java.util.ArrayList
            int r0 = r20.size()
            r2.<init>(r0)
            java.util.Iterator r0 = r20.iterator()
        L_0x0234:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x0322
            java.lang.Object r3 = r0.next()
            com.google.android.gms.internal.gtm.zzex r3 = (com.google.android.gms.internal.gtm.zzex) r3
            com.google.android.gms.common.internal.m.a(r3)
            boolean r4 = r3.zzh()
            r5 = 1
            r4 = r4 ^ r5
            java.lang.String r4 = r1.zza(r3, r4)
            if (r4 != 0) goto L_0x025b
            com.google.android.gms.internal.gtm.zzfb r4 = r19.zzz()
            java.lang.String r7 = "Error formatting hit for upload"
            r4.zzb(r3, r7)
        L_0x0258:
            r4 = 0
            goto L_0x030a
        L_0x025b:
            int r7 = r4.length()
            r19.zzw()
            com.google.android.gms.internal.gtm.zzet<java.lang.Integer> r8 = com.google.android.gms.internal.gtm.zzeu.zzu
            java.lang.Object r8 = r8.zzb()
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
            if (r7 > r8) goto L_0x02cc
            java.net.URL r4 = r1.zzj(r3, r4)
            if (r4 != 0) goto L_0x027d
            java.lang.String r0 = "Failed to build collect GET endpoint url"
        L_0x0278:
            r1.zzJ(r0)
            goto L_0x0322
        L_0x027d:
            com.google.android.gms.common.internal.m.a(r4)
            java.lang.String r7 = "GET request"
            r1.zzG(r7, r4)
            java.net.HttpURLConnection r4 = r1.zzb(r4)     // Catch:{ IOException -> 0x02b8, all -> 0x02b5 }
            r4.connect()     // Catch:{ IOException -> 0x02b2, all -> 0x02af }
            r1.zzk(r4)     // Catch:{ IOException -> 0x02b2, all -> 0x02af }
            int r7 = r4.getResponseCode()     // Catch:{ IOException -> 0x02b2, all -> 0x02af }
            if (r7 != r6) goto L_0x029e
            com.google.android.gms.internal.gtm.zzbq r7 = r19.zzs()     // Catch:{ IOException -> 0x02b2, all -> 0x02af }
            r7.zzi()     // Catch:{ IOException -> 0x02b2, all -> 0x02af }
            r7 = 200(0xc8, float:2.8E-43)
        L_0x029e:
            java.lang.String r8 = "GET status"
            java.lang.Integer r9 = java.lang.Integer.valueOf(r7)     // Catch:{ IOException -> 0x02b2, all -> 0x02af }
            r1.zzG(r8, r9)     // Catch:{ IOException -> 0x02b2, all -> 0x02af }
            if (r4 == 0) goto L_0x02ac
            r4.disconnect()
        L_0x02ac:
            if (r7 != r6) goto L_0x0322
            goto L_0x0258
        L_0x02af:
            r0 = move-exception
            r7 = r4
            goto L_0x02c6
        L_0x02b2:
            r0 = move-exception
            r7 = r4
            goto L_0x02ba
        L_0x02b5:
            r0 = move-exception
            r7 = 0
            goto L_0x02c6
        L_0x02b8:
            r0 = move-exception
            r7 = 0
        L_0x02ba:
            java.lang.String r3 = "Network GET connection error"
            r1.zzS(r3, r0)     // Catch:{ all -> 0x02c5 }
            if (r7 == 0) goto L_0x0322
            r7.disconnect()
            goto L_0x0322
        L_0x02c5:
            r0 = move-exception
        L_0x02c6:
            if (r7 == 0) goto L_0x02cb
            r7.disconnect()
        L_0x02cb:
            throw r0
        L_0x02cc:
            r4 = 0
            java.lang.String r7 = r1.zza(r3, r4)
            if (r7 != 0) goto L_0x02dd
            com.google.android.gms.internal.gtm.zzfb r7 = r19.zzz()
            java.lang.String r8 = "Error formatting hit for POST upload"
        L_0x02d9:
            r7.zzb(r3, r8)
            goto L_0x030a
        L_0x02dd:
            byte[] r7 = r7.getBytes()
            int r8 = r7.length
            r19.zzw()
            com.google.android.gms.internal.gtm.zzet<java.lang.Integer> r9 = com.google.android.gms.internal.gtm.zzeu.zzz
            java.lang.Object r9 = r9.zzb()
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r9 = r9.intValue()
            if (r8 <= r9) goto L_0x02fa
            com.google.android.gms.internal.gtm.zzfb r7 = r19.zzz()
            java.lang.String r8 = "Hit payload exceeds size limit"
            goto L_0x02d9
        L_0x02fa:
            java.net.URL r8 = r1.zzi(r3)
            if (r8 != 0) goto L_0x0304
            java.lang.String r0 = "Failed to build collect POST endpoint url"
            goto L_0x0278
        L_0x0304:
            int r7 = r1.zzg(r8, r7)
            if (r7 != r6) goto L_0x0322
        L_0x030a:
            long r7 = r3.zzb()
            java.lang.Long r3 = java.lang.Long.valueOf(r7)
            r2.add(r3)
            int r3 = r2.size()
            r19.zzw()
            int r7 = com.google.android.gms.internal.gtm.zzct.zzh()
            if (r3 < r7) goto L_0x0234
        L_0x0322:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzfe.zzc(java.util.List):java.util.List");
    }

    /* access modifiers changed from: protected */
    public final void zzd() {
        zzP("Network initialized. User agent", this.zzb);
    }

    public final boolean zze() {
        NetworkInfo networkInfo;
        zzr.zzh();
        zzW();
        try {
            networkInfo = ((ConnectivityManager) zzo().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException unused) {
            networkInfo = null;
        }
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        }
        zzO("No network connectivity");
        return false;
    }
}
