package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.c;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class GlideException extends Exception {

    /* renamed from: a  reason: collision with root package name */
    private static final StackTraceElement[] f10242a = new StackTraceElement[0];
    private static final long serialVersionUID = 1;

    /* renamed from: b  reason: collision with root package name */
    private final List<Throwable> f10243b;

    /* renamed from: c  reason: collision with root package name */
    private c f10244c;

    /* renamed from: d  reason: collision with root package name */
    private DataSource f10245d;

    /* renamed from: e  reason: collision with root package name */
    private Class<?> f10246e;

    /* renamed from: f  reason: collision with root package name */
    private String f10247f;

    /* renamed from: g  reason: collision with root package name */
    private Exception f10248g;

    private static final class a implements Appendable {

        /* renamed from: a  reason: collision with root package name */
        private final Appendable f10249a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f10250b = true;

        a(Appendable appendable) {
            this.f10249a = appendable;
        }

        private CharSequence a(CharSequence charSequence) {
            return charSequence == null ? "" : charSequence;
        }

        public Appendable append(char c2) throws IOException {
            boolean z2 = false;
            if (this.f10250b) {
                this.f10250b = false;
                this.f10249a.append("  ");
            }
            if (c2 == 10) {
                z2 = true;
            }
            this.f10250b = z2;
            this.f10249a.append(c2);
            return this;
        }

        public Appendable append(CharSequence charSequence) throws IOException {
            CharSequence a2 = a(charSequence);
            return append(a2, 0, a2.length());
        }

        public Appendable append(CharSequence charSequence, int i2, int i3) throws IOException {
            CharSequence a2 = a(charSequence);
            boolean z2 = false;
            if (this.f10250b) {
                this.f10250b = false;
                this.f10249a.append("  ");
            }
            if (a2.length() > 0 && a2.charAt(i3 - 1) == 10) {
                z2 = true;
            }
            this.f10250b = z2;
            this.f10249a.append(a2, i2, i3);
            return this;
        }
    }

    public GlideException(String str) {
        this(str, (List<Throwable>) Collections.emptyList());
    }

    public GlideException(String str, Throwable th) {
        this(str, (List<Throwable>) Collections.singletonList(th));
    }

    public GlideException(String str, List<Throwable> list) {
        this.f10247f = str;
        setStackTrace(f10242a);
        this.f10243b = list;
    }

    private void a(Appendable appendable) {
        a((Throwable) this, appendable);
        a(a(), (Appendable) new a(appendable));
    }

    private static void a(Throwable th, Appendable appendable) {
        try {
            appendable.append(th.getClass().toString()).append(": ").append(th.getMessage()).append(10);
        } catch (IOException unused) {
            throw new RuntimeException(th);
        }
    }

    private void a(Throwable th, List<Throwable> list) {
        if (th instanceof GlideException) {
            for (Throwable a2 : ((GlideException) th).a()) {
                a(a2, list);
            }
            return;
        }
        list.add(th);
    }

    private static void a(List<Throwable> list, Appendable appendable) {
        try {
            b(list, appendable);
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static void b(List<Throwable> list, Appendable appendable) throws IOException {
        int size = list.size();
        int i2 = 0;
        while (i2 < size) {
            int i3 = i2 + 1;
            appendable.append("Cause (").append(String.valueOf(i3)).append(" of ").append(String.valueOf(size)).append("): ");
            Throwable th = list.get(i2);
            if (th instanceof GlideException) {
                ((GlideException) th).a(appendable);
            } else {
                a(th, appendable);
            }
            i2 = i3;
        }
    }

    public List<Throwable> a() {
        return this.f10243b;
    }

    /* access modifiers changed from: package-private */
    public void a(c cVar, DataSource dataSource) {
        a(cVar, dataSource, (Class<?>) null);
    }

    /* access modifiers changed from: package-private */
    public void a(c cVar, DataSource dataSource, Class<?> cls) {
        this.f10244c = cVar;
        this.f10245d = dataSource;
        this.f10246e = cls;
    }

    public void a(Exception exc) {
        this.f10248g = exc;
    }

    public void a(String str) {
        List<Throwable> b2 = b();
        int size = b2.size();
        int i2 = 0;
        while (i2 < size) {
            StringBuilder sb = new StringBuilder();
            sb.append("Root cause (");
            int i3 = i2 + 1;
            sb.append(i3);
            sb.append(" of ");
            sb.append(size);
            sb.append(")");
            Log.i(str, sb.toString(), b2.get(i2));
            i2 = i3;
        }
    }

    public List<Throwable> b() {
        ArrayList arrayList = new ArrayList();
        a((Throwable) this, (List<Throwable>) arrayList);
        return arrayList;
    }

    public Throwable fillInStackTrace() {
        return this;
    }

    public String getMessage() {
        String str;
        String str2;
        String str3;
        StringBuilder sb = new StringBuilder(71);
        sb.append(this.f10247f);
        String str4 = "";
        if (this.f10246e != null) {
            str = ", " + this.f10246e;
        } else {
            str = str4;
        }
        sb.append(str);
        if (this.f10245d != null) {
            str2 = ", " + this.f10245d;
        } else {
            str2 = str4;
        }
        sb.append(str2);
        if (this.f10244c != null) {
            str4 = ", " + this.f10244c;
        }
        sb.append(str4);
        List<Throwable> b2 = b();
        if (b2.isEmpty()) {
            return sb.toString();
        }
        if (b2.size() == 1) {
            str3 = "\nThere was 1 root cause:";
        } else {
            sb.append("\nThere were ");
            sb.append(b2.size());
            str3 = " root causes:";
        }
        sb.append(str3);
        for (Throwable next : b2) {
            sb.append(10);
            sb.append(next.getClass().getName());
            sb.append('(');
            sb.append(next.getMessage());
            sb.append(')');
        }
        sb.append("\n call GlideException#logRootCauses(String) for more detail");
        return sb.toString();
    }

    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public void printStackTrace(PrintStream printStream) {
        a((Appendable) printStream);
    }

    public void printStackTrace(PrintWriter printWriter) {
        a((Appendable) printWriter);
    }
}
