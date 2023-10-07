package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import gt.d;
import gt.f;
import java.lang.ref.WeakReference;

public class i {

    /* renamed from: a  reason: collision with root package name */
    private final TextPaint f19312a = new TextPaint(1);

    /* renamed from: b  reason: collision with root package name */
    private final f f19313b = new f() {
        public void a(int i2) {
            boolean unused = i.this.f19315d = true;
            a aVar = (a) i.this.f19316e.get();
            if (aVar != null) {
                aVar.f();
            }
        }

        public void a(Typeface typeface, boolean z2) {
            if (!z2) {
                boolean unused = i.this.f19315d = true;
                a aVar = (a) i.this.f19316e.get();
                if (aVar != null) {
                    aVar.f();
                }
            }
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private float f19314c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f19315d = true;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public WeakReference<a> f19316e = new WeakReference<>((Object) null);

    /* renamed from: f  reason: collision with root package name */
    private d f19317f;

    public interface a {
        void f();

        int[] getState();

        boolean onStateChange(int[] iArr);
    }

    public i(a aVar) {
        a(aVar);
    }

    private float a(CharSequence charSequence) {
        if (charSequence == null) {
            return 0.0f;
        }
        return this.f19312a.measureText(charSequence, 0, charSequence.length());
    }

    public float a(String str) {
        if (!this.f19315d) {
            return this.f19314c;
        }
        float a2 = a((CharSequence) str);
        this.f19314c = a2;
        this.f19315d = false;
        return a2;
    }

    public TextPaint a() {
        return this.f19312a;
    }

    public void a(Context context) {
        this.f19317f.b(context, this.f19312a, this.f19313b);
    }

    public void a(a aVar) {
        this.f19316e = new WeakReference<>(aVar);
    }

    public void a(d dVar, Context context) {
        if (this.f19317f != dVar) {
            this.f19317f = dVar;
            if (dVar != null) {
                dVar.c(context, this.f19312a, this.f19313b);
                a aVar = (a) this.f19316e.get();
                if (aVar != null) {
                    this.f19312a.drawableState = aVar.getState();
                }
                dVar.b(context, this.f19312a, this.f19313b);
                this.f19315d = true;
            }
            a aVar2 = (a) this.f19316e.get();
            if (aVar2 != null) {
                aVar2.f();
                aVar2.onStateChange(aVar2.getState());
            }
        }
    }

    public void a(boolean z2) {
        this.f19315d = z2;
    }

    public d b() {
        return this.f19317f;
    }
}
