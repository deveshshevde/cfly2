package hr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.huantansheng.easyphotos.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class a extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<Object> f13403a;

    /* renamed from: b  reason: collision with root package name */
    private LayoutInflater f13404b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public int f13405c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public b f13406d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public int f13407e = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f13408f = 0;

    /* renamed from: g  reason: collision with root package name */
    private boolean f13409g = false;

    /* renamed from: hr.a$a  reason: collision with other inner class name */
    public class C0097a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        ImageView f13412a;

        /* renamed from: b  reason: collision with root package name */
        TextView f13413b;

        /* renamed from: c  reason: collision with root package name */
        TextView f13414c;

        /* renamed from: d  reason: collision with root package name */
        ImageView f13415d;

        /* renamed from: e  reason: collision with root package name */
        ConstraintLayout f13416e;

        C0097a(View view) {
            super(view);
            this.f13412a = (ImageView) view.findViewById(R.id.iv_album_cover);
            this.f13413b = (TextView) view.findViewById(R.id.tv_album_name);
            this.f13414c = (TextView) view.findViewById(R.id.tv_album_photos_count);
            this.f13415d = (ImageView) view.findViewById(R.id.iv_selected);
            this.f13416e = (ConstraintLayout) view.findViewById(R.id.m_root_view);
        }
    }

    public interface b {
        void a(int i2, int i3);
    }

    public a(Context context, ArrayList<Object> arrayList, int i2, b bVar) {
        this.f13403a = arrayList;
        this.f13404b = LayoutInflater.from(context);
        this.f13406d = bVar;
        this.f13405c = i2;
    }

    public void a() {
        this.f13409g = true;
        notifyDataSetChanged();
    }

    public void a(int i2) {
        int i3 = (!hq.a.d() || i2 <= this.f13407e) ? i2 : i2 - 1;
        int i4 = this.f13405c;
        this.f13405c = i2;
        notifyItemChanged(i4);
        notifyItemChanged(i2);
        this.f13406d.a(i2, i3);
    }

    public int getItemCount() {
        return this.f13403a.size();
    }

    public int getItemViewType(int i2) {
        Object obj = this.f13403a.get(i2);
        return (obj == null || (obj instanceof WeakReference)) ? 0 : 1;
    }

    public void onBindViewHolder(RecyclerView.v vVar, final int i2) {
        View view;
        ImageView imageView;
        int i3 = 0;
        if (vVar instanceof C0097a) {
            if (this.f13408f == 0) {
                this.f13408f = ((C0097a) vVar).f13416e.getPaddingLeft();
            }
            if (i2 == getItemCount() - 1) {
                ConstraintLayout constraintLayout = ((C0097a) vVar).f13416e;
                int i4 = this.f13408f;
                constraintLayout.setPadding(i4, i4, i4, i4);
            } else {
                ConstraintLayout constraintLayout2 = ((C0097a) vVar).f13416e;
                int i5 = this.f13408f;
                constraintLayout2.setPadding(i5, i5, i5, 0);
            }
            com.huantansheng.easyphotos.models.album.entity.b bVar = (com.huantansheng.easyphotos.models.album.entity.b) this.f13403a.get(i2);
            C0097a aVar = (C0097a) vVar;
            hq.a.f13402z.a(aVar.f13412a.getContext(), bVar.f20318d, aVar.f13412a);
            aVar.f13413b.setText(bVar.f20315a);
            aVar.f13414c.setText(String.valueOf(bVar.f20319e.size()));
            if (this.f13405c == i2) {
                imageView = aVar.f13415d;
            } else {
                imageView = aVar.f13415d;
                i3 = 4;
            }
            imageView.setVisibility(i3);
            vVar.itemView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    int i2 = i2;
                    if (hq.a.d() && i2 > a.this.f13407e) {
                        i2--;
                    }
                    int b2 = a.this.f13405c;
                    int unused = a.this.f13405c = i2;
                    a.this.notifyItemChanged(b2);
                    a.this.notifyItemChanged(i2);
                    a.this.f13406d.a(i2, i2);
                }
            });
        } else if (!(vVar instanceof hi.b)) {
        } else {
            if (this.f13409g) {
                hi.b bVar2 = (hi.b) vVar;
                bVar2.f13325a.removeAllViews();
                bVar2.f13325a.setVisibility(8);
                return;
            }
            this.f13407e = i2;
            if (!hq.a.f13384h) {
                ((hi.b) vVar).f13325a.setVisibility(8);
                return;
            }
            WeakReference weakReference = (WeakReference) this.f13403a.get(i2);
            if (weakReference != null && (view = (View) weakReference.get()) != null) {
                if (view.getParent() != null && (view.getParent() instanceof FrameLayout)) {
                    ((FrameLayout) view.getParent()).removeAllViews();
                }
                hi.b bVar3 = (hi.b) vVar;
                bVar3.f13325a.setVisibility(0);
                bVar3.f13325a.removeAllViews();
                bVar3.f13325a.addView(view);
            }
        }
    }

    public RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return i2 != 0 ? new C0097a(this.f13404b.inflate(R.layout.item_dialog_album_items_easy_photos, viewGroup, false)) : new hi.b(this.f13404b.inflate(R.layout.item_ad_easy_photos, viewGroup, false));
    }
}
