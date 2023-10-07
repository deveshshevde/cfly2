package com.xeagle.android.login.gsy.recycleView.adapter;

import android.view.View;
import com.xeagle.android.login.gsy.video.SampleCoverVideo;

final class SdVideoAdapter$convert$2 implements View.OnClickListener {
    final /* synthetic */ SampleCoverVideo $videoPlayer;
    final /* synthetic */ SdVideoAdapter this$0;

    SdVideoAdapter$convert$2(SdVideoAdapter sdVideoAdapter, SampleCoverVideo sampleCoverVideo) {
        this.this$0 = sdVideoAdapter;
        this.$videoPlayer = sampleCoverVideo;
    }

    public final void onClick(View view) {
        this.$videoPlayer.startWindowFullscreen(this.this$0.mContext, false, false);
    }
}
