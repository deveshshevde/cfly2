package com.shuyu.gsyvideoplayer;

import android.content.Context;
import android.view.ViewGroup;
import com.shuyu.gsyvideoplayer.utils.CommonUtil;

public class a extends b {

    /* renamed from: a  reason: collision with root package name */
    public static final int f21615a = R.id.ad_small_id;

    /* renamed from: b  reason: collision with root package name */
    public static final int f21616b = R.id.ad_full_id;

    /* renamed from: c  reason: collision with root package name */
    public static String f21617c = "GSYVideoADManager";

    /* renamed from: w  reason: collision with root package name */
    private static a f21618w;

    private a() {
        e();
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (f21618w == null) {
                f21618w = new a();
            }
            aVar = f21618w;
        }
        return aVar;
    }

    public static boolean a(Context context) {
        if (((ViewGroup) CommonUtil.scanForActivity(context).findViewById(16908290)).findViewById(f21616b) == null) {
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

    public static void c() {
        if (a().listener() != null) {
            a().listener().onVideoPause();
        }
    }

    public static void d() {
        if (a().listener() != null) {
            a().listener().onVideoResume();
        }
    }
}
