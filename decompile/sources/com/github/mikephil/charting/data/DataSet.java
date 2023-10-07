package com.github.mikephil.charting.data;

import com.github.mikephil.charting.data.Entry;
import fg.i;
import java.util.ArrayList;
import java.util.List;

public abstract class DataSet<T extends Entry> extends d<T> {

    /* renamed from: o  reason: collision with root package name */
    protected List<T> f14967o;

    /* renamed from: p  reason: collision with root package name */
    protected float f14968p;

    /* renamed from: q  reason: collision with root package name */
    protected float f14969q;

    /* renamed from: r  reason: collision with root package name */
    protected float f14970r;

    /* renamed from: s  reason: collision with root package name */
    protected float f14971s;

    public enum Rounding {
        UP,
        DOWN,
        CLOSEST
    }

    public T a(float f2, float f3, Rounding rounding) {
        int b2 = b(f2, f3, rounding);
        if (b2 > -1) {
            return (Entry) this.f14967o.get(b2);
        }
        return null;
    }

    public List<T> a(float f2) {
        ArrayList arrayList = new ArrayList();
        int size = this.f14967o.size() - 1;
        int i2 = 0;
        while (true) {
            if (i2 > size) {
                break;
            }
            int i3 = (size + i2) / 2;
            Entry entry = (Entry) this.f14967o.get(i3);
            if (f2 == entry.i()) {
                while (i3 > 0 && ((Entry) this.f14967o.get(i3 - 1)).i() == f2) {
                    i3--;
                }
                int size2 = this.f14967o.size();
                while (i3 < size2) {
                    Entry entry2 = (Entry) this.f14967o.get(i3);
                    if (entry2.i() != f2) {
                        break;
                    }
                    arrayList.add(entry2);
                    i3++;
                }
            } else if (f2 > entry.i()) {
                i2 = i3 + 1;
            } else {
                size = i3 - 1;
            }
        }
        return arrayList;
    }

    public void a(float f2, float f3) {
        List<T> list = this.f14967o;
        if (list != null && !list.isEmpty()) {
            this.f14968p = -3.4028235E38f;
            this.f14969q = Float.MAX_VALUE;
            int b2 = b(f3, Float.NaN, Rounding.UP);
            for (int b3 = b(f2, Float.NaN, Rounding.DOWN); b3 <= b2; b3++) {
                a((Entry) this.f14967o.get(b3));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(T t2) {
        if (t2.b() < this.f14969q) {
            this.f14969q = t2.b();
        }
        if (t2.b() > this.f14968p) {
            this.f14968p = t2.b();
        }
    }

    public int b(float f2, float f3, Rounding rounding) {
        int i2;
        Entry entry;
        List<T> list = this.f14967o;
        if (list == null || list.isEmpty()) {
            return -1;
        }
        int i3 = 0;
        int size = this.f14967o.size() - 1;
        while (i3 < size) {
            int i4 = (i3 + size) / 2;
            float i5 = ((Entry) this.f14967o.get(i4)).i() - f2;
            int i6 = i4 + 1;
            float abs = Math.abs(i5);
            float abs2 = Math.abs(((Entry) this.f14967o.get(i6)).i() - f2);
            if (abs2 >= abs) {
                if (abs >= abs2) {
                    double d2 = (double) i5;
                    if (d2 < i.f27244a) {
                        if (d2 >= i.f27244a) {
                        }
                    }
                }
                size = i4;
            }
            i3 = i6;
        }
        if (size == -1) {
            return size;
        }
        float i7 = ((Entry) this.f14967o.get(size)).i();
        if (rounding == Rounding.UP) {
            if (i7 < f2 && size < this.f14967o.size() - 1) {
                size++;
            }
        } else if (rounding == Rounding.DOWN && i7 > f2 && size > 0) {
            size--;
        }
        if (Float.isNaN(f3)) {
            return size;
        }
        while (size > 0 && ((Entry) this.f14967o.get(size - 1)).i() == i7) {
            size--;
        }
        float b2 = ((Entry) this.f14967o.get(size)).b();
        loop2:
        while (true) {
            i2 = size;
            do {
                size++;
                if (size >= this.f14967o.size()) {
                    break loop2;
                }
                entry = (Entry) this.f14967o.get(size);
                if (entry.i() != i7) {
                    break loop2;
                }
            } while (Math.abs(entry.b() - f3) >= Math.abs(b2 - f3));
            b2 = f3;
        }
        return i2;
    }

    public int b(Entry entry) {
        return this.f14967o.indexOf(entry);
    }

    public T b(float f2, float f3) {
        return a(f2, f3, Rounding.CLOSEST);
    }

    public T d(int i2) {
        return (Entry) this.f14967o.get(i2);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(v());
        for (int i2 = 0; i2 < this.f14967o.size(); i2++) {
            stringBuffer.append(((Entry) this.f14967o.get(i2)).toString() + " ");
        }
        return stringBuffer.toString();
    }

    public int u() {
        return this.f14967o.size();
    }

    public String v() {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder sb = new StringBuilder();
        sb.append("DataSet, label: ");
        sb.append(f() == null ? "" : f());
        sb.append(", entries: ");
        sb.append(this.f14967o.size());
        sb.append("\n");
        stringBuffer.append(sb.toString());
        return stringBuffer.toString();
    }

    public float w() {
        return this.f14969q;
    }

    public float x() {
        return this.f14968p;
    }

    public float y() {
        return this.f14971s;
    }

    public float z() {
        return this.f14970r;
    }
}
