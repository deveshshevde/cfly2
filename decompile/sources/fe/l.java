package fe;

import android.graphics.Canvas;
import android.graphics.Path;
import ex.a;
import fc.h;
import fg.j;

public abstract class l extends c {

    /* renamed from: a  reason: collision with root package name */
    private Path f27156a = new Path();

    public l(a aVar, j jVar) {
        super(aVar, jVar);
    }

    /* access modifiers changed from: protected */
    public void a(Canvas canvas, float f2, float f3, h hVar) {
        this.f27127i.setColor(hVar.a());
        this.f27127i.setStrokeWidth(hVar.S());
        this.f27127i.setPathEffect(hVar.T());
        if (hVar.Q()) {
            this.f27156a.reset();
            this.f27156a.moveTo(f2, this.f27179o.e());
            this.f27156a.lineTo(f2, this.f27179o.h());
            canvas.drawPath(this.f27156a, this.f27127i);
        }
        if (hVar.R()) {
            this.f27156a.reset();
            this.f27156a.moveTo(this.f27179o.f(), f3);
            this.f27156a.lineTo(this.f27179o.g(), f3);
            canvas.drawPath(this.f27156a, this.f27127i);
        }
    }
}
