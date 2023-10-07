package la;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.cfly.uav_pro.R;
import com.recyclerview.swipe.h;
import com.xeagle.android.utils.c;
import com.xeagle.android.vjoystick.IWidgets.IImageButton;
import java.util.ArrayList;

public class e extends h<b> {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<String> f30721a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public a f30722b;

    public interface a {
        void a(View view, int i2);

        void b(View view, int i2);

        void c(View view, int i2);
    }

    public class b extends RecyclerView.v {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public TextView f30727b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public IImageButton f30728c;

        public b(final View view) {
            super(view);
            this.f30727b = (TextView) view.findViewById(R.id.record_item_name);
            this.f30728c = (IImageButton) view.findViewById(R.id.record_item_btn);
            view.setOnClickListener(new View.OnClickListener(e.this) {
                public void onClick(View view) {
                    if (e.this.f30722b != null) {
                        e.this.f30722b.a(view, b.this.getPosition());
                    }
                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener(e.this) {
                public boolean onLongClick(View view) {
                    if (e.this.f30722b == null) {
                        return true;
                    }
                    e.this.f30722b.b(view, b.this.getPosition());
                    return true;
                }
            });
        }
    }

    public e(ArrayList<String> arrayList) {
        this.f30721a = arrayList;
    }

    public View a(ViewGroup viewGroup, int i2) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.record_list_item, viewGroup, false);
    }

    public void a(a aVar) {
        this.f30722b = aVar;
    }

    /* renamed from: a */
    public void onBindViewHolder(final b bVar, final int i2) {
        bVar.f30727b.setText(c.a(this.f30721a.get(i2)));
        bVar.f30728c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (e.this.f30722b != null) {
                    e.this.f30722b.c(bVar.f30728c, i2);
                }
            }
        });
    }

    /* renamed from: b */
    public b a(View view, int i2) {
        return new b(view);
    }

    public int getItemCount() {
        if (this.f30721a.size() == 0) {
            return 0;
        }
        return this.f30721a.size();
    }
}
