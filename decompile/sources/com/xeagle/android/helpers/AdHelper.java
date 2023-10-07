package com.xeagle.android.helpers;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import bz.j;
import com.bumptech.glide.c;
import com.bumptech.glide.g;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.h;
import com.google.gson.Gson;
import com.xeagle.android.login.beans.AdBeans;
import com.xeagle.android.login.retrofitLogin.SimpleHttpClient;
import com.xeagle.android.utils.y;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import okhttp3.ab;

public class AdHelper {
    private int mDownCount;
    private int mTimeout;

    public interface IFetchAdCallBack {
        void onFetchAd(AdBeans adBeans);

        void onPreLoadAdImgSuccess();
    }

    public interface ILoadAdCallBack {
        void onLoadAd(AdBeans.AdContent adContent);
    }

    private static final class InnerClass {
        public static final AdHelper sHelper = new AdHelper();

        private InnerClass() {
        }
    }

    private AdHelper() {
        this.mTimeout = 3000;
    }

    public static AdHelper getInstance() {
        return InnerClass.sHelper;
    }

    /* access modifiers changed from: private */
    public void preLoadAdImg(Context context, AdBeans adBeans, IFetchAdCallBack iFetchAdCallBack) {
        if (adBeans.isStatus() && adBeans.getSkipCount() > 0 && adBeans.getShowCount() > 0 && System.currentTimeMillis() <= y.a(adBeans.getEndAt())) {
            preload(context, adBeans.getAdvertisement(), iFetchAdCallBack);
            preload(context, adBeans.getLittleAd().getAdvertisement(), iFetchAdCallBack);
        }
    }

    private void preload(Context context, List<AdBeans.AdContent> list, final IFetchAdCallBack iFetchAdCallBack) {
        for (final AdBeans.AdContent next : list) {
            if (next.getShowCount() > 0) {
                if (!TextUtils.isEmpty(next.getImageUrl())) {
                    ((g) c.b(context).a(next.getImageUrl()).a(h.f10301a)).a(new com.bumptech.glide.request.g<Drawable>() {
                        public boolean onLoadFailed(GlideException glideException, Object obj, j<Drawable> jVar, boolean z2) {
                            Log.e("WelcomeActivity", "图片下载失败!");
                            return false;
                        }

                        public boolean onResourceReady(Drawable drawable, Object obj, j<Drawable> jVar, DataSource dataSource, boolean z2) {
                            next.ready();
                            IFetchAdCallBack iFetchAdCallBack = iFetchAdCallBack;
                            if (iFetchAdCallBack != null) {
                                iFetchAdCallBack.onPreLoadAdImgSuccess();
                            }
                            Log.i("WelcomeActivity", "ad图片下载成功!");
                            return false;
                        }
                    }).c();
                }
                if (!TextUtils.isEmpty(next.getBtnUrl())) {
                    ((g) c.b(context).i().a(next.getBtnUrl()).a(h.f10301a)).a(new com.bumptech.glide.request.g<bu.c>() {
                        public boolean onLoadFailed(GlideException glideException, Object obj, j<bu.c> jVar, boolean z2) {
                            Log.e("WelcomeActivity", "图片下载失败!");
                            return false;
                        }

                        public boolean onResourceReady(bu.c cVar, Object obj, j<bu.c> jVar, DataSource dataSource, boolean z2) {
                            next.ready();
                            IFetchAdCallBack iFetchAdCallBack = iFetchAdCallBack;
                            if (iFetchAdCallBack != null) {
                                iFetchAdCallBack.onPreLoadAdImgSuccess();
                            }
                            Log.i("WelcomeActivity", "gif图片下载成功!");
                            return false;
                        }
                    }).c();
                }
            }
        }
    }

    public int getAdDownCount() {
        return this.mDownCount;
    }

    public int getAdTimeout() {
        return this.mTimeout;
    }

    public void loadCacheAd(AdBeans adBeans, ILoadAdCallBack iLoadAdCallBack) {
        if (adBeans != null) {
            try {
                if (adBeans.isStatus()) {
                    if (adBeans.getSkipCount() <= 0) {
                        return;
                    }
                    if (adBeans.getShowCount() > 0) {
                        long currentTimeMillis = System.currentTimeMillis();
                        long a2 = y.a(adBeans.getStartAt());
                        long a3 = y.a(adBeans.getEndAt());
                        if (currentTimeMillis < a2) {
                            return;
                        }
                        if (currentTimeMillis <= a3) {
                            adBeans.decShowCount();
                            this.mDownCount = adBeans.getCountDown();
                            this.mTimeout = adBeans.getCountDown() * 1000;
                            AdBeans.AdContent nextAd = adBeans.nextAd();
                            while (nextAd != null) {
                                if (nextAd.getShowCount() > 0) {
                                    if (nextAd.isReady()) {
                                        if (iLoadAdCallBack != null) {
                                            iLoadAdCallBack.onLoadAd(nextAd);
                                            return;
                                        }
                                        return;
                                    }
                                }
                                adBeans.adIndexMoveDown();
                                nextAd = adBeans.nextAd();
                                if (nextAd == null) {
                                }
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        if (iLoadAdCallBack != null) {
            iLoadAdCallBack.onLoadAd((AdBeans.AdContent) null);
        }
    }

    public void loadLittleAd(AdBeans adBeans, ILoadAdCallBack iLoadAdCallBack) {
        if (adBeans != null) {
            try {
                AdBeans.LittleAd littleAd = adBeans.getLittleAd();
                if (littleAd != null && littleAd.isStatus()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    long a2 = y.a(littleAd.getStartAt());
                    long a3 = y.a(littleAd.getEndAt());
                    if (currentTimeMillis < a2) {
                        return;
                    }
                    if (currentTimeMillis <= a3) {
                        AdBeans.AdContent nextAd = littleAd.nextAd();
                        while (nextAd != null) {
                            if (nextAd.getShowCount() <= 0 && !nextAd.isHideBtn()) {
                                littleAd.adIndexMoveDown();
                                nextAd = littleAd.nextAd();
                                if (nextAd == null) {
                                }
                            } else if (iLoadAdCallBack != null) {
                                iLoadAdCallBack.onLoadAd(nextAd);
                                return;
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                if (iLoadAdCallBack != null) {
                    iLoadAdCallBack.onLoadAd((AdBeans.AdContent) null);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void requestAd(final Context context, final AdBeans adBeans, final IFetchAdCallBack iFetchAdCallBack) {
        if (Locale.SIMPLIFIED_CHINESE.getCountry().equals(context.getResources().getConfiguration().locale.getCountry())) {
            SimpleHttpClient.getInstance().getRequest("https://file.cfly-cn.com/upload/advertisement/cfly_advertisement.json", new SimpleHttpClient.RequestCallBack() {
                public void onFail(IOException iOException) {
                }

                public void onSuccess(ab abVar) {
                    try {
                        AdBeans adBeans = (AdBeans) new Gson().fromJson(abVar.g().string(), AdBeans.class);
                        if (adBeans == null || adBeans.getAdId() != adBeans.getAdId()) {
                            IFetchAdCallBack iFetchAdCallBack = iFetchAdCallBack;
                            if (iFetchAdCallBack != null) {
                                iFetchAdCallBack.onFetchAd(adBeans);
                            }
                            AdHelper.this.preLoadAdImg(context, adBeans, iFetchAdCallBack);
                        }
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
            });
        }
    }
}
