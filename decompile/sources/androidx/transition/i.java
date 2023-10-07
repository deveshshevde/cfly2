package androidx.transition;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import t.ac;

class i extends ViewGroup implements f {

    /* renamed from: a  reason: collision with root package name */
    ViewGroup f4840a;

    /* renamed from: b  reason: collision with root package name */
    View f4841b;

    /* renamed from: c  reason: collision with root package name */
    final View f4842c;

    /* renamed from: d  reason: collision with root package name */
    int f4843d;

    /* renamed from: e  reason: collision with root package name */
    private Matrix f4844e;

    /* renamed from: f  reason: collision with root package name */
    private final ViewTreeObserver.OnPreDrawListener f4845f = new ViewTreeObserver.OnPreDrawListener() {
        public boolean onPreDraw() {
            ac.e(i.this);
            if (i.this.f4840a == null || i.this.f4841b == null) {
                return true;
            }
            i.this.f4840a.endViewTransition(i.this.f4841b);
            ac.e(i.this.f4840a);
            i.this.f4840a = null;
            i.this.f4841b = null;
            return true;
        }
    };

    i(View view) {
        super(view.getContext());
        this.f4842c = view;
        setWillNotDraw(false);
        setLayerType(2, (Paint) null);
    }

    static i a(View view) {
        return (i) view.getTag(R.id.ghost_view);
    }

    static void a(View view, View view2) {
        aj.a(view2, view2.getLeft(), view2.getTop(), view2.getLeft() + view.getWidth(), view2.getTop() + view.getHeight());
    }

    static void a(View view, ViewGroup viewGroup, Matrix matrix) {
        ViewGroup viewGroup2 = (ViewGroup) view.getParent();
        matrix.reset();
        aj.a((View) viewGroup2, matrix);
        matrix.preTranslate((float) (-viewGroup2.getScrollX()), (float) (-viewGroup2.getScrollY()));
        aj.b(viewGroup, matrix);
    }

    static void a(View view, i iVar) {
        view.setTag(R.id.ghost_view, iVar);
    }

    static i b(View view, ViewGroup viewGroup, Matrix matrix) {
        g gVar;
        if (view.getParent() instanceof ViewGroup) {
            g a2 = g.a(viewGroup);
            i a3 = a(view);
            int i2 = 0;
            if (!(a3 == null || (gVar = (g) a3.getParent()) == a2)) {
                i2 = a3.f4843d;
                gVar.removeView(a3);
                a3 = null;
            }
            if (a3 == null) {
                if (matrix == null) {
                    matrix = new Matrix();
                    a(view, viewGroup, matrix);
                }
                a3 = new i(view);
                a3.a(matrix);
                if (a2 == null) {
                    a2 = new g(viewGroup);
                } else {
                    a2.a();
                }
                a((View) viewGroup, (View) a2);
                a((View) viewGroup, (View) a3);
                a2.a(a3);
                a3.f4843d = i2;
            } else if (matrix != null) {
                a3.a(matrix);
            }
            a3.f4843d++;
            return a3;
        }
        throw new IllegalArgumentException("Ghosted views must be parented by a ViewGroup");
    }

    static void b(View view) {
        i a2 = a(view);
        if (a2 != null) {
            int i2 = a2.f4843d - 1;
            a2.f4843d = i2;
            if (i2 <= 0) {
                ((g) a2.getParent()).removeView(a2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(Matrix matrix) {
        this.f4844e = matrix;
    }

    public void a(ViewGroup viewGroup, View view) {
        this.f4840a = viewGroup;
        this.f4841b = view;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a(this.f4842c, this);
        this.f4842c.getViewTreeObserver().addOnPreDrawListener(this.f4845f);
        aj.a(this.f4842c, 4);
        if (this.f4842c.getParent() != null) {
            ((View) this.f4842c.getParent()).invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        this.f4842c.getViewTreeObserver().removeOnPreDrawListener(this.f4845f);
        aj.a(this.f4842c, 0);
        a(this.f4842c, (i) null);
        if (this.f4842c.getParent() != null) {
            ((View) this.f4842c.getParent()).invalidate();
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        b.a(canvas, true);
        canvas.setMatrix(this.f4844e);
        aj.a(this.f4842c, 0);
        this.f4842c.invalidate();
        aj.a(this.f4842c, 4);
        drawChild(canvas, this.f4842c, getDrawingTime());
        b.a(canvas, false);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        if (a(this.f4842c) == this) {
            aj.a(this.f4842c, i2 == 0 ? 4 : 0);
        }
    }
}
