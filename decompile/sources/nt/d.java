package nt;

import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import org.greenrobot.eventbus.c;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public static b<?> f31624a;

    public static class a extends Fragment {

        /* renamed from: a  reason: collision with root package name */
        protected boolean f31625a;

        /* renamed from: b  reason: collision with root package name */
        protected Bundle f31626b;

        /* renamed from: c  reason: collision with root package name */
        private c f31627c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f31628d;

        /* renamed from: e  reason: collision with root package name */
        private Object f31629e;

        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            c a2 = d.f31624a.f31621a.a();
            this.f31627c = a2;
            a2.a((Object) this);
            this.f31628d = true;
        }

        public void onEventMainThread(f fVar) {
            if (d.b(this.f31629e, fVar)) {
                d.a(fVar);
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.b();
                androidx.fragment.app.c cVar = (androidx.fragment.app.c) fragmentManager.b("de.greenrobot.eventbus.error_dialog");
                if (cVar != null) {
                    cVar.dismiss();
                }
                androidx.fragment.app.c cVar2 = (androidx.fragment.app.c) d.f31624a.a(fVar, this.f31625a, this.f31626b);
                if (cVar2 != null) {
                    cVar2.show(fragmentManager, "de.greenrobot.eventbus.error_dialog");
                }
            }
        }

        public void onPause() {
            this.f31627c.c(this);
            super.onPause();
        }

        public void onResume() {
            super.onResume();
            if (this.f31628d) {
                this.f31628d = false;
                return;
            }
            c a2 = d.f31624a.f31621a.a();
            this.f31627c = a2;
            a2.a((Object) this);
        }
    }

    protected static void a(f fVar) {
        if (f31624a.f31621a.f31617f) {
            String str = f31624a.f31621a.f31618g;
            if (str == null) {
                str = c.f13998a;
            }
            Log.i(str, "Error dialog manager received exception", fVar.f31631a);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r1 = r1.b();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean b(java.lang.Object r0, nt.f r1) {
        /*
            if (r1 == 0) goto L_0x0010
            java.lang.Object r1 = r1.b()
            if (r1 == 0) goto L_0x0010
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0010
            r0 = 0
            return r0
        L_0x0010:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: nt.d.b(java.lang.Object, nt.f):boolean");
    }
}
