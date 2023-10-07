package rx.exceptions;

import java.util.HashSet;
import java.util.Set;
import or.d;

public final class OnErrorThrowable extends RuntimeException {
    private static final long serialVersionUID = -569558213262703934L;

    public static class OnNextValue extends RuntimeException {
        private static final long serialVersionUID = -3454462756050397899L;

        /* renamed from: a  reason: collision with root package name */
        private final Object f34221a;

        private static final class a {

            /* renamed from: a  reason: collision with root package name */
            static final Set<Class<?>> f34222a = a();

            private static Set<Class<?>> a() {
                HashSet hashSet = new HashSet();
                hashSet.add(Boolean.class);
                hashSet.add(Character.class);
                hashSet.add(Byte.class);
                hashSet.add(Short.class);
                hashSet.add(Integer.class);
                hashSet.add(Long.class);
                hashSet.add(Float.class);
                hashSet.add(Double.class);
                return hashSet;
            }
        }

        public OnNextValue(Object obj) {
            super("OnError while emitting onNext value: " + a(obj));
            this.f34221a = obj;
        }

        static String a(Object obj) {
            if (obj == null) {
                return "null";
            }
            if (a.f34222a.contains(obj.getClass())) {
                return obj.toString();
            }
            if (obj instanceof String) {
                return (String) obj;
            }
            if (obj instanceof Enum) {
                return ((Enum) obj).name();
            }
            String a2 = d.a().b().a(obj);
            if (a2 != null) {
                return a2;
            }
            return obj.getClass().getName() + ".class";
        }

        public Object a() {
            return this.f34221a;
        }
    }

    public static Throwable a(Throwable th, Object obj) {
        if (th == null) {
            th = new NullPointerException();
        }
        Throwable b2 = a.b(th);
        if (b2 != null && (b2 instanceof OnNextValue) && ((OnNextValue) b2).a() == obj) {
            return th;
        }
        a.a(th, (Throwable) new OnNextValue(obj));
        return th;
    }
}
