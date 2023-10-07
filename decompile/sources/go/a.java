package go;

import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

public class a implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    private final Dialog f28558a;

    /* renamed from: b  reason: collision with root package name */
    private final int f28559b;

    /* renamed from: c  reason: collision with root package name */
    private final int f28560c;

    /* renamed from: d  reason: collision with root package name */
    private final int f28561d;

    public a(Dialog dialog, Rect rect) {
        this.f28558a = dialog;
        this.f28559b = rect.left;
        this.f28560c = rect.top;
        this.f28561d = ViewConfiguration.get(dialog.getContext()).getScaledWindowTouchSlop();
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        View findViewById = view.findViewById(16908290);
        int left = this.f28559b + findViewById.getLeft();
        int width = findViewById.getWidth() + left;
        int top = this.f28560c + findViewById.getTop();
        if (new RectF((float) left, (float) top, (float) width, (float) (findViewById.getHeight() + top)).contains(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        if (motionEvent.getAction() == 1) {
            obtain.setAction(4);
        }
        if (Build.VERSION.SDK_INT < 28) {
            obtain.setAction(0);
            int i2 = this.f28561d;
            obtain.setLocation((float) ((-i2) - 1), (float) ((-i2) - 1));
        }
        view.performClick();
        return this.f28558a.onTouchEvent(obtain);
    }
}
