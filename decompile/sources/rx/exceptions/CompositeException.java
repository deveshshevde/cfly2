package rx.exceptions;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public final class CompositeException extends RuntimeException {
    private static final long serialVersionUID = 3026362227162912146L;

    /* renamed from: a  reason: collision with root package name */
    private final List<Throwable> f34215a;

    /* renamed from: b  reason: collision with root package name */
    private final String f34216b;

    /* renamed from: c  reason: collision with root package name */
    private Throwable f34217c;

    static final class CompositeExceptionCausalChain extends RuntimeException {

        /* renamed from: a  reason: collision with root package name */
        static String f34218a = "Chain of Causes for CompositeException In Order Received =>";
        private static final long serialVersionUID = 3875212506787802066L;

        CompositeExceptionCausalChain() {
        }

        public String getMessage() {
            return f34218a;
        }
    }

    private static abstract class a {
        private a() {
        }

        /* access modifiers changed from: package-private */
        public abstract Object a();

        /* access modifiers changed from: package-private */
        public abstract void a(Object obj);
    }

    private static class b extends a {

        /* renamed from: a  reason: collision with root package name */
        private final PrintStream f34219a;

        b(PrintStream printStream) {
            super();
            this.f34219a = printStream;
        }

        /* access modifiers changed from: package-private */
        public Object a() {
            return this.f34219a;
        }

        /* access modifiers changed from: package-private */
        public void a(Object obj) {
            this.f34219a.println(obj);
        }
    }

    private static class c extends a {

        /* renamed from: a  reason: collision with root package name */
        private final PrintWriter f34220a;

        c(PrintWriter printWriter) {
            super();
            this.f34220a = printWriter;
        }

        /* access modifiers changed from: package-private */
        public Object a() {
            return this.f34220a;
        }

        /* access modifiers changed from: package-private */
        public void a(Object obj) {
            this.f34220a.println(obj);
        }
    }

    @Deprecated
    public CompositeException(String str, Collection<? extends Throwable> collection) {
        this.f34217c = null;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            for (Object obj : collection) {
                if (obj instanceof CompositeException) {
                    linkedHashSet.addAll(((CompositeException) obj).a());
                } else {
                    linkedHashSet.add(obj == null ? new NullPointerException() : obj);
                }
            }
        } else {
            linkedHashSet.add(new NullPointerException());
        }
        arrayList.addAll(linkedHashSet);
        List<Throwable> unmodifiableList = Collections.unmodifiableList(arrayList);
        this.f34215a = unmodifiableList;
        this.f34216b = unmodifiableList.size() + " exceptions occurred. ";
    }

    public CompositeException(Collection<? extends Throwable> collection) {
        this((String) null, collection);
    }

    private List<Throwable> a(Throwable th) {
        ArrayList arrayList = new ArrayList();
        Throwable cause = th.getCause();
        if (cause == null) {
            return arrayList;
        }
        while (true) {
            arrayList.add(cause);
            if (cause.getCause() == null) {
                return arrayList;
            }
            cause = cause.getCause();
        }
    }

    private void a(StringBuilder sb, Throwable th, String str) {
        sb.append(str);
        sb.append(th);
        sb.append("\n");
        for (StackTraceElement append : th.getStackTrace()) {
            sb.append("\t\tat ");
            sb.append(append);
            sb.append("\n");
        }
        if (th.getCause() != null) {
            sb.append("\tCaused by: ");
            a(sb, th.getCause(), "");
        }
    }

    private void a(a aVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(this);
        sb.append("\n");
        for (StackTraceElement append : getStackTrace()) {
            sb.append("\tat ");
            sb.append(append);
            sb.append("\n");
        }
        int i2 = 1;
        for (Throwable a2 : this.f34215a) {
            sb.append("  ComposedException ");
            sb.append(i2);
            sb.append(" :");
            sb.append("\n");
            a(sb, a2, "\t");
            i2++;
        }
        synchronized (aVar.a()) {
            aVar.a(sb.toString());
        }
    }

    public List<Throwable> a() {
        return this.f34215a;
    }

    public synchronized Throwable getCause() {
        if (this.f34217c == null) {
            Throwable compositeExceptionCausalChain = new CompositeExceptionCausalChain();
            HashSet hashSet = new HashSet();
            Iterator<Throwable> it2 = this.f34215a.iterator();
            Throwable th = compositeExceptionCausalChain;
            while (it2.hasNext()) {
                Throwable next = it2.next();
                if (!hashSet.contains(next)) {
                    hashSet.add(next);
                    for (Throwable next2 : a(next)) {
                        if (hashSet.contains(next2)) {
                            next = new RuntimeException("Duplicate found in causal chain so cropping to prevent loop ...");
                        } else {
                            hashSet.add(next2);
                        }
                    }
                    try {
                        th.initCause(next);
                        th = th.getCause();
                    } catch (Throwable unused) {
                        th = next;
                    }
                }
            }
            this.f34217c = compositeExceptionCausalChain;
        }
        return this.f34217c;
    }

    public String getMessage() {
        return this.f34216b;
    }

    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public void printStackTrace(PrintStream printStream) {
        a((a) new b(printStream));
    }

    public void printStackTrace(PrintWriter printWriter) {
        a((a) new c(printWriter));
    }
}
