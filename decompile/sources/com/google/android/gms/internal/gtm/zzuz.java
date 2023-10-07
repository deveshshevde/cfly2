package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzut;
import com.google.android.gms.internal.gtm.zzuz;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class zzuz<MessageType extends zzuz<MessageType, BuilderType>, BuilderType extends zzut<MessageType, BuilderType>> extends zzsh<MessageType, BuilderType> {
    private static final Map<Object, zzuz<?, ?>> zza = new ConcurrentHashMap();
    protected zzxp zzc = zzxp.zzc();
    protected int zzd = -1;

    public static <ContainingType extends zzwk, Type> zzux<ContainingType, Type> zzaa(ContainingType containingtype, Type type, zzwk zzwk, zzvc zzvc, int i2, zzye zzye, Class cls) {
        return new zzux(containingtype, type, zzwk, new zzuw(zzvc, i2, zzye, false, false), cls);
    }

    static <T extends zzuz> T zzab(Class<T> cls) {
        Map<Object, zzuz<?, ?>> map = zza;
        T t2 = (zzuz) map.get(cls);
        if (t2 == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t2 = (zzuz) map.get(cls);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException("Class initialization cannot fail.", e2);
            }
        }
        if (t2 == null) {
            t2 = (zzuz) ((zzuz) zzxy.zze(cls)).zzb(6, (Object) null, (Object) null);
            if (t2 != null) {
                map.put(cls, t2);
            } else {
                throw new IllegalStateException();
            }
        }
        return t2;
    }

    protected static <T extends zzuz<T, ?>> T zzac(T t2, InputStream inputStream, zzuj zzuj) throws zzvk {
        zzth zzth = new zzth(inputStream, 4096, (zztg) null);
        T t3 = (zzuz) t2.zzb(4, (Object) null, (Object) null);
        try {
            zzwx<?> zzb = zzwt.zza().zzb(t3.getClass());
            zzb.zzh(t3, zztk.zzp(zzth), zzuj);
            zzb.zzf(t3);
            zzc(t3);
            return t3;
        } catch (zzvk e2) {
            e = e2;
            if (e.zzl()) {
                e = new zzvk((IOException) e);
            }
            e.zzh(t3);
            throw e;
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzvk) {
                throw ((zzvk) e3.getCause());
            }
            zzvk zzvk = new zzvk(e3);
            zzvk.zzh(t3);
            throw zzvk;
        } catch (RuntimeException e4) {
            if (e4.getCause() instanceof zzvk) {
                throw ((zzvk) e4.getCause());
            }
            throw e4;
        }
    }

    protected static <T extends zzuz<T, ?>> T zzad(T t2, byte[] bArr, zzuj zzuj) throws zzvk {
        T zzae = zzae(t2, bArr, 0, bArr.length, zzuj);
        zzc(zzae);
        return zzae;
    }

    static <T extends zzuz<T, ?>> T zzae(T t2, byte[] bArr, int i2, int i3, zzuj zzuj) throws zzvk {
        T t3 = (zzuz) t2.zzb(4, (Object) null, (Object) null);
        try {
            zzwx<?> zzb = zzwt.zza().zzb(t3.getClass());
            zzb.zzi(t3, bArr, 0, i3, new zzsl(zzuj));
            zzb.zzf(t3);
            if (t3.zzb == 0) {
                return t3;
            }
            throw new RuntimeException();
        } catch (zzvk e2) {
            e = e2;
            if (e.zzl()) {
                e = new zzvk((IOException) e);
            }
            e.zzh(t3);
            throw e;
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzvk) {
                throw ((zzvk) e3.getCause());
            }
            zzvk zzvk = new zzvk(e3);
            zzvk.zzh(t3);
            throw zzvk;
        } catch (IndexOutOfBoundsException unused) {
            zzvk zzj = zzvk.zzj();
            zzj.zzh(t3);
            throw zzj;
        }
    }

    protected static zzve zzaf() {
        return zzva.zzf();
    }

    protected static <E> zzvh<E> zzag() {
        return zzwu.zze();
    }

    protected static <E> zzvh<E> zzah(zzvh<E> zzvh) {
        int size = zzvh.size();
        return zzvh.zzd(size == 0 ? 10 : size + size);
    }

    static Object zzai(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    protected static Object zzaj(zzwk zzwk, String str, Object[] objArr) {
        return new zzwv(zzwk, str, objArr);
    }

    protected static <T extends zzuz> void zzak(Class<T> cls, T t2) {
        zza.put(cls, t2);
    }

    private static <T extends zzuz<T, ?>> T zzc(T t2) throws zzvk {
        if (t2 == null || t2.zzas()) {
            return t2;
        }
        zzvk zzvk = new zzvk(new zzxn(t2).getMessage());
        zzvk.zzh(t2);
        throw zzvk;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzwt.zza().zzb(getClass()).zzj(this, (zzuz) obj);
        }
        return false;
    }

    public final int hashCode() {
        int i2 = this.zzb;
        if (i2 != 0) {
            return i2;
        }
        int zzb = zzwt.zza().zzb(getClass()).zzb(this);
        this.zzb = zzb;
        return zzb;
    }

    public final String toString() {
        return zzwm.zza(this, super.toString());
    }

    /* access modifiers changed from: package-private */
    public final int zzQ() {
        return this.zzd;
    }

    /* access modifiers changed from: package-private */
    public final void zzT(int i2) {
        this.zzd = i2;
    }

    public final int zzX() {
        int i2 = this.zzd;
        if (i2 != -1) {
            return i2;
        }
        int zza2 = zzwt.zza().zzb(getClass()).zza(this);
        this.zzd = zza2;
        return zza2;
    }

    /* access modifiers changed from: protected */
    public final <MessageType extends zzuz<MessageType, BuilderType>, BuilderType extends zzut<MessageType, BuilderType>> BuilderType zzY() {
        return (zzut) zzb(5, (Object) null, (Object) null);
    }

    public final BuilderType zzZ() {
        BuilderType buildertype = (zzut) zzb(5, (Object) null, (Object) null);
        buildertype.zzz(this);
        return buildertype;
    }

    public final /* synthetic */ zzwj zzao() {
        return (zzut) zzb(5, (Object) null, (Object) null);
    }

    public final /* synthetic */ zzwj zzap() {
        zzut zzut = (zzut) zzb(5, (Object) null, (Object) null);
        zzut.zzz(this);
        return zzut;
    }

    public final void zzaq(zzto zzto) throws IOException {
        zzwt.zza().zzb(getClass()).zzn(this, zztp.zza(zzto));
    }

    public final /* synthetic */ zzwk zzar() {
        return (zzuz) zzb(6, (Object) null, (Object) null);
    }

    public final boolean zzas() {
        Boolean bool = Boolean.TRUE;
        byte byteValue = ((Byte) zzb(1, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzk = zzwt.zza().zzb(getClass()).zzk(this);
        zzb(2, true != zzk ? null : this, (Object) null);
        return zzk;
    }

    /* access modifiers changed from: protected */
    public abstract Object zzb(int i2, Object obj, Object obj2);
}
