package me.yokeyword.fragmentation;

public class a {

    /* renamed from: a  reason: collision with root package name */
    static volatile a f31094a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f31095b;

    /* renamed from: c  reason: collision with root package name */
    private int f31096c = 2;

    /* renamed from: d  reason: collision with root package name */
    private mv.a f31097d;

    /* renamed from: me.yokeyword.fragmentation.a$a  reason: collision with other inner class name */
    public static class C0225a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public boolean f31098a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public int f31099b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public mv.a f31100c;
    }

    a(C0225a aVar) {
        boolean a2 = aVar.f31098a;
        this.f31095b = a2;
        this.f31096c = a2 ? aVar.f31099b : 0;
        this.f31097d = aVar.f31100c;
    }

    public static a a() {
        if (f31094a == null) {
            synchronized (a.class) {
                if (f31094a == null) {
                    f31094a = new a(new C0225a());
                }
            }
        }
        return f31094a;
    }

    public mv.a b() {
        return this.f31097d;
    }

    public int c() {
        return this.f31096c;
    }
}
