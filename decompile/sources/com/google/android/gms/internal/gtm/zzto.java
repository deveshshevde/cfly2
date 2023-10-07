package com.google.android.gms.internal.gtm;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class zzto extends zzss {
    private static final Logger zzb = Logger.getLogger(zzto.class.getName());
    /* access modifiers changed from: private */
    public static final boolean zzc = zzxy.zzx();
    zztp zza;

    private zzto() {
    }

    /* synthetic */ zzto(zztn zztn) {
    }

    static int zzA(zzwk zzwk, zzwx zzwx) {
        zzsh zzsh = (zzsh) zzwk;
        int zzQ = zzsh.zzQ();
        if (zzQ == -1) {
            zzQ = zzwx.zza(zzsh);
            zzsh.zzT(zzQ);
        }
        return zzD(zzQ) + zzQ;
    }

    public static int zzB(String str) {
        int i2;
        try {
            i2 = zzyd.zzc(str);
        } catch (zzyc unused) {
            i2 = str.getBytes(zzvi.zza).length;
        }
        return zzD(i2) + i2;
    }

    public static int zzC(int i2) {
        return zzD(i2 << 3);
    }

    public static int zzD(int i2) {
        if ((i2 & -128) == 0) {
            return 1;
        }
        if ((i2 & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i2) == 0) {
            return 3;
        }
        return (i2 & -268435456) == 0 ? 4 : 5;
    }

    public static int zzE(long j2) {
        int i2;
        if ((-128 & j2) == 0) {
            return 1;
        }
        if (j2 < 0) {
            return 10;
        }
        if ((-34359738368L & j2) != 0) {
            j2 >>>= 28;
            i2 = 6;
        } else {
            i2 = 2;
        }
        if ((-2097152 & j2) != 0) {
            i2 += 2;
            j2 >>>= 14;
        }
        return (j2 & -16384) != 0 ? i2 + 1 : i2;
    }

    public static zzto zzF(byte[] bArr) {
        return new zztl(bArr, 0, bArr.length);
    }

    public static int zzt(byte[] bArr) {
        int length = bArr.length;
        return zzD(length) + length;
    }

    public static int zzu(zztd zztd) {
        int zzd = zztd.zzd();
        return zzD(zzd) + zzd;
    }

    @Deprecated
    static int zzv(int i2, zzwk zzwk, zzwx zzwx) {
        int zzD = zzD(i2 << 3);
        int i3 = zzD + zzD;
        zzsh zzsh = (zzsh) zzwk;
        int zzQ = zzsh.zzQ();
        if (zzQ == -1) {
            zzQ = zzwx.zza(zzsh);
            zzsh.zzT(zzQ);
        }
        return i3 + zzQ;
    }

    @Deprecated
    public static int zzw(zzwk zzwk) {
        return zzwk.zzX();
    }

    public static int zzx(int i2) {
        if (i2 >= 0) {
            return zzD(i2);
        }
        return 10;
    }

    public static int zzy(zzvq zzvq) {
        int zza2 = zzvq.zza();
        return zzD(zza2) + zza2;
    }

    public static int zzz(zzwk zzwk) {
        int zzX = zzwk.zzX();
        return zzD(zzX) + zzX;
    }

    public final void zzG() {
        if (zza() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzH(String str, zzyc zzyc) throws IOException {
        zzb.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", zzyc);
        byte[] bytes = str.getBytes(zzvi.zza);
        try {
            int length = bytes.length;
            zzq(length);
            zzl(bytes, 0, length);
        } catch (IndexOutOfBoundsException e2) {
            throw new zztm(e2);
        } catch (zztm e3) {
            throw e3;
        }
    }

    public abstract int zza();

    public abstract void zzb(byte b2) throws IOException;

    public abstract void zzd(int i2, boolean z2) throws IOException;

    public abstract void zze(int i2, zztd zztd) throws IOException;

    public abstract void zzf(int i2, int i3) throws IOException;

    public abstract void zzg(int i2) throws IOException;

    public abstract void zzh(int i2, long j2) throws IOException;

    public abstract void zzi(long j2) throws IOException;

    public abstract void zzj(int i2, int i3) throws IOException;

    public abstract void zzk(int i2) throws IOException;

    public abstract void zzl(byte[] bArr, int i2, int i3) throws IOException;

    public abstract void zzm(int i2, String str) throws IOException;

    public abstract void zzo(int i2, int i3) throws IOException;

    public abstract void zzp(int i2, int i3) throws IOException;

    public abstract void zzq(int i2) throws IOException;

    public abstract void zzr(int i2, long j2) throws IOException;

    public abstract void zzs(long j2) throws IOException;
}
