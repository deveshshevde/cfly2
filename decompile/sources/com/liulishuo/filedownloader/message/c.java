package com.liulishuo.filedownloader.message;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private volatile e f21395a;

    /* renamed from: b  reason: collision with root package name */
    private volatile b f21396b;

    public static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final c f21397a = new c();
    }

    public interface b {
        void a(MessageSnapshot messageSnapshot);
    }

    public static c a() {
        return a.f21397a;
    }

    public void a(MessageSnapshot messageSnapshot) {
        if (messageSnapshot instanceof a) {
            if (this.f21396b != null) {
                this.f21396b.a(messageSnapshot);
            }
        } else if (this.f21395a != null) {
            this.f21395a.a(messageSnapshot);
        }
    }

    public void a(b bVar) {
        this.f21396b = bVar;
        if (bVar == null) {
            this.f21395a = null;
        } else {
            this.f21395a = new e(5, bVar);
        }
    }
}
