package com.xeagle.android.utils;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Vibrator;
import com.cfly.uav_pro.R;

public class aa {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f24355a = true;

    /* renamed from: b  reason: collision with root package name */
    private boolean f24356b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f24357c;

    /* renamed from: d  reason: collision with root package name */
    private MediaPlayer f24358d;

    /* renamed from: e  reason: collision with root package name */
    private Vibrator f24359e;

    /* renamed from: f  reason: collision with root package name */
    private final MediaPlayer.OnCompletionListener f24360f;

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final aa f24362a = new aa();
    }

    private aa() {
        this.f24360f = new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.seekTo(0);
            }
        };
    }

    public static aa a() {
        return a.f24362a;
    }

    private void b(Context context) {
        if (this.f24356b && this.f24358d == null) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.f24358d = mediaPlayer;
            mediaPlayer.setAudioStreamType(3);
            this.f24358d.setOnCompletionListener(this.f24360f);
            AssetFileDescriptor openRawResourceFd = context.getResources().openRawResourceFd(R.raw.beep_beep);
            try {
                this.f24358d.setDataSource(openRawResourceFd.getFileDescriptor(), openRawResourceFd.getStartOffset(), openRawResourceFd.getLength());
                openRawResourceFd.close();
                this.f24358d.setVolume(0.1f, 0.1f);
                this.f24358d.prepare();
            } catch (Exception unused) {
                this.f24358d = null;
            }
        }
    }

    public aa a(Context context) {
        if (this.f24359e == null) {
            this.f24359e = (Vibrator) context.getSystemService("vibrator");
            this.f24356b = true;
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            if (f24355a || audioManager != null) {
                if (audioManager.getRingerMode() != 2) {
                    this.f24356b = false;
                }
                b(context);
            } else {
                throw new AssertionError();
            }
        }
        return this;
    }

    public void a(boolean z2) {
        if (this.f24357c != z2) {
            this.f24357c = z2;
        }
    }

    public void a(long[] jArr, int i2) {
        this.f24359e.cancel();
        this.f24359e.vibrate(jArr, i2);
    }

    public boolean b() {
        return this.f24357c;
    }

    public void c() {
        if (this.f24357c) {
            this.f24359e.cancel();
            this.f24359e.vibrate(300);
            this.f24357c = false;
        }
    }

    public void d() {
        this.f24359e.cancel();
    }
}
