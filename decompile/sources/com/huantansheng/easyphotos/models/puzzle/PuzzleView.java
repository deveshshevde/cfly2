package com.huantansheng.easyphotos.models.puzzle;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.content.b;
import com.huantansheng.easyphotos.R;
import com.huantansheng.easyphotos.models.puzzle.Line;
import java.util.ArrayList;
import java.util.List;

public class PuzzleView extends View {
    private boolean A;
    private a B;
    private Runnable C;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public ActionMode f20345a;

    /* renamed from: b  reason: collision with root package name */
    private List<d> f20346b;

    /* renamed from: c  reason: collision with root package name */
    private List<d> f20347c;

    /* renamed from: d  reason: collision with root package name */
    private c f20348d;

    /* renamed from: e  reason: collision with root package name */
    private RectF f20349e;

    /* renamed from: f  reason: collision with root package name */
    private int f20350f;

    /* renamed from: g  reason: collision with root package name */
    private int f20351g;

    /* renamed from: h  reason: collision with root package name */
    private Line f20352h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public d f20353i;

    /* renamed from: j  reason: collision with root package name */
    private d f20354j;

    /* renamed from: k  reason: collision with root package name */
    private d f20355k;

    /* renamed from: l  reason: collision with root package name */
    private Paint f20356l;

    /* renamed from: m  reason: collision with root package name */
    private Paint f20357m;

    /* renamed from: n  reason: collision with root package name */
    private Paint f20358n;

    /* renamed from: o  reason: collision with root package name */
    private float f20359o;

    /* renamed from: p  reason: collision with root package name */
    private float f20360p;

    /* renamed from: q  reason: collision with root package name */
    private float f20361q;

    /* renamed from: r  reason: collision with root package name */
    private PointF f20362r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f20363s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f20364t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f20365u;

    /* renamed from: v  reason: collision with root package name */
    private int f20366v;

    /* renamed from: w  reason: collision with root package name */
    private int f20367w;

    /* renamed from: x  reason: collision with root package name */
    private int f20368x;

    /* renamed from: y  reason: collision with root package name */
    private float f20369y;

    /* renamed from: z  reason: collision with root package name */
    private float f20370z;

    /* renamed from: com.huantansheng.easyphotos.models.puzzle.PuzzleView$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f20374a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.huantansheng.easyphotos.models.puzzle.PuzzleView$ActionMode[] r0 = com.huantansheng.easyphotos.models.puzzle.PuzzleView.ActionMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f20374a = r0
                com.huantansheng.easyphotos.models.puzzle.PuzzleView$ActionMode r1 = com.huantansheng.easyphotos.models.puzzle.PuzzleView.ActionMode.NONE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f20374a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.huantansheng.easyphotos.models.puzzle.PuzzleView$ActionMode r1 = com.huantansheng.easyphotos.models.puzzle.PuzzleView.ActionMode.DRAG     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f20374a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.huantansheng.easyphotos.models.puzzle.PuzzleView$ActionMode r1 = com.huantansheng.easyphotos.models.puzzle.PuzzleView.ActionMode.ZOOM     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f20374a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.huantansheng.easyphotos.models.puzzle.PuzzleView$ActionMode r1 = com.huantansheng.easyphotos.models.puzzle.PuzzleView.ActionMode.MOVE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f20374a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.huantansheng.easyphotos.models.puzzle.PuzzleView$ActionMode r1 = com.huantansheng.easyphotos.models.puzzle.PuzzleView.ActionMode.SWAP     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huantansheng.easyphotos.models.puzzle.PuzzleView.AnonymousClass3.<clinit>():void");
        }
    }

    private enum ActionMode {
        NONE,
        DRAG,
        ZOOM,
        MOVE,
        SWAP
    }

    public interface a {
        void a(d dVar, int i2);
    }

    public PuzzleView(Context context) {
        this(context, (AttributeSet) null);
    }

    public PuzzleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PuzzleView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f20345a = ActionMode.NONE;
        this.f20346b = new ArrayList();
        this.f20347c = new ArrayList();
        this.f20365u = true;
        this.A = true;
        this.C = new Runnable() {
            public void run() {
                ActionMode unused = PuzzleView.this.f20345a = ActionMode.SWAP;
                PuzzleView.this.invalidate();
            }
        };
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PuzzleView);
        this.f20350f = obtainStyledAttributes.getInt(R.styleable.PuzzleView_line_size, 4);
        this.f20366v = obtainStyledAttributes.getColor(R.styleable.PuzzleView_line_color, b.c(getContext(), R.color.easy_photos_fg_primary));
        this.f20367w = obtainStyledAttributes.getColor(R.styleable.PuzzleView_selected_line_color, b.c(getContext(), R.color.easy_photos_fg_accent));
        this.f20368x = obtainStyledAttributes.getColor(R.styleable.PuzzleView_handle_bar_color, b.c(getContext(), R.color.easy_photos_fg_accent));
        this.f20369y = (float) obtainStyledAttributes.getDimensionPixelSize(R.styleable.PuzzleView_piece_padding, 0);
        this.f20363s = obtainStyledAttributes.getBoolean(R.styleable.PuzzleView_need_draw_line, false);
        this.f20364t = obtainStyledAttributes.getBoolean(R.styleable.PuzzleView_need_draw_outer_line, false);
        this.f20351g = obtainStyledAttributes.getInt(R.styleable.PuzzleView_animation_duration, 300);
        this.f20370z = obtainStyledAttributes.getFloat(R.styleable.PuzzleView_radian, 0.0f);
        obtainStyledAttributes.recycle();
        this.f20349e = new RectF();
        Paint paint = new Paint();
        this.f20356l = paint;
        paint.setAntiAlias(true);
        this.f20356l.setColor(this.f20366v);
        this.f20356l.setStrokeWidth((float) this.f20350f);
        this.f20356l.setStyle(Paint.Style.STROKE);
        this.f20356l.setStrokeJoin(Paint.Join.ROUND);
        this.f20356l.setStrokeCap(Paint.Cap.SQUARE);
        Paint paint2 = new Paint();
        this.f20357m = paint2;
        paint2.setAntiAlias(true);
        this.f20357m.setStyle(Paint.Style.STROKE);
        this.f20357m.setStrokeJoin(Paint.Join.ROUND);
        this.f20357m.setStrokeCap(Paint.Cap.ROUND);
        this.f20357m.setColor(this.f20367w);
        this.f20357m.setStrokeWidth((float) this.f20350f);
        Paint paint3 = new Paint();
        this.f20358n = paint3;
        paint3.setAntiAlias(true);
        this.f20358n.setStyle(Paint.Style.FILL);
        this.f20358n.setColor(this.f20368x);
        this.f20358n.setStrokeWidth((float) (this.f20350f * 3));
        this.f20362r = new PointF();
    }

    private void a(Canvas canvas, Line line) {
        canvas.drawLine(line.a().x, line.a().y, line.b().x, line.b().y, this.f20356l);
    }

    private void a(Canvas canvas, d dVar) {
        a a2 = dVar.a();
        canvas.drawPath(a2.h(), this.f20357m);
        for (Line next : a2.j()) {
            if (this.f20348d.d().contains(next)) {
                PointF[] b2 = a2.b(next);
                canvas.drawLine(b2[0].x, b2[0].y, b2[1].x, b2[1].y, this.f20358n);
                canvas.drawCircle(b2[0].x, b2[0].y, (float) ((this.f20350f * 3) / 2), this.f20358n);
                canvas.drawCircle(b2[1].x, b2[1].y, (float) ((this.f20350f * 3) / 2), this.f20358n);
            }
        }
    }

    private void a(MotionEvent motionEvent) {
        d dVar;
        ActionMode actionMode;
        for (d l2 : this.f20346b) {
            if (l2.l()) {
                this.f20345a = ActionMode.NONE;
                return;
            }
        }
        if (motionEvent.getPointerCount() == 1) {
            Line g2 = g();
            this.f20352h = g2;
            if (g2 != null) {
                actionMode = ActionMode.MOVE;
            } else {
                d f2 = f();
                this.f20353i = f2;
                if (f2 != null) {
                    this.f20345a = ActionMode.DRAG;
                    postDelayed(this.C, 500);
                    return;
                }
                return;
            }
        } else if (motionEvent.getPointerCount() > 1 && (dVar = this.f20353i) != null && dVar.a(motionEvent.getX(1), motionEvent.getY(1)) && this.f20345a == ActionMode.DRAG) {
            actionMode = ActionMode.ZOOM;
        } else {
            return;
        }
        this.f20345a = actionMode;
    }

    private void a(MotionEvent motionEvent, PointF pointF) {
        pointF.x = (motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f;
        pointF.y = (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f;
    }

    private void a(Line line, MotionEvent motionEvent) {
        float f2;
        float f3;
        if (line != null && motionEvent != null) {
            if (line.g() == Line.Direction.HORIZONTAL) {
                f3 = motionEvent.getY();
                f2 = this.f20360p;
            } else {
                f3 = motionEvent.getX();
                f2 = this.f20359o;
            }
            if (line.a(f3 - f2, 80.0f)) {
                this.f20348d.e();
                b(line, motionEvent);
            }
        }
    }

    private void a(d dVar, MotionEvent motionEvent) {
        if (dVar != null && motionEvent != null && motionEvent.getPointerCount() >= 2) {
            float f2 = f(motionEvent) / this.f20361q;
            dVar.a(f2, f2, this.f20362r, motionEvent.getX() - this.f20359o, motionEvent.getY() - this.f20360p);
        }
    }

    private void b(MotionEvent motionEvent) {
        int i2 = AnonymousClass3.f20374a[this.f20345a.ordinal()];
        if (i2 == 2 || i2 == 3) {
            this.f20353i.i();
        } else if (i2 == 4) {
            this.f20352h.h();
            this.f20347c.clear();
            this.f20347c.addAll(h());
            for (d next : this.f20347c) {
                next.i();
                next.a(this.f20359o);
                next.b(this.f20360p);
            }
        }
    }

    private void b(Line line, MotionEvent motionEvent) {
        int size = this.f20347c.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f20347c.get(i2).a(motionEvent, line);
        }
    }

    private void b(d dVar, MotionEvent motionEvent) {
        if (dVar != null && motionEvent != null) {
            dVar.b(motionEvent.getX() - this.f20359o, motionEvent.getY() - this.f20360p);
        }
    }

    private void c(MotionEvent motionEvent) {
        int i2 = AnonymousClass3.f20374a[this.f20345a.ordinal()];
        if (i2 == 2) {
            b(this.f20353i, motionEvent);
        } else if (i2 == 3) {
            a(this.f20353i, motionEvent);
        } else if (i2 == 4) {
            a(this.f20352h, motionEvent);
        } else if (i2 == 5) {
            b(this.f20353i, motionEvent);
            this.f20354j = e(motionEvent);
        }
    }

    private void d(MotionEvent motionEvent) {
        d dVar;
        int i2 = AnonymousClass3.f20374a[this.f20345a.ordinal()];
        if (i2 == 2) {
            d dVar2 = this.f20353i;
            if (dVar2 != null && !dVar2.g()) {
                this.f20353i.a((View) this);
            }
            if (this.f20355k == this.f20353i && Math.abs(this.f20359o - motionEvent.getX()) < 3.0f && Math.abs(this.f20360p - motionEvent.getY()) < 3.0f) {
                this.f20353i = null;
            }
            a aVar = this.B;
            if (aVar != null) {
                d dVar3 = this.f20353i;
                aVar.a(dVar3, this.f20346b.indexOf(dVar3));
            }
        } else if (i2 != 3) {
            if (!(i2 != 5 || (dVar = this.f20353i) == null || this.f20354j == null)) {
                Drawable b2 = dVar.b();
                this.f20353i.a(this.f20354j.b());
                this.f20354j.a(b2);
                this.f20353i.a((View) this, true);
                this.f20354j.a((View) this, true);
                this.f20353i = null;
                this.f20354j = null;
                this.f20355k = null;
                a aVar2 = this.B;
                if (aVar2 != null) {
                    aVar2.a((d) null, 0);
                }
            }
            this.f20352h = null;
            this.f20347c.clear();
        } else {
            d dVar4 = this.f20353i;
            if (dVar4 != null && !dVar4.g()) {
                if (this.f20353i.h()) {
                    this.f20353i.a((View) this);
                } else {
                    this.f20353i.a((View) this, false);
                }
            }
        }
        this.f20355k = this.f20353i;
        this.f20352h = null;
        this.f20347c.clear();
    }

    private d e(MotionEvent motionEvent) {
        for (d next : this.f20346b) {
            if (next.a(motionEvent.getX(), motionEvent.getY())) {
                return next;
            }
        }
        return null;
    }

    private void e() {
        this.f20349e.left = (float) getPaddingLeft();
        this.f20349e.top = (float) getPaddingTop();
        this.f20349e.right = (float) (getWidth() - getPaddingRight());
        this.f20349e.bottom = (float) (getHeight() - getPaddingBottom());
        c cVar = this.f20348d;
        if (cVar != null) {
            cVar.f();
            this.f20348d.a(this.f20349e);
            this.f20348d.a();
            this.f20348d.a(this.f20369y);
            this.f20348d.b(this.f20370z);
        }
    }

    private float f(MotionEvent motionEvent) {
        float x2 = motionEvent.getX(0) - motionEvent.getX(1);
        float y2 = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((double) ((x2 * x2) + (y2 * y2)));
    }

    private d f() {
        for (d next : this.f20346b) {
            if (next.a(this.f20359o, this.f20360p)) {
                return next;
            }
        }
        return null;
    }

    private Line g() {
        for (Line next : this.f20348d.d()) {
            if (next.a(this.f20359o, this.f20360p, 40.0f)) {
                return next;
            }
        }
        return null;
    }

    private List<d> h() {
        if (this.f20352h == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (d next : this.f20346b) {
            if (next.a(this.f20352h)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public void a() {
        d dVar = this.f20353i;
        if (dVar != null) {
            dVar.j();
            this.f20353i.i();
            invalidate();
        }
    }

    public void a(float f2) {
        d dVar = this.f20353i;
        if (dVar != null) {
            dVar.c(f2);
            this.f20353i.i();
            invalidate();
        }
    }

    public void a(Bitmap bitmap) {
        a((Drawable) new BitmapDrawable(getResources(), bitmap));
    }

    public void a(final Drawable drawable) {
        post(new Runnable() {
            public void run() {
                if (PuzzleView.this.f20353i != null) {
                    PuzzleView.this.f20353i.a(drawable);
                    PuzzleView.this.f20353i.a(b.b(PuzzleView.this.f20353i, 0.0f));
                    PuzzleView.this.postInvalidate();
                }
            }
        });
    }

    public void a(List<Bitmap> list) {
        for (Bitmap b2 : list) {
            b(b2);
        }
        postInvalidate();
    }

    public void b() {
        d dVar = this.f20353i;
        if (dVar != null) {
            dVar.k();
            this.f20353i.i();
            invalidate();
        }
    }

    public void b(Bitmap bitmap) {
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), bitmap);
        bitmapDrawable.setAntiAlias(true);
        bitmapDrawable.setFilterBitmap(true);
        b((Drawable) bitmapDrawable);
    }

    public void b(Drawable drawable) {
        int size = this.f20346b.size();
        if (size >= this.f20348d.b()) {
            Log.e("SlantPuzzleView", "addPiece: can not add more. the current puzzle layout can contains " + this.f20348d.b() + " puzzle piece.");
            return;
        }
        a a2 = this.f20348d.a(size);
        a2.b(this.f20369y);
        d dVar = new d(drawable, a2, new Matrix());
        dVar.a(b.a(a2, drawable, 0.0f));
        dVar.a(this.f20351g);
        this.f20346b.add(dVar);
        setPiecePadding(this.f20369y);
        setPieceRadian(this.f20370z);
        invalidate();
    }

    public void c() {
        this.f20352h = null;
        this.f20353i = null;
        this.f20354j = null;
        this.f20347c.clear();
        this.f20346b.clear();
    }

    public void d() {
        this.f20353i = null;
        this.f20352h = null;
        this.f20354j = null;
        this.f20355k = null;
        this.f20347c.clear();
    }

    public int getHandleBarColor() {
        return this.f20368x;
    }

    public int getLineColor() {
        return this.f20366v;
    }

    public int getLineSize() {
        return this.f20350f;
    }

    public float getPiecePadding() {
        return this.f20369y;
    }

    public float getPieceRadian() {
        return this.f20370z;
    }

    public c getPuzzleLayout() {
        return this.f20348d;
    }

    public int getSelectedLineColor() {
        return this.f20367w;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f20348d != null) {
            this.f20356l.setStrokeWidth((float) this.f20350f);
            this.f20357m.setStrokeWidth((float) this.f20350f);
            this.f20358n.setStrokeWidth((float) (this.f20350f * 3));
            int b2 = this.f20348d.b();
            int i2 = 0;
            while (i2 < b2 && i2 < this.f20346b.size()) {
                d dVar = this.f20346b.get(i2);
                if (!(dVar == this.f20353i && this.f20345a == ActionMode.SWAP) && this.f20346b.size() > i2) {
                    dVar.a(canvas);
                }
                i2++;
            }
            if (this.f20364t) {
                for (Line a2 : this.f20348d.c()) {
                    a(canvas, a2);
                }
            }
            if (this.f20363s) {
                for (Line a3 : this.f20348d.d()) {
                    a(canvas, a3);
                }
            }
            if (!(this.f20353i == null || this.f20345a == ActionMode.SWAP)) {
                a(canvas, this.f20353i);
            }
            if (this.f20353i != null && this.f20345a == ActionMode.SWAP) {
                this.f20353i.a(canvas, 128);
                d dVar2 = this.f20354j;
                if (dVar2 != null) {
                    a(canvas, dVar2);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        e();
        if (this.f20346b.size() != 0) {
            int size = this.f20346b.size();
            for (int i6 = 0; i6 < size; i6++) {
                d dVar = this.f20346b.get(i6);
                dVar.a(this.f20348d.a(i6));
                if (this.A) {
                    dVar.a(b.b(dVar, 0.0f));
                } else {
                    dVar.a((View) this, true);
                }
            }
        }
        invalidate();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004e, code lost:
        if (java.lang.Math.abs(r4.getY() - r3.f20360p) <= 10.0f) goto L_0x0076;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0054, code lost:
        if (r3.f20345a == com.huantansheng.easyphotos.models.puzzle.PuzzleView.ActionMode.f20379e) goto L_0x0076;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r4) {
        /*
            r3 = this;
            boolean r0 = r3.f20365u
            if (r0 != 0) goto L_0x0009
            boolean r4 = super.onTouchEvent(r4)
            return r4
        L_0x0009:
            int r0 = r4.getAction()
            r0 = r0 & 255(0xff, float:3.57E-43)
            r1 = 1
            if (r0 == 0) goto L_0x0064
            if (r0 == r1) goto L_0x0057
            r2 = 2
            if (r0 == r2) goto L_0x002d
            r2 = 3
            if (r0 == r2) goto L_0x0057
            r2 = 5
            if (r0 == r2) goto L_0x001e
            goto L_0x0076
        L_0x001e:
            float r0 = r3.f(r4)
            r3.f20361q = r0
            android.graphics.PointF r0 = r3.f20362r
            r3.a((android.view.MotionEvent) r4, (android.graphics.PointF) r0)
            r3.a((android.view.MotionEvent) r4)
            goto L_0x0076
        L_0x002d:
            r3.c(r4)
            float r0 = r4.getX()
            float r2 = r3.f20359o
            float r0 = r0 - r2
            float r0 = java.lang.Math.abs(r0)
            r2 = 1092616192(0x41200000, float:10.0)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 > 0) goto L_0x0050
            float r4 = r4.getY()
            float r0 = r3.f20360p
            float r4 = r4 - r0
            float r4 = java.lang.Math.abs(r4)
            int r4 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r4 <= 0) goto L_0x0076
        L_0x0050:
            com.huantansheng.easyphotos.models.puzzle.PuzzleView$ActionMode r4 = r3.f20345a
            com.huantansheng.easyphotos.models.puzzle.PuzzleView$ActionMode r0 = com.huantansheng.easyphotos.models.puzzle.PuzzleView.ActionMode.SWAP
            if (r4 == r0) goto L_0x0076
            goto L_0x005e
        L_0x0057:
            r3.d(r4)
            com.huantansheng.easyphotos.models.puzzle.PuzzleView$ActionMode r4 = com.huantansheng.easyphotos.models.puzzle.PuzzleView.ActionMode.NONE
            r3.f20345a = r4
        L_0x005e:
            java.lang.Runnable r4 = r3.C
            r3.removeCallbacks(r4)
            goto L_0x0076
        L_0x0064:
            float r0 = r4.getX()
            r3.f20359o = r0
            float r0 = r4.getY()
            r3.f20360p = r0
            r3.a((android.view.MotionEvent) r4)
            r3.b((android.view.MotionEvent) r4)
        L_0x0076:
            r3.invalidate()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huantansheng.easyphotos.models.puzzle.PuzzleView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setAnimateDuration(int i2) {
        this.f20351g = i2;
        for (d a2 : this.f20346b) {
            a2.a(i2);
        }
    }

    public void setBackgroundColor(int i2) {
        super.setBackgroundColor(i2);
        c cVar = this.f20348d;
        if (cVar != null) {
            cVar.b(i2);
        }
    }

    public void setHandleBarColor(int i2) {
        this.f20368x = i2;
        this.f20358n.setColor(i2);
        invalidate();
    }

    public void setLineColor(int i2) {
        this.f20366v = i2;
        this.f20356l.setColor(i2);
        invalidate();
    }

    public void setLineSize(int i2) {
        this.f20350f = i2;
        invalidate();
    }

    public void setNeedDrawLine(boolean z2) {
        this.f20363s = z2;
        this.f20353i = null;
        this.f20355k = null;
        invalidate();
    }

    public void setNeedDrawOuterLine(boolean z2) {
        this.f20364t = z2;
        invalidate();
    }

    public void setNeedResetPieceMatrix(boolean z2) {
        this.A = z2;
    }

    public void setOnPieceSelectedListener(a aVar) {
        this.B = aVar;
    }

    public void setPiecePadding(float f2) {
        this.f20369y = f2;
        c cVar = this.f20348d;
        if (cVar != null) {
            cVar.a(f2);
        }
        invalidate();
    }

    public void setPieceRadian(float f2) {
        this.f20370z = f2;
        c cVar = this.f20348d;
        if (cVar != null) {
            cVar.b(f2);
        }
        invalidate();
    }

    public void setPuzzleLayout(c cVar) {
        c();
        this.f20348d = cVar;
        cVar.a(this.f20349e);
        this.f20348d.a();
        invalidate();
    }

    public void setSelectedLineColor(int i2) {
        this.f20367w = i2;
        this.f20357m.setColor(i2);
        invalidate();
    }

    public void setTouchEnable(boolean z2) {
        this.f20365u = z2;
    }
}
