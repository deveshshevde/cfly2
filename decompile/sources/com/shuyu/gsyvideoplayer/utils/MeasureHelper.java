package com.shuyu.gsyvideoplayer.utils;

import android.view.View;
import java.lang.ref.WeakReference;

public final class MeasureHelper {
    private int mCurrentAspectRatio = 0;
    private int mMeasuredHeight;
    private int mMeasuredWidth;
    private final MeasureFormVideoParamsListener mParamsListener;
    private int mVideoHeight;
    private int mVideoRotationDegree;
    private int mVideoSarDen;
    private int mVideoSarNum;
    private int mVideoWidth;
    private WeakReference<View> mWeakView;

    public interface MeasureFormVideoParamsListener {
        int getCurrentVideoHeight();

        int getCurrentVideoWidth();

        int getVideoSarDen();

        int getVideoSarNum();
    }

    public MeasureHelper(View view, MeasureFormVideoParamsListener measureFormVideoParamsListener) {
        this.mParamsListener = measureFormVideoParamsListener;
        this.mWeakView = new WeakReference<>(view);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00fb, code lost:
        if (r4 != false) goto L_0x0104;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x00fe, code lost:
        if (r4 != false) goto L_0x0100;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0100, code lost:
        r15 = (int) (r2 / r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0104, code lost:
        r14 = (int) (r5 * r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void doMeasure(int r14, int r15) {
        /*
            r13 = this;
            int r0 = com.shuyu.gsyvideoplayer.utils.GSYVideoType.getShowType()
            r13.mCurrentAspectRatio = r0
            int r0 = r13.mVideoHeight
            r1 = 1
            if (r0 == 0) goto L_0x015e
            int r0 = r13.mVideoWidth
            if (r0 != 0) goto L_0x0011
            goto L_0x015e
        L_0x0011:
            int r2 = r13.mVideoRotationDegree
            r3 = 270(0x10e, float:3.78E-43)
            r4 = 90
            if (r2 == r4) goto L_0x001b
            if (r2 != r3) goto L_0x001e
        L_0x001b:
            r12 = r15
            r15 = r14
            r14 = r12
        L_0x001e:
            int r2 = r13.mVideoSarNum
            if (r2 == 0) goto L_0x0039
            int r5 = r13.mVideoSarDen
            if (r5 == 0) goto L_0x0039
            double r6 = (double) r2
            double r8 = (double) r5
            r10 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            java.lang.Double.isNaN(r8)
            double r8 = r8 / r10
            java.lang.Double.isNaN(r6)
            double r6 = r6 / r8
            double r8 = (double) r0
            java.lang.Double.isNaN(r8)
            double r6 = r6 * r8
            int r0 = (int) r6
        L_0x0039:
            int r2 = android.view.View.getDefaultSize(r0, r14)
            int r5 = r13.mVideoHeight
            int r5 = android.view.View.getDefaultSize(r5, r15)
            int r6 = r13.mCurrentAspectRatio
            r7 = -4
            if (r6 != r7) goto L_0x004a
            goto L_0x0159
        L_0x004a:
            if (r0 <= 0) goto L_0x0157
            int r6 = r13.mVideoHeight
            if (r6 <= 0) goto L_0x0157
            int r2 = android.view.View.MeasureSpec.getMode(r14)
            int r14 = android.view.View.MeasureSpec.getSize(r14)
            int r5 = android.view.View.MeasureSpec.getMode(r15)
            int r15 = android.view.View.MeasureSpec.getSize(r15)
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r2 != r6) goto L_0x0109
            if (r5 != r6) goto L_0x0109
            float r2 = (float) r14
            float r5 = (float) r15
            float r6 = r2 / r5
            int r7 = r13.mCurrentAspectRatio
            r8 = 2
            r9 = 6
            r10 = -5
            if (r7 == r10) goto L_0x00bb
            if (r7 == r9) goto L_0x00ac
            if (r7 == r1) goto L_0x009b
            if (r7 == r8) goto L_0x008a
            float r3 = (float) r0
            int r4 = r13.mVideoHeight
            float r4 = (float) r4
            float r3 = r3 / r4
            int r4 = r13.mVideoSarNum
            if (r4 <= 0) goto L_0x00cb
            int r7 = r13.mVideoSarDen
            if (r7 <= 0) goto L_0x00cb
            float r4 = (float) r4
            float r3 = r3 * r4
            float r4 = (float) r7
            float r3 = r3 / r4
            goto L_0x00cb
        L_0x008a:
            r7 = 1068149419(0x3faaaaab, float:1.3333334)
            int r11 = r13.mVideoRotationDegree
            if (r11 == r4) goto L_0x0098
            if (r11 != r3) goto L_0x0094
            goto L_0x0098
        L_0x0094:
            r3 = 1068149419(0x3faaaaab, float:1.3333334)
            goto L_0x00cb
        L_0x0098:
            r3 = 1061158912(0x3f400000, float:0.75)
            goto L_0x00cb
        L_0x009b:
            r7 = 1071877689(0x3fe38e39, float:1.7777778)
            int r11 = r13.mVideoRotationDegree
            if (r11 == r4) goto L_0x00a9
            if (r11 != r3) goto L_0x00a5
            goto L_0x00a9
        L_0x00a5:
            r3 = 1071877689(0x3fe38e39, float:1.7777778)
            goto L_0x00cb
        L_0x00a9:
            r3 = 1058013184(0x3f100000, float:0.5625)
            goto L_0x00cb
        L_0x00ac:
            r7 = 1073741824(0x40000000, float:2.0)
            int r11 = r13.mVideoRotationDegree
            if (r11 == r4) goto L_0x00b8
            if (r11 != r3) goto L_0x00b5
            goto L_0x00b8
        L_0x00b5:
            r3 = 1073741824(0x40000000, float:2.0)
            goto L_0x00cb
        L_0x00b8:
            r3 = 1056964608(0x3f000000, float:0.5)
            goto L_0x00cb
        L_0x00bb:
            float r7 = com.shuyu.gsyvideoplayer.utils.GSYVideoType.getScreenScaleRatio()
            int r11 = r13.mVideoRotationDegree
            if (r11 == r4) goto L_0x00c8
            if (r11 != r3) goto L_0x00c6
            goto L_0x00c8
        L_0x00c6:
            r3 = r7
            goto L_0x00cb
        L_0x00c8:
            r3 = 1065353216(0x3f800000, float:1.0)
            float r3 = r3 / r7
        L_0x00cb:
            int r4 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r4 <= 0) goto L_0x00d1
            r4 = 1
            goto L_0x00d2
        L_0x00d1:
            r4 = 0
        L_0x00d2:
            int r6 = r13.mCurrentAspectRatio
            if (r6 == r10) goto L_0x00fe
            r7 = 4
            if (r6 == r7) goto L_0x00fb
            if (r6 == r9) goto L_0x00fe
            if (r6 == 0) goto L_0x00fe
            if (r6 == r1) goto L_0x00fe
            if (r6 == r8) goto L_0x00fe
            if (r4 == 0) goto L_0x00ec
            int r14 = java.lang.Math.min(r0, r14)
            float r15 = (float) r14
            float r15 = r15 / r3
            int r15 = (int) r15
            goto L_0x0159
        L_0x00ec:
            int r14 = r13.mVideoHeight
            int r14 = java.lang.Math.min(r14, r15)
            float r15 = (float) r14
            float r15 = r15 * r3
            int r15 = (int) r15
            r12 = r15
            r15 = r14
            r14 = r12
            goto L_0x0159
        L_0x00fb:
            if (r4 == 0) goto L_0x0100
            goto L_0x0104
        L_0x00fe:
            if (r4 == 0) goto L_0x0104
        L_0x0100:
            float r2 = r2 / r3
            int r15 = (int) r2
            goto L_0x0159
        L_0x0104:
            float r5 = r5 * r3
            int r14 = (int) r5
            goto L_0x0159
        L_0x0109:
            r1 = 1073741824(0x40000000, float:2.0)
            if (r2 != r1) goto L_0x0123
            if (r5 != r1) goto L_0x0123
            int r1 = r0 * r15
            int r2 = r13.mVideoHeight
            int r3 = r14 * r2
            if (r1 >= r3) goto L_0x011a
            int r14 = r1 / r2
            goto L_0x0159
        L_0x011a:
            int r3 = r14 * r2
            if (r1 <= r3) goto L_0x0159
            int r2 = r2 * r14
            int r15 = r2 / r0
            goto L_0x0159
        L_0x0123:
            if (r2 != r1) goto L_0x0132
            int r1 = r13.mVideoHeight
            int r1 = r1 * r14
            int r0 = r1 / r0
            if (r5 != r6) goto L_0x0130
            if (r0 <= r15) goto L_0x0130
            goto L_0x0159
        L_0x0130:
            r15 = r0
            goto L_0x0159
        L_0x0132:
            if (r5 != r1) goto L_0x0140
            int r0 = r0 * r15
            int r1 = r13.mVideoHeight
            int r0 = r0 / r1
            if (r2 != r6) goto L_0x013e
            if (r0 <= r14) goto L_0x013e
            goto L_0x0159
        L_0x013e:
            r14 = r0
            goto L_0x0159
        L_0x0140:
            int r1 = r13.mVideoHeight
            if (r5 != r6) goto L_0x014a
            if (r1 <= r15) goto L_0x014a
            int r3 = r15 * r0
            int r3 = r3 / r1
            goto L_0x014c
        L_0x014a:
            r3 = r0
            r15 = r1
        L_0x014c:
            if (r2 != r6) goto L_0x0155
            if (r3 <= r14) goto L_0x0155
            int r1 = r1 * r14
            int r15 = r1 / r0
            goto L_0x0159
        L_0x0155:
            r14 = r3
            goto L_0x0159
        L_0x0157:
            r14 = r2
            r15 = r5
        L_0x0159:
            r13.mMeasuredWidth = r14
            r13.mMeasuredHeight = r15
            return
        L_0x015e:
            r13.mMeasuredWidth = r1
            r13.mMeasuredHeight = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shuyu.gsyvideoplayer.utils.MeasureHelper.doMeasure(int, int):void");
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

    public void prepareMeasure(int i2, int i3, int i4) {
        MeasureFormVideoParamsListener measureFormVideoParamsListener = this.mParamsListener;
        if (measureFormVideoParamsListener != null) {
            try {
                int currentVideoWidth = measureFormVideoParamsListener.getCurrentVideoWidth();
                int currentVideoHeight = this.mParamsListener.getCurrentVideoHeight();
                Debuger.printfLog("videoWidth: " + currentVideoWidth + " videoHeight: " + currentVideoHeight);
                int videoSarNum = this.mParamsListener.getVideoSarNum();
                int videoSarDen = this.mParamsListener.getVideoSarDen();
                if (currentVideoWidth > 0 && currentVideoHeight > 0) {
                    setVideoSampleAspectRatio(videoSarNum, videoSarDen);
                    setVideoSize(currentVideoWidth, currentVideoHeight);
                }
                setVideoRotation(i4);
                doMeasure(i2, i3);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
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
