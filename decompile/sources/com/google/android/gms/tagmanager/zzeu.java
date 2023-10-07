package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.gtm.zzak;
import com.google.android.gms.internal.gtm.zzal;
import com.google.android.gms.internal.gtm.zzao;
import com.google.android.gms.internal.gtm.zzb;
import com.google.android.gms.internal.gtm.zzro;
import com.google.android.gms.internal.gtm.zzrw;
import com.google.android.gms.internal.gtm.zzsa;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class zzeu {
    private static final zzds<zzak> zza = new zzds<>(zzfv.zzb(), true);
    private final Map<String, zzbu> zzc;
    private final Map<String, zzbu> zzd;
    private final Map<String, zzbu> zze;
    private final Set<zzrw> zzf;
    private final DataLayer zzg;
    private final Map<String, zzet> zzh;
    private volatile String zzi;
    private int zzj;
    private final zzdb zzl;
    private final zzdb zzm;

    private final String zzi() {
        if (this.zzj <= 1) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toString(this.zzj));
        for (int i2 = 2; i2 < this.zzj; i2++) {
            sb.append(' ');
        }
        sb.append(": ");
        return sb.toString();
    }

    private final void zzk(zzak zzak, Set<String> set) {
        zzds<zzak> zzo;
        if (zzak != null && (zzo = zzo(zzak, set, new zzdq())) != zza) {
            Object zzl2 = zzfv.zzl(zzo.zza());
            if (zzl2 instanceof Map) {
                this.zzg.push((Map) zzl2);
            } else if (zzl2 instanceof List) {
                for (Object next : (List) zzl2) {
                    if (next instanceof Map) {
                        this.zzg.push((Map) next);
                    } else {
                        zzdh.zzc("pushAfterEvaluate: value not a Map");
                    }
                }
            } else {
                zzdh.zzc("pushAfterEvaluate: value not a Map or List");
            }
        }
    }

    private final zzds<Set<zzro>> zzl(Set<zzrw> set, Set<String> set2, zzer zzer, zzdp zzdp) {
        boolean z2;
        zzds zzds;
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        Iterator<zzrw> it2 = set.iterator();
        while (true) {
            boolean z3 = true;
            while (true) {
                if (it2.hasNext()) {
                    zzrw next = it2.next();
                    zzdo zzdo = new zzdo();
                    Iterator<zzro> it3 = next.zzd().iterator();
                    while (true) {
                        boolean z4 = true;
                        while (true) {
                            if (!it3.hasNext()) {
                                Iterator<zzro> it4 = next.zze().iterator();
                                while (true) {
                                    if (!it4.hasNext()) {
                                        zzfv.zzc(true);
                                        zzds = new zzds(true, z2);
                                        break;
                                    }
                                    zzds<Boolean> zzf2 = zzf(it4.next(), set2, new zzdn());
                                    if (!zzf2.zza().booleanValue()) {
                                        zzfv.zzc(false);
                                        zzds = new zzds(false, zzf2.zzb());
                                        break;
                                    }
                                    z2 = z2 && zzf2.zzb();
                                }
                            } else {
                                zzds<Boolean> zzf3 = zzf(it3.next(), set2, new zzdn());
                                if (zzf3.zza().booleanValue()) {
                                    zzfv.zzc(false);
                                    zzds = new zzds(false, zzf3.zzb());
                                    break;
                                } else if (!z2 || !zzf3.zzb()) {
                                    z4 = false;
                                }
                            }
                        }
                    }
                    if (((Boolean) zzds.zza()).booleanValue()) {
                        zzer.zza(next, hashSet, hashSet2, zzdo);
                    }
                    if (!z3 || !zzds.zzb()) {
                        z3 = false;
                    }
                } else {
                    hashSet.removeAll(hashSet2);
                    return new zzds<>(hashSet, z3);
                }
            }
        }
    }

    private final zzds<zzak> zzm(String str, Set<String> set, zzdm zzdm) {
        zzro zzro;
        boolean z2 = true;
        this.zzj++;
        zzes zzes = (zzes) this.zzm.zza(str);
        if (zzes == null) {
            zzet zzet = this.zzh.get(str);
            if (zzet == null) {
                String zzi2 = zzi();
                StringBuilder sb = new StringBuilder(String.valueOf(zzi2).length() + 15 + String.valueOf(str).length());
                sb.append(zzi2);
                sb.append("Invalid macro: ");
                sb.append(str);
                zzdh.zza(sb.toString());
                this.zzj--;
                return zza;
            }
            zzds<Set<zzro>> zzl2 = zzl(zzet.zzf(), set, new zzep(this, zzet.zzc(), zzet.zzb(), zzet.zze(), zzet.zzd()), new zzdp());
            if (zzl2.zza().isEmpty()) {
                zzro = zzet.zza();
            } else {
                if (zzl2.zza().size() > 1) {
                    String zzi3 = zzi();
                    StringBuilder sb2 = new StringBuilder(String.valueOf(zzi3).length() + 37 + String.valueOf(str).length());
                    sb2.append(zzi3);
                    sb2.append("Multiple macros active for macroName ");
                    sb2.append(str);
                    zzdh.zzc(sb2.toString());
                }
                zzro = (zzro) zzl2.zza().iterator().next();
            }
            if (zzro == null) {
                this.zzj--;
                return zza;
            }
            zzds<zzak> zzn = zzn(this.zze, zzro, set, new zzdn());
            if (!zzl2.zzb() || !zzn.zzb()) {
                z2 = false;
            }
            zzds<zzak> zzds = zza;
            if (zzn != zzds) {
                zzds = new zzds<>(zzn.zza(), z2);
            }
            zzak zza2 = zzro.zza();
            if (zzds.zzb()) {
                this.zzm.zzb(str, new zzes(zzds, zza2));
            }
            zzk(zza2, set);
            this.zzj--;
            return zzds;
        }
        zzk(zzes.zzb(), set);
        this.zzj--;
        return zzes.zzc();
    }

    private final zzds<zzak> zzn(Map<String, zzbu> map, zzro zzro, Set<String> set, zzdn zzdn) {
        String sb;
        zzak zzak = zzro.zzc().get(zzb.FUNCTION.toString());
        if (zzak == null) {
            sb = "No function id in properties";
        } else {
            String zzn = zzak.zzn();
            zzbu zzbu = map.get(zzn);
            if (zzbu == null) {
                sb = String.valueOf(zzn).concat(" has no backing implementation.");
            } else {
                zzds<zzak> zzds = (zzds) this.zzl.zza(zzro);
                if (zzds != null) {
                    return zzds;
                }
                HashMap hashMap = new HashMap();
                boolean z2 = true;
                boolean z3 = true;
                for (Map.Entry next : zzro.zzc().entrySet()) {
                    String str = (String) next.getKey();
                    zzak zzak2 = (zzak) next.getValue();
                    zzds<zzak> zzo = zzo((zzak) next.getValue(), set, new zzdq());
                    zzds<zzak> zzds2 = zza;
                    if (zzo == zzds2) {
                        return zzds2;
                    }
                    if (zzo.zzb()) {
                        zzro.zzd((String) next.getKey(), zzo.zza());
                    } else {
                        z3 = false;
                    }
                    hashMap.put((String) next.getKey(), zzo.zza());
                }
                if (!zzbu.zzg(hashMap.keySet())) {
                    String valueOf = String.valueOf(zzbu.zzf());
                    String valueOf2 = String.valueOf(hashMap.keySet());
                    int length = String.valueOf(zzn).length();
                    StringBuilder sb2 = new StringBuilder(length + 43 + String.valueOf(valueOf).length() + String.valueOf(valueOf2).length());
                    sb2.append("Incorrect keys for function ");
                    sb2.append(zzn);
                    sb2.append(" required ");
                    sb2.append(valueOf);
                    sb2.append(" had ");
                    sb2.append(valueOf2);
                    sb = sb2.toString();
                } else {
                    if (!z3 || !zzbu.zzb()) {
                        z2 = false;
                    }
                    zzds<zzak> zzds3 = new zzds<>(zzbu.zza(hashMap), z2);
                    if (z2) {
                        this.zzl.zzb(zzro, zzds3);
                    }
                    zzak zza2 = zzds3.zza();
                    return zzds3;
                }
            }
        }
        zzdh.zza(sb);
        return zza;
    }

    private final zzds<zzak> zzo(zzak zzak, Set<String> set, zzdq zzdq) {
        String sb;
        if (!zzak.zzN()) {
            return new zzds<>(zzak, true);
        }
        int zzO = zzak.zzO();
        if (zzO == 2) {
            zzal zzal = (zzal) zzsa.zza(zzak).zzZ();
            zzal.zzj();
            for (int i2 = 0; i2 < zzak.zza(); i2++) {
                zzds<zzak> zzo = zzo(zzak.zzj(i2), set, new zzdq());
                zzds<zzak> zzds = zza;
                if (zzo == zzds) {
                    return zzds;
                }
                zzal.zze(zzo.zza());
            }
            return new zzds<>((zzak) zzal.zzC(), false);
        } else if (zzO == 3) {
            zzal zzal2 = (zzal) zzsa.zza(zzak).zzZ();
            if (zzak.zzc() != zzak.zzd()) {
                String valueOf = String.valueOf(zzak.toString());
                zzdh.zza(valueOf.length() != 0 ? "Invalid serving value: ".concat(valueOf) : new String("Invalid serving value: "));
                return zza;
            }
            zzal2.zzk();
            zzal2.zzl();
            for (int i3 = 0; i3 < zzak.zzc(); i3++) {
                zzds<zzak> zzo2 = zzo(zzak.zzk(i3), set, new zzdq());
                zzds<zzak> zzo3 = zzo(zzak.zzl(i3), set, new zzdq());
                zzds<zzak> zzds2 = zza;
                if (zzo2 == zzds2 || zzo3 == zzds2) {
                    return zzds2;
                }
                zzal2.zzf(zzo2.zza());
                zzal2.zzg(zzo3.zza());
            }
            return new zzds<>((zzak) zzal2.zzC(), false);
        } else if (zzO != 4) {
            if (zzO != 7) {
                String num = Integer.toString(zzak.zzO());
                StringBuilder sb2 = new StringBuilder(String.valueOf(num).length() + 14);
                sb2.append("Unknown type: ");
                sb2.append(num);
                zzdh.zza(sb2.toString());
                return zza;
            }
            zzal zzal3 = (zzal) zzsa.zza(zzak).zzZ();
            zzal3.zzm();
            for (int i4 = 0; i4 < zzak.zze(); i4++) {
                zzds<zzak> zzo4 = zzo(zzak.zzm(i4), set, new zzdq());
                zzds<zzak> zzds3 = zza;
                if (zzo4 == zzds3) {
                    return zzds3;
                }
                zzal3.zzh(zzo4.zza());
            }
            return new zzds<>((zzak) zzal3.zzC(), false);
        } else if (set.contains(zzak.zzo())) {
            String zzo5 = zzak.zzo();
            String obj = set.toString();
            StringBuilder sb3 = new StringBuilder(String.valueOf(zzo5).length() + 79 + String.valueOf(obj).length());
            sb3.append("Macro cycle detected.  Current macro reference: ");
            sb3.append(zzo5);
            sb3.append(".  Previous macro references: ");
            sb3.append(obj);
            sb3.append(".");
            zzdh.zza(sb3.toString());
            return zza;
        } else {
            set.add(zzak.zzo());
            zzds<zzak> zzm2 = zzm(zzak.zzo(), set, new zzdm());
            for (zzao zzao : (zzao[]) zzak.zzq().toArray(new zzao[0])) {
                if (!(zzfv.zzl(zzm2.zza()) instanceof String)) {
                    sb = "Escaping can only be applied to strings.";
                } else {
                    zzao zzao2 = zzao.ESCAPE_HTML;
                    if (zzao.ordinal() != 11) {
                        String valueOf2 = String.valueOf(zzao);
                        StringBuilder sb4 = new StringBuilder(String.valueOf(valueOf2).length() + 28);
                        sb4.append("Unsupported Value Escaping: ");
                        sb4.append(valueOf2);
                        sb = sb4.toString();
                    } else {
                        try {
                            zzm2 = new zzds<>(zzfv.zzc(zzfy.zza(zzfv.zzn(zzfv.zzl(zzm2.zza())))), zzm2.zzb());
                        } catch (UnsupportedEncodingException e2) {
                            zzdh.zzb("Escape URI: unsupported encoding", e2);
                        }
                    }
                }
                zzdh.zza(sb);
            }
            set.remove(zzak.zzo());
            return zzm2;
        }
    }

    public final synchronized void zzc(String str) {
        zzd(str);
        for (zzro zzn : zzl(this.zzf, new HashSet(), new zzeq(this), new zzdp()).zza()) {
            zzn(this.zzc, zzn, new HashSet(), new zzdn());
        }
        zzd((String) null);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zzd(String str) {
        this.zzi = str;
    }

    /* access modifiers changed from: package-private */
    public final zzds<Boolean> zzf(zzro zzro, Set<String> set, zzdn zzdn) {
        zzds<zzak> zzn = zzn(this.zzd, zzro, set, zzdn);
        Boolean zzg2 = zzfv.zzg(zzfv.zzl(zzn.zza()));
        zzfv.zzc(zzg2);
        return new zzds<>(zzg2, zzn.zzb());
    }
}
