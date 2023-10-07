package kotlin.text;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import kotlin.Pair;
import kotlin.jvm.internal.h;
import mm.m;
import mr.c;
import mr.d;
import mt.b;

final class e implements b<c> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final CharSequence f30268a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final int f30269b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final int f30270c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final m<CharSequence, Integer, Pair<Integer, Integer>> f30271d;

    public static final class a implements Iterator<c>, mn.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f30272a;

        /* renamed from: b  reason: collision with root package name */
        private int f30273b = -1;

        /* renamed from: c  reason: collision with root package name */
        private int f30274c;

        /* renamed from: d  reason: collision with root package name */
        private int f30275d;

        /* renamed from: e  reason: collision with root package name */
        private c f30276e;

        /* renamed from: f  reason: collision with root package name */
        private int f30277f;

        a(e eVar) {
            this.f30272a = eVar;
            int a2 = d.a(eVar.f30269b, 0, eVar.f30268a.length());
            this.f30274c = a2;
            this.f30275d = a2;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0023, code lost:
            if (r0 < kotlin.text.e.a(r6.f30272a)) goto L_0x0025;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final void b() {
            /*
                r6 = this;
                int r0 = r6.f30275d
                r1 = 0
                if (r0 >= 0) goto L_0x000e
                r6.f30273b = r1
                r0 = 0
                mr.c r0 = (mr.c) r0
                r6.f30276e = r0
                goto L_0x009b
            L_0x000e:
                kotlin.text.e r0 = r6.f30272a
                int r0 = r0.f30270c
                r2 = -1
                r3 = 1
                if (r0 <= 0) goto L_0x0025
                int r0 = r6.f30277f
                int r0 = r0 + r3
                r6.f30277f = r0
                kotlin.text.e r4 = r6.f30272a
                int r4 = r4.f30270c
                if (r0 >= r4) goto L_0x0033
            L_0x0025:
                int r0 = r6.f30275d
                kotlin.text.e r4 = r6.f30272a
                java.lang.CharSequence r4 = r4.f30268a
                int r4 = r4.length()
                if (r0 <= r4) goto L_0x0049
            L_0x0033:
                int r0 = r6.f30274c
                mr.c r1 = new mr.c
                kotlin.text.e r4 = r6.f30272a
                java.lang.CharSequence r4 = r4.f30268a
                int r4 = kotlin.text.f.d(r4)
                r1.<init>(r0, r4)
            L_0x0044:
                r6.f30276e = r1
            L_0x0046:
                r6.f30275d = r2
                goto L_0x0099
            L_0x0049:
                kotlin.text.e r0 = r6.f30272a
                mm.m r0 = r0.f30271d
                kotlin.text.e r4 = r6.f30272a
                java.lang.CharSequence r4 = r4.f30268a
                int r5 = r6.f30275d
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                java.lang.Object r0 = r0.a(r4, r5)
                kotlin.Pair r0 = (kotlin.Pair) r0
                if (r0 != 0) goto L_0x0075
                int r0 = r6.f30274c
                mr.c r1 = new mr.c
                kotlin.text.e r4 = r6.f30272a
                java.lang.CharSequence r4 = r4.f30268a
                int r4 = kotlin.text.f.d(r4)
                r1.<init>(r0, r4)
                goto L_0x0044
            L_0x0075:
                java.lang.Object r2 = r0.c()
                java.lang.Number r2 = (java.lang.Number) r2
                int r2 = r2.intValue()
                java.lang.Object r0 = r0.d()
                java.lang.Number r0 = (java.lang.Number) r0
                int r0 = r0.intValue()
                int r4 = r6.f30274c
                mr.c r4 = mr.d.b((int) r4, (int) r2)
                r6.f30276e = r4
                int r2 = r2 + r0
                r6.f30274c = r2
                if (r0 != 0) goto L_0x0097
                r1 = 1
            L_0x0097:
                int r2 = r2 + r1
                goto L_0x0046
            L_0x0099:
                r6.f30273b = r3
            L_0x009b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.text.e.a.b():void");
        }

        /* renamed from: a */
        public c next() {
            if (this.f30273b == -1) {
                b();
            }
            if (this.f30273b != 0) {
                c cVar = this.f30276e;
                Objects.requireNonNull(cVar, "null cannot be cast to non-null type kotlin.ranges.IntRange");
                this.f30276e = null;
                this.f30273b = -1;
                return cVar;
            }
            throw new NoSuchElementException();
        }

        public boolean hasNext() {
            if (this.f30273b == -1) {
                b();
            }
            return this.f30273b == 1;
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public e(CharSequence charSequence, int i2, int i3, m<? super CharSequence, ? super Integer, Pair<Integer, Integer>> mVar) {
        h.d(charSequence, "input");
        h.d(mVar, "getNextMatch");
        this.f30268a = charSequence;
        this.f30269b = i2;
        this.f30270c = i3;
        this.f30271d = mVar;
    }

    public Iterator<c> a() {
        return new a(this);
    }
}
