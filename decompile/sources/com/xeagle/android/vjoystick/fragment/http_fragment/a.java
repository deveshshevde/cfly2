package com.xeagle.android.vjoystick.fragment.http_fragment;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableStringBuilder;
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
import com.myusb.proxy.proto.Proxy;
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
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.ap;
import kotlinx.coroutines.az;
import kotlinx.coroutines.bg;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.l;
import org.json.JSONException;
import org.json.JSONObject;

public final class a extends com.xeagle.android.fragments.a {

    /* renamed from: g  reason: collision with root package name */
    public static final C0154a f12966g = new C0154a((f) null);
    /* access modifiers changed from: private */

    /* renamed from: y  reason: collision with root package name */
    public static final String f12967y = "HttpSdVideoFragment";

    /* renamed from: h  reason: collision with root package name */
    private RecyclerView f12968h;

    /* renamed from: i  reason: collision with root package name */
    private FrameLayout f12969i;

    /* renamed from: j  reason: collision with root package name */
    private ExGridLayoutManager f12970j;

    /* renamed from: k  reason: collision with root package name */
    private la.c f12971k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public ProgressDialog f12972l;

    /* renamed from: m  reason: collision with root package name */
    private String f12973m;

    /* renamed from: n  reason: collision with root package name */
    private String f12974n;

    /* renamed from: o  reason: collision with root package name */
    private final boolean f12975o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public String f12976p;

    /* renamed from: q  reason: collision with root package name */
    private String f12977q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public final Handler f12978r = new Handler(Looper.getMainLooper());

    /* renamed from: s  reason: collision with root package name */
    private boolean f12979s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f12980t;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public String f12981u;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public String f12982v = "N/A";
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public final SpannableStringBuilder f12983w;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public final ConcurrentHashMap<String, StringBuilder> f12984x = new ConcurrentHashMap<>();

    /* renamed from: z  reason: collision with root package name */
    private HashMap f12985z;

    /* renamed from: com.xeagle.android.vjoystick.fragment.http_fragment.a$a  reason: collision with other inner class name */
    public static final class C0154a {
        private C0154a() {
        }

        public /* synthetic */ C0154a(f fVar) {
            this();
        }

        public final String a() {
            return a.f12967y;
        }
    }

    static final class b implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f25194a;

        b(a aVar) {
            this.f25194a = aVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            if (this.f25194a.f12542c != null) {
                this.f25194a.f12542c.k(this.f25194a.f12976p);
            }
        }
    }

    public static final class c implements com.hoho.android.usb.usb.data_proxy.f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f25195a;

        c(a aVar) {
            this.f25195a = aVar;
        }

        public void a(int i2, int i3, int i4, String str, byte[] bArr) {
            kotlin.jvm.internal.h.d(str, "args");
            kotlin.jvm.internal.h.d(bArr, "arg4");
            if (kotlin.text.f.a((CharSequence) str, (CharSequence) ".CFLY", false, 2, (Object) null)) {
                SpannableStringBuilder b2 = this.f25195a.f12983w;
                if (b2 != null) {
                    b2.append(new String(bArr, kotlin.text.d.f30261a));
                }
            } else if (!this.f25195a.f12984x.containsKey(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append(new String(bArr, kotlin.text.d.f30261a));
                this.f25195a.f12984x.put(str, sb);
            } else if (this.f25195a.f12984x.get(str) != null) {
                Object obj = this.f25195a.f12984x.get(str);
                kotlin.jvm.internal.h.a(obj);
                ((StringBuilder) obj).append(new String(bArr, kotlin.text.d.f30261a));
            }
        }

        public void a(int i2, int i3, String str, Proxy.ConnType connType) {
            kotlin.jvm.internal.h.d(str, "arg3");
            kotlin.jvm.internal.h.d(connType, "connType");
            XEagleApp d2 = this.f25195a.f12540a;
            kotlin.jvm.internal.h.b(d2, "xEagleApp");
            d2.e().b(a.f12966g.a());
        }

        public void a(int i2, String str, int i3, Proxy.ConnType connType) {
            kotlin.jvm.internal.h.d(str, "args");
            kotlin.jvm.internal.h.d(connType, "http");
            if (kotlin.text.f.a(str, this.f25195a.f12982v, true)) {
                a aVar = this.f25195a;
                aVar.b(String.valueOf(aVar.f12983w));
                this.f25195a.f12982v = "N/A";
            } else if (this.f25195a.f12984x.containsKey(str)) {
                a aVar2 = this.f25195a;
                aVar2.b(String.valueOf(aVar2.f12984x.get(str)));
                this.f25195a.f12984x.remove(str);
            }
            XEagleApp d2 = this.f25195a.f12540a;
            kotlin.jvm.internal.h.b(d2, "xEagleApp");
            d2.e().b(a.f12966g.a());
        }

        public void a(int i2, String str, Proxy.ConnType connType) {
            kotlin.jvm.internal.h.d(str, "arg3");
            kotlin.jvm.internal.h.d(connType, "http");
        }
    }

    static final class d implements c.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f25196a;

        d(a aVar) {
            this.f25196a = aVar;
        }

        public final boolean a() {
            this.f25196a.f12978r.post(new Runnable(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ d f25197a;

                {
                    this.f25197a = r1;
                }

                public final void run() {
                    this.f25197a.f25196a.i();
                }
            });
            return true;
        }
    }

    static final class e implements a.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f25198a;

        e(a aVar) {
            this.f25198a = aVar;
        }

        public final void onItemClick(ci.a<Object, ci.b> aVar, View view, int i2) {
            la.c d2 = this.f25198a.d();
            kotlin.jvm.internal.h.a((Object) d2);
            Object obj = d2.getData().get(i2);
            kotlin.jvm.internal.h.a(obj);
            String c2 = ((lc.a) obj).c();
            kotlin.jvm.internal.h.a((Object) c2);
            if (kotlin.text.f.b(c2, "TIME", false, 2, (Object) null)) {
                Intent intent = new Intent(this.f25198a.getActivity(), HttpSdDetailActivity.class);
                intent.putExtra("PAGE_TYPE", "TIME");
                intent.putExtra("FILE_NAME", this.f25198a.f12981u + c2);
                this.f25198a.requireActivity().startActivity(intent);
                return;
            }
            this.f25198a.f12981u = c2;
            this.f25198a.d(c2);
        }
    }

    public static final class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f25199a;

        f(a aVar) {
            this.f25199a = aVar;
        }

        public void run() {
            this.f25199a.j();
        }
    }

    public static final class g implements le.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f25200a;

        g(a aVar) {
            this.f25200a = aVar;
        }

        public void onFail(String str) {
            kotlin.jvm.internal.h.d(str, MyLocationStyle.ERROR_INFO);
        }

        public void onFinishDownload() {
            if (this.f25200a.f12972l != null) {
                ProgressDialog k2 = this.f25200a.f12972l;
                kotlin.jvm.internal.h.a((Object) k2);
                k2.dismiss();
            }
        }

        public void onProgress(int i2) {
            if (i2 == 100 && this.f25200a.f12972l != null) {
                ProgressDialog k2 = this.f25200a.f12972l;
                kotlin.jvm.internal.h.a((Object) k2);
                k2.dismiss();
            }
        }

        public void onStartDownload() {
            a aVar = this.f25200a;
            String string = aVar.f12544e.getString(R.string.push_waiting);
            kotlin.jvm.internal.h.b(string, "parent.getString(R.string.push_waiting)");
            aVar.c(string);
        }
    }

    public static final class h implements c.C0151c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f25201a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f25202b;

        h(a aVar, String str) {
            this.f25201a = aVar;
            this.f25202b = str;
        }

        public void writeFail(String str) {
            kotlin.jvm.internal.h.d(str, "msg");
        }

        public void writeSuccess() {
            BaseActivity baseActivity = this.f25201a.f12544e;
            kotlin.jvm.internal.h.b(baseActivity, "parent");
            Cursor rawQuery = com.xeagle.android.utils.c.a(baseActivity.getApplicationContext(), this.f25202b).rawQuery("select * from MediaFile", (String[]) null);
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
                            la.c d2 = this.f25201a.d();
                            kotlin.jvm.internal.h.a((Object) d2);
                            d2.addData(aVar);
                        }
                    }
                }
            }
        }
    }

    public static final class i implements le.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f25203a;

        i(a aVar) {
            this.f25203a = aVar;
        }

        public void onFail(String str) {
            kotlin.jvm.internal.h.d(str, MyLocationStyle.ERROR_INFO);
        }

        public void onFinishDownload() {
            if (this.f25203a.f12972l != null) {
                ProgressDialog k2 = this.f25203a.f12972l;
                kotlin.jvm.internal.h.a((Object) k2);
                k2.dismiss();
            }
        }

        public void onProgress(int i2) {
            if (i2 == 100 && this.f25203a.f12972l != null) {
                ProgressDialog k2 = this.f25203a.f12972l;
                kotlin.jvm.internal.h.a((Object) k2);
                k2.dismiss();
            }
        }

        public void onStartDownload() {
            a aVar = this.f25203a;
            String string = aVar.f12544e.getString(R.string.push_waiting);
            kotlin.jvm.internal.h.b(string, "parent.getString(R.string.push_waiting)");
            aVar.c(string);
        }
    }

    public static final class j implements c.C0151c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f25204a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f25205b;

        j(a aVar, String str) {
            this.f25204a = aVar;
            this.f25205b = str;
        }

        public void writeFail(String str) {
            kotlin.jvm.internal.h.d(str, "msg");
        }

        public void writeSuccess() {
            BaseActivity baseActivity = this.f25204a.f12544e;
            kotlin.jvm.internal.h.b(baseActivity, "parent");
            Cursor rawQuery = com.xeagle.android.utils.c.a(baseActivity.getApplicationContext(), this.f25205b).rawQuery("select * from MediaFile", (String[]) null);
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
                            la.c d2 = this.f25204a.d();
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
                    a(this.f12975o ? "Please wait ..." : "Downloading ...", (DialogInterface.OnClickListener) new b(this));
                    ProgressDialog progressDialog = this.f12972l;
                    kotlin.jvm.internal.h.a((Object) progressDialog);
                    Integer num = (Integer) obj;
                    kotlin.jvm.internal.h.a((Object) num);
                    progressDialog.setMax(num.intValue());
                    return;
                case IChannelListener.DATA_CHANNEL_EVENT_GET_PROGRESS:
                    ProgressDialog progressDialog2 = this.f12972l;
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
                    j();
                    this.f12976p = null;
                    return;
                default:
                    return;
            }
        } else {
            c("Calculating MD5");
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
            this.f12973m = (String) obj;
        } else if (i2 == 40) {
            Log.i("CmdChannel", "handleCmdChannelEvent:---notification--- " + obj);
            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.String");
            String str = (String) obj;
            int hashCode = str.hashCode();
            if (hashCode != -312225049) {
                if (hashCode == 1383208497 && str.equals("Card_Removed")) {
                    this.f12980t = false;
                    this.f12979s = false;
                    la.c cVar = this.f12971k;
                    kotlin.jvm.internal.h.a((Object) cVar);
                    cVar.a();
                }
            } else if (str.equals("Card_New_Insert")) {
                this.f12979s = true;
                String string = this.f12544e.getString(R.string.push_waiting);
                kotlin.jvm.internal.h.b(string, "parent.getString(R.string.push_waiting)");
                c(string);
                c();
            }
        } else if (i2 != 56) {
            if (i2 == 48) {
                Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f12976p = (String) obj;
            } else if (i2 == 49) {
                Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f12974n = (String) obj;
                Log.i("CmdChannel", "handleCmdChannelEvent: --del position--" + this.f12974n);
            }
        } else if (!this.f12980t) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type org.json.JSONObject");
            try {
                if (((((JSONObject) obj).getInt("info") >> 8) & 65535) == 0) {
                    this.f12980t = true;
                    ToastUtils.showShort(this.f12544e.getString(R.string.no_sd_card), new Object[0]);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    private final void a(int i2, String str) {
        XEagleApp xEagleApp = this.f12540a;
        kotlin.jvm.internal.h.b(xEagleApp, "xEagleApp");
        com.hoho.android.usb.usb.data_proxy.d e2 = xEagleApp.e();
        Proxy.ConnType connType = Proxy.ConnType.HTTP;
        Proxy.MsgType msgType = Proxy.MsgType.SEND;
        Charset charset = kotlin.text.d.f30261a;
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        byte[] bytes = str.getBytes(charset);
        kotlin.jvm.internal.h.b(bytes, "(this as java.lang.String).getBytes(charset)");
        e2.a(i2, connType, msgType, "172.50.10.1", 80, 0, 0, str, bytes);
    }

    private final void a(String str) {
        bg unused = g.a(az.f30335a, ap.b(), (CoroutineStart) null, new DelayVideoFragment$parseAmbaDirHtml$1(this, str, (kotlin.coroutines.c) null), 2, (Object) null);
    }

    private final void a(String str, DialogInterface.OnClickListener onClickListener) {
        j();
        ProgressDialog progressDialog = new ProgressDialog(this.f12544e);
        this.f12972l = progressDialog;
        kotlin.jvm.internal.h.a((Object) progressDialog);
        progressDialog.setTitle(str);
        ProgressDialog progressDialog2 = this.f12972l;
        kotlin.jvm.internal.h.a((Object) progressDialog2);
        progressDialog2.setMax(100);
        ProgressDialog progressDialog3 = this.f12972l;
        kotlin.jvm.internal.h.a((Object) progressDialog3);
        progressDialog3.setProgressStyle(1);
        ProgressDialog progressDialog4 = this.f12972l;
        kotlin.jvm.internal.h.a((Object) progressDialog4);
        progressDialog4.setCancelable(false);
        ProgressDialog progressDialog5 = this.f12972l;
        kotlin.jvm.internal.h.a((Object) progressDialog5);
        progressDialog5.setButton(-2, this.f12544e.getString(R.string.cancel), onClickListener);
        ProgressDialog progressDialog6 = this.f12972l;
        kotlin.jvm.internal.h.a((Object) progressDialog6);
        progressDialog6.show();
    }

    private final void a(String str, String str2, le.b bVar, c.C0151c cVar) {
        new le.d(CameraGlobal.BASE_URL, bVar).a(str, str2, cVar);
    }

    /* access modifiers changed from: private */
    public final void a(ArrayList<lc.a> arrayList) {
        b(arrayList);
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
        ProgressDialog progressDialog = this.f12972l;
        if (progressDialog != null) {
            kotlin.jvm.internal.h.a((Object) progressDialog);
            progressDialog.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public final void b(String str) {
        bg unused = g.a(az.f30335a, ap.b(), (CoroutineStart) null, new DelayVideoFragment$parseAmbaHtml$1(this, str, (kotlin.coroutines.c) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void b(ArrayList<lc.a> arrayList) {
        List list = arrayList;
        kotlin.collections.h.c(list);
        la.c cVar = this.f12971k;
        kotlin.jvm.internal.h.a((Object) cVar);
        cVar.setNewData(list);
        j();
    }

    /* access modifiers changed from: private */
    public final void c(String str) {
        j();
        ProgressDialog progressDialog = new ProgressDialog(this.f12544e);
        this.f12972l = progressDialog;
        kotlin.jvm.internal.h.a((Object) progressDialog);
        progressDialog.setTitle(this.f12544e.getString(R.string.menu_wait));
        ProgressDialog progressDialog2 = this.f12972l;
        kotlin.jvm.internal.h.a((Object) progressDialog2);
        progressDialog2.setMessage(str);
        ProgressDialog progressDialog3 = this.f12972l;
        kotlin.jvm.internal.h.a((Object) progressDialog3);
        progressDialog3.setCancelable(false);
        ProgressDialog progressDialog4 = this.f12972l;
        kotlin.jvm.internal.h.a((Object) progressDialog4);
        progressDialog4.show();
        this.f12978r.postDelayed(new f(this), 5000);
    }

    /* access modifiers changed from: private */
    public final void d(String str) {
        h();
        XEagleApp xEagleApp = this.f12540a;
        kotlin.jvm.internal.h.b(xEagleApp, "xEagleApp");
        com.xeagle.android.a m2 = xEagleApp.m();
        kotlin.jvm.internal.h.b(m2, "xEagleApp.appState");
        this.f12541b = m2.a();
        if (this.f12541b == 1) {
            XEagleApp xEagleApp2 = this.f12540a;
            kotlin.jvm.internal.h.b(xEagleApp2, "xEagleApp");
            com.xeagle.android.utils.prefs.a j2 = xEagleApp2.j();
            kotlin.jvm.internal.h.b(j2, "xEagleApp.preferences");
            this.f12977q = j2.t();
            String string = this.f12544e.getString(R.string.push_waiting);
            kotlin.jvm.internal.h.b(string, "parent.getString(R.string.push_waiting)");
            c(string);
            if (g()) {
                a(11, "http://172.50.10.1/SD/AMBA/" + str);
                return;
            }
            a("http://172.50.10.1/SD/AMBA/" + str);
        } else if (this.f12541b == 2 && this.f12543d != null) {
            this.f12543d.getSdcardStatus(CameraGlobal.BASE_URL, 1, CameraGlobal.GET_SDCARD_STATUS);
        }
    }

    private final boolean g() {
        BaseActivity baseActivity = this.f12544e;
        kotlin.jvm.internal.h.b(baseActivity, "parent");
        Context applicationContext = baseActivity.getApplicationContext();
        Objects.requireNonNull(applicationContext, "null cannot be cast to non-null type com.xeagle.android.XEagleApp");
        return ((XEagleApp) applicationContext).c();
    }

    private final void h() {
        SpannableStringBuilder spannableStringBuilder = this.f12983w;
        if (spannableStringBuilder != null) {
            spannableStringBuilder.clear();
        }
        this.f12984x.clear();
        XEagleApp xEagleApp = this.f12540a;
        kotlin.jvm.internal.h.b(xEagleApp, "xEagleApp");
        com.hoho.android.usb.usb.data_proxy.d e2 = xEagleApp.e();
        String str = f12967y;
        e2.b(str);
        XEagleApp xEagleApp2 = this.f12540a;
        kotlin.jvm.internal.h.b(xEagleApp2, "xEagleApp");
        xEagleApp2.e().a(str, (com.hoho.android.usb.usb.data_proxy.f) new c(this));
    }

    /* access modifiers changed from: private */
    public final void i() {
        com.xeagle.android.vjoystick.fragment.c a2 = com.xeagle.android.vjoystick.fragment.c.a();
        kotlin.jvm.internal.h.b(a2, "RemoteSDDataManager.getInstance()");
        if (!a2.b()) {
            com.xeagle.android.vjoystick.fragment.c.a().a((c.b) new d(this));
            return;
        }
        ArrayList arrayList = new ArrayList();
        com.xeagle.android.vjoystick.fragment.c.a().d(arrayList);
        b((ArrayList<lc.a>) arrayList);
    }

    /* access modifiers changed from: private */
    public final void j() {
        ProgressDialog progressDialog = this.f12972l;
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
        this.f12973m = "";
        this.f12974n = "";
        this.f12968h = (RecyclerView) view.findViewById(R.id.list_item_recycler);
        this.f12969i = (FrameLayout) view.findViewById(R.id.video_full_container);
        BaseActivity baseActivity2 = this.f12544e;
        kotlin.jvm.internal.h.b(baseActivity2, "parent");
        this.f12970j = new ExGridLayoutManager(baseActivity2.getApplicationContext(), 2);
        RecyclerView recyclerView = this.f12968h;
        kotlin.jvm.internal.h.a((Object) recyclerView);
        recyclerView.setLayoutManager(this.f12970j);
        this.f12971k = new la.c();
        RecyclerView recyclerView2 = this.f12968h;
        kotlin.jvm.internal.h.a((Object) recyclerView2);
        recyclerView2.setAdapter(this.f12971k);
        la.c cVar = this.f12971k;
        kotlin.jvm.internal.h.a((Object) cVar);
        cVar.setOnItemClickListener(new e(this));
        if (!org.greenrobot.eventbus.c.a().b(this)) {
            org.greenrobot.eventbus.c.a().a((Object) this);
        }
    }

    public int b() {
        return R.layout.sd_video_fragment;
    }

    public void c() {
        this.f12980t = false;
        if (DroneControlFragment.f12789g) {
            i();
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
        return this.f12971k;
    }

    public void f() {
        HashMap hashMap = this.f12985z;
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
        ProgressDialog progressDialog = this.f12972l;
        if (progressDialog != null) {
            kotlin.jvm.internal.h.a((Object) progressDialog);
            if (progressDialog.isShowing()) {
                ProgressDialog progressDialog2 = this.f12972l;
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
        f();
    }

    public void onPause() {
        super.onPause();
        if (g()) {
            XEagleApp xEagleApp = this.f12540a;
            kotlin.jvm.internal.h.b(xEagleApp, "xEagleApp");
            xEagleApp.e().b(f12967y);
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
                bVar = new i(this);
                cVar = new j(this, str);
            } else {
                ToastUtils.showShort(this.f12544e.getString(R.string.no_sd_card), new Object[0]);
                j();
                return;
            }
        } else if (a2 == 4003) {
            if (this.f12971k != null && this.f12545f > -1) {
                la.c cVar2 = this.f12971k;
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
                bVar = new g(this);
                cVar = new h(this, str);
            } else {
                ToastUtils.showShort(this.f12544e.getString(R.string.no_sd_card), new Object[0]);
                j();
                return;
            }
        } else {
            return;
        }
        a(CameraGlobal.HTTP_FILE, str, bVar, cVar);
    }
}
