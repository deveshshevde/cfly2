package kotlin.jvm;

import java.util.Objects;
import kotlin.jvm.internal.c;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;
import ms.b;

public final class a {
    public static final <T> Class<T> a(b<T> bVar) {
        h.d(bVar, "$this$javaObjectType");
        Class a2 = ((c) bVar).a();
        if (!a2.isPrimitive()) {
            Objects.requireNonNull(a2, "null cannot be cast to non-null type java.lang.Class<T>");
            return a2;
        }
        String name = a2.getName();
        if (name != null) {
            switch (name.hashCode()) {
                case -1325958191:
                    if (name.equals("double")) {
                        a2 = Double.class;
                        break;
                    }
                    break;
                case 104431:
                    if (name.equals("int")) {
                        a2 = Integer.class;
                        break;
                    }
                    break;
                case 3039496:
                    if (name.equals("byte")) {
                        a2 = Byte.class;
                        break;
                    }
                    break;
                case 3052374:
                    if (name.equals("char")) {
                        a2 = Character.class;
                        break;
                    }
                    break;
                case 3327612:
                    if (name.equals("long")) {
                        a2 = Long.class;
                        break;
                    }
                    break;
                case 3625364:
                    if (name.equals("void")) {
                        a2 = Void.class;
                        break;
                    }
                    break;
                case 64711720:
                    if (name.equals("boolean")) {
                        a2 = Boolean.class;
                        break;
                    }
                    break;
                case 97526364:
                    if (name.equals("float")) {
                        a2 = Float.class;
                        break;
                    }
                    break;
                case 109413500:
                    if (name.equals("short")) {
                        a2 = Short.class;
                        break;
                    }
                    break;
            }
        }
        Objects.requireNonNull(a2, "null cannot be cast to non-null type java.lang.Class<T>");
        return a2;
    }

    public static final <T> b<T> a(Class<T> cls) {
        h.d(cls, "$this$kotlin");
        return j.b(cls);
    }
}
