package ep;

import android.content.Context;
import android.view.MotionEvent;
import com.flypro.photoview_library.a;

public class b extends a {

    /* renamed from: f  reason: collision with root package name */
    private int f26948f = -1;

    /* renamed from: g  reason: collision with root package name */
    private int f26949g = 0;

    public b(Context context) {
        super(context);
    }

    /* access modifiers changed from: package-private */
    public float a(MotionEvent motionEvent) {
        try {
            return motionEvent.getX(this.f26949g);
        } catch (Exception unused) {
            return motionEvent.getX();
        }
    }

    /* access modifiers changed from: package-private */
    public float b(MotionEvent motionEvent) {
        try {
            return motionEvent.getY(this.f26949g);
        } catch (Exception unused) {
            return motionEvent.getY();
        }
    }

    public boolean c(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        int i2 = 0;
        if (action != 0) {
            int i3 = 1;
            if (action == 1 || action == 3) {
                this.f26948f = -1;
            } else if (action == 6) {
                int a2 = a.a(motionEvent.getAction());
                if (motionEvent.getPointerId(a2) == this.f26948f) {
                    if (a2 != 0) {
                        i3 = 0;
                    }
                    this.f26948f = motionEvent.getPointerId(i3);
                    this.f26942b = motionEvent.getX(i3);
                    this.f26943c = motionEvent.getY(i3);
                }
            }
        } else {
            this.f26948f = motionEvent.getPointerId(0);
        }
        int i4 = this.f26948f;
        if (i4 != -1) {
            i2 = i4;
        }
        this.f26949g = motionEvent.findPointerIndex(i2);
        return super.c(motionEvent);
    }
}
