package com.google.android.gms.tagmanager;

import com.google.android.gms.common.internal.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.checkerframework.dataflow.qual.SideEffectFree;

public class DataLayer {
    public static final Object OBJECT_NOT_PRESENT = new Object();
    static final String[] zza = "gtm.lifetime".split("\\.");
    private static final Pattern zzb = Pattern.compile("(\\d+)\\s*([smhd]?)");
    private final ConcurrentHashMap<zzav, Integer> zzc;
    private final Map<String, Object> zzd;
    private final ReentrantLock zze;
    private final LinkedList<Map<String, Object>> zzf;
    private final zzax zzg;
    /* access modifiers changed from: private */
    public final CountDownLatch zzh;

    DataLayer() {
        this(new zzas());
    }

    DataLayer(zzax zzax) {
        this.zzg = zzax;
        this.zzc = new ConcurrentHashMap<>();
        this.zzd = new HashMap();
        this.zze = new ReentrantLock();
        this.zzf = new LinkedList<>();
        this.zzh = new CountDownLatch(1);
        zzax.zzb(new zzat(this));
    }

    private final void zzh(Map<String, Object> map, String str, Collection<zzau> collection) {
        for (Map.Entry next : map.entrySet()) {
            String str2 = str.length() == 0 ? "" : ".";
            String str3 = (String) next.getKey();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + str2.length() + String.valueOf(str3).length());
            sb.append(str);
            sb.append(str2);
            sb.append(str3);
            String sb2 = sb.toString();
            if (next.getValue() instanceof Map) {
                zzh((Map) next.getValue(), sb2, collection);
            } else if (!sb2.equals("gtm.lifetime")) {
                collection.add(new zzau(sb2, next.getValue()));
            }
        }
    }

    /* access modifiers changed from: private */
    public final void zzi(Map<String, Object> map) {
        Long l2;
        long j2;
        String concat;
        zzbg zzbg;
        this.zze.lock();
        try {
            this.zzf.offer(map);
            if (this.zze.getHoldCount() == 1) {
                int i2 = 0;
                while (true) {
                    Map poll = this.zzf.poll();
                    if (poll == null) {
                        break;
                    }
                    synchronized (this.zzd) {
                        for (String str : poll.keySet()) {
                            zzf(zza(str, poll.get(str)), this.zzd);
                        }
                    }
                    for (zzav zza2 : this.zzc.keySet()) {
                        zza2.zza(poll);
                    }
                    i2++;
                    if (i2 > 500) {
                        this.zzf.clear();
                        throw new RuntimeException("Seems like an infinite loop of pushing to the data layer");
                    }
                }
            }
            String[] strArr = zza;
            int length = strArr.length;
            Object obj = map;
            int i3 = 0;
            while (true) {
                l2 = null;
                if (i3 >= length) {
                    break;
                }
                String str2 = strArr[i3];
                if (!(obj instanceof Map)) {
                    obj = null;
                    break;
                } else {
                    obj = ((Map) obj).get(str2);
                    i3++;
                }
            }
            if (obj != null) {
                String obj2 = obj.toString();
                Matcher matcher = zzb.matcher(obj2);
                if (!matcher.matches()) {
                    String valueOf = String.valueOf(obj2);
                    concat = valueOf.length() != 0 ? "unknown _lifetime: ".concat(valueOf) : new String("unknown _lifetime: ");
                    zzbg = zzdh.zzb;
                } else {
                    try {
                        String group = matcher.group(1);
                        m.a(group);
                        j2 = Long.parseLong(group);
                    } catch (NumberFormatException unused) {
                        String valueOf2 = String.valueOf(obj2);
                        zzdh.zzc(valueOf2.length() != 0 ? "illegal number in _lifetime value: ".concat(valueOf2) : new String("illegal number in _lifetime value: "));
                        j2 = 0;
                    }
                    if (j2 <= 0) {
                        String valueOf3 = String.valueOf(obj2);
                        concat = valueOf3.length() != 0 ? "non-positive _lifetime: ".concat(valueOf3) : new String("non-positive _lifetime: ");
                        zzbg = zzdh.zzb;
                    } else {
                        String group2 = matcher.group(2);
                        m.a(group2);
                        if (group2.length() == 0) {
                            l2 = Long.valueOf(j2);
                        } else {
                            char charAt = group2.charAt(0);
                            if (charAt == 'd') {
                                l2 = Long.valueOf(j2 * 86400000);
                            } else if (charAt == 'h') {
                                l2 = Long.valueOf(j2 * 3600000);
                            } else if (charAt == 'm') {
                                l2 = Long.valueOf(j2 * 60000);
                            } else if (charAt != 's') {
                                String valueOf4 = String.valueOf(obj2);
                                zzdh.zzc(valueOf4.length() != 0 ? "unknown units in _lifetime: ".concat(valueOf4) : new String("unknown units in _lifetime: "));
                            } else {
                                l2 = Long.valueOf(j2 * 1000);
                            }
                        }
                    }
                }
                zzbg.zzb(concat);
            }
            if (l2 != null) {
                ArrayList arrayList = new ArrayList();
                zzh(map, "", arrayList);
                this.zzg.zzc(arrayList, l2.longValue());
            }
            this.zze.unlock();
        } catch (Throwable th) {
            this.zze.unlock();
            throw th;
        }
    }

    @SideEffectFree
    public void push(Map<String, Object> map) {
        try {
            this.zzh.await();
        } catch (InterruptedException unused) {
            zzdh.zzc("DataLayer.push: unexpected InterruptedException");
        }
        zzi(map);
    }

    public String toString() {
        String sb;
        synchronized (this.zzd) {
            StringBuilder sb2 = new StringBuilder();
            for (Map.Entry next : this.zzd.entrySet()) {
                sb2.append(String.format("{\n\tKey: %s\n\tValue: %s\n}\n", new Object[]{next.getKey(), next.getValue()}));
            }
            sb = sb2.toString();
        }
        return sb;
    }

    /* access modifiers changed from: package-private */
    public final Map<String, Object> zza(String str, Object obj) {
        HashMap hashMap = new HashMap();
        String[] split = str.toString().split("\\.");
        int i2 = 0;
        HashMap hashMap2 = hashMap;
        while (true) {
            int length = split.length - 1;
            if (i2 < length) {
                HashMap hashMap3 = new HashMap();
                hashMap2.put(split[i2], hashMap3);
                i2++;
                hashMap2 = hashMap3;
            } else {
                hashMap2.put(split[length], obj);
                return hashMap;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zze(List<Object> list, List<Object> list2) {
        while (list2.size() < list.size()) {
            list2.add((Object) null);
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            Object obj = list.get(i2);
            if (obj instanceof List) {
                if (!(list2.get(i2) instanceof List)) {
                    list2.set(i2, new ArrayList());
                }
                Object obj2 = list2.get(i2);
                m.a(obj2);
                zze((List) obj, (List) obj2);
            } else if (obj instanceof Map) {
                if (!(list2.get(i2) instanceof Map)) {
                    list2.set(i2, new HashMap());
                }
                Object obj3 = list2.get(i2);
                m.a(obj3);
                zzf((Map) obj, (Map) obj3);
            } else if (obj != OBJECT_NOT_PRESENT) {
                list2.set(i2, obj);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzf(Map<String, Object> map, Map<String, Object> map2) {
        for (String next : map.keySet()) {
            Object obj = map.get(next);
            if (obj instanceof List) {
                if (!(map2.get(next) instanceof List)) {
                    map2.put(next, new ArrayList());
                }
                Object obj2 = map2.get(next);
                m.a(obj2);
                zze((List) obj, (List) obj2);
            } else if (obj instanceof Map) {
                if (!(map2.get(next) instanceof Map)) {
                    map2.put(next, new HashMap());
                }
                Object obj3 = map2.get(next);
                m.a(obj3);
                zzf((Map) obj, (Map) obj3);
            } else {
                map2.put(next, obj);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzg(zzav zzav) {
        this.zzc.put(zzav, 0);
    }
}
