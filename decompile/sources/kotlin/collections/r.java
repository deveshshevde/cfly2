package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.jvm.internal.h;
import kotlin.text.f;
import mm.b;

class r extends q {
    public static final <T, A extends Appendable> A a(Iterable<? extends T> iterable, A a2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, b<? super T, ? extends CharSequence> bVar) {
        h.d(iterable, "$this$joinTo");
        h.d(a2, "buffer");
        h.d(charSequence, "separator");
        h.d(charSequence2, "prefix");
        h.d(charSequence3, "postfix");
        h.d(charSequence4, "truncated");
        a2.append(charSequence2);
        int i3 = 0;
        for (Object next : iterable) {
            i3++;
            if (i3 > 1) {
                a2.append(charSequence);
            }
            if (i2 >= 0 && i3 > i2) {
                break;
            }
            f.a(a2, next, bVar);
        }
        if (i2 >= 0 && i3 > i2) {
            a2.append(charSequence4);
        }
        a2.append(charSequence3);
        return a2;
    }

    public static final <T> T a(Iterable<? extends T> iterable) {
        h.d(iterable, "$this$single");
        if (iterable instanceof List) {
            return h.f((List) iterable);
        }
        Iterator<? extends T> it2 = iterable.iterator();
        if (it2.hasNext()) {
            T next = it2.next();
            if (!it2.hasNext()) {
                return next;
            }
            throw new IllegalArgumentException("Collection has more than one element.");
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static final <T> String a(Iterable<? extends T> iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, b<? super T, ? extends CharSequence> bVar) {
        h.d(iterable, "$this$joinToString");
        h.d(charSequence, "separator");
        h.d(charSequence2, "prefix");
        h.d(charSequence3, "postfix");
        h.d(charSequence4, "truncated");
        String sb = ((StringBuilder) h.a(iterable, new StringBuilder(), charSequence, charSequence2, charSequence3, i2, charSequence4, bVar)).toString();
        h.b(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    public static /* synthetic */ String a(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, b bVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
        }
        if ((i3 & 2) != 0) {
            charSequence2 = "";
        }
        CharSequence charSequence5 = charSequence2;
        if ((i3 & 4) != 0) {
            charSequence3 = "";
        }
        CharSequence charSequence6 = charSequence3;
        int i4 = (i3 & 8) != 0 ? -1 : i2;
        if ((i3 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i3 & 32) != 0) {
            bVar = null;
        }
        return h.a(iterable, charSequence, charSequence5, charSequence6, i4, charSequence7, bVar);
    }

    public static final <T, C extends Collection<? super T>> C a(Iterable<? extends T> iterable, C c2) {
        h.d(iterable, "$this$toCollection");
        h.d(c2, "destination");
        for (Object add : iterable) {
            c2.add(add);
        }
        return c2;
    }

    public static final <T> List<T> a(Collection<? extends T> collection) {
        h.d(collection, "$this$toMutableList");
        return new ArrayList<>(collection);
    }

    public static final <T> boolean a(Iterable<? extends T> iterable, T t2) {
        h.d(iterable, "$this$contains");
        return iterable instanceof Collection ? ((Collection) iterable).contains(t2) : h.b(iterable, t2) >= 0;
    }

    public static final <T> int b(Iterable<? extends T> iterable, T t2) {
        h.d(iterable, "$this$indexOf");
        if (iterable instanceof List) {
            return ((List) iterable).indexOf(t2);
        }
        int i2 = 0;
        for (Object next : iterable) {
            if (i2 < 0) {
                h.b();
            }
            if (h.a((Object) t2, (Object) next)) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static final <T> List<T> b(Iterable<? extends T> iterable) {
        h.d(iterable, "$this$toList");
        if (!(iterable instanceof Collection)) {
            return h.b(h.c(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return h.a();
        }
        if (size != 1) {
            return h.a(collection);
        }
        return h.a(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
    }

    public static final <T> List<T> c(Iterable<? extends T> iterable) {
        h.d(iterable, "$this$toMutableList");
        return iterable instanceof Collection ? h.a((Collection) iterable) : (List) h.a(iterable, new ArrayList());
    }

    public static final <T> T d(List<? extends T> list) {
        h.d(list, "$this$firstOrNull");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static final <T> Set<T> d(Iterable<? extends T> iterable) {
        h.d(iterable, "$this$toSet");
        if (!(iterable instanceof Collection)) {
            return z.a((Set) h.a(iterable, new LinkedHashSet()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return z.a();
        }
        if (size != 1) {
            return (Set) h.a(iterable, new LinkedHashSet(u.a(collection.size())));
        }
        return z.a(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
    }

    public static final <T> T e(List<? extends T> list) {
        h.d(list, "$this$last");
        if (!list.isEmpty()) {
            return list.get(h.a(list));
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static final <T> T f(List<? extends T> list) {
        h.d(list, "$this$single");
        int size = list.size();
        if (size == 0) {
            throw new NoSuchElementException("List is empty.");
        } else if (size == 1) {
            return list.get(0);
        } else {
            throw new IllegalArgumentException("List has more than one element.");
        }
    }
}
