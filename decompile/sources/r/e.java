package r;

import java.util.Locale;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final d f34192a = new C0253e((c) null, false);

    /* renamed from: b  reason: collision with root package name */
    public static final d f34193b = new C0253e((c) null, true);

    /* renamed from: c  reason: collision with root package name */
    public static final d f34194c = new C0253e(b.f34200a, false);

    /* renamed from: d  reason: collision with root package name */
    public static final d f34195d = new C0253e(b.f34200a, true);

    /* renamed from: e  reason: collision with root package name */
    public static final d f34196e = new C0253e(a.f34198a, false);

    /* renamed from: f  reason: collision with root package name */
    public static final d f34197f = f.f34203a;

    private static class a implements c {

        /* renamed from: a  reason: collision with root package name */
        static final a f34198a = new a(true);

        /* renamed from: b  reason: collision with root package name */
        private final boolean f34199b;

        private a(boolean z2) {
            this.f34199b = z2;
        }

        public int a(CharSequence charSequence, int i2, int i3) {
            int i4 = i3 + i2;
            boolean z2 = false;
            while (i2 < i4) {
                int a2 = e.a(Character.getDirectionality(charSequence.charAt(i2)));
                if (a2 != 0) {
                    if (a2 != 1) {
                        continue;
                        i2++;
                    } else if (!this.f34199b) {
                        return 1;
                    }
                } else if (this.f34199b) {
                    return 0;
                }
                z2 = true;
                i2++;
            }
            if (z2) {
                return this.f34199b ? 1 : 0;
            }
            return 2;
        }
    }

    private static class b implements c {

        /* renamed from: a  reason: collision with root package name */
        static final b f34200a = new b();

        private b() {
        }

        public int a(CharSequence charSequence, int i2, int i3) {
            int i4 = i3 + i2;
            int i5 = 2;
            while (i2 < i4 && i5 == 2) {
                i5 = e.b(Character.getDirectionality(charSequence.charAt(i2)));
                i2++;
            }
            return i5;
        }
    }

    private interface c {
        int a(CharSequence charSequence, int i2, int i3);
    }

    private static abstract class d implements d {

        /* renamed from: a  reason: collision with root package name */
        private final c f34201a;

        d(c cVar) {
            this.f34201a = cVar;
        }

        private boolean b(CharSequence charSequence, int i2, int i3) {
            int a2 = this.f34201a.a(charSequence, i2, i3);
            if (a2 == 0) {
                return true;
            }
            if (a2 != 1) {
                return a();
            }
            return false;
        }

        /* access modifiers changed from: protected */
        public abstract boolean a();

        public boolean a(CharSequence charSequence, int i2, int i3) {
            if (charSequence != null && i2 >= 0 && i3 >= 0 && charSequence.length() - i3 >= i2) {
                return this.f34201a == null ? a() : b(charSequence, i2, i3);
            }
            throw new IllegalArgumentException();
        }
    }

    /* renamed from: r.e$e  reason: collision with other inner class name */
    private static class C0253e extends d {

        /* renamed from: a  reason: collision with root package name */
        private final boolean f34202a;

        C0253e(c cVar, boolean z2) {
            super(cVar);
            this.f34202a = z2;
        }

        /* access modifiers changed from: protected */
        public boolean a() {
            return this.f34202a;
        }
    }

    private static class f extends d {

        /* renamed from: a  reason: collision with root package name */
        static final f f34203a = new f();

        f() {
            super((c) null);
        }

        /* access modifiers changed from: protected */
        public boolean a() {
            return f.a(Locale.getDefault()) == 1;
        }
    }

    static int a(int i2) {
        if (i2 != 0) {
            return (i2 == 1 || i2 == 2) ? 0 : 2;
        }
        return 1;
    }

    static int b(int i2) {
        if (i2 != 0) {
            if (i2 == 1 || i2 == 2) {
                return 0;
            }
            switch (i2) {
                case 14:
                case 15:
                    break;
                case 16:
                case 17:
                    return 0;
                default:
                    return 2;
            }
        }
        return 1;
    }
}
