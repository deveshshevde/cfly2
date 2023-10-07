package q;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Handler;
import java.util.concurrent.Executor;

public class f {

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final int f34143a;

        /* renamed from: b  reason: collision with root package name */
        private final b[] f34144b;

        @Deprecated
        public a(int i2, b[] bVarArr) {
            this.f34143a = i2;
            this.f34144b = bVarArr;
        }

        static a a(int i2, b[] bVarArr) {
            return new a(i2, bVarArr);
        }

        public int a() {
            return this.f34143a;
        }

        public b[] b() {
            return this.f34144b;
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private final Uri f34145a;

        /* renamed from: b  reason: collision with root package name */
        private final int f34146b;

        /* renamed from: c  reason: collision with root package name */
        private final int f34147c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f34148d;

        /* renamed from: e  reason: collision with root package name */
        private final int f34149e;

        @Deprecated
        public b(Uri uri, int i2, int i3, boolean z2, int i4) {
            this.f34145a = (Uri) s.f.a(uri);
            this.f34146b = i2;
            this.f34147c = i3;
            this.f34148d = z2;
            this.f34149e = i4;
        }

        static b a(Uri uri, int i2, int i3, boolean z2, int i4) {
            return new b(uri, i2, i3, z2, i4);
        }

        public Uri a() {
            return this.f34145a;
        }

        public int b() {
            return this.f34146b;
        }

        public int c() {
            return this.f34147c;
        }

        public boolean d() {
            return this.f34148d;
        }

        public int e() {
            return this.f34149e;
        }
    }

    public static class c {
        public void a(int i2) {
        }

        public void a(Typeface typeface) {
        }
    }

    public static Typeface a(Context context, d dVar, int i2, boolean z2, int i3, Handler handler, c cVar) {
        a aVar = new a(cVar, handler);
        return z2 ? e.a(context, dVar, aVar, i2, i3) : e.a(context, dVar, i2, (Executor) null, aVar);
    }
}
