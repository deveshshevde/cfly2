package com.recyclerview.swipe;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.yanzhenjie.recyclerview.swipe.R;
import java.util.List;

public abstract class h<VH extends RecyclerView.v> extends RecyclerView.Adapter<VH> {

    /* renamed from: a  reason: collision with root package name */
    private i f21542a;

    /* renamed from: b  reason: collision with root package name */
    private b f21543b;

    public abstract View a(ViewGroup viewGroup, int i2);

    public abstract VH a(View view, int i2);

    public void a(VH vh, int i2, List<Object> list) {
        onBindViewHolder(vh, i2);
    }

    /* access modifiers changed from: package-private */
    public void a(b bVar) {
        this.f21543b = bVar;
    }

    /* access modifiers changed from: package-private */
    public void a(i iVar) {
        this.f21542a = iVar;
    }

    public final void onBindViewHolder(VH vh, int i2, List<Object> list) {
        View view = vh.itemView;
        if (view instanceof SwipeMenuLayout) {
            SwipeMenuLayout swipeMenuLayout = (SwipeMenuLayout) view;
            int childCount = swipeMenuLayout.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = swipeMenuLayout.getChildAt(i3);
                if (childAt instanceof SwipeMenuView) {
                    ((SwipeMenuView) childAt).a((RecyclerView.v) vh);
                }
            }
        }
        a(vh, i2, list);
    }

    public final VH onCreateViewHolder(ViewGroup viewGroup, int i2) {
        View a2 = a(viewGroup, i2);
        if (this.f21542a != null) {
            SwipeMenuLayout swipeMenuLayout = (SwipeMenuLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.swipe_item_default, viewGroup, false);
            g gVar = new g(swipeMenuLayout, i2);
            g gVar2 = new g(swipeMenuLayout, i2);
            this.f21542a.a(gVar, gVar2, i2);
            int size = gVar.b().size();
            if (size > 0) {
                SwipeMenuView swipeMenuView = (SwipeMenuView) swipeMenuLayout.findViewById(R.id.swipe_left);
                swipeMenuView.setOrientation(gVar.a());
                swipeMenuView.a(gVar, 1);
                swipeMenuView.a(this.f21543b, (l) swipeMenuLayout);
            }
            int size2 = gVar2.b().size();
            if (size2 > 0) {
                SwipeMenuView swipeMenuView2 = (SwipeMenuView) swipeMenuLayout.findViewById(R.id.swipe_right);
                swipeMenuView2.setOrientation(gVar2.a());
                swipeMenuView2.a(gVar2, -1);
                swipeMenuView2.a(this.f21543b, (l) swipeMenuLayout);
            }
            if (size > 0 || size2 > 0) {
                ((ViewGroup) swipeMenuLayout.findViewById(R.id.swipe_content)).addView(a2);
                a2 = swipeMenuLayout;
            }
        }
        return a(a2, i2);
    }
}
