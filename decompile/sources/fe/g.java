package fe;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import ex.a;
import fa.d;
import fb.e;
import fg.i;
import fg.j;

public abstract class g extends o {

    /* renamed from: g  reason: collision with root package name */
    protected a f27125g;

    /* renamed from: h  reason: collision with root package name */
    protected Paint f27126h;

    /* renamed from: i  reason: collision with root package name */
    protected Paint f27127i;

    /* renamed from: j  reason: collision with root package name */
    protected Paint f27128j = new Paint(4);

    /* renamed from: k  reason: collision with root package name */
    protected Paint f27129k;

    public g(a aVar, j jVar) {
        super(jVar);
        this.f27125g = aVar;
        Paint paint = new Paint(1);
        this.f27126h = paint;
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint(1);
        this.f27129k = paint2;
        paint2.setColor(Color.rgb(63, 63, 63));
        this.f27129k.setTextAlign(Paint.Align.CENTER);
        this.f27129k.setTextSize(i.a(9.0f));
        Paint paint3 = new Paint(1);
        this.f27127i = paint3;
        paint3.setStyle(Paint.Style.STROKE);
        this.f27127i.setStrokeWidth(2.0f);
        this.f27127i.setColor(Color.rgb(255, 187, 115));
    }

    public abstract void a();

    public abstract void a(Canvas canvas);

    public abstract void a(Canvas canvas, d[] dVarArr);

    /* access modifiers changed from: protected */
    public boolean a(e eVar) {
        return ((float) eVar.getData().i()) < ((float) eVar.getMaxVisibleCount()) * this.f27179o.q();
    }

    public abstract void b(Canvas canvas);

    /* access modifiers changed from: protected */
    public void b(fc.e eVar) {
        this.f27129k.setTypeface(eVar.j());
        this.f27129k.setTextSize(eVar.k());
    }

    public abstract void c(Canvas canvas);
}
