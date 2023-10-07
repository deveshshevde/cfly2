package com.xeagle.android.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import com.amap.api.mapcore.util.fx;
import com.blankj.utilcode.util.ToastUtils;
import com.cfly.uav_pro.R;
import com.ctoo.mediaedit.MyPhoto;
import com.ctoo.mediaedit.entity.MediaEditEntity;
import com.liulishuo.filedownloader.q;
import com.myusb.proxy.proto.Proxy;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.login.common.TimeUtil;
import com.xeagle.android.login.gsy.recycleView.ToolUtil;
import com.xeagle.android.login.pickImage.data.GLImage;
import com.xeagle.android.vjoystick.fragment.http_activity.HttpSdDetailActivity;
import cy.e;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.ap;
import kotlinx.coroutines.az;
import kotlinx.coroutines.bg;
import org.opencv.tracker.ImagesStitchUtil;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    private bg f24425a;

    /* renamed from: b  reason: collision with root package name */
    private long f24426b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f24427c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f24428d;

    /* renamed from: e  reason: collision with root package name */
    private int f24429e;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<lc.a> f24430f;

    /* renamed from: g  reason: collision with root package name */
    private XEagleApp f24431g;

    static final class a<T> implements Comparator<String> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f24432a = new a();

        a() {
        }

        /* renamed from: a */
        public final int compare(String str, String str2) {
            kotlin.jvm.internal.h.b(str, "s");
            CharSequence charSequence = str;
            int b2 = kotlin.text.f.b(charSequence, ".", 0, false, 6, (Object) null) - 8;
            int b3 = kotlin.text.f.b(charSequence, ".", 0, false, 6, (Object) null);
            Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
            String substring = str.substring(b2, b3);
            kotlin.jvm.internal.h.b(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            int parseInt = Integer.parseInt(substring);
            kotlin.jvm.internal.h.b(str2, "t1");
            CharSequence charSequence2 = str2;
            int b4 = kotlin.text.f.b(charSequence2, ".", 0, false, 6, (Object) null) - 8;
            int b5 = kotlin.text.f.b(charSequence2, ".", 0, false, 6, (Object) null);
            Objects.requireNonNull(str2, "null cannot be cast to non-null type java.lang.String");
            String substring2 = str2.substring(b4, b5);
            kotlin.jvm.internal.h.b(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return parseInt > Integer.parseInt(substring2) ? -1 : 0;
        }
    }

    public static final class b implements ImagesStitchUtil.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ l f24433a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ImagesStitchUtil.a f24434b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f24435c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Activity f24436d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f24437e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ String f24438f;

        b(l lVar, ImagesStitchUtil.a aVar, String str, Activity activity, String str2, String str3) {
            this.f24433a = lVar;
            this.f24434b = aVar;
            this.f24435c = str;
            this.f24436d = activity;
            this.f24437e = str2;
            this.f24438f = str3;
        }

        public void a(int i2) {
            this.f24434b.a(i2);
            this.f24433a.a(this.f24436d, i2);
        }

        public void a(String str) {
            Bitmap a2;
            Context context;
            int i2;
            float f2;
            String str2 = str;
            kotlin.jvm.internal.h.d(str2, GLImage.KEY_PATH);
            this.f24434b.a(str2);
            hf.d.b("LOOK_LOGcomp", "合成成功");
            l lVar = this.f24433a;
            lVar.a(lVar.c() + 1);
            XEagleApp d2 = this.f24433a.d();
            kotlin.jvm.internal.h.a((Object) d2);
            if (d2.g() != null) {
                XEagleApp d3 = this.f24433a.d();
                kotlin.jvm.internal.h.a((Object) d3);
                d3.g().a(this.f24435c, -1);
            }
            kw.a.a(new File(kx.d.u(this.f24436d)));
            if (kotlin.jvm.internal.h.a((Object) this.f24437e, (Object) "SAVE_A")) {
                Bitmap decodeFile = BitmapFactory.decodeFile(str);
                ArrayList arrayList = new ArrayList();
                for (int i3 = 1; i3 <= 80; i3++) {
                    if (1 <= i3 && 5 >= i3) {
                        context = this.f24436d;
                        i2 = i3 * 6;
                        f2 = 0.32f;
                    } else if (5 <= i3 && 60 >= i3) {
                        context = this.f24436d;
                        i2 = i3 * 6;
                        double d4 = (double) (i3 + 35);
                        Double.isNaN(d4);
                        double d5 = (double) 100;
                        Double.isNaN(d5);
                        f2 = (float) ((d4 * 0.8d) / d5);
                    } else {
                        double d6 = (double) (i3 + 35);
                        Double.isNaN(d6);
                        double d7 = (double) 100;
                        Double.isNaN(d7);
                        a2 = i.a(this.f24436d, decodeFile, 1, (float) ((d6 * 0.8d) / d7));
                        kotlin.jvm.internal.h.b(a2, "GPUImageUtil.getGpuImage…                        )");
                        arrayList.add(new MyPhoto((String) null, (Uri) null, (String) null, a2, "image/jpg", 0, 0, 0, 0, 2000, 0, false, false, 7655, (f) null));
                    }
                    a2 = i.a(context, decodeFile, i2, f2);
                    kotlin.jvm.internal.h.b(a2, "GPUImageUtil.getGpuImage…                        )");
                    arrayList.add(new MyPhoto((String) null, (Uri) null, (String) null, a2, "image/jpg", 0, 0, 0, 0, 2000, 0, false, false, 7655, (f) null));
                }
                this.f24433a.a(this.f24436d, "video_", (ArrayList<MyPhoto>) arrayList, this.f24437e, this.f24434b);
                return;
            }
            l lVar2 = this.f24433a;
            Activity activity = this.f24436d;
            String str3 = this.f24438f;
            kotlin.jvm.internal.h.b(str3, "tempPath");
            lVar2.b(activity, str3, R.string.img_comp_finish);
        }
    }

    static final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ l f24439a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f24440b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f24441c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f24442d;

        c(l lVar, Activity activity, int i2, String str) {
            this.f24439a = lVar;
            this.f24440b = activity;
            this.f24441c = i2;
            this.f24442d = str;
        }

        public final void run() {
            l lVar = this.f24439a;
            lVar.a(lVar.c() + 1);
            this.f24439a.f();
            ToastUtils.showShort(this.f24440b.getString(this.f24441c, new Object[]{this.f24442d}), new Object[0]);
            n.a(this.f24440b);
            this.f24439a.a(false);
            com.ctoo.mediaedit.utils.b.a(this.f24440b, this.f24442d);
        }
    }

    static final class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ l f24443a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f24444b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f24445c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Activity f24446d;

        d(l lVar, int i2, String str, Activity activity) {
            this.f24443a = lVar;
            this.f24444b = i2;
            this.f24445c = str;
            this.f24446d = activity;
        }

        public final void run() {
            l lVar = this.f24443a;
            lVar.a(lVar.c() + 1);
            this.f24443a.f();
            Log.i("LOOK_LOG", "compedImgFinish: =====msg===" + this.f24444b + "===tempPath===" + this.f24445c);
            ToastUtils.showShort(this.f24446d.getString(this.f24444b, new Object[]{this.f24445c}), new Object[0]);
            n.a(this.f24446d);
            Activity activity = this.f24446d;
            if (activity instanceof HttpSdDetailActivity) {
                ((HttpSdDetailActivity) activity).b();
            }
            this.f24443a.a(false);
            kx.c.a(this.f24446d, new File(this.f24445c));
        }
    }

    public static final class e extends com.liulishuo.filedownloader.g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ l f24447a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f24448b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ArrayList f24449c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f24450d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ XEagleApp f24451e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Activity f24452f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ String f24453g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ ImagesStitchUtil.a f24454h;

        e(l lVar, String str, ArrayList arrayList, int i2, XEagleApp xEagleApp, Activity activity, String str2, ImagesStitchUtil.a aVar) {
            this.f24447a = lVar;
            this.f24448b = str;
            this.f24449c = arrayList;
            this.f24450d = i2;
            this.f24451e = xEagleApp;
            this.f24452f = activity;
            this.f24453g = str2;
            this.f24454h = aVar;
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
        }

        /* access modifiers changed from: protected */
        public void a(com.liulishuo.filedownloader.a aVar, Throwable th) {
            kotlin.jvm.internal.h.d(aVar, "task");
            kotlin.jvm.internal.h.d(th, fx.f8867h);
            hf.d.b("RTSP", "error:===DOWNLOAD==== " + th.getMessage());
        }

        /* access modifiers changed from: protected */
        public void b(com.liulishuo.filedownloader.a aVar, long j2, long j3) {
            kotlin.jvm.internal.h.d(aVar, "task");
        }

        /* access modifiers changed from: protected */
        public void c(com.liulishuo.filedownloader.a aVar) {
            kotlin.jvm.internal.h.d(aVar, "task");
            if (this.f24447a.a()) {
                File file = new File(this.f24448b);
                if (file.exists()) {
                    l lVar = this.f24447a;
                    ArrayList arrayList = this.f24449c;
                    int i2 = this.f24450d;
                    XEagleApp xEagleApp = this.f24451e;
                    Activity activity = this.f24452f;
                    String absolutePath = file.getAbsolutePath();
                    kotlin.jvm.internal.h.b(absolutePath, "file.absolutePath");
                    lVar.a((ArrayList<lc.a>) arrayList, i2, xEagleApp, activity, absolutePath, this.f24453g, this.f24454h);
                }
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

    public static final class f extends com.liulishuo.filedownloader.g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ l f24455a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f24456b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ArrayList f24457c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f24458d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ XEagleApp f24459e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Activity f24460f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ File f24461g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ ImagesStitchUtil.a f24462h;

        f(l lVar, String str, ArrayList arrayList, int i2, XEagleApp xEagleApp, Activity activity, File file, ImagesStitchUtil.a aVar) {
            this.f24455a = lVar;
            this.f24456b = str;
            this.f24457c = arrayList;
            this.f24458d = i2;
            this.f24459e = xEagleApp;
            this.f24460f = activity;
            this.f24461g = file;
            this.f24462h = aVar;
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
        }

        /* access modifiers changed from: protected */
        public void a(com.liulishuo.filedownloader.a aVar, Throwable th) {
            kotlin.jvm.internal.h.d(aVar, "task");
            kotlin.jvm.internal.h.d(th, fx.f8867h);
            hf.d.b("CmdChannel", "error:--large-download---" + th.getMessage());
        }

        /* access modifiers changed from: protected */
        public void b(com.liulishuo.filedownloader.a aVar, long j2, long j3) {
            kotlin.jvm.internal.h.d(aVar, "task");
            hf.d.b("CmdChannel", "progress:--large--download--- " + j2);
        }

        /* access modifiers changed from: protected */
        public void c(com.liulishuo.filedownloader.a aVar) {
            kotlin.jvm.internal.h.d(aVar, "task");
            File file = new File(this.f24456b);
            hf.d.b("Media", "completed:--video-- " + this.f24456b);
            if (file.exists()) {
                this.f24455a.a((ArrayList<lc.a>) this.f24457c, this.f24458d, this.f24459e, this.f24460f, this.f24456b, this.f24461g, this.f24462h);
            }
        }

        /* access modifiers changed from: protected */
        public void c(com.liulishuo.filedownloader.a aVar, long j2, long j3) {
            kotlin.jvm.internal.h.d(aVar, "task");
        }

        /* access modifiers changed from: protected */
        public void d(com.liulishuo.filedownloader.a aVar) {
            kotlin.jvm.internal.h.d(aVar, "task");
        }
    }

    public static final class g implements com.hoho.android.usb.usb.data_proxy.f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ l f24463a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef f24464b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ArrayList f24465c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f24466d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ XEagleApp f24467e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Activity f24468f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ String f24469g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ String f24470h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ ImagesStitchUtil.a f24471i;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ long f24472j;

        /* renamed from: k  reason: collision with root package name */
        final /* synthetic */ ArrayList f24473k;

        g(l lVar, Ref.ObjectRef objectRef, ArrayList arrayList, int i2, XEagleApp xEagleApp, Activity activity, String str, String str2, ImagesStitchUtil.a aVar, long j2, ArrayList arrayList2) {
            this.f24463a = lVar;
            this.f24464b = objectRef;
            this.f24465c = arrayList;
            this.f24466d = i2;
            this.f24467e = xEagleApp;
            this.f24468f = activity;
            this.f24469g = str;
            this.f24470h = str2;
            this.f24471i = aVar;
            this.f24472j = j2;
            this.f24473k = arrayList2;
        }

        public void a(int i2, int i3, int i4, String str, byte[] bArr) {
            kotlin.jvm.internal.h.d(str, "args");
            kotlin.jvm.internal.h.d(bArr, "arg4");
            try {
                BufferedOutputStream bufferedOutputStream = (BufferedOutputStream) this.f24464b.f30237a;
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.write(bArr);
                }
                BufferedOutputStream bufferedOutputStream2 = (BufferedOutputStream) this.f24464b.f30237a;
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
            if (this.f24463a.a()) {
                Object obj = this.f24465c.get(this.f24466d);
                kotlin.jvm.internal.h.a(obj);
                kotlin.jvm.internal.h.b(obj, "imgList[i]!!");
                lc.a aVar = (lc.a) obj;
                aVar.a(2);
                this.f24465c.set(this.f24466d, aVar);
                long j2 = this.f24472j;
                ArrayList arrayList = this.f24473k;
                kotlin.jvm.internal.h.a((Object) arrayList);
                this.f24463a.a(this.f24467e, this.f24468f, (ArrayList<lc.a>) this.f24465c, this.f24466d + 1, j2, (ArrayList<lc.a>) arrayList, this.f24470h, this.f24471i);
                this.f24467e.e().b("DOWN_LOAD");
            }
        }

        public void a(int i2, String str, int i3, Proxy.ConnType connType) {
            kotlin.jvm.internal.h.d(str, "args");
            kotlin.jvm.internal.h.d(connType, "http");
            try {
                BufferedOutputStream bufferedOutputStream = (BufferedOutputStream) this.f24464b.f30237a;
                kotlin.jvm.internal.h.a((Object) bufferedOutputStream);
                bufferedOutputStream.close();
                this.f24464b.f30237a = (BufferedOutputStream) null;
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            if (i3 != 0) {
                this.f24463a.a(false);
                kw.a.a(this.f24469g);
            } else if (this.f24463a.a()) {
                bg unused = g.a(az.f30335a, ap.a(), (CoroutineStart) null, new ImageCompoundUtil$saveImages$3$onEnd$1(this, (kotlin.coroutines.c) null), 2, (Object) null);
            }
        }

        public void a(int i2, String str, Proxy.ConnType connType) {
            kotlin.jvm.internal.h.d(str, "arg3");
            kotlin.jvm.internal.h.d(connType, "http");
        }
    }

    public static final class h implements com.hoho.android.usb.usb.data_proxy.f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ l f24474a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef f24475b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ArrayList f24476c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f24477d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ XEagleApp f24478e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Activity f24479f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ String f24480g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ File f24481h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ ImagesStitchUtil.a f24482i;

        h(l lVar, Ref.ObjectRef objectRef, ArrayList arrayList, int i2, XEagleApp xEagleApp, Activity activity, String str, File file, ImagesStitchUtil.a aVar) {
            this.f24474a = lVar;
            this.f24475b = objectRef;
            this.f24476c = arrayList;
            this.f24477d = i2;
            this.f24478e = xEagleApp;
            this.f24479f = activity;
            this.f24480g = str;
            this.f24481h = file;
            this.f24482i = aVar;
        }

        public void a(int i2, int i3, int i4, String str, byte[] bArr) {
            kotlin.jvm.internal.h.d(str, "args");
            kotlin.jvm.internal.h.d(bArr, "arg4");
            try {
                BufferedOutputStream bufferedOutputStream = (BufferedOutputStream) this.f24475b.f30237a;
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.write(bArr);
                }
                BufferedOutputStream bufferedOutputStream2 = (BufferedOutputStream) this.f24475b.f30237a;
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
            this.f24478e.e().b("DOWN_LOAD");
        }

        public void a(int i2, String str, int i3, Proxy.ConnType connType) {
            kotlin.jvm.internal.h.d(str, "args");
            kotlin.jvm.internal.h.d(connType, "http");
            try {
                BufferedOutputStream bufferedOutputStream = (BufferedOutputStream) this.f24475b.f30237a;
                kotlin.jvm.internal.h.a((Object) bufferedOutputStream);
                bufferedOutputStream.close();
                this.f24475b.f30237a = (BufferedOutputStream) null;
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            if (i3 == 0) {
                bg unused = g.a(az.f30335a, (kotlin.coroutines.f) null, (CoroutineStart) null, new ImageCompoundUtil$saveVideo$3$onEnd$1(this, (kotlin.coroutines.c) null), 3, (Object) null);
            } else {
                this.f24474a.a(false);
                kw.a.a(this.f24480g);
            }
            this.f24478e.e().b("DOWN_LOAD");
        }

        public void a(int i2, String str, Proxy.ConnType connType) {
            kotlin.jvm.internal.h.d(str, "arg3");
            kotlin.jvm.internal.h.d(connType, "http");
        }
    }

    public static final class i implements e.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f24483a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ l f24484b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ArrayList f24485c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Activity f24486d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f24487e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ ImagesStitchUtil.a f24488f;

        i(String str, l lVar, ArrayList arrayList, Activity activity, String str2, ImagesStitchUtil.a aVar) {
            this.f24483a = str;
            this.f24484b = lVar;
            this.f24485c = arrayList;
            this.f24486d = activity;
            this.f24487e = str2;
            this.f24488f = aVar;
        }

        public void a() {
        }

        public void a(float f2) {
        }

        public void b() {
            this.f24488f.a("");
            hf.d.b("LOOK_LOGcomp", "videoComp: 视频合成成功");
            l lVar = this.f24484b;
            Activity activity = this.f24486d;
            String str = this.f24483a;
            kotlin.jvm.internal.h.b(str, "tempPath");
            lVar.a(activity, str, (int) R.string.video_comp_finish);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0045  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.app.Activity r3, int r4) {
        /*
            r2 = this;
            java.io.File r0 = new java.io.File
            r1 = r3
            android.content.Context r1 = (android.content.Context) r1
            java.lang.String r1 = kx.d.u(r1)
            r0.<init>(r1)
            kw.a.a((java.io.File) r0)
            r0 = 2131823280(0x7f110ab0, float:1.9279355E38)
            java.lang.String r0 = r3.getString(r0)
            java.lang.String r1 = "activity.getString(R.string.wrong_picture)"
            kotlin.jvm.internal.h.b(r0, r1)
            r1 = -1
            if (r4 == r1) goto L_0x002c
            r1 = 2
            if (r4 == r1) goto L_0x0022
            goto L_0x0038
        L_0x0022:
            r4 = 2131822492(0x7f11079c, float:1.9277757E38)
            java.lang.String r0 = r3.getString(r4)
            java.lang.String r4 = "activity.getString(R.string.read_error_image)"
            goto L_0x0035
        L_0x002c:
            r4 = 2131821510(0x7f1103c6, float:1.9275765E38)
            java.lang.String r0 = r3.getString(r4)
            java.lang.String r4 = "activity.getString(R.string.image_not_exist)"
        L_0x0035:
            kotlin.jvm.internal.h.b(r0, r4)
        L_0x0038:
            r4 = 0
            java.lang.Object[] r1 = new java.lang.Object[r4]
            com.blankj.utilcode.util.ToastUtils.showShort((java.lang.String) r0, (java.lang.Object[]) r1)
            com.xeagle.android.utils.n.a(r3)
            boolean r0 = r3 instanceof com.xeagle.android.vjoystick.fragment.http_activity.HttpSdDetailActivity
            if (r0 == 0) goto L_0x004a
            com.xeagle.android.vjoystick.fragment.http_activity.HttpSdDetailActivity r3 = (com.xeagle.android.vjoystick.fragment.http_activity.HttpSdDetailActivity) r3
            r3.b()
        L_0x004a:
            r2.f24427c = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.utils.l.a(android.app.Activity, int):void");
    }

    /* access modifiers changed from: private */
    public final void a(Activity activity, String str, int i2) {
        activity.runOnUiThread(new c(this, activity, i2, str));
    }

    private final void a(String str, String str2, Activity activity, ArrayList<lc.a> arrayList, XEagleApp xEagleApp, int i2, File file, ImagesStitchUtil.a aVar) {
        String str3;
        StringBuilder sb;
        String str4 = str;
        String str5 = str2;
        CharSequence charSequence = str5;
        if (kotlin.text.f.a(charSequence, (CharSequence) "AMBA", false, 2, (Object) null)) {
            str5 = kotlin.text.f.a(str2, "/tmp/SD0/", "/SD/", false, 4, (Object) null);
            str3 = kx.d.q(activity) + "/" + ToolUtil.getInstance().getAmbaPath(str5);
            sb = new StringBuilder();
        } else {
            int a2 = kotlin.text.f.a(charSequence, "/20", 0, false, 6, (Object) null);
            int length = str2.length();
            Objects.requireNonNull(str5, "null cannot be cast to non-null type java.lang.String");
            String substring = str5.substring(a2, length);
            kotlin.jvm.internal.h.b(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            str3 = kx.d.q(activity) + "video_" + kotlin.text.f.a(kotlin.text.f.a(substring, "_", "", false, 4, (Object) null), "/", "", false, 4, (Object) null);
            sb = new StringBuilder();
        }
        sb.append(str4);
        sb.append(str5);
        String str6 = str3;
        q.a().a(sb.toString()).a((com.liulishuo.filedownloader.i) new f(this, str6, arrayList, i2, xEagleApp, activity, file, aVar)).a(str6).c();
    }

    private final void a(String str, String str2, Activity activity, ArrayList<lc.a> arrayList, XEagleApp xEagleApp, int i2, String str3, ImagesStitchUtil.a aVar) {
        String str4;
        StringBuilder sb;
        String str5 = str;
        String str6 = str2;
        CharSequence charSequence = str6;
        if (kotlin.text.f.a(charSequence, (CharSequence) "AMBA", false, 2, (Object) null)) {
            str6 = kotlin.text.f.a(str2, "/tmp/SD0/", "/SD/", false, 4, (Object) null);
            str4 = kx.d.u(activity) + "/" + c.h(str6);
            sb = new StringBuilder();
        } else {
            int a2 = kotlin.text.f.a(charSequence, "/20", 0, false, 6, (Object) null);
            int length = str2.length();
            Objects.requireNonNull(str6, "null cannot be cast to non-null type java.lang.String");
            String substring = str6.substring(a2, length);
            kotlin.jvm.internal.h.b(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            str4 = kx.d.u(activity) + "image_" + kotlin.text.f.a(kotlin.text.f.a(substring, "_", "", false, 4, (Object) null), "/", "", false, 4, (Object) null);
            sb = new StringBuilder();
        }
        sb.append(str5);
        sb.append(str6);
        String str7 = str4;
        q.a().a(sb.toString()).a((com.liulishuo.filedownloader.i) new e(this, str7, arrayList, i2, xEagleApp, activity, str3, aVar)).a(str7).c();
    }

    private final void a(String str, ArrayList<String> arrayList, Activity activity, String str2, ImagesStitchUtil.a aVar) {
        this.f24425a = g.a(az.f30335a, ap.a(), (CoroutineStart) null, new ImageCompoundUtil$imageSynthesis$1(this, str2, arrayList, activity, aVar, str, (kotlin.coroutines.c) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void a(String str, ArrayList<String> arrayList, String str2, Activity activity, ImagesStitchUtil.a aVar) {
        File a2 = kx.d.a(new File(kx.d.s(activity)), "image_", ".jpg");
        kotlin.jvm.internal.h.b(a2, "DirectoryPath.createFile…         \".jpg\"\n        )");
        String absolutePath = a2.getAbsolutePath();
        Collections.sort(arrayList, g());
        hf.d.b("LOOK_LOGcomp", "开始合成图片");
        boolean z2 = arrayList.size() == 25 || arrayList.size() == 31;
        Object[] array = arrayList.toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        ImagesStitchUtil.a(activity, (String[]) array, absolutePath, z2, (ImagesStitchUtil.a) new b(this, aVar, str, activity, str2, absolutePath));
    }

    /* access modifiers changed from: private */
    public final void a(ArrayList<lc.a> arrayList, int i2, XEagleApp xEagleApp, Activity activity, String str, File file, ImagesStitchUtil.a aVar) {
        String str2 = str;
        lc.a aVar2 = arrayList.get(i2);
        kotlin.jvm.internal.h.b(aVar2, "imgList[i]");
        lc.a aVar3 = aVar2;
        aVar3.a(2);
        arrayList.set(i2, aVar3);
        a(xEagleApp, activity, arrayList, i2 + 1, this.f24427c, file, aVar);
        if (Build.VERSION.SDK_INT >= 30) {
            ku.b.a(str, (Context) activity);
        } else {
            ku.b.b(activity, new File(str));
        }
    }

    /* access modifiers changed from: private */
    public final void a(ArrayList<lc.a> arrayList, int i2, XEagleApp xEagleApp, Activity activity, String str, String str2, ImagesStitchUtil.a aVar) {
        lc.a aVar2 = arrayList.get(i2);
        kotlin.jvm.internal.h.a((Object) aVar2);
        kotlin.jvm.internal.h.b(aVar2, "imgList[i]!!");
        lc.a aVar3 = aVar2;
        aVar3.a(2);
        arrayList.set(i2, aVar3);
        xEagleApp.e().b("DOWN_LOAD");
        long j2 = this.f24426b;
        ArrayList<lc.a> arrayList2 = this.f24430f;
        kotlin.jvm.internal.h.a((Object) arrayList2);
        XEagleApp xEagleApp2 = xEagleApp;
        Activity activity2 = activity;
        a(xEagleApp2, activity2, arrayList, i2 + 1, j2, arrayList2, str2, aVar);
        kx.c.a(activity, new File(str));
    }

    /* access modifiers changed from: private */
    public final void b(Activity activity, String str, int i2) {
        activity.runOnUiThread(new d(this, i2, str, activity));
    }

    /* access modifiers changed from: private */
    public final void f() {
        long currentTimeMillis = System.currentTimeMillis() - this.f24426b;
        hf.d.b("LOOK_LOG", "耗时: " + TimeUtil.getDateTimeString(currentTimeMillis, TimeUtil.DEF_MM_SS));
    }

    private final Comparator<? super String> g() {
        return a.f24432a;
    }

    public final void a(int i2) {
        this.f24429e = i2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003e A[Catch:{ IOException -> 0x00f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0046 A[Catch:{ IOException -> 0x00f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x005e A[Catch:{ IOException -> 0x00f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0061 A[Catch:{ IOException -> 0x00f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0075 A[Catch:{ IOException -> 0x00f1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00b6 A[SYNTHETIC, Splitter:B:34:0x00b6] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00d8 A[Catch:{ IOException -> 0x00f1 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.app.Activity r13, java.lang.String r14, java.util.ArrayList<com.ctoo.mediaedit.MyPhoto> r15, java.lang.String r16, org.opencv.tracker.ImagesStitchUtil.a r17) {
        /*
            r12 = this;
            r9 = r12
            r0 = r13
            r1 = r14
            r2 = r15
            r3 = r16
            java.lang.String r4 = "LOOK_LOGcomp"
            java.lang.String r5 = "context"
            kotlin.jvm.internal.h.d(r13, r5)
            java.lang.String r5 = "videoName"
            kotlin.jvm.internal.h.d(r14, r5)
            java.lang.String r5 = "photos"
            kotlin.jvm.internal.h.d(r15, r5)
            java.lang.String r5 = "saveType"
            kotlin.jvm.internal.h.d(r3, r5)
            java.lang.String r5 = "listener"
            r8 = r17
            kotlin.jvm.internal.h.d(r8, r5)
            java.lang.String r5 = "开始图片合成视频"
            hf.d.b(r4, r5)     // Catch:{ IOException -> 0x00f1 }
            java.io.File r5 = new java.io.File     // Catch:{ IOException -> 0x00f1 }
            java.util.ArrayList<lc.a> r6 = r9.f24430f     // Catch:{ IOException -> 0x00f1 }
            java.util.Collection r6 = (java.util.Collection) r6     // Catch:{ IOException -> 0x00f1 }
            r7 = 0
            r10 = 1
            if (r6 == 0) goto L_0x003b
            boolean r6 = r6.isEmpty()     // Catch:{ IOException -> 0x00f1 }
            if (r6 == 0) goto L_0x0039
            goto L_0x003b
        L_0x0039:
            r6 = 0
            goto L_0x003c
        L_0x003b:
            r6 = 1
        L_0x003c:
            if (r6 == 0) goto L_0x0046
            r6 = r0
            android.content.Context r6 = (android.content.Context) r6     // Catch:{ IOException -> 0x00f1 }
            java.lang.String r6 = kx.d.q(r6)     // Catch:{ IOException -> 0x00f1 }
            goto L_0x004d
        L_0x0046:
            r6 = r0
            android.content.Context r6 = (android.content.Context) r6     // Catch:{ IOException -> 0x00f1 }
            java.lang.String r6 = kx.d.u(r6)     // Catch:{ IOException -> 0x00f1 }
        L_0x004d:
            r5.<init>(r6)     // Catch:{ IOException -> 0x00f1 }
            java.lang.String r6 = ".mp4"
            java.io.File r11 = kx.d.a(r5, r14, r6)     // Catch:{ IOException -> 0x00f1 }
            java.lang.String r1 = "SAVE_C"
            boolean r1 = kotlin.jvm.internal.h.a((java.lang.Object) r3, (java.lang.Object) r1)     // Catch:{ IOException -> 0x00f1 }
            if (r1 == 0) goto L_0x0061
            r1 = 30
            goto L_0x0063
        L_0x0061:
            r1 = 10
        L_0x0063:
            com.xeagle.android.utils.t r3 = new com.xeagle.android.utils.t     // Catch:{ IOException -> 0x00f1 }
            r3.<init>(r11, r1)     // Catch:{ IOException -> 0x00f1 }
            r1 = r2
            java.lang.Iterable r1 = (java.lang.Iterable) r1     // Catch:{ IOException -> 0x00f1 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ IOException -> 0x00f1 }
        L_0x006f:
            boolean r2 = r1.hasNext()     // Catch:{ IOException -> 0x00f1 }
            if (r2 == 0) goto L_0x009d
            java.lang.Object r2 = r1.next()     // Catch:{ IOException -> 0x00f1 }
            com.ctoo.mediaedit.MyPhoto r2 = (com.ctoo.mediaedit.MyPhoto) r2     // Catch:{ IOException -> 0x00f1 }
            java.lang.String r5 = r2.a()     // Catch:{ IOException -> 0x00f1 }
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ IOException -> 0x00f1 }
            int r5 = r5.length()     // Catch:{ IOException -> 0x00f1 }
            if (r5 <= 0) goto L_0x0089
            r5 = 1
            goto L_0x008a
        L_0x0089:
            r5 = 0
        L_0x008a:
            if (r5 == 0) goto L_0x0098
            java.lang.String r2 = r2.a()     // Catch:{ IOException -> 0x00f1 }
            android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeFile(r2)     // Catch:{ IOException -> 0x00f1 }
        L_0x0094:
            r3.a(r2)     // Catch:{ IOException -> 0x00f1 }
            goto L_0x006f
        L_0x0098:
            android.graphics.Bitmap r2 = r2.b()     // Catch:{ IOException -> 0x00f1 }
            goto L_0x0094
        L_0x009d:
            r3.a()     // Catch:{ IOException -> 0x00f1 }
            java.lang.String r1 = "图片合成视频成功"
            hf.d.b(r4, r1)     // Catch:{ IOException -> 0x00f1 }
            java.util.ArrayList<lc.a> r1 = r9.f24430f     // Catch:{ IOException -> 0x00f1 }
            java.util.Collection r1 = (java.util.Collection) r1     // Catch:{ IOException -> 0x00f1 }
            if (r1 == 0) goto L_0x00b1
            boolean r1 = r1.isEmpty()     // Catch:{ IOException -> 0x00f1 }
            if (r1 == 0) goto L_0x00b2
        L_0x00b1:
            r7 = 1
        L_0x00b2:
            java.lang.String r1 = "out"
            if (r7 == 0) goto L_0x00d8
            java.io.File r2 = new java.io.File     // Catch:{ IOException -> 0x00f1 }
            r3 = r0
            android.content.Context r3 = (android.content.Context) r3     // Catch:{ IOException -> 0x00f1 }
            java.lang.String r3 = kx.d.u(r3)     // Catch:{ IOException -> 0x00f1 }
            r2.<init>(r3)     // Catch:{ IOException -> 0x00f1 }
            kw.a.a((java.io.File) r2)     // Catch:{ IOException -> 0x00f1 }
            kotlin.jvm.internal.h.b(r11, r1)     // Catch:{ IOException -> 0x00f1 }
            java.lang.String r1 = r11.getAbsolutePath()     // Catch:{ IOException -> 0x00f1 }
            java.lang.String r2 = "out.absolutePath"
            kotlin.jvm.internal.h.b(r1, r2)     // Catch:{ IOException -> 0x00f1 }
            r2 = 2131823142(0x7f110a26, float:1.9279075E38)
            r12.a((android.app.Activity) r13, (java.lang.String) r1, (int) r2)     // Catch:{ IOException -> 0x00f1 }
            return
        L_0x00d8:
            com.xeagle.android.XEagleApp r2 = r9.f24431g     // Catch:{ IOException -> 0x00f1 }
            kotlin.jvm.internal.h.a((java.lang.Object) r2)     // Catch:{ IOException -> 0x00f1 }
            java.util.ArrayList<lc.a> r4 = r9.f24430f     // Catch:{ IOException -> 0x00f1 }
            kotlin.jvm.internal.h.a((java.lang.Object) r4)     // Catch:{ IOException -> 0x00f1 }
            r5 = 0
            boolean r6 = r9.f24427c     // Catch:{ IOException -> 0x00f1 }
            kotlin.jvm.internal.h.b(r11, r1)     // Catch:{ IOException -> 0x00f1 }
            r1 = r12
            r3 = r13
            r7 = r11
            r8 = r17
            r1.a((com.xeagle.android.XEagleApp) r2, (android.app.Activity) r3, (java.util.ArrayList<lc.a>) r4, (int) r5, (boolean) r6, (java.io.File) r7, (org.opencv.tracker.ImagesStitchUtil.a) r8)     // Catch:{ IOException -> 0x00f1 }
            goto L_0x0108
        L_0x00f1:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "执行异常 "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.String r1 = "LOOK_LOG"
            hf.d.a(r1, r0)
        L_0x0108:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.utils.l.a(android.app.Activity, java.lang.String, java.util.ArrayList, java.lang.String, org.opencv.tracker.ImagesStitchUtil$a):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00f0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.xeagle.android.XEagleApp r22, android.app.Activity r23, java.util.ArrayList<lc.a> r24, int r25, long r26, java.util.ArrayList<lc.a> r28, java.lang.String r29, org.opencv.tracker.ImagesStitchUtil.a r30) {
        /*
            r21 = this;
            r14 = r21
            r15 = r22
            r7 = r23
            r5 = r24
            r13 = r25
            r11 = r28
            java.lang.String r0 = "xEagleApp"
            kotlin.jvm.internal.h.d(r15, r0)
            java.lang.String r0 = "activity"
            kotlin.jvm.internal.h.d(r7, r0)
            java.lang.String r0 = "imgList"
            kotlin.jvm.internal.h.d(r5, r0)
            java.lang.String r0 = "videoList"
            kotlin.jvm.internal.h.d(r11, r0)
            java.lang.String r0 = "saveType"
            r9 = r29
            kotlin.jvm.internal.h.d(r9, r0)
            java.lang.String r0 = "listener"
            r10 = r30
            kotlin.jvm.internal.h.d(r10, r0)
            r14.f24429e = r13
            r3 = r26
            r14.f24426b = r3
            r14.f24430f = r11
            r14.f24431g = r15
            r0 = 1
            r14.f24427c = r0
            r1 = r5
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            boolean r2 = r1 instanceof java.util.Collection
            r6 = 0
            if (r2 == 0) goto L_0x004e
            r2 = r1
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x004e
        L_0x004c:
            r1 = 1
            goto L_0x006a
        L_0x004e:
            java.util.Iterator r1 = r1.iterator()
        L_0x0052:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x004c
            java.lang.Object r2 = r1.next()
            lc.a r2 = (lc.a) r2
            int r2 = r2.e()
            if (r2 != r0) goto L_0x0066
            r2 = 1
            goto L_0x0067
        L_0x0066:
            r2 = 0
        L_0x0067:
            if (r2 == 0) goto L_0x0052
            r1 = 0
        L_0x006a:
            if (r1 == 0) goto L_0x00f0
            java.lang.Object r0 = r5.get(r6)
            lc.a r0 = (lc.a) r0
            java.lang.String r0 = r0.c()
            r15 = r0
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            r17 = 0
            r18 = 0
            r19 = 6
            r20 = 0
            java.lang.String r16 = "/"
            int r1 = kotlin.text.f.b((java.lang.CharSequence) r15, (java.lang.String) r16, (int) r17, (boolean) r18, (int) r19, (java.lang.Object) r20)
            java.lang.String r2 = "null cannot be cast to non-null type java.lang.String"
            java.util.Objects.requireNonNull(r0, r2)
            java.lang.String r15 = r0.substring(r6, r1)
            java.lang.String r0 = "(this as java.lang.Strin…ing(startIndex, endIndex)"
            kotlin.jvm.internal.h.b(r15, r0)
            r18 = 0
            r19 = 4
            r20 = 0
            java.lang.String r16 = "//"
            java.lang.String r17 = "/"
            java.lang.String r2 = kotlin.text.f.a((java.lang.String) r15, (java.lang.String) r16, (java.lang.String) r17, (boolean) r18, (int) r19, (java.lang.Object) r20)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "saveImages: =======compose=="
            r0.append(r1)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "LOOK_LOG"
            android.util.Log.i(r1, r0)
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.io.File r0 = new java.io.File
            r1 = r7
            android.content.Context r1 = (android.content.Context) r1
            java.lang.String r1 = kx.d.u(r1)
            r0.<init>(r1)
            java.io.File[] r0 = r0.listFiles()
            if (r0 == 0) goto L_0x00e4
            int r1 = r0.length
        L_0x00d1:
            if (r6 >= r1) goto L_0x00e4
            r4 = r0[r6]
            java.lang.String r5 = "it"
            kotlin.jvm.internal.h.b(r4, r5)
            java.lang.String r4 = r4.getAbsolutePath()
            r3.add(r4)
            int r6 = r6 + 1
            goto L_0x00d1
        L_0x00e4:
            r1 = r21
            r4 = r23
            r5 = r29
            r6 = r30
            r1.a((java.lang.String) r2, (java.util.ArrayList<java.lang.String>) r3, (android.app.Activity) r4, (java.lang.String) r5, (org.opencv.tracker.ImagesStitchUtil.a) r6)
            return
        L_0x00f0:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "正在下载图片"
            r1.append(r2)
            r1.append(r13)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "LOOK_LOGcomp"
            hf.d.b(r2, r1)
            java.lang.Object r1 = r24.get(r25)
            lc.a r1 = (lc.a) r1
            java.lang.String r12 = r1.c()
            com.xeagle.android.a r1 = r22.m()
            java.lang.String r2 = "xEagleApp.appState"
            kotlin.jvm.internal.h.b(r1, r2)
            int r1 = r1.a()
            if (r1 != r0) goto L_0x01a0
            boolean r0 = r22.c()
            if (r0 == 0) goto L_0x019b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = r7
            android.content.Context r1 = (android.content.Context) r1
            java.lang.String r1 = kx.d.u(r1)
            r0.append(r1)
            java.lang.String r1 = "/"
            r0.append(r1)
            com.xeagle.android.login.gsy.recycleView.ToolUtil r1 = com.xeagle.android.login.gsy.recycleView.ToolUtil.getInstance()
            java.lang.String r1 = r1.getAmbaPath(r12)
            r0.append(r1)
            java.lang.String r8 = r0.toString()
            kotlin.jvm.internal.Ref$ObjectRef r6 = new kotlin.jvm.internal.Ref$ObjectRef
            r6.<init>()
            r0 = 0
            java.io.BufferedOutputStream r0 = (java.io.BufferedOutputStream) r0
            r6.f30237a = r0
            java.io.File r0 = new java.io.File     // Catch:{ FileNotFoundException -> 0x0166 }
            r0.<init>(r8)     // Catch:{ FileNotFoundException -> 0x0166 }
            java.io.BufferedOutputStream r1 = new java.io.BufferedOutputStream     // Catch:{ FileNotFoundException -> 0x0166 }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0166 }
            r2.<init>(r0)     // Catch:{ FileNotFoundException -> 0x0166 }
            java.io.OutputStream r2 = (java.io.OutputStream) r2     // Catch:{ FileNotFoundException -> 0x0166 }
            r1.<init>(r2)     // Catch:{ FileNotFoundException -> 0x0166 }
            r6.f30237a = r1     // Catch:{ FileNotFoundException -> 0x0166 }
            goto L_0x016a
        L_0x0166:
            r0 = move-exception
            r0.printStackTrace()
        L_0x016a:
            com.xeagle.android.communication.ftp.b r0 = com.xeagle.android.communication.ftp.c.a()     // Catch:{ Exception -> 0x0196 }
            com.xeagle.android.utils.l$g r16 = new com.xeagle.android.utils.l$g     // Catch:{ Exception -> 0x0196 }
            r1 = r16
            r2 = r21
            r3 = r6
            r4 = r24
            r5 = r25
            r6 = r22
            r7 = r23
            r9 = r29
            r10 = r30
            r14 = r12
            r11 = r26
            r17 = r14
            r14 = r13
            r13 = r28
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r13)     // Catch:{ Exception -> 0x0196 }
            r1 = r16
            com.hoho.android.usb.usb.data_proxy.f r1 = (com.hoho.android.usb.usb.data_proxy.f) r1     // Catch:{ Exception -> 0x0196 }
            r3 = r17
            r0.a(r15, r3, r14, r1)     // Catch:{ Exception -> 0x0196 }
            goto L_0x01c0
        L_0x0196:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x01c0
        L_0x019b:
            r3 = r12
            r14 = r13
            java.lang.String r2 = "http://172.50.10.1/"
            goto L_0x01af
        L_0x01a0:
            r3 = r12
            r14 = r13
            com.xeagle.android.a r0 = r22.m()
            int r0 = r0.a()
            r1 = 2
            if (r0 != r1) goto L_0x01c0
            java.lang.String r2 = "http://172.50.10.1:8082"
        L_0x01af:
            r1 = r21
            r4 = r23
            r5 = r24
            r6 = r22
            r7 = r25
            r8 = r29
            r9 = r30
            r1.a((java.lang.String) r2, (java.lang.String) r3, (android.app.Activity) r4, (java.util.ArrayList<lc.a>) r5, (com.xeagle.android.XEagleApp) r6, (int) r7, (java.lang.String) r8, (org.opencv.tracker.ImagesStitchUtil.a) r9)
        L_0x01c0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.utils.l.a(com.xeagle.android.XEagleApp, android.app.Activity, java.util.ArrayList, int, long, java.util.ArrayList, java.lang.String, org.opencv.tracker.ImagesStitchUtil$a):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x008b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.xeagle.android.XEagleApp r16, android.app.Activity r17, java.util.ArrayList<lc.a> r18, int r19, boolean r20, java.io.File r21, org.opencv.tracker.ImagesStitchUtil.a r22) {
        /*
            r15 = this;
            r11 = r15
            r12 = r16
            r7 = r17
            r5 = r18
            r10 = r22
            java.lang.String r0 = "xEagleApp"
            kotlin.jvm.internal.h.d(r12, r0)
            java.lang.String r0 = "activity"
            kotlin.jvm.internal.h.d(r7, r0)
            java.lang.String r0 = "videoList"
            kotlin.jvm.internal.h.d(r5, r0)
            java.lang.String r0 = "out"
            r9 = r21
            kotlin.jvm.internal.h.d(r9, r0)
            java.lang.String r0 = "listener"
            kotlin.jvm.internal.h.d(r10, r0)
            r0 = r20
            r11.f24427c = r0
            r0 = r5
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            boolean r1 = r0 instanceof java.util.Collection
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x003c
            r1 = r0
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x003c
        L_0x003a:
            r0 = 1
            goto L_0x0058
        L_0x003c:
            java.util.Iterator r0 = r0.iterator()
        L_0x0040:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x003a
            java.lang.Object r1 = r0.next()
            lc.a r1 = (lc.a) r1
            int r1 = r1.e()
            if (r1 != r3) goto L_0x0054
            r1 = 1
            goto L_0x0055
        L_0x0054:
            r1 = 0
        L_0x0055:
            if (r1 == 0) goto L_0x0040
            r0 = 0
        L_0x0058:
            if (r0 == 0) goto L_0x008b
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.io.File r1 = new java.io.File
            r3 = r7
            android.content.Context r3 = (android.content.Context) r3
            java.lang.String r3 = kx.d.u(r3)
            r1.<init>(r3)
            java.io.File[] r1 = r1.listFiles()
            if (r1 == 0) goto L_0x0085
            int r3 = r1.length
        L_0x0072:
            if (r2 >= r3) goto L_0x0085
            r4 = r1[r2]
            java.lang.String r5 = "it"
            kotlin.jvm.internal.h.b(r4, r5)
            java.lang.String r4 = r4.getAbsolutePath()
            r0.add(r4)
            int r2 = r2 + 1
            goto L_0x0072
        L_0x0085:
            java.lang.String r1 = "video_"
            r15.a((java.lang.String) r1, (java.util.ArrayList<java.lang.String>) r0, (android.app.Activity) r7, (org.opencv.tracker.ImagesStitchUtil.a) r10)
            return
        L_0x008b:
            java.lang.String r0 = "LOOK_LOGcomp"
            java.lang.String r1 = "开始下载视频"
            hf.d.b(r0, r1)
            java.lang.Object r0 = r18.get(r19)
            lc.a r0 = (lc.a) r0
            java.lang.String r13 = r0.c()
            com.xeagle.android.a r0 = r16.m()
            java.lang.String r1 = "xEagleApp.appState"
            kotlin.jvm.internal.h.b(r0, r1)
            int r0 = r0.a()
            if (r0 != r3) goto L_0x011f
            boolean r0 = r16.c()
            if (r0 == 0) goto L_0x011a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = r7
            android.content.Context r1 = (android.content.Context) r1
            java.lang.String r1 = kx.d.u(r1)
            r0.append(r1)
            java.lang.String r1 = "/"
            r0.append(r1)
            com.xeagle.android.login.gsy.recycleView.ToolUtil r1 = com.xeagle.android.login.gsy.recycleView.ToolUtil.getInstance()
            java.lang.String r1 = r1.getAmbaPath(r13)
            r0.append(r1)
            java.lang.String r8 = r0.toString()
            kotlin.jvm.internal.Ref$ObjectRef r3 = new kotlin.jvm.internal.Ref$ObjectRef
            r3.<init>()
            r0 = 0
            java.io.BufferedOutputStream r0 = (java.io.BufferedOutputStream) r0
            r3.f30237a = r0
            java.io.File r0 = new java.io.File     // Catch:{ FileNotFoundException -> 0x00f2 }
            r0.<init>(r8)     // Catch:{ FileNotFoundException -> 0x00f2 }
            java.io.BufferedOutputStream r1 = new java.io.BufferedOutputStream     // Catch:{ FileNotFoundException -> 0x00f2 }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x00f2 }
            r2.<init>(r0)     // Catch:{ FileNotFoundException -> 0x00f2 }
            java.io.OutputStream r2 = (java.io.OutputStream) r2     // Catch:{ FileNotFoundException -> 0x00f2 }
            r1.<init>(r2)     // Catch:{ FileNotFoundException -> 0x00f2 }
            r3.f30237a = r1     // Catch:{ FileNotFoundException -> 0x00f2 }
            goto L_0x00f6
        L_0x00f2:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00f6:
            com.xeagle.android.communication.ftp.b r0 = com.xeagle.android.communication.ftp.c.a()     // Catch:{ Exception -> 0x0115 }
            com.xeagle.android.utils.l$h r14 = new com.xeagle.android.utils.l$h     // Catch:{ Exception -> 0x0115 }
            r1 = r14
            r2 = r15
            r4 = r18
            r5 = r19
            r6 = r16
            r7 = r17
            r9 = r21
            r10 = r22
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x0115 }
            com.hoho.android.usb.usb.data_proxy.f r14 = (com.hoho.android.usb.usb.data_proxy.f) r14     // Catch:{ Exception -> 0x0115 }
            r8 = r19
            r0.a(r12, r13, r8, r14)     // Catch:{ Exception -> 0x0115 }
            goto L_0x013f
        L_0x0115:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x013f
        L_0x011a:
            r8 = r19
            java.lang.String r2 = "http://172.50.10.1/"
            goto L_0x012e
        L_0x011f:
            r8 = r19
            com.xeagle.android.a r0 = r16.m()
            int r0 = r0.a()
            r1 = 2
            if (r0 != r1) goto L_0x013f
            java.lang.String r2 = "http://172.50.10.1:8082"
        L_0x012e:
            r1 = r15
            r3 = r13
            r4 = r17
            r5 = r18
            r6 = r16
            r7 = r19
            r8 = r21
            r9 = r22
            r1.a((java.lang.String) r2, (java.lang.String) r3, (android.app.Activity) r4, (java.util.ArrayList<lc.a>) r5, (com.xeagle.android.XEagleApp) r6, (int) r7, (java.io.File) r8, (org.opencv.tracker.ImagesStitchUtil.a) r9)
        L_0x013f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.utils.l.a(com.xeagle.android.XEagleApp, android.app.Activity, java.util.ArrayList, int, boolean, java.io.File, org.opencv.tracker.ImagesStitchUtil$a):void");
    }

    public final void a(String str, ArrayList<String> arrayList, Activity activity, ImagesStitchUtil.a aVar) {
        String str2 = str;
        ArrayList<String> arrayList2 = arrayList;
        Activity activity2 = activity;
        kotlin.jvm.internal.h.d(str2, "videoName");
        kotlin.jvm.internal.h.d(arrayList2, "paths");
        kotlin.jvm.internal.h.d(activity2, "activity");
        kotlin.jvm.internal.h.d(aVar, "listener");
        hf.d.b("LOOK_LOGcomp", "videoComp: 开始视频合成");
        kotlin.collections.h.c(arrayList2);
        File a2 = kx.d.a(new File(kx.d.q(activity2)), str2, ".mp4");
        kotlin.jvm.internal.h.b(a2, "DirectoryPath.createFile… \".mp4\"\n                )");
        String absolutePath = a2.getAbsolutePath();
        ArrayList arrayList3 = new ArrayList();
        for (String file : arrayList2) {
            File file2 = new File(file);
            Uri parse = Uri.parse("file://" + file2);
            Uri uri = parse;
            String name = file2.getName();
            kotlin.jvm.internal.h.b(name, "mTempImageFile.name");
            kotlin.jvm.internal.h.b(parse, "uri");
            String absolutePath2 = file2.getAbsolutePath();
            kotlin.jvm.internal.h.b(absolutePath2, "mTempImageFile.absolutePath");
            MyPhoto myPhoto = new MyPhoto(name, uri, absolutePath2, (Bitmap) null, "video/mp4", 1080, 1920, 0, file2.length(), hw.a.a(file2.getAbsolutePath()), file2.lastModified() / ((long) 1000), false, false, 6152, (f) null);
            arrayList3.add(com.ctoo.mediaedit.a.f10788a.a(myPhoto));
        }
        cy.e eVar = new cy.e(activity.getResources());
        eVar.a((List<MediaEditEntity>) arrayList3, absolutePath);
        eVar.a(new i(absolutePath, this, arrayList, activity, str, aVar));
        eVar.start();
    }

    public final void a(boolean z2) {
        this.f24427c = z2;
    }

    public final boolean a() {
        return this.f24427c;
    }

    public final void b(boolean z2) {
        this.f24428d = z2;
    }

    public final boolean b() {
        return this.f24428d;
    }

    public final int c() {
        return this.f24429e;
    }

    public final XEagleApp d() {
        return this.f24431g;
    }

    public final void e() {
        bg bgVar = this.f24425a;
        if (bgVar != null) {
            bg.a.a(bgVar, (CancellationException) null, 1, (Object) null);
        }
    }
}
