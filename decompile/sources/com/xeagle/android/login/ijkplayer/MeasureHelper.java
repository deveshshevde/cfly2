package com.xeagle.android.login.ijkplayer;

import android.content.Context;
import android.view.View;
import com.cfly.uav_pro.R;
import java.lang.ref.WeakReference;

public final class MeasureHelper {
    private int mCurrentAspectRatio = 0;
    private int mMeasuredHeight;
    private int mMeasuredWidth;
    private int mVideoHeight;
    private int mVideoRotationDegree;
    private int mVideoSarDen;
    private int mVideoSarNum;
    private int mVideoWidth;
    private WeakReference<View> mWeakView;

    public MeasureHelper(View view) {
        this.mWeakView = new WeakReference<>(view);
    }

    public static String getAspectRatioText(Context context, int i2) {
        return context.getString(i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? R.string.N_A : R.string.VideoView_ar_4_3_fit_parent : R.string.VideoView_ar_16_9_fit_parent : R.string.VideoView_ar_match_parent : R.string.VideoView_ar_aspect_wrap_content : R.string.VideoView_ar_aspect_fill_parent : R.string.VideoView_ar_aspect_fit_parent);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00ac, code lost:
        if (r4 != false) goto L_0x00b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00af, code lost:
        if (r4 != false) goto L_0x00b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00b1, code lost:
        r13 = (int) (r0 / r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00b5, code lost:
        r12 = (int) (r3 * r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void doMeasure(int r12, int r13) {
        /*
            r11 = this;
            int r0 = r11.mVideoRotationDegree
            r1 = 270(0x10e, float:3.78E-43)
            r2 = 90
            if (r0 == r2) goto L_0x000a
            if (r0 != r1) goto L_0x000d
        L_0x000a:
            r10 = r13
            r13 = r12
            r12 = r10
        L_0x000d:
            int r0 = r11.mVideoWidth
            int r0 = android.view.View.getDefaultSize(r0, r12)
            int r3 = r11.mVideoHeight
            int r3 = android.view.View.getDefaultSize(r3, r13)
            int r4 = r11.mCurrentAspectRatio
            r5 = 3
            if (r4 != r5) goto L_0x0020
            goto L_0x0115
        L_0x0020:
            int r4 = r11.mVideoWidth
            if (r4 <= 0) goto L_0x0113
            int r4 = r11.mVideoHeight
            if (r4 <= 0) goto L_0x0113
            int r0 = android.view.View.MeasureSpec.getMode(r12)
            int r12 = android.view.View.MeasureSpec.getSize(r12)
            int r3 = android.view.View.MeasureSpec.getMode(r13)
            int r13 = android.view.View.MeasureSpec.getSize(r13)
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 != r4) goto L_0x00ba
            if (r3 != r4) goto L_0x00ba
            float r0 = (float) r12
            float r3 = (float) r13
            float r4 = r0 / r3
            int r5 = r11.mCurrentAspectRatio
            r6 = 5
            r7 = 4
            if (r5 == r7) goto L_0x0070
            if (r5 == r6) goto L_0x005f
            int r1 = r11.mVideoWidth
            float r1 = (float) r1
            int r2 = r11.mVideoHeight
            float r2 = (float) r2
            float r1 = r1 / r2
            int r2 = r11.mVideoSarNum
            if (r2 <= 0) goto L_0x0080
            int r8 = r11.mVideoSarDen
            if (r8 <= 0) goto L_0x0080
            float r2 = (float) r2
            float r1 = r1 * r2
            float r2 = (float) r8
            float r1 = r1 / r2
            goto L_0x0080
        L_0x005f:
            r8 = 1068149419(0x3faaaaab, float:1.3333334)
            int r9 = r11.mVideoRotationDegree
            if (r9 == r2) goto L_0x006d
            if (r9 != r1) goto L_0x0069
            goto L_0x006d
        L_0x0069:
            r1 = 1068149419(0x3faaaaab, float:1.3333334)
            goto L_0x0080
        L_0x006d:
            r1 = 1061158912(0x3f400000, float:0.75)
            goto L_0x0080
        L_0x0070:
            r8 = 1071877689(0x3fe38e39, float:1.7777778)
            int r9 = r11.mVideoRotationDegree
            if (r9 == r2) goto L_0x007e
            if (r9 != r1) goto L_0x007a
            goto L_0x007e
        L_0x007a:
            r1 = 1071877689(0x3fe38e39, float:1.7777778)
            goto L_0x0080
        L_0x007e:
            r1 = 1058013184(0x3f100000, float:0.5625)
        L_0x0080:
            r2 = 1
            int r4 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r4 <= 0) goto L_0x0087
            r4 = 1
            goto L_0x0088
        L_0x0087:
            r4 = 0
        L_0x0088:
            if (r5 == 0) goto L_0x00af
            if (r5 == r2) goto L_0x00ac
            if (r5 == r7) goto L_0x00af
            if (r5 == r6) goto L_0x00af
            if (r4 == 0) goto L_0x009d
            int r13 = r11.mVideoWidth
            int r12 = java.lang.Math.min(r13, r12)
            float r13 = (float) r12
            float r13 = r13 / r1
            int r13 = (int) r13
            goto L_0x0115
        L_0x009d:
            int r12 = r11.mVideoHeight
            int r12 = java.lang.Math.min(r12, r13)
            float r13 = (float) r12
            float r13 = r13 * r1
            int r13 = (int) r13
            r10 = r13
            r13 = r12
            r12 = r10
            goto L_0x0115
        L_0x00ac:
            if (r4 == 0) goto L_0x00b1
            goto L_0x00b5
        L_0x00af:
            if (r4 == 0) goto L_0x00b5
        L_0x00b1:
            float r0 = r0 / r1
            int r13 = (int) r0
            goto L_0x0115
        L_0x00b5:
            float r3 = r3 * r1
            int r12 = (int) r3
            goto L_0x0115
        L_0x00ba:
            r1 = 1073741824(0x40000000, float:2.0)
            if (r0 != r1) goto L_0x00da
            if (r3 != r1) goto L_0x00da
            int r0 = r11.mVideoWidth
            int r1 = r0 * r13
            int r2 = r11.mVideoHeight
            int r3 = r12 * r2
            if (r1 >= r3) goto L_0x00cf
            int r0 = r0 * r13
            int r12 = r0 / r2
            goto L_0x0115
        L_0x00cf:
            int r1 = r0 * r13
            int r3 = r12 * r2
            if (r1 <= r3) goto L_0x0115
            int r2 = r2 * r12
            int r13 = r2 / r0
            goto L_0x0115
        L_0x00da:
            if (r0 != r1) goto L_0x00ea
            int r0 = r11.mVideoHeight
            int r0 = r0 * r12
            int r1 = r11.mVideoWidth
            int r0 = r0 / r1
            if (r3 != r4) goto L_0x00e8
            if (r0 <= r13) goto L_0x00e8
            goto L_0x0115
        L_0x00e8:
            r13 = r0
            goto L_0x0115
        L_0x00ea:
            if (r3 != r1) goto L_0x00fa
            int r1 = r11.mVideoWidth
            int r1 = r1 * r13
            int r2 = r11.mVideoHeight
            int r1 = r1 / r2
            if (r0 != r4) goto L_0x00f8
            if (r1 <= r12) goto L_0x00f8
            goto L_0x0115
        L_0x00f8:
            r12 = r1
            goto L_0x0115
        L_0x00fa:
            int r1 = r11.mVideoWidth
            int r2 = r11.mVideoHeight
            if (r3 != r4) goto L_0x0106
            if (r2 <= r13) goto L_0x0106
            int r3 = r13 * r1
            int r3 = r3 / r2
            goto L_0x0108
        L_0x0106:
            r3 = r1
            r13 = r2
        L_0x0108:
            if (r0 != r4) goto L_0x0111
            if (r3 <= r12) goto L_0x0111
            int r2 = r2 * r12
            int r13 = r2 / r1
            goto L_0x0115
        L_0x0111:
            r12 = r3
            goto L_0x0115
        L_0x0113:
            r12 = r0
            r13 = r3
        L_0x0115:
            r11.mMeasuredWidth = r12
            r11.mMeasuredHeight = r13
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.login.ijkplayer.MeasureHelper.doMeasure(int, int):void");
    }

    public int getMeasuredHeight() {
        return this.mMeasuredHeight;
    }

    public int getMeasuredWidth() {
        return this.mMeasuredWidth;
    }

    public View getView() {
        WeakReference<View> weakReference = this.mWeakView;
        if (weakReference == null) {
            return null;
        }
        return (View) weakReference.get();
    }

    public void setAspectRatio(int i2) {
        this.mCurrentAspectRatio = i2;
    }

    public void setVideoRotation(int i2) {
        this.mVideoRotationDegree = i2;
    }

    public void setVideoSampleAspectRatio(int i2, int i3) {
        this.mVideoSarNum = i2;
        this.mVideoSarDen = i3;
    }

    public void setVideoSize(int i2, int i3) {
        this.mVideoWidth = i2;
        this.mVideoHeight = i3;
    }
}
