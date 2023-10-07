package la;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.cfly.uav_pro.R;
import com.flypro.core.database.PdfInfo;
import com.xeagle.android.login.retrofitLogin.UserGlobal;
import com.xeagle.android.vjoystick.IWidgets.IImageButton;
import java.util.ArrayList;

public class d extends RecyclerView.Adapter<b> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Context f30693a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<PdfInfo> f30694b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f30695c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public ProgressDialog f30696d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public a f30697e;

    public interface a {
        void setOnItemClick(int i2);
    }

    public class b extends RecyclerView.v implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        private View f30714b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public ImageView f30715c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public TextView f30716d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public TextView f30717e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public TextView f30718f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public IImageButton f30719g;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public int f30720h;

        public b(View view) {
            super(view);
            this.f30714b = view.findViewById(R.id.item_root);
            this.f30715c = (ImageView) view.findViewById(R.id.iv_pdf);
            this.f30716d = (TextView) view.findViewById(R.id.pdf_name);
            this.f30717e = (TextView) view.findViewById(R.id.pdf_flag);
            this.f30718f = (TextView) view.findViewById(R.id.pdf_size);
            this.f30719g = (IImageButton) view.findViewById(R.id.download_bt);
            this.f30714b.setOnClickListener(this);
        }

        public void onClick(View view) {
            if (view.getId() == R.id.item_root && d.this.f30697e != null) {
                d.this.f30697e.setOnItemClick(this.f30720h);
            }
        }
    }

    public d(Context context, ArrayList<PdfInfo> arrayList, boolean z2) {
        this.f30693a = context;
        this.f30694b = arrayList;
        this.f30695c = z2;
        ProgressDialog progressDialog = new ProgressDialog(context);
        this.f30696d = progressDialog;
        progressDialog.setProgressStyle(1);
        this.f30696d.setProgress(0);
    }

    private void a(String str, ImageView imageView, String str2) {
        new le.d(UserGlobal.DOWNLOAD_MANUAL_BASE_URL, new le.b() {
            public void onFail(String str) {
                Log.i("LiteHelper", "onFail: -->>>" + str);
            }

            public void onFinishDownload() {
                d.this.notifyDataSetChanged();
            }

            public void onProgress(int i2) {
            }

            public void onStartDownload() {
            }
        }).a(str, imageView, 60, 80, str2);
    }

    /* access modifiers changed from: private */
    public void a(String str, String str2, le.b bVar) {
        new le.d(UserGlobal.DOWNLOAD_MANUAL_BASE_URL, bVar).a(str, str2);
    }

    /* renamed from: a */
    public b onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new b(LayoutInflater.from(this.f30693a).inflate(R.layout.item_pdf_view, viewGroup, false));
    }

    public void a(a aVar) {
        this.f30697e = aVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x00e2, code lost:
        if (r0.isRecycled() == false) goto L_0x00e4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x010b, code lost:
        if (r0.isRecycled() == false) goto L_0x00e4;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0163  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0185  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onBindViewHolder(final la.d.b r5, final int r6) {
        /*
            r4 = this;
            int unused = r5.f30720h = r6
            android.widget.TextView r0 = r5.f30716d
            java.util.ArrayList<com.flypro.core.database.PdfInfo> r1 = r4.f30694b
            java.lang.Object r1 = r1.get(r6)
            com.flypro.core.database.PdfInfo r1 = (com.flypro.core.database.PdfInfo) r1
            java.lang.String r1 = r1.getName()
            r0.setText(r1)
            java.util.ArrayList<com.flypro.core.database.PdfInfo> r0 = r4.f30694b
            java.lang.Object r0 = r0.get(r6)
            com.flypro.core.database.PdfInfo r0 = (com.flypro.core.database.PdfInfo) r0
            java.lang.String r0 = r0.getFlag()
            if (r0 == 0) goto L_0x0061
            java.util.ArrayList<com.flypro.core.database.PdfInfo> r0 = r4.f30694b
            java.lang.Object r0 = r0.get(r6)
            com.flypro.core.database.PdfInfo r0 = (com.flypro.core.database.PdfInfo) r0
            java.lang.String r0 = r0.getFlag()
            java.lang.String r1 = "_"
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L_0x0061
            java.util.ArrayList<com.flypro.core.database.PdfInfo> r0 = r4.f30694b
            java.lang.Object r0 = r0.get(r6)
            com.flypro.core.database.PdfInfo r0 = (com.flypro.core.database.PdfInfo) r0
            java.lang.String r0 = r0.getFlag()
            int r0 = r0.indexOf(r1)
            android.widget.TextView r1 = r5.f30717e
            java.util.ArrayList<com.flypro.core.database.PdfInfo> r2 = r4.f30694b
            java.lang.Object r2 = r2.get(r6)
            com.flypro.core.database.PdfInfo r2 = (com.flypro.core.database.PdfInfo) r2
            java.lang.String r2 = r2.getFlag()
            r3 = 0
            java.lang.String r0 = r2.substring(r3, r0)
            r1.setText(r0)
            goto L_0x006a
        L_0x0061:
            android.widget.TextView r0 = r5.f30717e
            java.lang.String r1 = "CFLY2"
            r0.setText(r1)
        L_0x006a:
            android.widget.TextView r0 = r5.f30718f
            java.util.ArrayList<com.flypro.core.database.PdfInfo> r1 = r4.f30694b
            java.lang.Object r1 = r1.get(r6)
            com.flypro.core.database.PdfInfo r1 = (com.flypro.core.database.PdfInfo) r1
            java.lang.String r1 = r1.getFile_size()
            r0.setText(r1)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            android.content.Context r1 = r4.f30693a
            java.lang.String r1 = kx.d.m(r1)
            r0.append(r1)
            java.util.ArrayList<com.flypro.core.database.PdfInfo> r1 = r4.f30694b
            java.lang.Object r1 = r1.get(r6)
            com.flypro.core.database.PdfInfo r1 = (com.flypro.core.database.PdfInfo) r1
            java.lang.String r1 = r1.getName()
            r0.append(r1)
            java.lang.String r1 = ".png"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.io.File r1 = new java.io.File
            r1.<init>(r0)
            boolean r1 = r1.exists()
            if (r1 == 0) goto L_0x010e
            java.util.ArrayList<com.flypro.core.database.PdfInfo> r1 = r4.f30694b
            java.lang.Object r1 = r1.get(r6)
            com.flypro.core.database.PdfInfo r1 = (com.flypro.core.database.PdfInfo) r1
            boolean r1 = r1.isUpdate()
            java.lang.String r2 = "file://"
            if (r1 != 0) goto L_0x00ec
            boolean r1 = r4.f30695c
            if (r1 == 0) goto L_0x00c3
            goto L_0x0112
        L_0x00c3:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            android.net.Uri r0 = android.net.Uri.parse(r0)
            android.content.Context r1 = r4.f30693a
            android.graphics.Bitmap r0 = com.xeagle.android.utils.c.a((android.content.Context) r1, (android.net.Uri) r0)
            if (r0 == 0) goto L_0x0132
            boolean r1 = r0.isRecycled()
            if (r1 != 0) goto L_0x0132
        L_0x00e4:
            android.widget.ImageView r1 = r5.f30715c
            r1.setImageBitmap(r0)
            goto L_0x0132
        L_0x00ec:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            android.net.Uri r0 = android.net.Uri.parse(r0)
            android.content.Context r1 = r4.f30693a
            android.graphics.Bitmap r0 = com.xeagle.android.utils.c.a((android.content.Context) r1, (android.net.Uri) r0)
            if (r0 == 0) goto L_0x0132
            boolean r1 = r0.isRecycled()
            if (r1 != 0) goto L_0x0132
            goto L_0x00e4
        L_0x010e:
            boolean r1 = r4.f30695c
            if (r1 == 0) goto L_0x0126
        L_0x0112:
            java.util.ArrayList<com.flypro.core.database.PdfInfo> r1 = r4.f30694b
            java.lang.Object r1 = r1.get(r6)
            com.flypro.core.database.PdfInfo r1 = (com.flypro.core.database.PdfInfo) r1
            java.lang.String r1 = r1.getImage_url()
            android.widget.ImageView r2 = r5.f30715c
            r4.a((java.lang.String) r1, (android.widget.ImageView) r2, (java.lang.String) r0)
            goto L_0x0132
        L_0x0126:
            android.widget.ImageView r0 = r5.f30715c
            la.d$1 r1 = new la.d$1
            r1.<init>(r5)
            r0.post(r1)
        L_0x0132:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            android.content.Context r1 = r4.f30693a
            java.lang.String r1 = kx.d.m(r1)
            r0.append(r1)
            java.util.ArrayList<com.flypro.core.database.PdfInfo> r1 = r4.f30694b
            java.lang.Object r1 = r1.get(r6)
            com.flypro.core.database.PdfInfo r1 = (com.flypro.core.database.PdfInfo) r1
            java.lang.String r1 = r1.getName()
            r0.append(r1)
            java.lang.String r1 = ".pdf"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.io.File r1 = new java.io.File
            r1.<init>(r0)
            boolean r1 = r1.exists()
            if (r1 == 0) goto L_0x0185
            java.util.ArrayList<com.flypro.core.database.PdfInfo> r1 = r4.f30694b
            java.lang.Object r1 = r1.get(r6)
            com.flypro.core.database.PdfInfo r1 = (com.flypro.core.database.PdfInfo) r1
            boolean r1 = r1.isUpdate()
            if (r1 != 0) goto L_0x017b
            com.xeagle.android.vjoystick.IWidgets.IImageButton r1 = r5.f30719g
            la.d$2 r2 = new la.d$2
            r2.<init>(r5)
            goto L_0x018e
        L_0x017b:
            com.xeagle.android.vjoystick.IWidgets.IImageButton r1 = r5.f30719g
            la.d$3 r2 = new la.d$3
            r2.<init>(r5)
            goto L_0x018e
        L_0x0185:
            com.xeagle.android.vjoystick.IWidgets.IImageButton r1 = r5.f30719g
            la.d$4 r2 = new la.d$4
            r2.<init>(r5)
        L_0x018e:
            r1.post(r2)
            com.xeagle.android.vjoystick.IWidgets.IImageButton r1 = r5.f30719g
            la.d$5 r2 = new la.d$5
            r2.<init>(r6, r0, r5)
            r1.setOnClickListener(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: la.d.onBindViewHolder(la.d$b, int):void");
    }

    public int getItemCount() {
        if (this.f30694b.size() > 0) {
            return this.f30694b.size();
        }
        return 0;
    }

    public long getItemId(int i2) {
        return (long) i2;
    }
}
