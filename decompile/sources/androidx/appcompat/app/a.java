package androidx.appcompat.app;

import android.view.View;
import androidx.drawerlayout.widget.DrawerLayout;
import d.d;

public class a implements DrawerLayout.c {

    /* renamed from: a  reason: collision with root package name */
    boolean f648a;

    /* renamed from: b  reason: collision with root package name */
    private final C0017a f649b;

    /* renamed from: c  reason: collision with root package name */
    private d f650c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f651d;

    /* renamed from: e  reason: collision with root package name */
    private final int f652e;

    /* renamed from: f  reason: collision with root package name */
    private final int f653f;

    /* renamed from: androidx.appcompat.app.a$a  reason: collision with other inner class name */
    public interface C0017a {
        void a(int i2);
    }

    private void a(float f2) {
        d dVar;
        boolean z2;
        if (f2 == 1.0f) {
            dVar = this.f650c;
            z2 = true;
        } else {
            if (f2 == 0.0f) {
                dVar = this.f650c;
                z2 = false;
            }
            this.f650c.a(f2);
        }
        dVar.a(z2);
        this.f650c.a(f2);
    }

    public void a(int i2) {
    }

    public void a(View view) {
        a(1.0f);
        if (this.f648a) {
            b(this.f653f);
        }
    }

    public void a(View view, float f2) {
        if (this.f651d) {
            a(Math.min(1.0f, Math.max(0.0f, f2)));
        } else {
            a(0.0f);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(int i2) {
        this.f649b.a(i2);
    }

    public void b(View view) {
        a(0.0f);
        if (this.f648a) {
            b(this.f652e);
        }
    }
}
