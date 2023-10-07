package lk;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import lk.a;
import t.ac;
import t.ag;
import t.ah;

public class b extends a {
    public b(RecyclerView recyclerView) {
        super(recyclerView);
    }

    /* access modifiers changed from: protected */
    public void c(RecyclerView.v vVar) {
        ac.a(vVar.itemView, (float) this.f30882a.getLayoutManager().C());
    }

    /* access modifiers changed from: protected */
    public void u(final RecyclerView.v vVar) {
        final ag r2 = ac.r(vVar.itemView);
        this.f30883b.add(vVar);
        r2.b(0.0f).a(1.0f).a(f()).a((ah) new a.c() {
            public void a(View view) {
                b.this.n(vVar);
            }

            public void b(View view) {
                r2.a((ah) null);
                b.this.k(vVar);
                ac.a(view, 0.0f);
                ac.c(view, 1.0f);
                b.this.f30883b.remove(vVar);
                b.this.c();
            }

            public void c(View view) {
                ac.a(view, 0.0f);
                ac.c(view, 1.0f);
            }
        }).c();
    }

    /* access modifiers changed from: protected */
    public void v(final RecyclerView.v vVar) {
        final ag r2 = ac.r(vVar.itemView);
        this.f30885d.add(vVar);
        r2.a(g()).a(0.0f).b((float) this.f30882a.getLayoutManager().C()).a((ah) new a.c() {
            public void a(View view) {
                b.this.l(vVar);
            }

            public void b(View view) {
                r2.a((ah) null);
                ac.c(view, 1.0f);
                ac.a(view, (float) b.this.f30882a.getLayoutManager().C());
                b.this.i(vVar);
                b.this.f30885d.remove(vVar);
                b.this.c();
            }
        }).c();
    }
}
