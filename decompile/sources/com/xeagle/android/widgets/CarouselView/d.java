package com.xeagle.android.widgets.CarouselView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.h;
import com.android.volley.toolbox.l;
import com.cfly.uav_pro.R;
import java.util.ArrayList;

public class d extends RecyclerView.Adapter<b> {

    /* renamed from: a  reason: collision with root package name */
    private Context f25547a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<f> f25548b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public a f25549c;

    /* renamed from: d  reason: collision with root package name */
    private LayoutInflater f25550d;

    /* renamed from: e  reason: collision with root package name */
    private h f25551e;

    /* renamed from: f  reason: collision with root package name */
    private com.android.volley.toolbox.h f25552f;

    public interface a {
        void a(View view, int i2);
    }

    public static class b extends RecyclerView.v {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public ImageView f25556a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public TextView f25557b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public TextView f25558c;

        public b(View view) {
            super(view);
        }
    }

    public d(Context context, ArrayList<f> arrayList) {
        this.f25547a = context;
        this.f25548b = arrayList;
        this.f25550d = LayoutInflater.from(context);
        h a2 = l.a(context);
        this.f25551e = a2;
        this.f25552f = new com.android.volley.toolbox.h(a2, new b());
    }

    /* renamed from: a */
    public b onCreateViewHolder(ViewGroup viewGroup, int i2) {
        View inflate = this.f25550d.inflate(R.layout.carview, viewGroup, false);
        b bVar = new b(inflate);
        ImageView unused = bVar.f25556a = (ImageView) inflate.findViewById(R.id.f14096iv);
        TextView unused2 = bVar.f25558c = (TextView) inflate.findViewById(R.id.time);
        TextView unused3 = bVar.f25557b = (TextView) inflate.findViewById(R.id.iv_dec);
        return bVar;
    }

    public void a(a aVar) {
        this.f25549c = aVar;
    }

    /* renamed from: a */
    public void onBindViewHolder(final b bVar, final int i2) {
        String a2 = this.f25548b.get(i2).a();
        String d2 = this.f25548b.get(i2).d();
        String c2 = this.f25548b.get(i2).c();
        this.f25552f.a(a2, com.android.volley.toolbox.h.a(bVar.f25556a, (int) R.drawable.ic_launcher, (int) R.drawable.ic_launcher), 960, 960);
        bVar.f25558c.setText(d2);
        bVar.f25557b.setText(c2);
        if (this.f25549c != null) {
            bVar.itemView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    d.this.f25549c.a(bVar.itemView, i2);
                }
            });
        }
    }

    public int getItemCount() {
        return this.f25548b.size();
    }
}
