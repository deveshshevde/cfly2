package jz;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.g;
import com.cfly.uav_pro.R;
import com.xeagle.android.login.common.TimeUtil;
import com.xeagle.android.login.pickImage.ImagePicker;
import com.xeagle.android.login.pickImage.data.GLImage;
import java.util.ArrayList;
import kw.c;

public class b extends RecyclerView.Adapter<a> {

    /* renamed from: a  reason: collision with root package name */
    private Context f29864a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<GLImage> f29865b;

    /* renamed from: c  reason: collision with root package name */
    private ImagePicker f29866c = ImagePicker.getInstance();

    /* renamed from: d  reason: collision with root package name */
    private C0205b f29867d;

    static class a extends RecyclerView.v {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public ImageView f29868a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public TextView f29869b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public TextView f29870c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public TextView f29871d;

        public a(View view) {
            super(view);
            this.f29868a = (ImageView) view.findViewById(R.id.iv_editor_mask);
            this.f29869b = (TextView) view.findViewById(R.id.tv_editor_time);
            this.f29870c = (TextView) view.findViewById(R.id.tv_editor_date);
            this.f29871d = (TextView) view.findViewById(R.id.tv_editor_edit);
        }
    }

    /* renamed from: jz.b$b  reason: collision with other inner class name */
    public interface C0205b {
        void onClick(int i2);

        void onItemClick(int i2);
    }

    public b(Context context, ArrayList<GLImage> arrayList) {
        this.f29864a = context;
        this.f29865b = arrayList;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(int i2, View view) {
        C0205b bVar = this.f29867d;
        if (bVar != null) {
            bVar.onItemClick(i2);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(int i2, View view) {
        C0205b bVar = this.f29867d;
        if (bVar != null) {
            bVar.onClick(i2);
        }
    }

    /* renamed from: a */
    public a onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.editor_video_item, viewGroup, false));
    }

    public void a(ArrayList<GLImage> arrayList) {
        if (this.f29865b.size() > 0) {
            this.f29865b.clear();
        }
        this.f29865b.addAll(arrayList);
        notifyDataSetChanged();
    }

    /* renamed from: a */
    public void onBindViewHolder(a aVar, int i2) {
        GLImage gLImage = this.f29865b.get(i2);
        Log.i("editor", "onBindViewHolder:--path=== " + gLImage.getPath());
        aVar.f29869b.setText(c.a(TimeUtil.DEF_HH_MM_SS, gLImage.getAddTime()));
        aVar.f29870c.setText(c.a("yyyy-MM-dd", gLImage.getAddTime()));
        ((g) com.bumptech.glide.c.b(this.f29864a).j().b((int) R.drawable.placeholder_normal)).a(gLImage.getPath()).a(aVar.f29868a);
        aVar.f29871d.setOnClickListener(new View.OnClickListener(i2) {
            public final /* synthetic */ int f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                b.this.b(this.f$1, view);
            }
        });
        aVar.itemView.setOnClickListener(new View.OnClickListener(i2) {
            public final /* synthetic */ int f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                b.this.a(this.f$1, view);
            }
        });
    }

    public void a(C0205b bVar) {
        this.f29867d = bVar;
    }

    public int getItemCount() {
        return this.f29865b.size();
    }
}
