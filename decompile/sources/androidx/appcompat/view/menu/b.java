package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.n;
import java.util.ArrayList;

public abstract class b implements m {

    /* renamed from: a  reason: collision with root package name */
    protected Context f796a;

    /* renamed from: b  reason: collision with root package name */
    protected Context f797b;

    /* renamed from: c  reason: collision with root package name */
    protected g f798c;

    /* renamed from: d  reason: collision with root package name */
    protected LayoutInflater f799d;

    /* renamed from: e  reason: collision with root package name */
    protected LayoutInflater f800e;

    /* renamed from: f  reason: collision with root package name */
    protected n f801f;

    /* renamed from: g  reason: collision with root package name */
    private m.a f802g;

    /* renamed from: h  reason: collision with root package name */
    private int f803h;

    /* renamed from: i  reason: collision with root package name */
    private int f804i;

    /* renamed from: j  reason: collision with root package name */
    private int f805j;

    public b(Context context, int i2, int i3) {
        this.f796a = context;
        this.f799d = LayoutInflater.from(context);
        this.f803h = i2;
        this.f804i = i3;
    }

    public View a(i iVar, View view, ViewGroup viewGroup) {
        n.a b2 = view instanceof n.a ? (n.a) view : b(viewGroup);
        a(iVar, b2);
        return (View) b2;
    }

    public m.a a() {
        return this.f802g;
    }

    public n a(ViewGroup viewGroup) {
        if (this.f801f == null) {
            n nVar = (n) this.f799d.inflate(this.f803h, viewGroup, false);
            this.f801f = nVar;
            nVar.a(this.f798c);
            a(true);
        }
        return this.f801f;
    }

    public void a(int i2) {
        this.f805j = i2;
    }

    public void a(Context context, g gVar) {
        this.f797b = context;
        this.f800e = LayoutInflater.from(context);
        this.f798c = gVar;
    }

    /* access modifiers changed from: protected */
    public void a(View view, int i2) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f801f).addView(view, i2);
    }

    public void a(g gVar, boolean z2) {
        m.a aVar = this.f802g;
        if (aVar != null) {
            aVar.a(gVar, z2);
        }
    }

    public abstract void a(i iVar, n.a aVar);

    public void a(m.a aVar) {
        this.f802g = aVar;
    }

    public void a(boolean z2) {
        ViewGroup viewGroup = (ViewGroup) this.f801f;
        if (viewGroup != null) {
            g gVar = this.f798c;
            int i2 = 0;
            if (gVar != null) {
                gVar.k();
                ArrayList<i> j2 = this.f798c.j();
                int size = j2.size();
                int i3 = 0;
                for (int i4 = 0; i4 < size; i4++) {
                    i iVar = j2.get(i4);
                    if (a(i3, iVar)) {
                        View childAt = viewGroup.getChildAt(i3);
                        i itemData = childAt instanceof n.a ? ((n.a) childAt).getItemData() : null;
                        View a2 = a(iVar, childAt, viewGroup);
                        if (iVar != itemData) {
                            a2.setPressed(false);
                            a2.jumpDrawablesToCurrentState();
                        }
                        if (a2 != childAt) {
                            a(a2, i3);
                        }
                        i3++;
                    }
                }
                i2 = i3;
            }
            while (i2 < viewGroup.getChildCount()) {
                if (!a(viewGroup, i2)) {
                    i2++;
                }
            }
        }
    }

    public boolean a(int i2, i iVar) {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean a(ViewGroup viewGroup, int i2) {
        viewGroup.removeViewAt(i2);
        return true;
    }

    public boolean a(g gVar, i iVar) {
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000e, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(androidx.appcompat.view.menu.r r2) {
        /*
            r1 = this;
            androidx.appcompat.view.menu.m$a r0 = r1.f802g
            if (r0 == 0) goto L_0x000e
            if (r2 == 0) goto L_0x0007
            goto L_0x0009
        L_0x0007:
            androidx.appcompat.view.menu.g r2 = r1.f798c
        L_0x0009:
            boolean r2 = r0.a(r2)
            return r2
        L_0x000e:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.b.a(androidx.appcompat.view.menu.r):boolean");
    }

    public n.a b(ViewGroup viewGroup) {
        return (n.a) this.f799d.inflate(this.f804i, viewGroup, false);
    }

    public boolean b() {
        return false;
    }

    public boolean b(g gVar, i iVar) {
        return false;
    }

    public int c() {
        return this.f805j;
    }
}
