package as;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.h;

public final class i {
    public static final View a(ViewGroup viewGroup, int i2) {
        h.c(viewGroup, "$this$inflate");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i2, viewGroup, false);
        h.a((Object) inflate, "LayoutInflater.from(cont…inflate(res, this, false)");
        return inflate;
    }

    public static final void a(View view) {
        h.c(view, "$this$show");
        if (view.getVisibility() != 0) {
            view.setVisibility(0);
        }
    }

    public static final void a(View view, int i2, int i3, int i4, int i5) {
        h.c(view, "$this$updatePadding");
        view.setPadding(i2, i3, i4, i5);
    }

    public static /* synthetic */ void a(View view, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i2 = view.getPaddingLeft();
        }
        if ((i6 & 2) != 0) {
            i3 = view.getPaddingTop();
        }
        if ((i6 & 4) != 0) {
            i4 = view.getPaddingRight();
        }
        if ((i6 & 8) != 0) {
            i5 = view.getPaddingBottom();
        }
        a(view, i2, i3, i4, i5);
    }

    public static final void a(View view, boolean z2) {
        h.c(view, "$this$showOrHide");
        if (z2) {
            a(view);
        } else {
            b(view);
        }
    }

    public static final void b(View view) {
        h.c(view, "$this$hide");
        if (view.getVisibility() != 8) {
            view.setVisibility(8);
        }
    }

    public static final void b(View view, int i2, int i3, int i4, int i5) {
        h.c(view, "$this$placeAt");
        view.layout(i3, i2, i4 + i3, i5 + i2);
    }

    public static /* synthetic */ void b(View view, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i3 = 0;
        }
        if ((i6 & 4) != 0) {
            i4 = view.getMeasuredWidth();
        }
        if ((i6 & 8) != 0) {
            i5 = view.getMeasuredHeight();
        }
        b(view, i2, i3, i4, i5);
    }

    public static final void b(View view, boolean z2) {
        h.c(view, "$this$showOrConceal");
        if (z2) {
            a(view);
        } else {
            c(view);
        }
    }

    public static final void c(View view) {
        h.c(view, "$this$conceal");
        if (view.getVisibility() != 4) {
            view.setVisibility(4);
        }
    }

    public static final boolean d(View view) {
        h.c(view, "$this$isVisible");
        return view.getVisibility() == 0;
    }
}
