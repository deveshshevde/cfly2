package hr;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.huantansheng.easyphotos.R;
import com.huantansheng.easyphotos.models.puzzle.SquarePuzzleView;
import com.huantansheng.easyphotos.models.puzzle.c;
import java.util.ArrayList;
import java.util.List;

public class e extends RecyclerView.Adapter<b> {

    /* renamed from: a  reason: collision with root package name */
    private List<c> f13463a = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public a f13464b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public int f13465c = 0;

    public interface a {
        void a(int i2, int i3);
    }

    public static class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        SquarePuzzleView f13469a;

        /* renamed from: b  reason: collision with root package name */
        View f13470b;

        public b(View view) {
            super(view);
            this.f13469a = (SquarePuzzleView) view.findViewById(R.id.puzzle);
            this.f13470b = view.findViewById(R.id.m_selector);
        }
    }

    /* renamed from: a */
    public b onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_puzzle_easy_photos, viewGroup, false));
    }

    public void a(a aVar) {
        this.f13464b = aVar;
    }

    /* renamed from: a */
    public void onBindViewHolder(b bVar, final int i2) {
        final c cVar = this.f13463a.get(i2);
        if (this.f13465c == i2) {
            bVar.f13470b.setVisibility(0);
        } else {
            bVar.f13470b.setVisibility(8);
        }
        bVar.f13469a.setNeedDrawLine(true);
        bVar.f13469a.setNeedDrawOuterLine(true);
        bVar.f13469a.setTouchEnable(false);
        bVar.f13469a.setPuzzleLayout(cVar);
        bVar.itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int i2;
                if (e.this.f13465c != i2 && e.this.f13464b != null) {
                    c cVar = cVar;
                    int i3 = 0;
                    if (cVar instanceof hl.a) {
                        i2 = ((hl.a) cVar).j();
                    } else if (cVar instanceof hm.e) {
                        i3 = 1;
                        i2 = ((hm.e) cVar).j();
                    } else {
                        i2 = 0;
                    }
                    int unused = e.this.f13465c = i2;
                    e.this.f13464b.a(i3, i2);
                    e.this.notifyDataSetChanged();
                }
            }
        });
    }

    public void a(List<c> list) {
        this.f13463a = list;
        notifyDataSetChanged();
    }

    public int getItemCount() {
        List<c> list = this.f13463a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
