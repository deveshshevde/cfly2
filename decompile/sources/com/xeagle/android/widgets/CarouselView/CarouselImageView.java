package com.xeagle.android.widgets.CarouselView;

import android.content.Context;
import android.graphics.Camera;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Transformation;
import com.xeagle.android.widgets.CarouselView.CarouselAdapter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class CarouselImageView extends CarouselSpinner implements GestureDetector.OnGestureListener {
    private static final String F = "CarouselImageView";
    private CarouselAdapter.a G;
    /* access modifiers changed from: private */
    public int H;
    private Camera I;
    private Runnable J;
    private int K;
    private View L;
    private a M;
    private GestureDetector N;
    private int O;
    private boolean P;
    private int Q;
    private int R;
    private boolean S;
    private View T;
    private boolean U;
    private boolean V;
    /* access modifiers changed from: private */
    public boolean W;
    /* access modifiers changed from: private */

    /* renamed from: aa  reason: collision with root package name */
    public boolean f25498aa;

    /* renamed from: ab  reason: collision with root package name */
    private float f25499ab;

    /* renamed from: ac  reason: collision with root package name */
    private boolean f25500ac;

    private class a implements Runnable {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public e f25505b;

        /* renamed from: c  reason: collision with root package name */
        private float f25506c;

        public a() {
            this.f25505b = new e(CarouselImageView.this.getContext());
        }

        private void a() {
            CarouselImageView.this.removeCallbacks(this);
        }

        private void b(boolean z2) {
            synchronized (this) {
                this.f25505b.a(true);
            }
            if (z2) {
                CarouselImageView.this.n();
            }
        }

        public void a(float f2) {
            if (f2 != 0.0f) {
                a();
                this.f25506c = 0.0f;
                this.f25505b.a(f2);
                CarouselImageView.this.post(this);
            }
        }

        public void a(boolean z2) {
            CarouselImageView.this.removeCallbacks(this);
            b(z2);
        }

        public void b(float f2) {
            if (f2 != 0.0f) {
                a();
                this.f25506c = 0.0f;
                synchronized (this) {
                    this.f25505b.a(0.0f, -f2, CarouselImageView.this.H);
                }
                CarouselImageView.this.post(this);
            }
        }

        public void run() {
            boolean c2;
            float b2;
            if (CarouselImageView.this.getChildCount() == 0) {
                b(true);
                return;
            }
            boolean unused = CarouselImageView.this.W = false;
            synchronized (this) {
                e eVar = this.f25505b;
                c2 = eVar.c();
                b2 = eVar.b();
            }
            CarouselImageView.this.a(this.f25506c - b2);
            if (!c2 || CarouselImageView.this.W) {
                this.f25506c = 0.0f;
                b(true);
                return;
            }
            this.f25506c = b2;
            CarouselImageView.this.post(this);
        }
    }

    public CarouselImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    public CarouselImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CarouselImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.H = 900;
        this.I = new Camera();
        this.J = new Runnable() {
            public void run() {
                boolean unused = CarouselImageView.this.f25498aa = false;
                CarouselImageView.this.c();
            }
        };
        this.M = new a();
        this.Q = 12;
        this.R = 3;
        this.U = true;
        this.V = true;
        this.f25499ab = 0.2617994f;
        setChildrenDrawingOrderEnabled(true);
        GestureDetector gestureDetector = new GestureDetector(getContext(), this);
        this.N = gestureDetector;
        gestureDetector.setIsLongpressEnabled(true);
        setStaticTransformationsEnabled(true);
        this.H = 400;
        this.f25500ac = false;
        setNextSelectedPositionInt(0);
    }

    private int a(View view, boolean z2) {
        int measuredHeight = z2 ? getMeasuredHeight() : getHeight();
        int measuredHeight2 = z2 ? view.getMeasuredHeight() : view.getHeight();
        int i2 = this.O;
        if (i2 == 16) {
            return this.D.top + ((((measuredHeight - this.D.bottom) - this.D.top) - measuredHeight2) / 2);
        } else if (i2 == 48) {
            return this.D.top;
        } else {
            if (i2 != 80) {
                return 0;
            }
            return (measuredHeight - this.D.bottom) - measuredHeight2;
        }
    }

    private void a(int i2, float f2) {
        if (!this.f25477l) {
            CarouselItemImage carouselItemImage = (CarouselItemImage) this.E.a(i2);
            if (carouselItemImage != null) {
                b(carouselItemImage, carouselItemImage.getIndex(), f2);
                return;
            }
            CarouselItemImage carouselItemImage2 = (CarouselItemImage) this.f25523v.getView(i2, (View) null, this);
            b(carouselItemImage2, carouselItemImage2.getIndex(), f2);
            return;
        }
        CarouselItemImage carouselItemImage3 = (CarouselItemImage) this.f25523v.getView(i2, (View) null, this);
        b(carouselItemImage3, carouselItemImage3.getIndex(), f2);
    }

    private void a(CarouselItemImage carouselItemImage, int i2, float f2) {
        float f3 = (float) (i2 / 2);
        double d2 = (double) (f2 * 0.017453292f);
        float cos = f3 * (1.0f - ((float) Math.cos(d2)));
        double d3 = (double) cos;
        double sin = Math.sin((double) this.f25499ab);
        Double.isNaN(d3);
        carouselItemImage.setItemX(((-(((float) Math.sin(d2)) * f3)) + f3) - ((float) (carouselItemImage.getWidth() / 2)));
        carouselItemImage.setItemZ(cos);
        carouselItemImage.setItemY(((float) ((-getHeight()) / 2)) + ((float) (d3 * sin)));
    }

    private void b(CarouselItemImage carouselItemImage, int i2, float f2) {
        int i3;
        int i4;
        int i5;
        addViewInLayout(carouselItemImage, -1, generateDefaultLayoutParams());
        carouselItemImage.setSelected(i2 == this.f25480o);
        if (this.f25473h) {
            i3 = carouselItemImage.getMeasuredWidth();
            i5 = carouselItemImage.getMeasuredHeight();
            i4 = getMeasuredWidth();
        } else {
            i3 = carouselItemImage.getMeasuredWidth();
            i5 = carouselItemImage.getMeasuredHeight();
            i4 = getWidth();
        }
        carouselItemImage.setCurrentAngle(f2);
        carouselItemImage.measure(i3, i5);
        carouselItemImage.layout(0, a((View) carouselItemImage, true), i3, i5);
        a(carouselItemImage, i4, f2);
    }

    private boolean b(View view, int i2, long j2) {
        boolean z2;
        if (this.f25476k != null) {
            z2 = this.f25476k.a(this, this.L, this.K, j2);
        } else {
            z2 = false;
        }
        if (!z2) {
            this.G = new CarouselAdapter.a(view, i2, j2);
            z2 = super.showContextMenuForChild(this);
        }
        if (z2) {
            performHapticFeedback(0);
        }
        return z2;
    }

    private void d(View view) {
        if (view != null) {
            view.setPressed(true);
        }
        setPressed(true);
    }

    private int getCenterOfGallery() {
        return (((getWidth() - getPaddingLeft()) - getPaddingRight()) / 2) + getPaddingLeft();
    }

    /* access modifiers changed from: private */
    public void l() {
        int childCount = getChildCount();
        while (true) {
            childCount--;
            if (childCount >= 0) {
                getChildAt(childCount).setPressed(false);
            } else {
                setPressed(false);
                return;
            }
        }
    }

    private void m() {
        if (this.f25498aa) {
            this.f25498aa = false;
            super.c();
        }
        e();
        invalidate();
    }

    /* access modifiers changed from: private */
    public void n() {
        if (getChildCount() != 0 && this.T != null) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < getAdapter().getCount(); i2++) {
                arrayList.add((CarouselItemImage) getAdapter().getView(i2, (View) null, (ViewGroup) null));
            }
            Collections.sort(arrayList, new Comparator<CarouselItemImage>() {
                /* renamed from: a */
                public int compare(CarouselItemImage carouselItemImage, CarouselItemImage carouselItemImage2) {
                    int currentAngle = (int) carouselItemImage.getCurrentAngle();
                    if (currentAngle > 180) {
                        currentAngle = 360 - currentAngle;
                    }
                    int currentAngle2 = (int) carouselItemImage2.getCurrentAngle();
                    if (currentAngle2 > 180) {
                        currentAngle2 = 360 - currentAngle2;
                    }
                    return currentAngle - currentAngle2;
                }
            });
            float currentAngle = ((CarouselItemImage) arrayList.get(0)).getCurrentAngle();
            if (currentAngle > 180.0f) {
                currentAngle = -(360.0f - currentAngle);
            }
            if (currentAngle != 0.0f) {
                this.M.b(-currentAngle);
                return;
            }
            setSelectedPositionInt(((CarouselItemImage) arrayList.get(0)).getIndex());
            m();
        }
    }

    private void o() {
        View view = this.T;
        View childAt = getChildAt(this.f25480o - this.f25466a);
        this.T = childAt;
        if (childAt != null) {
            childAt.setSelected(true);
            childAt.setFocusable(true);
            if (hasFocus()) {
                childAt.requestFocus();
            }
            if (view != null) {
                view.setSelected(false);
                view.setFocusable(false);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(float f2) {
        if (getChildCount() != 0) {
            for (int i2 = 0; i2 < getAdapter().getCount(); i2++) {
                CarouselItemImage carouselItemImage = (CarouselItemImage) getAdapter().getView(i2, (View) null, (ViewGroup) null);
                float currentAngle = carouselItemImage.getCurrentAngle() + f2;
                while (currentAngle > 360.0f) {
                    currentAngle -= 360.0f;
                }
                while (currentAngle < 0.0f) {
                    currentAngle += 360.0f;
                }
                carouselItemImage.setCurrentAngle(currentAngle);
                a(carouselItemImage, getWidth(), currentAngle);
            }
            this.E.a();
            invalidate();
        }
    }

    /* access modifiers changed from: package-private */
    public void b(int i2, boolean z2) {
        if (this.f25477l) {
            d();
        }
        if (getCount() == 0) {
            j();
            return;
        }
        if (this.f25478m >= 0) {
            setSelectedPositionInt(this.f25478m);
        }
        k();
        detachAllViewsFromParent();
        float count = 360.0f / ((float) getAdapter().getCount());
        float f2 = ((float) this.f25480o) * count;
        for (int i3 = 0; i3 < getAdapter().getCount(); i3++) {
            float f3 = (((float) i3) * count) - f2;
            if (f3 < 0.0f) {
                f3 += 360.0f;
            }
            a(i3, f3);
        }
        this.E.a();
        invalidate();
        setNextSelectedPositionInt(this.f25480o);
        e();
        this.f25471f = false;
        o();
    }

    /* access modifiers changed from: package-private */
    public void c() {
        if (!this.f25498aa) {
            super.c();
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.LayoutParams;
    }

    /* access modifiers changed from: protected */
    public int computeHorizontalScrollExtent() {
        return 1;
    }

    /* access modifiers changed from: protected */
    public int computeHorizontalScrollOffset() {
        return this.f25480o;
    }

    /* access modifiers changed from: protected */
    public int computeHorizontalScrollRange() {
        return this.f25482q;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return keyEvent.dispatch(this, (KeyEvent.DispatcherState) null, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void dispatchSetPressed(boolean z2) {
        View view = this.T;
        if (view != null) {
            view.setPressed(z2);
        }
    }

    public void dispatchSetSelected(boolean z2) {
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ViewGroup.LayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i2, int i3) {
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < i2; i4++) {
            CarouselItemImage carouselItemImage = (CarouselItemImage) getAdapter().getView(i4, (View) null, (ViewGroup) null);
            if (i3 == 0) {
                carouselItemImage.setDrawn(false);
            }
            arrayList.add((CarouselItemImage) getAdapter().getView(i4, (View) null, (ViewGroup) null));
        }
        Collections.sort(arrayList);
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            CarouselItemImage carouselItemImage2 = (CarouselItemImage) it2.next();
            if (!carouselItemImage2.a()) {
                carouselItemImage2.setDrawn(true);
                return carouselItemImage2.getIndex();
            }
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public boolean getChildStaticTransformation(View view, Transformation transformation) {
        transformation.clear();
        transformation.setTransformationType(2);
        float width = ((float) getWidth()) / 2.0f;
        float height = ((float) getHeight()) / 2.0f;
        this.I.save();
        Matrix matrix = transformation.getMatrix();
        CarouselItemImage carouselItemImage = (CarouselItemImage) view;
        this.I.translate(carouselItemImage.getItemX(), carouselItemImage.getItemY(), carouselItemImage.getItemZ());
        this.I.getMatrix(matrix);
        matrix.preTranslate(-width, -height);
        matrix.postTranslate(width, height);
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        this.I.restore();
        Matrix matrix2 = new Matrix();
        matrix2.setValues(fArr);
        carouselItemImage.setCIMatrix(matrix2);
        view.invalidate();
        return true;
    }

    /* access modifiers changed from: protected */
    public ContextMenu.ContextMenuInfo getContextMenuInfo() {
        return this.G;
    }

    /* access modifiers changed from: package-private */
    public void h() {
        i();
    }

    /* access modifiers changed from: package-private */
    public void i() {
        if (this.M.f25505b.a()) {
            n();
        }
        l();
    }

    public boolean onDown(MotionEvent motionEvent) {
        this.M.a(false);
        int a2 = a((int) motionEvent.getX(), (int) motionEvent.getY());
        this.K = a2;
        if (a2 >= 0) {
            View childAt = getChildAt(a2 - this.f25466a);
            this.L = childAt;
            childAt.setPressed(true);
        }
        this.P = true;
        return true;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        if (!this.U) {
            removeCallbacks(this.J);
            if (!this.f25498aa) {
                this.f25498aa = true;
            }
        }
        this.M.a((float) ((int) f2));
        return true;
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z2, int i2, Rect rect) {
        View view;
        super.onFocusChanged(z2, i2, rect);
        if (z2 && (view = this.T) != null) {
            view.requestFocus(i2);
        }
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 != 66) {
            switch (i2) {
                case 21:
                    playSoundEffect(1);
                    return true;
                case 22:
                    playSoundEffect(3);
                    return true;
                case 23:
                    break;
            }
        }
        this.S = true;
        return super.onKeyDown(i2, keyEvent);
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (i2 != 23 && i2 != 66) {
            return super.onKeyUp(i2, keyEvent);
        }
        if (this.S && this.f25482q > 0) {
            d(this.T);
            postDelayed(new Runnable() {
                public void run() {
                    CarouselImageView.this.l();
                }
            }, (long) ViewConfiguration.getPressedStateDuration());
            a(getChildAt(this.f25480o - this.f25466a), this.f25480o, this.f25523v.getItemId(this.f25480o));
        }
        this.S = false;
        return true;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        this.f25473h = true;
        b(0, false);
        this.f25473h = false;
    }

    public void onLongPress(MotionEvent motionEvent) {
        if (this.K >= 0) {
            performHapticFeedback(0);
            b(this.L, this.K, a(this.K));
        }
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        getParent().requestDisallowInterceptTouchEvent(true);
        if (!this.U) {
            if (this.P) {
                if (!this.f25498aa) {
                    this.f25498aa = true;
                }
                postDelayed(this.J, 250);
            }
        } else if (this.f25498aa) {
            this.f25498aa = false;
        }
        a((float) ((int) f2));
        this.P = false;
        return true;
    }

    public void onShowPress(MotionEvent motionEvent) {
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        int i2 = this.K;
        if (i2 < 0) {
            return false;
        }
        if (!this.V && i2 != this.f25480o) {
            return true;
        }
        a(this.L, this.K, this.f25523v.getItemId(this.K));
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.N.onTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        if (action == 1) {
            i();
        } else if (action == 3) {
            h();
        }
        return onTouchEvent;
    }

    public void setAnimationDuration(int i2) {
        this.H = i2;
    }

    public void setCallbackDuringFling(boolean z2) {
        this.U = z2;
    }

    public void setCallbackOnUnselectedItemClick(boolean z2) {
        this.V = z2;
    }

    public void setGravity(int i2) {
        if (this.O != i2) {
            this.O = i2;
            requestLayout();
        }
    }

    /* access modifiers changed from: package-private */
    public void setSelectedPositionInt(int i2) {
        super.setSelectedPositionInt(i2);
        super.setNextSelectedPositionInt(i2);
        o();
    }

    public boolean showContextMenu() {
        if (!isPressed() || this.f25480o < 0) {
            return false;
        }
        return b(getChildAt(this.f25480o - this.f25466a), this.f25480o, this.f25481p);
    }

    public boolean showContextMenuForChild(View view) {
        int a2 = a(view);
        if (a2 < 0) {
            return false;
        }
        return b(view, a2, this.f25523v.getItemId(a2));
    }
}
