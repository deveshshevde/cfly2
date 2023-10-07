package com.flypro.photoview_library;

import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;

public class b implements GestureDetector.OnDoubleTapListener {

    /* renamed from: a  reason: collision with root package name */
    private d f14474a;

    public b(d dVar) {
        a(dVar);
    }

    public void a(d dVar) {
        this.f14474a = dVar;
    }

    public boolean onDoubleTap(MotionEvent motionEvent) {
        d dVar;
        float d2;
        d dVar2 = this.f14474a;
        if (dVar2 == null) {
            return false;
        }
        try {
            float g2 = dVar2.g();
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            if (g2 < this.f14474a.e()) {
                dVar = this.f14474a;
                d2 = dVar.e();
            } else if (g2 < this.f14474a.e() || g2 >= this.f14474a.f()) {
                dVar = this.f14474a;
                d2 = dVar.d();
            } else {
                dVar = this.f14474a;
                d2 = dVar.f();
            }
            dVar.a(d2, x2, y2, true);
        } catch (ArrayIndexOutOfBoundsException unused) {
        }
        return true;
    }

    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        RectF b2;
        d dVar = this.f14474a;
        if (dVar == null) {
            return false;
        }
        ImageView c2 = dVar.c();
        if (!(this.f14474a.i() == null || (b2 = this.f14474a.b()) == null)) {
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            if (b2.contains(x2, y2)) {
                this.f14474a.i().onPhotoTap(c2, (x2 - b2.left) / b2.width(), (y2 - b2.top) / b2.height());
                return true;
            }
        }
        if (this.f14474a.j() != null) {
            this.f14474a.j().a(c2, motionEvent.getX(), motionEvent.getY());
        }
        return false;
    }
}
