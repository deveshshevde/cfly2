package com.shuyu.gsyvideoplayer.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.shuyu.gsyvideoplayer.R;
import com.shuyu.gsyvideoplayer.utils.CommonUtil;
import com.shuyu.gsyvideoplayer.video.base.GSYBaseVideoPlayer;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jh.b;

public class GSYSampleADVideoPlayer extends ListGSYVideoPlayer {
    protected boolean isAdModel = false;
    protected boolean isFirstPrepared = false;
    protected TextView mADTime;
    protected View mJumpAd;
    protected ViewGroup mWidgetContainer;

    public static class GSYADVideoModel extends b {
        public static int TYPE_AD = 1;
        public static int TYPE_NORMAL;
        private boolean isSkip;
        private int mType;

        public GSYADVideoModel(String str, String str2, int i2) {
            this(str, str2, i2, false);
        }

        public GSYADVideoModel(String str, String str2, int i2, boolean z2) {
            super(str, str2);
            this.mType = TYPE_NORMAL;
            this.mType = i2;
            this.isSkip = z2;
        }

        public int getType() {
            return this.mType;
        }

        public boolean isSkip() {
            return this.isSkip;
        }

        public void setSkip(boolean z2) {
            this.isSkip = z2;
        }

        public void setType(int i2) {
            this.mType = i2;
        }
    }

    public GSYSampleADVideoPlayer(Context context) {
        super(context);
    }

    public GSYSampleADVideoPlayer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GSYSampleADVideoPlayer(Context context, Boolean bool) {
        super(context, bool);
    }

    /* access modifiers changed from: protected */
    public void changeAdUIState() {
        View view = this.mJumpAd;
        int i2 = 8;
        boolean z2 = false;
        if (view != null) {
            view.setVisibility((!this.isFirstPrepared || !this.isAdModel) ? 8 : 0);
        }
        TextView textView = this.mADTime;
        if (textView != null) {
            textView.setVisibility((!this.isFirstPrepared || !this.isAdModel) ? 8 : 0);
        }
        ViewGroup viewGroup = this.mWidgetContainer;
        if (viewGroup != null) {
            if (!this.isFirstPrepared || !this.isAdModel) {
                i2 = 0;
            }
            viewGroup.setVisibility(i2);
        }
        if (this.mBottomContainer != null) {
            this.mBottomContainer.setBackgroundColor((!this.isFirstPrepared || !this.isAdModel) ? getContext().getResources().getColor(R.color.bottom_container_bg) : 0);
        }
        int i3 = 4;
        if (this.mCurrentTimeTextView != null) {
            this.mCurrentTimeTextView.setVisibility((!this.isFirstPrepared || !this.isAdModel) ? 0 : 4);
        }
        if (this.mTotalTimeTextView != null) {
            this.mTotalTimeTextView.setVisibility((!this.isFirstPrepared || !this.isAdModel) ? 0 : 4);
        }
        if (this.mProgressBar != null) {
            SeekBar seekBar = this.mProgressBar;
            if (!this.isFirstPrepared || !this.isAdModel) {
                i3 = 0;
            }
            seekBar.setVisibility(i3);
            SeekBar seekBar2 = this.mProgressBar;
            if (!this.isFirstPrepared || !this.isAdModel) {
                z2 = true;
            }
            seekBar2.setEnabled(z2);
        }
    }

    /* access modifiers changed from: protected */
    public void cloneParams(GSYBaseVideoPlayer gSYBaseVideoPlayer, GSYBaseVideoPlayer gSYBaseVideoPlayer2) {
        super.cloneParams(gSYBaseVideoPlayer, gSYBaseVideoPlayer2);
        GSYSampleADVideoPlayer gSYSampleADVideoPlayer = (GSYSampleADVideoPlayer) gSYBaseVideoPlayer;
        GSYSampleADVideoPlayer gSYSampleADVideoPlayer2 = (GSYSampleADVideoPlayer) gSYBaseVideoPlayer2;
        gSYSampleADVideoPlayer2.isAdModel = gSYSampleADVideoPlayer.isAdModel;
        gSYSampleADVideoPlayer2.isFirstPrepared = gSYSampleADVideoPlayer.isFirstPrepared;
        gSYSampleADVideoPlayer2.changeAdUIState();
    }

    public int getLayoutId() {
        return R.layout.video_layout_sample_ad;
    }

    /* access modifiers changed from: protected */
    public void hideAllWidget() {
        if (!this.isFirstPrepared || !this.isAdModel) {
            super.hideAllWidget();
        }
    }

    /* access modifiers changed from: protected */
    public void init(Context context) {
        super.init(context);
        this.mJumpAd = findViewById(R.id.jump_ad);
        this.mADTime = (TextView) findViewById(R.id.ad_time);
        this.mWidgetContainer = (ViewGroup) findViewById(R.id.widget_container);
        View view = this.mJumpAd;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    GSYSampleADVideoPlayer.this.playNext();
                }
            });
        }
    }

    public void onPrepared() {
        super.onPrepared();
        this.isFirstPrepared = true;
        changeAdUIState();
    }

    public boolean setAdUp(ArrayList<GSYADVideoModel> arrayList, boolean z2, int i2) {
        return setUp((ArrayList) arrayList.clone(), z2, i2);
    }

    public boolean setAdUp(ArrayList<GSYADVideoModel> arrayList, boolean z2, int i2, File file) {
        return setUp((ArrayList) arrayList.clone(), z2, i2, file);
    }

    public boolean setAdUp(ArrayList<GSYADVideoModel> arrayList, boolean z2, int i2, File file, Map<String, String> map) {
        return setUp((ArrayList) arrayList.clone(), z2, i2, file, map);
    }

    /* access modifiers changed from: protected */
    public void setProgressAndTime(int i2, int i3, int i4, int i5, boolean z2) {
        super.setProgressAndTime(i2, i3, i4, i5, z2);
        TextView textView = this.mADTime;
        if (textView != null && i4 > 0) {
            textView.setText("" + ((i5 / 1000) - (i4 / 1000)));
        }
    }

    public boolean setUp(List<b> list, boolean z2, int i2) {
        return setUp(list, z2, i2, (File) null);
    }

    public boolean setUp(List<b> list, boolean z2, int i2, File file) {
        return setUp(list, z2, i2, file, new HashMap());
    }

    public boolean setUp(List<b> list, boolean z2, int i2, File file, Map<String, String> map) {
        return setUp(list, z2, i2, file, map, true);
    }

    /* access modifiers changed from: protected */
    public boolean setUp(List<b> list, boolean z2, int i2, File file, Map<String, String> map, boolean z3) {
        b bVar = list.get(i2);
        if (bVar instanceof GSYADVideoModel) {
            GSYADVideoModel gSYADVideoModel = (GSYADVideoModel) bVar;
            boolean z4 = true;
            if (!gSYADVideoModel.isSkip() || i2 >= list.size() - 1) {
                if (gSYADVideoModel.getType() != GSYADVideoModel.TYPE_AD) {
                    z4 = false;
                }
                this.isAdModel = z4;
            } else {
                return setUp(list, z2, i2 + 1, file, map, z3);
            }
        }
        changeAdUIState();
        return super.setUp(list, z2, i2, file, map, z3);
    }

    /* access modifiers changed from: protected */
    public void touchDoubleUp() {
        if (!this.isAdModel) {
            super.touchDoubleUp();
        }
    }

    /* access modifiers changed from: protected */
    public void touchSurfaceMove(float f2, float f3, float f4) {
        if (!this.mChangePosition || !this.isAdModel) {
            super.touchSurfaceMove(f2, f3, f4);
        }
    }

    /* access modifiers changed from: protected */
    public void touchSurfaceMoveFullLogic(float f2, float f3) {
        if (f2 > ((float) this.mThreshold) || f3 > ((float) this.mThreshold)) {
            int screenWidth = CommonUtil.getScreenWidth(getContext());
            if (!this.isAdModel || f2 < ((float) this.mThreshold) || Math.abs(((float) screenWidth) - this.mDownX) <= ((float) this.mSeekEndOffset)) {
                super.touchSurfaceMoveFullLogic(f2, f3);
                return;
            }
            this.mChangePosition = true;
            this.mDownPosition = getCurrentPositionWhenPlaying();
        }
    }

    /* access modifiers changed from: protected */
    public void touchSurfaceUp() {
        if (!this.mChangePosition || !this.isAdModel) {
            super.touchSurfaceUp();
        }
    }

    /* access modifiers changed from: protected */
    public void updateStartImage() {
        int i2;
        if (this.mStartButton != null && (this.mStartButton instanceof ImageView)) {
            ImageView imageView = (ImageView) this.mStartButton;
            if (this.mCurrentState == 2) {
                i2 = R.drawable.video_click_pause_selector;
            } else {
                int i3 = this.mCurrentState;
                i2 = R.drawable.video_click_play_selector;
            }
            imageView.setImageResource(i2);
        }
    }
}
