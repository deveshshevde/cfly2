package df;

import java.util.Arrays;

public final class b {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final String f26694a;

        /* renamed from: b  reason: collision with root package name */
        private C0164a f26695b;

        /* renamed from: c  reason: collision with root package name */
        private C0164a f26696c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f26697d;

        /* renamed from: df.b$a$a  reason: collision with other inner class name */
        private static final class C0164a {

            /* renamed from: a  reason: collision with root package name */
            String f26698a;

            /* renamed from: b  reason: collision with root package name */
            Object f26699b;

            /* renamed from: c  reason: collision with root package name */
            C0164a f26700c;

            private C0164a() {
            }
        }

        private a(String str) {
            C0164a aVar = new C0164a();
            this.f26695b = aVar;
            this.f26696c = aVar;
            this.f26697d = false;
            this.f26694a = (String) c.a(str);
        }

        private C0164a a() {
            C0164a aVar = new C0164a();
            this.f26696c.f26700c = aVar;
            this.f26696c = aVar;
            return aVar;
        }

        private a b(String str, Object obj) {
            C0164a a2 = a();
            a2.f26699b = obj;
            a2.f26698a = (String) c.a(str);
            return this;
        }

        public a a(String str, int i2) {
            return b(str, String.valueOf(i2));
        }

        public a a(String str, Object obj) {
            return b(str, obj);
        }

        public a a(String str, boolean z2) {
            return b(str, String.valueOf(z2));
        }

        public String toString() {
            boolean z2 = this.f26697d;
            StringBuilder sb = new StringBuilder(32);
            sb.append(this.f26694a);
            sb.append('{');
            String str = "";
            for (C0164a aVar = this.f26695b.f26700c; aVar != null; aVar = aVar.f26700c) {
                if (!z2 || aVar.f26699b != null) {
                    sb.append(str);
                    if (aVar.f26698a != null) {
                        sb.append(aVar.f26698a);
                        sb.append('=');
                    }
                    sb.append(aVar.f26699b);
                    str = ", ";
                }
            }
            sb.append('}');
            return sb.toString();
        }
    }

    public static int a(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static a a(Object obj) {
        return new a(a(obj.getClass()));
    }

    private static String a(Class<?> cls) {
        String replaceAll = cls.getName().replaceAll("\\$[0-9]+", "\\$");
        int lastIndexOf = replaceAll.lastIndexOf(36);
        if (lastIndexOf == -1) {
            lastIndexOf = replaceAll.lastIndexOf(46);
        }
        return replaceAll.substring(lastIndexOf + 1);
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }
}
