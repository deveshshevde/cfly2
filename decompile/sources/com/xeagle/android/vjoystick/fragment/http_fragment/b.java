package com.xeagle.android.vjoystick.fragment.http_fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import ci.a;
import com.amap.api.maps.model.MyLocationStyle;
import com.blankj.utilcode.util.ToastUtils;
import com.cfly.uav_pro.R;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.liulishuo.filedownloader.q;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.login.amba.connectivity.IChannelListener;
import com.xeagle.android.login.beans.sochipBeans.SochipSdcardBean;
import com.xeagle.android.login.pickImage.data.GLImage;
import com.xeagle.android.login.retrofitLogin.CameraGlobal;
import com.xeagle.android.newUI.activity.BaseActivity;
import com.xeagle.android.utils.c;
import com.xeagle.android.vjoystick.DroneControlFragment;
import com.xeagle.android.vjoystick.fragment.c;
import com.xeagle.android.vjoystick.fragment.http_activity.HttpSdDetailActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import jo.ay;
import kotlin.jvm.internal.h;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.l;
import org.json.JSONException;
import org.json.JSONObject;

public final class b extends com.xeagle.android.fragments.a {

    /* renamed from: g  reason: collision with root package name */
    public static final a f12986g = new a((f) null);

    /* renamed from: r  reason: collision with root package name */
    private static final String f12987r = "HttpSdPhotoFragment";

    /* renamed from: h  reason: collision with root package name */
    private boolean f12988h;

    /* renamed from: i  reason: collision with root package name */
    private RecyclerView f12989i;

    /* renamed from: j  reason: collision with root package name */
    private ExGridLayoutManager f12990j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public ProgressDialog f12991k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public la.c f12992l;

    /* renamed from: m  reason: collision with root package name */
    private String f12993m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public String f12994n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public final Handler f12995o = new Handler();

    /* renamed from: p  reason: collision with root package name */
    private final ConcurrentHashMap<String, StringBuilder> f12996p = new ConcurrentHashMap<>();

    /* renamed from: q  reason: collision with root package name */
    private String f12997q = "N/A";

    /* renamed from: s  reason: collision with root package name */
    private HashMap f12998s;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* renamed from: com.xeagle.android.vjoystick.fragment.http_fragment.b$b  reason: collision with other inner class name */
    static final class C0155b implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f25206a;

        C0155b(b bVar) {
            this.f25206a = bVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            if (this.f25206a.f12542c != null) {
                this.f25206a.f12542c.k(this.f25206a.f12994n);
            }
        }
    }

    static final class c implements c.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f25207a;

        c(b bVar) {
            this.f25207a = bVar;
        }

        public final boolean a() {
            this.f25207a.f12995o.post(new Runnable(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ c f25208a;

                {
                    this.f25208a = r1;
                }

                public final void run() {
                    this.f25208a.f25207a.e();
                }
            });
            return true;
        }
    }

    static final class d implements a.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f25209a;

        d(b bVar) {
            this.f25209a = bVar;
        }

        public final void onItemClick(ci.a<Object, ci.b> aVar, View view, int i2) {
            Intent intent = new Intent(this.f25209a.getActivity(), HttpSdDetailActivity.class);
            intent.putExtra("PAGE_TYPE", "IMAGE");
            la.c a2 = this.f25209a.f12992l;
            h.a((Object) a2);
            intent.putExtra("FILE_NAME", ((lc.a) a2.getData().get(i2)).c());
            this.f25209a.requireActivity().startActivity(intent);
        }
    }

    static final class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f25210a;

        e(b bVar) {
            this.f25210a = bVar;
        }

        public final void run() {
            this.f25210a.g();
        }
    }

    public static final class f implements le.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f25211a;

        f(b bVar) {
            this.f25211a = bVar;
        }

        public void onFail(String str) {
            h.d(str, MyLocationStyle.ERROR_INFO);
        }

        public void onFinishDownload() {
            if (this.f25211a.f12991k != null) {
                ProgressDialog g2 = this.f25211a.f12991k;
                h.a((Object) g2);
                g2.dismiss();
            }
        }

        public void onProgress(int i2) {
            if (i2 == 100 && this.f25211a.f12991k != null) {
                ProgressDialog g2 = this.f25211a.f12991k;
                h.a((Object) g2);
                g2.dismiss();
            }
        }

        public void onStartDownload() {
            b bVar = this.f25211a;
            String string = bVar.f12544e.getString(R.string.push_waiting);
            h.b(string, "parent.getString(R.string.push_waiting)");
            bVar.a(string);
        }
    }

    public static final class g implements c.C0151c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f25212a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f25213b;

        g(b bVar, String str) {
            this.f25212a = bVar;
            this.f25213b = str;
        }

        public void writeFail(String str) {
            h.d(str, "msg");
        }

        public void writeSuccess() {
            BaseActivity baseActivity = this.f25212a.f12544e;
            h.b(baseActivity, "parent");
            Cursor rawQuery = com.xeagle.android.utils.c.a(baseActivity.getApplicationContext(), this.f25213b).rawQuery("select * from MediaFile", (String[]) null);
            while (rawQuery.moveToNext()) {
                String string = rawQuery.getString(rawQuery.getColumnIndex("type"));
                Log.i("Sochip", "writeSuccess: --type--" + string);
                if (h.a((Object) string, (Object) "photo_A")) {
                    long j2 = rawQuery.getLong(rawQuery.getColumnIndex(GLImage.KEY_SIZE));
                    if (j2 > 0) {
                        String string2 = rawQuery.getString(rawQuery.getColumnIndex("file"));
                        String string3 = rawQuery.getString(rawQuery.getColumnIndex("time"));
                        String a2 = kw.c.a(j2);
                        h.b(a2, "StringUtils.readableFileSize(size)");
                        h.b(string2, "fileName");
                        h.b(string3, "time");
                        new lc.a(false, a2, string2, string3, (String) null, 0, 0, 112, (f) null);
                    }
                }
            }
            if (this.f25212a.f12992l != null) {
                la.c a3 = this.f25212a.f12992l;
                h.a((Object) a3);
                a3.notifyDataSetChanged();
            }
        }
    }

    private final void a(int i2, Object obj) {
        if (i2 != 518) {
            switch (i2) {
                case 512:
                    String string = this.f12544e.getString(R.string.string_download_now);
                    h.b(string, "parent.getString(R.string.string_download_now)");
                    a(string, (DialogInterface.OnClickListener) new C0155b(this));
                    ProgressDialog progressDialog = this.f12991k;
                    h.a((Object) progressDialog);
                    Integer num = (Integer) obj;
                    h.a((Object) num);
                    progressDialog.setMax(num.intValue());
                    return;
                case IChannelListener.DATA_CHANNEL_EVENT_GET_PROGRESS:
                    ProgressDialog progressDialog2 = this.f12991k;
                    h.a((Object) progressDialog2);
                    Integer num2 = (Integer) obj;
                    h.a((Object) num2);
                    progressDialog2.setProgress(num2.intValue());
                    return;
                case IChannelListener.DATA_CHANNEL_EVENT_GET_FINISH:
                    Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.String");
                    Toast.makeText(this.f12544e, "Download to " + ((String) obj), 0).show();
                    g();
                    this.f12994n = null;
                    return;
                default:
                    return;
            }
        } else {
            a("Calculating MD5");
        }
    }

    /* access modifiers changed from: private */
    public final void a(String str) {
        g();
        ProgressDialog progressDialog = new ProgressDialog(this.f12544e);
        this.f12991k = progressDialog;
        h.a((Object) progressDialog);
        progressDialog.setTitle(this.f12544e.getString(R.string.menu_wait));
        ProgressDialog progressDialog2 = this.f12991k;
        h.a((Object) progressDialog2);
        progressDialog2.setMessage(str);
        ProgressDialog progressDialog3 = this.f12991k;
        h.a((Object) progressDialog3);
        progressDialog3.setCancelable(false);
        ProgressDialog progressDialog4 = this.f12991k;
        h.a((Object) progressDialog4);
        progressDialog4.show();
        this.f12995o.postDelayed(new e(this), 5000);
    }

    private final void a(String str, DialogInterface.OnClickListener onClickListener) {
        g();
        ProgressDialog progressDialog = new ProgressDialog(this.f12544e);
        this.f12991k = progressDialog;
        h.a((Object) progressDialog);
        progressDialog.setTitle(str);
        ProgressDialog progressDialog2 = this.f12991k;
        h.a((Object) progressDialog2);
        progressDialog2.setMax(100);
        ProgressDialog progressDialog3 = this.f12991k;
        h.a((Object) progressDialog3);
        progressDialog3.setProgressStyle(1);
        ProgressDialog progressDialog4 = this.f12991k;
        h.a((Object) progressDialog4);
        progressDialog4.setCancelable(false);
        ProgressDialog progressDialog5 = this.f12991k;
        h.a((Object) progressDialog5);
        progressDialog5.setButton(-2, this.f12544e.getString(R.string.cancel), onClickListener);
        ProgressDialog progressDialog6 = this.f12991k;
        h.a((Object) progressDialog6);
        progressDialog6.show();
    }

    private final void a(String str, String str2, le.b bVar, c.C0151c cVar) {
        new le.d(CameraGlobal.BASE_URL, bVar).a(str, str2, cVar);
    }

    private final void a(ArrayList<lc.a> arrayList) {
        List list = arrayList;
        kotlin.collections.h.c(list);
        la.c cVar = this.f12992l;
        h.a((Object) cVar);
        cVar.setNewData(list);
        g();
    }

    private final void b(int i2, Object obj) {
        if (i2 >= 80) {
            c(i2, obj);
        } else if (i2 == 40) {
            Log.i("CmdChannel", "handleCmdChannelEvent:---notification--- " + obj);
            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.String");
            String str = (String) obj;
            int hashCode = str.hashCode();
            if (hashCode != -312225049) {
                if (hashCode == 1383208497 && str.equals("Card_Removed")) {
                    this.f12988h = false;
                    la.c cVar = this.f12992l;
                    h.a((Object) cVar);
                    cVar.a();
                }
            } else if (str.equals("Card_New_Insert")) {
                String string = this.f12544e.getString(R.string.push_waiting);
                h.b(string, "parent.getString(R.string.push_waiting)");
                a(string);
                c();
            }
        } else if (i2 != 56) {
            if (i2 == 48) {
                Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f12994n = (String) obj;
            } else if (i2 == 49) {
                Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f12993m = (String) obj;
            }
        } else if (!this.f12988h) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type org.json.JSONObject");
            try {
                if (((((JSONObject) obj).getInt("info") >> 8) & 65535) == 0) {
                    this.f12988h = true;
                    ToastUtils.showShort(this.f12544e.getString(R.string.no_sd_card), new Object[0]);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    private final void c(int i2, Object obj) {
        String str;
        String str2 = "CmdChannel";
        if (i2 != 128) {
            if (i2 != 129) {
                str2 = "Error";
                if (i2 == 132) {
                    str = "Lost connection with Remote Camera!";
                } else if (i2 == 134) {
                    str = "Cannot connect to the Camera. \nPlease make sure the selected camera is on. \nIf problem persists, please reboot both camera and this device.";
                } else {
                    return;
                }
            } else {
                str = "Invalid Session! Please start session first!";
            }
            Log.i(str2, str);
            return;
        }
        Log.i(str2, "Timeout! No response from Remote Camera!---");
        ProgressDialog progressDialog = this.f12991k;
        if (progressDialog != null) {
            h.a((Object) progressDialog);
            progressDialog.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public final void e() {
        com.xeagle.android.vjoystick.fragment.c a2 = com.xeagle.android.vjoystick.fragment.c.a();
        h.b(a2, "RemoteSDDataManager.getInstance()");
        if (!a2.b()) {
            com.xeagle.android.vjoystick.fragment.c.a().a((c.b) new c(this));
            return;
        }
        ArrayList arrayList = new ArrayList();
        com.xeagle.android.vjoystick.fragment.c.a().b((List<lc.a>) arrayList);
        a((ArrayList<lc.a>) arrayList);
    }

    private final boolean f() {
        BaseActivity baseActivity = this.f12544e;
        h.b(baseActivity, "parent");
        Context applicationContext = baseActivity.getApplicationContext();
        Objects.requireNonNull(applicationContext, "null cannot be cast to non-null type com.xeagle.android.XEagleApp");
        return ((XEagleApp) applicationContext).c();
    }

    /* access modifiers changed from: private */
    public final void g() {
        ProgressDialog progressDialog = this.f12991k;
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    public void a(View view) {
        h.d(view, Promotion.ACTION_VIEW);
        this.f12993m = "";
        XEagleApp xEagleApp = this.f12540a;
        h.b(xEagleApp, "xEagleApp");
        com.xeagle.android.a m2 = xEagleApp.m();
        h.b(m2, "xEagleApp.appState");
        this.f12541b = m2.a();
        BaseActivity baseActivity = this.f12544e;
        h.b(baseActivity, "parent");
        q.a(baseActivity.getApplicationContext());
        q.a().a(1);
        Log.i("Sochip", "onViewCreated: ----camera type---" + this.f12541b);
        this.f12989i = (RecyclerView) view.findViewById(R.id.list_photo_recycler);
        BaseActivity baseActivity2 = this.f12544e;
        h.b(baseActivity2, "parent");
        this.f12990j = new ExGridLayoutManager(baseActivity2.getApplicationContext(), 4);
        RecyclerView recyclerView = this.f12989i;
        h.a((Object) recyclerView);
        recyclerView.setLayoutManager(this.f12990j);
        this.f12992l = new la.c();
        RecyclerView recyclerView2 = this.f12989i;
        h.a((Object) recyclerView2);
        recyclerView2.setAdapter(this.f12992l);
        la.c cVar = this.f12992l;
        h.a((Object) cVar);
        cVar.setOnItemClickListener(new d(this));
        if (!org.greenrobot.eventbus.c.a().b(this)) {
            org.greenrobot.eventbus.c.a().a((Object) this);
        }
    }

    public int b() {
        return R.layout.sd_photo_fragment;
    }

    public void c() {
        this.f12988h = false;
        if (DroneControlFragment.f12789g) {
            e();
        }
    }

    @l(a = ThreadMode.MAIN)
    public final void channelEvent(jo.c cVar) {
        h.d(cVar, "event");
        if (cVar.b() != null) {
            int a2 = cVar.a() & IChannelListener.MSG_MASK;
            if (a2 == 0) {
                int a3 = cVar.a();
                Object b2 = cVar.b();
                h.b(b2, "event.param");
                b(a3, b2);
            } else if (a2 == 512) {
                int a4 = cVar.a();
                Object b3 = cVar.b();
                h.b(b3, "event.param");
                a(a4, b3);
            }
        }
    }

    public void d() {
        HashMap hashMap = this.f12998s;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        ProgressDialog progressDialog = this.f12991k;
        if (progressDialog != null) {
            h.a((Object) progressDialog);
            if (progressDialog.isShowing()) {
                ProgressDialog progressDialog2 = this.f12991k;
                h.a((Object) progressDialog2);
                progressDialog2.dismiss();
            }
        }
        q.a().b();
        q.a().e();
        if (org.greenrobot.eventbus.c.a().b(this)) {
            org.greenrobot.eventbus.c.a().c(this);
        }
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        d();
    }

    public void onPause() {
        super.onPause();
        if (f()) {
            XEagleApp xEagleApp = this.f12540a;
            h.b(xEagleApp, "xEagleApp");
            xEagleApp.e().b(f12987r);
        }
    }

    public void onResume() {
        super.onResume();
        c();
    }

    @l(a = ThreadMode.BACKGROUND)
    public final void onTcpErrorEvent(ay ayVar) {
        if (this.f12541b == 1 && this.f12542c != null) {
            this.f12542c.b();
            this.f12542c.e();
        }
    }

    @l(a = ThreadMode.MAIN)
    public final void socSuccessEvent(jp.f fVar) {
        h.d(fVar, "event");
        Log.i("Sochip", "socSuccessEvent:---- " + fVar.a());
        if (fVar.a() == 2004) {
            Log.i("Sochip", "socSuccessEvent: ----getSdcard");
            Object b2 = fVar.b();
            Objects.requireNonNull(b2, "null cannot be cast to non-null type com.xeagle.android.login.beans.sochipBeans.SochipSdcardBean");
            if (((SochipSdcardBean) b2).getDisk_status() == 0) {
                StringBuilder sb = new StringBuilder();
                BaseActivity baseActivity = this.f12544e;
                h.b(baseActivity, "parent");
                sb.append(kx.d.e(baseActivity.getApplicationContext()));
                sb.append("sunxi.db");
                String sb2 = sb.toString();
                a(CameraGlobal.HTTP_FILE, sb2, new f(this), new g(this, sb2));
                return;
            }
            Toast.makeText(this.f12544e, this.f12544e.getString(R.string.no_sd_card), 0).show();
            g();
        }
    }
}
