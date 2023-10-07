package ch;

import android.content.Context;
import android.media.SoundPool;
import com.cfly.uav_pro.R;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private SoundPool f6215a;

    public b(Context context) {
        SoundPool soundPool = new SoundPool(5, 1, 5);
        this.f6215a = soundPool;
        soundPool.load(context, R.raw.btn_turn, 1);
        this.f6215a.load(context, R.raw.btn_middle, 2);
        this.f6215a.load(context, R.raw.shutter, 3);
        this.f6215a.load(context, R.raw.beep, 4);
    }

    public void a() {
        this.f6215a.play(3, 1.0f, 1.0f, 3, 0, 1.0f);
    }
}
