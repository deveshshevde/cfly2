package com.shuyu.gsyvideoplayer;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.shuyu.gsyvideoplayer.utils.CommonUtil;
import com.shuyu.gsyvideoplayer.video.base.GSYVideoPlayer;

public class c extends b {

    /* renamed from: a  reason: collision with root package name */
    public static final int f21654a = R.id.small_id;

    /* renamed from: b  reason: collision with root package name */
    public static final int f21655b = R.id.full_id;

    /* renamed from: c  reason: collision with root package name */
    public static String f21656c = "GSYVideoManager";

    /* renamed from: w  reason: collision with root package name */
    private static c f21657w;

    private c() {
        e();
    }

    public static synchronized c a() {
        c cVar;
        synchronized (c.class) {
            if (f21657w == null) {
                f21657w = new c();
            }
            cVar = f21657w;
        }
        return cVar;
    }

    public static boolean a(Activity activity) {
        View findViewById = ((ViewGroup) CommonUtil.scanForActivity(activity).findViewById(16908290)).findViewById(f21655b);
        return (findViewById != null ? (GSYVideoPlayer) findViewById : null) != null;
    }

    public static boolean a(Context context) {
        if (((ViewGroup) CommonUtil.scanForActivity(context).findViewById(16908290)).findViewById(f21655b) == null) {
            return false;
        }
        CommonUtil.hideNavKey(context);
        if (a().lastListener() == null) {
            return true;
        }
        a().lastListener().onBackFullscreen();
        return true;
    }

    public static void b() {
        if (a().listener() != null) {
            a().listener().onCompletion();
        }
        a().releaseMediaPlayer();
    }

    public static void b(boolean z2) {
        if (a().listener() != null) {
            a().listener().onVideoResume(z2);
        }
    }

    public static void c() {
        if (a().listener() != null) {
            a().listener().onCompletion();
        }
        a().releaseVideoCache();
    }

    public static void d() {
        if (a().listener() != null) {
            a().listener().onVideoPause();
        }
    }

    public static void j() {
        if (a().listener() != null) {
            a().listener().onVideoResume();
        }
    }

    public void setDuration(long j2) {
    }
}
