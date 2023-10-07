package com.xeagle.android.vjoystick.fragment.http_fragment;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.ButterKnife;
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
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.l;
import org.json.JSONException;
import org.json.JSONObject;

public final class c extends com.xeagle.android.fragments.a {

    /* renamed from: g  reason: collision with root package name */
    public static final a f12999g = new a((f) null);

    /* renamed from: v  reason: collision with root package name */
    private static final String f13000v = "HttpSdVideoFragment";

    /* renamed from: h  reason: collision with root package name */
    private RecyclerView f13001h;

    /* renamed from: i  reason: collision with root package name */
    private FrameLayout f13002i;

    /* renamed from: j  reason: collision with root package name */
    private ExGridLayoutManager f13003j;

    /* renamed from: k  reason: collision with root package name */
    private la.c f13004k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public ProgressDialog f13005l;

    /* renamed from: m  reason: collision with root package name */
    private String f13006m;

    /* renamed from: n  reason: collision with root package name */
    private String f13007n;

    /* renamed from: o  reason: collision with root package name */
    private final boolean f13008o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public String f13009p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public final Handler f13010q = new Handler();

    /* renamed from: r  reason: collision with root package name */
    private boolean f13011r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f13012s;

    /* renamed from: t  reason: collision with root package name */
    private String f13013t = "N/A";

    /* renamed from: u  reason: collision with root package name */
    private final ConcurrentHashMap<String, StringBuilder> f13014u = new ConcurrentHashMap<>();

    /* renamed from: w  reason: collision with root package name */
    private HashMap f13015w;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    static final class b implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f25214a;

        b(c cVar) {
            this.f25214a = cVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            if (this.f25214a.f12542c != null) {
                this.f25214a.f12542c.k(this.f25214a.f13009p);
            }
        }
    }

    /* renamed from: com.xeagle.android.vjoystick.fragment.http_fragment.c$c  reason: collision with other inner class name */
    static final class C0156c implements c.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f25215a;

        C0156c(c cVar) {
            this.f25215a = cVar;
        }

        public final boolean a() {
            this.f25215a.f13010q.post(new Runnable(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ C0156c f25216a;

                {
                    this.f25216a = r1;
                }

                public final void run() {
                    this.f25216a.f25215a.g();
                }
            });
            return true;
        }
    }

    static final class d implements a.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f25217a;

        d(c cVar) {
            this.f25217a = cVar;
        }

        public final void onItemClick(ci.a<Object, ci.b> aVar, View view, int i2) {
            Intent intent = new Intent(this.f25217a.getActivity(), HttpSdDetailActivity.class);
            intent.putExtra("PAGE_TYPE", "VIDEO");
            la.c d2 = this.f25217a.d();
            kotlin.jvm.internal.h.a((Object) d2);
            intent.putExtra("FILE_NAME", ((lc.a) d2.getData().get(i2)).c());
            this.f25217a.requireActivity().startActivity(intent);
        }
    }

    public static final class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f25218a;

        e(c cVar) {
            this.f25218a = cVar;
        }

        public void run() {
            this.f25218a.h();
        }
    }

    public static final class f implements le.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f25219a;

        f(c cVar) {
            this.f25219a = cVar;
        }

        public void onFail(String str) {
            kotlin.jvm.internal.h.d(str, MyLocationStyle.ERROR_INFO);
        }

        public void onFinishDownload() {
            if (this.f25219a.f13005l != null) {
                ProgressDialog f2 = this.f25219a.f13005l;
                kotlin.jvm.internal.h.a((Object) f2);
                f2.dismiss();
            }
        }

        public void onProgress(int i2) {
            if (i2 == 100 && this.f25219a.f13005l != null) {
                ProgressDialog f2 = this.f25219a.f13005l;
                kotlin.jvm.internal.h.a((Object) f2);
                f2.dismiss();
            }
        }

        public void onStartDownload() {
            c cVar = this.f25219a;
            String string = cVar.f12544e.getString(R.string.push_waiting);
            kotlin.jvm.internal.h.b(string, "parent.getString(R.string.push_waiting)");
            cVar.a(string);
        }
    }

    public static final class g implements c.C0151c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f25220a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f25221b;

        g(c cVar, String str) {
            this.f25220a = cVar;
            this.f25221b = str;
        }

        public void writeFail(String str) {
            kotlin.jvm.internal.h.d(str, "msg");
        }

        public void writeSuccess() {
            BaseActivity baseActivity = this.f25220a.f12544e;
            kotlin.jvm.internal.h.b(baseActivity, "parent");
            Cursor rawQuery = com.xeagle.android.utils.c.a(baseActivity.getApplicationContext(), this.f25221b).rawQuery("select * from MediaFile", (String[]) null);
            while (rawQuery.moveToNext()) {
                String string = rawQuery.getString(rawQuery.getColumnIndex("type"));
                String string2 = rawQuery.getString(rawQuery.getColumnIndex("file"));
                if (kotlin.jvm.internal.h.a((Object) "video_A", (Object) string)) {
                    kotlin.jvm.internal.h.b(string2, "fileName");
                    if (!kotlin.text.f.a((CharSequence) string2, (CharSequence) "ths", false, 2, (Object) null)) {
                        long j2 = rawQuery.getLong(rawQuery.getColumnIndex(GLImage.KEY_SIZE));
                        if (j2 > 0) {
                            String string3 = rawQuery.getString(rawQuery.getColumnIndex("time"));
                            String a2 = kw.c.a(j2);
                            kotlin.jvm.internal.h.b(a2, "StringUtils.readableFileSize(size)");
                            kotlin.jvm.internal.h.b(string3, "time");
                            lc.a aVar = new lc.a(false, a2, string2, string3, (String) null, 0, 0, 112, (f) null);
                            la.c d2 = this.f25220a.d();
                            kotlin.jvm.internal.h.a((Object) d2);
                            d2.addData(aVar);
                        }
                    }
                }
            }
        }
    }

    public static final class h implements le.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f25222a;

        h(c cVar) {
            this.f25222a = cVar;
        }

        public void onFail(String str) {
            kotlin.jvm.internal.h.d(str, MyLocationStyle.ERROR_INFO);
        }

        public void onFinishDownload() {
            if (this.f25222a.f13005l != null) {
                ProgressDialog f2 = this.f25222a.f13005l;
                kotlin.jvm.internal.h.a((Object) f2);
                f2.dismiss();
            }
        }

        public void onProgress(int i2) {
            if (i2 == 100 && this.f25222a.f13005l != null) {
                ProgressDialog f2 = this.f25222a.f13005l;
                kotlin.jvm.internal.h.a((Object) f2);
                f2.dismiss();
            }
        }

        public void onStartDownload() {
            c cVar = this.f25222a;
            String string = cVar.f12544e.getString(R.string.push_waiting);
            kotlin.jvm.internal.h.b(string, "parent.getString(R.string.push_waiting)");
            cVar.a(string);
        }
    }

    public static final class i implements c.C0151c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f25223a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f25224b;

        i(c cVar, String str) {
            this.f25223a = cVar;
            this.f25224b = str;
        }

        public void writeFail(String str) {
            kotlin.jvm.internal.h.d(str, "msg");
        }

        public void writeSuccess() {
            BaseActivity baseActivity = this.f25223a.f12544e;
            kotlin.jvm.internal.h.b(baseActivity, "parent");
            Cursor rawQuery = com.xeagle.android.utils.c.a(baseActivity.getApplicationContext(), this.f25224b).rawQuery("select * from MediaFile", (String[]) null);
            while (rawQuery.moveToNext()) {
                String string = rawQuery.getString(rawQuery.getColumnIndex("type"));
                String string2 = rawQuery.getString(rawQuery.getColumnIndex("file"));
                if (kotlin.jvm.internal.h.a((Object) "video_A", (Object) string)) {
                    kotlin.jvm.internal.h.b(string2, "fileName");
                    if (!kotlin.text.f.a((CharSequence) string2, (CharSequence) "ths", false, 2, (Object) null)) {
                        long j2 = rawQuery.getLong(rawQuery.getColumnIndex(GLImage.KEY_SIZE));
                        if (j2 > 0) {
                            String string3 = rawQuery.getString(rawQuery.getColumnIndex("time"));
                            String a2 = kw.c.a(j2);
                            kotlin.jvm.internal.h.b(a2, "StringUtils.readableFileSize(size)");
                            kotlin.jvm.internal.h.b(string3, "time");
                            lc.a aVar = new lc.a(false, a2, string2, string3, (String) null, 0, 0, 112, (f) null);
                            la.c d2 = this.f25223a.d();
                            kotlin.jvm.internal.h.a((Object) d2);
                            d2.addData(aVar);
                        }
                    }
                }
            }
        }
    }

    private final void a(int i2, Object obj) {
        if (i2 != 518) {
            switch (i2) {
                case 512:
                    Log.e("CmdChannel", "handleDataChannelEvent: ----handle download progress");
                    a(this.f13008o ? "Please wait ..." : "Downloading ...", (DialogInterface.OnClickListener) new b(this));
                    ProgressDialog progressDialog = this.f13005l;
                    kotlin.jvm.internal.h.a((Object) progressDialog);
                    Integer num = (Integer) obj;
                    kotlin.jvm.internal.h.a((Object) num);
                    progressDialog.setMax(num.intValue());
                    return;
                case IChannelListener.DATA_CHANNEL_EVENT_GET_PROGRESS:
                    ProgressDialog progressDialog2 = this.f13005l;
                    if (progressDialog2 != null) {
                        kotlin.jvm.internal.h.a((Object) progressDialog2);
                        Integer num2 = (Integer) obj;
                        kotlin.jvm.internal.h.a((Object) num2);
                        progressDialog2.setProgress(num2.intValue());
                        return;
                    }
                    return;
                case IChannelListener.DATA_CHANNEL_EVENT_GET_FINISH:
                    Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.String");
                    Toast.makeText(this.f12544e, "Download to " + ((String) obj), 0).show();
                    h();
                    this.f13009p = null;
                    return;
                default:
                    return;
            }
        } else {
            a("Calculating MD5");
        }
    }

    private final void a(int i2, Object obj, String... strArr) {
        if (i2 >= 80) {
            b(i2, obj);
        } else if (i2 == 4) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.String");
            Log.i("Warning", (String) obj);
        } else if (i2 == 33) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f13006m = (String) obj;
        } else if (i2 == 40) {
            Log.i("CmdChannel", "handleCmdChannelEvent:---notification--- " + obj);
            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.String");
            String str = (String) obj;
            int hashCode = str.hashCode();
            if (hashCode != -312225049) {
                if (hashCode == 1383208497 && str.equals("Card_Removed")) {
                    this.f13012s = false;
                    this.f13011r = false;
                    la.c cVar = this.f13004k;
                    kotlin.jvm.internal.h.a((Object) cVar);
                    cVar.a();
                }
            } else if (str.equals("Card_New_Insert")) {
                this.f13011r = true;
                String string = this.f12544e.getString(R.string.push_waiting);
                kotlin.jvm.internal.h.b(string, "parent.getString(R.string.push_waiting)");
                a(string);
                c();
            }
        } else if (i2 != 56) {
            if (i2 == 48) {
                Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f13009p = (String) obj;
            } else if (i2 == 49) {
                Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f13007n = (String) obj;
                Log.i("CmdChannel", "handleCmdChannelEvent: --del position--" + this.f13007n);
            }
        } else if (!this.f13012s) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type org.json.JSONObject");
            try {
                if (((((JSONObject) obj).getInt("info") >> 8) & 65535) == 0) {
                    this.f13012s = true;
                    ToastUtils.showShort(this.f12544e.getString(R.string.no_sd_card), new Object[0]);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void a(String str) {
        h();
        ProgressDialog progressDialog = new ProgressDialog(this.f12544e);
        this.f13005l = progressDialog;
        kotlin.jvm.internal.h.a((Object) progressDialog);
        progressDialog.setTitle(this.f12544e.getString(R.string.menu_wait));
        ProgressDialog progressDialog2 = this.f13005l;
        kotlin.jvm.internal.h.a((Object) progressDialog2);
        progressDialog2.setMessage(str);
        ProgressDialog progressDialog3 = this.f13005l;
        kotlin.jvm.internal.h.a((Object) progressDialog3);
        progressDialog3.setCancelable(false);
        ProgressDialog progressDialog4 = this.f13005l;
        kotlin.jvm.internal.h.a((Object) progressDialog4);
        progressDialog4.show();
        this.f13010q.postDelayed(new e(this), 5000);
    }

    private final void a(String str, DialogInterface.OnClickListener onClickListener) {
        h();
        ProgressDialog progressDialog = new ProgressDialog(this.f12544e);
        this.f13005l = progressDialog;
        kotlin.jvm.internal.h.a((Object) progressDialog);
        progressDialog.setTitle(str);
        ProgressDialog progressDialog2 = this.f13005l;
        kotlin.jvm.internal.h.a((Object) progressDialog2);
        progressDialog2.setMax(100);
        ProgressDialog progressDialog3 = this.f13005l;
        kotlin.jvm.internal.h.a((Object) progressDialog3);
        progressDialog3.setProgressStyle(1);
        ProgressDialog progressDialog4 = this.f13005l;
        kotlin.jvm.internal.h.a((Object) progressDialog4);
        progressDialog4.setCancelable(false);
        ProgressDialog progressDialog5 = this.f13005l;
        kotlin.jvm.internal.h.a((Object) progressDialog5);
        progressDialog5.setButton(-2, this.f12544e.getString(R.string.cancel), onClickListener);
        ProgressDialog progressDialog6 = this.f13005l;
        kotlin.jvm.internal.h.a((Object) progressDialog6);
        progressDialog6.show();
    }

    private final void a(String str, String str2, le.b bVar, c.C0151c cVar) {
        new le.d(CameraGlobal.BASE_URL, bVar).a(str, str2, cVar);
    }

    private final void a(ArrayList<lc.a> arrayList) {
        List list = arrayList;
        kotlin.collections.h.c(list);
        la.c cVar = this.f13004k;
        kotlin.jvm.internal.h.a((Object) cVar);
        cVar.setNewData(list);
        h();
    }

    private final void b(int i2, Object obj) {
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
        ProgressDialog progressDialog = this.f13005l;
        if (progressDialog != null) {
            kotlin.jvm.internal.h.a((Object) progressDialog);
            progressDialog.dismiss();
        }
    }

    private final boolean f() {
        BaseActivity baseActivity = this.f12544e;
        kotlin.jvm.internal.h.b(baseActivity, "parent");
        Context applicationContext = baseActivity.getApplicationContext();
        Objects.requireNonNull(applicationContext, "null cannot be cast to non-null type com.xeagle.android.XEagleApp");
        return ((XEagleApp) applicationContext).c();
    }

    /* access modifiers changed from: private */
    public final void g() {
        com.xeagle.android.vjoystick.fragment.c a2 = com.xeagle.android.vjoystick.fragment.c.a();
        kotlin.jvm.internal.h.b(a2, "RemoteSDDataManager.getInstance()");
        if (!a2.b()) {
            com.xeagle.android.vjoystick.fragment.c.a().a((c.b) new C0156c(this));
            return;
        }
        ArrayList arrayList = new ArrayList();
        com.xeagle.android.vjoystick.fragment.c.a().a((List<lc.a>) arrayList);
        a((ArrayList<lc.a>) arrayList);
    }

    /* access modifiers changed from: private */
    public final void h() {
        ProgressDialog progressDialog = this.f13005l;
        if (progressDialog != null) {
            kotlin.jvm.internal.h.a((Object) progressDialog);
            progressDialog.dismiss();
        }
    }

    public void a(View view) {
        kotlin.jvm.internal.h.d(view, Promotion.ACTION_VIEW);
        ButterKnife.bind((Object) this, view);
        XEagleApp xEagleApp = this.f12540a;
        kotlin.jvm.internal.h.b(xEagleApp, "xEagleApp");
        com.xeagle.android.a m2 = xEagleApp.m();
        kotlin.jvm.internal.h.b(m2, "xEagleApp.appState");
        this.f12541b = m2.a();
        BaseActivity baseActivity = this.f12544e;
        kotlin.jvm.internal.h.b(baseActivity, "parent");
        q.a(baseActivity.getApplicationContext());
        q.a().a(1);
        this.f13006m = "";
        this.f13007n = "";
        this.f13001h = (RecyclerView) view.findViewById(R.id.list_item_recycler);
        this.f13002i = (FrameLayout) view.findViewById(R.id.video_full_container);
        BaseActivity baseActivity2 = this.f12544e;
        kotlin.jvm.internal.h.b(baseActivity2, "parent");
        this.f13003j = new ExGridLayoutManager(baseActivity2.getApplicationContext(), 2);
        RecyclerView recyclerView = this.f13001h;
        kotlin.jvm.internal.h.a((Object) recyclerView);
        recyclerView.setLayoutManager(this.f13003j);
        this.f13004k = new la.c();
        RecyclerView recyclerView2 = this.f13001h;
        kotlin.jvm.internal.h.a((Object) recyclerView2);
        recyclerView2.setAdapter(this.f13004k);
        la.c cVar = this.f13004k;
        kotlin.jvm.internal.h.a((Object) cVar);
        cVar.setOnItemClickListener(new d(this));
        if (!org.greenrobot.eventbus.c.a().b(this)) {
            org.greenrobot.eventbus.c.a().a((Object) this);
        }
    }

    public int b() {
        return R.layout.sd_video_fragment;
    }

    public void c() {
        this.f13012s = false;
        if (DroneControlFragment.f12789g) {
            g();
        }
    }

    @l(a = ThreadMode.MAIN)
    public final void channelEvent(jo.c cVar) {
        kotlin.jvm.internal.h.d(cVar, "event");
        if (cVar.b() != null) {
            int a2 = cVar.a() & IChannelListener.MSG_MASK;
            if (a2 == 0) {
                int a3 = cVar.a();
                Object b2 = cVar.b();
                kotlin.jvm.internal.h.b(b2, "event.param");
                a(a3, b2, new String[0]);
            } else if (a2 == 512) {
                int a4 = cVar.a();
                Object b3 = cVar.b();
                kotlin.jvm.internal.h.b(b3, "event.param");
                a(a4, b3);
            }
        }
    }

    public final la.c d() {
        return this.f13004k;
    }

    public void e() {
        HashMap hashMap = this.f13015w;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public void onAttach(Activity activity) {
        kotlin.jvm.internal.h.d(activity, "activity");
        super.onAttach(activity);
        this.f12544e = (BaseActivity) activity;
    }

    public void onDestroy() {
        super.onDestroy();
        ProgressDialog progressDialog = this.f13005l;
        if (progressDialog != null) {
            kotlin.jvm.internal.h.a((Object) progressDialog);
            if (progressDialog.isShowing()) {
                ProgressDialog progressDialog2 = this.f13005l;
                kotlin.jvm.internal.h.a((Object) progressDialog2);
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
        e();
    }

    public void onPause() {
        super.onPause();
        if (f()) {
            XEagleApp xEagleApp = this.f12540a;
            kotlin.jvm.internal.h.b(xEagleApp, "xEagleApp");
            xEagleApp.e().b(f13000v);
        }
    }

    public void onResume() {
        super.onResume();
        c();
    }

    @l(a = ThreadMode.MAIN)
    public final void socSuccessEvent(jp.f fVar) {
        String str;
        c.C0151c cVar;
        le.b bVar;
        kotlin.jvm.internal.h.d(fVar, "event");
        int a2 = fVar.a();
        if (a2 == 2004) {
            Object b2 = fVar.b();
            Objects.requireNonNull(b2, "null cannot be cast to non-null type com.xeagle.android.login.beans.sochipBeans.SochipSdcardBean");
            if (((SochipSdcardBean) b2).getDisk_status() == 0) {
                StringBuilder sb = new StringBuilder();
                BaseActivity baseActivity = this.f12544e;
                kotlin.jvm.internal.h.b(baseActivity, "parent");
                sb.append(kx.d.e(baseActivity.getApplicationContext()));
                sb.append("sunxi.db");
                str = sb.toString();
                bVar = new h(this);
                cVar = new i(this, str);
            } else {
                ToastUtils.showShort(this.f12544e.getString(R.string.no_sd_card), new Object[0]);
                h();
                return;
            }
        } else if (a2 == 4003) {
            if (this.f13004k != null && this.f12545f > -1) {
                la.c cVar2 = this.f13004k;
                kotlin.jvm.internal.h.a((Object) cVar2);
                cVar2.remove(this.f12545f);
            }
            Object b3 = fVar.b();
            Objects.requireNonNull(b3, "null cannot be cast to non-null type com.xeagle.android.login.beans.sochipBeans.SochipSdcardBean");
            if (((SochipSdcardBean) b3).getDisk_status() == 0) {
                StringBuilder sb2 = new StringBuilder();
                BaseActivity baseActivity2 = this.f12544e;
                kotlin.jvm.internal.h.b(baseActivity2, "parent");
                sb2.append(kx.d.e(baseActivity2.getApplicationContext()));
                sb2.append("sunxi.db");
                str = sb2.toString();
                bVar = new f(this);
                cVar = new g(this, str);
            } else {
                ToastUtils.showShort(this.f12544e.getString(R.string.no_sd_card), new Object[0]);
                h();
                return;
            }
        } else {
            return;
        }
        a(CameraGlobal.HTTP_FILE, str, bVar, cVar);
    }
}
