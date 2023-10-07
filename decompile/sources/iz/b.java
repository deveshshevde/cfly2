package iz;

import android.graphics.Canvas;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.k;

public class b extends k.a {

    /* renamed from: a  reason: collision with root package name */
    private d f29435a;

    /* renamed from: b  reason: collision with root package name */
    private c f29436b;

    /* renamed from: c  reason: collision with root package name */
    private e f29437c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f29438d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f29439e;

    public int a(RecyclerView recyclerView, RecyclerView.v vVar) {
        d dVar = this.f29435a;
        if (dVar != null) {
            return b(dVar.a(recyclerView, vVar), this.f29435a.b(recyclerView, vVar));
        }
        RecyclerView.h layoutManager = recyclerView.getLayoutManager();
        return layoutManager instanceof GridLayoutManager ? b(15, 12) : layoutManager instanceof LinearLayoutManager ? ((LinearLayoutManager) layoutManager).h() == 0 ? b(12, 3) : b(3, 12) : b(0, 0);
    }

    public void a(Canvas canvas, RecyclerView recyclerView, RecyclerView.v vVar, float f2, float f3, int i2, boolean z2) {
        float abs;
        int width;
        if (i2 == 1) {
            RecyclerView.h layoutManager = recyclerView.getLayoutManager();
            float f4 = 1.0f;
            if (layoutManager instanceof LinearLayoutManager) {
                int h2 = ((LinearLayoutManager) layoutManager).h();
                if (h2 == 0) {
                    abs = Math.abs(f3);
                    width = vVar.itemView.getHeight();
                } else if (h2 == 1) {
                    abs = Math.abs(f2);
                    width = vVar.itemView.getWidth();
                }
                f4 = 1.0f - (abs / ((float) width));
            }
            vVar.itemView.setAlpha(f4);
        }
        super.a(canvas, recyclerView, vVar, f2, f3, i2, z2);
    }

    public void a(RecyclerView.v vVar, int i2) {
        c cVar = this.f29436b;
        if (cVar != null) {
            cVar.a(vVar.getAdapterPosition());
        }
    }

    public void a(c cVar) {
        this.f29436b = cVar;
    }

    public void a(d dVar) {
        this.f29435a = dVar;
    }

    public void a(e eVar) {
        this.f29437c = eVar;
    }

    public void a(boolean z2) {
        this.f29439e = z2;
    }

    public boolean a() {
        return this.f29439e;
    }

    public void b(RecyclerView.v vVar, int i2) {
        super.b(vVar, i2);
        e eVar = this.f29437c;
        if (eVar != null && i2 != 0) {
            eVar.a(vVar, i2);
        }
    }

    public void b(boolean z2) {
        this.f29438d = z2;
    }

    public boolean b() {
        return this.f29438d;
    }

    public boolean b(RecyclerView recyclerView, RecyclerView.v vVar, RecyclerView.v vVar2) {
        c cVar;
        if (vVar.getItemViewType() != vVar2.getItemViewType() || (cVar = this.f29436b) == null) {
            return false;
        }
        return cVar.a(vVar.getAdapterPosition(), vVar2.getAdapterPosition());
    }

    public e d() {
        return this.f29437c;
    }

    public void d(RecyclerView recyclerView, RecyclerView.v vVar) {
        super.d(recyclerView, vVar);
        e eVar = this.f29437c;
        if (eVar != null) {
            eVar.a(vVar, 0);
        }
    }
}
