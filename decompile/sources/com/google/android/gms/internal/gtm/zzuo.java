package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzun;
import java.util.Iterator;
import java.util.Map;

final class zzuo<T extends zzun<T>> {
    private static final zzuo zzb = new zzuo(true);
    final zzxk<T, Object> zza = new zzxa(16);
    private boolean zzc;
    private boolean zzd;

    private zzuo() {
    }

    private zzuo(boolean z2) {
        zzg();
        zzg();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0059, code lost:
        r1 = com.google.android.gms.internal.gtm.zzto.zzD(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0088, code lost:
        r1 = com.google.android.gms.internal.gtm.zzto.zzu((com.google.android.gms.internal.gtm.zztd) r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00af, code lost:
        r1 = com.google.android.gms.internal.gtm.zzto.zzx(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00ba, code lost:
        r1 = com.google.android.gms.internal.gtm.zzto.zzE(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00ca, code lost:
        r1 = 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00cd, code lost:
        return r4 + r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int zza(com.google.android.gms.internal.gtm.zzun<?> r4, java.lang.Object r5) {
        /*
            com.google.android.gms.internal.gtm.zzye r0 = r4.zzd()
            int r1 = r4.zza()
            r4.zzg()
            int r4 = com.google.android.gms.internal.gtm.zzto.zzC(r1)
            com.google.android.gms.internal.gtm.zzye r1 = com.google.android.gms.internal.gtm.zzye.GROUP
            if (r0 != r1) goto L_0x001a
            r1 = r5
            com.google.android.gms.internal.gtm.zzwk r1 = (com.google.android.gms.internal.gtm.zzwk) r1
            com.google.android.gms.internal.gtm.zzvi.zzi(r1)
            int r4 = r4 + r4
        L_0x001a:
            com.google.android.gms.internal.gtm.zzyf r1 = com.google.android.gms.internal.gtm.zzyf.INT
            int r0 = r0.ordinal()
            r1 = 4
            r2 = 8
            switch(r0) {
                case 0: goto L_0x00c5;
                case 1: goto L_0x00bf;
                case 2: goto L_0x00b4;
                case 3: goto L_0x00b4;
                case 4: goto L_0x00a9;
                case 5: goto L_0x00a3;
                case 6: goto L_0x009d;
                case 7: goto L_0x0096;
                case 8: goto L_0x0084;
                case 9: goto L_0x007d;
                case 10: goto L_0x006b;
                case 11: goto L_0x005f;
                case 12: goto L_0x0053;
                case 13: goto L_0x0048;
                case 14: goto L_0x009d;
                case 15: goto L_0x00a3;
                case 16: goto L_0x003c;
                case 17: goto L_0x002e;
                default: goto L_0x0026;
            }
        L_0x0026:
            java.lang.RuntimeException r4 = new java.lang.RuntimeException
            java.lang.String r5 = "There is no way to get here, but the compiler thinks otherwise."
            r4.<init>(r5)
            throw r4
        L_0x002e:
            java.lang.Long r5 = (java.lang.Long) r5
            long r0 = r5.longValue()
            long r2 = r0 + r0
            r5 = 63
            long r0 = r0 >> r5
            long r0 = r0 ^ r2
            goto L_0x00ba
        L_0x003c:
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            int r0 = r5 + r5
            int r5 = r5 >> 31
            r5 = r5 ^ r0
            goto L_0x0059
        L_0x0048:
            boolean r0 = r5 instanceof com.google.android.gms.internal.gtm.zzvb
            if (r0 == 0) goto L_0x00a9
            com.google.android.gms.internal.gtm.zzvb r5 = (com.google.android.gms.internal.gtm.zzvb) r5
            int r5 = r5.zza()
            goto L_0x00af
        L_0x0053:
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
        L_0x0059:
            int r1 = com.google.android.gms.internal.gtm.zzto.zzD(r5)
            goto L_0x00cc
        L_0x005f:
            boolean r0 = r5 instanceof com.google.android.gms.internal.gtm.zztd
            if (r0 == 0) goto L_0x0064
            goto L_0x0088
        L_0x0064:
            byte[] r5 = (byte[]) r5
            int r1 = com.google.android.gms.internal.gtm.zzto.zzt(r5)
            goto L_0x00cc
        L_0x006b:
            boolean r0 = r5 instanceof com.google.android.gms.internal.gtm.zzvp
            if (r0 == 0) goto L_0x0076
            com.google.android.gms.internal.gtm.zzvp r5 = (com.google.android.gms.internal.gtm.zzvp) r5
            int r1 = com.google.android.gms.internal.gtm.zzto.zzy(r5)
            goto L_0x00cc
        L_0x0076:
            com.google.android.gms.internal.gtm.zzwk r5 = (com.google.android.gms.internal.gtm.zzwk) r5
            int r1 = com.google.android.gms.internal.gtm.zzto.zzz(r5)
            goto L_0x00cc
        L_0x007d:
            com.google.android.gms.internal.gtm.zzwk r5 = (com.google.android.gms.internal.gtm.zzwk) r5
            int r1 = com.google.android.gms.internal.gtm.zzto.zzw(r5)
            goto L_0x00cc
        L_0x0084:
            boolean r0 = r5 instanceof com.google.android.gms.internal.gtm.zztd
            if (r0 == 0) goto L_0x008f
        L_0x0088:
            com.google.android.gms.internal.gtm.zztd r5 = (com.google.android.gms.internal.gtm.zztd) r5
            int r1 = com.google.android.gms.internal.gtm.zzto.zzu(r5)
            goto L_0x00cc
        L_0x008f:
            java.lang.String r5 = (java.lang.String) r5
            int r1 = com.google.android.gms.internal.gtm.zzto.zzB(r5)
            goto L_0x00cc
        L_0x0096:
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            r5.booleanValue()
            r1 = 1
            goto L_0x00cc
        L_0x009d:
            java.lang.Integer r5 = (java.lang.Integer) r5
            r5.intValue()
            goto L_0x00cc
        L_0x00a3:
            java.lang.Long r5 = (java.lang.Long) r5
            r5.longValue()
            goto L_0x00ca
        L_0x00a9:
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
        L_0x00af:
            int r1 = com.google.android.gms.internal.gtm.zzto.zzx(r5)
            goto L_0x00cc
        L_0x00b4:
            java.lang.Long r5 = (java.lang.Long) r5
            long r0 = r5.longValue()
        L_0x00ba:
            int r1 = com.google.android.gms.internal.gtm.zzto.zzE(r0)
            goto L_0x00cc
        L_0x00bf:
            java.lang.Float r5 = (java.lang.Float) r5
            r5.floatValue()
            goto L_0x00cc
        L_0x00c5:
            java.lang.Double r5 = (java.lang.Double) r5
            r5.doubleValue()
        L_0x00ca:
            r1 = 8
        L_0x00cc:
            int r4 = r4 + r1
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzuo.zza(com.google.android.gms.internal.gtm.zzun, java.lang.Object):int");
    }

    public static <T extends zzun<T>> zzuo<T> zzd() {
        return zzb;
    }

    private static Object zzl(Object obj) {
        if (obj instanceof zzwp) {
            return ((zzwp) obj).zzc();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    private final void zzm(Map.Entry<T, Object> entry) {
        Object obj;
        zzxk<T, Object> zzxk;
        Object zze;
        zzun zzun = (zzun) entry.getKey();
        Object value = entry.getValue();
        if (!(value instanceof zzvp)) {
            zzun.zzg();
            if (zzun.zze() != zzyf.MESSAGE || (zze = zze(zzun)) == null) {
                zzxk = this.zza;
                obj = zzl(value);
            } else {
                if (zze instanceof zzwp) {
                    obj = zzun.zzc((zzwp) zze, (zzwp) value);
                } else {
                    zzwj zzap = ((zzwk) zze).zzap();
                    zzun.zzb(zzap, (zzwk) value);
                    obj = zzap.zzC();
                }
                zzxk = this.zza;
            }
            zzxk.put(zzun, obj);
            return;
        }
        zzvp zzvp = (zzvp) value;
        throw null;
    }

    private static <T extends zzun<T>> boolean zzn(Map.Entry<T, Object> entry) {
        zzun zzun = (zzun) entry.getKey();
        if (zzun.zze() == zzyf.MESSAGE) {
            zzun.zzg();
            Object value = entry.getValue();
            if (value instanceof zzwk) {
                if (!((zzwk) value).zzas()) {
                    return false;
                }
            } else if (value instanceof zzvp) {
                return true;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        }
        return true;
    }

    private static final int zzo(Map.Entry<T, Object> entry) {
        int zzD;
        int zzD2;
        zzun zzun = (zzun) entry.getKey();
        Object value = entry.getValue();
        if (zzun.zze() != zzyf.MESSAGE) {
            return zza(zzun, value);
        }
        zzun.zzg();
        zzun.zzf();
        boolean z2 = value instanceof zzvp;
        int zza2 = ((zzun) entry.getKey()).zza();
        if (z2) {
            int zzD3 = zzto.zzD(8);
            int zza3 = ((zzvp) value).zza();
            zzD = zzD3 + zzD3 + zzto.zzD(16) + zzto.zzD(zza2);
            zzD2 = zzto.zzD(24) + zzto.zzD(zza3) + zza3;
        } else {
            int zzD4 = zzto.zzD(8);
            zzD = zzD4 + zzD4 + zzto.zzD(16) + zzto.zzD(zza2);
            zzD2 = zzto.zzD(24) + zzto.zzz((zzwk) value);
        }
        return zzD + zzD2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzuo)) {
            return false;
        }
        return this.zza.equals(((zzuo) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final int zzb() {
        int i2 = 0;
        for (int i3 = 0; i3 < this.zza.zzb(); i3++) {
            i2 += zzo(this.zza.zzg(i3));
        }
        for (Map.Entry<T, Object> zzo : this.zza.zzc()) {
            i2 += zzo(zzo);
        }
        return i2;
    }

    /* renamed from: zzc */
    public final zzuo<T> clone() {
        zzuo<T> zzuo = new zzuo<>();
        for (int i2 = 0; i2 < this.zza.zzb(); i2++) {
            Map.Entry<T, Object> zzg = this.zza.zzg(i2);
            zzuo.zzi((zzun) zzg.getKey(), zzg.getValue());
        }
        for (Map.Entry next : this.zza.zzc()) {
            zzuo.zzi((zzun) next.getKey(), next.getValue());
        }
        zzuo.zzd = this.zzd;
        return zzuo;
    }

    public final Object zze(T t2) {
        Object obj = this.zza.get(t2);
        if (!(obj instanceof zzvp)) {
            return obj;
        }
        zzvp zzvp = (zzvp) obj;
        throw null;
    }

    public final Iterator<Map.Entry<T, Object>> zzf() {
        return this.zzd ? new zzvo(this.zza.entrySet().iterator()) : this.zza.entrySet().iterator();
    }

    public final void zzg() {
        if (!this.zzc) {
            this.zza.zza();
            this.zzc = true;
        }
    }

    public final void zzh(zzuo<T> zzuo) {
        for (int i2 = 0; i2 < zzuo.zza.zzb(); i2++) {
            zzm(zzuo.zza.zzg(i2));
        }
        for (Map.Entry<T, Object> zzm : zzuo.zza.zzc()) {
            zzm(zzm);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0033, code lost:
        if ((r7 instanceof byte[]) == false) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0047, code lost:
        if (r0 != false) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004b, code lost:
        if ((r7 instanceof com.google.android.gms.internal.gtm.zzvp) == false) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004d, code lost:
        r5.zzd = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004f, code lost:
        r5.zza.zze(r6, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0054, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0083, code lost:
        throw new java.lang.IllegalArgumentException(java.lang.String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new java.lang.Object[]{java.lang.Integer.valueOf(r6.zza()), r6.zzd().zza(), r7.getClass().getName()}));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0021, code lost:
        if ((r7 instanceof com.google.android.gms.internal.gtm.zzvp) == false) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002a, code lost:
        if ((r7 instanceof com.google.android.gms.internal.gtm.zzvb) == false) goto L_0x0055;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzi(T r6, java.lang.Object r7) {
        /*
            r5 = this;
            r6.zzg()
            com.google.android.gms.internal.gtm.zzye r0 = r6.zzd()
            com.google.android.gms.internal.gtm.zzvi.zze(r7)
            com.google.android.gms.internal.gtm.zzye r1 = com.google.android.gms.internal.gtm.zzye.DOUBLE
            com.google.android.gms.internal.gtm.zzyf r1 = com.google.android.gms.internal.gtm.zzyf.INT
            com.google.android.gms.internal.gtm.zzyf r0 = r0.zza()
            int r0 = r0.ordinal()
            r1 = 1
            switch(r0) {
                case 0: goto L_0x0045;
                case 1: goto L_0x0042;
                case 2: goto L_0x003f;
                case 3: goto L_0x003c;
                case 4: goto L_0x0039;
                case 5: goto L_0x0036;
                case 6: goto L_0x002d;
                case 7: goto L_0x0024;
                case 8: goto L_0x001b;
                default: goto L_0x001a;
            }
        L_0x001a:
            goto L_0x0055
        L_0x001b:
            boolean r0 = r7 instanceof com.google.android.gms.internal.gtm.zzwk
            if (r0 != 0) goto L_0x0049
            boolean r0 = r7 instanceof com.google.android.gms.internal.gtm.zzvp
            if (r0 == 0) goto L_0x0055
            goto L_0x0049
        L_0x0024:
            boolean r0 = r7 instanceof java.lang.Integer
            if (r0 != 0) goto L_0x0049
            boolean r0 = r7 instanceof com.google.android.gms.internal.gtm.zzvb
            if (r0 == 0) goto L_0x0055
            goto L_0x0049
        L_0x002d:
            boolean r0 = r7 instanceof com.google.android.gms.internal.gtm.zztd
            if (r0 != 0) goto L_0x0049
            boolean r0 = r7 instanceof byte[]
            if (r0 == 0) goto L_0x0055
            goto L_0x0049
        L_0x0036:
            boolean r0 = r7 instanceof java.lang.String
            goto L_0x0047
        L_0x0039:
            boolean r0 = r7 instanceof java.lang.Boolean
            goto L_0x0047
        L_0x003c:
            boolean r0 = r7 instanceof java.lang.Double
            goto L_0x0047
        L_0x003f:
            boolean r0 = r7 instanceof java.lang.Float
            goto L_0x0047
        L_0x0042:
            boolean r0 = r7 instanceof java.lang.Long
            goto L_0x0047
        L_0x0045:
            boolean r0 = r7 instanceof java.lang.Integer
        L_0x0047:
            if (r0 == 0) goto L_0x0055
        L_0x0049:
            boolean r0 = r7 instanceof com.google.android.gms.internal.gtm.zzvp
            if (r0 == 0) goto L_0x004f
            r5.zzd = r1
        L_0x004f:
            com.google.android.gms.internal.gtm.zzxk<T, java.lang.Object> r0 = r5.zza
            r0.put(r6, r7)
            return
        L_0x0055:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r2 = 3
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            int r4 = r6.zza()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r2[r3] = r4
            com.google.android.gms.internal.gtm.zzye r6 = r6.zzd()
            com.google.android.gms.internal.gtm.zzyf r6 = r6.zza()
            r2[r1] = r6
            r6 = 2
            java.lang.Class r7 = r7.getClass()
            java.lang.String r7 = r7.getName()
            r2[r6] = r7
            java.lang.String r6 = "Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n"
            java.lang.String r6 = java.lang.String.format(r6, r2)
            r0.<init>(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzuo.zzi(com.google.android.gms.internal.gtm.zzun, java.lang.Object):void");
    }

    public final boolean zzj() {
        return this.zzc;
    }

    public final boolean zzk() {
        for (int i2 = 0; i2 < this.zza.zzb(); i2++) {
            if (!zzn(this.zza.zzg(i2))) {
                return false;
            }
        }
        for (Map.Entry<T, Object> zzn : this.zza.zzc()) {
            if (!zzn(zzn)) {
                return false;
            }
        }
        return true;
    }
}
