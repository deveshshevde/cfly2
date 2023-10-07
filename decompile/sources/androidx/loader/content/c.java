package androidx.loader.content;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class c<D> {

    /* renamed from: n  reason: collision with root package name */
    int f3705n;

    /* renamed from: o  reason: collision with root package name */
    C0031c<D> f3706o;

    /* renamed from: p  reason: collision with root package name */
    b<D> f3707p;

    /* renamed from: q  reason: collision with root package name */
    Context f3708q;

    /* renamed from: r  reason: collision with root package name */
    boolean f3709r = false;

    /* renamed from: s  reason: collision with root package name */
    boolean f3710s = false;

    /* renamed from: t  reason: collision with root package name */
    boolean f3711t = true;

    /* renamed from: u  reason: collision with root package name */
    boolean f3712u = false;

    /* renamed from: v  reason: collision with root package name */
    boolean f3713v = false;

    public final class a extends ContentObserver {
        public a() {
            super(new Handler());
        }

        public boolean deliverSelfNotifications() {
            return true;
        }

        public void onChange(boolean z2) {
            c.this.A();
        }
    }

    public interface b<D> {
        void a(c<D> cVar);
    }

    /* renamed from: androidx.loader.content.c$c  reason: collision with other inner class name */
    public interface C0031c<D> {
        void a(c<D> cVar, D d2);
    }

    public c(Context context) {
        this.f3708q = context.getApplicationContext();
    }

    public void A() {
        if (this.f3709r) {
            s();
        } else {
            this.f3712u = true;
        }
    }

    /* access modifiers changed from: protected */
    public void a() {
    }

    public void a(int i2, C0031c<D> cVar) {
        if (this.f3706o == null) {
            this.f3706o = cVar;
            this.f3705n = i2;
            return;
        }
        throw new IllegalStateException("There is already a listener registered");
    }

    public void a(C0031c<D> cVar) {
        C0031c<D> cVar2 = this.f3706o;
        if (cVar2 == null) {
            throw new IllegalStateException("No listener register");
        } else if (cVar2 == cVar) {
            this.f3706o = null;
        } else {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
    }

    @Deprecated
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.f3705n);
        printWriter.print(" mListener=");
        printWriter.println(this.f3706o);
        if (this.f3709r || this.f3712u || this.f3713v) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.f3709r);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.f3712u);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.f3713v);
        }
        if (this.f3710s || this.f3711t) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.f3710s);
            printWriter.print(" mReset=");
            printWriter.println(this.f3711t);
        }
    }

    public void b(D d2) {
        C0031c<D> cVar = this.f3706o;
        if (cVar != null) {
            cVar.a(this, d2);
        }
    }

    /* access modifiers changed from: protected */
    public boolean b() {
        return false;
    }

    public String c(D d2) {
        StringBuilder sb = new StringBuilder(64);
        s.b.a(d2, sb);
        sb.append("}");
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public void i() {
    }

    /* access modifiers changed from: protected */
    public void j() {
    }

    /* access modifiers changed from: protected */
    public void k() {
    }

    public void l() {
        b<D> bVar = this.f3707p;
        if (bVar != null) {
            bVar.a(this);
        }
    }

    public Context m() {
        return this.f3708q;
    }

    public boolean n() {
        return this.f3709r;
    }

    public boolean o() {
        return this.f3710s;
    }

    public boolean p() {
        return this.f3711t;
    }

    public final void q() {
        this.f3709r = true;
        this.f3711t = false;
        this.f3710s = false;
        i();
    }

    public boolean r() {
        return b();
    }

    public void s() {
        a();
    }

    public void t() {
        this.f3709r = false;
        j();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        s.b.a(this, sb);
        sb.append(" id=");
        sb.append(this.f3705n);
        sb.append("}");
        return sb.toString();
    }

    public void u() {
        this.f3710s = true;
        v();
    }

    /* access modifiers changed from: protected */
    public void v() {
    }

    public void w() {
        k();
        this.f3711t = true;
        this.f3709r = false;
        this.f3710s = false;
        this.f3712u = false;
        this.f3713v = false;
    }

    public boolean x() {
        boolean z2 = this.f3712u;
        this.f3712u = false;
        this.f3713v |= z2;
        return z2;
    }

    public void y() {
        this.f3713v = false;
    }

    public void z() {
        if (this.f3713v) {
            A();
        }
    }
}
