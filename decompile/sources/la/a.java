package la;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cfly.uav_pro.R;
import java.util.List;

public class a extends RecyclerView.Adapter<C0215a> {

    /* renamed from: a  reason: collision with root package name */
    private Context f30682a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public List<String> f30683b;

    /* renamed from: c  reason: collision with root package name */
    private int f30684c = -1;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public b f30685d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public RecyclerView f30686e;

    public interface b {
        void a(RecyclerView recyclerView, int i2, String str);
    }

    /* renamed from: la.a$a  reason: collision with other inner class name */
    class C0215a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f30687a;

        public C0215a(View view) {
            super(view);
            this.f30687a = (TextView) view.findViewById(R.id.count_tv);
            view.setOnClickListener(new View.OnClickListener(a.this) {
                public void onClick(View view) {
                    if (a.this.f30685d != null) {
                        a.this.f30685d.a(a.this.f30686e, C0215a.this.getLayoutPosition(), (String) a.this.f30683b.get(C0215a.this.getLayoutPosition()));
                    }
                }
            });
        }
    }

    public a(RecyclerView recyclerView, Context context, List<String> list) {
        this.f30682a = context;
        this.f30683b = list;
        this.f30686e = recyclerView;
    }

    /* renamed from: a */
    public C0215a onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new C0215a(LayoutInflater.from(this.f30682a).inflate(R.layout.count_item, viewGroup, false));
    }

    public void a(LinearLayoutManager linearLayoutManager, int i2) {
        this.f30684c = i2;
        linearLayoutManager.b(i2, 0);
        notifyDataSetChanged();
    }

    /* renamed from: a */
    public void onBindViewHolder(C0215a aVar, int i2) {
        aVar.f30687a.setText(this.f30683b.get(i2));
        int i3 = this.f30684c;
        if (i3 != -1) {
            if (i3 == i2) {
                aVar.f30687a.setTextColor(-16711936);
            } else {
                aVar.f30687a.setTextColor(-1);
            }
            aVar.f30687a.setTextSize(12.0f);
        }
    }

    public void a(b bVar) {
        this.f30685d = bVar;
    }

    public int getItemCount() {
        return this.f30683b.size();
    }
}
