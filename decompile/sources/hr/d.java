package hr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.huantansheng.easyphotos.R;
import com.huantansheng.easyphotos.ui.widget.PressedImageView;

public class d extends RecyclerView.Adapter<b> {

    /* renamed from: a  reason: collision with root package name */
    private LayoutInflater f13454a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public a f13455b;

    /* renamed from: c  reason: collision with root package name */
    private int f13456c = -1;

    public interface a {
        void a(int i2);
    }

    class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        PressedImageView f13459a;

        /* renamed from: b  reason: collision with root package name */
        View f13460b;

        /* renamed from: c  reason: collision with root package name */
        TextView f13461c;

        public b(View view) {
            super(view);
            this.f13459a = (PressedImageView) view.findViewById(R.id.iv_photo);
            this.f13460b = view.findViewById(R.id.v_selector);
            this.f13461c = (TextView) view.findViewById(R.id.tv_type);
        }
    }

    public d(Context context, a aVar) {
        this.f13454a = LayoutInflater.from(context);
        this.f13455b = aVar;
    }

    /* renamed from: a */
    public b onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new b(this.f13454a.inflate(R.layout.item_preview_selected_photos_easy_photos, viewGroup, false));
    }

    public void a(int i2) {
        if (this.f13456c != i2) {
            this.f13456c = i2;
            notifyDataSetChanged();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0084  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onBindViewHolder(hr.d.b r9, final int r10) {
        /*
            r8 = this;
            java.lang.String r0 = hp.a.b((int) r10)
            java.lang.String r1 = hp.a.d(r10)
            android.net.Uri r2 = hp.a.c((int) r10)
            long r3 = hp.a.e(r10)
            java.lang.String r5 = "gif"
            boolean r0 = r0.endsWith(r5)
            r6 = 0
            if (r0 != 0) goto L_0x0022
            boolean r0 = r1.endsWith(r5)
            if (r0 == 0) goto L_0x0020
            goto L_0x0022
        L_0x0020:
            r0 = 0
            goto L_0x0023
        L_0x0022:
            r0 = 1
        L_0x0023:
            boolean r5 = hq.a.f13397u
            r7 = 8
            if (r5 == 0) goto L_0x0045
            if (r0 == 0) goto L_0x0045
            hh.a r0 = hq.a.f13402z
            com.huantansheng.easyphotos.ui.widget.PressedImageView r1 = r9.f13459a
            android.content.Context r1 = r1.getContext()
            com.huantansheng.easyphotos.ui.widget.PressedImageView r3 = r9.f13459a
            r0.b(r1, r2, r3)
            android.widget.TextView r0 = r9.f13461c
            int r1 = com.huantansheng.easyphotos.R.string.gif_easy_photos
            r0.setText(r1)
        L_0x003f:
            android.widget.TextView r0 = r9.f13461c
            r0.setVisibility(r6)
            goto L_0x007a
        L_0x0045:
            boolean r0 = hq.a.f13398v
            if (r0 == 0) goto L_0x0068
            java.lang.String r0 = "video"
            boolean r0 = r1.contains(r0)
            if (r0 == 0) goto L_0x0068
            hh.a r0 = hq.a.f13402z
            com.huantansheng.easyphotos.ui.widget.PressedImageView r1 = r9.f13459a
            android.content.Context r1 = r1.getContext()
            com.huantansheng.easyphotos.ui.widget.PressedImageView r5 = r9.f13459a
            r0.a(r1, r2, r5)
            android.widget.TextView r0 = r9.f13461c
            java.lang.String r1 = hw.a.a((long) r3)
            r0.setText(r1)
            goto L_0x003f
        L_0x0068:
            hh.a r0 = hq.a.f13402z
            com.huantansheng.easyphotos.ui.widget.PressedImageView r1 = r9.f13459a
            android.content.Context r1 = r1.getContext()
            com.huantansheng.easyphotos.ui.widget.PressedImageView r3 = r9.f13459a
            r0.a(r1, r2, r3)
            android.widget.TextView r0 = r9.f13461c
            r0.setVisibility(r7)
        L_0x007a:
            int r0 = r8.f13456c
            if (r0 != r10) goto L_0x0084
            android.view.View r0 = r9.f13460b
            r0.setVisibility(r6)
            goto L_0x0089
        L_0x0084:
            android.view.View r0 = r9.f13460b
            r0.setVisibility(r7)
        L_0x0089:
            com.huantansheng.easyphotos.ui.widget.PressedImageView r9 = r9.f13459a
            hr.d$1 r0 = new hr.d$1
            r0.<init>(r10)
            r9.setOnClickListener(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: hr.d.onBindViewHolder(hr.d$b, int):void");
    }

    public int getItemCount() {
        return hp.a.e();
    }
}
