package ep;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

public class c extends b {

    /* renamed from: f  reason: collision with root package name */
    protected final ScaleGestureDetector f26950f;

    public c(Context context) {
        super(context);
        this.f26950f = new ScaleGestureDetector(context, new ScaleGestureDetector.OnScaleGestureListener() {
            public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (Float.isNaN(scaleFactor) || Float.isInfinite(scaleFactor)) {
                    return false;
                }
                c.this.f26941a.a(scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
                return true;
            }

            public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
                return true;
            }

            public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            }
        });
    }

    public boolean a() {
        return this.f26950f.isInProgress();
    }

    public boolean c(MotionEvent motionEvent) {
        this.f26950f.onTouchEvent(motionEvent);
        return super.c(motionEvent);
    }
}
