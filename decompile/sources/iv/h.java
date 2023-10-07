package iv;

public class h implements b {

    /* renamed from: a  reason: collision with root package name */
    private final int f13780a;

    /* renamed from: b  reason: collision with root package name */
    private final int f13781b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f13782c;

    /* renamed from: d  reason: collision with root package name */
    private final d f13783d;

    /* renamed from: e  reason: collision with root package name */
    private final String f13784e;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        int f13785a;

        /* renamed from: b  reason: collision with root package name */
        int f13786b;

        /* renamed from: c  reason: collision with root package name */
        boolean f13787c;

        /* renamed from: d  reason: collision with root package name */
        d f13788d;

        /* renamed from: e  reason: collision with root package name */
        String f13789e;

        private a() {
            this.f13785a = 2;
            this.f13786b = 0;
            this.f13787c = true;
            this.f13789e = "PRETTY_LOGGER";
        }

        public a a(int i2) {
            this.f13785a = i2;
            return this;
        }

        public a a(String str) {
            this.f13789e = str;
            return this;
        }

        public a a(boolean z2) {
            this.f13787c = z2;
            return this;
        }

        public h a() {
            if (this.f13788d == null) {
                this.f13788d = new e();
            }
            return new h(this);
        }

        public a b(int i2) {
            this.f13786b = i2;
            return this;
        }
    }

    private h(a aVar) {
        j.a(aVar);
        this.f13780a = aVar.f13785a;
        this.f13781b = aVar.f13786b;
        this.f13782c = aVar.f13787c;
        this.f13783d = aVar.f13788d;
        this.f13784e = aVar.f13789e;
    }

    private int a(StackTraceElement[] stackTraceElementArr) {
        j.a(stackTraceElementArr);
        for (int i2 = 5; i2 < stackTraceElementArr.length; i2++) {
            String className = stackTraceElementArr[i2].getClassName();
            if (!className.equals(g.class.getName()) && !className.equals(f.class.getName())) {
                return i2 - 1;
            }
        }
        return -1;
    }

    public static a a() {
        return new a();
    }

    private String a(String str) {
        j.a(str);
        return str.substring(str.lastIndexOf(".") + 1);
    }

    private void a(int i2, String str) {
        c(i2, str, "┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
    }

    private void a(int i2, String str, int i3) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (this.f13782c) {
            c(i2, str, "│ Thread: " + Thread.currentThread().getName());
            c(i2, str);
        }
        int a2 = a(stackTrace) + this.f13781b;
        if (i3 + a2 > stackTrace.length) {
            i3 = (stackTrace.length - a2) - 1;
        }
        String str2 = "";
        while (i3 > 0) {
            int i4 = i3 + a2;
            if (i4 < stackTrace.length) {
                str2 = str2 + "   ";
                c(i2, str, 9474 + ' ' + str2 + a(stackTrace[i4].getClassName()) + "." + stackTrace[i4].getMethodName() + " " + " (" + stackTrace[i4].getFileName() + ":" + stackTrace[i4].getLineNumber() + ")");
            }
            i3--;
        }
    }

    private String b(String str) {
        if (j.a((CharSequence) str) || j.a(this.f13784e, str)) {
            return this.f13784e;
        }
        return this.f13784e + "-" + str;
    }

    private void b(int i2, String str) {
        c(i2, str, "└────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
    }

    private void b(int i2, String str, String str2) {
        j.a(str2);
        for (String str3 : str2.split(System.getProperty("line.separator"))) {
            c(i2, str, "│ " + str3);
        }
    }

    private void c(int i2, String str) {
        c(i2, str, "├┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄");
    }

    private void c(int i2, String str, String str2) {
        j.a(str2);
        this.f13783d.a(i2, str, str2);
    }

    public void a(int i2, String str, String str2) {
        j.a(str2);
        String b2 = b(str);
        a(i2, b2);
        a(i2, b2, this.f13780a);
        byte[] bytes = str2.getBytes();
        int length = bytes.length;
        if (length <= 4000) {
            if (this.f13780a > 0) {
                c(i2, b2);
            }
            b(i2, b2, str2);
            b(i2, b2);
            return;
        }
        if (this.f13780a > 0) {
            c(i2, b2);
        }
        for (int i3 = 0; i3 < length; i3 += 4000) {
            b(i2, b2, new String(bytes, i3, Math.min(length - i3, 4000)));
        }
        b(i2, b2);
    }
}
