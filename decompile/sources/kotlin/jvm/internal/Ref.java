package kotlin.jvm.internal;

import java.io.Serializable;

public class Ref {

    public static final class IntRef implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        public int f30236a;

        public String toString() {
            return String.valueOf(this.f30236a);
        }
    }

    public static final class ObjectRef<T> implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        public T f30237a;

        public String toString() {
            return String.valueOf(this.f30237a);
        }
    }
}
