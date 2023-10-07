package com.google.android.gms.internal.gtm;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Map;

final class zzul extends zzuk<zzuw> {
    zzul() {
    }

    /* access modifiers changed from: package-private */
    public final int zza(Map.Entry<?, ?> entry) {
        return ((zzuw) entry.getKey()).zzb;
    }

    /* access modifiers changed from: package-private */
    public final zzuo<zzuw> zzb(Object obj) {
        return ((zzuv) obj).zza;
    }

    /* access modifiers changed from: package-private */
    public final zzuo<zzuw> zzc(Object obj) {
        return ((zzuv) obj).zzU();
    }

    /* access modifiers changed from: package-private */
    public final Object zzd(zzuj zzuj, zzwk zzwk, int i2) {
        return zzuj.zzc(zzwk, i2);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0093, code lost:
        r4 = java.lang.Long.valueOf(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <UT, UB> UB zze(com.google.android.gms.internal.gtm.zzww r4, java.lang.Object r5, com.google.android.gms.internal.gtm.zzuj r6, com.google.android.gms.internal.gtm.zzuo<com.google.android.gms.internal.gtm.zzuw> r7, UB r8, com.google.android.gms.internal.gtm.zzxo<UT, UB> r9) throws java.io.IOException {
        /*
            r3 = this;
            com.google.android.gms.internal.gtm.zzux r5 = (com.google.android.gms.internal.gtm.zzux) r5
            com.google.android.gms.internal.gtm.zzuw r0 = r5.zzd
            int r1 = r0.zzb
            com.google.android.gms.internal.gtm.zzye r0 = r0.zzc
            com.google.android.gms.internal.gtm.zzye r2 = com.google.android.gms.internal.gtm.zzye.ENUM
            if (r0 != r2) goto L_0x001f
            int r4 = r4.zzg()
            com.google.android.gms.internal.gtm.zzuw r6 = r5.zzd
            com.google.android.gms.internal.gtm.zzvc<?> r6 = r6.zza
            com.google.android.gms.internal.gtm.zzyl r6 = com.google.android.gms.internal.gtm.zzyl.zzc(r4)
            if (r6 != 0) goto L_0x0085
            java.lang.Object r4 = com.google.android.gms.internal.gtm.zzwz.zzD(r1, r4, r8, r9)
            return r4
        L_0x001f:
            com.google.android.gms.internal.gtm.zzuw r9 = r5.zzd
            com.google.android.gms.internal.gtm.zzye r9 = r9.zzc
            int r9 = r9.ordinal()
            switch(r9) {
                case 0: goto L_0x00a1;
                case 1: goto L_0x0098;
                case 2: goto L_0x008f;
                case 3: goto L_0x008a;
                case 4: goto L_0x0081;
                case 5: goto L_0x007c;
                case 6: goto L_0x0077;
                case 7: goto L_0x006e;
                case 8: goto L_0x0069;
                case 9: goto L_0x005e;
                case 10: goto L_0x0053;
                case 11: goto L_0x004e;
                case 12: goto L_0x0049;
                case 13: goto L_0x0041;
                case 14: goto L_0x003c;
                case 15: goto L_0x0037;
                case 16: goto L_0x0032;
                case 17: goto L_0x002d;
                default: goto L_0x002a;
            }
        L_0x002a:
            r4 = 0
            goto L_0x00a9
        L_0x002d:
            long r0 = r4.zzn()
            goto L_0x0093
        L_0x0032:
            int r4 = r4.zzi()
            goto L_0x0085
        L_0x0037:
            long r0 = r4.zzm()
            goto L_0x0093
        L_0x003c:
            int r4 = r4.zzh()
            goto L_0x0085
        L_0x0041:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "Shouldn't reach here."
            r4.<init>(r5)
            throw r4
        L_0x0049:
            int r4 = r4.zzj()
            goto L_0x0085
        L_0x004e:
            com.google.android.gms.internal.gtm.zztd r4 = r4.zzq()
            goto L_0x00a9
        L_0x0053:
            com.google.android.gms.internal.gtm.zzwk r9 = r5.zzc
            java.lang.Class r9 = r9.getClass()
            java.lang.Object r4 = r4.zzt(r9, r6)
            goto L_0x00a9
        L_0x005e:
            com.google.android.gms.internal.gtm.zzwk r9 = r5.zzc
            java.lang.Class r9 = r9.getClass()
            java.lang.Object r4 = r4.zzr(r9, r6)
            goto L_0x00a9
        L_0x0069:
            java.lang.String r4 = r4.zzv()
            goto L_0x00a9
        L_0x006e:
            boolean r4 = r4.zzS()
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            goto L_0x00a9
        L_0x0077:
            int r4 = r4.zzf()
            goto L_0x0085
        L_0x007c:
            long r0 = r4.zzk()
            goto L_0x0093
        L_0x0081:
            int r4 = r4.zzg()
        L_0x0085:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            goto L_0x00a9
        L_0x008a:
            long r0 = r4.zzo()
            goto L_0x0093
        L_0x008f:
            long r0 = r4.zzl()
        L_0x0093:
            java.lang.Long r4 = java.lang.Long.valueOf(r0)
            goto L_0x00a9
        L_0x0098:
            float r4 = r4.zzb()
            java.lang.Float r4 = java.lang.Float.valueOf(r4)
            goto L_0x00a9
        L_0x00a1:
            double r0 = r4.zza()
            java.lang.Double r4 = java.lang.Double.valueOf(r0)
        L_0x00a9:
            r5.zza()
            com.google.android.gms.internal.gtm.zzuw r6 = r5.zzd
            com.google.android.gms.internal.gtm.zzye r6 = r6.zzc
            int r6 = r6.ordinal()
            r9 = 9
            if (r6 == r9) goto L_0x00bd
            r9 = 10
            if (r6 == r9) goto L_0x00bd
            goto L_0x00c9
        L_0x00bd:
            com.google.android.gms.internal.gtm.zzuw r6 = r5.zzd
            java.lang.Object r6 = r7.zze(r6)
            if (r6 == 0) goto L_0x00c9
            java.lang.Object r4 = com.google.android.gms.internal.gtm.zzvi.zzg(r6, r4)
        L_0x00c9:
            com.google.android.gms.internal.gtm.zzuw r5 = r5.zzd
            r7.zzi(r5, r4)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzul.zze(com.google.android.gms.internal.gtm.zzww, java.lang.Object, com.google.android.gms.internal.gtm.zzuj, com.google.android.gms.internal.gtm.zzuo, java.lang.Object, com.google.android.gms.internal.gtm.zzxo):java.lang.Object");
    }

    /* access modifiers changed from: package-private */
    public final void zzf(Object obj) {
        ((zzuv) obj).zza.zzg();
    }

    /* access modifiers changed from: package-private */
    public final void zzg(zzww zzww, Object obj, zzuj zzuj, zzuo<zzuw> zzuo) throws IOException {
        zzux zzux = (zzux) obj;
        zzuo.zzi(zzux.zzd, zzww.zzt(zzux.zzc.getClass(), zzuj));
    }

    /* access modifiers changed from: package-private */
    public final void zzh(zztd zztd, Object obj, zzuj zzuj, zzuo<zzuw> zzuo) throws IOException {
        byte[] bArr;
        zzux zzux = (zzux) obj;
        zzwk zzD = zzux.zzc.zzao().zzD();
        int zzd = zztd.zzd();
        if (zzd == 0) {
            bArr = zzvi.zzc;
        } else {
            byte[] bArr2 = new byte[zzd];
            zztd.zze(bArr2, 0, 0, zzd);
            bArr = bArr2;
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        if (wrap.hasArray()) {
            zzsn zzsn = new zzsn(wrap, true);
            zzwt.zza().zzb(zzD.getClass()).zzh(zzD, zzsn, zzuj);
            zzuo.zzi(zzux.zzd, zzD);
            if (zzsn.zzc() != Integer.MAX_VALUE) {
                throw zzvk.zzb();
            }
            return;
        }
        throw new IllegalArgumentException("Direct buffers not yet supported");
    }

    /* access modifiers changed from: package-private */
    public final boolean zzi(zzwk zzwk) {
        return zzwk instanceof zzuv;
    }

    /* access modifiers changed from: package-private */
    public final void zzj(zztp zztp, Map.Entry<?, ?> entry) throws IOException {
        zzuw zzuw = (zzuw) entry.getKey();
        zzye zzye = zzye.DOUBLE;
        switch (zzuw.zzc.ordinal()) {
            case 0:
                zztp.zzf(zzuw.zzb, ((Double) entry.getValue()).doubleValue());
                return;
            case 1:
                zztp.zzo(zzuw.zzb, ((Float) entry.getValue()).floatValue());
                return;
            case 2:
                zztp.zzt(zzuw.zzb, ((Long) entry.getValue()).longValue());
                return;
            case 3:
                zztp.zzK(zzuw.zzb, ((Long) entry.getValue()).longValue());
                return;
            case 4:
                zztp.zzr(zzuw.zzb, ((Integer) entry.getValue()).intValue());
                return;
            case 5:
                zztp.zzm(zzuw.zzb, ((Long) entry.getValue()).longValue());
                return;
            case 6:
                zztp.zzk(zzuw.zzb, ((Integer) entry.getValue()).intValue());
                return;
            case 7:
                zztp.zzb(zzuw.zzb, ((Boolean) entry.getValue()).booleanValue());
                return;
            case 8:
                zztp.zzG(zzuw.zzb, (String) entry.getValue());
                return;
            case 9:
                zztp.zzq(zzuw.zzb, entry.getValue(), zzwt.zza().zzb(entry.getValue().getClass()));
                return;
            case 10:
                zztp.zzv(zzuw.zzb, entry.getValue(), zzwt.zza().zzb(entry.getValue().getClass()));
                return;
            case 11:
                zztp.zzd(zzuw.zzb, (zztd) entry.getValue());
                return;
            case 12:
                zztp.zzI(zzuw.zzb, ((Integer) entry.getValue()).intValue());
                return;
            case 13:
                zztp.zzr(zzuw.zzb, ((Integer) entry.getValue()).intValue());
                return;
            case 14:
                zztp.zzx(zzuw.zzb, ((Integer) entry.getValue()).intValue());
                return;
            case 15:
                zztp.zzz(zzuw.zzb, ((Long) entry.getValue()).longValue());
                return;
            case 16:
                zztp.zzB(zzuw.zzb, ((Integer) entry.getValue()).intValue());
                return;
            case 17:
                zztp.zzD(zzuw.zzb, ((Long) entry.getValue()).longValue());
                return;
            default:
                return;
        }
    }
}
