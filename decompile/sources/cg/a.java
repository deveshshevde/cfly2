package cg;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Vibrator;
import com.cfly.customeui.R;

public class a {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f6207a = true;

    /* renamed from: b  reason: collision with root package name */
    private boolean f6208b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f6209c;

    /* renamed from: d  reason: collision with root package name */
    private MediaPlayer f6210d;

    /* renamed from: e  reason: collision with root package name */
    private Vibrator f6211e;

    /* renamed from: f  reason: collision with root package name */
    private final MediaPlayer.OnCompletionListener f6212f;

    /* renamed from: cg.a$a  reason: collision with other inner class name */
    private static final class C0068a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f6214a = new a();
    }

    private a() {
        this.f6212f = new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.seekTo(0);
            }
        };
    }

    public static a a() {
        return C0068a.f6214a;
    }

    private void b(Context context) {
        if (this.f6208b && this.f6210d == null) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.f6210d = mediaPlayer;
            mediaPlayer.setAudioStreamType(3);
            this.f6210d.setOnCompletionListener(this.f6212f);
            AssetFileDescriptor openRawResourceFd = context.getResources().openRawResourceFd(R.raw.beep_beep);
            try {
                this.f6210d.setDataSource(openRawResourceFd.getFileDescriptor(), openRawResourceFd.getStartOffset(), openRawResourceFd.getLength());
                openRawResourceFd.close();
                this.f6210d.setVolume(0.1f, 0.1f);
                this.f6210d.prepare();
            } catch (Exception unused) {
                this.f6210d = null;
            }
        }
    }

    public a a(Context context) {
        if (this.f6211e == null) {
            this.f6211e = (Vibrator) context.getSystemService("vibrator");
            this.f6208b = true;
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            if (f6207a || audioManager != null) {
                if (audioManager.getRingerMode() != 2) {
                    this.f6208b = false;
                }
                b(context);
            } else {
                throw new AssertionError();
            }
        }
        return this;
    }

    public void a(boolean z2) {
        if (this.f6209c != z2) {
            this.f6209c = z2;
        }
    }

    public void b() {
        if (this.f6209c) {
            this.f6211e.cancel();
            this.f6211e.vibrate(300);
            this.f6209c = false;
        }
    }
}
