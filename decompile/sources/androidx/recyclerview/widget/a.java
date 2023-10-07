package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.r;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import java.util.ArrayList;
import java.util.List;
import s.e;

final class a implements r.a {

    /* renamed from: a  reason: collision with root package name */
    final ArrayList<b> f4088a;

    /* renamed from: b  reason: collision with root package name */
    final ArrayList<b> f4089b;

    /* renamed from: c  reason: collision with root package name */
    final C0035a f4090c;

    /* renamed from: d  reason: collision with root package name */
    Runnable f4091d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f4092e;

    /* renamed from: f  reason: collision with root package name */
    final r f4093f;

    /* renamed from: g  reason: collision with root package name */
    private e.a<b> f4094g;

    /* renamed from: h  reason: collision with root package name */
    private int f4095h;

    /* renamed from: androidx.recyclerview.widget.a$a  reason: collision with other inner class name */
    interface C0035a {
        RecyclerView.v a(int i2);

        void a(int i2, int i3);

        void a(int i2, int i3, Object obj);

        void a(b bVar);

        void b(int i2, int i3);

        void b(b bVar);

        void c(int i2, int i3);

        void d(int i2, int i3);
    }

    static final class b {

        /* renamed from: a  reason: collision with root package name */
        int f4096a;

        /* renamed from: b  reason: collision with root package name */
        int f4097b;

        /* renamed from: c  reason: collision with root package name */
        Object f4098c;

        /* renamed from: d  reason: collision with root package name */
        int f4099d;

        b(int i2, int i3, int i4, Object obj) {
            this.f4096a = i2;
            this.f4097b = i3;
            this.f4099d = i4;
            this.f4098c = obj;
        }

        /* access modifiers changed from: package-private */
        public String a() {
            int i2 = this.f4096a;
            return i2 != 1 ? i2 != 2 ? i2 != 4 ? i2 != 8 ? "??" : "mv" : "up" : "rm" : ProductAction.ACTION_ADD;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            int i2 = this.f4096a;
            if (i2 != bVar.f4096a) {
                return false;
            }
            if (i2 == 8 && Math.abs(this.f4099d - this.f4097b) == 1 && this.f4099d == bVar.f4097b && this.f4097b == bVar.f4099d) {
                return true;
            }
            if (this.f4099d != bVar.f4099d || this.f4097b != bVar.f4097b) {
                return false;
            }
            Object obj2 = this.f4098c;
            Object obj3 = bVar.f4098c;
            if (obj2 != null) {
                if (!obj2.equals(obj3)) {
                    return false;
                }
            } else if (obj3 != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.f4096a * 31) + this.f4097b) * 31) + this.f4099d;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + a() + ",s:" + this.f4097b + "c:" + this.f4099d + ",p:" + this.f4098c + "]";
        }
    }

    a(C0035a aVar) {
        this(aVar, false);
    }

    a(C0035a aVar, boolean z2) {
        this.f4094g = new e.b(30);
        this.f4088a = new ArrayList<>();
        this.f4089b = new ArrayList<>();
        this.f4095h = 0;
        this.f4090c = aVar;
        this.f4092e = z2;
        this.f4093f = new r(this);
    }

    private void b(b bVar) {
        g(bVar);
    }

    private void c(b bVar) {
        char c2;
        boolean z2;
        boolean z3;
        int i2 = bVar.f4097b;
        int i3 = bVar.f4097b + bVar.f4099d;
        int i4 = bVar.f4097b;
        char c3 = 65535;
        int i5 = 0;
        while (i4 < i3) {
            if (this.f4090c.a(i4) != null || d(i4)) {
                if (c3 == 0) {
                    e(a(2, i2, i5, (Object) null));
                    z3 = true;
                } else {
                    z3 = false;
                }
                c2 = 1;
            } else {
                if (c3 == 1) {
                    g(a(2, i2, i5, (Object) null));
                    z2 = true;
                } else {
                    z2 = false;
                }
                c2 = 0;
            }
            if (z2) {
                i4 -= i5;
                i3 -= i5;
                i5 = 1;
            } else {
                i5++;
            }
            i4++;
            c3 = c2;
        }
        if (i5 != bVar.f4099d) {
            a(bVar);
            bVar = a(2, i2, i5, (Object) null);
        }
        if (c3 == 0) {
            e(bVar);
        } else {
            g(bVar);
        }
    }

    private int d(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        for (int size = this.f4089b.size() - 1; size >= 0; size--) {
            b bVar = this.f4089b.get(size);
            if (bVar.f4096a == 8) {
                if (bVar.f4097b < bVar.f4099d) {
                    i6 = bVar.f4097b;
                    i5 = bVar.f4099d;
                } else {
                    i6 = bVar.f4099d;
                    i5 = bVar.f4097b;
                }
                if (i2 < i6 || i2 > i5) {
                    if (i2 < bVar.f4097b) {
                        if (i3 == 1) {
                            bVar.f4097b++;
                            i7 = bVar.f4099d + 1;
                        } else if (i3 == 2) {
                            bVar.f4097b--;
                            i7 = bVar.f4099d - 1;
                        }
                        bVar.f4099d = i7;
                    }
                } else if (i6 == bVar.f4097b) {
                    if (i3 == 1) {
                        i9 = bVar.f4099d + 1;
                    } else {
                        if (i3 == 2) {
                            i9 = bVar.f4099d - 1;
                        }
                        i2++;
                    }
                    bVar.f4099d = i9;
                    i2++;
                } else {
                    if (i3 == 1) {
                        i8 = bVar.f4097b + 1;
                    } else {
                        if (i3 == 2) {
                            i8 = bVar.f4097b - 1;
                        }
                        i2--;
                    }
                    bVar.f4097b = i8;
                    i2--;
                }
            } else if (bVar.f4097b > i2) {
                if (i3 == 1) {
                    i4 = bVar.f4097b + 1;
                } else if (i3 == 2) {
                    i4 = bVar.f4097b - 1;
                }
                bVar.f4097b = i4;
            } else if (bVar.f4096a == 1) {
                i2 -= bVar.f4099d;
            } else if (bVar.f4096a == 2) {
                i2 += bVar.f4099d;
            }
        }
        for (int size2 = this.f4089b.size() - 1; size2 >= 0; size2--) {
            b bVar2 = this.f4089b.get(size2);
            if (bVar2.f4096a == 8) {
                if (bVar2.f4099d != bVar2.f4097b && bVar2.f4099d >= 0) {
                }
            } else if (bVar2.f4099d > 0) {
            }
            this.f4089b.remove(size2);
            a(bVar2);
        }
        return i2;
    }

    private void d(b bVar) {
        int i2 = bVar.f4097b;
        int i3 = bVar.f4097b + bVar.f4099d;
        char c2 = 65535;
        int i4 = 0;
        for (int i5 = bVar.f4097b; i5 < i3; i5++) {
            if (this.f4090c.a(i5) != null || d(i5)) {
                if (c2 == 0) {
                    e(a(4, i2, i4, bVar.f4098c));
                    i2 = i5;
                    i4 = 0;
                }
                c2 = 1;
            } else {
                if (c2 == 1) {
                    g(a(4, i2, i4, bVar.f4098c));
                    i2 = i5;
                    i4 = 0;
                }
                c2 = 0;
            }
            i4++;
        }
        if (i4 != bVar.f4099d) {
            Object obj = bVar.f4098c;
            a(bVar);
            bVar = a(4, i2, i4, obj);
        }
        if (c2 == 0) {
            e(bVar);
        } else {
            g(bVar);
        }
    }

    private boolean d(int i2) {
        int size = this.f4089b.size();
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = this.f4089b.get(i3);
            if (bVar.f4096a == 8) {
                if (a(bVar.f4099d, i3 + 1) == i2) {
                    return true;
                }
            } else if (bVar.f4096a == 1) {
                int i4 = bVar.f4097b + bVar.f4099d;
                for (int i5 = bVar.f4097b; i5 < i4; i5++) {
                    if (a(i5, i3 + 1) == i2) {
                        return true;
                    }
                }
                continue;
            } else {
                continue;
            }
        }
        return false;
    }

    private void e(b bVar) {
        int i2;
        if (bVar.f4096a == 1 || bVar.f4096a == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int d2 = d(bVar.f4097b, bVar.f4096a);
        int i3 = bVar.f4097b;
        int i4 = bVar.f4096a;
        if (i4 == 2) {
            i2 = 0;
        } else if (i4 == 4) {
            i2 = 1;
        } else {
            throw new IllegalArgumentException("op should be remove or update." + bVar);
        }
        int i5 = 1;
        for (int i6 = 1; i6 < bVar.f4099d; i6++) {
            int d3 = d(bVar.f4097b + (i2 * i6), bVar.f4096a);
            int i7 = bVar.f4096a;
            if (i7 == 2 ? d3 == d2 : i7 == 4 && d3 == d2 + 1) {
                i5++;
            } else {
                b a2 = a(bVar.f4096a, d2, i5, bVar.f4098c);
                a(a2, i3);
                a(a2);
                if (bVar.f4096a == 4) {
                    i3 += i5;
                }
                d2 = d3;
                i5 = 1;
            }
        }
        Object obj = bVar.f4098c;
        a(bVar);
        if (i5 > 0) {
            b a3 = a(bVar.f4096a, d2, i5, obj);
            a(a3, i3);
            a(a3);
        }
    }

    private void f(b bVar) {
        g(bVar);
    }

    private void g(b bVar) {
        this.f4089b.add(bVar);
        int i2 = bVar.f4096a;
        if (i2 == 1) {
            this.f4090c.c(bVar.f4097b, bVar.f4099d);
        } else if (i2 == 2) {
            this.f4090c.b(bVar.f4097b, bVar.f4099d);
        } else if (i2 == 4) {
            this.f4090c.a(bVar.f4097b, bVar.f4099d, bVar.f4098c);
        } else if (i2 == 8) {
            this.f4090c.d(bVar.f4097b, bVar.f4099d);
        } else {
            throw new IllegalArgumentException("Unknown update op type for " + bVar);
        }
    }

    /* access modifiers changed from: package-private */
    public int a(int i2, int i3) {
        int size = this.f4089b.size();
        while (i3 < size) {
            b bVar = this.f4089b.get(i3);
            if (bVar.f4096a == 8) {
                if (bVar.f4097b == i2) {
                    i2 = bVar.f4099d;
                } else {
                    if (bVar.f4097b < i2) {
                        i2--;
                    }
                    if (bVar.f4099d <= i2) {
                        i2++;
                    }
                }
            } else if (bVar.f4097b > i2) {
                continue;
            } else if (bVar.f4096a == 2) {
                if (i2 < bVar.f4097b + bVar.f4099d) {
                    return -1;
                }
                i2 -= bVar.f4099d;
            } else if (bVar.f4096a == 1) {
                i2 += bVar.f4099d;
            }
            i3++;
        }
        return i2;
    }

    public b a(int i2, int i3, int i4, Object obj) {
        b a2 = this.f4094g.a();
        if (a2 == null) {
            return new b(i2, i3, i4, obj);
        }
        a2.f4096a = i2;
        a2.f4097b = i3;
        a2.f4099d = i4;
        a2.f4098c = obj;
        return a2;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        a((List<b>) this.f4088a);
        a((List<b>) this.f4089b);
        this.f4095h = 0;
    }

    public void a(b bVar) {
        if (!this.f4092e) {
            bVar.f4098c = null;
            this.f4094g.a(bVar);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(b bVar, int i2) {
        this.f4090c.a(bVar);
        int i3 = bVar.f4096a;
        if (i3 == 2) {
            this.f4090c.a(i2, bVar.f4099d);
        } else if (i3 == 4) {
            this.f4090c.a(i2, bVar.f4099d, bVar.f4098c);
        } else {
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    /* access modifiers changed from: package-private */
    public void a(List<b> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            a(list.get(i2));
        }
        list.clear();
    }

    /* access modifiers changed from: package-private */
    public boolean a(int i2) {
        return (i2 & this.f4095h) != 0;
    }

    /* access modifiers changed from: package-private */
    public boolean a(int i2, int i3, int i4) {
        if (i2 == i3) {
            return false;
        }
        if (i4 == 1) {
            this.f4088a.add(a(8, i2, i3, (Object) null));
            this.f4095h |= 8;
            return this.f4088a.size() == 1;
        }
        throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
    }

    /* access modifiers changed from: package-private */
    public boolean a(int i2, int i3, Object obj) {
        if (i3 < 1) {
            return false;
        }
        this.f4088a.add(a(4, i2, i3, obj));
        this.f4095h |= 4;
        return this.f4088a.size() == 1;
    }

    /* access modifiers changed from: package-private */
    public int b(int i2) {
        return a(i2, 0);
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.f4093f.a(this.f4088a);
        int size = this.f4088a.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.f4088a.get(i2);
            int i3 = bVar.f4096a;
            if (i3 == 1) {
                f(bVar);
            } else if (i3 == 2) {
                c(bVar);
            } else if (i3 == 4) {
                d(bVar);
            } else if (i3 == 8) {
                b(bVar);
            }
            Runnable runnable = this.f4091d;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.f4088a.clear();
    }

    /* access modifiers changed from: package-private */
    public boolean b(int i2, int i3) {
        if (i3 < 1) {
            return false;
        }
        this.f4088a.add(a(1, i2, i3, (Object) null));
        this.f4095h |= 1;
        return this.f4088a.size() == 1;
    }

    public int c(int i2) {
        int size = this.f4088a.size();
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = this.f4088a.get(i3);
            int i4 = bVar.f4096a;
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 == 8) {
                        if (bVar.f4097b == i2) {
                            i2 = bVar.f4099d;
                        } else {
                            if (bVar.f4097b < i2) {
                                i2--;
                            }
                            if (bVar.f4099d <= i2) {
                                i2++;
                            }
                        }
                    }
                } else if (bVar.f4097b > i2) {
                    continue;
                } else if (bVar.f4097b + bVar.f4099d > i2) {
                    return -1;
                } else {
                    i2 -= bVar.f4099d;
                }
            } else if (bVar.f4097b <= i2) {
                i2 += bVar.f4099d;
            }
        }
        return i2;
    }

    /* access modifiers changed from: package-private */
    public void c() {
        int size = this.f4089b.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f4090c.b(this.f4089b.get(i2));
        }
        a((List<b>) this.f4089b);
        this.f4095h = 0;
    }

    /* access modifiers changed from: package-private */
    public boolean c(int i2, int i3) {
        if (i3 < 1) {
            return false;
        }
        this.f4088a.add(a(2, i2, i3, (Object) null));
        this.f4095h |= 2;
        return this.f4088a.size() == 1;
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        return this.f4088a.size() > 0;
    }

    /* access modifiers changed from: package-private */
    public void e() {
        c();
        int size = this.f4088a.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.f4088a.get(i2);
            int i3 = bVar.f4096a;
            if (i3 == 1) {
                this.f4090c.b(bVar);
                this.f4090c.c(bVar.f4097b, bVar.f4099d);
            } else if (i3 == 2) {
                this.f4090c.b(bVar);
                this.f4090c.a(bVar.f4097b, bVar.f4099d);
            } else if (i3 == 4) {
                this.f4090c.b(bVar);
                this.f4090c.a(bVar.f4097b, bVar.f4099d, bVar.f4098c);
            } else if (i3 == 8) {
                this.f4090c.b(bVar);
                this.f4090c.d(bVar.f4097b, bVar.f4099d);
            }
            Runnable runnable = this.f4091d;
            if (runnable != null) {
                runnable.run();
            }
        }
        a((List<b>) this.f4088a);
        this.f4095h = 0;
    }

    /* access modifiers changed from: package-private */
    public boolean f() {
        return !this.f4089b.isEmpty() && !this.f4088a.isEmpty();
    }
}
