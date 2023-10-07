package t;

import android.os.Build;
import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.core.R;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;
import u.c;
import u.d;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final View.AccessibilityDelegate f34401a = new View.AccessibilityDelegate();

    /* renamed from: b  reason: collision with root package name */
    private final View.AccessibilityDelegate f34402b;

    /* renamed from: c  reason: collision with root package name */
    private final View.AccessibilityDelegate f34403c;

    /* renamed from: t.a$a  reason: collision with other inner class name */
    static final class C0256a extends View.AccessibilityDelegate {

        /* renamed from: a  reason: collision with root package name */
        final a f34404a;

        C0256a(a aVar) {
            this.f34404a = aVar;
        }

        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.f34404a.b(view, accessibilityEvent);
        }

        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            d a2 = this.f34404a.a(view);
            if (a2 != null) {
                return (AccessibilityNodeProvider) a2.a();
            }
            return null;
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f34404a.d(view, accessibilityEvent);
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            c a2 = c.a(accessibilityNodeInfo);
            a2.n(ac.M(view));
            a2.p(ac.O(view));
            a2.i(ac.N(view));
            a2.f(ac.g(view));
            this.f34404a.a(view, a2);
            a2.a(accessibilityNodeInfo.getText(), view);
            List<c.a> b2 = a.b(view);
            for (int i2 = 0; i2 < b2.size(); i2++) {
                a2.a(b2.get(i2));
            }
        }

        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f34404a.c(view, accessibilityEvent);
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.f34404a.a(viewGroup, view, accessibilityEvent);
        }

        public boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
            return this.f34404a.a(view, i2, bundle);
        }

        public void sendAccessibilityEvent(View view, int i2) {
            this.f34404a.a(view, i2);
        }

        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.f34404a.a(view, accessibilityEvent);
        }
    }

    public a() {
        this(f34401a);
    }

    public a(View.AccessibilityDelegate accessibilityDelegate) {
        this.f34402b = accessibilityDelegate;
        this.f34403c = new C0256a(this);
    }

    private boolean a(int i2, View view) {
        WeakReference weakReference;
        SparseArray sparseArray = (SparseArray) view.getTag(R.id.tag_accessibility_clickable_spans);
        if (sparseArray == null || (weakReference = (WeakReference) sparseArray.get(i2)) == null) {
            return false;
        }
        ClickableSpan clickableSpan = (ClickableSpan) weakReference.get();
        if (!a(clickableSpan, view)) {
            return false;
        }
        clickableSpan.onClick(view);
        return true;
    }

    private boolean a(ClickableSpan clickableSpan, View view) {
        if (clickableSpan != null) {
            ClickableSpan[] d2 = c.d(view.createAccessibilityNodeInfo().getText());
            int i2 = 0;
            while (d2 != null && i2 < d2.length) {
                if (clickableSpan.equals(d2[i2])) {
                    return true;
                }
                i2++;
            }
        }
        return false;
    }

    static List<c.a> b(View view) {
        List<c.a> list = (List) view.getTag(R.id.tag_accessibility_actions);
        return list == null ? Collections.emptyList() : list;
    }

    /* access modifiers changed from: package-private */
    public View.AccessibilityDelegate a() {
        return this.f34403c;
    }

    public d a(View view) {
        AccessibilityNodeProvider accessibilityNodeProvider;
        if (Build.VERSION.SDK_INT < 16 || (accessibilityNodeProvider = this.f34402b.getAccessibilityNodeProvider(view)) == null) {
            return null;
        }
        return new d(accessibilityNodeProvider);
    }

    public void a(View view, int i2) {
        this.f34402b.sendAccessibilityEvent(view, i2);
    }

    public void a(View view, AccessibilityEvent accessibilityEvent) {
        this.f34402b.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public void a(View view, c cVar) {
        this.f34402b.onInitializeAccessibilityNodeInfo(view, cVar.a());
    }

    public boolean a(View view, int i2, Bundle bundle) {
        List<c.a> b2 = b(view);
        boolean z2 = false;
        int i3 = 0;
        while (true) {
            if (i3 >= b2.size()) {
                break;
            }
            c.a aVar = b2.get(i3);
            if (aVar.a() == i2) {
                z2 = aVar.a(view, bundle);
                break;
            }
            i3++;
        }
        if (!z2 && Build.VERSION.SDK_INT >= 16) {
            z2 = this.f34402b.performAccessibilityAction(view, i2, bundle);
        }
        return (z2 || i2 != R.id.accessibility_action_clickable_span) ? z2 : a(bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1), view);
    }

    public boolean a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f34402b.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public boolean b(View view, AccessibilityEvent accessibilityEvent) {
        return this.f34402b.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public void c(View view, AccessibilityEvent accessibilityEvent) {
        this.f34402b.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public void d(View view, AccessibilityEvent accessibilityEvent) {
        this.f34402b.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }
}
