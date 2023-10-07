package com.xeagle.android.login.ijkplayer;

import android.content.Context;
import android.os.Handler;
import android.util.SparseArray;
import android.view.View;
import android.widget.TableLayout;
import java.util.Locale;
import tv.danmaku.ijk.media.player.IMediaPlayer;

public class InfoHudViewHolder {
    private static final int MSG_UPDATE_HUD = 1;
    /* access modifiers changed from: private */
    public Handler mHandler = new Handler() {
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0044, code lost:
            if ((r1 instanceof tv.danmaku.ijk.media.player.IjkMediaPlayer) != false) goto L_0x0026;
         */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x004b  */
        /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void handleMessage(android.os.Message r20) {
            /*
                r19 = this;
                r0 = r19
                r1 = r20
                int r1 = r1.what
                r2 = 1
                if (r1 == r2) goto L_0x000b
                goto L_0x0189
            L_0x000b:
                com.xeagle.android.login.ijkplayer.InfoHudViewHolder r1 = com.xeagle.android.login.ijkplayer.InfoHudViewHolder.this
                r3 = 0
                tv.danmaku.ijk.media.player.IMediaPlayer r1 = r1.mMediaPlayer
                if (r1 != 0) goto L_0x0016
                goto L_0x0189
            L_0x0016:
                com.xeagle.android.login.ijkplayer.InfoHudViewHolder r1 = com.xeagle.android.login.ijkplayer.InfoHudViewHolder.this
                tv.danmaku.ijk.media.player.IMediaPlayer r1 = r1.mMediaPlayer
                boolean r1 = r1 instanceof tv.danmaku.ijk.media.player.IjkMediaPlayer
                if (r1 == 0) goto L_0x002a
                com.xeagle.android.login.ijkplayer.InfoHudViewHolder r1 = com.xeagle.android.login.ijkplayer.InfoHudViewHolder.this
                tv.danmaku.ijk.media.player.IMediaPlayer r1 = r1.mMediaPlayer
            L_0x0026:
                r3 = r1
                tv.danmaku.ijk.media.player.IjkMediaPlayer r3 = (tv.danmaku.ijk.media.player.IjkMediaPlayer) r3
                goto L_0x0047
            L_0x002a:
                com.xeagle.android.login.ijkplayer.InfoHudViewHolder r1 = com.xeagle.android.login.ijkplayer.InfoHudViewHolder.this
                tv.danmaku.ijk.media.player.IMediaPlayer r1 = r1.mMediaPlayer
                boolean r1 = r1 instanceof tv.danmaku.ijk.media.player.MediaPlayerProxy
                if (r1 == 0) goto L_0x0047
                com.xeagle.android.login.ijkplayer.InfoHudViewHolder r1 = com.xeagle.android.login.ijkplayer.InfoHudViewHolder.this
                tv.danmaku.ijk.media.player.IMediaPlayer r1 = r1.mMediaPlayer
                tv.danmaku.ijk.media.player.MediaPlayerProxy r1 = (tv.danmaku.ijk.media.player.MediaPlayerProxy) r1
                tv.danmaku.ijk.media.player.IMediaPlayer r1 = r1.getInternalMediaPlayer()
                if (r1 == 0) goto L_0x0047
                boolean r4 = r1 instanceof tv.danmaku.ijk.media.player.IjkMediaPlayer
                if (r4 == 0) goto L_0x0047
                goto L_0x0026
            L_0x0047:
                if (r3 != 0) goto L_0x004b
                goto L_0x0189
            L_0x004b:
                int r1 = r3.getVideoDecoder()
                r4 = 2131823112(0x7f110a08, float:1.9279014E38)
                r5 = 2
                if (r1 == r2) goto L_0x0061
                if (r1 == r5) goto L_0x005c
                com.xeagle.android.login.ijkplayer.InfoHudViewHolder r1 = com.xeagle.android.login.ijkplayer.InfoHudViewHolder.this
                java.lang.String r6 = ""
                goto L_0x0065
            L_0x005c:
                com.xeagle.android.login.ijkplayer.InfoHudViewHolder r1 = com.xeagle.android.login.ijkplayer.InfoHudViewHolder.this
                java.lang.String r6 = "MediaCodec"
                goto L_0x0065
            L_0x0061:
                com.xeagle.android.login.ijkplayer.InfoHudViewHolder r1 = com.xeagle.android.login.ijkplayer.InfoHudViewHolder.this
                java.lang.String r6 = "avcodec"
            L_0x0065:
                r1.setRowValue(r4, r6)
                float r1 = r3.getVideoOutputFramesPerSecond()
                float r4 = r3.getVideoDecodeFramesPerSecond()
                com.xeagle.android.login.ijkplayer.InfoHudViewHolder r6 = com.xeagle.android.login.ijkplayer.InfoHudViewHolder.this
                r7 = 2131821404(0x7f11035c, float:1.927555E38)
                java.util.Locale r8 = java.util.Locale.US
                java.lang.Object[] r9 = new java.lang.Object[r5]
                java.lang.Float r4 = java.lang.Float.valueOf(r4)
                r10 = 0
                r9[r10] = r4
                java.lang.Float r1 = java.lang.Float.valueOf(r1)
                r9[r2] = r1
                java.lang.String r1 = "%.2f / %.2f"
                java.lang.String r1 = java.lang.String.format(r8, r1, r9)
                r6.setRowValue(r7, r1)
                long r6 = r3.getVideoCachedDuration()
                long r8 = r3.getAudioCachedDuration()
                long r11 = r3.getVideoCachedBytes()
                long r13 = r3.getAudioCachedBytes()
                r15 = r11
                long r10 = r3.getTcpSpeed()
                r17 = r6
                long r5 = r3.getBitRate()
                long r3 = r3.getSeekLoadDuration()
                com.xeagle.android.login.ijkplayer.InfoHudViewHolder r7 = com.xeagle.android.login.ijkplayer.InfoHudViewHolder.this
                java.util.Locale r1 = java.util.Locale.US
                r12 = 2
                java.lang.Object[] r2 = new java.lang.Object[r12]
                java.lang.String r17 = com.xeagle.android.login.ijkplayer.InfoHudViewHolder.formatedDurationMilli(r17)
                r18 = 0
                r2[r18] = r17
                java.lang.String r15 = com.xeagle.android.login.ijkplayer.InfoHudViewHolder.formatedSize(r15)
                r12 = 1
                r2[r12] = r15
                java.lang.String r15 = "%s, %s"
                java.lang.String r1 = java.lang.String.format(r1, r15, r2)
                r2 = 2131823111(0x7f110a07, float:1.9279012E38)
                r7.setRowValue(r2, r1)
                com.xeagle.android.login.ijkplayer.InfoHudViewHolder r1 = com.xeagle.android.login.ijkplayer.InfoHudViewHolder.this
                java.util.Locale r7 = java.util.Locale.US
                r2 = 2
                java.lang.Object[] r2 = new java.lang.Object[r2]
                java.lang.String r8 = com.xeagle.android.login.ijkplayer.InfoHudViewHolder.formatedDurationMilli(r8)
                r2[r18] = r8
                java.lang.String r8 = com.xeagle.android.login.ijkplayer.InfoHudViewHolder.formatedSize(r13)
                r2[r12] = r8
                java.lang.String r2 = java.lang.String.format(r7, r15, r2)
                r7 = 2131820571(0x7f11001b, float:1.927386E38)
                r1.setRowValue(r7, r2)
                com.xeagle.android.login.ijkplayer.InfoHudViewHolder r1 = com.xeagle.android.login.ijkplayer.InfoHudViewHolder.this
                r2 = 2131821586(0x7f110412, float:1.927592E38)
                java.util.Locale r7 = java.util.Locale.US
                java.lang.Object[] r8 = new java.lang.Object[r12]
                com.xeagle.android.login.ijkplayer.InfoHudViewHolder r9 = com.xeagle.android.login.ijkplayer.InfoHudViewHolder.this
                long r13 = r9.mLoadCost
                java.lang.Long r9 = java.lang.Long.valueOf(r13)
                r13 = 0
                r8[r13] = r9
                java.lang.String r9 = "%d ms"
                java.lang.String r7 = java.lang.String.format(r7, r9, r8)
                r1.setRowValue(r2, r7)
                com.xeagle.android.login.ijkplayer.InfoHudViewHolder r1 = com.xeagle.android.login.ijkplayer.InfoHudViewHolder.this
                r2 = 2131822593(0x7f110801, float:1.9277962E38)
                java.util.Locale r7 = java.util.Locale.US
                java.lang.Object[] r8 = new java.lang.Object[r12]
                com.xeagle.android.login.ijkplayer.InfoHudViewHolder r14 = com.xeagle.android.login.ijkplayer.InfoHudViewHolder.this
                long r14 = r14.mSeekCost
                java.lang.Long r14 = java.lang.Long.valueOf(r14)
                r8[r13] = r14
                java.lang.String r7 = java.lang.String.format(r7, r9, r8)
                r1.setRowValue(r2, r7)
                com.xeagle.android.login.ijkplayer.InfoHudViewHolder r1 = com.xeagle.android.login.ijkplayer.InfoHudViewHolder.this
                r2 = 2131822595(0x7f110803, float:1.9277966E38)
                java.util.Locale r7 = java.util.Locale.US
                java.lang.Object[] r8 = new java.lang.Object[r12]
                java.lang.Long r3 = java.lang.Long.valueOf(r3)
                r8[r13] = r3
                java.lang.String r3 = java.lang.String.format(r7, r9, r8)
                r1.setRowValue(r2, r3)
                com.xeagle.android.login.ijkplayer.InfoHudViewHolder r1 = com.xeagle.android.login.ijkplayer.InfoHudViewHolder.this
                r2 = 2131822908(0x7f11093c, float:1.92786E38)
                java.util.Locale r3 = java.util.Locale.US
                java.lang.Object[] r4 = new java.lang.Object[r12]
                r7 = 1000(0x3e8, double:4.94E-321)
                java.lang.String r7 = com.xeagle.android.login.ijkplayer.InfoHudViewHolder.formatedSpeed(r10, r7)
                r4[r13] = r7
                java.lang.String r7 = "%s"
                java.lang.String r3 = java.lang.String.format(r3, r7, r4)
                r1.setRowValue(r2, r3)
                com.xeagle.android.login.ijkplayer.InfoHudViewHolder r1 = com.xeagle.android.login.ijkplayer.InfoHudViewHolder.this
                r2 = 2131820761(0x7f1100d9, float:1.9274246E38)
                java.util.Locale r3 = java.util.Locale.US
                java.lang.Object[] r4 = new java.lang.Object[r12]
                float r5 = (float) r5
                r6 = 1148846080(0x447a0000, float:1000.0)
                float r5 = r5 / r6
                java.lang.Float r5 = java.lang.Float.valueOf(r5)
                r6 = 0
                r4[r6] = r5
                java.lang.String r5 = "%.2f kbs"
                java.lang.String r3 = java.lang.String.format(r3, r5, r4)
                r1.setRowValue(r2, r3)
                com.xeagle.android.login.ijkplayer.InfoHudViewHolder r1 = com.xeagle.android.login.ijkplayer.InfoHudViewHolder.this
                android.os.Handler r1 = r1.mHandler
                r1.removeMessages(r12)
                com.xeagle.android.login.ijkplayer.InfoHudViewHolder r1 = com.xeagle.android.login.ijkplayer.InfoHudViewHolder.this
                android.os.Handler r1 = r1.mHandler
                r2 = 500(0x1f4, double:2.47E-321)
                r1.sendEmptyMessageDelayed(r12, r2)
            L_0x0189:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.login.ijkplayer.InfoHudViewHolder.AnonymousClass1.handleMessage(android.os.Message):void");
        }
    };
    /* access modifiers changed from: private */
    public long mLoadCost = 0;
    /* access modifiers changed from: private */
    public IMediaPlayer mMediaPlayer;
    private SparseArray<View> mRowMap = new SparseArray<>();
    /* access modifiers changed from: private */
    public long mSeekCost = 0;
    private TableLayoutBinder mTableLayoutBinder;

    public InfoHudViewHolder(Context context, TableLayout tableLayout) {
        this.mTableLayoutBinder = new TableLayoutBinder(context, tableLayout);
    }

    private void appendRow(int i2) {
        this.mRowMap.put(i2, this.mTableLayoutBinder.appendRow2(i2, (String) null));
    }

    private void appendSection(int i2) {
        this.mTableLayoutBinder.appendSection(i2);
    }

    /* access modifiers changed from: private */
    public static String formatedDurationMilli(long j2) {
        int i2 = (j2 > 1000 ? 1 : (j2 == 1000 ? 0 : -1));
        Locale locale = Locale.US;
        Object[] objArr = new Object[1];
        if (i2 >= 0) {
            objArr[0] = Float.valueOf(((float) j2) / 1000.0f);
            return String.format(locale, "%.2f sec", objArr);
        }
        objArr[0] = Long.valueOf(j2);
        return String.format(locale, "%d msec", objArr);
    }

    /* access modifiers changed from: private */
    public static String formatedSize(long j2) {
        if (j2 >= 100000) {
            return String.format(Locale.US, "%.2f MB", new Object[]{Float.valueOf((((float) j2) / 1000.0f) / 1000.0f)});
        } else if (j2 >= 100) {
            return String.format(Locale.US, "%.1f KB", new Object[]{Float.valueOf(((float) j2) / 1000.0f)});
        } else {
            return String.format(Locale.US, "%d B", new Object[]{Long.valueOf(j2)});
        }
    }

    /* access modifiers changed from: private */
    public static String formatedSpeed(long j2, long j3) {
        if (j3 <= 0 || j2 <= 0) {
            return "0 B/s";
        }
        float f2 = (((float) j2) * 1000.0f) / ((float) j3);
        if (f2 >= 1000000.0f) {
            return String.format(Locale.US, "%.2f MB/s", new Object[]{Float.valueOf((f2 / 1000.0f) / 1000.0f)});
        } else if (f2 >= 1000.0f) {
            return String.format(Locale.US, "%.1f KB/s", new Object[]{Float.valueOf(f2 / 1000.0f)});
        } else {
            return String.format(Locale.US, "%d B/s", new Object[]{Long.valueOf((long) f2)});
        }
    }

    /* access modifiers changed from: private */
    public void setRowValue(int i2, String str) {
        View view = this.mRowMap.get(i2);
        if (view == null) {
            this.mRowMap.put(i2, this.mTableLayoutBinder.appendRow2(i2, str));
            return;
        }
        this.mTableLayoutBinder.setValueText(view, str);
    }

    public void setMediaPlayer(IMediaPlayer iMediaPlayer) {
        this.mMediaPlayer = iMediaPlayer;
        if (iMediaPlayer != null) {
            this.mHandler.sendEmptyMessageDelayed(1, 500);
        } else {
            this.mHandler.removeMessages(1);
        }
    }

    public void updateLoadCost(long j2) {
        this.mLoadCost = j2;
    }

    public void updateSeekCost(long j2) {
        this.mSeekCost = j2;
    }
}
