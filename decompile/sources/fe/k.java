package fe;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import ex.a;
import fg.i;
import fg.j;

public abstract class k extends l {
    public k(a aVar, j jVar) {
        super(aVar, jVar);
    }

    private boolean b() {
        return i.d() >= 18;
    }

    /* access modifiers changed from: protected */
    public void a(Canvas canvas, Path path, int i2, int i3) {
        int i4 = (i2 & 16777215) | (i3 << 24);
        if (b()) {
            int save = canvas.save();
            canvas.clipPath(path);
            canvas.drawColor(i4);
            canvas.restoreToCount(save);
            return;
        }
        Paint.Style style = this.f27126h.getStyle();
        int color = this.f27126h.getColor();
        this.f27126h.setStyle(Paint.Style.FILL);
        this.f27126h.setColor(i4);
        canvas.drawPath(path, this.f27126h);
        this.f27126h.setColor(color);
        this.f27126h.setStyle(style);
    }

    /* access modifiers changed from: protected */
    public void a(Canvas canvas, Path path, Drawable drawable) {
        if (b()) {
            int save = canvas.save();
            canvas.clipPath(path);
            drawable.setBounds((int) this.f27179o.f(), (int) this.f27179o.e(), (int) this.f27179o.g(), (int) this.f27179o.h());
            drawable.draw(canvas);
            canvas.restoreToCount(save);
            return;
        }
        throw new RuntimeException("Fill-drawables not (yet) supported below API level 18, this code was run on API level " + i.d() + ".");
    }
}
