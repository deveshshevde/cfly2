package ax;

import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.materialdialogs.b;
import com.afollestad.materialdialogs.internal.list.DialogRecyclerView;
import kotlin.jvm.internal.h;

public final class a {
    public static final RecyclerView.Adapter<?> a(b bVar) {
        h.c(bVar, "$this$getListAdapter");
        DialogRecyclerView recyclerView = bVar.b().getContentLayout().getRecyclerView();
        if (recyclerView != null) {
            return recyclerView.getAdapter();
        }
        return null;
    }
}
