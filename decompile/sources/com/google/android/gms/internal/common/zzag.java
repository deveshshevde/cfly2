package com.google.android.gms.internal.common;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.RandomAccess;

public abstract class zzag<E> extends zzac<E> implements List<E>, RandomAccess {
    private static final zzak<Object> zza = new zzae(zzai.zza, 0);

    zzag() {
    }

    static <E> zzag<E> zzi(Object[] objArr, int i2) {
        return i2 == 0 ? zzai.zza : new zzai(objArr, i2);
    }

    public static <E> zzag<E> zzj(Iterable<? extends E> iterable) {
        Objects.requireNonNull(iterable);
        if (iterable instanceof Collection) {
            return zzk((Collection) iterable);
        }
        Iterator<? extends E> it2 = iterable.iterator();
        if (!it2.hasNext()) {
            return zzai.zza;
        }
        Object next = it2.next();
        if (!it2.hasNext()) {
            return zzm(next);
        }
        zzad zzad = new zzad(4);
        zzad.zzb(next);
        zzad.zzc(it2);
        zzad.zzc = true;
        return zzi(zzad.zza, zzad.zzb);
    }

    public static <E> zzag<E> zzk(Collection<? extends E> collection) {
        if (collection instanceof zzac) {
            zzag<E> zzd = ((zzac) collection).zzd();
            if (!zzd.zzf()) {
                return zzd;
            }
            Object[] array = zzd.toArray();
            return zzi(array, array.length);
        }
        Object[] array2 = collection.toArray();
        int length = array2.length;
        zzah.zza(array2, length);
        return zzi(array2, length);
    }

    public static <E> zzag<E> zzl() {
        return zzai.zza;
    }

    public static <E> zzag<E> zzm(E e2) {
        Object[] objArr = {e2};
        zzah.zza(objArr, 1);
        return zzi(objArr, 1);
    }

    public static <E> zzag<E> zzn(E e2, E e3) {
        Object[] objArr = {e2, e3};
        zzah.zza(objArr, 2);
        return zzi(objArr, 2);
    }

    @Deprecated
    public final void add(int i2, E e2) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean addAll(int i2, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    public final boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (list instanceof RandomAccess) {
                    int i2 = 0;
                    while (i2 < size) {
                        if (zzr.zza(get(i2), list.get(i2))) {
                            i2++;
                        }
                    }
                    return true;
                }
                Iterator it2 = iterator();
                Iterator it3 = list.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (it3.hasNext()) {
                            if (!zzr.zza(it2.next(), it3.next())) {
                                break;
                            }
                        } else {
                            break;
                        }
                    } else if (!it3.hasNext()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int size = size();
        int i2 = 1;
        for (int i3 = 0; i3 < size; i3++) {
            i2 = (i2 * 31) + get(i3).hashCode();
        }
        return i2;
    }

    public final int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (obj.equals(get(i2))) {
                return i2;
            }
        }
        return -1;
    }

    public final /* synthetic */ Iterator iterator() {
        return listIterator(0);
    }

    public final int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    public final /* synthetic */ ListIterator listIterator() {
        return listIterator(0);
    }

    @Deprecated
    public final E remove(int i2) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final E set(int i2, E e2) {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public int zza(Object[] objArr, int i2) {
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            objArr[i3] = get(i3);
        }
        return size;
    }

    @Deprecated
    public final zzag<E> zzd() {
        return this;
    }

    public final zzaj<E> zze() {
        return listIterator(0);
    }

    /* renamed from: zzh */
    public zzag<E> subList(int i2, int i3) {
        zzs.zzc(i2, i3, size());
        int i4 = i3 - i2;
        return i4 == size() ? this : i4 == 0 ? zzai.zza : new zzaf(this, i2, i4);
    }

    /* renamed from: zzo */
    public final zzak<E> listIterator(int i2) {
        zzs.zzb(i2, size(), "index");
        return isEmpty() ? zza : new zzae(this, i2);
    }
}
