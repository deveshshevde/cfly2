package bu;

import aj.b;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import bu.g;
import cc.k;
import com.bumptech.glide.load.i;
import java.nio.ByteBuffer;
import java.util.List;

public class c extends Drawable implements b, Animatable, g.b {

    /* renamed from: a  reason: collision with root package name */
    private final a f5999a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f6000b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f6001c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f6002d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f6003e;

    /* renamed from: f  reason: collision with root package name */
    private int f6004f;

    /* renamed from: g  reason: collision with root package name */
    private int f6005g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f6006h;

    /* renamed from: i  reason: collision with root package name */
    private Paint f6007i;

    /* renamed from: j  reason: collision with root package name */
    private Rect f6008j;

    /* renamed from: k  reason: collision with root package name */
    private List<b.a> f6009k;

    static final class a extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        final g f6010a;

        a(g gVar) {
            this.f6010a = gVar;
        }

        public int getChangingConfigurations() {
            return 0;
        }

        public Drawable newDrawable() {
            return new c(this);
        }

        public Drawable newDrawable(Resources resources) {
            return newDrawable();
        }
    }

    public c(Context context, bj.a aVar, i<Bitmap> iVar, int i2, int i3, Bitmap bitmap) {
        this(new a(new g(com.bumptech.glide.c.a(context), aVar, i2, i3, iVar, bitmap)));
    }

    c(a aVar) {
        this.f6003e = true;
        this.f6005g = -1;
        this.f5999a = (a) k.a(aVar);
    }

    private void h() {
        this.f6004f = 0;
    }

    private void i() {
        k.a(!this.f6002d, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.f5999a.f6010a.g() != 1) {
            if (!this.f6000b) {
                this.f6000b = true;
                this.f5999a.f6010a.a((g.b) this);
            } else {
                return;
            }
        }
        invalidateSelf();
    }

    private void j() {
        this.f6000b = false;
        this.f5999a.f6010a.b(this);
    }

    private Rect k() {
        if (this.f6008j == null) {
            this.f6008j = new Rect();
        }
        return this.f6008j;
    }

    private Paint l() {
        if (this.f6007i == null) {
            this.f6007i = new Paint(2);
        }
        return this.f6007i;
    }

    private Drawable.Callback m() {
        Drawable.Callback callback = getCallback();
        while (callback instanceof Drawable) {
            callback = ((Drawable) callback).getCallback();
        }
        return callback;
    }

    private void n() {
        List<b.a> list = this.f6009k;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f6009k.get(i2).b(this);
            }
        }
    }

    public int a() {
        return this.f5999a.f6010a.d();
    }

    public void a(i<Bitmap> iVar, Bitmap bitmap) {
        this.f5999a.f6010a.a(iVar, bitmap);
    }

    public Bitmap b() {
        return this.f5999a.f6010a.a();
    }

    public ByteBuffer c() {
        return this.f5999a.f6010a.f();
    }

    public int d() {
        return this.f5999a.f6010a.g();
    }

    public void draw(Canvas canvas) {
        if (!this.f6002d) {
            if (this.f6006h) {
                Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), k());
                this.f6006h = false;
            }
            canvas.drawBitmap(this.f5999a.f6010a.i(), (Rect) null, k(), l());
        }
    }

    public int e() {
        return this.f5999a.f6010a.e();
    }

    public void f() {
        if (m() == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        if (e() == d() - 1) {
            this.f6004f++;
        }
        int i2 = this.f6005g;
        if (i2 != -1 && this.f6004f >= i2) {
            n();
            stop();
        }
    }

    public void g() {
        this.f6002d = true;
        this.f5999a.f6010a.h();
    }

    public Drawable.ConstantState getConstantState() {
        return this.f5999a;
    }

    public int getIntrinsicHeight() {
        return this.f5999a.f6010a.c();
    }

    public int getIntrinsicWidth() {
        return this.f5999a.f6010a.b();
    }

    public int getOpacity() {
        return -2;
    }

    public boolean isRunning() {
        return this.f6000b;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f6006h = true;
    }

    public void setAlpha(int i2) {
        l().setAlpha(i2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        l().setColorFilter(colorFilter);
    }

    public boolean setVisible(boolean z2, boolean z3) {
        k.a(!this.f6002d, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.f6003e = z2;
        if (!z2) {
            j();
        } else if (this.f6001c) {
            i();
        }
        return super.setVisible(z2, z3);
    }

    public void start() {
        this.f6001c = true;
        h();
        if (this.f6003e) {
            i();
        }
    }

    public void stop() {
        this.f6001c = false;
        j();
    }
}
