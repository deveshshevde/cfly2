package com.xeagle.android.vjoystick.fragment.http_activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.SpannableStringBuilder;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ci.a;
import com.amap.api.mapcore.util.fx;
import com.amap.api.maps.model.MyLocationStyle;
import com.blankj.utilcode.util.GsonUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.cfly.uav_pro.R;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.myusb.proxy.proto.Proxy;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.activities.helpers.SuperUI;
import com.xeagle.android.bean.ProgressBean;
import com.xeagle.android.dialogs.c;
import com.xeagle.android.dialogs.d;
import com.xeagle.android.login.amba.connectivity.IChannelListener;
import com.xeagle.android.login.beans.sochipBeans.SochipSdcardBean;
import com.xeagle.android.login.gsy.recycleView.ToolUtil;
import com.xeagle.android.login.gsy.recycleView.adapter.SdPhotoAdapter;
import com.xeagle.android.login.gsy.recycleView.adapter.SdVideoAdapter;
import com.xeagle.android.login.gsy.video.SampleCoverVideo;
import com.xeagle.android.login.pickImage.data.GLImage;
import com.xeagle.android.login.retrofitLogin.CameraGlobal;
import com.xeagle.android.newUI.cameraManager.AmbaClient;
import com.xeagle.android.utils.c;
import com.xeagle.android.vjoystick.DroneControlFragment;
import com.xeagle.android.vjoystick.IWidgets.IImageButton;
import cy.h;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import jo.ay;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.ap;
import kotlinx.coroutines.az;
import kotlinx.coroutines.bg;
import org.greenrobot.eventbus.ThreadMode;
import org.opencv.tracker.ImagesStitchUtil;

public final class HttpSdDetailActivity extends SuperUI {
    /* access modifiers changed from: private */
    public BufferedOutputStream A;
    private String B;
    /* access modifiers changed from: private */
    public SpannableStringBuilder C;
    private ImagesStitchUtil.a D;
    /* access modifiers changed from: private */
    public final Runnable E;
    /* access modifiers changed from: private */
    public final Runnable F;
    private HashMap G;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public io.reactivex.disposables.b f12947a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public String f12948b = "";
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public int f12949c;

    /* renamed from: k  reason: collision with root package name */
    private com.xeagle.android.dialogs.d f12950k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public String f12951l;

    /* renamed from: m  reason: collision with root package name */
    private SdVideoAdapter f12952m;

    /* renamed from: n  reason: collision with root package name */
    private String f12953n;

    /* renamed from: o  reason: collision with root package name */
    private AppCompatActivity f12954o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public final String f12955p = "HttpSdDetailActivity";
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public GridLayoutManager f12956q;

    /* renamed from: r  reason: collision with root package name */
    private ProgressDialog f12957r;

    /* renamed from: s  reason: collision with root package name */
    private SdPhotoAdapter f12958s;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public boolean f12959t;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public String f12960u;

    /* renamed from: v  reason: collision with root package name */
    private String f12961v;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public final ConcurrentHashMap<String, StringBuilder> f12962w = new ConcurrentHashMap<>();

    /* renamed from: x  reason: collision with root package name */
    private String f12963x;
    /* access modifiers changed from: private */

    /* renamed from: y  reason: collision with root package name */
    public final Handler f12964y;
    /* access modifiers changed from: private */

    /* renamed from: z  reason: collision with root package name */
    public String f12965z;

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ HttpSdDetailActivity f25075a;

        a(HttpSdDetailActivity httpSdDetailActivity) {
            this.f25075a = httpSdDetailActivity;
        }

        public final void run() {
            Toast.makeText(this.f25075a, R.string.synthesis_failed, 0).show();
        }
    }

    public static final class aa implements c.C0151c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ HttpSdDetailActivity f25076a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f25077b;

        aa(HttpSdDetailActivity httpSdDetailActivity, String str) {
            this.f25076a = httpSdDetailActivity;
            this.f25077b = str;
        }

        public void writeFail(String str) {
            kotlin.jvm.internal.h.d(str, "msg");
        }

        public void writeSuccess() {
            Cursor rawQuery = com.xeagle.android.utils.c.a(this.f25076a.getApplicationContext(), this.f25077b).rawQuery("select * from MediaFile", (String[]) null);
            while (rawQuery.moveToNext()) {
                String string = rawQuery.getString(rawQuery.getColumnIndex("type"));
                Log.i("Sochip", "writeSuccess: --type--" + string);
                if (kotlin.jvm.internal.h.a((Object) string, (Object) "photo_A")) {
                    long j2 = rawQuery.getLong(rawQuery.getColumnIndex(GLImage.KEY_SIZE));
                    if (j2 > 0) {
                        String string2 = rawQuery.getString(rawQuery.getColumnIndex("file"));
                        String string3 = rawQuery.getString(rawQuery.getColumnIndex("time"));
                        String a2 = kw.c.a(j2);
                        kotlin.jvm.internal.h.b(a2, "StringUtils.readableFileSize(size)");
                        kotlin.jvm.internal.h.b(string2, "fileName");
                        kotlin.jvm.internal.h.b(string3, "time");
                        lc.a aVar = new lc.a(false, a2, string2, string3, (String) null, 0, 0, 112, (f) null);
                        if (kotlin.jvm.internal.h.a((Object) this.f25076a.f12951l, (Object) "IMAGE")) {
                            HttpSdDetailActivity.g(this.f25076a).addData(aVar);
                        } else {
                            HttpSdDetailActivity.h(this.f25076a).addData(aVar);
                        }
                    }
                }
            }
        }
    }

    static final class ab implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ HttpSdDetailActivity f25078a;

        ab(HttpSdDetailActivity httpSdDetailActivity) {
            this.f25078a = httpSdDetailActivity;
        }

        public final void run() {
            this.f25078a.n();
            if (!this.f25078a.isDestroyed() && !this.f25078a.isFinishing()) {
                ToastUtils.showShort((int) R.string.wrong_picture);
            }
        }
    }

    static final class ac implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ HttpSdDetailActivity f25079a;

        ac(HttpSdDetailActivity httpSdDetailActivity) {
            this.f25079a = httpSdDetailActivity;
        }

        public final void run() {
            this.f25079a.runOnUiThread(new Runnable(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ ac f25080a;

                {
                    this.f25080a = r1;
                }

                public final void run() {
                    this.f25080a.f25079a.j();
                    Toast.makeText(this.f25080a.f25079a.getApplicationContext(), this.f25080a.f25079a.getString(R.string.download_time_out), 1).show();
                    try {
                        BufferedOutputStream r2 = this.f25080a.f25079a.A;
                        if (r2 != null) {
                            r2.close();
                        }
                        this.f25080a.f25079a.A = null;
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    kw.a.a(this.f25080a.f25079a.f12965z);
                }
            });
        }
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ HttpSdDetailActivity f25081a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef f25082b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ cy.h f25083c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f25084d;

        b(HttpSdDetailActivity httpSdDetailActivity, Ref.ObjectRef objectRef, cy.h hVar, String str) {
            this.f25081a = httpSdDetailActivity;
            this.f25082b = objectRef;
            this.f25083c = hVar;
            this.f25084d = str;
        }

        public final void run() {
            Ref.ObjectRef objectRef = this.f25082b;
            HttpSdDetailActivity httpSdDetailActivity = this.f25081a;
            String string = httpSdDetailActivity.getString(R.string.new_comp);
            kotlin.jvm.internal.h.b(string, "getString(R.string.new_comp)");
            objectRef.f30237a = com.xeagle.android.utils.n.a((AppCompatActivity) httpSdDetailActivity, string, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ b f25085a;

                {
                    this.f25085a = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    com.xeagle.android.utils.m.a().b(false);
                    this.f25085a.f25083c.a();
                    this.f25085a.f25081a.disDialog();
                    kw.a.a(this.f25085a.f25084d);
                }
            });
            ProgressDialog progressDialog = (ProgressDialog) this.f25082b.f30237a;
            kotlin.jvm.internal.h.a((Object) progressDialog);
            progressDialog.setMax(100);
        }
    }

    public static final class c implements h.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ HttpSdDetailActivity f25086a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef f25087b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef f25088c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f25089d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f25090e;

        static final class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ c f25091a;

            a(c cVar) {
                this.f25091a = cVar;
            }

            public final void run() {
                this.f25091a.f25086a.disDialog();
                File file = new File((String) this.f25091a.f25088c.f30237a);
                if (file.exists()) {
                    file.delete();
                }
                Toast.makeText(this.f25091a.f25086a.getApplicationContext(), R.string.synthesis_failed, 0).show();
            }
        }

        static final class b implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ c f25092a;

            b(c cVar) {
                this.f25092a = cVar;
            }

            public final void run() {
                this.f25092a.f25086a.disDialog();
                Toast.makeText(HttpSdDetailActivity.t(this.f25092a.f25086a), this.f25092a.f25086a.getString(R.string.time_compose_complete), 1).show();
            }
        }

        c(HttpSdDetailActivity httpSdDetailActivity, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2, String str, String str2) {
            this.f25086a = httpSdDetailActivity;
            this.f25087b = objectRef;
            this.f25088c = objectRef2;
            this.f25089d = str;
            this.f25090e = str2;
        }

        public void a() {
            kw.a.a(this.f25089d);
            int b2 = kotlin.text.f.b((CharSequence) this.f25090e, "/", 0, false, 6, (Object) null);
            String str = this.f25090e;
            Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
            String substring = str.substring(0, b2);
            kotlin.jvm.internal.h.b(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            String a2 = kotlin.text.f.a(substring, "//", "/", false, 4, (Object) null);
            XEagleApp xEagleApp = this.f25086a.xEagleApp;
            kotlin.jvm.internal.h.b(xEagleApp, "xEagleApp");
            if (xEagleApp.g() != null) {
                XEagleApp xEagleApp2 = this.f25086a.xEagleApp;
                kotlin.jvm.internal.h.b(xEagleApp2, "xEagleApp");
                xEagleApp2.g().a(a2, -1);
            }
            this.f25086a.runOnUiThread(new b(this));
        }

        public void a(int i2) {
            ProgressDialog progressDialog = (ProgressDialog) this.f25087b.f30237a;
            kotlin.jvm.internal.h.a((Object) progressDialog);
            progressDialog.setProgress(i2 / 10);
        }

        public void a(Exception exc) {
            kotlin.jvm.internal.h.d(exc, fx.f8867h);
            new com.xeagle.android.utils.file.IO.b(this.f25086a.g(), exc).a(this.f25086a.getApplicationContext());
            this.f25086a.runOnUiThread(new a(this));
        }
    }

    public static final class d implements d.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ HttpSdDetailActivity f25093a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f25094b;

        d(HttpSdDetailActivity httpSdDetailActivity, int i2) {
            this.f25093a = httpSdDetailActivity;
            this.f25094b = i2;
        }

        public void onNo() {
        }

        public void onYes() {
            SystemClock.sleep(500);
            if (this.f25093a.xEagleApp.m().a() == 1) {
                if (this.f25093a.xEagleApp.g() != null) {
                    String c2 = ((lc.a) HttpSdDetailActivity.g(this.f25093a).getData().get(this.f25094b)).c();
                    if (HttpSdDetailActivity.g(this.f25093a).getData().size() <= 1) {
                        CharSequence charSequence = c2;
                        if (kotlin.text.f.a(charSequence, (CharSequence) "PANO", false, 2, (Object) null) || kotlin.text.f.a(charSequence, (CharSequence) "TIME", false, 2, (Object) null)) {
                            int b2 = kotlin.text.f.b(charSequence, "/", 0, false, 6, (Object) null);
                            Objects.requireNonNull(c2, "null cannot be cast to non-null type java.lang.String");
                            String substring = c2.substring(0, b2);
                            kotlin.jvm.internal.h.b(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                            String a2 = kotlin.text.f.a(substring, "//", "/", false, 4, (Object) null);
                            XEagleApp xEagleApp = this.f25093a.xEagleApp;
                            kotlin.jvm.internal.h.b(xEagleApp, "xEagleApp");
                            if (xEagleApp.g() != null) {
                                XEagleApp xEagleApp2 = this.f25093a.xEagleApp;
                                kotlin.jvm.internal.h.b(xEagleApp2, "xEagleApp");
                                xEagleApp2.g().a(a2, -1);
                                return;
                            }
                            return;
                        }
                    }
                    this.f25093a.xEagleApp.g().a(kotlin.text.f.a(((lc.a) HttpSdDetailActivity.g(this.f25093a).getData().get(this.f25094b)).c(), "//", "/", false, 4, (Object) null), this.f25094b);
                }
            } else if (this.f25093a.xEagleApp.m().a() == 2 && this.f25093a.xEagleApp.h() != null) {
                this.f25093a.xEagleApp.h().setCmdAndStr(CameraGlobal.BASE_URL, 1, 4003, ((lc.a) HttpSdDetailActivity.g(this.f25093a).getData().get(this.f25094b)).c());
            }
        }
    }

    public static final class e implements d.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ HttpSdDetailActivity f25095a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f25096b;

        e(HttpSdDetailActivity httpSdDetailActivity, int i2) {
            this.f25095a = httpSdDetailActivity;
            this.f25096b = i2;
        }

        public void onNo() {
        }

        public void onYes() {
            XEagleApp xEagleApp = this.f25095a.xEagleApp;
            kotlin.jvm.internal.h.b(xEagleApp, "xEagleApp");
            com.xeagle.android.a m2 = xEagleApp.m();
            kotlin.jvm.internal.h.b(m2, "xEagleApp.appState");
            if (m2.a() == 1) {
                XEagleApp xEagleApp2 = this.f25095a.xEagleApp;
                kotlin.jvm.internal.h.b(xEagleApp2, "xEagleApp");
                if (xEagleApp2.g() != null) {
                    String c2 = ((lc.a) HttpSdDetailActivity.h(this.f25095a).getData().get(this.f25096b)).c();
                    CharSequence charSequence = c2;
                    if (kotlin.text.f.a(charSequence, (CharSequence) "TIME", false, 2, (Object) null)) {
                        int b2 = kotlin.text.f.b(charSequence, "/", 0, false, 6, (Object) null);
                        Objects.requireNonNull(c2, "null cannot be cast to non-null type java.lang.String");
                        String substring = c2.substring(0, b2);
                        kotlin.jvm.internal.h.b(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        String a2 = kotlin.text.f.a(substring, "//", "/", false, 4, (Object) null);
                        XEagleApp xEagleApp3 = this.f25095a.xEagleApp;
                        kotlin.jvm.internal.h.b(xEagleApp3, "xEagleApp");
                        if (xEagleApp3.g() != null) {
                            XEagleApp xEagleApp4 = this.f25095a.xEagleApp;
                            kotlin.jvm.internal.h.b(xEagleApp4, "xEagleApp");
                            xEagleApp4.g().a(a2, -1);
                            return;
                        }
                        return;
                    }
                    XEagleApp xEagleApp5 = this.f25095a.xEagleApp;
                    kotlin.jvm.internal.h.b(xEagleApp5, "xEagleApp");
                    xEagleApp5.g().a(kotlin.text.f.a(((lc.a) HttpSdDetailActivity.h(this.f25095a).getData().get(this.f25096b)).c(), "//", "/", false, 4, (Object) null), this.f25096b);
                    return;
                }
                return;
            }
            XEagleApp xEagleApp6 = this.f25095a.xEagleApp;
            kotlin.jvm.internal.h.b(xEagleApp6, "xEagleApp");
            com.xeagle.android.a m3 = xEagleApp6.m();
            kotlin.jvm.internal.h.b(m3, "xEagleApp.appState");
            if (m3.a() == 2) {
                XEagleApp xEagleApp7 = this.f25095a.xEagleApp;
                kotlin.jvm.internal.h.b(xEagleApp7, "xEagleApp");
                if (xEagleApp7.h() != null) {
                    XEagleApp xEagleApp8 = this.f25095a.xEagleApp;
                    kotlin.jvm.internal.h.b(xEagleApp8, "xEagleApp");
                    xEagleApp8.h().setCmdAndStr(CameraGlobal.BASE_URL, 1, 4003, ((lc.a) HttpSdDetailActivity.h(this.f25095a).getData().get(this.f25096b)).c());
                }
            }
        }
    }

    public static final class f implements com.hoho.android.usb.usb.data_proxy.f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ HttpSdDetailActivity f25097a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ProgressDialog f25098b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef f25099c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f25100d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f25101e;

        f(HttpSdDetailActivity httpSdDetailActivity, ProgressDialog progressDialog, Ref.ObjectRef objectRef, String str, int i2) {
            this.f25097a = httpSdDetailActivity;
            this.f25098b = progressDialog;
            this.f25099c = objectRef;
            this.f25100d = str;
            this.f25101e = i2;
        }

        public void a(int i2, int i3, int i4, String str, byte[] bArr) {
            kotlin.jvm.internal.h.d(str, "args");
            kotlin.jvm.internal.h.d(bArr, "arg4");
            String e2 = this.f25097a.f12955p;
            Log.i(e2, "onEnd: " + str);
            ProgressBean progressBean = (ProgressBean) GsonUtils.fromJson(str, ProgressBean.class);
            ProgressDialog progressDialog = this.f25098b;
            if (progressDialog != null) {
                double current = progressBean.getCurrent();
                double d2 = (double) 100;
                Double.isNaN(d2);
                progressDialog.setProgress((int) ((current * d2) / progressBean.getTotal()));
            }
            try {
                BufferedOutputStream bufferedOutputStream = (BufferedOutputStream) this.f25099c.f30237a;
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.write(bArr);
                }
                BufferedOutputStream bufferedOutputStream2 = (BufferedOutputStream) this.f25099c.f30237a;
                if (bufferedOutputStream2 != null) {
                    bufferedOutputStream2.flush();
                }
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }

        public void a(int i2, int i3, String str, Proxy.ConnType connType) {
            kotlin.jvm.internal.h.d(str, "arg3");
            kotlin.jvm.internal.h.d(connType, "connType");
            XEagleApp xEagleApp = this.f25097a.xEagleApp;
            kotlin.jvm.internal.h.b(xEagleApp, "xEagleApp");
            xEagleApp.e().b("DOWN_LOAD");
        }

        public void a(int i2, String str, int i3, Proxy.ConnType connType) {
            kotlin.jvm.internal.h.d(str, "args");
            kotlin.jvm.internal.h.d(connType, "http");
            try {
                BufferedOutputStream bufferedOutputStream = (BufferedOutputStream) this.f25099c.f30237a;
                kotlin.jvm.internal.h.a((Object) bufferedOutputStream);
                bufferedOutputStream.close();
                this.f25099c.f30237a = (BufferedOutputStream) null;
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            if (i3 == 0) {
                this.f25097a.a(this.f25100d, this.f25101e);
            } else {
                kw.a.a(this.f25100d);
            }
            XEagleApp xEagleApp = this.f25097a.xEagleApp;
            kotlin.jvm.internal.h.b(xEagleApp, "xEagleApp");
            xEagleApp.e().b("DOWN_LOAD");
        }

        public void a(int i2, String str, Proxy.ConnType connType) {
            kotlin.jvm.internal.h.d(str, "arg3");
            kotlin.jvm.internal.h.d(connType, "http");
        }
    }

    static final class g implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ HttpSdDetailActivity f25102a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f25103b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f25104c;

        g(HttpSdDetailActivity httpSdDetailActivity, int i2, String str) {
            this.f25102a = httpSdDetailActivity;
            this.f25103b = i2;
            this.f25104c = str;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            this.f25102a.e(this.f25103b);
            this.f25102a.disDialog();
            kw.a.a(this.f25104c);
            XEagleApp xEagleApp = this.f25102a.xEagleApp;
            kotlin.jvm.internal.h.b(xEagleApp, "xEagleApp");
            xEagleApp.e().b("DOWN_LOAD");
        }
    }

    public static final class h implements com.hoho.android.usb.usb.data_proxy.f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ HttpSdDetailActivity f25105a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ProgressDialog f25106b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f25107c;

        h(HttpSdDetailActivity httpSdDetailActivity, ProgressDialog progressDialog, String str) {
            this.f25105a = httpSdDetailActivity;
            this.f25106b = progressDialog;
            this.f25107c = str;
        }

        public void a(int i2, int i3, int i4, String str, byte[] bArr) {
            kotlin.jvm.internal.h.d(str, "args");
            kotlin.jvm.internal.h.d(bArr, "arg4");
            ProgressBean progressBean = (ProgressBean) GsonUtils.fromJson(str, ProgressBean.class);
            ProgressDialog progressDialog = this.f25106b;
            if (progressDialog != null) {
                double current = progressBean.getCurrent();
                double d2 = (double) 100;
                Double.isNaN(d2);
                progressDialog.setProgress((int) ((current * d2) / progressBean.getTotal()));
            }
            try {
                BufferedOutputStream r2 = this.f25105a.A;
                if (r2 != null) {
                    r2.write(bArr);
                }
                BufferedOutputStream r3 = this.f25105a.A;
                if (r3 != null) {
                    r3.flush();
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }

        public void a(int i2, int i3, String str, Proxy.ConnType connType) {
            kotlin.jvm.internal.h.d(str, "arg3");
            kotlin.jvm.internal.h.d(connType, "connType");
            this.f25105a.f12964y.removeCallbacks(this.f25105a.E);
            try {
                BufferedOutputStream r2 = this.f25105a.A;
                if (r2 != null) {
                    r2.close();
                }
                this.f25105a.A = null;
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            kw.a.a(this.f25105a.f12965z);
            XEagleApp xEagleApp = this.f25105a.xEagleApp;
            kotlin.jvm.internal.h.b(xEagleApp, "xEagleApp");
            xEagleApp.e().b("DOWN_LOAD");
        }

        public void a(int i2, String str, int i3, Proxy.ConnType connType) {
            kotlin.jvm.internal.h.d(str, "args");
            kotlin.jvm.internal.h.d(connType, "http");
            this.f25105a.f12964y.removeCallbacks(this.f25105a.E);
            try {
                BufferedOutputStream r2 = this.f25105a.A;
                if (r2 != null) {
                    r2.close();
                }
                this.f25105a.A = null;
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            if (i3 != 0) {
                kw.a.a(this.f25105a.f12965z);
            } else if (com.xeagle.android.utils.m.a().b()) {
                HttpSdDetailActivity httpSdDetailActivity = this.f25105a;
                httpSdDetailActivity.c(httpSdDetailActivity.f12965z);
                HttpSdDetailActivity httpSdDetailActivity2 = this.f25105a;
                httpSdDetailActivity2.b(this.f25107c, httpSdDetailActivity2.f12965z);
            } else {
                return;
            }
            XEagleApp xEagleApp = this.f25105a.xEagleApp;
            kotlin.jvm.internal.h.b(xEagleApp, "xEagleApp");
            xEagleApp.e().b("DOWN_LOAD");
        }

        public void a(int i2, String str, Proxy.ConnType connType) {
            kotlin.jvm.internal.h.d(str, "arg3");
            kotlin.jvm.internal.h.d(connType, "http");
        }
    }

    public static final class i implements com.hoho.android.usb.usb.data_proxy.f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ HttpSdDetailActivity f25108a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ProgressDialog f25109b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef f25110c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f25111d;

        i(HttpSdDetailActivity httpSdDetailActivity, ProgressDialog progressDialog, Ref.ObjectRef objectRef, String str) {
            this.f25108a = httpSdDetailActivity;
            this.f25109b = progressDialog;
            this.f25110c = objectRef;
            this.f25111d = str;
        }

        public void a(int i2, int i3, int i4, String str, byte[] bArr) {
            kotlin.jvm.internal.h.d(str, "args");
            kotlin.jvm.internal.h.d(bArr, "arg4");
            ProgressBean progressBean = (ProgressBean) GsonUtils.fromJson(str, ProgressBean.class);
            ProgressDialog progressDialog = this.f25109b;
            if (progressDialog != null) {
                double current = progressBean.getCurrent();
                double d2 = (double) 100;
                Double.isNaN(d2);
                progressDialog.setProgress((int) ((current * d2) / progressBean.getTotal()));
            }
            try {
                BufferedOutputStream bufferedOutputStream = (BufferedOutputStream) this.f25110c.f30237a;
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.write(bArr);
                }
                BufferedOutputStream bufferedOutputStream2 = (BufferedOutputStream) this.f25110c.f30237a;
                if (bufferedOutputStream2 != null) {
                    bufferedOutputStream2.flush();
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }

        public void a(int i2, int i3, String str, Proxy.ConnType connType) {
            kotlin.jvm.internal.h.d(str, "arg3");
            kotlin.jvm.internal.h.d(connType, "connType");
            XEagleApp xEagleApp = this.f25108a.xEagleApp;
            kotlin.jvm.internal.h.b(xEagleApp, "xEagleApp");
            xEagleApp.e().b("DOWN_LOAD");
            try {
                BufferedOutputStream bufferedOutputStream = (BufferedOutputStream) this.f25110c.f30237a;
                kotlin.jvm.internal.h.a((Object) bufferedOutputStream);
                bufferedOutputStream.close();
                this.f25110c.f30237a = (BufferedOutputStream) null;
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            kw.a.a(this.f25111d);
            io.reactivex.disposables.b u2 = this.f25108a.f12947a;
            if (u2 != null) {
                u2.dispose();
            }
        }

        public void a(int i2, String str, int i3, Proxy.ConnType connType) {
            kotlin.jvm.internal.h.d(str, "args");
            kotlin.jvm.internal.h.d(connType, "http");
            try {
                BufferedOutputStream bufferedOutputStream = (BufferedOutputStream) this.f25110c.f30237a;
                kotlin.jvm.internal.h.a((Object) bufferedOutputStream);
                bufferedOutputStream.close();
                this.f25110c.f30237a = (BufferedOutputStream) null;
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            if (i3 == 0) {
                this.f25108a.c(this.f25111d);
            } else {
                kw.a.a(this.f25111d);
            }
            XEagleApp xEagleApp = this.f25108a.xEagleApp;
            kotlin.jvm.internal.h.b(xEagleApp, "xEagleApp");
            xEagleApp.e().b("DOWN_LOAD");
            io.reactivex.disposables.b u2 = this.f25108a.f12947a;
            if (u2 != null) {
                u2.dispose();
            }
        }

        public void a(int i2, String str, Proxy.ConnType connType) {
            kotlin.jvm.internal.h.d(str, "arg3");
            kotlin.jvm.internal.h.d(connType, "http");
        }
    }

    static final class j implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ HttpSdDetailActivity f25112a;

        j(HttpSdDetailActivity httpSdDetailActivity) {
            this.f25112a = httpSdDetailActivity;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            com.xeagle.android.utils.m.a().b(false);
            this.f25112a.e(0);
            this.f25112a.disDialog();
            kw.a.a(this.f25112a.f12965z);
            XEagleApp xEagleApp = this.f25112a.xEagleApp;
            kotlin.jvm.internal.h.b(xEagleApp, "xEagleApp");
            xEagleApp.e().b("DOWN_LOAD");
        }
    }

    static final class k implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ HttpSdDetailActivity f25113a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f25114b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f25115c;

        k(HttpSdDetailActivity httpSdDetailActivity, int i2, String str) {
            this.f25113a = httpSdDetailActivity;
            this.f25114b = i2;
            this.f25115c = str;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            this.f25113a.e(this.f25114b);
            this.f25113a.disDialog();
            kw.a.a(this.f25115c);
            XEagleApp xEagleApp = this.f25113a.xEagleApp;
            kotlin.jvm.internal.h.b(xEagleApp, "xEagleApp");
            xEagleApp.e().b("DOWN_LOAD");
        }
    }

    public static final class l extends com.liulishuo.filedownloader.g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ HttpSdDetailActivity f25116a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef f25117b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f25118c;

        static final class a implements DialogInterface.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ l f25119a;

            a(l lVar) {
                this.f25119a = lVar;
            }

            public final void onClick(DialogInterface dialogInterface, int i2) {
                com.liulishuo.filedownloader.q.a().b();
                this.f25119a.f25116a.disDialog();
            }
        }

        l(HttpSdDetailActivity httpSdDetailActivity, Ref.ObjectRef objectRef, String str) {
            this.f25116a = httpSdDetailActivity;
            this.f25117b = objectRef;
            this.f25118c = str;
        }

        /* access modifiers changed from: protected */
        public void a(com.liulishuo.filedownloader.a aVar, long j2, long j3) {
            kotlin.jvm.internal.h.d(aVar, "task");
        }

        /* access modifiers changed from: protected */
        public void a(com.liulishuo.filedownloader.a aVar, String str, boolean z2, long j2, long j3) {
            kotlin.jvm.internal.h.d(aVar, "task");
            kotlin.jvm.internal.h.d(str, "etag");
            super.a(aVar, str, z2, j2, j3);
            this.f25117b.f30237a = com.xeagle.android.utils.n.a(this.f25116a, (String) null, new a(this), 1, (Object) null);
        }

        /* access modifiers changed from: protected */
        public void a(com.liulishuo.filedownloader.a aVar, Throwable th) {
            kotlin.jvm.internal.h.d(aVar, "task");
            kotlin.jvm.internal.h.d(th, fx.f8867h);
            Log.i("RTSP", "error:===DOWNLOAD==== " + th.getMessage());
        }

        /* access modifiers changed from: protected */
        public void b(com.liulishuo.filedownloader.a aVar, long j2, long j3) {
            kotlin.jvm.internal.h.d(aVar, "task");
            ProgressDialog progressDialog = (ProgressDialog) this.f25117b.f30237a;
            if (progressDialog != null) {
                progressDialog.setProgress((int) ((j2 * ((long) 100)) / j3));
            }
        }

        /* access modifiers changed from: protected */
        public void c(com.liulishuo.filedownloader.a aVar) {
            kotlin.jvm.internal.h.d(aVar, "task");
            if (new File(this.f25118c).exists()) {
                HttpSdDetailActivity httpSdDetailActivity = this.f25116a;
                httpSdDetailActivity.a(this.f25118c, httpSdDetailActivity.f12949c);
            }
        }

        /* access modifiers changed from: protected */
        public void c(com.liulishuo.filedownloader.a aVar, long j2, long j3) {
            kotlin.jvm.internal.h.d(aVar, "task");
        }

        /* access modifiers changed from: protected */
        public void d(com.liulishuo.filedownloader.a aVar) {
            kotlin.jvm.internal.h.d(aVar, "task");
            ToastUtils.showShort((int) R.string.file_is_downloading);
        }
    }

    public static final class m extends com.liulishuo.filedownloader.g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ HttpSdDetailActivity f25120a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef f25121b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f25122c;

        static final class a implements DialogInterface.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ m f25123a;

            a(m mVar) {
                this.f25123a = mVar;
            }

            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.f25123a.f25120a.disDialog();
            }
        }

        m(HttpSdDetailActivity httpSdDetailActivity, Ref.ObjectRef objectRef, String str) {
            this.f25120a = httpSdDetailActivity;
            this.f25121b = objectRef;
            this.f25122c = str;
        }

        /* access modifiers changed from: protected */
        public void a(com.liulishuo.filedownloader.a aVar, long j2, long j3) {
            kotlin.jvm.internal.h.d(aVar, "task");
        }

        /* access modifiers changed from: protected */
        public void a(com.liulishuo.filedownloader.a aVar, String str, boolean z2, long j2, long j3) {
            kotlin.jvm.internal.h.d(aVar, "task");
            kotlin.jvm.internal.h.d(str, "etag");
            super.a(aVar, str, z2, j2, j3);
            this.f25121b.f30237a = com.xeagle.android.utils.n.a(this.f25120a, (String) null, new a(this), 1, (Object) null);
        }

        /* access modifiers changed from: protected */
        public void a(com.liulishuo.filedownloader.a aVar, Throwable th) {
            kotlin.jvm.internal.h.d(aVar, "task");
            kotlin.jvm.internal.h.d(th, fx.f8867h);
            Log.i("CmdChannel", "error:--large-download---" + th.getMessage());
        }

        /* access modifiers changed from: protected */
        public void b(com.liulishuo.filedownloader.a aVar, long j2, long j3) {
            kotlin.jvm.internal.h.d(aVar, "task");
            Log.i("CmdChannel", "progress:--large--download--- " + j2);
            ProgressDialog progressDialog = (ProgressDialog) this.f25121b.f30237a;
            if (progressDialog != null) {
                progressDialog.setProgress((int) ((j2 * ((long) 100)) / j3));
            }
        }

        /* access modifiers changed from: protected */
        public void c(com.liulishuo.filedownloader.a aVar) {
            kotlin.jvm.internal.h.d(aVar, "task");
            this.f25120a.c(this.f25122c);
        }

        /* access modifiers changed from: protected */
        public void c(com.liulishuo.filedownloader.a aVar, long j2, long j3) {
            kotlin.jvm.internal.h.d(aVar, "task");
        }

        /* access modifiers changed from: protected */
        public void d(com.liulishuo.filedownloader.a aVar) {
            kotlin.jvm.internal.h.d(aVar, "task");
            Toast.makeText(this.f25120a, R.string.file_is_downloading, 0).show();
        }
    }

    static final class n implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ HttpSdDetailActivity f25124a;

        n(HttpSdDetailActivity httpSdDetailActivity) {
            this.f25124a = httpSdDetailActivity;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            if (this.f25124a.remoteCam != null) {
                this.f25124a.remoteCam.k(this.f25124a.f12960u);
            }
        }
    }

    public static final class o implements com.hoho.android.usb.usb.data_proxy.f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ HttpSdDetailActivity f25136a;

        o(HttpSdDetailActivity httpSdDetailActivity) {
            this.f25136a = httpSdDetailActivity;
        }

        public void a(int i2, int i3, int i4, String str, byte[] bArr) {
            StringBuilder sb;
            kotlin.jvm.internal.h.d(str, "args");
            kotlin.jvm.internal.h.d(bArr, "arg4");
            if (!kotlin.text.f.a((CharSequence) str, (CharSequence) ".CFLY", false, 2, (Object) null)) {
                if (!this.f25136a.f12962w.containsKey(str)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(new String(bArr, kotlin.text.d.f30261a));
                    this.f25136a.f12962w.put(str, sb2);
                } else if (this.f25136a.f12962w.get(str) != null && (sb = (StringBuilder) this.f25136a.f12962w.get(str)) != null) {
                    sb.append(new String(bArr, kotlin.text.d.f30261a));
                }
            } else if (this.f25136a.C != null) {
                SpannableStringBuilder b2 = this.f25136a.C;
                kotlin.jvm.internal.h.a((Object) b2);
                b2.append(new String(bArr, kotlin.text.d.f30261a));
            }
        }

        public void a(int i2, int i3, String str, Proxy.ConnType connType) {
            kotlin.jvm.internal.h.d(str, "arg3");
            kotlin.jvm.internal.h.d(connType, "connType");
            XEagleApp xEagleApp = this.f25136a.xEagleApp;
            kotlin.jvm.internal.h.b(xEagleApp, "xEagleApp");
            xEagleApp.e().b(this.f25136a.f12955p);
        }

        public void a(int i2, String str, int i3, Proxy.ConnType connType) {
            kotlin.jvm.internal.h.d(str, "args");
            kotlin.jvm.internal.h.d(connType, "connType");
            if (connType == Proxy.ConnType.HTTP) {
                SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) this.f25136a.a(com.xeagle.R.id.smartRefresh);
                if (smartRefreshLayout != null) {
                    smartRefreshLayout.b();
                }
                this.f25136a.j();
                if (kotlin.jvm.internal.h.a((Object) this.f25136a.f12951l, (Object) "IMAGE") || kotlin.jvm.internal.h.a((Object) this.f25136a.f12951l, (Object) "PANO")) {
                    HttpSdDetailActivity httpSdDetailActivity = this.f25136a;
                    httpSdDetailActivity.a(str, String.valueOf(httpSdDetailActivity.f12962w.get(str)));
                } else {
                    HttpSdDetailActivity httpSdDetailActivity2 = this.f25136a;
                    httpSdDetailActivity2.c(str, String.valueOf(httpSdDetailActivity2.f12962w.get(str)));
                }
            }
            XEagleApp xEagleApp = this.f25136a.xEagleApp;
            kotlin.jvm.internal.h.b(xEagleApp, "xEagleApp");
            xEagleApp.e().b(this.f25136a.f12955p);
        }

        public void a(int i2, String str, Proxy.ConnType connType) {
            kotlin.jvm.internal.h.d(str, "arg3");
            kotlin.jvm.internal.h.d(connType, "http");
        }
    }

    static final class p implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ HttpSdDetailActivity f25137a;

        static final class a implements DialogInterface.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ p f25138a;

            a(p pVar) {
                this.f25138a = pVar;
            }

            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.f25138a.f25137a.e(com.xeagle.android.utils.m.a().c());
                this.f25138a.f25137a.disDialog();
                com.xeagle.android.utils.m.a().a(false);
                XEagleApp xEagleApp = this.f25138a.f25137a.xEagleApp;
                kotlin.jvm.internal.h.b(xEagleApp, "xEagleApp");
                xEagleApp.e().b("DOWN_LOAD");
            }
        }

        p(HttpSdDetailActivity httpSdDetailActivity) {
            this.f25137a = httpSdDetailActivity;
        }

        public final void onClick(View view) {
            String c2;
            String c3;
            if (!HttpSdDetailActivity.g(this.f25137a).getData().isEmpty() || !HttpSdDetailActivity.h(this.f25137a).getData().isEmpty()) {
                String i2 = this.f25137a.f12948b;
                if ((i2 != null ? Boolean.valueOf(kotlin.text.f.a((CharSequence) i2, (CharSequence) "PANO", false, 2, (Object) null)) : null).booleanValue()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    if (kotlin.text.f.a((CharSequence) this.f25137a.f12948b, (CharSequence) "PANOC", false, 2, (Object) null)) {
                        if (HttpSdDetailActivity.g(this.f25137a).getData().size() < 3) {
                            com.xeagle.android.dialogs.r.a().a(this.f25137a.getString(R.string.warning), this.f25137a.getString(R.string.pano_lost_warn), (c.a) null).show(this.f25137a.getSupportFragmentManager(), "PANOC");
                            return;
                        }
                    } else if (kotlin.text.f.a((CharSequence) this.f25137a.f12948b, (CharSequence) "PANOD", false, 2, (Object) null) && HttpSdDetailActivity.g(this.f25137a).getData().size() < 6) {
                        com.xeagle.android.dialogs.r.a().a(this.f25137a.getString(R.string.warning), this.f25137a.getString(R.string.pano_lost_warn), (c.a) null).show(this.f25137a.getSupportFragmentManager(), "PANOD");
                        return;
                    }
                    List data = HttpSdDetailActivity.g(this.f25137a).getData();
                    kotlin.jvm.internal.h.b(data, "photoAdapter.data");
                    int i3 = 0;
                    for (Object next : data) {
                        int i4 = i3 + 1;
                        if (i3 < 0) {
                            kotlin.collections.h.b();
                        }
                        lc.a aVar = (lc.a) next;
                        aVar.a(1);
                        if (kotlin.text.f.a((CharSequence) aVar.c(), (CharSequence) "JPG", false, 2, (Object) null)) {
                            String e2 = this.f25137a.f12955p;
                            Log.i(e2, "initClick: ====compose===pano image url===" + aVar.c());
                            arrayList.add(aVar);
                        }
                        i3 = i4;
                    }
                    if (arrayList.isEmpty()) {
                        ToastUtils.showShort((int) R.string.image_not_exist);
                        return;
                    }
                    HttpSdDetailActivity httpSdDetailActivity = this.f25137a;
                    String string = httpSdDetailActivity.getString(R.string.new_comp_img);
                    kotlin.jvm.internal.h.b(string, "getString(R.string.new_comp_img)");
                    com.xeagle.android.utils.n.b(httpSdDetailActivity, string);
                    this.f25137a.o();
                    this.f25137a.m();
                    com.xeagle.android.utils.l a2 = com.xeagle.android.utils.m.a();
                    XEagleApp xEagleApp = this.f25137a.xEagleApp;
                    kotlin.jvm.internal.h.b(xEagleApp, "xEagleApp");
                    HttpSdDetailActivity httpSdDetailActivity2 = this.f25137a;
                    a2.a(xEagleApp, (Activity) httpSdDetailActivity2, (ArrayList<lc.a>) arrayList, 0, currentTimeMillis, (ArrayList<lc.a>) arrayList2, "SAVE_B", httpSdDetailActivity2.a());
                    this.f25137a.b();
                    this.f25137a.f12964y.postDelayed(this.f25137a.F, 300000);
                    return;
                }
                lc.a aVar2 = (lc.a) HttpSdDetailActivity.g(this.f25137a).getItem(this.f25137a.f12949c);
                if (aVar2 == null || (c3 = aVar2.c()) == null || !kotlin.text.f.a((CharSequence) c3, (CharSequence) "PLANET", false, 2, (Object) null)) {
                    lc.a aVar3 = (lc.a) HttpSdDetailActivity.h(this.f25137a).getItem(this.f25137a.f12949c);
                    if (aVar3 != null && (c2 = aVar3.c()) != null && kotlin.text.f.a((CharSequence) c2, (CharSequence) "TIME", false, 2, (Object) null)) {
                        ArrayList arrayList3 = new ArrayList();
                        List data2 = HttpSdDetailActivity.g(this.f25137a).getData();
                        kotlin.jvm.internal.h.b(data2, "photoAdapter.data");
                        int i5 = 0;
                        for (Object next2 : data2) {
                            int i6 = i5 + 1;
                            if (i5 < 0) {
                                kotlin.collections.h.b();
                            }
                            lc.a aVar4 = (lc.a) next2;
                            aVar4.a(1);
                            String e3 = this.f25137a.f12955p;
                            Log.i(e3, "initClick: =====mode name=downLoadVideo: ======" + aVar4.c());
                            if (kotlin.text.f.a((CharSequence) aVar4.c(), (CharSequence) "MP4", false, 2, (Object) null)) {
                                arrayList3.add(aVar4);
                                String e4 = this.f25137a.f12955p;
                                Log.i(e4, "initClick: add mp4===downLoadVideo: ======" + aVar4.c());
                            }
                            i5 = i6;
                        }
                        if (arrayList3.isEmpty()) {
                            ToastUtils.showShort((int) R.string.file_not_exist);
                        } else {
                            this.f25137a.b(((lc.a) arrayList3.get(0)).c());
                        }
                    }
                } else {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    ArrayList arrayList4 = new ArrayList();
                    ArrayList arrayList5 = new ArrayList();
                    List data3 = HttpSdDetailActivity.g(this.f25137a).getData();
                    kotlin.jvm.internal.h.b(data3, "photoAdapter.data");
                    int i7 = 0;
                    for (Object next3 : data3) {
                        int i8 = i7 + 1;
                        if (i7 < 0) {
                            kotlin.collections.h.b();
                        }
                        lc.a aVar5 = (lc.a) next3;
                        aVar5.a(1);
                        if (kotlin.text.f.a((CharSequence) aVar5.c(), (CharSequence) "JPG", false, 2, (Object) null)) {
                            arrayList4.add(aVar5);
                        } else {
                            arrayList5.add(aVar5);
                        }
                        i7 = i8;
                    }
                    HttpSdDetailActivity httpSdDetailActivity3 = this.f25137a;
                    String string2 = httpSdDetailActivity3.getString(R.string.new_comp);
                    kotlin.jvm.internal.h.b(string2, "getString(R.string.new_comp)");
                    ProgressDialog a3 = com.xeagle.android.utils.n.a((AppCompatActivity) httpSdDetailActivity3, string2, (DialogInterface.OnClickListener) new a(this));
                    if (a3 != null) {
                        a3.setMax((arrayList4.size() * 2) + 3);
                    }
                    this.f25137a.m();
                    com.xeagle.android.utils.l a4 = com.xeagle.android.utils.m.a();
                    XEagleApp xEagleApp2 = this.f25137a.xEagleApp;
                    kotlin.jvm.internal.h.b(xEagleApp2, "xEagleApp");
                    HttpSdDetailActivity httpSdDetailActivity4 = this.f25137a;
                    a4.a(xEagleApp2, (Activity) httpSdDetailActivity4, (ArrayList<lc.a>) arrayList4, 0, currentTimeMillis2, (ArrayList<lc.a>) arrayList5, "SAVE_A", httpSdDetailActivity4.a());
                }
            } else {
                ToastUtils.showShort((int) R.string.file_not_exist);
            }
        }
    }

    static final class q implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ HttpSdDetailActivity f25164a;

        q(HttpSdDetailActivity httpSdDetailActivity) {
            this.f25164a = httpSdDetailActivity;
        }

        public final void onClick(View view) {
            this.f25164a.setResult(2020, new Intent());
            this.f25164a.finish();
        }
    }

    static final class r implements a.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ HttpSdDetailActivity f25165a;

        r(HttpSdDetailActivity httpSdDetailActivity) {
            this.f25165a = httpSdDetailActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:21:0x015a, code lost:
            if (kotlin.text.f.a((java.lang.CharSequence) ((lc.a) r8).c(), (java.lang.CharSequence) "PANOD", false, 2, (java.lang.Object) null) != false) goto L_0x015c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:5:0x0063, code lost:
            if (kotlin.text.f.a((java.lang.CharSequence) ((lc.a) r8).c(), (java.lang.CharSequence) "TIME", false, 2, (java.lang.Object) null) != false) goto L_0x0065;
         */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x01a4  */
        /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onItemClick(ci.a<java.lang.Object, ci.b> r8, android.view.View r9, int r10) {
            /*
                r7 = this;
                com.xeagle.android.vjoystick.fragment.http_activity.HttpSdDetailActivity r8 = r7.f25165a
                com.xeagle.android.login.gsy.recycleView.adapter.SdPhotoAdapter r8 = com.xeagle.android.vjoystick.fragment.http_activity.HttpSdDetailActivity.g((com.xeagle.android.vjoystick.fragment.http_activity.HttpSdDetailActivity) r8)
                java.lang.Object r8 = r8.getItem(r10)
                kotlin.jvm.internal.h.a((java.lang.Object) r8)
                lc.a r8 = (lc.a) r8
                java.lang.String r8 = r8.c()
                java.lang.CharSequence r8 = (java.lang.CharSequence) r8
                java.lang.String r9 = "PANO"
                r0 = r9
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                r1 = 0
                r2 = 2
                r3 = 0
                boolean r8 = kotlin.text.f.a((java.lang.CharSequence) r8, (java.lang.CharSequence) r0, (boolean) r1, (int) r2, (java.lang.Object) r3)
                java.lang.String r0 = "TIME"
                java.lang.String r4 = "PLANET"
                java.lang.String r5 = "JPG"
                if (r8 != 0) goto L_0x0065
                com.xeagle.android.vjoystick.fragment.http_activity.HttpSdDetailActivity r8 = r7.f25165a
                com.xeagle.android.login.gsy.recycleView.adapter.SdPhotoAdapter r8 = com.xeagle.android.vjoystick.fragment.http_activity.HttpSdDetailActivity.g((com.xeagle.android.vjoystick.fragment.http_activity.HttpSdDetailActivity) r8)
                java.lang.Object r8 = r8.getItem(r10)
                kotlin.jvm.internal.h.a((java.lang.Object) r8)
                lc.a r8 = (lc.a) r8
                java.lang.String r8 = r8.c()
                java.lang.CharSequence r8 = (java.lang.CharSequence) r8
                r6 = r4
                java.lang.CharSequence r6 = (java.lang.CharSequence) r6
                boolean r8 = kotlin.text.f.a((java.lang.CharSequence) r8, (java.lang.CharSequence) r6, (boolean) r1, (int) r2, (java.lang.Object) r3)
                if (r8 != 0) goto L_0x0065
                com.xeagle.android.vjoystick.fragment.http_activity.HttpSdDetailActivity r8 = r7.f25165a
                com.xeagle.android.login.gsy.recycleView.adapter.SdPhotoAdapter r8 = com.xeagle.android.vjoystick.fragment.http_activity.HttpSdDetailActivity.g((com.xeagle.android.vjoystick.fragment.http_activity.HttpSdDetailActivity) r8)
                java.lang.Object r8 = r8.getItem(r10)
                kotlin.jvm.internal.h.a((java.lang.Object) r8)
                lc.a r8 = (lc.a) r8
                java.lang.String r8 = r8.c()
                java.lang.CharSequence r8 = (java.lang.CharSequence) r8
                r6 = r0
                java.lang.CharSequence r6 = (java.lang.CharSequence) r6
                boolean r8 = kotlin.text.f.a((java.lang.CharSequence) r8, (java.lang.CharSequence) r6, (boolean) r1, (int) r2, (java.lang.Object) r3)
                if (r8 == 0) goto L_0x01bd
            L_0x0065:
                com.xeagle.android.vjoystick.fragment.http_activity.HttpSdDetailActivity r8 = r7.f25165a
                com.xeagle.android.login.gsy.recycleView.adapter.SdPhotoAdapter r8 = com.xeagle.android.vjoystick.fragment.http_activity.HttpSdDetailActivity.g((com.xeagle.android.vjoystick.fragment.http_activity.HttpSdDetailActivity) r8)
                java.lang.Object r8 = r8.getItem(r10)
                kotlin.jvm.internal.h.a((java.lang.Object) r8)
                lc.a r8 = (lc.a) r8
                java.lang.String r8 = r8.c()
                java.lang.CharSequence r8 = (java.lang.CharSequence) r8
                r6 = r5
                java.lang.CharSequence r6 = (java.lang.CharSequence) r6
                boolean r8 = kotlin.text.f.a((java.lang.CharSequence) r8, (java.lang.CharSequence) r6, (boolean) r1, (int) r2, (java.lang.Object) r3)
                if (r8 != 0) goto L_0x01bd
                com.xeagle.android.vjoystick.fragment.http_activity.HttpSdDetailActivity r8 = r7.f25165a
                com.xeagle.android.login.gsy.recycleView.adapter.SdPhotoAdapter r8 = com.xeagle.android.vjoystick.fragment.http_activity.HttpSdDetailActivity.g((com.xeagle.android.vjoystick.fragment.http_activity.HttpSdDetailActivity) r8)
                java.lang.Object r8 = r8.getItem(r10)
                kotlin.jvm.internal.h.a((java.lang.Object) r8)
                lc.a r8 = (lc.a) r8
                java.lang.String r8 = r8.c()
                java.lang.CharSequence r8 = (java.lang.CharSequence) r8
                java.lang.String r6 = "MP4"
                java.lang.CharSequence r6 = (java.lang.CharSequence) r6
                boolean r8 = kotlin.text.f.a((java.lang.CharSequence) r8, (java.lang.CharSequence) r6, (boolean) r1, (int) r2, (java.lang.Object) r3)
                if (r8 != 0) goto L_0x01bd
                com.xeagle.android.vjoystick.fragment.http_activity.HttpSdDetailActivity r8 = r7.f25165a
                com.xeagle.android.login.gsy.recycleView.adapter.SdPhotoAdapter r8 = com.xeagle.android.vjoystick.fragment.http_activity.HttpSdDetailActivity.g((com.xeagle.android.vjoystick.fragment.http_activity.HttpSdDetailActivity) r8)
                java.lang.Object r8 = r8.getItem(r10)
                kotlin.jvm.internal.h.a((java.lang.Object) r8)
                lc.a r8 = (lc.a) r8
                java.lang.String r8 = r8.c()
                java.lang.CharSequence r8 = (java.lang.CharSequence) r8
                java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                boolean r8 = kotlin.text.f.a((java.lang.CharSequence) r8, (java.lang.CharSequence) r4, (boolean) r1, (int) r2, (java.lang.Object) r3)
                java.lang.String r4 = "imgHeCheng"
                if (r8 != 0) goto L_0x016f
                com.xeagle.android.vjoystick.fragment.http_activity.HttpSdDetailActivity r8 = r7.f25165a
                com.xeagle.android.login.gsy.recycleView.adapter.SdPhotoAdapter r8 = com.xeagle.android.vjoystick.fragment.http_activity.HttpSdDetailActivity.g((com.xeagle.android.vjoystick.fragment.http_activity.HttpSdDetailActivity) r8)
                java.lang.Object r8 = r8.getItem(r10)
                kotlin.jvm.internal.h.a((java.lang.Object) r8)
                lc.a r8 = (lc.a) r8
                java.lang.String r8 = r8.c()
                java.lang.CharSequence r8 = (java.lang.CharSequence) r8
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                boolean r8 = kotlin.text.f.a((java.lang.CharSequence) r8, (java.lang.CharSequence) r0, (boolean) r1, (int) r2, (java.lang.Object) r3)
                if (r8 == 0) goto L_0x00e0
                goto L_0x016f
            L_0x00e0:
                com.xeagle.android.vjoystick.fragment.http_activity.HttpSdDetailActivity r8 = r7.f25165a
                com.xeagle.android.login.gsy.recycleView.adapter.SdPhotoAdapter r8 = com.xeagle.android.vjoystick.fragment.http_activity.HttpSdDetailActivity.g((com.xeagle.android.vjoystick.fragment.http_activity.HttpSdDetailActivity) r8)
                java.lang.Object r8 = r8.getItem(r10)
                kotlin.jvm.internal.h.a((java.lang.Object) r8)
                lc.a r8 = (lc.a) r8
                java.lang.String r8 = r8.c()
                java.lang.CharSequence r8 = (java.lang.CharSequence) r8
                java.lang.String r0 = "PANOB"
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                boolean r8 = kotlin.text.f.a((java.lang.CharSequence) r8, (java.lang.CharSequence) r0, (boolean) r1, (int) r2, (java.lang.Object) r3)
                if (r8 != 0) goto L_0x015c
                com.xeagle.android.vjoystick.fragment.http_activity.HttpSdDetailActivity r8 = r7.f25165a
                com.xeagle.android.login.gsy.recycleView.adapter.SdPhotoAdapter r8 = com.xeagle.android.vjoystick.fragment.http_activity.HttpSdDetailActivity.g((com.xeagle.android.vjoystick.fragment.http_activity.HttpSdDetailActivity) r8)
                java.lang.Object r8 = r8.getItem(r10)
                kotlin.jvm.internal.h.a((java.lang.Object) r8)
                lc.a r8 = (lc.a) r8
                java.lang.String r8 = r8.c()
                java.lang.CharSequence r8 = (java.lang.CharSequence) r8
                java.lang.String r0 = "PANOA"
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                boolean r8 = kotlin.text.f.a((java.lang.CharSequence) r8, (java.lang.CharSequence) r0, (boolean) r1, (int) r2, (java.lang.Object) r3)
                if (r8 != 0) goto L_0x015c
                com.xeagle.android.vjoystick.fragment.http_activity.HttpSdDetailActivity r8 = r7.f25165a
                com.xeagle.android.login.gsy.recycleView.adapter.SdPhotoAdapter r8 = com.xeagle.android.vjoystick.fragment.http_activity.HttpSdDetailActivity.g((com.xeagle.android.vjoystick.fragment.http_activity.HttpSdDetailActivity) r8)
                java.lang.Object r8 = r8.getItem(r10)
                kotlin.jvm.internal.h.a((java.lang.Object) r8)
                lc.a r8 = (lc.a) r8
                java.lang.String r8 = r8.c()
                java.lang.CharSequence r8 = (java.lang.CharSequence) r8
                java.lang.String r0 = "PANOC"
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                boolean r8 = kotlin.text.f.a((java.lang.CharSequence) r8, (java.lang.CharSequence) r0, (boolean) r1, (int) r2, (java.lang.Object) r3)
                if (r8 != 0) goto L_0x015c
                com.xeagle.android.vjoystick.fragment.http_activity.HttpSdDetailActivity r8 = r7.f25165a
                com.xeagle.android.login.gsy.recycleView.adapter.SdPhotoAdapter r8 = com.xeagle.android.vjoystick.fragment.http_activity.HttpSdDetailActivity.g((com.xeagle.android.vjoystick.fragment.http_activity.HttpSdDetailActivity) r8)
                java.lang.Object r8 = r8.getItem(r10)
                kotlin.jvm.internal.h.a((java.lang.Object) r8)
                lc.a r8 = (lc.a) r8
                java.lang.String r8 = r8.c()
                java.lang.CharSequence r8 = (java.lang.CharSequence) r8
                java.lang.String r0 = "PANOD"
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                boolean r8 = kotlin.text.f.a((java.lang.CharSequence) r8, (java.lang.CharSequence) r0, (boolean) r1, (int) r2, (java.lang.Object) r3)
                if (r8 == 0) goto L_0x018a
            L_0x015c:
                com.xeagle.android.vjoystick.fragment.http_activity.HttpSdDetailActivity r8 = r7.f25165a
                int r0 = com.xeagle.R.id.imgHeCheng
                android.view.View r8 = r8.a((int) r0)
                android.widget.Button r8 = (android.widget.Button) r8
                kotlin.jvm.internal.h.b(r8, r4)
                com.xeagle.android.vjoystick.fragment.http_activity.HttpSdDetailActivity r0 = r7.f25165a
                r1 = 2131820946(0x7f110192, float:1.9274621E38)
                goto L_0x0181
            L_0x016f:
                com.xeagle.android.vjoystick.fragment.http_activity.HttpSdDetailActivity r8 = r7.f25165a
                int r0 = com.xeagle.R.id.imgHeCheng
                android.view.View r8 = r8.a((int) r0)
                android.widget.Button r8 = (android.widget.Button) r8
                kotlin.jvm.internal.h.b(r8, r4)
                com.xeagle.android.vjoystick.fragment.http_activity.HttpSdDetailActivity r0 = r7.f25165a
                r1 = 2131820947(0x7f110193, float:1.9274623E38)
            L_0x0181:
                java.lang.String r0 = r0.getString(r1)
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                r8.setText(r0)
            L_0x018a:
                com.xeagle.android.vjoystick.fragment.http_activity.HttpSdDetailActivity r8 = r7.f25165a
                com.xeagle.android.login.gsy.recycleView.adapter.SdPhotoAdapter r0 = com.xeagle.android.vjoystick.fragment.http_activity.HttpSdDetailActivity.g((com.xeagle.android.vjoystick.fragment.http_activity.HttpSdDetailActivity) r8)
                java.lang.Object r10 = r0.getItem(r10)
                kotlin.jvm.internal.h.a((java.lang.Object) r10)
                lc.a r10 = (lc.a) r10
                java.lang.String r10 = r10.c()
                r8.f12948b = r10
                boolean r8 = com.xeagle.android.vjoystick.DroneControlFragment.f12789g
                if (r8 == 0) goto L_0x020f
                com.xeagle.android.vjoystick.fragment.http_activity.HttpSdDetailActivity r8 = r7.f25165a
                java.lang.String r8 = r8.f12951l
                boolean r8 = kotlin.jvm.internal.h.a((java.lang.Object) r8, (java.lang.Object) r9)
                if (r8 == 0) goto L_0x01b7
                com.xeagle.android.vjoystick.fragment.http_activity.HttpSdDetailActivity r8 = r7.f25165a
                java.lang.String r9 = "IMAGE"
                r8.f12951l = r9
            L_0x01b7:
                com.xeagle.android.vjoystick.fragment.http_activity.HttpSdDetailActivity r8 = r7.f25165a
                r8.r()
                goto L_0x020f
            L_0x01bd:
                com.xeagle.android.vjoystick.fragment.http_activity.HttpSdDetailActivity r8 = r7.f25165a
                com.xeagle.android.login.gsy.recycleView.adapter.SdPhotoAdapter r8 = com.xeagle.android.vjoystick.fragment.http_activity.HttpSdDetailActivity.g((com.xeagle.android.vjoystick.fragment.http_activity.HttpSdDetailActivity) r8)
                java.lang.Object r8 = r8.getItem(r10)
                kotlin.jvm.internal.h.a((java.lang.Object) r8)
                lc.a r8 = (lc.a) r8
                java.lang.String r8 = r8.c()
                java.lang.CharSequence r8 = (java.lang.CharSequence) r8
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                boolean r8 = kotlin.text.f.a((java.lang.CharSequence) r8, (java.lang.CharSequence) r5, (boolean) r1, (int) r2, (java.lang.Object) r3)
                if (r8 == 0) goto L_0x020f
                android.content.Intent r8 = new android.content.Intent
                com.xeagle.android.vjoystick.fragment.http_activity.HttpSdDetailActivity r9 = r7.f25165a
                android.content.Context r9 = (android.content.Context) r9
                java.lang.Class<com.xeagle.android.vjoystick.activity.ImageViewActivity> r0 = com.xeagle.android.vjoystick.activity.ImageViewActivity.class
                r8.<init>(r9, r0)
                com.xeagle.android.vjoystick.fragment.http_activity.HttpSdDetailActivity r9 = r7.f25165a
                com.xeagle.android.login.gsy.recycleView.adapter.SdPhotoAdapter r9 = com.xeagle.android.vjoystick.fragment.http_activity.HttpSdDetailActivity.g((com.xeagle.android.vjoystick.fragment.http_activity.HttpSdDetailActivity) r9)
                java.lang.Object r9 = r9.getItem(r10)
                kotlin.jvm.internal.h.a((java.lang.Object) r9)
                lc.a r9 = (lc.a) r9
                java.lang.String r9 = r9.c()
                java.lang.String r10 = "image_name"
                r8.putExtra(r10, r9)
                com.xeagle.android.vjoystick.fragment.http_activity.HttpSdDetailActivity r9 = r7.f25165a
                r10 = r9
                android.app.Activity r10 = (android.app.Activity) r10
                android.util.Pair[] r0 = new android.util.Pair[r1]
                android.app.ActivityOptions r10 = android.app.ActivityOptions.makeSceneTransitionAnimation(r10, r0)
                android.os.Bundle r10 = r10.toBundle()
                r9.startActivity(r8, r10)
            L_0x020f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.vjoystick.fragment.http_activity.HttpSdDetailActivity.r.onItemClick(ci.a, android.view.View, int):void");
        }
    }

    static final class s implements a.C0069a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ HttpSdDetailActivity f25166a;

        s(HttpSdDetailActivity httpSdDetailActivity) {
            this.f25166a = httpSdDetailActivity;
        }

        public final void a(ci.a<Object, ci.b> aVar, View view, int i2) {
            this.f25166a.f12949c = i2;
            kotlin.jvm.internal.h.b(view, Promotion.ACTION_VIEW);
            int id2 = view.getId();
            if (id2 == R.id.list_item_btn) {
                this.f25166a.b(i2);
            } else if (id2 == R.id.video_delete) {
                this.f25166a.h(i2);
            } else if (id2 == R.id.video_download) {
                if (this.f25166a.f12959t) {
                    ToastUtils.showShort(this.f25166a.getString(R.string.video_is_load_no_download), new Object[0]);
                } else {
                    this.f25166a.d(i2);
                }
            }
        }
    }

    static final class t implements a.C0069a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ HttpSdDetailActivity f25167a;

        t(HttpSdDetailActivity httpSdDetailActivity) {
            this.f25167a = httpSdDetailActivity;
        }

        public final void a(ci.a<Object, ci.b> aVar, View view, int i2) {
            this.f25167a.f12949c = i2;
            kotlin.jvm.internal.h.b(view, Promotion.ACTION_VIEW);
            switch (view.getId()) {
                case R.id.photo_delete /*2131298353*/:
                    this.f25167a.f(i2);
                    return;
                case R.id.photo_download /*2131298354*/:
                    this.f25167a.g(i2);
                    return;
                default:
                    return;
            }
        }
    }

    static final class u<T> implements lv.d<Long> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ HttpSdDetailActivity f25168a;

        u(HttpSdDetailActivity httpSdDetailActivity) {
            this.f25168a = httpSdDetailActivity;
        }

        /* renamed from: a */
        public final void accept(Long l2) {
            com.flypro.core.MAVLink.b.a(this.f25168a.f12358g, (byte) 22);
            hf.d.b(this.f25168a.f12955p, "飞控保活");
        }
    }

    public static final class v extends RecyclerView.l {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ HttpSdDetailActivity f25169a;

        /* renamed from: b  reason: collision with root package name */
        private int f25170b;

        /* renamed from: c  reason: collision with root package name */
        private int f25171c;

        v(HttpSdDetailActivity httpSdDetailActivity) {
            this.f25169a = httpSdDetailActivity;
        }

        public void a(RecyclerView recyclerView, int i2, int i3) {
            kotlin.jvm.internal.h.d(recyclerView, "recyclerView");
            super.a(recyclerView, i2, i3);
            GridLayoutManager v2 = this.f25169a.f12956q;
            kotlin.jvm.internal.h.a((Object) v2);
            this.f25170b = v2.o();
            GridLayoutManager v3 = this.f25169a.f12956q;
            kotlin.jvm.internal.h.a((Object) v3);
            this.f25171c = v3.q();
            com.shuyu.gsyvideoplayer.c a2 = com.shuyu.gsyvideoplayer.c.a();
            kotlin.jvm.internal.h.b(a2, "GSYVideoManager.instance()");
            if (a2.getPlayPosition() >= 0) {
                com.shuyu.gsyvideoplayer.c a3 = com.shuyu.gsyvideoplayer.c.a();
                kotlin.jvm.internal.h.b(a3, "GSYVideoManager.instance()");
                int playPosition = a3.getPlayPosition();
                com.shuyu.gsyvideoplayer.c a4 = com.shuyu.gsyvideoplayer.c.a();
                kotlin.jvm.internal.h.b(a4, "GSYVideoManager.instance()");
                if (!a4.getPlayTag().equals("VIDEO_ADAPTER")) {
                    return;
                }
                if ((playPosition < this.f25170b || playPosition > this.f25171c) && !com.shuyu.gsyvideoplayer.c.a((Activity) this.f25169a)) {
                    com.shuyu.gsyvideoplayer.c.b();
                    if (!this.f25169a.f12959t) {
                        HttpSdDetailActivity.h(this.f25169a).notifyDataSetChanged();
                    }
                }
            }
        }
    }

    public static final class w implements com.hoho.android.usb.usb.data_proxy.f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ HttpSdDetailActivity f25172a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ BufferedOutputStream f25173b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f25174c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ lc.a f25175d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f25176e;

        static final class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ w f25177a;

            a(w wVar) {
                this.f25177a = wVar;
            }

            public final void run() {
                if (Build.VERSION.SDK_INT >= 30) {
                    ku.b.a(this.f25177a.f25174c, (Context) this.f25177a.f25172a);
                } else {
                    ku.b.b(this.f25177a.f25172a, new File(this.f25177a.f25174c));
                }
            }
        }

        static final class b implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ w f25178a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ int f25179b;

            b(w wVar, int i2) {
                this.f25178a = wVar;
                this.f25179b = i2;
            }

            public final void run() {
                int i2 = this.f25179b;
                if (1 <= i2 && 96 >= i2) {
                    lc.a aVar = this.f25178a.f25175d;
                    kotlin.jvm.internal.h.a((Object) aVar);
                    aVar.a(3);
                    this.f25178a.f25175d.b(this.f25179b);
                    HttpSdDetailActivity.h(this.f25178a.f25172a).setData(this.f25178a.f25176e, this.f25178a.f25175d);
                    return;
                }
                this.f25178a.f25172a.c(this.f25178a.f25176e);
            }
        }

        w(HttpSdDetailActivity httpSdDetailActivity, BufferedOutputStream bufferedOutputStream, String str, lc.a aVar, int i2) {
            this.f25172a = httpSdDetailActivity;
            this.f25173b = bufferedOutputStream;
            this.f25174c = str;
            this.f25175d = aVar;
            this.f25176e = i2;
        }

        public void a(int i2, int i3, int i4, String str, byte[] bArr) {
            kotlin.jvm.internal.h.d(str, "args");
            kotlin.jvm.internal.h.d(bArr, "arg4");
            if (this.f25172a.f12959t) {
                try {
                    BufferedOutputStream bufferedOutputStream = this.f25173b;
                    kotlin.jvm.internal.h.a((Object) bufferedOutputStream);
                    bufferedOutputStream.write(bArr);
                    BufferedOutputStream bufferedOutputStream2 = this.f25173b;
                    kotlin.jvm.internal.h.a((Object) bufferedOutputStream2);
                    bufferedOutputStream2.flush();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }

        public void a(int i2, int i3, String str, Proxy.ConnType connType) {
            kotlin.jvm.internal.h.d(str, "arg3");
            kotlin.jvm.internal.h.d(connType, "connType");
            XEagleApp xEagleApp = this.f25172a.xEagleApp;
            kotlin.jvm.internal.h.b(xEagleApp, "xEagleApp");
            xEagleApp.e().b("LOOK_LOG");
            this.f25172a.f12959t = false;
        }

        public void a(int i2, String str, int i3, Proxy.ConnType connType) {
            kotlin.jvm.internal.h.d(str, "args");
            kotlin.jvm.internal.h.d(connType, "http");
            if (this.f25172a.f12959t && kotlin.text.f.a((CharSequence) str, (CharSequence) ".CFLY", false, 2, (Object) null)) {
                try {
                    this.f25173b.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                this.f25172a.runOnUiThread(new a(this));
                XEagleApp xEagleApp = this.f25172a.xEagleApp;
                kotlin.jvm.internal.h.b(xEagleApp, "xEagleApp");
                xEagleApp.e().b("LOOK_LOG");
                this.f25172a.f12959t = false;
            }
        }

        public void a(int i2, String str, Proxy.ConnType connType) {
            kotlin.jvm.internal.h.d(str, "arg3");
            kotlin.jvm.internal.h.d(connType, "http");
            ProgressBean progressBean = (ProgressBean) GsonUtils.fromJson(str, ProgressBean.class);
            double current = progressBean.getCurrent();
            double d2 = (double) 100;
            Double.isNaN(d2);
            this.f25172a.runOnUiThread(new b(this, (int) ((current * d2) / progressBean.getTotal())));
        }
    }

    public static final class x implements ImagesStitchUtil.a {
        x() {
        }

        public void a(int i2) {
        }

        public void a(String str) {
            kotlin.jvm.internal.h.d(str, GLImage.KEY_PATH);
        }
    }

    static final class y implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ HttpSdDetailActivity f25180a;

        y(HttpSdDetailActivity httpSdDetailActivity) {
            this.f25180a = httpSdDetailActivity;
        }

        public final void run() {
            this.f25180a.j();
        }
    }

    public static final class z implements le.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ HttpSdDetailActivity f25181a;

        z(HttpSdDetailActivity httpSdDetailActivity) {
            this.f25181a = httpSdDetailActivity;
        }

        public void onFail(String str) {
            kotlin.jvm.internal.h.d(str, MyLocationStyle.ERROR_INFO);
        }

        public void onFinishDownload() {
            HttpSdDetailActivity.f(this.f25181a).dismiss();
        }

        public void onProgress(int i2) {
            if (i2 == 100) {
                HttpSdDetailActivity.f(this.f25181a).dismiss();
            }
        }

        public void onStartDownload() {
            HttpSdDetailActivity httpSdDetailActivity = this.f25181a;
            String string = httpSdDetailActivity.getString(R.string.push_waiting);
            kotlin.jvm.internal.h.b(string, "getString(R.string.push_waiting)");
            httpSdDetailActivity.a(string);
        }
    }

    public HttpSdDetailActivity() {
        Looper mainLooper = Looper.getMainLooper();
        kotlin.jvm.internal.h.a((Object) mainLooper);
        this.f12964y = new Handler(mainLooper);
        this.B = "N/A";
        this.D = new x();
        this.E = new ac(this);
        this.F = new ab(this);
    }

    private final void a(int i2, Object obj) {
        if (i2 != 518) {
            switch (i2) {
                case 512:
                    String string = getParent().getString(R.string.string_download_now);
                    kotlin.jvm.internal.h.b(string, "parent.getString(R.string.string_download_now)");
                    a(string, (DialogInterface.OnClickListener) new n(this));
                    ProgressDialog progressDialog = this.f12957r;
                    if (progressDialog == null) {
                        kotlin.jvm.internal.h.b("mProgressDialog");
                    }
                    kotlin.jvm.internal.h.a((Object) progressDialog);
                    Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Int");
                    progressDialog.setMax(((Integer) obj).intValue());
                    return;
                case IChannelListener.DATA_CHANNEL_EVENT_GET_PROGRESS:
                    ProgressDialog progressDialog2 = this.f12957r;
                    if (progressDialog2 == null) {
                        kotlin.jvm.internal.h.b("mProgressDialog");
                    }
                    kotlin.jvm.internal.h.a((Object) progressDialog2);
                    Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Int");
                    progressDialog2.setProgress(((Integer) obj).intValue());
                    return;
                case IChannelListener.DATA_CHANNEL_EVENT_GET_FINISH:
                    Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.String");
                    Toast.makeText(getParent(), "Download to " + ((String) obj), 0).show();
                    j();
                    this.f12960u = null;
                    return;
                default:
                    return;
            }
        } else {
            a("Calculating MD5");
        }
    }

    private final void a(int i2, String str, Proxy.MsgType msgType) {
        XEagleApp xEagleApp = this.xEagleApp;
        kotlin.jvm.internal.h.b(xEagleApp, "xEagleApp");
        com.hoho.android.usb.usb.data_proxy.d e2 = xEagleApp.e();
        Proxy.ConnType connType = Proxy.ConnType.HTTP;
        Charset charset = kotlin.text.d.f30261a;
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        byte[] bytes = str.getBytes(charset);
        kotlin.jvm.internal.h.b(bytes, "(this as java.lang.String).getBytes(charset)");
        e2.a(i2, connType, msgType, "172.50.10.1", 80, 0, 0, str, bytes);
    }

    /* access modifiers changed from: private */
    public final void a(String str) {
        j();
        ProgressDialog progressDialog = this.f12957r;
        if (progressDialog == null) {
            kotlin.jvm.internal.h.b("mProgressDialog");
        }
        progressDialog.setMessage(str);
        ProgressDialog progressDialog2 = this.f12957r;
        if (progressDialog2 == null) {
            kotlin.jvm.internal.h.b("mProgressDialog");
        }
        progressDialog2.show();
        this.f12964y.postDelayed(new y(this), 5000);
    }

    /* access modifiers changed from: private */
    public final void a(String str, int i2) {
        bg unused = g.a(az.f30335a, (kotlin.coroutines.f) null, (CoroutineStart) null, new HttpSdDetailActivity$notifyImageUI$1(this, i2, str, (kotlin.coroutines.c) null), 3, (Object) null);
    }

    private final void a(String str, DialogInterface.OnClickListener onClickListener) {
        j();
        ProgressDialog progressDialog = new ProgressDialog(getParent());
        this.f12957r = progressDialog;
        if (progressDialog == null) {
            kotlin.jvm.internal.h.b("mProgressDialog");
        }
        kotlin.jvm.internal.h.a((Object) progressDialog);
        progressDialog.setTitle(str);
        ProgressDialog progressDialog2 = this.f12957r;
        if (progressDialog2 == null) {
            kotlin.jvm.internal.h.b("mProgressDialog");
        }
        kotlin.jvm.internal.h.a((Object) progressDialog2);
        progressDialog2.setMax(100);
        ProgressDialog progressDialog3 = this.f12957r;
        if (progressDialog3 == null) {
            kotlin.jvm.internal.h.b("mProgressDialog");
        }
        kotlin.jvm.internal.h.a((Object) progressDialog3);
        progressDialog3.setProgressStyle(1);
        ProgressDialog progressDialog4 = this.f12957r;
        if (progressDialog4 == null) {
            kotlin.jvm.internal.h.b("mProgressDialog");
        }
        kotlin.jvm.internal.h.a((Object) progressDialog4);
        progressDialog4.setCancelable(false);
        ProgressDialog progressDialog5 = this.f12957r;
        if (progressDialog5 == null) {
            kotlin.jvm.internal.h.b("mProgressDialog");
        }
        kotlin.jvm.internal.h.a((Object) progressDialog5);
        progressDialog5.setButton(-2, getParent().getString(R.string.cancel), onClickListener);
        ProgressDialog progressDialog6 = this.f12957r;
        if (progressDialog6 == null) {
            kotlin.jvm.internal.h.b("mProgressDialog");
        }
        kotlin.jvm.internal.h.a((Object) progressDialog6);
        progressDialog6.show();
    }

    /* access modifiers changed from: private */
    public final void a(String str, String str2) {
        bg unused = g.a(az.f30335a, ap.b(), (CoroutineStart) null, new HttpSdDetailActivity$parseAmbaPhoto$1(this, str, str2, (kotlin.coroutines.c) null), 2, (Object) null);
    }

    private final void a(String str, String str2, le.b bVar, c.C0151c cVar) {
        try {
            new le.d(CameraGlobal.BASE_URL, bVar).a(str, str2, cVar);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private final void a(String str, lc.a aVar) {
        String str2;
        String str3;
        String str4 = str;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.f30237a = (ProgressDialog) null;
        if (kotlin.text.f.a((CharSequence) aVar.c(), (CharSequence) "AMBA", false, 2, (Object) null)) {
            String a2 = kotlin.text.f.a(aVar.c(), "/tmp/SD0/", "/SD/", false, 4, (Object) null);
            str2 = kx.d.q(this) + ToolUtil.getInstance().getAmbaPath(a2);
            str3 = str4 + a2;
        } else {
            String c2 = aVar.c();
            int a3 = kotlin.text.f.a((CharSequence) aVar.c(), "/20", 0, false, 6, (Object) null);
            int length = aVar.c().length();
            Objects.requireNonNull(c2, "null cannot be cast to non-null type java.lang.String");
            String substring = c2.substring(a3, length);
            kotlin.jvm.internal.h.b(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            str2 = kx.d.q(this) + "video_" + kotlin.text.f.a(kotlin.text.f.a(substring, "_", "", false, 4, (Object) null), "/", "", false, 4, (Object) null);
            str3 = str4 + aVar.c();
        }
        com.liulishuo.filedownloader.q.a().a(str3).a((com.liulishuo.filedownloader.i) new m(this, objectRef, str2)).a(str2).c();
    }

    /* access modifiers changed from: private */
    public final void a(ArrayList<lc.a> arrayList) {
        j();
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) a(com.xeagle.R.id.smartRefresh);
        if (smartRefreshLayout != null) {
            smartRefreshLayout.b();
        }
        SdPhotoAdapter sdPhotoAdapter = this.f12958s;
        if (sdPhotoAdapter == null) {
            kotlin.jvm.internal.h.b("photoAdapter");
        }
        List list = arrayList;
        sdPhotoAdapter.setNewData(list);
        kotlin.jvm.internal.h.a((Object) arrayList);
        kotlin.collections.h.c(list);
        SdVideoAdapter sdVideoAdapter = this.f12952m;
        if (sdVideoAdapter == null) {
            kotlin.jvm.internal.h.b("myVideoAdapter");
        }
        sdVideoAdapter.setNewData(list);
        if ((this.f12948b.length() > 0) || kotlin.jvm.internal.h.a((Object) this.f12951l, (Object) "TIME")) {
            Button button = (Button) a(com.xeagle.R.id.imgHeCheng);
            kotlin.jvm.internal.h.b(button, "imgHeCheng");
            button.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public final void b(int i2) {
        int i3 = i2;
        SdVideoAdapter sdVideoAdapter = this.f12952m;
        if (sdVideoAdapter == null) {
            kotlin.jvm.internal.h.b("myVideoAdapter");
        }
        lc.a aVar = (lc.a) sdVideoAdapter.getItem(i3);
        SdVideoAdapter sdVideoAdapter2 = this.f12952m;
        if (sdVideoAdapter2 == null) {
            kotlin.jvm.internal.h.b("myVideoAdapter");
        }
        Object item = sdVideoAdapter2.getItem(i3);
        kotlin.jvm.internal.h.a(item);
        String c2 = ((lc.a) item).c();
        StringBuilder sb = new StringBuilder();
        sb.append(kx.d.l(this));
        Objects.requireNonNull(c2, "null cannot be cast to non-null type java.lang.String");
        String substring = c2.substring(c2.length() - 12);
        kotlin.jvm.internal.h.b(substring, "(this as java.lang.String).substring(startIndex)");
        sb.append(substring);
        String sb2 = sb.toString();
        if (this.f12959t) {
            ToastUtils.showShort(getString(R.string.video_is_load), new Object[0]);
            return;
        }
        try {
            File file = new File(sb2);
            if (file.exists()) {
                file.delete();
            }
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            XEagleApp xEagleApp = this.xEagleApp;
            kotlin.jvm.internal.h.b(xEagleApp, "xEagleApp");
            xEagleApp.e().b("LOOK_LOG");
            XEagleApp xEagleApp2 = this.xEagleApp;
            kotlin.jvm.internal.h.b(xEagleApp2, "xEagleApp");
            xEagleApp2.e().a("LOOK_LOG", (com.hoho.android.usb.usb.data_proxy.f) new w(this, bufferedOutputStream, sb2, aVar, i2));
            if (!this.f12959t) {
                XEagleApp xEagleApp3 = this.xEagleApp;
                kotlin.jvm.internal.h.b(xEagleApp3, "xEagleApp");
                com.hoho.android.usb.usb.data_proxy.d e2 = xEagleApp3.e();
                Proxy.ConnType connType = Proxy.ConnType.HTTP;
                Proxy.MsgType msgType = Proxy.MsgType.SEND;
                kotlin.jvm.internal.h.a((Object) aVar);
                String d2 = aVar.d();
                String d3 = aVar.d();
                Charset charset = kotlin.text.d.f30261a;
                if (d3 != null) {
                    byte[] bytes = d3.getBytes(charset);
                    kotlin.jvm.internal.h.b(bytes, "(this as java.lang.String).getBytes(charset)");
                    e2.a(12, connType, msgType, "172.50.10.1", 80, 0, 0, d2, bytes);
                    this.f12959t = true;
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
        } catch (FileNotFoundException e3) {
            e3.printStackTrace();
        }
    }

    private final void b(int i2, Object obj) {
        if (i2 >= 80) {
            c(i2, obj);
        } else if (i2 == 5) {
            j();
        } else if (i2 == 48) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f12960u = (String) obj;
        } else if (i2 == 49) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.String");
            String str = (String) obj;
            this.f12961v = str;
            kotlin.jvm.internal.h.a((Object) str);
            if (kotlin.text.f.a((CharSequence) str, (CharSequence) ".MP4", false, 2, (Object) null)) {
                XEagleApp xEagleApp = this.xEagleApp;
                kotlin.jvm.internal.h.b(xEagleApp, "xEagleApp");
                AmbaClient g2 = xEagleApp.g();
                if (g2 != null) {
                    SdVideoAdapter sdVideoAdapter = this.f12952m;
                    if (sdVideoAdapter == null) {
                        kotlin.jvm.internal.h.b("myVideoAdapter");
                    }
                    g2.a(kotlin.text.f.a(((lc.a) sdVideoAdapter.getData().get(this.f12949c)).c(), "AA.MP4", "AB.CFLY", false, 4, (Object) null), this.f12949c);
                }
            } else {
                if (kotlin.jvm.internal.h.a((Object) this.f12951l, (Object) "IMAGE") || kotlin.jvm.internal.h.a((Object) this.f12951l, (Object) "PANO")) {
                    SdPhotoAdapter sdPhotoAdapter = this.f12958s;
                    if (sdPhotoAdapter == null) {
                        kotlin.jvm.internal.h.b("photoAdapter");
                    }
                    sdPhotoAdapter.remove(this.f12949c);
                } else {
                    SdVideoAdapter sdVideoAdapter2 = this.f12952m;
                    if (sdVideoAdapter2 == null) {
                        kotlin.jvm.internal.h.b("myVideoAdapter");
                    }
                    sdVideoAdapter2.remove(this.f12949c);
                }
                k();
                String str2 = this.f12961v;
                kotlin.jvm.internal.h.a((Object) str2);
                if (!kotlin.text.f.c(str2, ".JPG", false, 2, (Object) null)) {
                    String str3 = this.f12961v;
                    kotlin.jvm.internal.h.a((Object) str3);
                    if (!kotlin.text.f.c(str3, ".CFLY", false, 2, (Object) null)) {
                        finish();
                    }
                }
            }
            Log.i("CmdChannel", "handleCmdChannelEvent: --del position--" + this.f12961v);
        }
    }

    /* access modifiers changed from: private */
    public final void b(String str) {
        Log.i(this.f12955p, "downLoadVideo: ====url====" + str);
        if (this.xEagleApp.m().a() == 1 && this.xEagleApp.c()) {
            com.xeagle.android.utils.m.a().b(true);
            o();
            String str2 = kx.d.q(this) + "/" + ToolUtil.getInstance().getAmbaPath(str);
            this.f12965z = str2;
            try {
                kotlin.jvm.internal.h.a((Object) str2);
                this.f12965z = kotlin.text.f.a(str2, "//", "/", false, 4, (Object) null);
                File file = new File(this.f12965z);
                if (file.exists()) {
                    if (file.length() == 0) {
                        kw.a.a(this.f12965z);
                    } else {
                        b(str, this.f12965z);
                        return;
                    }
                }
                this.A = new BufferedOutputStream(new FileOutputStream(file, true));
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
            }
            ProgressDialog a2 = com.xeagle.android.utils.n.a(this, (String) null, new j(this), 1, (Object) null);
            this.f12964y.removeCallbacks(this.E);
            this.f12964y.postDelayed(this.E, 300000);
            com.xeagle.android.communication.ftp.b a3 = com.xeagle.android.communication.ftp.c.a();
            XEagleApp xEagleApp = this.xEagleApp;
            kotlin.jvm.internal.h.b(xEagleApp, "xEagleApp");
            a3.a(xEagleApp, str, 0, new h(this, a2, str));
        }
    }

    /* access modifiers changed from: private */
    public final void b(String str, String str2) {
        if (str2 != null) {
            XEagleApp d2 = XEagleApp.d();
            kotlin.jvm.internal.h.b(d2, "XEagleApp.getXEagleApp()");
            en.a k2 = d2.k();
            kotlin.jvm.internal.h.b(k2, "XEagleApp.getXEagleApp().drone");
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.f30237a = (ProgressDialog) null;
            cy.h hVar = new cy.h(getResources());
            try {
                hVar.a(this, str2, k2.y());
                Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                objectRef2.f30237a = kx.d.q(this) + "video_" + com.xeagle.android.utils.y.b(System.currentTimeMillis()) + ".mp4";
                hVar.a((String) objectRef2.f30237a);
                runOnUiThread(new b(this, objectRef, hVar, str2));
                hVar.a((h.a) new c(this, objectRef, objectRef2, str2, str));
                hVar.a(0, 40000000);
            } catch (Exception e2) {
                new com.xeagle.android.utils.file.IO.b(g(), e2).a(getApplicationContext());
                runOnUiThread(new a(this));
            }
        }
    }

    private final void b(String str, lc.a aVar) {
        String str2;
        String str3;
        String str4 = str;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.f30237a = (ProgressDialog) null;
        if (kotlin.text.f.a((CharSequence) aVar.c(), (CharSequence) "AMBA", false, 2, (Object) null)) {
            String a2 = kotlin.text.f.a(aVar.c(), "/tmp/SD0/", "/SD/", false, 4, (Object) null);
            str2 = kx.d.s(this) + com.xeagle.android.utils.c.h(a2);
            str3 = str4 + a2;
        } else {
            String c2 = aVar.c();
            int a3 = kotlin.text.f.a((CharSequence) aVar.c(), "/20", 0, false, 6, (Object) null);
            int length = aVar.c().length();
            Objects.requireNonNull(c2, "null cannot be cast to non-null type java.lang.String");
            String substring = c2.substring(a3, length);
            kotlin.jvm.internal.h.b(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            str2 = kx.d.s(this) + "image_" + kotlin.text.f.a(kotlin.text.f.a(substring, "_", "", false, 4, (Object) null), "/", "", false, 4, (Object) null);
            str3 = str4 + aVar.c();
        }
        com.liulishuo.filedownloader.q.a().a(str3).a((com.liulishuo.filedownloader.i) new l(this, objectRef, str2)).a(str2).c();
    }

    /* access modifiers changed from: private */
    public final void c(int i2) {
        RecyclerView recyclerView = (RecyclerView) a(com.xeagle.R.id.rcw);
        kotlin.jvm.internal.h.b(recyclerView, "rcw");
        int childCount = recyclerView.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = ((RecyclerView) a(com.xeagle.R.id.rcw)).getChildAt(i3);
            kotlin.jvm.internal.h.b(childAt, "itemView");
            Object tag = childAt.getTag();
            Objects.requireNonNull(tag, "null cannot be cast to non-null type com.xeagle.android.login.gsy.video.SampleCoverVideo");
            SampleCoverVideo sampleCoverVideo = (SampleCoverVideo) tag;
            if (sampleCoverVideo.getPlayPosition() == i2) {
                sampleCoverVideo.startPlayLogic();
                return;
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
        ProgressDialog progressDialog = this.f12957r;
        if (progressDialog == null) {
            kotlin.jvm.internal.h.b("mProgressDialog");
        }
        progressDialog.dismiss();
    }

    /* access modifiers changed from: private */
    public final void c(String str) {
        if (str != null) {
            bg unused = g.a(az.f30335a, (kotlin.coroutines.f) null, (CoroutineStart) null, new HttpSdDetailActivity$notifyVideo$1(this, str, (kotlin.coroutines.c) null), 3, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public final void c(String str, String str2) {
        bg unused = g.a(az.f30335a, ap.b(), (CoroutineStart) null, new HttpSdDetailActivity$parseAmbaVideo$1(this, str, str2, (kotlin.coroutines.c) null), 2, (Object) null);
    }

    private final void d() {
        XEagleApp xEagleApp = this.xEagleApp;
        kotlin.jvm.internal.h.b(xEagleApp, "xEagleApp");
        xEagleApp.e().b(this.f12955p);
        XEagleApp xEagleApp2 = this.xEagleApp;
        kotlin.jvm.internal.h.b(xEagleApp2, "xEagleApp");
        xEagleApp2.e().a(this.f12955p, (com.hoho.android.usb.usb.data_proxy.f) new o(this));
    }

    /* access modifiers changed from: private */
    public final void d(int i2) {
        lc.a aVar;
        String str;
        if (this.xEagleApp.m().a() == 1) {
            if (this.xEagleApp.c()) {
                o();
                SdVideoAdapter sdVideoAdapter = this.f12952m;
                if (sdVideoAdapter == null) {
                    kotlin.jvm.internal.h.b("myVideoAdapter");
                }
                Object item = sdVideoAdapter.getItem(i2);
                kotlin.jvm.internal.h.a(item);
                String c2 = ((lc.a) item).c();
                String str2 = kx.d.q(this) + "/" + ToolUtil.getInstance().getAmbaPath(c2);
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                objectRef.f30237a = (BufferedOutputStream) null;
                try {
                    File file = new File(str2);
                    if (file.exists()) {
                        ToastUtils.showShort(getString(R.string.already_download), new Object[0]);
                        return;
                    }
                    objectRef.f30237a = new BufferedOutputStream(new FileOutputStream(file, true));
                    ProgressDialog a2 = com.xeagle.android.utils.n.a(this, (String) null, new k(this, i2, str2), 1, (Object) null);
                    com.xeagle.android.communication.ftp.b a3 = com.xeagle.android.communication.ftp.c.a();
                    XEagleApp xEagleApp = this.xEagleApp;
                    kotlin.jvm.internal.h.b(xEagleApp, "xEagleApp");
                    a3.a(xEagleApp, c2, i2, new i(this, a2, objectRef, str2));
                    return;
                } catch (FileNotFoundException e2) {
                    e2.printStackTrace();
                }
            } else {
                SdVideoAdapter sdVideoAdapter2 = this.f12952m;
                if (sdVideoAdapter2 == null) {
                    kotlin.jvm.internal.h.b("myVideoAdapter");
                }
                Object item2 = sdVideoAdapter2.getItem(i2);
                kotlin.jvm.internal.h.a(item2);
                kotlin.jvm.internal.h.b(item2, "myVideoAdapter.getItem(position)!!");
                aVar = (lc.a) item2;
                str = "http://172.50.10.1";
            }
        } else if (this.xEagleApp.m().a() == 2) {
            SdVideoAdapter sdVideoAdapter3 = this.f12952m;
            if (sdVideoAdapter3 == null) {
                kotlin.jvm.internal.h.b("myVideoAdapter");
            }
            Object item3 = sdVideoAdapter3.getItem(i2);
            kotlin.jvm.internal.h.a(item3);
            kotlin.jvm.internal.h.b(item3, "myVideoAdapter.getItem(position)!!");
            aVar = (lc.a) item3;
            str = "http://172.50.10.1:8082";
        } else {
            return;
        }
        a(str, aVar);
    }

    private final void d(String str) {
        bg unused = g.a(az.f30335a, ap.b(), (CoroutineStart) null, new HttpSdDetailActivity$parseAmbaPhotoHtml$1(this, str, (kotlin.coroutines.c) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void e(int i2) {
        XEagleApp xEagleApp = this.xEagleApp;
        kotlin.jvm.internal.h.b(xEagleApp, "xEagleApp");
        com.hoho.android.usb.usb.data_proxy.d e2 = xEagleApp.e();
        Proxy.ConnType connType = Proxy.ConnType.FTP;
        Proxy.MsgType msgType = Proxy.MsgType.FTP_DOWNLOAD_STOP;
        byte[] bytes = "".getBytes(kotlin.text.d.f30261a);
        kotlin.jvm.internal.h.b(bytes, "(this as java.lang.String).getBytes(charset)");
        e2.a(i2, connType, msgType, "172.50.10.1", 21, 0, 0, "", bytes);
    }

    private final void e(String str) {
        bg unused = g.a(az.f30335a, (kotlin.coroutines.f) null, (CoroutineStart) null, new HttpSdDetailActivity$parseAmbaVideoHtml$1(this, str, (kotlin.coroutines.c) null), 3, (Object) null);
    }

    private final boolean e() {
        Context applicationContext = getApplicationContext();
        Objects.requireNonNull(applicationContext, "null cannot be cast to non-null type com.xeagle.android.XEagleApp");
        return ((XEagleApp) applicationContext).c();
    }

    public static final /* synthetic */ ProgressDialog f(HttpSdDetailActivity httpSdDetailActivity) {
        ProgressDialog progressDialog = httpSdDetailActivity.f12957r;
        if (progressDialog == null) {
            kotlin.jvm.internal.h.b("mProgressDialog");
        }
        return progressDialog;
    }

    /* access modifiers changed from: private */
    public final void f(int i2) {
        com.xeagle.android.dialogs.d a2 = com.xeagle.android.dialogs.d.a(getString(R.string.delete), getString(R.string.confirm_to_delete), (d.a) null);
        kotlin.jvm.internal.h.b(a2, "BtnYesDialog.newInstance…           null\n        )");
        this.f12950k = a2;
        if (a2 == null) {
            kotlin.jvm.internal.h.b("deleteDlg");
        }
        if (!a2.isAdded()) {
            com.xeagle.android.dialogs.d dVar = this.f12950k;
            if (dVar == null) {
                kotlin.jvm.internal.h.b("deleteDlg");
            }
            dVar.a(new d(this, i2));
            com.xeagle.android.dialogs.d dVar2 = this.f12950k;
            if (dVar2 == null) {
                kotlin.jvm.internal.h.b("deleteDlg");
            }
            kotlin.jvm.internal.h.a((Object) dVar2);
            dVar2.show(getSupportFragmentManager(), "deletePhoto");
        }
    }

    public static final /* synthetic */ SdPhotoAdapter g(HttpSdDetailActivity httpSdDetailActivity) {
        SdPhotoAdapter sdPhotoAdapter = httpSdDetailActivity.f12958s;
        if (sdPhotoAdapter == null) {
            kotlin.jvm.internal.h.b("photoAdapter");
        }
        return sdPhotoAdapter;
    }

    /* access modifiers changed from: private */
    public final void g(int i2) {
        lc.a aVar;
        String str;
        XEagleApp xEagleApp = this.xEagleApp;
        kotlin.jvm.internal.h.b(xEagleApp, "xEagleApp");
        com.xeagle.android.a m2 = xEagleApp.m();
        kotlin.jvm.internal.h.b(m2, "xEagleApp.appState");
        if (m2.a() == 1) {
            XEagleApp xEagleApp2 = this.xEagleApp;
            kotlin.jvm.internal.h.b(xEagleApp2, "xEagleApp");
            if (xEagleApp2.c()) {
                XEagleApp xEagleApp3 = this.xEagleApp;
                kotlin.jvm.internal.h.b(xEagleApp3, "xEagleApp");
                if (xEagleApp3.f() != null) {
                    SdPhotoAdapter sdPhotoAdapter = this.f12958s;
                    if (sdPhotoAdapter == null) {
                        kotlin.jvm.internal.h.b("photoAdapter");
                    }
                    Object item = sdPhotoAdapter.getItem(i2);
                    kotlin.jvm.internal.h.a(item);
                    String c2 = ((lc.a) item).c();
                    String str2 = kx.d.s(this) + ToolUtil.getInstance().getAmbaPath(c2);
                    Ref.ObjectRef objectRef = new Ref.ObjectRef();
                    objectRef.f30237a = (BufferedOutputStream) null;
                    try {
                        File file = new File(str2);
                        if (file.exists()) {
                            ToastUtils.showShort(getString(R.string.already_download), new Object[0]);
                            return;
                        }
                        objectRef.f30237a = new BufferedOutputStream(new FileOutputStream(file, true));
                        ProgressDialog a2 = com.xeagle.android.utils.n.a(this, (String) null, new g(this, i2, str2), 1, (Object) null);
                        try {
                            com.xeagle.android.communication.ftp.b a3 = com.xeagle.android.communication.ftp.c.a();
                            XEagleApp xEagleApp4 = this.xEagleApp;
                            kotlin.jvm.internal.h.b(xEagleApp4, "xEagleApp");
                            a3.a(xEagleApp4, c2, i2, new f(this, a2, objectRef, str2, i2));
                            return;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return;
                        }
                    } catch (FileNotFoundException e3) {
                        e3.printStackTrace();
                    }
                } else {
                    return;
                }
            } else {
                SdPhotoAdapter sdPhotoAdapter2 = this.f12958s;
                if (sdPhotoAdapter2 == null) {
                    kotlin.jvm.internal.h.b("photoAdapter");
                }
                Object obj = sdPhotoAdapter2.getData().get(i2);
                kotlin.jvm.internal.h.b(obj, "photoAdapter.data[position]");
                aVar = (lc.a) obj;
                str = "http://172.50.10.1/";
            }
        } else if (this.xEagleApp.m().a() == 2) {
            SdPhotoAdapter sdPhotoAdapter3 = this.f12958s;
            if (sdPhotoAdapter3 == null) {
                kotlin.jvm.internal.h.b("photoAdapter");
            }
            Object obj2 = sdPhotoAdapter3.getData().get(i2);
            kotlin.jvm.internal.h.b(obj2, "photoAdapter.data[position]");
            aVar = (lc.a) obj2;
            str = "http://172.50.10.1:8082";
        } else {
            return;
        }
        b(str, aVar);
    }

    public static final /* synthetic */ SdVideoAdapter h(HttpSdDetailActivity httpSdDetailActivity) {
        SdVideoAdapter sdVideoAdapter = httpSdDetailActivity.f12952m;
        if (sdVideoAdapter == null) {
            kotlin.jvm.internal.h.b("myVideoAdapter");
        }
        return sdVideoAdapter;
    }

    /* access modifiers changed from: private */
    public final void h(int i2) {
        com.xeagle.android.dialogs.d a2 = com.xeagle.android.dialogs.d.a(getString(R.string.delete), getString(R.string.confirm_to_delete), (d.a) null);
        kotlin.jvm.internal.h.b(a2, "BtnYesDialog.newInstance…           null\n        )");
        this.f12950k = a2;
        if (a2 == null) {
            kotlin.jvm.internal.h.b("deleteDlg");
        }
        if (!a2.isAdded()) {
            com.xeagle.android.dialogs.d dVar = this.f12950k;
            if (dVar == null) {
                kotlin.jvm.internal.h.b("deleteDlg");
            }
            dVar.a(new e(this, i2));
            com.xeagle.android.dialogs.d dVar2 = this.f12950k;
            if (dVar2 == null) {
                kotlin.jvm.internal.h.b("deleteDlg");
            }
            dVar2.show(getSupportFragmentManager(), "deleteVideo");
        }
    }

    /* access modifiers changed from: private */
    public final void j() {
        ProgressDialog progressDialog = this.f12957r;
        if (progressDialog == null) {
            kotlin.jvm.internal.h.b("mProgressDialog");
        }
        progressDialog.dismiss();
    }

    private final void k() {
        XEagleApp xEagleApp = this.xEagleApp;
        kotlin.jvm.internal.h.b(xEagleApp, "xEagleApp");
        com.xeagle.android.a m2 = xEagleApp.m();
        kotlin.jvm.internal.h.b(m2, "xEagleApp.appState");
        int a2 = m2.a();
        XEagleApp xEagleApp2 = this.xEagleApp;
        kotlin.jvm.internal.h.b(xEagleApp2, "xEagleApp");
        boolean c2 = xEagleApp2.c();
        XEagleApp xEagleApp3 = this.xEagleApp;
        kotlin.jvm.internal.h.b(xEagleApp3, "xEagleApp");
        com.xeagle.android.vjoystick.fragment.c.a().a(a2, c2, xEagleApp3.h());
    }

    private final void l() {
        ((Button) a(com.xeagle.R.id.imgHeCheng)).setOnClickListener(new p(this));
        ((IImageButton) a(com.xeagle.R.id.ib_go_back)).setOnClickListener(new q(this));
        ((SmartRefreshLayout) a(com.xeagle.R.id.smartRefresh)).b(false);
        ((SmartRefreshLayout) a(com.xeagle.R.id.smartRefresh)).c(false);
        SdPhotoAdapter sdPhotoAdapter = this.f12958s;
        if (sdPhotoAdapter == null) {
            kotlin.jvm.internal.h.b("photoAdapter");
        }
        sdPhotoAdapter.setOnItemClickListener(new r(this));
        SdVideoAdapter sdVideoAdapter = this.f12952m;
        if (sdVideoAdapter == null) {
            kotlin.jvm.internal.h.b("myVideoAdapter");
        }
        sdVideoAdapter.setOnItemChildClickListener(new s(this));
        SdPhotoAdapter sdPhotoAdapter2 = this.f12958s;
        if (sdPhotoAdapter2 == null) {
            kotlin.jvm.internal.h.b("photoAdapter");
        }
        sdPhotoAdapter2.setOnItemChildClickListener(new t(this));
    }

    /* access modifiers changed from: private */
    public final void m() {
        kw.a.a(new File(kx.d.u(this)));
    }

    /* access modifiers changed from: private */
    public final void n() {
        com.xeagle.android.utils.m.a().a(false);
        XEagleApp xEagleApp = this.xEagleApp;
        kotlin.jvm.internal.h.b(xEagleApp, "xEagleApp");
        xEagleApp.e().b("DOWN_LOAD");
        com.liulishuo.filedownloader.q.a().c();
        b();
        e(com.xeagle.android.utils.m.a().c());
        disDialog();
        com.xeagle.android.utils.m.a().e();
    }

    /* access modifiers changed from: private */
    public final void o() {
        io.reactivex.disposables.b bVar = this.f12947a;
        if (bVar != null) {
            bVar.dispose();
        }
        this.f12947a = io.reactivex.f.a(5, 30, TimeUnit.SECONDS).b(lz.a.b()).a(lu.a.a()).a(new u(this));
    }

    private final void p() {
        RecyclerView.Adapter adapter;
        RecyclerView recyclerView;
        String str;
        this.f12954o = this;
        this.f12961v = "";
        com.liulishuo.filedownloader.q.a(getApplicationContext());
        com.liulishuo.filedownloader.q.a().a(1);
        this.f12961v = "";
        this.f12952m = new SdVideoAdapter(this);
        this.f12958s = new SdPhotoAdapter();
        if (kotlin.jvm.internal.h.a((Object) this.f12951l, (Object) "IMAGE") || kotlin.jvm.internal.h.a((Object) this.f12951l, (Object) "PANO")) {
            this.f12956q = new GridLayoutManager(this, 4);
            ((RecyclerView) a(com.xeagle.R.id.rcw)).setLayoutManager(this.f12956q);
            recyclerView = (RecyclerView) a(com.xeagle.R.id.rcw);
            adapter = this.f12958s;
            if (adapter == null) {
                str = "photoAdapter";
            }
            recyclerView.setAdapter(adapter);
        }
        this.f12956q = new GridLayoutManager(this, 2);
        ((RecyclerView) a(com.xeagle.R.id.rcw)).setLayoutManager(this.f12956q);
        recyclerView = (RecyclerView) a(com.xeagle.R.id.rcw);
        adapter = this.f12952m;
        if (adapter == null) {
            str = "myVideoAdapter";
        }
        recyclerView.setAdapter(adapter);
        kotlin.jvm.internal.h.b(str);
        recyclerView.setAdapter(adapter);
    }

    private final void q() {
        ((RecyclerView) a(com.xeagle.R.id.rcw)).a((RecyclerView.l) new v(this));
    }

    /* access modifiers changed from: private */
    public final void r() {
        String str;
        SpannableStringBuilder spannableStringBuilder = this.C;
        if (spannableStringBuilder != null) {
            spannableStringBuilder.clear();
        }
        this.f12962w.clear();
        d();
        this.camera_type = this.xEagleApp.m().a();
        boolean z2 = true;
        if (this.camera_type == 1) {
            this.f12963x = this.xEagleApp.j().t();
            String string = getString(R.string.push_waiting);
            kotlin.jvm.internal.h.b(string, "getString(R.string.push_waiting)");
            a(string);
            if (e()) {
                StringBuilder sb = new StringBuilder();
                sb.append("http://172.50.10.1/SD/AMBA/");
                String str2 = this.f12953n;
                kotlin.jvm.internal.h.a((Object) str2);
                sb.append(str2);
                if (this.f12948b.length() != 0) {
                    z2 = false;
                }
                if (z2) {
                    str = "";
                } else {
                    str = '/' + this.f12948b;
                }
                sb.append(str);
                a(14, sb.toString(), Proxy.MsgType.SEND);
            } else if (kotlin.jvm.internal.h.a((Object) this.f12951l, (Object) "IMAGE") || kotlin.jvm.internal.h.a((Object) this.f12951l, (Object) "PANO")) {
                String str3 = this.f12953n;
                kotlin.jvm.internal.h.a((Object) str3);
                d(str3);
            } else {
                String str4 = this.f12953n;
                kotlin.jvm.internal.h.a((Object) str4);
                e(str4);
            }
        } else if (this.camera_type == 2 && this.xEagleApp.h() != null) {
            this.xEagleApp.h().getSdcardStatus(CameraGlobal.BASE_URL, 1, CameraGlobal.GET_SDCARD_STATUS);
        }
    }

    public static final /* synthetic */ AppCompatActivity t(HttpSdDetailActivity httpSdDetailActivity) {
        AppCompatActivity appCompatActivity = httpSdDetailActivity.f12954o;
        if (appCompatActivity == null) {
            kotlin.jvm.internal.h.b("activity");
        }
        return appCompatActivity;
    }

    public View a(int i2) {
        if (this.G == null) {
            this.G = new HashMap();
        }
        View view = (View) this.G.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.G.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final ImagesStitchUtil.a a() {
        return this.D;
    }

    public final void b() {
        this.f12964y.removeCallbacks(this.F);
    }

    @org.greenrobot.eventbus.l(a = ThreadMode.MAIN)
    public final void channelEvent(jo.c cVar) {
        kotlin.jvm.internal.h.d(cVar, "event");
        int a2 = cVar.a() & IChannelListener.MSG_MASK;
        if (a2 != 0) {
            if (a2 == 512) {
                int a3 = cVar.a();
                Object b2 = cVar.b();
                kotlin.jvm.internal.h.b(b2, "event.param");
                a(a3, b2);
            }
        } else if (cVar.b() != null) {
            int a4 = cVar.a();
            Object b3 = cVar.b();
            kotlin.jvm.internal.h.b(b3, "event.param");
            b(a4, b3);
        }
    }

    public void disDialog() {
        super.disDialog();
        b();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_sd_detail);
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle(getString(R.string.menu_wait));
        progressDialog.setCancelable(false);
        kotlin.l lVar = kotlin.l.f30254a;
        this.f12957r = progressDialog;
        this.f12953n = getIntent().getStringExtra("FILE_NAME");
        this.f12951l = getIntent().getStringExtra("PAGE_TYPE");
        p();
        if (DroneControlFragment.f12789g) {
            r();
        }
        l();
        q();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        com.shuyu.gsyvideoplayer.c.b();
        ProgressDialog progressDialog = this.f12957r;
        if (progressDialog == null) {
            kotlin.jvm.internal.h.b("mProgressDialog");
        }
        if (progressDialog.isShowing()) {
            ProgressDialog progressDialog2 = this.f12957r;
            if (progressDialog2 == null) {
                kotlin.jvm.internal.h.b("mProgressDialog");
            }
            progressDialog2.dismiss();
        }
        io.reactivex.disposables.b bVar = this.f12947a;
        if (bVar != null) {
            bVar.dispose();
        }
        if (e()) {
            this.xEagleApp.e().b(this.f12955p);
        }
        com.liulishuo.filedownloader.q.a().b();
        com.liulishuo.filedownloader.q.a().e();
        b();
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (!com.xeagle.android.utils.m.a().a()) {
            return super.onKeyDown(i2, keyEvent);
        }
        ToastUtils.showShort(getString(R.string.warn_compose_running), new Object[0]);
        return false;
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        com.shuyu.gsyvideoplayer.c.d();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        com.shuyu.gsyvideoplayer.c.j();
    }

    @org.greenrobot.eventbus.l(a = ThreadMode.BACKGROUND)
    public final void onTcpErrorEvent(ay ayVar) {
        if (this.camera_type == 1 && this.xEagleApp.g() != null) {
            this.xEagleApp.g().b();
            this.xEagleApp.g().e();
        }
    }

    @org.greenrobot.eventbus.l(a = ThreadMode.MAIN)
    public final void socSuccessEvent(jp.f fVar) {
        kotlin.jvm.internal.h.d(fVar, "event");
        int a2 = fVar.a();
        if (a2 == 2004) {
            Object b2 = fVar.b();
            Objects.requireNonNull(b2, "null cannot be cast to non-null type com.xeagle.android.login.beans.sochipBeans.SochipSdcardBean");
            if (((SochipSdcardBean) b2).getDisk_status() == 0) {
                String str = kx.d.e(getApplicationContext()) + "sunxi.db";
                try {
                    a(CameraGlobal.HTTP_FILE, str, new z(this), new aa(this, str));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else {
                Toast.makeText(this, getString(R.string.no_sd_card), 0).show();
                j();
            }
        } else if (a2 != 4003 || this.f12949c < 0) {
        } else {
            if (kotlin.jvm.internal.h.a((Object) this.f12951l, (Object) "IMAGE")) {
                SdPhotoAdapter sdPhotoAdapter = this.f12958s;
                if (sdPhotoAdapter == null) {
                    kotlin.jvm.internal.h.b("photoAdapter");
                }
                sdPhotoAdapter.remove(this.f12949c);
                return;
            }
            SdVideoAdapter sdVideoAdapter = this.f12952m;
            if (sdVideoAdapter == null) {
                kotlin.jvm.internal.h.b("myVideoAdapter");
            }
            sdVideoAdapter.remove(this.f12949c);
        }
    }
}
