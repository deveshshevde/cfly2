package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.util.HashMap;
import java.util.HashSet;

public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    public static int f1802a = -1;

    /* renamed from: b  reason: collision with root package name */
    int f1803b;

    /* renamed from: c  reason: collision with root package name */
    int f1804c;

    /* renamed from: d  reason: collision with root package name */
    String f1805d = null;

    /* renamed from: e  reason: collision with root package name */
    protected int f1806e;

    /* renamed from: f  reason: collision with root package name */
    HashMap<String, ConstraintAttribute> f1807f;

    public c() {
        int i2 = f1802a;
        this.f1803b = i2;
        this.f1804c = i2;
    }

    /* access modifiers changed from: package-private */
    public abstract void a(Context context, AttributeSet attributeSet);

    public abstract void a(HashMap<String, r> hashMap);

    /* access modifiers changed from: package-private */
    public abstract void a(HashSet<String> hashSet);

    /* access modifiers changed from: package-private */
    public boolean a(String str) {
        String str2 = this.f1805d;
        if (str2 == null || str == null) {
            return false;
        }
        return str.matches(str2);
    }

    public void b(HashMap<String, Integer> hashMap) {
    }
}
