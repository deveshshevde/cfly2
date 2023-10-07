package com.scwang.smartrefresh.layout.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.b;
import com.scwang.smartrefresh.layout.impl.RefreshFooterWrapper;
import com.scwang.smartrefresh.layout.impl.RefreshHeaderWrapper;
import ja.f;
import ja.g;
import ja.h;
import ja.i;
import ja.j;

public abstract class InternalAbstract extends RelativeLayout implements h {

    /* renamed from: x  reason: collision with root package name */
    protected View f12188x;

    /* renamed from: y  reason: collision with root package name */
    protected b f12189y;

    /* renamed from: z  reason: collision with root package name */
    protected h f12190z;

    protected InternalAbstract(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    protected InternalAbstract(View view) {
        this(view, view instanceof h ? (h) view : null);
    }

    protected InternalAbstract(View view, h hVar) {
        super(view.getContext(), (AttributeSet) null, 0);
        this.f12188x = view;
        this.f12190z = hVar;
        if (!(this instanceof RefreshFooterWrapper) || !(hVar instanceof g) || hVar.getSpinnerStyle() != b.f12103e) {
            if (this instanceof RefreshHeaderWrapper) {
                h hVar2 = this.f12190z;
                if (!(hVar2 instanceof f) || hVar2.getSpinnerStyle() != b.f12103e) {
                    return;
                }
            } else {
                return;
            }
        }
        hVar.getView().setScaleY(-1.0f);
    }

    public int a(j jVar, boolean z2) {
        h hVar = this.f12190z;
        if (hVar == null || hVar == this) {
            return 0;
        }
        return hVar.a(jVar, z2);
    }

    public void a(float f2, int i2, int i3) {
        h hVar = this.f12190z;
        if (hVar != null && hVar != this) {
            hVar.a(f2, i2, i3);
        }
    }

    public void a(i iVar, int i2, int i3) {
        h hVar = this.f12190z;
        if (hVar == null || hVar == this) {
            View view = this.f12188x;
            if (view != null) {
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams instanceof SmartRefreshLayout.LayoutParams) {
                    iVar.a((h) this, ((SmartRefreshLayout.LayoutParams) layoutParams).f12041a);
                    return;
                }
                return;
            }
            return;
        }
        hVar.a(iVar, i2, i3);
    }

    public void a(j jVar, int i2, int i3) {
        h hVar = this.f12190z;
        if (hVar != null && hVar != this) {
            hVar.a(jVar, i2, i3);
        }
    }

    public void a(j jVar, RefreshState refreshState, RefreshState refreshState2) {
        h hVar = this.f12190z;
        if (hVar != null && hVar != this) {
            if ((this instanceof RefreshFooterWrapper) && (hVar instanceof g)) {
                if (refreshState.f12078s) {
                    refreshState = refreshState.b();
                }
                if (refreshState2.f12078s) {
                    refreshState2 = refreshState2.b();
                }
            } else if ((this instanceof RefreshHeaderWrapper) && (hVar instanceof f)) {
                if (refreshState.f12077r) {
                    refreshState = refreshState.a();
                }
                if (refreshState2.f12077r) {
                    refreshState2 = refreshState2.a();
                }
            }
            h hVar2 = this.f12190z;
            if (hVar2 != null) {
                hVar2.a(jVar, refreshState, refreshState2);
            }
        }
    }

    public void a(boolean z2, float f2, int i2, int i3, int i4) {
        h hVar = this.f12190z;
        if (hVar != null && hVar != this) {
            hVar.a(z2, f2, i2, i3, i4);
        }
    }

    public boolean a() {
        h hVar = this.f12190z;
        return (hVar == null || hVar == this || !hVar.a()) ? false : true;
    }

    public boolean a(boolean z2) {
        h hVar = this.f12190z;
        return (hVar instanceof f) && ((f) hVar).a(z2);
    }

    public void b(j jVar, int i2, int i3) {
        h hVar = this.f12190z;
        if (hVar != null && hVar != this) {
            hVar.b(jVar, i2, i3);
        }
    }

    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return (obj instanceof h) && getView() == ((h) obj).getView();
        }
        return true;
    }

    public b getSpinnerStyle() {
        b bVar = this.f12189y;
        if (bVar != null) {
            return bVar;
        }
        h hVar = this.f12190z;
        if (hVar != null && hVar != this) {
            return hVar.getSpinnerStyle();
        }
        View view = this.f12188x;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof SmartRefreshLayout.LayoutParams) {
                b bVar2 = ((SmartRefreshLayout.LayoutParams) layoutParams).f12042b;
                this.f12189y = bVar2;
                if (bVar2 != null) {
                    return bVar2;
                }
            }
            if (layoutParams != null && (layoutParams.height == 0 || layoutParams.height == -1)) {
                for (b bVar3 : b.f12104f) {
                    if (bVar3.f12107i) {
                        this.f12189y = bVar3;
                        return bVar3;
                    }
                }
            }
        }
        b bVar4 = b.f12099a;
        this.f12189y = bVar4;
        return bVar4;
    }

    public View getView() {
        View view = this.f12188x;
        return view == null ? this : view;
    }

    public void setPrimaryColors(int... iArr) {
        h hVar = this.f12190z;
        if (hVar != null && hVar != this) {
            hVar.setPrimaryColors(iArr);
        }
    }
}
