package com.recyclerview.swipe;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;
import iz.a;
import iz.c;
import iz.d;
import iz.e;
import java.util.ArrayList;

public class SwipeMenuRecyclerView extends RecyclerView {
    protected int N;
    protected SwipeMenuLayout O;
    protected int P;
    private int Q;
    private int R;
    private boolean S;
    /* access modifiers changed from: private */
    public i T;
    /* access modifiers changed from: private */
    public b U;
    private a V;
    private i W;

    /* renamed from: aa  reason: collision with root package name */
    private b f21523aa;

    public SwipeMenuRecyclerView(Context context) {
        this(context, (AttributeSet) null);
    }

    public SwipeMenuRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwipeMenuRecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.P = -1;
        this.S = false;
        this.W = new i() {
            public void a(g gVar, g gVar2, int i2) {
                if (SwipeMenuRecyclerView.this.T != null) {
                    SwipeMenuRecyclerView.this.T.a(gVar, gVar2, i2);
                }
            }
        };
        this.f21523aa = new b() {
            public void a(a aVar, int i2, int i3, int i4) {
                if (SwipeMenuRecyclerView.this.U != null) {
                    SwipeMenuRecyclerView.this.U.a(aVar, i2, i3, i4);
                }
            }
        };
        this.N = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    private boolean b(int i2, int i3, boolean z2) {
        int i4 = this.Q - i2;
        int i5 = this.R - i3;
        if (Math.abs(i4) > this.N && Math.abs(i4) > Math.abs(i5)) {
            return false;
        }
        if (Math.abs(i5) >= this.N || Math.abs(i4) >= this.N) {
            return z2;
        }
        return false;
    }

    private View n(View view) {
        if (view instanceof SwipeMenuLayout) {
            return view;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(view);
        while (!arrayList.isEmpty()) {
            View view2 = (View) arrayList.remove(0);
            if (view2 instanceof ViewGroup) {
                if (view2 instanceof SwipeMenuLayout) {
                    return view2;
                }
                ViewGroup viewGroup = (ViewGroup) view2;
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    arrayList.add(viewGroup.getChildAt(i2));
                }
            }
        }
        return view;
    }

    private void y() {
        if (this.V == null) {
            a aVar = new a();
            this.V = aVar;
            aVar.a((RecyclerView) this);
        }
    }

    public e getOnItemStateChangedListener() {
        return this.V.e();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        SwipeMenuLayout swipeMenuLayout;
        ViewParent parent;
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        if (this.S) {
            return onInterceptTouchEvent;
        }
        boolean z3 = true;
        if (motionEvent.getPointerCount() > 1) {
            return true;
        }
        int action = motionEvent.getAction();
        int x2 = (int) motionEvent.getX();
        int y2 = (int) motionEvent.getY();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    onInterceptTouchEvent = b(x2, y2, onInterceptTouchEvent);
                    if (this.O == null || (parent = getParent()) == null) {
                        return onInterceptTouchEvent;
                    }
                    int i2 = this.Q - x2;
                    boolean z4 = i2 > 0 && (this.O.e() || this.O.h());
                    boolean z5 = i2 < 0 && (this.O.d() || this.O.i());
                    if (!z4 && !z5) {
                        z3 = false;
                    }
                    parent.requestDisallowInterceptTouchEvent(z3);
                } else if (action != 3) {
                    return onInterceptTouchEvent;
                }
            }
            return b(x2, y2, onInterceptTouchEvent);
        }
        this.Q = x2;
        this.R = y2;
        int f2 = f(a((float) x2, (float) y2));
        if (f2 == this.P || (swipeMenuLayout = this.O) == null || !swipeMenuLayout.b()) {
            z2 = false;
        } else {
            this.O.a();
            z2 = true;
        }
        if (z2) {
            this.O = null;
            f2 = -1;
        } else {
            RecyclerView.v e2 = e(f2);
            if (e2 == null) {
                return z2;
            }
            View n2 = n(e2.itemView);
            if (!(n2 instanceof SwipeMenuLayout)) {
                return z2;
            }
            this.O = (SwipeMenuLayout) n2;
        }
        this.P = f2;
        return z2;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        SwipeMenuLayout swipeMenuLayout;
        if (motionEvent.getAction() == 2 && (swipeMenuLayout = this.O) != null && swipeMenuLayout.b()) {
            this.O.a();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        if (adapter instanceof h) {
            h hVar = (h) adapter;
            hVar.a(this.W);
            hVar.a(this.f21523aa);
        }
        super.setAdapter(adapter);
    }

    public void setItemViewSwipeEnabled(boolean z2) {
        y();
        this.S = z2;
        this.V.b(z2);
    }

    public void setLongPressDragEnabled(boolean z2) {
        y();
        this.V.a(z2);
    }

    public void setOnItemMoveListener(c cVar) {
        y();
        this.V.a(cVar);
    }

    public void setOnItemMovementListener(d dVar) {
        y();
        this.V.a(dVar);
    }

    public void setOnItemStateChangedListener(e eVar) {
        this.V.a(eVar);
    }

    public void setSwipeMenuCreator(i iVar) {
        this.T = iVar;
    }

    public void setSwipeMenuItemClickListener(b bVar) {
        this.U = bVar;
    }
}
