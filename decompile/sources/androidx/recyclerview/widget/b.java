package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;

public final class b implements q {

    /* renamed from: a  reason: collision with root package name */
    private final RecyclerView.Adapter f4100a;

    public b(RecyclerView.Adapter adapter) {
        this.f4100a = adapter;
    }

    public void a(int i2, int i3) {
        this.f4100a.notifyItemRangeInserted(i2, i3);
    }

    public void a(int i2, int i3, Object obj) {
        this.f4100a.notifyItemRangeChanged(i2, i3, obj);
    }

    public void b(int i2, int i3) {
        this.f4100a.notifyItemRangeRemoved(i2, i3);
    }

    public void c(int i2, int i3) {
        this.f4100a.notifyItemMoved(i2, i3);
    }
}
