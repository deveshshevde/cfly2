package androidx.appcompat.view.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.widget.af;

public final class ExpandedMenuView extends ListView implements AdapterView.OnItemClickListener, g.b, n {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f756a = {16842964, 16843049};

    /* renamed from: b  reason: collision with root package name */
    private g f757b;

    /* renamed from: c  reason: collision with root package name */
    private int f758c;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842868);
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        af a2 = af.a(context, attributeSet, f756a, i2, 0);
        if (a2.g(0)) {
            setBackgroundDrawable(a2.a(0));
        }
        if (a2.g(1)) {
            setDivider(a2.a(1));
        }
        a2.b();
    }

    public void a(g gVar) {
        this.f757b = gVar;
    }

    public boolean a(i iVar) {
        return this.f757b.a((MenuItem) iVar, 0);
    }

    public int getWindowAnimations() {
        return this.f758c;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    public void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
        a((i) getAdapter().getItem(i2));
    }
}
