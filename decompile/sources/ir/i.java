package ir;

import android.view.View;
import is.c;
import iu.a;
import java.util.HashMap;
import java.util.Map;

public final class i extends m {

    /* renamed from: h  reason: collision with root package name */
    private static final Map<String, c> f29119h;

    /* renamed from: i  reason: collision with root package name */
    private Object f29120i;

    /* renamed from: j  reason: collision with root package name */
    private String f29121j;

    /* renamed from: k  reason: collision with root package name */
    private c f29122k;

    static {
        HashMap hashMap = new HashMap();
        f29119h = hashMap;
        hashMap.put("alpha", j.f29123a);
        hashMap.put("pivotX", j.f29124b);
        hashMap.put("pivotY", j.f29125c);
        hashMap.put("translationX", j.f29126d);
        hashMap.put("translationY", j.f29127e);
        hashMap.put("rotation", j.f29128f);
        hashMap.put("rotationX", j.f29129g);
        hashMap.put("rotationY", j.f29130h);
        hashMap.put("scaleX", j.f29131i);
        hashMap.put("scaleY", j.f29132j);
        hashMap.put("scrollX", j.f29133k);
        hashMap.put("scrollY", j.f29134l);
        hashMap.put("x", j.f29135m);
        hashMap.put("y", j.f29136n);
    }

    public i() {
    }

    private i(Object obj, String str) {
        this.f29120i = obj;
        a(str);
    }

    public static i a(Object obj, String str, float... fArr) {
        i iVar = new i(obj, str);
        iVar.a(fArr);
        return iVar;
    }

    public void a() {
        super.a();
    }

    /* access modifiers changed from: package-private */
    public void a(float f2) {
        super.a(f2);
        for (k b2 : this.f29171f) {
            b2.b(this.f29120i);
        }
    }

    public void a(c cVar) {
        if (this.f29171f != null) {
            k kVar = this.f29171f[0];
            String c2 = kVar.c();
            kVar.a(cVar);
            this.f29172g.remove(c2);
            this.f29172g.put(this.f29121j, kVar);
        }
        if (this.f29122k != null) {
            this.f29121j = cVar.a();
        }
        this.f29122k = cVar;
        this.f29170e = false;
    }

    public void a(String str) {
        if (this.f29171f != null) {
            k kVar = this.f29171f[0];
            String c2 = kVar.c();
            kVar.a(str);
            this.f29172g.remove(c2);
            this.f29172g.put(str, kVar);
        }
        this.f29121j = str;
        this.f29170e = false;
    }

    public void a(float... fArr) {
        if (this.f29171f == null || this.f29171f.length == 0) {
            c cVar = this.f29122k;
            if (cVar != null) {
                a(k.a((c<?, Float>) cVar, fArr));
                return;
            }
            a(k.a(this.f29121j, fArr));
            return;
        }
        super.a(fArr);
    }

    /* renamed from: b */
    public i c(long j2) {
        super.a(j2);
        return this;
    }

    /* access modifiers changed from: package-private */
    public void d() {
        if (!this.f29170e) {
            if (this.f29122k == null && a.f29374a && (this.f29120i instanceof View)) {
                Map<String, c> map = f29119h;
                if (map.containsKey(this.f29121j)) {
                    a(map.get(this.f29121j));
                }
            }
            for (k a2 : this.f29171f) {
                a2.a(this.f29120i);
            }
            super.d();
        }
    }

    /* renamed from: e */
    public i f() {
        return (i) super.clone();
    }

    public String toString() {
        String str = "ObjectAnimator@" + Integer.toHexString(hashCode()) + ", target " + this.f29120i;
        if (this.f29171f != null) {
            for (int i2 = 0; i2 < this.f29171f.length; i2++) {
                str = str + "\n    " + this.f29171f[i2].toString();
            }
        }
        return str;
    }
}
