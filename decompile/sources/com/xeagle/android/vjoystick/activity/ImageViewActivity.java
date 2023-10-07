package com.xeagle.android.vjoystick.activity;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.transition.Slide;
import android.util.Log;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import com.amap.api.maps.model.MyLocationStyle;
import com.blankj.utilcode.util.GsonUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.cfly.uav_pro.R;
import com.flypro.photoview_library.PhotoView;
import com.hoho.android.usb.usb.data_proxy.f;
import com.myusb.proxy.proto.Proxy;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.bean.ProgressBean;
import com.xeagle.android.login.retrofitLogin.CameraGlobal;
import com.xeagle.android.newUI.activity.BaseActivity;
import com.xeagle.android.newUI.widgets.RoundProgressBar;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.h;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.az;
import kotlinx.coroutines.bg;

public final class ImageViewActivity extends BaseActivity {

    /* renamed from: a  reason: collision with root package name */
    private boolean f24954a;

    /* renamed from: b  reason: collision with root package name */
    private OrientationEventListener f24955b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap f24956c;

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ImageViewActivity f24957a;

        a(ImageViewActivity imageViewActivity) {
            this.f24957a = imageViewActivity;
        }

        public final void onClick(View view) {
            this.f24957a.finish();
        }
    }

    public static final class b extends OrientationEventListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ImageViewActivity f24958a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(ImageViewActivity imageViewActivity, Context context) {
            super(context);
            this.f24958a = imageViewActivity;
        }

        public void onOrientationChanged(int i2) {
            ImageViewActivity imageViewActivity;
            int i3;
            if (i2 != -1 && i2 <= 350 && i2 >= 10) {
                if (81 <= i2 && 99 >= i2) {
                    i3 = 8;
                    if (this.f24958a.getRequestedOrientation() != 8) {
                        imageViewActivity = this.f24958a;
                    } else {
                        return;
                    }
                } else if ((171 > i2 || 189 < i2) && 261 <= i2 && 279 >= i2 && this.f24958a.getRequestedOrientation() != 9) {
                    imageViewActivity = this.f24958a;
                    i3 = 0;
                } else {
                    return;
                }
                imageViewActivity.setRequestedOrientation(i3);
            }
        }
    }

    public static final class c implements le.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ImageViewActivity f24959a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ RoundProgressBar f24960b;

        c(ImageViewActivity imageViewActivity, RoundProgressBar roundProgressBar) {
            this.f24959a = imageViewActivity;
            this.f24960b = roundProgressBar;
        }

        public void onFail(String str) {
            h.d(str, MyLocationStyle.ERROR_INFO);
            ToastUtils.showShort(this.f24959a.getString(R.string.down_failed), new Object[0]);
        }

        public void onFinishDownload() {
            RoundProgressBar roundProgressBar = this.f24960b;
            h.a((Object) roundProgressBar);
            roundProgressBar.setVisibility(8);
        }

        public void onProgress(int i2) {
            Log.i("newUI", "onProgress:---- " + i2);
            RoundProgressBar roundProgressBar = this.f24960b;
            h.a((Object) roundProgressBar);
            roundProgressBar.setProgress(i2);
        }

        public void onStartDownload() {
            RoundProgressBar roundProgressBar = this.f24960b;
            h.a((Object) roundProgressBar);
            roundProgressBar.setVisibility(0);
            this.f24960b.setProgress(0);
        }
    }

    public static final class d implements f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ImageViewActivity f24961a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef f24962b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ PhotoView f24963c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f24964d;

        d(ImageViewActivity imageViewActivity, Ref.ObjectRef objectRef, PhotoView photoView, String str) {
            this.f24961a = imageViewActivity;
            this.f24962b = objectRef;
            this.f24963c = photoView;
            this.f24964d = str;
        }

        public void a(int i2, int i3, int i4, String str, byte[] bArr) {
            h.d(str, "args");
            h.d(bArr, "arg4");
            ProgressBean progressBean = (ProgressBean) GsonUtils.fromJson(str, ProgressBean.class);
            double current = progressBean.getCurrent();
            double d2 = (double) 100;
            Double.isNaN(d2);
            int total = (int) ((current * d2) / progressBean.getTotal());
            RoundProgressBar roundProgressBar = (RoundProgressBar) this.f24961a.a(com.xeagle.R.id.image_pb);
            h.b(roundProgressBar, "image_pb");
            roundProgressBar.setProgress(total);
            try {
                BufferedOutputStream bufferedOutputStream = (BufferedOutputStream) this.f24962b.f30237a;
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.write(bArr);
                }
                BufferedOutputStream bufferedOutputStream2 = (BufferedOutputStream) this.f24962b.f30237a;
                if (bufferedOutputStream2 != null) {
                    bufferedOutputStream2.flush();
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }

        public void a(int i2, int i3, String str, Proxy.ConnType connType) {
            h.d(str, "arg3");
            h.d(connType, "connType");
            XEagleApp xEagleApp = this.f24961a.xEagleApp;
            h.b(xEagleApp, "xEagleApp");
            xEagleApp.e().b("DOWN_LOAD");
        }

        public void a(int i2, String str, int i3, Proxy.ConnType connType) {
            h.d(str, "args");
            h.d(connType, "http");
            try {
                BufferedOutputStream bufferedOutputStream = (BufferedOutputStream) this.f24962b.f30237a;
                h.a((Object) bufferedOutputStream);
                bufferedOutputStream.close();
                this.f24962b.f30237a = (BufferedOutputStream) null;
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            if (i3 == 0) {
                bg unused = g.a(az.f30335a, (kotlin.coroutines.f) null, (CoroutineStart) null, new ImageViewActivity$usbDownload$1$onEnd$1(this, (kotlin.coroutines.c) null), 3, (Object) null);
            } else {
                kw.a.a(this.f24964d);
            }
            XEagleApp xEagleApp = this.f24961a.xEagleApp;
            h.b(xEagleApp, "xEagleApp");
            xEagleApp.e().b("DOWN_LOAD");
        }

        public void a(int i2, String str, Proxy.ConnType connType) {
            h.d(str, "arg3");
            h.d(connType, "http");
        }
    }

    private final void a(String str, PhotoView photoView) {
        String g2 = kx.d.g(getApplicationContext());
        RoundProgressBar roundProgressBar = (RoundProgressBar) a(com.xeagle.R.id.image_pb);
        h.a((Object) roundProgressBar);
        roundProgressBar.setVisibility(0);
        RoundProgressBar roundProgressBar2 = (RoundProgressBar) a(com.xeagle.R.id.image_pb);
        h.b(roundProgressBar2, "image_pb");
        roundProgressBar2.setProgress(0);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.f30237a = (BufferedOutputStream) null;
        try {
            File file = new File(g2);
            if (file.exists()) {
                file.delete();
            }
            objectRef.f30237a = new BufferedOutputStream(new FileOutputStream(file, true));
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        }
        try {
            com.xeagle.android.communication.ftp.b a2 = com.xeagle.android.communication.ftp.c.a();
            XEagleApp xEagleApp = this.xEagleApp;
            h.b(xEagleApp, "xEagleApp");
            a2.a(xEagleApp, str, 13, new d(this, objectRef, photoView, g2));
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    private final void a(String str, String str2, RoundProgressBar roundProgressBar, PhotoView photoView) {
        le.d dVar = new le.d(str, new c(this, roundProgressBar));
        boolean a2 = kotlin.text.f.a((CharSequence) str2, (CharSequence) "AMBA", false, 2, (Object) null);
        dVar.a(str2, (ImageView) photoView);
    }

    public View a(int i2) {
        if (this.f24956c == null) {
            this.f24956c = new HashMap();
        }
        View view = (View) this.f24956c.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f24956c.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        getWindow().requestFeature(12);
        getWindow().requestFeature(13);
        Window window = getWindow();
        h.b(window, "window");
        window.setAllowEnterTransitionOverlap(false);
        Window window2 = getWindow();
        h.b(window2, "window");
        window2.setAllowReturnTransitionOverlap(false);
        Slide slide = new Slide();
        slide.setDuration(500);
        slide.setSlideEdge(48);
        slide.setMode(2);
        Window window3 = getWindow();
        h.b(window3, "window");
        window3.setEnterTransition(slide);
        setContentView((int) R.layout.image_view_activity);
        String stringExtra = getIntent().getStringExtra("image_name");
        Application application = getApplication();
        Objects.requireNonNull(application, "null cannot be cast to non-null type com.xeagle.android.XEagleApp");
        com.xeagle.android.a m2 = ((XEagleApp) application).m();
        h.b(m2, "(application as XEagleApp).appState");
        if (m2.a() == 2) {
            this.f24954a = false;
            a(CameraGlobal.BASE_URL, "http://172.50.10.1:8082" + stringExtra, (RoundProgressBar) a(com.xeagle.R.id.image_pb), (PhotoView) a(com.xeagle.R.id.preview_photo));
        } else {
            Application application2 = getApplication();
            Objects.requireNonNull(application2, "null cannot be cast to non-null type com.xeagle.android.XEagleApp");
            com.xeagle.android.a m3 = ((XEagleApp) application2).m();
            h.b(m3, "(application as XEagleApp).appState");
            if (m3.a() == 1) {
                h.a((Object) stringExtra);
                String a2 = kotlin.text.f.a(stringExtra, "/tmp/SD0/", "/SD/", false, 4, (Object) null);
                String str = "http://172.50.10.1" + a2;
                Context applicationContext = getApplicationContext();
                Objects.requireNonNull(applicationContext, "null cannot be cast to non-null type com.xeagle.android.XEagleApp");
                if (((XEagleApp) applicationContext).c()) {
                    String str2 = kx.d.s(getApplicationContext()) + com.xeagle.android.utils.c.h(a2);
                    if (new File(str2).exists()) {
                        this.f24954a = false;
                        PhotoView photoView = (PhotoView) a(com.xeagle.R.id.preview_photo);
                        if (photoView != null) {
                            photoView.setImageBitmap(com.xeagle.android.utils.c.b(str2));
                        }
                    } else {
                        this.f24954a = true;
                        a(stringExtra, (PhotoView) a(com.xeagle.R.id.preview_photo));
                    }
                } else {
                    this.f24954a = false;
                    a("http://172.50.10.1/", str, (RoundProgressBar) a(com.xeagle.R.id.image_pb), (PhotoView) a(com.xeagle.R.id.preview_photo));
                }
            }
        }
        findViewById(R.id.bt_back).setOnClickListener(new a(this));
        OrientationEventListener bVar = new b(this, this);
        this.f24955b = bVar;
        bVar.enable();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        OrientationEventListener orientationEventListener = this.f24955b;
        if (orientationEventListener == null) {
            h.b("mOrientationListener");
        }
        orientationEventListener.disable();
        if (this.f24954a) {
            File file = new File(kx.d.g(getApplicationContext()));
            if (file.exists()) {
                file.delete();
            }
        }
    }
}
