package com.huawei.android.multiscreen.mirror.sdk.ui;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import java.util.Random;

public class GrabDemoActivityTask {
    private static final String TAG = "MIRROR_SDK";
    private static GrabDemoActivityTask instance;
    /* access modifiers changed from: private */
    public Context context;
    Thread otherActivityThreadTest = new Thread(new Runnable() {
        public void run() {
            Random random = new Random();
            while (GrabDemoActivityTask.this.running) {
                Intent intent = new Intent(GrabDemoActivityTask.this.context, SinkActivity.class);
                intent.addFlags(AMapEngineUtils.MAX_P20_WIDTH);
                intent.addFlags(AMapEngineUtils.HALF_MAX_P20_WIDTH);
                GrabDemoActivityTask.this.context.startActivity(intent);
                try {
                    Thread.sleep((long) (random.nextInt(3000) + 10));
                } catch (InterruptedException e2) {
                    Log.e(GrabDemoActivityTask.TAG, "Thread.sleep Exception", e2);
                }
            }
        }
    });
    /* access modifiers changed from: private */
    public boolean running;

    private GrabDemoActivityTask(Context context2) {
        this.context = context2;
    }

    public static GrabDemoActivityTask buildInstence(Context context2) {
        GrabDemoActivityTask grabDemoActivityTask = instance;
        if (grabDemoActivityTask != null) {
            return grabDemoActivityTask;
        }
        GrabDemoActivityTask grabDemoActivityTask2 = new GrabDemoActivityTask(context2);
        instance = grabDemoActivityTask2;
        return grabDemoActivityTask2;
    }

    public static void destroyInstence() {
        GrabDemoActivityTask grabDemoActivityTask = instance;
        if (grabDemoActivityTask != null) {
            grabDemoActivityTask.stop();
            instance = null;
        }
    }

    public void start() {
        this.running = true;
        this.otherActivityThreadTest.start();
    }

    public void stop() {
        this.running = false;
    }
}
