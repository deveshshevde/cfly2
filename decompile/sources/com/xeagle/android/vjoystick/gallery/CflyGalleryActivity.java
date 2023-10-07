package com.xeagle.android.vjoystick.gallery;

import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.transition.Explode;
import android.util.Log;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.Fragment;
import com.flyco.tablayout.SlidingTabLayout;
import com.hoho.android.usb.usb.data_proxy.d;
import com.myusb.proxy.proto.Proxy;
import com.xeagle.R;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.activities.helpers.SuperUI;
import com.xeagle.android.newUI.cameraManager.AmbaClient;
import com.xeagle.android.newUI.widgets.NoScrollViewPager;
import com.xeagle.android.vjoystick.IWidgets.IImageButton;
import com.xeagle.android.vjoystick.fragment.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.h;
import kotlin.text.f;

public final class CflyGalleryActivity extends SuperUI implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public static final a f25277a = new a((f) null);

    /* renamed from: c  reason: collision with root package name */
    private static final AtomicInteger f25278c = new AtomicInteger(0);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<Fragment> f25279b = new ArrayList<>();

    /* renamed from: k  reason: collision with root package name */
    private HashMap f25280k;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public static final class b implements dv.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CflyGalleryActivity f25281a;

        b(CflyGalleryActivity cflyGalleryActivity) {
            this.f25281a = cflyGalleryActivity;
        }

        public void a(int i2) {
            Object obj = this.f25281a.f25279b.get(i2);
            h.b(obj, "fragmentList[position]");
            Fragment fragment = (Fragment) obj;
            Objects.requireNonNull(fragment, "null cannot be cast to non-null type com.xeagle.android.fragments.BaseFragment");
            ((com.xeagle.android.fragments.a) fragment).c();
        }

        public void b(int i2) {
        }
    }

    private final void a() {
        XEagleApp xEagleApp = this.xEagleApp;
        h.b(xEagleApp, "xEagleApp");
        c.a().a(xEagleApp.e());
        XEagleApp xEagleApp2 = this.xEagleApp;
        h.b(xEagleApp2, "xEagleApp");
        com.xeagle.android.a m2 = xEagleApp2.m();
        h.b(m2, "xEagleApp.appState");
        int a2 = m2.a();
        XEagleApp xEagleApp3 = this.xEagleApp;
        h.b(xEagleApp3, "xEagleApp");
        boolean c2 = xEagleApp3.c();
        XEagleApp xEagleApp4 = this.xEagleApp;
        h.b(xEagleApp4, "xEagleApp");
        c.a().a(a2, c2, xEagleApp4.h());
    }

    private final void b() {
        IImageButton iImageButton = (IImageButton) a(R.id.ib_go_back);
        h.a((Object) iImageButton);
        iImageButton.setOnClickListener(this);
    }

    private final void d() {
        c.a().c();
        XEagleApp d2 = XEagleApp.d();
        h.b(d2, "XEagleApp.getXEagleApp()");
        if (d2.e() != null) {
            XEagleApp d3 = XEagleApp.d();
            h.b(d3, "XEagleApp.getXEagleApp()");
            d e2 = d3.e();
            Proxy.ConnType connType = Proxy.ConnType.HTTP;
            Proxy.MsgType msgType = Proxy.MsgType.CLOSE;
            byte[] bytes = "".getBytes(kotlin.text.d.f30261a);
            h.b(bytes, "(this as java.lang.String).getBytes(charset)");
            e2.a(12, connType, msgType, "172.50.10.1", 80, 0, 0, "", bytes);
        }
    }

    public View a(int i2) {
        if (this.f25280k == null) {
            this.f25280k = new HashMap();
        }
        View view = (View) this.f25280k.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f25280k.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public void onClick(View view) {
        h.d(view, "v");
        if (view.getId() == com.cfly.uav_pro.R.id.ib_go_back) {
            d();
            finish();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().requestFeature(12);
            Window window = getWindow();
            h.b(window, "window");
            window.setEnterTransition(new Explode());
            Window window2 = getWindow();
            h.b(window2, "window");
            window2.setExitTransition(new Explode());
        }
        setContentView((int) com.cfly.uav_pro.R.layout.cfly_grallery_activity);
        f25278c.incrementAndGet();
        Application application = getApplication();
        Objects.requireNonNull(application, "null cannot be cast to non-null type com.xeagle.android.XEagleApp");
        this.xEagleApp = (XEagleApp) application;
        XEagleApp xEagleApp = this.xEagleApp;
        h.b(xEagleApp, "xEagleApp");
        this.prefs = xEagleApp.j();
        XEagleApp xEagleApp2 = this.xEagleApp;
        h.b(xEagleApp2, "xEagleApp");
        com.xeagle.android.a m2 = xEagleApp2.m();
        h.b(m2, "xEagleApp.appState");
        m2.l(false);
        String[] strArr = {getResources().getString(com.cfly.uav_pro.R.string.string_local_photo), getResources().getString(com.cfly.uav_pro.R.string.string_local_video), getResources().getString(com.cfly.uav_pro.R.string.string_remote_photo), getResources().getString(com.cfly.uav_pro.R.string.string_remote_video), getResources().getString(com.cfly.uav_pro.R.string.string_delay_video), getResources().getString(com.cfly.uav_pro.R.string.string_panora_mode)};
        com.xeagle.android.vjoystick.fragment.http_fragment.b bVar = new com.xeagle.android.vjoystick.fragment.http_fragment.b();
        com.xeagle.android.vjoystick.fragment.http_fragment.c cVar = new com.xeagle.android.vjoystick.fragment.http_fragment.c();
        com.xeagle.android.vjoystick.fragment.a aVar = new com.xeagle.android.vjoystick.fragment.a();
        com.xeagle.android.vjoystick.fragment.b bVar2 = new com.xeagle.android.vjoystick.fragment.b();
        com.xeagle.android.vjoystick.fragment.http_fragment.a aVar2 = new com.xeagle.android.vjoystick.fragment.http_fragment.a();
        com.xeagle.android.vjoystick.fragment.http_fragment.d dVar = new com.xeagle.android.vjoystick.fragment.http_fragment.d();
        this.f25279b.add(aVar);
        this.f25279b.add(bVar2);
        this.f25279b.add(bVar);
        this.f25279b.add(cVar);
        this.f25279b.add(aVar2);
        this.f25279b.add(dVar);
        SlidingTabLayout slidingTabLayout = (SlidingTabLayout) a(R.id.slt);
        h.a((Object) slidingTabLayout);
        slidingTabLayout.a((NoScrollViewPager) a(R.id.vpr), strArr, this, this.f25279b);
        b();
        a();
        SlidingTabLayout slidingTabLayout2 = (SlidingTabLayout) a(R.id.slt);
        h.a((Object) slidingTabLayout2);
        slidingTabLayout2.setOnTabSelectListener(new b(this));
        if (this.camera_type == 1 && this.remoteCam != null) {
            com.xeagle.android.utils.prefs.a aVar3 = this.prefs;
            h.b(aVar3, "prefs");
            String t2 = aVar3.t();
            h.b(t2, "prefs.cameraFirmwareVersion");
            com.xeagle.android.utils.prefs.a aVar4 = this.prefs;
            h.b(aVar4, "prefs");
            String t3 = aVar4.t();
            h.b(t3, "prefs.cameraFirmwareVersion");
            Objects.requireNonNull(t2, "null cannot be cast to non-null type java.lang.String");
            String substring = t2.substring(f.b((CharSequence) t3, "_", 0, false, 6, (Object) null) + 1);
            h.b(substring, "(this as java.lang.String).substring(startIndex)");
            if (Integer.parseInt(substring) >= 2020121101) {
                AmbaClient ambaClient = this.remoteCam;
                h.b(ambaClient, "remoteCam");
                ambaClient.y();
                return;
            }
            this.remoteCam.A();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        int decrementAndGet = f25278c.decrementAndGet();
        if (decrementAndGet == 0) {
            d();
        }
        Log.w("GalleryActivity", "==> onDestroy  " + decrementAndGet);
    }
}
