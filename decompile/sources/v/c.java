package v;

import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.view.inputmethod.InputContentInfo;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final C0261c f34567a;

    private static final class a implements C0261c {

        /* renamed from: a  reason: collision with root package name */
        final InputContentInfo f34568a;

        a(Uri uri, ClipDescription clipDescription, Uri uri2) {
            this.f34568a = new InputContentInfo(uri, clipDescription, uri2);
        }

        a(Object obj) {
            this.f34568a = (InputContentInfo) obj;
        }

        public Uri a() {
            return this.f34568a.getContentUri();
        }

        public ClipDescription b() {
            return this.f34568a.getDescription();
        }

        public Uri c() {
            return this.f34568a.getLinkUri();
        }

        public Object d() {
            return this.f34568a;
        }

        public void e() {
            this.f34568a.requestPermission();
        }
    }

    private static final class b implements C0261c {

        /* renamed from: a  reason: collision with root package name */
        private final Uri f34569a;

        /* renamed from: b  reason: collision with root package name */
        private final ClipDescription f34570b;

        /* renamed from: c  reason: collision with root package name */
        private final Uri f34571c;

        b(Uri uri, ClipDescription clipDescription, Uri uri2) {
            this.f34569a = uri;
            this.f34570b = clipDescription;
            this.f34571c = uri2;
        }

        public Uri a() {
            return this.f34569a;
        }

        public ClipDescription b() {
            return this.f34570b;
        }

        public Uri c() {
            return this.f34571c;
        }

        public Object d() {
            return null;
        }

        public void e() {
        }
    }

    /* renamed from: v.c$c  reason: collision with other inner class name */
    private interface C0261c {
        Uri a();

        ClipDescription b();

        Uri c();

        Object d();

        void e();
    }

    public c(Uri uri, ClipDescription clipDescription, Uri uri2) {
        this.f34567a = Build.VERSION.SDK_INT >= 25 ? new a(uri, clipDescription, uri2) : new b(uri, clipDescription, uri2);
    }

    private c(C0261c cVar) {
        this.f34567a = cVar;
    }

    public static c a(Object obj) {
        if (obj != null && Build.VERSION.SDK_INT >= 25) {
            return new c(new a(obj));
        }
        return null;
    }

    public Uri a() {
        return this.f34567a.a();
    }

    public ClipDescription b() {
        return this.f34567a.b();
    }

    public Uri c() {
        return this.f34567a.c();
    }

    public Object d() {
        return this.f34567a.d();
    }

    public void e() {
        this.f34567a.e();
    }
}
