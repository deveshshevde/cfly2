package com.blankj.utilcode.util;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import androidx.core.app.h;
import androidx.core.app.k;
import com.blankj.utilcode.util.Utils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class NotificationUtils {
    public static final int IMPORTANCE_DEFAULT = 3;
    public static final int IMPORTANCE_HIGH = 4;
    public static final int IMPORTANCE_LOW = 2;
    public static final int IMPORTANCE_MIN = 1;
    public static final int IMPORTANCE_NONE = 0;
    public static final int IMPORTANCE_UNSPECIFIED = -1000;

    public static class ChannelConfig {
        public static final ChannelConfig DEFAULT_CHANNEL_CONFIG = new ChannelConfig(Utils.getApp().getPackageName(), Utils.getApp().getPackageName(), 3);
        /* access modifiers changed from: private */
        public NotificationChannel mNotificationChannel;

        public ChannelConfig(String str, CharSequence charSequence, int i2) {
            if (Build.VERSION.SDK_INT >= 26) {
                this.mNotificationChannel = new NotificationChannel(str, charSequence, i2);
            }
        }

        public NotificationChannel getNotificationChannel() {
            return this.mNotificationChannel;
        }

        public ChannelConfig setBypassDnd(boolean z2) {
            if (Build.VERSION.SDK_INT >= 26) {
                this.mNotificationChannel.setBypassDnd(z2);
            }
            return this;
        }

        public ChannelConfig setDescription(String str) {
            if (Build.VERSION.SDK_INT >= 26) {
                this.mNotificationChannel.setDescription(str);
            }
            return this;
        }

        public ChannelConfig setGroup(String str) {
            if (Build.VERSION.SDK_INT >= 26) {
                this.mNotificationChannel.setGroup(str);
            }
            return this;
        }

        public ChannelConfig setImportance(int i2) {
            if (Build.VERSION.SDK_INT >= 26) {
                this.mNotificationChannel.setImportance(i2);
            }
            return this;
        }

        public ChannelConfig setLightColor(int i2) {
            if (Build.VERSION.SDK_INT >= 26) {
                this.mNotificationChannel.setLightColor(i2);
            }
            return this;
        }

        public ChannelConfig setLockscreenVisibility(int i2) {
            if (Build.VERSION.SDK_INT >= 26) {
                this.mNotificationChannel.setLockscreenVisibility(i2);
            }
            return this;
        }

        public ChannelConfig setName(CharSequence charSequence) {
            if (Build.VERSION.SDK_INT >= 26) {
                this.mNotificationChannel.setName(charSequence);
            }
            return this;
        }

        public ChannelConfig setShowBadge(boolean z2) {
            if (Build.VERSION.SDK_INT >= 26) {
                this.mNotificationChannel.setShowBadge(z2);
            }
            return this;
        }

        public ChannelConfig setSound(Uri uri, AudioAttributes audioAttributes) {
            if (Build.VERSION.SDK_INT >= 26) {
                this.mNotificationChannel.setSound(uri, audioAttributes);
            }
            return this;
        }

        public ChannelConfig setVibrationPattern(long[] jArr) {
            if (Build.VERSION.SDK_INT >= 26) {
                this.mNotificationChannel.setVibrationPattern(jArr);
            }
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Importance {
    }

    public static boolean areNotificationsEnabled() {
        return k.a((Context) Utils.getApp()).b();
    }

    public static void cancel(int i2) {
        k.a((Context) Utils.getApp()).a(i2);
    }

    public static void cancel(String str, int i2) {
        k.a((Context) Utils.getApp()).a(str, i2);
    }

    public static void cancelAll() {
        k.a((Context) Utils.getApp()).a();
    }

    public static Notification getNotification(ChannelConfig channelConfig, Utils.Consumer<h.d> consumer) {
        if (Build.VERSION.SDK_INT >= 26) {
            ((NotificationManager) Utils.getApp().getSystemService("notification")).createNotificationChannel(channelConfig.getNotificationChannel());
        }
        h.d dVar = new h.d(Utils.getApp());
        if (Build.VERSION.SDK_INT >= 26) {
            dVar.a(channelConfig.mNotificationChannel.getId());
        }
        if (consumer != null) {
            consumer.accept(dVar);
        }
        return dVar.b();
    }

    private static void invokePanels(String str) {
        try {
            Class.forName("android.app.StatusBarManager").getMethod(str, new Class[0]).invoke(Utils.getApp().getSystemService("statusbar"), new Object[0]);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void notify(int i2, ChannelConfig channelConfig, Utils.Consumer<h.d> consumer) {
        notify((String) null, i2, channelConfig, consumer);
    }

    public static void notify(int i2, Utils.Consumer<h.d> consumer) {
        notify((String) null, i2, ChannelConfig.DEFAULT_CHANNEL_CONFIG, consumer);
    }

    public static void notify(String str, int i2, ChannelConfig channelConfig, Utils.Consumer<h.d> consumer) {
        k.a((Context) Utils.getApp()).a(str, i2, getNotification(channelConfig, consumer));
    }

    public static void notify(String str, int i2, Utils.Consumer<h.d> consumer) {
        notify(str, i2, ChannelConfig.DEFAULT_CHANNEL_CONFIG, consumer);
    }

    public static void setNotificationBarVisibility(boolean z2) {
        invokePanels(z2 ? Build.VERSION.SDK_INT <= 16 ? "expand" : "expandNotificationsPanel" : Build.VERSION.SDK_INT <= 16 ? "collapse" : "collapsePanels");
    }
}
