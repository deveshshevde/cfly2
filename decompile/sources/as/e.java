package as;

import android.view.View;
import kotlin.jvm.internal.h;
import kotlin.l;
import mm.b;

public final class e {

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f5567a;

        a(b bVar) {
            this.f5567a = bVar;
        }

        public final void onClick(View view) {
            d dVar = d.f5563a;
            h.a((Object) view, "it");
            if (dVar.a(view)) {
                this.f5567a.invoke(view);
            }
        }
    }

    public static final <T extends View> T a(T t2, b<? super T, l> bVar) {
        h.c(t2, "$this$onClickDebounced");
        h.c(bVar, "click");
        t2.setOnClickListener(new a(bVar));
        return t2;
    }
}
