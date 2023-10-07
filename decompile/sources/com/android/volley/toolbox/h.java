package com.android.volley.toolbox;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.i;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class h {

    /* renamed from: a  reason: collision with root package name */
    private final com.android.volley.h f9977a;

    /* renamed from: b  reason: collision with root package name */
    private int f9978b = 100;

    /* renamed from: c  reason: collision with root package name */
    private final b f9979c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final HashMap<String, a> f9980d = new HashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final HashMap<String, a> f9981e = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    private final Handler f9982f = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public Runnable f9983g;

    private class a {

        /* renamed from: b  reason: collision with root package name */
        private final Request<?> f9994b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public Bitmap f9995c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public final LinkedList<c> f9996d;

        public a(Request<?> request, c cVar) {
            LinkedList<c> linkedList = new LinkedList<>();
            this.f9996d = linkedList;
            this.f9994b = request;
            linkedList.add(cVar);
        }

        public void a(c cVar) {
            this.f9996d.add(cVar);
        }

        public boolean b(c cVar) {
            this.f9996d.remove(cVar);
            if (this.f9996d.size() != 0) {
                return false;
            }
            this.f9994b.f();
            return true;
        }
    }

    public interface b {
        Bitmap a(String str);

        void a(String str, Bitmap bitmap);
    }

    public class c {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public Bitmap f9998b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final d f9999c;

        /* renamed from: d  reason: collision with root package name */
        private final String f10000d;

        /* renamed from: e  reason: collision with root package name */
        private final String f10001e;

        public c(Bitmap bitmap, String str, String str2, d dVar) {
            this.f9998b = bitmap;
            this.f10001e = str;
            this.f10000d = str2;
            this.f9999c = dVar;
        }

        public void a() {
            HashMap b2;
            if (this.f9999c != null) {
                a aVar = (a) h.this.f9980d.get(this.f10000d);
                if (aVar == null) {
                    a aVar2 = (a) h.this.f9981e.get(this.f10000d);
                    if (aVar2 != null) {
                        aVar2.b(this);
                        if (aVar2.f9996d.size() == 0) {
                            b2 = h.this.f9981e;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                } else if (aVar.b(this)) {
                    b2 = h.this.f9980d;
                } else {
                    return;
                }
                b2.remove(this.f10000d);
            }
        }

        public Bitmap b() {
            return this.f9998b;
        }

        public String c() {
            return this.f10001e;
        }
    }

    public interface d extends i.a {
        void a(c cVar, boolean z2);
    }

    public h(com.android.volley.h hVar, b bVar) {
        this.f9977a = hVar;
        this.f9979c = bVar;
    }

    public static d a(final ImageView imageView, final int i2, final int i3) {
        return new d() {
            public void a(VolleyError volleyError) {
                int i2 = i3;
                if (i2 != 0) {
                    imageView.setImageResource(i2);
                }
            }

            public void a(c cVar, boolean z2) {
                if (cVar.b() != null) {
                    imageView.setImageBitmap(cVar.b());
                    return;
                }
                int i2 = i2;
                if (i2 != 0) {
                    imageView.setImageResource(i2);
                }
            }
        };
    }

    private static String a(String str, int i2, int i3) {
        StringBuilder sb = new StringBuilder(str.length() + 12);
        sb.append("#W");
        sb.append(i2);
        sb.append("#H");
        sb.append(i3);
        sb.append(str);
        return sb.toString();
    }

    private void a() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("ImageLoader must be invoked from the main thread.");
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, Bitmap bitmap) {
        this.f9979c.a(str, bitmap);
        a remove = this.f9980d.remove(str);
        if (remove != null) {
            remove.f9995c = bitmap;
            a(str, remove, (VolleyError) null);
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, VolleyError volleyError) {
        a remove = this.f9980d.remove(str);
        if (remove != null) {
            a(str, remove, volleyError);
        }
    }

    private void a(String str, a aVar, final VolleyError volleyError) {
        this.f9981e.put(str, aVar);
        if (this.f9983g == null) {
            AnonymousClass4 r3 = new Runnable() {
                public void run() {
                    for (a aVar : h.this.f9981e.values()) {
                        Iterator it2 = aVar.f9996d.iterator();
                        while (it2.hasNext()) {
                            c cVar = (c) it2.next();
                            if (cVar.f9999c != null) {
                                if (volleyError == null) {
                                    cVar.f9998b = aVar.f9995c;
                                    cVar.f9999c.a(cVar, false);
                                } else {
                                    cVar.f9999c.a(volleyError);
                                }
                            }
                        }
                    }
                    h.this.f9981e.clear();
                    h.this.f9983g = null;
                }
            };
            this.f9983g = r3;
            this.f9982f.postDelayed(r3, (long) this.f9978b);
        }
    }

    public c a(String str, d dVar) {
        return a(str, dVar, 0, 0);
    }

    public c a(String str, d dVar, int i2, int i3) {
        d dVar2 = dVar;
        a();
        final String a2 = a(str, i2, i3);
        Bitmap a3 = this.f9979c.a(a2);
        if (a3 != null) {
            c cVar = new c(a3, str, (String) null, (d) null);
            dVar2.a(cVar, true);
            return cVar;
        }
        c cVar2 = new c((Bitmap) null, str, a2, dVar);
        dVar2.a(cVar2, true);
        a aVar = this.f9980d.get(a2);
        if (aVar != null) {
            aVar.a(cVar2);
            return cVar2;
        }
        i iVar = new i(str, new i.b<Bitmap>() {
            public void a(Bitmap bitmap) {
                h.this.a(a2, bitmap);
            }
        }, i2, i3, Bitmap.Config.RGB_565, new i.a() {
            public void a(VolleyError volleyError) {
                h.this.a(a2, volleyError);
            }
        });
        this.f9977a.a(iVar);
        this.f9980d.put(a2, new a(iVar, cVar2));
        return cVar2;
    }
}
