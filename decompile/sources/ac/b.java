package ac;

import ac.a;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.lifecycle.aa;
import androidx.lifecycle.ab;
import androidx.lifecycle.ac;
import androidx.lifecycle.n;
import androidx.lifecycle.s;
import androidx.lifecycle.t;
import androidx.loader.content.c;
import j.h;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

class b extends a {

    /* renamed from: a  reason: collision with root package name */
    static boolean f30a = false;

    /* renamed from: b  reason: collision with root package name */
    private final n f31b;

    /* renamed from: c  reason: collision with root package name */
    private final c f32c;

    public static class a<D> extends s<D> implements c.C0031c<D> {

        /* renamed from: e  reason: collision with root package name */
        private final int f33e;

        /* renamed from: f  reason: collision with root package name */
        private final Bundle f34f;

        /* renamed from: g  reason: collision with root package name */
        private final androidx.loader.content.c<D> f35g;

        /* renamed from: h  reason: collision with root package name */
        private n f36h;

        /* renamed from: i  reason: collision with root package name */
        private C0002b<D> f37i;

        /* renamed from: j  reason: collision with root package name */
        private androidx.loader.content.c<D> f38j;

        a(int i2, Bundle bundle, androidx.loader.content.c<D> cVar, androidx.loader.content.c<D> cVar2) {
            this.f33e = i2;
            this.f34f = bundle;
            this.f35g = cVar;
            this.f38j = cVar2;
            cVar.a(i2, this);
        }

        /* access modifiers changed from: package-private */
        public androidx.loader.content.c<D> a(n nVar, a.C0001a<D> aVar) {
            C0002b<D> bVar = new C0002b<>(this.f35g, aVar);
            a(nVar, bVar);
            C0002b<D> bVar2 = this.f37i;
            if (bVar2 != null) {
                b(bVar2);
            }
            this.f36h = nVar;
            this.f37i = bVar;
            return this.f35g;
        }

        /* access modifiers changed from: package-private */
        public androidx.loader.content.c<D> a(boolean z2) {
            if (b.f30a) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.f35g.r();
            this.f35g.u();
            C0002b<D> bVar = this.f37i;
            if (bVar != null) {
                b(bVar);
                if (z2) {
                    bVar.b();
                }
            }
            this.f35g.a(this);
            if ((bVar == null || bVar.a()) && !z2) {
                return this.f35g;
            }
            this.f35g.w();
            return this.f38j;
        }

        public void a(androidx.loader.content.c<D> cVar, D d2) {
            if (b.f30a) {
                Log.v("LoaderManager", "onLoadComplete: " + this);
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                b(d2);
                return;
            }
            if (b.f30a) {
                Log.w("LoaderManager", "onLoadComplete was incorrectly called on a background thread");
            }
            a(d2);
        }

        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f33e);
            printWriter.print(" mArgs=");
            printWriter.println(this.f34f);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.f35g);
            androidx.loader.content.c<D> cVar = this.f35g;
            cVar.a(str + "  ", fileDescriptor, printWriter, strArr);
            if (this.f37i != null) {
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.f37i);
                C0002b<D> bVar = this.f37i;
                bVar.a(str + "  ", printWriter);
            }
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(e().c(a()));
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.println(d());
        }

        /* access modifiers changed from: protected */
        public void b() {
            if (b.f30a) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            this.f35g.q();
        }

        public void b(t<? super D> tVar) {
            super.b(tVar);
            this.f36h = null;
            this.f37i = null;
        }

        public void b(D d2) {
            super.b(d2);
            androidx.loader.content.c<D> cVar = this.f38j;
            if (cVar != null) {
                cVar.w();
                this.f38j = null;
            }
        }

        /* access modifiers changed from: protected */
        public void c() {
            if (b.f30a) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.f35g.t();
        }

        /* access modifiers changed from: package-private */
        public androidx.loader.content.c<D> e() {
            return this.f35g;
        }

        /* access modifiers changed from: package-private */
        public void f() {
            n nVar = this.f36h;
            C0002b<D> bVar = this.f37i;
            if (nVar != null && bVar != null) {
                super.b(bVar);
                a(nVar, bVar);
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.f33e);
            sb.append(" : ");
            s.b.a(this.f35g, sb);
            sb.append("}}");
            return sb.toString();
        }
    }

    /* renamed from: ac.b$b  reason: collision with other inner class name */
    static class C0002b<D> implements t<D> {

        /* renamed from: a  reason: collision with root package name */
        private final androidx.loader.content.c<D> f39a;

        /* renamed from: b  reason: collision with root package name */
        private final a.C0001a<D> f40b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f41c = false;

        C0002b(androidx.loader.content.c<D> cVar, a.C0001a<D> aVar) {
            this.f39a = cVar;
            this.f40b = aVar;
        }

        public void a(String str, PrintWriter printWriter) {
            printWriter.print(str);
            printWriter.print("mDeliveredData=");
            printWriter.println(this.f41c);
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            return this.f41c;
        }

        /* access modifiers changed from: package-private */
        public void b() {
            if (this.f41c) {
                if (b.f30a) {
                    Log.v("LoaderManager", "  Resetting: " + this.f39a);
                }
                this.f40b.onLoaderReset(this.f39a);
            }
        }

        public void onChanged(D d2) {
            if (b.f30a) {
                Log.v("LoaderManager", "  onLoadFinished in " + this.f39a + ": " + this.f39a.c(d2));
            }
            this.f40b.onLoadFinished(this.f39a, d2);
            this.f41c = true;
        }

        public String toString() {
            return this.f40b.toString();
        }
    }

    static class c extends aa {

        /* renamed from: a  reason: collision with root package name */
        private static final ab.b f42a = new ab.b() {
            public <T extends aa> T a(Class<T> cls) {
                return new c();
            }
        };

        /* renamed from: b  reason: collision with root package name */
        private h<a> f43b = new h<>();

        /* renamed from: c  reason: collision with root package name */
        private boolean f44c = false;

        c() {
        }

        static c a(ac acVar) {
            return (c) new ab(acVar, f42a).a(c.class);
        }

        /* access modifiers changed from: package-private */
        public <D> a<D> a(int i2) {
            return this.f43b.a(i2);
        }

        /* access modifiers changed from: protected */
        public void a() {
            super.a();
            int b2 = this.f43b.b();
            for (int i2 = 0; i2 < b2; i2++) {
                this.f43b.d(i2).a(true);
            }
            this.f43b.c();
        }

        /* access modifiers changed from: package-private */
        public void a(int i2, a aVar) {
            this.f43b.b(i2, aVar);
        }

        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f43b.b() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                for (int i2 = 0; i2 < this.f43b.b(); i2++) {
                    a d2 = this.f43b.d(i2);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f43b.c(i2));
                    printWriter.print(": ");
                    printWriter.println(d2.toString());
                    d2.a(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.f44c = true;
        }

        /* access modifiers changed from: package-private */
        public boolean c() {
            return this.f44c;
        }

        /* access modifiers changed from: package-private */
        public void e() {
            this.f44c = false;
        }

        /* access modifiers changed from: package-private */
        public void f() {
            int b2 = this.f43b.b();
            for (int i2 = 0; i2 < b2; i2++) {
                this.f43b.d(i2).f();
            }
        }
    }

    b(n nVar, ac acVar) {
        this.f31b = nVar;
        this.f32c = c.a(acVar);
    }

    /* JADX INFO: finally extract failed */
    private <D> androidx.loader.content.c<D> a(int i2, Bundle bundle, a.C0001a<D> aVar, androidx.loader.content.c<D> cVar) {
        try {
            this.f32c.b();
            androidx.loader.content.c<D> onCreateLoader = aVar.onCreateLoader(i2, bundle);
            if (onCreateLoader != null) {
                if (onCreateLoader.getClass().isMemberClass()) {
                    if (!Modifier.isStatic(onCreateLoader.getClass().getModifiers())) {
                        throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + onCreateLoader);
                    }
                }
                a aVar2 = new a(i2, bundle, onCreateLoader, cVar);
                if (f30a) {
                    Log.v("LoaderManager", "  Created new loader " + aVar2);
                }
                this.f32c.a(i2, aVar2);
                this.f32c.e();
                return aVar2.a(this.f31b, aVar);
            }
            throw new IllegalArgumentException("Object returned from onCreateLoader must not be null");
        } catch (Throwable th) {
            this.f32c.e();
            throw th;
        }
    }

    public <D> androidx.loader.content.c<D> a(int i2, Bundle bundle, a.C0001a<D> aVar) {
        if (this.f32c.c()) {
            throw new IllegalStateException("Called while creating a loader");
        } else if (Looper.getMainLooper() == Looper.myLooper()) {
            a a2 = this.f32c.a(i2);
            if (f30a) {
                Log.v("LoaderManager", "initLoader in " + this + ": args=" + bundle);
            }
            if (a2 == null) {
                return a(i2, bundle, aVar, (androidx.loader.content.c) null);
            }
            if (f30a) {
                Log.v("LoaderManager", "  Re-using existing loader " + a2);
            }
            return a2.a(this.f31b, aVar);
        } else {
            throw new IllegalStateException("initLoader must be called on the main thread");
        }
    }

    public void a() {
        this.f32c.f();
    }

    @Deprecated
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f32c.a(str, fileDescriptor, printWriter, strArr);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        s.b.a(this.f31b, sb);
        sb.append("}}");
        return sb.toString();
    }
}
