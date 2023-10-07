package com.shuyu.gsyvideoplayer.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import jg.d;
import jg.g;

public class GifCreateHelper {
    /* access modifiers changed from: private */
    public int mDelay;
    private int mFrequencyCount;
    /* access modifiers changed from: private */
    public d mGSYVideoGifSaveListener;
    /* access modifiers changed from: private */
    public List<String> mPicList;
    private StandardGSYVideoPlayer mPlayer;
    /* access modifiers changed from: private */
    public int mSampleSize;
    /* access modifiers changed from: private */
    public boolean mSaveShotBitmapSuccess;
    /* access modifiers changed from: private */
    public int mScaleSize;
    private Timer mTimer;
    private TaskLocal mTimerTask;
    private File mTmpPath;

    private class TaskLocal extends TimerTask {
        private TaskLocal() {
        }

        public void run() {
            if (GifCreateHelper.this.mSaveShotBitmapSuccess) {
                boolean unused = GifCreateHelper.this.mSaveShotBitmapSuccess = false;
                GifCreateHelper.this.startSaveBitmap();
            }
        }
    }

    public GifCreateHelper(StandardGSYVideoPlayer standardGSYVideoPlayer, d dVar) {
        this(standardGSYVideoPlayer, dVar, 0, 1, 5, 50);
    }

    public GifCreateHelper(StandardGSYVideoPlayer standardGSYVideoPlayer, d dVar, int i2, int i3, int i4, int i5) {
        this.mSaveShotBitmapSuccess = true;
        this.mTimer = new Timer();
        this.mPicList = new ArrayList();
        this.mDelay = 0;
        this.mSampleSize = 1;
        this.mScaleSize = 5;
        this.mFrequencyCount = 50;
        this.mPlayer = standardGSYVideoPlayer;
        this.mGSYVideoGifSaveListener = dVar;
        this.mDelay = i2;
        this.mSampleSize = i3;
        this.mScaleSize = i4;
        this.mFrequencyCount = i5;
    }

    /* access modifiers changed from: private */
    public void startSaveBitmap() {
        File file = this.mTmpPath;
        this.mPlayer.saveFrame(new File(file, "GSY-TMP-FRAME" + System.currentTimeMillis() + ".tmp"), new g() {
            public void result(boolean z2, File file) {
                boolean unused = GifCreateHelper.this.mSaveShotBitmapSuccess = true;
                if (z2) {
                    Debuger.printfError(" SUCCESS CREATE FILE " + file.getAbsolutePath());
                    GifCreateHelper.this.mPicList.add(file.getAbsolutePath());
                }
            }
        });
    }

    public void cancelTask() {
        TaskLocal taskLocal = this.mTimerTask;
        if (taskLocal != null) {
            taskLocal.cancel();
            this.mTimerTask = null;
        }
    }

    public void createGif(File file, List<String> list, int i2, int i3, int i4, d dVar) {
        File file2 = file;
        List<String> list2 = list;
        d dVar2 = dVar;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        AnimatedGifEncoder animatedGifEncoder = new AnimatedGifEncoder();
        animatedGifEncoder.start(byteArrayOutputStream);
        animatedGifEncoder.setRepeat(0);
        animatedGifEncoder.setDelay(i2);
        int i5 = 0;
        while (i5 < list.size()) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = i3;
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(list2.get(i5), options);
            double d2 = (double) options.outWidth;
            double d3 = (double) i4;
            Double.isNaN(d2);
            Double.isNaN(d3);
            double d4 = (double) options.outHeight;
            Double.isNaN(d4);
            Double.isNaN(d3);
            options.inJustDecodeBounds = false;
            int i6 = i5;
            Bitmap decodeFile = BitmapFactory.decodeFile(list2.get(i6), options);
            Bitmap extractThumbnail = ThumbnailUtils.extractThumbnail(decodeFile, (int) (d2 / d3), (int) (d4 / d3));
            animatedGifEncoder.addFrame(extractThumbnail);
            decodeFile.recycle();
            extractThumbnail.recycle();
            i5 = i6 + 1;
            dVar2.a(i5, list.size());
        }
        animatedGifEncoder.finish();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file.getPath());
            byteArrayOutputStream.writeTo(fileOutputStream);
            byteArrayOutputStream.flush();
            fileOutputStream.flush();
            byteArrayOutputStream.close();
            fileOutputStream.close();
            dVar2.a(true, file2);
        } catch (IOException e2) {
            e2.printStackTrace();
            dVar2.a(false, file2);
        }
    }

    public void startGif(File file) {
        this.mTmpPath = file;
        cancelTask();
        this.mPicList.clear();
        TaskLocal taskLocal = new TaskLocal();
        this.mTimerTask = taskLocal;
        this.mTimer.schedule(taskLocal, 0, (long) this.mFrequencyCount);
    }

    public void stopGif(final File file) {
        cancelTask();
        this.mSaveShotBitmapSuccess = true;
        new Thread(new Runnable() {
            public void run() {
                if (GifCreateHelper.this.mPicList.size() > 2) {
                    GifCreateHelper gifCreateHelper = GifCreateHelper.this;
                    gifCreateHelper.createGif(file, gifCreateHelper.mPicList, GifCreateHelper.this.mDelay, GifCreateHelper.this.mSampleSize, GifCreateHelper.this.mScaleSize, GifCreateHelper.this.mGSYVideoGifSaveListener);
                    return;
                }
                GifCreateHelper.this.mGSYVideoGifSaveListener.a(false, (File) null);
            }
        }).start();
    }
}
