package com.xeagle.android.vjoystick.IWidgets.phasedSeekbar;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.xeagle.R;
import java.lang.reflect.Array;

public class PhasedSeekBar extends View {

    /* renamed from: a  reason: collision with root package name */
    protected static final int[] f24696a = new int[0];

    /* renamed from: b  reason: collision with root package name */
    protected static final int[] f24697b = {16842913};

    /* renamed from: c  reason: collision with root package name */
    protected static final int[] f24698c = {16842919};

    /* renamed from: d  reason: collision with root package name */
    protected int[] f24699d = f24697b;

    /* renamed from: e  reason: collision with root package name */
    protected boolean f24700e = true;

    /* renamed from: f  reason: collision with root package name */
    protected boolean f24701f = true;

    /* renamed from: g  reason: collision with root package name */
    protected boolean f24702g = false;

    /* renamed from: h  reason: collision with root package name */
    protected boolean f24703h = true;

    /* renamed from: i  reason: collision with root package name */
    protected boolean f24704i = true;

    /* renamed from: j  reason: collision with root package name */
    protected Drawable f24705j;

    /* renamed from: k  reason: collision with root package name */
    protected RectF f24706k;

    /* renamed from: l  reason: collision with root package name */
    protected int f24707l;

    /* renamed from: m  reason: collision with root package name */
    protected int f24708m;

    /* renamed from: n  reason: collision with root package name */
    protected int f24709n;

    /* renamed from: o  reason: collision with root package name */
    protected int f24710o;

    /* renamed from: p  reason: collision with root package name */
    protected int f24711p;

    /* renamed from: q  reason: collision with root package name */
    protected int f24712q;

    /* renamed from: r  reason: collision with root package name */
    protected int f24713r;

    /* renamed from: s  reason: collision with root package name */
    protected int f24714s;

    /* renamed from: t  reason: collision with root package name */
    protected int[][] f24715t;

    /* renamed from: u  reason: collision with root package name */
    protected int f24716u;

    /* renamed from: v  reason: collision with root package name */
    protected int f24717v;

    /* renamed from: w  reason: collision with root package name */
    protected a f24718w;

    /* renamed from: x  reason: collision with root package name */
    protected c f24719x;

    /* renamed from: y  reason: collision with root package name */
    protected b f24720y;

    /* renamed from: z  reason: collision with root package name */
    protected boolean f24721z = true;

    public PhasedSeekBar(Context context) {
        super(context);
        a((AttributeSet) null, 0);
    }

    public PhasedSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet, 0);
    }

    public PhasedSeekBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(attributeSet, i2);
    }

    /* access modifiers changed from: protected */
    public int a(MotionEvent motionEvent) {
        return Math.min(Math.max((int) motionEvent.getX(), this.f24711p), getWidth() - this.f24711p);
    }

    /* access modifiers changed from: protected */
    public void a() {
        Rect rect = new Rect((int) this.f24706k.left, (int) this.f24706k.top, (int) (((float) getWidth()) - this.f24706k.right), (int) (((float) getHeight()) - this.f24706k.bottom));
        Drawable drawable = this.f24705j;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        int width = getWidth() / 2;
        this.f24709n = width;
        this.f24707l = width;
        int height = (getHeight() / 5) * 4;
        this.f24710o = height;
        this.f24708m = height;
        b bVar = this.f24720y;
        if (bVar != null) {
            bVar.a(this.f24707l, height, this.f24716u);
        }
        int count = getCount();
        int width2 = rect.width() / count;
        int i2 = width2 / 2;
        int height2 = rect.height() / count;
        int i3 = height2 / 2;
        int[] iArr = new int[2];
        iArr[1] = 2;
        iArr[0] = count;
        this.f24715t = (int[][]) Array.newInstance(int.class, iArr);
        int i4 = 0;
        int i5 = 1;
        while (i4 < count) {
            this.f24715t[i4][0] = this.f24700e ? ((width2 * i5) - i2) + rect.left : this.f24709n;
            this.f24715t[i4][1] = !this.f24700e ? ((height2 * i5) - i3) + rect.top : this.f24710o;
            i4++;
            i5++;
        }
    }

    /* access modifiers changed from: protected */
    public void a(AttributeSet attributeSet, int i2) {
        this.f24706k = new RectF();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.PhasedSeekBar, i2, 0);
            setDrawOnOff(obtainStyledAttributes.getBoolean(7, this.f24703h));
            setFixPoint(obtainStyledAttributes.getBoolean(8, this.f24704i));
            setModeIsHorizontal(obtainStyledAttributes.getInt(11, 0) != 2);
            this.f24706k.left = obtainStyledAttributes.getDimension(4, 0.0f);
            this.f24706k.top = obtainStyledAttributes.getDimension(6, 0.0f);
            this.f24706k.right = obtainStyledAttributes.getDimension(5, 0.0f);
            this.f24706k.bottom = obtainStyledAttributes.getDimension(3, 0.0f);
            this.f24711p = (int) (obtainStyledAttributes.getDimension(10, 0.0f) / 2.0f);
            this.f24712q = (int) (obtainStyledAttributes.getDimension(10, 0.0f) / 2.0f);
            this.f24713r = (int) (obtainStyledAttributes.getDimension(1, 0.0f) / 2.0f);
            this.f24714s = (int) (obtainStyledAttributes.getDimension(0, 0.0f) / 2.0f);
            this.f24705j = obtainStyledAttributes.getDrawable(2);
            obtainStyledAttributes.recycle();
        }
    }

    /* access modifiers changed from: protected */
    public int b(MotionEvent motionEvent) {
        return Math.min(Math.max((int) motionEvent.getY(), this.f24712q), getHeight() - this.f24712q);
    }

    /* access modifiers changed from: protected */
    public int c(MotionEvent motionEvent) {
        int min = Math.min(Math.max((int) motionEvent.getY(), 0), getHeight());
        setRelateY(min);
        return min;
    }

    /* access modifiers changed from: protected */
    public int getCount() {
        if (isInEditMode()) {
            return 3;
        }
        return this.f24718w.a();
    }

    public int getCurrentItem() {
        return this.f24716u;
    }

    public int getCurrentX() {
        return this.f24707l;
    }

    public int getCurrentY() {
        return this.f24708m;
    }

    public boolean isEnabled() {
        return this.f24721z;
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setFirstDraw(true);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        StateListDrawable stateListDrawable;
        StringBuilder sb;
        int i2;
        float f2;
        String str;
        int i3;
        int i4;
        int i5;
        super.onDraw(canvas);
        if (this.f24701f) {
            a();
        }
        Drawable drawable = this.f24705j;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        if (!isInEditMode()) {
            int count = getCount();
            if (!this.f24702g) {
                int i6 = SubsamplingScaleImageView.TILE_SIZE_AUTO;
                int i7 = 0;
                for (int i8 = 0; i8 < count; i8++) {
                    if (this.f24700e) {
                        i5 = this.f24715t[i8][0];
                        i4 = this.f24707l;
                    } else {
                        i5 = this.f24715t[i8][1];
                        i4 = this.f24708m;
                    }
                    int abs = Math.abs(i5 - i4);
                    if (i6 > abs) {
                        i7 = i8;
                        i6 = abs;
                    }
                }
                setCurrentItem(i7);
                stateListDrawable = this.f24718w.a(i7);
            } else {
                this.f24702g = false;
                int[][] iArr = this.f24715t;
                int i9 = this.f24716u;
                this.f24707l = iArr[i9][0];
                this.f24708m = iArr[i9][1];
                stateListDrawable = this.f24718w.a(i9);
            }
            stateListDrawable.setState(this.f24699d);
            Drawable current = stateListDrawable.getCurrent();
            for (int i10 = 0; i10 < count; i10++) {
                if (this.f24703h || i10 != this.f24716u) {
                    StateListDrawable a2 = this.f24718w.a(i10);
                    a2.setState(f24696a);
                    Drawable current2 = a2.getCurrent();
                    int[][] iArr2 = this.f24715t;
                    int i11 = iArr2[i10][0];
                    int i12 = this.f24711p;
                    int i13 = iArr2[i10][1];
                    int i14 = this.f24712q;
                    current2.setBounds(i11 - i12, i13 - i14, iArr2[i10][0] + i12, iArr2[i10][1] + i14);
                    current2.draw(canvas);
                }
            }
            int i15 = this.f24707l;
            int i16 = this.f24711p;
            int i17 = this.f24708m;
            int i18 = this.f24712q;
            current.setBounds(i15 - (i16 * 2), i17 - i18, i15 - (i16 / 2), i17 + i18);
            current.draw(canvas);
            Paint paint = new Paint();
            paint.setStrokeWidth(1.0f);
            paint.setColor(-1);
            paint.setAntiAlias(false);
            paint.setTextSize(18.0f);
            for (int i19 = 0; i19 < 8; i19++) {
                if (i19 <= 2) {
                    sb.append(i19 * 10);
                    sb.append("");
                    str = sb.toString();
                    f2 = (float) (this.f24707l + this.f24711p);
                    i2 = (getHeight() - ((getHeight() * i19) / 8)) - (getHeight() / 16);
                    i3 = this.f24712q / 2;
                } else {
                    sb = new StringBuilder();
                    sb.append(i19 * 10);
                    sb.append("");
                    str = sb.toString();
                    f2 = (float) (this.f24707l + this.f24711p);
                    i2 = (getHeight() - ((getHeight() * i19) / 8)) - (getHeight() / 16);
                    i3 = this.f24712q;
                }
                canvas.drawText(str, f2, (float) (i2 + i3), paint);
            }
            setFirstDraw(false);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z2 = false;
        if (!isEnabled()) {
            return false;
        }
        this.f24707l = this.f24700e ? a(motionEvent) : this.f24709n;
        this.f24708m = !this.f24700e ? b(motionEvent) : this.f24710o;
        int action = motionEvent.getAction();
        if (this.f24704i && action == 1) {
            z2 = true;
        }
        this.f24702g = z2;
        this.f24699d = (action == 1 || action == 3) ? f24697b : f24698c;
        invalidate();
        b bVar = this.f24720y;
        if (bVar != null) {
            bVar.a(this.f24707l, c(motionEvent), this.f24716u);
        }
        if (action == 0 || action == 1) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setAdapter(a aVar) {
        this.f24718w = aVar;
    }

    /* access modifiers changed from: protected */
    public void setCurrentItem(int i2) {
        c cVar;
        if (!(this.f24716u == i2 || (cVar = this.f24719x) == null)) {
            cVar.a(i2);
        }
        this.f24716u = i2;
    }

    public void setDrawOnOff(boolean z2) {
        this.f24703h = z2;
    }

    public void setEnabled(boolean z2) {
        this.f24721z = z2;
    }

    public void setFirstDraw(boolean z2) {
        this.f24701f = z2;
    }

    public void setFixPoint(boolean z2) {
        this.f24704i = z2;
    }

    public void setInteractionListener(b bVar) {
        this.f24720y = bVar;
    }

    public void setListener(c cVar) {
        this.f24719x = cVar;
    }

    public void setModeIsHorizontal(boolean z2) {
        this.f24700e = z2;
    }

    public void setPosition(int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        if (i2 >= this.f24718w.a()) {
            i2 = this.f24718w.a() - 1;
        }
        this.f24716u = i2;
        this.f24702g = true;
        invalidate();
    }

    public void setRelateY(int i2) {
        this.f24717v = i2;
    }
}
