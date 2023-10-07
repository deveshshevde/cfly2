package iv;

import java.util.ArrayList;
import java.util.List;

class g implements i {

    /* renamed from: a  reason: collision with root package name */
    private final ThreadLocal<String> f29392a = new ThreadLocal<>();

    /* renamed from: b  reason: collision with root package name */
    private final List<c> f29393b = new ArrayList();

    g() {
    }

    private String a() {
        String str = this.f29392a.get();
        if (str == null) {
            return null;
        }
        this.f29392a.remove();
        return str;
    }

    private synchronized void a(int i2, Throwable th, String str, Object... objArr) {
        j.a(str);
        a(i2, a(), b(str, objArr), th);
    }

    private String b(String str, Object... objArr) {
        return (objArr == null || objArr.length == 0) ? str : String.format(str, objArr);
    }

    public i a(String str) {
        if (str != null) {
            this.f29392a.set(str);
        }
        return this;
    }

    public synchronized void a(int i2, String str, String str2, Throwable th) {
        if (!(th == null || str2 == null)) {
            str2 = str2 + " : " + j.a(th);
        }
        if (th != null && str2 == null) {
            str2 = j.a(th);
        }
        if (j.a((CharSequence) str2)) {
            str2 = "Empty/NULL log message";
        }
        for (c next : this.f29393b) {
            if (next.a(i2, str)) {
                next.a(i2, str, str2);
            }
        }
    }

    public void a(c cVar) {
        this.f29393b.add(j.a(cVar));
    }

    public void a(String str, Object... objArr) {
        a(4, (Throwable) null, str, objArr);
    }

    public void a(Throwable th, String str, Object... objArr) {
        a(6, th, str, objArr);
    }
}
