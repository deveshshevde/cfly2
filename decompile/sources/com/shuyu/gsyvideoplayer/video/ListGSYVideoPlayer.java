package com.shuyu.gsyvideoplayer.video;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.shuyu.gsyvideoplayer.video.base.GSYBaseVideoPlayer;
import com.shuyu.gsyvideoplayer.video.base.GSYVideoPlayer;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jh.b;
import moe.codeest.enviews.ENDownloadView;

public class ListGSYVideoPlayer extends StandardGSYVideoPlayer {
    protected int mPlayPosition;
    protected List<b> mUriList = new ArrayList();

    public ListGSYVideoPlayer(Context context) {
        super(context);
    }

    public ListGSYVideoPlayer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ListGSYVideoPlayer(Context context, Boolean bool) {
        super(context, bool);
    }

    /* access modifiers changed from: protected */
    public void changeUiToNormal() {
        super.changeUiToNormal();
        if (this.mHadPlay && this.mPlayPosition < this.mUriList.size()) {
            setViewShowState(this.mThumbImageViewLayout, 8);
            setViewShowState(this.mTopContainer, 4);
            setViewShowState(this.mBottomContainer, 4);
            setViewShowState(this.mStartButton, 8);
            setViewShowState(this.mLoadingProgressBar, 0);
            setViewShowState(this.mBottomProgressBar, 4);
            setViewShowState(this.mLockScreen, 8);
            if (this.mLoadingProgressBar instanceof ENDownloadView) {
                ((ENDownloadView) this.mLoadingProgressBar).a();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void cloneParams(GSYBaseVideoPlayer gSYBaseVideoPlayer, GSYBaseVideoPlayer gSYBaseVideoPlayer2) {
        super.cloneParams(gSYBaseVideoPlayer, gSYBaseVideoPlayer2);
        ListGSYVideoPlayer listGSYVideoPlayer = (ListGSYVideoPlayer) gSYBaseVideoPlayer;
        ListGSYVideoPlayer listGSYVideoPlayer2 = (ListGSYVideoPlayer) gSYBaseVideoPlayer2;
        listGSYVideoPlayer2.mPlayPosition = listGSYVideoPlayer.mPlayPosition;
        listGSYVideoPlayer2.mUriList = listGSYVideoPlayer.mUriList;
    }

    public void onAutoCompletion() {
        if (!playNext()) {
            super.onAutoCompletion();
        }
    }

    public void onCompletion() {
        releaseNetWorkState();
        if (this.mPlayPosition >= this.mUriList.size()) {
            super.onCompletion();
        }
    }

    public void onPrepared() {
        super.onPrepared();
    }

    public boolean playNext() {
        if (this.mPlayPosition >= this.mUriList.size() - 1) {
            return false;
        }
        int i2 = this.mPlayPosition + 1;
        this.mPlayPosition = i2;
        b bVar = this.mUriList.get(i2);
        this.mSaveChangeViewTIme = 0;
        setUp(this.mUriList, this.mCache, this.mPlayPosition, (File) null, this.mMapHeadData, false);
        if (!TextUtils.isEmpty(bVar.getTitle()) && this.mTitleTextView != null) {
            this.mTitleTextView.setText(bVar.getTitle());
        }
        startPlayLogic();
        return true;
    }

    /* access modifiers changed from: protected */
    public void prepareVideo() {
        super.prepareVideo();
        if (this.mHadPlay && this.mPlayPosition < this.mUriList.size()) {
            setViewShowState(this.mLoadingProgressBar, 0);
            if (this.mLoadingProgressBar instanceof ENDownloadView) {
                ((ENDownloadView) this.mLoadingProgressBar).a();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void resolveNormalVideoShow(View view, ViewGroup viewGroup, GSYVideoPlayer gSYVideoPlayer) {
        if (gSYVideoPlayer != null) {
            ListGSYVideoPlayer listGSYVideoPlayer = (ListGSYVideoPlayer) gSYVideoPlayer;
            b bVar = this.mUriList.get(this.mPlayPosition);
            if (!TextUtils.isEmpty(bVar.getTitle()) && this.mTitleTextView != null) {
                this.mTitleTextView.setText(bVar.getTitle());
            }
        }
        super.resolveNormalVideoShow(view, viewGroup, gSYVideoPlayer);
    }

    public boolean setUp(List<b> list, boolean z2, int i2) {
        return setUp(list, z2, i2, (File) null, new HashMap());
    }

    public boolean setUp(List<b> list, boolean z2, int i2, File file) {
        return setUp(list, z2, i2, file, new HashMap());
    }

    public boolean setUp(List<b> list, boolean z2, int i2, File file, Map<String, String> map) {
        return setUp(list, z2, i2, file, map, true);
    }

    /* access modifiers changed from: protected */
    public boolean setUp(List<b> list, boolean z2, int i2, File file, Map<String, String> map, boolean z3) {
        this.mUriList = list;
        this.mPlayPosition = i2;
        this.mMapHeadData = map;
        b bVar = list.get(i2);
        boolean up = setUp(bVar.getUrl(), z2, file, bVar.getTitle(), z3);
        if (!TextUtils.isEmpty(bVar.getTitle()) && this.mTitleTextView != null) {
            this.mTitleTextView.setText(bVar.getTitle());
        }
        return up;
    }

    public GSYBaseVideoPlayer startWindowFullscreen(Context context, boolean z2, boolean z3) {
        GSYBaseVideoPlayer startWindowFullscreen = super.startWindowFullscreen(context, z2, z3);
        if (startWindowFullscreen != null) {
            ListGSYVideoPlayer listGSYVideoPlayer = (ListGSYVideoPlayer) startWindowFullscreen;
            b bVar = this.mUriList.get(this.mPlayPosition);
            if (!TextUtils.isEmpty(bVar.getTitle()) && this.mTitleTextView != null) {
                listGSYVideoPlayer.mTitleTextView.setText(bVar.getTitle());
            }
        }
        return startWindowFullscreen;
    }
}
