package hr;

import android.content.Context;
import android.content.Intent;
import android.graphics.PointF;
import android.net.Uri;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.github.chrisbanes.photoview.PhotoView;
import com.github.chrisbanes.photoview.g;
import com.huantansheng.easyphotos.R;
import com.huantansheng.easyphotos.models.album.entity.Photo;
import java.util.ArrayList;

public class c extends RecyclerView.Adapter<b> {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<Photo> f13440a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public a f13441b;

    /* renamed from: c  reason: collision with root package name */
    private LayoutInflater f13442c;

    public interface a {
        void a();

        void b();
    }

    public class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        public SubsamplingScaleImageView f13450a;

        /* renamed from: b  reason: collision with root package name */
        ImageView f13451b;

        /* renamed from: c  reason: collision with root package name */
        PhotoView f13452c;

        b(View view) {
            super(view);
            this.f13450a = (SubsamplingScaleImageView) view.findViewById(R.id.iv_long_photo);
            this.f13452c = (PhotoView) view.findViewById(R.id.iv_photo_view);
            this.f13451b = (ImageView) view.findViewById(R.id.iv_play);
        }
    }

    public c(Context context, ArrayList<Photo> arrayList, a aVar) {
        this.f13440a = arrayList;
        this.f13442c = LayoutInflater.from(context);
        this.f13441b = aVar;
    }

    /* access modifiers changed from: private */
    public void a(View view, Uri uri, String str) {
        Context context = view.getContext();
        Intent intent = new Intent("android.intent.action.VIEW");
        if (Build.VERSION.SDK_INT >= 24) {
            intent.addFlags(1);
            intent.addFlags(2);
        }
        intent.setDataAndType(uri, str);
        context.startActivity(intent);
    }

    /* renamed from: a */
    public b onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new b(this.f13442c.inflate(R.layout.item_preview_photo_easy_photos, viewGroup, false));
    }

    /* renamed from: a */
    public void onBindViewHolder(b bVar, int i2) {
        final Uri uri = this.f13440a.get(i2).f20301a;
        String str = this.f13440a.get(i2).f20303c;
        final String str2 = this.f13440a.get(i2).f20304d;
        double d2 = (double) this.f13440a.get(i2).f20306f;
        double d3 = (double) this.f13440a.get(i2).f20305e;
        Double.isNaN(d2);
        Double.isNaN(d3);
        double d4 = d2 / d3;
        bVar.f13451b.setVisibility(8);
        bVar.f13452c.setVisibility(8);
        bVar.f13450a.setVisibility(8);
        if (str2.contains("video")) {
            bVar.f13452c.setVisibility(0);
            hq.a.f13402z.a(bVar.f13452c.getContext(), uri, bVar.f13452c);
            bVar.f13451b.setVisibility(0);
            bVar.f13451b.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    c.this.a(view, uri, str2);
                }
            });
        } else if (str.endsWith("gif") || str2.endsWith("gif")) {
            bVar.f13452c.setVisibility(0);
            hq.a.f13402z.c(bVar.f13452c.getContext(), uri, bVar.f13452c);
        } else if (d4 > 2.3d) {
            bVar.f13450a.setVisibility(0);
            bVar.f13450a.setImage(ImageSource.uri(str));
        } else {
            bVar.f13452c.setVisibility(0);
            hq.a.f13402z.a(bVar.f13452c.getContext(), uri, bVar.f13452c);
        }
        bVar.f13450a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                c.this.f13441b.a();
            }
        });
        bVar.f13452c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                c.this.f13441b.a();
            }
        });
        bVar.f13450a.setOnStateChangedListener(new SubsamplingScaleImageView.OnStateChangedListener() {
            public void onCenterChanged(PointF pointF, int i2) {
            }

            public void onScaleChanged(float f2, int i2) {
                c.this.f13441b.b();
            }
        });
        bVar.f13452c.setScale(1.0f);
        bVar.f13452c.setOnScaleChangeListener(new g() {
            public void a(float f2, float f3, float f4) {
                c.this.f13441b.b();
            }
        });
    }

    public int getItemCount() {
        return this.f13440a.size();
    }
}
