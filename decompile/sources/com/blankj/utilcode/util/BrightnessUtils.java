package com.blankj.utilcode.util;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.provider.Settings;
import android.view.Window;
import android.view.WindowManager;
import java.util.Objects;

public final class BrightnessUtils {
    private BrightnessUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static int getBrightness() {
        try {
            return Settings.System.getInt(Utils.getApp().getContentResolver(), "screen_brightness");
        } catch (Settings.SettingNotFoundException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static int getWindowBrightness(Window window) {
        Objects.requireNonNull(window, "Argument 'window' of type Window (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        float f2 = window.getAttributes().screenBrightness;
        return f2 < 0.0f ? getBrightness() : (int) (f2 * 255.0f);
    }

    public static boolean isAutoBrightnessEnabled() {
        try {
            return Settings.System.getInt(Utils.getApp().getContentResolver(), "screen_brightness_mode") == 1;
        } catch (Settings.SettingNotFoundException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean setAutoBrightnessEnabled(boolean z2) {
        return Settings.System.putInt(Utils.getApp().getContentResolver(), "screen_brightness_mode", z2 ? 1 : 0);
    }

    public static boolean setBrightness(int i2) {
        ContentResolver contentResolver = Utils.getApp().getContentResolver();
        boolean putInt = Settings.System.putInt(contentResolver, "screen_brightness", i2);
        contentResolver.notifyChange(Settings.System.getUriFor("screen_brightness"), (ContentObserver) null);
        return putInt;
    }

    public static void setWindowBrightness(Window window, int i2) {
        Objects.requireNonNull(window, "Argument 'window' of type Window (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = ((float) i2) / 255.0f;
        window.setAttributes(attributes);
    }
}
