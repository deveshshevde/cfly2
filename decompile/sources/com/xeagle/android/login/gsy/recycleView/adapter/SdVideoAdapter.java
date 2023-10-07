package com.xeagle.android.login.gsy.recycleView.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import ci.a;
import ci.b;
import com.cfly.uav_pro.R;
import com.shuyu.gsyvideoplayer.utils.GSYVideoHelper;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.login.gsy.video.SampleCoverVideo;
import com.xeagle.android.newUI.activity.BaseActivity;
import com.xeagle.android.newUI.widgets.RoundProgressBar;
import com.xeagle.android.utils.e;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.l;
import kotlin.text.f;
import kx.d;

public final class SdVideoAdapter extends a<lc.a, b> {
    private GSYVideoHelper.GSYVideoHelperBuilder gsySmallVideoHelperBuilder = new GSYVideoHelper.GSYVideoHelperBuilder();
    private BaseActivity parent;
    private jd.a videoPlayerHelp;
    private XEagleApp xEagleApp;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SdVideoAdapter(BaseActivity baseActivity) {
        super((int) R.layout.list_video_item2);
        h.d(baseActivity, "parent");
        this.parent = baseActivity;
        Context applicationContext = this.parent.getApplicationContext();
        Objects.requireNonNull(applicationContext, "null cannot be cast to non-null type com.xeagle.android.XEagleApp");
        this.xEagleApp = (XEagleApp) applicationContext;
    }

    /* access modifiers changed from: protected */
    public void convert(b bVar, lc.a aVar) {
        String str;
        Object obj;
        int i2;
        boolean z2;
        String str2;
        String str3;
        String str4;
        StringBuilder sb;
        b bVar2 = bVar;
        lc.a aVar2 = aVar;
        h.d(bVar2, "helper");
        h.d(aVar2, "item");
        bVar2.a((int) R.id.video_delete).a((int) R.id.video_download).a((int) R.id.list_item_btn);
        bVar2.a((int) R.id.list_item_btn, this.xEagleApp.c());
        SampleCoverVideo sampleCoverVideo = (SampleCoverVideo) bVar2.c(R.id.videoPlayer);
        View inflate = View.inflate(this.mContext, R.layout.layout_explayout, (ViewGroup) null);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(d.l(this.mContext));
        String c2 = aVar.c();
        Objects.requireNonNull(c2, "null cannot be cast to non-null type java.lang.String");
        String substring = c2.substring(aVar.c().length() - 12);
        h.b(substring, "(this as java.lang.String).substring(startIndex)");
        sb2.append(substring);
        String sb3 = sb2.toString();
        if (this.xEagleApp.c()) {
            if (aVar.e() == 3) {
                int f2 = aVar.f();
                if (1 <= f2 && 95 >= f2) {
                    h.b(sampleCoverVideo, "videoPlayer");
                    RoundProgressBar imagePb = sampleCoverVideo.getImagePb();
                    h.b(imagePb, "videoPlayer.imagePb");
                    imagePb.setProgress(aVar.f());
                    RoundProgressBar imagePb2 = sampleCoverVideo.getImagePb();
                    h.b(imagePb2, "videoPlayer.imagePb");
                    imagePb2.setVisibility(0);
                    bVar2.a((int) R.id.list_item_btn, false);
                } else if (f2 == 96) {
                    bVar2.a((int) R.id.list_item_btn, false);
                }
            } else {
                bVar2.a((int) R.id.list_item_btn, true);
            }
            h.b(sampleCoverVideo, "videoPlayer");
            RoundProgressBar imagePb3 = sampleCoverVideo.getImagePb();
            h.b(imagePb3, "videoPlayer.imagePb");
            imagePb3.setVisibility(8);
        }
        com.xeagle.android.a m2 = this.xEagleApp.m();
        h.b(m2, "xEagleApp.appState");
        String str5 = "";
        if (m2.a() == 1) {
            com.xeagle.android.utils.prefs.a j2 = this.xEagleApp.j();
            h.b(j2, "xEagleApp.preferences");
            String t2 = j2.t();
            h.b(t2, "xEagleApp.preferences.cameraFirmwareVersion");
            com.xeagle.android.utils.prefs.a j3 = this.xEagleApp.j();
            h.b(j3, "xEagleApp.preferences");
            String t3 = j3.t();
            h.b(t3, "xEagleApp.preferences.cameraFirmwareVersion");
            Objects.requireNonNull(t2, "null cannot be cast to non-null type java.lang.String");
            String substring2 = t2.substring(f.b((CharSequence) t3, "_", 0, false, 6, (Object) null) + 1);
            h.b(substring2, "(this as java.lang.String).substring(startIndex)");
            if (Integer.parseInt(substring2) >= 2020121101) {
                sb = new StringBuilder();
                sb.append("http://172.50.10.1");
                str4 = aVar.c();
                z2 = false;
                i2 = 4;
                obj = null;
                str3 = "AA.MP4";
                str2 = "AB.CFLY";
            } else {
                sb = new StringBuilder();
                sb.append("http://172.50.10.1");
                str4 = aVar.c();
                z2 = false;
                i2 = 4;
                obj = null;
                str3 = "AA";
                str2 = "AB";
            }
            sb.append(f.a(str4, str3, str2, z2, i2, obj));
            str = f.a(sb.toString(), "/tmp/SD0/", "/SD/", false, 4, (Object) null);
        } else {
            com.xeagle.android.a m3 = this.xEagleApp.m();
            h.b(m3, "xEagleApp.appState");
            if (m3.a() == 2) {
                str = "http://172.50.10.1:8082" + f.a(aVar.c(), ".mp4", "_ths.mp4", false, 4, (Object) null);
            } else {
                str = str5;
            }
        }
        aVar2.a(str);
        if (this.xEagleApp.m().a() == 1) {
            try {
                int b2 = f.b((CharSequence) aVar.c(), "/", 0, false, 6, (Object) null) + 1;
                l lVar = l.f30252a;
                Locale locale = Locale.US;
                Object[] objArr = new Object[2];
                String c3 = aVar.c();
                if (c3 != null) {
                    String substring3 = c3.substring(b2);
                    h.b(substring3, "(this as java.lang.String).substring(startIndex)");
                    objArr[0] = substring3;
                    objArr[1] = aVar.b();
                    String format = String.format(locale, "%s_%s", Arrays.copyOf(objArr, 2));
                    h.b(format, "java.lang.String.format(locale, format, *args)");
                    str5 = format;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
            } catch (StringIndexOutOfBoundsException e2) {
                e2.printStackTrace();
            }
        } else if (this.xEagleApp.m().a() == 2) {
            l lVar2 = l.f30252a;
            Locale locale2 = Locale.US;
            String c4 = aVar.c();
            int b3 = f.b((CharSequence) aVar.c(), "/", 0, false, 6, (Object) null);
            int length = aVar.c().length();
            Objects.requireNonNull(c4, "null cannot be cast to non-null type java.lang.String");
            String substring4 = c4.substring(b3, length);
            h.b(substring4, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            str5 = String.format(locale2, "%s_%s", Arrays.copyOf(new Object[]{substring4, aVar.b()}, 2));
            h.b(str5, "java.lang.String.format(locale, format, *args)");
        }
        h.b(sampleCoverVideo, "videoPlayer");
        TextView titleTextView = sampleCoverVideo.getTitleTextView();
        h.b(titleTextView, "videoPlayer.titleTextView");
        titleTextView.setTextSize(e.f24395a.a(4.0f));
        GSYVideoHelper.GSYVideoHelperBuilder gSYVideoHelperBuilder = this.gsySmallVideoHelperBuilder;
        gSYVideoHelperBuilder.setThumbImageView(inflate);
        if (this.xEagleApp.c()) {
            gSYVideoHelperBuilder.setUrl(sb3);
        } else {
            gSYVideoHelperBuilder.setUrl(str);
        }
        gSYVideoHelperBuilder.setVideoTitle(str5);
        gSYVideoHelperBuilder.setCacheWithPlay(true);
        gSYVideoHelperBuilder.setRotateViewAuto(true);
        gSYVideoHelperBuilder.setLockLand(true);
        gSYVideoHelperBuilder.setPlayTag("VIDEO_ADAPTER");
        gSYVideoHelperBuilder.setShowFullAnimation(true);
        gSYVideoHelperBuilder.setAutoFullWithSize(true);
        gSYVideoHelperBuilder.setNeedLockFull(true);
        gSYVideoHelperBuilder.setDismissControlTime(3000);
        gSYVideoHelperBuilder.setPlayPosition(bVar.getAdapterPosition());
        kotlin.l lVar3 = kotlin.l.f30254a;
        jd.a aVar3 = gSYVideoHelperBuilder;
        this.videoPlayerHelp = aVar3;
        if (aVar3 != null) {
            aVar3.build((StandardGSYVideoPlayer) sampleCoverVideo);
        }
        ImageView backButton = sampleCoverVideo.getBackButton();
        h.b(backButton, "videoPlayer.backButton");
        backButton.setVisibility(8);
        View view = bVar2.itemView;
        h.b(view, "helper.itemView");
        view.setTag(sampleCoverVideo);
        sampleCoverVideo.getFullscreenButton().setOnClickListener(new SdVideoAdapter$convert$2(this, sampleCoverVideo));
    }

    public final BaseActivity getParent() {
        return this.parent;
    }

    public final void setParent(BaseActivity baseActivity) {
        h.d(baseActivity, "<set-?>");
        this.parent = baseActivity;
    }
}
