package com.xeagle.android.login.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.cfly.uav_pro.R;

public class Settings {
    public static final int PV_PLAYER__AndroidMediaPlayer = 1;
    public static final int PV_PLAYER__Auto = 0;
    public static final int PV_PLAYER__IjkExoMediaPlayer = 3;
    public static final int PV_PLAYER__IjkMediaPlayer = 2;
    private Context mAppContext;
    private SharedPreferences mSharedPreferences;

    public Settings(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.mAppContext = applicationContext;
        this.mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext);
    }

    public boolean getEnableDetachedSurfaceTextureView() {
        return this.mSharedPreferences.getBoolean(this.mAppContext.getString(R.string.pref_key_enable_detached_surface_texture), false);
    }

    public boolean getEnableNoView() {
        return this.mSharedPreferences.getBoolean(this.mAppContext.getString(R.string.pref_key_enable_no_view), false);
    }

    public boolean getEnableSurfaceView() {
        return this.mSharedPreferences.getBoolean(this.mAppContext.getString(R.string.pref_key_enable_surface_view), false);
    }

    public boolean getEnableTextureView() {
        return this.mSharedPreferences.getBoolean(this.mAppContext.getString(R.string.pref_key_enable_texture_view), true);
    }

    public String getLastDirectory() {
        return this.mSharedPreferences.getString(this.mAppContext.getString(R.string.pref_key_last_directory), "/");
    }

    public boolean getMediaCodecHandleResolutionChange() {
        return this.mSharedPreferences.getBoolean(this.mAppContext.getString(R.string.pref_key_media_codec_handle_resolution_change), false);
    }

    public String getPixelFormat() {
        return this.mSharedPreferences.getString(this.mAppContext.getString(R.string.pref_key_pixel_format), "");
    }

    public int getPlayer() {
        try {
            return Integer.valueOf(this.mSharedPreferences.getString(this.mAppContext.getString(R.string.pref_key_player), "")).intValue();
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public boolean getUsingMediaCodec() {
        return this.mSharedPreferences.getBoolean(this.mAppContext.getString(R.string.pref_key_using_media_codec), false);
    }

    public boolean getUsingMediaCodecAutoRotate() {
        return this.mSharedPreferences.getBoolean(this.mAppContext.getString(R.string.pref_key_using_media_codec_auto_rotate), false);
    }

    public boolean getUsingMediaDataSource() {
        return this.mSharedPreferences.getBoolean(this.mAppContext.getString(R.string.pref_key_using_mediadatasource), false);
    }

    public boolean getUsingOpenSLES() {
        return this.mSharedPreferences.getBoolean(this.mAppContext.getString(R.string.pref_key_using_opensl_es), false);
    }

    public void setLastDirectory(String str) {
        this.mSharedPreferences.edit().putString(this.mAppContext.getString(R.string.pref_key_last_directory), str).apply();
    }
}
