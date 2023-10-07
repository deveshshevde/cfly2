package com.xeagle.android.helpers;

import android.content.Context;
import android.preference.PreferenceManager;
import com.flypro.core.MAVLink.k;
import en.a;
import java.util.Arrays;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class RcOutput {
    public static final int AILERON = 0;
    private static final int DISABLE_OVERRIDE = 0;
    public static final int ELEVATOR = 1;
    public static final int RC5 = 4;
    public static final int RC6 = 5;
    public static final int RC7 = 6;
    public static final int RC8 = 7;
    private static final int RC_RANGE = 550;
    private static final int RC_TRIM = 1500;
    public static final int RUDDER = 3;
    public static final int TROTTLE = 2;
    /* access modifiers changed from: private */
    public a drone;
    private Context parrentContext;
    public int[] rcOutputs = new int[8];
    private ScheduledExecutorService scheduleTaskExecutor;

    public RcOutput(a aVar, Context context) {
        this.drone = aVar;
        this.parrentContext = context;
    }

    private int getRcOverrideDelayMs() {
        int parseInt = Integer.parseInt(PreferenceManager.getDefaultSharedPreferences(this.parrentContext).getString("pref_mavlink_stream_rate_RC_override", "0"));
        boolean z2 = false;
        boolean z3 = parseInt > 1;
        if (parseInt < 500) {
            z2 = true;
        }
        if (z2 && z3) {
            return 1000 / parseInt;
        }
        return 20;
    }

    public void disableRcOverride() {
        if (isRcOverrided()) {
            this.scheduleTaskExecutor.shutdownNow();
            this.scheduleTaskExecutor = null;
        }
        Arrays.fill(this.rcOutputs, 0);
        k.a(this.drone, this.rcOutputs);
        k.a(this.drone, this.rcOutputs);
        k.a(this.drone, this.rcOutputs);
    }

    public void enableRcOverride() {
        if (!isRcOverrided()) {
            Arrays.fill(this.rcOutputs, 0);
            k.a(this.drone, this.rcOutputs);
            k.a(this.drone, this.rcOutputs);
            k.a(this.drone, this.rcOutputs);
            Arrays.fill(this.rcOutputs, 0);
            ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(5);
            this.scheduleTaskExecutor = newScheduledThreadPool;
            newScheduledThreadPool.scheduleWithFixedDelay(new Runnable() {
                public void run() {
                    k.a(RcOutput.this.drone, RcOutput.this.rcOutputs);
                }
            }, 0, (long) getRcOverrideDelayMs(), TimeUnit.MILLISECONDS);
        }
    }

    public boolean isRcOverrided() {
        return this.scheduleTaskExecutor != null;
    }

    public void setRcChannel(int i2, double d2) {
        if (d2 > 1.0d) {
            d2 = 1.0d;
        }
        if (d2 < -1.0d) {
            d2 = -1.0d;
        }
        this.rcOutputs[i2] = (int) ((d2 * 550.0d) + 1500.0d);
    }
}
