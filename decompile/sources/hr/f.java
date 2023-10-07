package hr;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.huantansheng.easyphotos.R;
import com.huantansheng.easyphotos.models.album.entity.Photo;
import java.util.ArrayList;

public class f extends RecyclerView.Adapter {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<Photo> f13471a;

    /* renamed from: b  reason: collision with root package name */
    private LayoutInflater f13472b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public a f13473c;

    public interface a {
        void a(int i2);
    }

    public class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        ImageView f13476a;

        /* renamed from: b  reason: collision with root package name */
        TextView f13477b;

        public b(View view) {
            super(view);
            this.f13476a = (ImageView) view.findViewById(R.id.iv_photo);
            this.f13477b = (TextView) view.findViewById(R.id.tv_type);
        }
    }

    public f(Context context, ArrayList<Photo> arrayList, a aVar) {
        this.f13471a = arrayList;
        this.f13473c = aVar;
        this.f13472b = LayoutInflater.from(context);
    }

    public int getItemCount() {
        ArrayList<Photo> arrayList = this.f13471a;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public void onBindViewHolder(RecyclerView.v vVar, final int i2) {
        b bVar;
        Photo photo = this.f13471a.get(i2);
        String str = photo.f20303c;
        String str2 = photo.f20304d;
        Uri uri = photo.f20301a;
        long j2 = photo.f20309i;
        boolean z2 = str.endsWith("gif") || str2.endsWith("gif");
        if (hq.a.f13397u && z2) {
            bVar = (b) vVar;
            hq.a.f13402z.b(bVar.f13476a.getContext(), uri, bVar.f13476a);
            bVar.f13477b.setText(R.string.gif_easy_photos);
        } else if (!hq.a.f13398v || !str2.contains("video")) {
            b bVar2 = (b) vVar;
            hq.a.f13402z.a(bVar2.f13476a.getContext(), uri, bVar2.f13476a);
            bVar2.f13477b.setVisibility(8);
            ((b) vVar).f13476a.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    f.this.f13473c.a(i2);
                }
            });
        } else {
            bVar = (b) vVar;
            hq.a.f13402z.a(bVar.f13476a.getContext(), uri, bVar.f13476a);
            bVar.f13477b.setText(hw.a.a(j2));
        }
        bVar.f13477b.setVisibility(0);
        ((b) vVar).f13476a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                f.this.f13473c.a(i2);
            }
        });
    }

    public RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new b(this.f13472b.inflate(R.layout.item_puzzle_selector_easy_photos, viewGroup, false));
    }
}
