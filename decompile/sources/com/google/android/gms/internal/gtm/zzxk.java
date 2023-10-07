package com.google.android.gms.internal.gtm;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

class zzxk<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private final int zza;
    /* access modifiers changed from: private */
    public List<zzxe> zzb = Collections.emptyList();
    /* access modifiers changed from: private */
    public Map<K, V> zzc = Collections.emptyMap();
    private boolean zzd;
    private volatile zzxi zze;
    private Map<K, V> zzf = Collections.emptyMap();

    /* synthetic */ zzxk(int i2, zzxj zzxj) {
        this.zza = i2;
    }

    private final int zzk(K k2) {
        int size = this.zzb.size() - 1;
        int i2 = 0;
        if (size >= 0) {
            int compareTo = k2.compareTo(this.zzb.get(size).zza());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        while (i2 <= size) {
            int i3 = (i2 + size) / 2;
            int compareTo2 = k2.compareTo(this.zzb.get(i3).zza());
            if (compareTo2 < 0) {
                size = i3 - 1;
            } else if (compareTo2 <= 0) {
                return i3;
            } else {
                i2 = i3 + 1;
            }
        }
        return -(i2 + 1);
    }

    /* access modifiers changed from: private */
    public final V zzl(int i2) {
        zzn();
        V value = this.zzb.remove(i2).getValue();
        if (!this.zzc.isEmpty()) {
            Iterator it2 = zzm().entrySet().iterator();
            List<zzxe> list = this.zzb;
            Map.Entry entry = (Map.Entry) it2.next();
            list.add(new zzxe(this, (Comparable) entry.getKey(), entry.getValue()));
            it2.remove();
        }
        return value;
    }

    private final SortedMap<K, V> zzm() {
        zzn();
        if (this.zzc.isEmpty() && !(this.zzc instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.zzc = treeMap;
            this.zzf = treeMap.descendingMap();
        }
        return (SortedMap) this.zzc;
    }

    /* access modifiers changed from: private */
    public final void zzn() {
        if (this.zzd) {
            throw new UnsupportedOperationException();
        }
    }

    public final void clear() {
        zzn();
        if (!this.zzb.isEmpty()) {
            this.zzb.clear();
        }
        if (!this.zzc.isEmpty()) {
            this.zzc.clear();
        }
    }

    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return zzk(comparable) >= 0 || this.zzc.containsKey(comparable);
    }

    public final Set<Map.Entry<K, V>> entrySet() {
        if (this.zze == null) {
            this.zze = new zzxi(this, (zzxh) null);
        }
        return this.zze;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzxk)) {
            return super.equals(obj);
        }
        zzxk zzxk = (zzxk) obj;
        int size = size();
        if (size != zzxk.size()) {
            return false;
        }
        int zzb2 = zzb();
        if (zzb2 != zzxk.zzb()) {
            return entrySet().equals(zzxk.entrySet());
        }
        for (int i2 = 0; i2 < zzb2; i2++) {
            if (!zzg(i2).equals(zzxk.zzg(i2))) {
                return false;
            }
        }
        if (zzb2 != size) {
            return this.zzc.equals(zzxk.zzc);
        }
        return true;
    }

    public final V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int zzk = zzk(comparable);
        return zzk >= 0 ? this.zzb.get(zzk).getValue() : this.zzc.get(comparable);
    }

    public final int hashCode() {
        int zzb2 = zzb();
        int i2 = 0;
        for (int i3 = 0; i3 < zzb2; i3++) {
            i2 += this.zzb.get(i3).hashCode();
        }
        return this.zzc.size() > 0 ? i2 + this.zzc.hashCode() : i2;
    }

    public final V remove(Object obj) {
        zzn();
        Comparable comparable = (Comparable) obj;
        int zzk = zzk(comparable);
        if (zzk >= 0) {
            return zzl(zzk);
        }
        if (this.zzc.isEmpty()) {
            return null;
        }
        return this.zzc.remove(comparable);
    }

    public final int size() {
        return this.zzb.size() + this.zzc.size();
    }

    public void zza() {
        if (!this.zzd) {
            this.zzc = this.zzc.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.zzc);
            this.zzf = this.zzf.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.zzf);
            this.zzd = true;
        }
    }

    public final int zzb() {
        return this.zzb.size();
    }

    public final Iterable<Map.Entry<K, V>> zzc() {
        return this.zzc.isEmpty() ? zzxd.zza() : this.zzc.entrySet();
    }

    /* renamed from: zze */
    public final V put(K k2, V v2) {
        zzn();
        int zzk = zzk(k2);
        if (zzk >= 0) {
            return this.zzb.get(zzk).setValue(v2);
        }
        zzn();
        if (this.zzb.isEmpty() && !(this.zzb instanceof ArrayList)) {
            this.zzb = new ArrayList(this.zza);
        }
        int i2 = -(zzk + 1);
        if (i2 >= this.zza) {
            return zzm().put(k2, v2);
        }
        int size = this.zzb.size();
        int i3 = this.zza;
        if (size == i3) {
            zzxe remove = this.zzb.remove(i3 - 1);
            zzm().put(remove.zza(), remove.getValue());
        }
        this.zzb.add(i2, new zzxe(this, k2, v2));
        return null;
    }

    public final Map.Entry<K, V> zzg(int i2) {
        return this.zzb.get(i2);
    }

    public final boolean zzj() {
        return this.zzd;
    }
}
