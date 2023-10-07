package com.xeagle.android.utils;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.net.Uri;
import android.util.SparseIntArray;
import com.xeagle.R;
import com.xeagle.android.XEagleApp;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class ab {

    /* renamed from: a  reason: collision with root package name */
    private static volatile ab f24363a;

    /* renamed from: b  reason: collision with root package name */
    private ExecutorService f24364b;

    /* renamed from: c  reason: collision with root package name */
    private ExecutorService f24365c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public SoundPool f24366d;

    /* renamed from: e  reason: collision with root package name */
    private com.xeagle.android.utils.prefs.a f24367e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public int f24368f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public SparseIntArray f24369g = new SparseIntArray();
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public SparseIntArray f24370h = new SparseIntArray();
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public volatile BlockingQueue<Integer> f24371i = new LinkedBlockingQueue();
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public int f24372j;

    private class a implements Runnable {
        private a() {
        }

        public void run() {
            while (true) {
                try {
                    ab abVar = ab.this;
                    int unused = abVar.f24372j = ((Integer) abVar.f24371i.take()).intValue();
                    ab abVar2 = ab.this;
                    int unused2 = abVar2.f24368f = abVar2.f24366d.play(ab.this.f24369g.get(ab.this.f24372j), 1.0f, 1.0f, 0, 0, 1.0f);
                    Thread.sleep((long) ab.this.f24370h.get(ab.this.f24372j));
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(Context context, int i2) {
        this.f24371i.offer(Integer.valueOf(i2));
    }

    public static ab b() {
        if (f24363a == null) {
            synchronized (ab.class) {
                if (f24363a == null) {
                    f24363a = new ab();
                }
            }
        }
        return f24363a;
    }

    public void a() {
        ExecutorService executorService = this.f24364b;
        if (executorService != null) {
            executorService.shutdown();
            this.f24364b = null;
        }
        SoundPool soundPool = this.f24366d;
        if (soundPool != null) {
            soundPool.stop(this.f24368f);
        }
    }

    public void a(int i2) {
        this.f24371i.remove(Integer.valueOf(i2));
    }

    public void a(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f24367e = ((XEagleApp) context).j();
        this.f24366d = new SoundPool.Builder().build();
        for (Field field : R.raw.class.getDeclaredFields()) {
            try {
                int i2 = field.getInt(R.raw.class);
                Uri parse = Uri.parse("android.resource://" + context.getPackageName() + "/" + i2);
                MediaPlayer mediaPlayer = new MediaPlayer();
                mediaPlayer.setDataSource(context, parse);
                mediaPlayer.setAudioStreamType(3);
                mediaPlayer.prepare();
                int duration = mediaPlayer.getDuration();
                this.f24369g.put(i2, this.f24366d.load(applicationContext, i2, 1));
                this.f24370h.put(i2, duration);
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        }
    }

    public void a(final Context context, final String str) {
        if (this.f24367e.I()) {
            this.f24365c.execute(new Runnable() {
                public void run() {
                    ab b2;
                    Context context;
                    int i2;
                    if (!str.equalsIgnoreCase(context.getString(com.cfly.uav_pro.R.string.usb_sport_gear_warn))) {
                        if (str.equalsIgnoreCase(context.getString(com.cfly.uav_pro.R.string.prearm_acc_cal_detail))) {
                            b2 = ab.b();
                            context = context;
                            i2 = com.cfly.uav_pro.R.raw.acc_no_cal;
                        } else if (str.equalsIgnoreCase(context.getString(com.cfly.uav_pro.R.string.spinner_mode_althold))) {
                            b2 = ab.b();
                            context = context;
                            i2 = com.cfly.uav_pro.R.raw.alt_hold_mode;
                        } else if (str.equalsIgnoreCase(context.getString(com.cfly.uav_pro.R.string.circle_mode_running))) {
                            b2 = ab.b();
                            context = context;
                            i2 = com.cfly.uav_pro.R.raw.circle_mode_run;
                        } else if (str.equalsIgnoreCase(context.getString(com.cfly.uav_pro.R.string.tts_battery_invalid))) {
                            b2 = ab.b();
                            context = context;
                            i2 = com.cfly.uav_pro.R.raw.drone_check_fail;
                        } else if (str.equalsIgnoreCase(context.getString(com.cfly.uav_pro.R.string.follow_mode_running))) {
                            b2 = ab.b();
                            context = context;
                            i2 = com.cfly.uav_pro.R.raw.follow_mode_run;
                        } else if (str.equalsIgnoreCase(context.getString(com.cfly.uav_pro.R.string.land_finish))) {
                            b2 = ab.b();
                            context = context;
                            i2 = com.cfly.uav_pro.R.raw.land_finish;
                        } else if (str.equalsIgnoreCase(context.getString(com.cfly.uav_pro.R.string.land_mode_running))) {
                            b2 = ab.b();
                            context = context;
                            i2 = com.cfly.uav_pro.R.raw.land_mode_run;
                        } else if (str.equalsIgnoreCase(context.getString(com.cfly.uav_pro.R.string.spinner_mode_loiter))) {
                            b2 = ab.b();
                            context = context;
                            i2 = com.cfly.uav_pro.R.raw.loiter_mode_run;
                        } else if (str.equalsIgnoreCase(context.getString(com.cfly.uav_pro.R.string.rtl_height_success_detail))) {
                            b2 = ab.b();
                            context = context;
                            i2 = com.cfly.uav_pro.R.raw.tts_rtl_height_success;
                        } else if (str.equalsIgnoreCase(context.getString(com.cfly.uav_pro.R.string.rtl_mode_auto))) {
                            b2 = ab.b();
                            context = context;
                            i2 = com.cfly.uav_pro.R.raw.rtl_mode_auto;
                        } else if (str.equalsIgnoreCase(context.getString(com.cfly.uav_pro.R.string.rtl_mode_battery))) {
                            b2 = ab.b();
                            context = context;
                            i2 = com.cfly.uav_pro.R.raw.rtl_mode_battery;
                        } else if (str.equalsIgnoreCase(context.getString(com.cfly.uav_pro.R.string.rtl_mode_lost))) {
                            b2 = ab.b();
                            context = context;
                            i2 = com.cfly.uav_pro.R.raw.rtl_mode_lost;
                        } else if (str.equalsIgnoreCase(context.getString(com.cfly.uav_pro.R.string.rtl_mode_running))) {
                            b2 = ab.b();
                            context = context;
                            i2 = com.cfly.uav_pro.R.raw.rtl_mode_running;
                        } else {
                            if (!str.equalsIgnoreCase(context.getString(com.cfly.uav_pro.R.string.set_rtl_home_success))) {
                                if (!str.equalsIgnoreCase(context.getString(com.cfly.uav_pro.R.string.usb_sport_gear_warn))) {
                                    if (str.equalsIgnoreCase(context.getString(com.cfly.uav_pro.R.string.notify_take_off))) {
                                        b2 = ab.b();
                                        context = context;
                                        i2 = com.cfly.uav_pro.R.raw.take_off;
                                    } else if (str.equalsIgnoreCase(context.getString(com.cfly.uav_pro.R.string.acc_cal_reboot))) {
                                        b2 = ab.b();
                                        context = context;
                                        i2 = com.cfly.uav_pro.R.raw.tts_acc_cal_reboot;
                                    } else if (str.equalsIgnoreCase(context.getString(com.cfly.uav_pro.R.string.prearm_acc_hel_detail))) {
                                        b2 = ab.b();
                                        context = context;
                                        i2 = com.cfly.uav_pro.R.raw.tts_acc_hel;
                                    } else if (str.equalsIgnoreCase(context.getString(com.cfly.uav_pro.R.string.prearm_alt_display_detail))) {
                                        b2 = ab.b();
                                        context = context;
                                        i2 = com.cfly.uav_pro.R.raw.tts_alt_display;
                                    } else if (str.equalsIgnoreCase(context.getString(com.cfly.uav_pro.R.string.althold_limit_warn))) {
                                        b2 = ab.b();
                                        context = context;
                                        i2 = com.cfly.uav_pro.R.raw.tts_althold_limit;
                                    } else if (str.equalsIgnoreCase(context.getString(com.cfly.uav_pro.R.string.attitude_failure))) {
                                        b2 = ab.b();
                                        context = context;
                                        i2 = com.cfly.uav_pro.R.raw.tts_attitude_failure;
                                    } else if (str.equalsIgnoreCase(context.getString(com.cfly.uav_pro.R.string.bad_ahs_error))) {
                                        b2 = ab.b();
                                        context = context;
                                        i2 = com.cfly.uav_pro.R.raw.tts_bad_ahs;
                                    } else if (str.equalsIgnoreCase(context.getString(com.cfly.uav_pro.R.string.prearm_baro_hel_detail))) {
                                        b2 = ab.b();
                                        context = context;
                                        i2 = com.cfly.uav_pro.R.raw.tts_baro_hel;
                                    } else if (str.equalsIgnoreCase(context.getString(com.cfly.uav_pro.R.string.set_battery_sn_detail))) {
                                        b2 = ab.b();
                                        context = context;
                                        i2 = com.cfly.uav_pro.R.raw.tts_battery_sn;
                                    } else if (str.equalsIgnoreCase(context.getString(com.cfly.uav_pro.R.string.set_battery_time_detail))) {
                                        b2 = ab.b();
                                        context = context;
                                        i2 = com.cfly.uav_pro.R.raw.tts_battery_time;
                                    } else if (str.equalsIgnoreCase(context.getString(com.cfly.uav_pro.R.string.battery_unactivated))) {
                                        b2 = ab.b();
                                        context = context;
                                        i2 = com.cfly.uav_pro.R.raw.tts_battery_unactivated;
                                    } else if (str.equalsIgnoreCase(context.getString(com.cfly.uav_pro.R.string.fence_beginner_mode_detail))) {
                                        b2 = ab.b();
                                        context = context;
                                        i2 = com.cfly.uav_pro.R.raw.tts_beginner_mode;
                                    } else if (str.equalsIgnoreCase(context.getString(com.cfly.uav_pro.R.string.prearm_comp_cal_detail))) {
                                        b2 = ab.b();
                                        context = context;
                                        i2 = com.cfly.uav_pro.R.raw.tts_comp_cal;
                                    } else if (str.equalsIgnoreCase(context.getString(com.cfly.uav_pro.R.string.prearm_comp_hel_detail))) {
                                        b2 = ab.b();
                                        context = context;
                                        i2 = com.cfly.uav_pro.R.raw.tts_comp_hel;
                                    } else if (str.equalsIgnoreCase(context.getString(com.cfly.uav_pro.R.string.prearm_comp_offset_detail))) {
                                        b2 = ab.b();
                                        context = context;
                                        i2 = com.cfly.uav_pro.R.raw.tts_comp_offset;
                                    } else if (str.equalsIgnoreCase(context.getString(com.cfly.uav_pro.R.string.compass_variance_detail))) {
                                        b2 = ab.b();
                                        context = context;
                                        i2 = com.cfly.uav_pro.R.raw.tts_compass_variance;
                                    } else if (str.equalsIgnoreCase(context.getString(com.cfly.uav_pro.R.string.set_drone_sn_detail))) {
                                        b2 = ab.b();
                                        context = context;
                                        i2 = com.cfly.uav_pro.R.raw.tts_drone_sn;
                                    } else if (str.equalsIgnoreCase(context.getString(com.cfly.uav_pro.R.string.set_drone_time_detail))) {
                                        b2 = ab.b();
                                        context = context;
                                        i2 = com.cfly.uav_pro.R.raw.tts_drone_time;
                                    } else if (str.equalsIgnoreCase(context.getString(com.cfly.uav_pro.R.string.drone_unactived))) {
                                        b2 = ab.b();
                                        context = context;
                                        i2 = com.cfly.uav_pro.R.raw.tts_drone_unactived;
                                    } else if (str.equalsIgnoreCase(context.getString(com.cfly.uav_pro.R.string.gimbal_init))) {
                                        b2 = ab.b();
                                        context = context;
                                        i2 = com.cfly.uav_pro.R.raw.tts_gimbal_init;
                                    } else if (str.equalsIgnoreCase(context.getString(com.cfly.uav_pro.R.string.gimbal_tips))) {
                                        b2 = ab.b();
                                        context = context;
                                        i2 = com.cfly.uav_pro.R.raw.tts_gimbal_tips;
                                    } else if (str.equalsIgnoreCase(context.getString(com.cfly.uav_pro.R.string.prearm_gyro_hel_detail))) {
                                        b2 = ab.b();
                                        context = context;
                                        i2 = com.cfly.uav_pro.R.raw.tts_gyro_hel;
                                    } else if (str.equalsIgnoreCase(context.getString(com.cfly.uav_pro.R.string.low_battery_warn))) {
                                        b2 = ab.b();
                                        context = context;
                                        i2 = com.cfly.uav_pro.R.raw.tts_low_battery;
                                    } else if (str.equalsIgnoreCase(context.getString(com.cfly.uav_pro.R.string.mode_not_arm_detail))) {
                                        b2 = ab.b();
                                        context = context;
                                        i2 = com.cfly.uav_pro.R.raw.tts_mode_not_arm;
                                    } else if (str.equalsIgnoreCase(context.getString(com.cfly.uav_pro.R.string.prearm_rc_cal_detail))) {
                                        b2 = ab.b();
                                        context = context;
                                        i2 = com.cfly.uav_pro.R.raw.tts_rc_cal;
                                    } else if (str.equalsIgnoreCase(context.getString(com.cfly.uav_pro.R.string.rtl_height_exceeds_detail))) {
                                        b2 = ab.b();
                                        context = context;
                                        i2 = com.cfly.uav_pro.R.raw.tts_rtl_height_exceeds;
                                    } else if (str.equalsIgnoreCase(context.getString(com.cfly.uav_pro.R.string.rtl_height_invalid_detail))) {
                                        b2 = ab.b();
                                        context = context;
                                        i2 = com.cfly.uav_pro.R.raw.tts_rtl_height_invalid;
                                    } else if (str.equalsIgnoreCase(context.getString(com.cfly.uav_pro.R.string.set_rtl_home_fail_gps))) {
                                        b2 = ab.b();
                                        context = context;
                                        i2 = com.cfly.uav_pro.R.raw.tts_rtl_home_fail;
                                    } else if (str.equalsIgnoreCase(context.getString(com.cfly.uav_pro.R.string.set_rtl_home_fail_power))) {
                                        b2 = ab.b();
                                        context = context;
                                        i2 = com.cfly.uav_pro.R.raw.tts_rtl_home_fail_power;
                                    } else if (!str.equalsIgnoreCase(context.getString(com.cfly.uav_pro.R.string.set_rtl_home_success))) {
                                        if (str.equalsIgnoreCase(context.getString(com.cfly.uav_pro.R.string.sport_mode_warn))) {
                                            b2 = ab.b();
                                            context = context;
                                            i2 = com.cfly.uav_pro.R.raw.tts_sport_mode;
                                        } else if (str.equalsIgnoreCase(context.getString(com.cfly.uav_pro.R.string.prearm_thr_fs_detail))) {
                                            b2 = ab.b();
                                            context = context;
                                            i2 = com.cfly.uav_pro.R.raw.tts_thr_fs;
                                        } else if (str.equalsIgnoreCase(context.getString(com.cfly.uav_pro.R.string.unknown_battery))) {
                                            b2 = ab.b();
                                            context = context;
                                            i2 = com.cfly.uav_pro.R.raw.tts_unknown_battery;
                                        } else if (str.equalsIgnoreCase(context.getString(com.cfly.uav_pro.R.string.wind_large))) {
                                            b2 = ab.b();
                                            context = context;
                                            i2 = com.cfly.uav_pro.R.raw.tts_wind_too_high;
                                        } else if (str.equalsIgnoreCase(context.getString(com.cfly.uav_pro.R.string.vibration_large_detail))) {
                                            b2 = ab.b();
                                            context = context;
                                            i2 = com.cfly.uav_pro.R.raw.tts_vibration_large;
                                        } else if (str.equalsIgnoreCase(context.getString(com.cfly.uav_pro.R.string.rtl_power_saturated))) {
                                            b2 = ab.b();
                                            context = context;
                                            i2 = com.cfly.uav_pro.R.raw.tts_rtl_power_saturated;
                                        } else if (str.equalsIgnoreCase(context.getString(com.cfly.uav_pro.R.string.gps_not_locked))) {
                                            b2 = ab.b();
                                            context = context;
                                            i2 = com.cfly.uav_pro.R.raw.tts_gps_not_locked;
                                        } else if (str.equalsIgnoreCase(context.getString(com.cfly.uav_pro.R.string.optical_flow_invalid))) {
                                            b2 = ab.b();
                                            context = context;
                                            i2 = com.cfly.uav_pro.R.raw.tts_optical_flow_invalid;
                                        } else if (str.equalsIgnoreCase(context.getString(com.cfly.uav_pro.R.string.gps_satellites_few))) {
                                            b2 = ab.b();
                                            context = context;
                                            i2 = com.cfly.uav_pro.R.raw.tts_gps_satellites_few;
                                        } else if (str.equalsIgnoreCase(context.getString(com.cfly.uav_pro.R.string.drone_early_rtl))) {
                                            b2 = ab.b();
                                            context = context;
                                            i2 = com.cfly.uav_pro.R.raw.tts_drone_early_rtl;
                                        } else if (str.equalsIgnoreCase(context.getString(com.cfly.uav_pro.R.string.not_take_photo))) {
                                            b2 = ab.b();
                                            context = context;
                                            i2 = com.cfly.uav_pro.R.raw.not_take_photo;
                                        } else if (str.equalsIgnoreCase(context.getString(com.cfly.uav_pro.R.string.not_take_video))) {
                                            b2 = ab.b();
                                            context = context;
                                            i2 = com.cfly.uav_pro.R.raw.not_take_video;
                                        } else {
                                            return;
                                        }
                                    }
                                }
                            }
                            ab.b().a(context, (int) com.cfly.uav_pro.R.raw.tts_set_rtl_home);
                            return;
                        }
                        b2.a(context, i2);
                        return;
                    }
                    ab.b().a(context, (int) com.cfly.uav_pro.R.raw.sport_gear_warn);
                }
            });
        }
    }

    public void b(int i2) {
        this.f24371i.offer(Integer.valueOf(i2));
    }

    public void b(Context context) {
        if (this.f24367e.I()) {
            if (this.f24364b == null) {
                ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
                this.f24364b = newSingleThreadExecutor;
                newSingleThreadExecutor.execute(new a());
            }
            if (this.f24365c == null) {
                this.f24365c = Executors.newSingleThreadExecutor();
            }
        }
    }

    public void c() {
        this.f24371i.clear();
    }
}
