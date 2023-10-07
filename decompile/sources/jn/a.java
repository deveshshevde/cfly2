package jn;

import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.shuyu.gsyvideoplayer.video.base.GSYBaseVideoPlayer;

public class a implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    private int f29539a;

    /* renamed from: b  reason: collision with root package name */
    private int f29540b;

    /* renamed from: c  reason: collision with root package name */
    private int f29541c;

    /* renamed from: d  reason: collision with root package name */
    private int f29542d;

    /* renamed from: e  reason: collision with root package name */
    private int f29543e;

    /* renamed from: f  reason: collision with root package name */
    private int f29544f;

    /* renamed from: g  reason: collision with root package name */
    private GSYBaseVideoPlayer f29545g;

    public a(GSYBaseVideoPlayer gSYBaseVideoPlayer, int i2, int i3) {
        this.f29541c = i2;
        this.f29542d = i3;
        this.f29545g = gSYBaseVideoPlayer;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.f29539a = rawX;
            this.f29540b = rawY;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f29545g.getLayoutParams();
            this.f29543e = rawX - layoutParams.leftMargin;
            this.f29544f = rawY - layoutParams.topMargin;
        } else if (action == 1) {
            return Math.abs(this.f29540b - rawY) >= 5 || Math.abs(this.f29539a - rawX) >= 5;
        } else {
            if (action == 2) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.f29545g.getLayoutParams();
                layoutParams2.leftMargin = rawX - this.f29543e;
                layoutParams2.topMargin = rawY - this.f29544f;
                int i2 = layoutParams2.leftMargin;
                int i3 = this.f29541c;
                if (i2 >= i3) {
                    layoutParams2.leftMargin = i3;
                }
                int i4 = layoutParams2.topMargin;
                int i5 = this.f29542d;
                if (i4 >= i5) {
                    layoutParams2.topMargin = i5;
                }
                if (layoutParams2.leftMargin <= 0) {
                    layoutParams2.leftMargin = 0;
                }
                if (layoutParams2.topMargin <= 0) {
                    layoutParams2.topMargin = 0;
                }
                this.f29545g.setLayoutParams(layoutParams2);
            }
        }
        return false;
    }
}
