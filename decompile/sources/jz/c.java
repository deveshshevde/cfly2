package jz;

import android.content.Context;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.cfly.uav_pro.R;
import com.xeagle.android.login.pickImage.ImagePicker;
import com.xeagle.android.login.pickImage.data.GLImage;
import java.io.File;
import java.util.concurrent.TimeUnit;
import jy.a;
import kb.g;
import kx.d;

public class c extends RecyclerView.Adapter<a> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Context f29872a;

    /* renamed from: b  reason: collision with root package name */
    private jy.a f29873b;

    /* renamed from: c  reason: collision with root package name */
    private long f29874c;

    /* renamed from: d  reason: collision with root package name */
    private long f29875d = 2147483647L;

    /* renamed from: e  reason: collision with root package name */
    private int f29876e;

    /* renamed from: f  reason: collision with root package name */
    private float f29877f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public GLImage f29878g;

    /* renamed from: h  reason: collision with root package name */
    private ImagePicker f29879h;

    static class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        FrameLayout f29882a;

        /* renamed from: b  reason: collision with root package name */
        ImageView f29883b;

        /* renamed from: c  reason: collision with root package name */
        g f29884c;

        /* renamed from: d  reason: collision with root package name */
        AsyncTask<?, ?, ?> f29885d;

        a(View view) {
            super(view);
            this.f29882a = (FrameLayout) view.findViewById(R.id.thumb_layout);
            this.f29883b = (ImageView) view.findViewById(R.id.video_thumb);
        }
    }

    public c(Context context, jy.a aVar) {
        this.f29872a = context;
        this.f29873b = aVar;
        this.f29879h = ImagePicker.getInstance();
        this.f29876e = (((WindowManager) this.f29872a.getSystemService("window")).getDefaultDisplay().getWidth() - 250) - (context.getResources().getDimensionPixelOffset(R.dimen.dp_13) * 2);
    }

    public long a() {
        this.f29874c = this.f29873b.a();
        notifyDataSetChanged();
        return this.f29874c;
    }

    public long a(GLImage gLImage) {
        this.f29874c = gLImage.getDuration();
        this.f29878g = gLImage;
        notifyDataSetChanged();
        return this.f29874c;
    }

    /* renamed from: a */
    public a onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new a(LayoutInflater.from(this.f29872a).inflate(R.layout.video_thumb_item, viewGroup, false));
    }

    /* renamed from: a */
    public void onBindViewHolder(final a aVar, int i2) {
        ViewGroup.LayoutParams layoutParams = aVar.f29882a.getLayoutParams();
        layoutParams.width = this.f29876e / getItemCount();
        aVar.f29882a.setLayoutParams(layoutParams);
        String str = d.f(this.f29872a) + this.f29878g.getAddTime() + File.separator;
        if (new File(str).exists()) {
            com.bumptech.glide.c.b(this.f29872a).a(str + this.f29878g.getName()).a(aVar.f29883b);
            return;
        }
        this.f29877f = (((float) this.f29874c) / ((float) getItemCount())) / 1000.0f;
        if (aVar.f29884c != null) {
            aVar.f29884c.c();
            aVar.f29884c = null;
        }
        aVar.f29885d = this.f29873b.a(new a.C0203a() {
            public void a(g gVar, long j2) {
                if (gVar != null) {
                    aVar.f29884c = gVar;
                    aVar.f29883b.setImageBitmap(gVar.d());
                    Context a2 = c.this.f29872a;
                    com.xeagle.android.utils.c.a(d.a(a2, c.this.f29878g.getAddTime() + File.separator + c.this.f29878g.getName()), gVar.d());
                }
            }
        }, TimeUnit.SECONDS.toNanos((long) (((float) i2) * this.f29877f)));
    }

    public int getItemCount() {
        long j2 = this.f29874c;
        if (j2 == 0) {
            return 0;
        }
        long j3 = this.f29875d;
        if (((long) ((int) (j2 / 1000))) > j3) {
            return Math.round((float) (((j2 / 1000) / j3) * 3));
        }
        return 3;
    }
}
