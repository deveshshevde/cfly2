package as;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.h;

public final class f {

    public static final class a extends RecyclerView.l {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RecyclerView f5568a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f5569b;

        a(RecyclerView recyclerView, View view) {
            this.f5568a = recyclerView;
            this.f5569b = view;
        }

        public void a(RecyclerView recyclerView, int i2, int i3) {
            h.c(recyclerView, "recyclerView");
            super.a(recyclerView, i2, i3);
            f.b(this.f5568a, this.f5569b);
        }
    }

    public static final void a(RecyclerView recyclerView, View view) {
        h.c(recyclerView, "$this$attachTopDivider");
        h.c(view, "divider");
        b(recyclerView, view);
        recyclerView.a((RecyclerView.l) new a(recyclerView, view));
    }

    public static final void b(RecyclerView recyclerView, View view) {
        h.c(recyclerView, "$this$invalidateTopDividerNow");
        h.c(view, "divider");
        if (!i.d(recyclerView)) {
            i.b(view);
        } else {
            i.a(view, recyclerView.computeVerticalScrollOffset() > view.getMeasuredHeight() * 2);
        }
    }
}
