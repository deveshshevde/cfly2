package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import java.util.Map;
import java.util.WeakHashMap;
import t.ac;
import u.c;
import u.d;

public class u extends t.a {

    /* renamed from: a  reason: collision with root package name */
    final RecyclerView f4319a;

    /* renamed from: b  reason: collision with root package name */
    private final a f4320b;

    public static class a extends t.a {

        /* renamed from: a  reason: collision with root package name */
        final u f4321a;

        /* renamed from: b  reason: collision with root package name */
        private Map<View, t.a> f4322b = new WeakHashMap();

        public a(u uVar) {
            this.f4321a = uVar;
        }

        public d a(View view) {
            t.a aVar = this.f4322b.get(view);
            return aVar != null ? aVar.a(view) : super.a(view);
        }

        public void a(View view, int i2) {
            t.a aVar = this.f4322b.get(view);
            if (aVar != null) {
                aVar.a(view, i2);
            } else {
                super.a(view, i2);
            }
        }

        public void a(View view, AccessibilityEvent accessibilityEvent) {
            t.a aVar = this.f4322b.get(view);
            if (aVar != null) {
                aVar.a(view, accessibilityEvent);
            } else {
                super.a(view, accessibilityEvent);
            }
        }

        public void a(View view, c cVar) {
            if (!this.f4321a.b() && this.f4321a.f4319a.getLayoutManager() != null) {
                this.f4321a.f4319a.getLayoutManager().a(view, cVar);
                t.a aVar = this.f4322b.get(view);
                if (aVar != null) {
                    aVar.a(view, cVar);
                    return;
                }
            }
            super.a(view, cVar);
        }

        public boolean a(View view, int i2, Bundle bundle) {
            if (this.f4321a.b() || this.f4321a.f4319a.getLayoutManager() == null) {
                return super.a(view, i2, bundle);
            }
            t.a aVar = this.f4322b.get(view);
            if (aVar != null) {
                if (aVar.a(view, i2, bundle)) {
                    return true;
                }
            } else if (super.a(view, i2, bundle)) {
                return true;
            }
            return this.f4321a.f4319a.getLayoutManager().a(view, i2, bundle);
        }

        public boolean a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            t.a aVar = this.f4322b.get(viewGroup);
            return aVar != null ? aVar.a(viewGroup, view, accessibilityEvent) : super.a(viewGroup, view, accessibilityEvent);
        }

        public boolean b(View view, AccessibilityEvent accessibilityEvent) {
            t.a aVar = this.f4322b.get(view);
            return aVar != null ? aVar.b(view, accessibilityEvent) : super.b(view, accessibilityEvent);
        }

        /* access modifiers changed from: package-private */
        public void c(View view) {
            t.a b2 = ac.b(view);
            if (b2 != null && b2 != this) {
                this.f4322b.put(view, b2);
            }
        }

        public void c(View view, AccessibilityEvent accessibilityEvent) {
            t.a aVar = this.f4322b.get(view);
            if (aVar != null) {
                aVar.c(view, accessibilityEvent);
            } else {
                super.c(view, accessibilityEvent);
            }
        }

        /* access modifiers changed from: package-private */
        public t.a d(View view) {
            return this.f4322b.remove(view);
        }

        public void d(View view, AccessibilityEvent accessibilityEvent) {
            t.a aVar = this.f4322b.get(view);
            if (aVar != null) {
                aVar.d(view, accessibilityEvent);
            } else {
                super.d(view, accessibilityEvent);
            }
        }
    }

    public u(RecyclerView recyclerView) {
        this.f4319a = recyclerView;
        t.a c2 = c();
        this.f4320b = (c2 == null || !(c2 instanceof a)) ? new a(this) : (a) c2;
    }

    public void a(View view, c cVar) {
        super.a(view, cVar);
        if (!b() && this.f4319a.getLayoutManager() != null) {
            this.f4319a.getLayoutManager().a(cVar);
        }
    }

    public boolean a(View view, int i2, Bundle bundle) {
        if (super.a(view, i2, bundle)) {
            return true;
        }
        if (b() || this.f4319a.getLayoutManager() == null) {
            return false;
        }
        return this.f4319a.getLayoutManager().a(i2, bundle);
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        return this.f4319a.v();
    }

    public t.a c() {
        return this.f4320b;
    }

    public void d(View view, AccessibilityEvent accessibilityEvent) {
        super.d(view, accessibilityEvent);
        if ((view instanceof RecyclerView) && !b()) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.getLayoutManager() != null) {
                recyclerView.getLayoutManager().a(accessibilityEvent);
            }
        }
    }
}
